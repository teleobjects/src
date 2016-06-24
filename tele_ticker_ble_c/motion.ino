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
  if (millis() > lastTick + tick) {
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
  }
}

void showAlphabet() {
//  clearDisplay();
  for (int i = 0; i < CHARS; i++ ) {
    dis[i] = i + cursorX % 255;
  }
  cursorX -= pitch/5;
  updateDisplay();
}

void showAxis() {
  clearDisplay();
  rollBuffer[0] = roll >= 0 ? '+' : '-';
  rollBuffer[1] = char(int(abs(roll) / 100) + 48);
  rollBuffer[2] = char((int(abs(roll)) / 10 % 10) + 48);
  rollBuffer[3] = char(int(abs(roll)) % 10) + 48;

  pitchBuffer[0] = pitch >= 0 ? '+' : '-';
  pitchBuffer[1] = char(int(abs(pitch) / 100) + 48);
  pitchBuffer[2] = char((int(abs(pitch)) / 10 % 10) + 48);
  pitchBuffer[3] = char(int(abs(pitch)) % 10) + 48;

  headingBuffer[0] = heading >= 0 ? '+' : '-';
  headingBuffer[1] = char(int(abs(heading) / 100) + 48);
  headingBuffer[2] = char((int(abs(heading)) / 10 % 10) + 48);
  headingBuffer[3] = char(int(abs(heading)) % 10) + 48;

  int offsetX = 5;
  dis[0 + offsetX] = 'R';
  dis[1 + offsetX] = rollBuffer[0];
  dis[2 + offsetX] = rollBuffer[1];
  dis[3 + offsetX] = rollBuffer[2];
  dis[4 + offsetX] = rollBuffer[3];

  dis[8 + offsetX] = 'P';
  dis[9 + offsetX] = pitchBuffer[0];
  dis[10 + offsetX] = pitchBuffer[1];
  dis[11 + offsetX] = pitchBuffer[2];
  dis[12 + offsetX] = pitchBuffer[3];

  dis[16 + offsetX] = 'H';
  dis[17 + offsetX] = headingBuffer[0];
  dis[18 + offsetX] = headingBuffer[1];
  dis[19 + offsetX] = headingBuffer[2];
  dis[20 + offsetX] = headingBuffer[3];

  updateDisplay();
}

void showSleep() {
  clearDisplay();
  if (inertia > 8) {
    mode = LOOK;
    awakeStart = millis();
    eyesX = 0;
  }
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

float targetHeading;

void showCompass() {
  accelerometer();
  targetHeading += (heading - targetHeading) * .025;
  int offset = int(map(targetHeading, -180, 180, 0, compass.length()));
  if (offset < 0) offset += compass.length();
  if (offset > compass.length()) offset -= compass.length();
  for (int i = 0; i < CHARS; i++) {
    int pos = (i + offset);
    if (pos >= compass.length()) pos = pos - compass.length(); //- (pos -compass.length());
    //    if (pos < 0) pos = pos + compass.length();
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
  dis[cursorX++] = voltageBuffer[0] - 48 + 17;
  dis[cursorX++] = voltageBuffer[2];
  dis[cursorX++] = voltageBuffer[3];
  dis[cursorX++] = 131;
  if (charging) {
    if (millis() > chargingNext) {
      chargingX ++;
      chargingNext = millis() + chargingSpeed;
      if (chargingX >= batIndex + 1) {
        chargingNext = millis() + chargingSpeed * 4;
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
  if (voltage < 340 && !charging && millis() % 1000 < 500) {
    data = "LOW BATTERY";
    for (int i = 0; i < data.length(); i++) {
      dis[cursorX++] = data[i];
    }
    lastBattery = millis() > 10000;
  }
  updateDisplay();
}

void showBrightness() {
  clearDisplay();
  brightnessIndex = map(brightness, 1, 13, 2, 10);
  dis[cursorX++] = brightnessIndex + 48;
  dis[cursorX++] = '0';
  if (brightnessIndex == 10) dis[cursorX++] = '0';
  dis[cursorX++] = '%';
  cursorX++;
  data = "brightness";
  for (int i = 0; i < data.length(); i++) {
    dis[cursorX++] = data[i];
  }
  updateDisplay();
}

void showRain() {
  if (millis() - lastTick > tick * 10 ) {
    lastTick = millis();
    for (int i = 0; i < CHARS; i++) {
      if (dis[i] == ' ') {
        if (random(100) < tock) dis[i] = 10;
      } else if (dis[i] == 10) {
        dis[i] = 11;
        if (random(100) < 70) dis[i] = '/';
      } else if (dis[i] == 11) {
        dis[i] = ' ';
      } else if (dis[i] == '/') {
        dis[i] = 11;
        if (random(100) < 30) dis[i] = '/';
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

  if (millis() - lastTick > tick * 10 ) {
    lastTick = millis();
    for (int i = 0; i < CHARS; i++) {
      if (random(100) < 70 && dis[i] > 7 && dis[i] < 14) {
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
      int snowWind = (-2 + random(teck)); //-x * 40;
      if (random(100) < abs(snowWind)) {
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

    if (random(100) < 50)  {
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
            case (char)140:
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
    }
    updateDisplay();
  }
}
