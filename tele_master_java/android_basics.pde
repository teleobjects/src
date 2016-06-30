// import android.os.Bundle;
// import android.os.BatteryManager;
// import android.os.Vibrator;

// import android.content.Context;
// import android.content.Intent;
// import android.content.IntentFilter;
// import android.content.Context;
// import android.content.BroadcastReceiver;

// import android.view.WindowManager;
// import android.view.inputmethod.InputMethodManager;

// import android.app.ActivityManager;

// import android.net.wifi.ScanResult;
// import android.net.wifi.WifiManager;
// import android.net.NetworkInfo;
// import android.net.ConnectivityManager;

// import ketai.sensors.*; 
// import ketai.ui.*;

// ActivityManager activityManager; 
// WindowManager windowManager;
// InputMethodManager inputMethodManager;
// WifiManager wifiManager;
// ConnectivityManager connectivityManager;

// // MEMORY
// float maxMemory = 0;  
// int freeMemory = 0;

// // KEYBOARD

// // boolean keyTyped=false;
// // boolean keyboard;

// public void onCreate(Bundle savedInstanceState) {
//   super.onCreate(savedInstanceState);
//   vibe = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
//   wifiManager = (WifiManager) getActivity().getSystemService(Context.WIFI_SERVICE);
//   connectivityManager  = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
//   activityManager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
//   inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//   getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
// }

// KetaiLocation location;
// KetaiAudioInput mic;
// Vibrator vibe; 

// class Sensors {
//   long vibeDuration = 5;
//   long[] vibeList = { 0, 20, 20, 20, 20 };    

//   PApplet parent;

//   Sensors(PApplet _parent) {
//     parent = _parent;
//   }

//   void update() {
//     if (location == null) {
//       try {
//         location = new KetaiLocation(parent);
//         location.setUpdateRate(5000, 5);
//       } 
//       catch (Exception e) {
//         if (verbose) println("error initializing location");
//       }
//     }
//   }

//   void updateMemory() {
//   }

//   void updateBattery() {
//   }

//   void vibrate() {
//     vibe.vibrate(vibeDuration);
//   }
// }

// void onLocationEvent(double _latitude, double _longitude, double _altitude) {
//   try {
//     if (geolocation != null) {
//       geolocation.located = true;
//       geolocation.updated = false;
//       geolocation.longitude = _longitude;
//       geolocation.latitude = _latitude;
//       geolocation.altitude = _altitude;
//       //geolocation.provider = location.getProvider();
//     }
//     Packet newPacket = new Packet(false, "", getPilot("location").x);
//     newPacket.init();
//   }
//   catch (Exception e) {
//     println("Exception "+e);
//   }
// }


// class Keyboard {
//   PApplet parent;
//   boolean keyboard;

//   Keyboard(PApplet _parent) {
//     parent = _parent;
//   }

//   void showKeyboard() {
//     KetaiKeyboard.toggle(parent);
//     keyboard = true;
//   }

//   void hideKeyboard() {
//     KetaiKeyboard.toggle(parent);
//     keyboard = false;
//   }
// }

// void keyTyped() 
// {
//   //keyTyped = true;
//   println("key typed");
// }


// ///////////////
// // MIC
// ///////////////



// class Eq {

//   short[] micData;

//   char[] eqData;
//   float[] eqVal;
//   int res= 32;

//   float rightL;
//   float leftL;
//   float eqFilter = .2;

//   Eq( PApplet parent) {
//     mic = new KetaiAudioInput(parent);
//     eqData = new char[res];
//     startMic();
//   }

//   void update() {
//     //if (manager.channel == EQ) {
//     if (micData != null) {
//       pushMatrix();
//       stroke(redColor);
//       strokeWeight(4);
//       translate((width-1280)/2, 0);
//       scale(1.3, 0);
//       for (int i = 0; i < micData.length; i++) {
//         if (i != micData.length-1) {
//           line(i, map(micData[i], -32768, 32767, height, 0), i+1, map(micData[i+1], -32768, 32767, height, 0));
//         }
//       }
//       popMatrix();
//     }
//   } else {

//   //}

//   void startMic() {
//     if (!mic.isActive()) {
//       mic.start();
//     }
//   }

//   void stopMic() {
//     if (mic.isActive()) {
//       mic.stop();
//     }
//   }
// }

// void onAudioEvent(short[] _micData)
// {
//   eq.micData= _micData;
// }


// void downloadByteArrayAsImage(String url, String fileName) {
// }