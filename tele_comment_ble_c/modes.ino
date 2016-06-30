

void parse() {
  mode =  data[0] - 48;
  tack = data[1] - 48;
  teck = data[2] - 48;
  tick = data[3] - 48;
  tock = data[4] - 48;
  tuck = data[5] - 48;
  busy = false;
  switch (mode) {

    case BLANK:
      clearDisplay();
      updateDisplay();
      setTextSize(1);
      setTextFont(1);
      break;

    case FONT:
      setTextFont(tack);
      setTextSize(teck);
      break;

    case INSTANT:
      clearDisplay(tack);
      data = cleanString(data.substring(PACKETIN, data.length()));
      dis[tick] = data;
      printDisplay(data, tack, 0, 0);
      updateDisplay(tack);
      break;

    case CENTERED:
      clearDisplay(tack);
      data = cleanString(data.substring(PACKETIN, data.length()));
      dis[tick] = data;
      printDisplay(data, tack, 1000, 0);
      updateDisplay(tack);
      break;

    case SCROLL:
      clearDisplay(tack);
      data = cleanString(data.substring(PACKETIN, data.length()));
      scroll(data, tack, WIDTH, - textWidth(data), 0, tick);
      break;

    case SCROLL_CENTER_RIGHT:
      clearDisplay(tack);
      data = cleanString(data.substring(PACKETIN, data.length()));
      scroll(data, tack, WIDTH, (WIDTH - textWidth(data) + 1) / 2, 0, tick);
      break;

    case SCROLL_ALL_RIGHT:
      clearDisplay(tack);
      data = cleanString(data.substring(PACKETIN, data.length()));
      scroll(data, tack, WIDTH, -textWidth(data), 0, tick);
      break;

    case SCROLL_PUSH_RIGHT:
      clearDisplay(tack);
      data = cleanString(data.substring(PACKETIN, data.length()));
      scroll(data, tack, WIDTH, - textWidth(data), 0, tick);
      break;

    case TICKER:
      clearDisplay(tack);
      cursorX = 0;
      dis[tack] = "";
      data = cleanString(data.substring(PACKETIN, data.length()));
      busy = true;
      break;

    case WAIT:
      break;
  }
}

void play() {
  switch (mode) {
    case CLOCK:
      clock();
      break;
    case TICKER:
      if (busy && millis() > lastTick + tick) {
        lastTick = millis();
        if (data.length() > 0) {
          dis[tack] += data[0];
          cursorX += charWidth(data[0]);
          data = data.substring(1, data.length());
          if (cursorX > WIDTH || data.length() == 0) {
            busy = false;
          }
        }
      }
      clearDisplay(tack);
      printDisplay(dis[tack], tack, 0, 0);
      // CURSOR
      if (cursorX < WIDTH && cursorX >= 0) {
        if (millis() % 500 < 250) {
          setTextColor(LED_OFF);
        } else {
          setTextColor(LED_ON);
        }
        printDisplay("_", tack, cursorX, 0);
        setTextColor(LED_ON);
      }
      updateDisplay(tack);
      break;
    case RANDOM:
      random();
      delay(1);
      break;
    case BATTERY:
      batIndex = int(map(voltage, minBat, maxBat, 0, 10));
      clearDisplay();
      setTextFont(1);
      printDisplay(String(voltage) + "v", 1, 1000, 0);
      printDisplay(String(batIndex) + "0%", 0, 1000, 0);
      updateDisplay();
      break;
    case ALPHABET:
      alphabet();
      break;

  }

}


void alphabet() {
  String str = "";
  for (int i = 32; i < 200; i++) {
    str += char(i);
  }

  clearDisplay(0);
  scroll(str, 0, WIDTH, -textWidth(str), 0, 5);
}

void random() {
  String str;
  for (int i = 0; i < 20; i++) {
    str += char((byte)(48 + random(10)));
  }
  clearDisplay();
  printDisplay(str, 0, 0, 0);
  str = "";
  for (int i = 0; i < 20; i++) {
    str += char((byte)(48 + random(10)));
  }
  printDisplay(str, 1, 0, 0);
  updateDisplay();
  delay(50);
}

void clock() {
  int v0 = 0;
  int v1 = -8;
  clearDisplay();
  setTextFont(0);
  setTextSize(2);
  //  printDouble("hello", 4, v0, v1);
  printDouble(String(char(tack)), 4, v0, v1);

  printDouble(String(char(teck)), 16, v0, v1);
  printDouble(String(char(tick)), 34, v0, v1);
  printDouble(String(char(tock)), 47, v0, v1);
  printDouble(millis() % 500 < 250 ? "." : " ", 24, v0, v1);
  updateDisplay();
}
