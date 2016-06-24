float tapeWidth = 13;
float left, right;
float leftS, rightS;
float leftTarget, rightTarget;
PShape download, upload, arrow;
boolean reelStatus;
long reelStart;
long leftNext, rightNext;

void reelOn() {
  reelStatus = true;
  reelStart = millis();
  leftS = 0;
  rightS = 0;
  leftTarget = 0;
  rightTarget = 0;
}

void reelOff() {
  reelStatus = false;
  leftS = 0;
  rightS = 0;
  leftTarget = 0;
  rightTarget = 0;
}

void initReel() {
  reel = loadShape("svg/reel.svg");
  reel.disableStyle();
  reel_ = loadShape("svg/reel_.svg");
  reel_.disableStyle();
  reel_tape = loadShape("svg/reel_tape3.svg");
  reel_tape.disableStyle();
  download = loadShape("svg/cloud.svg");
  download.disableStyle();
  upload = loadShape("svg/cloud.svg");
  upload.disableStyle();
  arrow = loadShape("svg/arrow.svg");
  arrow.disableStyle();
}

void drawReel(float thisX, float thisY) {
  long reelEllapsed = millis() - reelStart;
  if (activeScene == 7 && !reelStatus) {
    reelOn();
  }
  if (activeScene != 7 && reelStatus) {
    reelOff();
  }
  if (reelStatus && reelEllapsed > 5000) {
    if (millis() > leftNext) {
      leftNext = millis() + (int)random(500);
      leftTarget = random(.5);
      if (random(1)< .3) leftTarget = 0;
    }
    if (millis() > rightNext) {
      rightNext = millis() + (int)random(1000);
      rightTarget = random(1)/10;
      if (random(1)< .4) rightTarget = 0;
    }
  }
  leftS += (leftTarget - leftS) *.1;
  rightS += (rightTarget - rightS) *.1;
  left += leftS;
  right -= rightS;
  pushMatrix();
  translate(thisX, thisY);
  scale(.6);
  pushMatrix();
  fill(255);
  noStroke();
  shape(reel_, -reel.width/2, -reel.height/2);
  noFill();
  stroke(0);
  strokeWeight(1);
  shape(reel, -reel.width/2, -reel.height/2);
  strokeWeight(z*heavyStroke);
  shape(reel_, -reel.width/2, -reel.height/2);
  popMatrix();
  pushMatrix();
  iso();
  rotateX(radians(-90));
  scale(.078);
  translate(-725, 0, 0);
  pushMatrix();
  rotateZ(left);
  stroke(redColor);
  fill(255);
  strokeWeight(z*heavyStroke*.6);  
  shape(reel_tape, 0, 0 );
  shape(reel_tape, -tapeWidth, 0 );
  popMatrix();
  pushMatrix();
  scale(1.1);
  translate(0, 500);
  fill(redColor, leftS > .05 ? 255 : 20);
  noStroke();
  shape(download, 0, 0);
  translate(0, 60);
  rotate(PI);
  scale(1.1);
  shape(arrow, 0, 0);
  popMatrix();
  translate(925, 0, 0);
  stroke(redColor);
  fill(255);
  stroke(redColor);
  fill(255);
  strokeWeight(z*heavyStroke*.6);
  pushMatrix();
  rotateZ(right);
  shape(reel_tape, 0, 0 );
  shape(reel_tape, -tapeWidth, 0 );
  popMatrix();
  pushMatrix();
  scale(1.1);
  translate(0, 500);
  fill(redColor, rightS > .02 ? 255 : 20);
  noStroke();
  shape(upload, 0, 0);
  translate(0, 60);
  scale(1.1);
  shape(arrow, 0, 00);
  popMatrix();
  popMatrix();
  popMatrix();
}