void initAccelerometer() {
  if (!lsm.begin())
  {
    while (1);
  }
  lsm.setupAccel(lsm.LSM9DS0_ACCELRANGE_2G);
  lsm.setupMag(lsm.LSM9DS0_MAGGAIN_2GAUSS);
  lsm.setupGyro(lsm.LSM9DS0_GYROSCALE_245DPS);
}

void updateSensors() {
  if (millis() - lastSensors > 5000 || temperature == 0) {
    dec[0] = true;
    updateDisplay();
    lastSensors = millis();
    pressure = baro.getPressure();
    //    altitude = baro.getAltitude();
    temperature = baro.getTemperature();
    //  temperature2 = sht.readTemperature();
    humidity = sht.readHumidity();
  }
}

void initSensors() {
  if (!baro.begin()) {
    Serial.println("Couldnt find sensor");
  }
  if (!sht.begin(0x44)) {
    Serial.println("Couldn't find SHT31");
  }
}

void accelerometer() {
  if (millis() > lastAccelerometer + 100) {
    lastAccelerometer = millis();
    float pitch_ = pitch;
    float roll_ = roll;
    float heading_ = heading;
    sensors_event_t accel, mag, gyro, temp;
    lsm.getEvent(&accel, &mag, &gyro, &temp);
    float const PI_F = 3.14159265F;
    pitch = (float)atan2(accel.acceleration.y, accel.acceleration.z);
    if (accel.acceleration.y * sin(pitch) + accel.acceleration.z * cos(pitch) == 0) {
      roll = accel.acceleration.x > 0 ? (PI_F / 2) : (-PI_F / 2);
    } else {
      roll = (float)atan(-accel.acceleration.x / (accel.acceleration.y * sin(pitch) + \
                         accel.acceleration.z * cos(pitch)));
    }
    heading = (float)atan2(mag.magnetic.z * sin(pitch) - mag.magnetic.y * cos(pitch), \
                           mag.magnetic.x * cos(roll) + \
                           mag.magnetic.y * sin(roll) * sin(pitch) + \
                           mag.magnetic.z * sin(roll) * cos(pitch));
    roll = int(roll * 180 / PI_F);
    roll -= 7; // adjustment

    pitch = int(pitch * 180 / PI_F);
    if (pitch > 0) pitch = 180 - pitch;
    if (pitch < 0) pitch = -180 - pitch;
    heading = int(heading * 180 / PI_F);

    targetInertia = abs(roll_ - roll) + abs(pitch_ - pitch) + abs(heading_ - heading);
    inertia += (targetInertia - inertia) * .25;


    //  targetInertiaRoll = (roll_ - roll);
    //    inertiaRoll += (roll - inertiaRoll) * .5;
    //    targetInertiaPitch = abs(pitch_ - pitch);
    //    inertiaPitch += (targetInertiaPitch - inertiaPitch) * .5;
  }
}

//void accelerometer() {
//  if (millis() > lastAccelerometer + 100) {
//    lastAccelerometer = millis();
//    float pitch_ = pitch;
//    float roll_ = roll;
//    float heading_ = heading;
//
//    sensors_vec_t   orientation;
//    if (ahrs.getOrientation(&orientation))
//    {
//      pitch = orientation.pitch;
//      roll = orientation.roll;
//      heading = orientation.heading;
//    }
//
//
//    targetInertia = abs(roll_ - roll) + abs(pitch_ - pitch) + abs(heading_ - heading);
//    inertia += (targetInertia - inertia) * .25;
//
//    //  targetInertiaRoll = (roll_ - roll);
//    //    inertiaRoll += (roll - inertiaRoll) * .5;
//    //    targetInertiaPitch = abs(pitch_ - pitch);
//    //    inertiaPitch += (targetInertiaPitch - inertiaPitch) * .5;
//  }
//}

void battery() {
  if (millis() - lastBattery > 1000 || lastCharging != charging) {
    lastBattery = millis();
    float measuredvbat = analogRead(BAT_PIN);
    charging = !digitalRead(CHARGE_PIN);
    measuredvbat *= 2;    // we divided by 2, so multiply back
    measuredvbat *= 3.3;  // Multiply by 3.3V, our reference voltage
    measuredvbat /= 1024; // convert to voltage
    voltage = (int)(measuredvbat * 100);
    //    dtostrf(measuredvbat, 3, 2, voltageBuffer);  // float, width, precision, buffer
    if (charging != lastCharging) {
      lastTx = 0;
      tx();
    }
    if (lastVoltage != voltage && mode == BATTERY) {
      lastTx = 0;
      tx();
    }
    lastCharging = charging;
    lastVoltage = voltage;
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

//
//char *dtostrf (double val, signed char width, unsigned char prec, char *sout) {
//  char fmt[20];
//  sprintf(fmt, " % % % d. % df", width, prec);
//  sprintf(sout, fmt, val);
//  return sout;
//}
