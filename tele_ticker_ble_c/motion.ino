void showShow() {

  if (millis() > lastScroll + 1000 - (abs(roll) * 10)) {
    if (abs(roll) > 15) {
      click(DOUBLE_CLICK);
      scrollShow(roll > 0);
      //      tx();
    }
  }
  clearDisplay();
  cursorX = (CHARS - showItems[currentShowItem].length()) / 2;
  for (int i = 0; i < showItems[currentShowItem].length(); i++) {
    dis[cursorX + i] = showItems[currentShowItem][i] ;
  }
  updateDisplay();
}

void showSensors() {

  //
  clearDisplay();

  int offsetX = 5;

  dis[1 + offsetX] = temperature >= 0 ? ' ' : '-';
  dis[2 + offsetX] = char(int(abs(temperature) / 10) + 48);
  dis[3 + offsetX] = char(int(abs(temperature)) % 10) + 48;
  dis[4 + offsetX] = '°';
  dis[5 + offsetX] = 'C';

  dis[7 + offsetX] = humidity == 100 ? '1' : ' ';
  dis[8 + offsetX] = char(int(humidity / 10) + 48);
  dis[9 + offsetX] = char((int(humidity) % 10) + 48);
  dis[10 + offsetX] = '%';
  dis[11 + offsetX] = 'h';

  int p = pressure / 100;

  dis[14 + offsetX] = p > 1000 ? '1' : ' ';
  dis[15 + offsetX] =  char(((p % 1000) / 100) + 48);
  dis[16 + offsetX] =  char(((p % 100) / 10) + 48);
  dis[17 + offsetX] =  char(p % 10) + 48;
  dis[18 + offsetX] = 'm';
  dis[19 + offsetX] = 'b';

  updateDisplay();
  updateSensors();

}

void showClock() {

  clearDisplay();
  //  updateTimer();
  cursorX = 10;
  if (timer[0] > 0) {
    dis[cursorX + 0] = timer[0] + 48;
  }
  dis[cursorX + 1] = timer[1] + 48;
  dis[cursorX + 3] = timer[2] + 48;
  dis[cursorX + 4] = timer[3] + 48;
  dis[cursorX + 6] = timer[4] + 48;
  dis[cursorX + 7] = timer[5] + 48;
  dec[cursorX + 1] = millis() % 1000 < 500;
  dec[cursorX + 4] = millis() % 1000 < 500;
  dis[cursorX + 9] = postMeridiam ? 'P' : 'A';
  dis[cursorX + 10] = 'M';
  updateDisplay();
}

void showBall() {
  clearDisplay();
  //  showAxis();

  //  if (pitch > 0) {
  //    ballY += (180 - abs(pitch)) / 60;
  //  } else {
  //    ballY -= (180 - abs(pitch)) / 60;
  //  }

  // continous
  //  if (millis() > lastPitch + 300) {
  //    if (pitch > 0 && pitch < pitchLimit) {
  //      ballY ++;
  //      lastPitch = millis();
  //    } else if (pitch < -pitchLimit) {
  //      ballY --;
  //      lastPitch = millis();
  //    }
  //  }

  // gap +110 +150
  //  if (pitch > 0 && millis() > lastPitch + 300) {
  //    if (pitch < 110) {
  //      ballY ++;
  //      lastPitch = millis();
  //    } else if (pitch > 150) {
  //      ballY --;
  //      lastPitch = millis();
  //    }
  //  }

  //  gap +120 -170
  if (millis() > lastTick + 300) {
    if (pitch > 0 && pitch < 120) {
      ballY ++;
      lastTick = millis();
    }

    if (pitch < 0 && pitch > -170) {
      ballY --;
      lastTick = millis();
    }
  }

  if (ballY < 0) ballY = 0;
  if (ballY > 2) ballY = 2;
  dis[int(ballX)] = bars[int(ballY)];
  ballX += roll / 40;
  if (ballX < 0) ballX = 0;
  if (ballX > 31) ballX = 31;
  //  delay(tick);
  updateDisplay();
}

void showCounter() {
  if (millis() > lastTick + tick) {
    lastTick = millis();
    switch (tack) {
      case 0:
        if (cursorX == CHARS + 1) clearDisplay();
        for (int i = 0; i < cursorX; i++) {
          dec[i] = true;
        }
        cursorX ++;
        if (cursorX == CHARS + 1) lastTick = millis() + tock;
        break;
      case 1:
        if (cursorX == CHARS + 1) clearDisplay();
        for (int i = 0; i < cursorX; i++) {
          dis[i] = data[0];
        }
        cursorX ++;
        if (cursorX == CHARS + 1) lastTick = millis() + tock;
        break;
      case 2:
        clearDisplay();
        dis[lastX] = data[0];
        lastX ++;
        if (lastX == CHARS + 1) {
          lastTick = millis() + tock;
          lastX  = 0;
          clearDisplay();
        }
        break;
      case 3:
        //        dis[i] = int(random(15));
        break;
      case 4:
        //        dec[i] = random(10) < 5;
        break;
    }
    updateDisplay();
  }
}

