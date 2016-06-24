void play() {
  switch (mode) {

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

    case SCROLL:
      if (busy) {
        if (millis() > lastTick + tick) {
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
              if (data.length() > 0) {
                if (data[0] == '.' && dis [CHARS - 2] != '.') {
                  dec[CHARS - 1] = true;
                  data = data.substring(1, data.length());
                  breakX --;
                }
              }
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
      clearDisplay();
      dis[ballX] = ballY == 0 ? 'o' : 30 ;
      //      ballX -= x;
      if (ballX < 0) ballX = 0;
      if (ballX > 31) ballX = 31;
      //      ballY += z;
      if (ballY < 0) ballY = 0;
      if (ballY > 1) ballY = 1;
      delay(tick);
      updateDisplay();
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
  }

}

void parse() {
  busy = false;

  if (data[0] - 48 == PING) return;

  mode = data[0] - 48;
  tack = data[1] - 48;
  teck = data[2] - 48;
  tick = data[3] - 48;
  tock = data[4] - 48;
  tuck = data[5] - 48;
  data = data.substring(PACKETIN, data.length());
  if (data.length() > 0 && data[data.length() - 1] == ' ') data = data.substring(0, data.length() - 1); // get rid of trailing space, hack!

  switch (mode) {
    case COUNTER:
      clearDisplay();
      break;
      
    case RAIN:
      clearDisplay();
      break;

    case SNOW:
      clearDisplay();
      break;

    case LOADING:
      clearDisplay();
      break;

    case COMPASS:
      clearDisplay();
      break;

    case BATTERY:
      clearDisplay();
      break;

    case BLANK:
      clearDisplay();
      updateDisplay();
      break;

    case BRIGHTNESS:
      brightness = tack;
      if (brightness > 15) brightness = 1;
      setBrightness(brightness);
      break;

    case LOOK:
      face = tack;
      faceClosed = teck;
      eyesX = 0;
      //      busy = true;
      //      awakeStart = millis();
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
      break;

    case STREAM:
      if (data.length() == CHARS) {
        for (int i = 0; i < CHARS; i++) {
          dis[i] = data[i];
          dec[i] = false;
        }
      }
      updateDisplay();
      busy = true;
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
      break;

    case TICKER:
      busy = true;
      breakX = 0;
      break;

    case SCROLL_ALL_RIGHT:
      busy = true;
      cursorX = 0;
      breakX = CHARS + data.length();
      mode = SCROLL;
      break;

    case SCROLL_CENTER_RIGHT:
      busy = true;
      cursorX = 0;
      breakX = ((CHARS - data.length()) / 2) + data.length();
      mode = SCROLL;
      break;

    case SCROLL_PUSH_RIGHT:
      busy = true;
      cursorX = 0;
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
      mode = SCROLL;
      break;

    case SCROLL_ALL_LEFT:
      busy = true;
      cursorX = 0;
      breakX = -CHARS - data.length();
      mode = SCROLL;
      break;

    case SCROLL_CENTER_LEFT:
      busy = true;
      cursorX = 0;
      breakX = -((CHARS - data.length()) / 2) - data.length();
      mode = SCROLL;
      break;

    case SCROLL_PUSH_LEFT:
      busy = true;
      cursorX = 0;
      firstX = 0;
      for (int i = 0; i < CHARS; i++) {
        if (dis[i] != ' ') break;
        firstX ++;
      }
      firstX = -(CHARS - firstX);
      breakX = -((CHARS - data.length()) / 2) - data.length();
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
      mode = SCROLL;
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

