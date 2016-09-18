void showSpectrum() {
  clearDisplay();
  for (int column = 0; column < WIDTH / 2; column++) {
    int l = (data[column] - 48 );
    printLine(1, column * 2, -1, column * 2, -1 + l, 1);
    printLine(0, column * 2, 8, column * 2, 8 - l, 1);
  }
  updateDisplay();
}

void showAlphabet() {
  setTextFont(0);
  String str = "";
  for (int i = 32; i < 236; i++) { // 236
    str += char(i);
  }
  clearDisplay(0);
  scroll(str, 0, WIDTH, -textWidth(str, 0), 0, 0, 0);
}

void showCounter() {
  if (millis() > lastTick + tick) {
    lastTick = millis();
    clearDisplay();
    switch (tack) {
      case 0:
        printVerticalLine(cursorX, LED_ON);
        cursorX ++;
        cursorX = cursorX % WIDTH;
        break;
    }
    updateDisplay();
  }
}
void showNoise() {
  if (millis() > lastTick + tick * 10) {
    lastTick = millis();

    clearDisplay();
    switch (tack) {
      case 0:
        for (int i = 0; i < teck; i++) {
          int  m = int (random(16));
          int px = int (random(8));
          int py = int (random(8));
          printPixel(m, px, py);
        }
        for (int i = 0; i < NUM; i++) {
          matrix[i].setBrightness(int(random(16)));
        }
        break;
      case 1:
        for (int i = 0; i < teck; i++) {
          int x = int(random(WIDTH));
          printLine(0, x, 0 , x, 7, LED_ON);
          printLine(1, x, 0 , x, 7, LED_ON);
        }
        for (int i = 0; i < NUM / 2; i++) {
          int br = int(random(16));
          matrix[i].setBrightness(br);
          matrix[i + 8].setBrightness(br);
        }
        break;
    }
    updateDisplay();
  }
}

void showRandom() {
  if (millis() > lastTick + tick * 10) {
    lastTick = millis();
    String str;
    int last = 236;
    int first = 32;
    clearDisplay();
    dis[0] = "";
    dis[1] = "";
    for (int i = 0; i < 20; i++) {
      switch (tack) {
        case 0:
          first = 32;
          last = 236;
          break;
        case 1:
          first = 48;
          last = 58;
          break;
        case 2:
          first = 65;
          last = 65 + 24;
          break;
        case 3:
          first = 65;
          last = 97 + 30;
          break;
      }
      dis[0] += char((byte)(first + random(last - first)));
      dis[1] += char((byte)(first + random(last - first)));
    }
    printDisplay(dis[0], WIDTH, 0, 0, 0);
    printDisplay(dis[1], WIDTH, 1, 0, 0);
    updateDisplay();
  }
}

void updateTimer() {
  if (millis() > nextTime) {
    nextTime += 1000;
    timer[5] = (timer[5] + 1) % 10;
    if (timer[5] == 0) {
      timer[4] = (timer[4] + 1) % 6;
      if (timer[4] == 0) {
        timer[3] = (timer[3]  + 1) % 10;
        if (timer[3] == 0) {
          timer[2] = (timer[2] + 1) % 6;
          if (timer[2] == 0) {
            timer[1] = ((timer[1] + 1) % 10);
            if (timer[1] == 0) {
              timer[0]++;
            }
            if (teck) {
              if (timer[0] == 1 && timer[1] == 2) {
                postMeridiam = !postMeridiam;

              }
              if (timer[0] == 1 && timer[1] == 3) {
                timer[0] = 0;
                timer[1] = 1;
              }
            } else {
              if (timer[0] == 2 && timer[1] == 4) {
                timer[0] = 0;
                timer[1] = 0;
              }
            }
          }
        }
      }
    }
  }
}

