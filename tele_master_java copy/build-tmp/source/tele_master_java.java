import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.Calendar; 
import java.io.File; 
import java.util.UUID; 
import java.util.List; 
import java.lang.Runtime; 
import java.net.InetAddress; 
import java.net.UnknownHostException; 
import com.temboo.core.*; 
import com.temboo.Library.Google.Spreadsheets.*; 
import com.temboo.Library.Google.OAuth.*; 
import com.temboo.Library.Google.Contacts.*; 
import com.temboo.Library.Utilities.XML.*; 
import com.temboo.Library.Utilities.JSON.*; 
import com.temboo.Library.Google.Calendar.*; 
import com.temboo.Library.Google.Plus.People.*; 
import com.temboo.Library.Twitter.OAuth.*; 
import com.temboo.Library.Twitter.Trends.*; 
import com.temboo.Library.Twitter.Users.*; 
import com.temboo.Library.Twitter.FriendsAndFollowers.*; 
import com.temboo.Library.Google.Gmailv2.Messages.*; 
import java.awt.image.BufferedImage; 
import java.io.ByteArrayInputStream; 
import java.io.ByteArrayOutputStream; 
import java.io.File; 
import java.io.IOException; 
import java.io.InputStream; 
import javax.imageio.ImageIO; 
import ddf.minim.*; 
import ddf.minim.*; 
import ddf.minim.effects.*; 
import processing.serial.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class tele_master_java extends PApplet {








 



 













TembooSession session;

boolean refresh = true;
boolean debug = false;
boolean verbose = true;
boolean metric = true;
boolean sync = false;
boolean retina = true;
boolean androidMode;

Gui gui;
Gestures gestures;
Credentials credentials;
Time time;
Manager manager;
Network network;
Bluetooth bluetooth;
Sensors sensors;
Keyboard keyboard;
Eq eq;
Geolocation geolocation;

Google google;
Profile profile;
GoogleContacts contacts;
GoogleCalendar calendar;
GoogleDrive drive;
GoogleMail mail;

Places places;
Weather weather;
News news;
Twitter twitter;
Messaging messaging;

Karaoke karaoke;
Player player;

Teleobject ticker;
Teleobject comment;
Teleobject mailbox;
Teleobject reel;
Teleobject frame;

Teleobject activeObject;

boolean real= true;

ArrayList<Teleobject> teleobjects;

float y, targetY;

public void setup() {
  // fullScreen(OPENGL);
  // orientation(LANDSCAPE);
  // androidMode = true;
  // hint(DISABLE_DEPTH_TEST);
  
  retina = displayDensity() == 2;
  // smooth();
   
  androidMode = false;

  credentials = new Credentials();
  time = new Time();
  keyboard = new Keyboard(this);
  eq = new Eq(this);
  network = new Network();
  bluetooth = new Bluetooth(this);
  geolocation = new Geolocation();
  sensors = new Sensors(this);
  weather = new Weather();
  places = new Places();
  messaging = new Messaging(); 
  gui = new Gui();
  gestures = new Gestures(this);

  google = new Google();
  profile = new Profile();
  mail = new GoogleMail();
  contacts = new GoogleContacts();
  calendar = new GoogleCalendar();
  drive = new GoogleDrive();
  news = new News();
  twitter = new Twitter();

  karaoke = new Karaoke();

  player = new Player(this);

  teleobjects = new ArrayList<Teleobject>();

  manager = new Manager();

  ticker = new Ticker(this);
  ticker.name = "ticker";
  ticker.init();

  //comment = new Comment(this);
  //comment.name= "comment";
  //comment.init();

  //mailbox = new Mailbox(this);
  //mailbox.name = "mailbox";
  //mailbox.init();

  //reel = new Reel(this);
  //reel.name = "reel";
  //reel.init();

  //frame = new Frame(this);
  //frame.name = "frame";
  //frame.init();

  teleobjects.add(ticker);
  //teleobjects.add(comment);
  //teleobjects.add(mailbox);
  //teleobjects.add(reel);
  //teleobjects.add(frame);
  activeObject = ticker;
}

public void draw() {
  if (google.authenticating || twitter.authenticating) {
    background(redColor);
    if (gestures.tapped) {
      gestures.tapped = false;
      if (google.authenticating) {
        google.login();
        manager.setChannel(GOOGLE);
      } else if (twitter.authenticating) {
        twitter.login();
        manager.setChannel(TWITTER);
      }
    }
  } else {
    background(real ? 255 : backgroundColor);
    time.update();
    manager.update(); 
    sensors.update();     
    bluetooth.update();
    //network.update();
    //weather.update();
    //keyboard.update();
    eq.update();
    gestures.update();
    // gui.update(); 

    if (activeObject == null) {
      ticker.update();
      //comment.update();
      //mailbox.update();
      //  reel.update();
      //  frame.update();
    } else {
      activeObject.update();
    }
    targetY = keyboard.keyboard ? 380 : 0;
    y = attract (y, targetY, .3f, 1);      
    if (y>0) background(backgroundColor, map(y, 0, 380, 0, 255));
    pushMatrix();
    if (activeObject == null) {
      translate(width/2, (height/2) - y);
      scale(androidMode ? .9f : .68f);
      ticker.display(-210, 120);
      //comment.display(-400, -200);
      //mailbox.display(-960, 108);
      //reel.display(750, 80);
      //frame.display(200, -218);
    } else {
      translate(width/2, (height/2) - y);
      scale(width/1220.0f);
      //scale(1.3);
      activeObject.display(0, -20);
    }
    popMatrix();
    eq.display();
    gui.update(); 

  }
}
// import android.os.Bundle;
// import android.os.BatteryManager;
// import android.os.Vibrator;
// import android.os.Environment;

// import android.content.Context;
// import android.content.res.AssetFileDescriptor;
// import android.content.Intent;
// import android.content.IntentFilter;
// import android.content.BroadcastReceiver;

// import android.app.ActivityManager;

// import android.view.*;
// import android.view.WindowManager;
// import android.view.inputmethod.InputMethodManager;
// import android.view.KeyEvent;
// import android.view.MotionEvent;

// import android.graphics.Rect;

// import android.media.MediaPlayer;
// import android.app.Activity;


// import android.net.NetworkInfo;
// import android.net.ConnectivityManager;
// import android.net.wifi.ScanResult;
// import android.net.wifi.WifiManager;
// import android.net.wifi.WifiInfo;

// import android.bluetooth.BluetoothAdapter;

// import ketai.sensors.*; 
// import ketai.ui.*;

// KetaiGesture gesture;
// KetaiLocation location;
// KetaiAudioInput mic;
// Vibrator vibe; 

// ActivityManager activityManager; 
// WindowManager windowManager;
// InputMethodManager inputMethodManager;
// WifiManager wifiManager;
// ConnectivityManager connectivityManager;
// BroadcastReceiver receiver;

// MediaPlayer mediaPlayer;
// Context context; 
// Activity act;
// AssetFileDescriptor afd;

// // MEMORY
// float maxMemory = 0;  
// int freeMemory = 0;

// // KEYBOARD

// public void onCreate(Bundle savedInstanceState) {
//   super.onCreate(savedInstanceState);
//   vibe = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
//   wifiManager = (WifiManager) getActivity().getSystemService(Context.WIFI_SERVICE);
//   connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
//   activityManager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
//   //inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//   getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

//   IntentFilter filter = new IntentFilter();
//   filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
//   filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");

//   receiver = new BroadcastReceiver() {
//     @Override
//       public void onReceive(Context context, Intent intent) {
//       if (verbose) println("network state changed");
//       if (network != null) {
//         network.update();
//       }
//     }
//   };
//   getActivity().registerReceiver(receiver, filter);

//   //getActivity().getWindow().getDecorView().findViewById(android.R.id.content).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//   //  public void onGlobalLayout() {
//   //    Rect r = new Rect();
//   //    getActivity().getWindow().getDecorView().findViewById(android.R.id.content).getWindowVisibleDisplayFrame(r);
//   //    int screenHeight = getActivity().getWindow().getDecorView().findViewById(android.R.id.content).getRootView().getHeight();
//   //    int keypadHeight = screenHeight - r.bottom;
//   //    if (keyboard !=  null) {
//   //      if (keypadHeight > screenHeight * 0.15) {
//   //        keyboard.keyboard = true;
//   //      } else {
//   //        keyboard.keyboard = false;
//   //        //View decorView = getActivity().getWindow().getDecorView();
//   //        //int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
//   //        //decorView.setSystemUiVisibility(uiOptions);
//   //      }
//   //    }
//   //  }
//   //}
//   //);
// }

// void onDestroy() {
//   super.onDestroy();
//   if (receiver != null) {
//     getActivity().unregisterReceiver(receiver);
//     receiver = null;
//   }
//   if (mediaPlayer !=null) {
//     mediaPlayer.release();
//     mediaPlayer = null;
//   }
//   if (verbose) println("on destroy teleobjects");
// }

// void onPause() {
//   super.onPause();
//   if (bluetooth != null) {
//     bluetooth.pause();
//   }
//   if (mediaPlayer !=null) {
//     mediaPlayer.release();
//     mediaPlayer = null;
//   }
//   if (verbose) println("on pause teleobjects");
// }

// void onResume() {
//   super.onResume();
//   if (bluetooth != null) {
//     bluetooth.resume();
//   }
//   if (verbose) println("on resume teleobjects");
// }

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
//       if (location != null && location.getProvider() != null) geolocation.provider = location.getProvider();
//     }
//     Packet newPacket = new Packet(false, "", getPilot("location").x);
//     newPacket.init();
//   }
//   catch (Exception e) {
//     println("Exception "+e);
//   }
// }

// class Gestures {
//   PApplet parent;
//   boolean tapped;
//   boolean doubleTapped;
//   boolean flicking;
//   boolean dragging;
//   long lastTap;
//   int debounce = 200;
//   float startX, startY;

//   Gestures(PApplet parent_) {
//     parent = parent_;
//     gesture = new KetaiGesture(parent);
//   }

//   void update() {
//     if (dragging) {
//       stroke(255, 0, 0);
//       line(startX, startY, mouseX, mouseY);
//     }
//   }
// }

// void onDoubleTap(float x, float y)
// {
//   //things.add(new Thing("DOUBLE", x, y));
// }

// void onTap(float x, float y)
// {
//   //things.add(new Thing("SINGLE", x, y));
// }

// void onLongPress(float x, float y)
// {
//   //things.add(new Thing("LONG", x, y));
// }

// void onFlick( float x, float y, float px, float py, float v)
// {
//   //things.add(new Thing("FLICK:"+v, x, y, px, py));
// }

// void onPinch(float x, float y, float d)
// {
//   //Size = constrain(Size+d, 10, 2000);
// }

// void onRotate(float x, float y, float ang)
// {
//   //Angle += ang;
// }

// void mousePressed() {
//   println(mouseX+" "+mouseY+" "+keyboard.keyboard);
//   if (millis() - gestures.lastTap > gestures.debounce) {
//     if (keyboard.keyboard) {
//       keyboard.hide();
//     } else {
//       gestures.lastTap = millis();
//       gestures.tapped = true;
//       gestures.dragging = true;
//       gestures.startX = mouseX;
//       gestures.startY = mouseY;
//     }
//   }
// }

// void mouseReleased() {
//   gestures.tapped = false;
//   gestures.dragging = false;
// }

// void mouseDragged()
// {
// }

// public boolean surfaceTouchEvent(MotionEvent event) {
//   super.surfaceTouchEvent(event);
//   return gesture.surfaceTouchEvent(event);
// }

// class Keyboard {
//   PApplet parent;
//   boolean keyboard, lastKeyboard;

//   Keyboard(PApplet _parent) {
//     parent = _parent;
//   }

//   void update() {
//     //if (!keyboard) {
//     //  getActivity().runOnUiThread(new Runnable() {
//     //    public void run() {
//     //      View decorView = getActivity().getWindow().getDecorView();
//     //      int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
//     //      decorView.setSystemUiVisibility(uiOptions);
//     //    }
//     //  }
//     //  );
//     //}
//   }

//   void show() {
//     if (!keyboard) {
//       KetaiKeyboard.toggle(parent);
//     }
//   }

//   void hide() {
//     if (keyboard) {
//       KetaiKeyboard.toggle(parent);
//     }
//   }
// }

// void keyPressed() {
//   if (keyboard.keyboard) {
//     if (key == CODED && keyCode == KeyEvent.KEYCODE_DEL) key = 8;
//     if (key == 10) key = 31;
//     if (activeObject != null) {
//       activeObject.pages.add(new Page(key+"", TYPE, 0, 0, 0, 0, 1));
//     }
//   }
// }

// ///////////////
// // MIC
// ///////////////

// class Eq {

//   short[] micData;

//   char[] eqData;
//   char[] eqDataNibble;
//   float[] eqVal;
//   int res= 32;

//   float rightL;
//   float leftL;
//   float eqFilter = .2;

//   float maxL = 1000;
//   float minL = 0;

//   Eq( PApplet parent) {
//     println("starting eq");
//     mic = new KetaiAudioInput(parent);
//     eqVal = new float[res];
//     eqData = new char[res];
//     //eqDataNibble = new char[res/4];
//     //startMic();
//   }

//   void update() {
//     if (!mic.isActive()) {
//       mic.start();
//     }

//     //if (manager.channel == EQ) {
//     //  startMic();
//     //} else {
//     //  stopMic();
//     //}

//     if (micData != null) {
//       rightL = 0;//abs(micData[0]);
//       leftL = 0;//abs(micData[micData.length-1]);
//       for (int i = 0; i < res; i++) {
//         //print(micData[int(micData.length/res*i)]);
//         //print("   ");
//         float targetLevel = micData[int(micData.length/res*i)];
//         if (targetLevel < maxL / 2) targetLevel += targetLevel/2; // adjust
//         eqVal[i] += (targetLevel-eqVal[i])*eqFilter;
//         eqData[i] = char((byte)map(abs(eqVal[i]), minL, maxL, 0, 7));
//         if (eqData[i] > 7) eqData[i] = 7;
//         if (eqData[i] < 0) eqData[i] = 0;
//         //print(char(eqData[i]+48));
//       }
//       //println();
//       //for (int i=0; i<res/4; i++) {
//       //  int a = int((eqData[(i*4)])/2 << 6);
//       //  int b = int((eqData[(i*4)+1])/2 << 4);
//       //  int c = int((eqData[(i*4)+2])/2 << 2);
//       //  int d = int((eqData[(i*4)+3])/2);
//       //  eqDataNibble[i] =  char(int(random(255)));//char(255-(a | b | c | d));
//       //  if (eqDataNibble[i] < 32) eqDataNibble[i] = 32;
//       //  //if (eqDataNibble[i] == '\n') eqDataNibble[i]++;
//       //  //if (eqDataNibble[i] == 0) eqDataNibble[i]++;
//       //}
//     }
//   }


//   void display() {
//     stroke(greenColor);
//     strokeWeight(2);
//     pushMatrix();
//     scale(displayWidth*1.0/micData.length*1.0, 1);
//     translate(0, 250);
//     for (int i = 0; i < micData.length; i++)
//     {
//       if (i != micData.length-1)
//         line(i, map(micData[i], -32768, 32767, height, 0), i+1, map(micData[i+1], -32768, 32767, height, 0));
//     }
//     popMatrix();
//   }

//   void startMic() {
//     //if (!mic.isActive()) {
//     // if (verbose) println("mic started");
//     //  mic.start();
//     //}
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

// //// PLAYER

// class Player {
//   PApplet parent;

//   Player(PApplet _parent) {
//     parent =_parent; 
//     act = parent.getActivity();
//     context = act.getApplicationContext();
//     //try {
//     //mediaPlayer = new MediaPlayer();
//     //afd = context.getAssets().openFd("daft punk - get lucky.mp3");
//     //if (verbose) println("Successfully loaded audio file");
//     //mediaPlayer.setDataSource(afd.getFileDescriptor());
//     //mediaPlayer.prepare();
//     //} 
//     //catch(IOException e) {
//     //  if (verbose) println("Audio file did not load");
//     //}
//     //mediaPlayer.start();
//   }

//   void play() {
//     mediaPlayer.start();
//   }

//   void stop() {
//     mediaPlayer.stop();
//   }
// }
// import blepdroid.*;
// import blepdroid.BlepdroidDevice;

// UUID BLUEFRUIT_UART_SERVICE = UUID.fromString( "6E400001-B5A3-F393-E0A9-E50E24DCCA9E");
// UUID BLUEFRUIT_UART_TX = UUID.fromString("6E400002-B5A3-F393-E0A9-E50E24DCCA9E");
// UUID BLUEFRUIT_UART_RX = UUID.fromString("6E400003-B5A3-F393-E0A9-E50E24DCCA9E");

// class Bluetooth {
//   PApplet parent;
//   BluetoothAdapter mBluetoothAdapter;

//   Bluetooth(PApplet _parent) {
//     parent = _parent;
//     mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//   }

//   boolean available;
//   boolean initialized;
//   boolean pairing;
//   boolean discovering;

//   void update() {
//     available = mBluetoothAdapter.isEnabled();
//     if (!available) {
//       BluetoothAdapter.getDefaultAdapter().enable();
//     } else {
//       if (!initialized) {
//         try {
//           Blepdroid.initialize(parent);
//           initialized = true;
//           if (verbose) println("initalizing bluetooth");
//         }
//         catch (Exception e) {
//           if (verbose) println("error initializing bluetooth");
//         }
//       } else {
//         connect();
//       }
//     }
//   }

//   void disconnect() {
//     if (verbose) println("disconnecting");
//     for (Teleobject teleobject : teleobjects) {      
//       teleobject.comm.device = null;
//       teleobject.comm.found = false;
//       teleobject.comm.paired = false;
//       teleobject.comm.discovered = false;
//       teleobject.comm.connected = false;
//       teleobject.comm.acknowledged = false;
//       teleobject.comm.busy = false;
//       teleobject.comm.deviceName = "";
//       teleobject.comm.deviceAddress = "";
//       teleobject.comm.deviceRssi = 0;
//     }
//     //available = false;
//     pairing = false;
//     discovering = false;
//   }    

//   void pause() {
//     disconnect();
//   }

//   void resume() {
//   }

//   void reconnect() {
//     if (verbose) println("reconnecting");
//     disconnect();
//     Blepdroid.getInstance().onPause();
//     Blepdroid.getInstance().onResume();
//     //scan();
//   }

//   void connect() {
//     for (Teleobject teleobject : teleobjects) {   
//       if (teleobject.comm != null && !teleobject.comm.connected) {
//         if (teleobject.comm.found) {
//           if (teleobject.comm.paired) {
//             if (teleobject.comm.discovered) {
//               //Blepdroid.getInstance().connectToService(BLUEFRUIT_UART_SERVICE); //not required, throws error ???
//               Blepdroid.getInstance().setCharacteristicToListen(teleobject.comm.device, BLUEFRUIT_UART_RX);
//               teleobject.comm.connected = true;
//               teleobject.comm.connecting = true;
//               teleobject.comm.connectionTime = millis();
//               discovering = false;
//               if (verbose) println("setting characteristic");
//             } else {
//               if (!discovering) {
//                 Blepdroid.getInstance().discoverServices(teleobject.comm.device);
//                 discovering = true;
//                 if (verbose) println("discovering services");
//               }
//             }
//           } else {
//             if (!pairing) {
//               Blepdroid.getInstance().connectDevice(teleobject.comm.device);
//               pairing = true;
//               if (verbose) println("connecting device");
//             }
//           }
//         } else { 
//           // not found, maybe scan again after 10 seconds... might drain battery ??? check ???
//         }
//       }
//     }

//     // rssi changes not implemented in current version of blepdroid
//     //if (teleobject.comm != null && teleobject.comm.connected) {
//     //  if (millis() > teleobject.comm.lastRssi + 5000) {
//     //    teleobject.comm.lastRssi = millis();
//     //    if (verbose) println("requesting rssi");
//     //    Blepdroid.getInstance().readRSSI(teleobject.comm.device);
//     //  }
//     //}
//   }

//   //void scan() {
//   //  Blepdroid.getInstance().scanDevices();
//   //}
// }

// void onCharacteristicChanged(BlepdroidDevice device_, String characteristic, byte[] data)
// {
//   for (Teleobject teleobject : teleobjects) {
//     if (teleobject.comm != null && teleobject.comm.device != null && device_ == teleobject.comm.device) {
//       teleobject.comm.rx(data);
//     }
//   }
// }

// void onDeviceDiscovered(BlepdroidDevice device_)
// {
//   for (Teleobject teleobject : teleobjects) {
//     if (teleobject.comm != null && device_.address.contains(teleobject.comm.targetDeviceAddress)) {
//       if (!teleobject.comm.found) {
//         //println("/////////////////////////////////////////////////////// target device found "+teleobject.name);
//         teleobject.comm.deviceName = device_.name;
//         teleobject.comm.deviceAddress = device_.address;
//         teleobject.comm.deviceRssi = device_.rssi;
//         teleobject.comm.portName = teleobject.comm.deviceAddress;
//         teleobject.comm.device = device_;
//         teleobject.comm.found = true;
//       }
//     }
//   }
// }

// void onBluetoothConnection(BlepdroidDevice device_, int state)
// {
//   for (Teleobject teleobject : teleobjects) {
//     if (teleobject.comm != null && teleobject.comm.device !=  null && device_ == teleobject.comm.device) {
//       //if (verbose) println("/////////////////////////////////////////////////////// paring successfull to "+  teleobject.name + " "+state);
//       teleobject.comm.paired = true;
//       bluetooth.pairing = false;
//     }
//   }
// }

// void onServicesDiscovered(BlepdroidDevice device_, int status)
// {
//   for (Teleobject teleobject : teleobjects) {
//     if (teleobject.comm != null && teleobject.comm.device !=  null && device_ == teleobject.comm.device) {
//       //if (verbose) println("/////////////////////////////////////////////////////// discovered services successfull to "+  teleobject.name + " "+status);
//       teleobject.comm.discovered = true;
//       bluetooth.discovering = false;
//     }
//   }
// }

// void onBluetoothRSSI(BlepdroidDevice device_, int rssi)
// {
//   println("onBluetoothRSSI " + device_.address + " " + Integer.toString(rssi));
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
// class Network {
//   String hostName; // our host name;
//   String hostIP; // our internal ip
//   String externalIP; // our external ip
//   String ssid; // ssid of connected wifi network 
//   String bssid;  // hex id 
//   String mac; // mac address
//   int rssi;  // signal strength
//   int linkSpeed;  //
//   int frequency; ///
//   String type; // type of active network connection
//   String state; // state of current connection
//   String reason; // not used
//   String extra; // name of wifi network or cellular provider
//   boolean roaming; // true if we are roaming
//   boolean available; // not used 
//   boolean cellular; // true if our connection is through cellular
//   boolean wifi; // true if wifi is enabled;
//   boolean networked; // true if there is an active connection
//   boolean router; // true if we are connected to router
//   boolean ip; // true if we have been granted an internal ip;
//   boolean connected; // true if we are connected to a network (wifi or cellular)
//   boolean online; // true if we are online and can access the www
//   boolean loading; // true if loading in another thread;

//   int pingTime;
//   long pingStart;
//   boolean updated;
//   long lastUpdated;

//   Network () {
//     update();
//   }

//   void update() {
//     updated = true;
//     lastUpdated = time.currentTimeStamp;

//     switch (wifiManager.getWifiState()) {
//     case 1: 
//       wifi = false;
//       break;
//     case 3: 
//       wifi = true;
//       break;
//     case 4: 
//       wifi = false; 
//       break;
//     default: 
//       wifi = false;
//     }
//     if (wifi) {
//       try { 
//         WifiInfo wifiInfo = wifiManager.getConnectionInfo();
//         if (verbose) println(wifiInfo);
//         ssid = removeQuotes(wifiInfo.getSSID());
//         bssid = removeQuotes(wifiInfo.getBSSID());
//         mac = removeQuotes(wifiInfo.getMacAddress());
//         rssi = wifiInfo.getRssi();
//         frequency = wifiInfo.getFrequency();
//         linkSpeed = wifiInfo.getLinkSpeed();
//         router = ssid != null;
//         if (router) {
//           int ipAddress = wifiInfo.getIpAddress();
//           hostIP = String.format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff), (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));
//           ip = !hostIP.equals("0.0.0.0");
//         }
//       }
//       catch (Exception e) {
//         if (verbose) println(e);
//       }
//     } else {
//       ssid = null;
//       hostIP = null;
//       router = false;
//     }

//     NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

//     if (networkInfo != null) {
//       networked = true;
//       String[] networkInfoItems = splitTokens(networkInfo+"", ",");
//       type = networkInfoItems[0].substring(7, networkInfoItems[0].length()-2);
//       state = networkInfoItems[1].substring(7, networkInfoItems[1].length());
//       reason = networkInfoItems[2].substring(9, networkInfoItems[2].length());
//       extra = removeQuotes(networkInfoItems[3].substring(8, networkInfoItems[3].length()));
//       roaming = networkInfoItems[4].substring(10, networkInfoItems[4].length()).equals("true");
//       //failover = networkInfoItems[5].substring(11, networkInfoItems[5].length()).equals("true");
//       //available = networkInfoItems[6].substring(14, networkInfoItems[6].length()).equals("true");
//       connected = networkInfo.isConnected();
//       cellular = networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
//       online = isOnline();
//     } else {
//       networked = false;  
//       type = null;
//       state = null;
//       reason = null;
//       extra = null;
//       roaming = false;
//       connected = false;
//       cellular = false;
//       online = false;
//     }

//     if (online) {
//       thread("getExternalIp");
//     }
//   }

//   boolean isOnline() {
//     Runtime runtime = Runtime.getRuntime();
//     try {
//       Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
//       int exitValue = ipProcess.waitFor();
//       return (exitValue == 0);
//     } 
//     catch (IOException e) { 
//       e.printStackTrace();
//     } 
//     catch (InterruptedException e) { 
//       e.printStackTrace();
//     }
//     return false;
//   }
// }

// void getExternalIp() {
//   network.pingStart = millis();
//   String ipFinderUrl = "http://checkip.amazonaws.com"; // "https://api.ipify.org"; // 
//   String[] ip = loadStrings(ipFinderUrl);
//   if (ip != null) {
//     network.externalIP = ip[0];
//     network.pingTime = int(millis() - network.pingStart);
//   }
// }

// //////void ping() {
// //////  network.pinging = true;
// //////  network.pingStart = millis();
// //////  if (debug) { 
// //////    Packet newPacket = new Packet(true, "", getPilot("online").x);
// //////    newPacket.init();
// //////  }
// //////  if (debug) println("ping http://www.google.com");  
// //////  try { 
// //////    String[] contentThread = loadStrings("http://www.google.com");
// ////    if (contentThread != null) {
// ////      network.pingTime = int(millis() - network.pingStart);
// ////      if (debug) {
// ////        if (verbose) println("ping google in "+network.pingTime+"ms");
// ////        Packet newPacket = new Packet(false, "", getPilot("online").x);
// ////        newPacket.init();
// ////        //network.online = true;
// ////      }
// ////    } else {
// ////      if (verbose) println("unable to reach google");
// ////      network.online = false;
// ////    }
// ////  } 
// ////  catch (Exception e) {
// ////    if (debug) println(e);
// ////    //network.online = false;
// ////    if (verbose) println("unable to reach google");
// ////  }
// ////  network.pinging = false;
// ////}
class Comment extends Teleobject {
  int clockMode;

  Comment(PApplet _parent) {
    parent = _parent;
  }

  public void init() {
    comm = new Comm(parent, this);
    comm.portNumber = "14121";
    comm.targetDeviceAddress = "E4:CB:FF:38:3A:00";
    display = new CommentDisplay();
    comm.init();
  }

  public void printPages() {
    switch (channel) {
      case BYE:
      pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
      break;

      case HELLO: 
      // pages.add(new Page("", TICKER, 0, 0, 0, 0, 1));
      // pages.add(new Page("", FONT, 1, 1, 0, 0, 1));
      if (!google.loggedin) {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page("What's up?", TICKER, 0, 0, 40, 0, 0));
      } 
      else {
        // pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));

        pages.add(new Page("What's up "+profile.givenName+"?", TICKER, 0, 0, 40, 0, 0));
        // pages.add(new Page(, TICKER, 1, 0, 40, 0, 0));
      }
      break;

      case DIM:
      manager.play = true;
      pages.add(new Page("", BRIGHTNESS, comm.brightness+3, 0, 0, 0, 1));
      pages.add(new Page("", PING, 0, 0, 0, 0, 1));
      break;

      case LOCATION:
      if (!geolocation.updated) {
        pages.add(new Page("We're lost...", TICKER, 0, 0, 50, 0, 1));
      } 
      else {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page(getCoordinate(geolocation.latitude, true), CENTERED, 0, 0, 0, 0, 0));
        pages.add(new Page(getCoordinate(geolocation.longitude, false), CENTERED, 1, 0, 0, 0, 20));
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));


        pages.add(new Page(geolocation.houseNumber+" "+geolocation.street, SCROLL_ALL_RIGHT, 0, 0, 10, 0, 1));
        pages.add(new Page(geolocation.neighbourhood+" "+geolocation.postCode, SCROLL_ALL_RIGHT, 0, 0, 10, 0, 1));
        pages.add(new Page(geolocation.city+", "+geolocation.county+", "+geolocation.state, SCROLL_ALL_RIGHT, 1, 0, 10, 0, 1));
      }
      break;

      case WEATHER:
      if (!weather.updated) {
        pages.add(new Page("can't connect to the cloud...", TICKER, 0, 0, 50, 0, 0));
      } 
      else {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page(("weather"), SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 30));
        pages.add(new Page((weather.condition+" in "+geolocation.neighbourhood), SCROLL_ALL_RIGHT, 1, 0, 5, 0, 1));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("It's "+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + (metric ? "\u00b0c" : "\u00b0f"), CENTERED, 0, 0, 0, 0, 10));
        pages.add(new Page("and it's gonna get hotter...", SCROLL_ALL_RIGHT, 1, 0, 10, 0, 10));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("humidity", CENTERED, 0, 0, 0, 0, 5));
        pages.add(new Page(PApplet.parseInt(weather.humidity)+"%", CENTERED, 1, 0, 0, 0, 10));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("pressure", CENTERED, 0, 0, 0, 0, 5));
        pages.add(new Page(PApplet.parseInt(weather.pressure)+"mPa", CENTERED, 1, 0, 0, 0, 10));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("wind", CENTERED, 0, 0, 0, 0, 5));
        pages.add(new Page(PApplet.parseInt(weather.windSpeed) +"m/h "+(int)weather.windDeg+"\u00b0 "+getHeading(weather.windDeg), CENTERED, 1, 0, 0, 0, 10));
      }
      break;

      case ONLINE:
      if (network.online) {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page("ip "+network.externalIP, CENTERED, 0, 0, 0, 0, 0));
        pages.add(new Page("ping "+network.pingTime+"ms", CENTERED, 1, 0, 0, 0, 0));
      } 
      else {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page("no network...", TICKER, 0, 0, 0, 0, 5));
        pages.add(new Page("...no fun", TICKER, 1, 0, 0, 0, 5));
      }
      break;

      case WIFI:
      if (network.wifi) {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page(network.hostName, CENTERED, 0, 0, 0, 0, 0));
        pages.add(new Page(network.hostIP, CENTERED, 1, 0, 0, 0, 0));
      } 
      else {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page("no wifi...", TICKER, 0, 0, 20, 0, 5));
        pages.add(new Page("...no network", TICKER, 1, 0, 20, 0, 5));
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page("no cloud...", TICKER, 0, 0, 0, 0, 5));
        pages.add(new Page("...no fun", TICKER, 1, 0, 0, 0, 5));
      }
      break;

      case BLUETOOTH:
      if (comm != null) {
        if (comm.connected) {
          if (!androidMode) {
            pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
            pages.add(new Page(comm.portName.substring(0, 5), TICKER, 0, 0, 50, 0, 10));
            pages.add(new Page(comm.portName.substring(5, comm.portName.length()), TICKER, 1, 0, 50, 0, 0));
          } 
          else {
            pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
            pages.add(new Page(comm.deviceAddress, CENTERED, 0, 0, 0, 0, 0));
            pages.add(new Page(comm.deviceRssi+"dB", CENTERED, 1, 0, 0, 0, 0));
          }
        } 
        else {
          pages.add(new Page("not connected...", TICKER, 0, 0, 10, 0, 0));
        }
      } 
      break;

      case ENERGY:
      pages.add(new Page("", BATTERY, 0, 0, 0, 0, 1));
      break;

      case TIME:
      if (clockMode++ == 3) clockMode = 0;
      String hour_ = nf(hour(), 2, 0);
      String minute_ = nf(minute(), 2, 0);
      String second_ = nf(second(), 2, 0);
      pages.add(new Page(hour_ + minute_ + second_, CLOCK, clockMode, 1, 0, 0, 0));
      break;

      case GOOGLE:
      if (google.loggedin) {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        // pages.add(new Page("", FONT, 1, 1, 0, 0, 1));

        pages.add(new Page("What's up", TICKER, 0, 0, 50, 0, 10));
        pages.add(new Page(profile.givenName+"?", TICKER, 1, 0, 50, 0, 10));
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 1));
        pages.add(new Page("our google id", SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 10));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 1, 0, 0, 5));

        pages.add(new Page(profile.id, SCROLL_ALL_RIGHT, 1, 0, 10, 0, 5));

        pages.add(new Page("our email", SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 10));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 1, 0, 0, 5));

        pages.add(new Page(profile.email, SCROLL_ALL_RIGHT, 1, 0, 10, 0, 0));

        pages.add(new Page("we are over "+profile.minAge+","+"speak english!", CENTERED, 2, 0, 0, 0, 20));
        // pages.add(new Page(, CENTERED, 1, 0, 0, 0, 30));
        // pages.add(new Page("", BLANK, 2, 0, 0, 0, 1));
        pages.add(new Page("let's rock!", CENTERED, 2, 0, 0, 0, 0));
      } 
      else {
        pages.add(new Page("let's login to google!"+profile.givenName, CENTERED, 0, 0, 10, 0, 0));
      }
      break;

      case CONTACTS:
      // pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
      pages.add(new Page(contacts.contactList.size()+" friends!", SCROLL_CENTER_RIGHT, 0, 1, 0, 0, 10));
      pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 1, 0, 0, 5));

      for (Contact contact : contacts.contactList) {
        pages.add(new Page(contact.title.toUpperCase(), CENTERED, 1, 0, 0, 0, 0));
      }
      break;

      case NEWS:
      if (news.updated) {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page("NY TIMES", SCROLL_CENTER_RIGHT, 0, 1, 0, 0, 10));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 1, 0, 0, 5));

        for (Article article : news.articles) {
          for (int i=0; i < article.keywords.size(); i++) {
            String keyword = article.keywords.get(i);
            pages.add(new Page(keyword.toUpperCase(), CENTERED, 2, 0, 0, 0, 5));
            pages.add(new Page("", BLANK, 2, 0, 0, 0, 1));
          }
          pages.add(new Page("", BLANK, 2, 0, 0, 0, 5));
          pages.add(new Page(article.section.toUpperCase()+":", SCROLL_DOWN, 0, 0, 0, 0, 20));
          pages.add(new Page(article.title, SCROLL_ALL_RIGHT, 1, 0, 10, 0, 5));
          pages.add(new Page(article.content, TICKER, 1, 0, 4, 2, 20));
          pages.add(new Page("", BLANK, 2, 0, 0, 0, 10));
        }
      } 
      else {
        pages.add(new Page("can't find...", TICKER, 0, 0, 60, 0, 30));
        pages.add(new Page(("...the newspaper"), TICKER, 1, 0, 60, 0, 30));
      }
      break;

      case CALENDAR:
      pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
      if (calendar.updated) {
        pages.add(new Page(("remember...?"), SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 50));
        for (int i=0; i<50; i++) {           // for (Event event : calendar.eventList) {         
          Event event = calendar.eventList.get((int)random(calendar.eventList.size()));
          pages.add(new Page(event.date, CENTERED, 0, 0, 0, 0, 0));
          pages.add(new Page(event.summary, SCROLL_ALL_RIGHT, 1, 0, 5, 0, 0));
        }
      } 
      else {
        pages.add(new Page("can't find...", TICKER, 0, 0, 60, 0, 30));
        pages.add(new Page(("...the calendar"), TICKER, 1, 0, 60, 0, 30));
      }
      break;

      case EQ: 
      manager.play = true;
      comm.busy = false;
      String str = "";
      for (int i =0; i<32; i++) {
        str += PApplet.parseChar(48+eq.eqData[PApplet.parseInt(i)]);
      }
      pages.add(new Page(str, SPECTRUM, 2, 0, 0, 0, 1));
      break;
    }
  }
}
class CommentDisplay extends Display {
  PShape outline;
  float r = 7.3f;
  float offsetV = 50;
  int disW = 64;
  int disH = 8;

