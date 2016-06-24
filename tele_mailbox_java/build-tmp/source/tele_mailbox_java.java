import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.serial.*; 
import java.net.InetAddress; 
import java.net.UnknownHostException; 
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

public class tele_mailbox_java extends PApplet {


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
final int ALPHABET = 108;
final int SDCARD = 109;
final int MAIL = 110;
final int THING = 111;
final int TWITTER = 113;
final int NEWS = 114;
final int SETTINGS = 200;
final int REFRESH = 201;

final int RESULTS = 120;

boolean dweet, usb, bluetooth, wifi, paired, connecting, connected, ready, online, located, found, forecasted, placed, loggedin, loading, metric = true;

boolean play;
boolean refresh;

int servoDown = 20;
int servoUp = 177;
int servoWave = 175;

int channel = -1;

ArrayList<String> pages;
int pageIndex;
int lastPageIndex;
int pageSpeed = 200;
long lastPage;
boolean initPage;

boolean debug = false;

boolean android = false;

// boolean gradient = false;

public void setup() {
  
  rectMode(CENTER);
  imageMode(CENTER);
  initTime();
  initComm();
  initColors();
  initGui();
  initPilots();
  // initWifi();
  // initOnline();
  // initThing();
  initLocation();
  initContacts();
  //initPlaces();
  begin();
}

int currentSymbol = 0;
int currentColor = 0;

public void setChannel(int thisCOM8x8mand) {
  println(thisCOM8x8mand);
  channel = thisCOM8x8mand;
  switch(channel) {
    case PLAY:
    // printBlank();
    // printForeground(whiteColor);
    currentSymbol ++;
    if (currentSymbol == pilots.size()) currentSymbol = 0;
    // printForeground(foreground);
    printBlank();
    printSymbol(pilots.get(currentSymbol).icon, 40, 40, 48, 48, 1, true);
    break;

    case UP:
    foreground = fWheel.c;
    background = bWheel.c;
    printForeground(foreground);
    printBackground(background);

    break;

    case DOWN:
    int g = (int)random(gradients.length);
    top = tops[g];
    bottom = bottoms[g];
    printGradient(color(red(top), green(top), blue(top)), color(red(bottom), green(bottom), blue(bottom)));
    break;

    case LEFT:
    if (currentColor ++ == colors.length-1) currentColor = 0;
    printBackground(colors[currentColor]);
    printBlank();
    break;


    case THING:
    // updateThing();
    // if (dweeted) {
    //   dweeted = false;
    //   if (latestDweet.content_ != null) {
    //     String[] items = splitTokens(latestDweet.content_, ",");
    //     if (items[0].equals("CONTACT")) {
    //     }
    //   }
    // }
    break;
    case MAIL:
    pageSpeed = 500;
    updateMail();
    pages = mails;
    break;
    case TIME:
    printTime();
    break;
    case SDCARD:
    writeString("0");
    printBlank();
    printDirectory("/");
    break;
    case CONTACTS:
    updateContacts();
    //pages = contacts;
    printContact();
    break;
    case WEATHER:
    updateWeather();
    //pages = weathers;
    printWeather();
    break;
    case LOCATION:
    updateLocation();
    //pages = locations;
    printLocation();
    break;
    case ONLINE:
    updateOnline();
    //pages = onlines;
    printOnline();
    break;
    case WIFI:
    updateWifi();
    //pages = wifis;
    printWifi();
    break;
    case DRIVE:

    break;
    case ALPHABET:
    // println("pixels");
    // printBytes(64,64,48,48);
    // initPage = false;
    // // printServo(servoDown);
    // printForeground(color(255,255,255));
    // printBackground(redColor);
    printBlank();

    printAlphabet(true, currentFont, 0, 0);
    currentFont ++;
    currentFont = currentFont % widths.length;
    break;
    case USB:
    if (connected) {
      terminate();
    } else {
      begin();
    }
  }
  initPage = true;
  pageIndex = 0;
  lastPageIndex = - 1;
  lastPage = millis() - pageSpeed;

}

public void draw() {
  displayGui();
  if (connected) {
    rx();
    tx();
  }
  if (connecting) {
    if (portName != null) {
      connected = true;
      connecting = false;
      printServo(servoDown);
      printForeground(foreground);
      printBackground(background);
      printBlank();
      busy = false;
      setChannel(TIME);
    }
  }

  // if (millis() - lastPage>pageSpeed) {
  //   getDweet();
  //   if (dweeted) {
  //     dweeted = false;
  //     if (latestDweet.content_ != null) {
  //       String[] items = splitTokens(latestDweet.content_, "|");
  //       println("got dweet "+items);
  //       if (items[0].indexOf("CONTACTS") != -1) { /////////// fix dweet from frame (now frameCONTACT
  //         printServo(servoWave);
  //         printBlank();
  //         printServo(servoUp);
  //         printForeground(redColor);
  //         // println(items[2]);
  //         printImage(items[2], 16, 16);
  //         writeString("E");
  //         printString(cleanUp(items[1]), false, true, ARIALB14, 0, 2);
  //         lastPage = millis();
  //         //busy = true;
  //       }
  //     }
  //   }
  // }


  if (channel == TIME) {
    if (millis() - lastPage > pageSpeed) {
      lastPage = millis();
      printString(getStringTime(false), true, true, ARIALB14, 0, 26);
      pageSpeed = 500;

    }
  }

  if (channel == MAIL) {
    if (millis() - lastPage > pageSpeed) {
      lastPage = millis();
      lastPageIndex = pageIndex;
      pageSpeed = 3000;
      String stringText = ""; 
      String thisPage = pages.get(pageIndex);
      String[] items = splitTokens(thisPage, ""+TAB);
      String name = cleanUp(removeQuotes(items[0].substring(0, items[0].indexOf("<")-1)));
      if (name.indexOf("(") != -1) {
        name = name.substring(0, items[0].indexOf("(")-2);
      }
      if (name != null) {
        // sendDweet("CONTACTS", removeSpaces(name).toUpperCase()+"|null");  //////////
      }
      printServo(servoWave);
      printBlank();
      printServo(servoUp);
      printForeground(redColor);
      int y = 100;
      y = printString(name, false, true, ARIALB14, 0, y);
      printForeground(color(50, 50, 50));
      y -= 14;
      String subject = cleanUp(items[2]);
      if (subject.length() > 50) subject = subject.substring(0,50);
      printString(subject, true, true, COM8x8, 0, y);
      printString(items[1].substring(0, 16), false, true, SYSTEM5x7, 0, 5);
      printString(items[1].substring(18, items[1].length()), false, true, SYSTEM5x7, 0, 15);
      pageIndex++;
      if (pageIndex == pages.size()) {
        updateMail();
        pageIndex = 0;
        pageSpeed = 10000;
      }
    }
  }
}

public void printContact() {
  printServo(servoWave );
  printBlank();
  printServo(servoUp);
  printForeground(redColor);
  printImage(contactImage, 16, 112);
  // writeString("E");
  printString(cleanUp(contactName), false, true, FONT10x14, 0, 127);
  // sendDweet("CONTACTS", contactName +"|"+contactImage);  //////////
}

public void printLocation() {
  printBlank();
  printString(getCoordinate(longitude, false), true, true, COM8x8, 0, 96);
  printString(getCoordinate(latitude, true), true, true, COM8x8, 0, 108);
  printString(houseNumber +" "+ street, false, true, SYSTEM5x7, 0, 40);
  printString(neighbourhood, false, true, ARIALB14, 0, 28);
  printSymbol(getPilot("weather").icon , 40, 40, 48, 48, .75f, true);

}

public void printWeather() {
  printBlank();
  printString(neighbourhood, false, true, ARIALB14, 0, 28);
  printString(condition+"", false, true, ARIAL14, 0, 40);
  printString(PApplet.parseInt(humidity)+"% "+ PApplet.parseInt(pressure)+" mPa", false, true, SYSTEM5x7, 0, 98);
  printString(PApplet.parseInt(windSpeed)+" m/h "+getHeading(windDeg)+" "+(int)windDeg, false, true, SYSTEM5x7, 128, 108);
  int tmp = PApplet.parseInt(metric ? getCelcius(temp) : temp);
  // String decimals = ""+(getCelcius(temp) - int(getCelcius(temp)));
  if (tmp >= 10) {
    printCharacter((""+tmp).charAt(0) , 18, 40, 48, 48, 1, 60, true);
    printCharacter((""+tmp).charAt(1) , 54, 40, 48, 48, 1, 60, true);
    printString(metric ? "C" : "F", false, false, ARIALB14, 90, 56);
  } else {
    printString(metric ? "C" : "F", false, false, ARIALB14, 80, 56);
    printCharacter((""+tmp).charAt(0) , 40, 40, 48, 48, 1, 60, true);
  }
}

public void printTime() {
  printBlank();
  printString(monthStr+"", false, true, ARIALB14, 0, 102);
  printString(dayStr+"", false, true, ARIAL14, 0, 40);
  printString(year+"", false, true, ARIAL14, 0, 118);
  if (day > 9) {
    // printCharacter((""+day).charAt(0) , 26, 40, 48, 48, 1, 58, true);
    // printCharacter((""+day).charAt(1) , 58, 40, 48, 48, 1, 58, true);
    printCharacter((""+day).charAt(0) , 28, 40, 48, 48, 1, 50, true);
    printCharacter((""+day).charAt(1) , 56, 40, 48, 48, 1, 50, true);
  } else {
    printCharacter((""+day).charAt(0) , 40, 40, 48, 48, 1, 50, true);
  }
}

public void printOnline() {
  printBlank();
  printString(externalIP, false, true, ARIALB14, 0, 82);
  printString("ping "+pingTime+"ms",false, true, SYSTEM5x7, 0, 90);
  printSymbol(getPilot("online").icon , 40, 20, 48, 48, .9f, true);

}

public void printWifi() {
  printBlank();
  printString(hostIP, false, true, ARIALB14, 0, 82);
  printString(hostName, false, true, SYSTEM5x7, 0, 90);
  printSymbol(getPilot("wifi").icon , 40, 20, 48, 48, .9f, true);
}


String portName = "";
Serial port;

public void initComm() {
  println(Serial.list());
}

ArrayList<String> buffer;

public void begin() {
  usb = true;
  busy = false;
  bluetooth = !usb;
  for (int i=0; i<Serial.list().length; i++) {
    if (Serial.list()[i].indexOf(usb ? "1411" : "teleobject") != -1) {
      portName = Serial.list()[i];
      println("connecting to "+portName);
      try {
        port = new Serial(this, portName, 115200);
        connecting = true;
        paired = true;
        println("connected to "+portName);
        break;
      } catch (Exception e) {
        println("could not connect to "+portName);
      }
    }
  }

  buffer = new ArrayList<String>();
}

public void terminate() {
  port = null;
  connected = false;
  usb = false;
}



public void rx() {
  if (connected) {
    if (port.available() > 0) {
      rxR = PApplet.parseInt(millis() - lastRx);
      lastRx = millis();
      println("RX "+millis() + port.read());  
      busy = false;
    }
  }
  
}

public void writeString(String thisString) {
  buffer.add(thisString);  
}

public void tx() {
  if (connected && !busy && buffer.size() > 0) {
    txString(buffer.get(0));
    buffer.remove(0);
    busy = true;
    // println("tx"+millis());
  }
}

public void txString(String thisString) {
  byte[] dataOut = new byte[thisString.length()+1];
  for (int i=0; i<thisString.length(); i++) {
    dataOut[i] = (byte) thisString.charAt(i);
  }
  dataOut[thisString.length()] = '\n';
  txR = PApplet.parseInt(millis() - lastTx);
  lastTx = millis();
  port.write(dataOut);
}

//void rx() {
// if (connected) {
//   if (port.available() > 13  ) {
//     byte[] data = port.readBytesUntil(254);
//     rxR = int(millis() - lastRx);
//     lastRx = millis();
//     if (data != null) {A
//       parse(data);
//     }
//   }
// }
//}
String swatches[] = {"ffcc00", "4cd964", "34aadc", "007aff", "5856d6", "ff2d55", "8e8e93", "c7c7cc", "D1EEFC", "FFD3E0", "F7F7F7", "FF1300", "1F1F21", "BDBEC2", "FF3A2D"};
String gradients[][] = {{"ff5e3a", "ff2a68"}, {"ff9500", "ff5e3a"}, {"ffdb4c", "ffcd02"}, {"87fc70", "0bd318"}, {"52edc7", "5ac8fb"}, {"1ad6fd", "1d62f0"}, {"c644fc", "5856d6"}, {"ef4db6", "c643fc"}, {"4a4a4a", "2b2b2b"}, {"dbddde", "898c90"}, {"5ad427", "a4e786"}, {"c86edf", "e4b7f0"}, {"fb2b69", "ff5b37"}, {"f7f7f7", "d7d7d7"}, {"1d77ef", "81f3fd"}, {"d6cec3", "e4ddca"}, {"55efcb", "5bcaff"}};


int[] colors;
int[] tops;
int[] bottoms;

public void initColors() {
	colors = new int[swatches.length];

	tops = new int[gradients.length];
	bottoms = new int[gradients.length];

	for (int i=0; i<swatches.length;i++) {
		colors[i] = unhex(swatches[i]);
	}
	for (int i=0; i<gradients.length;i++) {
		tops[i] = unhex(gradients[i][0]);
		bottoms[i] = unhex(gradients[i][1]);
	}
}
// PROTOCOL
int packetLength = 14;
int headerLength = 4;
int missedPackets = 0;
int packetIn = 1, packetOut = 1;
long lastTx, lastRx;
int txSpeed = 100;

//int displayMode, tick, tock;

// SENSOR


float sens = 1;
float ax, ay, az;
float fx, fy, fz;
boolean shock, busy;
int mm;
float battery;
int txR;
int rxR;

ArrayList<String> contacts;
int currentContact = 0;


String contactName, contactLastName, contactInitials, contactImage;
//PImage contactImg;

public void initContacts() {
  contacts = new ArrayList();
  String[] buffer = loadStrings("csv/contact_list.csv");
  for (int i=0; i<buffer.length; i++) {
    contacts.add(buffer[i]);
  }
}

public void updateContacts() {
  currentContact = (int)random(contacts.size());
  //currentContact ++;
  //if (currentContact == contacts.size()) currentContact = 0;

  String[] items =  splitTokens(contacts.get(currentContact), ",");
  contactName = cleanUp(items[0]);
  contactLastName =  cleanUp(items[1]);
  contactInitials =  cleanUp(items[2]);
  contactImage = items[3];
  //contactImg = loadImage("data/img/"+contactImage+".png");


  //println("data/img/"+contactImage+".png");
}
ArrayList drives;

public void updateDrive() {
  drives = new ArrayList();
  long pingStart = millis();
  String logId = "1nDJ7lBSpylE5ORHF6xTntc4N9iqq8m3j_LW7Ok5K8RQ";
  String[] driveContent = loadStrings("https://docs.google.com/spreadsheets/d/"+logId+"/export?format=tsv&id="+logId);
  pingTime = PApplet.parseInt(millis()-pingStart);
  for (int i=0; i<driveContent.length; i++) {
    drives.add(removeQuotes(driveContent[i]));
  }
  initPage = true;
}

PFont font, fontBold, fontMono, fontMonoBold;

PFont fonts[];
int fontSizes[];

String info = "";
PShape outline, window, app, mask, frame;

PImage digits128;

float cW = 1600;
float cH = 900;

// color redColor = color(190, 30, 45);
int redColor = color(255, 0, 0);
int whiteColor = color(255, 255, 255);
int backgroundColor = 200;

PGraphics wheel;

boolean clicked;

Wheel bWheel, fWheel;

int debounce = 500;
long lastClick;

Oled oled;

public void initGui() {
  font = createFont("Helvetica", 64);
  fontBold = createFont("Helvetica-Bold", 64);
  fontMono = createFont("Courier", 64);
  fontMonoBold =  createFont("Courier-Bold", 64);
  outline = loadShape("shp/mailbox.svg");
  outline.disableStyle();
  mask = loadShape("shp/mask.svg");
  mask.disableStyle();
  app = loadShape("shp/app.svg");
  app.disableStyle();
  window = loadShape("shp/window.svg");
  window.disableStyle();
  frame = loadShape("shp/mask.svg");
  frame.disableStyle();
  bWheel = new Wheel();
  fWheel = new Wheel();
  //digits128 = loadImage("bmp/digits128.png");

  PFont tmp[]  = {fontMono, fontMonoBold, fontBold, fontBold, font, fontBold, fontBold};
  fonts = tmp;
  int temp2[] = {9, 10, 16, 36, 13, 13, 15};
  fontSizes = temp2;


  oled = new Oled();
}

// void displayWheel(float x, float y, float s) {
//   pushMatrix();
//   translate(x, y);
//   textAlign(CENTER, CENTER);
//   textSize(10);
//   text("R"+red(oled.c)+" G"+green(oled.c)+" B"+blue(oled.c), 50, 110);
//   scale(s);
//   image(wheel, 0, 0);
//   popMatrix();
// }

public void displayGui() {
  background(backgroundColor);

  pushMatrix();
  if (tile != null)
    image(tile, 100,600);

  if (tile2 != null)
    image(tile2, 300,600);
  fWheel.c = foreground;
  bWheel.c = background;

  bWheel.display(100,200, .2f);
  fWheel.display(100,400, .2f);

  scale(width/cW);


  // DWEETS
  // displayDweet(1000, 740);

  // PILOTS
  checkPilots();
  displayPilots();

  popMatrix();

  // OBJECT
  pushMatrix();
  translate(width/2, height/2);
  scale(width/cW);
  // scale(1.5);

  pushMatrix();
  translate(0, 60);
  oled.display();
  popMatrix();
  fill(255);
  strokeWeight(2);
  stroke(0);
  shape(mask, -mask.width/2, -mask.height/2);
  fill(50);
  textFont(font, 12);
  textAlign(LEFT, TOP);
  text(portName, -100, 180);
  popMatrix();
}

public void updateColors() {
  foreground = fWheel.c;
  background = bWheel.c;
  printForeground(foreground);
  // printBackground(background);
}

class Wheel {
  PGraphics g;
  int c;
  float cx = 0, cy = 0;

