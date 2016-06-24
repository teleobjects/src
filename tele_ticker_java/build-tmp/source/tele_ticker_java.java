import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.Calendar; 
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
import java.net.InetAddress; 
import java.net.UnknownHostException; 
import processing.serial.*; 
import java.awt.image.BufferedImage; 
import java.io.ByteArrayInputStream; 
import java.io.ByteArrayOutputStream; 
import java.io.File; 
import java.io.IOException; 
import java.io.InputStream; 
import javax.imageio.ImageIO; 
import ddf.minim.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class tele_ticker_java extends PApplet {


















TembooSession session = new TembooSession("teleobjects", "teleobjects", "d1YKYX3a5Y6V1LAyYebWzB1RczFVkwrN");


boolean debug = false;
boolean verbose = true;
boolean metric = true;

boolean forceoffline = false;
boolean forcelogin = false;

boolean sync = true;

boolean android = false;

Time time;
Alpha alpha;
Gui gui;
Eq eq;
Google google;
Profile profile;
Geolocation geolocation;
GoogleContacts contacts;
GoogleCalendar calendar;
GoogleDrive drive;

Places places;
Mail mail;
Weather weather;
News news;
Twitter twitter;
Messaging messaging;

public void setup() {
  
  orientation(LANDSCAPE);

  time = new Time();
  places = new Places();
  profile = new Profile();
  google = new Google();
  news = new News();
  twitter = new Twitter();
  contacts = new GoogleContacts();
  calendar = new GoogleCalendar();
  drive = new GoogleDrive();
  geolocation = new Geolocation();
  eq = new Eq(this);
  weather = new Weather();
  mail = new Mail();
  messaging = new Messaging();
  alpha = new Alpha();
  gui = new Gui();
  gui.init();
  initComm();
}

public void draw() {

  if (google.authenticating || twitter.authenticating) {
    background(redColor);
    if (gui.clicked) {
      gui.clicked = false;
      if (google.authenticating) {
        google.login();
      } else if (twitter.authenticating) {
        twitter.login();
      }
    }
  } else {
    if (connected && connecting) {
      connecting = false;
      writeString("", BLANK, 1, 1, 1);
      writeString(cleanUp("Hi "+ (google.loggedin ? profile.givenName : "there") +"!", false), TICKER, 10, 1, 1);
      gui.refresh = true;
    }
    if (channel == EQ || channel == AXIS) gui.refresh = true;
    if (!connected) busy = alpha.busy;     /// simulator
    updateComm();
    time.update();
    geolocation.update();
    weather.update();
    eq.update();
    gui.update();
    play();
  }
}
final int CHARS = 32;

char DEC_POINT = 47;
char DEGREE = 29;
char SINGLE_QUOTE = 5;
char DOUBLE_QUOTE = 34;
char DECIMAL_POINT = 14;
char BAR_TOP = 0;
char BAR_MIDDLE = '-';
char BAR_BOTTOM = 3;
char EQ_LOW = '_';
char EQ_MID = '=';
char EQ_HIGH = 135;
char EQ_OFF = ' ';

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

final int DWEET_TX = 100;
final int IMAGE = 101;

class Alpha {
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

  // SLEEP
  boolean busyZ;
  int zzz, zzzC, zzzD = 1;
  long nextZ;
  long awakeStart;

  Alpha() {
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

  public void update() {
    switch(mode) {
      case LOOK:
      clearDisplay();
      int eyesX = 0;
      boolean eyesB = millis() % 1200 < 300;
      face = (int)data.charAt(0)- 65;
      faceClosed = (int)data.charAt(1) - 65;
      dis[eyesX] = !eyesB ?  PApplet.parseChar(leftEyes[face]) : PApplet.parseChar(leftEyes[faceClosed]);
      dis[eyesX + 1] = !eyesB ?  PApplet.parseChar(rightEyes[face]) : PApplet.parseChar(rightEyes[faceClosed]) ;
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
      if (millis() - lastTick > tick*1.35f) {
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

  public void display() {
    update();
    fill(redColor);
    noStroke();
    float currentX = -546;
    for (int i=0; i < CHARS; i++) {
      pushMatrix();
      translate(currentX, 36);
      scale(.16f);
      drawChar(dis[i]);
      if (dec[i]) drawChar('.');
      currentX += 35;
      popMatrix();
    }
  }

  public void printString(String thisString, int thisMode, int thisTick, int thisTock, int thisTuck) {
    data = thisString;
    mode = thisMode;
    tick = thisTick;
    tock = thisTock;
    tuck = thisTuck;
    busy = false;

    lastTick = millis() + txDelay;

    switch (mode) {
      case DWEET_TX:
      String[] items = splitTokens(thisString, "|");
      //if (dweet) {
      messaging.sendDweet(items[0], thisString.substring(thisString.indexOf("|"), thisString.length()));
      //}
      break;

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

  public void drawChar(char thisChar) {
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

  public void clearDisplay() {
    for (int i=0; i < CHARS; i++) {
      dis[i] = ' ';
      dec[i] = false;
    }
    cursorX = 0;
  }
}

String invalid  = "`\u00b4_\u00e2\u0080\u0098\u00e1\u00e4\u00c1\u00c2\u00c4\u00e9\u00ea\u00eb\u00c9\u00ca\u00cb\u00ed\u00ee\u00ef\u00cd\u00ce\u00cf\u00f3\u00f4\u00f6\u00d3\u00d4\u00d6\u00fa\u00fb\u00fc\u00da\u00db\u00dc\u00f1\u00d1";//+char(8217);
String subs     = "'' 'aaAAAeeeEEEiiiIIIoooOOOuuuUUUnN";
String valid = " !@#$%^&*()-+=[]}{;':<>,.?/01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"+DEGREE+DOUBLE_QUOTE+SINGLE_QUOTE;

public String cleanUp(String str, boolean capitalize) {
  String tmp = cleanUp(str);
  if (capitalize) tmp = tmp.toUpperCase();
  return tmp;
}

public String cleanUp(String str) {
  // boolean flag = false;
  String res = "";
  for (int i=0; i<str.length(); i++) {
    char ch = str.charAt(i);
    if (ch == '&' && str.charAt(i+1) == '#') {
      ch = 39;
      i = i+6;
      // flag = true;

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
  // if (flag) println(res);
  return res;
}
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
final int PLAY = -20;
final int UP = -10;
final int DOWN = -11;
final int LEFT = -12;
final int RIGHT = -13;
final int USB = -1;
final int BLUETOOTH = -2;
final int LOCATION = 100;
final int CONTACTS = 101;
final int PLACES = 102;
final int WEATHER = 103;
final int ONLINE = 104;
final int WIFI = 105;
final int TIME = 106;
final int EQ = 107;
final int MAIL = 110;
final int THING = 111;
final int DRIVE = 112;
final int TWITTER = 113;
final int NEWS = 114;
final int CALENDAR = 115;
final int SETTINGS = 200;
final int REFRESH = 201;
final int PROFILE = 202;

final int RESULTS = 120;

int channel = -1;
ArrayList<String> pages;
int pageIndex = 0;
int lastPageIndex;
long lastPage;
boolean initPage;
boolean play = true;
boolean direction;

public void setChannel(int thisCommand) {
  if ((thisCommand >= COMPASS && thisCommand <= SNOW) || thisCommand == SLEEP) {
    channel = thisCommand;
    writeString("", thisCommand, 1, 1, 1);
  }

  boolean flag = false;

  switch(thisCommand) {

    case PROFILE:
    channel = thisCommand;
    if (google.loggedin) {
      pages = profile.getPages();
    } else {
      google.login();
    }
    initPage = true;
    flag = true;
    lastPageIndex = - 1;
    break;

    case THING:
    //dweet = !dweet;
    break;

    case PLAY:
    play = !play;
    break;

    case UP:
    if (channel == PLACES) {
      places.search();
      setChannel(RESULTS);
      flag = true;
    }
    break;

    case RIGHT:
    busy = false;
    alpha.busy = false;
    lastPage = 0;
    pageIndex ++;
    direction = true;
    if (pageIndex == pages.size()) pageIndex = 0;
    break;

    case LEFT:
    busy = false;
    alpha.busy = false;
    lastPage = 0;
    pageIndex --;
    direction = false;
    if (pageIndex == -1) pageIndex = pages.size()-1;
    break;

    case SETTINGS:
    debug = !debug;
    break;

    case USB:
    if (!android && !connected) {     
      beginComm();
    }
    break;

    case BLUETOOTH:
    if (android  && !connected) {
      beginComm();
    }
    break;

    case ONLINE:
    updateOnline();
    pages = onlines;
    channel = thisCommand;
    flag = true;
    break;

    case WIFI:
    updateWifi();
    pages = wifis;
    channel = thisCommand;
    flag = true;
    break;

    case RESULTS:
    play = true;
    channel = thisCommand;
    pages = places.results;
    flag = true;
    break;

    case PLACES:
    play = false;
    pages = places.getPages();
    initPage = true;
    channel = thisCommand;
    lastPageIndex = - 1;
    break; 

    case TWITTER:
    pages = twitter.getPages();
    channel = thisCommand;
    flag = true;
    break;

    case NEWS:
    pages = news.getPages();
    channel = thisCommand;
    flag = true;
    break;

    case MAIL:
    pages = mail.getPages();
    channel = thisCommand;
    flag = true;
    break;

    case CALENDAR:
    pages = calendar.getPages();
    channel = thisCommand;
    flag = true;
    break;

    case CONTACTS:
    pages = contacts.getPages();
    channel = thisCommand;
    flag = true;

    break;
    case LOCATION:
    pages = geolocation.getPages();
    channel = thisCommand;
    flag = true;
    break;

    case WEATHER:
    pages = weather.getPages();
    channel = thisCommand;
    flag = true;
    break;

    case DRIVE:
    pages = drive.getPages();
    channel = thisCommand;
    flag = true;
    break;

    case TIME:
    channel = thisCommand;
    flag = true;
    break;

    case EQ:
    writeString("", BLANK, 1, 1, 1);
    break;
  }

  if (flag) {
    initPage = true;
    pageIndex = 0;
    lastPageIndex = - 1;
    lastPage = 0;
  }

  channel = thisCommand;
  gui.refresh = true;
  //busy = false;
}

public void play() {

  if (channel == ONLINE || channel == WIFI || channel == LOCATION || channel == WEATHER || channel == RESULTS ||
    channel == DRIVE || channel == MAIL || channel == TWITTER || channel == NEWS || channel == CONTACTS ||
    channel == UP || channel == DOWN || channel == RIGHT || channel == LEFT || channel == PROFILE || channel == CALENDAR) {

    //if (!busy && abs(ax) > tiltAngle) {
    //  play = false;
    //  if (millis() - lastPage > 500) {
    //    if (ax > 0) {
    //      direction = true;
    //      pageIndex++;
    //      lastPage = 0;
    //      if (pageIndex == pages.size()) pageIndex = 0;
    //    } else {
    //      direction = false;
    //      pageIndex--;
    //      lastPage = 0;
    //      if (pageIndex == -1) pageIndex = pages.size()-1;
    //    }
    //  }
    //}


    if (!busy && pages != null && pages.size() > 0) {
      if (pageIndex != lastPageIndex) {
        if (millis() - lastPage > tuck*100) {
          lastPage = millis();
          busy = true;
          lastPageIndex = pageIndex;
          String stringText = ""; 
          String thisPage = pages.get(pageIndex);
          if (thisPage.indexOf(TAB+"") != -1) {
            String[] items = splitTokens(thisPage, ""+TAB);
            if (items.length > 3) {
              displayMode = parseInt(items[0]);
              tick = parseInt(items[1]);
              tock = parseInt(items[2]);
              tuck = parseInt(items[3]);
              if (items.length > 4) {
                stringText = items[4];
              }
              writeString(stringText, displayMode, tick, tock, tuck);
            }
          } else {
            stringText = thisPage;
            displayMode = TICKER;
            tick = 20;
            tock = 10;
            tuck = 10;
            writeString(stringText, displayMode, tick, tock, tuck);
          }
          if (play) {
            pageIndex ++;
            if (pageIndex == pages.size()) {
              pageIndex = 0;
            }
          }
        }
      }
    }
  }

  if (channel == TIME) {
    if (millis() - lastPage > 1000) {
      lastPage= millis();
      writeString(cleanUp(getStringTime(true)), CENTERED, 1, 1, 1);
    }
  }

  //if (dweet && !busy) {
  //  if (millis() - lastDweet > 1000) { /////////
  //    lastDweet = millis();
  //    getDweet();
  //  }
  //  if (dweeted) {
  //    dweeted = false;
  //    if (latestDweet.content_ != null) {
  //      String[] items = splitTokens(latestDweet.content_, "|");
  //      println("got dweet "+items[1]);
  //      if (items[1].indexOf("CONTACTS") != -1) { /////////// fix dweet from frame (now frameCONTACT
  //        writeString(items[2], SCROLL_PUSH_RIGHT, 10, 1, 20);
  //        lastPage = millis();
  //        //busy = true;
  //      }
  //    }
  //  }
  //}

  if (channel == RESULTS) {
    if (az < -5 && !busy) {
      setChannel(PLACES);
    }
  }

  if (channel == PLACES && !busy) {
    //if (millis() - lastPage > 1000) {
    //  if (play && channel == CONTACTS) {
    //    direction = true;
    //    pageIndex++;
    //    if (pageIndex == pages.size()) pageIndex = 0;
    //  }
    //  //if (abs(ax) > tiltAngle ) {
    //  //  //lastPage = millis();
    //  //  if (ax > 0) {
    //  //    direction = true;
    //  //    pageIndex++;
    //  //    if (pageIndex == pages.size()) pageIndex = 0;
    //  //  } else {
    //  //    direction = false;
    //  //    pageIndex--;
    //  //    if (pageIndex == -1) pageIndex = pages.size()-1;
    //  //  }
    //  //}
    //  if (az > 5) {
    //    //if (channel == PLACES) {
    //    //  searchPlaces();
    //    //  setChannel(RESULTS);
    //    //}
    //  } else if (pageIndex != lastPageIndex) {
    //    if (!busy) {
    //      lastPage = millis();
    //      busy = true;
    //      if (channel == CONTACTS) {  
    //        if (dweet) {        
    //          //sendDweet("CONTACTS", pages.get(pageIndex)+"|"+profileImages.get(pageIndex));
    //        }
    //      }
    //      writeString(cleanUp(pages.get(pageIndex), true), direction ? 
    //        SCROLL_PUSH_RIGHT : SCROLL_PUSH_LEFT, 10, 1, 10);
    //      lastPageIndex = pageIndex;
    //    }
    //  }
    //}
  }

  if (channel == EQ) {
    if (!android) {
      eq.update();
      tuck = 1;
      if (millis() - lastPage > tuck*100) {
        lastPage = millis();
        String str = "";
        for (int i=0; i<CHARS; i++) {
          str += eq.eqData[i];
        }
        writeString(str, STREAM, 1, 1, 1);
      }
    }
  }
}
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
float sens = .5f;
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

public String createString(String thisString, int thisMode, int thisTick, int thisTock, int thisTuck) {
  return thisMode+""+TAB+""+thisTick+""+TAB+""+thisTock+""+TAB+""+thisTuck+""+TAB+""+thisString;
}

public void writeString(String thisString, int thisMode, int tick, int tock, int tuck) {
  // thisString = thisString.toUpperCase();
  if (android) {
    txDelay = PApplet.parseInt(thisString.length()/BLE_PACKET_LENGHT*TX_SPEED*1.2f);
    String str = "";
    str += PApplet.parseChar(thisMode+48);
    str += PApplet.parseChar(tick+48);
    str += PApplet.parseChar(tock+48);
    str += PApplet.parseChar(tuck+48);
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

public void parseBytes(byte[] data) {
  if (data.length == packetLength) {
    mm = data[0];
    ax = data[2]*(data[1] == 1 ? -1 : 1);
    ay = data[4]*(data[3] == 1 ? -1 : 1);
    az = data[6]*(data[5] == 1 ? -1 : 1);
    battery = (data[7]-48)+((data[8]-48)/10.0f)+((data[9]-48)/100.0f);
    if (millis() - lastPage > tuck*100) { ///////////////    fix!!!
      busy = false;
    }
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
    // login();
  }

  public void login() {
    if (authenticating) {
      runFinalizeOAuthChoreo();
      authenticating = false;
    } else if (forcelogin) {
      runInitializeOAuthChoreo();
    } else {
      authenticate();
    }
  }

  public void authenticate() {
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

  Profile () {
  }

  public void update() {
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
  }

  public ArrayList<String> getPages() {
    ArrayList<String> pages = new ArrayList<String>();
    pages.add(createString("Hi "+givenName, TICKER, 20, 1, 20));
    pages.add(createString(id+" "+objectType, TICKER, 20, 1, 20));
    pages.add(createString(email, TICKER, 20, 1, 20));
    pages.add(createString("+"+minAge+" "+"speaks "+language, TICKER, 20, 1, 20));
    return pages;
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

class GoogleDrive {
  ArrayList<String> drives;

  GoogleDrive () {
  }

  public void update() {
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

  public ArrayList<String> getPages() {
    update();
    return drives;
  }

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
    XML contactsXML = null;
    try {
      contactsXML = loadXML((android ? "data\\tmp\\" : "data/tmp/") + "contacts.xml");
    } catch (Exception e) {
      println("error loading contacts.xml");
    }

    if (contactsXML == null && online) {
      println("getting contacts");
      String contactsBuffer = runGetAllContactsChoreo();
      contactsXML = parseXML (contactsBuffer);
      saveXML(contactsXML, (android ?  "data\\tmp\\" : "data/tmp/") + "contacts.xml");  
    }

    if (contactsXML != null) {
      XML[] entries = contactsXML.getChildren("entry");
      for (int i = 0; i < entries.length; i++) {
        Contact contact = new Contact();
        contact.title = entries[i].getChild("title").getContent();
        XML names = entries[i].getChild("gd:name");
        // if (names.getChild("gd:fullName").getContent() !=null && names.getChild("gd:fullName").getContent()!=null) contact.fullName = names.getChild("gd:fullName").getContent();
        // if (names.getChild("gd:givenName").getContent() !=null  && names.getChild("gd:givenName").getContent()!=null) contact.givenName = names.getChild("gd:givenName").getContent();
        // if (names.getChild("gd:familyName") !=null && names.getChild("gd:familyName").getContent()!=null) contact.familyName = names.getChild("gd:familyName").getContent();
        if (entries[i].getChild("gd:email") !=null ) contact.email = entries[i].getChild("gd:email").getString("address").toLowerCase();
        if (entries[i].getChild("gd:phoneNumber") !=null ) contact.phoneNumber = entries[i].getChild("gd:phoneNumber").getContent();
        if (entries[i].getChild("link") != null) {
          if (entries[i].getChild("link").hasAttribute("gd:etag")) {
            contact.url = entries[i].getChild("link").getString("href");
            if (contact.url != null) {
              String url = contact.url+"?access_token="+ACCESS_TOKEN;
              println(url);
              // try {
              //   contact.img = loadLocalImage(contact.email+".png");
              // } catch (Exception e)   {                
              //   downloadByteArrayAsImage(url, contact.email);
              //   contact.img = loadLocalImage(contact.email+".png");
              // }
              contactList.add(contact);
            }
          }
        }
      }
      updated = true;
    }
    println(contactList.size() + " contacts");
  }

  public ArrayList<String> getPages() {
    if (!updated) update();
    ArrayList<String> pages = new ArrayList<String>();
    for (Contact thisContact : contactList) {
      if (thisContact.title != null && thisContact.title != "") {
        pages.add(createString(cleanUp(thisContact.url, true), IMAGE, 1, 1, 5));
        pages.add(cleanUp(thisContact.title, true));
       
      }
    }
    return pages;
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
}

/////////////////////////////////////
// CALENDAR
/////////////////////////////////////


class GoogleCalendar {
  ArrayList<Event> eventsList;
  boolean updated;

  GoogleCalendar () {
    eventsList = new ArrayList<Event>();
  }

  public void update() {
    eventsList = new ArrayList<Event>();
    JSONObject eventsObject = runGetAllEventsChoreo();
    JSONArray itemsArray = eventsObject.getJSONArray("items");
    for (int i = 0; i<itemsArray.size(); i++) {
      JSONObject thisItem = itemsArray.getJSONObject(itemsArray.size()-i-1);
      Event event = new Event();
      event.summary = thisItem.getString("summary");
      eventsList.add(event);
    }  
    updated = true;
    println(eventsList.size()+" events");
  }

  public ArrayList<String> getPages() {
    if (!updated) update();
    ArrayList<String> pages = new ArrayList<String>();
    for (Event thisEvent : eventsList) {
      if (thisEvent.summary != null && thisEvent.summary != "") {
        pages.add(cleanUp(thisEvent.summary, true));
      }
    }
    return pages;
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
  String date;

  Event() {
  }

  public void debug() {
  }
}

int whiteColor = color (255, 255, 255);
int redColor = color(190, 30, 45);
int backgroundColor = 200;
PFont font;//, fontBold, fontMono, fontMonoBold;

PShape outline, outline_mask, app, mask;


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

  public void init() {
    app = loadShape("shp/app.svg");
    app.disableStyle();
    outline = loadShape("shp/ticker.svg");
    outline.disableStyle();
    outline_mask = loadShape("shp/ticker_mask.svg");
    outline_mask.disableStyle();
    mask = loadShape("shp/mask.svg");
    mask.disableStyle();
    font = createFont("Monospaced", 32);

    initPilots();
    packets = new ArrayList<Packet>();
  }

  public void update() {
    pushMatrix();
    scale(width/cW);
    // PILOTS
    checkPilots();
    if (refresh) {
      background(backgroundColor);
    } else {
      if (debug) {
        rectMode(CORNER);
        fill(backgroundColor);
        rect(0, 112, width, 292);
        rect(0, (height/2)+24, width, 292);
      }
    }
    displayPilots();
    // PACKETS
    if (debug) {
      displayPackets();
    }
    popMatrix();
    // OBJECT
    pushMatrix();
    translate(width/2, height/2);
    scale(width/cW);
    translate(0, -48);
    targetRot = radians(ay);
    rot += (targetRot-rot)*.1f;
    if (channel == AXIS) {
      rotate(-rot);
    }
    scale(1.2f);
    if (refresh || debug) {
      strokeWeight(3);
      stroke(0);
      fill(255);
      shape(outline, 0, 0);
      fill(backgroundColor);
      shape(outline_mask, 0, 0);
    } else {
      rectMode(CENTER);
      fill(255);
      noStroke();
      rect(0, 35, 1120, 50);
    }
    alpha.display();
    // DWEETS
    //if (debug) {
      if (messaging != null) {
        messaging.displayDweet(-596, 150);
      }
    //} 
    popMatrix();

    if (android) {
      refresh = false;
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

public void keyPressed() {
  println("key pressed");
  if (key >= 48 && key <= 58) {  
    setChannel(key-48);
  }
  if (key >= 65 && key <= 65+28) {
    setChannel(key-48);
  }
}

public void mousePressed() {
  if (millis()-gui.lastClick > gui.debounce) {
    gui.lastClick = millis();
    gui.clicked = true;
  }
}

public void mouseReleased() {
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

  public void display() {
    loc.x = attract(loc.x, targetLoc.x, .08f, 5);
    loc.y = attract(loc.y, targetLoc.y, .08f, 5);
    loc.z = attract(loc.z, targetLoc.z, .08f, 5);
    noStroke();
    fill(in ? whiteColor : redColor, loc.z);
    ellipseMode(CENTER);
    ellipse(loc.x, loc.y, 15, 15);
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
    long pingStart = millis();
    String thing= "teleobjects";
    String url = "https://thingspace.io/get/latest/dweet/for/"+thing;
    println("getting dweet");
    String[] buffer = loadStrings(url);
    if (buffer != null) {
      latestDweet.parse(buffer[0], true);
      if (!lastCreated.equals(latestDweet.created_)) {
        println(buffer);
        lastCreated = latestDweet.created_;
        pingTime = PApplet.parseInt(millis()-pingStart);

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
    long pingStart = millis();
    String url = "https://dweet.io:443/dweet/quietly/for/"+thing+"?"+"teleobject="+teleobject+"&"+key_+"="+encode(value_);
    String[] buffer = loadUrl(url);
    //println(url);
    if (buffer != null) {
     // latestDweet.parse(buffer[0], false);
     latestDweet.info = value_;
     pingTime = PApplet.parseInt(millis()-pingStart);
     dweetA = 255;
   }
 }

 public void sendDweet(String key_, String value_) {
  long pingStart = millis();
  String url = "https://dweet.io:443/dweet/for/"+thing+"?"+"teleobject="+teleobject+"&"+key_+"="+encode(value_);
  String[] buffer = loadStrings(url);
    //println(url);
    if (buffer != null) {
     latestDweet.parse(buffer[0], false);
     pingTime = PApplet.parseInt(millis()-pingStart);
     dweetA = 255;
   }
 }

 public void displayDweet(float thisX, float thisY) {
  dweetA += (dweetTargetA - dweetA)*.01f;
  if (latestDweet.info != null) {
    pushMatrix();
    translate(thisX, thisY);
    textAlign(LEFT);
    textFont(font, 20);
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
ArrayList<String> onlines;
ArrayList<String> wifis;

 
 

String hostName; 
String hostIP; 
String externalIP;

String pingUrl = "http://www.google.com";
String ipFinderUrl = "https://api.ipify.org";
int pingTime;

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

public String[] loadLocal(String thisFile) {
  String[] result = loadStrings((android ? "data\\tmp\\" : "data/tmp/") +thisFile);
  println("loaded "+thisFile);
  return result;
}

public void saveLocal(String thisFile, String[] thisContent) {
  saveStrings((android ? "data\\tmp\\" : "data/tmp/") +thisFile, thisContent);
  println("saved "+thisFile);
}

public void saveLocal(String thisFile, PImage img) {
  if (img != null) {
    PImage tmp = createImage(img.width, img.height, RGB);
    tmp = img.get();
    if (android) {
      tmp.save(savePath(sketchPath("data\\tmp\\"+thisFile)));
    } else {
      tmp.save(savePath(sketchPath("data/tmp/"+thisFile)));
    }
  }
  println("saved "+thisFile);
}


public PImage loadLocalImage(String thisFile) {
  if (debug) { 
    Packet newPacket = new Packet(false, "", getPilot("online").x);
  }
  PImage img = loadImage((android ? "data\\tmp\\" : "data/tmp/")+thisFile);
  println("loaded "+thisFile);
  return img;
}

public String[] loadUrl(String thisUrl) {
  loading = true;
  //writeString("", LOADING, 1, 1, 1);
  if (debug) { 
    Packet newPacket = new Packet(false, "", getPilot("online").x);
  }
  println("loading "+thisUrl);  
  long pingStart = millis();
  if (wifi && online) {
    try { 
      String[] content = loadStrings(thisUrl);
      if (content != null) {
        pingTime = PApplet.parseInt(millis() - pingStart);
        //online = true;
        println("loaded url "+pingTime+"ms");
        if (debug) {
          Packet newPacket = new Packet(true, "", getPilot("online").x);
        }
        return content;
      }
    } 
    catch (Exception e) {
      println(e);
      onlines.add("error, exception");
    }
  }
  println("error, offline");
  return null;
}

public void updateOnline() {
  onlines = new ArrayList<String>();
  long pingStart = millis();
  // println(ipFinderUrl);
  // onlineState ="online";
  // online = true;
  
  try { 
    String[] ip = loadStrings(ipFinderUrl);
    if (ip != null) {
      pingTime = PApplet.parseInt(millis() - pingStart);
      externalIP = ip[0];
      onlines.add(cleanUp("IP "+ip[0]+" PING "+pingTime+"ms"));
      onlineState ="online";
      online = true;
    } else {
      onlines.add("CAN'T CONNECT TO WWW");
      onlineState ="offline";
      online = false;
    }
  } 
  catch (Exception e) {
    println(e);
    online = false;
    onlines.add("EXCEPTION THROWN");
    onlineState ="offline";
  }
}

public void initWifi() {
  updateWifi();
}

public void updateWifi() {
  wifis = new ArrayList<String>();
  try { 
    InetAddress addr = InetAddress.getLocalHost(); 
    byte[] ipAddr = addr.getAddress(); 
    String raw_addr = addr.toString(); 
    String[] list = split(raw_addr, '/'); 
    hostIP = list[1]; 
    if (hostIP.indexOf(":") != -1) {
      hostName = addr.getHostName();
      hostIP = "OFFLINE";
      wifis.add(cleanUp(hostName+" IS OFFLINE", true));
      wifiState = "wifi disabled";
      wifi = false;
    } else {
      hostName = addr.getHostName();
      wifis.add(cleanUp(hostName+"@"+hostIP, true));
      wifiState = "wifi enabled";
      wifi = true;
    }
  } 
  catch (UnknownHostException e) {
    println(e);
  }
}










Serial port;

public void initComm() {
  beginComm();
  updateWifi();
  if (!forceoffline) {
    updateOnline();
  } else {
    online = false;
    onlineState = "offline";
  }
}

public void beginComm() {
  usb = true;
  for (int i=0; i<Serial.list().length; i++) {
    if (Serial.list()[i].indexOf(usb ? "usbmodem" : "teleobject") != -1) {
      portName = Serial.list()[i];   
      println("connecting to "+portName);
      try {
        port = new Serial(this, portName, 115200);
        connecting = true;
        connected = true;
        println("connected to "+portName);
        break;
      } 
      catch (Exception e) {
        println("could not connect to "+portName);
      }
    }
  }
}

public void updateComm() {
  if (connected) {
    rx();
  }
}

public void terminateComm() {
  port = null;
  connected = false;
}

public void tx(byte[] data) {
  if (connected) {
    txR = PApplet.parseInt(millis() - lastTx);
    lastTx = millis();
    port.write(data);
    if (debug) {
     Packet newPacket = new Packet(false, "", getPilot(usb ? "usb" : "bluetooth").x);
   }
 }
}

public void rx() {
  if (connected) {
    if (port.available() > 13  ) {
      byte[] data = port.readBytesUntil(254);
      rxR = PApplet.parseInt(millis() - lastRx);
      lastRx = millis();
      if (data != null) {
        parseBytes(data);
        if (debug) {
          Packet newPacket = new Packet(true, "", getPilot(usb ? "usb" : "bluetooth").x);
        }
      }
    }
  }
}

/////////////////
// PLACE HOLDERS
/////////////////

public void downloadByteArrayAsImage(String url, String fileName) {
  byte[] imageInByte = loadBytes(url);
  InputStream in = new ByteArrayInputStream(imageInByte);  
  try {
    BufferedImage bImageFromConvert = ImageIO.read(in);
    ImageIO.write(bImageFromConvert, "png", new File(
      sketchPath("data/tmp/"+fileName+".png")));
    println("downloaded byte array "+fileName);
  } 
  catch(Exception e) {
    println("error");
  }
}

int location = -1;// = null;

public void tx(String str) {
}

public void connectBluetooth() {
}

public void updateBluetooth() {
}


/////////////////
// MIC
/////////////////



class Eq {
 Minim minim;
 AudioInput in;

 char[] eqData;
 float[]eqVal;
 int res= 32;

 float maxL = .03f;
 float midL = .01f;
 float minL = midL/2;

 float rightL;
 float leftL;
 float eqFilter = .2f;

 Eq (PApplet parent) {
   minim = new Minim(parent);
   in = minim.getLineIn(minim.STEREO, res);
   eqData = new char[res];
   eqVal = new float[res];
 }

 boolean softEq = false;

 public void update()
 {
   rightL = in.right.level();
   leftL = in.left.level();
   if (channel == EQ ) {
     // pushMatrix();
     // stroke(redColor);
     // strokeWeight(2);
     // translate(0, height);
     // pushMatrix();
     // scale(width/res, 1);
     float offset = 100;
     // popMatrix();
     float eqWidth = width*1.0f/(res-1);
     for (int i = 0; i < in.bufferSize(); i++) {
       float targetLevel =  abs(in.left.get(i));
       eqVal[i] = eqVal[i]+(targetLevel-eqVal[i])*eqFilter;
       if ( eqVal[i] > maxL) {
         eqData[i] =EQ_HIGH;
       } else if ( eqVal[i] > midL &&  eqVal[i] < maxL) {
         eqData[i] =EQ_MID;
       } else if ( eqVal[i] >  minL &&  eqVal[i] < midL) {
         eqData[i] =EQ_LOW;
       } else {
         eqData[i] =EQ_OFF;
       }
       // line(0, -offset + in.left.get(i)*offset, eqWidth, -offset + in.left.get(i)*offset);
       // translate(eqWidth, 0);
     }
     // popMatrix();
   }
 }
}
//    if ( in.isMonitoring() )
//    {
//      in.disableMonitoring();
//    }
//    else
//    {
//      in.enableMonitoring();
//    }
ArrayList<Pilot> pilots; 

public void initPilots() {
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
    thisPilot.y = (height-70)/(width/gui.cW);
    pilots.add(thisPilot);
  }

  pilotTable = loadTable("csv/pilotsControl.csv", "header, csv");
  for (int i=0; i<pilotTable.getRowCount(); i++ ) {
    TableRow row = pilotTable.getRow(i);
    Pilot thisPilot = new Pilot(row.getString("name"), row.getString("shape"), row.getInt("command"));
    thisPilot.x = -8 + (width/2) - (130*5/2) + (130*i);
    thisPilot.y = (height-200)/(width/gui.cW);
    pilots.add(thisPilot);
  }
}

public void displayPilots() {
  String currentChannelName = "null";

  Pilot currentPilot = getPilotByCommand(channel);
  if (currentPilot != null) currentChannelName = currentPilot.name.toUpperCase();
  setPilot("play", play);
  // setPilot("refresh", refresh);
  setPilot("profile", google.loggedin);
  setPilot("settings", debug);
  setPilot("compass", channel==COMPASS);
  setPilot("contacts", channel==CONTACTS);
  setPilot("twitter", channel==TWITTER);
  setPilot("mail", channel==MAIL);
  setPilot("news", channel==NEWS);
  setPilot("drive", channel==DRIVE);
  //setPilot("things", dweet);
  setPilot("eq", channel==EQ);
  setPilot("time", channel==TIME);
  setPilot("axis", channel==AXIS);
  setPilot("sleep", channel==SLEEP);
  setPilot("places", channel==PLACES);
  setPilot("location", channel==LOCATION);
  setPilot("battery", channel==BATTERY);
  setPilot("weather", channel==WEATHER);
  setPilot("online", online);
  setPilot("wifi", wifi); 
  setPilot("twitter", twitter.name+"\n@"+twitter.screenName+"\n"+twitter.userID+"\n"+twitter.followers.size()+" followers\n"+twitter.friends.size()+" friends\n"+twitter.trends.size()+" trending topics");
  if (twitter.img != null) setPilot("twitter", twitter.img);
  setPilot("calendar", calendar.eventsList.size()+" events");

  setPilot("contacts", contacts.contactList.size()+" contacts");
  if (profile != null) {
    setPilot("profile", profile.givenName+" "+ profile.familyName+"\n"+profile.email+"\n"+profile.id+"\n"+profile.kind+"\n"+profile.minAge+"\n"+profile.language);
  }
  if (profile.img != null) setPilot("profile", profile.img);
  setPilot("sleep", (busy ? "busy" : "free")+"\n"+(int)frameRate+" fps\n"+width+"x"+height+"px\n"+currentChannelName+"\n"+(time.currentTimeStamp-time.startTimeStamp)/1000+"s");
  setPilot("weather", weather.conditionMain+"\n"+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + (metric ? "\u00b0C" : PApplet.parseChar(29)+"\u00b0F")+"\n"+PApplet.parseInt(weather.humidity)+"% humidity"+"\n"+
    weather.pressure+"mPa \n"+weather.clouds+"% clouds\n"+weather.windSpeed+"m/h \n"+getHeading(weather.windDeg)+" "+(int)weather.windDeg+"\u00b0\n"+(time.currentTimeStamp-weather.lastUpdated)/1000+"s");
  setPilot("online", onlineState + "\n" + (online ? externalIP+"\n"+pingTime+"ms" : ""));
  setPilot("wifi", wifiState+"\n"+hostIP+"\n"+hostName);
  if (connected) {
    setPilot(usb ? "usb" : "bluetooth", portName+"\nTX "+nf(millis()-lastTx, 4, 0)+"ms\nRX "+nf(millis()-lastRx, 4, 0)+"ms\n"+busy+"\n");
  }
  setPilot("battery", nf(battery, 1, 2)+"v");
  setPilot("time", getStringTime(true)+"\n");
  setPilot("location", getCoordinate(geolocation.latitude, true)+"\n"+getCoordinate(geolocation.longitude, false)+"\n"+geolocation.provider+"\n"+geolocation.houseNumber+" "+geolocation.street+"\n"+geolocation.neighbourhood+"\n"+(time.currentTimeStamp-geolocation.lastUpdated)/1000+"s");
  setPilot("usb", usb && connected);
  setPilot("bluetooth", bluetooth &  connected);
  setPilotRotation("bluetooth", connecting);
  setPilot("axis", "X "+(ax>=0?"+":"")+PApplet.parseInt(ax)+"\n"+"Y "+(ay>=0?"+":"")+PApplet.parseInt(ay)+"\n"+"Z "+(az>=0?"+":"")+PApplet.parseInt(az));
  setPilot("eq", "R "+nf((int)(eq.rightL*1000), 3, 0)+"\nL "+nf((int)(eq.leftL*1000), 3, 0));

  // if (channel == CONTACTS && profile.img != null) {
  //   pushMatrix();
  //   translate(getPilot("contacts").x, getPilot("contacts").y-100);
  //   pushMatrix();
  //   scale(.822);
  //   scale(96.0/ profile.img.height*1.0);
  //   image( profile.img, 0, 0);
  //   popMatrix();
  //   fill(backgroundColor);
  //   noStroke();
  //   scale(.7);
  //   shape(mask, 0, 0);
  //   popMatrix();
  // }
  // if (channel == NEWS && articleImage != null) {
  //   pushMatrix();
  //   translate(getPilot("news").x, getPilot("news").y-100);
  //   pushMatrix();
  //   scale(articleImage.width/mask.width*.765);
  //   image(articleImage, 0, 0);
  //   popMatrix();
  //   fill(backgroundColor);
  //   noStroke();
  //   scale(.7);
  //   shape(mask, 0, 0);
  //   popMatrix();
  // }
  //  if (logged && profileImage != null) {
  //    pushMatrix();
  //    translate(getPilot("account").x, getPilot("account").y);
  //    pushMatrix();
  //    scale(profileImage.width/mask.width*.48);
  //    image(profileImage, 0, 0);
  //    popMatrix();
  //    fill(255, 0, 0, 50);
  //    noStroke();
  //    scale(.7);
  //    shape(mask, 0, 0);
  //    //scale(.7);
  //    //shape(mask, 0, 0);
  //    popMatrix();
  //  }

  for (Pilot thisPilot : pilots) {
    thisPilot.display();
  }
}

public void checkPilots() {
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
  float x, y, s = .7f;
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

  public void display() {
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
        scale(112.0f/img.width*1.0f);
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
    if (label!=null && debug) { 
      fill(50);
      textAlign(CENTER);
      int fontSize = android ? 20 : 16;
      int lineHieght = android ? 26 : 24;
      textFont(font, fontSize);
      int offsetY =  y < height/2 ? 84 : (-90 - (countChar(label, '\n')*lineHieght));
      text(label, 0, offsetY);
    }
    popMatrix();
  }

  public void check() {
    sx = screenX (x, y);
    sy = screenY (x, y);
    if (gui.clicked && dist(sx, sy, mouseX, mouseY) < 50) {
      setChannel(command);
      gui.clicked = false;
    }
  }
}

public void setPilotRotation(String thisPilot, boolean thisRotation) {
  for (Pilot pilot : pilots) {
    if (pilot.name.equals(thisPilot)) {
      pilot.rotating = thisRotation;
      break;
    }
  }
}

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
/////////////////////////////////////
// MAIL
/////////////////////////////////////

class Mail {
  ArrayList<String> mails;
  int mailIndex;
  boolean updated;
  long lastUpdated;

  Mail() {
  }

  public void update() {
    mails = new ArrayList<String>();
    String[] mailBuffer = loadUrl("http://teleobjects.com/api/proxy.php?mail=true");
    for (int i=0; i<mailBuffer.length; i++) {
      int currentMail = mailBuffer.length - i - 1;
      if (mailBuffer[currentMail].indexOf("=?") == - 1) {
        String[] items = splitTokens (mailBuffer[currentMail], "\t");
        if (items.length>0) {
          String name =  items[0];
          if (name.indexOf("<") != -1) {
            name = name.substring(0, name.indexOf("<"));
          }
          name = removeQuotes(name);
          mails.add(createString(" ", INSTANT, 1, 1, 1));
          mails.add(createString(cleanUp(name, true), SCROLL_PUSH_RIGHT, 10, 1, 15));
          mails.add(createString(" ", INSTANT, 1, 1, 1));
          if (items.length>1) {
            String date = items[1].substring(0, 11);
            mails.add(createString(cleanUp(date, true), CENTERED, 1, 1, 15));
            // mails.add(createString(" ", INSTANT, 1, 1, 1));
          }
          if (items.length > 2) {
            String subject =  cleanUp(items[2].toUpperCase());
            mails.add(createString(subject, SCROLL_ALL_RIGHT, 100, 1, 20));
          }
        }
      }
    }
    if (mails.size() == 0) {
      mails.add("No unread emails");
    }
    updated = true;
    lastUpdated = time.currentTimeStamp;
  }

  public ArrayList<String> getPages() {
    if (!updated) update();

    return mails;
  }
}

/////////////////////////////////////
// PLACES
/////////////////////////////////////

class Places {
  ArrayList<String> places, results;
  int placeTypeIndex;
  
  boolean placed;

  Places () {
    init();
  }

  public void init() {
    places = new ArrayList<String>();
    String[] placeTypes = loadStrings("csv/place_types_short.csv");
    for (int i=0; i<placeTypes.length; i++) {
      places.add((placeTypes[i]));
    }
  }

  public ArrayList<String> getPages() {
    return places;
  }

  public void search() {
    String types = places.get(pageIndex).toLowerCase();
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
        results.add(cleanUp("FOUND "+numberOfPlaces+" "+types+"S", true));

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
            results.add(cleanUp(placeResult.getString("name")+" IS OPEN", true));
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
  // int articleIndex;

  News() {
  }

  public void update() {
    articles = new ArrayList<Article>();
    // articleIndex = 0;

    String newsUrl = "http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/1.json?api-key="+encode(newsKey);
    String[] newsResponse = loadUrl(newsUrl);
    if (newsResponse.length>0) {
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
        articles.add(article);   
      }
    }
  }

  public ArrayList<String> getPages() {
    update();
    ArrayList<String> pages = new ArrayList<String>();
    if (articles.size() == 0) {
      pages.add("CAN'T CONNECT TO NY TIMES");
      return pages;
    }
    pages.add(createString("LATEST FROM NY TIMES", SCROLL_PUSH_RIGHT, 10, 1, 20));
    pages.add(createString(" ", SCROLL_PUSH_RIGHT, 10, 1, 10));
    for (Article article : articles) {

      if (article.keywords.size() > 0) {
        pages.add(createString(article.imageUrl, IMAGE, 1, 1, 10));
        for (String keyword : article.keywords) {
          pages.add(createString(keyword, CENTERED, 1, 1, 10));
        }
        // pages.add(createString("", BLANK, 1, 1, 1));
        pages.add(createString(cleanUp(article.title, true), TICKER, 2, 10, 30));
        pages.add(createString(cleanUp(article.content, true), TICKER, 2, 10, 50));
        // pages.add(createString("", BLANK, 1, 1, 1));
      }
    }
    return pages;
  }
}

class Article {
  String title;
  String content;
  ArrayList<String> keywords;
  String imageUrl;

  Article() {
    keywords = new ArrayList();
  }

  public void display() {
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
    return cleanUp(removeSpaces(str), true);
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

  public void init() {
    if (hardLocation) {
      latitude = 40.7352735f;
      longitude = -73.95551f;
      provider = "fixed";
      located = true;
    } else {
      String url = "http://www.geoplugin.net/json.gp?ip="+externalIP;
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

  public void update() {
    if (located && !updated && online) {
      String url = "http://nominatim.openstreetmap.org/reverse?lat="+latitude+"&lon="+longitude+"&format=json";
      String[] geolocationContent = loadUrl(url);
      if (geolocationContent != null) {
        saveLocal("location.json", geolocationContent);
        String jsonFragment = geolocationContent[0];
        if (!jsonFragment.contains("error")) {
          processing.data.JSONObject geolocatedData = processing.data.JSONObject.parse(jsonFragment);
          processing.data.JSONObject address = geolocatedData.getJSONObject("address");
          country = address.getString("country");
          countryCode = address.getString("country_code");
          state = address.getString("state");
          county = address.getString("county");
          city = address.getString("city");
          if (!address.isNull("suburb")) suburb = address.getString("suburb");
          if (!address.isNull("house_number")) neighbourhood =  address.getString("neighbourhood");
          if (!address.isNull("road")) street = address.getString("road");
          if (!address.isNull("house_number")) houseNumber = address.getString("house_number");
          if (!address.isNull("building")) building = address.getString("building");
          if (!address.isNull("postcode")) postCode = address.getString("postcode");
          updated = true;
          lastUpdated = time.currentTimeStamp;
        }
      }
    }
  }

  public ArrayList<String> getPages() {
    ArrayList<String> pages = new ArrayList<String>();
    if (!updated) {
      pages.add("We're lost...");
    } else {
      pages.add(cleanUp(getCoordinate(latitude, true)+" "+getCoordinate(longitude, false), true));
      pages.add(cleanUp(houseNumber+" "+street, true));
      pages.add(cleanUp(neighbourhood+" "+postCode, true));
      pages.add(cleanUp(city+", "+state, true));
    }
    return pages;
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
    month = cal.get(Calendar.MONTH);
    monthStr = monthNames[month];
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
  boolean updated;
  long lastUpdated;
  int weatherRefresh = 300; 

  float windSpeed, windDeg, windGust, rain, clouds;
  String condition, conditionMain;
  float  temp, pressure, humidity;

  Weather() {
  }

  public void update() {
    if (!updated && geolocation.updated) {
      String[] weatherContent = null;

      // weatherContent = loadLocal("weather.json");

      if (weatherContent == null && online) {
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

  public ArrayList<String> getPages() {
    if (!updated) update();
    pages = new ArrayList<String>();
    if (!updated) {
      pages.add(cleanUp("No weather info..."));
    } else {
      pages.add(createString(cleanUp(condition+" in "+geolocation.neighbourhood, true), TICKER, 10, 1, 20));
      pages.add(createString("", BLANK, 10, 1, 1));
      pages.add(createString(cleanUp("IT'S "+nf(metric ? getCelcius(temp) : temp, 0, 1) + (metric ? PApplet.parseChar(DEGREE)+"c" : PApplet.parseChar(29)+"f"), false), CENTERED, 1, 1, 10));
      pages.add(createString(cleanUp(PApplet.parseInt(humidity)+"% HUMID", true), CENTERED, 1, 1, 10));
      pages.add(createString(cleanUp("PRESSURE "+PApplet.parseInt(pressure)+"mPa", false), CENTERED, 1, 1, 10));
      pages.add(createString(cleanUp(PApplet.parseInt(clouds)+"% CLOUDY", true), CENTERED, 10, 1, 10));
      pages.add(createString(cleanUp("WIND "+PApplet.parseInt(windSpeed) +"m/h "+(int)windDeg+PApplet.parseChar(DEGREE)+" "+getHeading(windDeg), false), CENTERED, 1, 1, 10));
      pages.add(createString("", SCROLL_PUSH_RIGHT, 10, 1, 20));
    }
    return pages;
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

  PImage img;
  boolean loggedin, authenticating, profiled;
  ArrayList<String> trends, pages, followers, friends;

  Twitter () {
    //login(); 
    trends = new ArrayList<String>();   
    pages = new ArrayList<String>();
    followers = new ArrayList<String>();
    friends = new ArrayList<String>();
  }  

  public ArrayList<String> getPages() {
    if (!loggedin) {
      login();
      return null;
    }
    pages = new ArrayList<String>();
    pages.add("@"+screenName);
    if (description != null) pages.add(description);
    if (location != null) pages.add(location);
    pages.add(lastUpdated);
    pages.add(status);
    getFollowers();
    pages.add(createString(followers.size()+" FOLLOWERS", SCROLL_PUSH_RIGHT, 10, 1, 20));
    pages.add(createString("", SCROLL_PUSH_RIGHT, 10, 1, 20));

    for (String follower : followers) {
      pages.add(createString("@"+follower, CENTERED, 0, 1, 8));
    }
    getFriends();
    pages.add(createString(friends.size()+" FRIENDS", SCROLL_PUSH_RIGHT, 10, 1, 20));
    pages.add(createString("", SCROLL_PUSH_RIGHT, 10, 1, 20));

    for (String friend : friends) {
      pages.add(createString("@"+friend, CENTERED, 0, 1, 8));
    }
    getTrendingTopics();
    pages.add(createString("TRENDING IN NYC", SCROLL_PUSH_RIGHT, 10, 1, 20));
    pages.add(createString("", SCROLL_PUSH_RIGHT, 10, 1, 20));

    for (String trend : trends) {
      pages.add(createString(trend, CENTERED, 0, 1, 8));
    }
    return pages;
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
    for (int i = 0; i<trendsArray.size(); i++) {
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
      // println(show.toString());
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
          img = loadImage (mediaUrl);   ////////////  this is only if there is media in the latest status!!!
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
public String concatenate(String[] content) {
  String result="";
  for(int i=0; i<content.length;i++){
    result += content[i];
  }
  return result;
}

public int countChar(String str, char c){
  if (str.length() == 0 || str == null) return 0;
  int count = 0;
  for (int i=0; i<str.length(); i++) {
    if(str.charAt(i) == c) count ++;
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

public String removeBrackets(String str) {
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
  } catch (Exception e) {

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
  return (degrees+""+ DEGREE + nf(minutes, 2, 0) + SINGLE_QUOTE + nf(seconds, 2, 0) + DOUBLE_QUOTE +""+hemisphere);
}

public float getCelcius(float temp) {
  temp -= 32;
  temp /= 1.8f;
  return temp;
}

public String getStringTime(boolean am_pm) {
  String result = "";

  if (am_pm) {
    String hour_ = nf(hour()%12, 2, 0);
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


public float attract(float val, float target, float ratio, float snap) {
  float result =  val + ((target-val)*ratio);
  if (abs(result-target) < snap) result = target;
  return result;
} 
  public void settings() {  size(1600, 900); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "tele_ticker_java" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
