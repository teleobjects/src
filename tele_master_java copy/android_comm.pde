// class Comm {
//   String targetDeviceAddress; 

//   BlepdroidDevice device;

//   String deviceName = "";
//   String deviceAddress = "";
//   int deviceRssi = 0;
//   long lastRssi;

//   final int BLE_PACKET_LENGHT = 18;
//   final int TX_SPEED = 125;

//   boolean usb, bluetooth;

//   boolean connecting, connected, found, paired, discovering, discovered, acknowledged, greeted, busy;
//   boolean parsed;
//   long connectionTime;

//   String portName = "";
//   String portNumber;
//   long lastTx, lastRx;
//   int txR;
//   int rxR;
//   int txDelay; /// to sync screen emulator with teleobject....
//   int timeOuts = 0;

//   // PROTOCOL IN
//   int packetLength = 11;
//   boolean buffering;
//   byte[] buffer = new byte[packetLength];
//   int bufferIndex = 0;

//   // PROTOCOL OUT
//   int headerLength = 6;

//   // SENSOR

//   float ax, ay, az;
//   boolean shock;
//   int mm;
//   float battery;
//   int minBat = 320;
//   int maxBat = 425;
//   boolean charging;
//   int brightness = 15;

//   Comm (PApplet _parent, Teleobject _teleobject) {
//   }

//   void reset() {
//     //device = null;
//     connecting = false;
//     connected = false;
//     discovered = false;
//     discovering = false;
//     found = false;
//     acknowledged = false;
//   }

//   void init() {
//     bluetooth = true;
//     bleBuffer = new ArrayList<String>();
//   }

//   void update() {
//     tx();
//   }

//   void writeString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
//     if (connected) {
//       txDelay = (thisString.length()+headerLength)/BLE_PACKET_LENGHT*TX_SPEED;
//       String str = "";
//       str += char(thisMode+48);
//       str += char(tack+48);
//       str += char(teck+48);
//       str += char(tick+48);
//       str += char(tock+48);
//       str += char(tuck+48);
//       str += thisString + '\n';
//       addToTxBuffer(str);
//       busy = true;
//     }
//   }

//   ArrayList<String> bleBuffer;

//   void addToTxBuffer(String str) {
//     while (true) {
//       if (str.length() >= BLE_PACKET_LENGHT) {
//         bleBuffer.add(str.substring(0, BLE_PACKET_LENGHT));
//         str = str.substring(BLE_PACKET_LENGHT, str.length());
//       } else {
//         bleBuffer.add(str);
//         break;
//       }
//     }
//   }

//   void tx() {
//     if (bleBuffer.size() > 0 ) {
//       if (millis() - lastTx > TX_SPEED) {
//         Blepdroid.getInstance().writeCharacteristic(device, BLUEFRUIT_UART_TX, bleBuffer.get(0).getBytes());
//         bleBuffer.remove(0);
//         txR = int(millis() - lastTx);
//         lastTx = millis();
//         busy = true;
//         if (debug) {
//           Packet newPacket = new Packet(false, "", getPilot("bluetooth").x);
//           newPacket.init();
//         }
//       }
//     }
//   }

//   void rx(byte[] data) {
//     if (data.length == packetLength) {
//       parse(data);
//       buffering = false;
//     } else {
//       if (buffering) {
//         for (int i=0; i<data.length && bufferIndex < packetLength; i ++) {
//           buffer[bufferIndex] = data[i];
//           bufferIndex ++;
//         }
//         if (bufferIndex >= packetLength) parse(buffer);
//       } else {
//         if (verbose) println("buffering rx, received " + data.length + " bytes");        
//         buffering = true;
//         bufferIndex = 0;
//         buffer = new byte[packetLength];
//         for (int i=0; i<data.length && bufferIndex < packetLength; i ++) {
//           buffer[bufferIndex] = data[i];
//           bufferIndex ++;
//         }
//       }
//     }
//   }

//   void parse(byte[] data) {
//     acknowledged = true;
//     busy = false;
//     lastRx = millis();
//     mm = data[0]; 
//     ax = (data[2] < 0 ? 256 + data[2] : data[2]) * (data[1] == 1 ? -1 : 1);
//     ay = (data[4] < 0 ? 256 + data[4] : data[4]) * (data[3] == 1 ? -1 : 1);
//     az = (data[6] < 0 ? 256 + data[6] : data[6]) * (data[5] == 1 ? -1 : 1);
//     battery = ((data[7] < 0 ? 256 + data[7] : data[7]) + minBat)/100.0;
//     charging = (data[8] == 1);
//     brightness = data[9];
//     if (debug) {
//       Packet newPacket = new Packet(true, "", getPilot("bluetooth").x);
//       newPacket.init();
//     }
//     parsed = true;
//   }
// }   