void initComm() {
  if (!ble.begin(VERBOSE_MODE))
  {
    Serial.println("Couldn't start Bluetooth");
  }
  if (!ble.factoryReset() ) {
    Serial.println("Couldn't perform a factory reset");
  }
  //  ble.info();
  //  ble.verbose(false);
  ble.echo(false);
}

void updateComm() {
  if (connecting) {
    if (ble.isConnected() ) {
      connected = true;
      connecting = false;
      ble.sendCommandCheckOK("AT+HWModeLED=" MODE_LED_BEHAVIOUR);
      ble.sendCommandCheckOK("AT+GAPDEVNAME=teleobject.ticker");
      ble.sendCommandCheckOK("AT+BLEPOWERLEVEL=4"); // 4 = highest power, -40 = lowest power
      ble.setMode(BLUEFRUIT_MODE_DATA);
    }
  }
}

void tx() {
  //  int ellapsed = millis() - lastTx;
  //  if (ellapsed < txSpeed) delay(txSpeed - lastTx);
  //  if (millis() - lastTx > txSpeed) {
  lastTx = millis();
  byteOut[0] = '@';
  byteOut[1] = mode;
  byteOut[2] =  (roll < 0 ? 1 : 2);
  byteOut[3] = abs(roll) + 1;
  byteOut[4] =  (pitch < 0 ? 1 : 2);
  byteOut[5] = abs(pitch) + 1;
  byteOut[6] = (heading < 0 ? 1 : 2);
  byteOut[7] = abs(heading) + 1;
  byteOut[8] = voltage - minBat;
  byteOut[9] = charging ? 1 : 2;
  byteOut[10] = brightness;
  byteOut[11] = (int(pressure / 100) - 1000);
  byteOut[12] = (int)temperature + 50;
  byteOut[13] = (int)humidity;
  byteOut[PACKETOUT - 1] = 254;
  if (connected) {
    for (int i = 0; i < PACKETOUT; i++) {
      charOut[i] = (char)byteOut[i];
    }
    charOut[PACKETOUT] = 0;
    ble.print(charOut);
  } else {
    if (DEBUG) {
      Serial.write(byteOut, sizeof(byteOut));
    }
  }
  //  }
}

void rx() {
  if (connected) {
    //    if (buffering && millis() - lastRx > timeOut) {
    //      buffering = false;
    //      data = "";
    //      lastRx = millis();
    //      error();
    //      delay(1000);
    //      tx();
    //    }
//    if (ble.available() && !buffering) ";
    while (ble.available()) {
      char c = ble.read();
      if (c == '\n' || data.length() > BUF_SIZE) {
        lastRx = millis();
        parse();
        buffering = false;
      } else if (c == '@') {
        buffering = true;
        data = "@";
      } else if (buffering) {
        data += c;
      }
    }
  } else {
    if (DEBUG) {
      if (Serial.available() > 0) {
        data = "";
      }
      while (Serial.available() > 0) {
        char c = Serial.read();
        if (data[0] == '@' && c == '\n') {
          lastRx = millis();
          parse();
        } else {
          data += c;
        }
      }
    }
  }
}
