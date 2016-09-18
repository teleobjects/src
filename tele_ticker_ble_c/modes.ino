void play() {
  switch (mode) {

    case TYPE:
      if (cursorX < CHARS && cursorX >= 0) dis[cursorX] = millis() % 500 < 250 ? 32 : '_';
      updateDisplay();
      break;

    case SENSORS:
      showSensors();
      break;

    case RANDOM:
      showRandom();
      break;

    case BRIGHTNESS:
      showBrightness();
      break;

    case BATTERY:
      showBattery();
      break;

    case COMPASS:
      showCompass();
      break;

    case LOADING:
      showLoading();
      break;

    case COUNTER:
      showCounter();
      break;

    case SLEEP:
      showSleep();
      break;

    case LOOK:
      showLook();
      break;

    case CLOCK:
      showClock();
      break;

    case SCROLL:
      if (busy) {
        if (millis() > lastTick + tick * 2) {
          lastTick = millis();
          if (cursorX < breakX) {
            cursorX ++;
            for (int i = 0; i < CHARS - 1; i++) {
              dis[i] = dis[i + 1];
              dec[i] = dec[i + 1];
            }
            if (data.length() > 0) {
              dis[CHARS - 1] = data[0];
              dec[CHARS - 1] = false;
              data = data.substring(1, data.length());
              //              if (data.length() > 0) {
              //                if (data[0] == '.' && dis [CHARS - 2] != '.') {
              //                  dec[CHARS - 1] = true;
              //                  data = data.substring(1, data.length());
              //                  breakX --;
              //                }
              //              }
            } else {
              dis[CHARS - 1] = ' ';
              dec[CHARS - 1 ] = false;
            }
          } else if (cursorX > breakX ) {   /// scroll left
            cursorX --;
            for (int i = CHARS - 1; i > 0; i--) {
              dis[i] = dis[i - 1];
              dec[i] = dec[i - 1];
            }

            if (data.length() > 0) {
              dis[0] = data[data.length() - 1];
              dec[0] = false;
              data = data.substring(0, data.length() - 1);
              // if (data.length() > 0) {
              //   if (data.charAt(0) == '.' && dis [CHARS-2] != '.') {
              //     dec[CHARS - 1] = true;
              //     data = data.substring(1, data.length());
              //     breakX --;
              //   }
              // }
            } else {
              dis[0] = ' ';
              dec[0] = false;
            }
          } else {
            busy = false;
            tx();

          }
        }
        updateDisplay();
      }
      break;

    case TICKER:
      if (busy && millis() > lastTick + tick) {
        lastTick = millis();
        if (data.length() > 0) {
          if (breakX == 0) {
            clearDisplay();
            breakX = data.length();
            if (breakX > CHARS) breakX = findLastChar(data.substring(0, CHARS), ' ');
            if (breakX == 0) breakX = data.length();
            if (breakX > CHARS) breakX = CHARS;
            if (data[0] == ' ' && data.length() > 1) data = data.substring(1, data.length());
          }
          dis[cursorX] = data[0];
          data = data.substring(1, data.length());
          if (data.length() > 0 && data[0] == '.' && dis[cursorX] != '.') {
            dec[cursorX] = true;
            data = data.substring(1, data.length());
            breakX --;
          }
          //          if (data.length() == 0) {
          //            lastTick = millis() + tock * 100;
          //          }
          cursorX ++;
          if (cursorX >= breakX) {
            breakX = 0;
            if (data.length() > 0) {
              lastTick = millis() + tock * 100;
            }
            if (dis[cursorX - 1] == ' ') cursorX --;
          }
        } else {
          busy = false;
          tx();

        }
      }
      if (cursorX < CHARS && cursorX >= 0) dis[cursorX] = millis() % 500 < 250 ? 32 : '_';
      updateDisplay();
      break;

    case AXIS:
      showAxis();
      break;

    case ALPHABET:
      showAlphabet();
      break;

    case BALL:
      showBall();
      break;

    case AIRPORT:
      showAirport();
      break;

    case RAIN:
      showRain();
      break;

    case SNOW:
      showSnow();
      break;

    case MENU:
      showMenu();
      break;

    case SHOW:
      showShow();
      break;
  }
}

