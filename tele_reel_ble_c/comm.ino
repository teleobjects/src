void initComm() {
  if (!ble.begin(VERBOSE_MODE))
  {
    //    Serial.println("Couldn't start Bluetooth");
  }
  if (!ble.factoryReset() ) {
    //    Serial.println("Couldn't factory reset");
  }
  //  ble.info();
  ble.verbose(false);
  ble.echo(false);
}

void updateComm() {
  if (ble.isConnected()) {
    connected = true;
    connecting = false;
    if ( ble.isVersionAtLeast(MINIMUM_FIRMWARE_VERSION) ) {
      ble.sendCommandCheckOK("AT+HWModeLED=" MODE_LED_BEHAVIOUR);
    }
    //        ble.sendCommandCheckOK("AT+BLEPOWERLEVEL=4");
    ble.setMode(BLUEFRUIT_MODE_DATA);
  } else {
    connected = false;
  }
}

void tx() {
  if (millis() - lastTx > txSpeed) {
    responses ++;
    lastTx = millis();
    byteOut[0] = (byte)mode;
    byteOut[1] = 70;//(byte)(roll < 0 ? 1 : 2);
    byteOut[2] = 70;//(byte)(int)abs(roll);
    byteOut[3] = 70;//(byte)(pitch < 0 ? 1 : 2);
    byteOut[4] = 70;//(byte)(int)abs(pitch);
    byteOut[5] = 70;//(byte)(heading < 0 ? 1 : 2);
    byteOut[6] = 70;//(byte)(int)abs(heading);
    byteOut[7] = (byte)voltage - minBat;
    byteOut[8] = (byte)(charging ? 1 : 100);
    byteOut[9] = 70;//(byte)voltageBuffer[3];
    byteOut[10] = (byte)254;
    if (DEBUG) {
      Serial.write(byteOut, sizeof(byteOut));
    }
    if (connected) {
      for (int i = 0; i < PACKETOUT; i++) {
        charOut[i] = (char)byteOut[i] + 48;
      }
      charOut[PACKETOUT] = 0;
      ble.print(charOut);
    }
  }
}

void rx() {
  if (connected) {
    if (buffering && millis() - lastRx > timeOut) {
      buffering = false;
      charIndex = 0;
    }
    while (ble.available()) {
      char c = ble.read();
      if (c == '\n' || charIndex == BUF_SIZE) {
        data = "";
        for (int i = 0; i < charIndex; i++) {
          data += charIn[i];
        }
        charIndex = 0;
        parse();
        buffering = false;
        responses = 0;
      } else {
        lastRx = millis();
        buffering = true;
        charIn[charIndex] = c;
        charIndex ++;
      }
    }
  }
  if (DEBUG) {
    if (Serial.available() > 0) {
      data = Serial.readStringUntil('\n');
      parse();
      responses = 0;
    }
  }
}