void showClock() {
  clearDisplay();
  updateTimer();
  switch (tack) {
    case 0:
      setTextFont(0);
      cursorX = 3;
      timerX[0] = cursorX;
      timerX[1] = cursorX + 6;
      timerX[2] = cursorX + 15;
      timerX[3] = cursorX + 21;
      timerX[4] = cursorX + 30;
      timerX[5] = cursorX + 36;
      for (int i = 0; i < 6; i++) {
        if (timer[i] != lastTimer[i] && timerY[i] == 0) {
          timerY[i] = 9;
        }
        if (timerY[i] > 0) {
          timerY[i] --;
          if (timerY[i] == 0) lastTimer[i] = timer[i];
        }
        if (i > 0 || lastTimer[0] > 0) {
          printChar(timer[i] + 48, 5, 1, timerX[i], timerY[i]);
          if (timerY[i] != 0) printChar(lastTimer[i] + 48, 5, 1, timerX[i], timerY[i] - 8);
        }
      }
      printDisplay(postMeridiam ? "PM" : "AM", 11, 1, cursorX + 45, 0);
      setTextColor(millis() % 1000 < 500 ? 1 : 0);
      printChar('.', 4, 1, cursorX + 10, 0);
      printChar('.', 4, 1, cursorX + 25, 0);
      setTextColor(1);
      setTextFont(1);
      printCentered("Wed, July 7th", 0, 0);

      //      setTextSize(2);
      //      if (!teck || timer[0] > 0) {
      //        printDouble(String(char(timer[0] + 48)), 2, 0, -8);
      //      }
      //      printDouble(String(char(timer[1] + 48)), 12, 0, -8);
      //      printDouble(String(char(timer[2] + 48)), 28, 0, -8);
      //      printDouble(String(char(timer[3] + 48)), 40, 0, -8);
      //      printRect(1, 24, 4, 2, 2, millis() % 1000 < 500 ? 1 : 0);
      //      setTextSize(1);
      //      printChar(timer[4] + 48, 16, 0, 52, 1);
      //      printChar(timer[5] + 48, 16, 0, 58, 1);
      //      if (teck) {
      //        printDisplay(postMeridiam ? "PM" : "AM", 16, 1, 52, 0);
      //      }
      break;

    case 1:
      cursorX = teck ? 27 : 36;
      timerX[0] = cursorX;
      timerX[1] = cursorX + 4;
      timerX[2] = cursorX + 10;
      timerX[3] = cursorX + 14;
      timerX[4] = cursorX + 20;
      timerX[5] = cursorX + 24;
      for (int i = 0; i < 6; i++) {
        if (timer[i] != lastTimer[i] && timerY[i] == 0) {
          timerY[i] = 9;
        }
        if (timerY[i] > 0) {
          timerY[i] --;
          if (timerY[i] == 0) lastTimer[i] = timer[i];
        }
        if (i > 0 || lastTimer[0] > 0) {
          printChar(timer[i] + 48, 4, 1, timerX[i], timerY[i]);
          if (timerY[i] != 0) printChar(lastTimer[i] + 48, 4, 1, timerX[i], timerY[i] - 8);
        }
      }
      if (teck) {
        printDisplay(postMeridiam ? "PM" : "AM", 16, 1, cursorX + 29, 0);
      }
      setTextColor(millis() % 1000 < 500 ? 1 : 0);
      printChar('.', 3, 1, cursorX + 8, 0);
      printChar('.', 3, 1, cursorX + 18, 0);
      setTextColor(1);
      break;

    case 2:
      setTextFont(1);
      timerX[0] = 0;
      timerX[1] = 13;
      timerX[2] = 31;
      timerX[3] = 44;
      timerX[4] = 57;
      timerX[5] = 61;
      for (int i = 0; i < 6; i++) {
        if (timer[i] != lastTimer[i] && timerY[i] == 0) {
          timerY[i] = i < 4 ? 24 : 9;
        }
        setTextSize(i < 4 ? 4 : 1);
        if (timerY[i] > 0) {
          timerY[i] -= i < 4 ? 2 : 1;
          if (timerY[i] == 0) lastTimer[i] = timer[i];
        }
        if (i < 4) {
          if (i > 0 || lastTimer[0] > 0) {
            printDouble(String(char(timer[i] + 48)), timerX[i], timerY[i] + 13, timerY[i] + 2);
            if (timerY[i] != 0) printDouble(String(char(lastTimer[i] + 48)), timerX[i], timerY[i] - 24 + 9,  timerY[i] - 24);
          }
        } else {
          printChar(timer[i] + 48, 4, 0, timerX[i], timerY[i] - 1);
          if (timerY[i] != 0) printChar(lastTimer[i] + 48, 4, 0, timerX[i], timerY[i] - 1 - 9);
        }
      }
      printRect(1, 26, 4, 4, 4, millis() % 1000 < 500 ? 1 : 0);
      if (true) {
        for (int i = 0; i < 4; i++) {
          printLine(0, 0, 1 + (i * 2), 56, 1 + (i * 2), 0);
          printLine(1, 0, 1 + (i * 2), 56, 1 + (i * 2), 0);
        }
      }
      if (teck) {
        printDisplay(postMeridiam ? "PM" : "AM", 16, 1, 57, 1);
      }
      break;

    case 3:
      setTextFont(1);
      timerX[0] = 3;
      timerX[1] = 12;
      timerX[2] = 30;
      timerX[3] = 42;
      timerX[4] = 54;
      timerX[5] = 58;
      for (int i = 0; i < 6; i++) {
        if (timer[i] != lastTimer[i] && timerY[i] == 0) {
          timerY[i] = i < 4 ? 24 : 9;
        }
        setTextSize(i < 4 ? 3 : 1);
        if (timerY[i] > 0) {
          timerY[i] -= i < 4 ? 2 : 1;
          if (timerY[i] == 0) lastTimer[i] = timer[i];
        }
        if (i < 4) {
          if (i > 0 || lastTimer[0] > 0) {
            printDouble(String(char(timer[i] + 48)), timerX[i], timerY[i] + 11, timerY[i]);
            if (timerY[i] != 0) printDouble(String(char(lastTimer[i] + 48)), timerX[i], timerY[i] - 24 + 11,  timerY[i] - 24);
          }
        } else {
          printChar(timer[i] + 48, 4, 0, timerX[i], timerY[i] + 1);
          if (timerY[i] != 0) printChar(lastTimer[i] + 48, 4, 0, timerX[i], timerY[i] - 8);
        }
      }
      if (teck) {
        printDisplay(postMeridiam ? "PM" : "AM", 16, 1, 54, 0);
      }
      printRect(1, 24, 3, 3, 3, millis() % 1000 < 500 ? 1 : 0);
      break;
      //    case 4:
      //      setTextFont(5);
      //      if (!teck || timer[0] > 0) {
      //        printDouble(String(char(timer[0] + 48)), 0, 11, 0);
      //      }
      //      printDouble(String(char(timer[1] + 48)), 13, 11, 0);
      //      printDouble(String(char(timer[2] + 48)), 28, 11, 0);
      //      printDouble(String(char(timer[3] + 48)), 41, 11, 0);
      //      setTextFont(1);
      //      printDisplay(String(char(timer[4] + 48)) + String(char(timer[5] + 48)), 16, 0, 56, 0);
      //      printRect(1, 26, 4, 3, 3, millis() % 1000 < 500 ? 1 : 0);
      //      break;
  }
  updateDisplay();
}

