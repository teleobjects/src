
PFont font, fontBold, fontMono, fontMonoBold;

PFont fonts[];
int fontSizes[];

String info = "";
PShape outline, window, app, mask, frame;

PImage digits128;

float cW = 1600;
float cH = 900;

// color redColor = color(190, 30, 45);
color redColor = color(255, 0, 0);
color whiteColor = color(255, 255, 255);
color backgroundColor = 200;

PGraphics wheel;

boolean clicked;

Wheel bWheel, fWheel;

int debounce = 500;
long lastClick;

Oled oled;

void initGui() {
  font = createFont("Helvetica", 64);
  fontBold = createFont("Helvetica-Bold", 64);
  fontMono = createFont("Courier", 64);
  fontMonoBold =  createFont("Courier-Bold", 64);
  outline = loadShape("shp/mailbox.svg");
  outline.disableStyle();
  mask = loadShape("shp/mask.svg");
  mask.disableStyle();
  app = loadShape("shp/app.svg");
  app.disableStyle();
  window = loadShape("shp/window.svg");
  window.disableStyle();
  frame = loadShape("shp/mask.svg");
  frame.disableStyle();
  bWheel = new Wheel();
  fWheel = new Wheel();
  //digits128 = loadImage("bmp/digits128.png");

  PFont tmp[]  = {fontMono, fontMonoBold, fontBold, fontBold, font, fontBold, fontBold};
  fonts = tmp;
  int temp2[] = {9, 10, 16, 36, 13, 13, 15};
  fontSizes = temp2;


  oled = new Oled();
}

// void displayWheel(float x, float y, float s) {
//   pushMatrix();
//   translate(x, y);
//   textAlign(CENTER, CENTER);
//   textSize(10);
//   text("R"+red(oled.c)+" G"+green(oled.c)+" B"+blue(oled.c), 50, 110);
//   scale(s);
//   image(wheel, 0, 0);
//   popMatrix();
// }

void displayGui() {
  background(backgroundColor);

  pushMatrix();
  if (tile != null)
    image(tile, 100,600);

  if (tile2 != null)
    image(tile2, 300,600);
  fWheel.c = foreground;
  bWheel.c = background;

  bWheel.display(100,200, .2);
  fWheel.display(100,400, .2);

  scale(width/cW);


  // DWEETS
  // displayDweet(1000, 740);

  // PILOTS
  checkPilots();
  displayPilots();

  popMatrix();

  // OBJECT
  pushMatrix();
  translate(width/2, height/2);
  scale(width/cW);
  // scale(1.5);

  pushMatrix();
  translate(0, 60);
  oled.display();
  popMatrix();
  fill(255);
  strokeWeight(2);
  stroke(0);
  shape(mask, -mask.width/2, -mask.height/2);
  fill(50);
  textFont(font, 12);
  textAlign(LEFT, TOP);
  text(portName, -100, 180);
  popMatrix();
}

void updateColors() {
  foreground = fWheel.c;
  background = bWheel.c;
  printForeground(foreground);
  // printBackground(background);
}

class Wheel {
  PGraphics g;
  color c;
  float cx = 0, cy = 0;

  Wheel() {
    g = createGraphics(512, 512);
    g.beginDraw();
    g.background(backgroundColor);
    g.smooth();
    g.noStroke();
    g.colorMode(HSB);
    g.translate(256, 256);
    saturationChanger(128, 256);
    g.endDraw();
  }

  void display(float x, float y, float s) {
    pushMatrix();
    translate(x, y);
    textAlign(CENTER, CENTER);
    textSize(10);
    scale(s);
    pushMatrix();
    translate(0,300);
    scale(6);
    text("R"+(int)red(c)+" G"+(int)green(c)+" B"+(int)blue(c), 0, 0);

    popMatrix();
    imageMode(CENTER);
    image(g, 0, 0);
    noFill();
    stroke(50,200);
    strokeWeight(1);

    popMatrix();

    ellipse(cx,cy,6,6);
    // image(g);
    if (clicked) {
      if (dist (mouseX, mouseY, x, y) < 88) {
        c = get(mouseX, mouseY);
        // clicked = false;
        cx = mouseX;
        cy = mouseY;
        updateColors();

      }
    }
  }

  void saturationChanger(int i, int initial) {
    if (i > 0) {
      colorTriangle(256, 0, initial, initial);
      saturationChanger(i-1, initial-2);
    }
  }

  void colorTriangle(int iteration, int h, int s, int height) {
    if (iteration > 0) {
      g.fill(h%256, s, 256);
      g.triangle(0, 0, 128*tan(radians(5.625/4)), height, -128*tan(radians(5.625/4)), height);
      g.rotate(radians(5.625/4));
      colorTriangle(iteration-1, h+1, s, height);
    }
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

void keyPressed() {
  if (key >= 48 && key <= 58) {  
    writeString(key+"");
  }
  if (key >= 65 && key <= 65+28) {
    //mode = key - 48;
    writeString(key+"");
  }

  switch (key) {
    case TAB:
    debug = !debug;
    break;
    case 's':
    // sendDweet("FOO", "BAR");
    break;
    case 'd':
    // updateThing();
    break;
    case ' ':
    //oled.foreground = get(mouseX, mouseY);
    printBackground(get(mouseX, mouseY));
    break;
    case '>':
    currentFont ++;
    if (currentFont == 10) currentFont = 0;
    break;
    case '<':
    currentFont --;
    if (currentFont == -1) currentFont = 9;
    break;
  }
}


ArrayList<Packet> packets ;

void initPackets() {
  packets = new ArrayList();
}

void displayPackets() {
  for (Packet packet : packets) {
    packet.display();
  }
  if (packets.size() > 20) {
    packets.remove(0);
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
    loc = new PVector (x_, in ? height/2/(width/cW) : 150, 255);
    targetLoc = new PVector (x_, in ? 150 : height/2/(width/cW), 0);
    packets.add(this);
  }

  void display() {

    loc.x = attract(loc.x, targetLoc.x, .05, 10);
    loc.y = attract(loc.y, targetLoc.y, .05, 10);
    loc.z = attract(loc.z, targetLoc.z, .05, 10);

    fill(redColor, loc.z);
    // ellipse(loc.x, loc.y, 10, 10);
    if (!android) {
      textAlign(CENTER);
      if (label != null) {
        //textFont(fontMonoBold, 12);
        text(label, loc.x, loc.y);
      }
    } else {
      ellipse(loc.x, loc.y, 10, 10);
    }
    if ((in && loc.y < 50) || (!in && loc.y>height/2)) { 
      packets.remove(this);
      // this = null;
    }
  }
}