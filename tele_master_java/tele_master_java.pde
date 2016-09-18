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

void setup() {
  fullScreen(OPENGL);
  orientation(LANDSCAPE);
  androidMode = true;
  // hint(DISABLE_DEPTH_TEST);
  // size(2000, 1200, OPENGL);
  // retina = displayDensity() == 2;
  // // smooth();
  // pixelDensity(displayDensity()); 
  // androidMode = false;

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

void draw() {
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
    y = attract (y, targetY, .3, 1);      
    if (y>0) background(backgroundColor, map(y, 0, 380, 0, 255));

    pushMatrix();
    if (activeObject == null) {
      translate(width/2, (height/2) - y);
      scale(androidMode ? .9 : .68);
      ticker.display(-210, 120);
      //comment.display(-400, -200);
      //mailbox.display(-960, 108);
      //reel.display(750, 80);
      //frame.display(200, -218);
    } else {
      translate(width/2, (height/2) - y);
      scale(width/1220.0);
      //scale(1.3);
      activeObject.display(0, -20);
    }
    popMatrix();
    if (manager.channel == EQ) eq.display();
    gui.display();
  }
}