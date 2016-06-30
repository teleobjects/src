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
  clearDisplay();
  font = 1;
  for (byte i = 0; i < NUM; i++) {
    //    matrix[i].clear();
    matrix[i].writeDisplay();
    matrix[i].setBrightness(1);
    matrix[i].setRotation(2);
    matrix[i].setFont(&TomThumb);
    //    matrix[i].invertDisplay(true);
    //    matrix[i].setTextColor(LED_OFF);
    matrix[i].setTextSize(fontSize);
    matrix[i].setTextWrap(false);
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
        matrix[i].setFont(&FreeSansBold12pt7b);
      }
      break;
    case 3:
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

  byte m = (row * 8);
  for (byte i = 0; i < 8; i++) {
    matrix[m + i].writeDisplay();
  }
}

void clearDisplay() {
  clearDisplay(0);
  clearDisplay(1);
}

void clearDisplay(byte row) {
  byte m = (row * 8);
  for (byte i = 0; i < 8; i++) {
    matrix[m + i].clear();
  }
}

void fill(byte row) {
  byte m = (row * 8);
  for (byte i = 0; i < 8; i++) {
    matrix[m + i].fillScreen(LED_ON);
  }
}

void printDouble(String str, int x, int y0, int y1) {
  int w = textWidth(str);
  for (byte i = 0; i < 8; i++) {
    matrix[i].setCursor((-i * 8) + x, y0 + (font > 0 ? 6 : 0));
    matrix[i].print(str);
  }
  for (byte i = 0; i < 8; i++) {
    matrix[8 + i].setCursor((-i * 8) + x, y1 + (font > 0 ? 6 : 0));
    matrix[8 + i].print(str);
  }
}

void printDisplay(String str, byte row, int x, int y) {
  int w = textWidth(str);
  if (x == 1000) {
    x = (WIDTH - w + 1) / 2;
  }
  byte m = (row * 8);
  for (byte i = 0; i < 8; i++) {
    if (i * 8 > w + x) break;
    if ((i * 8) + 8 > x) {
      matrix[m + i].setCursor((-i * 8) + x, y + (font > 0 ? 6 : 0));
      matrix[m + i].print(str);
    }
  }
}

void scroll(String str, byte row, int x0, int x1, int y, byte s) {
  for (int x = x0; x > x1; x--) {
    clearDisplay(row);
    printDisplay(str, row, x, y);
    updateDisplay(row);
    delay(s);
  }
}

byte charWidth(char c) {
  return textWidth(String(c));
}

int textWidth(String c) {
  return matrix[tack * 8].getTextWidth(c);
}


