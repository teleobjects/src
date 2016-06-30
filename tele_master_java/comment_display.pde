class CommentDisplay extends Display {
  PShape outline;
  float r = 7.3;
  float offsetV = 50;
  int disW = 64;
  int disH = 8;
  boolean busy;
  boolean[][][] dis = new boolean[2][64][8];

  MonoFont standardFont = new MonoFont("glcdfont.c");
  ProportionalFont tomFont = new ProportionalFont("TomThumb.h");
  ProportionalFont freeSans9 = new ProportionalFont("FreeSansBold9pt7b.h");
  ProportionalFont freeSans12 = new ProportionalFont("FreeSansBold12pt7b.h");
  ProportionalFont freeSans18 = new ProportionalFont("FreeSansBold18pt7b.h");
  // Font freeSans24 = new Font("FreeSansBold24pt7b.h");

  Font[] fonts = {standardFont, tomFont, freeSans9, freeSans12, freeSans18};

  String data;
  int mode;
  int tack, teck, tick, tock, tuck;
  long lastTick;
  int cursorLine, cursorX, cursorY;

  int currentFont = 1;

  CommentDisplay() {
    outline = loadShape("shp/comment.svg");
    outline.disableStyle();
  }

  void display() {
    // standardFont.display();
    // tomFont.display();
    // freeSans18.display();
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
        else {
          fill(redColor, 10);
          ellipse(column * r, row * r, r-1, r-1);
        }
      }
    }
  }

  void update() {
    switch (mode) {
      case TICKER:  
      if (data.length() > 0) {    
        if (millis() - lastTick > tick) {
          lastTick = millis();
          cursorX += drawChar(data.charAt(0), tack, cursorX, cursorY);
          data = data.substring(1,data.length());
          cursorLine = tack;
        } 
      }
      else {
        busy = false;
      }      
      if (cursorX < disW && cursorX >= 0) drawChar(millis() % 500 < 250 ? ' ' : '_', cursorLine, cursorX, cursorY);
      break;
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
    busy = true;
    lastTick = millis();
    switch (mode) {
      case TICKER:
      clearDisplay(tack);
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
    } 
    else  {
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
          if (xx > 0 && xx < disW && yy > 0 && yy < disH) {
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

  void drawString(String thisString, int thisLine, int x, int y) {
    if (currentFont == 0) {
      for (int i = 0; i < thisString.length(); i++) {
        x += drawChar(thisString.charAt(i), thisLine, x, y);
      }
    } 
    else {
      for (int i = 0; i < thisString.length(); i++) {
        x += drawChar(thisString.charAt(i), thisLine, x, y);
      }
    }
  }

  void clearDisplay(int thisLine) {
    if (thisLine == 2) {
      dis = new boolean[2][64][8];
    } 
    else {
      for (int column = 0; column < disW; column++) {
        for (int row = 0; row < disH; row++) {
          dis[thisLine][column][row] = false;
        }
      }
    }    
    cursorX = 0;
    cursorY = 0;
  }
}