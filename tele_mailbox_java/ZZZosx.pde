import processing.serial.*;

String portName = "";
Serial port;

void initComm() {
  println(Serial.list());
}

ArrayList<String> buffer;

void begin() {
  usb = true;
  busy = false;
  bluetooth = !usb;
  for (int i=0; i<Serial.list().length; i++) {
    if (Serial.list()[i].indexOf(usb ? "1411" : "teleobject") != -1) {
      portName = Serial.list()[i];
      println("connecting to "+portName);
      try {
        port = new Serial(this, portName, 115200);
        connecting = true;
        paired = true;
        println("connected to "+portName);
        break;
      } catch (Exception e) {
        println("could not connect to "+portName);
      }
    }
  }

  buffer = new ArrayList<String>();
}

void terminate() {
  port = null;
  connected = false;
  usb = false;
}



void rx() {
  if (connected) {
    if (port.available() > 0) {
      rxR = int(millis() - lastRx);
      lastRx = millis();
      println("RX "+millis() + port.read());  
      busy = false;
    }
  }
  
}

void writeString(String thisString) {
  buffer.add(thisString);  
}

void tx() {
  if (connected && !busy && buffer.size() > 0) {
    txString(buffer.get(0));
    buffer.remove(0);
    busy = true;
    // println("tx"+millis());
  }
}

void txString(String thisString) {
  byte[] dataOut = new byte[thisString.length()+1];
  for (int i=0; i<thisString.length(); i++) {
    dataOut[i] = (byte) thisString.charAt(i);
  }
  dataOut[thisString.length()] = '\n';
  txR = int(millis() - lastTx);
  lastTx = millis();
  port.write(dataOut);
}

//void rx() {
// if (connected) {
//   if (port.available() > 13  ) {
//     byte[] data = port.readBytesUntil(254);
//     rxR = int(millis() - lastRx);
//     lastRx = millis();
//     if (data != null) {A
//       parse(data);
//     }
//   }
// }
//}