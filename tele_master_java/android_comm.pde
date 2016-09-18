class Comm {
  String targetDeviceAddress; 

  BlepdroidDevice device;

  String deviceName = "";
  String deviceAddress = "";
  int deviceRssi = 0;
  long lastRssi;

  final int BLE_PACKET_LENGHT = 18;
  final int TX_SPEED = 1;

  boolean usb, bluetooth;

  boolean connecting, connected, found, paired, discovering, discovered, acknowledged, greeted, busy;
  boolean parsed;
  long connectionTime;

  String portName = "";
  String portNumber;
  long lastTx, lastRx;
  int txR;
  int rxR;
  int txDelay; /// to sync screen emulator with teleobject....
  int timeOuts = 0;

  // PROTOCOL IN
  int packetLength = 15;
  boolean buffering;
  byte[] buffer = new byte[packetLength];
  int bufferIndex = 0;

  // PROTOCOL OUT
  int headerLength = 7;

  // SENSOR

  float ax, ay, az;
  boolean shock;
  int mm;
  float battery;
  int minBat = 320;
  int maxBat = 425;
  boolean charging;
  int brightness = 15;

  int temperature;
  int pressure;
  int humidity;

  Comm (PApplet _parent, Teleobject _teleobject) {
  }

  void reset() {
    //device = null;
    connecting = false;
    connected = false;
    discovered = false;
    discovering = false;
    found = false;
    acknowledged = false;
  }

  void init() {
    bluetooth = true;
    bleBuffer = new ArrayList<String>();
  }

  void update() {
    tx();
  }

  void writeString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
    if (connected) {
      txDelay = (thisString.length()+headerLength)/BLE_PACKET_LENGHT*TX_SPEED;
      String str = "";
      str += '@';
      str += char(thisMode+48);
      str += char(tack+48);
      str += char(teck+48);
      str += char(tick+48);
      str += char(tock+48);
      str += char(tuck+48);
      str += thisString + '\n';
      addToTxBuffer(str);
      busy = true;
    }
  }

  ArrayList<String> bleBuffer;

  void addToTxBuffer(String str) {
    while (true) {
      if (str.length() >= BLE_PACKET_LENGHT) {
        bleBuffer.add(str.substring(0, BLE_PACKET_LENGHT));
        str = str.substring(BLE_PACKET_LENGHT, str.length());
      } else {
        bleBuffer.add(str);
        break;
      }
    }
  }

  void tx() {
    if (bleBuffer.size() > 0 ) {
      if (millis() - lastTx > TX_SPEED) {
        Blepdroid.getInstance().writeCharacteristic(device, BLUEFRUIT_UART_TX, bleBuffer.get(0).getBytes());
        bleBuffer.remove(0);
        txR = int(millis() - lastTx);
        lastTx = millis();
        busy = true;
        if (debug) {
          Packet newPacket = new Packet(false, "", getPilot("bluetooth").x);
          newPacket.init();
        }
      }
    }
  }

  void rx(byte[] data) {
    if (buffering) {
      println("buffering rx");
      for (int i=0; i<data.length && bufferIndex < packetLength; i ++) {
        buffer[bufferIndex] = data[i];
        bufferIndex ++;
        if (bufferIndex == packetLength) {
          parse(buffer);
          buffering = false;
          bufferIndex = 0;
        }
      }
    } else {
      if (data[0] == '@') {
        buffering = true;
        bufferIndex = 0;
        buffer = new byte[packetLength];
      }
      for (int i=0; i < data.length; i ++) {
        if (buffering) {
          buffer[bufferIndex] = data[i];
          bufferIndex ++;
          if (bufferIndex == packetLength) {
            parse(buffer);
            buffering = false;
            bufferIndex = 0;
          }
        }
      }
    }
  }

  void parse(byte[] data) {
    acknowledged = true;
    busy = false;
    mm = data[1];
    ax = int(data[3] > 0 ? data[3]-1 : 256+data[3])*(data[2] == 1 ? -1 : 1);
    ay = int(data[5] > 0 ? data[5]-1 : 256+data[5])*(data[4] == 1 ? -1 : 1);
    az = int(data[7] > 0 ? data[7]-1 : 256+data[7])*(data[6] == 1 ? -1 : 1);
    //battery = ((data[8] < 0 ? 256 + data[8] : data[8]) + minBat)/100.0;
    //ax = data[3]*(data[2] == 1 ? -1 : 1);
    //ay = data[5]*(data[4] == 1 ? -1 : 1);
    //az = data[7]*(data[6] == 1 ? -1 : 1);
    battery = (data[8] + minBat)/100.0;
    charging = (data[9] == 1);
    brightness = data[10];
    pressure = data[11]+1000;
    temperature = data[12]-50;
    humidity = data[13];
    busy = false;
    parsed = true;  
    if (debug) {
      Packet newPacket = new Packet(true, "", getPilot("bluetooth").x);
      newPacket.init();
    }
  }
}   