  Wheel() {
    g = createGraphics(512, 512);
    g.beginDraw();
    g.background(backgroundColor);
    g.smooth();
    g.noStroke();
    g.colorMode(HSB);
    g.translate(256, 256);
    saturationChanger(128, 256);
    g.endDraw();
  }

  public void display(float x, float y, float s) {
    pushMatrix();
    translate(x, y);
    textAlign(CENTER, CENTER);
    textSize(10);
    scale(s);
    pushMatrix();
    translate(0,300);
    scale(6);
    text("R"+(int)red(c)+" G"+(int)green(c)+" B"+(int)blue(c), 0, 0);

    popMatrix();
    imageMode(CENTER);
    image(g, 0, 0);
    noFill();
    stroke(50,200);
    strokeWeight(1);

    popMatrix();

    ellipse(cx,cy,6,6);
    // image(g);
    if (clicked) {
      if (dist (mouseX, mouseY, x, y) < 88) {
        c = get(mouseX, mouseY);
        // clicked = false;
        cx = mouseX;
        cy = mouseY;
        updateColors();

      }
    }
  }

  public void saturationChanger(int i, int initial) {
    if (i > 0) {
      colorTriangle(256, 0, initial, initial);
      saturationChanger(i-1, initial-2);
    }
  }

  public void colorTriangle(int iteration, int h, int s, int height) {
    if (iteration > 0) {
      g.fill(h%256, s, 256);
      g.triangle(0, 0, 128*tan(radians(5.625f/4)), height, -128*tan(radians(5.625f/4)), height);
      g.rotate(radians(5.625f/4));
      colorTriangle(iteration-1, h+1, s, height);
    }
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

public void keyPressed() {
  if (key >= 48 && key <= 58) {  
    writeString(key+"");
  }
  if (key >= 65 && key <= 65+28) {
    //mode = key - 48;
    writeString(key+"");
  }

  switch (key) {
    case TAB:
    debug = !debug;
    break;
    case 's':
    // sendDweet("FOO", "BAR");
    break;
    case 'd':
    // updateThing();
    break;
    case ' ':
    //oled.foreground = get(mouseX, mouseY);
    printBackground(get(mouseX, mouseY));
    break;
    case '>':
    currentFont ++;
    if (currentFont == 10) currentFont = 0;
    break;
    case '<':
    currentFont --;
    if (currentFont == -1) currentFont = 9;
    break;
  }
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
  if (hardLocation) {
    // home
    latitude = 40.7352735f;
    longitude = -73.95551f;
    provider = "fixed";
    located = true;
  } else {
    String url = "http://www.geoplugin.net/json.gp?ip="+externalIP;
    println(url);
    String[] geopluginContent = loadStrings(url);
    if (geopluginContent != null) {
      saveStrings("json\\geolocation.json", geopluginContent);
      String jsonFragment = "";
      for (int i=0; i<geopluginContent.length; i++) {
        jsonFragment += geopluginContent[i];
      }
      JSONObject geolocatedData = JSONObject.parse(jsonFragment);
      latitude = geolocatedData.getFloat("geoplugin_latitude");
      longitude = geolocatedData.getFloat("geoplugin_longitude");
      provider = "geoplugin";
      located = true;
    }
  }
  updateLocation();
}

public void updateLocation() {
  if (located && !found) {
    if (longitude != 0) {
      String url = "http://nominatim.openstreetmap.org/reverse?lat="+latitude+"&lon="+longitude+"&format=json";
      println(url);
      String[] geolocationContent = loadStrings(url);
      if (geolocationContent != null) {
        //saveStrings("json/location.json", geolocationContent);
        String jsonFragment = geolocationContent[0];
        JSONObject geolocatedData = JSONObject.parse(jsonFragment);
        JSONObject address = geolocatedData.getJSONObject("address");
        country = address.getString("country");
        countryCode = address.getString("country_code");
        state = address.getString("state");
        county = address.getString("county");
        city = address.getString("city");
        //suburb = address.getString("suburb");
        neighbourhood =  address.getString("neighbourhood");
        street = address.getString("road");
        houseNumber = address.getString("house_number");
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
	String[] mailBuffer = loadStrings("http://teleobjects.com/api/proxy.php?mail=true");
	for (int i=0; i<mailBuffer.length; i++) {
		mails.add(mailBuffer[i]);
		println(mailBuffer[i]);
	}


		// String[] items = splitTokens (mailBuffer[i], "\t");
		// String name = removeQuotes(items[0].substring(0, items[0].indexOf("<")));
		// mails.add(cleanUp(name.toUpperCase())+"\t"+SCROLL_CENTER+char(50)+char(50));
		// mails.add(cleanUp(items[1]+"\t"+INSTANT+char(32)+char(32)).toUpperCase());
		// String subject =  cleanUp(items[2].toUpperCase());
   //if (subject.length() > 32) {
   //  mails.add(subject.substring(0, 32)+"\t"+INSTANT+char(100)+char(100));
   //  mails.add(subject.substring(32, subject.length()-1)+"\t"+INSTANT+char(100)+char(100));
   //} else {
   //  mails.add(subject+"\t"+INSTANT+char(200)+char(100));
   //}
   //while (subject.length()>32) {
   //  mails.add(subject.substring(0, 32)+"\t"+INSTANT+char(100)+char(100));
   //  subject = subject.substring(32, subject.length());
   //}
   // mails.add(subject+"\t"+INSTANT+char(100)+char(100));

   //mails.add(" \t"+INSTANT+char(48)+char(48));

   //println(items[0].substring(0, items[0].indexOf('<')));
   //for (int j=1; j<items.length; j++) {
   //  mails.add(cleanUp(items[j], true));
   //}
// }
// }
}
char DEC_POINT = 47;
char DEGREE = 135;//char(29);
char SINGLE_QUOTE = PApplet.parseChar(5);
char DOUBLE_QUOTE = PApplet.parseChar(34);
char DECIMAL_POINT = 14;
char BAR_TOP = PApplet.parseChar(0);
char BAR_MIDDLE = '-';
char BAR_BOTTOM = PApplet.parseChar(3);
char EQ_LOW = '_';
char EQ_MID = '=';
char EQ_HIGH = PApplet.parseChar(135);
char EQ_OFF = ' ';

int currentFont = 0;

int foreground, background, top, bottom;
boolean gradient;

final int SYSTEM5x7 = 0;
final int COM8x8 = 1;
final int FONT10x14 = 2;
final int FONT20x28 = 3;
final int ARIAL14 = 4;
final int ARIALB14 = 5;
final int ARIALB16 = 6;

int[] widths =  {5, 8, 10, 20, 7, 7, 8};
int[] heights = {7, 8, 14, 28, 14, 14, 16};

final int BLANK = 0;
final int FOREGROUND = 1;
final int BACKGROUND = 2;
final int STRING = 3;
final int SYMBOL = 4;
final int BITMAP = 5;
final int DIGIT = 6;
final int CHARTABLE = 7;
final int FONT = 8;
final int DIRECTORY = 9;
final int SERVO = 10;
final int GRID = 11;
final int COPY_PIXELS = 12;
final int COPY_BYTES = 13;
final int COPY_GRADIENT = 14;
final int GRADIENT = 15;

final int LOADING = 15;

final int BATTERY = 17;
final int AXIS = 18;
final int DRIVE = 20;
final int EXTRA2 = 21;
final int BALL = 22;
final int RAIN = 23;
final int SNOW = 24;

final int WIDTH = 128;
final int HEIGHT= 128;

class Oled {
  final int FILL = 0;
  // color c;
  int w = 128;
  int h = 128;
  float f = 9;
  boolean gradient;

  PGraphics display;

  byte r, g, b;

  Oled () {
    foreground = whiteColor;
    background = redColor;
    top = 0;
    bottom = 0;
    display = createGraphics(128, 128, JAVA2D);
    display.noSmooth();
    display.beginDraw();
    display.background(background);
    display.endDraw();
  }

  public void display() {
    // println("display");
    // oled.display.beginDraw();
    // oled.display.smooth();
    // //oled.display.background(255);
    // oled.display.endDraw();
    // r = (byte)red(c);
    // g = (byte)green(c);
    // b = (byte)blue(c);


    //r = (byte)map(red(c),0,255,0,31);
    //g = (byte)map(green(c),0,255,0,15);
    //b = (byte)map(blue(c),0,255,0,31);
    // fill(c);
    // noStroke();
    //rect(0, 0, w, h);
    // textAlign(CENTER, CENTER);
    // fill(255);
    // textSize(16);

    image(display, 0, 0);
    switch(channel) {
      //case CONTACTS:
      //  image(contactImg, 0, 0); 
      //  fill(255);
      //  noStroke();
      //  scale(1.14);
      //  shape(frame, 0, 0);

      //  break;
      //default:
      //  text("teleobjects", 0, 0);
      //}
    }
  }

  public void printImage(String thisImageName, int thisX, int thisY) {
    PImage img;
    // img = loadImage(thisImageName);
    // if (img == null) {
      img = loadImage("data/png/"+thisImageName+".png");
    // }
    display.beginDraw();
    display.imageMode(CORNER);
    if (img!=null) display.image(img, thisX, thisY-img.height);
    display.fill(background);
    display.translate(64, 64);
    display.scale(1.14f);
    display.shape(frame, 0, 0);
    display.endDraw();
  }

  public void printString(String thisString, boolean mono, boolean center, int thisFont, int thisX, int thisY) {
    display.beginDraw();
    display.rectMode(CENTER);
    display.fill(background);
    display.noStroke();
    display.textFont(fonts[thisFont], fontSizes[thisFont]);
    if (center) {
      // display.rect(64, 128-thisY-heights[thisFont]/2, 128, heights[thisFont]);
      display.textAlign(CENTER, BOTTOM);
      display.fill(foreground);
      display.text(thisString, 64, thisY);
    } else {
      // display.rect(thisX, 128-thisY-heights[thisFont]/2, 128, heights[thisFont]);
      display.textAlign(LEFT, BOTTOM);
      display.fill(foreground);
      display.text(thisString, thisX, thisY);
    }
    display.endDraw();
  }
}

public void printBlank() {
  if (oled.gradient) {
    oled.display.beginDraw();
    for (int i = 0; i < HEIGHT; i++) {
      float inter = map(i, 0, HEIGHT, 0, 1);
      int c = lerpColor(top, bottom, inter);
      oled.display.stroke(c);
      oled.display.line(0, i, HEIGHT, i);
    }
  } else {
    oled.display.endDraw();
    oled.display.beginDraw();
    oled.display.background(background);
    oled.display.endDraw();
  }
  writeString(str(BLANK));
}

public void printGrid() {
  writeString(str(GRID));
}

public void printMask() {
  // writeString("B");
  // oled.display.beginDraw();
  // oled.display.background(background);
  // oled.display.endDraw();
}

public void printBackground(int c) {
  writeString(str(BACKGROUND)+PApplet.parseChar((byte)(red(c)/8)+48)+PApplet.parseChar((byte)(green(c)/4)+48)+PApplet.parseChar((byte)(blue(c)/8)+48));
  background = color(red(c), green(c), blue(c)); 
  oled.gradient = false;
}

public void printForeground(int c) {
  writeString(str(FOREGROUND)+PApplet.parseChar((byte)(red(c)/8+48))+PApplet.parseChar((byte)(green(c)/4)+48)+PApplet.parseChar((byte)(blue(c)/8)+48));
  foreground = c;
  // oled.display.beginDraw();
  // oled.display.fill(foreground);  
  // oled.display.endDraw(); 
}

public int printString(String str, boolean mono, boolean center, int thisFont, int thisX, int thisY) {
  boolean alpha = true;
  int charWidth = 0;
  charWidth = PApplet.parseInt(WIDTH/widths[thisFont])-4;
  // if (mono) {
  //   charWidth = int(WIDTH/widths[thisFont])-4;
  // } else {
  //   charWidth = int(WIDTH/widths[thisFont])-4;
  // }
  if (str != null) {
    while (str.length() > 0) {
      int nextLineW = str.length () > charWidth ? charWidth : str.length();  
      nextLineW = str.length();
      writeString(str(STRING)+PApplet.parseChar((mono ? 1 : 0)+48)+PApplet.parseChar((center ? 1 : 0)+48)+PApplet.parseChar(thisFont+48)+PApplet.parseChar(thisX+48)+PApplet.parseChar(thisY+48)+str.substring(0, nextLineW));
      oled.printString( str.substring(0, nextLineW),  mono,  center,  thisFont,  thisX,  thisY);
      str = str.substring(nextLineW, str.length());
      thisY = thisY - heights[thisFont];
    }
  }
  return thisY + heights[thisFont];
}

public void printGradient(int c1, int c2) {
  top = c1;
  bottom = c2;
  oled.display.beginDraw();
  for (int i = 0; i < HEIGHT; i++) {
    float inter = map(i, 0, HEIGHT, 0, 1);
    int c = lerpColor(top, bottom, inter);
    oled.display.stroke(c);
    oled.display.line(0, i, HEIGHT, i);
  }
  oled.display.endDraw();
  String str = "";
  for (int row = 0 ; row < WIDTH; row = row + 2) {
    int c = oled.display.get(1,row);
    str += PApplet.parseChar((byte)(red(c)/8)+48);
    str += PApplet.parseChar((byte)(green(c)/4)+48);
    str += PApplet.parseChar((byte)(blue(c)/8)+48);
  }
  writeString("" + PApplet.parseChar(COPY_GRADIENT+48) + str);
  // writeString("" + char(GRADIENT+48));
  oled.gradient = true;

}

public void printSymbol(int img, int thisX, int thisY) {
  writeString(""+SYMBOL+PApplet.parseChar(thisX+48)+PApplet.parseChar(thisY+48)+PApplet.parseChar(img+48));
}

public void printImage(String img, int thisX, int thisY) {
  oled.printImage(img, thisX, thisY);
  if (img.length() > 11) {
    img = "/FACE/"+img.substring(0, 6).toUpperCase()+"~1.BMP";
  }
  writeString(""+BITMAP+PApplet.parseChar(thisX+48)+PApplet.parseChar(thisY+48)+img);
}

public void printAlphabet(boolean mono, int f, int x, int y) {    
  writeString(""+CHARTABLE+PApplet.parseChar((mono ? 1 : 0 )+48)+PApplet.parseChar(f+48)+PApplet.parseChar(x+48)+PApplet.parseChar(y+48));
}

public void printServo(int a) {
  writeString(""+PApplet.parseChar(SERVO+48)+PApplet.parseChar(a+48));
}

PGraphics tile2;
public void printSymbol(PShape shp, int x, int y, int w, int h, float s, boolean alpha) {
 tile2 = createGraphics(w*2, h*2);
 tile2.noSmooth();
 tile2.beginDraw();
 tile2.background(255);
 tile2.fill(0);
 tile2.noStroke();
 tile2.translate(w, h);
  // tile.scale(shp.width/w);
  tile2.scale(.58f*2);
  tile2.shape(shp, 0, 0);
  tile2.endDraw();


  tile = createGraphics(w, h);
  tile.noSmooth();
  tile.beginDraw();
  tile.background(255);
  // tile.fill(0);
  // tile.noStroke();
  // tile.translate(w/2, h /2);
  // // tile.scale(shp.width/w);
  // tile.scale(.55);
  // tile.shape(shp, 0, 0);

  tile.imageMode(CENTER);
  tile.translate(w/2,h/2);
  tile.scale(s/2);
  tile.image(tile2, 0,0);
  tile.endDraw();
  printBytes(x, y, w, h, alpha);
}

public void printCharacter(char c, int x, int y, int w, int h, int f, int s, boolean alpha) {
  tile = createGraphics(w,h, JAVA2D);
  tile.noSmooth();
  tile.beginDraw();
  tile.background(255);
  tile.fill(0);
  tile.noStroke();
  tile.textAlign(CENTER, CENTER);
  tile.textFont(fontBold);
  tile.textSize(s);
  tile.text(PApplet.parseChar(c), (w/2)-1, (h/2)-2);
  tile.endDraw();
  printBytes(x, y, w, h, alpha);
}

PGraphics tile;

// void printCharacter(char c, int w, int y, int f, int s) 

public void printBytes(int x, int y, int w, int h, boolean alpha) {
  String str = "";
  for (int row = 0 ; row < w; row ++) {
    for (int byte_ = 0; byte_ < PApplet.parseInt(w/8); byte_ ++) {
      String thisByte = "";
      for (int bit = 7 ; bit >= 0; bit --) {
        int column = (byte_*8)+bit;
        thisByte += tile.get(column, row) == color(0) ? "1" : "0";
      }
      int newVal = unbinary(thisByte);
      str += PApplet.parseChar(newVal);
    }
  }
  writeString("" + PApplet.parseChar(COPY_BYTES+48) + PApplet.parseChar(x+48) + PApplet.parseChar(y+48) + PApplet.parseChar(w+48) + PApplet.parseChar(h+48) + (alpha ? '1' : '0') + "\n" + str);
}

public void printPixels(int x, int y, int w, int h) {
  String str = "";
  for (int row = 0 ; row < w; row ++) {
    for (int column = 0 ; column < h; column ++) {
      str += random(10)<5 ? "0" : "1";
    }
  }
  writeString(""+ PApplet.parseChar(COPY_PIXELS+48)+ PApplet.parseChar(x+48) +PApplet.parseChar(y+48)+PApplet.parseChar(w+48)+PApplet.parseChar(h+48)+str);
  println(str.length());
}

public void printFont(int f) {
  writeString(""+FONT+PApplet.parseChar(f+48));
  oled.display.beginDraw();
  oled.display.textFont(fonts[f]);
  oled.display.endDraw();
}

public void printDirectory(String thisString) {    
  writeString(""+DIRECTORY+thisString);
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
  // writeString("", LOADING, 1, 1, 1);
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
  // setPilot("sleep", channel==SLEEP);
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
  // setPilot("eq", "R "+nf((int)(rightL*1000), 3, 0)+"\nL "+nf((int)(leftL*1000), 3, 0));

  // if (channel == CONTACTS && profileImage != null) {
  //   pushMatrix();
  //   translate(getPilot("contacts").x, getPilot("contacts").y-100);
  //   pushMatrix();
  //   scale(.822);
  //   scale(96.0/profileImage.height*1.0);

  //   image(profileImage, 0, 0);
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
ArrayList dweets;
Dweet latestDweet;
float dweetA, dweetTargetA = 0;
String lastCreated = "";
boolean dweeted;
long lastDweet;
String teleobject = "mailbox";
String thing = "teleobjects";

public void initThing() {
  latestDweet = new Dweet();
  dweets = new ArrayList();
}

// void getDweet() {
//   long pingStart = millis();
//   String thing= "teleobjects";
//   String url = "https://thingspace.io/get/latest/dweet/for/"+thing;
//   // println("getting dweet");
//   String[] buffer = loadStrings(url);
//   if (buffer != null) {
//     latestDweet.parse(buffer[0], true);
//     if (!lastCreated.equals(latestDweet.created_)) {
//       println(buffer);
//       lastCreated = latestDweet.created_;
//       pingTime = int(millis()-pingStart);

//       boolean flag = true;

//       for (int i=0; i<latestDweet.properties.size(); i++) {
//         String property = latestDweet.properties.get(i);
//         if (property.equals("teleobject")) {
//           String teleobject_ = latestDweet.values.get(i);
//           if (teleobject_.equals(teleobject)) {
//             println("sent by my self"); 
//             flag = false;
//           }
//         }

//         // if (property.equals("NEWS")&& true) {
//         //   if (debug) println("news");
//         //   String content = latestDweet.values.get(i);
//         //   String[] items = splitTokens(content, "|");
//         //   String img = items[1];
//         //   display.imagery = requestImage(img);
//         //   display.mode = IMAGERY;
//         //   lastTilt = 0;
//         // }
//       }
//       if (flag) {
//         println("good dweet");
//         dweeted = true;
//         dweetA = 255;
//       }
//     }
//   }
// }

// void sendDweet(String key_, String value_) {
//   long pingStart = millis();
//   String url = "https://thingspace.io/dweet/for/"+thing+"?"+"teleobject="+teleobject+"&"+key_+"="+encode(value_);
//   String[] buffer = loadStrings(url);
//   println(url);
//   if (buffer != null) {
//     latestDweet.parse(buffer[0], false);
//     pingTime = int(millis()-pingStart);
//     dweetA = 255;
//   }
// }

public void displayDweet(float thisX, float thisY) {
  // dweetA += (dweetTargetA - dweetA)*.01;
  // if (latestDweet.info != null) {
  //   pushMatrix();
  //   translate(thisX, thisY);
  //   textAlign(LEFT);
  //   textFont(fontBold, 20);
  //   fill(redColor, dweetA);
  //   text(latestDweet.info, 0, 0);
  //   popMatrix();
  // }
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
        content_ += removeBrackets(properties_[i])+"|"+ removeBrackets(withContent.getString(properties_[i]))+"|";
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
  currentTimeStamp = d.getTime();
  startTimeStamp = currentTimeStamp;
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

public String cleanUp(String str, boolean capitalize) {
  if (capitalize) str = str.toUpperCase();
  return cleanUp(str);
}

public String cleanUp(String str) {
  String res = "";
  for (int i=0; i<str.length(); i++) {
    char ch = str.charAt(i);
    if (ch > 31 && ch < 128) {
      res += ch;
    } 

    if (ch =='\u00e1' || ch == '\u00e2' || ch == '\u00e5')  res += 'a';
    if (ch =='\u00e9' || ch == '\u00ea' || ch == '\u00eb')  res += 'e';
    if (ch =='\u00ed' || ch == '\u00ea' || ch == '\u00ef')  res += 'i';
    if (ch =='\u00f3' || ch == '\u00f4' || ch == '\u00f6' || ch == '\u00f8')  res += 'o';
    if (ch =='\u00fa' || ch == '\u00fb' || ch == '\u00fc')  res += 'u';
  }
  return res;
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
  str = trim(str);
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
    result +=  ":";
    String minute_ = nf(minute(), 2, 0);
    result += minute_.charAt(0);
    result += minute_.charAt(1);
    result += ":";
    String second_ = nf(second(), 2, 0 );
    result += second_.charAt(0);
    result += second_.charAt(1);
    if (hour() >= 12) {
      result += "PM";
    } else {
      result += "AM";
    }
  }   else {
    String hour_ = nf(hour(), 2, 0);
    result += hour_.charAt(0);
    result +=  hour_.charAt(1);
    result +=  ".";
    String minute_ = nf(minute(), 2, 0);
    result += minute_.charAt(0);
    result += minute_.charAt(1);
    result += ".";
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
    weathers = new ArrayList();
    String[] weatherContent = null;
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
      println(weatherUrl);
      weatherContent = loadStrings(weatherUrl);
      if (weatherContent != null) {
        //saveStrings("weather.json", weatherContent);
        weatherUpdated = currentTimeStamp;
      }
    }
    if (weatherContent != null) {
      String weatherFragment = weatherContent[0];
      JSONObject weatherJSON = JSONObject.parse(weatherFragment);
      JSONArray weatherArray = weatherJSON.getJSONArray("weather");
      JSONObject weather= weatherArray.getJSONObject(0);
      condition = weather.getString("description");
      conditionMain = weather.getString("main");
      JSONObject main = weatherJSON.getJSONObject("main");
      temp = main.getFloat("temp");
      humidity = main.getFloat("humidity");
      pressure = main.getFloat("pressure");
      JSONObject cloudsData = weatherJSON.getJSONObject("clouds");
      clouds = cloudsData.getFloat("all");
      if (weatherJSON.hasKey("wind")) {
        JSONObject windData = weatherJSON.getJSONObject("wind");
        windSpeed =  windData.getFloat("speed");
        if (windData.hasKey("deg")) {
          windDeg = windData.getFloat("deg");
        }
        if (windData.hasKey("gust")) {
          windGust = windData.getFloat("gust");
        }
      }
      if (weatherJSON.hasKey("rain")) {
        JSONObject rainData = weatherJSON.getJSONObject("rain");
        //rain = rainData.getFloat("3h");
      }
      if (weatherJSON.hasKey("clouds")) {
        JSONObject cloudData = weatherJSON.getJSONObject("clouds");
        clouds = cloudData.getFloat("all");
      }
      forecasted = true;
    }
    if (!forecasted) {
      weathers.add(cleanUp("No weather info..."));
    } else {
      weathers.add(cleanUp(condition+" in "+neighbourhood, true));
      weathers.add(cleanUp("It's "+nf(metric ? getCelcius(temp) : temp, 0, 1) + (metric ? PApplet.parseChar(DEGREE)+"C" : PApplet.parseChar(29)+"F"), true));
      weathers.add(cleanUp(PApplet.parseInt(humidity)+"% humid", true));
      weathers.add(cleanUp("Pressure "+PApplet.parseInt(pressure), true)+"hPa");
      weathers.add(cleanUp(PApplet.parseInt(clouds)+"% cloudy", true));
      weathers.add(cleanUp("Wind "+PApplet.parseInt(windSpeed), true)+"m/h "+cleanUp((int)windDeg+"\u00b0 "+getHeading(windDeg)));
    }
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
    String[] appletArgs = new String[] { "tele_mailbox_java" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
