import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.io.File; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class tele_frame_java extends PApplet {

int lastMouseX, startMouseX;
int lastMouseY, startMouseY;
long lastPress;
int debounceTime = 100;
boolean clicked;
int dragDistance;
int snap = 2;
boolean dragging;
boolean moving;
boolean action;

int currentX = 0;
int targetX;

Face[] faces;
int faceNum ;
int currentFace = 0;

String[] buffer;
long last;
Photo[] instagram;

PShape app, mask;
Display display;


File folder;
String [] filenames;

//long lastDweet;

boolean debug = false;

public void setup() {
  //fullScreen();
  
  // orientation(LANDSCAPE);

  buffer= loadStrings("csv/contact_list.csv");
  app = loadShape("shp/app.svg");
  app.disableStyle();
  mask = loadShape("shp/mask.svg");
  mask.disableStyle();
  //shapeMode(CENTER);
  faceNum = 5;//buffer.length;
  imageMode(CENTER);
  rectMode(CENTER);
  noStroke();
  //smooth(8);
  //background(255);
  //noCursor();
  //textAlign(LEFT, TOP); 
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

public void draw() {
  //background(255);
  display.display();

  if (display.mode == IMAGERY) {
    if (millis() - lastDweet > refresh) {
      lastDweet = millis();
      getDweet();
    }
    //displayDweet(20, 20);
  }

  moving = false;
  currentX =  attract(currentX, targetX, snap, 3);
  if (currentX > 0) {
    currentX -= faceNum*displayW;
    targetX -= faceNum*displayW;
  }
  if (currentX <= -faceNum * displayW) {
    currentX += faceNum*displayW;
    targetX += faceNum*displayW;
  }
  currentFace = (int)((-currentX)/ displayW);

  if (clicked) {
    display.mode ++;
    if (display.mode == 3) display.mode = 0;

    clicked = false;
  }

  if (dragging && !moving && !action) {
    lastPress = millis();
    if (mouseX-startMouseX > dragDistance) {
      targetX +=displayW;
      startMouseX = mouseX;
      action = true;
    } else if (startMouseX-mouseX > dragDistance) {
      targetX -=displayW;
      startMouseX = mouseX;
      action = true;
    }
  }

  //if (millis() - last > 1000) {
  //  last = millis();
  //  targetX +=displayW;
  //}
}

public void keyPressed() {
  if (key >= 48 && key < 59) {
    display.mode = key-48;
  }
}

public void mousePressed() {
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
}

public void mouseReleased() {
  clicked = true;

  if (mouseX != startMouseX) {
    clicked = false;
  }
  dragging = false;
  action = false;
}
int displayW = 240;
int redColor = color(190, 30, 45);
PFont orator;
int overlay = 255;

final int BLANK = 0;
final int CONTACTS = 1;
final int IMAGERY = 2;

class Display {
  int mode = 0;
  PImage imagery;

  Display () {
    orator = createFont("Helvetica", 128);
  }

  public void display() {
    pushMatrix();
    translate(width/2, height/2);
    pushMatrix();

    switch (mode) {
    case BLANK:
      fill(255, 0, 0);
      rectMode(CENTER);
      rect(0, 0, width, height);
      break;
    case CONTACTS:
      scale(1.018f);
      drawItems();
      break;
    case IMAGERY:
      if (imagery != null) {
        pushMatrix();
        scale(240.0f/imagery.height*1.0f);
        image(imagery, 0, 0);
        popMatrix();
      }
      break;
    }
    if (overlay > 2) {
      //moving = true;
      //drawItems();
      fill(255, overlay);
      rectMode(CENTER);
      rect(0, 0, width, height);
      overlay -= 4;
    }
    popMatrix();
    fill(0);
    scale(2.15f);
    shape(mask, 0, 0);
    popMatrix();
    rectMode(CORNER);
    rect(0, 0, 40, height);
    rect(width-40, 0, 40, height);
    //scale(3);



    if (false) {
      fill(255, 0, 0);
      // text("ellapsed "+millis(), 10, 15);
      textSize(30);
      //text("fps "+nf(frameRate, 0, 2), 10, 30);
      // text("width "+width, 10, 55);
      // text("height "+height, 10, 75);
      // text("item "+(currentFace), 10, 95);
      // text("margin "+nf(marginRatio,0,2), 10, 115);
      // text("speed "+nf(speed, 0, 2), 10, 135);
      // text("moving "+moving, 10, 155);
      // text("x "+currentX, 10, 115);
      // text("targetx "+targetX, 10, 135);
    }
  }


  public void drawItems() {
    int tempX = currentX + currentFace * displayW;

    //if (moving) {
    faces[currentFace].display(tempX);
    faces[currentFace-1 >= 0 ? currentFace - 1 : currentFace + faceNum - 1].display(tempX - displayW);
    faces[currentFace+1 <= faceNum - 1 ? currentFace + 1 : currentFace + 1 - faceNum].display(tempX + displayW);
    //}

    //if (moving) {
    //  instagram[currentFace].display(tempX);
    //  instagram[currentFace-1 >= 0 ? currentFace - 1 : currentFace + faceNum - 1].display(tempX - displayW);
    //  instagram[currentFace+1 <= faceNum - 1 ? currentFace + 1 : currentFace + 1 - faceNum].display(tempX + displayW);
    //}
  }
}



class Photo {
  String url;
  PImage img;

  Photo (String def) {
    img = loadImage(url);
    img.resize(displayW, displayW);
  }

  public void display(float x) {
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

  public void display(float x) {
    if (img != null) {
      pushMatrix();
      translate(x, 0);
      //scale(240.0/img.width);
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

public int attract(int val, int targetVal, int snap, int speed) {
  if (abs(targetVal - val) > snap) { 
    moving = true;
    float delta = (targetVal - val) / speed;
    //if (abs(delta) < snap) {
    //  delta = delta < 0 ? -1 : 1;
    //  val = targetVal;
    //}
    val += delta;
  } else {
    val = targetVal;
  }
  return val;
}
ArrayList dweets;
Dweet latestDweet;
float dweetA, dweetTargetA = 0;
String lastCreated = "";
boolean dweeted;
long lastDweet;
int refresh = 500;

public void initThing() {
  latestDweet = new Dweet();
  dweets = new ArrayList();
}

public void getDweet() {
  long pingStart = millis();
  String thing= "teleobjects";
  String url = "https://thingspace.io/get/latest/dweet/for/"+thing;
  String[] buffer = loadStrings(url);
  if (buffer != null) {
    latestDweet.parse(buffer[0], true);
    if (!lastCreated.equals(latestDweet.created_)) {
      lastCreated = latestDweet.created_;
      //pingTime = int(millis()-pingStart);
      dweeted = true;
      dweetA = 255;
      for (int i=0; i<latestDweet.properties.size(); i++) {
        String property = latestDweet.properties.get(i);
        if (property.equals("CONTACTS")) {
          String content = latestDweet.values.get(i);
          String[] items = splitTokens(content, TAB+"");
          String img = items[1];
          display.imagery = loadImage("img/"+img+".png");
        }
        if (property.equals("NEWS")) {
          String content = latestDweet.values.get(i);
          String[] items = splitTokens(content, TAB+"");
          String img = items[1];
          display.imagery = loadImage(img);
        }
      }
    }
  }
}

public void sendDweet(String key_, String value_) {
  long pingStart = millis();
  String thing_ = "teleobjects";
  String teleobject_ = "ticker";
  String url = "https://thingspace.io/dweet/for/"+thing_+"?"+"teleobject="+teleobject_+"&"+key_+"="+encode(value_);
  String[] buffer = loadStrings(url);
  println(url);
  if (buffer != null) {
    latestDweet.parse(buffer[0], false);
    //pingTime = int(millis()-pingStart);
    dweetA = 255;
  }
}

public void displayDweet(float thisX, float thisY) {
  dweetA += (dweetTargetA - dweetA)*.05f;
  if (latestDweet.info != null) {
    pushMatrix();
    translate(thisX, thisY);
    textAlign(LEFT);
    //textFont(fontBold, 20);
    fill(redColor);
    text(latestDweet.info, 0, 0);
    popMatrix();
  }
}

class Dweet {
  String created_ = "";
  String content_;
  String info;
  String thing_;

  ArrayList<String> properties;
  ArrayList<String> values;
  Dweet() {
  }

  public void parse(String d, boolean getting) {
    processing.data.JSONObject dweetData = processing.data.JSONObject.parse(d);
    String this_ = dweetData.getString("this");
    properties = new ArrayList();
    values = new ArrayList();
    if (this_.equals("succeeded")) {
      String by_ = dweetData.getString("by");
      String the_ = dweetData.getString("the");
      processing.data.JSONObject withObject = null;
      if (getting) {
        processing.data.JSONArray withArray = dweetData.getJSONArray("with");
        withObject= withArray.getJSONObject(0);
      } else {
        withObject = dweetData.getJSONObject("with");
      }
      thing_  = removeBrackets(withObject.getString("thing"));
      created_ = withObject.getString("created");
      processing.data.JSONObject withContent =  withObject.getJSONObject("content");
      String[] properties_ = (String[]) withContent.keys().toArray(new String[withContent.size()]);
      content_ = "";
      for (int i=0; i<properties_.length; i++) {
        properties.add(removeBrackets(properties_[i]));
        values.add(removeBrackets(withContent.getString(properties_[i])));
        content_ += removeBrackets(properties_[i])+"\t"+ removeBrackets(withContent.getString(properties_[i]))+"\t";
      }
      //info = "this "+this_+" by "+by_+" the "+the_+" thing "+thing_;//+" content "+content_;
    } else {
      int with_ = dweetData.getInt("with");
      String because_ = dweetData.getString("because");
      //info = "this "+this_+" with "+with_+" because "+because_;
    }
  }
}

public String encode(String name) {
  String encoded = null;
  try { 
    encoded = java.net.URLEncoder.encode(name, "UTF-8");
  } 
  catch (Exception e) {
  }
  return encoded;
}

public String removeQuotes(String str) {
  if (str.length() > 0) {
    if (str.charAt(0) == 34) {
      str = str.substring(1, str.length()-1);
    }
  }
  if (str.length() > 0) {

    if (str.charAt(str.length()-1) == 43) {
      str = str.substring(0, str.length()-2);
    }
  }
  return str;
}

public String removeBrackets(String str) {
  if (str.length() > 0) {
    if (str.charAt(0) == '{') {
      str = str.substring(1, str.length()-1);
    }
  }
  if (str.length() > 0) {
    if (str.charAt(str.length()-1) == '}') {
      str = str.substring(0, str.length()-2);
    }
  }
  return str;
}
  public void settings() {  size(320, 240); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "tele_frame_java" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
