void initComm() {
  if (!ble.begin(VERBOSE_MODE))
  {
    Serial.println("Couldn't start Bluetooth");
  }
  if (!ble.factoryReset() ) {
    Serial.println("Couldn't perform a factory reset");
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
    ble.sendCommandCheckOK("AT+BLEPOWERLEVEL=4");
    ble.setMode(BLUEFRUIT_MODE_DATA);
  } else {
    connected = false;
  }
}

void tx() {
  if (millis() - lastTx > txSpeed) {
    lastTx = millis();
    responses ++;
    byteOut[0] = (byte)mode;
    byteOut[1] = (byte)(roll < 0 ? 1 : 2);
    byteOut[2] = (byte)(int)abs(roll);
    byteOut[3] = (byte)(pitch < 0 ? 1 : 2);
    byteOut[4] = (byte)(int)abs(pitch);
    byteOut[5] = (byte)(heading < 0 ? 1 : 2);
    byteOut[6] = (byte)(int)abs(heading);
    byteOut[7] = (byte)voltage - minBat;
    byteOut[8] = (byte)(charging ? 1 : 100);
    byteOut[9] = (byte)brightness;
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
      data = "";
      responses = 0;
      busy = false;
      while (ble.available()) {
        ble.read(); // empty buffer
      }
    }
    if (ble.available() > 0 && !buffering) {
      data = "";
    }
    while (ble.available()) {
      char c = ble.read();
      if (c == '\n' || data.length() > BUF_SIZE) {
        while (ble.available()) {
          ble.read(); // empty buffer
        }
        parse();
        responses = 0;
        buffering = false;
      } else {
        lastRx = millis();
        buffering = true;
        data += c;
      }
    }
  }

  if (DEBUG) {
    if (Serial.available() > 0) {
      data = "";
    }
    while (Serial.available() > 0) {
      char c = Serial.read();
      if (c == '\n' || data.length() > BUF_SIZE) {
        //        while (Serial.available() > 0) {
        //          Serial.read(); // to clean the remaining chars, check better option
        //        }
        parse();
        responses = 0;
      } else {
        lastRx = millis();
        data += c;
      }
    }
  }
}
