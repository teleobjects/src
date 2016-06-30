// import blepdroid.*;
// import blepdroid.BlepdroidDevice;

// UUID BLUEFRUIT_UART_SERVICE = UUID.fromString( "6E400001-B5A3-F393-E0A9-E50E24DCCA9E");
// UUID BLUEFRUIT_UART_TX = UUID.fromString("6E400002-B5A3-F393-E0A9-E50E24DCCA9E");
// UUID BLUEFRUIT_UART_RX = UUID.fromString("6E400003-B5A3-F393-E0A9-E50E24DCCA9E");

// class Bluetooth {
//   PApplet parent;

//   Bluetooth(PApplet _parent) {
//     parent = _parent;
//   }

//   boolean available;
//   boolean initialized;
//   boolean discovering;

//   void update() {
//     if (!initialized) {
//       try {
//         Blepdroid.initialize(parent);
//         initialized = true;
//         if (verbose) println("initalizing bluetooth");
//       } 
//       catch (Exception e) {
//         if (verbose) println("error initializing bluetooth");
//       }
//     } else {
//       for (Teleobject teleobject : teleobjects) {        
//         if (teleobject.comm != null && teleobject.comm.found && teleobject.comm.paired && !teleobject.comm.discovering && !teleobject.comm.discovered && !discovering) {
//           if (verbose) println("/////////////////////////////////////////////////////// discovering services for "+  teleobject.name);
//           teleobject.comm.discovering = true;
//           Blepdroid.getInstance().discoverServices(teleobject.comm.device);
//           discovering = true;
//         }
//       }
//     }
//   }

//   void scan() {
//     //if (verbose) println("/////////////////// scanning devices");
//     //Blepdroid.getInstance().scanDevices();
//     //for (Teleobject teleobject : teleobjects) {
//     //  if (teleobject.comm != null && teleobject.comm.device != null && teleobject.comm.paired) {
//     //    //Blepdroid.getInstance().connectDevice(teleobject.comm.device);
//     //  }
//     //}
//   }
  
//   void release() {
    
//   }
// }

// void onCharacteristicChanged(BlepdroidDevice device_, String characteristic, byte[] data)
// {
//   for (int i=0; i<data.length; i++ ) {
//     data[i] -= 48;
//   }
//   for (Teleobject teleobject : teleobjects) {
//     if (teleobject.comm != null && teleobject.comm.device != null && device_ == teleobject.comm.device) {
//       teleobject.comm.lastRx = millis();
//       if (debug) {
//         Packet newPacket = new Packet(true, "", getPilot("bluetooth").x);
//         newPacket.init();
//       }
//       teleobject.comm.parseBytes(data);
//     }
//   }
// }

// void onDeviceDiscovered(BlepdroidDevice device_)
// {
//   bluetooth.available = true;
//   for (Teleobject teleobject : teleobjects) {
//     if (teleobject.comm != null && device_.address.contains(teleobject.comm.targetDeviceAddress)) {
//       if (!teleobject.comm.found) {
//         println("/////////////////////////////////////////////////////// target device found "+teleobject.name);
//         teleobject.comm.deviceName = device_.name;
//         teleobject.comm.deviceAddress = device_.address;
//         teleobject.comm.deviceRssi = device_.rssi;
//         teleobject.comm.portName = teleobject.comm.deviceAddress;
//         teleobject.comm.device = device_;
//         teleobject.comm.found = true;
//         //if (!teleobject.comm.paired) {
//         if (Blepdroid.getInstance().connectDevice(device_)) { 
//           if (verbose) println("/////////////////////////////////////////////////////// pairing to "+ teleobject.name);
//         } else {
//           if (verbose) println("/////////////////////////////////////////////////////// couldn't pair to "+  teleobject.name);
//         }
//         //}
//       }
//     }
//   }
// }

// void onBluetoothConnection(BlepdroidDevice device_, int state)
// {
//   for (Teleobject teleobject : teleobjects) {
//     if (teleobject.comm != null && teleobject.comm.device !=  null && device_ == teleobject.comm.device) {
//       if (verbose) println("/////////////////////////////////////////////////////// paring successfull to "+  teleobject.name + " "+state);
//       teleobject.comm.paired = true;
//     }
//   }
// }

// void onBluetoothRSSI(BlepdroidDevice device_, int rssi)
// {
//   if (verbose) println("onBluetoothRSSI " + device_.address + " " + Integer.toString(rssi));
// }

// void onServicesDiscovered(BlepdroidDevice device_, int status)
// {
//   for (Teleobject teleobject : teleobjects) {
//     if (teleobject.comm != null && teleobject.comm.device != null && device_ == teleobject.comm.device && teleobject.comm.discovering) {
//       Blepdroid.getInstance().setCharacteristicToListen(device_, BLUEFRUIT_UART_RX);
//       teleobject.comm.discovering = false;
//       teleobject.comm.discovered = true;
//       teleobject.comm.connected = true;
//       teleobject.comm.connecting = true;
//       teleobject.comm.connectionTime = millis();          
//       bluetooth.discovering = false;
//       if (verbose) println("/////////////////////////////////////////////////////// connected to "+ teleobject.name + " " + status);
//     }
//   }
// }

// //void onDescriptorWrite(BlepdroidDevice device, String characteristic, String data)
// //{
// //  //println("onDescriptorWrite " + characteristic + " " + data);
// //}

// //void onDescriptorRead(BlepdroidDevice device_, String characteristic, String data)
// //{
// //  //println(" onDescriptorRead " + characteristic + " " + data);
// //}

// //void onCharacteristicRead(BlepdroidDevice device_, String characteristic, byte[] data)
// //{
// //  //println("onCharacteristicRead " + characteristic + " " + data);
// //}

// //void onCharacteristicWrite(BlepdroidDevice device_, String characteristic, byte[] data)
// //{
// //  //println("onCharacteristicWrite " + characteristic + " " + data);
// //}