class Teleobject {
  PApplet parent;
  String name;
  Comm comm = null;
  Display display;
  ArrayList<Page> pages = new ArrayList<Page>();
  int pageIndex = -1;
  int lastPageIndex = -1;
  long lastPage;
  int pageDelay = 2000;
  boolean newPage;
  int channel;
  boolean ready;
  boolean direction;
  boolean manual;

  void init() {
  }

  void update() {
    if (comm != null) {
      if (comm.connected && comm.connecting) { 
        comm.connecting = false;
        manager.setChannel(HELLO);
        manager.loop = false;
      }

      if (comm.connected) {
        comm.update();
        // if (millis() < lastPage) comm.busy = true;  // to get rid of bouncing packets!!! check delay with bluetooth!
        if (comm.busy) {
          lastPage = millis();
        } 
        else {
          ready = true;
        }
      } 
      else {
        if (display.busy) {
          lastPage = millis();
        } 
        else {
          ready = true;
        }
      }
    }
    // checkSensors();
    if (comm.battery > 3.00 && comm.battery < 3.40) channel = BATTERY;
    play();
  }

  void play() {
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
          if ((manager.loop && pages.size() > 1) || manager.channel == EQ || manager.channel == TIME || manager.channel == ORIENTATION) {
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

  void initPages(int _channel) {
    pages = new ArrayList<Page>();
    // if (_channel != channel) newPage = true;
    channel = _channel;
    lastPageIndex = -1;
    pageIndex = 0;
  }

  void nextPage() {
    lastPage = pageIndex;
    pageIndex++;
    if (pageIndex == pages.size()) pageIndex = 0;
    ready = true;
    manual = true;
    direction = true;
    pageDelay = 0;
    play();
  }

  void previousPage() {
    lastPage = pageIndex;
    pageIndex--;
    if (pageIndex < 0) pageIndex = pages.size()-1;
    ready = true;
    manual = true;
    direction = false;
    pageDelay = 0;
    play();
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

  void writeString(String content, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
    if (content.length() > 256 - comm.headerLength - 2) content = content.substring(0,256-comm.headerLength-2); // restrict content to buffer size
    if (content.length() == 128 - comm.headerLength - 1) content += " "; // avoid packets of 127, they crash, hack!!!

    content = display.cleanUp(content);
    comm.writeString(content, thisMode, tack, teck, tick, tock, tuck);
    display.printString(content, thisMode, tack, teck, tick, tock, tuck);
    // if (name.equals("ticker") && channel != ENERGY && channel != HELLO && channel != BYE) {
    //   reel.pages.add(new Page("", INSTANT, 1, 10, content.length()/2, 0, 0));
    // }
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


class Mailbox extends Teleobject {
  Mailbox(PApplet _parent) {
    parent = _parent;
    // num = _num;
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
  Reel(PApplet _parent) {
    parent = _parent;
    // num = _num;
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
  Frame(PApplet _parent) {
    parent = _parent;
  }

  void init() {
    display = new FrameDisplay();
  }
}

class Display {
  boolean busy;

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

  char getEqChar(int val) {
    return ' ';
  }
}