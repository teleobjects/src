//import processing.serial.*;

//Serial port;

//void initComm() {
//  println(Serial.list());
//}

//void beginComm() {
//  for (int i=0; i<Serial.list().length; i++) {
//    if (Serial.list()[i].indexOf(usb ? "usbmodem" : "teleobject") != -1) {
//      portName = Serial.list()[i];   
//      println("connecting to "+portName);
//      try {
//        port = new Serial(this, portName, 57600);
//        connecting = true;
//        connected = true;
//        paired = true;
//        println("connected to "+portName);
//        break;
//      } 
//      catch (Exception e) {
//        println("could not connect to "+portName);
//      }
//    }
//  }
//}

//void updateComm() {
//}

//void terminateComm() {
//  port = null;
//  connected = false;
//}

//void tx(byte[] data) {
//  if (connected) {
//    txR = int(millis() - lastTx);
//    lastTx = millis();
//    port.write(data);
//  }
//}

//void rx() {
//  if (connected) {
//    if (port.available() > 13  ) {
//      byte[] data = port.readBytesUntil(254);
//      rxR = int(millis() - lastRx);
//      lastRx = millis();
//      if (data != null) {
//        parseBytes(data);
//      }
//    }
//  }
//}

///////////////////
//// PLACE HOLDERS
///////////////////

//int location = -1;// = null;

//void connectBluetooth() {
//}

//void updateBluetooth() {
//}