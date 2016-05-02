import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import ddf.minim.*; 
import java.net.InetAddress; 
import java.net.UnknownHostException; 
import processing.serial.*; 
import java.text.SimpleDateFormat; 
import java.util.Date; 
import java.util.Calendar; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class tele_ticker_java extends PApplet {

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

final int SETTINGS = 200;
final int REFRESH = 201;

final int RESULTS = 120;

boolean dweet, usb, bluetooth, wifi, paired, connecting, connected, ready, online, located, found, forecasted, placed, loggedin, loading, metric = true;
boolean refresh = true;
boolean play = true;
boolean direction;

int channel = -1;

PImage profileImage = null;

ArrayList<String> pages;
int pageIndex = 0;
int lastPageIndex;
long lastPage;
boolean initPage;

boolean debug = false;
boolean verbose = true;
boolean android = false;


public void setup() {
  

  if (android) {
    //fullScreen();
    orientation(LANDSCAPE);
  }
  rectMode(CENTER);
  imageMode(CENTER);
  //smooth();
  //frameRate(24);
  initTime();
  initComm();
  initGui();
  initPilots();
  initDisplay();
  initWifi();
  //initOnline();
  initThing();
  initLocation();
  initPlaces();
  initContacts();
  //initMail();
  //initTwitter();
  //initNews();
  initMic();
  writeString("", TICKER, 1, 1, 1);
  pages = new ArrayList();
  pages.add("");
}

public void setChannel(int thisCommand) {
  println(thisCommand);

  if ((thisCommand >= BATTERY && thisCommand <= SNOW) || thisCommand == SLEEP) {
    channel = thisCommand;
    writeString("", thisCommand, 1, 1, 1);
  }

  boolean flag = false;

  switch(thisCommand) {
  case RESULTS:
    play = true;
    channel = thisCommand;
    pages = results;
    flag = true;
    break;

  case PLACES:
    play = false;
    pages = places;
    initPage = true;
    channel = thisCommand;
    lastPageIndex = - 1;
    break; 

  case UP:
    if (channel == PLACES) {
      searchPlaces();
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

  case REFRESH:
    refresh = !refresh;
    break;

  case USB:
    if (!android) {
      if (!connected) {
        usb = true;
        beginComm();
      } else {
        // terminateComm();
      }
    }
    break;

  case BLUETOOTH:
    if (android  && !connected) {
      beginComm();
    }
    if (!android) {
      if (!connected) {
        bluetooth = true;
        beginComm();
      } else {
        // terminateComm();
      }
    }
    break;

  case TWITTER:
    // updateTwitter();
    // pages = tweets;
    // channel = thisCommand;
    // flag = true;
    break;

  case NEWS:
    updateNews();
    pages = news;
    channel = thisCommand;
    flag = true;
    break;

  case THING:
    dweet = !dweet;
    break;

  case PLAY:
    play = !play;
    break;

  case MAIL:
    updateMail();
    pages = mails;
    channel = thisCommand;
    flag = true;
    break;

  case CONTACTS:
    play = false;
    pages = contacts;
    channel = thisCommand;
    flag = true;

    break;
  case LOCATION:
    updateLocation();
    pages = locations;
    channel = thisCommand;
    flag = true;
    break;

  case WEATHER:
    updateWeather();
    pages = weathers;
    channel = thisCommand;
    flag = true;
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

  case DRIVE:
    updateDrive();
    pages = drives;
    channel = thisCommand;
    flag = true;

    break;

  case TIME:
    channel = thisCommand;
    flag = true;

    break;

  case EQ:
    channel = thisCommand;
    break;
  }

  if (flag) {
    initPage = true;
    pageIndex = 0;
    lastPageIndex = - 1;
    lastPage = 0;
  }


  refresh = true;
  busy = false;
}

public void draw() {

  if (!connected) busy = alpha.busy; /// simulator

  displayGui();

  if (refresh == true) {
    refresh = false;
  }

  if (android) {
    // if (location == null) {
    //   location = new KetaiLocation(this);
    //   location. setUpdateRate(1000, 1);
    // } 
  }

  /// CONNECTIONS
  if (android) {
    if (connecting) {
      updateComm();
    }
    if (!paired) {
      connected = false;
    }
  } else {
    if (connecting && millis() - startTime > 1000) {
      connected = true;
    }
    if (connected) {
      rx();
    }
  }

  if (connected && connecting) {
    connecting = false;
    writeString("", INSTANT, 1, 1, 1);
    writeString(cleanUp("What's up...?", true), TICKER, 50, 1, 1);
    busy = true;
    refresh = true;
  }


  if (channel == ONLINE || channel == WIFI || channel == LOCATION || channel == WEATHER || channel == RESULTS ||
    channel == DRIVE || channel == MAIL || channel == TWITTER || channel == NEWS ||
    channel == UP || channel == DOWN || channel == RIGHT || channel == LEFT) {

    if (!busy && abs(ax) > tiltAngle) {
      play = false;
      if (millis() - lastPage > 500) {
        if (ax > 0) {
          direction = true;
          pageIndex++;
          lastPage = 0;
          if (pageIndex == pages.size()) pageIndex = 0;
        } else {
          direction = false;
          pageIndex--;
          lastPage = 0;
          if (pageIndex == -1) pageIndex = pages.size()-1;
        }
      }
    }

    if (pageIndex != lastPageIndex) {
      if (!busy) {
        if (millis() - lastPage > tuck*100) {
          lastPage = millis();
          busy = true;
          lastPageIndex = pageIndex;
          String stringText = ""; 
          String thisPage = pages.get(pageIndex);
          if (thisPage.indexOf(TAB+"") != -1) {
            String[] items = splitTokens(thisPage, ""+TAB);
            displayMode = parseInt(items[0]);
            tick = parseInt(items[1]);
            tock = parseInt(items[2]);
            tuck = parseInt(items[3]);
            if (items.length > 4) {
              stringText = items[4];
            }
          } else {
            stringText = thisPage;
            displayMode = TICKER;
            tick = 20;
            tock = 10;
            tuck = 10;
          }
          writeString(stringText, displayMode, tick, tock, tuck);
          if (play) {
            //println("play");
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

  if (dweet && !busy) {
    if (millis() - lastDweet > 1000) { /////////
      lastDweet = millis();
      getDweet();
    }
    if (dweeted) {
      dweeted = false;
      if (latestDweet.content_ != null) {
        String[] items = splitTokens(latestDweet.content_, "|");
        println("got dweet "+items[1]);
        if (items[1].indexOf("CONTACTS") != -1) { /////////// fix dweet from frame (now frameCONTACT
          writeString(items[2], SCROLL_PUSH_RIGHT, 10, 1, 20);
          lastPage = millis();
          //busy = true;
        }
      }
    }
  }

  if (channel == RESULTS) {
    if (az < -5 && !busy) {
      setChannel(PLACES);
    }
  }


  if (channel == PLACES || channel == CONTACTS && !busy) {
    if (millis() - lastPage > 1000) {

      if (play && channel == CONTACTS) {
        direction = true;
        pageIndex++;
        if (pageIndex == pages.size()) pageIndex = 0;
      }

      if (abs(ax) > tiltAngle ) {
        //lastPage = millis();
        if (ax > 0) {
          direction = true;
          pageIndex++;
          if (pageIndex == pages.size()) pageIndex = 0;
        } else {
          direction = false;
          pageIndex--;
          if (pageIndex == -1) pageIndex = pages.size()-1;
        }
      }

      if (az > 5) {
        if (channel == PLACES) {
          searchPlaces();
          setChannel(RESULTS);
        }
      } else if (pageIndex != lastPageIndex) {
        if (!busy) {
          lastPage = millis();
          busy = true;
          if (channel == CONTACTS) {  
            if (dweet) {        
              sendDweet("CONTACTS", pages.get(pageIndex)+"|"+profileImages.get(pageIndex));
            }
          }

          writeString(cleanUp(pages.get(pageIndex), true), direction ? 
            SCROLL_PUSH_RIGHT : SCROLL_PUSH_LEFT, 10, 1, 10);
          lastPageIndex = pageIndex;
        }
      }
    }
  }

  if (channel == EQ) {

    if (!android) {
      updateMic();

      tuck = 1;
      if (millis() - lastPage > tuck*100) {
        lastPage = millis();
        String str = "";
        for (int i=0; i<CHARS; i++) {
          str += eq[i];
        }
        writeString(str, STREAM, 1, 1, 1);
      }
    }
  }
}
final int CHARS = 32;

char DEC_POINT = 47;
char DEGREE = '\u00b0';
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

final int BATTERY = 17;
final int AXIS = 18;
final int ALPHABET = 19;
final int EXTRA = 20;
final int STREAM = 21;
final int BALL = 22;
final int RAIN = 23;
final int SNOW = 24;

final int DWEET_TX = 100;

Alpha alpha;

public void initDisplay() {
  alpha = new Alpha();
}

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
      if (millis() > lastTick + tick*1.09f) {
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
      if (millis() - lastTick > tick*1.09f) {
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
    for (int i=0; i< CHARS; i++) {
      char current = dis[i];
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
    switch (mode) {
      case DWEET_TX:
      println ("dweet tx "+thisString);
      String[] items = splitTokens(thisString, "|");
      
      if (dweet) {
        sendDweet(items[0], thisString.substring(thisString.indexOf("|"), thisString.length()));
      }

      // clearDisplay();
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
      // if (data.length()>1) {
      //   while(data.charAt(data.length()-1) == ' ') data = data.substring(0,data.length()-2);
      // }
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



String invalid  = "_\u00e2\u0080\u0099\u00e1\u00e4\u00c1\u00c2\u00c4\u00e9\u00ea\u00eb\u00c9\u00ca\u00cb\u00ed\u00ee\u00ef\u00cd\u00ce\u00cf\u00f3\u00f4\u00f6\u00d3\u00d4\u00d6\u00fa\u00fb\u00fc\u00da\u00db\u00dc\u00f1\u00d1"+PApplet.parseChar(8217);
String subs    =  " aaaAAAeeeEEEiiiIIIoooOOOuuuUUUnN'";
String valid = " !@#$%^&*()-+=[]}{;':<>,.?/01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"+DEGREE+DOUBLE_QUOTE+SINGLE_QUOTE;

public String cleanUp(String str, boolean capitalize) {
  String tmp = cleanUp(str);
  if (capitalize) tmp = tmp.toUpperCase();
  return tmp;
}

public String cleanUp(String str) {
  String res = "";
  for (int i=0; i<str.length(); i++) {
    char ch = str.charAt(i);
    if (invalid.indexOf(ch) != -1) {
      if (invalid.indexOf(ch) < subs.length()) {
        ch = subs.charAt(invalid.indexOf(ch));
      }
    }
    if (valid.indexOf(ch) != -1) {
      res +=  ch;
    } else {
      res += '-';
      // println(char(ch)+" code: "+(int)ch+" not valid");
    }
  }
  return res;
}
/*

import ketai.sensors.*; 
KetaiLocation location;

import ketai.net.bluetooth.*;
import ketai.net.*;

import android.content.Intent;
import android.os.Bundle;

//Location uic;

KetaiBluetooth bt;
//KetaiList klist;

byte[] buffer;
int bufferIndex = 0;

void onCreate(Bundle savedInstanceState) {
  println("create");
  bt = new KetaiBluetooth(this);

  //if (location == null)
  //location = new KetaiLocation(this);
  super.onCreate(savedInstanceState);
}


//void onResume()
//{
//  println("resume");
//  if (location == null)
//    //location = new KetaiLocation(this);
//    super.onResume();
//}

void onActivityResult(int requestCode, int resultCode, Intent data) {
  bt.onActivityResult(requestCode, resultCode, data);
}

void terminateComm() {
}

void initComm() {
  buffer = new byte[packetLength];
}

void beginComm() {
  bt.start();
  updateComm();
  if (paired && !connecting) {
    println("connecting to teleobject");
    bt.connectToDeviceByName("teleobject");  
    connecting = true;
  }
}

void updateComm() {
  if (bt != null) {
    bluetooth = bt.isStarted();
    connected = bt.getConnectedDeviceNames().size() > 0;
    paired = bt.getPairedDeviceNames().size() > 0;
    portName = "";
    ArrayList<String> pairedDevices = bt.getPairedDeviceNames();
    ArrayList<String> connectedDevices = bt.getConnectedDeviceNames();
    for (String pair : pairedDevices)
    {
      portName+= pair+" paired\n";
    }
    for (String conn : connectedDevices)
    {
      portName+= conn+" connected\n";
    }
  }
}

void tx(byte[] data) {
  if (connected) {
    bt.broadcast(data);
    txR = int(millis() - lastTx);
    lastTx = millis();
  }
}


void onBluetoothDataEvent(String who, byte[] data)
{
  for (int i=0; i<data.length; i++) {
    buffer[bufferIndex++]= data[i];
    if (data[i] == (byte)254) {
      parse(buffer);
      buffer = new byte[packetLength];
      bufferIndex = 0;
    } 
  }
}

void onLocationEvent(double _latitude, double _longitude, double _altitude) {
  try {
    located = true;
    provider = location.getProvider();
    longitude = _longitude;
    latitude = _latitude;
    altitude = _altitude;
    println("lat/lon/alt: " + latitude + "/" + longitude + "/" + altitude);
  }
  catch (Exception e) {
    println("Exception "+e);
  }
}


///////////////
// PLACE HOLDERS
///////////////


char[]eq;
float[]eqVal;
int res= 32;

float rightL;
float leftL;
float eqFilter = .2;

void initMic() {
}

void updateMic() {
}

void rx() {
}*/
// PROTOCOL IN
int packetLength = 14;
int missedPackets = 0;
int packetIn = 1, packetOut = 1;

long lastTx, lastRx;
int txR;
int rxR;

// PROTOCOL OUT
int displayMode, tick, tock, tuck;
int headerLength = 5;

// SENSOR
float sens = 1;
float ax, ay, az;
float fx, fy, fz;
boolean shock, busy;
int mm;
float battery;
float tiltAngle = 3;

// COMM
String portName = "";


public String createString(String thisString, int thisMode, int thisTick, int thisTock, int thisTuck) {
  return thisMode+""+TAB+""+thisTick+""+TAB+""+thisTock+""+TAB+""+thisTuck+""+TAB+""+thisString;
}

public void writeString(String thisString, int thisMode, int tick, int tock, int tuck) {
  if (thisString.length() == 123) thisString += " "; /////////// HACK
  packetOut ++;
  // println(thisString.length());
  if (packetOut == 100) packetOut = 1;
  byte[] data = new byte[thisString.length()+headerLength+1];
  data[0] = (byte)(thisMode+48);
  data[1] = (byte)(tick+48);
  data[2] = (byte)(tock+48);
  data[3] = (byte)(tuck+48);
  data[4] = (byte)(packetOut+48);
  for (int i=0; i < thisString.length(); i++) {
    data[i+headerLength] = (byte)thisString.charAt(i);
  }
  data [data.length-1] = (byte)'\n';
  tx(data);
  alpha.printString(thisString, thisMode, tick, tock, tuck);
  if (debug && !android) {
    //println(thisMode+"   "+tick+"   "+tock+"   "+tuck+"   "+packetOut+" "+thisString);
    Packet newPacket = new Packet(false, thisString, getPilot(usb ? "usb" : "bluetooth").x);
  }
}

public void parse(byte[] data) {
  if (data.length > 12) {
    packetIn = data[12];
    if (packetIn < packetOut || packetIn == 0) {
      missedPackets ++;
      //if (debug) {
      //println("missed"+missedPackets+" "+packetIn+" "+packetOut);
      //}
    } else {
      mm = data[0];
      ax = data[1]-10+(data[2]/10.0f);
      ay = data[3]-10+(data[4]/10.0f);
      az = data[5]-10+(data[6]/10.0f);
      fx += (ax-fx)*sens;
      fy += (ay-fy)*sens;
      fz += (az-fz)*sens;
      shock = data[7] == 1 ? true : false;
      battery = data[8]+(data[9]/10.0f)+(data[10]/100.0f);
      busy = data[11] == 1 ? true : false;
      if (debug && !android) {
        Packet newPacket = new Packet(true, busy ? "BUSY" : "FREE", getPilot(usb ? "usb" : "bluetooth").x);
        //println(packetIn+" "+busy +" " +mm+" "+ax+" "+ay+" "+az+" "+shock+" "+battery);
      }
    }
  }
}

ArrayList<String> contacts;

ArrayList<String> profileImages;

int currentContact = 0;
// String[] contactData;

// String contactName, contactLastName, contactInitials, contactImage;

public void initContacts() {
  contacts = new ArrayList();
  profileImages = new ArrayList();

  String[] contactData = loadStrings("csv/contact_list.csv");
  for (int i=0; i<contactData.length; i++) {
    String[] items =  splitTokens(contactData[i], ",");
    String fullName = removeQuotes(cleanUp(items[0]));
    String lastName = removeQuotes(cleanUp(items[1]));
    String initials = cleanUp(items[2]);
    String contactImage = items[3];
    if (!lastName.equals("_") && !lastName.equals(" ") && !lastName.equals("")) {
      fullName += " "+lastName;
    }
    contacts.add(fullName);
    profileImages.add(contactImage);
  }
}
ArrayList drives;

public void updateDrive() {
	drives = new ArrayList();
	long pingStart = millis();
	String logId = "1nDJ7lBSpylE5ORHF6xTntc4N9iqq8m3j_LW7Ok5K8RQ";
	String driveUrl = "https://docs.google.com/spreadsheets/d/"+logId+"/export?format=tsv&id="+logId;
	String[] driveContent = loadStrings(driveUrl);
	println(driveUrl);
	pingTime = PApplet.parseInt(millis()-pingStart);
	if (driveContent != null) {
		for (int i=0; i<driveContent.length; i++) {
			drives.add(removeQuotes(driveContent[i]));
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



PFont font, fontBold, fontMono, fontMonoBold;

float rot, targetRot;
PShape outline, outline_mask, app, mask;

float cW = 1600;
// float cH = 900;

int redColor = color(190, 30, 45);
int backgroundColor = 200;

int debounce = 500;
long lastClick;
boolean clicked;

public void initGui() {
  app = loadShape("shp/app.svg");
  app.disableStyle();
  outline = loadShape("shp/ticker.svg");
  outline.disableStyle();
  outline_mask = loadShape("shp/ticker_mask.svg");
  outline_mask.disableStyle();
  mask = loadShape("shp/mask.svg");
  mask.disableStyle();
  font = createFont("Helvetica", 64);
  fontBold = createFont("Helvetica-Bold", 64);
  fontMono = createFont("Courier", 64);
  fontMonoBold =  createFont("Courier-Bold", 64);
  initPackets();
}

public void displayGui() {
  pushMatrix();
  scale(width/cW);
  checkPilots();
  if (refresh || debug) {
    background(backgroundColor);
    // PACKETS
    if (!android) {
      displayPackets();
    }
    displayPilots();
  }
  // PILOTS

  popMatrix();

  // OBJECT
  pushMatrix();
  translate(width/2, height/2);
  scale(width/cW);
  translate(0, -48);
  if (channel == AXIS) {
    targetRot = radians(map(fx, -9, 9, 60, -60));
    rot += (targetRot-rot)*.2f;
    rotate(rot);
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


  // PORT NAME
  if (debug ) {
    fill(backgroundColor);
    rectMode(CORNER);
    rect(-596, 100, 500, 200);
    fill(50);
    textFont(font, 18);
    textAlign(LEFT, TOP);
    text((int)frameRate+" fps\n"+width+"x"+height+"px\n"+portName, -596, 100);
  }
  // DWEETS
  if (debug) {
    displayDweet(-596, 150);
  } 
  popMatrix();
}

public void keyPressed() {
  if (key >= 48 && key <= 58) {  
    setChannel(key-48);
  }
  if (key >= 65 && key <= 65+28) {
    setChannel(key-48);
  }
}

public void mousePressed() {
  if (millis()-lastClick > debounce) {
    lastClick = millis();
    clicked = true;
  }
}

public void mouseReleased() {
  clicked = false;
}

ArrayList<Packet> packets ;

public void initPackets() {
  packets = new ArrayList();
}

public void displayPackets() {
  for (Packet packet : packets) {
    packet.display();
  }
  if (packets.size() > 20) {
    packets.remove(0);
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
    loc = new PVector (x_, in ? height/2/(width/cW) : 150, 255);
    targetLoc = new PVector (x_, in ? 150 : height/2/(width/cW), 0);
    packets.add(this);
  }

  public void display() {

    loc.x = attract(loc.x, targetLoc.x, .05f, 10);
    loc.y = attract(loc.y, targetLoc.y, .05f, 10);
    loc.z = attract(loc.z, targetLoc.z, .05f, 10);

    fill(redColor, loc.z);
    // ellipse(loc.x, loc.y, 10, 10);
    if (!android) {
      textAlign(CENTER);
      if (label != null) {
        //textFont(fontMonoBold, 12);
        text(label, loc.x, loc.y);
      }
    } else {
      ellipse(loc.x, loc.y, 10, 10);
    }
    if ((in && loc.y < 50) || (!in && loc.y>height/2)) { 
      packets.remove(this);
      // this = null;
    }
  }
}
ArrayList<String> locations;
String provider;
double longitude, latitude, altitude, accuracy;
String postCode, country, countryCode, state, county, city, suburb, neighbourhood, street, houseNumber, building;

boolean hardLocation = true;

public void initLocation() {
  if (!android) {
    if (hardLocation) {
      // home
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
    // updateLocation();
  }
}

public void updateLocation() {
  if (located && !found) {
    if (longitude != 0) {
      String url = "http://nominatim.openstreetmap.org/reverse?lat="+latitude+"&lon="+longitude+"&format=json";
      String[] geolocationContent = loadUrl(url);
      if (geolocationContent != null) {
        //saveStrings("json/location.json", geolocationContent);
        String jsonFragment = geolocationContent[0];
        processing.data.JSONObject geolocatedData = processing.data.JSONObject.parse(jsonFragment);
        processing.data.JSONObject address = geolocatedData.getJSONObject("address");
        country = address.getString("country");
        countryCode = address.getString("country_code");
        state = address.getString("state");
        county = address.getString("county");
        city = address.getString("city");
        //suburb = address.getString("suburb");
        neighbourhood =  address.getString("neighbourhood");
        street = address.getString("road");

        if (!address.isNull("house_number")) {
          houseNumber = address.getString("house_number");
        }
        //building = address.getString("building");
        postCode = address.getString("postcode");
        found = true;
      }
    }
  }
  //////////////
  locations = new ArrayList();
  if (!found) {
    locations.add("WE'RE LOST...");
    //found = = false;
  } else {
    locations.add(cleanUp(getCoordinate(latitude, true)+" "+getCoordinate(longitude, false), true));
    locations.add(cleanUp(houseNumber+" "+street, true));
    locations.add(cleanUp(neighbourhood+" "+postCode, true));
    locations.add(cleanUp(city+", "+state, true));
  }
}
ArrayList<String> mails;
int mailIndex;

public void initMail() {
}

public void updateMail() {
  mails = new ArrayList();
  String[] mailBuffer = loadUrl("http://teleobjects.com/api/proxy.php?mail=true");
  //println(mailBuffer);
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
        mails.add(createString(cleanUp(name, true), SCROLL_PUSH_RIGHT, 10, 1, 10));
        mails.add(createString(" ", INSTANT, 1, 1, 1));
        if (items.length>1) {
          String date = items[1].substring(0, 11);
          mails.add(createString(cleanUp(date, true), CENTERED, 1, 1, 10));
          mails.add(createString(" ", INSTANT, 1, 1, 1));
        }

        if (items.length > 2) {
          String subject =  cleanUp(items[2].toUpperCase());
          mails.add(createString(subject, SCROLL_ALL_RIGHT, 100, 1, 10));
        }
      }
    }
  }
  if (mails.size() == 0) {
    mails.add("No unread emails");
  }
}


Minim minim;
AudioInput in;

char[]eq;
float[]eqVal;
int res= 32;

float maxL = .03f;
float midL = .01f;
float minL = midL/2;

float rightL;
float leftL;
float eqFilter = .2f;

public void initMic()
{
 minim = new Minim(this);
 in = minim.getLineIn(minim.STEREO, res);
 eq = new char[res];
 eqVal = new float[res];
}

boolean softEq = false;

public void updateMic()
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
     eq[i] =EQ_HIGH;
   } else if ( eqVal[i] > midL &&  eqVal[i] < maxL) {
     eq[i] =EQ_MID;
   } else if ( eqVal[i] >  minL &&  eqVal[i] < midL) {
     eq[i] =EQ_LOW;
   } else {
     eq[i] =EQ_OFF;
   }
   // line(0, -offset + in.left.get(i)*offset, eqWidth, -offset + in.left.get(i)*offset);
   // translate(eqWidth, 0);
 }
 // popMatrix();
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
ArrayList<String> news;

ArrayList<Article> articles;
int articleIndex;

PImage articleImage;

// import java.net.URI;
String newsKey = "df5b7c70d8675c367c0cbacc5b8879e0:11:74861169";

public void initNews() {
}

public void updateNews() {
  news = new ArrayList();
  articles = new ArrayList();
  articleIndex = 0;
  news.add(createString("LATEST FROM NY TIMES", SCROLL_PUSH_RIGHT, 10, 1, 20));
  news.add(createString(" ", SCROLL_PUSH_RIGHT, 10, 1, 10));
  String newsUrl = "http://api.nytimes.com/svc/mostpopular/v2/mostviewed/all-sections/1.json?api-key="+encode(newsKey);
  String[] newsResponse = loadUrl(newsUrl);
  // println(newsUrl);
  if (newsResponse != null) {
    String newsFragment = newsResponse[0];
    processing.data.JSONObject newsJSON = processing.data.JSONObject.parse(newsFragment);
    processing.data.JSONArray newsArray = newsJSON.getJSONArray("results");
    int numberOfNews = newsArray.size();
    for (int i=1; i<numberOfNews; i++) {
      processing.data.JSONObject newsContent = newsArray.getJSONObject(i);
      String newsTitle = newsContent.getString("title");
      String newsSection = newsContent.getString("section");
      String newsKeywords = newsContent.getString("adx_keywords");
      String newsAbstract = newsContent.getString("abstract");
      String newsType = newsContent.getString("section");

      processing.data.JSONArray mediaArray = newsContent.getJSONArray("media");
      processing.data.JSONObject mediaContent = mediaArray.getJSONObject(0);

      processing.data.JSONArray mediaMetadataArray = mediaContent.getJSONArray("media-metadata");
      processing.data.JSONObject imageData = mediaMetadataArray.getJSONObject(0);
      String imageUrl = imageData.getString("url");
      // println(imageUrl);

      String items[] = splitTokens(cleanUp(newsKeywords, true), ";");
      int count = 0;

      Article article = new Article();
      article.imageUrl = imageUrl;
      article.title = newsTitle;
      article.content = newsAbstract;
      for (int j=0; j<items.length && count < 10; j++) {
        if (items[j].length() < 28) {
          String keyword = cleanKeyword(items[j]);
          if (keyword != null && keyword.length() >0 ) {
            count ++;
            article.keywords.add(keyword);
            println(keyword);
          }
        }
      }
      if (article.keywords.size() > 0) {
        article.display();
      }
    }
  }
  if (news.size() == 0) news.add("CAN'T CONNECT TO NY TIMES");
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
    news.add(createString("NEWS|"+title+"|"+imageUrl, DWEET_TX, 1, 1, 1));
    for (String keyword : keywords) {
      news.add(createString("", BLANK, 1, 1, 1));
      news.add(createString(keyword, CENTERED, 1, 1, 3));
    }
    news.add(createString("", BLANK, 1, 1, 1));
    news.add(createString(cleanUp(title, true), TICKER, 2, 10, 20));
    news.add(createString(cleanUp(content, true), TICKER, 2, 10, 20));
  }
}

public String cleanKeyword(String str) {
  int parenthesis = str.indexOf("(");
  //
  if (parenthesis != -1) {
    str = removeSpaces(str.substring(0, parenthesis-1));
  }
  int comma = str.indexOf(",");
  if (comma != -1) {
    str = str.substring(comma+2, str.length())+" "+removeSpaces(str.substring(0, comma));
  }

  return str;
}
ArrayList<String> onlines;
ArrayList<String> wifis;


 
 

String hostName; 
String hostIP; 
String externalIP;

String pingUrl = "http://www.google.com";
String ipFinderUrl = "https://api.ipify.org";
int pingTime;

public String[] loadUrl(String thisUrl) {
  loading = true;
  writeString("", LOADING, 1, 1, 1);
  println(thisUrl);
  if (!wifi) updateWifi();
  long pingStart = millis();
  if (wifi) {
    String[] content = loadStrings(thisUrl);
    if (content != null) {
      pingTime = PApplet.parseInt(millis() - pingStart);
      online = true;
      println("ok "+pingTime+"ms");
      return content;
    }
  }
  println("error");
  return null;
}

public void initOnline() {
  updateOnline();
}

public void updateOnline() {
  onlines = new ArrayList();
  long pingStart = millis();
  println(ipFinderUrl);
  try { 
    String[] ip = loadUrl(ipFinderUrl);
    if (ip != null) {
      online = true;
      pingTime = PApplet.parseInt(millis() - pingStart);
      externalIP = ip[0];
      onlines.add(cleanUp("IP "+ip[0]+" PING "+pingTime+"ms"));
    } else {
      onlines.add("CAN'T CONNECT TO WWW");
      online = false;
    }
  } 
  catch (Exception e) {
    println(e);
    online = false;
    onlines.add("EXCEPTION THROWN");
  }
}

public void initWifi() {
  updateWifi();
}

public void updateWifi() {
  wifis = new ArrayList();
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
      wifi = false;
      online = false;
    } else {
      hostName = addr.getHostName();
      wifis.add(cleanUp(hostName+"@"+hostIP, true));
      wifi = true;
    }
  } 
  catch (UnknownHostException e) {
    println(e);
  }
}



Serial port;

public void initComm() {
	println(Serial.list());
}

public void beginComm() {
	for (int i=0; i<Serial.list().length; i++) {
		if (Serial.list()[i].indexOf(usb ? "usbmodem" : "teleobject") != -1) {
			portName = Serial.list()[i];   
			println("connecting to "+portName);
			try {
				port = new Serial(this, portName, 57600);
				connecting = true;
				paired = true;
				println("connected to "+portName);
				break;
			} catch (Exception e) {
				println("could not connect to "+portName);
			}
		}
	}
}

public void updateComm() {
}

public void terminateComm() {
//println("terminate");
port = null;
connected = false;
}

public void tx(byte[] data) {
	if (connected) {
		txR = PApplet.parseInt(millis() - lastTx);
		lastTx = millis();
		port.write(data);
	}
}

public void rx() {
	if (connected) {
		if (port.available() > 13  ) {
			byte[] data = port.readBytesUntil(254);
			rxR = PApplet.parseInt(millis() - lastRx);
			lastRx = millis();
			if (data != null) {
				parse(data);
			}
		}
	}
}

/////////////////
// PLACE HOLDERS
/////////////////

int location = -1;// = null;

public void connectBluetooth() {
}

public void updateBluetooth() {
}
ArrayList<Pilot> pilots; 

public void initPilots() {
  pilots = new ArrayList();
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
    thisPilot.y = (height-70)/(width/cW);
    pilots.add(thisPilot);
  }
}


public void displayPilots() {
  setPilot("play", play);
  setPilot("refresh", refresh);
  setPilot("settings", debug);
  setPilot("contacts", channel==CONTACTS);
  setPilot("twitter", channel==TWITTER);
  setPilot("mail", channel==MAIL);
  setPilot("news", channel==NEWS);
  setPilot("drive", channel==DRIVE);
  setPilot("things", dweet);
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
  setPilot("sleep", (int)frameRate+" fps\n"+width+"x"+height+"px\n"+channel+"\n"+(currentTimeStamp-startTimeStamp)/1000+"s");
  setPilot("weather", conditionMain+"\n"+nf(metric ? getCelcius(temp) : temp, 0, 1) + (metric ? "\u00b0C" : PApplet.parseChar(29)+"\u00b0F")+"\n"+PApplet.parseInt(humidity)+"% humidity"+"\n"+
    pressure+"mPa \n"+clouds+"% clouds\n"+windSpeed+"m/h \n"+getHeading(windDeg)+" "+(int)windDeg+"\u00b0\n"+(currentTimeStamp-weatherUpdated)/1000+"s");
  setPilot("online", online ? externalIP+"\n"+pingTime+"ms" : "");
  setPilot("wifi", hostIP+"\n"+hostName);
  if (connected) {
    setPilot(usb ? "usb" : "bluetooth", "TX "+nf(millis()-lastTx, 4, 0)+"ms\nRX "+nf(millis()-lastRx, 4, 0)+"ms\n"+busy+"\n"+missedPackets+" missed");
  }
  setPilot("battery", nf(battery, 1, 2)+"v");
  setPilot("time", getStringTime(true)+"\n");
  setPilot("location", getCoordinate(latitude, true)+"\n"+getCoordinate(longitude, false)+"\n"+provider+"\n"+houseNumber+" "+street+"\n"+neighbourhood);
  setPilot("usb", usb && connected);
  setPilot("bluetooth", bluetooth && connected);
  setPilotRotation("bluetooth", connecting);
  setPilot("axis", "X "+(ax>=0?"+":"")+nf(ax, 1, 1)+"\n"+"Y "+(ay>=0?"+":"")+nf(ay, 1, 1)+"\n"+"Z "+(az>=0?"+":"")+nf(az, 1, 1));
  setPilot("eq", "R "+nf((int)(rightL*1000), 3, 0)+"\nL "+nf((int)(leftL*1000), 3, 0));

  if (channel == CONTACTS && profileImage != null) {
    pushMatrix();
    translate(getPilot("contacts").x, getPilot("contacts").y-100);
    pushMatrix();
    scale(.822f);
    scale(96.0f/profileImage.height*1.0f);

    image(profileImage, 0, 0);
    popMatrix();
    fill(backgroundColor);
    noStroke();
    scale(.7f);
    shape(mask, 0, 0);
    popMatrix();
  }


  if (channel == NEWS && articleImage != null) {
    pushMatrix();
    translate(getPilot("news").x, getPilot("news").y-100);
    pushMatrix();
    scale(articleImage.width/mask.width*.765f);

    image(articleImage, 0, 0);
    popMatrix();
    fill(backgroundColor);
    noStroke();
    scale(.7f);
    shape(mask, 0, 0);
    popMatrix();
  }

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
  float r = 0;

  boolean rotating;

  Pilot(String thisName, String thisShape, int thisCommand) {
    name = thisName;
    icon = loadShape("svg/"+thisShape+".svg");
    icon.disableStyle();
    command = thisCommand;
  }

  public void display() {
    pushMatrix();

    noFill();
    noStroke();
    translate(x, y);
    fill(backgroundColor);
    scale(s);
    rectMode(CENTER);
    rect(0, 0, 120, 120);
    stroke(state ? redColor : 255);
    strokeWeight(3);
    shape(app, 0, 0);
    //if (rotating) rotate(millis()/1000.0);
    shape(icon, 0, 0);
    if (label!=null && debug && (channel == command || !android)) {     
      fill(50);
      textAlign(CENTER);
      textFont(font, android ? 40 : 20);
      text(label, 0, 84);
    }
    popMatrix();
  }

  public void check() {
    sx = screenX (x, y);
    sy = screenY (x, y);
    if (clicked && dist(sx, sy, mouseX, mouseY) < 50) {
      setChannel(command);
      clicked = false;
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

//Pilot getPilotByCommand(String thisCommand) {
//  for (Pilot pilot : pilots) {
//    if (pilot.command.equals(thisCommand)) {
//      return pilot;
//    }
//  }
//  return null;
//}

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
ArrayList<String> places, results;
int placeTypeIndex;

public void initPlaces() {
  places = new ArrayList();
  String[] placeTypes = loadStrings("csv/place_types_short.csv");
  for (int i=0; i<placeTypes.length; i++) {
    places.add((placeTypes[i]));
  }
}

public void searchPlaces() {
  String types = places.get(pageIndex).toLowerCase();
  int radius = 500;
  results = new ArrayList();
  String placesUrl = "https://maps.googleapis.com/maps/api/place/radarsearch/json?location="+latitude+","+longitude+"&radius="+radius+"&types="+encode(types)+"&key=AIzaSyCKVs8ruHWC9-gx2b2XpNz2AxzqUYvAD6c"; // &keyword=vegetarian&
  String placesContent[] = loadUrl(placesUrl);
  if (placesContent != null) {
    String placesFragment ="";

    for (int i=0;i<placesContent.length;i++) {
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
          for (int j=0;j<placeDetailContent.length;j++) {
            placeDetailFragment += placeDetailContent[j];
          }
          processing.data.JSONObject placeDetailJSON = processing.data.JSONObject.parse(placeDetailFragment);
          processing.data.JSONObject placeResult = placeDetailJSON.getJSONObject("result");
          processing.data.JSONObject placeGeometry = placeResult.getJSONObject("geometry");
          //println(placeGeometry);
          results.add(cleanUp(placeResult.getString("name")+" IS OPEN",true));
          println(placeResult.getString("name"));
        }

      }
      placed = true;
    }
  }
}
ArrayList dweets;
Dweet latestDweet;
float dweetA, dweetTargetA = 0;
String lastCreated = "";
boolean dweeted;
long lastDweet;
String teleobject = "ticker";
String thing = "teleobjects";

public void initThing() {
  latestDweet = new Dweet();
  dweets = new ArrayList();
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

public void sendDweet(String key_, String value_) {
  long pingStart = millis();
  String url = "https://thingspace.io/dweet/for/"+thing+"?"+"teleobject="+teleobject+"&"+key_+"="+encode(value_);
  String[] buffer = loadStrings(url);
  println(url);
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
    textFont(fontBold, 20);
    fill(redColor, dweetA);
    text(latestDweet.info, 0, 0);
    popMatrix();
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




String dayStr, monthStr;
int day;
int month;
int year;
long startTime = 0;
long currentTimeStamp = 0;
long startTimeStamp = 0;

String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
String[] monthNames ={"January", "February", "March", "April", "May", "June", "July", 
"August", "September", "October", "November", "December"};

public void initTime() {
  Date d = new Date();
  startTimeStamp = d.getTime();
  Calendar cal = Calendar.getInstance();
  cal.setTime(d);
  int dayTemp = cal.get(Calendar.DAY_OF_WEEK);
  dayTemp -= 2;
  if (dayTemp < 0)dayTemp += 7;
  dayStr = dayNames[dayTemp];
  day = cal.get(Calendar.DAY_OF_MONTH);
  month = cal.get(Calendar.MONTH);
  monthStr = monthNames[month];
  year = cal.get(Calendar.YEAR);
  startTime = millis();
}

public void updateTime() {
  Date d = new Date();
  currentTimeStamp = d.getTime();
}

//import twitter4j.conf.*;
//import twitter4j.api.*;
//import twitter4j.*;

//import java.util.List;
//// import java.util.Iterator;

//ConfigurationBuilder   cb;
//Query query;
//Twitter twitter;

ArrayList<String> tweets;

//// ArrayList<UserCustom> twittersList;

//String screenName;

//int    trendId = 2459115; // NYC


public void initTwitter() {
  //	cb = new ConfigurationBuilder();
  //	cb.setOAuthConsumerKey("Ray2xXVP9I1PuxgOP1Cu6IdXO");
  //	cb.setOAuthConsumerSecret("EnZmqdtHIoH4zhDrp4VE0Ze3LzrWUrdFSZUg2CHSRu3iNzVk2i");
  //	cb.setOAuthAccessToken("4421325317-j8acACcvuXYnxsFYtjJGe2AOdY6vQxtQvLVpGXz");
  //	cb.setOAuthAccessTokenSecret("dxKlTw62t3w9Dc3H3pt5n5qOYqVpslIMfyVeCQV7LnbmI");
  //	twitter = new TwitterFactory(cb.build()).getInstance();
}
public void updateTwitter() {
  //	tweets = new ArrayList();
  //	getTrending();
  //	getTweets();
  //	queryTwitter(("#IoT"));
}

//void getTweets() {
//	try 
//	{
//		// println("10 Twitter timeline");
//		User user = twitter.verifyCredentials();
//		String screenName = "@"+user.getScreenName();
//		// println(screenName);
//		tweets.add(screenName+" LATEST TWEETS");
//		tweets.add(user.getDescription());
//		tweets.add(user.getLocation());
//		Paging paging = new Paging(1, 10);
//		List<Status> statuses = twitter.getHomeTimeline(paging);

//		for (Status status : statuses) {
//			String usr = "@"+status.getUser().getName();
//			String msg =  status.getText();
//			println(usr, msg);
//			tweets.add(cleanUp(usr+" "+msg, true));
//		}
//	}
//	catch(TwitterException te) {
//		tweets.add("Can't connect to Twitter " + te);
//	}
//	if (tweets.size() == 0 ) tweets.add("Can't connect to Twitter");
//}

//void queryTwitter(String str) {
//	ArrayList<String> twitt = new ArrayList<String>();
//	query = new Query(str);
//	query.setCount(10);
//	try {
//		QueryResult result = twitter.search(query);
//		List<Status> results = result.getTweets();
//		// println("New Tweet : ");
//		tweets.add(cleanUp("LATEST ABOUT "+str, false));

//		for (Status tw : results) {
//			String msg = tw.getText();
//			String usr = tw.getUser().getScreenName();
//			String twStr = "@"+usr+": "+msg;
//			// println(twStr);
//			// tweets.add(cleanUp("@"+usr)+cleanUp(msg, true));
//			tweets.add(cleanUp(msg, true));

//		}
//	}
//	catch (TwitterException te) {
//		tweets.add("Can't connect to Twitter "+te);
//	}
//	// return twitt;
//}


//void getTrending() {
//	ArrayList<String> twitt = new ArrayList<String>();
//	try {
//		Trends trends = twitter.getPlaceTrends(trendId);
//		tweets.add(createString("POPULAR IN NEW YORK CITY", SCROLL_PUSH_RIGHT, 10, 1, 20)) ;
//		tweets.add(createString(" ", SCROLL_PUSH_RIGHT, 10, 1, 1)) ;

//		// tweets.add(createString(" ", INSTANT, 1, 1, 1));

//		for (int i = 0; i < trends.getTrends().length && i < 5; i++) {
//			// println(trends.getTrends()[i].getName());
//			tweets.add(createString(cleanUp(trends.getTrends()[i].getName(), true), CENTERED, 1, 1, 10));
//			tweets.add(createString(" ", INSTANT, 1, 1, 1));

//		}
//	}
//	catch (TwitterException te) {
//		tweets.add("Can't connect to Twitter "+te);
//	}
//}
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
      str = str.substring(0, str.length()-2);
    }
  }
  return str;
}

public String removeSpaces(String str) {
  if (str.length() > 0) {
    if (str.charAt(0) == ' ') {
      str = str.substring(1, str.length()-1);
    }
  }
  if (str.length() > 0) {
    if (str.charAt(str.length()-1) == ' ') {
      str = str.substring(0, str.length()-2);
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

public String getCoordinate(double coordinate, boolean isLat) {
  char hemisphere = coordinate < 0 ? (isLat ? 'S' : 'W') : (isLat ? 'N' : 'E');
  float coord = (float)coordinate; 
  coord = abs(coord);
  int degrees = PApplet.parseInt(coord);         
  float minutesFromRemainder = (coord - degrees) * 60;      
  int minutes = PApplet.parseInt(minutesFromRemainder);      
  float secondsFromRemainder = ( minutesFromRemainder - minutes ) * 60;  
  int seconds = PApplet.parseInt( secondsFromRemainder);
  return (degrees+""+DEGREE + nf(minutes, 2, 0) + SINGLE_QUOTE + nf(seconds, 2, 0) +DOUBLE_QUOTE +""+hemisphere);
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
ArrayList<String> weathers;
long weatherUpdated;
int weatherRefresh = 300; // in seconds

float windSpeed, windDeg, windGust, rain, clouds;
String condition, conditionMain;
float  temp, pressure, humidity;

public void updateWeather() {
  if ((currentTimeStamp - weatherUpdated)/1000 > weatherRefresh || !forecasted) {
    String[] weatherContent = null;
    forecasted = false;
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
    if (weatherContent == null) {
      String weatherUrl = "http://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid=1ebe1cb0874724fa15a5a109140d6e4e"+"&units=imperial";
      weatherContent = loadUrl(weatherUrl);
      if (weatherContent != null) {
        //saveStrings("weather.json", weatherContent);
        weatherUpdated = currentTimeStamp;
      }
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
        //rain = rainData.getFloat("3h");
      }
      if (weatherJSON.hasKey("clouds")) {
        processing.data.JSONObject cloudData = weatherJSON.getJSONObject("clouds");
        clouds = cloudData.getFloat("all");
      }
      forecasted = true;
    }
  }
  weathers = new ArrayList();

  if (!forecasted) {
    weathers.add(cleanUp("No weather info..."));
  } else {
    weathers.add(createString(cleanUp(condition+" in "+neighbourhood, true), TICKER, 10, 1, 20));
    weathers.add(createString("", RAIN, 20, 1, 50));
    weathers.add(createString("", BLANK, 10, 1, 1));
    weathers.add(createString(cleanUp("IT'S "+nf(metric ? getCelcius(temp) : temp, 0, 1) + (metric ? PApplet.parseChar(DEGREE)+"c" : PApplet.parseChar(29)+"f"), false), CENTERED, 1, 1, 10));
    weathers.add(createString(cleanUp(PApplet.parseInt(humidity)+"% HUMID", true), CENTERED, 1, 1, 10));
    weathers.add(createString(cleanUp("PRESSURE "+PApplet.parseInt(pressure)+"mPa", false), CENTERED, 1, 1, 10));
    weathers.add(createString(cleanUp(PApplet.parseInt(clouds)+"% CLOUDY", true), CENTERED, 10, 1, 10));
    weathers.add(createString(cleanUp("WIND "+PApplet.parseInt(windSpeed) +"m/h "+(int)windDeg+PApplet.parseChar(DEGREE)+" "+getHeading(windDeg), false), CENTERED, 1, 1, 10));
    weathers.add(createString("", SCROLL_PUSH_RIGHT, 10, 1, 20));
  }
}

public String getHeading(float deg) {
  String[] directions = {"N", "NNE", "NE", "ENE", "E", "ESE", "SE", "SSE", 
    "S", "SSW", "SW", "WSW", "W", "WNW", "NW", "NNW"};
  int i = PApplet.parseInt((deg + 11.25f)/22.5f);
  return directions[i % 16];
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
