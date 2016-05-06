boolean dweet, usb, bluetooth, wifi, paired, connecting, connected, ready, online, located, found, forecasted, placed, loggedin, loading, logging, logged, metric = true;
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
boolean android = true;

void setup() {
  //println(PFont.list());
  //size(1600, 900);
  if (android) {
    //fullScreen();
    bluetooth = true;
    orientation(LANDSCAPE);
  }
  //
  rectMode(CENTER);
  imageMode(CENTER);
  //smooth();
  //frameRate(24);
  initTime();
  initComm();
  initGui();
  initPilots();
  initDisplay();
  //initWifi();
  //initOnline();
  initThing();
  initLocation();
  initPlaces();
  initContacts();
  //initMail();
  //initTwitter();
  //initNews();
  initMic();
  pages = new ArrayList();
  pages.add("");
}


void draw() {

  
  updateComm();

  if (android) {
    if (location == null) {
      try {
        location = new KetaiLocation(this);
        location. setUpdateRate(1000, 1);
      } 
      catch (Exception e) {
        println("error");
      }
    }
  }
  
  
  /// OSX
  if (!android) {
    //if (connecting);// && millis() - startTime > 1000) {
    //  connectimh
    //  connected = true;
    //}
    if (connected) {
      rx();
    }
  }

  if (!connected) busy = alpha.busy; /// simulator

  if (channel == EQ || channel == AXIS) refresh = true;
  displayGui();
  updateMic();
  refresh = false;
  play();
}