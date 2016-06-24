String suitcaseDisplay = "";
long suitcaseLast, suitcaseStart;
boolean suitcaseStatus;
int suitcaseMode = 0;

void initSuitcase() {
  suitcase = loadShape("svg/suitcase.svg");
  suitcase.disableStyle();
  suitcase_ = loadShape("svg/suitcase_.svg");
  suitcase_.disableStyle();
}

int clickCounter, lastClickCounter;

void suitcaseOn() {
  suitcaseStatus = true;
  suitcaseStart = millis();
  idle = false;
  for (int i=0; i<4; i++) {
    frameReady[i] = false;
  }
  clickCounter = 0;
  lastClickCounter = 0;
}

void suitcaseOff() {
  suitcaseStatus = false;
}

long sentenceStart;

void drawSuitcase(float thisX, float thisY) {

  if (activeScene == 4 && !suitcaseStatus) {
    suitcaseOn();
  }
  if (activeScene != 4 && suitcaseStatus) {
    suitcaseOff();
  }

  long suitcaseEllapsed = millis() - suitcaseStart;

  pushMatrix();
  translate(thisX, thisY);
  scale(.8);
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
  textFont(sevenFont, 17.5);
  //textSize(17.5);
  if (suitcaseEllapsed < 2000 && millis()-suitcaseLast > 30) {
    suitcaseLast = millis();
    suitcaseDisplay= "";
    String targetText = "40 43'N  73 55'W                  ";
    for (int i=0; i<24; i++) {
      int pos = int(suitcaseEllapsed/2000.0*24);
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
        suitcaseDisplay += char(int(random(10))+48) ;
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