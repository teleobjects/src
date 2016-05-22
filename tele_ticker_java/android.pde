// import android.os.Bundle;
// import android.content.Context;

// //import android.view.inputmethod.InputMethodManager;

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

// String targetDeviceAddress = "FB:57:53:9C:DF:10";
// String targetDeviceName = "Adafruit";
// BlepdroidDevice device;
// String deviceName = "";
// String deviceAddress = "";
// int deviceRssi = 0;

// ArrayList<String> bleBuffer;

// //final int BLE_PACKET_LENGHT=18;
// //final int TX_SPEED = 150;

// KetaiLocation location;
// KetaiAudioInput mic;

// WifiManager wifiManager;          // instance of the WifiManager for getting network details
// List<ScanResult> networks;        // list of ScanResult objects, parsed later

// ConnectivityManager connMgr;

// Vibrator vibe;    
// long vibeDuration = 5;
// long[] vibeList = { 0, 20, 20, 20, 20 };    

// //InputMethodManager imm;
// boolean keyTyped=false;
// boolean keyboard;

// ActivityManager activityManager; 

// public void onCreate(Bundle savedInstanceState) {
//   super.onCreate(savedInstanceState);
//   vibe = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
//   wifiManager = (WifiManager) getActivity().getSystemService(Context.WIFI_SERVICE);
//   connMgr  = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
//   activityManager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
//   //InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
// }

// void initComm() {
//   bluetooth = true;
//   bleBuffer = new ArrayList<String>();
//   updateWifi();
//   updateOnline();
// }

// void vibrate() {
//   vibe.vibrate(vibeDuration);
// }

// void terminateComm() {
// }

// void showKeyboard() {
//   keyboard = true;
// }

// void hideKeyboard() {
//   keyboard = false;
// }

// //void keyTyped() 
// //{
// //  keyTyped=true;
// //  println("key typed");
// //}

// void beginComm() {
//   if (device != null) {
//     Blepdroid.getInstance().scanDevices();
//   } else {
//     Blepdroid.getInstance().discoverServices(device);
//   }
// }

// void updateComm() {
//   if (location == null) {
//     try {
//       location = new KetaiLocation(this);
//       location. setUpdateRate(1000, 1);
//     } 
//     catch (Exception e) {
//       println("error");
//     }
//   }
//   if (!connecting && !connected) {
//     try {
//       Blepdroid.initialize(this);
//       connecting = true;
//     } 
//     catch (Exception e) {
//       println("error");
//     }
//   }


//   freeMemory = activityManager.getMemoryClass();
//   Runtime rt = Runtime.getRuntime();
//   maxMemory = rt.maxMemory() / 1048576;    // convert from bytes to MB

//   NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
//   if (networkInfo != null && networkInfo.isConnected()) {
//   } else {
//     online = false;
//     onlineState = "offline";
//   }
//   switch (wifiManager.getWifiState()) {
//   case 1: 
//     wifiState = "Wifi disabled"; 
//     wifi = false;
//     break;
//   case 3: 
//     wifiState = "Wifi enabled"; 
//     wifi = true;
//     online = true;
//     onlineState = "online";
//     break;
//   case 4: 
//     wifiState = "Wifi state unknown"; 
//     wifi = false; 
//     break;
//   default: 
//     wifiState = "Wifi state: " + wifiState;
//     wifi = false;
//   }
//   if (connected) {
//     if (bleBuffer.size() > 0 ) {
//       if (millis() - lastTx > TX_SPEED) {
//         Blepdroid.getInstance().writeCharacteristic(device, BLUEFRUIT_UART_TX, bleBuffer.get(0).getBytes());
//         if (debug) {
//           Packet newPacket = new Packet(false, "", getPilot(usb ? "usb" : "bluetooth").x);
//         }
//         bleBuffer.remove(0);
//         txR = int(millis() - lastTx);
//         lastTx = millis();
//       }
//     }
//   }
// }

// void tx(String str) {
//   while (true) {
//     bleBuffer.add(str.length() > BLE_PACKET_LENGHT ? str.substring(0, BLE_PACKET_LENGHT) : str);
//     if (str.length() > BLE_PACKET_LENGHT) {
//       str = str.substring(BLE_PACKET_LENGHT, str.length());
//     } else {
//       break;
//     }
//   }
// }

