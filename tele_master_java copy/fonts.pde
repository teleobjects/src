  class Font {
  // String file;

  String[] fontData;
  ArrayList<Integer> fontMap;
  ArrayList<String> charBitMaps;
  int[][] fontGlyphs;
  int first;
  int last;
  int yAdvance;


  boolean monoFontMap[][][];
  int w;
  int h;
}


class ProportionalFont extends Font {
  ProportionalFont(String thisFile) {
    fontData = loadStrings("fonts/"+thisFile);
    fontMap = new ArrayList<Integer>();
    int lastLine = 0;
    for (int i = 0; i < fontData.length; i++) {
      String thisLine = removeSpaces(fontData[i]);
      lastLine ++;
      if (thisLine.length() > 2 && thisLine.substring(0, 2).equals("0x")) {
        String[] items = splitTokens(thisLine, ",");
        for (int j = 0; j<items.length; j++) {
          String thisVal = removeSpaces(items[j]).substring(0, 4);
          if (thisVal.substring(0, 2).equals("0x")) {
            fontMap.add(unhex(thisVal.substring(2, 4)));
          }
        }
      }
      if (thisLine.contains("};")) break;
    }
    int charNum = 0;
    for (int i = lastLine; i < fontData.length; i++) {
      String thisLine = removeSpaces(fontData[i]);
      if (thisLine.length() > 2 && thisLine.charAt(0) == '{') {
        charNum ++;
      }
      if (thisLine.contains("};")) break;
    }
    fontGlyphs = new int[charNum][6];
    int currentChar = 0;
    for (int i = lastLine; i < fontData.length; i++) {
      String thisLine = removeSpaces(fontData[i]);
      lastLine ++;
      if (thisLine.length() > 2 && thisLine.charAt(0) == '{') {
        String items[] = splitTokens(thisLine.substring(1, thisLine.length()));
        for (int j = 0; j < 6; j++ ) {
          fontGlyphs[currentChar][j] = parseInt(filterNumber(items[j]));
        }
        currentChar ++;
      }
      if (thisLine.contains("};")) break;
    }
    for (int i = lastLine; i < fontData.length; i++) {
      String thisLine = removeSpaces(fontData[i]);
      String[] items = splitTokens(thisLine, ",");
      if (items.length == 3) {
        first = unhex(removeSpaces(items[0]).substring(2, 4));
        last = unhex(removeSpaces(items[1]).substring(2, 4));
        yAdvance = parseInt(removeSpaces(items[2].substring(0, items[2].length()-3)));
      }
    }
  }

  void display() {
    background(255);
    int px = 4;
    int cx = 0;
    int cy = yAdvance*px;
    int marginx = 1;
    int marginy = 0;
    rectMode(CORNER);
    textSize(8);
    textAlign(LEFT, TOP);
    for (int i=0; i<fontGlyphs.length; i++) {
      int offset = fontGlyphs[i][0];
      int w = fontGlyphs[i][1];
      int h = fontGlyphs[i][2];
      int xAdvance = fontGlyphs[i][3];
      int offsetx = fontGlyphs[i][4];
      int offsety = fontGlyphs[i][5];
      fill(255, 0, 0);
      stroke(255, 0, 0, 50);
      noFill();
      int tempy = (offsety*px);
      text(i+first, cx, cy+tempy+(h*px));
      rect(cx, cy+tempy, xAdvance * px, h*px);
      // int totalPixels = w * h;
      // int bytes = totalPixels/8;
      // if (totalPixels > bytes*8) bytes ++;
      // for (int thisByte = 0; thisByte < bytes; thisByte++) {
      // 	int bits = fontMap.get(offset+thisByte);
      // 	text(offset+thisByte+" "+bits, cx, cy + tempy + (thisByte * px));
      // }
      int currentBit = 8;
      int currentByte = 0;
      int tempX = offsetx * px;
      int bits = 0;
      for (int row = 0; row < h; row++) {
        for (int column = 0; column < w; column++) {
          if (currentBit == 8) {
            bits = fontMap.get(offset + currentByte);
            currentByte ++;
            currentBit = 0;
          }
          if ((bits & (128 >> currentBit)) != 0) {
            fill(50);
            stroke(255);
            rect(cx + tempX + (column * px), cy + tempy + (row * px), px, px);
          }
          currentBit++;
        }
      }

      cx += (xAdvance+marginx) * px;
      if (cx > width - ((w + xAdvance) * px)) {
        cx = 0;
        cy += px * (yAdvance+marginy);
      }
    }
  }
}

class MonoFont extends Font {

  MonoFont (String thisFile) {
    monoFontMap = new boolean[256][w][h];
    fontData = loadStrings("fonts/"+thisFile);
    int currentChar = 0;
    for (int i = 0; i < fontData.length; i++) {
      String[] items = splitTokens(fontData[i], ",");
      if (items.length >= w) {
        for (int column = 0; column < w; column ++) {
          int thisRow = unhex(removeSpaces(items[column]).substring(2, 4));
          for (int row = 0; row < h; row++) {
            monoFontMap[currentChar][column][row] = (thisRow & (1 << row)) != 0;
          }
        }
        currentChar ++;
      }
    }
  }

  void display() {
    background(255);
    int cx = 0;
    int cy = 8;
    int px = 7;
    int offsetx = 3;
    int offsety = 3;
    rectMode(CORNER);
    textSize(8);
    textAlign(LEFT, TOP);
    for (int i=0; i<monoFontMap.length; i++) {
      fill(255, 0, 0);
      text(i, cx, cy+(h*px));
      stroke(255, 0, 0, 50);
      noFill();
      rect(cx, cy, w*px, h*px);
      for (int j=0; j<w; j++) {
        for (byte k=0; k<h; k++) {
          if (monoFontMap[i][j][k]) {
            fill(50);
            stroke(255);
            rect(cx, cy, px, px);
          }
          cy += px;
        }
        cx += px;
        cy -= px*h;
      }
      cx += offsetx*px;
      if (cx > width-(w*px)) {
        cx = 0;
        cy += px*(h+offsety);
      }
    }
  }
}