// import android.os.Bundle;
// import android.content.Context;

// import blepdroid.*;
// import blepdroid.BlepdroidDevice;
// import java.util.UUID;

// import android.net.wifi.ScanResult;     // required import for scanning networks
// import android.net.wifi.WifiManager;    // required imports for wifi
// import java.util.List;                  // Java import for lists

// import android.net.ConnectivityManager;
// import android.net.NetworkInfo;

// import android.os.Vibrator;
// import ketai.sensors.*; 

// import android.app.ActivityManager;  // required import for "nice" memory
// import java.lang.Runtime;            // required import for max memory

// public static UUID BLUEFRUIT_UART_SERVICE = UUID.fromString( "6E400001-B5A3-F393-E0A9-E50E24DCCA9E");
// public static UUID BLUEFRUIT_UART_TX = UUID.fromString("6E400002-B5A3-F393-E0A9-E50E24DCCA9E");
// public static UUID BLUEFRUIT_UART_RX = UUID.fromString("6E400003-B5A3-F393-E0A9-E50E24DCCA9E");

// KetaiLocation location;
// KetaiAudioInput mic;

// WifiManager wifiManager;          // instance of the WifiManager for getting network details
// List<ScanResult> networks;        // list of ScanResult objects, parsed later

// ConnectivityManager connMgr;

// Vibrator vibe;    
// long vibeDuration = 5;
// long[] vibeList = { 0, 20, 20, 20, 20 };    

// // MEMORY
// float maxMemory = 0;  
// int freeMemory = 0;

// ActivityManager activityManager; 


// public void onCreate(Bundle savedInstanceState) {
//  super.onCreate(savedInstanceState);
//  vibe = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
//  wifiManager = (WifiManager) getActivity().getSystemService(Context.WIFI_SERVICE);
//  connMgr  = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
//  activityManager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
//  //InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
// }
// boolean bleConnecting;
// boolean discovering;
// void vibrate() {
//  vibe.vibrate(vibeDuration);
// }

// ///////////////
// // SENSORS
// ///////////////


// void updateSensors() {
//  if (!bleConnecting) {
//    try {
//      Blepdroid.initialize(this);
//      bleConnecting = true;
//    } 
//    catch (Exception e) {
//      println("error");
//    }
//  }

//  if (location == null) {
//    try {
//      location = new KetaiLocation(this);
//      location.setUpdateRate(1000, 1);
//    } 
//    catch (Exception e) {
//      println("error");
//    }
//  }
//  freeMemory = activityManager.getMemoryClass();
//  Runtime rt = Runtime.getRuntime();
//  maxMemory = rt.maxMemory() / 1048576;    // convert from bytes to MB
//  NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
//  if (networkInfo != null && networkInfo.isConnected()) {
//  } else {
//    network.online = false;
//    network.onlineState = "offline";
//  }
//  switch (wifiManager.getWifiState()) {
//  case 1: 
//    network.wifiState = "Wifi disabled"; 
//    network.wifi = false;
//    break;
//  case 3: 
//    network.wifiState = "Wifi enabled"; 
//    network.wifi = true;
//    network.online = true;
//    network.onlineState = "online";
//    break;
//  case 4: 
//    network.wifiState = "Wifi state unknown"; 
//    network.wifi = false; 
//    break;
//  default: 
//    network.wifiState = "Wifi state: " + network.wifiState;
//    network.wifi = false;
//  }
// }

// void onCharacteristicChanged(BlepdroidDevice device_, String characteristic, byte[] data)
// {
//  for (int i=0; i<data.length; i++ ) {
//    data[i] -= 48;
//  }
//  for (Teleobject teleobject : teleobjects) {
//    if (teleobject.comm != null) {
//      if (teleobject.comm.device != null) {
//        if ( device_ == teleobject.comm.device) {
//          teleobject.comm.lastRx = millis();
//          if (debug) {
//            Packet newPacket = new Packet(true, "", getPilot("bluetooth").x);
//          }
//          teleobject.comm.parseBytes(data);
//        }
//      }
//    }
//  }
// }

