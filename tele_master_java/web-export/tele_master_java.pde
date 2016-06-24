import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.io.File;

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

TembooSession session = new TembooSession("teleobjects", "teleobjects", "2KCJoyEHzlanzvmd6QAHlrSLuLPFffOw");

boolean debug = false;
boolean verbose = true;
boolean metric = true;
boolean sync = true;
boolean android = false;

//long globalLastTx;
//int GLOBAL_TX_SPEED = 100;

Time time;
Gui gui;
Manager manager;
Network network;
// Eq eq;
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

Teleobject ticker;
Teleobject comment;
Teleobject mailbox;
Teleobject reel;
Teleobject frame;

Teleobject activeObject;


ArrayList<Teleobject> teleobjects;

void setup() {
  size(1600, 900);
  orientation(LANDSCAPE);
  imageMode(CENTER);
  time = new Time();
  network = new Network();
  geolocation = new Geolocation();
  weather = new Weather();
  places = new Places();
  // eq = new Eq(this);
  messaging = new Messaging();

  google = new Google();
  profile = new Profile();
  mail = new GoogleMail();
  contacts = new GoogleContacts();
  calendar = new GoogleCalendar();
  drive = new GoogleDrive();

  news = new News();
  twitter = new Twitter();
  gui = new Gui();
  gui.init();

  teleobjects = new ArrayList<Teleobject>();

  manager = new Manager();

  ticker = new Ticker(this, 0);
  ticker.name = "ticker";
  ticker.init();

  comment = new Comment(this, 1);
  comment.name= "comment";
  comment.init();

  mailbox = new Mailbox(this, 2);
  mailbox.name = "mailbox";
  mailbox.init();

  reel = new Reel(this, 3);
  reel.name = "reel";
  reel.init();

  frame = new Frame(this, 4);
  frame.name = "frame";
  frame.init();

  teleobjects.add(ticker);
  teleobjects.add(comment);
  teleobjects.add(mailbox);
  teleobjects.add(reel);
  teleobjects.add(frame);
  
  google.login();
}

void draw() {
  if (google.authenticating || twitter.authenticating) {
    background(redColor);
    if (gui.clicked) {
      gui.clicked = false;
      if (google.authenticating) {
        google.login();
        manager.setChannel(GOOGLE);
      } else if (twitter.authenticating) {
        twitter.login();
      }
    }
  } else {

    updateSensors();
    time.update();
    geolocation.update();
    weather.update();
    // eq.update();
    gui.update();
    manager.update();


    ticker.update();
    mailbox.update();
    comment.update();
    reel.update();
    frame.update();

    if (activeObject == null) {
      translate(width/2, height/2);
      scale(.7);
      ticker.display(-210, 120);
      mailbox.display(-960, 108);
      comment.display(-400, -200);
      reel.display(740, 80);
      frame.display(200, -220);
    } else {
      translate(width/2, height/2);
      scale(width/1600);
      activeObject.display(0, 0);
    }
  }
}
//import android.os.Bundle;
//import android.content.Context;

//import blepdroid.*;
//import blepdroid.BlepdroidDevice;
//import java.util.UUID;

//import android.net.wifi.ScanResult;     // required import for scanning networks
//import android.net.wifi.WifiManager;    // required imports for wifi
//import java.util.List;                  // Java import for lists

//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;

//import android.os.Vibrator;
//import ketai.sensors.*; 

//import android.app.ActivityManager;  // required import for "nice" memory
//import java.lang.Runtime;            // required import for max memory

//public static UUID BLUEFRUIT_UART_SERVICE = UUID.fromString( "6E400001-B5A3-F393-E0A9-E50E24DCCA9E");
//public static UUID BLUEFRUIT_UART_TX = UUID.fromString("6E400002-B5A3-F393-E0A9-E50E24DCCA9E");
//public static UUID BLUEFRUIT_UART_RX = UUID.fromString("6E400003-B5A3-F393-E0A9-E50E24DCCA9E");

//KetaiLocation location;
//KetaiAudioInput mic;

//WifiManager wifiManager;          // instance of the WifiManager for getting network details
//List<ScanResult> networks;        // list of ScanResult objects, parsed later

//ConnectivityManager connMgr;

//Vibrator vibe;    
//long vibeDuration = 5;
//long[] vibeList = { 0, 20, 20, 20, 20 };    

//// MEMORY
//float maxMemory = 0;  
//int freeMemory = 0;

//ActivityManager activityManager; 


//public void onCreate(Bundle savedInstanceState) {
//  super.onCreate(savedInstanceState);
//  vibe = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
//  wifiManager = (WifiManager) getActivity().getSystemService(Context.WIFI_SERVICE);
//  connMgr  = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
//  activityManager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
//  //InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
//}
//boolean bleConnecting;
//boolean discovering;
//void vibrate() {
//  vibe.vibrate(vibeDuration);
//}

/////////////////
//// SENSORS
/////////////////


//void updateSensors() {
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
//}

//void onCharacteristicChanged(BlepdroidDevice device_, String characteristic, byte[] data)
//{
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
//}

//void onDeviceDiscovered(BlepdroidDevice device_)
//{
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
//}

//void onServicesDiscovered(BlepdroidDevice device_, int status)
//{
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
//}

//void onBluetoothRSSI(BlepdroidDevice device_, int rssi)
//{
//  println(" onBluetoothRSSI " + device_.address + " " + Integer.toString(rssi));
//}

//void onBluetoothConnection(BlepdroidDevice device_, int state)
//{
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
//}


//void onDescriptorWrite(BlepdroidDevice device, String characteristic, String data)
//{
//  //println("onDescriptorWrite " + characteristic + " " + data);
//}

//void onDescriptorRead(BlepdroidDevice device_, String characteristic, String data)
//{
//  //println(" onDescriptorRead " + characteristic + " " + data);
//}

//void onCharacteristicRead(BlepdroidDevice device_, String characteristic, byte[] data)
//{
//  //println("onCharacteristicRead " + characteristic + " " + data);
//}

//void onCharacteristicWrite(BlepdroidDevice device_, String characteristic, byte[] data)
//{
//  //println("onCharacteristicWrite " + characteristic + " " + data);
//}

//void onLocationEvent(double _latitude, double _longitude, double _altitude) {
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
//}

//void   scanDevices() {
//  Blepdroid.getInstance().scanDevices();
//}    

/////////////////
//// COMM
/////////////////

//class Comm {
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
//}


/////////////////
//// MIC
/////////////////

//short[] micData;

//void onAudioEvent(short[] _micData)
//{
//  //println("audio event");
//  micData= _micData;
//}

//class Eq {
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
//}

////void tx (byte[] data) {
////}

////void rx() {
////}

//void downloadByteArrayAsImage(String url, String fileName) {
//}
class CommentDisplay extends Display {
  PShape outline;
  float m = 58;
  float w = m*8;
  float h = m; 
  float offsetV = 50;
  boolean busy = true;

  CommentDisplay() {
    outline = loadShape("shp/comment.svg");
    outline.disableStyle();
  }

  void display() {
    strokeWeight(thick);
    stroke(0);
    fill(255);
    shape(outline, 0, 0);
    translate(-230, - 45);
    translate(0, -offsetV);
    displayRow();
    translate(0, offsetV*2);
    displayRow();
  }

  void displayRow() {
    rectMode(CORNER);
    ellipseMode(CORNER);
    fill(50);
    // rect(0,0,w,h,5);
    stroke(redColor, 10);	
    stroke(255, 50);
    strokeWeight(.5);
    // noStroke();
    fill(redColor);
    for (int c = 0; c<8; c++) {
      for (int x = 0; x<8; x++) {
        for (int y=0; y<8; y++) {		
          ellipse(c*m + (x*m/8.0), y*m/8.0, m/8.0, m/8.0);
        }
      }
    }
  }

  String invalid  = "`´_âáäÁÂÄéêëÉÊËíîïÍÎÏóôöÓÔÖúûüÚÛÜñÑ";
  String subs     = "'' 'aaAAAeeeEEEiiiIIIoooOOOuuuUUUnN";
  String valid = " !@#$%^&*()-+=[]}{;':<>,.?/01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz°'"+char(34);