void showBattery() {
  int hundreds = int(voltage / 100);
  String dec = String(voltage - (hundreds * 100));
  String v = String(hundreds) + "." + dec + "v " + String(batIndex) + "0%";
  int w = textWidth(v, 1);
  teck = (WIDTH - w + 1) / 2;
  clearDisplay(1);
  printDisplay(v, w, 1, teck, 0);
  batIndex = int(map(voltage, minBat, maxBat, 0, 10));
  if (batIndex > 10) batIndex = 10;
  cursorX = 15;
  batLong = 30;
  printLine(0, cursorX, 1, cursorX, 6, 1);
  printLine(0, cursorX + 1, 0, cursorX + batLong + 1, 0, 1);
  printLine(0, cursorX + batLong + 2, 1, cursorX + batLong + 2, 6 , 1);
  printLine(0, cursorX + 1, 7, cursorX + batLong + 1, 7, 1);
  printLine(0, cursorX + batLong + 3, 3, cursorX + batLong + 3, 4, 1);
  if (charging) {
    if (millis() > chargingNext) {
      for (int i = 0; i < 10; i++) {
        printLine(0, cursorX + 2 + (i * 3), 2, cursorX + 2 + (i * 3), 5, i < chargingX ? 1 : 0);
        printLine(0, cursorX + 3 + (i * 3), 2, cursorX + 3 + (i * 3), 5, i < chargingX ? 1 : 0);
      }
      chargingX ++;
      chargingNext = millis() + chargingSpeed;
      if (chargingX >= batIndex + 1) {
        chargingNext = millis() + chargingSpeed * 4;
        chargingX = -1;
      }
    }
  } else {
    for (int i = 0; i < 10; i++) {
      printLine(0, cursorX + 2 + (i * 3), 2, cursorX + 2 + (i * 3), 5, batIndex >= i ? 1 : 0);
      printLine(0, cursorX + 3 + (i * 3), 2, cursorX + 3 + (i * 3), 5, batIndex >= i ? 1 : 0);
    }
  }
  updateDisplay();
}

void showBrightness() {
  clearDisplay();
  brightnessIndex = map(brightness, 1, 13, 2, 10);
  String br = String(brightnessIndex) + "0% brightness";
  printCentered(br, 0, 0);
  updateDisplay();
}