void showRandom() {
  if (millis() > lastTick + tick) {
    lastTick = millis();
    clearDisplay();
    for (int i = 0; i < CHARS; i++) {
      switch (tack) {
        case 0:
          dis[i] = int(48 + random(10));
          break;
        case 1:
          dis[i] = int(65 + random(28));
          break;
        case 2:
          dis[i] = int(0 + random(128));
          break;
        case 3:
          dis[i] = int(random(15));
          break;
        case 4:
          dec[i] = random(10) < 5;
          break;
      }
    }
  }
  updateDisplay();
}

void showLook() {
  clearDisplay();
  boolean eyesB = millis() % 1200 < 300;
  face = tack - 65;
  faceClosed = teck - 65;
  dis[eyesX] = !eyesB ?  char(leftEyes[face]) : char(leftEyes[faceClosed]);
  dis[eyesX + 1] = !eyesB ?  char(rightEyes[face]) : char(rightEyes[faceClosed]) ;
  dec[eyesX] = true;
  updateDisplay();
}

void showAirport() {
  if (millis() > lastTick + tick && busy) {
    lastTick = millis();
    busy = false;
    for (int i = 0; i < CHARS; i++) {
      if (dis[i] != data[i]) {
        busy = true;
        dis[i] = dis[i] + 1;
        if (dis[i] == 35) dis[i] = char(48);
        if (dis[i] > 64 + 26) dis[i] = char(48);
        if (dis[i] < 48) dis[i] = char(48);
        if (dis[i] > 58 && dis[i] < 65) dis[i] = 65;
        if (dis[i] == 48 && (data[i] < 48 || data[i] > 65 + 26)) dis[i] = data[i];
      }
    }
    updateDisplay();
    if (busy == false) {
      tx();
    }
  }
}

void showAlphabet() {
  for (int i = 0; i < CHARS; i++ ) {
    dis[i] = i + cursorX % 255;
  }
  ballX -= roll / 40;
  cursorX = int(ballX);
  if (cursorX != lastX) click(SHARP_CLICK);
  lastX = cursorX;
  updateDisplay();
  delay(10);
}

void showAxis() {
  clearDisplay();

  int offsetX = 5;
  dis[0 + offsetX] = 'P';
  dis[1 + offsetX] = pitch >= 0 ? '+' : '-';
  dis[2 + offsetX] = char(int(abs(pitch) / 100) + 48);
  dis[3 + offsetX] = char((int(abs(pitch)) / 10 % 10) + 48);
  dis[4 + offsetX] = char(int(abs(pitch)) % 10) + 48;

  dis[8 + offsetX] = 'R';
  dis[9 + offsetX] = roll >= 0 ? '+' : '-';
  dis[10 + offsetX] = char(int(abs(roll) / 100) + 48);
  dis[11 + offsetX] = char((int(abs(roll)) / 10 % 10) + 48);
  dis[12 + offsetX] = char(int(abs(roll)) % 10) + 48;

  dis[16 + offsetX] = 'H';
  dis[17 + offsetX] = heading >= 0 ? '+' : '-';
  dis[18 + offsetX] = char(int(abs(heading) / 100) + 48);
  dis[19 + offsetX] = char((int(abs(heading)) / 10 % 10) + 48);
  dis[20 + offsetX] = char(int(abs(heading)) % 10) + 48;
  updateDisplay();

  if (millis() - lastTx > txSpeed) {
    tx();
  }
}

void showSleep() {
  clearDisplay();
  //  if (inertia > 8) {
  //    mode = LOOK;
  //    awakeStart = millis();
  //    eyesX = 0;
  //  }
  switch (zzz) {
    case 0:
      break;
    case 1:
      dis[0] = 'z';
      break;
    case 2:
      dis[0] = 'z';
      dis[1] = 'z';
      break;
    case 3 :
      dis[0] = 'z';
      dis[1] = 'z';
      dis[2] = 'z';
      break;
  }
  updateDisplay();
  if (millis() > nextZ) {
    zzz += zzzD;
    if (zzz == 3) zzzD = -1;
    if (zzz == 0) zzzD = 1;
    nextZ = millis() + 60;
    if (zzz == 0) {
      zzzC ++;
      if (zzzC % 2 == 0) {
        nextZ += 3000;
      }
    }
  }
}

