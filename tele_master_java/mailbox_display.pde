class MailboxDisplay extends Display {
  PShape outline, window, mask;


  int mode = 0;
  String data = "";


  long lastTick;
  int cursorX = 0;
  int breakX;
  boolean busy;
  int displayMode, tack, teck, tick, tock, tuck;

  int w = 128;
  int h = 128;
  float f = 9;

  color foreground, background, top, bottom;
  boolean gradient;

  int currentFont = 0;


  final int SYSTEM5x7 = 0;
  final int COM8x8 = 1;
  final int FONT10x14 = 2;
  final int FONT20x28 = 3;
  final int ARIAL14 = 4;
  final int ARIALB14 = 5;
  final int ARIALB16 = 6;

  int[] widths =  {5, 8, 10, 20, 7, 7, 8};
  int[] heights = {7, 8, 14, 28, 14, 14, 16};

  PGraphics display;

  MailboxDisplay () {
    outline = loadShape("shp/mailbox.svg");
    outline.disableStyle();
    window = loadShape("shp/app.svg");
    window.disableStyle();
    mask = loadShape("shp/mask.svg");
    mask.disableStyle();

    foreground = whiteColor;
    background = redColor;
    top = 0;
    bottom = 0;
    display = createGraphics(128, 128, JAVA2D);
    display.noSmooth();
    display.beginDraw();
    display.background(background, 230);
    display.endDraw();
  }

  void update() {
  }

  void display() {
    pushMatrix();

    scale(.63);
    fill(255);
    stroke(0);
    strokeWeight(thick/.7);

    shape(outline, 0, 0);
    pushMatrix();
    scale(.85);
    image(display, 0, 70);
    popMatrix();
    noStroke();
    fill(255);
    shape(mask, 0, 60);
    noFill();
    stroke(0);
    strokeWeight(thick/.7);
    shape(window, 0, 60);
    popMatrix();
  }

  void printString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
  }
}