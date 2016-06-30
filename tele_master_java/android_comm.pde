// class Comm {
//   String targetDeviceAddress; 

//   BlepdroidDevice device;

//   String deviceName = "";
//   String deviceAddress = "";
//   int deviceRssi = 0;

//   final int BLE_PACKET_LENGHT = 18;
//   final int TX_SPEED = 100;

//   boolean usb, bluetooth;

//   boolean connecting, connected, found, paired, discovering, discovered, acknowledged, busy;

//   String portName = "";
//   String name = "";
//   String portNumber;
//   long lastTx, lastRx;
//   int txR;
//   int rxR;
//   int txDelay; /// to sync simulator....

//   long connectionTime; // check when is set
//   int timeOuts = 0;

//   // PROTOCOL IN
//   int packetLength = 11;

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
//   int brightness;

//   Comm (PApplet _parent) {
//   }

//   void reset() {
//     device = null;
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
//     //txDelay = int(thisString.length()/BLE_PACKET_LENGHT*TX_SPEED*1.2);
//     String str = "";
//     str += char(thisMode+48);
//     str += char(tack+48);
//     str += char(teck+48);
//     str += char(tick+48);
//     str += char(tock+48);
//     str += char(tuck+48);
//     str += thisString + '\n';
//     addToTxBuffer(str);
//     busy = true;
//     if (debug) {
//       println(name+"|"+thisMode+"|"+tack+"|"+teck+"|"+tick+"|"+tock+"|"+tuck+"|"+thisString);
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
//     if (connected) {
//       if (bleBuffer.size() > 0 ) {
//         if (millis() - lastTx > TX_SPEED) {
//           //bluetooth.write(
//           Blepdroid.getInstance().writeCharacteristic(device, BLUEFRUIT_UART_TX, bleBuffer.get(0).getBytes());
//           if (debug) {
//             Packet newPacket = new Packet(false, "", getPilot("bluetooth").x);
//             newPacket.init();
//           }
//           bleBuffer.remove(0);
//           txR = int(millis() - lastTx);
//           lastTx = millis();
//           busy = true;
//         }
//       }
//     }
//   }

//   void parseBytes(byte[] data) {
//     acknowledged = true;
//     if (data.length == packetLength) {
//       mm = data[0];
//       ax = data[2]*(data[1] == 1 ? -1 : 1);
//       ay = data[4]*(data[3] == 1 ? -1 : 1);
//       az = data[6]*(data[5] == 1 ? -1 : 1);
//       battery = (data[7]+320.0)/100.0;
//       charging = (data[8] == 1);
//       brightness = data[9];
//       busy = false;
//     }
//   }
// }