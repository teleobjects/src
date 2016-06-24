String display = "";
long last;

PFont balloonFont;

String buffer;

boolean balloonStatus;

String[] balloonList;
int currentLine;

int ticDelay;
String consoleText = "";
String consoleLastText;

int consoleWidth = 40;
int consoleMode, consoleNextMode;

String bufferText = "";
long consoleNext;
long consoleTic;
int consoleDelay = 1600;
char consoleCursor = '_';
boolean consoleReady = false;

int consoleX, consoleW;
int consoleY, consoleH;

PGraphics bd;

void initBalloon() {
  consoleW = 1570;
  consoleH = 170;
  balloon = loadShape("svg/balloon.svg");
  balloon.disableStyle();
  balloon_ = loadShape("svg/balloon_.svg");
  balloon_.disableStyle();
  balloonList = loadStrings("data/balloon.txt");
  balloonFont = createFont("Ozone", 16);
  bd = createGraphics(consoleW, 170);
  consoleReady = true;
}



void drawBalloon(float thisX, float thisY) {
  if (activeScene == 2 && !balloonStatus) {
    balloonStatus = true;
    currentLine = 0;
    consoleReady = true;
    consoleNext = 0;
  }
  if (activeScene != 2 && balloonStatus) {
    balloonStatus = false;
  }

  pushMatrix();
  translate(thisX, thisY);
  scale(.8);
  pushMatrix();
  noStroke();
  fill(255);
  shape(balloon_, -balloon.width/2, -balloon.height/2);
  noFill();
  stroke(0);
  strokeWeight(1);
  shape(balloon, -balloon.width/2, -balloon.height/2);
  strokeWeight( z*heavyStroke);
  shape(balloon_, -balloon.width/2, -balloon.height/2);
  popMatrix();
  if (balloonStatus) {
    updateBalloon();
    String displayText = consoleText;
    if (consoleMode == 1) {
      displayText += ((millis()%1000 < 500) ? "" : "_");
    }
    bd.beginDraw();
    bd.background(255);
    bd.fill(redColor);
    bd.textFont(balloonFont, 120);
    bd.text(displayText, 10+consoleX, 128+consoleY);
    bd.endDraw();
    pushMatrix();
    iso();
    rotateX(radians(-90));
    noStroke();
    translate(3.2, 1.7);
    scale(.1);
    image(bd, 0, 0);
    popMatrix();
  }
  popMatrix();
}

void updateBalloon() {
  if (millis() > consoleNext && consoleReady) {
    consoleReady = false;
    consoleX = 0;
    consoleY = 0;
    consoleLastText = consoleText;
    bufferText = balloonList[currentLine];
    char modeId = bufferText.charAt(0);
    bufferText = bufferText.substring(1, bufferText.length());
    currentLine ++;
    if (currentLine == balloonList.length) {
      currentLine = 0;
    }
    switch(modeId) {
    case '*':
      ticDelay = 50;
      consoleMode = 0;
      consoleNext = millis() + consoleDelay;
      consoleReady = true;
      break;
    case ';':
      consoleText = "";
      consoleMode = 1;
      consoleNext = millis() + consoleDelay;
      consoleReady = true;
      break;
    case '>':
      if (!muted) whistle.rewind();
      if (!muted) whistle.play();
      ticDelay = 20;
      consoleText = "";
      consoleMode = 1;
      consoleReady = false;
      break;
    case '<':
      if (!muted) twobubbles.rewind();
      if (!muted) twobubbles.play();
      ticDelay = 1;
      consoleX = consoleW;
      consoleText = bufferText;
      consoleMode = 2;
      consoleReady = false;
      break;
    case '^':
      if (!muted) event.rewind();
      if (!muted) event.play();
      ticDelay = 1;
      consoleText = consoleLastText+"\n"+ bufferText;
      consoleMode = 3;
      consoleReady = false;
      break;
    }
  }

  if (millis() > consoleTic) {
    consoleTic = millis() + ticDelay;
    switch (consoleMode) {
    case 0:
      consoleText = "";
      for (int i=0; i<consoleWidth; i++) {
        consoleText += char(int(random(48))+65) ;
      }
      break;
    case 1:
      if (bufferText.length() > 0) {
        consoleText = consoleText+bufferText.charAt(0);
        consoleTic = millis() + ticDelay;
        bufferText = bufferText.substring(1, bufferText.length());
      } else {
        if (!consoleReady) {
          consoleNext = millis() + consoleDelay;
          consoleReady = true;
        }
      }
      break;
    case 2:
      consoleX -= 20;
      textFont(balloonFont, 120);
      if (consoleX + textWidth(consoleText) < -20) {
        consoleText = "";
        consoleReady = true;
      }
      break;
    case 3:
      if (!consoleReady) {
        consoleY -= 10;
        if (consoleY < -consoleH) {
          consoleText = bufferText;
          consoleY = 0;
          consoleReady = true;
          consoleNext = millis() + consoleDelay;
        }
      }
      break;
    }
  }
}