// void onDeviceDiscovered(BlepdroidDevice device_)
// {
//  for (Teleobject teleobject : teleobjects) {
//    if (teleobject.comm != null) {
//      if (device_.address.contains(teleobject.comm.targetDeviceAddress)) {
//        if (!teleobject.comm.connected) {
//          teleobject.comm.deviceName = device_.name;
//          teleobject.comm.deviceAddress = device_.address;
//          teleobject.comm.deviceRssi = device_.rssi;
//          if (Blepdroid.getInstance().connectDevice(device_)) {
//            println("/////////////////////////////////////////////////////// connecting to "+ teleobject.name);
//            teleobject.comm.portName = teleobject.comm.deviceAddress;
//            teleobject.comm.device = device_;
//            Blepdroid.getInstance().discoverServices(device_);
//            teleobject.comm.connecting = true;
//            //teleobject.comm.connected = true;
//          } else {
//            println("/////////////////////////////////////////////////////// couldn't connect to "+  teleobject.name);
//          }
//        }
//      }
//    }
//  }
// }

// void onServicesDiscovered(BlepdroidDevice device_, int status)
// {
//  for (Teleobject teleobject : teleobjects) {
//    if (teleobject.comm != null) {
//      if (teleobject.comm.device !=  null) {
//        if ( device_ == teleobject.comm.device && !teleobject.comm.connected) {
//          Blepdroid.getInstance().setCharacteristicToListen(device_, BLUEFRUIT_UART_RX);
//          teleobject.comm.connected = true;
//          teleobject.comm.connectionTime = millis();          
//          println("/////////////////////////////////////////////////////// connected to "+ teleobject.name);
//          discovering = false;
//        }
//      }
//    }
//  }
// }

// void onBluetoothRSSI(BlepdroidDevice device_, int rssi)
// {
//  println(" onBluetoothRSSI " + device_.address + " " + Integer.toString(rssi));
// }

// void onBluetoothConnection(BlepdroidDevice device_, int state)
// {
//  for (Teleobject teleobject : teleobjects) {
//    if (teleobject.comm != null) {
//      if (teleobject.comm.device !=  null) {
//        if ( device_ == teleobject.comm.device) {
//          println("/////////////////////////////////////////////////////// connection made "+  teleobject.name);
//          Blepdroid.getInstance().discoverServices(device_);
//        }
//      }
//    }
//  }
// }


// void onDescriptorWrite(BlepdroidDevice device, String characteristic, String data)
// {
//  //println("onDescriptorWrite " + characteristic + " " + data);
// }

// void onDescriptorRead(BlepdroidDevice device_, String characteristic, String data)
// {
//  //println(" onDescriptorRead " + characteristic + " " + data);
// }

// void onCharacteristicRead(BlepdroidDevice device_, String characteristic, byte[] data)
// {
//  //println("onCharacteristicRead " + characteristic + " " + data);
// }

// void onCharacteristicWrite(BlepdroidDevice device_, String characteristic, byte[] data)
// {
//  //println("onCharacteristicWrite " + characteristic + " " + data);
// }

// void onLocationEvent(double _latitude, double _longitude, double _altitude) {
//  try {
//    geolocation.located = true;
//    geolocation.updated = false;
//    geolocation.provider = location.getProvider();
//    geolocation.longitude = _longitude;
//    geolocation.latitude = _latitude;
//    geolocation.altitude = _altitude;
//  }
//  catch (Exception e) {
//    println("Exception "+e);
//  }
// }

// void   scanDevices() {
//  Blepdroid.getInstance().scanDevices();
// }    

// ///////////////
// // COMM
// ///////////////

// class Comm {
//  String targetDeviceAddress; 

//  BlepdroidDevice device;
//  String deviceName = "";
//  String deviceAddress = "";
//  int deviceRssi = 0;

//  final int BLE_PACKET_LENGHT = 18;
//  final int TX_SPEED = 150;

//  boolean usb, bluetooth, connecting, connected, busy;
//  String portName = "";
//  String portNumber;
//  long lastTx, lastRx;
//  int txR;
//  int rxR;
//  int txDelay;
//  long connectionTime;

//  // PROTOCOL IN
//  int packetLength = 11;

