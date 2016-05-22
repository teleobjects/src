int lastMouseX, startMouseX;
int lastMouseY, startMouseY;
long lastPress;
int debounceTime = 100;
boolean clicked;
int dragDistance;
int snap = 1;
boolean dragging;
boolean moving;
boolean action;

long firstClick;

float accelerometerX, accelerometerY, accelerometerZ;
float tilt;

int doubleClickTime = 1000;
//boolean firstClick;
int clickCount =0 ;
float currentX = 0;
float targetX;

Face[] faces;
int faceNum ;
int currentFace = 0;
int lastFace = 0;

String[] buffer;
long last;
Photo[] instagram;

PShape app, mask;
Display display;

import java.io.File;
File folder;
String [] filenames;
long lastMove;
long lastTilt;

//long lastDweet;

boolean debug = true;
boolean android = true;

void setup() {
  //size(320, 240);
  fullScreen(JAVA2D);
  initSensors();
  orientation(LANDSCAPE);
  println(width+" "+height+"px");
  buffer= loadStrings("csv/contact_list.csv");
  app = loadShape("shp/app.svg");
  app.disableStyle();
  mask = loadShape("shp/mask.svg");
  mask.disableStyle();
  faceNum = 25;
  imageMode(CENTER);
  rectMode(CENTER);
  noStroke();
  faces = new Face[faceNum];
  for (int i=0; i<faceNum; i++) {
    faces[i] = new Face(buffer[i]);
  }
  dragDistance = 10;
  display = new Display();
  //java.io.File folder = new java.io.File(sketchPath("instagram/"));
  //filenames = folder.list();
  //println(filenames.length + ".properties.ser");
  //faceNum = 50;//filenames.length;
  //instagram = new Photo[filenames.length];
  //for (int i = 0; i <= filenames.length-1; i++)
  //{
  //  if (filenames[i].charAt(0) != '.') {
  //    instagram[i] = new Photo(filenames[i]);
  //  }
  //}
  initThing();
}

void draw() {

  if (millis() - lastDweet > refresh && millis()-lastTilt > 2000) {
    lastDweet = millis();
    getDweet();
  }

  currentX =  attract(currentX, targetX, snap, 10);
  if (currentX > 0) {
    currentX -= faceNum*displayW;
    targetX -= faceNum*displayW;
    lastMove = millis();
  }  
  if (currentX <= -faceNum * displayW) {
    currentX += faceNum*displayW;
    targetX += faceNum*displayW;
    lastMove = millis();
  }

  //if (currentX == targetX) moving = false;

  if (clicked) {
    display.mode ++;
    if (display.mode == 3) display.mode = 1;
    clicked = false;
  }
  if (android) {
    tilt = accelerometerY;
    if (abs(tilt) > 2) {
      lastTilt = millis();
      targetX += tilt*2;
      display.mode = CONTACTS;
    }
    if (abs(tilt) <= 2) {
      lastMove = millis();
      if ((targetX%displayW) > -displayW/2) {
        targetX -= (targetX%displayW);
      } else {
        targetX -= (targetX%displayW);
        targetX -= displayW;
      }
    }
  }
  currentFace = (int)((-currentX)/ displayW);

  if (abs(tilt) < 2 && currentX == targetX) {

    if (currentFace != lastFace) {
      lastFace = currentFace;
      String name =  faces[currentFace].name;
      if (faces[currentFace].lastName.length()> 1) {
        name += " "+faces[currentFace].lastName;
      }
      sendDweet("CONTACTS", name+"|"+faces[currentFace].url);
    }
  }
  if (dragging && !action) {
    lastPress = millis();
    if (mouseX-startMouseX > dragDistance) {
      targetX +=displayW;
      startMouseX = mouseX;
      action = true;
      moving = true;
      lastMove = millis();
    } else if (startMouseX-mouseX > dragDistance) {
      targetX -=displayW;
      startMouseX = mouseX;
      action = true;
      moving = true;
      lastMove = millis();
    }
  }

  display.display();


  //if (abs(accelerometerX) > 3) {
  //  if (accelerometerX > 0) {
  //    display.mode ++;
  //    if ( display.mode > 4)  display.mode = 1;
  //  }
  //  if (accelerometerX < 0) {
  //    display.mode --;
  //    if ( display.mode ==0)  display.mode = 3;
  //  }
  //}

  //if (millis() - last > 1000) {
  //  last = millis();
  //  targetX +=displayW;
  //}
  if (millis() - firstClick > doubleClickTime) {
    clickCount = 0;
  }
  if (dragging && millis() - lastPress > 500) {
    //display.mode = 1;
  }
}

void keyPressed() {
  if (key >= 48 && key < 59) {
    //display.mode = key-48;
  }
}

void mousePressed() {
  lastPress = millis();

  if (!dragging) {
    startMouseX = mouseX;
    startMouseY = mouseY;
    lastMouseX = mouseX;
    lastMouseY = mouseY;
    dragging = true;
  } else {
    lastMouseX = mouseX;
    lastMouseY = mouseY;
  }

  //println("click");
  if (clickCount ==0) firstClick = millis();
  clickCount ++;
  lastMove = millis();

  if (clickCount==2) {  // double-click
    //println("double-click");
    //clicked = true;
  }
  if (clickCount==3) {  // double-click
    //println("double-click");
    clicked = true;
  }
}

void mouseReleased() {
  if (mouseX != startMouseX) {
    clicked = false;
  }
  dragging = false;
  action = false;
}