// void onCharacteristicChanged(BlepdroidDevice device_, String characteristic, byte[] data)
// {
//   for (int i=0; i<data.length; i++ ) {
//     data[i] -= 48;
//   }
//   lastRx = millis();
//   if (debug) {
//     Packet newPacket = new Packet(true, "", getPilot(usb ? "usb" : "bluetooth").x);
//   }
//   parseBytes(data);
// }

// void onDeviceDiscovered(BlepdroidDevice device_)
// {
//   //if (device.name != null && device.name.contains(targetDeviceName)) {
//   if (device_.name != null && device_.address.contains(targetDeviceAddress)) {
//     println("discovered target device " + device_.name + " address: " + device_.address + " rssi: " + device_.rssi );
//     deviceName = device_.name;
//     deviceAddress = device_.address;
//     deviceRssi = device_.rssi;
//     if (Blepdroid.getInstance().connectDevice(device_)) {
//       println("connected to "+device_.name);
//       portName = device_.name+"\n"+deviceAddress;
//       device = device_;
//     } else {
//       println("couldn't connect to "+device_.name);
//     }
//   }
// }

// void onServicesDiscovered(BlepdroidDevice device_, int status)
// {
//   Blepdroid.getInstance().setCharacteristicToListen(device_, BLUEFRUIT_UART_RX);
//   connected = true;
// }

// void onBluetoothRSSI(BlepdroidDevice device_, int rssi)
// {
//   //println(" onBluetoothRSSI " + device.address + " " + Integer.toString(rssi));
// }

// void onBluetoothConnection(BlepdroidDevice device_, int state)
// {
//   Blepdroid.getInstance().discoverServices(device);
//   //println("onBluetoothConnection "+device);
// }

// void onDescriptorWrite(BlepdroidDevice device, String characteristic, String data)
// {
//   //println("onDescriptorWrite " + characteristic + " " + data);
// }

// void onDescriptorRead(BlepdroidDevice device_, String characteristic, String data)
// {
//   //println(" onDescriptorRead " + characteristic + " " + data);
// }

// void onCharacteristicRead(BlepdroidDevice device_, String characteristic, byte[] data)
// {
//   //println("onCharacteristicRead " + characteristic + " " + data);
// }

// void onCharacteristicWrite(BlepdroidDevice device_, String characteristic, byte[] data)
// {
//   //println("onCharacteristicWrite " + characteristic + " " + data);
// }

// void onLocationEvent(double _latitude, double _longitude, double _altitude) {
//   try {
//     geolocation.located = true;
//     geolocation.updated = false;
//     geolocation.provider = location.getProvider();
//     geolocation.longitude = _longitude;
//     geolocation.latitude = _latitude;
//     geolocation.altitude = _altitude;
//   }
//   catch (Exception e) {
//     println("Exception "+e);
//   }
// }

// short[] micData;


// void onAudioEvent(short[] _micData)
// {
//   micData= _micData;
// }

// ///////////////
// // PLACE HOLDERS
// ///////////////

// class Eq {
//   char[] eqData;
//   float[] eqVal;
//   int res= 32;

//   float rightL;
//   float leftL;
//   float eqFilter = .2;

//   Eq( PApplet parent) {
//     mic = new KetaiAudioInput(parent);
//     eqData = new char[res];
//   }

//   void update() {
//     if (channel == EQ) {
//       if (!mic.isActive()) {
//         mic.start();
//       }
//       if (micData != null) {
//         pushMatrix();
//         stroke(redColor);
//         strokeWeight(4);
//         translate((width-1280)/2, 0);
//         scale(1.3, 0);
//         for (int i = 0; i < micData.length; i++) {
//           if (i != micData.length-1) {
//             line(i, map(micData[i], -32768, 32767, height, 0), i+1, map(micData[i+1], -32768, 32767, height, 0));
//           }
//         }
//         popMatrix();
//       }
//     } else {
//       if (mic.isActive()) {
//         mic.stop();
//       }
//     }
//   }

//   char[] getPage () {
//     return eqData;
//   }
// }

// void tx (byte[] data) {
// }

// void rx() {
// }

// void downloadByteArrayAsImage(String url, String fileName) {
// }