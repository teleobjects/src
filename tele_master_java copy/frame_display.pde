class FrameDisplay extends Display {
  PShape outline, window, mask;
  int mode = 0;
  String data = "";
  long lastTick;
  int cursorX = 0;
  int breakX;
  int displayMode, tick, tock, tuck;
  
  int w = 128;
  int h = 128;
  float f = 9;

  color foreground, background, top, bottom;
  boolean gradient;

  int currentFont = 0;

  PGraphics display;

  FrameDisplay () {
    outline = loadShape("shp/app.svg");
    outline.disableStyle();
    mask = loadShape("shp/mask.svg");
    mask.disableStyle();
    foreground = whiteColor;
    background = redColor;
    top = 0;
    bottom = 0;
    display = createGraphics(240, 240, JAVA2D);
    display.noSmooth();
    display.beginDraw();
    display.background(background, 230);
    display.endDraw();
  }

  void update() {
  }

  void display() {
    pushMatrix();
    scale(.596);
    fill(255);
    stroke(0);
    pushMatrix();
    scale(4);
    strokeWeight(thickStroke);
    shape(outline, 0, 0);
    popMatrix();
    pushMatrix();
    scale(.74);
    image(display, 0, 0);
    popMatrix();
    pushMatrix();
    scale(1.6);
    noStroke();
    fill(255);
    shape(mask, 0, 0);
    noFill();
    stroke(0);
    strokeWeight(thickStroke*.59*1.6);
    shape(outline, 0, 0);
    popMatrix();
    popMatrix();
  }

  void printString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
  }
}