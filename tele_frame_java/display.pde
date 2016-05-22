int displayW = 240;
color redColor = color(190, 30, 45);
PFont orator;
int overlay = 255;

final int BLANK = 0;
final int CONTACTS = 1;
final int IMAGERY = 2;
final int CAM = 3;

class Display {
  int mode = CONTACTS ;
  PImage imagery;

  Display () {
    orator = createFont("Helvetica", 128);
  }

  void display() {
    translate(width/2, height/2);
    scale(height/240.0);
    switch (mode) {
    case BLANK:
      fill(255);
      rectMode(CENTER);
      rect(0, 0, width, height);
      break;
    case CONTACTS:
      //if (debug) println("new contact");
      scale(1.018);
      drawItems();


      break;
    case IMAGERY:
      background(50);
      if (imagery != null) {
        if (imagery.width > 0) {
          pushMatrix();
          scale(240.0/imagery.height*1.01);
          image(imagery, 0, 0);
          popMatrix();
        }
      }
      break;
    case CAM:
      background(0, 0, 255);
      updateCam();
      pushMatrix();
      scale(240.0/cam.height*1.01);
      image(cam, 0, 0);
      popMatrix();
      break;
    }
    if (overlay > 2) {
      fill(255, overlay);
      rectMode(CENTER);
      rect(0, 0, width, height);
      overlay -= 4;
    }

    if (android) {
      fill(0);
      pushMatrix();
      scale(2.15);
      shape(mask, 0, 0);
      popMatrix();
      translate(-360/2, -height/2);
      rectMode(CORNER);
      rect(0, 0, 60, height);
      rect(360-60, 0, 60, height);
    }
  }

  void drawItems() {
    float tempX = currentX + currentFace * displayW;
    faces[currentFace-1 >= 0 ? currentFace - 1 : currentFace + faceNum - 1].display(tempX - displayW);
    faces[currentFace+1 <= faceNum - 1 ? currentFace + 1 : currentFace + 1 - faceNum].display(tempX + displayW);
    faces[currentFace].display(tempX);
  }
}

class Photo {
  String url;
  PImage img;

  Photo (String def) {
    img = loadImage(url);
    img.resize(displayW, displayW);
  }

  void display(float x) {
    if (img != null) {
      pushMatrix();
      translate(x, 0);
      //scale(240.0/img.width);
      image(img, 0, 0);
      popMatrix();
    }
  }
}


class Face {
  String name;
  String lastName;
  String initials;
  String url;

  PImage img;
  int phase = 0;
  boolean ready = false;
  Face (String def) {
    String[] items = splitTokens(def, ",");
    name = items[0];
    lastName = items[1];
    initials = items[2];
    url = items[3];
    img = loadImage("img/"+url+".png");
    img.resize(displayW, displayW);
  }

  void display(float x) {
    if (img != null) {
      pushMatrix();
      translate(x, 0);
      image(img, 0, 0);
      popMatrix();
    }

    //fill(255, 100);
    //textFont(orator, 20);
    //float nameWidth = textWidth(name+"  ");
    //rect(x-nameWidth/2, -15, nameWidth, 30);
    //fill(redColor);
    //textAlign(CENTER, CENTER);
    //text(name.toUpperCase(), x, 0);
  }
}

float attract(float val, float targetVal, int snap, int speed) {
  if (abs(targetVal - val) > snap) { 
    //moving = true;
    float delta = (targetVal - val)  / speed * 1.0;
    val += delta;
  } else {
    val = targetVal;
  }
  return val;
}