long alarmNext;
PShape[] icons;
String[] alarmIcons = {"heart", "like", "talk"};
PShape circle_mask;
int alarmImage;
int activeIcon;
boolean alarmStatus;
long alarmStarted;

float hammerR;

void alarmOn() {
  alarmStarted = millis();
  alarmStatus = true;
  activeIcon = -1;
  alarmImage = -1;
}

void alarmOff() {
  alarmStatus = false;
}

void initAlarm() {
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

void drawAlarm(float thisX, float thisY) {
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
    Ani.to(this, .1, "hammerR", -PI/20, Ani.QUAD_IN_OUT);
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
    Ani.to(this, .01, "hammerR", PI/20, Ani.QUAD_IN_OUT);
  }
  pushMatrix();
  translate(thisX, thisY);
  scale(.8);
  pushMatrix();
  noStroke();
  fill(255);
  shape(alarm__, -alarm.width/2, -alarm.height/2);
  popMatrix();
  pushMatrix();
  iso();
  rotateX(radians(-90));
  pushMatrix();
  translate(-19.8, 5.8 );
  scale(.05);
  if (alarmImage != -1) {
    //image(faces[alarmImage], 0, 0);
  }
  scale(1.48);
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
  scale(.09);
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