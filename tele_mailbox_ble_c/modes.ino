
void parse() {
  mode = data[0] - 48;
  switch (mode) {
    case BLANK:
      if (gradient) {
        oled.fillGradient();
      } else {
        oled.fillScreen(background);
      }
      break;

    case REFRESH:
      foreground = WHITE;
      background = RED;
      printFont(5);
      break;

    case FOREGROUND:
      foreground = {data[1] - 48, data[2] - 48, data[3] - 48};
      break;
    case BACKGROUND:
      background =  {data[1] - 48, data[2] - 48, data[3] - 48};
      gradient = false;
      break;
    case FONT:
      printFont(data[1] - 48);
      break;
    case STRING:
      str = "";
      for (int i = PACKETIN; i < data.length(); i++) {
        str += data[i];
      }
      printString(str, data[1] - 48, data[2] - 48, data[3] - 48, data[4] - 48);
      break;
    case SYMBOL:
      break;

    case BITMAP:
      str = "";
      for (int i = 3; i < data.length(); i++) {
        str += data[i];
      }
      printBitmap(str, data[1] - 48, data[2] - 48);
      break;
    case CHARTABLE:
      printCharTable(true, data[2] - 48,  data[3] - 48,  data[4] - 48);
      break;
    case GRID:
      printGrid();
      break;
    case SERVO:
      switch (data[1] - 48) {
        case 0:
          printServo(servoMin);
          break;
        case 1:
          printServo(servoMax);
          break;
        case 2:
          printServo(servoMax - (data[2] - 48));
          delay((data[3] - 48) * 10);
          printServo(servoMax);
          break;
      }
      break;
    case DIRECTORY:
      str = "";
      for (int i = 1; i < data.length(); i++) {
        str += data[i];
      }
      printDirectory(str);
      break;
    case COPY_PIXELS:
      printPixels(data[1] - 48, data[2] - 48, data[3] - 48, data[4] - 48);
      break;
    case COPY_BYTES:
      Serial.readBytes((byte*)screen,  int((data[3] - 48) / 8) * data[4]);
      printBytes(data[1] - 48, data[2] - 48, data[3] - 48, data[4] - 48, data[5] == '1' ? true :  false);
      break;
    case COPY_GRADIENT:
      //      Serial.readBytes((byte*)screen, int(HEIGHT * 3 / 2));
      printGradient();
      break;
    case GRADIENT:
      oled.fillGradient();
  }
}

