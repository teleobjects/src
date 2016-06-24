void play() {
  switch (mode) {
    case INSTANT:
      if (millis() - lastMotorTime > tick * 100) {
        stopMotors();
        mode = STOP;
        busy = false;
      } else {
        busy = true;
        dotStrip();
        updateMotors();
      }
      break;
    case TICKER:
      pixelColors[7][0] = millis() % 500 < 250 ? brightness : 0;
      pixelColors[8][0] = millis() % 500 > 250 ? brightness : 0;
      break;

    case BATTERY:
      stopMotors();
      batIndex = int(map(voltage, minBat, maxBat, 0, 16));
      if (charging) {
        if (millis() > chargingNext) {
          clearDots();
          chargingNext = millis() + chargingSpeed;
          chargingX ++;
          if (chargingX >= batIndex) {
            chargingX = 0;
          }
          for (int i = 0; i < chargingX; i++ ) {
            pixelColors[i][0] =  brightness;
          }
        }
      } else {
        clearDots();
        for (int i = 0; i < batIndex - 1; i++ ) {
          pixelColors[i][0] =  brightness;
        }
        pixelColors[batIndex - 1][0] =   millis() % 500 < 250 ? brightness : 0;;
      }
      break;

    case RANDOM:
      dotStrip();
      randomMotors();
      updateMotors();

      break;
  }
}

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
      stopMotors();
      clearDots();
      break;
    case STOP:
      stopMotors();
      break;
    case INSTANT:
      busy = true;
      lastMotorTime = millis();
      if (teck > 25) teck = 25;
      if (tack == 1) {
        stepperR.setSpeed(teck * 10);
        stepperL.setSpeed(teck * 10);
        dir = true;
      } else {
        stepperR.setSpeed(-teck * 10);
        stepperL.setSpeed(-teck * 10);
        dir = false;
      }
      break;
    case TICKER:
      clearDots();
      stopMotors();
      break;
  }
}