void error() {
  dec[31] = true;
  dec[30] = true;
  dec[29] = true;
  updateDisplay();
}

void parse() {
  if (data[1] - 48 == PING) {
    tx();
    return;
  }
  mode = data[1] - 48;
  tack = data[2] - 48;
  teck = data[3] - 48;
  tick = data[4] - 48;
  tock = data[5] - 48;
  tuck = data[6] - 48;
  data = data.substring(PACKETIN, data.length());

  //  click(STRONG_CLICK);
  //  if (mode != STREAM && mode != TYPE && mode != SPECTRUM && data.length() > 0 && data[data.length() - 1] == ' ') data = data.substring(0, data.length() - 1); // get rid of trailing space, hack!

  switch (mode) {
    case SHOW:
      currentShowItem = 0;
      scrollShow(false);
      break;
    case TYPE:
      if (data[0] == 8) {
        if (cursorX > 0) {
          dis[cursorX] = 32;
          dis[cursorX - 1] = 32;
          cursorX --;
        }
      } else if (data[0] == 31) {
        clearDisplay();
      } else if (data[0] >= 32 && data[0] < 128) {
        dis[cursorX] = data[0];
        cursorX ++;
        if (cursorX == CHARS) {
          for (int i = 0; i < CHARS - 1; i ++) {
            dis[i] = dis[i + 1];
          }
          cursorX --;
        }
      }
      updateDisplay();
      tx();
      break;

    case CLOCK:
      if (tack > 0) {
        for (int i = 0; i < 6; i++) {
          timer[i] = data[i] - 48;
        }
        if (teck > 0) {
          int hour = timer[0] * 10 + timer[1];
          postMeridiam = hour >= 12;
          if (hour == 0) hour = 12;
          if (postMeridiam) {
            hour = hour - 12;
          }
          timer[0] = int (hour / 10);;
          timer[1] = hour - (timer[0] * 10);
        }
      }
      //      for (int i = 0; i < 6; i++) {
      //        lastTimer[i] = timer[i];
      //      }
      nextTime = millis() + 1000;
      //      busy = false;
      tx();
      break;

    case COUNTER:
      clearDisplay();
      tx();
      break;

    case RAIN:
      clearDisplay();
      tx();
      break;

    case SNOW:
      clearDisplay();
      tx();
      break;

    case LOADING:
      clearDisplay();
      tx();
      break;

    case COMPASS:
      clearDisplay();
      tx();
      break;

    case SENSORS:
      tx();
      break;

    case RANDOM:
      tx();
      break;

    case BATTERY:
      clearDisplay();
      tx();
      break;

    case BLANK:
      clearDisplay();
      updateDisplay();
      tx();
      break;

    case BRIGHTNESS:
      if (tack != 0) {
        brightness = tack;
        if (brightness > 15) brightness = 1;
        setBrightness(brightness);
      }
      tx();
      break;

    case LOOK:
      face = tack;
      faceClosed = teck;
      eyesX = 0;
      //      busy = true;
      //      awakeStart = millis();
      tx();
      break;

    case INSTANT:
      clearDisplay();
      while (data.length() > 0 && cursorX < CHARS) {
        dis[cursorX] = data[0];
        if (data.length() > 0 && data[0] == '.' && dis[cursorX ] != '.') {
          dec[cursorX] = true;
          data = data.substring(1, data.length());
        }
        data = data.substring(1, data.length());
        cursorX ++;
      }
      updateDisplay();
      tx();
      break;

    case SPECTRUM:
      //      busy = true;
      //      for (int i = 0; i < CHARS / 4; i++) {
      //        byte b[4] = {0, 0, 0, 0};
      //        char c = 255 - data[i];
      //        b[0] = (c & 0b00000011);
      //        b[1] = (c & 0b00001100) >> 2;
      //        b[2] = (c & 0b00110000) >> 4;
      //        b[3] = (c & 0b11000000) >> 6;
      //        for (int j = 0; j < 4; j++) {
      //          dis[(i * 4) + j] = spectrum[b[j]];
      //          dec[(i * 4) + j] = false;
      //        }
      //      }
      //      if (data.length() == 4) {

      for (int i = 0; i < data.length() ; i++) {
//        if (data[i] > 3) data[i] == 0;
        dis[i] = spectrum[data[i] - 48];
        dec[i] = false;
        //        }
      }
      updateDisplay();

      break;

    case STREAM:
      //      busy = true;
      if (data.length() == CHARS) {
        for (int i = 0; i < CHARS; i++) {
          dis[i] = data[i];
          dec[i] = false;
        }
      }
      updateDisplay();
      break;

    case CENTERED:
      clearDisplay();
      cursorX = (CHARS - data.length() +  countChar(data, '.')) / 2;
      while (data.length() > 0 && cursorX < CHARS) {
        dis[cursorX] = data[0];
        data = data.substring(1, data.length());
        if (data.length() > 0) {
          if (data[0] == '.' && dis[cursorX ] != '.') {
            dec[cursorX] = true;
            data = data.substring(1, data.length());
          }
        }
        cursorX ++;
      }
      updateDisplay();
      tx();
      break;

    case TICKER:
      busy = true;
      breakX = 0;
      break;

    case SCROLL:
      busy = true;
      cursorX = 0;
      mode = SCROLL;
      if (tock == 0) {
        clearDisplay();
      }

      if (tack == 0) {
        switch (teck) {
          case 0:
            breakX = CHARS + data.length();
            break;
          case 1:
            breakX = ((CHARS - data.length()) / 2) + data.length();
            if (tock == 1) {
              lastX = CHARS + 1;
              for (int i = CHARS - 1; i >= 0; i--) {
                if (dis[i] != ' ') break;
                lastX --;
              }
              breakX = ((CHARS - data.length()) / 2) + data.length();
              if (breakX < lastX) {
                for (int i = 0; i < (lastX - breakX) && data.length() < CHARS; i++) {
                  data = " " + data;
                  data = data + " ";
                }
                //        if (data.length() > CHARS) data = data.substring(0, CHARS);
                if (CHARS > data.length()) {
                  breakX = ((CHARS - data.length()) / 2) + data.length();
                } else {
                  breakX = data.length();
                }
              }
            }
            break;
          case 2:
            breakX = CHARS;
            break;
          case 3:
            breakX = data.length();
            break;
        }
      } else {
        switch (teck) {
          case 0:
            breakX = -(CHARS + data.length());
            break;
          case 1:
            breakX = -((CHARS - data.length()) / 2) - data.length();
            if (tock == 1) {
              firstX = 0;
              for (int i = 0; i < CHARS; i++) {
                if (dis[i] != ' ') break;
                firstX ++;
              }
              firstX = -(CHARS - firstX);
              if (breakX > firstX) {
                for (int i = 0; i < (breakX - firstX) && data.length() < CHARS; i++) {
                  data = " " + data;
                  data = data + " ";
                }
                if (CHARS > data.length()) {
                  breakX = -((CHARS - data.length()) / 2) - data.length();
                } else {
                  breakX = data.length();
                }
              }
            }
            break;
          case 2:
            breakX = -CHARS;
            break;
          case 3:
            breakX = - data.length();
            break;
        }
      }
      break;

    case AIRPORT:
      busy = true;
      for (int i = data.length(); i < CHARS; i++) {
        data += " ";
      }
      for (int i = 0; i < CHARS; i++) {
        dec[i] = false;
      }
      break;
  }
}