  boolean[][][] dis = new boolean[2][64][8];

  MonoFont standardFont = new MonoFont("glcdfont.c");
  ProportionalFont tomFont = new ProportionalFont("TomThumb.h");
  ProportionalFont freeSans9 = new ProportionalFont("FreeSansBold9pt7b.h");
  ProportionalFont freeSans12 = new ProportionalFont("FreeSansBold12pt7b.h");
  ProportionalFont freeSans18 = new ProportionalFont("FreeSansBold18pt7b.h");
  // Font freeSans24 = new Font("FreeSansBold24pt7b.h");

  Font[] fonts = {standardFont, tomFont, freeSans9, freeSans12, freeSans18};
  int currentFont = 1;

  String data;
  int mode;
  int tack, teck, tick, tock, tuck;
  long lastTick;
  boolean cursorOn;
  int cursorLine, cursorX, cursorY;

  int tcL, tcX, tcY;

  int breakX;

  CommentDisplay() {
    outline = loadShape("shp/comment.svg");
    outline.disableStyle();
  }

  public void display() {
    update();
    strokeWeight(thickStroke);
    stroke(0);
    fill(255);
    shape(outline, 0, 0);
    translate(-232, - 45);
    translate(0, -offsetV);
    displayLine(0);
    translate(0, offsetV*2);
    displayLine(1);
  }

  public void displayLine(int thisLine) {
    noStroke();
    for (int column = 0; column < disW; column++) {
      for (int row = 0; row < disH; row++) {
        if (dis[thisLine][column][row]) {
          fill(redColor);
          ellipse(column * r, row * r, r-1, r-1);
        } 
        //else {
        //  fill(redColor, 10);
        //  ellipse(column * r, row * r, r-1, r-1);
        //}
      }
    }
  }

  public void update() {
    if (cursorOn && tcX < disW && tcX >= 0) drawChar(' ', tcL, tcX, tcY); 

    switch (mode) {
    case TICKER:  
      if (data.length() > 0) {    
        if (millis() - lastTick > tick) {
          if (breakX == -1) {  
            // if (data.charAt(0) == ' ') data = data.substring(1,data.length());
            // if (cursorLine == 0) {

            // }
            clearDisplay(cursorLine);
            cursorX = 0;  
            breakX = disW;
            if (stringWidth(data) > disW ) {
              int lastSpace;    
              int tempX = data.length();
              while (breakX >= disW) {
                lastSpace = findLastChar(data.substring(0, tempX), ' ');
                if (lastSpace != 0) {      
                  breakX = stringWidth(data.substring(0, lastSpace));
                  tempX = lastSpace;
                } else {
                  break;
                }
              }
            }
          }
          lastTick = millis();
          cursorX += drawChar(data.charAt(0), cursorLine, cursorX, cursorY);
          tcX = cursorX;
          tcY = cursorY;
          tcL = cursorLine;
          // if (cursorX > breakX) {
          //   cursorLine ++;
          //   breakX = -1;
          //   if (data.charAt(0) == ' ') {
          //     tcX -= charWidth(' ');
          //   }
          //   if (cursorLine == 2) {
          //     cursorLine = 0;
          //     lastTick = millis() + tock * 100;                   
          //   }  
          // }                
          data = data.substring(1, data.length());
        }
      } else {
        busy = false;
      }      
      break;
    }
    if (cursorOn) {
      if (cursorX < disW && cursorX >= 0) drawChar(millis() % 500 < 250 ? ' ' : '_', tcL, tcX, tcY);
    }
  }

  public void printString(String thisString, int thisMode, int thisTack, int thisTeck, int thisTick, int thisTock, int thisTuck) {
    data = thisString;
    if (thisMode != PING) {
      mode = thisMode;
      tack = thisTack;
      teck = thisTeck;
      tick = thisTick;
      tock = thisTock;
      tuck = thisTuck;
    }
    busy = false;
    cursorOn = false;

    switch (mode) {
    case BLANK:
      clearDisplay(tack);
      break;

    case TICKER:
      if (tack > 1) tack = 0;
      clearDisplay(tack);
      cursorLine = tack;
      cursorOn = true;
      breakX = -1;
      busy = true;
      break;

    case INSTANT:
      if (tack == 2) tack = 0;
      clearDisplay(tack);
      drawString(data, tack, cursorX, cursorY);    
      break;

    case CENTERED:
      if (tack == 2) tack = 0;
      clearDisplay(tack);
      int w = stringWidth(data);
      if (w < disW) {
        cursorX = (disW - w) / 2;
      }
      drawString(data, tack, cursorX, cursorY);    
      break;
    }
  }

  public int drawChar(char thisChar, int thisLine, int x, int y) {
    if (currentFont == 0) {
      for (int row = 0; row < standardFont.h; row++) {
        for (int column = 0; column < standardFont.w; column++) {
          if (x + column < disW && y + row < disH) {
            dis[thisLine][x+column][y+row] = standardFont.monoFontMap[(int)thisChar][column][row];
          }
        }
      }
      return standardFont.w + 1;
    } else {
      if (thisChar > fonts[currentFont].last) return 0;
      int glyphNum = (int)thisChar - fonts[currentFont].first;
      int offset = fonts[currentFont].fontGlyphs[glyphNum][0];
      int w = fonts[currentFont].fontGlyphs[glyphNum][1];
      int h = fonts[currentFont].fontGlyphs[glyphNum][2];
      int xAdvance = fonts[currentFont].fontGlyphs[glyphNum][3];
      int offsetx = fonts[currentFont].fontGlyphs[glyphNum][4];
      int offsety = fonts[currentFont].fontGlyphs[glyphNum][5];
      int currentBit = 8;
      int currentByte = 0;
      int bits = 0;
      for (int row = 0; row < disH; row++) {
        for (int column = 0; column <= xAdvance; column++) {
          int xx = x + column;
          int yy = y + row;
          if (xx >= 0 && xx < disW && yy >= 0 && yy < disH) {
            dis[thisLine][xx][yy] = false;
          }
        }
      }
      for (int row = 0; row < h; row++) {
        for (int column = 0; column < w; column++) {
          if (currentBit == 8) {
            bits = fonts[currentFont].fontMap.get(offset + currentByte);
            currentByte ++;
            currentBit = 0;
          }
          int xx = x + offsetx + column;
          int yy = y + disH + offsety + row - 2;
          if (xx >= 0 && xx < disW && yy >= 0 && yy < disH) {
            if ((bits & (128 >> currentBit)) != 0) {
              dis[thisLine][xx][yy] = true;
            }
          }
          currentBit++;
        }
      }
      return xAdvance;
    }
  }

  public int charWidth(char thisChar) {


    if (currentFont == 0) {
      return standardFont.w;
    } else {
      if (thisChar > fonts[currentFont].last) return 0;
      int glyphNum = (int)thisChar - fonts[currentFont].first;
      int xAdvance = fonts[currentFont].fontGlyphs[glyphNum][3];
      return xAdvance;
    }
  }

  public int stringWidth(String thisString) {
    int w = 0;
    for (int i = 0; i < thisString.length(); i++) {
      w += charWidth(thisString.charAt(i));
    }
    return w;
  }

  public int drawString(String thisString, int thisLine, int x, int y) {
    if (currentFont == 0) {
      for (int i = 0; i < thisString.length(); i++) {
        x += drawChar(thisString.charAt(i), thisLine, x, y);
      }
    } else {
      for (int i = 0; i < thisString.length(); i++) {
        x += drawChar(thisString.charAt(i), thisLine, x, y);
      }
    }
    return x;
  }

  public void clearDisplay(int thisLine) {
    if (thisLine == 2) {
      dis = new boolean[2][64][8];
    } else {
      for (int column = 0; column < disW; column++) {
        for (int row = 0; row < disH; row++) {
          dis[thisLine][column][row] = false;
        }
      }
    }    
    cursorX = 0;
    cursorY = 0;
  }



  String invalid  = "`\u00b4\u00e2\u0080\u0098\u00e1\u00e4\u00c1\u00c2\u00c4\u00e9\u00ea\u00eb\u00c9\u00ca\u00cb\u00ed\u00ee\u00ef\u00cd\u00ce\u00cf\u00f3\u00f4\u00f6\u00d3\u00d4\u00d6\u00fa\u00fb\u00fc\u00da\u00db\u00dc\u00f1\u00d1";
  String subs     = "'''aaAAAeeeEEEiiiIIIoooOOOuuuUUUnN   ";
  String valid = " !@#$%^&*()-+=[|]}{;':<>,.?/~`\u00b0'_01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"+PApplet.parseChar(34)+PApplet.parseChar(135);

  public String cleanUp(String str) {
    String res = "";
    for (int i=0; i<str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '&') {
        if (str.charAt(i+1) == '#') {
          ch = 39;
          i = i+6;
        } else {
          if (str.length() > i+5) {
            if (str.charAt(i+5) == ';') {
              ch = 39;
              i = i+5;
            }
          }
        }
      }
      if (invalid.indexOf(ch) != -1) {
        ch = subs.charAt(invalid.indexOf(ch));
      }
      if (valid.indexOf(ch) != -1) {
        res +=  ch;
      } else {
        res += PApplet.parseChar(39);//'-';
      }
    }
    return res;
  }
}
final int BOTTOM_EYE_LEFT = 27;
final int BOTTOM_EYE_RIGHT = 27;
final int BOTTOM_EYE_CLOSED_LEFT = 28;
final int BOTTOM_EYE_CLOSED_RIGHT = 28;

final int TOP_EYE_LEFT = 29;
final int TOP_EYE_RIGHT = 29;
final int TOP_EYE_CLOSED_LEFT = 30;
final int TOP_EYE_CLOSED_RIGHT = 30;

final int NEUTRAL_LEFT = 145;
final int NEUTRAL_RIGHT = 146;
final int WIDE_EYED_LEFT = 147;
final int WIDE_EYED_RIGHT = 148;
final int WIDE_EYED_SURPRISED_LEFT = 149;
final int WIDE_EYED_SURPRISED_RIGHT = 150;
final int SURPRISED_LEFT = 151;
final int SURPRISED_RIGHT = 152;
final int SCARED_LEFT = 153;
final int SCARED_RIGHT = 154;
final int ANGRY_LEFT = 155;
final int ANGRY_RIGHT = 156;
final int PERPLEXED_LEFT = 157;
final int PERPLEXED_RIGHT = 158;
final int HAPPY_LEFT = 159;
final int HAPPY_RIGHT = 160;
final int CRYING_LEFT = 161;
final int CRYING_RIGHT = 162;
final int EYES_CLOSED_LEFT = 163;
final int EYES_CLOSED_RIGHT = 164 ;
final int CROSS_DEAD_LEFT = 165 ;
final int CROSS_DEAD_RIGHT = 166;
final int X_DEAD_LEFT = 167;
final int X_DEAD_RIGHT = 168;

final int UNDERSCORE_LEFT = '_';
final int UNDERSCORE_RIGHT = '_';

final int DASH_LEFT = '-';
final int DASH_RIGHT = '-';

final int SWEAT_BEAD = 169;

final int bottom = 0;
final int bottom_closed = 1;
final int top = 2;
final int top_closed = 3;;
final int neutral = 4;
final int wide = 5;
final int surprised= 6;
final int scared = 7;
final int angry = 8;
final int perplexed = 9;
final int happy = 10;
final int crying = 11;
final int closed = 12;
final int cross = 13;
final int dead = 14;
final int underscore = 15;
final int dash = 16;

boolean noseFace = true;
int face = neutral;
int faceClosed = closed;

int leftEyes[] = {BOTTOM_EYE_LEFT, BOTTOM_EYE_CLOSED_LEFT, TOP_EYE_LEFT, TOP_EYE_CLOSED_LEFT, NEUTRAL_LEFT, 
WIDE_EYED_LEFT, WIDE_EYED_SURPRISED_LEFT, SURPRISED_LEFT, SCARED_LEFT, ANGRY_LEFT, PERPLEXED_LEFT, HAPPY_LEFT, 
CRYING_LEFT, EYES_CLOSED_LEFT, CROSS_DEAD_LEFT, X_DEAD_LEFT, UNDERSCORE_LEFT, DASH_LEFT};

int rightEyes[] = {BOTTOM_EYE_RIGHT, BOTTOM_EYE_CLOSED_RIGHT, TOP_EYE_RIGHT, TOP_EYE_CLOSED_RIGHT, NEUTRAL_RIGHT, 
WIDE_EYED_RIGHT, WIDE_EYED_SURPRISED_RIGHT, SURPRISED_RIGHT, SCARED_RIGHT, ANGRY_RIGHT, PERPLEXED_RIGHT, HAPPY_RIGHT, 
CRYING_RIGHT, EYES_CLOSED_RIGHT, CROSS_DEAD_RIGHT, X_DEAD_RIGHT, UNDERSCORE_RIGHT, DASH_RIGHT};
  class Font {
  // String file;

  String[] fontData;
  ArrayList<Integer> fontMap;
  ArrayList<String> charBitMaps;
  int[][] fontGlyphs;
  int first;
  int last;
  int yAdvance;


  boolean monoFontMap[][][];
  int w;
  int h;
}


class ProportionalFont extends Font {
  ProportionalFont(String thisFile) {
    fontData = loadStrings("fonts/"+thisFile);
    fontMap = new ArrayList<Integer>();
    int lastLine = 0;
    for (int i = 0; i < fontData.length; i++) {
      String thisLine = removeSpaces(fontData[i]);
      lastLine ++;
      if (thisLine.length() > 2 && thisLine.substring(0, 2).equals("0x")) {
        String[] items = splitTokens(thisLine, ",");
        for (int j = 0; j<items.length; j++) {
          String thisVal = removeSpaces(items[j]).substring(0, 4);
          if (thisVal.substring(0, 2).equals("0x")) {
            fontMap.add(unhex(thisVal.substring(2, 4)));
          }
        }
      }
      if (thisLine.contains("};")) break;
    }
    int charNum = 0;
    for (int i = lastLine; i < fontData.length; i++) {
      String thisLine = removeSpaces(fontData[i]);
      if (thisLine.length() > 2 && thisLine.charAt(0) == '{') {
        charNum ++;
      }
      if (thisLine.contains("};")) break;
    }
    fontGlyphs = new int[charNum][6];
    int currentChar = 0;
    for (int i = lastLine; i < fontData.length; i++) {
      String thisLine = removeSpaces(fontData[i]);
      lastLine ++;
      if (thisLine.length() > 2 && thisLine.charAt(0) == '{') {
        String items[] = splitTokens(thisLine.substring(1, thisLine.length()));
        for (int j = 0; j < 6; j++ ) {
          fontGlyphs[currentChar][j] = parseInt(filterNumber(items[j]));
        }
        currentChar ++;
      }
      if (thisLine.contains("};")) break;
    }
    for (int i = lastLine; i < fontData.length; i++) {
      String thisLine = removeSpaces(fontData[i]);
      String[] items = splitTokens(thisLine, ",");
      if (items.length == 3) {
        first = unhex(removeSpaces(items[0]).substring(2, 4));
        last = unhex(removeSpaces(items[1]).substring(2, 4));
        yAdvance = parseInt(removeSpaces(items[2].substring(0, items[2].length()-3)));
      }
    }
  }

