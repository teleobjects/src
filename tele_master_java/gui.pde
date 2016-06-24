
color whiteColor = color (255, 255, 255);
color redColor = color(190, 30, 45);
color backgroundColor = 200;
PFont font;//, fontBold, fontMono, fontMonoBold;

PShape app, mask;

float thick = 3;

class Gui {
  boolean refresh = true;
  float rot, targetRot;
  int debounce = 500;
  long lastClick;
  boolean clicked;
  ArrayList<Packet> packets;

  Gui () {
  }

  void init() {
    imageMode(CENTER);
    app = loadShape("shp/app.svg");
    app.disableStyle();

    mask = loadShape("shp/mask.svg");
    mask.disableStyle();
    font = createFont("Monospaced", 32);

    initPilots();
    packets = new ArrayList<Packet>();
  }

  void update() {
    pushMatrix();
    scale(width/1600.0);

    // PILOTS
    refresh = true;
    checkPilots();
    if (refresh) {
      background(backgroundColor);
      } else {
      //if (debug) {
      //  rectMode(CORNER);
      //  noStroke();
      //  fill(backgroundColor);
      //  rect(0, 112, width, 120);
      //  rect(0, (height/2)+194, width, 120);
      //}
    }
    displayPilots();

    // PACKETS
    if (debug) {
      displayPackets();
    }
    popMatrix();

    // DWEETS
    if (messaging != null && debug) {
      messaging.displayDweet(250, 630);
    }

    if (android) {
      refresh = false;
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

void keyPressed() {
  switch (key) {
    case '0':
    activeObject = null;
    break;
    case '1':
    activeObject = ticker;
    break;
    case '2':
    activeObject = comment;
    break;
    case '3':
    activeObject = mailbox;
    break;
    case '4':
    activeObject = reel;
    break;
    case '5':
    activeObject = frame;
    break;
  }
  if (key >= 48 && key <= 58) {  
    //ticker.editor.setChannel(key-48);
  }
  if (key >= 65 && key <= 65+28) {
    //ticker.editor.setChannel(key-48);
  }
}

void mousePressed() {
  if (millis()-gui.lastClick > gui.debounce) {
    gui.lastClick = millis();
    gui.clicked = true;
  }
}

void mouseReleased() {
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

  void display() {
    loc.x = attract(loc.x, targetLoc.x, .08, 5);
    loc.y = attract(loc.y, targetLoc.y, .08, 5);
    loc.z = attract(loc.z, targetLoc.z, .08, 5);
    noStroke();
    fill(in ? whiteColor : redColor, loc.z);
    ellipseMode(CENTER);
    ellipse(loc.x, loc.y, 15, 15);
  }
}