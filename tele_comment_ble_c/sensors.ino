void battery() {
  if (millis() - lastBattery > 1000 || lastCharging != charging) {
    lastBattery = millis();
    float measuredvbat = analogRead(BAT_PIN);
    charging = !digitalRead(CHARGE_PIN);
    measuredvbat *= 2;    // we divided by 2, so multiply back
    measuredvbat *= 3.3;  // Multiply by 3.3V, our reference voltage
    measuredvbat /= 1024; // convert to voltage
    voltage = (int)(measuredvbat * 100);
    if (charging != lastCharging) {
      lastTx = 0;
      tx();
    }
    lastCharging = charging;
  }
}

//char *dtostrf (double val, signed char width, unsigned char prec, char *sout) {
//  char fmt[4];
////  sprintf(fmt, "%%%d.%df", width, prec);
////  sprintf(sout, fmt, val);
//  return sout;
//}