  public void display() {
    background(255);
    int px = 4;
    int cx = 0;
    int cy = yAdvance*px;
    int marginx = 1;
    int marginy = 0;
    rectMode(CORNER);
    textSize(8);
    textAlign(LEFT, TOP);
    for (int i=0; i<fontGlyphs.length; i++) {
      int offset = fontGlyphs[i][0];
      int w = fontGlyphs[i][1];
      int h = fontGlyphs[i][2];
      int xAdvance = fontGlyphs[i][3];
      int offsetx = fontGlyphs[i][4];
      int offsety = fontGlyphs[i][5];
      fill(255, 0, 0);
      stroke(255, 0, 0, 50);
      noFill();
      int tempy = (offsety*px);
      text(i+first, cx, cy+tempy+(h*px));
      rect(cx, cy+tempy, xAdvance * px, h*px);
      // int totalPixels = w * h;
      // int bytes = totalPixels/8;
      // if (totalPixels > bytes*8) bytes ++;
      // for (int thisByte = 0; thisByte < bytes; thisByte++) {
      // 	int bits = fontMap.get(offset+thisByte);
      // 	text(offset+thisByte+" "+bits, cx, cy + tempy + (thisByte * px));
      // }
      int currentBit = 8;
      int currentByte = 0;
      int tempX = offsetx * px;
      int bits = 0;
      for (int row = 0; row < h; row++) {
        for (int column = 0; column < w; column++) {
          if (currentBit == 8) {
            bits = fontMap.get(offset + currentByte);
            currentByte ++;
            currentBit = 0;
          }
          if ((bits & (128 >> currentBit)) != 0) {
            fill(50);
            stroke(255);
            rect(cx + tempX + (column * px), cy + tempy + (row * px), px, px);
          }
          currentBit++;
        }
      }

      cx += (xAdvance+marginx) * px;
      if (cx > width - ((w + xAdvance) * px)) {
        cx = 0;
        cy += px * (yAdvance+marginy);
      }
    }
  }
}

class MonoFont extends Font {

  MonoFont (String thisFile) {
    monoFontMap = new boolean[256][w][h];
    fontData = loadStrings("fonts/"+thisFile);
    int currentChar = 0;
    for (int i = 0; i < fontData.length; i++) {
      String[] items = splitTokens(fontData[i], ",");
      if (items.length >= w) {
        for (int column = 0; column < w; column ++) {
          int thisRow = unhex(removeSpaces(items[column]).substring(2, 4));
          for (int row = 0; row < h; row++) {
            monoFontMap[currentChar][column][row] = (thisRow & (1 << row)) != 0;
          }
        }
        currentChar ++;
      }
    }
  }

  public void display() {
    background(255);
    int cx = 0;
    int cy = 8;
    int px = 7;
    int offsetx = 3;
    int offsety = 3;
    rectMode(CORNER);
    textSize(8);
    textAlign(LEFT, TOP);
    for (int i=0; i<monoFontMap.length; i++) {
      fill(255, 0, 0);
      text(i, cx, cy+(h*px));
      stroke(255, 0, 0, 50);
      noFill();
      rect(cx, cy, w*px, h*px);
      for (int j=0; j<w; j++) {
        for (byte k=0; k<h; k++) {
          if (monoFontMap[i][j][k]) {
            fill(50);
            stroke(255);
            rect(cx, cy, px, px);
          }
          cy += px;
        }
        cx += px;
        cy -= px*h;
      }
      cx += offsetx*px;
      if (cx > width-(w*px)) {
        cx = 0;
        cy += px*(h+offsety);
      }
    }
  }
}
class FrameDisplay extends Display {
  PShape outline, window, mask;
  int mode = 0;
  String data = "";
  long lastTick;
  int cursorX = 0;
  int breakX;
  int displayMode, tick, tock, tuck;
  
  int w = 128;
  int h = 128;
  float f = 9;

  int foreground, background, top, bottom;
  boolean gradient;

  int currentFont = 0;

  PGraphics display;

  FrameDisplay () {
    outline = loadShape("shp/app.svg");
    outline.disableStyle();
    mask = loadShape("shp/mask.svg");
    mask.disableStyle();
    foreground = whiteColor;
    background = redColor;
    top = 0;
    bottom = 0;
    display = createGraphics(240, 240, JAVA2D);
    display.noSmooth();
    display.beginDraw();
    display.background(background, 230);
    display.endDraw();
  }

  public void update() {
  }

  public void display() {
    pushMatrix();
    scale(.596f);
    fill(255);
    stroke(0);
    pushMatrix();
    scale(4);
    strokeWeight(thickStroke);
    shape(outline, 0, 0);
    popMatrix();
    pushMatrix();
    scale(.74f);
    image(display, 0, 0);
    popMatrix();
    pushMatrix();
    scale(1.6f);
    noStroke();
    fill(255);
    shape(mask, 0, 0);
    noFill();
    stroke(0);
    strokeWeight(thickStroke*.59f*1.6f);
    shape(outline, 0, 0);
    popMatrix();
    popMatrix();
  }

  public void printString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
  }
}
////////////////////////
// GOOGLE
////////////////////////

String CLIENT_ID;
String CLIENT_SECRET;
String REFRESH_TOKEN;
String ACCESS_TOKEN;
String CALLBACK_ID;

class Google {
  boolean loggedin;
  boolean logging;
  boolean authenticating;

  String[] keys;

  Google() {
    if (credentials.credentials != null) {
      String[] items = splitTokens(credentials.credentials[1], ",");
      CLIENT_ID = items[0];
      CLIENT_SECRET = items[1];
    }
    //login();
  }

  public void login() {
    if (authenticating) {
      runFinalizeOAuthChoreo();
      authenticating = false;
      profile.update();
      loggedin = true;
      logging = false;
      manager.setChannel(GOOGLE);
    } else {
      authenticate();
    }
  }

  public void logout() {
    deleteFile("google.txt");
    loggedin = false;
    logging = false;
    authenticating = false;
    REFRESH_TOKEN = null;
    ACCESS_TOKEN = null;
    profile = new Profile();
    google = new Google();
    contacts = new GoogleContacts();
    calendar = new GoogleCalendar();
  }

  public void authenticate() {
    try {
      keys = loadStrings("tmp/google.txt");
      if (keys != null) {
        REFRESH_TOKEN = keys[0];
        ACCESS_TOKEN = keys[1];
      }
    } 
    catch (Exception e) {
      println("error");
    }
    if (REFRESH_TOKEN == null) {
      if (network.online) {
        runInitializeOAuthChoreo();
      }
    } else {
      profile.update();
      loggedin = true;
      logging = false;
      manager.setChannel(GOOGLE);
    }
  }

  public void runInitializeOAuthChoreo() {
    com.temboo.Library.Google.OAuth.InitializeOAuth initializeOAuthChoreo = new com.temboo.Library.Google.OAuth.InitializeOAuth(session);
    initializeOAuthChoreo.setClientID(CLIENT_ID);
    String scopes = "http://www.google.com/m8/feeds/";
    scopes += " https://www.googleapis.com/auth/drive";
    scopes += " https://www.googleapis.com/auth/userinfo.email";
    scopes += " https://www.googleapis.com/auth/userinfo.profile";
    scopes += " http://www.google.com/m8/feeds/";
    scopes += " https://spreadsheets.google.com/feeds/";
    scopes += " https://www.googleapis.com/auth/calendar";
    scopes += " https://www.googleapis.com/auth/plus.login";
    scopes += " https://www.googleapis.com/auth/plus.profile.emails.read";
    scopes += " https://mail.google.com/";
    initializeOAuthChoreo.setScope(scopes);
    com.temboo.Library.Google.OAuth.InitializeOAuthResultSet initializeOAuthResults = initializeOAuthChoreo.run();
    link(initializeOAuthResults.getAuthorizationURL());
    CALLBACK_ID = initializeOAuthResults.getCallbackID();
    authenticating = true;
  }

  public void runFinalizeOAuthChoreo() {
    com.temboo.Library.Google.OAuth.FinalizeOAuth finalizeOAuthChoreo = new com.temboo.Library.Google.OAuth.FinalizeOAuth(session);
    finalizeOAuthChoreo.setCallbackID(CALLBACK_ID);
    finalizeOAuthChoreo.setClientID(CLIENT_ID);
    finalizeOAuthChoreo.setClientSecret(CLIENT_SECRET);
    com.temboo.Library.Google.OAuth.FinalizeOAuthResultSet finalizeOAuthResults = finalizeOAuthChoreo.run();
    println(finalizeOAuthResults.getErrorMessage());
    println(finalizeOAuthResults.getExpires());
    println(finalizeOAuthResults.getRefreshToken());
    ACCESS_TOKEN = finalizeOAuthResults.getAccessToken();
    REFRESH_TOKEN = finalizeOAuthResults.getRefreshToken();
    keys = new String[2];
    keys[0] = REFRESH_TOKEN;
    keys[1] = ACCESS_TOKEN;
    saveLocal("google.txt", keys);
  }
}

/////////////////////////////////////
// PROFILE
/////////////////////////////////////

class Profile {
  String nickname, email, url, familyName, givenName, objectType, id, kind, language;
  int minAge;
  PImage img = null;
  boolean updated;
  long lastUpdated;

  Profile () {
  }

  public void update() {
    JSONObject choreo = null;
    try {
      String[] choreoBuffer = loadLocal("profile.json");
      choreo = JSONObject.parse(concatenate(choreoBuffer));
    } 
    catch (Exception e) {
      if (network.online) {
        choreo = runGetChoreo();
        String[] choreoBuffer = { choreo.toString()};
        saveLocal("profile.json", choreoBuffer);
      }
    }
    if (choreo != null) {
      email = choreo.getJSONArray("emails").getJSONObject(0).getString("value");
      url = choreo.getJSONObject("image").getString("url");
      url = profile.url.substring(0, url.length()-6);
      familyName = choreo.getJSONObject("name").getString("familyName");
      givenName = choreo.getJSONObject("name").getString("givenName");
      objectType = choreo.getString("objectType");
      id = choreo.getString("id");
      kind = choreo.getString("kind");
      language = choreo.getString("language");
      minAge = choreo.getJSONObject("ageRange").getInt("min");
      try {
        //img = loadLocalImage(id+".png");
      } 
      catch (Exception e) {
      }
      if (img == null) {
        //img = loadImage(url);
        //saveLocal(id+".png", img);
      }
      updated = true;
    }
  }

  public JSONObject runGetChoreo() {
    Get getChoreo = new Get(session);
    getChoreo.setClientID(CLIENT_ID);
    getChoreo.setClientSecret(CLIENT_SECRET);
    getChoreo.setRefreshToken(REFRESH_TOKEN);
    getChoreo.setUserID("me");
    //getChoreo.addOutputFilter("nickname", "nickname", "Response");
    GetResultSet getResults = getChoreo.run();
    //println(getResults.getNewAccessToken());
    JSONObject response = JSONObject.parse(getResults.getResponse());
    return response;
  }
}

/////////////////////////////////////
// DRIVE
/////////////////////////////////////

class GoogleMail {
  ArrayList<Email> mailList = new ArrayList<Email>();
  boolean updated;
  int maxEmails = 5;

  public void update() {
    if (google.loggedin && network.online) {
      mailList = new ArrayList<Email>();
      JSONObject emailList = runListMessagesChoreo();
      JSONArray itemsArray = emailList.getJSONArray("messages");
      for (int i = 0; i<itemsArray.size(); i++) {
        String id = itemsArray.getJSONObject(i).getString("id");
        JSONObject emailObject = runGetMessageChoreo(id);
        Email email = new Email();
        email.id = id;
        email.snippet = emailObject.getString("snippet");
        JSONArray headers = emailObject.getJSONObject("payload").getJSONArray("headers");
        for (int j = 0; j<headers.size(); j++) {
          JSONObject header = headers.getJSONObject(j);
          if (header.getString("name").equals("Subject")) email.subject = header.getString("value");
          if (header.getString("name").equals("From")) email.sender = header.getString("value");
          if (header.getString("name").equals("Date")) email.date = header.getString("value").substring(0, 25);
        }
        println(email.subject +" "+email.sender);
        email.fix();
        mailList.add( email);
      }
      updated = true;
    }
  }

  public JSONObject runListMessagesChoreo() {
    ListMessages listMessagesChoreo = new ListMessages(session);
    listMessagesChoreo.setRefreshToken(REFRESH_TOKEN);
    listMessagesChoreo.setClientSecret(CLIENT_SECRET);
    listMessagesChoreo.setClientID(CLIENT_ID);
    listMessagesChoreo.setMaxResults(maxEmails);
    listMessagesChoreo.setQuery("is:unread");
    ListMessagesResultSet listMessagesResults = listMessagesChoreo.run();

    ACCESS_TOKEN = listMessagesResults.getNewAccessToken();
    // String result = listMessagesResults.getResponse();
    JSONObject response = JSONObject.parse(listMessagesResults.getResponse());
    return response;
  }

  public JSONObject runGetMessageChoreo(String id) {
    GetMessage getMessageChoreo = new GetMessage(session);
    getMessageChoreo.setRefreshToken(REFRESH_TOKEN);
    getMessageChoreo.setClientSecret(CLIENT_SECRET);
    getMessageChoreo.setClientID(CLIENT_ID);
    getMessageChoreo.setMessageID(id);
    GetMessageResultSet getMessageResults = getMessageChoreo.run();
    ACCESS_TOKEN =  getMessageResults.getNewAccessToken();
    JSONObject response = JSONObject.parse(getMessageResults.getResponse());
    return response;
  }
}

class Email {
  String sender, date, subject, id, snippet;

  public void fix() {
    if (sender.indexOf("<") != -1 &&  sender.indexOf("<") > 0) {

      sender = sender.substring(0, sender.indexOf("<")-1);
    }
    sender = removeQuotes(sender);
  }
}


/////////////////////////////////////
// DRIVE
/////////////////////////////////////

class GoogleDrive {
  boolean updated;
  String[] driveContent;
  ArrayList<String> commands;

  GoogleDrive () {
  }

  public void update() {
    if (network.online && false) {
      String logId = "1nDJ7lBSpylE5ORHF6xTntc4N9iqq8m3j_LW7Ok5K8RQ";
      String driveUrl = "https://docs.google.com/spreadsheets/d/"+logId+"/export?format=tsv&id="+logId;
      driveContent = loadUrl(driveUrl);
    } else {
      driveContent = loadStrings("tsv/drive.tsv");
    }
    if (driveContent != null) {
      updated = true;
    }
  }

  // ArrayList<String> getPages() {
  //   update();
  //   return drives;
  // }

  // void runAppendRowChoreo(String content) {
  //   AppendRow appendRowChoreo = new AppendRow(session);
  //   appendRowChoreo.setClientID(CLIENT_ID);
  //   appendRowChoreo.setRefreshToken(REFRESH_TOKEN);
  //   appendRowChoreo.setClientSecret(CLIENT_SECRET);
  //   appendRowChoreo.setSpreadsheetTitle("tele_log");
  //   retrieveRowChoreo.setWorksheetName("tele_log");
  //   appendRowChoreo.setRowData(content);
  //   AppendRowResultSet appendRowResults = appendRowChoreo.run();
  //   //if (ACCESS_TOKEN == null) {
  //   //ACCESS_TOKEN = appendRowResults.getNewAccessToken();
  //   //}
  //   println(appendRowResults.getResponse());
  // }

  // void runRetrieveRowChoreo() {
  //   RetrieveRow retrieveRowChoreo = new RetrieveRow(session);
  //   retrieveRowChoreo.setClientID(CLIENT_ID);
  //   retrieveRowChoreo.setRefreshToken(REFRESH_TOKEN);
  //   retrieveRowChoreo.setClientSecret(CLIENT_SECRET);
  //   retrieveRowChoreo.setSpreadsheetName("tele_log");
  //   retrieveRowChoreo.setWorksheetName("tele_log");
  //   RetrieveRowResultSet retrieveRowResults = retrieveRowChoreo.run();
  //   println(retrieveRowResults.getRowData());
  //   //if (ACCESS_TOKEN == "") {
  //   //ACCESS_TOKEN = retrieveRowResults.getNewAccessToken();
  //   //}
  // }
}

/////////////////////////////////////
// CONTACTS
/////////////////////////////////////

class GoogleContacts {
  String contactsData;
  ArrayList<Contact> contactList;
  int maxContacts = 5000;
  boolean updated;

  GoogleContacts () {
    contactList = new ArrayList<Contact>();
  }

  public void update() {
    if (google.loggedin) {

      XML contactsXML = null;
      try {
        contactsXML = loadXML((androidMode ? "data\\tmp\\" : "data/tmp/") + "contacts.xml");
      } 
      catch (Exception e) {
        println("error loading contacts.xml");
      }

      if (contactsXML == null) {
        println("getting contacts");
        String contactsBuffer = runGetAllContactsChoreo();
        contactsXML = parseXML (contactsBuffer);
        saveXML(contactsXML, (androidMode ?  "data\\tmp\\" : "data/tmp/") + "contacts.xml");
      }

      if (contactsXML != null) {
        XML[] entries = contactsXML.getChildren("entry");
        for (int i = 1; i < entries.length; i++) {
          Contact contact = new Contact();
          contact.title = entries[i].getChild("title").getContent();
          // XML names = entries[i].getChild("gd:name");
          // if (names.getChild("gd:fullName").getContent() !=null && names.getChild("gd:fullName").getContent()!=null) contact.fullName = names.getChild("gd:fullName").getContent();
          // if (names.getChild("gd:givenName").getContent() !=null  && names.getChild("gd:givenName").getContent()!=null) contact.givenName = names.getChild("gd:givenName").getContent();
          // if (names.getChild("gd:familyName") !=null && names.getChild("gd:familyName").getContent()!=null) contact.familyName = names.getChild("gd:familyName").getContent();
          if (entries[i].getChild("gd:email") !=null ) contact.email = entries[i].getChild("gd:email").getString("address").toLowerCase();
          if (entries[i].getChild("gd:phoneNumber") !=null ) contact.phoneNumber = entries[i].getChild("gd:phoneNumber").getContent();
          if (entries[i].getChild("link") != null) {
            if (entries[i].getChild("link").hasAttribute("gd:etag")) {
              contact.url = entries[i].getChild("link").getString("href");
              if (contact.url != null) {
                try {
                  //contact.img = loadLocalImage(contact.email+".png");
                  // println(contact.url);
                } 
                catch (Exception e) {                
                  //String url = contact.url+"?access_token="+ACCESS_TOKEN;
                  //downloadByteArrayAsImage(url, contact.email);
                }
                if (contact.title.length() >0) contactList.add(contact);
              }
            }
          }
        }
        updated = true;
      }
    }
  }

  public String runGetAllContactsChoreo() {
    GetAllContacts getAllContactsChoreo = new GetAllContacts(session);
    getAllContactsChoreo.setRefreshToken(REFRESH_TOKEN);
    getAllContactsChoreo.setClientSecret(CLIENT_SECRET);
    getAllContactsChoreo.setClientID(CLIENT_ID);
    getAllContactsChoreo.setMaxResults(maxContacts);
    GetAllContactsResultSet getAllContactsResults = getAllContactsChoreo.run();
    ACCESS_TOKEN = getAllContactsResults.getAccessToken();
    return getAllContactsResults.getResponse();
  }
}

class Contact {
  String title;
  String fullName;
  String givenName;
  String familyName;
  String email;
  String phoneNumber;
  String url;
  PImage img;

  // void fix() {
  //   if (title.length() == 0) {
  //     title = fullName;
  //   }
  //   if (title.length() == 0) {
  //     title = givenName+" "+familyName;
  //   }
  //   if (title.length() == 0) {
  //     title = email;
  //   }
  // }
}

/////////////////////////////////////
// CALENDAR
/////////////////////////////////////


class GoogleCalendar {
  ArrayList<Event> eventList;
  boolean updated;

  GoogleCalendar () {
    eventList = new ArrayList<Event>();
  }

  public void update() {
    if (google.loggedin && network.online) {

      eventList = new ArrayList<Event>();
      JSONObject eventsObject = runGetAllEventsChoreo();
      JSONArray itemsArray = eventsObject.getJSONArray("items");
      for (int i = 0; i<itemsArray.size(); i++) {
        JSONObject thisItem = itemsArray.getJSONObject(itemsArray.size()-i-1);
        println(thisItem.toString());
        Event event = new Event();
        event.summary = thisItem.getString("summary");
        event.dateRaw = thisItem.getString("created");
        event.fix();
        eventList.add(event);
      }  
      updated = true;
      println(eventList.size()+" events");
    }
  }

  public JSONObject runGetAllEventsChoreo() {
    // println(loadStrings("https://www.googleapis.com/calendar/v3/calendars/primary/events&access_token="+ACCESS_TOKEN));
    GetAllEvents getAllEventsChoreo = new GetAllEvents(session);
    getAllEventsChoreo.setRefreshToken(REFRESH_TOKEN);
    getAllEventsChoreo.setClientSecret(CLIENT_SECRET);
    getAllEventsChoreo.setClientID(CLIENT_ID);
    getAllEventsChoreo.setCalendarID("primary");
    // getAllEventsChoreo.setMaxResults(2500);
    // getAllEventsChoreo.setSingleEvents("true");
    getAllEventsChoreo.setResponseFormat("json");
    GetAllEventsResultSet getAllEventsResults = getAllEventsChoreo.run();
    // println(getAllEventsResults.getNewAccessToken());
    return JSONObject.parse(getAllEventsResults.getResponse());
  }
}

class Event {
  String summary;
  String dateRaw, date;
  int day, month, year;
  Event() {
  }

  public void fix() {
    //print(dateRaw);
    year = parseInt(dateRaw.substring(0, 4));
    month = parseInt(dateRaw.substring(5, 7));
    day = parseInt(dateRaw.substring(8, 10));
    date =time.monthNames[month-1] +" "+ day+", "+year;
  }

  public void debug() {
  }
}

int whiteColor = color (255, 255, 255);
int redColor = color(190, 30, 45);
int greenColor = color(147, 213, 48);
int orangeColor = color(255, 128, 0);
int backgroundColor = 50;
PFont font;//, fontBold, fontMono, fontMonoBold;

float thickStroke = 3;
PShape app, mask;

class Gui {
  //boolean refresh = true;
  //float rot, targetRot;
  ArrayList<Packet> packets;

  Gui () {
    init();
  }

  public void init() {
    imageMode(CENTER);
    ellipseMode(CENTER);
    app = loadShape("shp/app.svg");
    app.disableStyle();
    mask = loadShape("shp/mask.svg");
    mask.disableStyle();
    textSize(16);
    initPilots();
    packets = new ArrayList<Packet>();
  }

  public void update() {
    // pushMatrix();
    // PILOTS
    displayPilots();
    // PACKETS
    if (debug) {
      displayPackets();
    }
    // popMatrix();
    // MESSAGING
    if (messaging != null && debug) {
      messaging.displayDweet(250, 630);
    }
  }

  public void displayPackets() {
    for (int i =0; i<packets.size(); i++) {
      packets.get(i).display();
    }
    for (int i =0; i<packets.size(); i++) {
      if (i<packets.size()) {
        if (packets.get(i).loc.z < 5) packets.remove(i);
      }
    }
  }
}

class Packet {
  PVector loc;
  PVector targetLoc;
  boolean in;
  String label;

  Packet(boolean in_, String label_, float x_) { 
    label = label_;
    in = in_;
    loc = new PVector (x_+(in?40:0)-20, in ? displayHeight/2-200 : 118, 255);
    targetLoc = new PVector (x_+(in?40:0)-20, in ? 118 : displayHeight/2-200, 0);
    if (gui.packets.size() < 20) {
      gui.packets.add(this);
    }
  }

  public void init() {
  }

  public void display() {
    //loc.x = attract(loc.x, targetLoc.x, .08, 5);
    loc.y = attract(loc.y, targetLoc.y, .08f, 5);
    loc.z = attract(loc.z, targetLoc.z, .08f, 5);
    hint(DISABLE_DEPTH_TEST);

    // hint(ENABLE_DEPTH_TEST);
    noStroke();
    fill(in ? (real ? 50 : whiteColor) : redColor, loc.z);
    ellipse(loc.x, loc.y, 15, 15);
    ellipseMode(CENTER);
    // hint(DISABLE_DEPTH_TEST);
  }
}
public void deleteFile(String thisFileName) {
  String fileName = "";
  if (androidMode) {
    //fileName = sketchPath("data\\tmp\\"+thisFileName);
  } else {
    fileName = sketchPath("data/tmp/"+thisFileName);
  }
  File f = new File(fileName);
  if (f.exists()) {
    f.delete();
    println("deleted "+thisFileName);
  } else {
    println("could not delete "+thisFileName);
  }
}

// String getSdFilePath(String relativeFilename) {
//   File externalDir = Environment.getExternalStorageDirectory();
//   if (externalDir == null ) {
//     return null;
//   }
//   String sketchName= this.getClass().getSimpleName();
//   File sketchSdDir = new File(externalDir, sketchName);
//   File finalDir =  new File(sketchSdDir, relativeFilename);
//   return finalDir.getAbsolutePath();
// }

public String[] loadLocal(String thisFile) {
  String[] result = {};
  if (androidMode) {
    // String dataFile = getSdFilePath("strings.txt");
    // if ( dataFile == null ) {
    //   if (verbose) println("no SD CARD found");
    //   return null;
    // } else {
    //   loadStrings(dataFile);
    //   if (verbose) println("loaded "+dataFile);
    // }
  } else {
    result = loadStrings("data/tmp/"+thisFile);
    if (verbose) println("loaded "+thisFile);
  }
  return result;
}

public void saveLocal(String thisFile, String[] thisContent) {
  if (androidMode) {
    //     String dataFile = getSdFilePath("strings.txt");
    //   if ( dataFile == null ) {
    //     if (verbose) println("no SD CARD found");
    // } else {
    //     saveStrings(dataFile, thisContent);
    //     if (verbose) println("saved "+dataFile);
    //   }
  } else {
    saveStrings("data/tmp/"+thisFile, thisContent);
    if (verbose) println("saved "+thisFile);
  }
}

public void saveLocal(String thisFile, PImage img) {
  if (img != null) {
    PImage tmp = createImage(img.width, img.height, RGB);
    tmp = img.get();
    if (androidMode) {
      tmp.save(savePath(sketchPath("data\\tmp\\"+thisFile)));
    } else {
      tmp.save(savePath(sketchPath("data/tmp/"+thisFile)));
    }
  }
  if (verbose) println("saved "+thisFile);
}

public PImage loadLocalImage(String thisFile) {
  return loadLocalImage(thisFile, "tmp");
}

public PImage loadLocalImage(String thisFile, String thisFolder) {
  if (debug) { 
    Packet newPacket = new Packet(false, "", getPilot("online").x);
    newPacket.init();
  }
  String filePath = "";
  filePath = (androidMode ? "data\\"+thisFolder+"\\" : "data/"+thisFolder+"/")+thisFile;
  PImage img = loadImage(filePath);
  if (verbose) println("loaded "+thisFile);
  return img;
}

