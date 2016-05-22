// COMM

boolean usb, bluetooth, wifi, connecting, connected, online, loading;


String portName = "";
long lastTx, lastRx;
int txR;
int rxR;

// PROTOCOL IN
int packetLength = 11;

// PROTOCOL OUT
int displayMode, tick, tock, tuck;
int headerLength = 4;

// SENSOR
float sens = .5;
float ax, ay, az;
boolean shock, busy;
int mm;
float battery;

// MEMORY
float maxMemory = 0;  
int freeMemory = 0;

// STATES
String wifiState;   
String onlineState;

float tiltAngle = 3;

final int BLE_PACKET_LENGHT=18;
final int TX_SPEED = 200;

int txDelay;

String createString(String thisString, int thisMode, int thisTick, int thisTock, int thisTuck) {
  return thisMode+""+TAB+""+thisTick+""+TAB+""+thisTock+""+TAB+""+thisTuck+""+TAB+""+thisString;
}

void writeString(String thisString, int thisMode, int tick, int tock, int tuck) {
  // thisString = thisString.toUpperCase();
  if (android) {
    txDelay = int(thisString.length()/BLE_PACKET_LENGHT*TX_SPEED*1.2);
    String str = "";
    str += char(thisMode+48);
    str += char(tick+48);
    str += char(tock+48);
    str += char(tuck+48);
    str += thisString + '\n';
    tx(str);
  } else {
    txDelay = 0;
    byte[] data = new byte[thisString.length()+headerLength+1];
    data[0] = (byte)(thisMode+48);
    data[1] = (byte)(tick+48);
    data[2] = (byte)(tock+48);
    data[3] = (byte)(tuck+48);
    for (int i=0; i < thisString.length(); i++) {  
      data[i+headerLength] = (byte)thisString.charAt(i);
    }
    data [data.length-1] = (byte)'\n';
    tx(data);
  }
  alpha.printString(thisString, thisMode, tick, tock, tuck);
  if (sync) {
    messaging.sendDweetQuietly("content", thisString+"|"+thisMode+"|"+tick+"|"+tock+"|"+tuck);
  }
  if (debug) {
    //println(thisMode+"   "+tick+"   "+tock+"   "+tuck+"  "+thisString);
  }
}

void parseBytes(byte[] data) {
  if (data.length == packetLength) {
    mm = data[0];
    ax = data[2]*(data[1] == 1 ? -1 : 1);
    ay = data[4]*(data[3] == 1 ? -1 : 1);
    az = data[6]*(data[5] == 1 ? -1 : 1);
    battery = (data[7]-48)+((data[8]-48)/10.0)+((data[9]-48)/100.0);
    if (millis() - lastPage > tuck*100) { ///////////////    fix!!!
      busy = false;
    }
  }
}