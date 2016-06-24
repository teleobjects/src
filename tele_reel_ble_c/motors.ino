void initMotors() {
  AFMStop.begin(); // Start the top shield
  //  //  TWBR = ((F_CPU / 400000l) - 16) / 2;
  //  //  myMotorR->setSpeed(50);  // 10 rpm
  //  //  myMotorL->setSpeed(50);  // 10 rpm
  //

  //  stepperR.setSpeed(256.0);
  //  stepperL.setSpeed(256.0);

  stepperR.setSpeed(0);
  stepperL.setSpeed(0);

  stepperR.setMaxSpeed(200.0);
  stepperR.setAcceleration(200.0);
  stepperL.setMaxSpeed(200.0);
  stepperL.setAcceleration(200.0);
}

void updateMotors() {
  stepperR.runSpeed();
  stepperL.runSpeed();
}

void stopMotors() {
  stepperR.setSpeed(0);
  stepperL.setSpeed(0);
}

void setMotors() {
  stepperL.setSpeed(lMax);
  stepperL.setMaxSpeed(lMax);
  stepperL.setAcceleration(lAcc);
  stepperL.moveTo( 100);
  stepperR.setSpeed(rMax);
  stepperR.setMaxSpeed(rMax);
  stepperR.setAcceleration(rAcc);
  stepperR.moveTo(100);
}

void randomMotors() {
  if (millis() - lastMotorTime > tick  * 100) {
    lastR = millis();
    int tempR = random(10);
    ampR = random(256);
    if (ampR > 150) ampR = 250;
    if (ampR < 30) ampR = 0;
    if (random(10) < 5)  {
      stepperR.setSpeed(ampR);
      stepperL.setSpeed(ampR);
      dir = true;

    } else {
      stepperR.setSpeed(-ampR);
      stepperL.setSpeed(-ampR);
      dir = false;
    }
    //    stepperR.move(10000);
    //    stepperL.move(10000);
  }
}

void battery() {
  if (millis() - lastBattery > 1000 || lastCharging != charging) {
    lastBattery = millis();
    float measuredvbat = analogRead(BAT_PIN);
    charging = !digitalRead(CHARGE_PIN);
    measuredvbat *= 2;    // we divided by 2, so multiply back
    measuredvbat *= 3.3;  // Multiply by 3.3V, our reference voltage
    measuredvbat /= 1024; // convert to voltage
    voltage = (int)(measuredvbat * 100);
    if (charging != lastCharging) tx();
    lastCharging = charging;
    //  dtostrf(measuredvbat, 3, 2, voltageBuffer);  // float, width, precision, buffer
  }
}

