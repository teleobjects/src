class ReelDisplay extends Display {
  PShape outline, wheel, wheel_mask;

  int mode = 0;
  String data = "";

  long lastTick;
  int cursorX = 0;
  int breakX;
  boolean busy;
  int displayMode, tick, tock, tuck;

  int[] heights = {7, 8, 14, 28, 14, 14, 16};

  int dotNum = 16;
  float dotR = 8;
  float offsetX = 18;
  color[] colorDots, targetDots;

  float angleL, angleR;
  float targetL, targetR;

  int lMax, lAcc, lPos;
  int rMax, rAcc, rPos;

  ReelDisplay () {
    outline = loadShape("shp/reel.svg");
    outline.disableStyle();
    wheel = loadShape("shp/wheel.svg");
    wheel.disableStyle();
    wheel_mask = loadShape("shp/wheel_mask.svg");
    wheel_mask.disableStyle();
    colorDots = new color[dotNum];
    targetDots = new color[dotNum];
    for (int i=0; i< colorDots.length; i++) {
      colorDots[i] = redColor;
    }
  }

  void update() {
  }

  void display() {
    fill(255);
    stroke(0);
    strokeWeight(thickStroke);
    shape(outline, 0, 0);
    pushMatrix();
    translate(offsetX/2, 0);
    translate(-offsetX * dotNum /2, 36);
    for (int i=0; i< colorDots.length; i++) {
      noStroke();
      fill(255, 0, 0, red(colorDots[i])*16);
      ellipse(i*offsetX, 0, dotR, dotR);
    }
    popMatrix();
    pushMatrix();
    translate(-135, -100);
    scale(.97);
    rotate(angleL);
    noStroke();
    fill(255);
    shape(wheel_mask, 0, 0);
    noFill();
    stroke(0);
    strokeWeight(thickStroke);
    shape(wheel, 0, 0);

    popMatrix();
    pushMatrix();
    translate(135, -100);
    scale(.97);
    rotate(angleR);
    noStroke();
    fill(255);
    shape(wheel_mask, 0, 0);
    noFill();
    stroke(0);
    strokeWeight(thickStroke);
    shape(wheel, 0, 0);    popMatrix();
  }

  void printString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
  }

  void randomReds(int b) {
    for (int i=0; i< colorDots.length; i++) {
      colorDots[i] = color(random(b), 0, 0);
    }
  }
}