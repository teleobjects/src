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

boolean debug = true;
boolean verbose = true;
boolean metric = true;
boolean sync = false;
boolean retina = true;
boolean android = false;

Time time;
Gui gui;
Manager manager;
Network network;
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

Teleobject ticker;
Teleobject comment;
Teleobject mailbox;
Teleobject reel;
Teleobject frame;

Teleobject activeObject;

ArrayList<Teleobject> teleobjects;

void setup() {
  size(displayWidth, 700, OPENGL);
  frameRate(60);
  retina = displayDensity() == 2;
  pixelDensity(displayDensity()); 
  // fullScreen();
  // orientation(LANDSCAPE);

  gui = new Gui();
  gui.init();

  time = new Time();
  network = new Network();
  geolocation = new Geolocation();
  weather = new Weather();
  places = new Places();
  eq = new Eq(this);
  messaging = new Messaging();

  google = new Google();
  profile = new Profile();
  mail = new GoogleMail();
  contacts = new GoogleContacts();
  calendar = new GoogleCalendar();
  drive = new GoogleDrive();

  news = new News();

  twitter = new Twitter();

  teleobjects = new ArrayList<Teleobject>();

  manager = new Manager();

  ticker = new Ticker(this);
  ticker.name = "ticker";
  ticker.init();

  comment = new Comment(this);
  comment.name= "comment";
  comment.init();

  mailbox = new Mailbox(this);
  mailbox.name = "mailbox";
  mailbox.init();

  reel = new Reel(this);
  reel.name = "reel";
  reel.init();

  frame = new Frame(this);
  frame.name = "frame";
  frame.init();

  teleobjects.add(ticker);
  teleobjects.add(comment);
  teleobjects.add(mailbox);
  teleobjects.add(reel);
  teleobjects.add(frame);

  activeObject = ticker;
  // google.login();
}

void draw() {
  if (google.authenticating || twitter.authenticating) {
    background(redColor);
    if (gui.clicked) {
      gui.clicked = false;
      if (google.authenticating) {
        google.login();
        manager.setChannel(GOOGLE);
      } 
      else if (twitter.authenticating) {
        twitter.login();
        manager.setChannel(TWITTER);
      }
    }
  } 
  else {

    updateSensors();                 
    time.update();
    eq.update();

    manager.update();
    gui.update();

    // weather.update();

    ticker.update();
    // mailbox.update();
    // comment.update();
    // reel.update();
    // frame.update();

    if (activeObject == null) {
      translate(width/2, height/2);
      scale(.7);
      ticker.display(-210, 120);
      mailbox.display(-960, 108);
      comment.display(-400, -200);
      reel.display(740, 80);
      frame.display(200, -220);
    } 
    else {
      translate(width/2, height/2);
      scale(width/1600.0);
      activeObject.display(0, -70);
    }
  }
}