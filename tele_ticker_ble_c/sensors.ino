void initAccelerometer() {
  if (!lsm.begin())
  {
    while (1);
  }
  lsm.setupAccel(lsm.LSM9DS0_ACCELRANGE_2G);
  lsm.setupMag(lsm.LSM9DS0_MAGGAIN_2GAUSS);
  lsm.setupGyro(lsm.LSM9DS0_GYROSCALE_245DPS);
}

void accelerometer() {
  sensors_event_t accel, mag, gyro, temp;
  lsm.getEvent(&accel, &mag, &gyro, &temp);
  float const PI_F = 3.14159265F;
  roll = (float)atan2(accel.acceleration.y, accel.acceleration.z);
  if (accel.acceleration.y * sin(roll) + accel.acceleration.z * cos(roll) == 0) {
    pitch = accel.acceleration.x > 0 ? (PI_F / 2) : (-PI_F / 2);
  } else {
    pitch = (float)atan(-accel.acceleration.x / (accel.acceleration.y * sin(roll) + \
                        accel.acceleration.z * cos(roll)));
  }
  heading = (float)atan2(mag.magnetic.z * sin(roll) - mag.magnetic.y * cos(roll), \
                         mag.magnetic.x * cos(pitch) + \
                         mag.magnetic.y * sin(pitch) * sin(roll) + \
                         mag.magnetic.z * sin(pitch) * cos(roll));
  roll = int((roll - PI_F / 2) * 180 / PI_F); // correction !!
  pitch = int((pitch * 180 / PI_F) - 6.5); // correction !!
  heading = int(heading * 180 / PI_F);
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
    dtostrf(measuredvbat, 3, 2, voltageBuffer);  // float, width, precision, buffer
    if (charging != lastCharging) {
      lastTx = 0;
      tx();
    }
    lastCharging = charging;
  }
}


char *dtostrf (double val, signed char width, unsigned char prec, char *sout) {
  char fmt[20];
  sprintf(fmt, "%%%d.%df", width, prec);
  sprintf(sout, fmt, val);
  return sout;
}
