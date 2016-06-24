
color whiteColor = color (255, 255, 255);
color redColor = color(190, 30, 45);
color backgroundColor = 200;
PFont font;//, fontBold, fontMono, fontMonoBold;

PShape outline, outline_mask, app, mask;


class Gui {
  boolean refresh = true;
  float cW = 1600;
  float rot, targetRot;
  int debounce = 500;
  long lastClick;
  boolean clicked;
  ArrayList<Packet> packets;

  Gui () {
  }

  void init() {
    app = loadShape("shp/app.svg");
    app.disableStyle();
    outline = loadShape("shp/comment.svg");
    outline.disableStyle();
    // outline_mask = loadShape("shp/ticker_mask.svg");
    // outline_mask.disableStyle();
    mask = loadShape("shp/mask.svg");
    mask.disableStyle();
    font = createFont("Monospaced", 32);

    initPilots();
    packets = new ArrayList<Packet>();
  }

  void update() {
    pushMatrix();
    scale(width/cW);
    // PILOTS
    checkPilots();
    if (refresh) {
      background(backgroundColor);
    } else {
      if (debug) {
        rectMode(CORNER);
        fill(backgroundColor);
        rect(0, 112, width, 292);
        rect(0, (height/2)+24, width, 292);
      }
    }
    displayPilots();
    // PACKETS
    if (debug) {
      displayPackets();
    }
    popMatrix();
    // OBJECT
    pushMatrix();
    translate(width/2, height/2);
    scale(width/cW);
    translate(0, -48);
    scale(1.2);
    if (refresh || debug) {
      strokeWeight(2.5);
      stroke(0);
      fill(255);
      shape(outline, 0, 0);
      // fill(backgroundColor);
      // shape(outline_mask, 0, 0);
    } else {
      rectMode(CENTER);
      fill(255);
      noStroke();
      rect(0, 35, 1120, 50);
    }
    matrix.display();
    // DWEETS
    //if (debug) {
      if (messaging != null) {
        messaging.displayDweet(-596, 150);
      }
    //} 
    popMatrix();

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
  println("key pressed");
  if (key >= 48 && key <= 58) {  
    setChannel(key-48);
  }
  if (key >= 65 && key <= 65+28) {
    setChannel(key-48);
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