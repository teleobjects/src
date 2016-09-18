void initDisplay() {
  alpha0.begin(0x70, 0);
  alpha1.begin(0x71, 0);
  alpha2.begin(0x72, 0);
  alpha3.begin(0x73, 0);
  alpha4.begin(0x74, 0);
  alpha5.begin(0x75, 0);
  alpha6.begin(0x76, 0);
  alpha7.begin(0x77, 0);
}

void updateDisplay() {
  alpha0.writeDigitAscii(0, dis[28], dec[28]);
  alpha0.writeDigitAscii(1, dis[29], dec[29]);
  alpha0.writeDigitAscii(2, dis[30], dec[30]);
  alpha0.writeDigitAscii(3, dis[31], dec[31]);

  alpha1.writeDigitAscii(0, dis[24], dec[24]);
  alpha1.writeDigitAscii(1, dis[25], dec[25]);
  alpha1.writeDigitAscii(2, dis[26], dec[26]);
  alpha1.writeDigitAscii(3, dis[27], dec[27]);

  alpha2.writeDigitAscii(0, dis[20], dec[20]);
  alpha2.writeDigitAscii(1, dis[21], dec[21]);
  alpha2.writeDigitAscii(2, dis[22], dec[22]);
  alpha2.writeDigitAscii(3, dis[23], dec[23]);

  alpha4.writeDigitAscii(0, dis[16], dec[16]);
  alpha4.writeDigitAscii(1, dis[17], dec[17]);
  alpha4.writeDigitAscii(2, dis[18], dec[18]);
  alpha4.writeDigitAscii(3, dis[19], dec[19]);

  alpha3.writeDigitAscii(0, dis[12], dec[12]);
  alpha3.writeDigitAscii(1, dis[13], dec[13]);
  alpha3.writeDigitAscii(2, dis[14], dec[14]);
  alpha3.writeDigitAscii(3, dis[15], dec[15]);

  alpha5.writeDigitAscii(0, dis[8], dec[8]);
  alpha5.writeDigitAscii(1, dis[9], dec[9]);
  alpha5.writeDigitAscii(2, dis[10], dec[10]);
  alpha5.writeDigitAscii(3, dis[11], dec[11]);

  alpha6.writeDigitAscii(0, dis[4], dec[4]);
  alpha6.writeDigitAscii(1, dis[5], dec[5]);
  alpha6.writeDigitAscii(2, dis[6], dec[6]);
  alpha6.writeDigitAscii(3, dis[7], dec[7]);

  alpha7.writeDigitAscii(0, dis[0], dec[0]);
  alpha7.writeDigitAscii(1, dis[1], dec[1]);
  alpha7.writeDigitAscii(2, dis[2], dec[2]);
  alpha7.writeDigitAscii(3, dis[3], dec[3]);

  alpha0.writeDisplay();
  alpha1.writeDisplay();
  alpha2.writeDisplay();
  alpha3.writeDisplay();
  alpha4.writeDisplay();
  alpha5.writeDisplay();
  alpha6.writeDisplay();
  alpha7.writeDisplay();
}

void setBrightness(byte b) {
  alpha0.setBrightness(b);
  alpha1.setBrightness(b);
  alpha2.setBrightness(b);
  alpha3.setBrightness(b);
  alpha4.setBrightness(b);
  alpha5.setBrightness(b);
  alpha6.setBrightness(b);
  alpha7.setBrightness(b);
}

void clearDisplay() {
  //  memcpy(dis, ' ', CHARS);  ?????????? explore for speed...
  //  memcpy(dec, 0, 0);
  dis = "";
  for (int i = 0; i < CHARS; i++) {
    dis += ' ';
    dec[i] = false;
  }
  cursorX = 0;
}

void blinkDisplay(byte t, byte s) {
  String tmpDis = dis;
  clearDisplay();
  updateDisplay();
  delay(t);
  dis = tmpDis;
  updateDisplay();
  delay(s);
}