public String[] loadUrl(String thisUrl) {
  network.loading = true;
  if (debug) { 
    Packet newPacket = new Packet(true, "", getPilot("online").x);
    newPacket.init();
  }
  if (verbose) println("loading url "+thisUrl);  
  network.pingStart = millis();
  if (network.online) {
    try { 
      String[] content = loadStrings(thisUrl);
      if (content != null) {
        network.pingTime = PApplet.parseInt(millis() - network.pingStart);
        if (verbose) println("loaded url "+network.pingTime+"ms");
        if (debug) {
          Packet newPacket = new Packet(false, "", getPilot("online").x);
          newPacket.init();
        }
        //network.updated = false;
        return content;
      }
    } 
    catch (Exception e) {
      if (verbose) println(e);
    }
  }
  if (verbose) println("error, offline");
  //network.updated = false;
  network.loading = false;
  return null;
}

public long getFileTimeStamp(String thisFolder, String thisFileName) {
  String fileName;
  if (androidMode) {
    fileName = dataPath("tmp\\"+thisFileName);
  } else {
    fileName = sketchPath("data/tmp/"+thisFileName);
  }
  File file = new File(fileName);
  if (file.exists()) {  
    long lastUpdated = file.lastModified();
    if (verbose) println("getting time stamp "+fileName);
    return lastUpdated;
  } else {
    if (verbose) println("could not get time stamp "+fileName);
    return 0;
  }
}

public String getEasyTimeStamp(long thisTime) {
  if (thisTime == 0) return "never";
  float dif = PApplet.parseInt((time.currentTimeStamp - thisTime) / 1000);
  float secondsPerMinute = 60;  
  float secondsPerHour = secondsPerMinute * 60;
  float secondsPerDay = secondsPerHour * 24;
  float days = dif / secondsPerDay;
  float hours = (days - (int)days) * secondsPerDay / secondsPerHour;
  float minutes = (hours - (int)hours) * secondsPerHour / secondsPerMinute;
  float seconds = (minutes - (int)minutes) * secondsPerMinute;
  return ((int)days > 0 ? (int)days+"d " : "") + ((int)hours > 0 ? (int)hours+"h " : "") + ((int)minutes > 0 ? (int)minutes+"m " : "") +(int)seconds+"s ago";
}
class Mailbox extends Teleobject {


 Mailbox(PApplet _parent) {
  parent = _parent;
}

public void init() {
  comm = new Comm(parent, this);
  display = new MailboxDisplay();
  comm.portNumber = "1431";
  comm.targetDeviceAddress = "D2:26:16:99:DF:A5";
  comm.init();
}

public void printPages() {
  switch(channel) {
    case HELLO: 
    pages.add(new Page("", REFRESH, 0, 0, 0, 0, 1));

    String hello = "What's up"+ (google.loggedin ? " "+profile.givenName : "") +"?";
    pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
    pages.add(new Page("", FONT, 5, 0, 0, 0, 1));
    pages.add(new Page(hello, STRING, 0, 1, 1, 64+6, 1));
    pages.add(new Page("", SERVO, 2, 5, 15, 0, 0));

    break;

    case BYE:
    pages.add(new Page("", SERVO, 0, 0, 0, 0, 1));
    pages.add(new Page("", BACKGROUND, 0, 0, 0, 0, 1));
    pages.add(new Page("", BACKGROUND, 0, 0, 0, 0, 1));

    pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
    pages.add(new Page("", FONT, 5, 0, 0, 0, 1));
    pages.add(new Page("zzz", STRING, 0, 1, 1, 64+6, 1 ));
    break;

    case CONTACTS:
    break;


    default:
    String thisCommandName = "";
    if (channel > 100 && getPilotByCommand(channel) != null) {
      thisCommandName = getPilotByCommand(channel).name;
      } else {
        thisCommandName = "????";
      }
      pages.add(new Page("", SERVO, 2, 5, 15, 0, 0));
      pages.add(new Page("", FONT, 5, 0, 0, 0, 0));
      pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
      pages.add(new Page(thisCommandName, STRING, 0, 1, 1, 64+6, 0));
      break;
    }
  }
}
class MailboxDisplay extends Display {
  PShape outline, window, mask;
  int mode = 0;
  String data = "";

  long lastTick;
  int cursorX = 0;
  int breakX;
  boolean busy = true;

  int displayMode, tack, teck, tick, tock, tuck;

  int w = 128;
  int h = 128;
  float f = 9;

  int foreground, background, top, bottom;
  boolean gradient;

  int currentFont = 0;

  final int SYSTEM5x7 = 0;
  final int COM8x8 = 1;
  final int FONT10x14 = 2;
  final int FONT20x28 = 3;
  final int ARIAL14 = 4;
  final int ARIALB14 = 5;
  final int ARIALB16 = 6;

  int[] widths =  {5, 8, 10, 20, 7, 7, 8};
  int[] heights = {7, 8, 14, 28, 14, 14, 16};

  PGraphics display;

  MailboxDisplay () {
    outline = loadShape("shp/mailbox.svg");
    outline.disableStyle();
    window = loadShape("shp/app.svg");
    window.disableStyle();
    mask = loadShape("shp/mask.svg");
    mask.disableStyle();
    foreground = whiteColor;
    background = redColor;
    top = 0;
    bottom = 0;
    display = createGraphics(128, 128, JAVA2D);
    display.noSmooth();
    display.beginDraw();
    display.background(background, 230);
    display.endDraw();
  }

  public void update() {
  }

  public void display() {
    pushMatrix();
    scale(.63f);
    fill(255);
    stroke(0);
    strokeWeight(thickStroke);
    shape(outline, 0, 0);
    pushMatrix();
    scale(.85f);
    image(display, 0, 70);
    popMatrix();
    noStroke();
    fill(255);
    shape(mask, 0, 60);
    noFill();
    stroke(0);
    strokeWeight(thickStroke);
    shape(window, 0, 60);
    popMatrix();
  }

  public void printString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
    busy = true;
  }
}
final int NONE = 0;
final int BLANK = 1;
final int CENTERED = 2;
final int INSTANT = 3;
final int TICKER = 4;
final int SCROLL = 5;
final int SCROLL_ALL_RIGHT = 6;
final int SCROLL_CENTER_RIGHT = 7;
final int SCROLL_PUSH_RIGHT = 8;
final int SCROLL_ALL_LEFT = 9;
final int SCROLL_CENTER_LEFT = 10;
final int SCROLL_PUSH_LEFT = 11;
final int SLEEP = 12;
final int AIRPORT = 13;
final int BLINK = 14;
final int LOADING = 15;
final int BATTERY = 17;
final int AXIS = 18;
final int ALPHABET = 19;
final int EXTRA = 20;
final int STREAM = 21;
final int BALL = 22;
final int RAIN = 23;
final int SNOW = 24;
final int RANDOM = 25;
final int CLOCK = 26;
final int COUNTER = 27;
final int SPECTRUM = 28;
final int BRIGHTNESS = 29;
final int LOOK = 30;
final int COMPASS = 31;
final int TYPE = 32;
final int SENSORS = 33;

final int WAIT = 50;
final int PING = 54;
final int MENU = 55;

final int SCROLL_DOWN = 56;
final int SCROLL_UP = 57;


final int FOREGROUND = 61;
final int BACKGROUND = 62;
final int STRING = 63;
final int SYMBOL = 64;
final int BITMAP = 65;
final int DIGIT = 66;
final int CHARTABLE = 67;
final int DIRECTORY = 69;
final int SERVO = 70;
final int GRID = 71;
final int GRADIENT = 72;
final int COPY_PIXELS = 73;
final int COPY_BYTES = 74;
final int COPY_GRADIENT = 75;
final int REFRESH = 76;
final int FONT = 77;

// channels

int demoModes[] = {LOOK, ALPHABET, BALL, RAIN, SNOW, COMPASS, RANDOM};
int demoMode = 0;

final int SCAN = -10;
final int LOGOUT = -11;
final int PLAY = -12;
final int UP = -13;
final int DOWN = -14;
final int LEFT = -15;
final int RIGHT = -16;
final int LOOP = -27;
final int KEYBOARD = -18;
final int DEMO = -19;
final int SYNC = -20;
final int OBJECT = -21;
//final int MOBILE = -22;

final int SETTINGS = 100;
final int WIFI = 101;
final int MOBILE = 102;
final int ONLINE = 103;
final int BLUETOOTH = 104;
final int DIM = 105;
final int ENERGY = 106;
final int ORIENTATION = 107;
final int TIME = 108;
final int EQ = 109;
final int LOCATION = 110;
final int ENVIRONMENT = 111;
final int NAVIGATION = 112;
final int RESULTS = 113;


final int HELLO = 150;
final int BYE = 151;
final int SEARCH = 152;
final int STATUS = 153;
final int GOOGLE = 200;
final int CONTACTS = 201;
final int MAIL = 202;
final int CALENDAR = 203;
final int YOUTUBE = 204;
final int DRIVE = 205;
final int TWITTER = 206;
final int FACEBOOK = 207;
final int INSTAGRAM = 208;
final int FOURSQUARE = 209;
final int NEWS = 210;
final int WEATHER = 211;
final int PLAYER = 212;
final int KARAOKE = 213;

// final int PLACES = 212

class Manager {
  int channel;
  boolean play = true;
  boolean loop = false;
  boolean manual = false;

  Manager () {
    //String[] commandList = loadStrings("tsv/commands.txt");
    //for (int i=0; i<commandList.length; i++) {
    //  String thisLine = commandList[i];
    //  if (thisLine.length() > 0) {
    //    String[] items = splitTokens(thisLine, " ");
    //    if (items.length == 5) {
    //      String thisCommand = items[2];
    //      int thisCommandNum = parseInt(items[4].substring(0, items[4].length()-1));
    //    }
    //  }
    //}
  }

  public void update() {
  }


  public void setChannel(int thisCommand) {

    switch(thisCommand) {
      case KEYBOARD:
      keyboard.show();
      break;

      case PLAYER:

      break;

      case YOUTUBE:
      player.play();

      break;

      case UP:
      // if (channel == NAVIGATION) {
      //   places.search(ticker.pages.get(ticker.pageIndex).content);
      //   thisCommand = RESULTS;
      // }
      break;

      case DOWN:
      // if (channel == RESULTS) {
      //   thisCommand = NAVIGATION;
      // }
      break;

      case RIGHT:
      for (Teleobject teleobject : teleobjects) {
        teleobject.nextPage();
      }
      break;

      case LEFT:
      for (Teleobject teleobject : teleobjects) {
        teleobject.previousPage();
      }
      break;

      case SETTINGS:
      debug = !debug;
      break;

      case MOBILE:
      network.update();
      break;

      case WIFI:
      network.update();
      break;

      case ONLINE:
      network.update();
      break;

      case BLUETOOTH:
      if (activeObject != null && !androidMode && !ticker.comm.connected) activeObject.comm.init();

      break;

      case LOGOUT:
      bluetooth.reconnect();
      //google.logout();
      break;

      case SYNC:
      sync = !sync;
      break;

      case LOOP:
      loop = !loop;
      break;

      case PLAY:  
      play = !play;
      break;

      case OBJECT:
      if (activeObject == null) {
        activeObject = ticker;
      } 
      else {
        int nextObject = teleobjects.indexOf(activeObject);
        nextObject ++;
        if (nextObject == teleobjects.size()) {
          activeObject = null ;
        } 
        else {
          activeObject = teleobjects.get(nextObject);
        }
      }
      break;

      case LOCATION:
      geolocation.update();
      break;

      case WEATHER:
      weather.update();
      break;

      case GOOGLE:
      if (!google.loggedin) {
        google.login();
        if (google.authenticating) play = false;
      } 
      else {
        play = true;
      }
      break;

      case CONTACTS:
      if (!contacts.updated) contacts.update();
      break;

      case MAIL:
      if (!mail.updated) mail.update();
      break;

      case CALENDAR:
      if (!calendar.updated) calendar.update();
      break;

      case TWITTER:
      if (twitter.loggedin) {
        twitter.update();
      } 
      else {
        twitter.login();
        twitter.update();
      }
      break;

      case NEWS:
      news.update();
      break;

      case DRIVE:
      if (!drive.updated || true) drive.update(); // to test...
      break;
    }

    // if (thisCommand == DEMO) {
    //   channel = demoModes[demoMode];
    //   if (demoMode == demoModes.length) demoMode = 0;
    //   for (Teleobject teleobject : teleobjects) {
    //     teleobject.initPages(channel);
    //     teleobject.printPages();
    //   }
    // }

    if (thisCommand > 100) {
      channel = thisCommand;
      if (activeObject == null) {
        for (Teleobject teleobject : teleobjects) {
          teleobject.initPages(channel);
          teleobject.printPages();
          teleobject.pageDelay = 0;
          teleobject.ready = true;
          teleobject.display.busy = false;
          teleobject.comm.busy = false;
        }
      } else {
        activeObject.initPages(channel);
        activeObject.printPages();
        activeObject.pageDelay = 0;
        activeObject.ready = true;
        activeObject.display.busy = false;
        activeObject.comm.busy = false;
      }
    }
  }
}

class Messaging {

  ArrayList<Dweet> dweets;
  
  boolean dweet;
  Dweet latestDweet;
  float dweetA, dweetTargetA = 0;
  String lastCreated = "";
  boolean dweeted;
  long lastDweet;
  String teleobject = "ticker";
  String thing = "teleobject";

  Messaging() {
    latestDweet = new Dweet();
    // dweets = new ArrayList<Dweet>();
  }

  public void getDweet() {
    network.pingStart = millis();
    String thing= "teleobjects";
    String url = "https://thingspace.io/get/latest/dweet/for/"+thing;
    println("getting dweet");
    String[] buffer = loadStrings(url);
    if (buffer != null) {
      latestDweet.parse(buffer[0], true);
      if (!lastCreated.equals(latestDweet.created_)) {
        println(buffer);
        lastCreated = latestDweet.created_;
        network.pingTime = PApplet.parseInt(millis()-network.pingStart);

        boolean flag = true;

        for (int i=0; i<latestDweet.properties.size(); i++) {
          String property = latestDweet.properties.get(i);
          if (property.equals("teleobject")) {
            String teleobject_ = latestDweet.values.get(i);
            if (teleobject_.equals(teleobject)) {
              println("sent by my self"); 
              flag = false;
            }
          }
            // if (property.equals("NEWS")&& true) {
            //   if (debug) println("news");
            //   String content = latestDweet.values.get(i);
            //   String[] items = splitTokens(content, "|");
            //   String img = items[1];
            //   display.imagery = requestImage(img);
            //   display.mode = IMAGERY;
            //   lastTilt = 0;
            // }
          }
          if (flag) {
            println("good dweet");
            dweeted = true;
            dweetA = 255;
          }
        }
      }
    }

    public void sendDweetQuietly(String key_, String value_) {
      network.pingStart = millis();
      String url = "https://dweet.io:443/dweet/quietly/for/"+thing+"?"+"teleobject="+teleobject+"&"+key_+"="+encode(value_);
      String[] buffer = loadUrl(url);
      println(url);
      if (buffer != null) {
        // latestDweet.parse(buffer[0], false);
        latestDweet.info = value_;
        network.pingTime = PApplet.parseInt(millis()-network.pingStart);
        dweetA = 255;
      }
    }

    public void sendDweet(String key_, String value_) {
      network.pingStart = millis();
      String url = "https://dweet.io:443/dweet/for/"+thing+"?"+"teleobject="+teleobject+"&"+key_+"="+encode(value_);
      String[] buffer = loadStrings(url);
      //println(url);
      if (buffer != null) {
          latestDweet.parse(buffer[0], false);
        network.pingTime = PApplet.parseInt(millis()-network.pingStart);
        dweetA = 255;
      }
    }

    public void displayDweet(float thisX, float thisY) {
      dweetA += (dweetTargetA - dweetA)*.01f;
      if (latestDweet.info != null) {
        pushMatrix();
        translate(thisX, thisY);
        textAlign(LEFT);
        textFont(font, 16);
        fill(redColor, dweetA);
        text(latestDweet.info, 0, 0);
        popMatrix();
      }
    }
  }

  class Dweet {
    String created_ = "";
    String content_;
    String info;
    String thing_;

    ArrayList<String> properties;
    ArrayList<String> values;
    Dweet() {
    }

    public void parse(String d, boolean getting) {
      processing.data.JSONObject dweetData = processing.data.JSONObject.parse(d);
      String this_ = dweetData.getString("this");
      properties = new ArrayList();
      values = new ArrayList();
      if (this_.equals("succeeded")) {
        String by_ = dweetData.getString("by");
        String the_ = dweetData.getString("the");
        processing.data.JSONObject withObject = null;
        if (getting) {
          processing.data.JSONArray withArray = dweetData.getJSONArray("with");
          withObject= withArray.getJSONObject(0);
        } else {
          withObject = dweetData.getJSONObject("with");
        }
        thing_  = removeBrackets(withObject.getString("thing"));
        created_ = withObject.getString("created");
        processing.data.JSONObject withContent =  withObject.getJSONObject("content");
        String[] properties_ = (String[]) withContent.keys().toArray(new String[withContent.size()]);
        content_ = "";
        for (int i=0; i<properties_.length; i++) {
          properties.add(removeBrackets(properties_[i]));
          values.add(removeBrackets(withContent.getString(properties_[i])));
          content_ += removeBrackets(properties_[i])+"|"+ removeBrackets(withContent.getString(properties_[i]));
        }
      //info = "this "+this_+" by "+by_+" the "+the_+" thing "+thing_;//+" content "+content_;
    } else {
      int with_ = dweetData.getInt("with");
      String because_ = dweetData.getString("because");
      //info = "this "+this_+" with "+with_+" because "+because_;
    }
  }
}


class Karaoke {

  String title;
  String artist;
  String file;
  String[] lyrics;
  ArrayList<String> lines;
  ArrayList<Integer> times;

  boolean playing;
  long startTime;
  int nextLine;
  int nextTime;

  Karaoke() {
    init();
  }

  public void init() {
    file = "2 chainz wiz khalifa - we own it(fast&furious)";
    // file = "coldplay - yellow";
    // file = "daft punk - get lucky";
    lyrics = loadStrings("mp3/"+file+".lrc");
    lines = new ArrayList<String>();
    times = new ArrayList<Integer>();

    for (int i=0; i < lyrics.length; i++ ) {
      String thisLine = lyrics[i];
      if (thisLine.length()>9) {
        if (thisLine.charAt(0) == '[' && thisLine.charAt(3) == ':' && thisLine.charAt(6) == '.' && thisLine.charAt(9) == ']') {
          lines.add(thisLine.substring(10, thisLine.length()));
          times.add((parseInt(thisLine.substring(1, 3))*60*1000) + (parseInt(thisLine.substring(4, 6))*1000)  + parseInt(thisLine.substring(7, 9))*10);
          // println(thisLine.substring(1,3) + "  " + parseInt(thisLine.substring(1,3))*60*1000);
          // println(times.get(times.size()-1) + "\t\t\t"+ lines.get(lines.size()-1));
        }
      }
    }
  }

  public void play() {
    if (!playing) {
      startTime = millis();
      playing = true;
    }
  }
  
  public void stop(){
    playing = false; 
    
  }
  
  public String update() {
    String result = "";
    if (playing) {
      if (times.get(nextLine) <= (millis() - startTime) ) {
        result = lines.get(nextLine);
        nextLine ++;
        if (nextLine == lines.size()) {
          println("end");
          playing = false;
          nextLine = 0;
          nextTime = 10;
        } else {
          nextTime = PApplet.parseInt((times.get(nextLine) - times.get(nextLine-1))/100);
        }
      }
    }
    return result;
  }
}












Minim minim;
AudioPlayer song;


class Player{
	PApplet parent;


	Player(PApplet _parent) {
		parent = _parent;
		minim = new Minim(parent);
		song = minim.loadFile("mp3/"+karaoke.file+".mp3");
	}

	public void play() {
		song.play();
	}

}

/////////////////
// PLACE HOLDERS
/////////////////

// void downloadByteArrayAsImage(String url, String fileName) {
// 	println("downloading file array");
// 	byte[] imageInByte = loadBytes(url);
// 	InputStream in = new ByteArrayInputStream(imageInByte);  
// 	try {
// 		BufferedImage bImageFromConvert = ImageIO.read(in);
// 		ImageIO.write(bImageFromConvert, "png", new File(
// 			sketchPath("data/tmp/"+fileName+".png")));
// 		println("downloaded byte array "+fileName);
// 	} 
// 	catch(Exception e) {
// 		println("error");
// 	}
// }

/////////////////
// GESTURES
/////////////////

class Gestures {
	PApplet parent;
	boolean tapped;
	boolean doubleTapped;
	boolean flicking;
	boolean dragging;
	long lastTap;
	int debounce = 200;
	float startX, startY;

	Gestures(PApplet parent_) {
		parent = parent_;
	}

	public void update() {
		if (dragging) {
			stroke(255, 0, 0);
			line(startX, startY, mouseX, mouseY);
		}
	}
}

public void mousePressed() {
// println(mouseX+" "+mouseY+" "+keyboard.keyboard);
if (millis() - gestures.lastTap > gestures.debounce) {
	gestures.lastTap = millis();
	gestures.tapped = true;
	gestures.dragging = true;
	gestures.startX = mouseX;
	gestures.startY = mouseY;
}
}

public void mouseReleased() {
	gestures.tapped = false;
	gestures.dragging = false;
}

public void mouseDragged()
{
}

/////////////////
// KEYBOARD
/////////////////

class Keyboard {
	PApplet parent;
	boolean keyboard;

	Keyboard(PApplet _parent) {
		parent = _parent;
	}

	public void show() {
	}

	public void hide() {
	}

	public void update() {
	}
}

public void keyPressed() {
	if (key == 10) key = 31;
	if (activeObject != null) {
		activeObject.pages.add(new Page(key+"", TYPE, 0, 0, 0, 0, 1));
	}
}

class Bluetooth {
	boolean available;
	PApplet parent;

	Bluetooth(PApplet _parent) {
		parent = _parent;
	}

	public void update() {
	}

	public void reconnect() {
	}
}

class Sensors {
	PApplet parent;

	Sensors(PApplet _parent) {
		parent = _parent;
		init();
	}

	public void init() {
		if (network.externalIP == null) {
   // geolocation.latitude = 28.659363; 
   // geolocation.longitude = -17.913001;
   geolocation.latitude = 40.735f;
   geolocation.longitude = -73.955f;
   //geolocation.latitude = 28.46944; 
   //geolocation.longitude = - 16.24806;
   geolocation.provider = "fixed";
   geolocation.located = true;
} else {
	String url = "http://www.geoplugin.net/json.gp?ip="+network.externalIP;
	String[] geopluginContent = loadUrl(url);
	if (geopluginContent != null) {
		saveStrings("tmp/geolocation.json", geopluginContent);
		String jsonFragment = "";
		for (int i=0; i<geopluginContent.length; i++) {
			jsonFragment += geopluginContent[i];
		}
		processing.data.JSONObject geolocatedData = processing.data.JSONObject.parse(jsonFragment);
		geolocation.latitude = geolocatedData.getFloat("geoplugin_latitude");
		geolocation.longitude = geolocatedData.getFloat("geoplugin_longitude");
		geolocation.provider = "geoplugin";
		geolocation.located = true;
	}
}
}

public void update() {
}
}

/////////////////
// MIC
/////////////////

class Eq {
	Minim minim;
	AudioInput in;

	char[] eqDataNibble;

	char[] eqData;
	float[] eqVal;
	int res = 32;

	float maxL = .05f;
	float minL = 0;

	float rightL;
	float leftL;
	float eqFilter = .25f;

	Eq (PApplet parent) {
		minim = new Minim(parent);
		in = minim.getLineIn(minim.STEREO, res);
		eqData = new char[res];
		eqVal = new float[res];
		eqDataNibble =new char[res/4];
	}

	public void update() {
		rightL = in.right.level();
		leftL = in.left.level();
		for (int i = 0; i < in.bufferSize(); i++) {
			float targetLevel = abs(in.left.get(i));
			if (targetLevel < maxL / 2) targetLevel += targetLevel/2; 
			eqVal[i] += (targetLevel-eqVal[i])*eqFilter;
			eqData[i] = PApplet.parseChar(PApplet.parseByte(map(eqVal[i], minL, maxL, 0, 7)));
			if (eqData[i] > 7) eqData[i] = 7;
			if (eqData[i] < 0) eqData[i] = 0;
		}


 // for (int i=0; i<res/4; i++) {
 //   int a = int((eqData[(i*4)])/2 << 6);
 //   int b = int((eqData[(i*4)+1])/2 << 4);
 //   int c = int((eqData[(i*4)+2])/2 << 2);
 //   int d = int((eqData[(i*4)+3])/2);
 //   eqDataNibble[i] = char(255-(a | b | c | d));
 //   //if (eqDataNibble[i] == '\n') eqDataNibble[i]++;
 //   //if (eqDataNibble[i] == 0) eqDataNibble[i]++;
 // }
}

public void display() {

}
}