//  // PROTOCOL OUT
//  int headerLength = 4;

//  // SENSOR
//  float sens = .5;
//  float ax, ay, az;
//  boolean shock;
//  int mm;
//  float battery;
//  boolean charging;

//  Comm (PApplet _parent) {
//  }

//  void init() {
//    bluetooth = true;
//    bleBuffer = new ArrayList<String>();
//    //Blepdroid.getInstance().scanDevices();
//  }

//  void update() {
//    if (device != null && !connected && !discovering) {
//     Blepdroid.getInstance().discoverServices(device);
//     discovering = true;
//    }
//    tx();
//  }

//  void writeString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
//    //txDelay = int(thisString.length()/BLE_PACKET_LENGHT*TX_SPEED*1.2);
//    String str = "";
//    str += char(thisMode+48);
//    str += char(tack+48);
//    str += char(teck+48);
//    str += char(tick+48);
//    str += char(tock+48);
//    str += char(tuck+48);
//    str += thisString + '\n';
//    tx(str);
//  }

//  ArrayList<String> bleBuffer;

//  void tx(String str) {
//    while (true) {
//      bleBuffer.add(str.length() > BLE_PACKET_LENGHT ? str.substring(0, BLE_PACKET_LENGHT) : str);
//      if (str.length() > BLE_PACKET_LENGHT) {
//        str = str.substring(BLE_PACKET_LENGHT, str.length());
//      } else {
//        break;
//      }
//    }
//  }

//  void tx() {
//    if (connected) {
//      if (bleBuffer.size() > 0 ) {
//        if (millis() - lastTx > TX_SPEED) {// && millis() > globalLastTx + GLOBAL_TX_SPEED) {
//          Blepdroid.getInstance().writeCharacteristic(device, BLUEFRUIT_UART_TX, bleBuffer.get(0).getBytes());
//          if (debug) {
//            Packet newPacket = new Packet(false, "", getPilot("bluetooth").x);
//          }
//          bleBuffer.remove(0);
//          txR = int(millis() - lastTx);
//          lastTx = millis();
//          busy = true;
//        }
//      }
//    }
//  }

//  void parseBytes(byte[] data) {
//    if (data.length == packetLength) {
//      mm = data[0];
//      ax = data[2]*(data[1] == 1 ? -1 : 1);
//      ay = data[4]*(data[3] == 1 ? -1 : 1);
//      az = data[6]*(data[5] == 1 ? -1 : 1);
//      battery = (data[7]+320.0)/100.0;
//      charging = (data[8] == 1);
//      busy = false;
//    }
//  }
// }


// ///////////////
// // MIC
// ///////////////

// short[] micData;

// void onAudioEvent(short[] _micData)
// {
//  //println("audio event");
//  micData= _micData;
// }

// class Eq {
//  char[] eqData;
//  float[] eqVal;
//  int res= 32;

//  float rightL;
//  float leftL;
//  float eqFilter = .2;

//  Eq( PApplet parent) {
//    mic = new KetaiAudioInput(parent);
//    eqData = new char[res];
//    //mic.start();
//  }

//  void update() {
//    //if (ticker.editor.channel == EQ) {
//    //if (!mic.isActive()) {
//    //  mic.start();
//    //}
//    //if (micData != null) {
//    //  pushMatrix();
//    //  stroke(redColor);
//    //  strokeWeight(4);
//    //  translate((width-1280)/2, 0);
//    //  scale(1.3, 0);
//    //  for (int i = 0; i < micData.length; i++) {
//    //    if (i != micData.length-1) {
//    //      line(i, map(micData[i], -32768, 32767, height, 0), i+1, map(micData[i+1], -32768, 32767, height, 0));
//    //    }
//    //  }
//    //  popMatrix();
//    //}
//    //} else {
//    //  if (mic.isActive()) {
//    //    mic.stop();
//    //  }
//  }
//  //
//  char[] getPage () {
//    return eqData;
//  }
// }

// //void tx (byte[] data) {
// //}

// //void rx() {
// //}

// void downloadByteArrayAsImage(String url, String fileName) {
// }