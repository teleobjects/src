
color whiteColor = color (255, 255, 255);
color redColor = color(190, 30, 45);
color greenColor = color(147, 213, 48);
color orangeColor = color(255, 128, 0);
color backgroundColor = 50;
PFont font;//, fontBold, fontMono, fontMonoBold;

float thickStroke = 3;
PShape app, mask;

class Gui {
  //boolean refresh = true;
  //float rot, targetRot;
  ArrayList<Packet> packets;

  Gui () {
    init();
  }

  void init() {
    imageMode(CENTER);
    ellipseMode(CENTER);
    app = loadShape("shp/app.svg");
    app.disableStyle();
    mask = loadShape("shp/mask.svg");
    mask.disableStyle();
    textSize(16);
    initPilots();
    packets = new ArrayList<Packet>();
  }

  void display() {
    // PILOTS
    displayPilots();
    // PACKETS
    if (debug) {
      displayPackets();
    }
    // MESSAGING
    if (messaging != null && debug) {
      messaging.displayDweet(250, 630);
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

class Packet {
  PVector loc;
  PVector targetLoc;
  boolean in;
  String label;

  Packet(boolean in_, String label_, float x_) { 
    label = label_;
    in = in_;
    loc = new PVector (x_+(in?40:0)-20, in ? displayHeight/2-100 : 118, 255);
    targetLoc = new PVector (x_+(in?40:0)-20, in ? 118 : displayHeight/2-100, 0);
    if (gui.packets.size() < 20) {
      gui.packets.add(this);
    }
  }

  void init() {
  }

  void display() {
    //loc.x = attract(loc.x, targetLoc.x, .08, 5);
    loc.y = attract(loc.y, targetLoc.y, .08, 5);
    loc.z = attract(loc.z, targetLoc.z, .08, 5);
    hint(DISABLE_DEPTH_TEST);

    // hint(ENABLE_DEPTH_TEST);
    noStroke();
    fill(in ? (real ? 50 : whiteColor) : redColor, loc.z);
    ellipse(loc.x, loc.y, 15, 15);
    ellipseMode(CENTER);
    // hint(DISABLE_DEPTH_TEST);
  }
}