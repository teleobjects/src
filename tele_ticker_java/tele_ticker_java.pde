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

void setup() {
  size(1600, 900);
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

void draw() {

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