void showLoading() {
  if (millis() > lastTick + tick) {
    lastTick = millis();
    switch (tack) {
      case 0:
        dis[0] = loadingOut[lastX];
        lastX ++;
        if (lastX >= 6) lastX = 0;
        break;
      case 1:
        dis[0] = loadingIn[lastX];
        lastX ++;
        if (lastX >= 8) lastX = 0;
        break;

      case 2:
        for (int i = 0; i < CHARS; i++) {
          dis[i] = loadingIn[lastX];
        }
        lastX ++;
        if (lastX >= 8) lastX = 0;
        break;
    }
    cursorX = 1;
    for (int i = 0; i < data.length(); i++) {
      dis[cursorX] = data[i];
      cursorX ++;
    }
    if (teck) {
      cursorX --;
      int index = millis() % 1000 / 200;
      for (int i = 0; i < 3; i++) {
        dec[cursorX + i] = index > i;
      }
    }

    updateDisplay();
  }
}


void showCompass() {
  if (abs(heading - currentHeading) > 180) {
    if (heading > currentHeading) {
      currentHeading += 360;
    } else if (heading < currentHeading) {
      currentHeading -= 360;
    }
  }
  currentHeading += (heading - currentHeading) * .02;
  int offset = int(map(currentHeading + 180, 0, 360, 0, compass.length()));
  if (offset != lastX && millis() - lastTx > 10 ) {
    click(MEDIUM_CLICK);
    //    responses = 0;
    //    busy = false;
    if (millis() - lastTx > txSpeed) {
      tx();
    }
    lastX = offset;

  }
  for (int i = 0; i < CHARS; i++) {
    int pos = (i + offset);
    dis[i] = compass[pos % compass.length()];
  }
  updateDisplay();

}

void showBattery() {
  clearDisplay();
  batIndex = int(map(voltage, minBat, maxBat, 0, 10));
  if (batIndex > 10) batIndex = 10;
  dis[batLong] = 6;
  cursorX = batLong + 2;
  dis[cursorX++] = batIndex + 48;
  dis[cursorX++] = '0';
  if (batIndex == 10) dis[cursorX++] = '0';
  dis[cursorX++] = '%';
  dis[cursorX++] = ' ';
  dec[cursorX] = true;
  dis[cursorX++] = int(voltage / 100) + 48;
  dis[cursorX++] = ((voltage % 100) / 10) + 48;
  dis[cursorX++] = (voltage % 10) + 48;
  dis[cursorX++] = 131;
  if (charging) {
    if (millis() > chargingNext) {
      chargingX ++;
      chargingNext = millis() + chargingSpeed;
      if (chargingX == batIndex) chargingNext = millis() + chargingSpeed * 4;
      if (chargingX >= batIndex + 1) {
        chargingNext = millis() + chargingSpeed * 2;
        chargingX = -1;
      }
    }
    dis[0] = chargingX > 0 ? 130 : '[';
    for (int i = 1; i < batLong - 1; i++) {
      dis[i] =  i < chargingX ? 130 : 128;
    }
    dis[batLong - 1] = chargingX >= 10 ? 130 : ']';

  } else {
    dis[0] = batIndex == 0 ? '[' : 130;
    for (int i = 1; i < batLong - 1; i++) {
      dis[i] =  i < batIndex ? 130 : 128;
    }
    dis[batLong - 1] = batIndex == 10 ? 130 : ']';
  }
  cursorX++;
  if (voltage < lowBat && !charging && millis() % 1000 < 500) {
    data = "LOW BATTERY";
    for (int i = 0; i < data.length(); i++) {
      dis[cursorX++] = data[i];
    }
    //    lastBattery = millis() > 10000;
  }
  updateDisplay();
}

void showBrightness() {
  if (millis() > lastRoll + 400 - (abs(roll) * 10)) {
    if (abs(roll) > 8) {
      lastRoll = millis();
      brightness += (roll > 0 ? 1 : -1);
      if (brightness >= 1 && brightness <= 15) click(STRONG_CLICK);
      if (brightness > 15) brightness = 15;
      if (brightness < 1) brightness = 1;
      setBrightness(brightness);
      tx();
      lastBrightness = brightness;
    }
  }
  clearDisplay();
  brightnessIndex = map(brightness, 1, 15, 1, 10);
  if (brightnessIndex == 10) {
    dis[cursorX++] = '1';
    dis[cursorX++] = '0';

  } else {
    cursorX++;
    dis[cursorX++] = brightnessIndex + 48;
  }
  dis[cursorX++] = '0';
  dis[cursorX++] = '%';
  cursorX++;
  data = "brightness";
  for (int i = 0; i < data.length(); i++) {
    dis[cursorX++] = data[i];
  }
  for (int i = 0; i < brightness; i++) {
    dis[CHARS - 15 + i] = '|';
  }
  updateDisplay();

}