// //    if ( in.isMonitoring() )
// //    {
// //      in.disableMonitoring();
// //    }
// //    else
// //    {
// //      in.enableMonitoring();
// //    }
 

 class Comm {
 	PApplet parent;
 	Serial port;
 	String portNumber;
 	boolean connecting, connected, found, paired, discovering, discovered, acknowledged, busy;
 	boolean parsed;
 	String portName = "";
 	String targetDeviceAddress = "";
 	long lastTx, lastRx;
 	int txR;
 	int rxR;
 	long connectionTime;
 	Teleobject teleobject;

	// PLACEHOLDERS
	String deviceAddress, deviceRssi;

	// PROTOCOL IN
	int packetLength = 15;

	// PROTOCOL OUT
	int headerLength = 7;

	// SENSOR
	float sens = .5f;
	float ax, ay, az;
	boolean shock;
	int mm;
	float battery = 0;
	boolean charging = false;

	int minBat = 320;
	int maxBat = 425;

	int brightness = 1;
	int temperature = 0;
	int pressure = 0;
	int humidity = 0;
	// MEMORY
	float maxMemory = 0;  
	int freeMemory = 0;

	float tiltAngle = 3;

	// final int BLE_PACKET_LENGHT=18;
	// final int TX_SPEED = 200;
	int timeOuts = 0;
	int txDelay;

	Comm(PApplet _parent, Teleobject _teleobject) {
		parent = _parent;
		teleobject = _teleobject;
	}

	public void init() {
		for (int i=0; i<Serial.list().length; i++) {
			if (Serial.list()[i].indexOf(portNumber) != -1) {
				portName = Serial.list()[i];   
				try {
					port = new Serial(parent, portName, 115200);
					connecting = true;
					connected = true;
					discovered = true;
					acknowledged = true;
					connectionTime = millis();
					println("connected to "+portName);
					break;
				} 
				catch (Exception e) {
					println("could not connect to "+portName);
				}
			}
		}
	}

	public void update() {
		if (connected) {
			rx();
		}
	}

	public void terminate() {
		port = null;
		connected = false;
	}

	public void tx(byte[] data) {  
		txR = PApplet.parseInt(millis() - lastTx);
		lastTx = millis();
		port.write(data);
		if (debug) {
			Packet newPacket = new Packet(false, "", getPilot("bluetooth").x);
		}
	}

	public void tx(String str) {
	}

	public void rx() {  
		if (port.available() == packetLength) {
			byte[] data = port.readBytesUntil(254);
			rxR = PApplet.parseInt(millis() - lastRx);
			lastRx = millis();
			if (data != null && data[0] == '>' && data.length >= packetLength) {
				acknowledged = true;
				parseBytes(data);			
			}
			// port.clear();
		}
	}

	public void writeString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
		if (connected) {
			byte[] data = new byte[thisString.length()+headerLength+1];
			data[0] = '>';
			data[1] = (byte)(thisMode+48);
			data[2] = (byte)(tack+48);
			data[3] = (byte)(teck+48);
			data[4] = (byte)(tick+48);
			data[5] = (byte)(tock+48);
			data[6] = (byte)(tuck+48);
			for (int i=0; i < thisString.length(); i++) {  
				data[i+headerLength] = (byte)thisString.charAt(i);
			}
			data [data.length-1] = (byte)'\n';
			tx(data);
			busy = true;
		}
	}

	public void parseBytes(byte[] data) {	
		if (debug) {
			Packet newPacket = new Packet(true, "", getPilot("bluetooth").x);
			newPacket.init();
		}
		mm = data[1];
		ax = PApplet.parseInt(data[3])*(data[2] == 1 ? -1 : 1);
		ay = PApplet.parseInt(data[5])*(data[4] == 1 ? -1 : 1);
		az = PApplet.parseInt(data[7])*(data[6] == 1 ? -1 : 1);
		battery = (data[8]+320.0f)/100.0f;
		charging = (data[9] == 1);
		brightness = data[10];
		pressure = data[11]+1000;
		temperature = data[12]-50;
		humidity = data[13];
		busy = false;
		parsed = true;	
	}
}
 class Network {
 	String hostName; 
 	String hostIP; 
 	String externalIP;

 	String ipFinderUrl = "https://api.ipify.org";

 	String type;
 	String state;
 	String reason;
 	String extra;
 	String ssid;
 	boolean roaming;
 	boolean available;
 	boolean networked;
 	boolean router;
 	boolean wifi;
 	boolean online;
 	boolean pinging;

 	boolean ip;
 	boolean cellular;

 	boolean loading;
 	String connectionTime;

 	int pingTime;
 	long pingStart;
 	String mac = "";
 	int rssi = 0;
 	int linkSpeed = 0;
 	int frequency = 0;

 	Network () {
 		update();
 	}

 	public void update() {
 		try { 
 			InetAddress addr = InetAddress.getLocalHost(); 
 			//byte[] ipAddr = addr.getAddress(); 
 			String raw_addr = addr.toString(); 
 			String[] list = split(raw_addr, '/'); 
 			hostIP = list[1]; 
 			hostName = addr.getHostName();
 			if (hostIP.indexOf(":") != -1 || hostIP.contains("127.0.0.1")) {
 				ip = false;
 				wifi = false;
 				router = false;
 				networked = false;
 			} 
 			else {
 				ip = true;
 				wifi = true;
 				router = true;
 				networked = true;
 				type = "WIFI";
 			}
 		} 
 		catch (UnknownHostException e) {
 			if (verbose) println(e);
 		}

 		if (!pinging) {
 			thread("ping");
 		}
 	}

 	public void getExternalIP() {
 		String[] ip = loadStrings(ipFinderUrl);
 		if (ip != null) {
 			pingTime = PApplet.parseInt(millis() - pingStart);
 			externalIP = ip[0];
 		}
 	}
 }

 public void ping() {
 	network.pinging = true;
 	network.pingStart = millis();
 	if (verbose) println("ping http://www.google.com");  
 	try { 
 		String[] contentThread = loadStrings("http://www.google.com");
 		if (contentThread != null) {
 			network.pingTime = PApplet.parseInt(millis() - network.pingStart);
 			if (debug) {
 				if (verbose) println("ping google in "+network.pingTime+"ms");
 				network.online = true;
 			}
 		} 
 		else {
 			if (verbose) println("unable to reach google");
 			network.online = false;
 		}
 	} 
 	catch (Exception e) {
 		if (verbose) println(e);
 		network.online = false;
 		if (verbose) println("unable to reach google");
 	}
 	network.pinging = false;
 	if (network.online) thread("getExternalIp");
 }

 public void getExternalIp() {
 	String ipFinderUrl = "http://checkip.amazonaws.com"; // "https://api.ipify.org"; // 
 	String[] ip = loadStrings(ipFinderUrl);
 	if (ip != null) {
 		network.externalIP = ip[0];
 	}
 }
ArrayList<Pilot> pilots; 

public void initPilots() {
  pilots = new ArrayList<Pilot>();

  int offsetX = width / 16; 

  Table pilotTable = loadTable("csv/pilotsTop.csv", "header, csv");
  for (int i=0; i<pilotTable.getRowCount(); i++ ) {
    TableRow row = pilotTable.getRow(i);
    Pilot thisPilot = new Pilot(row.getString("name"), row.getString("shape"), row.getInt("command"));
    thisPilot.x = offsetX/2+(offsetX*i);
    thisPilot.s = width/2400.0f;
    thisPilot.y = offsetX-(50*thisPilot.s);
    pilots.add(thisPilot);
  }

  pilotTable = loadTable("csv/pilotsBottom.csv", "header, csv");
  for (int i=0; i<pilotTable.getRowCount(); i++ ) {
    TableRow row = pilotTable.getRow(i);
    Pilot thisPilot = new Pilot(row.getString("name"), row.getString("shape"), row.getInt("command"));
    thisPilot.x = offsetX/2+(offsetX*i);
    thisPilot.s = width/2400.0f;
    thisPilot.y = height-offsetX+(50*thisPilot.s);
    // thisPilot.y = 1000;
    pilots.add(thisPilot);
  }

  //pilotTable = loadTable("csv/pilotsControl.csv", "header, csv");
  //for (int i=0; i<pilotTable.getRowCount(); i++ ) {
  //  TableRow row = pilotTable.getRow(i);
  //  Pilot thisPilot = new Pilot(row.getString("name"), row.getString("shape"), row.getInt("command"));
  //  thisPilot.x = offsetX/2+(offsetX*i);
  //  thisPilot.s = width/2400.0;
  //  thisPilot.y = height-(offsetX);
  //  // thisPilot.y = 1130;
  //  pilots.add(thisPilot);
  //}
}

public void displayPilots() {
  String bluetoothInfo = "";

  for (Teleobject teleobject : teleobjects) {
    if (teleobject.comm != null) {
      if (androidMode) {
        bluetoothInfo += (teleobject.comm.found ? teleobject.comm.portName : teleobject.name + " not found") + "\n";
        bluetoothInfo += (teleobject.comm.paired ? "P" : "p" );
        bluetoothInfo += (teleobject.comm.discovered ? "D" : "d");
        bluetoothInfo += (teleobject.comm.connected ? "C" : "c");        
        bluetoothInfo += (teleobject.comm.acknowledged ? "A" : "a");
        bluetoothInfo += (teleobject.comm.busy ? "B" : "b") + "\n" ;
      } else {
        if (teleobject.comm.connected) {
          bluetoothInfo +=  teleobject.comm.portName +" " +(teleobject.display.busy ? "B" : "b") + "\n";
        }
      }
    }
  }

  String energyInfo = "";
  for (Teleobject teleobject : teleobjects) {
    if (teleobject.comm != null && teleobject.comm.connected) {
      energyInfo += teleobject.comm.battery+"v "+(teleobject.comm.charging ? "c" : "b")+"\n";
    }
  }

  String dimInfo = "";
  for (Teleobject teleobject : teleobjects) {
    if (teleobject.comm != null && teleobject.comm.connected) {
      int index = (int)map(teleobject.comm.brightness, 1, 15, 1, 10);
      dimInfo += index+"0 %\n";
    }
  }

  String environmentInfo = ticker.comm.temperature+"\u00b0C\n"+ ticker.comm.humidity+"%\n"+ticker.comm.pressure+"mba";
  setPilot("environment", manager.channel == ENVIRONMENT);
  setPilot("environment", environmentInfo);

  String currentChannelName = "null";

  Pilot currentPilot = getPilotByCommand(manager.channel);
  if (currentPilot != null) currentChannelName = currentPilot.name.toUpperCase();
  setPilot("play", manager.play);

  // TOP

  setPilot("settings", debug);
  setPilot("settings", width + "x" + height + "px\n" + (retina ? "retina" : "non-retina") + "\n" + (int)frameRate +" fps\n" + currentChannelName);

  setPilot("bluetooth", bluetooth.available);
  setPilot("bluetooth", bluetoothInfo);

  String networkInfo = (network.wifi ? "wifi enabled" : "wifi disabled") + "\n";
  if (network.wifi) {
    if (network.router) {
      networkInfo += (androidMode ? network.ssid : network.hostName)+ "\n";
      networkInfo += network.ip ? network.hostIP : "no IP";
    } else {
      networkInfo += "";
    }
  }
  setPilot("wifi", network.wifi && network.ip);
  setPilot("wifi", networkInfo);

  setPilot("mobile", network.cellular ? network.state + "\n" + network.extra : "" ); // + "\n" + network.reason
  setPilot("mobile", network.cellular);

  setPilot("online", network.online);

  String onlineInfo = (network.online ? "online" : "offline") + "\n";
  if (network.online) {
    onlineInfo += network.type + "\n" + network.externalIP + "\n" + network.pingTime + "ms";
  }
  setPilot("online", onlineInfo);

  setPilot("energy", manager.channel == ENERGY);
  setPilot("energy", energyInfo);

  setPilot("orientation", manager.channel == ORIENTATION);
  setPilot("orientation", "P "+(ticker.comm.ay>=0?"+":"")+PApplet.parseInt(ticker.comm.ay)+"\n"+"R "+(ticker.comm.ax>=0?"+":"")+PApplet.parseInt(ticker.comm.ax)+"\n"+"H "+(ticker.comm.az>=0?"+":"")+PApplet.parseInt(ticker.comm.az));

  setPilot("time", manager.channel == TIME);
  setPilot("time", getStringTime(true, ":")+"\n"+getStringDate("/"));

  setPilot("sync", sync);

  setPilot("search", manager.channel == SEARCH);



  setPilot("dim", manager.channel==DIM);
  setPilot("dim", dimInfo);

  setPilot("eq", manager.channel==EQ);
  setPilot("eq", "R "+nf((int)(eq.rightL*1000), 3, 0)+"\nL "+nf((int)(eq.leftL*1000), 3, 0));

  setPilot("navigation", manager.channel==NAVIGATION);

  setPilot("location", manager.channel==LOCATION);
  setPilot("location", getCoordinate(geolocation.latitude, true)+"\n"+getCoordinate(geolocation.longitude, false)+"\n"+geolocation.provider+", "+(time.currentTimeStamp-geolocation.lastUpdated)/1000+"s\n"+geolocation.houseNumber+" "+geolocation.street+"\n"+geolocation.neighbourhood);
  setPilot("sleep", manager.channel==SLEEP);
  setPilot("sleep", (int)frameRate+" fps\n"+width+"x"+height+"px");

  // BOTTOM

  setPilot("google", google.loggedin);
  if (profile != null && google.loggedin) {
    setPilot("google", profile.givenName+" "+ profile.familyName+"\n"+profile.email+"\n"+profile.id+"\n"+profile.kind+"\n"+profile.minAge+"\n"+profile.language);
    if (profile.img != null && google.loggedin) {
      setPilot("google", profile.img);
    } else {
      getPilot("google").img = null;
    }
  }

  setPilot("mail", manager.channel==MAIL);

  setPilot("contacts", manager.channel==CONTACTS);
  setPilot("contacts", contacts.contactList.size()+" contacts");

  setPilot("calendar", manager.channel==CALENDAR);
  setPilot("calendar", calendar.eventList.size()+" events");

  setPilot("youtube", manager.channel==YOUTUBE);

  setPilot("drive", manager.channel==DRIVE);

  setPilot("twitter", manager.channel==TWITTER);

  String twitterInfo = "";
  if (twitter.updated) twitterInfo += twitter.name+"\n@"+twitter.screenName+"\n"+twitter.userID+"\n"+twitter.followers.size()+" followers\n"+twitter.friends.size()+" friends\n"+twitter.trends.size()+" trending topics";
  setPilot("twitter", twitterInfo);
  if (twitter.img != null) setPilot("twitter", twitter.img);

  setPilot("facebook", manager.channel==FACEBOOK);

  setPilot("instagram", manager.channel==INSTAGRAM);

  setPilot("foursquare", manager.channel==FOURSQUARE);

  setPilot("news", manager.channel==NEWS);
  setPilot("news", getEasyTimeStamp(news.lastUpdated));

  setPilot("weather", manager.channel==WEATHER);

  String weatherInfo = "";

  if (weather.updated) weatherInfo = weather.conditionMain+", "+(time.currentTimeStamp-weather.lastUpdated)/1000+"s"+"\n"+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + (metric ? "\u00b0C" : PApplet.parseChar(29)+"\u00b0F")+"\n"+PApplet.parseInt(weather.humidity)+"% humidity"+"\n"+
    weather.pressure+"mPa \n"+weather.clouds+"% clouds\n"+weather.windSpeed+"m/h "+getHeading(weather.windDeg)+"\n"+ getEasyTimeStamp(weather.lastUpdated);
  setPilot("weather", weatherInfo);

  // CENTER

  setPilot("play", manager.play);
  setPilot("loop", manager.loop);

  for (Pilot thisPilot : pilots) {
    thisPilot.check();
    thisPilot.display();
  }
}


class Pilot {
  String label;
  String name;
  int command;
  boolean state;
  PShape icon;
  float x, y, s;
  //float sx, sy;
  float val;
  PImage img;

  Pilot(String thisName, String thisShape, int thisCommand) {
    name = thisName;
    if (thisShape.equals("bluetooth") && !androidMode) thisShape = "usb";
    icon = loadShape("svg/"+thisShape+".svg");
    icon.disableStyle();
    command = thisCommand;
  }

  public void display() {
    pushMatrix();
    translate(x, y);
    scale(s);

    //noStroke();
    //fill(80);
    //shape(app, 0, 0);


    // if (gui.refresh) {
    // rectMode(CENTER);
    // noStroke();
    // fill(backgroundColor);
    // rect(0, 0, 120, 120);
    if (img != null) {
      pushMatrix();
      scale(112.0f/img.width*1.0f);
      imageMode(CENTER);
      image(img, 0, 0);
      popMatrix();
      noStroke();
      fill(backgroundColor);
      shape(mask, 0, 0);
    } else {
      noFill();
      stroke(state ? redColor : 150);
      strokeWeight(2);
      shape(icon, 0, 0);
    }
    noFill();
    strokeWeight(2);
    stroke(state ? redColor : 150);
    shape(app, 0, 0);
    // }       
    if (label!=null && debug) { 
      fill(real ? 50 : 200);
      textAlign(CENTER);
      int lineHeight = androidMode ? 24 : 24;
      int offsetY =  y < height/2 ? 84 : (-84 - (countChar(label, '\n')*lineHeight));
      text(label, 0, offsetY);
    }
    popMatrix();
  }

  public void check() {
    if (gestures.tapped && dist(x, y, mouseX, mouseY) < 60*s) {
      manager.setChannel(command);
      gestures.tapped = false;
    }
  }
}

// void setPilotRotation(String thisPilot, boolean thisRotation) {
//   for (Pilot pilot : pilots) {
//     if (pilot.name.equals(thisPilot)) {
//       pilot.rotating = thisRotation;
//       break;
//     }
//   }
// }

public Pilot getPilot(String thisPilot) {
  for (Pilot pilot : pilots) {
    if (pilot.name.equals(thisPilot)) {
      return pilot;
    }
  }
  return null;
}

public Pilot getPilotByCommand(int thisCommand) {
  for (Pilot pilot : pilots) {
    if (pilot.command == thisCommand) {
      return pilot;
    }
  }
  return null;
}

public void setPilot(String thisPilot, boolean thisState) {
  for (Pilot pilot : pilots) {
    if (pilot.name.equals(thisPilot)) {
      pilot.state = thisState;
      break;
    }
  }
}

public void setPilot(String thisPilot, String thisLabel) {
  for (Pilot pilot : pilots) {
    if (pilot.name.equals(thisPilot)) {
      pilot.label = thisLabel;
      break;
    }
  }
}

public void setPilot(String thisPilot, PImage img) {
  for (Pilot pilot : pilots) {
    if (pilot.name.equals(thisPilot)) {
      pilot.img = img;
      break;
    }
  }
}
class ReelDisplay extends Display {
  PShape outline, wheel, wheel_mask;

  int mode = 0;
  String data = "";

  long lastTick;
  int cursorX = 0;
  int breakX;
  boolean busy;
  int displayMode, tick, tock, tuck;

  int[] heights = {7, 8, 14, 28, 14, 14, 16};

  int dotNum = 16;
  float dotR = 8;
  float offsetX = 18;
  int[] colorDots, targetDots;

  float angleL, angleR;
  float targetL, targetR;

  int lMax, lAcc, lPos;
  int rMax, rAcc, rPos;

  ReelDisplay () {
    outline = loadShape("shp/reel.svg");
    outline.disableStyle();
    wheel = loadShape("shp/wheel.svg");
    wheel.disableStyle();
    wheel_mask = loadShape("shp/wheel_mask.svg");
    wheel_mask.disableStyle();
    colorDots = new int[dotNum];
    targetDots = new int[dotNum];
    for (int i=0; i< colorDots.length; i++) {
      colorDots[i] = redColor;
    }
  }

  public void update() {
  }

  public void display() {
    fill(255);
    stroke(0);
    strokeWeight(thickStroke);
    shape(outline, 0, 0);
    pushMatrix();
    translate(offsetX/2, 0);
    translate(-offsetX * dotNum /2, 36);
    for (int i=0; i< colorDots.length; i++) {
      noStroke();
      fill(255, 0, 0, red(colorDots[i])*16);
      ellipse(i*offsetX, 0, dotR, dotR);
    }
    popMatrix();
    pushMatrix();
    translate(-135, -100);
    scale(.97f);
    rotate(angleL);
    noStroke();
    fill(255);
    shape(wheel_mask, 0, 0);
    noFill();
    stroke(0);
    strokeWeight(thickStroke);
    shape(wheel, 0, 0);

    popMatrix();
    pushMatrix();
    translate(135, -100);
    scale(.97f);
    rotate(angleR);
    noStroke();
    fill(255);
    shape(wheel_mask, 0, 0);
    noFill();
    stroke(0);
    strokeWeight(thickStroke);
    shape(wheel, 0, 0);    popMatrix();
  }

  public void printString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
  }

  public void randomReds(int b) {
    for (int i=0; i< colorDots.length; i++) {
      colorDots[i] = color(random(b), 0, 0);
    }
  }
}
/////////////////////////////////////
// PLACES
/////////////////////////////////////

class Places {
  ArrayList<String> placeList, results;
  String types;
  boolean placed;
  String appKey;

  Places () {
    init();
  }

  public void init() {
    if (credentials.credentials != null) {
      appKey = credentials.credentials[2];
    }
    placeList = new ArrayList<String>();
    String[] placeTypes = loadStrings("csv/place_types_short.csv");
    for (int i=0; i<placeTypes.length; i++) {
      placeList.add((placeTypes[i]));
    }
  }

  public void search(String str) {
    types = placeList.get(ticker.pageIndex);
    int radius = 500;
    results = new ArrayList<String>();
    String placesUrl = "https://maps.googleapis.com/maps/api/place/radarsearch/json?location="+geolocation.latitude+","+geolocation.longitude+"&radius="+radius+"&types="+encode(types)+"&key="+appKey; // &keyword=vegetarian&
    String placesContent[] = loadUrl(placesUrl);
    if (placesContent != null) {
      String placesFragment ="";
      for (int i=0; i<placesContent.length; i++) {
        placesFragment += placesContent[i];
      }
      processing.data.JSONObject placesJSON = processing.data.JSONObject.parse(placesFragment);
      if (placesJSON != null) {
        processing.data.JSONArray placesArray = placesJSON.getJSONArray("results");
        int numberOfPlaces = placesArray.size();

        for (int i=0; i<numberOfPlaces && i < numberOfPlaces && i < 10; i++) {
          processing.data.JSONObject onePlace = placesArray.getJSONObject(i);
          String onePlaceId = onePlace.getString("place_id");
          String placeDetailsUrl = "https://maps.googleapis.com/maps/api/place/details/json?placeid="+onePlaceId+"&key="+appKey;
          String[] placeDetailContent = loadUrl(placeDetailsUrl);
          if (placeDetailContent != null) {
            String placeDetailFragment ="";
            for (int j=0; j<placeDetailContent.length; j++) {
              placeDetailFragment += placeDetailContent[j];
            }
            processing.data.JSONObject placeDetailJSON = processing.data.JSONObject.parse(placeDetailFragment);
            processing.data.JSONObject placeResult = placeDetailJSON.getJSONObject("result");
            //processing.data.JSONObject placeGeometry = placeResult.getJSONObject("geometry");
            //println(placeGeometry);
            results.add(placeResult.getString("name"));
            println(placeResult.getString("name"));
          }
        }
        placed = true;
      }
    }
  }
}

/////////////////////////////////////
// NEWS
/////////////////////////////////////

class News {
  String newsKey;// = "df5b7c70d8675c367c0cbacc5b8879e0:11:74861169";
  ArrayList<Article> articles;
  boolean updated;
  long lastUpdated;

  News() {
    if (credentials.credentials != null) {
      newsKey = credentials.credentials[4];
    }
  }

  public void update() {
    String[] newsContent = null;

    //newsContent = loadStrings("tmp/news.json");
    //lastUpdated = getFileTimeStamp("tmp", "news.json");

    if (network.online && refresh) { // add time stamp check
      String newsUrl = "http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/1.json?api-key="+encode(newsKey);
      newsContent = loadUrl(newsUrl);
      lastUpdated = time.currentTimeStamp;
      //saveLocal("news.json", newsContent);
    } 

    if (newsContent != null) {
      articles = new ArrayList<Article>();
      String newsFragment = newsContent[0];
      JSONObject newsJSON = processing.data.JSONObject.parse(newsFragment);
      JSONArray newsArray = newsJSON.getJSONArray("results");
      int numberOfNews = newsArray.size();
      for (int i=1; i<numberOfNews; i++) {
        JSONObject newsObject = newsArray.getJSONObject(i);
        String newsTitle = newsObject.getString("title");
        String newsSection = newsObject.getString("section");
        String newsKeywords = newsObject.getString("adx_keywords");
        String newsAbstract = newsObject.getString("abstract");
        String newsAuthor;
        if (!newsObject.isNull(newsObject.getString("byline")))  newsAuthor = newsObject.getString("byline");
        // String newsType = newsObject.getString("section");
        String imageUrl = "";
        try {
          JSONArray mediaArray = newsObject.getJSONArray("media");
          JSONObject mediaContent = mediaArray.getJSONObject(0);
          JSONArray mediaMetadataArray = mediaContent.getJSONArray("media-metadata");
          JSONObject imageData = mediaMetadataArray.getJSONObject(0);
          imageUrl = imageData.getString("url");
          // println(imageUrl);
        } 
        catch(Exception e) {
          //println("no media");
        }
        String items[] = splitTokens(newsKeywords, ";");
        int count = 0;
        Article article = new Article();
        article.imageUrl = imageUrl;
        article.title = newsTitle;
        article.section = newsSection ;
        article.content = newsAbstract;
        for (int j=0; j<items.length && count < 5; j++) {
          if (items[j].length() < 28) {
            String keyword = cleanKeyword(items[j]);
            if (keyword != null && keyword.length() >0 ) {
              count ++;
              article.keywords.add(keyword);
            }
          }
        }    
        if (article.keywords.size() > 0) articles.add(article);
      }
      updated = true;
    }
  }

  public String cleanKeyword(String str) {
    int parenthesis = str.indexOf("(");
      if (parenthesis != -1) {
        str = removeSpaces(str.substring(0, parenthesis-1));
      }
      int comma = str.indexOf(",");
      if (comma != -1) {
        str = str.substring(comma+1, str.length())+" "+removeSpaces(str.substring(0, comma));
      }
      return removeSpaces(str);
    }
  }

  class Article {
    String title;
    String content;
    String author;
    String section;
    String source;
    String date;
    ArrayList<String> keywords = new ArrayList<String>();
    String imageUrl;
  }

/////////////////////////////////////
// GEOLOCATION
/////////////////////////////////////



class Geolocation {
  String provider;
  double longitude, latitude, altitude, accuracy;
  String displayName;
  String postCode, country, countryCode, state, county, city, suburb, neighbourhood, street, houseNumber, building;
  long lastUpdated;
  boolean updated;
  boolean located;

  String formattedAddress;

  Geolocation() {
  }

  public void update() {
    String[] geolocationContent = null;//loadLocal("location.json");
    //lastUpdated = getFileTimeStamp("tmp", "location.json");
    String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng="+latitude+","+longitude+"&key=AIzaSyCKVs8ruHWC9-gx2b2XpNz2AxzqUYvAD6c";
    if (located && network.online && refresh) {
      geolocationContent = loadUrl(url);      
    }
    if (geolocationContent != null) { 
      lastUpdated = time.currentTimeStamp;   
      String jsonFragment ="";
      for (int i=0; i<geolocationContent.length; i++) {
        jsonFragment += geolocationContent[i];
      }
      processing.data.JSONObject geolocationJSON = processing.data.JSONObject.parse(jsonFragment);
      processing.data.JSONArray results = geolocationJSON.getJSONArray("results");
      formattedAddress = results.getJSONObject(0).getString("formatted_address");
      println(geolocationContent);
      updated = true;
    }
  }
}

