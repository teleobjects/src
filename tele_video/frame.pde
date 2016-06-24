PImage[] faces;
int face[];
long faceLast[];
int status[];
boolean frameReady[];
int[] bestShots = {3, 11, 12, 16, 28, 30, 31, 33, 41, 47, 55, 56, 57, 65, 66};
PShape speakerGrid;
long startTime;
boolean frameStatus, calling, idle, answer;

void initFrame() {
  speakerGrid = loadShape("svg/speakerGrid.svg");
  speakerGrid.disableStyle();
  faces = new PImage[76];
  for (int i=0; i<76; i++) {
    faces[i] = loadImage("faces/faces"+nf(i, 4, 0)+".jpg");
  }
  face = new int[4];
  faceLast = new long[4];
  status = new int[4];
  frameReady = new boolean[4];
  frame = loadShape("svg/frame.svg");
  frame.disableStyle();
  frame_ = loadShape("svg/frame_.svg");
  frame_.disableStyle();
}

void frameOn() {
  answer = false;
  frameStatus = true;
  startTime = millis();
  calling = false;
  if (!muted) hangup.rewind();
  if (!muted) skypeCall.rewind();
  if (!muted) dial.rewind();

  idle = false;
  for (int i=0; i<4; i++) {
    frameReady[i] = false;
  }
}

void frameOff() {
  if (!muted) skypeCall.pause();
  frameStatus = false;
  idle = true;
}

void drawFrame(float thisX, float thisY) {
  if (activeScene == 1 && !frameStatus) {
    frameOn();
  }
  if (activeScene != 1 && frameStatus) {
    frameOff();
  }
  long ellapsed = millis() - startTime;
  if (frameStatus && ellapsed > 7000 && !calling && !idle) {
    calling = true;
    if (!muted) skypeCall.play();
  }
  if (frameStatus && ellapsed > 10000 && !answer) {
    answer = true;
    if (!muted) dial.play();
  }
  if (frameStatus && ellapsed > 11000 && calling) {
    if (!muted) hangup.play();
    calling = false;
  }
  pushMatrix();
  translate(thisX, thisY);
  drawSingleFrame(0);
  translate(55, 32);
  drawSingleFrame(1);
  translate(55, 32);
  drawSingleFrame(2);  
  translate(55, 32);
  drawSingleFrame(3);
  popMatrix();
}

void drawSingleFrame(int num) {
  noStroke();
  fill(255);
  shape(frame_, -frame.width/2, -frame.height/2);
  pushMatrix();
  iso();
  rotateX(radians(-90));
  long ellapsed = millis() - startTime;
  int frameColor = redColor;
  float frameAlpha = .8;
  if (frameStatus && ellapsed > 2000 + (num*1000) || idle) {
    pushMatrix();
    translate(-3.8, 1.95);
    scale(.087);
    if (ellapsed > 2000 + (num*1000) && ellapsed < 4000+(num*1000)) {
      if (millis()-faceLast[num] > 200) {
        faceLast[num] = millis();//(int)random(50);
        face[num] = bestShots[int(random(bestShots.length))];
        status[num] = (int)random(2);
      }
    }
    if (ellapsed > 4000+(num*1000) && !frameReady[num] ) {
      if (!muted) skype1.rewind();
      if (!muted) skype1.play();
      status[num] = 2;
      frameReady[num] = true;
      if (num == 1) face[1] = 34;
    }
    if (calling && num == 1) {
      frameAlpha = map(sin(millis()/200.0), -1, 1, .3, 1);
    } else {
      frameAlpha = .8;
    }
    switch(status[num]) {
    case 0:
      frameColor = redColor;
      break;
    case 2:
      frameColor = color(127, 187, 86);
      break;
    case 1:
      frameColor = color(250, 209, 22);
      break;
    }
    noStroke();
    fill(frameColor, 255);
    rect(0, 0, faces[face[num]].width, faces[face[num]].height);
    tint(frameColor, 255*frameAlpha);
    image(faces[face[num]], 0, 0);
    noTint();
    popMatrix();
    noStroke();
    fill(frameColor, 50);
    rect(-4, 2, 21, 21);
    noStroke();
    strokeWeight(1);
    fill(255);
    rect(-16.4, 2, 4.1, 21);
    rect(8.4, 2, 4.1, 21);
  } else {
    noStroke();
    fill(frameColor, 50);
    rect(-4, 2, 21, 21);
  }
  fill(0);
  translate(-8, 25);
  scale(.1);
  shape(speakerGrid, 0, 0);
  popMatrix();
  noFill();
  stroke(0);
  strokeWeight(1);
  shape(frame, -frame.width/2, -frame.height/2);
  strokeWeight( z*heavyStroke);
  shape(frame_, -frame.width/2, -frame.height/2);
}