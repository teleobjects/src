PFont font, fontBold, fontMono, fontMonoBold;

float rot, targetRot;
PShape outline, outline_mask, app, mask;

float cW = 1600;
// float cH = 900;
color whiteColor = color (255, 255, 255);
color redColor = color(190, 30, 45);
color backgroundColor = 200;

int debounce = 500;
long lastClick;
boolean clicked;

void initGui() {
  app = loadShape("shp/app.svg");
  app.disableStyle();
  outline = loadShape("shp/ticker.svg");
  outline.disableStyle();
  outline_mask = loadShape("shp/ticker_mask.svg");
  outline_mask.disableStyle();
  mask = loadShape("shp/mask.svg");
  mask.disableStyle();
  font = createFont("Monospaced", 64);
  fontBold = createFont("Monospaced", 64);
  fontMono = createFont("Monospaced", 64);
  fontMonoBold =  createFont("Monospaced", 64);
  initPackets();
}

void displayGui() {
  pushMatrix();
  scale(width/cW);
  // PACKETS
  if (debug) {
    displayPackets();
  }
  // PILOTS
  checkPilots();
  if (refresh) {
    background(backgroundColor);
    displayPilots();
  }
  popMatrix();
  // OBJECT
  pushMatrix();
  translate(width/2, height/2);
  scale(width/cW);
  translate(0, -48);
  targetRot = radians(ay+90+4);
  rot += (targetRot-rot)*.1;
  if (channel == AXIS) {
    rotate(-rot);
  }
  scale(1.2);
  if (refresh) {
    strokeWeight(3);
    stroke(0);
    fill(255);
    shape(outline, 0, 0);
    fill(backgroundColor);
    shape(outline_mask, 0, 0);
  } else {
    rectMode(CENTER);
    fill(255);
    noStroke();
    rect(0, 35, 1120, 50);
  }
  alpha.display();
  // PORT NAME
  if (debug || true ) {
    fill(backgroundColor);
    rectMode(CORNER);
    rect(-596, 100, 500, 200);
    fill(50);
    textFont(font, 18);
    textAlign(LEFT, TOP);
    text(freeMemory+"/"+maxMemory+"Mb"+"\n"+(int)frameRate+" fps\n"+width+"x"+height+"px\n"+portName+"\n"+(busy?"busy":"free"), -596, 100);
  }
  // DWEETS
  if (debug) {
    displayDweet(-596, 150);
  } 
  popMatrix();
}

void keyPressed() {
  if (key >= 48 && key <= 58) {  
    setChannel(key-48);
  }
  if (key >= 65 && key <= 65+28) {
    setChannel(key-48);
  }
}

void mousePressed() {
  if (millis()-lastClick > debounce) {
    lastClick = millis();
    clicked = true;
  }
}

void mouseReleased() {
  clicked = false;
}

ArrayList<Packet> packets ;

void initPackets() {
  packets = new ArrayList();
}

void displayPackets() {
  if (!refresh) {
    fill(backgroundColor);
    rect(getPilot("bluetooth").x-50, 112, 100, 292);
  }
  for (int i =0; i<packets.size(); i++) {
    packets.get(i).display();
  }
  for (int i =0; i<packets.size(); i++) {
    if (i<packets.size()) {
      if (packets.get(i).loc.z < 3) packets.remove(i);
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
    loc = new PVector (x_+(in?40:0)-20, in ? 400 : 118, 255);
    targetLoc = new PVector (x_+(in?40:0)-20, in ? 118 : 400, 0);
    if (packets.size() < 10) {
      packets.add(this);
    }
  }

  void display() {
    loc.x = attract(loc.x, targetLoc.x, .08, 2);
    loc.y = attract(loc.y, targetLoc.y, .08, 2);
    loc.z = attract(loc.z, targetLoc.z, .08, 2);
    fill(in ? whiteColor : redColor, loc.z);
    ellipseMode(CENTER);
    ellipse(loc.x, loc.y, 15, 15);
  }
}