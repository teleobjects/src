import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import de.looksgood.ani.*; 
import de.looksgood.ani.easing.*; 
import ddf.minim.*; 
import ddf.minim.effects.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class tele_video extends PApplet {

PFont helvetica, sevenFont, orator;

PShape balloon, balloon_, frame, frame_, map, map_, map_mask;
PShape suitcase, suitcase_, mailbox, mailbox_, mailbox_flag;
PShape reel, reel_, reel_tape, alarm, alarm_, alarm__, hammer, hammer_;

PImage texture;
PImage shadow;

boolean debug, muted = true, textured = true;

int darkGreyColor = 80;
int backgroundColor = 220;
int redColor = color(190, 30, 45);
float heavyStroke = 1.2f;

long globalStart;


public void setup() {
   
  // size(1920, 1080, P3D);
  //size(2048, 1152, P3D);
  frameRate(60);
  noCursor();
  Ani.init(this);
  imageMode(CENTER);
  rectMode(CENTER);
  textMode(MODEL);
  
  // hint(DISABLE_DEPTH_TEST);
  sevenFont = createFont ("Digital-7Mono", 128);
  helvetica = createFont("HelveticaNeue-Light", 64);
  orator = createFont("OratorStd", 128);
  texture = width == 1280 ? loadImage("img/paper_1280x720.jpg") : loadImage("img/paper_1920x1080.jpg");
  shadow = loadImage("shadows/shadow_circle_light.png");
  initHome();
  initGlobe();
  initKeyhole();
  initSuitcase();
  initMailbox();
  initReel();
  initBalloon();
  initFrame();
  initMap();
  initAlarm();
  initComposer();
  initEnd();
  goToScene(0);
  //textured = true;
  if (muted) {
    soundtrack.pause();
  } else {
    initSound();
    soundtrack.play();
  }
}

public void draw() {
  background(backgroundColor);
  pushMatrix();
  translate(width/2, height/2);  // center
  pushMatrix();
  scale(width/1600.0f);  // normalize
  drawBackground();
  drawContent();
  drawForeground();
  popMatrix();
  if (textured) {
    scale(width*1.0f/texture.width*1.0f);
    blendMode(MULTIPLY);
    image(texture, 0, 0);  // background
    blendMode(BLEND);
    //tint(255, 50);
    //image(texture, 0, 0);  // overlay
    //noTint();
  }
  popMatrix();

  if (debug) {
    textFont(helvetica, 18);
    fill(redColor);
    textAlign(LEFT);  
    text(x, 10, 30);
    text(y, 10, 60);
    text(z, 10, 90);
    long ellapsed = millis()-globalStart;
    //int sec = (int)ellapsed;
    int min = (int)ellapsed/60000;
    int sec = ((int)ellapsed-min*60*1000)/1000;
    text(frameRate > 59 ? 60 : (int)frameRate, 10, 120);  
    text(auto ? "auto" : "stop", 10, 150);
    text(muted ? "muted" : "sound", 10, 180);
    text(nf(min, 2, 0)+":"+nf(sec, 2, 0), 10, 210);
    text(activeScene +"scene", 10, 240);
    text(keyframe +"keyframe", 10, 270);
    strokeWeight(1);
    stroke(redColor, 100);
    for (int i=1; i<3; i++) {
      line(i*width/3.0f, 0, i*width/3.0f, height);
    }
    for (int i=1; i<3; i++) {
      line(0, i*height/3.0f, width, i*height/3.0f);
    }
    stroke(255, 0, 0, 20);
    line(0, height/2, width, height/2);
    line(width/2, 0, width/2, height);
    //for (int i=1; i<3; i++) {
    //  line(i*width/3.0, 0, i*width/3.0, height);
    //}
    //for (int i=1; i<3; i++) {
    //  line(0, i*height/3.0, width, i*height/3.0);
    //}
  }
}
long alarmNext;
PShape[] icons;
String[] alarmIcons = {"heart", "like", "talk"};
PShape circle_mask;
int alarmImage;
int activeIcon;
boolean alarmStatus;
long alarmStarted;

float hammerR;

public void alarmOn() {
  alarmStarted = millis();
  alarmStatus = true;
  activeIcon = -1;
  alarmImage = -1;
}

public void alarmOff() {
  alarmStatus = false;
}

public void initAlarm() {
  alarm = loadShape("svg/alarm.svg");
  alarm.disableStyle();
  alarm_ = loadShape("svg/alarm_.svg");
  alarm_.disableStyle();
  alarm__ = loadShape("svg/alarm__.svg");
  alarm__.disableStyle();
  hammer = loadShape("svg/hammer.svg");
  hammer.disableStyle();
  hammer_ = loadShape("svg/hammer_.svg");
  hammer_.disableStyle();
  circle_mask = loadShape("svg/circle_mask.svg");
  circle_mask.disableStyle();
  icons = new PShape[3];
  for (int i=0; i<3; i++) {
    icons[i] = loadShape("svg/"+alarmIcons[i]+".svg");
    icons[i].disableStyle();
  }
  activeIcon = -1;
  alarmImage = -1;
}

public void drawAlarm(float thisX, float thisY) {
  if (activeScene == 5 && !alarmStatus) {
    alarmOn();
  }
  if (activeScene != 5 && alarmStatus) {
    alarmOff();
  }
  long alarmEllapsed = millis() - alarmStarted;

  if (millis() > alarmNext && alarmStatus && alarmEllapsed > 4000) {
    alarmNext = millis()+1000+(int)random(1500);
    int lastAlarmImage = alarmImage;
    while (lastAlarmImage == alarmImage) {
      alarmImage = (int)random(faces.length);
    }
    int lastActiveIcon = activeIcon;
    while (activeIcon == lastActiveIcon) {
      activeIcon = (int)random(3);
    }
    Ani.to(this, .1f, "hammerR", -PI/20, Ani.QUAD_IN_OUT);
    if (!muted) {
      switch(activeIcon) {
      case 0:
        offline.rewind();
        offline.play();
        break;
      case 1:
        twobubbles.rewind();
        twobubbles.play(); 
        break;
      case 2:
        whistle.rewind();
        whistle.play();
        break;
      }
    }
  }
  if (hammerR == -PI/20) {
    Ani.to(this, .01f, "hammerR", PI/20, Ani.QUAD_IN_OUT);
  }
  pushMatrix();
  translate(thisX, thisY);
  scale(.8f);
  pushMatrix();
  noStroke();
  fill(255);
  shape(alarm__, -alarm.width/2, -alarm.height/2);
  popMatrix();
  pushMatrix();
  iso();
  rotateX(radians(-90));
  pushMatrix();
  translate(-19.8f, 5.8f );
  scale(.05f);
  if (alarmImage != -1) {
    //image(faces[alarmImage], 0, 0);
  }
  scale(1.48f);
  fill(255);
  noStroke();
  //shape(circle_mask, 0, 0);
  noFill();
  stroke(0);
  strokeWeight(2);
  //fill(redColor, 50);

  ellipse(0, 0, 166, 166);
  popMatrix();
  pushMatrix();
  noStroke();
  translate(5, 22, 20);
  scale(.09f);
  fill(redColor, activeIcon == 0 ? 255 : 50);
  shape(icons[0], -130, 0 );
  fill(redColor, activeIcon == 1 ? 255 :  50);
  shape(icons[1], 0, -10 );
  fill(redColor, activeIcon == 2 ? 255 : 50);
  shape(icons[2], 130, 0 );
  popMatrix();
  popMatrix();
  noFill();
  stroke(0);
  strokeWeight(1);
  shape(alarm, -alarm.width/2, -alarm.height/2);
  noFill();
  stroke(0);
  strokeWeight( z*heavyStroke);
  shape(alarm_, -alarm.width/2, -alarm.height/2);
  translate(11, 30);
  rotate(hammerR);
  noStroke();
  fill(255);
  shape(hammer_, 0, 0);
  noFill();
  stroke(redColor);
  strokeWeight( z*heavyStroke);
  shape(hammer, 0, 0);
  popMatrix();
}
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

public void initBalloon() {
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



public void drawBalloon(float thisX, float thisY) {
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
  scale(.8f);
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
    translate(3.2f, 1.7f);
    scale(.1f);
    image(bd, 0, 0);
    popMatrix();
  }
  popMatrix();
}

public void updateBalloon() {
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
        consoleText += PApplet.parseChar(PApplet.parseInt(random(48))+65) ;
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
float x, y, z;
boolean dragged;
float offsetX, offsetY;

public void initCamera() {
}

public void updateCamera() {
  if (dragged) {
    x += (mouseX-offsetX)/ z;
    offsetX = mouseX;
    y += (mouseY-offsetY)/ z;
    offsetY = mouseY;
  }
  scale(z);
  translate(x, y);
}

public void keyPressed() {
  switch (key) {
  case 't':
    textured = !textured;
    break;
  case TAB:
    debug = !debug;
    break;
  case 'a':
    auto = !auto;
    break;
  case 'm':
    muted = !muted;
    break;
  case '0':
    goToScene(0);
    break;
  case '1':
    goToScene(1);
    break;
  case '2':
    goToScene(2);
    break;
  case '3':
    goToScene(3);
    break;
  case '4':
    goToScene(4);
    break;
  case '5':
    goToScene(5);
    break;
  case '6':
    goToScene(6);
    break;
  case '7':
    goToScene(7);
    break;
  case '8':
    goToScene(8);
    break;
  case '9':
    goToScene(9);
    break;
    //case ' ':
    //  int scope = 300; 
    //  targetX = -scope+random(scope*2);
    //  targetY = -scope+random(scope*2);
    //  targetZoom = 1+random(4);
    //break;
  }
}

public void iso() {
  ortho(-width/2, width/2, -height/2, height/2, -2000, 2000);
  rotateX(radians(54.7f));
  rotateZ(radians(45));
}

public void mouseWheel(MouseEvent event) {
  float delta = event.getAmount();
  float targetZ = delta/1000.0f;
  z -= targetZ;
}

public void pressCamera() {
  offsetX = mouseX;
  offsetY = mouseY;
  dragged = true;
}

public void releaseCamera() {
  dragged = false;
}

public void keyReleased() {
  keyCode = 0;
}

public void mousePressed() {
  pressCamera();
}

public void mouseReleased() {
  releaseCamera();
}



int activeScene;

PShape[] numbers;

Scene[] scenes;

boolean auto = true;

public void initComposer() {
  numbers = new PShape[10];
  for (int i=0; i<10; i++) {
    numbers[i] = loadShape("svg/"+i+".svg");
    numbers[i].disableStyle();
  }
  scenes = new Scene[10];
  for (int i=0; i<10; i++) {
    scenes[i] = new Scene();
    scenes[i].num = i;
    scenes[i].init();
  }
}

public void drawBackground() {

  for (int i=1; i<9; i++) {
    scenes[i].update();
    scenes[i].drawBackground();
  }

  drawHome();

  if (activeScene == 9) {
    drawEnd();
  } else {
    endOff();
  }
}

public void drawContent() {
  pushMatrix();
  updateCamera();  
  if ((activeScene == 0 && keyframe == 9) || (activeScene > 0 && activeScene < 9) || (activeScene == 9 && millis() - endStart < 8000)) {
    drawFrame(300, 0);
    drawBalloon(300, -250);
    drawMap(-100, -250);
    drawSuitcase(-500, -220);
    drawAlarm(-450, 0);
    drawMailbox(-520, 280);
    drawReel(-200, 150);

    drawKeyhole(100, 305);
  }
  noStroke();
  popMatrix();
  if ((activeScene == 9 && millis() - endStart < 9000) || (activeScene == 0 && keyframe == 9)) {
    home_mask.draw();
    logo.draw();
  }
}

public void drawForeground() {
  for (int i=1; i<9; i++) {
    scenes[i].drawForeground();
  }
}

public void goToScene(int thisScene) {
  scenes[activeScene].off();
  activeScene = thisScene;
  scenes[activeScene].on();
  /**
   * Ani.LINEAR
   * Ani.QUAD_IN
   * Ani.QUAD_OUT
   * Ani.QUAD_IN_OUT
   * Ani.CUBIC_IN
   * Ani.CUBIC_IN_OUT
   * Ani.CUBIC_OUT
   * Ani.QUART_IN
   * Ani.QUART_OUT
   * Ani.QUART_IN_OUT
   * Ani.QUINT_IN
   * Ani.QUINT_OUT
   * Ani.QUINT_IN_OUT
   * Ani.SINE_IN
   * Ani.SINE_OUT
   * Ani.SINE_IN_OUT
   * Ani.CIRC_IN
   * Ani.CIRC_OUT
   * Ani.CIRC_IN_OUT
   * Ani.EXPO_IN
   * Ani.EXPO_OUT
   * Ani.EXPO_IN_OUT
   * Ani.BACK_IN
   * Ani.BACK_OUT
   * Ani.BACK_IN_OUT
   * Ani.BOUNCE_IN
   * Ani.BOUNCE_OUT
   * Ani.BOUNCE_IN_OUT
   * Ani.ELASTIC_IN
   * Ani.ELASTIC_OUT
   * Ani.ELASTIC_IN_OUT
   */
}

public void goTo(float xx, float yy, float zz) {
  float tt = 3;
  if (activeScene != 9) {
    Ani.to(this, tt, "x", xx, Ani.SINE_IN_OUT);
    Ani.to(this, tt, "y", yy, Ani.SINE_IN_OUT);
    Ani.to(this, tt, "z", zz, Ani.SINE_IN_OUT);
  }
}

class Scene {
  int num;
  boolean status;

  long start, ellapsed;
  PVector target = new PVector(0, 0, 1);
  PVector targetZoom = new PVector(0, 0, 0);

  boolean zoom;

  ShapeObject index, app;
  TextObject[] infos;
  IconObject[] props;

  public void init() {
    if (num > 0 && num < 9) {
      index = new ShapeObject();
      index.shp = numbers[num];
      index.c = redColor;
      index.init();
    }

    String data[] = loadStrings("data/"+num+".txt");

    String[] dataItems = split(data[0], ",");
    String appName = dataItems[0];

    if (!appName.equals("null")) {
      app = new ShapeObject();
      app.shp = loadShape("svg/"+appName+".svg");
      app.init();
      app.c = 200;
    }

    if (dataItems.length > 3) {
      target = new PVector(parseFloat(dataItems[1]), parseFloat(dataItems[2]), parseFloat(dataItems[3]));
    }
    if (dataItems.length > 6) {
      targetZoom = new PVector(parseFloat(dataItems[4]), parseFloat(dataItems[5]), parseFloat(dataItems[6]));
    } else {
      targetZoom = target;
    }
    if (data.length > 1) {
      String[] icons = split(data[1], ",");
      String[] labels = split(data[2], ",");
      props = new IconObject[icons.length];
      for (int i=0; i<props.length; i ++) {
        props[i] = new IconObject();
        props[i].shp = loadShape("svg/"+icons[i]+".svg");
        props[i].content =labels[i];
        props[i].c = redColor;
        props[i].init();
      }
    }
    if (data.length > 3) {
      infos = new TextObject[data.length-3];
      for (int i=0; i<infos.length; i++ ) {
        infos[i] = new TextObject();
        infos[i].c = 50;
        infos[i].content = data[i+3];
      }
    }
  }

  public void on() {
    start = millis();
    status = true;
    zoom = false;

    goTo(target.x, target.y, target.z);

    if (index != null) {
      index.a = 1;
      index.z = 200;
      index.aniZ(1, 14, Ani.SINE_OUT);
    }
    if (app != null ) {
      app.z = 5;
      app.a = 0;
      app.aniA(2, .7f, Ani.SINE_OUT);
      app.aniZ(16, 15, Ani.SINE_OUT);
    }

    if (infos != null) {
      float lineHeight = 120;
      for (int i=0; i<infos.length; i++ ) {
        infos[i].x = activeScene % 2 == 0 ? 2000 : -2000;
        infos[i].y = -lineHeight*1.5f +  ( i * lineHeight);
        infos[i].z = 1;
      }
      for (int i=0; i<props.length; i ++) {
        int column = i%2;
        int row = i == 0 ? 0 : PApplet.parseInt(i/2);
        props[i].z = 0;
        props[i].y = (row*220) - 220;
        props[i].x = (column*220) + (activeScene % 2 != 0 ? (-width/4) - 110 : (width/4) - 110);
      }
    }
  }

  public void off() {
    status = false;
    if (index != null) {
      index.aniA(0.001f, 0, Ani.LINEAR);
      index.aniZ(0.001f, 100, Ani.LINEAR);
    }
    if (app != null ) {
      app.aniA(1, 0, Ani.SINE_OUT);
    }
    if (infos != null) {
      for (int i=0; i<infos.length; i ++) {
        infos[i].aniA(0.001f, 0, Ani.LINEAR);
        infos[i].aniX(0.001f, -2000, Ani.LINEAR);
      }
    } 
    if (props != null) {
      for (int i=0; i<props.length; i ++) {
        props[i].aniZ(0.001f, 0, Ani.LINEAR);
        props[i].aniA(0.001f, 0, Ani.LINEAR);
      }
    }
  }

  public void update() {
    if (status) {
      ellapsed = millis() - start;

      if (ellapsed > 12000 && auto && activeScene < 9) {
        goToScene(activeScene + 1);
      }

      if ((ellapsed > 800 && ellapsed < 850) ||  (ellapsed > 900 && ellapsed < 950 )) index.a = 0;
      if ((ellapsed > 850 && ellapsed < 900) ||  (ellapsed > 950 && ellapsed < 1000)) index.a = 1;
      if (ellapsed > 1000) index.aniA(.5f, 0, Ani.SINE_OUT);

      if (ellapsed > 7000 && !zoom && auto) {
        goTo(targetZoom.x, targetZoom.y, targetZoom.z);
        zoom = true;
      }

      if (ellapsed > 11000) {
        app.aniA(1, 0, Ani.SINE_OUT);
      }

      if (infos != null) {
        for (int i=0; i<infos.length; i++ ) {
          if (ellapsed > 2000+(800*i)) {
            infos[i].aniA (.1f, 1, Ani.LINEAR);
            infos[i].aniX (.1f, activeScene % 2 == 0 ? 0 : -650, Ani.LINEAR);
          }

          if (ellapsed > 4500+(800*i)) {
            infos[i].aniA (.1f, 0, Ani.SINE_OUT);
          }
        }
      }

      if (props != null) {
        for (int i=0; i<props.length; i ++) {
          if (ellapsed > 6000+(i*400)) {
            props[i].aniZ(1, 1, Ani.ELASTIC_OUT);
            props[i].aniA(.1f, 1, Ani.SINE_OUT);
          }
          if (ellapsed > 9000+(i*100)) {
            props[i].aniZ(.2f, 0, Ani.SINE_OUT);
            props[i].aniA(.2f, 0, Ani.SINE_OUT);
          }
        }
      }
    }
  }

  public void drawBackground() {
    if (app != null) {
      pushMatrix();
      iso();
      rotateZ(activeScene % 2 == 0 ? radians(-90) : 0);
      app.draw();
      popMatrix();
    }
  }

  public void drawForeground() {
    if (infos != null) {
      for (int i=0; i<infos.length; i ++) {
        infos[i].draw();
      }
    }    
    if (props != null) {
      for (int i=0; i<props.length; i ++) {
        props[i].draw();
      }
    }
    if (index != null) {
      index.draw();
    }
  }
}
long endStart;
ShapeObject home_mask;
OverlayObject red_mask;

boolean endStatus;
int endFrame;

TextObject title;


public void initEnd() {
  title = new TextObject();
  title.content = "www.teleobjects.com";
  title.centered = true;
  title.fontSize = 48;

  home_mask = new ShapeObject();
  home_mask.shp = home.shp;
  home_mask.init();
}

public void endOff() {
  endStatus = false;
}

public void endOn() {
  z = scenes[8].targetZoom.z;
  x = scenes[8].targetZoom.x;
  y = scenes[8].targetZoom.y;
  //title.content = "teleobjects";
  title.z = 1;
  title.c = 50;

  logo.a = 0;
  endStart = millis();
  endStatus = true;
  endFrame = 0;
  cloud.c = redColor;
  cloud.a = 1;
  cloud.z = 10;
  cloud.y = 0;
  mobile.c = 255;
  mobile.a = 1;
  mobile.z = 2;
  mobile.c = 255;
  mobile.c_ = redColor;
  rotation = 1.3f;
  sat = false;
  globeA = 0;
  globeZ = 12;
  home.c = backgroundColor;
  home.a = 1;
  home_mask.c = backgroundColor;
  home_mask.a = 0;
  Ani.to(this, 13, "z", .00005f, Ani.QUINT_OUT);
  Ani.to(this, 13, "x", 0, Ani.QUINT_IN_OUT);
  Ani.to(this, 13, "y", 0, Ani.QUINT_IN_OUT);
}

public void drawEnd() {
  if (activeScene == 9 && !endStatus) {
    endOn();
  }
  if (activeScene != 9 && endStatus) {
    endOff();
  }
  long endEllapsed = millis() - endStart;
  pushMatrix();
  if (globeA > 0 ) {
    drawGlobe();
  }
  scale(z*105);
  cloud.draw();
  mobile.draw();
  home.draw();   
  popMatrix();
  logo.draw();
  title.draw();
  home_mask.z = home.z*z*105;

  if (endEllapsed > 3500 && home_mask.a == 0) home_mask.aniA(3, 1, Ani.SINE_IN_OUT);
  if (endEllapsed > 6000 && logo.a == 0) logo.aniA (.5f, 1, Ani.SINE_IN_OUT);
  if (endEllapsed > 7250 && logo.a == 1 ) logo.aniA (.5f, .01f, Ani.SINE_IN_OUT);
  if (endEllapsed > 8500 && home.a == 1) home.aniA(1, 0, Ani.SINE_IN_OUT);
  if (endEllapsed > 10000 && mobile.a == 1) mobile.aniA(.5f, 0.0001f, Ani.SINE_IN_OUT);
  if (endEllapsed > 11000 && cloud.a == 1) cloud.aniA(.5f, 0, Ani.SINE_IN_OUT);
  if (endEllapsed > 10000 && globeZ == 12) Ani.to(this, 3, "globeZ", 1, Ani.SINE_IN_OUT);
  if (endEllapsed > 10000 && globeA == 0) Ani.to(this, .5f, "globeA", 1, Ani.SINE_IN_OUT);
  if (endEllapsed > 13000 && globeA == 1) Ani.to(this, 1, "globeA", .001f, Ani.SINE_IN_OUT);
  if (endEllapsed > 13000 && title.a == 0) title.aniA (1, 1, Ani.SINE_IN_OUT);
  if (endEllapsed > 15000 && title.a == 1) title.aniA (.5f, .01f, Ani.SINE_IN_OUT);
}
PImage[] faces;
int face[];
long faceLast[];
int status[];
boolean frameReady[];
int[] bestShots = {3, 11, 12, 16, 28, 30, 31, 33, 41, 47, 55, 56, 57, 65, 66};
PShape speakerGrid;
long startTime;
boolean frameStatus, calling, idle, answer;

public void initFrame() {
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

public void frameOn() {
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

public void frameOff() {
  if (!muted) skypeCall.pause();
  frameStatus = false;
  idle = true;
}

public void drawFrame(float thisX, float thisY) {
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

public void drawSingleFrame(int num) {
  noStroke();
  fill(255);
  shape(frame_, -frame.width/2, -frame.height/2);
  pushMatrix();
  iso();
  rotateX(radians(-90));
  long ellapsed = millis() - startTime;
  int frameColor = redColor;
  float frameAlpha = .8f;
  if (frameStatus && ellapsed > 2000 + (num*1000) || idle) {
    pushMatrix();
    translate(-3.8f, 1.95f);
    scale(.087f);
    if (ellapsed > 2000 + (num*1000) && ellapsed < 4000+(num*1000)) {
      if (millis()-faceLast[num] > 200) {
        faceLast[num] = millis();//(int)random(50);
        face[num] = bestShots[PApplet.parseInt(random(bestShots.length))];
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
      frameAlpha = map(sin(millis()/200.0f), -1, 1, .3f, 1);
    } else {
      frameAlpha = .8f;
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
    rect(-16.4f, 2, 4.1f, 21);
    rect(8.4f, 2, 4.1f, 21);
  } else {
    noStroke();
    fill(frameColor, 50);
    rect(-4, 2, 21, 21);
  }
  fill(0);
  translate(-8, 25);
  scale(.1f);
  shape(speakerGrid, 0, 0);
  popMatrix();
  noFill();
  stroke(0);
  strokeWeight(1);
  shape(frame, -frame.width/2, -frame.height/2);
  strokeWeight( z*heavyStroke);
  shape(frame_, -frame.width/2, -frame.height/2);
}
ShapeObject logo, home, cloud, world, mobile, box, box_;
PShape rays;
OverlayObject overlay;
MultipleObject mobileMultiple;
BoxObject[] boxes;
ShapeObject[] clouds, apps, actions;
int actionNum = 8;
int cloudNum = 6;
int appNum = 8;
String[] appNames = {"skypeapp", "mailapp", "markerapp", "mapapp", "wifiapp", "whatsapp", "cameraapp", "mailapp"};
String[] actionNames = {"talk", "like", "location", "touch", "camera", "moon", "drop", "heart"};
long homeStart;
boolean homeStatus;
float currentApp;
float heartZ;
int keyframe;
boolean titleFlag, homeFlag, cloudFlag;

public void initHome() {
  overlay = new OverlayObject();
  z = .0001f;
  logo = new ShapeObject();
  logo.shp = loadShape("svg/logo.svg");
  logo.c = 70;
  logo.init();
  mobileMultiple = new MultipleObject();
  mobileMultiple.shp = loadShape("svg/mobile.svg");
  mobileMultiple.c = backgroundColor;
  mobileMultiple.init();
  cloud = new ShapeObject();
  cloud.shp = loadShape("svg/cloud.svg");
  cloud.c = backgroundColor;
  cloud.init();
  clouds = new ShapeObject[cloudNum];
  PVector[] cloudData = new PVector[cloudNum];
  cloudData[0] = new PVector(400, -100, 7);
  cloudData[1] = new PVector(-200, 300, 5);
  cloudData[2] = new PVector(-500, -300, 9);
  cloudData[3] = new PVector(100, 300, 12);
  cloudData[4] = new PVector(0, 200, 16);
  cloudData[5] = new PVector(0, 0, 50);
  for (int i=0; i<cloudNum; i++) {
    clouds[i] = new ShapeObject();
    clouds[i].shp = cloud.shp;
    clouds[i].c = backgroundColor;
    clouds[i].x = cloudData[i].x;
    clouds[i].y = cloudData[i].y;
    clouds[i].z = cloudData[i].z;
    clouds[i].init();
  }
  apps = new ShapeObject[appNum];
  boxes = new BoxObject[appNum];
  for (int i=0; i<appNum; i++) {
    apps[i] = new ShapeObject();
    apps[i].shp = loadShape("svg/"+appNames[i]+".svg");
    apps[i].shp_ = loadShape("svg/maskapp.svg");
    apps[i].c = redColor;
    apps[i].z = .6f;
    apps[i].init();
    boxes[i] = new BoxObject();
    boxes[i].shp = loadShape("svg/box.svg");
    boxes[i].shp_ = loadShape("svg/box_.svg");
    boxes[i].c = 0;
  }
  rays = loadShape("svg/rays.svg");
  rays.disableStyle();
  mobile = new ShapeObject();
  mobile.shp = loadShape("svg/mobile.svg");
  mobile.shp_ = loadShape("svg/mobile_.svg");
  mobile.c = darkGreyColor;
  mobile.init();
  actions = new ShapeObject[actionNum];
  for (int i=0; i<actionNum; i++) {
    actions[i] = new ShapeObject();
    actions[i].shp = loadShape("svg/"+actionNames[i]+".svg");
    actions[i].c = redColor;
    actions[i].z = 4;
    actions[i].init();
  }

  home = new ShapeObject();
  home.shp = loadShape("svg/home.svg");
  home.c = backgroundColor;
  home.init();
}

public void homeOn() {
  globalStart = millis();

  //if (!muted) soundtrack.rewind();
  keyframe = 0;// 8;// 7;
  homeStart = millis(); //- 20000;
  //auto = false;
  homeStatus = true;
  keyframe = 0;
  overlay.a = 0;
  overlay.c = redColor;
  logo.z = 1.3f;
  logo.a = 0;
  home.a = 0;
  home.z = .3f;
  home_mask.c = backgroundColor;
  home_mask.a = 1;
  cloud.a = 1;
  cloud.z = 1;
  cloud.y = -1000;
  for (int i=0; i<cloudNum; i++) {
    clouds[i].a = 0;
  }
  for (int i=0; i<appNum; i++) {
    boxes[i].shp = loadShape("svg/box.svg");
    boxes[i].shp_ = loadShape("svg/box_.svg");
    boxes[i].z = 1.75f;
    boxes[i].a = 0;
    boxes[i].init();
    apps[i].a = 0;
  }
  mobileMultiple.z = 1.3f;
  mobileMultiple.a = 0;
  mobileMultiple.c = backgroundColor;
  mobileMultiple.s = .750f ;
  startY= -400;
  layerY = 0;
  heartZ = 1;
  globeOn();
}

public void homeOff() {
  homeStatus = false;
}

public void drawHome() {
  if (activeScene == 0 && !homeStatus) {
    homeOn();
  }
  if (activeScene != 0 && homeStatus) {
    homeOff();
  }
  if (homeStatus) {
    long  homeEllapsed = millis() - homeStart;
    switch(keyframe) {
    case 0:
      if (homeEllapsed > 0) {  // title fades out
        keyframe ++;
      }
      break;
    case 1:
      if (homeEllapsed > 0) { // globe enters
        Ani.to(this, 3, "globeA", 1, Ani.QUAD_IN_OUT);    
        Ani.to(this, 3, "globeZ", 1, Ani.QUAD_IN_OUT);    
        keyframe ++;
      }
      break;
    case 2:
      drawGlobe();   
      if (homeEllapsed > 4000) { // globe zooms in
        Ani.to(this, 3, "globeZ", 15, Ani.QUAD_IN_OUT);  
        keyframe ++;
      }
      break;
    case 3:
      drawGlobe();  
      overlay.draw();
      if (homeEllapsed > 5000 && overlay.a == 0) { // multiple zooms appears
        overlay.aniA(1, 1, Ani.SINE_IN);
      }
      if (homeEllapsed > 4500 && layerY == 0) {  // layers scroll
        Ani.to(this, 8.5f, "layerY", 950, Ani.QUAD_IN_OUT);
      }
      if (homeEllapsed > 6000) {  
        mobileMultiple.aniA(1, 1, Ani.SINE_OUT);

        keyframe++;
      }
      break;
    case 4:
      overlay.draw(); 
      mobileMultiple.draw();
      if (homeEllapsed > 6500) {  // multiple zooms in
        mobileMultiple.aniS(5, 28, Ani.QUAD_IN_OUT);
        keyframe ++;
      }
      break;
    case 5:  
      overlay.draw();
      pushMatrix();
      scale(mobileMultiple.s/5);
      cloud.y = layerY - 950;
      cloud.draw();
      drawLayers();
      popMatrix();    
      mobileMultiple.draw();
      for (int i =0; i<cloudNum; i++) { // clouds overlap
        if (homeEllapsed-12000 > 100*i) {
          if (clouds[i].a ==0) clouds[i].aniA(.2f, 1, Ani.SINE_IN_OUT);
          clouds[i].draw();
        }
      }
      if (homeEllapsed > 13000) {  // overlay fades in
        overlay.c = backgroundColor;
        overlay.a = 1;
        overlay.aniA(1, 0, Ani.SINE_IN_OUT);
        mobile.aniZ(1, 2, Ani.SINE_IN_OUT);
        mobile.aniA(1, 1, Ani.SINE_IN_OUT);
        keyframe++;
      }
      break;
    case 6:
      drawDataMatrix();
      overlay.draw();
      mobile.draw();
      float appAngle = millis()/10000.0f;
      float appOffset = 2*PI/appNum;
      for (int i =0; i<appNum; i++) { // apps fade in
        if (homeEllapsed-12000 > 200*i) {
          if (apps[i].a ==0) apps[i].aniA(1, 1, Ani.SINE_IN_OUT);
          apps[i].x = cos(appAngle+appOffset*i)*200*1.7f;
          apps[i].y = sin(appAngle+appOffset*i)*200*1.7f;
          apps[i].draw();
        }
      }
      for (int i =0; i<appNum; i++) {
        if (homeEllapsed-15000 > 200*i) { // apps fade out

          if (boxes[i].a ==0) boxes[i].aniA(.5f, 1, Ani.SINE_IN_OUT);
          boxes[i].x = apps[i].x;
          boxes[i].y = apps[i].y;
          boxes[i].draw();

          if (apps[i].a == 1) apps[i].aniA(.5f, 0.001f, Ani.SINE_IN_OUT);
          apps[i].x = cos(appAngle+appOffset*i)*200*1.7f;
          apps[i].y = sin(appAngle+appOffset*i)*200*1.7f;
          apps[i].draw();
        }
      }
      if (homeEllapsed > 15000 && mobile.a == 1) { // mobile fades out
        mobile.aniA(1, 0, Ani.SINE_IN_OUT);
      }

      if (homeEllapsed > 17000) {
        keyframe++;
      }
      break;
    case 7:
      drawDataMatrix();
      pushMatrix();
      scale(heartZ);
      appAngle = millis()/10000.0f;
      appOffset = 2*PI/appNum;
      for (int i =0; i<appNum; i++) {
        int currentApp = (int)(homeEllapsed-17000)/300;
        if (currentApp >= 0 && currentApp < appNum ) {
          actions[currentApp].draw();
          actions[currentApp].a = 1;
        }
        apps[i].x = cos(appAngle+appOffset*i)*200*1.7f;
        apps[i].y = sin(appAngle+appOffset*i)*200*1.7f;
      }
      for (int i =0; i<appNum; i++) {
        if (homeEllapsed-17000 > 300*i) {  // boxes fade out 
          if (boxes[i].a == 1) {
            boxes[i].aniA(.3f, 0, Ani.SINE_OUT);
            boxes[i].shp = rays;
            boxes[i].shp_ = rays;
            boxes[i].z = 1.2f;
          }
        }
        boxes[i].x = apps[i].x;
        boxes[i].y = apps[i].y;
        boxes[i].draw();
      }
      popMatrix();
      if (homeEllapsed > 19200 && heartZ == 1) Ani.to(this, 7, "heartZ", 100, Ani.SINE_IN_OUT);
      if (homeEllapsed > 19200) {
        keyframe ++;
      }
      break;
    case 8:
      drawDataMatrix();
      pushMatrix();
      scale(heartZ);
      actions[appNum-1].draw();
      home.draw();
      popMatrix();
      z = heartZ / 120;
      home_mask.z = home.z * heartZ ;
      if (homeEllapsed > 20000 && home.a == 0) home.aniA(1, 1, Ani.SINE_IN_OUT);
      if (homeEllapsed > 21000) {    
        keyframe ++;
        home_mask.aniA(3, 0, Ani.SINE_IN_OUT);
      }
      break;
    case 9:
      pushMatrix();
      z = heartZ / 120;
      scale(heartZ);
      actions[appNum-1].draw();
      home.draw();
      home_mask.z = home.z * heartZ;
      if (homeEllapsed > 24000 && logo.a == 0) {    
        logo.aniA(2, 1, Ani.SINE_OUT);
      }
      if (homeEllapsed > 26000 && logo.a == 1) {    
        logo.aniA(.5f, 0.0001f, Ani.SINE_OUT);
      }
      popMatrix();
      logo.draw();
      if (homeEllapsed > 27000 && auto) {    
        goToScene(1);
      }
      break;
    }
  }
}

float startY, layerY;
float layerOffset = 150;
float layerSize = 200;
int modules = 10;
float moduleOffset = layerSize/modules;
int layerNum = 4;
float layersAlpha = 1;
char[][][] matrix = new char[layerNum][modules][modules];
long lastMatrix;

public void drawLayers () {
  pushMatrix();
  translate(0, startY+layerY);
  iso();
  strokeWeight(1.5f);
  textFont(orator, 16);
  textAlign(CENTER, CENTER);
  for (int k=0; k<layerNum; k++) {
    noFill();
    fill(redColor);
    stroke(255, layersAlpha*255);
    rect(0, 0, layerSize, layerSize, 20);
    pushMatrix();
    translate(-layerSize/2, -layerSize/2);
    if (millis() > lastMatrix) {
      lastMatrix = millis() + 100;
      for (int l=0; l<layerNum; l++) {
        for (int i=0; i<modules; i++) {
          for (int j=0; j<modules; j++) {
            if (random(10)<5) {
              matrix[l][i][j] = PApplet.parseChar('A'+(int)random(24));
            }
          }
        }
      }
    }
    for (int rows = 1; rows < modules; rows ++ ) {
      for (int columns = 1; columns < modules; columns ++ ) {
        pushMatrix();
        translate (columns * moduleOffset, rows * moduleOffset);
        fill(255, layersAlpha*255);
        text(matrix[k][rows][columns], 0, 0);
        popMatrix();
      }
    }
    popMatrix();
    translate(0, 0, layerOffset);
  }
  popMatrix();
  hint(ENABLE_DEPTH_TEST);
  fill(redColor);
  noStroke();
  rect(0, -1250, 1000, 2000);
  hint(DISABLE_DEPTH_TEST);
}

int rrr = 9;
int ccc = 16;
float fff;

char[][] dataMatrix = new char[rrr][ccc];
long lastDataMatrix;

public void drawDataMatrix() {
  fff = 1600 / ccc;
  if (millis() > lastMatrix) {
    lastMatrix = millis() + 100;
    for (int i=0; i<rrr; i++) {
      for (int j=0; j<ccc; j++) {
        if (random(10)<5) {
          dataMatrix[i][j] = PApplet.parseChar('A'+(int)random(24));
        }
      }
    }
  }

  textAlign(CENTER, TOP);
  textFont(orator, 128);
  fill(50, 25);
  pushMatrix();
  translate(-1600/2, -900/2);
  for (int rr = 0; rr < rrr; rr ++ ) {
    for (int cc = 0; cc < ccc; cc ++ ) {
      pushMatrix();
      translate (48 + cc * fff, 8+rr * fff);
      text(dataMatrix[rr][cc], 0, 0);
      popMatrix();
    }
  }
  popMatrix();
}
PImage[] leftMovie, rightMovie;

long keyholeStart;
PShape keyhole, keyhole_, keyhole__, keyhole___;
boolean keyholeStatus;
int leftFrame, rightFrame;
int leftDirection, rightDirection;
long frameLast;
float noiseA;

public void initKeyhole() {
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

public void keyholeOn() { 
  keyholeStatus = true;
  keyholeStart = millis();
  leftDirection = 1;
  rightDirection  = 1;
  rightFrame = 0;
  leftFrame = 0;
  noiseA = 1;
  Ani.to(this, 10, "noiseA", 0, Ani.SINE_IN_OUT);
}

public void keyholeOff() {
  keyholeStatus = false;
}

public void drawKeyhole (float thisX, float thisY) {
  if (millis() > frameLast + 1000.0f/24) {
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
  scale(.8f);
  drawSingleKeyhole(0);
  translate(100, -60);
  drawSingleKeyhole(1);
  popMatrix();
}

public void drawSingleKeyhole(int num) {
  long keyholeEllapsed = millis()- keyholeStart;
  if (activeScene == 8 && !keyholeStatus) keyholeOn();
  //if (activeScene != 8 && keyholeStatus) keyholeOff();
  pushMatrix();
  noStroke();
  fill(255);
  shape(keyhole_, -keyhole.width/2, -keyhole.height/2);
  pushMatrix();
  translate(16.7f, 8.6f);
  iso();
  rotateX(radians(-90));
  rotateY(radians(90));


  pushMatrix();
  scale(.062f);
  translate(-28, -2);
  //fill(redColor, 50);
  //rect(0, 0, 480, 480);
  if (keyholeStatus && keyholeEllapsed > 2000) {
    //tint(redColor, 100);
    leftMovie[leftFrame].filter(GRAY);
    rightMovie[rightFrame].filter(GRAY);
    scale(num == 1 ? .95f : 1);
    image(num == 1 ? leftMovie[leftFrame] : rightMovie[rightFrame], 0, 0);
  }
  popMatrix();
  pushMatrix();
  scale(.4f);

  //if (keyholeStatus && keyholeEllapsed > 8000 && noiseA == 1) Ani.to(this, 2, "noiseA", 0, Ani.SINE_IN_OUT);
  if (keyholeStatus && keyholeEllapsed > 12000 && noiseA == 0) Ani.to(this, 2, "noiseA", .9f, Ani.SINE_IN_OUT);

  for (int i= -50; i<50; i=i+1) {
    for (int j= -50; j<50; j=j+1) {
      fill(redColor, random(noiseA*255));
      rect(i, j, 1, 1);
    }
  }
  //}
  popMatrix();

  pushMatrix();
  scale(.062f);
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
long mailboxLast, mailboxStart;
int counter;
boolean mailboxStatus, flagUp;
float mailboxAngle = 0, mailboxTargetAngle = 90;

public void initMailbox() {
  mailbox = loadShape("svg/mailbox.svg");
  mailbox.disableStyle();
  mailbox_ = loadShape("svg/mailbox_.svg");
  mailbox_.disableStyle();
  mailbox_flag = loadShape("svg/mailbox_flag2.svg");
  mailbox_flag.disableStyle();
}

public void mailboxOn() {
  mailboxStatus = true;
  mailboxStart = millis();
  counter = 0;
}

public void mailboxOff() {
  mailboxStatus = false;
}

public void drawMailbox(float thisX, float thisY) {
  long mailboxEllapsed = millis()- mailboxStart;
  if (activeScene == 6 && !mailboxStatus) {
    mailboxOn();
  }
  if (activeScene != 6 && mailboxStatus) {
    mailboxOff();
  }

  pushMatrix();
  translate(thisX, thisY);
  scale(.8f);
  pushMatrix();
  noStroke();
  fill(255);
  shape(mailbox_, -mailbox.width/2, -mailbox.height/2);
  noFill();
  stroke(0);
  strokeWeight(1);
  shape(mailbox, -mailbox.width/2, -mailbox.height/2);
  strokeWeight( z*heavyStroke);
  shape(mailbox_, -mailbox.width/2, -mailbox.height/2);
  popMatrix();
  pushMatrix();
  iso();
  rotateX(radians(-90));
  pushMatrix();
  stroke(redColor);
  fill(255);
  scale(.18f);
  translate(80, 0, -30);
  translate(0, 0, 55);
  strokeWeight( z*heavyStroke);


  if (mailboxStatus) {
    if (mailboxEllapsed > 5000 && mailboxEllapsed < 9000 && mailboxStatus && millis()-mailboxLast > 1000 && counter < 4) {
      mailboxLast = millis();
      mailboxAngle = 45;
      counter ++;
      if (!muted) {
        boing.rewind();
        boing.play();
      }
    }
    if (mailboxEllapsed > 10000 && mailboxStatus && millis()-mailboxLast > 100 && counter > 0) {
      mailboxLast = millis();
      mailboxAngle = 45;
      if (counter == 4 && !muted) {
        bitbit.rewind();
        bitbit.play();
      }
      counter --;
    }
  }
  if (counter > 0) mailboxTargetAngle = 0;
  if (counter == 0) mailboxTargetAngle = 90;
  mailboxAngle += (mailboxTargetAngle-mailboxAngle)*.5f;
  rotateZ(-radians(mailboxAngle));
  shape(mailbox_flag, 0, 0 );
  shape(mailbox_flag, -5, 0 );
  popMatrix();
  rotateY(radians(90));
  noStroke();
  textFont(sevenFont, 15);
  textAlign(LEFT, BOTTOM);
  String counterDisplay = nf(counter, 3, 0)+"";
  for (int i=0; i<3; i++) {
    fill(redColor, 30);
    text("8", 27+(i*9), 58.5f);
    if (mailboxEllapsed > 3000) {
      fill(redColor);
      text(counterDisplay.charAt(i), 27+(i*9), 58.5f);
    }
  }
  popMatrix();
  popMatrix();
}
PImage[] mapImage;
float[] mapImageZ = {.25f, .5f, 1};
PShape marker;
PGraphics mapCanvas;
boolean mapStatus;
boolean mapZoom;
float mapX, mapY, mapZ;
float mapNext;
float mapA;
float scope = 50;
long mapStart;
float mapTx, mapTy;
float mapScaleY;

float[] markerX = {70, 46, -85, -125, -35, 25, 60, -70, -80, -60};
float[] markerY = {0, -18, 70, 30, 20, 50, 60, 30, -30, -50, -150};

boolean mapKill;
boolean mapSound;

public void initMap() {
  marker= loadShape("svg/location_.svg");
  marker.disableStyle();
  map = loadShape("svg/map.svg");
  map.disableStyle();
  map_ = loadShape("svg/map_.svg");
  map_.disableStyle();
  map_mask = loadShape("svg/map_mask.svg");
  map_mask.disableStyle();
  mapImage = new PImage[3];
  mapImage[2] = loadImage("maps/nyc_16x9_2.png");
  mapImage[1] = loadImage("maps/nyc_16x9_1.png");
  mapImage[0] = loadImage("maps/nyc_16x9_0.png");
  mapCanvas =  createGraphics(1600, 900);
  mapCanvas.beginDraw();
  mapCanvas.shapeMode(CORNER);
  mapCanvas.imageMode(CENTER);
  mapCanvas.endDraw();
  mapTx = 0;
  mapTy = 10000;
  //mapScaleY = 1;
}

public void mapOn() {
  mapKill = false;

  mapScaleY = 1;
  mapA = 0;
  mapStatus = true;
  mapStart = millis();
  mapZoom = false;
  mapSound = false;
}

public void mapOff() {
  //Ani.to(this, .5, "mapA", 0.01, Ani.SINE_IN_OUT);
  mapKill = false;
  mapStatus = false;
}

public void drawMap(float thisX, float thisY) {
  if (activeScene == 3 && !mapStatus) {
    mapOn();
  }
  if (activeScene != 3 && mapStatus && !mapKill) {
    mapKill = true;
  }
  long mapEllapsed = millis() - mapStart;
  mapTx += .0025f;
  mapTy += .0025f;
  if (mapStatus) {
    if (mapEllapsed > 2000 && mapA == 0) {
      if (!muted) {
        ready.rewind();
        ready.play();
      }
      Ani.to(this, 3, "mapA", 1, Ani.SINE_IN_OUT);
    }
    if (mapEllapsed < 6500) {
      mapZ = 1.7f + sin(mapEllapsed/1000.0f)/4;
      mapX = map(noise(mapTx), 100, 1, -scope, scope);
      mapY = map(noise(mapTy), 100, 1, -scope, scope);
    }
    if (mapEllapsed > 6500 && mapZoom == false) {
      mapZoom = true;
      Ani.to(this, 3.5f, "mapX", -46, Ani.SINE_IN_OUT);
      Ani.to(this, 3.5f, "mapY", 18, Ani.SINE_IN_OUT);
      Ani.to(this, 3.5f, "mapZ", 20, Ani.SINE_IN_OUT);
      if (!muted) {
        zoomin.rewind();
        zoomin.play();
      }
    }
    if (mapEllapsed > 11500 && mapScaleY == 1) {
      Ani.to(this, .3f, "mapScaleY", 0, Ani.SINE_OUT);
      if (!muted) {
        offff.rewind();
        offff.play();
      }
    }
    if (mapKill && mapEllapsed > 12000) {
      mapOff();
    }
  }
  pushMatrix();
  translate(thisX, thisY);
  noStroke();
  fill(255);
  shape(map_, -map.width/2, -map.height/2);
  pushMatrix();
  iso();
  rotateX(radians(-90));
  scale(.115f);
  translate(-45, 80);
  if (mapStatus || mapKill) {
    if (mapA > 0) {
      mapCanvas.beginDraw();
      mapCanvas.translate(mapCanvas.width/2, mapCanvas.height/2);
      mapCanvas.scale(mapZ);
      mapCanvas.translate(mapX, mapY);
      mapCanvas.background(255);
      mapCanvas.tint(255, 200);
      if (mapZ < 3) {
        mapCanvas.image(mapImage[2], 0, 0);
      } 
      if (mapZ >= 3 && mapZ <= 9) {
        mapCanvas.pushMatrix();
        mapCanvas.scale(mapImageZ[1]);
        mapCanvas.image(mapImage[1], 0, 0);
        mapCanvas.popMatrix();
      }
      if (mapZ > 9) {
        mapCanvas.pushMatrix();
        mapCanvas.scale(mapImageZ[0]);
        mapCanvas.image(mapImage[0], 0, 0);
        mapCanvas.popMatrix();
      }
      mapCanvas.noStroke();
      mapCanvas.scale(1.0f/mapZ);
      for (int i=0; i<markerX.length; i++) {
        mapCanvas.pushMatrix();
        mapCanvas.ellipseMode(CENTER);
        mapCanvas.translate(markerX[i]*mapZ, markerY[i]*mapZ);
        mapCanvas.scale(1);
        mapCanvas.fill(redColor);
        mapCanvas.shape(marker, -100, -100);
        mapCanvas.fill(255);
        mapCanvas.popMatrix();
      }
      if (mapEllapsed > 9000) {
        if (!mapSound && !muted) {
          mapSound = true;
          pattern.rewind();
          pattern.play();
        }

        float angle = PI/2+millis()/5000.0f;
        float offset = 2*PI/satNum;
        float radius = 100;

        for (int i=0; i < satNum; i++) {

          if (mapEllapsed > 9000+(i*200)) {
            mapCanvas.pushMatrix(); 
            float x = markerX[1]*mapZ+cos(angle+offset*i)*radius*1.7f;
            float y = markerY[1]*mapZ+sin(angle+satOffset*i)*radius*1.7f;
            mapCanvas.translate(x, y);
            mapCanvas.fill(255);
            mapCanvas.ellipse(0, 0, 90, 90);
            mapCanvas.fill(redColor);
            mapCanvas.scale(.6f);
            mapCanvas.shape(satellites[i].shp, 0, 0);
            //satellites[i].draw();
            mapCanvas.popMatrix();
          }
        }
      }
      mapCanvas.endDraw();
    }
    pushMatrix();
    scale(1, mapScaleY);
    image(mapCanvas, 0, 0);
    popMatrix();
  }    
  if (mapA < 1) {
    fill(255, 255*(1-mapA));
    rect(0, 0, mapCanvas.width, mapCanvas.height);
  }
  fill(redColor, 30);
  rect(0, 0, mapCanvas.width, mapCanvas.height);
  popMatrix();
  noStroke();
  fill(255);
  shape(map_mask, -map.width/2, -map.height/2);
  noFill();
  stroke(0);
  strokeWeight(1);
  shape(map, -map.width/2, -map.height/2);
  strokeWeight( z*heavyStroke);
  shape(map_, -map.width/2, -map.height/2);
  popMatrix();
}
class Object {
  int c;
  float a, x, y, z;

  public void aniX (float tt, float xx, Easing ee) {
    Ani.to(this, tt, "x", xx, ee);
  }

  public void aniY (float tt, float yy, Easing ee) {
    Ani.to(this, tt, "y", yy, ee);
  }

  public void aniZ (float tt, float zz, Easing ee) {
    Ani.to(this, tt, "z", zz, ee);
  }

  public void aniA (float tt, float aa, Easing ee) {
    Ani.to(this, tt, "a", aa, ee);
  }
}

class TextObject extends Object {
  String content = "";
  int fontSize = 48;
  boolean centered;

  public void draw() {
    pushMatrix();
    translate(x, y);
    scale(z);
    fill(c, a*255);
    noStroke();
    textAlign(centered ? CENTER : LEFT, CENTER);
    textFont(helvetica, fontSize);  
    text(content, 0, -fontSize/8);
    popMatrix();
  }
}

class OverlayObject extends Object {
  public void draw() {
    fill(c, a*255);
    rect(0, 0, 1600, 900);
  }
}

class MultipleObject extends ShapeObject {
  int rows = 10, columns = 16; 
  float s;

  public void aniS (float tt, float ss, Easing ee) {
    Ani.to(this, tt, "s", ss, ee);
  }

  public void draw () {
    pushMatrix();
    scale(s);
    translate(x-(200*columns/2), y-(200*rows/2));
    for (int i = 0; i < rows; i++) {
      pushMatrix();
      for (int j = 0; j <columns; j++ ) {
        pushMatrix();
        scale(z);
        fill(c, a*255);
        noStroke();
        shape(shp, 0, 0);
        popMatrix();
        translate(200, 0);
      }
      popMatrix();
      translate(0, 200);
    }  
    popMatrix();
  }
}

class IconObject extends ShapeObject {
  String content  = "";

  public void draw() {
    pushMatrix();
    translate(x, y);
    scale(z);
    pushMatrix();
    translate(8, 8);
    scale(180.0f/shadow.width*1.15f);
    tint(255, a*255);
    image(shadow, 0, 0);
    noTint();
    popMatrix();
    noStroke();
    fill(c, a*255);
    ellipse(0, 0, 180, 180);
    fill(255, a*255);
    shape(shp, 0, -15);
    textFont(orator, 22);
    textAlign(CENTER, CENTER);
    text(content.toUpperCase(), 0, 47);
    popMatrix();
  }
}

class BoxObject extends ShapeObject {
  PShape shp;

  public void init() {
    shp_.disableStyle();
    shp.disableStyle();
    findBoundsOutline(shp);
    dimension = new PVector(vMax.x-vMin.x, vMax.y - vMin.y);
    location = new PVector(0, 0);
  }

  public void draw() {
    pushMatrix();
    translate(x, y);
    scale(z);
    translate(-500, -500);
    fill(255, 255*a);
    noStroke();
    shape(shp_, 0, 0);
    noFill();
    stroke(0, a*255);
    strokeWeight(1);
    shape(shp, 0, 0);
    strokeWeight(heavyStroke);
    shape(shp_, 0, 0);
    popMatrix();
  }
}

class ShapeObject extends Object {
  int c_ = 255;
  PShape shp, shp_;
  PVector vMin = new PVector(1000, 1000);
  PVector vMax = new PVector(0, 0);
  PVector dimension, location;

  public void init() {
    shp.disableStyle();
    if (shp_ != null) {
      shp_.disableStyle();
    }
    findBoundsOutline(shp);
    dimension = new PVector(vMax.x-vMin.x, vMax.y - vMin.y);
    location = new PVector(0, 0);
  }

  public void findBoundsOutline(PShape outline) {
    for (int j=0; j<outline.getChildCount(); j++) {
      PShape contour = outline.getChild(j);
      PShape path ;
      if (contour.getVertexCount() == 0) {
        for (int k=0; k<contour.getChildCount(); k++) {
          path = contour.getChild(k);
          findBoundsPath(path);
        }
      } else {
        path = contour;
        findBoundsPath(path);
      }
    }
  }

  public void findBoundsPath(PShape path) {
    for (int i=0; i<path.getVertexCount(); i++) {
      PVector v = new PVector(0, 0);
      v = path.getVertex(i);
      if (v.x != 0 && v.y != 0) {
        if (v.x > vMax.x) vMax.x = v.x;
        if (v.y > vMax.y) vMax.y = v.y;
        if (v.x < vMin.x) vMin.x = v.x;
        if (v.y < vMin.y) vMin.y = v.y;
      }
    }
  }

  public void draw() {
    pushMatrix();
    translate(x, y);
    scale(z);
    noStroke();
    if (shp_ != null) {
      fill(c_, a * 255);
      shape(shp_, 0, 0);
    }
    fill(c, a*255);
    shape(shp, 0, 0);
    popMatrix();
  }
}
float tapeWidth = 13;
float left, right;
float leftS, rightS;
float leftTarget, rightTarget;
PShape download, upload, arrow;
boolean reelStatus;
long reelStart;
long leftNext, rightNext;

public void reelOn() {
  reelStatus = true;
  reelStart = millis();
  leftS = 0;
  rightS = 0;
  leftTarget = 0;
  rightTarget = 0;
}

public void reelOff() {
  reelStatus = false;
  leftS = 0;
  rightS = 0;
  leftTarget = 0;
  rightTarget = 0;
}

public void initReel() {
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

public void drawReel(float thisX, float thisY) {
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
      leftTarget = random(.5f);
      if (random(1)< .3f) leftTarget = 0;
    }
    if (millis() > rightNext) {
      rightNext = millis() + (int)random(1000);
      rightTarget = random(1)/10;
      if (random(1)< .4f) rightTarget = 0;
    }
  }
  leftS += (leftTarget - leftS) *.1f;
  rightS += (rightTarget - rightS) *.1f;
  left += leftS;
  right -= rightS;
  pushMatrix();
  translate(thisX, thisY);
  scale(.6f);
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
  scale(.078f);
  translate(-725, 0, 0);
  pushMatrix();
  rotateZ(left);
  stroke(redColor);
  fill(255);
  strokeWeight(z*heavyStroke*.6f);  
  shape(reel_tape, 0, 0 );
  shape(reel_tape, -tapeWidth, 0 );
  popMatrix();
  pushMatrix();
  scale(1.1f);
  translate(0, 500);
  fill(redColor, leftS > .05f ? 255 : 20);
  noStroke();
  shape(download, 0, 0);
  translate(0, 60);
  rotate(PI);
  scale(1.1f);
  shape(arrow, 0, 0);
  popMatrix();
  translate(925, 0, 0);
  stroke(redColor);
  fill(255);
  stroke(redColor);
  fill(255);
  strokeWeight(z*heavyStroke*.6f);
  pushMatrix();
  rotateZ(right);
  shape(reel_tape, 0, 0 );
  shape(reel_tape, -tapeWidth, 0 );
  popMatrix();
  pushMatrix();
  scale(1.1f);
  translate(0, 500);
  fill(redColor, rightS > .02f ? 255 : 20);
  noStroke();
  shape(upload, 0, 0);
  translate(0, 60);
  scale(1.1f);
  shape(arrow, 0, 00);
  popMatrix();
  popMatrix();
  popMatrix();
}



Minim minim;
AudioPlayer whistle, notification, skypeCall, soundtrack, bitbit, offline, dial, pattern, ready, event, boing, bubble, twobubbles, offff, zoomin, click;

AudioPlayer skype1, hangup;

public void initSound()
{
  minim = new Minim(this);
  whistle = minim.loadFile("sounds/Whatsapp Notification Sound (Whistle).mp3");
  notification =  minim.loadFile("sounds/WhatsApp Sound Original Message.mp3");  
  skypeCall =  minim.loadFile("sounds/skypeCallMuted.mp3");
  skype1 =  minim.loadFile("sounds/skype1.mp3");
  soundtrack = minim.loadFile("sounds/07 fold air.mp3");
  hangup = minim.loadFile("sounds/hangup.mp3");
  offline = minim.loadFile("sounds/offline.mp3");
  bitbit = minim.loadFile("sounds/bitBit.mp3");
  dial = minim.loadFile("sounds/dialTone.mp3");
  pattern = minim.loadFile("sounds/pattern.mp3");
  ready = minim.loadFile("sounds/ready.mp3");
  event = minim.loadFile("sounds/event.mp3");
  boing = minim.loadFile("sounds/boing.mp3");
  bubble = minim.loadFile("sounds/bubble.mp3");
  twobubbles = minim.loadFile("sounds/twoBubbles.mp3");
  offff = minim.loadFile("sounds/offff.mp3");
  zoomin = minim.loadFile("sounds/zoomin.mp3");
  click = minim.loadFile("sounds/click.mp3");
}

//void updateSound()
//{
//  stroke(redColor);
//  for (int i = 0; i < whistle.bufferSize() - 1; i++)
//  {
//    line(i, 50  + whistle.left.get(i)*50, i+1, 50  + whistle.left.get(i+1)*50);
//    line(i, 150 + whistle.right.get(i)*50, i+1, 150 + whistle.right.get(i+1)*50);
//  }
//}
String suitcaseDisplay = "";
long suitcaseLast, suitcaseStart;
boolean suitcaseStatus;
int suitcaseMode = 0;

public void initSuitcase() {
  suitcase = loadShape("svg/suitcase.svg");
  suitcase.disableStyle();
  suitcase_ = loadShape("svg/suitcase_.svg");
  suitcase_.disableStyle();
}

int clickCounter, lastClickCounter;

public void suitcaseOn() {
  suitcaseStatus = true;
  suitcaseStart = millis();
  idle = false;
  for (int i=0; i<4; i++) {
    frameReady[i] = false;
  }
  clickCounter = 0;
  lastClickCounter = 0;
}

public void suitcaseOff() {
  suitcaseStatus = false;
}

long sentenceStart;

public void drawSuitcase(float thisX, float thisY) {

  if (activeScene == 4 && !suitcaseStatus) {
    suitcaseOn();
  }
  if (activeScene != 4 && suitcaseStatus) {
    suitcaseOff();
  }

  long suitcaseEllapsed = millis() - suitcaseStart;

  pushMatrix();
  translate(thisX, thisY);
  scale(.8f);
  pushMatrix();
  noStroke();
  fill(255);
  shape(suitcase_, -suitcase.width/2, -suitcase.height/2);
  noFill();
  stroke(0);
  strokeWeight(1);
  shape(suitcase, -suitcase.width/2, -suitcase.height/2);
  strokeWeight( z*heavyStroke);
  shape(suitcase_, -suitcase.width/2, -suitcase.height/2);
  popMatrix();
  pushMatrix();
  iso();
  rotateX(radians(-90));
  rotateY(radians(90));
  noStroke();
  textAlign(LEFT, BOTTOM);
  textFont(sevenFont, 17.5f);
  //textSize(17.5);
  if (suitcaseEllapsed < 2000 && millis()-suitcaseLast > 30) {
    suitcaseLast = millis();
    suitcaseDisplay= "";
    String targetText = "40 43'N  73 55'W                  ";
    for (int i=0; i<24; i++) {
      int pos = PApplet.parseInt(suitcaseEllapsed/2000.0f*24);
      suitcaseDisplay += i < pos ? targetText.charAt(i) : " ";
    }
  }

  if (suitcaseEllapsed < 2000) {
    suitcaseDisplay = "40 43'N  73 55'W";
    sentenceStart = suitcaseStart+0;
    //clickCounter ++;
  }
  if (suitcaseEllapsed > 2000 && suitcaseEllapsed < 4000) {
    suitcaseDisplay = "Greenpoint Brooklyn NY";
    sentenceStart = suitcaseStart+2000;
    if (!muted && clickCounter == 0) {
      clickCounter ++;
      click.rewind();
      click.play();
    }
  }
  if (suitcaseEllapsed > 4000 && suitcaseEllapsed < 6000) {
    suitcaseDisplay = "The G Train is delayed";
    sentenceStart = suitcaseStart+4000;
    if (!muted && clickCounter == 1) {
      clickCounter ++;
      click.rewind();
      click.play();
    }
  }
  if (suitcaseEllapsed > 6000 && suitcaseEllapsed < 8000) {
    suitcaseDisplay = "as usual";
    sentenceStart = suitcaseStart+6000;
    if (!muted && clickCounter == 2) {
      clickCounter ++;
      click.rewind();
      click.play();
    }
  }
  if (suitcaseEllapsed > 8000 && suitcaseEllapsed < 10000) {
    suitcaseDisplay = "bus b62 leaving soon";
    sentenceStart = suitcaseStart+8000;
    if (!muted && clickCounter == 3) {
      clickCounter ++;
      click.rewind();
      click.play();
    }
  }
  if (suitcaseEllapsed > 10000 && suitcaseEllapsed < 12000) {
    suitcaseDisplay = "you better Hurry up";
    sentenceStart = suitcaseStart+10000;
    if (!muted && clickCounter == 4) {
      clickCounter ++;
      click.rewind();
      click.play();
    }
  }
  if (suitcaseEllapsed > 12000 && suitcaseEllapsed < 13000) {
    sentenceStart = suitcaseStart+12000;
    if (millis() - suitcaseLast > 100) {
      suitcaseLast = millis();
      suitcaseDisplay= "";
      for (int i=0; i<24; i++) {
        suitcaseDisplay += PApplet.parseChar(PApplet.parseInt(random(10))+48) ;
      }
    }
  }
  fill(redColor, 20);
  for (int i=0; i<24; i++) {
    text("8", -90+(i*8), 13 );
  }
  fill(redColor);
  if (suitcaseStatus) suitcaseDisplay += ((millis()%500 < 250) ? "" : "_");

  for (int i=0; i<suitcaseDisplay.length(); i++) {
    if (millis()-sentenceStart > i * 30) {
      text(suitcaseDisplay.charAt(i), -90+(i*8), 13);
    }
  }
  popMatrix();
  popMatrix();
}
Globe globe;

int globeR = 170;
float globeA;
float globeZ;
int satNum = 9;

ShapeObject[] satellites;
float satAngle = 0;
float satOffset = 2*PI/satNum;

//long globeStart = 0;
long globeNext = 0;
int globeCounter = 0;

String[] satelliteShapes = {"nerd", "woman", "glasses", "necktie", "curly", "ponytail", "beard", "moustache", "freaky"};

public void initGlobe() {
  globe = new Globe(globeR, 32, "img/world_red3.png");
  satellites = new ShapeObject[satNum];
  for (int i=0; i < satNum; i++) {
    satellites[i] = new ShapeObject();
    //satellites[i].a = 0;
    satellites[i].c = darkGreyColor;
    //satellites[i].z = 0;
    satellites[i].shp = loadShape("svg/profiles/"+satelliteShapes[i]+".svg");
    satellites[i].init();
  }
}

float rotation;
float rotationSpeed = .005f;
boolean back, sat;

public void globeOn() {
  for (int i=0; i < satNum; i++) {
    satellites[i].a = 0;
    satellites[i].z = 0;
  }
  rotation = 2.4f;
  globeCounter = 0;
  globeNext = millis() + 500;
  globeZ = 0;
  globeA = 0;
  satAngle = -PI/2;
  back = false;
  sat = true;
}

public void drawGlobe() {

  pushMatrix();
  scale(globeZ);
  pushMatrix();
  rotation += rotationSpeed;
  rotateY(rotation);
  rotateZ(radians(-15));
  noStroke();
  hint(ENABLE_DEPTH_TEST);
  globe.render(); 
  hint(DISABLE_DEPTH_TEST);
  popMatrix();

  if (sat) {
    satAngle += rotationSpeed;

    if (!back && millis() > globeNext) {
      globeNext = millis() + 200;
      satellites[globeCounter].aniZ(2, .5f, Ani.SINE_IN_OUT);
      satellites[globeCounter].aniA(2, 1, Ani.SINE_IN_OUT);
      globeCounter ++;
      if (globeCounter == satNum) {
        globeCounter = 0;
        globeNext = millis() + 1000;
        back = true;
      }
    }


    if (back && millis() > globeNext && globeCounter < satNum) {
      globeNext = millis() + 100;
      satellites[globeCounter].aniZ(.4f, 0, Ani.SINE_IN_OUT);
      satellites[globeCounter].aniA(.4f, 0, Ani.SINE_IN_OUT);
      globeCounter ++;
    }

    for (int i=0; i < satNum; i++) {
      pushMatrix(); 
      //if (satellites[i].a > 0.2 ) {
      satellites[i].x = cos(satAngle+satOffset*i)*globeR*1.7f;
      satellites[i].y = sin(satAngle+satOffset*i)*globeR*1.7f;

      float offset = 15*satellites[i].z;
      
      tint(255, satellites[i].a*255*.8f);
      image(shadow, satellites[i].x+offset, satellites[i].y+offset, 220*satellites[i].z, 220*satellites[i].z);
      noTint();
      fill(255, satellites[i].a*255);

      ellipse(satellites[i].x, satellites[i].y, 200*satellites[i].z, 200*satellites[i].z);
      satellites[i].draw();
      //}
      popMatrix();
    }
  }
  noStroke();
  fill(backgroundColor, (1-globeA) * 255);
  ellipse(0, 0, globeR*2, globeR*2);
  popMatrix();
}

class Globe {
  PImage 
    txtMap;
  int 
    globeRadius; 
  float 
    rWRatio, 
    rHRatio, 
    ROTATION_FACTOR=.01f*DEG_TO_RAD;
  PVector   
    rotation, 
    rotSpeed;

  // Textured sphere implementation 
  float[][] 
    texturedSphereX, 
    texturedSphereY, 
    texturedSphereZ, 
    texturedSphereU, 
    texturedSphereV; 
  int   
    texturedSphereDetail;


  Globe(int _radius, int _sphereDetail, String _mapFilename) {
    globeRadius = _radius;
    txtMap = loadImage(_mapFilename);
    rWRatio= txtMap.width/globeRadius;
    rHRatio= txtMap.height/globeRadius;
    setTexturedSphereDetail(_sphereDetail); 
    rotation= new PVector(0, HALF_PI);
    rotSpeed= new PVector(0, 0);
  }

  public void setTexturedSphereDetail(int detail) {   //Set the detail level for textured spheres, constructing the underlying vertex and uv map data  
    if (detail == texturedSphereDetail) return; 
    texturedSphereDetail = detail; 
    float step = PI / detail; 
    float ustep = .5f / detail; 
    float vstep = 1.f / detail; 
    int d1= detail+1;
    int d2= detail*2 +1;

    texturedSphereX = new float[d1][d2]; 
    texturedSphereY = new float[d1][d2]; 
    texturedSphereZ = new float[d1][d2]; 
    texturedSphereU = new float[d1][d2]; 
    texturedSphereV = new float[d1][d2]; 

    for (int i = 0; i <= detail; i++) { 
      float theta = step * i; 
      float y = cos(theta); 
      float sin_theta = sin(theta); 
      float v = 1.0f - vstep * i; 

      for (int j = 0; j <= 2 * detail; j++) { 
        float phi = step * j; 
        float x = sin_theta * cos(phi); 
        float z = sin_theta * sin(phi); 
        float u = 1.0f - ustep * j; 

        texturedSphereX[i][j] = x * globeRadius; 
        texturedSphereY[i][j] = y * globeRadius; 
        texturedSphereZ[i][j] = z * globeRadius; 
        texturedSphereU[i][j] = u * txtMap.width; 
        texturedSphereV[i][j] = v * txtMap.height;
      }
    }
  }

  public void render() {  // draw the sphere
    int nexti, t2= 2*texturedSphereDetail;
    for (int i = 0; i < texturedSphereDetail; i=nexti) { 
      nexti = i + 1;   
      beginShape(QUAD_STRIP); 
      texture(txtMap); 
      for (int j=0; j<=t2; j++) {         
        float u  = texturedSphereU[i][j]; 
        float x1 = texturedSphereX[i][j]; 
        float y1 = texturedSphereY[i][j]; 
        float z1 = texturedSphereZ[i][j]; 
        float v1 = texturedSphereV[i][j]; 
        float x2 = texturedSphereX[nexti][j]; 
        float y2 = texturedSphereY[nexti][j]; 
        float z2 = texturedSphereZ[nexti][j]; 
        float v2 = texturedSphereV[nexti][j]; 
        vertex(x1, y1, z1, u, v1); 
        vertex(x2, y2, z2, u, v2);
      }   
      endShape();
    }
  }

  //  void addRotation(int mX, int mY, int pmX, int pmY) {
  //    rotSpeed.x += (pmY-mY)* ROTATION_FACTOR;
  //    rotSpeed.y -= (pmX-mX)* ROTATION_FACTOR;
  //  }
  //
  //  void update() {
  //    // w.addRotation(0, 0, -int(rotationSpeed*10000), 0);
  //    // theta1 = sin(angle*orbitSpeed) * scalar;
  //    // rotSpeed.x += rotationSpeed*360;
  //    rotation.add(rotSpeed);
  //    rotSpeed.mult(.95);
  //  }
}
  public void settings() {  size(1280, 720, OPENGL);  smooth(16); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "tele_video" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
