void battery() {
  if (millis() - lastBattery > 1000 || lastCharging != charging) {
    lastBattery = millis();
    float measuredvbat = analogRead(BAT_PIN);
    charging = !digitalRead(CHARGE_PIN);
    measuredvbat *= 2;
    measuredvbat *= 3.3;
    measuredvbat /= 1024;
    voltage = (int)(measuredvbat * 100);
    if (charging != lastCharging) tx();
    lastCharging = charging;
    //    dtostrf(measuredvbat, 3, 2, voltageBuffer);  // float, width, precision, buffer
  }
}

//char *dtostrf (double val, signed char width, unsigned char prec, char *sout) {
//  char fmt[20];
//  sprintf(fmt, "%%%d.%df", width, prec);
//  sprintf(sout, fmt, val);
//  return sout;
//}
