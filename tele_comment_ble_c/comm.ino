void initComm() {
  if (!ble.begin(VERBOSE_MODE))
  {
    //    Serial.println("Couldn't start Bluetooth");
  }
  //  ble.echo(false);
  //  if (!ble.factoryReset() ) {
  //    Serial.println("Couldn't factory reset");
  //  }
  ble.info();
  ble.echo(false);
  ble.sendCommandCheckOK("AT+HWModeLED=" MODE_LED_BEHAVIOUR);
  //  ble.sendCommandCheckOK("AT+BLEPOWERLEVEL=4");
  //  while (!ble.isConnected()) {
  //    delay(100);
  //    Serial.print(".");
  //  }
  ble.setMode(BLUEFRUIT_MODE_DATA);
  connected = true;
}

//void updateComm() {
//  if (ble.isConnected() && connecting) {
//    connected = true;
//    connecting = false;
//      ble.sendCommandCheckOK("AT+HWModeLED=" MODE_LED_BEHAVIOUR);
//    ble.sendCommandCheckOK("AT+BLEPOWERLEVEL=4");
//    ble.setMode(BLUEFRUIT_MODE_DATA);
//  }
//}

void tx() {
  if (millis() - lastTx > txSpeed) {
    lastTx = millis();
    responses ++;
    byteOut[0] = (byte)mode;
    byteOut[1] = 70;
    byteOut[2] = 70;
    byteOut[3] = 70;
    byteOut[4] = 70;
    byteOut[5] = 70;
    byteOut[6] = 70;
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
    //    if (buffering && millis() - lastRx > timeOut) {
    //      buffering = false;
    //      data = "";
    //      responses = 0;
    //      busy = false;
    //      while (ble.available()) {
    //        ble.read(); // empty buffer
    //      }
    //    }
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
      data = Serial.readStringUntil('\n');
      parse();
      responses = 0;
    }

    //    if (Serial.available() > 0) {
    //      data = "";
    //    }
    //    while (Serial.available() > 0) {
    //      char c = Serial.read();
    //      if (c == '\n') { //  || data.length() > BUF_SIZE
    //        //        while (Serial.available() > 0) {
    //        //          Serial.read(); // to clean the remaining chars, check better option
    //        //        }
    //        parse();
    //        responses = 0;
    //      } else {
    //        lastRx = millis();
    //        data += c;
    //      }
    //    }
  }
}
