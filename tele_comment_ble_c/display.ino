void initDisplay() {
  matrix[0].begin(0x70, 4);
  matrix[1].begin(0x71, 4);
  matrix[2].begin(0x72, 4);
  matrix[3].begin(0x73, 4);
  matrix[4].begin(0x70, 3);
  matrix[5].begin(0x71, 3);
  matrix[6].begin(0x72, 3);
  matrix[7].begin(0x73, 3);
  matrix[8].begin(0x70, 2);
  matrix[9].begin(0x71, 2);
  matrix[10].begin(0x72, 2);
  matrix[11].begin(0x73, 2);
  matrix[12].begin(0x70, 1);
  matrix[13].begin(0x71, 1);
  matrix[14].begin(0x72, 1);
  matrix[15].begin(0x73, 1);
  //  clearDisplay();
  font = 1;
  fontSize = 1;
  brightness = 1;
  for (byte i = 0; i < NUM; i++) {
    matrix[i].clear();
    matrix[i].setBrightness(1);
    matrix[i].setRotation(2);
    matrix[i].setFont(&TomThumb);
    //    matrix[i].invertDisplay(true);
    //    matrix[i].setTextColor(LED_OFF);
    matrix[i].setTextSize(fontSize);
    matrix[i].setTextWrap(false);
    matrix[i].writeDisplay();
  }
}

void setBrightness(byte b) {
  brightness = b;
  for (byte i = 0; i < NUM; i++) {
    matrix[i].setBrightness(brightness);
  }
}

void setTextColor(boolean b) {
  for (byte i = 0; i < NUM; i++) {
    matrix[i].setTextColor(b ? LED_ON : LED_OFF);
  }
}

void setTextSize(byte f) {
  fontSize = f;
  for (byte i = 0; i < NUM; i++) {
    matrix[i].setTextSize(f);
  }
}

void setTextFont(byte f) {
  font = f;
  switch (f) {
    case 0:
      for (byte i = 0; i < NUM; i++) {
        matrix[i].setFont();
      }
      break;
    case 1:
      for (byte i = 0; i < NUM; i++) {
        matrix[i].setFont(&TomThumb);
      }
      break;
    case 2:
      for (byte i = 0; i < NUM; i++) {
        matrix[i].setFont(&FreeSans9pt7b);
      }
      break;

    case 3:
      for (byte i = 0; i < NUM; i++) {
        matrix[i].setFont(&FreeSans12pt7b);
      }
      break;

    case 4:
      for (byte i = 0; i < NUM; i++) {
        matrix[i].setFont(&FreeSansBold9pt7b);
      }
      break;

    case 5:
      for (byte i = 0; i < NUM; i++) {
        matrix[i].setFont(&FreeSansBold12pt7b);
      }
      break;

    case 6:
      for (byte i = 0; i < NUM; i++) {
        matrix[i].setFont(&FreeSansBold18pt7b);
      }
      break;
  }
}

void updateDisplay() {
  updateDisplay(0);
  updateDisplay(1);
}

void updateDisplay(byte row) {
  byte m = row > 0 ? 8 : 0;
  for (byte i = 0; i < 8; i++) {
    matrix[m + i].writeDisplay();
  }
}

void clearDisplay() {
  clearDisplay(0);
  clearDisplay(1);
}

void clearDisplay(byte row) {
  byte m = row > 0 ? 8 : 0;
  for (byte i = 0; i < 8; i++) {
    matrix[m + i].clear();
  }
}

void printPixel(int m, int x, int y) {
  matrix[m].drawPixel(x, y, LED_ON);
  //  matrix[m].writeDisplay();
}

void fill(byte row) {
  byte m = row > 0 ? 8 : 0;
  for (byte i = 0; i < 8; i++) {
    matrix[m + i].fillScreen(LED_ON);
  }
}

void printDouble(String str, int x, int y0, int y1) {
  printDisplay(str, WIDTH, 0, x, y0);
  printDisplay(str, WIDTH, 1, x, y1);
}

void printCentered(String str, int row, int y) {
  while (textWidth(str, row) > WIDTH) {
    str = str.substring(0, str.length() - 1);
  }
  printDisplay(str, textWidth(str, row), row, (WIDTH - textWidth(str, row)) / 2, y);
}

void printChar(char c, int w, byte row, int x, int y) {
  printDisplay(String(c), w, row, x, y);
}

void printDisplay(String str, int w, byte row, int x, int y) {
  if (font > 0) y += 6;
  byte m = row > 0 ? 8 : 0;
  for (byte i = 0; i < 8 && i * 8 < x + w; i++) {
    if ((i * 8) + 8 > x) {
      matrix[m + i].setCursor((-i * 8) + x, y);
      matrix[m + i].print(str);
    }
  }
}

void printVerticalLine(int x, int c) {
  int mx = int(x / 8);
  matrix[8 + mx].drawLine(x - (mx * 8), 0, x - (mx * 8), 7, c);
  matrix[mx].drawLine(x - mx * 8, 0, x - mx * 8, 7, c);
}

void printLine(int row, int x0, int y0, int x1, int y1, int c) {
  byte m = row > 0 ? 8 : 0;
  for (byte i = 0; i < 8; i++) {
    if ((i * 8) + 8 > x0 ) {
      matrix[m + i].drawLine((-i * 8) + x0, y0, (-i * 8) + x1, y1, c);
    }
  }
}

void printRect(int row,  int x0, int y0, int x1, int y1, int c) {
  byte m = (row > 0 ? 1 : 0) * 8;
  for (byte i = 0; i < 8; i++) {
    matrix[m + i].fillRect((-i * 8) + x0, y0, x1, y1, c);
  }
}

void scrollDoubleUp() {
  for (int v = 0; v < 14; v++) {
    clearDisplay();
    printDisplay(dis[0], 64, 0, 0, -v);
    printDisplay(dis[1], 64, 0, 0, -v + 13);
    printDisplay(dis[1], 64, 1, 0, -v);
    updateDisplay();
  }
  dis[0] = dis[1];
  dis[1] = "";
}

void scrollDown(String str, int row) {
  for  (int v = 0; v < 12; v++) {
    clearDisplay(row);
    printDisplay(dis[row], textWidth(dis[row], row), row, 0, v);
    printDisplay(data, textWidth(data, row), row, 0,  v - 11);
    updateDisplay(row);
  }
  dis[row] = data;
}

void scroll(String str, byte row, int x0, int x1, int y, byte s, byte d) {
  int w = textWidth(str, row);
  //  s ++;
  for (int x = x0; x > x1; x--) {
    clearDisplay(row);
    printDisplay(str, w, row, x, y);
    updateDisplay(row);
    if (x - x1 > 3) {
      x -= s;
    }
    //    delay(d);
  }
}

byte charWidth(char c, int row) {
  return textWidth(String(c), row);
}

int textWidth(String c, int row) {
  return matrix[row * 8].getTextWidth(c);
}


