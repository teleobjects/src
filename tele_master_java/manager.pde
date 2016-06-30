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
final int COUNTER = 27;
final int BRIGHTNESS = 51;
final int PING = 54;
final int LOOK = 55;

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
final int JUMP = -18;
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
final int NAVIGATION = 111;
final int RESULTS = 112;


final int HELLO = 150;
final int BYE = 151;
final int SEARCH = 152;
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
  boolean loop = false;
  boolean manual = false;

  Manager () {
    String[] commandList = loadStrings("tsv/commands.txt");
    for (int i=0; i<commandList.length; i++) {
      String thisLine = commandList[i];
      if (thisLine.length() > 0) {
        String[] items = splitTokens(thisLine, " ");
        if (items.length == 5) {
          String thisCommand = items[2];
          int thisCommandNum = parseInt(items[4].substring(0, items[4].length()-1));
        }
      }
    }
  }

  void update() {
  }

  void setChannel(int thisCommand) {

    switch(thisCommand) {
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
      bluetooth.scanDevices();
      break;

    case LOGOUT:
      google.logout();
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
      } else {
        int nextObject = teleobjects.indexOf(activeObject);
        nextObject ++;
        if (nextObject == teleobjects.size()) {
          activeObject = null ;
        } else {
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
        twitter.update();
      }
      break;

    case NEWS:
      if (!news.updated) news.update();
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
    gui.refresh = true;
  }
}