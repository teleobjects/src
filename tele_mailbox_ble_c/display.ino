void printGradient() {
  int byteIndex = 1;
  for (int row = 0 ; row < HEIGHT; row = row + 2) {
    background = {data[byteIndex] - 48, data[byteIndex + 1] - 48, data[byteIndex + 2] - 48};
    oled.setGradient(HEIGHT - row, background);
    oled.setGradient(HEIGHT - row - 1, background);
    byteIndex += 3;
  }
  gradient = true;
}

void printPixels( byte x, byte y, byte w, byte h) {
  int byteIndex = 6;
  for (int row = 0 ; row < h; row ++) {
    for (int column = 0 ; column < w; column ++) {
      byte currentBit = data[byteIndex];
      oled.setPixel(x + column, HEIGHT - y - row, currentBit == '0' ? background : foreground);
      byteIndex ++;
    }
  }
}

void printBytes(byte x, byte y, byte w, byte h, boolean alpha) {
  int byteIndex = 0;
  for (int row = 0 ; row < h; row ++) {
    for (int byte_ = 0 ; byte_ < int(w / 8); byte_ ++) {
      for (int bit_ = 0; bit_ < 8; bit_++) {
        byte currentBit = screen[byteIndex] & (1 << bit_);
        if (alpha) {
          if (currentBit != 0) {
            oled.setPixel(x + (byte_ * 8) + bit_, HEIGHT - y - row, foreground);
          }
        } else {
          oled.setPixel(x + (byte_ * 8) + bit_, HEIGHT - y - row, currentBit == 0 ? background : foreground);
        }
      }
      byteIndex ++;
    }
  }
}

void printServo(byte angle) {
  servo.write(angle);
}

void printDirectory(String dir) {
  text.clear();
  File root = SD.open(dir);
  while (true) {
    File entry =  root.openNextFile();
    if (!entry) {
      break;
    }
    text.print(entry.name());
    if (entry.isDirectory()) {
      text.println("/");
      //      printDirectory(entry, numTabs + 1); // not recursive !
    } else {
      text.println();
      //      Serial.println(entry.size(), DEC);
    }
    entry.close();
  }
}

void printBitmap(String file, byte x, byte y) {
  File bmp = SD.open(file);
  if (!bmp) {
    text.clear();
    text.println(MSG_SKIP);
    text.println(file);
  }
  else {
    oled.displayBMP(bmp, x, HEIGHT - y);
  }
  bmp.close();
}

void printFont(int f) {
  font = f;
  oled.selectFont(fonts[f]);
}

void printString(String str, boolean mono, boolean center, byte x, byte y) {
  //  oled.selectFont(fonts[f]);
  if (mono) {
    int w = widths[font];
    if (center) {
      x = (WIDTH / 2) - (w * str.length() / 2);
    }
    for (int i = 0; i < str.length(); i ++) {
      oled.drawChar(x, HEIGHT - y, str[i], foreground, background, gradient);
      x += w;
    }
  } else {
    if (center) {
      x = (WIDTH / 2) - (oled.stringWidth(str) / 2);
    }
    oled.drawString(x, HEIGHT - y, str, foreground, background, gradient);
  }
}

void printCharTable(boolean mono, byte f, byte x, byte y) {
  oled.selectFont(fonts[f]);
  font = f;
  byte cx = x;
  byte cy = y;
  byte s = firsts[f];
  byte w = widths[f];
  byte h = heights[f];
  byte e = 255;
  while (s < e) {
    oled.drawChar(cx, HEIGHT - h -  cy, s, foreground, background, gradient);
    if (!mono) {
      w = oled.charWidth(s) + 1;
    }
    cx += w;
    if (cx > WIDTH - w) {
      cx = x;
      cy += h;
    }
    s++;
  }
}

void printGrid() {
  oled.drawLine(0, 0, WIDTH, HEIGHT, foreground);
  oled.drawLine(0, HEIGHT, WIDTH, 0, foreground);
  oled.drawCircle(WIDTH / 2, HEIGHT / 2, 50, foreground);
  oled.drawCircle(WIDTH / 2, HEIGHT / 2, 30, foreground);
  oled.drawBox(WIDTH / 2 - 50, HEIGHT / 2 - 50, WIDTH / 2 + 50, HEIGHT / 2 + 50, 1, foreground);
  oled.drawBox(WIDTH / 2 - 25, HEIGHT / 2 - 25, WIDTH / 2 + 25, HEIGHT / 2 + 25, 1, foreground);
}


