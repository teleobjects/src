PImage[] leftMovie, rightMovie;

long keyholeStart;
PShape keyhole, keyhole_, keyhole__, keyhole___;
boolean keyholeStatus;
int leftFrame, rightFrame;
int leftDirection, rightDirection;
long frameLast;
float noiseA;

void initKeyhole() {
  keyhole = loadShape("svg/keyhole.svg");
  keyhole.disableStyle();
  keyhole_ = loadShape("svg/keyhole_.svg");
  keyhole_.disableStyle();
  keyhole__ = loadShape("svg/keyhole__.svg");
  keyhole__.disableStyle();

  leftMovie = new PImage[31];
  for (int i=0; i < leftMovie.length; i++) {
    leftMovie[i] = loadImage("vid/five/five_clip "+nf(i+1, 2, 0)+".png");
  }

  rightMovie = new PImage[30];
  for (int i=0; i<rightMovie.length; i++) {
    rightMovie[i] = loadImage("vid/two/two_clip "+nf(i+1, 3, 0)+".png");
  }
}

void keyholeOn() { 
  keyholeStatus = true;
  keyholeStart = millis();
  leftDirection = 1;
  rightDirection  = 1;
  rightFrame = 0;
  leftFrame = 0;
  noiseA = 1;
  Ani.to(this, 10, "noiseA", 0, Ani.SINE_IN_OUT);
}

void keyholeOff() {
  keyholeStatus = false;
}

void drawKeyhole (float thisX, float thisY) {
  if (millis() > frameLast + 1000.0/24) {
    frameLast = millis();
    leftFrame += leftDirection;
    rightFrame += rightDirection;
    if (leftFrame == leftMovie.length-1) leftDirection = -1;
    if (leftFrame == 0) leftDirection = 1;

    if (rightFrame == rightMovie.length-1) rightDirection = -1;
    if (rightFrame == 0) rightDirection = 1;
  }
  pushMatrix();
  translate(thisX, thisY);
  scale(.8);
  drawSingleKeyhole(0);
  translate(100, -60);
  drawSingleKeyhole(1);
  popMatrix();
}

void drawSingleKeyhole(int num) {
  long keyholeEllapsed = millis()- keyholeStart;
  if (activeScene == 8 && !keyholeStatus) keyholeOn();
  //if (activeScene != 8 && keyholeStatus) keyholeOff();
  pushMatrix();
  noStroke();
  fill(255);
  shape(keyhole_, -keyhole.width/2, -keyhole.height/2);
  pushMatrix();
  translate(16.7, 8.6);
  iso();
  rotateX(radians(-90));
  rotateY(radians(90));


  pushMatrix();
  scale(.062);
  translate(-28, -2);
  //fill(redColor, 50);
  //rect(0, 0, 480, 480);
  if (keyholeStatus && keyholeEllapsed > 2000) {
    //tint(redColor, 100);
    leftMovie[leftFrame].filter(GRAY);
    rightMovie[rightFrame].filter(GRAY);
    scale(num == 1 ? .95 : 1);
    image(num == 1 ? leftMovie[leftFrame] : rightMovie[rightFrame], 0, 0);
  }
  popMatrix();
  pushMatrix();
  scale(.4);

  //if (keyholeStatus && keyholeEllapsed > 8000 && noiseA == 1) Ani.to(this, 2, "noiseA", 0, Ani.SINE_IN_OUT);
  if (keyholeStatus && keyholeEllapsed > 12000 && noiseA == 0) Ani.to(this, 2, "noiseA", .9, Ani.SINE_IN_OUT);

  for (int i= -50; i<50; i=i+1) {
    for (int j= -50; j<50; j=j+1) {
      fill(redColor, random(noiseA*255));
      rect(i, j, 1, 1);
    }
  }
  //}
  popMatrix();

  pushMatrix();
  scale(.062);
  translate(-28, -2);
  fill(redColor, 50);
  rect(0, 0, 480, 480);
  popMatrix();

  //stroke(0);
  //noFill();
  //strokeWeight(5);
  //ellipse(0, -16, 4, 4);
  popMatrix();


  fill(255);  
  noStroke();
  shape(keyhole__, -keyhole.width/2, -keyhole.height/2);
  noFill();
  stroke(0);
  strokeWeight(1);
  shape(keyhole, -keyhole.width/2, -keyhole.height/2);
  strokeWeight(z*heavyStroke);
  shape(keyhole_, -keyhole.width/2, -keyhole.height/2);
  popMatrix();
}