void showRain() {
  if (abs(roll) > 5 && millis() - lastRoll > 100) {
    lastRoll = millis();
    tick += roll / 10;
    tock -= roll / 10;
    if (tock < 10) tock = 10;
    if (tock > 90) tock = 90;
    if (tick < 5) tick = 5;
    if (tick > 30) tick = 30;
  }
  if (millis() - lastTick > tick * 10 ) {
    lastTick = millis();
    for (int i = 0; i < CHARS; i++) {
      if (dis[i] == ' ') {
        if (random(100) < tock) dis[i] = 10;
      } else if (dis[i] == 10) {
        dis[i] = 11;
        if (random(100) < 70) dis[i] = ' / ';
      } else if (dis[i] == 11) {
        dis[i] = ' ';
      } else if (dis[i] == ' / ') {
        dis[i] = 11;
        if (random(100) < 30) dis[i] = ' / ';
      }
    }
    updateDisplay();
  }
}

void showSnow() {
  // tick speed
  // tock intensity
  // tack fall
  // teck wind

  //  teck = roll * 5;
  //  if (teck < -50) teck = -50;
  //  if (teck > 50) teck = 50;
  tack = 50;
  if (millis() - lastTick > tick * 5 ) {
    lastTick = millis();
    for (int i = 0; i < CHARS; i++) {
      if (random(100) < 50 && dis[i] > 7 && dis[i] < 14) {
        dis[i] = 32;
      }
      switch (dis[i]) {
        case 141:
          dis[i] = 137;
          break;
        case 142:
          dis[i] = 138;
          break;
        case 143:
          dis[i] = 139;
          break;
        case 144:
          dis[i] = 140;
          break;
        case 8:
          dis[i] = 137;
          break;
        case 10:
          dis[i] = 138;
          break;
        case 11:
          dis[i] = 139;
          break;
        case 13:
          dis[i] = 140;
          break;
      }
      if (dis[i] == 32 && random(100) < tock) {
        dis[i] = random(100) < 50 ? 137 : 138;
      }
      if (random(100) < 1) {
        dis[i] = 32;
      }
    }
    for (int i = 0; i < CHARS; i++) {
      // WIND
      int snowWind = roll * 5;
      if (random(100) < abs(teck)) {
        if (snowWind > 0) {
          if (dis[i] == 137) {
            dis[i] = 138;
          } else if (dis[i] == 138) {
            if (dis[i + 1] == 32 || i == 31) {
              dis[i + 1] = 137;
              dis[i] = 32;
              i++;
            }
          } else if (dis[i] == 139) {
            dis[i] = 140;
          } else if (dis[i] == 140) {
            if (dis[i + 1] == 32 || i == 31) {
              dis[i] = 32;
              dis[i + 1] = 139;
              i++;
            }
          }
        } else {
          if (dis[i] == 138) {
            dis[i] = 137;
          } else if (dis[i] == 137) {
            if (dis[i - 1] == 32 || i == 0) {
              dis[i - 1] = 138;
              dis[i] = 32;
              i++;
            }
          } else if (dis[i] == 140) {
            dis[i] = 139;
          } else if (dis[i] == 139) {
            if (dis[i - 1] == 32 || i == 0) {
              dis[i] = 32;
              dis[i - 1] = 140;
              i++;
            }
          }
        }
      } else {
        // FALL
        if (random(100) < tack) {
          if (dis[i] == 137) {
            dis[i] = 139;
          } else if (dis[i] == 138) {
            dis[i] = 140;
          } else if (dis[i] == 139) {
            dis[i] = ' ';
          } else if (dis[i] == 140) {
            dis[i] = ' ';
          }
        }
      }
    }

    //    if (random(100) < 90)  {
    for (int i = 0; i < 32; i++) {
      if (random(100) < 80) {
        switch (dis[i]) {
          case 137:
            dis[i] = 141;
            break;
          case 138:
            dis[i] = 142;
            break;
          case 139:
            dis[i] = 143;
            break;
          case 140:
            dis[i] = 144;
            break;
        }
      }  else  {
        switch (dis[i]) {
          case 137:
            dis[i] = 8;
            break;
          case 138:
            dis[i] = 10;
            break;
          case 139:
            dis[i] = 11;
            break;
          case 140:
            dis[i] = 13;
            break;
        }
      }
    }
    //    }
    updateDisplay();
  }
}