// class Geolocation {
//   String provider;
//   double longitude, latitude, altitude, accuracy;
//   String displayName;
//   String postCode, country, countryCode, state, county, city, suburb, neighbourhood, street, houseNumber, building;
//   long lastUpdated;
//   boolean updated;
//   boolean located;

//   Geolocation() {
//   }

//   void update() {
//     String[] geolocationContent = null;//loadLocal("location.json");
//     //lastUpdated = getFileTimeStamp("tmp", "location.json");

//     //http://api.openweathermap.org/data/2.5/weather?lat=28.46926673326195&lon=-16.24783340413054&appid=1ebe1cb0874724fa15a5a109140d6e4e&units=imperial

//     if (located && network.online && refresh) {
//       //String url = "http://nominatim.openstreetmap.org/reverse?lat="+latitude+"&lon="+longitude+"&format=json";

//       String url = "http://nominatim.openstreetmap.org/reverse?lat=28.46926673326195&lon=-16.24783340413054&format=json";

//         //String url = "http://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&format=json";

//         geolocationContent = loadUrl(url);
//       lastUpdated = time.currentTimeStamp;
//       //saveLocal("location.json", geolocationContent);
//     }
//     if (geolocationContent != null) {    
//       String jsonFragment = geolocationContent[0];
//       processing.data.JSONObject geolocatedData = processing.data.JSONObject.parse(jsonFragment);
//       processing.data.JSONObject address = geolocatedData.getJSONObject("address");
//       if (!address.isNull("display_name")) displayName = address.getString("display_name");
//       if (!address.isNull("country")) country = address.getString("country");
//       if (!address.isNull("country_code")) countryCode = address.getString("country_code");
//       if (!address.isNull("state")) state = address.getString("state");
//       if (!address.isNull("county")) county = address.getString("county");
//       if (!address.isNull("city")) city = address.getString("city");
//       if (city == null && !address.isNull("town")) city = address.getString("town");
//       if (!address.isNull("suburb")) suburb = address.getString("suburb");
//       if (!address.isNull("neighbourhood")) neighbourhood = address.getString("neighbourhood");
//       if (!address.isNull("road")) street = address.getString("road");
//       if (street == null && !address.isNull("pedestrian")) street = address.getString("pedestrian");
//       if (!address.isNull("house_number")) houseNumber = address.getString("house_number");
//       if (!address.isNull("building")) building = address.getString("building");
//       if (!address.isNull("postcode")) postCode = address.getString("postcode");
//       updated = true;
//     }
//   }
// }

/////////////////////////////////////
// TIME
/////////////////////////////////////

class Time {
  String dayStr, monthStr;
  int day;
  int month;
  int year;
  long currentTimeStamp = 0;
  long startTimeStamp = 0;

  String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
  String[] monthNames ={"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

  Time() {
    init();
    update();
  }

  public void init() {
    Date d = new Date();
    startTimeStamp = d.getTime();
    Calendar cal = Calendar.getInstance();
    cal.setTime(d);
    int dayTemp = cal.get(Calendar.DAY_OF_WEEK);
    dayTemp -= 2;  // ???
    if (dayTemp < 0) dayTemp += 7;
    dayStr = dayNames[dayTemp];
    day = cal.get(Calendar.DAY_OF_MONTH);
    month = cal.get(Calendar.MONTH)+1;
    monthStr = monthNames[month-1];
    year = cal.get(Calendar.YEAR);
    currentTimeStamp = d.getTime();
  }

  public void update() {
    Date d = new Date();
    currentTimeStamp = d.getTime();
  }
}

/////////////////////////////////////
// WEATHER
/////////////////////////////////////

class Weather {
  String appId;

  boolean updated;
  long lastUpdated;
  int weatherRefresh = 300;
  float windSpeed, windDeg, windGust, rain, clouds;
  String condition, conditionMain;
  float  temp, pressure, humidity;
  String station;

  Weather() {
    if (credentials.credentials != null) {
      appId = credentials.credentials[5];
    }
  }

  public void update() {
    String[] weatherContent =  null;//loadLocal("weather.json");
    //lastUpdated = getFileTimeStamp("tmp", "weather.json");

    if (network.online && (refresh || weatherContent != null) && geolocation.located) { 
      String weatherUrl = "http://api.openweathermap.org/data/2.5/weather?lat="+geolocation.latitude+"&lon="+geolocation.longitude+"&appid="+appId+"&units=imperial";
      weatherContent = loadUrl(weatherUrl);
      if (weatherContent != null) {
        //saveLocal("weather.json", weatherContent);
        lastUpdated = time.currentTimeStamp;
      }
    }

    if (weatherContent != null) {
      String weatherFragment = weatherContent[0];
      println(weatherFragment);
      processing.data.JSONObject weatherJSON = processing.data.JSONObject.parse(weatherFragment);
      if (!weatherJSON.isNull("name")) station = weatherJSON.getString("name");
      processing.data.JSONArray weatherArray = weatherJSON.getJSONArray("weather");
      processing.data.JSONObject weather= weatherArray.getJSONObject(0);
      condition = weather.getString("description");
      conditionMain = weather.getString("main");
      processing.data.JSONObject main = weatherJSON.getJSONObject("main");
      temp = main.getFloat("temp");
      humidity = main.getFloat("humidity");
      pressure = main.getFloat("pressure");
      processing.data.JSONObject cloudsData = weatherJSON.getJSONObject("clouds");
      clouds = cloudsData.getFloat("all");
      if (weatherJSON.hasKey("wind")) {
        processing.data.JSONObject windData = weatherJSON.getJSONObject("wind");
        windSpeed =  windData.getFloat("speed");
        if (windData.hasKey("deg")) {
          windDeg = windData.getFloat("deg");
        }
        if (windData.hasKey("gust")) {
          windGust = windData.getFloat("gust");
        }
      }
      if (weatherJSON.hasKey("rain")) {
        processing.data.JSONObject rainData = weatherJSON.getJSONObject("rain");
      }
      if (weatherJSON.hasKey("clouds")) {
        processing.data.JSONObject cloudData = weatherJSON.getJSONObject("clouds");
        clouds = cloudData.getFloat("all");
      }
      updated = true;
    }
  }
}

/////////////////////////////////////
// CREDENTIALS
/////////////////////////////////////

class Credentials {
  String[] credentials;

  Credentials() {
    credentials = loadStrings("key/credentials.csv");
    if (credentials != null) {
      String items[] = splitTokens(credentials[0], ",");
      session = new TembooSession(items[0], items[1], items[2]);
    }
  }
}
class Teleobject {
  PApplet parent;
  String name;
  Comm comm = null;
  Display display;
  ArrayList<Page> pages = new ArrayList<Page>();
  int pageIndex = -1;
  int lastPageIndex = -1;
  long lastPage;
  int pageDelay;// = 2000;
  boolean newPage;
  int channel;
  boolean ready;
  boolean direction;
  boolean manual;

  public void init() {
  }

  public void update() {
    if (comm != null) {

      if (comm.connected && !comm.acknowledged && millis() > comm.lastTx + 500) {
        comm.writeString("", PING, 0, 0, 0, 0, 0);
      }

      if (comm.connected && comm.connecting && comm.acknowledged) {
        comm.connecting = false;
        //comm.greeted = true;
        manager.setChannel(HELLO);
        manager.loop = true;
        comm.busy = false;
        ready = true;
      }

      if (channel == EQ) {
        comm.busy = false;
        ready = true;
      }  

      if (comm.connected) {
        comm.update();
        if (androidMode && comm.busy && !display.busy && millis() > comm.lastTx + 1000) { // so it does not get stacked, if missed a packet...
          println("timeout waiting");
          //comm.timeOuts ++;
          //comm.writeString("", PING, 0, 0, 0, 0, 0);  
          //comm.busy = false;
        }
        if (comm.busy) {
          lastPage = millis();
        } else {
          ready = true;
        }
      } else {
        if (display.busy) {
          lastPage = millis();
        } else {
          ready = true;
        }
      }

      if (comm.parsed) {
        //comm.parsed = false;
        //if (comm.mm != display.mode) {
        //  if (comm.mm == COMPASS || comm.mm == CLOCK || comm.mm == RAIN || comm.mm == AXIS || comm.mm == BATTERY || comm.mm == SLEEP || comm.mm == BRIGHTNESS || comm.mm == LOOK) {
        //    switch(comm.mm) {
        //    case AXIS:
        //      manager.channel = ORIENTATION;
        //      break;
        //    case COMPASS:
        //      manager.channel = NAVIGATION;
        //      break;
        //    case CLOCK:
        //      manager.channel = TIME;
        //      break;
        //    case BATTERY:
        //      manager.channel = ENERGY;
        //      break;
        //    case BRIGHTNESS:
        //      manager.channel = DIM;
        //      break;
        //    }
        //    display.mode = comm.mm;
        //    channel = manager.channel;
        //  }
        //}
      }
    }


    play();
  }

  public void play() {
    if (ready && millis() > lastPage + pageDelay && pages.size() > 0 && pageIndex != -1 && pageIndex != lastPageIndex && pageIndex < pages.size()) { 
      lastPage = millis();
      Page thisPage = pages.get(pageIndex);
      int tmpMode = thisPage.mode;
      if (manual) {
        // if (name.equals("ticker")) tmpMode= direction ? SCROLL_PUSH_RIGHT : SCROLL_PUSH_LEFT;
        manual = false;
      }
      writeString(thisPage.content, tmpMode, thisPage.tack, thisPage.teck, thisPage.tick, thisPage.tock, thisPage.tuck);
      pageDelay = thisPage.tuck * 100;
      lastPageIndex = pageIndex;
      ready = false;
      if (manager.play) {
        pageIndex++;
        if (pageIndex == pages.size()) {                  
          if ((manager.loop && pages.size() > 1) || manager.channel == EQ || manager.channel == KARAOKE) {
            initPages(channel);
            printPages();
          }
        }
      }

      ///////////////// HACK
      // if (manager.channel == CONTACTS && name.equals("ticker") && pageIndex > 0) {
      //   mailbox.initPages(CONTACTS);
      //   mailbox.pages.add(new Page("", SERVO, 2, 5, 15, 0, 0));
      //   mailbox.pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
      //   mailbox.pages.add(new Page("", FONT, 5, 0, 0, 0, 0));
      //   mailbox.pages.add(new Page(pages.get(pageIndex).content, STRING, 0, 1, 1, 64+6, 1 ));
      // }
      ///////////////// HACK

      // if (name.equals("ticker")) {
      //   if (sync) {
      //     messaging.sendDweetQuietly("content",  thisPage.content+"|"+tmpMode+"|"+thisPage.tack+"|"+thisPage.teck+"|"+thisPage.tick+"|"+thisPage.tock+"|"+thisPage.tuck);
      //   }
      // }
    }
  }

  public void initPages(int _channel) {
    pages = new ArrayList<Page>();
    channel = _channel;
    lastPageIndex = -1;
    pageIndex = 0;
  }

  public void nextPage() {
    lastPage = pageIndex;
    pageIndex++;
    if (pageIndex == pages.size()) pageIndex = 0;
    ready = true;
    manual = true;
    direction = true;
    pageDelay = 0;
    play();
  }

  public void previousPage() {
    lastPage = pageIndex;
    pageIndex--;
    if (pageIndex < 0) pageIndex = pages.size()-1;
    ready = true;
    manual = true;
    direction = false;
    pageDelay = 0;
    play();
  }

  public void display(float x, float y) {
    pushMatrix();
    translate(x, y);
    display.display();
    popMatrix();
  }

  public void printPages() {
  }

  public void checkSensors() {
  }

  public void writeString(String content, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
    if (thisMode > 0) {
      // if (content.length() > 256 - comm.headerLength - 2) content = content.substring(0, 256-comm.headerLength-2); // restrict content to buffer size !!!
      if (content.length() == 128 - comm.headerLength - 1) content += " "; // avoid packets of 127, they crash, hack!!! check!!!
      content = display.cleanUp(content);
      comm.writeString(content, thisMode, tack, teck, tick, tock, tuck);
      display.printString(content, thisMode, tack, teck, tick, tock, tuck);
      if (verbose) println (name+"|"+thisMode+"|"+tack+"|"+teck+"|"+tick+"|"+tock+"|"+tuck+"|"+content);
    }
  }
}

class Page {
  String content;
  int mode, tack, teck, tick, tock, tuck;

  Page (String _content, int _mode, int _tack, int _teck, int _tick, int _tock, int _tuck) {
    content = _content;
    mode = _mode;
    tack = _tack;
    teck = _teck;
    tick = _tick;
    tock = _tock;
    tuck = _tuck;
  }
}

//////////
// REEL
//////////

class Reel extends Teleobject {
  Reel(PApplet _parent) {
    parent = _parent;
  }

  public void init() {
    comm = new Comm(parent, this);
    display = new ReelDisplay();
    comm.portNumber = "1441";
    comm.targetDeviceAddress = "C0:70:75:10:D9:AF";
    comm.init();
  }

  public void initPages(int _channel) {
    channel = _channel;
  }

  public void play() {
    if (ready && pages.size() > 0 && millis() > lastPage + pageDelay) { 
      lastPage = millis();
      Page thisPage = pages.get(0);
      pages.remove(0);
      pageDelay = thisPage.tuck * 100;
      comm.writeString(thisPage.content, thisPage.mode, thisPage.tack, thisPage.teck, thisPage.tick, thisPage.tock, thisPage.tuck);
      ready = false;
    }
  }

  public void printPages() {
    ready = true;
    switch(channel) {
    case HELLO:
      pages.add(new Page("", TICKER, 0, 0, 0, 0, 0));
      break;

    case BYE:
      pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
      break;

    case ENERGY:
      pages.add(new Page("", BATTERY, 0, 0, 0, 0, 0));
      break;

    default:
    }
  }
}

class Frame extends Teleobject {
  Frame(PApplet _parent) {
    parent = _parent;
  }

  public void init() {
    display = new FrameDisplay();
  }
}

class Display {
  boolean busy;
  int mode, lastMode;

  Display() {
  }

  public void init() {
  }

  public void display() {
  }

  public void update() {
  }

  public String cleanUp(String str) {
    return str;
  }

  public void printString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
  }
}
class Ticker extends Teleobject {

  Ticker(PApplet _parent) {
    parent = _parent;
  }

  // void setMode(int thisMode) {
  // println(thisMode);
  // }

  public void init() {
    comm = new Comm(parent, this);
    comm.portNumber = "1411";
    comm.targetDeviceAddress = "FB:57:53:9C:DF:10";
    display = new TickerDisplay();
    comm.init();
  }

  public void printPages() {
    switch (channel) {
      case STATUS:
      int sp = 5;
      //String hi = "Hi"+ (google.loggedin ? " "+profile.givenName : "");
      pages.add(new Page("SYSTEM", TICKER, 0, 0, 60, 0, 10));
      // pages.add(new Page(".", COUNTER, 1, 0, 30, 0, 9));
      // pages.add(new Page("", BLANK, 0, 0, 30, 0, 10));
      pages.add(new Page( nf(hour(), 2, 0) + nf(minute(), 2, 0) + nf(second(), 2, 0), CLOCK, 1, 1, 0, 0, sp));
      pages.add(new Page(time.month +" / "+time.day +" / "+ time.year, CENTERED, 1, 1, 0, 0, sp));
      pages.add(new Page("", BATTERY, 0, 0, 0, 0, sp));
      pages.add(new Page("", BRIGHTNESS, 0, 0, 0, 0, sp));
      pages.add(new Page("", SENSORS, 0, 0, 0, 0, sp));
      pages.add(new Page("", AXIS, 0, 0, 0, 0, sp));
      pages.add(new Page("", COMPASS, 0, 0, 0, 0, sp));
      pages.add(new Page(getCoordinate(geolocation.latitude, true)+"    "+getCoordinate(geolocation.longitude, false), CENTERED, 0, 0, 0, 0, sp));

      if (comm.connected) {
        if (!androidMode) {
          pages.add(new Page("we're tethered to "+comm.portName, TICKER, 0, 0, 25, sp, sp));
        } else {
          pages.add(new Page("bluetooth "+comm.deviceAddress, TICKER, 0, 0, 25, sp, sp));
          pages.add(new Page(""+comm.deviceRssi+" dB signal strength", TICKER, 0, 0, 25, sp, sp));
        }
      }

      if (network.wifi) {
        if(androidMode) {
          pages.add(new Page("wifi network " + network.extra, TICKER, 0, 0, 25, sp, sp));
          pages.add(new Page("mac address " + network.mac.toUpperCase(), TICKER, 0, 0, 25, sp, sp));
          pages.add(new Page("our state is " + network.state, TICKER, 0, 0, 25, sp, sp));
          pages.add(new Page("signal strength " + network.rssi + "dB", TICKER, 0, 0, 25, sp, sp));
          pages.add(new Page("link speed " + network.linkSpeed + "Mbsp", TICKER, 0, 0, 25, sp, sp));
          pages.add(new Page("frequency " + network.frequency+" Mhz", TICKER, 0, 0, 25, sp, sp));
        }
        if (network.hostName != null) { 
          pages.add(new Page("our host is "+network.hostName, TICKER, 0, 0, 25, sp, sp));
        }
        pages.add(new Page("our local ip is " + network.hostIP, TICKER, 0, 0, 25, sp, sp));
      } else { 
        pages.add(new Page("our wifi is disabled, damn!", TICKER, 0, 0, 25, 0, sp));
      }

      if (network.cellular) {
        pages.add(new Page("we're connected to cellular network" + network.extra, TICKER, 0, 0, 25, sp, sp));
        pages.add(new Page("with a " + network.type + " link", TICKER, 0, 0, 25, sp, sp));
        pages.add(new Page("our local ip is " + network.hostIP, TICKER, 0, 0, 25, sp, sp));
      }

      if (network.online) {
        pages.add(new Page("our external ip is "+network.externalIP + ", and we reach the cloud in " + network.pingTime + "ms", TICKER, 0, 0, 25, sp, sp));
      } else {
        pages.add(new Page("we're offline. that sucks...", TICKER, 0, 0, 25, 0, sp));
      }

      pages.add(new Page("it's "+time.dayStr, TICKER, 0, 0, 25, 0, sp));
      pages.add(new Page(time.monthStr+" " + time.day+"th, "+time.year, TICKER, 0, 0, 25, 0, sp));
      pages.add(new Page("we are at "+(int)geolocation.latitude+" degrees North and "+abs((int)geolocation.longitude)+" degrees West", TICKER, 0, 0, 25, sp, sp));
      pages.add(new Page("that seems to be at "+(geolocation.formattedAddress), TICKER, 0, 0, 25, sp, sp));

      if (!weather.updated) {
        pages.add(new Page(("no idea about the weather...").toLowerCase(), TICKER, 0, 0, 25, sp, sp));
      } else {
        pages.add(new Page("right now, "+(weather.condition+" around "+weather.station), TICKER, 0, 0, 25, sp, sp));
        pages.add(new Page("looks like it's "+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + " degrees " +(metric ? "celsius" : "farenheit") + " out there", TICKER, 0, 0, 25, sp, sp));
        pages.add(new Page("with a "+PApplet.parseInt(weather.humidity)+" per cent of humidity", TICKER, 0, 0, 25, sp, sp));
        pages.add(new Page("nice pressure of "+PApplet.parseInt(weather.pressure)+" milibars", TICKER, 0, 0, 25, sp, sp));
        pages.add(new Page("and a soft breeze of "+PApplet.parseInt(weather.windSpeed) +" miles per hour from the "+getHeading(weather.windDeg), TICKER, 0, 0, 25, sp, sp));
        // pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));
      }

      break;

      case ENVIRONMENT:
      pages.add(new Page("2", SENSORS, 0, 0, 0, 0, 0));
      break;

      case SEARCH:
      int face = (int)random(16);
      pages.add(new Page("", LOOK, 65+face, 66+face, 0, 0, 0));
      break;

      case HELLO: 
      String hello = "What's up"+ (google.loggedin ? " "+profile.givenName : "") +"?";
      pages.add(new Page(hello, TICKER, 0, 0, 25, 10, 10));
      break;

      case BYE:
      pages.add(new Page("", SLEEP, 0, 0, 0, 0, 0));
      break;

      // case NAVIGATION:
      // pages.add(new Page("", COMPASS, 0, 0, 0, 0, 0));
      // break;

      case LOCATION:    
      if (!geolocation.updated) {
        pages.add(new Page("we're rather lost...", TICKER, 0, 0, 40, 0, 1));
      } else {
        pages.add(new Page(getCoordinate(geolocation.latitude, true)+" "+getCoordinate(geolocation.longitude, false), TICKER, 0, 0, 20, 0, 20));
        pages.add(new Page((geolocation.formattedAddress).toUpperCase(), TICKER, 0, 0, 20, 20, 20));
        // String roadInfo = "";
        // if (geolocation.houseNumber != null) roadInfo += geolocation.houseNumber+" ";
        // roadInfo += geolocation.street.toUpperCase();
        // pages.add(new Page(roadInfo, TICKER, 0, 0, 10, 0, 20));
        // if (geolocation.neighbourhood != null) {
        //   pages.add(new Page(geolocation.neighbourhood.toUpperCase(), TICKER, 0, 0, 20, 0, 20));
        // }
        // pages.add(new Page(geolocation.city.toUpperCase() + ", " + geolocation.postCode, TICKER, 0, 0, 20, 0, 20));
        // pages.add(new Page((geolocation.county+ ", " + geolocation.state).toUpperCase(), TICKER, 0, 0, 20, 0, 30));
      }
      break;

      case DRIVE:
      if (drive.updated) {
        for (int i=0; i<drive.driveContent.length; i++) {
          String thisLine = drive.driveContent[i];
          String items[] = splitTokens(thisLine, TAB+"");
          if (items.length > 5) {
            String content = "";
            if (items.length>6) content = items[6];
            pages.add(new Page(content, parseInt(items[0]), parseInt(items[1]), parseInt(items[2]), parseInt(items[3]), parseInt(items[4]), parseInt(items[5])));
          }
        }
      } else {
        pages.add(new Page(("hmmmm, can't find the file...").toLowerCase(), TICKER, 0, 0, 40, 0, 1));
      }
      break;

      case WEATHER:
      if (!weather.updated) {
        pages.add(new Page(("can't connect to the cloud...").toLowerCase(), TICKER, 0, 0, 40, 0, 1));
      } else {
        pages.add(new Page((weather.condition+" in "+weather.station).toUpperCase(), SCROLL, 0, 0, 40, 0, 20));
        pages.add(new Page("IT'S "+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + (metric ? "\u00b0c" : "\u00b0f"), CENTERED, 1, 1, 10, 0, 10));
        pages.add(new Page(PApplet.parseInt(weather.humidity)+"% HUMID", CENTERED, 0, 0, 0, 0, 10));
        pages.add(new Page("PRESSURE "+PApplet.parseInt(weather.pressure)+"mPa", CENTERED, 0, 0, 0, 0, 10));
        pages.add(new Page("WIND "+PApplet.parseInt(weather.windSpeed) +"m/h "+(int)weather.windDeg+"\u00b0 "+getHeading(weather.windDeg), CENTERED, 0, 0, 0, 0, 10));
        pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));
      }
      break;

      case ONLINE:
      if (network.online) {
        pages.add(new Page("ip "+network.externalIP + " ping " + network.pingTime + "ms", TICKER, 0, 0, 10, 0, 0));
      } else {
        pages.add(new Page("we're offline. that sucks...", TICKER, 0, 0, 40, 0, 0));
      }
      break;

      case WIFI:
      if (network.wifi) {
        pages.add(new Page(network.hostName+"@" + network.hostIP, TICKER, 0, 0, 10, 0, 0));
      } else { 
        pages.add(new Page("wifi is disabled, damn!", TICKER, 0, 0, 40, 0, 0));
      }
      break;

      case MOBILE:
      if (network.networked) {
        pages.add(new Page("connected to " + network.extra, TICKER, 0, 0, 10, 10, 20));
        pages.add(new Page("through " + network.type, TICKER, 0, 0, 10, 10, 20));
        pages.add(new Page("state " + removeSpaces(network.state), TICKER, 0, 0, 10, 10, 20));
        pages.add(new Page(network.roaming ? "roaming" : "not roaming", TICKER, 0, 0, 10, 0, 20));
      } else { 
        pages.add(new Page("sighs... no network available...", TICKER, 0, 0, 40, 0, 0));
      }
      break;

      case BLUETOOTH:
      if (comm != null) {
        if (comm.connected) {
          if (!androidMode) {
            pages.add(new Page(comm.portName, TICKER, 0, 0, 10, 0, 0));
          } else {
            pages.add(new Page(comm.deviceAddress+" "+comm.deviceRssi+"dB", TICKER, 0, 0, 10, 0, 0));
          }
        } else {
          pages.add(new Page("not connected...", TICKER, 0, 0, 40, 0, 0));
        }
      }
      break;

      case ENERGY:
      pages.add(new Page("", BATTERY, 0, 0, 0, 0, 0));
      break;

      case DIM:
      manager.play = true;
      pages.add(new Page("", BRIGHTNESS, comm.brightness, 0, 0, 0, 0));
      // pages.add(new Page("", PING, 0, 0, 0, 0, 0));
      break;

      case ORIENTATION:
      pages.add(new Page("", AXIS, 0, 0, 0, 0, 0));
      break;

      case NAVIGATION:
      pages.add(new Page("", COMPASS, 0, 0, 0, 0, 0));
      break;

      case TIME:
      String hour_ = nf(hour(), 2, 0);
      String minute_ = nf(minute(), 2, 0);
      String second_ = nf(second(), 2, 0);
      pages.add(new Page(hour_ + minute_ + second_, CLOCK, 1, 1, 0, 0, 0));  
      break;

