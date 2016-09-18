void parse() {
  busy = false;
  if (mode == TICKER) deleteCursor = true;
  if (data[0] - 48 == PING) return;
  mode =  data[0] - 48;
  tack = data[1] - 48;
  teck = data[2] - 48;
  tick = data[3] - 48;
  tock = data[4] - 48;
  tuck = data[5] - 48;
  data = data.substring(PACKETIN, data.length());
  switch (mode) {
    case BLANK:
      if (tack < 2) {
        clearDisplay(tack);
        updateDisplay(tack);
        dis[tack] = "";
      } else {
        clearDisplay();
        updateDisplay();
        dis[0] = "";
        dis[1] = "";
      }
      setTextSize(1);
      setTextFont(1);
      setBrightness(1);
      break;

    case FONT:
      setTextFont(tack);
      setTextSize(teck);
      break;

    case INSTANT:
      clearDisplay(tack);
      printDisplay(data, textWidth(data, tack), tack, 0, 0);
      updateDisplay(tack);
      break;

    case CENTERED:
      //      data += char(0);
      if (tack > 1) {
        clearDisplay();
        int f = -1;
        int c = int(data.length() / 2);
        f = findFirstChar(data.substring(c, data.length()), ' ');
        if (f == -1) {
          f = findLastChar(data.substring(0, c), ' ');
        } else {
          f += c;
        }
        if (f != -1) {
          printCentered(data.substring(0, f), 0, 0);
          printCentered(data.substring(f + 1, data.length()), 1, 0);
        } else {
          printCentered(data, 0, 0);
        }
        updateDisplay();
      } else {
        clearDisplay(tack);
        printCentered(data, tack, 0);
        updateDisplay(tack);
      }

      break;

    case SCROLL_CENTER_RIGHT:
      dis[tack] = data;
      cursorX = (WIDTH - textWidth( dis[tack], tack)) / 2;
      scroll(dis[tack], tack, WIDTH, cursorX, 0, teck, tick);
      cursorX += textWidth(dis[tack], tack);
      break;

    case SCROLL_ALL_RIGHT:
      dis[tack] = data;
      cursorX = -textWidth( dis[tack], tack);
      scroll(dis[tack], tack, WIDTH, cursorX, 0, teck, tick);
      dis[tack] = "";
      cursorX = 0;
      break;

    case SCROLL_PUSH_RIGHT:
      if (dis[tack] == "") {
        dis[tack] = data;
        scroll(dis[tack], tack, WIDTH, 0, 0, teck, tick);
        cursorX = textWidth(dis[tack], tack);
      } else {
        int left = cursorX - textWidth(dis[tack], tack);
        int right = 0;
        while (right < WIDTH) {
          dis[tack] = dis[tack] + " ";
          right = left + textWidth(dis[tack], tack);
        }
        scroll(dis[tack] + data, tack, left, -textWidth(dis[tack], tack), 0, teck, tick);
        dis[tack] = data;
        cursorX = textWidth(dis[tack], tack);
      }
      break;

    case SCROLL_DOWN:
      scrollDown(data, teck);
      break;
    case BATTERY:
      clearDisplay(0);
      break;

    case TICKER:
      //      data += char(0);
      busy = true;
      cursorL = tack > 0 ? 1 : 0;
      if (cursorL == 0) {
        clearDisplay();
        dis[0] = "";
        dis[1] = "";
      }
      dis[cursorL] = "";
      cursorX = 0;
      cursorY = 0;
      breakX = 0;
      break;

    case SPECTRUM:
      busy = true;
      if (lastMode != mode) clearDisplay();
      showSpectrum();
      break;

    case CLOCK:
      for (int i = 0; i < 6; i++) {
        timer[i] = data[i] - 48;
      }
      if (teck > 0) {
        int hour = timer[0] * 10 + timer[1];
        postMeridiam = hour > 12;
        if (postMeridiam) {
          hour = hour - 12;
          timer[0] = int (hour / 10);;
          timer[1] = hour - (timer[0] * 10);
        }
      }
      for (int i = 0; i < 6; i++) {
        lastTimer[i] = timer[i];
      }
      nextTime = millis() + 1000;
      break;

    case BRIGHTNESS:
      brightness = tack;
      if (brightness > 15) brightness = 1;
      setBrightness(brightness);
      break;
    case WAIT:
      break;
  }
}

void play() {
  if (deleteCursor) {
    setTextColor(LED_OFF);
    printDisplay("_", 4, tcL, tcX, tcY); //
    setTextColor(LED_ON);
    deleteCursor = false;
    updateDisplay(tcL);
  }

  switch (mode) {
    case TICKER:
      if (busy && millis() > lastTick + tick && data.length() > 0) {
        lastTick = millis();
        if (breakX == -1) {
          scrollDoubleUp();
          breakX = 0;
        }
        if (breakX == -2) {
          cursorL = 1;
          deleteCursor = true;
          breakX = 0;
          break;
        }
        if (breakX == 0) {
          if (data[0] == ' ' && data.length() > 0) data = data.substring(1, data.length());
          int nextSpace = 0;
          int f = 0;
          breakX = WIDTH;
          while (true) {
            String nextBlock = data.substring(nextSpace, data.length());
            f = findFirstChar(nextBlock, ' ');
            if (f == -1) {
              if (textWidth(data, cursorL) < WIDTH) breakX = textWidth(data, cursorL);
              break;
            }
            nextSpace = nextSpace + f ;
            int nextX = textWidth(data.substring(0, nextSpace), cursorL);
            nextSpace ++;
            if (nextX >= WIDTH) break;
            breakX = nextX;
          }
        }

        dis[cursorL] += data[0];
        cursorX += charWidth(data[0], cursorL);
        tcX = cursorX;
        tcL = cursorL;
        tcY = 0;

        clearDisplay(cursorL);
        printDisplay(dis[cursorL], textWidth(dis[cursorL], cursorL), cursorL, 0, 0);

        if (cursorX > breakX && data.length() > 0 ) {
          lastTick = millis() + tock * 100;
          cursorX = 0;
          tcX -= textWidth(" ", tcL);
          if (cursorL == 0) {
            breakX = -2;
          } else {
            breakX = -1;
          }
        }
        data = data.substring(1, data.length());
        if (data.length() == 0) busy = false;
      }

      // CURSOR
      setTextColor(millis() % 500 < 250 ? 0 : 1);
      printDisplay("_", 4, tcL, tcX, tcY);
      setTextColor(LED_ON);
      updateDisplay(cursorL);
      break;

    case RANDOM:
      showRandom();
      break;

    case NOISE:
      showNoise();
      break;

    case COUNTER:
      showCounter();
      break;

    case ALPHABET:
      showAlphabet();
      break;

    case BATTERY:
      showBattery();
      break;

    case BRIGHTNESS:
      showBrightness();
      break;

    case CLOCK:
      showClock();
      break;
  }

  if (deleteCursor) {
    setTextColor(LED_OFF);
    printDisplay("_", 4, tcL, tcX, tcY); //
    setTextColor(LED_ON);
    deleteCursor = false;
    updateDisplay(tcL);
  }

}
