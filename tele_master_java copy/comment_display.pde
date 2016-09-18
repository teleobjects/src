class CommentDisplay extends Display {
  PShape outline;
  float r = 7.3;
  float offsetV = 50;
  int disW = 64;
  int disH = 8;

  boolean[][][] dis = new boolean[2][64][8];

  MonoFont standardFont = new MonoFont("glcdfont.c");
  ProportionalFont tomFont = new ProportionalFont("TomThumb.h");
  ProportionalFont freeSans9 = new ProportionalFont("FreeSansBold9pt7b.h");
  ProportionalFont freeSans12 = new ProportionalFont("FreeSansBold12pt7b.h");
  ProportionalFont freeSans18 = new ProportionalFont("FreeSansBold18pt7b.h");
  // Font freeSans24 = new Font("FreeSansBold24pt7b.h");

  Font[] fonts = {standardFont, tomFont, freeSans9, freeSans12, freeSans18};
  int currentFont = 1;

  String data;
  int mode;
  int tack, teck, tick, tock, tuck;
  long lastTick;
  boolean cursorOn;
  int cursorLine, cursorX, cursorY;

  int tcL, tcX, tcY;

  int breakX;

  CommentDisplay() {
    outline = loadShape("shp/comment.svg");
    outline.disableStyle();
  }

  void display() {
    update();
    strokeWeight(thickStroke);
    stroke(0);
    fill(255);
    shape(outline, 0, 0);
    translate(-232, - 45);
    translate(0, -offsetV);
    displayLine(0);
    translate(0, offsetV*2);
    displayLine(1);
  }

  void displayLine(int thisLine) {
    noStroke();
    for (int column = 0; column < disW; column++) {
      for (int row = 0; row < disH; row++) {
        if (dis[thisLine][column][row]) {
          fill(redColor);
          ellipse(column * r, row * r, r-1, r-1);
        } 
        //else {
        //  fill(redColor, 10);
        //  ellipse(column * r, row * r, r-1, r-1);
        //}
      }
    }
  }

  void update() {
    if (cursorOn && tcX < disW && tcX >= 0) drawChar(' ', tcL, tcX, tcY); 

    switch (mode) {
    case TICKER:  
      if (data.length() > 0) {    
        if (millis() - lastTick > tick) {
          if (breakX == -1) {  
            // if (data.charAt(0) == ' ') data = data.substring(1,data.length());
            // if (cursorLine == 0) {

            // }
            clearDisplay(cursorLine);
            cursorX = 0;  
            breakX = disW;
            if (stringWidth(data) > disW ) {
              int lastSpace;    
              int tempX = data.length();
              while (breakX >= disW) {
                lastSpace = findLastChar(data.substring(0, tempX), ' ');
                if (lastSpace != 0) {      
                  breakX = stringWidth(data.substring(0, lastSpace));
                  tempX = lastSpace;
                } else {
                  break;
                }
              }
            }
          }
          lastTick = millis();
          cursorX += drawChar(data.charAt(0), cursorLine, cursorX, cursorY);
          tcX = cursorX;
          tcY = cursorY;
          tcL = cursorLine;
          // if (cursorX > breakX) {
          //   cursorLine ++;
          //   breakX = -1;
          //   if (data.charAt(0) == ' ') {
          //     tcX -= charWidth(' ');
          //   }
          //   if (cursorLine == 2) {
          //     cursorLine = 0;
          //     lastTick = millis() + tock * 100;                   
          //   }  
          // }                
          data = data.substring(1, data.length());
        }
      } else {
        busy = false;
      }      
      break;
    }
    if (cursorOn) {
      if (cursorX < disW && cursorX >= 0) drawChar(millis() % 500 < 250 ? ' ' : '_', tcL, tcX, tcY);
    }
  }

  void printString(String thisString, int thisMode, int thisTack, int thisTeck, int thisTick, int thisTock, int thisTuck) {
    data = thisString;
    if (thisMode != PING) {
      mode = thisMode;
      tack = thisTack;
      teck = thisTeck;
      tick = thisTick;
      tock = thisTock;
      tuck = thisTuck;
    }
    busy = false;
    cursorOn = false;

    switch (mode) {
    case BLANK:
      clearDisplay(tack);
      break;

    case TICKER:
      if (tack > 1) tack = 0;
      clearDisplay(tack);
      cursorLine = tack;
      cursorOn = true;
      breakX = -1;
      busy = true;
      break;

    case INSTANT:
      if (tack == 2) tack = 0;
      clearDisplay(tack);
      drawString(data, tack, cursorX, cursorY);    
      break;

    case CENTERED:
      if (tack == 2) tack = 0;
      clearDisplay(tack);
      int w = stringWidth(data);
      if (w < disW) {
        cursorX = (disW - w) / 2;
      }
      drawString(data, tack, cursorX, cursorY);    
      break;
    }
  }

  int drawChar(char thisChar, int thisLine, int x, int y) {
    if (currentFont == 0) {
      for (int row = 0; row < standardFont.h; row++) {
        for (int column = 0; column < standardFont.w; column++) {
          if (x + column < disW && y + row < disH) {
            dis[thisLine][x+column][y+row] = standardFont.monoFontMap[(int)thisChar][column][row];
          }
        }
      }
      return standardFont.w + 1;
    } else {
      if (thisChar > fonts[currentFont].last) return 0;
      int glyphNum = (int)thisChar - fonts[currentFont].first;
      int offset = fonts[currentFont].fontGlyphs[glyphNum][0];
      int w = fonts[currentFont].fontGlyphs[glyphNum][1];
      int h = fonts[currentFont].fontGlyphs[glyphNum][2];
      int xAdvance = fonts[currentFont].fontGlyphs[glyphNum][3];
      int offsetx = fonts[currentFont].fontGlyphs[glyphNum][4];
      int offsety = fonts[currentFont].fontGlyphs[glyphNum][5];
      int currentBit = 8;
      int currentByte = 0;
      int bits = 0;
      for (int row = 0; row < disH; row++) {
        for (int column = 0; column <= xAdvance; column++) {
          int xx = x + column;
          int yy = y + row;
          if (xx >= 0 && xx < disW && yy >= 0 && yy < disH) {
            dis[thisLine][xx][yy] = false;
          }
        }
      }
      for (int row = 0; row < h; row++) {
        for (int column = 0; column < w; column++) {
          if (currentBit == 8) {
            bits = fonts[currentFont].fontMap.get(offset + currentByte);
            currentByte ++;
            currentBit = 0;
          }
          int xx = x + offsetx + column;
          int yy = y + disH + offsety + row - 2;
          if (xx >= 0 && xx < disW && yy >= 0 && yy < disH) {
            if ((bits & (128 >> currentBit)) != 0) {
              dis[thisLine][xx][yy] = true;
            }
          }
          currentBit++;
        }
      }
      return xAdvance;
    }
  }

  int charWidth(char thisChar) {


    if (currentFont == 0) {
      return standardFont.w;
    } else {
      if (thisChar > fonts[currentFont].last) return 0;
      int glyphNum = (int)thisChar - fonts[currentFont].first;
      int xAdvance = fonts[currentFont].fontGlyphs[glyphNum][3];
      return xAdvance;
    }
  }

  int stringWidth(String thisString) {
    int w = 0;
    for (int i = 0; i < thisString.length(); i++) {
      w += charWidth(thisString.charAt(i));
    }
    return w;
  }

  int drawString(String thisString, int thisLine, int x, int y) {
    if (currentFont == 0) {
      for (int i = 0; i < thisString.length(); i++) {
        x += drawChar(thisString.charAt(i), thisLine, x, y);
      }
    } else {
      for (int i = 0; i < thisString.length(); i++) {
        x += drawChar(thisString.charAt(i), thisLine, x, y);
      }
    }
    return x;
  }

  void clearDisplay(int thisLine) {
    if (thisLine == 2) {
      dis = new boolean[2][64][8];
    } else {
      for (int column = 0; column < disW; column++) {
        for (int row = 0; row < disH; row++) {
          dis[thisLine][column][row] = false;
        }
      }
    }    
    cursorX = 0;
    cursorY = 0;
  }



  String invalid  = "`´âáäÁÂÄéêëÉÊËíîïÍÎÏóôöÓÔÖúûüÚÛÜñÑ";
  String subs     = "'''aaAAAeeeEEEiiiIIIoooOOOuuuUUUnN   ";
  String valid = " !@#$%^&*()-+=[|]}{;':<>,.?/~`°'_01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"+char(34)+char(135);

  String cleanUp(String str) {
    String res = "";
    for (int i=0; i<str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '&') {
        if (str.charAt(i+1) == '#') {
          ch = 39;
          i = i+6;
        } else {
          if (str.length() > i+5) {
            if (str.charAt(i+5) == ';') {
              ch = 39;
              i = i+5;
            }
          }
        }
      }
      if (invalid.indexOf(ch) != -1) {
        ch = subs.charAt(invalid.indexOf(ch));
      }
      if (valid.indexOf(ch) != -1) {
        res +=  ch;
      } else {
        res += char(39);//'-';
      }
    }
    return res;
  }
}