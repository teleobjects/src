// COMM
String portName = "";
long lastTx, lastRx;
int txR;
int rxR;

// PROTOCOL IN
int packetLength = 14;

// PROTOCOL OUT
int displayMode, tick, tock, tuck;
int headerLength = 5;

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


void writeString(String thisString, int thisMode, int tick, int tock, int tuck) {
  if (android) {
    String str = "";
    str += char(thisMode+48);
    str += char(tick+48);
    str += char(tock+48);
    str += char(tuck+48);
    str += "0";//char(packetOut+48);
    str += thisString + '\n';
    tx(str);
  } else {
    byte[] data = new byte[thisString.length()+headerLength+1];
    data[0] = (byte)(thisMode+48);
    data[1] = (byte)(tick+48);
    data[2] = (byte)(tock+48);
    data[3] = (byte)(tuck+48);
    data[4] = 0;
    for (int i=0; i < thisString.length(); i++) {  
      data[i+headerLength] = (byte)thisString.charAt(i);
    }
    data [data.length-1] = (byte)'\n';
    tx(data);
  }
  alpha.printString(thisString, thisMode, tick, tock, tuck);
  if (debug) {
    //println(thisMode+"   "+tick+"   "+tock+"   "+tuck+"   "+packetOut+" "+thisString);
  }
}

void parseBytes(byte[] data) {
  if (data.length >= packetLength-1) {
    mm = data[0];
    ax = ((data[1]-48)-180)*2;
    ay = ((data[2]-48)-180)*2;
    az = ((data[3]-48)-180)*2;
    shock = false;//data[7] == 1 ? true : false;
    battery = (data[8]-48)+((data[9]-48)/10.0)+((data[10]-48)/100.0);
    if (millis() - lastPage > tuck*100) { ///////////////    fix!!!
      busy = false;// data[11] == 1 ? true : false;
    }
    //println(data[8]+" "+data[9]+" "+data[10]);
    if (debug) {
      //println(" "+busy +" " +mm+" "+ax+" "+ay+" "+az+" "+shock+" "+battery);
      Packet newPacket = new Packet(true, busy ? "BUSY" : "FREE", getPilot(usb ? "usb" : "bluetooth").x);
    }
    //}
  }
}