      case KARAOKE:
      manager.play = true;
      //comm.busy = false;
      String nextLine = karaoke.update().toUpperCase();
      if (!nextLine.equals("")) {
        if (nextLine.length() > 32) {
          int breakX = findLastChar(nextLine.substring(0, PApplet.parseInt(nextLine.length()/1.6f)), ' ');
          int next = karaoke.nextTime;

          int delay = PApplet.parseInt(breakX/1.6f);
          if (delay < 6) delay = 6;
          if (delay > next/2) delay = next/2;

          // if (delay > next - 2) delay = next - 2;
          pages.add(new Page(nextLine.substring(0, breakX), CENTERED, 0, 0, 0, 0, delay));
          delay = PApplet.parseInt((nextLine.length()-breakX)/1.6f);
          if (delay < 6) delay = 6;
          if (delay > next/2) delay = next/2;

          pages.add(new Page(nextLine.substring(breakX+1, nextLine.length()), CENTERED, 0, 0, 0, 0, delay));
        } else {
          int delay = PApplet.parseInt(nextLine.length()/1.6f);
          int next = karaoke.nextTime;
          if (delay < 6) delay = 6;
          if (delay > next-2) delay = next-2;
          pages.add(new Page(nextLine, CENTERED, 0, 0, 0, 0, delay));
        }
      } else {
        String str = "";
        for (int i =0; i<32; i++) {
          // if (eq.eqDataNibble[i] == 0) eq.eqDataNibble[i] = 1;
          // println(eq.eqDataNibble[i]);
          str = str + PApplet.parseChar((eq.eqData[i]/2) + 48);
        }
        pages.add(new Page(str, SPECTRUM, 0, 0, 0, 0, 2));
      }
      break;

      case EQ: 
      manager.play = true;

      String str = "";
      for (int i =0; i<32; i++) {
        // if (eq.eqDataNibble[i] == 0) eq.eqDataNibble[i] = 1;
        // println(eq.eqDataNibble[i]);
        str = str + PApplet.parseChar((eq.eqData[i]/2) + 48);
      }
      // println("eq "+str);
      pages.add(new Page(str, SPECTRUM, 0, 0, 0, 0, 1));
      //pages.add(new Page("HELO", STREAM, 0, 0, 0, 0, 5));

      break;

      case GOOGLE:
      if (google.loggedin) {
        pages.add(new Page("What's up "+profile.givenName+"?", TICKER, 0, 0, 25, 10, 20));
        pages.add(new Page(profile.email, SCROLL, 0, 1, 5, 1, 20));
        pages.add(new Page("id "+profile.id, SCROLL, 0, 1, 5, 1, 20));
        pages.add(new Page("we are over "+profile.minAge, SCROLL, 0, 1, 5, 1, 20));
        pages.add(new Page("and speak English...", SCROLL, 0, 1, 5, 1, 20));
      } else {
        pages.add(new Page("we gotta login to Google!", TICKER, 0, 0, 40, 0, 1));
      }
      break;

      case CONTACTS:
      if (contacts.updated) {
        pages.add(new Page(("we've got "+contacts.contactList.size()+" friends!").toLowerCase(), SCROLL, 0, 1, 0, 0, 40));
        pages.add(new Page("", SCROLL, 0, 0, 1, 1, 0));
        for (Contact contact : contacts.contactList) {
          pages.add(new Page(contact.title.toUpperCase(), SCROLL, 0, 1, 0, 1, 0));
        }
      } else {
        pages.add(new Page("we gotta login to Google!", TICKER, 0, 0, 40, 0, 0));
      }
      break;

      case NEWS:
      if (news.updated) {
        pages.add(new Page(("latest from NY TIMES"), SCROLL, 0, 1, 0, 0, 20));
        pages.add(new Page("", SCROLL, 0, 2, 0, 1, 0));
        for (Article article : news.articles) {
          for (int i=0; i < article.keywords.size(); i++) {
            String keyword = article.keywords.get(i);
            pages.add(new Page(keyword.toUpperCase(), CENTERED, 0, 0, 0, 0, 7));
            pages.add(new Page("", BLANK, 0, 0, 0, 0, 3));
          }
          pages.add(new Page(article.title.toUpperCase(), SCROLL, 0, 0, 40, 0, 1));
          pages.add(new Page(article.content.toUpperCase(), TICKER, 0, 0, 20, 10, 30));
        }
      } else {
        pages.add(new Page(("where is the newspaper?").toLowerCase(), TICKER, 0, 0, 30, 0, 0));
      }
      break;

      case MAIL:
      if (mail.updated) {
        pages.add(new Page(("latest "+mail.mailList.size()+" emails!").toLowerCase(), SCROLL, 0, 1, 0, 0, 20));
        pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));

        for (Email email : mail.mailList) {
          pages.add(new Page(email.date.toUpperCase(), SCROLL, 0, 1, 20, 0, 20));
          pages.add(new Page(email.sender.toUpperCase(), TICKER, 0, 0, 20, 10, 20));
          pages.add(new Page(email.subject.toUpperCase(), TICKER, 0, 0, 20, 10, 20));
          pages.add(new Page(email.snippet.toUpperCase()+"...", TICKER, 0, 0, 20, 10, 20));
          pages.add(new Page("", BLANK, 0, 0, 10, 0, 0));
        }
      } else {
        pages.add(new Page("we gotta login to Google!", TICKER, 0, 0, 30, 0, 0));
      }
      break;

      case CALENDAR:
      if (calendar.updated) {
        pages.add(new Page(("do you rememember when...?").toLowerCase(), SCROLL, 0, 1, 0, 0, 50));
        pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));
        for (int i=0; i<50; i++) { 
          Event event = calendar.eventList.get((int)random(calendar.eventList.size()));
          pages.add(new Page(event.date.toUpperCase(), CENTERED, 0, 0, 0, 0, 20));
          pages.add(new Page(event.summary.toUpperCase(), TICKER, 0, 0, 50, 10, 30));
        }
      } else {
        pages.add(new Page("can't seem to find our calendar", TICKER, 0, 0, 30, 0, 30));
      }
      break;

      case TWITTER:
      if (twitter.updated) {
        pages.add(new Page("what's going on in TWITTER?", SCROLL, 0, 1, 0, 0, 20));
        pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));
        pages.add(new Page("@"+twitter.screenName, TICKER, 0, 0, 30, 10, 20));
        if (twitter.location != null)  pages.add(new Page(twitter.location, TICKER, 0, 0, 30, 10, 20));
        if (twitter.description != null)  pages.add(new Page(twitter.description, TICKER, 0, 0, 30, 10, 20));
        pages.add(new Page("trending in NYC", SCROLL, 0, 1, 0, 0, 20));
        pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));
        for (String trend : twitter.trends) {
          pages.add(new Page(trend, CENTERED, 0, 0, 0, 0, 10));
        }
        pages.add(new Page(twitter.followers.size()+" FOLLOWERS", SCROLL, 0, 1, 0, 1, 20));
        pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));
        for (String follower : twitter.followers) {
          pages.add(new Page("@"+follower, CENTERED, 0, 0, 0, 0, 10));
        }
        pages.add(new Page(twitter.friends.size()+" FRIENDS", SCROLL, 0, 1, 0, 1, 20));
        pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));
        for (String friend : twitter.friends) {
          pages.add(new Page("@"+friend, CENTERED, 0, 0, 0, 0, 10));
        }
      } else {
        if (twitter.authenticating) {
          pages.add(new Page("just a sec, logging in to TWITTER!", TICKER, 0, 0, 50, 0, 1));
        } else {
          pages.add(new Page("oh", SCROLL, 1, 3, 25, 0, 5));
          pages.add(new Page("no", SCROLL, 1, 3, 25, 0, 15));
          pages.add(new Page("twitter", SCROLL, 1, 3, 25, 0, 5));
          pages.add(new Page("is", SCROLL, 1, 3, 25, 0, 5));
          pages.add(new Page("down", SCROLL, 1, 3, 25, 0, 20));
        }
      }
      break;

      // case NAVIGATION:
      // manager.play = false;
      // for (String place : places.placeList) {
      //   pages.add(new Page(place.toUpperCase(), SCROLL, 0, 0, 0, 1, 0));
      // }
      // break;

      case RESULTS:
      manager.play = true;
      if (places.results.size() > 0) {
        pages.add(new Page("FOUND "+places.results.size()+" "+places.types+"s", TICKER, 0, 0, 30, 0, 20));
        for (String result : places.results) {
          pages.add(new Page(result.toUpperCase()+" is open", TICKER, 0, 0, 30, 10, 20));
        }
      } else {
        pages.add(new Page("no "+places.types+" around here!", TICKER, 0, 0, 60, 0, 1));
      }
      break;
    }

    // if (channel != ENERGY && channel != HELLO && channel != BYE) {
    //   int payload = 0;
    //   for (Page page : pages) {
    //     payload += page.content.length();
    //   }
    //   reel.pages.add(new Page("", INSTANT, 0, 23, int(payload/5), 0, 5));
    // }
  }

  public void checkSensors() {
  }
}
class TickerDisplay extends Display {
  int CHARS = 32;

  float rot, targetRot;
  PShape outline, outline_mask;
  PShape segments[];
  String segmentNames[] = {"DP", "N", "M", "L", "K", "J", "H", "G2", "G1", "F", "E", "D", "C", "B", "A"};
  String alphaFont[];

  String data;
  long lastTick;
  char[] dis;
  boolean[] dec;
  int cursorX, firstX, lastX, breakX;
  int displayMode, tack, teck, tick, tock, tuck;

  char EQ_OFF = ' ';
  char EQ_LOW = '_';
  char EQ_MID = '=';
  char EQ_HIGH = PApplet.parseChar(135);

  char[] spectrum = {EQ_OFF, EQ_LOW, EQ_MID, EQ_HIGH};

  byte loadingOut[] = {0, 1, 2, 3, 4, 5};
  byte loadingIn[] = {6, 8, 9, 10, 7, 13, 12, 11};

  String compass = "| | | | | | E | | | | | | NE | | | | | | N | | | | | | NW | | | | | | W | | | | | | SW | | | | | | S | | | | | | SE ";
  float heading, currentHeading;

  // SLEEP
  boolean busyZ;
  int zzz, zzzC, zzzD = 1;
  long nextZ;
  long awakeStart;

  // BATTERY
  int batIndex;
  int batLong = 10;
  int chargingX;
  long chargingNext;
  int chargingSpeed = 150;
  long lastBattery;

  int displayColor = greenColor;
  int displayBrightness = 255;

  PImage ticker_front;

  TickerDisplay() {
    ticker_front = loadImage("ticker_front_red_2400.png");
    outline = loadShape("shp/ticker.svg");
    outline.disableStyle();
    outline_mask = loadShape("shp/ticker_mask.svg");
    outline_mask.disableStyle();
    dis = new char[CHARS];
    dec = new boolean[CHARS];
    segments = new PShape[15];
    for (int i=0; i<15; i++) {
      segments[i] = loadShape("dig/"+segmentNames[i]+".svg");
      segments[i].disableStyle();
    }
    alphaFont = loadStrings("csv/alphaFont.csv");
    clearDisplay();
  }

  public void display() {
    update();
    if (ticker.channel == ORIENTATION) {
      targetRot = radians(ticker.comm.ax);
      rot += (targetRot-rot)*.1f;
      rotate(rot);
    }

    if (real) {
      pushMatrix();
      scale(outline.width*.413f/2400);
      image(ticker_front, -10, 3);
      popMatrix();
    } else {
      strokeWeight(thickStroke);
      stroke(0);
      fill(255);
      shape(outline, 0, 0);
      fill(backgroundColor);
      shape(outline_mask, 0, 0);
    }

    float currentX = -546;
    if (ticker.comm != null) displayBrightness = PApplet.parseInt(map(ticker.comm.brightness, 1, 15, 100, 255));
    fill(displayColor, displayBrightness);
    noStroke();
    hint(ENABLE_DEPTH_TEST);

    for (int i=0; i < CHARS; i++) {
      pushMatrix();
      translate(currentX, 36);
      scale(.16f);
      drawChar(dis[i]);
      if (dec[i]) drawChar('.');
      currentX += 35;
      popMatrix();
    }
    hint(DISABLE_DEPTH_TEST);
  }

  public void update() {
    switch(mode) {
      case COMPASS:
      heading = ticker.comm.az;

      if (abs(heading - currentHeading) > 180) {
        if (heading > currentHeading) {
          currentHeading += 360;
        } else if (heading < currentHeading) {
          currentHeading -= 360;
        }
      }
      currentHeading += (heading - currentHeading) * .025f;
      int offset = PApplet.parseInt(map(currentHeading + 180, 0, 360, 0, compass.length()));
      for (int i = 0; i < CHARS; i++) {
        int pos = (i + offset);
        if (pos < 0) pos += compass.length();
        dis[i] = compass.charAt(pos % compass.length());
        dec[i] = false;
      }
      break;

      case TYPE:
      if (cursorX < CHARS && cursorX >= 0) dis[cursorX] = millis() % 500 < 250 ? ' ' : '_';
      break;

      case AIRPORT:
      if (millis() > lastTick + tick) {
        lastTick = millis();
        busy = false;
        for (int i = 0; i < CHARS; i++) {
          if (dis[i] != data.charAt(i)) {
            busy = true;
            dis[i] = PApplet.parseChar(dis[i] + 1);
            if (dis[i] == 35) dis[i] = PApplet.parseChar(48);
            if (dis[i] > 64 + 26) dis[i] = PApplet.parseChar(48);
            if (dis[i] < 48) dis[i] = PApplet.parseChar(48);
            if (dis[i] > 58 && dis[i] < 65) dis[i] = 65;
            if (dis[i] == 48 && (data.charAt(i) < 48 || data.charAt(i) > 65 + 26)) dis[i] = data.charAt(i);
          }
        }
      }
      break;

      case ALPHABET:
      tick = 100;
      if (millis() > lastTick + tick) {
        lastTick = millis();
        cursorX++;
        if (cursorX == 255- CHARS) busy = false;
        for (int i=0; i<CHARS; i++) {
          dis[i] = PApplet.parseChar((cursorX + i) % 255);
        }
      }
      break;

      case LOADING:
      if (millis() > lastTick + tick) {
        lastTick = millis();
        switch (tack) {
          case 0:
          dis[0] = (char)loadingOut[lastX%6];
          lastX ++;
          if (lastX >= 6) lastX = 0;
          break;
          case 1:
          dis[0] = (char)loadingIn[lastX%8];
          lastX ++;
          if (lastX >= 8) lastX = 0;
          break;

          case 2:
          for (int i = 0; i < CHARS; i++) {
            dis[i] = (char)loadingIn[lastX];
          }
          lastX ++;
          if (lastX >= 8) lastX = 0;
          break;
        }
        cursorX = 1;
        for (int i = 0; i < data.length(); i++) {
          dis[cursorX] = data.charAt(i);
          cursorX ++;
        }
        if (teck > 0) {
          cursorX --;
          int index = millis() % 1000 / 200;
          for (int i = 0; i < 3; i++) {
            dec[cursorX + i] = index > i;
          }
        }
      }

      break;

      case AXIS:
      clearDisplay();
      int offsetX = 5;

      dis[0 + offsetX] = 'P';
      dis[1 + offsetX] = ticker.comm.ay >= 0 ? '+' : '-';

      dis[2 + offsetX] = PApplet.parseChar((abs(PApplet.parseInt(ticker.comm.ay)) / 100) + 48);
      dis[3 + offsetX] = PApplet.parseChar((abs(PApplet.parseInt(ticker.comm.ay)) / 10 % 10) + 48);
      dis[4 + offsetX] = PApplet.parseChar((abs(PApplet.parseInt(ticker.comm.ay)) % 10) + 48);

      dis[8 + offsetX] = 'R';
      dis[9 + offsetX] = ticker.comm.ax >= 0 ? '+' : '-';
      dis[10 + offsetX] = PApplet.parseChar((abs(PApplet.parseInt(ticker.comm.ax)) / 100) + 48);
      dis[11 + offsetX] = PApplet.parseChar((abs(PApplet.parseInt(ticker.comm.ax)) / 10 % 10) + 48);
      dis[12 + offsetX] = PApplet.parseChar((abs(PApplet.parseInt(ticker.comm.ax)) % 10) + 48);

      dis[16 + offsetX] = 'H';
      dis[17 + offsetX] = ticker.comm.az >= 0 ? '+' : '-';
      dis[18 + offsetX] = PApplet.parseChar((abs(PApplet.parseInt(ticker.comm.az)) / 100) + 48);
      dis[19 + offsetX] = PApplet.parseChar((abs(PApplet.parseInt(ticker.comm.az)) / 10 % 10) + 48);
      dis[20 + offsetX] = PApplet.parseChar((abs(PApplet.parseInt(ticker.comm.az)) % 10) + 48);
      break;

      case BRIGHTNESS:
      clearDisplay();
      int brightnessIndex = (int)map(ticker.comm.brightness, 1, 15, 1, 10);
      dis[cursorX++] = PApplet.parseChar(brightnessIndex + 48);
      dis[cursorX++] = '0';
      if (brightnessIndex == 10) dis[cursorX++] = '0';
      dis[cursorX++] = '%';
      cursorX++;
      data = "brightness";
      for (int i = 0; i < data.length(); i++) {
        dis[cursorX++] = data.charAt(i);
      }
      for (int i = 0; i < ticker.comm.brightness; i++) {
        dis[CHARS - 15 + i] = '|';
      }
      break;

      case BATTERY:
      clearDisplay();
      int batIndex = PApplet.parseInt(map(min(ticker.comm.battery*100, ticker.comm.maxBat), ticker.comm.minBat, ticker.comm.maxBat, 0, 10));
      dis[batLong] = 6;
      cursorX = batLong + 1;
      if (batIndex == 10) {
        dis[cursorX++] = '1';
        dis[cursorX++] = '0';
        dis[cursorX++] = '0';
      } else {
        dis[cursorX++] = ' ';
        dis[cursorX++] = PApplet.parseChar(batIndex + 48);
        dis[cursorX++] = '0';
      } 
      dis[cursorX++] = '%';
      dis[cursorX++] = ' ';
      dis[cursorX++] = nf(ticker.comm.battery*100, 3, 0).charAt(0);
      dec[cursorX-1] = true;
      dis[cursorX++] = nf(ticker.comm.battery*100, 3, 0).charAt(1);
      dis[cursorX++] = nf(ticker.comm.battery*100, 3, 0).charAt(2);
      dis[cursorX++] = 131; 

      if (ticker.comm.charging) {
        if (millis() > chargingNext) {    
          chargingX ++;
          chargingNext = millis() + chargingSpeed;
          if (chargingX == batIndex) chargingNext = millis() + chargingSpeed * 4;
          if (chargingX >= batIndex + 1) {
            chargingNext = millis() + chargingSpeed * 4;
            chargingX = -1;
          }
        }
        dis[0] = chargingX > 0 ? 130 : '[';
        for (int i = 1; i < batLong - 1; i++) {
          dis[i] =  i < chargingX ? PApplet.parseChar(130) : PApplet.parseChar(128);
        }
        dis[batLong - 1] = chargingX >= 10 ? 130 : ']';
      } else {
        dis[0] = batIndex == 0 ? '[' : 130;
        for (int i = 1; i < batLong - 1; i++) {
          dis[i] =  i < batIndex ?  PApplet.parseChar(130) : PApplet.parseChar(128);
        }
        dis[batLong - 1] = batIndex == 10 ? 130 : ']';
      }

      cursorX++;
      if (ticker.comm.battery < 3.40f && !ticker.comm.charging && millis() % 1000 < 500) {
        data = "LOW BATTERY";
        for (int i = 0; i < data.length(); i++) {
          dis[cursorX++] = data.charAt(i);
        }
      }
      break;

      case CLOCK:
      clearDisplay();
      cursorX = 10;
      String t = getStringTime(true, " ");
      if (t.charAt(0) > '0') {
        dis[cursorX] = t.charAt(0);
      }
      for (int i = 1; i<11; i++) {
        dis[cursorX + i] = t.charAt(i);
      }
      dec [cursorX + 1] = millis() % 1000 < 500;
      dec [cursorX + 4] = millis() % 1000 < 500;
      break;

      case RANDOM:
      if (millis() > lastTick + tick) {
        lastTick = millis();
        clearDisplay();
        for (int i = 0; i < CHARS; i++) {
          switch (tack) {
            case 0:
            dis[i] = (char)PApplet.parseInt(48 + random(10));
            break;
            case 1:
            dis[i] = (char)PApplet.parseInt(65 + random(28));
            break;
            case 2:
            dis[i] = (char)PApplet.parseInt(0 + random(128));
            break;
            case 3:
            dis[i] = (char)PApplet.parseInt(random(15));
            break;
            case 4:
            dec[i] = random(10) < 5;
            break;
          }
        }
      }
      break;

      case LOOK:
      clearDisplay();
      int eyesX = 0;
      boolean eyesB = millis() % 1200 < 300;
      face = tack-65;
      faceClosed = teck-65;
      if (face < 0) face = 0;
      if (faceClosed < 0) faceClosed = 0;
      dis[eyesX] = !eyesB ?  PApplet.parseChar(leftEyes[face]) : PApplet.parseChar(leftEyes[faceClosed]);
      dis[eyesX + 1] = !eyesB ?  PApplet.parseChar(rightEyes[face]) : PApplet.parseChar(rightEyes[faceClosed]) ;
      dec[eyesX] = true;
      break;

      case SLEEP:
      clearDisplay();

      for (int i = 1; i <= zzz; i++) {
        dis[i-1] = 'z';
      }

      if (millis() > nextZ) {
        zzz += zzzD;
        if (zzz == 3) zzzD = -1;
        if (zzz == 0) zzzD = 1;
        nextZ = millis() + 60;
        if (zzz == 0) {
          zzzC ++;
          if (zzzC % 2 == 0) {
            nextZ += 3000;
          }
        }
      }
      break;

      case SCROLL:
      if (millis() > lastTick + tick * 2) {
        lastTick = millis();
        if (cursorX < breakX ) {    /// scroll right
          cursorX ++;
          for (int i = 0; i < CHARS-1; i++) {
            dis[i] = dis[i + 1];
            dec[i] = dec[i + 1];
          }
          if (data.length() > 0) {
            dis[CHARS - 1] = data.charAt(0);
            dec[CHARS - 1] = false;
            data = data.substring(1, data.length());
            if (data.length() > 0) {
              if (data.charAt(0) == '.' && dis[CHARS-2] != '.') {
                dec[CHARS - 1] = true;
                data = data.substring(1, data.length());
                breakX --;
              }
            }
          } else {
            dis[CHARS - 1] = ' ';
            dec[CHARS - 1] = false;
          }
        } else if (cursorX > breakX ) { 
          cursorX --;
          for (int i = CHARS-1; i > 0; i--) {
            dis[i] = dis[i - 1];
            dec[i] = dec[i - 1];
          }

          if (data.length() > 0) {
            dis[0] = data.charAt(data.length()-1);
            dec[0] = false;
            data = data.substring(0, data.length()-1);
            // if (data.length() > 0) {
            //   if (data.charAt(0) == '.' && dis [CHARS-2] != '.') {
            //     dec[CHARS - 1] = true;
            //     data = data.substring(1, data.length());
            //     breakX --;
            //   }
            // }
          } else {
            dis[0] = ' ';
            dec[0] = false;
          }
        } else {
          busy = false;
        }
      }
      break;

      case TICKER:      
      if (millis() - lastTick > tick *.9f) {
        lastTick = millis();
        if (data.length() > 0) {
          if (breakX == 0) {
            clearDisplay();
            breakX = data.length();
            if (breakX > CHARS) breakX = findLastChar(data.substring(0, CHARS), ' ');
            if (breakX == 0) breakX = data.length();
            if (breakX > CHARS) breakX = CHARS;
            if (data.charAt(0) == ' ' && data.length() > 1) data = data.substring(1, data.length());
          }
          dis[cursorX] = data.charAt(0);
          data = data.substring(1, data.length());
          if (data.length() > 0) {
            if (data.charAt(0) == '.' && dis[cursorX] != '.') {
              dec[cursorX] = true;
              data = data.substring(1, data.length());
              breakX --;
            }
          } else {
            lastTick = millis() + tock*100;
          }
          cursorX ++;
          if (cursorX == breakX) {
            breakX = 0;
            if (data.length()>0) {
              lastTick = millis() + tock*100;
            }
            if (dis[cursorX - 1] == ' ') cursorX --;
          }
        } else {
          busy = false;
        }
      }
      if (cursorX < CHARS && cursorX >= 0) dis[cursorX] = millis() % 500 < 250 ? ' ' : '_';
      break;

      case RAIN:
      if (millis() - lastTick > tick * 10 ) {
        lastTick = millis();
        for (int i = 0; i < CHARS; i++) {
          if (dis[i] == ' ') {
            if (random(100) < tock) dis[i] = 10;
          } else if (dis[i] == 10) {
            dis[i] = 11;
            if (random(100) < 70) dis[i] = '/';
          } else if (dis[i] == 11) {
            dis[i] = ' ';
          } else if (dis[i] == '/') {
            dis[i] = 11;
            if (random(100) < 30) dis[i] = '/';
          }
        }
      }
      break;

      case SNOW:
      // tack fall
      // teck wind
      // tick speed
      // tock intensity

      if (millis() - lastTick > tick * 10 ) {
        lastTick = millis();
        for (int i = 0; i < CHARS; i++) {
          if (random(100) < 70 && dis[i] > 7 && dis[i] < 14) {
            dis[i] = (char)32;
          }
          switch (dis[i]) {
            case (char)141:
            dis[i] = (char)137;
            break;
            case (char)142:
            dis[i] = (char)138;
            break;
            case (char)143:
            dis[i] = (char)139;
            break;
            case (char)144:
            dis[i] = (char)140;
            break;
            case (char)8:
            dis[i] = (char)137;
            break;
            case (char)10:
            dis[i] = (char)138;
            break;
            case (char)11:
            dis[i] = (char)139;
            break;
            case (char)13:
            dis[i] = (char)140;
            break;
          }
          if (dis[i] == (char)32 && random(100) < tock) {
            dis[i] = random(100) < 50 ? (char)137 : (char)138;
          }
          if (random(100) < 1) {
            dis[i] = ' ';
          }
        }
        for (int i = 0; i < CHARS; i++) {
          int wind = (int)(-2 + random(teck*2)); 
          if (random(100) < abs(wind)) {
            if (teck > 0) {
              if (dis[i] == (char)137) {
                dis[i] = 138;
              } else if (dis[i] == (char)138) {
                if (i < CHARS-1) {
                  if (dis[i + 1] == (char)32 || i == 31) {
                    dis[i + 1] = (char)137;
                    dis[i] = (char)32;
                    i++;
                  }
                }
              } else if (dis[i] == (char)139) {
                dis[i] = (char)140;
              } else if (dis[i] == (char)140) {
                if (i < CHARS - 1) {
                  if (dis[i + 1] == (char)32 || i == CHARS - 1) {
                    dis[i] = (char)32;
                    dis[i + 1] = (char)139;
                    i++;
                  }
                }
              }
            } else {
              if (dis[i] == (char)138) {
                dis[i] = 137;
              } else if (dis[i] == (char)137) {
                if (dis[i - 1] == (char)32 || i == 0) {
                  dis[i - 1] = (char)138;
                  dis[i] = (char)32;
                  i++;
                }
              } else if (dis[i] == (char)140) {
                dis[i] = 139;
              } else if (dis[i] == (char)139) {
                if (dis[i - 1] == (char)32 || i == 0) {
                  dis[i] = (char)32;
                  dis[i - 1] = (char)140;
                  i++;
                }
              }
            }
          } else {
            if (random(100) < tack) {
              if (dis[i] == (char)137) {
                dis[i] = 139;
              } else if (dis[i] == (char)138) {
                dis[i] = 140;
              } else if (dis[i] == (char)139) {
                dis[i] = (char)32;
              } else if (dis[i] == (char)140) {
                dis[i] = (char)32;
              }
            }
          }
        }
        if (random(100) < 50) {
          for (int i = 0; i < CHARS; i++) {
            if (random(100) < 80) {
              switch (dis[i]) {
                case (char)137:
                dis[i] = (char)141;
                break;
                case (char)138:
                dis[i] = (char)142;
                break;
                case (char)139:
                dis[i] = (char)143;
                break;
                case (char)140:
                dis[i] = (char)144;
                break;
              }
            } else {
              switch (dis[i]) {
                case (char)137:
                dis[i] = (char)8;
                break;
                case (char)138:
                dis[i] = (char)10;
                break;
                case (char)139:
                dis[i] = (char)11;
                break;
                case (char)140:
                dis[i] = (char)13;
                break;
              }
            }
          }
        }
        break;
      }
    }
  }

