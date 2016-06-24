
/* @pjs preload="suitcase.svg,suitcase_.svg,suitcase_digits.svg, first_digit.svg"; */

PFont helvetica, sevenFont, orator;

PShape suitcase, balloon, balloon_, digits, first;
String display = "";
long last;

PFont balloonFont;

float z = 1;
float heavyStroke = 2;

String buffer;
color redColor = color(190, 30, 45);

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

interface JavaScript {
  void auth();
}

void bindJavascript(JavaScript js) {
  javascript = js;
}

JavaScript javascript;
boolean done;

void setup() {
  setSize();
  //lights();
  //smooth(2);
  ////hint(ENABLE_OPENGL_4X_SMOOTH);
  //imageMode(CENTER);
  //rectMode(CENTER);
  //textMode(MODEL);
  shapeMode(CORNER);
  initBalloon();
  frameRate(12);
}

void draw() {
  background(done? color(255,0,0) : 255);
  fill(redColor);
  noStroke();
  //ellipse(256, 256, 150, 150);
  drawBalloon(width/2, height/2);
}


void mousePressed() {
  auth();
}

void results(String contacts) {
  done = true;
  println(contacts);
}


void initBalloon() {
  consoleW = 1570;
  consoleH = 170;
  suitcase = loadShape("suitcase.svg");
  suitcase.disableStyle();
  suitcase_ = loadShape("suitcase_.svg");
  suitcase_.disableStyle();
  digits = loadShape("suitcase_digits.svg");
  digits.disableStyle();
  first = loadShape("first_digit.svg");
  first.disableStyle();
  //balloonList = loadStrings("balloon.txt");
  balloonFont = createFont("Helvetica", 16); // ozone
  //bd = createGraphics(consoleW, 170);

  consoleReady = true;
  balloonStatus = true;
  currentLine = 0;
  consoleNext = 0;
}

void drawBalloon(float thisX, float thisY) {
  //suitcase.disableStyle();
  //suitcase_.disableStyle();

  //if (activeScene == 2 && !balloonStatus) {
  //  balloonStatus = true;
  //  currentLine = 0;
  //  consoleReady = true;
  //  consoleNext = 0;
  //}
  //if (activeScene != 2 && balloonStatus) {
  //  balloonStatus = false;
  //}

  pushMatrix();
  translate(thisX, thisY);
  scale(1);

  noStroke();
  fill(255);
  shape(suitcase_, -suitcase.width/2, -suitcase.height/2);
  noFill();
  stroke(0);
  strokeWeight(1);
  shape(suitcase, -suitcase.width/2, -suitcase.height/2);
  strokeWeight( z*heavyStroke);
  shape(suitcase_, -suitcase.width/2, -suitcase.height/2);

  fill(redColor, 100);
  noStroke();
  shape(digits, -suitcase.width/2, -suitcase.height/2);
  fill(redColor, millis()%500<250 ? 255: 0);

  shape(first, -suitcase.width/2, -suitcase.height/2);

  fill(redColor);

  text(nf((int)random(255), 3)+"."+nf((int)random(255), 3)+"."+nf((int)random(255), 3)+"."+nf((int)random(255), 3), -60, 80);
  popMatrix();

  //if (balloonStatus) {
  //  //updateBalloon();
  //  String displayText = consoleText;
  //  if (consoleMode == 1) {
  //    displayText += ((millis()%1000 < 500) ? "" : "_");
  //  }
  //  bd.beginDraw();
  //  bd.background(255);
  //  bd.fill(redColor);
  //  bd.textFont(balloonFont, 120);
  //  bd.text(displayText, 10+consoleX, 128+consoleY);
  //  bd.endDraw();
  //  pushMatrix();
  //  iso();
  //  rotateX(radians(-90));
  //  noStroke();
  //  translate(3.2, 1.7);
  //  scale(.1);
  //  image(bd, 0, 0);
  //  popMatrix();
  //}
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
      //if (!muted) whistle.rewind();
      //if (!muted) whistle.play();
      ticDelay = 20;
      consoleText = "";
      consoleMode = 1;
      consoleReady = false;
      break;
    case '<':
      //if (!muted) twobubbles.rewind();
      //if (!muted) twobubbles.play();
      ticDelay = 1;
      consoleX = consoleW;
      consoleText = bufferText;
      consoleMode = 2;
      consoleReady = false;
      break;
    case '^':
      //if (!muted) event.rewind();
      //if (!muted) event.play();
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


void setSize()
{
  size(window.innerWidth, window.innerHeight-5);
  //pgl = (PGraphicsOpenGL) g;
  //gl = pgl.beginGL();  
  //gl.glViewport(0, 0, width, height);
  //pgl.endGL(); 
  //size(document.body.clientWidth - 20, document.body.clientHeight - 20);
}