  String cleanUp(String str) {
    // println(str);
    String res = "";
    for (int i=0; i<str.length(); i++) {
     char ch = str.charAt(i);
     if (ch == '&'){
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
  if (ch > 127) {
   ch = 39;
 }
 if (invalid.indexOf(ch) != -1) {
   ch = subs.charAt(invalid.indexOf(ch));
 }
 if (valid.indexOf(ch) != -1) {
   res +=  ch;
 } else {
   res += '-';
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
final int bottom_closed = 1;;
final int top = 2;;
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
class FrameDisplay extends Display {
  PShape outline, window, mask;
  int mode = 0;
  String data = "";
  long lastTick;
  int cursorX = 0;
  int breakX;
  boolean busy;
  int displayMode, tick, tock, tuck;

  int w = 128;
  int h = 128;
  float f = 9;

  color foreground, background, top, bottom;
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

  void update() {
  }

  void display() {
    pushMatrix();
    scale(.60);
    fill(255);
    stroke(0);
    pushMatrix();
    scale(4);
    strokeWeight(thick/2.5);
    shape(outline, 0, 0);
    popMatrix();
    pushMatrix();
    scale(.74);
    image(display, 0, 0);
    popMatrix();
    pushMatrix();
    scale(1.6);
    noStroke();
    fill(255);
    shape(mask, 0, 0);
    noFill();
    stroke(0);
    strokeWeight(thick);
    shape(outline, 0, 0);
    popMatrix();
    popMatrix();
  }

   void printString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
  }
}
////////////////////////
// GOOGLE
////////////////////////

//String CLIENT_ID = "113132524761-9vc5rqbcbqjq79msolp7iaki9vbehqsl.apps.googleusercontent.com";
//String CLIENT_SECRET = "wB14XMGd7Ju_CZZh9Q3ukrwY";
//String REFRESH_TOKEN = "1/hSZSH0vYOnV1kegywSyJUcxaTgGPv8pWcq1K_KtVouAMEudVrK5jSpoR30zcRFq6";

String CLIENT_ID = "113132524761-c5gg9a8m6tq7nus1iad89enfk3t2lfjv.apps.googleusercontent.com";
String CLIENT_SECRET = "iLxRPab7WJpdXJeLN8MjeqY_";
String REFRESH_TOKEN;
String ACCESS_TOKEN;
String CALLBACK_ID;

class Google {
  boolean loggedin;
  boolean logging;
  boolean authenticating;

  String[] credentials;

  Google() {
    //login();
  }

  void login() {
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

  void logout() {
    deleteFile("credentials.txt");
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

  void authenticate() {
    try {
      credentials = loadLocal("credentials.txt");
      if (credentials != null) {
        REFRESH_TOKEN = credentials[0];
        ACCESS_TOKEN = credentials[1];
        println(REFRESH_TOKEN);
        println(ACCESS_TOKEN);
      }
    } 
    catch (Exception e) {
      println("error");
    }
    if (REFRESH_TOKEN == null) {
      runInitializeOAuthChoreo();
    } else {
      profile.update();
      loggedin = true;
      logging = false;
      manager.setChannel(GOOGLE);
    }
  }

  void runInitializeOAuthChoreo() {
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

  void runFinalizeOAuthChoreo() {
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
    credentials = new String[2];
    credentials[0] = REFRESH_TOKEN;
    credentials[1] = ACCESS_TOKEN;
    saveLocal("credentials.txt", credentials);
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

  Profile () {
  }

  void update() {
    JSONObject choreo;
    try {
      String[] choreoBuffer = loadLocal("profile.json");
      choreo = JSONObject.parse(concatenate(choreoBuffer));
    } 
    catch (Exception e) {
      choreo = runGetChoreo();
      String[] choreoBuffer = { choreo.toString()};
      saveLocal("profile.json", choreoBuffer);
    }
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
      img = loadLocalImage(id+".png");
    } 
    catch (Exception e) {
    }
    if (img == null) {
      img = loadImage(url);
      saveLocal(id+".png", img);
    }
    updated = true;
  }

  JSONObject runGetChoreo() {
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

  void update() {
    if (google.loggedin) {
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

  JSONObject runListMessagesChoreo() {
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

  JSONObject runGetMessageChoreo(String id) {
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

  void fix() {
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
  ArrayList<String> drives;

  GoogleDrive () {
  }

  void update() {
    drives = new ArrayList<String>();
    String logId = "1nDJ7lBSpylE5ORHF6xTntc4N9iqq8m3j_LW7Ok5K8RQ";
    String driveUrl = "https://docs.google.com/spreadsheets/d/"+logId+"/export?format=tsv&id="+logId;
    String[] driveContent = loadUrl(driveUrl);
    if (driveContent != null) {
      for (int i=0; i<driveContent.length; i++) {
        drives.add(removeQuotes(driveContent[i]));
      }
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

  void update() {
    if (google.loggedin) {

      XML contactsXML = null;
      try {
        contactsXML = loadXML((android ? "data\\tmp\\" : "data/tmp/") + "contacts.xml");
      } 
      catch (Exception e) {
        println("error loading contacts.xml");
      }

      if (contactsXML == null) {
        println("getting contacts");
        String contactsBuffer = runGetAllContactsChoreo();
        contactsXML = parseXML (contactsBuffer);
        saveXML(contactsXML, (android ?  "data\\tmp\\" : "data/tmp/") + "contacts.xml");
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

  String runGetAllContactsChoreo() {
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

  void update() {
    if (google.loggedin) {

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

  JSONObject runGetAllEventsChoreo() {
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

  void fix() {
    //print(dateRaw);
    year = parseInt(dateRaw.substring(0, 4));
    month = parseInt(dateRaw.substring(5, 7));
    day = parseInt(dateRaw.substring(8, 10));
    date =time.monthNames[month-1] +" "+ day+", "+year;
  }

  void debug() {
  }
}

color whiteColor = color (255, 255, 255);
color redColor = color(190, 30, 45);
color backgroundColor = 200;
PFont font;//, fontBold, fontMono, fontMonoBold;

PShape app, mask;

float thick = 3;

class Gui {
  boolean refresh = true;
  float cW = 1600;
  float rot, targetRot;
  int debounce = 500;
  long lastClick;
  boolean clicked;
  ArrayList<Packet> packets;

  Gui () {
  }

  void init() {
    app = loadShape("shp/app.svg");
    app.disableStyle();

    mask = loadShape("shp/mask.svg");
    mask.disableStyle();
    font = createFont("Monospaced", 32);

    initPilots();
    packets = new ArrayList<Packet>();
  }

  void update() {
    pushMatrix();
    scale(width/cW);

    // PILOTS
    refresh = true;
    checkPilots();
    if (refresh) {
      background(backgroundColor);
    } else {
      //if (debug) {
      //  rectMode(CORNER);
      //  noStroke();
      //  fill(backgroundColor);
      //  rect(0, 112, width, 120);
      //  rect(0, (height/2)+194, width, 120);
      //}
    }
    displayPilots();

    // PACKETS
    if (debug) {
      displayPackets();
    }
    popMatrix();

    // DWEETS
    if (messaging != null && debug) {
      messaging.displayDweet(250, 630);
    }

    if (android) {
      refresh = false;
    }
  }

  void displayPackets() {
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

void keyPressed() {
  switch (key) {
    case '0':
    activeObject = null;
    break;
    case '1':
    activeObject = ticker;
    break;
    case '2':
    activeObject = comment;
    break;
    case '3':
    activeObject = mailbox;
    break;
    case '4':
    activeObject = reel;
    break;
    case '5':
    activeObject = frame;
    break;
  }
  if (key >= 48 && key <= 58) {  
    //ticker.editor.setChannel(key-48);
  }
  if (key >= 65 && key <= 65+28) {
    //ticker.editor.setChannel(key-48);
  }
}

void mousePressed() {
  if (millis()-gui.lastClick > gui.debounce) {
    gui.lastClick = millis();
    gui.clicked = true;
  }
}

void mouseReleased() {
  gui.clicked = false;
}

class Packet {
  PVector loc;
  PVector targetLoc;
  boolean in;
  String label;

  Packet(boolean in_, String label_, float x_) { 
    label = label_;
    in = in_;
    loc = new PVector (x_+(in?40:0)-20, in ? 400 : 118, 255);
    targetLoc = new PVector (x_+(in?40:0)-20, in ? 118 : 400, 0);
    if (gui.packets.size() < 20) {
      gui.packets.add(this);
    }
  }

  void display() {
    loc.x = attract(loc.x, targetLoc.x, .08, 5);
    loc.y = attract(loc.y, targetLoc.y, .08, 5);
    loc.z = attract(loc.z, targetLoc.z, .08, 5);
    noStroke();
    fill(in ? whiteColor : redColor, loc.z);
    ellipseMode(CENTER);
    ellipse(loc.x, loc.y, 15, 15);
  }
}
class MailboxDisplay extends Display {
  PShape outline, window, mask;


  int mode = 0;
  String data = "";


  long lastTick;
  int cursorX = 0;
  int breakX;
  boolean busy;
  int displayMode, tack, teck, tick, tock, tuck;

  int w = 128;
  int h = 128;
  float f = 9;

  color foreground, background, top, bottom;
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

  void update() {
  }

  void display() {
    pushMatrix();

    scale(.63);
    fill(255);
    stroke(0);
    strokeWeight(thick/.7);

    shape(outline, 0, 0);
    pushMatrix();
    scale(.85);
    image(display, 0, 70);
    popMatrix();
    noStroke();
    fill(255);
    shape(mask, 0, 60);
    noFill();
    stroke(0);
    strokeWeight(thick/.7);
    shape(window, 0, 60);
    popMatrix();
  }

  void printString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
  }
}
final int SCAN = -10;
final int LOGOUT = -11;
final int PLAY = -12;
final int UP = -13;
final int DOWN = -14;
final int LEFT = -15;
final int RIGHT = -16;
final int LOOP = -27;
final int JUMP = -18;
final int DEMO = -19;
final int SYNC = -20;
final int OBJECT = -21;
final int MOBILE = -22;

final int BLANK = 0;
final int LOOK = 1;
final int CENTERED = 2;
final int INSTANT= 3;
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
final int COMPASS = 16;
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
final int BRIGHTNESS = 51;
final int FONT = 52;

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

final int SETTINGS = 100;
final int BLUETOOTH = 101;
final int WIFI = 102;
final int ONLINE = 103;
final int ENERGY = 104;
final int ORIENTATION = 105;
final int TIME = 106;
final int EQ = 107;
final int LOCATION = 108;
final int NAVIGATION = 109;
final int RESULTS = 110;

final int HELLO = 150;
final int BYE = 151;

int demoModes[] = {LOOK, ALPHABET, BALL, RAIN, SNOW, COMPASS, RANDOM};
int demoMode = 0;

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
// final int PLACES = 212
class Manager {
  int channel;
  boolean play = true;
  boolean loop = true;
  boolean manual = false;

  Manager () {
  }

  void update() {
  }

  void setChannel(int thisCommand) {
    switch(thisCommand) {
      case UP:
      if (channel == NAVIGATION) {
        places.search(ticker.pages.get(ticker.pageIndex).content);
        thisCommand = RESULTS;
      }
      break;

      case DOWN:
      if (channel == RESULTS) {
        thisCommand = NAVIGATION;
      }
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


      case LOGOUT:
      google.logout();
      break;
      case SCAN:
      scanDevices();
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

      case SETTINGS:
      debug = !debug;
      break;

      case MOBILE:
      if (activeObject == null) {
        activeObject = ticker;
      } else {
        int nextObject = activeObject.num;
        nextObject ++;
        if (nextObject > 4)        {
          activeObject = null;
        } else{
          activeObject = teleobjects.get(nextObject);
        }
      }
      break;


      case GOOGLE:
      if (!google.loggedin) {
        google.login();
        if (google.authenticating) play = false;
      } else {
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
      } else {
        twitter.login();
      }
      break;

      case WIFI:
      network.updateWifi();
      break;

      case ONLINE:
      network.updateOnline();
      break;

      case NEWS:
      if (!news.updated) news.update();
      break;
    }

    if (thisCommand == DEMO) {
      channel = demoModes[demoMode];
      if (demoMode == demoModes.length) demoMode = 0;
      for (Teleobject teleobject : teleobjects) {
        teleobject.initPages(channel);
        teleobject.printPages();
      }
    }
    if (thisCommand > 100) {
      channel = thisCommand;
      for (Teleobject teleobject : teleobjects) {
        teleobject.initPages(channel);
        teleobject.printPages();
      }
    }
    gui.refresh = true;
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

  void getDweet() {
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
        network.pingTime = int(millis()-network.pingStart);

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

    void sendDweetQuietly(String key_, String value_) {
      network.pingStart = millis();
      String url = "https://dweet.io:443/dweet/quietly/for/"+thing+"?"+"teleobject="+teleobject+"&"+key_+"="+encode(value_);
      String[] buffer = loadUrl(url);
      println(url);
      if (buffer != null) {
        // latestDweet.parse(buffer[0], false);
        latestDweet.info = value_;
        network.pingTime = int(millis()-network.pingStart);
        dweetA = 255;
      }
    }

    void sendDweet(String key_, String value_) {
      network.pingStart = millis();
      String url = "https://dweet.io:443/dweet/for/"+thing+"?"+"teleobject="+teleobject+"&"+key_+"="+encode(value_);
      String[] buffer = loadStrings(url);
      //println(url);
      if (buffer != null) {
          latestDweet.parse(buffer[0], false);
        network.pingTime = int(millis()-network.pingStart);
        dweetA = 255;
      }
    }

    void displayDweet(float thisX, float thisY) {
      dweetA += (dweetTargetA - dweetA)*.01;
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

    void parse(String d, boolean getting) {
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
import java.net.InetAddress; 
import java.net.UnknownHostException; 

class Network {
  String hostName; 
  String hostIP; 
  String externalIP;

  // String pingUrl = "http://www.google.com";
  String ipFinderUrl = "https://api.ipify.org";

  // STATES
  String wifiState;   
  String onlineState;
  boolean wifi, online, loading;
  int pingTime;
  long pingStart;

  Network () {
    init();
  }

  void init() {
    updateOnline();
    updateWifi();
  }

  void updateOnline() {
    // onlines = new ArrayList<String>();
    pingStart = millis();  
    try { 
      String[] ip = loadStrings(ipFinderUrl);
      if (ip != null) {
        pingTime = int(millis() - pingStart);
        externalIP = ip[0];
        onlineState ="online";
        online = true;
      } else {
        onlineState ="offline";
        online = false;
      }
    } 
    catch (Exception e) {
      println(e);
      online = false;
      // onlines.add("EXCEPTION THROWN");
      onlineState ="offline";
    }
  }

  void updateWifi() {
    //   wifis = new ArrayList<String>();
    try { 
      InetAddress addr = InetAddress.getLocalHost(); 
      byte[] ipAddr = addr.getAddress(); 
      String raw_addr = addr.toString(); 
      String[] list = split(raw_addr, '/'); 
      hostIP = list[1]; 
      if (hostIP.indexOf(":") != -1) {
        hostName = addr.getHostName();
        hostIP = "OFFLINE";
        wifiState = "wifi disabled";
        wifi = false;
      } else {
        hostName = addr.getHostName();
        wifiState = "wifi enabled";
        wifi = true;
      }
    } 
    catch (UnknownHostException e) {
      println(e);
    }
  }
}

void deleteFile(String thisFile) {
  String fileName;
  if (android) {
    fileName = sketchPath("data\\tmp\\"+thisFile);
  } else {
    fileName = dataPath("tmp/"+thisFile);
  }
  File f = new File(fileName);
  if (f.exists()) {
    f.delete();
    println("deleted "+thisFile);
  } else {
    println("could not delete "+thisFile);
  }
}

String[] loadLocal(String thisFile) {
  String[] result = loadStrings((android ? "data\\tmp\\" : "data/tmp/") +thisFile);
  if (debug) println("loaded "+thisFile);
  return result;
}

void saveLocal(String thisFile, String[] thisContent) {
  saveStrings((android ? "data\\tmp\\" : "data/tmp/") +thisFile, thisContent);
  if (debug) println("saved "+thisFile);
}

void saveLocal(String thisFile, PImage img) {
  if (img != null) {
    PImage tmp = createImage(img.width, img.height, RGB);
    tmp = img.get();
    if (android) {
      tmp.save(savePath(sketchPath("data\\tmp\\"+thisFile)));
    } else {
      tmp.save(savePath(sketchPath("data/tmp/"+thisFile)));
    }
  }
  if (debug) println("saved "+thisFile);
}

PImage loadLocalImage(String thisFile) {
  if (debug) { 
    Packet newPacket = new Packet(false, "", getPilot("online").x);
  }
  PImage img = loadImage((android ? "data\\tmp\\" : "data/tmp/")+thisFile);
  if (debug) println("loaded "+thisFile);
  return img;
}

String[] loadUrl(String thisUrl) {
  network.loading = true;
  if (debug) { 
    Packet newPacket = new Packet(false, "", getPilot("online").x);
  }
  if (debug) println("loading "+thisUrl);  
  long pingStart = millis();
  if (network.wifi && network.online) {
    try { 
      String[] content = loadStrings(thisUrl);
      if (content != null) {
        network.pingTime = int(millis() - network.pingStart);
        if (debug) println("loaded url "+network.pingTime+"ms");
        if (debug) {
          Packet newPacket = new Packet(true, "", getPilot("online").x);
        }
        return content;
      }
    } 
    catch (Exception e) {
      if (debug) println(e);
      // onlines.add("error, exception");
    }
  }
  if (debug) println("error, offline");
  return null;
}

//String fileName = "weather.json";
//File file = new File(fileName);
//if (file!= null) {
//  weatherUpdated = file.lastModified();
//  //if ((currentTimeStamp - weatherUpdated)/1000 < weatherRefresh || !online) {
//  weatherContent = loadStrings(fileName);
//  //weatherUpdated = currentTimeStamp;
//  println("loading local file "+fileName);
//  //}
//}
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import processing.serial.*;


class Comm {
	PApplet parent;
	Serial port;
	String portNumber;

	boolean usb, bluetooth, connecting, connected, busy;
	String portName = "";
	String targetDeviceAddress = "";
	long lastTx, lastRx;
	int txR;
	int rxR;
	long connectionTime;

	// PLACEHOLDERS
	String deviceAddress, deviceRssi;

	// PROTOCOL IN
	int packetLength = 11;

	// PROTOCOL OUT
	int headerLength = 6;

	// SENSOR
	float sens = .5;
	float ax, ay, az;
	boolean shock;
	int mm;
	float battery;
	boolean charging;

	// MEMORY
	float maxMemory = 0;  
	int freeMemory = 0;

	float tiltAngle = 3;

	// final int BLE_PACKET_LENGHT=18;
	// final int TX_SPEED = 200;

	int txDelay;

	Comm(PApplet _parent) {
		parent = _parent;
	}

	void init() {
		usb = true;
		for (int i=0; i<Serial.list().length; i++) {
			if (Serial.list()[i].indexOf(portNumber) != -1) {
				portName = Serial.list()[i];   
				try {
					port = new Serial(parent, portName, 115200);
					connecting = true;
					connected = true;
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

	void update() {
		if (connected) {
			rx();
		}
	}

	void terminate() {
		port = null;
		// connected = false;
	}

	void tx(byte[] data) {  
		if (connected) {
			txR = int(millis() - lastTx);
			lastTx = millis();
			port.write(data);
			if (debug) {
				Packet newPacket = new Packet(false, "", getPilot("bluetooth").x);
			}
		}
	}

	void tx(String str) {
	}

	void rx() {  
		if (port.available() > 13  ) {
			byte[] data = port.readBytesUntil(254);
			rxR = int(millis() - lastRx);
			lastRx = millis();
			if (data != null) {
				parseBytes(data);
				if (debug) {
					Packet newPacket = new Packet(true, "", getPilot("bluetooth").x);
				}
			}
		}
	}

	//  String createString(String thisString, int thisMode, int thisTick, int thisTock, int thisTuck) {
	//   return thisMode+""+TAB+""+thisTick+""+TAB+""+thisTock+""+TAB+""+thisTuck+""+TAB+""+thisString;
	// }

	void writeString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
		txDelay = 0;
		byte[] data = new byte[thisString.length()+headerLength+1];
		data[0] = (byte)(thisMode+48);
		data[1] = (byte)(tack+48);
		data[2] = (byte)(teck+48);
		data[3] = (byte)(tick+48);
		data[4] = (byte)(tock+48);
		data[5] = (byte)(tuck+48);
		for (int i=0; i < thisString.length(); i++) {  
			data[i+headerLength] = (byte)thisString.charAt(i);
		}
		data [data.length-1] = (byte)'\n';
		tx(data);
		if (debug) {
			println(thisMode+"|"+tack+"|"+teck+"|"+tick+"|"+tock+"|"+tuck+"|"+thisString);
		}
	}

	void parseBytes(byte[] data) {
		if (data.length == packetLength) {
			mm = data[0];
			ax = data[2]*(data[1] == 1 ? -1 : 1);
			ay = data[4]*(data[3] == 1 ? -1 : 1);
			az = data[6]*(data[5] == 1 ? -1 : 1);
			battery = (data[7]+320.0)/100.0;
			charging = (data[8] == 1);
			busy = false;
		}
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

void updateSensors() {
}

void   scanDevices() {
}    



// /////////////////
// // MIC
// /////////////////

// import ddf.minim.*;

// class Eq {
// 	Minim minim;
// 	AudioInput in;

// 	char[] eqData;
// 	float[]eqVal;
// 	int res= 32;

// 	float maxL = .03;
// 	float midL = .01;
// 	float minL = midL/2;

// 	float rightL;
// 	float leftL;
// 	float eqFilter = .2;

// 	Eq (PApplet parent) {
// 		minim = new Minim(parent);
// 		in = minim.getLineIn(minim.STEREO, res);
// 		eqData = new char[res];
// 		eqVal = new float[res];
// 	}

// 	boolean softEq = false;

// 	void update()
// 	{
// 		rightL = in.right.level();
// 		leftL = in.left.level();
// // if (channel == EQ ) {
// // pushMatrix();
// // stroke(redColor);
// // strokeWeight(2);
// // translate(0, height);
// // pushMatrix();
// // scale(width/res, 1);
// float offset = 100;
// // popMatrix();
// float eqWidth = width*1.0/(res-1);
// for (int i = 0; i < in.bufferSize(); i++) {
// 	float targetLevel =  abs(in.left.get(i));
// 	eqVal[i] = eqVal[i]+(targetLevel-eqVal[i])*eqFilter;
//   // if ( eqVal[i] > maxL) {
//   //   eqData[i] =EQ_HIGH;
//   // } else if ( eqVal[i] > midL &&  eqVal[i] < maxL) {
//   //   eqData[i] =EQ_MID;
//   // } else if ( eqVal[i] >  minL &&  eqVal[i] < midL) {
//   //   eqData[i] =EQ_LOW;
//   // } else {
//   //   eqData[i] =EQ_OFF;
//   // }
//   // line(0, -offset + in.left.get(i)*offset, eqWidth, -offset + in.left.get(i)*offset);
//   // translate(eqWidth, 0);
// }
// // popMatrix();
// // }
// }
// }
// //    if ( in.isMonitoring() )
// //    {
// //      in.disableMonitoring();
// //    }
// //    else
// //    {
// //      in.enableMonitoring();
// //    }
ArrayList<Pilot> pilots; 

void initPilots() {
  pilots = new ArrayList<Pilot>();
  Table pilotTable = loadTable("csv/pilotsTop.csv", "header, csv");
  for (int i=0; i<pilotTable.getRowCount(); i++ ) {
    TableRow row = pilotTable.getRow(i);
    Pilot thisPilot = new Pilot(row.getString("name"), row.getString("shape"), row.getInt("command"));
    thisPilot.x = 80+(130*i);
    thisPilot.y = 70;
    pilots.add(thisPilot);
  }

  pilotTable = loadTable("csv/pilotsBottom.csv", "header, csv");
  for (int i=0; i<pilotTable.getRowCount(); i++ ) {
    TableRow row = pilotTable.getRow(i);
    Pilot thisPilot = new Pilot(row.getString("name"), row.getString("shape"), row.getInt("command"));
    thisPilot.x = 80+(130*i);
    thisPilot.y = (height-200)/(width/gui.cW);

    pilots.add(thisPilot);
  }

  pilotTable = loadTable("csv/pilotsControl.csv", "header, csv");
  for (int i=0; i<pilotTable.getRowCount(); i++ ) {
    TableRow row = pilotTable.getRow(i);
    Pilot thisPilot = new Pilot(row.getString("name"), row.getString("shape"), row.getInt("command"));
    thisPilot.x = 80+(130*i);
    thisPilot.y = (height-70)/(width/gui.cW);

    pilots.add(thisPilot);
  }
}

void displayPilots() {
  String bluetoothInfo = "";
  boolean bluetoothOn = false;
  for (Teleobject teleobject : teleobjects) {
    if (teleobject.comm != null) {
      if (teleobject.comm.connected) {
        bluetoothInfo += teleobject.comm.portName+"\n";
        bluetoothOn  = true;
      } else {
        bluetoothInfo += "not connected\n";

      }
    }
  }

  String energyInfo = "";
  for (Teleobject teleobject : teleobjects) {
    if (teleobject.comm != null) {
      energyInfo += teleobject.comm.battery+"v "+(teleobject.comm.charging ? "c" : "b")+"\n";
    }
  }

  String currentChannelName = "null";

  Pilot currentPilot = getPilotByCommand(manager.channel);
  if (currentPilot != null) currentChannelName = currentPilot.name.toUpperCase();
  setPilot("play", manager.play);

  // TOP

  setPilot("settings", debug);

  setPilot("bluetooth", bluetoothOn);
  setPilot("bluetooth", bluetoothInfo);

  setPilot("wifi", network.wifi); 
  setPilot("wifi", network.wifiState+"\n"+network.hostIP+"\n"+network.hostName);

  setPilot("online", network.online);
  setPilot("online", network.onlineState + "\n" + (network.online ? network.externalIP+"\n"+network.pingTime+"ms" : ""));

  setPilot("energy", manager.channel==ENERGY);
  setPilot("energy", energyInfo);


  setPilot("orientation", manager.channel==ORIENTATION);
  setPilot("orientation", "R "+(ticker.comm.ax>=0?"+":"")+int(ticker.comm.ax)+"\n"+"P "+(ticker.comm.ay>=0?"+":"")+int(ticker.comm.ay)+"\n"+"H "+(ticker.comm.az>=0?"+":"")+int(ticker.comm.az));

  setPilot("time", manager.channel==TIME);
  setPilot("time", getStringTime(true,":")+"\n");

  setPilot("sync", sync);
  // setPilot("eq", "R "+nf((int)(eq.rightL*1000), 3, 0)+"\nL "+nf((int)(eq.leftL*1000), 3, 0));

  setPilot("navigation", manager.channel==NAVIGATION);

  setPilot("location", manager.channel==LOCATION);
  setPilot("location", getCoordinate(geolocation.latitude, true)+"\n"+getCoordinate(geolocation.longitude, false)+"\n"+geolocation.provider+", "+(time.currentTimeStamp-geolocation.lastUpdated)/1000+"s\n"+geolocation.houseNumber+" "+geolocation.street+"\n"+geolocation.neighbourhood);
  setPilot("sleep", manager.channel==SLEEP);
  setPilot("sleep", (int)frameRate+" fps\n"+width+"x"+height+"px");

  // BOTTOM

  setPilot("google", google.loggedin);
  if (profile != null) {
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
  setPilot("twitter", twitter.name+"\n@"+twitter.screenName+"\n"+twitter.userID+"\n"+twitter.followers.size()+" followers\n"+twitter.friends.size()+" friends\n"+twitter.trends.size()+" trending topics");
  if (twitter.img != null) setPilot("twitter", twitter.img);

  setPilot("facebook", manager.channel==FACEBOOK);

  setPilot("instagram", manager.channel==INSTAGRAM);

  setPilot("foursquare", manager.channel==FOURSQUARE);

  setPilot("news", manager.channel==NEWS);

  setPilot("weather", manager.channel==WEATHER);
  setPilot("weather", weather.conditionMain+", "+(time.currentTimeStamp-weather.lastUpdated)/1000+"s"+"\n"+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + (metric ? "°C" : char(29)+"°F")+"\n"+int(weather.humidity)+"% humidity"+"\n"+
    weather.pressure+"mPa \n"+weather.clouds+"% clouds\n"+weather.windSpeed+"m/h \n"+getHeading(weather.windDeg)+" "+(int)weather.windDeg+"°");


// CENTER

setPilot("play", manager.play);
setPilot("loop", manager.loop);


for (Pilot thisPilot : pilots) {
  thisPilot.display();
}
}

void checkPilots() {
  for (Pilot thisPilot : pilots) {
    thisPilot.check();
  }
}

class Pilot {
  String label;
  String name;
  int command;
  boolean state;
  PShape icon;
  float x, y, s = .7;
  float sx, sy;
  float val;
  PImage img;

  //float r = 0;

  boolean rotating;

  Pilot(String thisName, String thisShape, int thisCommand) {
    name = thisName;
    icon = loadShape("svg/"+thisShape+".svg");
    icon.disableStyle();
    command = thisCommand;
  }

  void display() {
    pushMatrix();
    translate(x, y);
    scale(s);
    if (gui.refresh) {
      rectMode(CENTER);
      noStroke();
      fill( backgroundColor);
      rect(0, 0, 120, 120);
      if (img != null) {
        pushMatrix();
        scale(112.0/img.width*1.0);
        imageMode(CENTER);
        image(img, 0, 0);
        popMatrix();
        noStroke();
        fill(backgroundColor);
        shape(mask, 0, 0);
      } else {
        noFill();
        stroke(state ? redColor : 255);
        strokeWeight(3);
        shape(icon, 0, 0);
      }
      noFill();
      strokeWeight(3);
      stroke(state ? redColor : whiteColor);
      shape(app, 0, 0);
    }
    if (label!=null && (debug || (name.equals("bluetooth") && activeObject == null))) { 
      fill(50);
      textAlign(CENTER);
      int fontSize = android ? 20 : 16;
      int lineHieght = android ? 26 : 24;
      textFont(font, fontSize);
      int offsetY =  y < height/2 ? 84 : (-84 - (countChar(label, '\n')*lineHieght));
      text(label, 0, offsetY);
    }
    popMatrix();
  }

  void check() {
    sx = screenX (x, y);
    sy = screenY (x, y);
    if (gui.clicked && dist(sx, sy, mouseX, mouseY) < 50) {
      manager.setChannel(command);
      gui.clicked = false;
    }
  }
}

void setPilotRotation(String thisPilot, boolean thisRotation) {
  for (Pilot pilot : pilots) {
    if (pilot.name.equals(thisPilot)) {
      pilot.rotating = thisRotation;
      break;
    }
  }
}

Pilot getPilot(String thisPilot) {
  for (Pilot pilot : pilots) {
    if (pilot.name.equals(thisPilot)) {
      return pilot;
    }
  }
  return null;
}

Pilot getPilotByCommand(int thisCommand) {
  for (Pilot pilot : pilots) {
    if (pilot.command == thisCommand) {
      return pilot;
    }
  }
  return null;
}

void setPilot(String thisPilot, boolean thisState) {
  for (Pilot pilot : pilots) {
    if (pilot.name.equals(thisPilot)) {
      pilot.state = thisState;
      break;
    }
  }
}

void setPilot(String thisPilot, String thisLabel) {
  for (Pilot pilot : pilots) {
    if (pilot.name.equals(thisPilot)) {
      pilot.label = thisLabel;
      break;
    }
  }
}

void setPilot(String thisPilot, PImage img) {
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
  color[] colorDots, targetDots;

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

    colorDots = new color[dotNum];
    targetDots = new color[dotNum];
    for (int i=0; i< colorDots.length; i++) {
      colorDots[i] = redColor;
    }
  }

  void update() {
  }

  void display() {
    fill(255);
    stroke(0);
    strokeWeight(thick);
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
    scale(.97);
    rotate(angleL);
    noStroke();
    fill(255);
    shape(wheel_mask, 0, 0);
    noFill();
    stroke(0);
    strokeWeight(thick);
    shape(wheel, 0, 0);

    popMatrix();
    pushMatrix();
    translate(135, -100);
    scale(.97);
    rotate(angleR);
    noStroke();
    fill(255);
    shape(wheel_mask, 0, 0);
    noFill();
    stroke(0);
    strokeWeight(thick);
    shape(wheel, 0, 0);    popMatrix();
  }

  void printString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
  }

  void randomReds(int b) {
    for (int i=0; i< colorDots.length; i++) {
      colorDots[i] = color(random(b), 0, 0);
    }
  }
}
/////////////////////////////////////
// MAIL
/////////////////////////////////////

// class Mail {
//   ArrayList<Email> mails;
//   int mailIndex;
//   boolean updated;
//   long lastUpdated;

//   Mail() {
//   }

//   void update() {
//     mails = new ArrayList<Email>();
//     String[] mailBuffer = loadUrl("http://teleobjects.com/api/proxy.php?mail=true");
//     for (int i=0; i<mailBuffer.length; i++) {
//       int currentMail = mailBuffer.length - i - 1;
//       if (mailBuffer[currentMail].indexOf("=?") == - 1) {
//         String[] items = splitTokens (mailBuffer[currentMail], "\t");
//         if (items.length>0) {

//           Email email = new Email();
//           String name =  items[0];
//           if (name.indexOf("<") != -1) {
//             name = name.substring(0, name.indexOf("<"));
//           }
//           email.name = removeQuotes(name);
//           if (items.length>1) {
//             email.date = items[1].substring(0, 11);
//           }
//           if (items.length > 2) {
//             email.subject = items[2].toUpperCase();
//           }
//           mails.add(email);
//         }
//       }
//     }
//     updated = true;
//     mailIndex = 0;
//     lastUpdated = time.currentTimeStamp;
//   }

//   // ArrayList<String> getPages() {
//   //   if (!updated) update();
//   //   return mails;
//   // }
// }

// class Email {
//   String name, date, subject;
// }

/////////////////////////////////////
// PLACES
/////////////////////////////////////

class Places {
  ArrayList<String> placeList, results;
  // int placeTypeIndex;
  String types;
  boolean placed;


  Places () {
    init();
  }

  void init() {
    placeList = new ArrayList<String>();
    String[] placeTypes = loadStrings("csv/place_types_short.csv");
    for (int i=0; i<placeTypes.length; i++) {
      placeList.add((placeTypes[i]));
    }
  }

  // ArrayList<String> getPages() {
  //   return places;
  // }

  void search(String str) {
     types = placeList.get(ticker.pageIndex);
     int radius = 500;
     results = new ArrayList<String>();
    String placesUrl = "https://maps.googleapis.com/maps/api/place/radarsearch/json?location="+geolocation.latitude+","+geolocation.longitude+"&radius="+radius+"&types="+encode(types)+"&key=AIzaSyCKVs8ruHWC9-gx2b2XpNz2AxzqUYvAD6c"; // &keyword=vegetarian&
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
          String placeDetailsUrl = "https://maps.googleapis.com/maps/api/place/details/json?placeid="+onePlaceId+"&key=AIzaSyCKVs8ruHWC9-gx2b2XpNz2AxzqUYvAD6c";
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
  String newsKey = "df5b7c70d8675c367c0cbacc5b8879e0:11:74861169";
  ArrayList<Article> articles;
  boolean updated;

  News() {
  }

  void update() {
    articles = new ArrayList<Article>();
    String newsUrl = "http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/1.json?api-key="+encode(newsKey);
    String[] newsResponse = loadUrl(newsUrl);
    if (newsResponse.length>0) {
      updated = true;
      String newsFragment = newsResponse[0];
      JSONObject newsJSON = processing.data.JSONObject.parse(newsFragment);
      JSONArray newsArray = newsJSON.getJSONArray("results");
      int numberOfNews = newsArray.size();
      for (int i=1; i<numberOfNews; i++) {
        JSONObject newsContent = newsArray.getJSONObject(i);
        String newsTitle = newsContent.getString("title");
        String newsSection = newsContent.getString("section");
        String newsKeywords = newsContent.getString("adx_keywords");
        String newsAbstract = newsContent.getString("abstract");
        String newsType = newsContent.getString("section");
        String imageUrl = "";
        try {
          JSONArray mediaArray = newsContent.getJSONArray("media");
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
    }
  }

  String cleanKeyword(String str) {
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
    ArrayList<String> keywords = new ArrayList<String>();
    String imageUrl;
  }

/////////////////////////////////////
// GEOLOCATION
/////////////////////////////////////

class Geolocation {
  String provider;
  double longitude, latitude, altitude, accuracy;
  String postCode, country, countryCode, state, county, city, suburb, neighbourhood, street, houseNumber, building;
  long lastUpdated;
  boolean updated;
  boolean located;

  boolean hardLocation = true;

  Geolocation() {
    if (!android) {
      init();
    }
  }

  void init() {
    if (hardLocation) {
      latitude = 40.7352735;
      longitude = -73.95551;
      provider = "fixed";
      located = true;
    } else {
      String url = "http://www.geoplugin.net/json.gp?ip="+network.externalIP;
      String[] geopluginContent = loadUrl(url);
      if (geopluginContent != null) {
        saveStrings("json\\geolocation.json", geopluginContent);
        String jsonFragment = "";
        for (int i=0; i<geopluginContent.length; i++) {
          jsonFragment += geopluginContent[i];
        }
        processing.data.JSONObject geolocatedData = processing.data.JSONObject.parse(jsonFragment);
        latitude = geolocatedData.getFloat("geoplugin_latitude");
        longitude = geolocatedData.getFloat("geoplugin_longitude");
        provider = "geoplugin";
        located = true;
      }
    }
  }

  void update() {
    if (located && !updated && network.online) {
      String url = "http://nominatim.openstreetmap.org/reverse?lat="+latitude+"&lon="+longitude+"&format=json";
      String[] geolocationContent = loadUrl(url);
      println(geolocationContent);
      if (geolocationContent != null) {
        saveLocal("location.json", geolocationContent);
        String jsonFragment = geolocationContent[0];
        if (!jsonFragment.contains("error")) {
          processing.data.JSONObject geolocatedData = processing.data.JSONObject.parse(jsonFragment);
          processing.data.JSONObject address = geolocatedData.getJSONObject("address");
          if (!address.isNull("country")) country = address.getString("country");
          if (!address.isNull("country_code")) countryCode = address.getString("country_code");
          if (!address.isNull("state"))   state = address.getString("state");
          if (!address.isNull("county"))  county = address.getString("county");
          if (!address.isNull("city"))  city = address.getString("city");
          if (!address.isNull("suburb")) suburb = address.getString("suburb");
          if (!address.isNull("house_number")) neighbourhood =  address.getString("neighbourhood");
          if (!address.isNull("road")) street = address.getString("road");
          if (!address.isNull("house_number")) houseNumber = address.getString("house_number");
          if (!address.isNull("building")) building = address.getString("building");
          if (!address.isNull("postcode")) postCode = address.getString("postcode");
          if (city != null) updated = true;
          lastUpdated = time.currentTimeStamp;
        }
      }
    }
  }
}

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
  String[] monthNames ={"January", "February", "March", "April", "May", "June", "July", 
  "August", "September", "October", "November", "December"};

  Time() {
    init();
    update();
  }

  void init() {
    Date d = new Date();
    startTimeStamp = d.getTime();
    Calendar cal = Calendar.getInstance();
    cal.setTime(d);
    int dayTemp = cal.get(Calendar.DAY_OF_WEEK);
    dayTemp -= 2;  // ???
    if (dayTemp < 0) dayTemp += 7;
    dayStr = dayNames[dayTemp];
    day = cal.get(Calendar.DAY_OF_MONTH);
    month = cal.get(Calendar.MONTH);
    monthStr = monthNames[month];
    year = cal.get(Calendar.YEAR);
    currentTimeStamp = d.getTime();
  }

  void update() {
    Date d = new Date();
    currentTimeStamp = d.getTime();
  }
}

/////////////////////////////////////
// WEATHER
/////////////////////////////////////

class Weather {
  boolean updated;
  long lastUpdated;
  int weatherRefresh = 300; 

  float windSpeed, windDeg, windGust, rain, clouds;
  String condition, conditionMain;
  float  temp, pressure, humidity;

  Weather() {
  }

  void update() {
    if (!updated && geolocation.updated) {
      String[] weatherContent = null;

      // weatherContent = loadLocal("weather.json");

      if (weatherContent == null && network.online) {
        String weatherUrl = "http://api.openweathermap.org/data/2.5/weather?lat="+geolocation.latitude+"&lon="+geolocation.longitude+"&appid=1ebe1cb0874724fa15a5a109140d6e4e"+"&units=imperial";
        weatherContent = loadUrl(weatherUrl);
        saveLocal("weather.json", weatherContent);
      }

      if (weatherContent != null) {
        String weatherFragment = weatherContent[0];
        processing.data.JSONObject weatherJSON = processing.data.JSONObject.parse(weatherFragment);
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
        lastUpdated = time.currentTimeStamp;
      }
    }
  }
}
class Teleobject {
  PApplet parent;
  String name;
  int num;
  Comm comm = null;
  Display display;

  // PAGES
  ArrayList<Page> pages = new ArrayList<Page>();
  int pageIndex = -1;
  int lastPageIndex = -1;
  long lastPage;
  int pageDelay = 2000;
  boolean newPage;
  // boolean play = true;
  // boolean loop = false;
  int channel;
  boolean ready;
  boolean direction;
  boolean manual;

  void init() {
  }

  void update() {
    if (comm != null) {
      comm.update();
      if (millis() < lastPage + 200   ) comm.busy = true;  // to get rid of bouncing packets!!! check delay with bluetooth!
      // if (comm.busy) lastPage = millis();
      if (!comm.busy) ready = true;
      // if (!comm.connected) {
      //   if (display.busy) lastPage = millis();
      //   ready = !display.busy;
      // }
      if (comm.connected && comm.connecting) { 
        // lastPage = millis()-100;
        comm.connecting = false;
        //manager.setChannel(HELLO);
        //manager.loop = false;
        //comm.busy = false;
        //ready = true;
      }
    }
    checkSensors();
    play();
  }

  void play() {
    if (ready && millis() > lastPage + pageDelay && pages.size() > 0 && pageIndex != -1 && pageIndex != lastPageIndex && pageIndex < pages.size()) { 
      lastPage = millis();
      Page thisPage = pages.get(pageIndex);
      int tmpMode = thisPage.mode;
      if (manual) {
        if (name.equals("ticker")) tmpMode= direction ? SCROLL_PUSH_RIGHT : SCROLL_PUSH_LEFT;
        manual = false;
      }
      writeString(thisPage.content, tmpMode, thisPage.tack, thisPage.teck, thisPage.tick, thisPage.tock, thisPage.tuck);
      pageDelay = thisPage.tuck * 100;
      lastPageIndex = pageIndex;
      ready = false;

      ///////////////// HACK
      if (manager.channel == CONTACTS && name.equals("ticker") && pageIndex > 0) {
        mailbox.initPages(CONTACTS);
        mailbox.pages.add(new Page("", SERVO, 2, 5, 15, 0, 0));
        mailbox. pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
        mailbox.pages.add(new Page("", FONT, 5, 0, 0, 0, 0));
        mailbox.pages.add(new Page(pages.get(pageIndex).content, STRING, 0, 1, 1, 64+6, 1 ));
      }

      if (manager.play || name.equals("mailbox")) {
        pageIndex++;
        if (pageIndex == pages.size()) {                  
          if (manager.loop && !name.equals("mailbox")) {
            initPages(channel);
            printPages();
            pageDelay = channel == TIME ? 500 : 5000;
          } else {
            pageIndex = -1;
            lastPageIndex = pageIndex;
          }
        }
      }


      if (name.equals("ticker")) {
        if (sync) {
          messaging.sendDweetQuietly("content",  thisPage.content+"|"+tmpMode+"|"+thisPage.tack+"|"+thisPage.teck+"|"+thisPage.tick+"|"+thisPage.tock+"|"+thisPage.tuck);
        }
      }
      ///////////////// HACK
    }
  }

  void nextPage() {
    lastPage = pageIndex;
    pageIndex++;
    if (pageIndex == pages.size()) pageIndex = 1;
    ready = true;
    manual = true;
    direction = true;
  }

  void previousPage() {
    lastPage = pageIndex;
    pageIndex--;
    if (pageIndex < 1)  pageIndex = pages.size()-1;

    if (name.equals("mailbox")) pageIndex = 0;
    ready = true;
    direction = false;
    manual = true;
  }

  void display(float x, float y) {
    pushMatrix();
    translate(x, y);
    display.display();
    popMatrix();
  }

  void printPages() {
  }

  void checkSensors() {    
  }

  void initPages(int _channel) {
    pages = new ArrayList<Page>();
    if (_channel != channel) newPage = true;
    channel = _channel;
    lastPageIndex = -1;
    lastPage = 0;
    pageIndex = 0;
    ready = true;
  }

  // String cleanUp(String str) {
  //   return display.cleanUp(str);
  // }

  void writeString(String content, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
    content = display.cleanUp(content);
    comm.writeString(content, thisMode, tack, teck, tick, tock, tuck);
    display.printString(content, thisMode, tack, teck, tick, tock, tuck);
    if (name.equals("ticker") && channel != ENERGY && channel != HELLO && channel != BYE) {
      reel.pages.add(new Page("", INSTANT, 1, 10, content.length()/2, 0, 0));
    }
  }
}

class Page {
  String content;
  int mode;
  int tack, teck, tick, tock, tuck;

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

long lastTilt, lastPitch;
boolean tiltEngaged, pitchEngaged;

class Ticker extends Teleobject {
  Ticker(PApplet _parent, int _num) {
    parent = _parent;
    num = _num;
  }

  void checkSensors() {
    if (comm.connected) {
      if (manager.channel == NAVIGATION || manager.channel == RESULTS || manager.channel == ORIENTATION || manager.channel == CONTACTS) {
        if (!comm.busy && millis() > comm.lastTx + 200) {
          comm.writeString("", 200, 0,0,0,0,0);
        }
      }
      float tilt = comm.ay - 7;
      if (abs(tilt) < 5) tiltEngaged = false;
      if (millis() > lastTilt + 500 && abs(tilt) > 10 && !tiltEngaged) {
        lastTilt = millis();  
        manager.play = false;
        tiltEngaged = true;
        if (tilt > 0) {
          manager.setChannel(LEFT);    
        } else {
          manager.setChannel(RIGHT);     
        }
      }
      float pitch = comm.ax;
      // if (pitch > -80 && pitch < 100) pitchEngaged = false;
      if (millis() > lastPitch + 500 ) {
        // pitchEngaged = true;
        lastPitch = millis();
        if (pitch < -100 && pitch > -120) {
          manager.setChannel(UP);    
        } else if (pitch > 100 && pitch < 120)  {
          manager.setChannel(DOWN);    
        }
      }
    }
  }

  void init() {
    display = new TickerDisplay();
    comm = new Comm(parent);
    comm.portNumber = "1411";
    comm.targetDeviceAddress = "FB:57:53:9C:DF:10";
    comm.init();
  }



  void printPages() {
    switch (channel) {

      case LOOK:
      pages.add(new Page("AB", LOOK, 0, 0, 0, 65, 66));
      break;

      case HELLO: 
      String hello = "What's up"+ (google.loggedin ? " "+profile.givenName : "") +"?";
      //pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
      //pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
      pages.add(new Page(hello, TICKER, 0, 0, 50, 0, 1));
      break;

      case BYE:
      pages.add(new Page("", SLEEP, 0, 0, 0, 0, 1));
      break;

      case LOCATION:    
      if (!geolocation.updated) {
        pages.add(new Page("We're lost...", TICKER, 0, 0, 80, 0, 1));
      } else {
        pages.add(new Page(getCoordinate(geolocation.latitude, true)+" "+getCoordinate(geolocation.longitude, false), TICKER, 0, 0, 20, 0, 20));
        pages.add(new Page((geolocation.houseNumber+" "+geolocation.street).toUpperCase(), TICKER, 0, 0, 20, 0, 20));
        pages.add(new Page((geolocation.neighbourhood+" "+geolocation.postCode).toUpperCase(), TICKER, 0, 0, 20, 0, 20));
        pages.add(new Page((geolocation.city+", "+geolocation.state).toUpperCase(), TICKER, 0, 0, 20, 0, 20));
      }
      break;
      case WEATHER:
      if (!weather.updated) {
        pages.add(new Page(("Can't connect to the cloud...").toLowerCase(), TICKER, 0, 0, 80, 0, 1));
      } else {
        pages.add(new Page((weather.condition+" in "+geolocation.neighbourhood).toUpperCase(), TICKER, 0, 0, 10, 10, 20));
        pages.add(new Page("IT'S "+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + (metric ? "°c" : "°f"), CENTERED, 1, 1, 20, 0, 10));
        pages.add(new Page(int(weather.humidity)+"% HUMID", CENTERED, 0, 0, 0, 0, 10));
        pages.add(new Page("PRESSURE "+int(weather.pressure)+"mPa", CENTERED, 0, 0, 0, 0, 10));
        pages.add(new Page("WIND "+int(weather.windSpeed) +"m/h "+(int)weather.windDeg+"° "+getHeading(weather.windDeg), CENTERED, 0, 0, 0, 0, 10));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 1));
      }
      break;
      case ONLINE:
      pages.add(new Page("IP "+network.externalIP+" PING "+network.pingTime+"ms", TICKER, 0, 0, 20, 10, 1));
      break;
      case WIFI:
      pages.add(new Page(network.hostName+"@"+network.hostIP, TICKER, 0, 0, 20, 10, 1));
      break;
      case BLUETOOTH:
      if (comm != null) {
        if (comm.connected) {
          if (!android) {
            pages.add(new Page(comm.portName, TICKER, 0, 0, 20, 0, 1));
          } else {
            pages.add(new Page(comm.deviceAddress+" "+comm.deviceRssi+"dB", TICKER, 0, 0, 20, 0, 0));
          }
        } else {
          pages.add(new Page("not connected...", TICKER, 0, 0, 20, 0, 1));
        }
      }
      break;
      case ENERGY:
      pages.add(new Page("", BATTERY, 0, 0, 0, 0, 1));
      break;
      case ORIENTATION:
      pages.add(new Page("", AXIS, 0, 0, 0, 0, 2));
      break;
      case TIME:
      pages.add(new Page(getStringTime(true, ". "), CENTERED, 0, 0, 0, 0, 10));
      break;

      case GOOGLE:
      if (google.loggedin) {
        //pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("What's up "+profile.givenName+"?", TICKER, 0, 0, 50, 10, 40));
        pages.add(new Page(profile.id, SCROLL_PUSH_RIGHT, 0, 0, 10, 0, 20));
        pages.add(new Page(profile.email.toUpperCase(), SCROLL_PUSH_RIGHT, 0, 0, 10, 0, 20));
        pages.add(new Page("we are over "+profile.minAge+", speak english!", SCROLL_PUSH_RIGHT, 0, 0, 10, 0, 20));
      } else {
        pages.add(new Page(("we gotta login to google!").toLowerCase(), TICKER, 0, 0, 10, 0, 1));
      }
      break;

      case CONTACTS:
      if (contacts.updated) {
        pages.add(new Page(("we've got "+contacts.contactList.size()+" friends!").toLowerCase(), SCROLL_CENTER_RIGHT, 0, 0, 30, 0, 40));
        // pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 0));
        for (Contact contact : contacts.contactList) {
          pages.add(new Page(contact.title.toUpperCase(), SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 20));
        }
      } else {
        pages.add(new Page(("we gotta login to google!").toLowerCase(), TICKER, 0, 0, 10, 0, 1));
      }
      break;

      case NEWS:
      if (news.updated) {
        pages.add(new Page(("LET'S CHECK OUT THE NY TIMES").toUpperCase(), SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 40));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 1));
        for (Article article : news.articles) {
          for (int i=0; i < article.keywords.size(); i++) {
            String keyword = article.keywords.get(i);
            pages.add(new Page(keyword.toUpperCase(), CENTERED, 0, 0, 0, 0, 5));
          }
          pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
          pages.add(new Page(article.title.toUpperCase(), SCROLL_ALL_RIGHT, 0, 0, 90, 0, 20));
          pages.add(new Page(article.content.toUpperCase(), TICKER, 0, 0, 10, 10, 30));
        }
      } else {
        pages.add(new Page(("HAVE YOU SEEN THE NEWSPAPER?").toLowerCase(), TICKER, 0, 0, 30, 0, 1));
      }
      break;

      case MAIL:
      if (mail.updated) {
        pages.add(new Page(("latest "+mail.mailList.size()+" emails!").toLowerCase(), SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 50));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 1));

        for (Email email : mail.mailList) {
          pages.add(new Page(email.date.toUpperCase(), SCROLL_CENTER_RIGHT, 0, 0, 20, 0, 20));
          pages.add(new Page(email.sender.toUpperCase(), TICKER, 0, 0, 20, 20, 30));
          pages.add(new Page(email.subject.toUpperCase(), TICKER, 0, 0, 10, 10, 20));
          pages.add(new Page(email.snippet.toUpperCase()+".......", TICKER, 0, 0, 10, 10, 20));
          pages.add(new Page("", BLANK, 0, 0, 10, 0, 0));
        }
      } else {
        pages.add(new Page(("we gotta login to google!").toUpperCase(), TICKER, 0, 0, 30, 0, 0));
      }
      break;

      case CALENDAR:
      if (calendar.updated) {
        pages.add(new Page("", TICKER, 0, 0, 0, 0, 1));
        pages.add(new Page(("do you rememember when...?").toLowerCase(), SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 50));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 1));
        for (int i=0; i<50; i++) { 
          Event event = calendar.eventList.get((int)random(calendar.eventList.size()));
          pages.add(new Page(event.date.toUpperCase(), CENTERED, 0, 0, 0, 0, 20));
          pages.add(new Page(event.summary.toUpperCase(), TICKER, 0, 0, 50, 10, 30));
        }
      } else {
        pages.add(new Page("can't seem to find our calendar", TICKER, 0, 0, 60, 0, 30));
      }
      break;

      case TWITTER:
      if (twitter.updated) {
        pages.add(new Page("", TICKER, 0, 0, 0, 0, 1));
        pages.add(new Page("what's going on in twitter?", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 50));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 20));
        pages.add(new Page("@"+twitter.screenName, TICKER, 0, 0, 30, 10, 20));
        if (twitter.description != null)  pages.add(new Page(twitter.description, TICKER, 0, 0, 30, 10, 20));
        if (twitter.location != null)  pages.add(new Page("@"+twitter.location, TICKER, 0, 0, 30, 10, 20));

        pages.add(new Page("trending in NYC", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 30));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 1));
        for (String trend : twitter.trends) {
          pages.add(new Page(trend, CENTERED, 0, 0, 0, 0, 10));
        }

        pages.add(new Page(twitter.followers.size()+" FOLLOWERS", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 30));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 1));
        for (String follower : twitter.followers) {
          pages.add(new Page("@"+follower, CENTERED, 0, 0, 0, 0, 10));      
        }

        pages.add(new Page(twitter.friends.size()+" FRIENDS", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 30));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 1));

        for (String friend : twitter.friends) {
          pages.add(new Page("@"+friend, CENTERED, 0, 0, 0, 0, 10));
        }
      }else {
        pages.add(new Page("oh no, twitter is down!", TICKER, 0, 0, 60, 0, 1));
      }
      break;

      case NAVIGATION:
      manager.play = false;
      // manager.loop = true;
      for (String place : places.placeList) {
        pages.add(new Page(place.toUpperCase(), SCROLL_PUSH_RIGHT, 0, 0, 5, 0, 10));
      }
      break;

      case RESULTS:
      manager.play = true;
      // manager.loop = true;
      if (places.results.size() > 0) {
        pages.add(new Page("FOUND "+places.results.size()+" "+places.types+"s", TICKER, 0, 0, 30, 0, 20));
        for (String result : places.results) {
          pages.add(new Page(result.toUpperCase()+" is open", TICKER, 0, 0, 30, 10, 20));
        }
      } else {
        pages.add(new Page("no "+places.types+"around here!", TICKER, 0, 0, 60, 0, 1));
      }

      break;
    }
    if (channel != ENERGY && channel != HELLO && channel != BYE) {
      int payload = 0;
      for (Page page : pages) {
        payload += page.content.length();
      }
      reel.pages.add(new Page("", INSTANT, 0, 23, int(payload/5), 0, 5));
    }
  }
}

class Comment extends Teleobject {
  Comment(PApplet _parent, int _num) {
    parent = _parent;
    num = _num;
  }

  void init() {
    comm = new Comm(parent);
    display = new CommentDisplay();
    comm.portNumber = "1421";
    comm.targetDeviceAddress = "E4:CB:FF:38:3A:00";
    comm.init();
  }

  void printPages() {
    switch (channel) {
      case BYE:
      pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
      //pages.add(new Page("zzz", INSTANT, 0, 0, 0, 0, 0));
      break;

      case HELLO: 
      pages.add(new Page("", TICKER, 0, 0, 0, 0, 1));
      pages.add(new Page("", FONT, 1, 1, 0, 0, 1));
      if (!google.loggedin) {
        pages.add(new Page("What's up?", TICKER, 0, 0, 80, 0, 1));
      } else {
        pages.add(new Page("What's up", TICKER, 0, 0, 80, 0, 1));
        pages.add(new Page(profile.givenName+"?", TICKER, 1, 0, 80, 0, 1));
      }

      break;

      case LOCATION:
      if (!geolocation.updated) {
        pages.add(new Page("We're lost...", TICKER, 0, 0, 50, 0, 1));
      } else {
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page(getCoordinate(geolocation.latitude, true), CENTERED, 0, 0, 0, 0, 1));
        pages.add(new Page(getCoordinate(geolocation.longitude, false), CENTERED, 1, 0, 0, 0, 20));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page(geolocation.houseNumber+" "+geolocation.street, SCROLL_ALL_RIGHT, 0, 0, 10, 0, 5));
        pages.add(new Page(geolocation.neighbourhood+" "+geolocation.postCode, TICKER, 0, 0, 20, 0, 5));
        pages.add(new Page(geolocation.city+", "+geolocation.state, TICKER, 1, 0, 20, 0, 20));
      }
      break;

      case WEATHER:
      if (!weather.updated) {
        pages.add(new Page("can't connect to the cloud...", TICKER, 0, 0, 50, 0, 0));
      } else {
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
        pages.add(new Page(("weather"), SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 30));
        pages.add(new Page((weather.condition+" in "+geolocation.neighbourhood), SCROLL_ALL_RIGHT, 1, 0, 5, 0, 1));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("It's "+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + (metric ? "°c" : "°f"), CENTERED, 0, 0, 0, 0, 10));
        pages.add(new Page("and it's gonna get hotter...", SCROLL_ALL_RIGHT, 1, 0, 10, 0, 10));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("humidity", CENTERED, 0, 0, 0, 0, 5));
        pages.add(new Page(int(weather.humidity)+"%", CENTERED, 1, 0, 0, 0, 10));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("pressure", CENTERED, 0, 0, 0, 0, 5));
        pages.add(new Page(int(weather.pressure)+"mPa", CENTERED, 1, 0, 0, 0, 10));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("wind", CENTERED, 0, 0, 0, 0, 5));
        pages.add(new Page(int(weather.windSpeed) +"m/h "+(int)weather.windDeg+"° "+getHeading(weather.windDeg), CENTERED, 1, 0, 0, 0, 10));
      }
      break;

      case ONLINE:
      pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
      pages.add(new Page("ip "+network.externalIP, CENTERED, 0, 0, 0, 0, 1));
      pages.add(new Page("ping "+network.pingTime+"ms", CENTERED, 1, 0, 0, 0, 1));
      break;

      case WIFI:
      pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
      pages.add(new Page(network.hostName, CENTERED, 0, 0, 0, 0, 1));
      pages.add(new Page(network.hostIP, CENTERED, 1, 0, 0, 0, 1));
      break;

      case BLUETOOTH:
      if (comm != null) {
        if (comm.connected) {
          if (!android) {
            pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
            pages.add(new Page(comm.portName.substring(0, 5), TICKER, 0, 0, 20, 0, 1));
            pages.add(new Page(comm.portName.substring(5, comm.portName.length()), TICKER, 1, 0, 20, 0, 1));
          } else {
            pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
            pages.add(new Page(comm.deviceAddress, CENTERED, 0, 0, 0, 0, 1));
            pages.add(new Page(comm.deviceRssi+"dB", CENTERED, 1, 0, 0, 0, 1));
          }
        } else {
          pages.add(new Page("not connected...", TICKER, 0, 0, 10, 0, 1));
        }
      } 
      break;

      case ENERGY:
      pages.add(new Page("", BATTERY, 0, 0, 0, 0, 1));
      break;

      case TIME:
      //pages.add(new Page(getStringTime(true, "."), CENTERED, 0, 0, 0, 0, 10));
      //if (newPage) pages.add(new Page(time.monthStr+" "+time.day+"th, "+time.year, CENTERED, 1, 0, 0, 0, 0));//time.dayStr+", "+
      String hour_ = nf(hour(), 2, 0);
      String minute_ = nf(minute(), 2, 0);
      pages.add(new Page(getStringTime(true, "."), CLOCK, hour_.charAt(0), hour_.charAt(1), minute_.charAt(0), minute_.charAt(1), 10));
      break;

      case GOOGLE:
      if (google.loggedin) {
        //pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("", FONT, 1, 1, 0, 0, 1));

        pages.add(new Page("What's up", TICKER, 0, 0, 50, 0, 10));
        pages.add(new Page(profile.givenName+"?", TICKER, 1, 0, 40, 0, 30));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("our google id", CENTERED, 0, 0, 0, 0, 1));
        pages.add(new Page(profile.id, SCROLL_ALL_RIGHT, 1, 0, 10, 0, 5));
        pages.add(new Page("our email", CENTERED, 0, 0, 0, 0, 1));
        pages.add(new Page(profile.email, SCROLL_ALL_RIGHT, 1, 0, 10, 0, 5));
        pages.add(new Page("we are over "+profile.minAge+",", CENTERED, 0, 0, 0, 0, 1));
        pages.add(new Page("speak english!", CENTERED, 1, 0, 0, 0, 30));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("let's!", CENTERED, 0, 0, 0, 0, 10));
        pages.add(new Page("rock!", CENTERED, 1, 0, 0, 0, 30));
      } else {
        pages.add(new Page("let's login to google!"+profile.givenName, CENTERED, 0, 0, 10, 0, 0));
      }
      break;

      case CONTACTS:
      // pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
      pages.add(new Page(contacts.contactList.size()+" friends!", CENTERED, 0, 0, 0, 0, 40));
      for (Contact contact : contacts.contactList) {
        pages.add(new Page(contact.title.toUpperCase(), CENTERED, 1, 0, 0, 0, 15));
      }
      break;

      case NEWS:
      if (news.updated) {
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
        pages.add(new Page(("NY TIMES"), SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 30));
        for (Article article : news.articles) {
          for (int i=0; i < article.keywords.size(); i++) {
            String keyword = article.keywords.get(i);
            pages.add(new Page(keyword.toUpperCase(), CENTERED, 0, 0, 0, 0, 5));
          }
          pages.add(new Page(article.title, SCROLL_ALL_RIGHT, 1, 0, 5, 0, 0));
          pages.add(new Page(article.content, SCROLL_ALL_RIGHT, 1, 0, 5, 0, 0));
        }
      } else {
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
      } else {
        pages.add(new Page("can't find...", TICKER, 0, 0, 60, 0, 30));
        pages.add(new Page(("...the calendar"), TICKER, 1, 0, 60, 0, 30));
      }
      break;
    }
  }
}

class Mailbox extends Teleobject {
  Mailbox(PApplet _parent, int _num) {
    parent = _parent;
    num = _num;
  }

  void init() {
    comm = new Comm(parent);
    display = new MailboxDisplay();
    comm.portNumber = "1431";
    comm.targetDeviceAddress = "D2:26:16:99:DF:A5";
    comm.init();
  }

  void printPages() {
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

//////////
// REEL
//////////

class Reel extends Teleobject {
  Reel(PApplet _parent, int _num) {
    parent = _parent;
    num = _num;
  }

  void init() {
    comm = new Comm(parent);
    display = new ReelDisplay();
    comm.portNumber = "1441";
    comm.targetDeviceAddress = "C0:70:75:10:D9:AF";
    comm.init();
  }

  void initPages(int _channel) {
    channel = _channel;
  }

  void play() {
    if (ready && pages.size() > 0 && millis() > lastPage + pageDelay) { 
      lastPage = millis();
      Page thisPage = pages.get(0);
      pages.remove(0);
      pageDelay = thisPage.tuck * 100;
      comm.writeString(thisPage.content, thisPage.mode, thisPage.tack, thisPage.teck, thisPage.tick, thisPage.tock, thisPage.tuck);
      ready = false;
    }
  }

  void printPages() {
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
  Frame(PApplet _parent, int _num) {
    parent = _parent;
    num = _num;
  }

  void init() {
    display = new FrameDisplay();
  }
}

class Display {
  boolean busy = true;

  Display() {
  }

  void init() {
  }

  void display() {
  }

  void update() {
  }

  String cleanUp(String str) {
    return str;
  }

  void printString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
  }
}


class TickerDisplay extends Display {

  final int CHARS = 32;

  char DEC_POINT = 47;
  char DEGREE = 29;
  char SINGLE_QUOTE = 5;
  char DECIMAL_POINT = 14;
  char BAR_TOP = 0;
  char BAR_MIDDLE = '-';
  char BAR_BOTTOM = 3;
  char EQ_LOW = '_';
  char EQ_MID = '=';
  char EQ_HIGH = 135;
  char EQ_OFF = ' ';


  PShape outline, outline_mask;
  PShape segments[];
  String segmentNames[] = {"DP", "N", "M", "L", "K", "J", "H", "G2", "G1", "F", "E", "D", "C", "B", "A"};
  String alphaFont[];
  int mode = 0;
  String data = "";
  long lastTick;
  char[] dis;
  boolean[] dec;
  int cursorX = 0;
  int breakX;
  boolean busy;
  int displayMode, tack, teck, tick, tock, tuck;

  float rot, targetRot;

  // SLEEP
  boolean busyZ;
  int zzz, zzzC, zzzD = 1;
  long nextZ;
  long awakeStart;

  TickerDisplay() {
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

  void update() {
    switch(mode) {
      case LOOK:
      clearDisplay();
      int eyesX = 0;
      boolean eyesB = millis() % 1200 < 300;
      face = tock-65;//(int)data.charAt(0)- 65;
      faceClosed = tuck-65;//(int)data.charAt(1) - 65;
      dis[eyesX] = !eyesB ?  char(leftEyes[face]) : char(leftEyes[faceClosed]);
      dis[eyesX + 1] = !eyesB ?  char(rightEyes[face]) : char(rightEyes[faceClosed]) ;
      dec[eyesX] = true;
      break;
      case SLEEP:
      clearDisplay();
      switch (zzz) {
        case 0:
        break;
        case 1:
        dis[0] = 'z';
        break;
        case 2:
        dis[0] = 'z';
        dis[1] = 'z';
        break;
        case 3 :
        dis[0] = 'z';
        dis[1] = 'z';
        dis[2] = 'z';
        break;
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
      if (millis() > lastTick + tick*1) {
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
              if (data.charAt(0) == '.' && dis [CHARS-2] != '.') {
                dec[CHARS - 1] = true;
                data = data.substring(1, data.length());
                breakX --;
              }
            }
          } else {
            dis[CHARS - 1] = ' ';
            dec[CHARS-1 ] = false;
          }
        } else if (cursorX > breakX ) {   /// scroll left
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
      if (millis() - lastTick > tick*1.10) {
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
          if (cursorX < CHARS) { ///// to fix bug ????
            dis[cursorX] = data.charAt(0);
          }
          data = data.substring(1, data.length());
          if (data.length() > 0) {
            if (data.charAt(0) == '.' && dis[cursorX] != '.') {
              dec[cursorX] = true;
              data = data.substring(1, data.length());
              breakX --;
              if (data.length() == 0) {
                lastTick = millis() + tock*100;
              }
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
      if (cursorX < CHARS && cursorX >= 0) dis[cursorX] = millis() % 500 < 250 ? CHARS : '_';
      break;
    }
  }

  void display() {
    update();
    targetRot = radians(ticker.comm.ay-8);
    rot += (targetRot-rot)*.1;

    if (manager.channel == ORIENTATION) {
      rotate(rot);
    }

    //if (gui.refresh || debug) {
      strokeWeight(thick);
      stroke(0);
      fill(255);
      shape(outline, 0, 0);
      fill(backgroundColor);
      shape(outline_mask, 0, 0);
    //} //else {
    //rectMode(CENTER);
    //fill(255);
    //noStroke();
    //rect(0, 35, 1120, 50);
    //}
    //
    fill(redColor);
    noStroke();
    float currentX = -546;
    for (int i=0; i < CHARS; i++) {
      pushMatrix();
      translate(currentX, 36);
      scale(.16);
      drawChar(dis[i]);
      if (dec[i]) drawChar('.');
      currentX += 35;
      popMatrix();
    }
  }

  void printString(String thisString, int thisMode, int thisTack, int thisTeck, int thisTick, int thisTock, int thisTuck) {
    data = thisString;
    mode = thisMode;
    tack = thisTack;
    teck = thisTeck;
    tick = thisTick;
    tock = thisTock;
    tuck = thisTuck;
    busy = false;

    lastTick = millis();// + 300; /// parent.comm.txDelay

    switch (mode) {
      case BLANK:
      clearDisplay();
      break;

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

      case STREAM:
      if (data.length() == CHARS) {
        // dis = data;
        for (int i=0; i<CHARS; i++) {
          dis[i] = data.charAt(i);
        }
      }
      break;

      case CENTERED:
      clearDisplay();
      cursorX = (CHARS - data.length() +  countChar(data, '.')) / 2;
      while (data.length() > 0 && cursorX < CHARS) {
        dis[cursorX] = data.charAt(0);
        data = data.substring(1, data.length());
        if (data.length() > 0) {
          if (data.charAt(0) == '.' && dis[cursorX] != '.') {
            dec[cursorX] = true;
            data = data.substring(1, data.length());
          }
        }
        cursorX ++;
      }
      break;

      case TICKER:
      breakX = 0;
      busy = true;
      break;

      case SCROLL_ALL_RIGHT:
      cursorX = 0;
      breakX = CHARS + data.length();
      mode = SCROLL;
      busy = true;
      break;

      case SCROLL_CENTER_RIGHT:
      cursorX = 0;
      breakX = ((CHARS - data.length()) / 2) + data.length();
      mode = SCROLL;
      busy = true;

      break;

      case SCROLL_PUSH_RIGHT:
      cursorX = 0;
      int lastX = CHARS+1;
      for (int i=CHARS-1; i>=0; i--) {
        if (dis[i] != ' ') break;
        lastX --;
      }
      breakX = ((CHARS - data.length()) / 2) + data.length();
      if (breakX < lastX) {
        for (int i=0; i < (lastX - breakX) && data.length()< CHARS; i++) {
          data = " "+data;
          data = data +" ";
        }
        if (CHARS > data.length()) {
          breakX = ((CHARS - data.length()) / 2) + data.length();
        } else {
          breakX = data.length();
        }
      } 
      mode = SCROLL;
      busy = true;
      break;

      case SCROLL_ALL_LEFT:
      cursorX = 0;
      breakX = -CHARS - data.length();
      mode = SCROLL;
      busy = true;
      break;

      case SCROLL_CENTER_LEFT:
      cursorX = 0;
      breakX = -((CHARS - data.length()) / 2) - data.length();
      mode = SCROLL;
      busy = true;
      break;

      case SCROLL_PUSH_LEFT:
      cursorX = 0;
      int firstX = 0;
      for (int i=0; i<CHARS; i++) {
        if (dis[i] != ' ') break;
        firstX ++;
      }
      firstX = -(CHARS - firstX);
      breakX = -((CHARS - data.length()) / 2) - data.length();
      if (breakX > firstX) {
        for (int i=0; i < (breakX - firstX) && data.length()< CHARS; i++) {
          data = " "+data;
          data = data +" ";
        }
        if (CHARS > data.length()) {
          breakX = -((CHARS - data.length()) / 2) - data.length();
        } else {
          breakX = data.length();
        }
      } 
      mode = SCROLL;
      busy = true;
      break;

      case AIRPORT:
      for (int i = data.length(); i < CHARS; i++) {
        data += " ";
      }
      break;
    }
  }

  void drawChar(char thisChar) {
    String thisWord = "000000000000000";
    if (thisChar < alphaFont.length) {
      thisWord = alphaFont[thisChar].substring(3, 18);
    } 
    for (int i=0; i<15; i++) {
      if (thisWord.charAt(i) == '1') {
        shape(segments[i], 0, 0);
      }
    }
  }

  void clearDisplay() {
    for (int i=0; i < CHARS; i++) {
      dis[i] = ' ';
      dec[i] = false;
    }
    cursorX = 0;
  }

  String invalid  = "`´_âáäÁÂÄéêëÉÊËíîïÍÎÏóôöÓÔÖúûüÚÛÜñÑ";
  String subs     = "'' 'aaAAAeeeEEEiiiIIIoooOOOuuuUUUnN   ";
  String valid = " !@#$%^&*()-+=[]}{;':<>,.?/01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz°'"+char(34);

  String cleanUp(String str) {
    String res = "";
    for (int i=0; i<str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '&'){
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
      if (ch > 127) {
        ch = 39;
      }
      if (valid.indexOf(ch) != -1) {
        res +=  ch;
      } else {
        res += 39;//'-';
        //ch = 39;
      }

    }
    return res;
  }
}

class Twitter {
  String CONSUMER_KEY = "Ray2xXVP9I1PuxgOP1Cu6IdXO";
  String CONSUMER_SECRET = "EnZmqdtHIoH4zhDrp4VE0Ze3LzrWUrdFSZUg2CHSRu3iNzVk2i";
  String TOKEN_SECRET;// = "dxKlTw62t3w9Dc3H3pt5n5qOYqVpslIMfyVeCQV7LnbmI";
  String TOKEN;// = "dxKlTw62t3w9Dc3H3pt5n5qOYqVpslIMfyVeCQV7LnbmI";
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
    trends = new ArrayList<String>();   
    followers = new ArrayList<String>();
    friends = new ArrayList<String>();
  }  

  void update() {
    getTrendingTopics();
    getFollowers();
    getFriends();
    updated = true;
  }

  void getFollowers() {
    followers = new ArrayList<String>();
    JSONObject followersObject = runListFollowersChoreo(userID);
    JSONArray followersArray = followersObject.getJSONArray("users");
    for (int i = 0; i<followersArray.size(); i++) {
      JSONObject thisFollower = followersArray.getJSONObject(i);
      followers.add(thisFollower.getString("screen_name"));
    }
  }

  void getFriends() {
    friends = new ArrayList<String>();
    JSONObject friendsObject = runListFriendsChoreo(userID);
    JSONArray friendsArray = friendsObject.getJSONArray("users");
    for (int i = 0; i<friendsArray.size(); i++) {
      JSONObject thisFriend = friendsArray.getJSONObject(i);
      friends.add(thisFriend.getString("screen_name"));
    }
  }

  void getTrendingTopics() {
    println("getting trending");
    trends = new ArrayList<String>();   
    JSONObject trendsObject = runPlaceChoreo(placeID);
    JSONArray trendsArray = trendsObject.getJSONArray("trends");
    for (int i = 0; i<trendsArray.size(); i++) {
      JSONObject thisTrend = trendsArray.getJSONObject(i);
      trends.add(removeQuotes(thisTrend.getString("name")));
    }
  }

  void login() {
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
        saveLocal("twitter.txt", twitterBuffer);
      } else {
        try {
          String[] twitterBuffer = loadLocal("twitter.txt");
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
      img = loadLocalImage(userID+".png");
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

  void runInitializeOAuthChoreo() {
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

  void runFinalizeOAuthChoreo() {
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

  JSONObject runListFollowersChoreo(String userID) {
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

  JSONObject runListFriendsChoreo(String userID) {
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

  JSONObject runPlaceChoreo(String placeId) {
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

  JSONObject runShowChoreo(String thisUserID) {
    JSONObject result;
    try {
      String[] showBuffer = loadLocal(thisUserID+".txt");
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
      saveLocal(thisUserID+".txt", tmp);    
      result = JSONObject.parse(showBuffer);
      // println(showResults.getLimit());
      // println(showResults.getRemaining());
      // println(showResults.getReset());
    }
    return result;
  }
}
  char DOUBLE_QUOTE = 34;

  String concatenate(String[] content) {
    String result="";
    for(int i=0; i<content.length;i++){
      result += content[i];
    }
    return result;
  }

  int countChar(String str, char c){
    if (str.length() == 0 || str == null) return 0;
    int count = 0;
    for (int i=0; i<str.length(); i++) {
      if(str.charAt(i) == c) count ++;
    }
    return count;
  }

  int findLastChar(String str, char c) {
    if (str.length() == 0 || str == null) return 0;
    int count = str.length() - 1;
    while (count > 0) {
      if (str.charAt(count) == c) break;
      count --;
    }
    return count;
  }

  String removeQuotes(String str) {
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

  String removeSpaces(String str) {
    if (str.length() > 0) {
      if (str.charAt(0) == ' ') {
        str = str.substring(1, str.length());
      }
    }
    if (str.length() > 0) {
      if (str.charAt(str.length()-1) == ' ') {
        str = str.substring(0, str.length()-1);
      }
    }
    return str;
  }

  String removeBrackets(String str) {
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

  String encode(String name) {
    String encoded = null;
    try { 
      encoded = java.net.URLEncoder.encode(name, "UTF-8"); 
    } catch (Exception e) {

    }
    return encoded;
  }

  String getHeading(float deg) {
    String[] directions = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", 
    "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"};
    int i = int((deg + 11.25)/22.5);
    return directions[i % 16];
  }

  String getCoordinate(double coordinate, boolean isLat) {
    char hemisphere = coordinate < 0 ? (isLat ? 'S' : 'W') : (isLat ? 'N' : 'E');
    float coord = (float)coordinate; 
    coord = abs(coord);
    int degrees = int(coord);         
    float minutesFromRemainder = (coord - degrees) * 60;      
    int minutes = int(minutesFromRemainder);      
    float secondsFromRemainder = ( minutesFromRemainder - minutes ) * 60;  
    int seconds = int( secondsFromRemainder);
    return (degrees+"°" + nf(minutes, 2, 0) + "'" + nf(seconds, 2, 0) + DOUBLE_QUOTE +""+hemisphere);
  }

  float getCelcius(float temp) {
    temp -= 32;
    temp /= 1.8;
    return temp;
  }

  String getStringTime(boolean am_pm, String separator) {
    String result = "";
    if (am_pm) {
      String hour_ = nf(hour()%12, 2, 0);
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
    }   else {
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


  float attract(float val, float target, float ratio, float snap) {
    float result =  val + ((target-val)*ratio);
    if (abs(result-target) < snap) result = target;
    return result;
  } 