  ////

  public void printString(String thisString, int thisMode, int thisTack, int thisTeck, int thisTick, int thisTock, int thisTuck) {
    data = thisString;
    if (thisMode != PING) {
      mode = thisMode;
      tack = thisTack;
      teck = thisTeck;
      tick = thisTick;
      tock = thisTock;
      tuck = thisTuck;
    } else {
      return;
    }

    busy = false;
    lastTick = millis() + ticker.comm.txDelay;

    switch (mode) {
      case TYPE:
      if (data.charAt(0) == 8) {
        if (cursorX > 0) {
          dis[cursorX] = ' ';
          dis[cursorX -1] = ' ';
          cursorX --;
        }
      } else if (data.charAt(0) == 31) {
        clearDisplay();
      } else if (data.charAt(0) >= 32 && data.charAt(0) < 128) {
        dis[cursorX] = data.charAt(0);
        cursorX ++;
        if (cursorX == CHARS) {
          lastTick = millis() + tock;
          for (int i=0; i < CHARS - 1; i ++) {
            dis[i] = dis[i+1];
          }
          cursorX --;
        }
      }
      break;

      //case COMPASS:
      //  clearDisplay();
      //  break;

      //case LOADING:
      //  clearDisplay();
      //  break;

      // case ALPHABET:
      // clearDisplay();

      //case BRIGHTNESS:
      //  clearDisplay();
      //  break;

      // case BATTERY:
      // clearDisplay();
      // break;

      // case AXIS:
      // clearDisplay();
      // break;

      case SNOW:
      clearDisplay();
      break;

      case RAIN:
      clearDisplay();
      break;

      case BLANK:
      clearDisplay();
      break;

      //case SLEEP:
      //  clearDisplay();
      //  break;

      case INSTANT:
      clearDisplay();
      while (data.length() > 0 && cursorX < CHARS) {
        dis[cursorX] = data.charAt(0);
        data = data.substring(1, data.length());
        if (data.length() > 0) {
          if (data.charAt(0) == '.' && dis[cursorX] == '.') {
            dec[cursorX] = true;
            data = data.substring(1, data.length());
          }
        }
        cursorX ++;
      }
      break;

      case SENSORS:
      clearDisplay();

      int offsetX = 5;
      dis[1 + offsetX] = ticker.comm.temperature >= 0 ? ' ' : '-';
      dis[2 + offsetX] = PApplet.parseChar(PApplet.parseInt(abs(ticker.comm.temperature) / 10) + 48);
      dis[3 + offsetX] = PApplet.parseChar((PApplet.parseInt(abs(ticker.comm.temperature)) % 10) + 48);
      dis[4 + offsetX] = '\u00b0';
      dis[5 + offsetX] = 'C';

      dis[7 + offsetX] = ticker.comm.humidity == 100 ? '1' : ' ';
      dis[8 + offsetX] = PApplet.parseChar(PApplet.parseInt(ticker.comm.humidity / 10) + 48);
      dis[9 + offsetX] = PApplet.parseChar((PApplet.parseInt(ticker.comm.humidity) % 10) + 48);
      dis[10 + offsetX] = '%';
      dis[11 + offsetX] = 'h';

      dis[14 + offsetX] = ticker.comm.pressure > 1000 ? '1' : ' ';
      dis[15 + offsetX] =  PApplet.parseChar(((ticker.comm.pressure % 1000) / 100) + 48);
      dis[16 + offsetX] =  PApplet.parseChar(((ticker.comm.pressure % 100) / 10) + 48);
      dis[17 + offsetX] =  PApplet.parseChar((ticker.comm.pressure % 10) + 48);
      dis[18 + offsetX] = 'm';
      dis[19 + offsetX] = 'b';
      break;

      case SPECTRUM:
      clearDisplay();
      // if (data.length() == 32) {
        for (int i = 0; i < data.length(); i++) {
          dis[i] = spectrum[data.charAt(i) - 48];
        }
      // }

      // for (int i = 0; i < CHARS / 4; i++) {
      //   byte b[] = new byte[4];
      //   int c = 255-data.charAt(i);
      //   b[0] = byte(c & unbinary("00000011"));
      //   b[1] = byte((c & unbinary("00001100")) >> 2);
      //   b[2] = byte((c & unbinary("00110000")) >> 4);
      //   b[3] = byte((c & unbinary("11000000")) >> 6);
      //   for (int j = 0; j < 4; j++) {
      //     dis[(i * 4) + j] = spectrum[b[j]];
      //     dec[(i * 4) + j] = false;
      //   }
      // }
      // }
      break;

      case STREAM:
      if (data.length() == CHARS) {
        for (int i=0; i<CHARS; i++) {
          dis[i] = data.charAt(i);
          dec[i] = false;
        }
      }
      break;

      case CENTERED:
      clearDisplay();
      cursorX = (CHARS - data.length() +  countChar(data, '.')) / 2;
      while (data.length() > 0 && cursorX < CHARS) {
        if (cursorX > 0) {
          dis[cursorX] = data.charAt(0);
          data = data.substring(1, data.length());
          if (data.length() > 0) {
            if (data.charAt(0) == '.' && dis[cursorX] != '.') {
              dec[cursorX] = true;
              data = data.substring(1, data.length());
            }
          }
        }
        cursorX ++;
      }
      break;

      case TICKER:
      busy = true;
      breakX = 0;
      break;

      case SCROLL:
      busy = true;
      cursorX = 0;
      mode = SCROLL;

      if (tock == 0) {
        clearDisplay();
      }

      if (tack == 0) {
        switch (teck) {
          case 0:
          breakX = CHARS + data.length();
          break;
          case 1:
          breakX = ((CHARS - data.length()) / 2) + data.length();
          if (tock == 1) {
            lastX = CHARS + 1;
            for (int i = CHARS - 1; i >= 0; i--) {
              if (dis[i] != ' ') break;
              lastX --;
            }
            breakX = ((CHARS - data.length()) / 2) + data.length();
            if (breakX < lastX) {
              for (int i = 0; i < (lastX - breakX) && data.length() < CHARS; i++) {
                data = " " + data;
                data = data + " ";
              }
              if (CHARS > data.length()) {
                breakX = ((CHARS - data.length()) / 2) + data.length();
              } else {
                breakX = data.length();
              }
            }
          }
          break;
          case 2:
          breakX = CHARS;
          break;
          case 3:
          breakX = data.length();
          break;
        }
      } else {
        switch (teck) {
          case 0:
          breakX = -(CHARS + data.length());
          break;
          case 1:
          breakX = -((CHARS - data.length()) / 2) - data.length();
          if (tock == 1) {
            firstX = 0;
            for (int i = 0; i < CHARS; i++) {
              if (dis[i] != ' ') break;
              firstX ++;
            }
            firstX = -(CHARS - firstX);
            if (breakX > firstX) {
              for (int i = 0; i < (breakX - firstX) && data.length() < CHARS; i++) {
                data = " " + data;
                data = data + " ";
              }
              if (CHARS > data.length()) {
                breakX = -((CHARS - data.length()) / 2) - data.length();
              } else {
                breakX = data.length();
              }
            }
          }
          break;
          case 2:
          breakX = -CHARS;
          break;
          case 3:
          breakX = - data.length();
          break;
        }
      }
      break;

      case AIRPORT:
      for (int i = data.length(); i < CHARS; i++) {
        data += " ";
      }
      busy = true;      
      break;
    }
  }

  public void drawChar(char thisChar) {
    if (PApplet.parseInt(thisChar) < alphaFont.length && PApplet.parseInt(thisChar) >= 0) {
      String thisWord = alphaFont[thisChar].substring(3, 18);
      for (int i=0; i<15; i++) {
        if (thisWord.charAt(i) == '1') {
          shape(segments[i], 0, 0);
        }
      }
    }
  }

  public void clearDisplay() {
    for (int i = 0; i < CHARS; i++) {
      dis[i] = ' ';
    }
    dec = new boolean[CHARS];
    cursorX = 0;
  }

  String invalid  = "`\u00b4\u00e2\u0080\u0098\u00e1\u00e4\u00c1\u00c2\u00c4\u00e9\u00ea\u00eb\u00c9\u00ca\u00cb\u00ed\u00ee\u00ef\u00cd\u00ce\u00cf\u00f3\u00f4\u00f6\u00d3\u00d4\u00d6\u00fa\u00fb\u00fc\u00da\u00db\u00dc\u00f1\u00d1";
  String subs     = "'''aaAAAeeeEEEiiiIIIoooOOOuuuUUUnN   ";
  String valid = " !@#$%^&*()-+=[|]}{;':<>,.?/~`\u00b0'_01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"+PApplet.parseChar(34)+PApplet.parseChar(135);

  public String cleanUp(String str) {
    String res = "";
    for (int i=0; i<str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '&') {
        if (str.charAt(i+1) == '#') {
          ch = 39;
          i = i+6;
        } else {
          if (str.length() > i+5) {
            if (str.charAt(i+5) == ';') {
              ch = 39;
              i = i+5;
            }
          }
        }
      }
      if (invalid.indexOf(ch) != -1) {
        ch = subs.charAt(invalid.indexOf(ch));
      }
      if (valid.indexOf(ch) != -1) {
        res +=  ch;
      } else {
        res += PApplet.parseChar(39);
      }
    }
    return res;
  }
}

class Twitter {
  String CONSUMER_KEY;// = "Ray2xXVP9I1PuxgOP1Cu6IdXO";
  String CONSUMER_SECRET; //= "EnZmqdtHIoH4zhDrp4VE0Ze3LzrWUrdFSZUg2CHSRu3iNzVk2i";
  String TOKEN_SECRET;
  String TOKEN;
  String CALLBACK_ID;
  String name;
  String screenName;
  String userID;
  String placeID = "2459115";
  String errorMessage;
  String profileImageUrl;
  String description;
  String location;
  String status;
  String lastUpdated;
  String mediaUrl;
  boolean updated;
  PImage img;
  boolean loggedin, authenticating, profiled;
  ArrayList<String> trends, followers, friends;

  Twitter () {
    if (credentials.credentials != null) {
      String[] items = splitTokens(credentials.credentials[3], ",");
      CONSUMER_KEY = items[0];
      CONSUMER_SECRET = items[1];
    }

    trends = new ArrayList<String>();   
    followers = new ArrayList<String>();
    friends = new ArrayList<String>();
  }  

  public void update() {
    if (network.online) {
      getTrendingTopics();
      getFollowers();
      getFriends();
      updated = true;
    }
  }

  public void getFollowers() {
    followers = new ArrayList<String>();
    JSONObject followersObject = runListFollowersChoreo(userID);
    JSONArray followersArray = followersObject.getJSONArray("users");
    for (int i = 0; i<followersArray.size(); i++) {
      JSONObject thisFollower = followersArray.getJSONObject(i);
      followers.add(thisFollower.getString("screen_name"));
    }
  }

  public void getFriends() {
    friends = new ArrayList<String>();
    JSONObject friendsObject = runListFriendsChoreo(userID);
    JSONArray friendsArray = friendsObject.getJSONArray("users");
    for (int i = 0; i<friendsArray.size(); i++) {
      JSONObject thisFriend = friendsArray.getJSONObject(i);
      friends.add(thisFriend.getString("screen_name"));
    }
  }

  public void getTrendingTopics() {
    println("getting trending");
    trends = new ArrayList<String>();   
    JSONObject trendsObject = runPlaceChoreo(placeID);
    JSONArray trendsArray = trendsObject.getJSONArray("trends");
    for (int i = 0; i<trendsArray.size() && i<10; i++) {
      JSONObject thisTrend = trendsArray.getJSONObject(i);
      trends.add(removeQuotes(thisTrend.getString("name")));
    }
  }

  public void login() {
    if (!loggedin) {
      if (authenticating) {
        println("logginin");
        authenticating = false;
        runFinalizeOAuthChoreo();
        loggedin = true;
        println("logged in");
        String[] twitterBuffer = new String[5];
        twitterBuffer[0] = TOKEN;
        twitterBuffer[1] = TOKEN_SECRET;
        twitterBuffer[2] = CONSUMER_KEY;
        twitterBuffer[3] = CONSUMER_SECRET;
        twitterBuffer[4] = userID;
        saveStrings("tmp/twitter.txt", twitterBuffer);
      } else {
        try {
          String[] twitterBuffer = loadStrings("tmp/twitter.txt");
          if (twitterBuffer.length == 5) {
            TOKEN = twitterBuffer[0];
            TOKEN_SECRET = twitterBuffer[1];
            CONSUMER_KEY = twitterBuffer[2];
            CONSUMER_SECRET = twitterBuffer[3];
            userID =  twitterBuffer[4];
            loggedin = true;
          } else {
            println("error reading twitter credentials");
          }
        } 
        catch (Exception E) {
          println("authenticating twitter");
          runInitializeOAuthChoreo();
          authenticating = true;
        }
      }
    }

    if (loggedin) {
      JSONObject show = runShowChoreo(userID);
      screenName= show.getString("screen_name");
      description = show.getString("description");
      name = show.getString("name");
      if (!show.isNull("profile_location")) location = show.getJSONObject("profile_location").getString("name");
      profileImageUrl = show.getString("profile_image_url_https");
      String ext = profileImageUrl.substring(profileImageUrl.length()-4, profileImageUrl.length());
      if (profileImageUrl.contains("_normal")) profileImageUrl = profileImageUrl.substring(0, profileImageUrl.length()-11)+ext;  
      img = loadImage("tmp/"+userID+"/"+userID+".png");
      if (img == null) {
        img = loadImage(profileImageUrl);
        saveLocal(userID+".png", img);
      }   
      status = show.getJSONObject("status").getString("text");
      lastUpdated = show.getString("created_at");
      if (!show.getJSONObject("status").isNull("extended_entities")) {
        mediaUrl = show.getJSONObject("status").getJSONObject("extended_entities").getJSONArray("media").getJSONObject(0).getString("media_url");
        if (mediaUrl != null) {
          // img = loadImage (mediaUrl);   ////////////  this is only if there is media in the latest status!!!
        }
      }
    }
  }

  public void runInitializeOAuthChoreo() {
    println("initializing, launching link");
    com.temboo.Library.Twitter.OAuth.InitializeOAuth initializeOAuthChoreo = new com.temboo.Library.Twitter.OAuth.InitializeOAuth(session);
    initializeOAuthChoreo.setConsumerKey(CONSUMER_KEY);
    initializeOAuthChoreo.setConsumerSecret(CONSUMER_SECRET);
    initializeOAuthChoreo.setForwardingURL("http://www.teleobjects.com");
    com.temboo.Library.Twitter.OAuth.InitializeOAuthResultSet initializeOAuthResults = initializeOAuthChoreo.run();
    TOKEN_SECRET = initializeOAuthResults.getOAuthTokenSecret();
    CALLBACK_ID = initializeOAuthResults.getCallbackID();
    link(initializeOAuthResults.getAuthorizationURL());
  }

  public void runFinalizeOAuthChoreo() {
    println("finalizing");
    com.temboo.Library.Twitter.OAuth.FinalizeOAuth finalizeOAuthChoreo = new com.temboo.Library.Twitter.OAuth.FinalizeOAuth(session);
    finalizeOAuthChoreo.setConsumerKey(CONSUMER_KEY);
    finalizeOAuthChoreo.setConsumerSecret(CONSUMER_SECRET);
    finalizeOAuthChoreo.setOAuthTokenSecret (TOKEN_SECRET);
    finalizeOAuthChoreo.setCallbackID(CALLBACK_ID);
    com.temboo.Library.Twitter.OAuth.FinalizeOAuthResultSet finalizeOAuthResults = finalizeOAuthChoreo.run();
    TOKEN = finalizeOAuthResults.getAccessToken();
    TOKEN_SECRET = finalizeOAuthResults.getAccessTokenSecret();
    errorMessage = finalizeOAuthResults.getErrorMessage();
    userID = finalizeOAuthResults.getUserID();
    println(userID+" "+errorMessage);
  }

  public JSONObject runListFollowersChoreo(String userID) {
    ListFollowers listFollowersChoreo = new ListFollowers(session);
    listFollowersChoreo.setAccessToken(TOKEN);
    listFollowersChoreo.setAccessTokenSecret(TOKEN_SECRET);
    listFollowersChoreo.setConsumerKey(CONSUMER_KEY);
    listFollowersChoreo.setConsumerSecret(CONSUMER_SECRET);
    listFollowersChoreo.setUserID(userID);
    ListFollowersResultSet listFollowersResults = listFollowersChoreo.run();
    // println(listFollowersResults.getLimit());
    // println(listFollowersResults.getRemaining());
    // println(listFollowersResults.getReset());
    return JSONObject.parse(listFollowersResults.getResponse());
  }

  public JSONObject runListFriendsChoreo(String userID) {
    ListFriends listFriendsChoreo = new ListFriends(session);
    listFriendsChoreo.setAccessToken(TOKEN);
    listFriendsChoreo.setAccessTokenSecret(TOKEN_SECRET);
    listFriendsChoreo.setConsumerKey(CONSUMER_KEY);
    listFriendsChoreo.setConsumerSecret(CONSUMER_SECRET);
    listFriendsChoreo.setUserID(userID);
    ListFriendsResultSet listFriendsResults = listFriendsChoreo.run();
    // println(listFriendsResults.getLimit());
    // println(listFriendsResults.getRemaining());
    // println(listFriendsResults.getReset());
    return JSONObject.parse(listFriendsResults.getResponse());
  }

  public JSONObject runPlaceChoreo(String placeId) {
    Place placeChoreo = new Place(session);
    placeChoreo.setAccessToken(TOKEN);
    placeChoreo.setAccessTokenSecret(TOKEN_SECRET);
    placeChoreo.setConsumerKey(CONSUMER_KEY);
    placeChoreo.setConsumerSecret(CONSUMER_SECRET);
    placeChoreo.setID(placeID);
    PlaceResultSet placeResults = placeChoreo.run();
    String result = placeResults.getResponse();
    return JSONObject.parse(result.substring(1, result.length()-1));
  }

  public JSONObject runShowChoreo(String thisUserID) {
    JSONObject result;
    try {
      String[] showBuffer = loadStrings("tmp/"+thisUserID+"/"+thisUserID+".txt");
      result = JSONObject.parse(concatenate(showBuffer));
    } 
    catch (Exception E) {
      Show showChoreo = new Show(session);
      showChoreo.setAccessToken(TOKEN);
      showChoreo.setAccessTokenSecret(TOKEN_SECRET);
      showChoreo.setConsumerKey(CONSUMER_KEY);
      showChoreo.setConsumerSecret(CONSUMER_SECRET);
      showChoreo.setUserId(thisUserID);
      ShowResultSet showResults = showChoreo.run();
      String showBuffer = showResults.getResponse();
      String[] tmp = new String[1];
      tmp[0] = showBuffer;
      saveStrings("tmp/"+thisUserID+"/"+thisUserID+".txt", tmp);    
      result = JSONObject.parse(showBuffer);
      // println(showResults.getLimit());
      // println(showResults.getRemaining());
      // println(showResults.getReset());
    }
    return result;
  }
}
char DOUBLE_QUOTE = 34;

public String filterNumber(String thisString) {
  String result = "";
  for (int i = 0; i < thisString.length(); i++) {
    char thisChar = thisString.charAt(i);
    if (thisChar >= 48 && thisChar <= 58 || thisChar == '-' || thisChar == '+' || thisChar =='x') result += thisChar;
  }
  return result;
}

public String concatenate(String[] content) {
  String result="";
  for (int i = 0; i < content.length; i++) {
    result += content[i];
  }
  return result;
}

public int countChar(String str, char c) {
  if (str.length() == 0 || str == null) return 0;
  int count = 0;
  for (int i = 0; i < str.length(); i++) {
    if (str.charAt(i) == c) count ++;
  }
  return count;
}

public int findNextChar(String str, char c) {
  if (str.length() == 0 || str == null) return 0;
  int count = 0;
  while (count < str.length()) {
    if (str.charAt(count) == c) break;
    count ++;
  }
  return count;
}

public int findLastChar(String str, char c) {
  if (str.length() == 0 || str == null) return 0;
  int count = str.length() - 1;
  while (count > 0) {
    if (str.charAt(count) == c) break;
    count --;
  }
  return count;
}

public String removeQuotes(String str) {
  if (str.length() > 0) {
    if (str.charAt(0) == DOUBLE_QUOTE) {
      str = str.substring(1, str.length());
    }
  }
  if (str.length() > 0) {

    if (str.charAt(str.length()-1) == DOUBLE_QUOTE) {
      str = str.substring(0, str.length()-1);
    }
  }
  return str;
}

public String removeSpaces(String str) {
  if (str == null) return str;
  while (str.length() > 0 && (str.charAt(0) == ' ' || str.charAt(0) == TAB)) {
    str = str.substring(1, str.length());
  }
  while (str.length() > 0 && (str.charAt(str.length()-1) == ' ' || str.charAt(str.length()-1) == TAB)) {
    str = str.substring(0, str.length()-1);
  }
  return str;
}

public String removeBrackets(String str) {
  if (str == null) return str;
  if (str.length() > 0) {
    if (str.charAt(0) == '{') {
      str = str.substring(1, str.length()-1);
    }
  }
  if (str.length() > 0) {
    if (str.charAt(str.length()-1) == '}') {
      str = str.substring(0, str.length()-2);
    }
  }
  return str;
}

public String encode(String name) {
  String encoded = null;
  try { 
    encoded = java.net.URLEncoder.encode(name, "UTF-8");
  } 
  catch (Exception e) {
    if (verbose) println("error encoding url "+name);
  }
  return encoded;
}

public String getHeading(float deg) {
  String[] directions = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", 
    "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"};
  int i = PApplet.parseInt((deg + 11.25f)/22.5f);
  return directions[i % 16];
}

public String getCoordinate(double coordinate, boolean isLat) {
  char hemisphere = coordinate < 0 ? (isLat ? 'S' : 'W') : (isLat ? 'N' : 'E');
  float coord = (float)coordinate; 
  coord = abs(coord);
  int degrees = PApplet.parseInt(coord);         
  float minutesFromRemainder = (coord - degrees) * 60;      
  int minutes = PApplet.parseInt(minutesFromRemainder);      
  float secondsFromRemainder = ( minutesFromRemainder - minutes ) * 60;  
  int seconds = PApplet.parseInt( secondsFromRemainder);
  return (degrees+"\u00b0" + nf(minutes, 2, 0) + "'" + nf(seconds, 2, 0) + DOUBLE_QUOTE +""+hemisphere);
}

public float getCelcius(float temp) {
  temp -= 32;
  temp /= 1.8f;
  return temp;
}

public String getStringDate(String separator) {
  String result = "";
  String day_ = nf(time.day, 2, 0);
  String month_ = nf(time.month, 2, 0);
  String year_ = (""+time.year);//.substring(2,4);
  result += month_;
  result +=  separator;
  result += day_;
  result +=  separator;
  result += year_;
  return result;
}

public String getStringTime(boolean am_pm, String separator) {
  String result = "";
  if (am_pm) {
    int tempHour = hour()%12;
    if (tempHour == 0) tempHour = 12;

    String hour_ = nf(tempHour, 2, 0);
    result += hour_.charAt(0);
    result +=  hour_.charAt(1);
    result +=  separator;
    String minute_ = nf(minute(), 2, 0);
    result += minute_.charAt(0);
    result += minute_.charAt(1);
    result += separator;
    String second_ = nf(second(), 2, 0 );
    result += second_.charAt(0);
    result += second_.charAt(1);
    if (hour() >= 12) {
      result += " PM";
    } else {
      result += " AM";
    }
  } else {
    String hour_ = nf(hour(), 2, 0);
    result += hour_.charAt(0);
    result +=  hour_.charAt(1);
    result +=  ". ";
    String minute_ = nf(minute(), 2, 0);
    result += minute_.charAt(0);
    result += minute_.charAt(1);
    result += ". ";
    String second_ = nf(second(), 2, 0 );
    result += second_.charAt(0);
    result += second_.charAt(1);
  }
  return result;
}

public float attract(float val, float target, float ratio, float snap) {
  val += (target - val) * ratio;
  if (abs(val - target) < snap) val = target;
  return val;
} 
  public void settings() {  size(2000, 1200, OPENGL);  pixelDensity(displayDensity()); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "tele_master_java" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
