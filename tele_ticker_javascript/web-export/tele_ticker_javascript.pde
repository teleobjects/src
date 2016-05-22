Ticker ticker;
Frame frame;
//PImage test;

void setup() {
  setSize();
  ticker = new Ticker();
  ticker.printString("WHAT'S UP?", TICKER, 5, 1, 1);

  frame = new Frame();
  listenDweet("teleobject");
}

void draw() {
  background(backgroundColor);
  //size(12000,600);
  //fill(redColor);
  //text(thing, 100, 100);
  //text(content, 100, 130);
  //text(created, 100, 160);

  //if (test != null) {
  //  pushMatrix();
  //  scale(.5);
  //  image(test, 50, 50);
  //  popMatrix();
  //}
  translate(width/2, height/2);
  //scale(s);

  ticker.display();

  translate(300, -300);
  frame.display();
}

void newDweet() {
  String[] items = splitTokens(content, "|");


  ticker.printString(items[0], parseInt(items[1]), parseInt(items[2]), parseInt(items[3]), parseInt(items[4]));
  frame.printString(items[0], parseInt(items[1]), parseInt(items[2]), parseInt(items[3]), parseInt(items[4]));

  //println(items[0]);
}

void setSize()
{
  //println("setSize");
  size(window.innerWidth, window.innerHeight);
  if (width < 1200) {
    s = width/1400.0;
  }
  //size(document.body.clientWidth - 20, document.body.clientHeight - 20);
}

void mousePressed() {
  String thing = "teleobject";
  String url = "https://thingspace.io/get/latest/dweet/for/"+thing;
  test = loadImage("https://static01.nyt.com/images/2016/05/12/us/politics/00trumpwomen-top-copy/00trumpwomen-top-square320.jpg");

  if (mouseX <  width/2) {
    //getDweet("teleobject");
    //println(result);
    //println(content);
  } else {

    //sendDweet("teleobject", millis());
  }
}




class Frame {
  PShape frame, app;
  PImage img;

  //PGraphics canvas;


  Frame() {
    //canvas = createGraphics(240, 240);

    //canvas.beginDraw();
    //canvas.background(redColor);
    //canvas.endDraw();

    app = loadShape("shp/app.svg");
    app.disableStyle();

    mask = loadShape("shp/mask.svg");
    mask.disableStyle();
  }

  void display() {

    strokeWeight(2.5);
    stroke(50);
    fill(255);
    pushMatrix();
    scale(2.5);
    strokeWeight(2.5/2.5);

    shape(app, 0, 0);
    popMatrix();

    pushMatrix();
    //image(canvas, 0, 0);

    if (img != null) {
      imageMode(CENTER);

      scale(240.0/img.width*.46);

      image(img, 0, 0);
    }
    popMatrix();

    fill(255);
    noStroke();
    shape(mask, 0, 0);

    stroke(0);
    strokeWeight(2.5);
    noFill();
    shape(app, 0, 0);
  }

  void printString(String thisString, int thisMode, int thisTick, int thisTock, int thisTuck) {
    if (thisMode == IMAGE) {
      println("loading "+thisString);
      img = loadImage(thisString);
      //canvas.beginDraw();
      //canvas.scale(img.width/240.0);
      ////canvas.scale(2);
      //canvas.background(255);
      //canvas.fill(redColor);
      //canvas.text(thisString, 10, 120);
      //canvas.imageMode(CORNER);

      //canvas.image(img,0,0);
      //canvas.endDraw();
    }
  }
}

final int CHARS = 32;

char DEC_POINT = 47;
char DEGREE = '°';
char SINGLE_QUOTE = 5;
char DOUBLE_QUOTE = 34;
char DECIMAL_POINT = 14;
char BAR_TOP = 0;
char BAR_MIDDLE = '-';
char BAR_BOTTOM = 3;
char EQ_LOW = '_';
char EQ_MID = '=';
char EQ_HIGH = 135;
char EQ_OFF = ' ';

final int BLANK = 0;
final int LOOK = 1;
final int CENTERED = 2;
final int INSTANT= 3;
final int TICKER = 4;
final int SCROLL = 5;
final int SCROLL_ALL_RIGHT = 6;
final int SCROLL_CENTER_RIGHT = 7;
final int SCROLL_PUSH_RIGHT = 8;
final int SCROLL_ALL_LEFT = 9;
final int SCROLL_CENTER_LEFT = 10;
final int SCROLL_PUSH_LEFT = 11;
final int SLEEP = 12;
final int AIRPORT = 13;
final int BLINK = 14;
final int LOADING = 15;

final int BATTERY = 17;
final int AXIS = 18;
final int ALPHABET = 19;
final int EXTRA = 20;
final int STREAM = 21;
final int BALL = 22;
final int RAIN = 23;
final int SNOW = 24;

final int DWEET_TX = 100;
final int IMAGE = 101;

color whiteColor = color (255, 255, 255);
color redColor = color(190, 30, 45);
color backgroundColor = color(200);

final int BLE_PACKET_LENGHT=18;
final int TX_SPEED = 150;

class Ticker {

  int  tick, tock, tuck;


  PShape outline, outline_mask, app, mask;
  float rot, targetRot;

  PShape segments[];
  String segmentNames[] = {"DP", "N", "M", "L", "K", "J", "H", "G2", "G1", "F", "E", "D", "C", "B", "A"};
  String alphaFont[];
  int mode = 0;
  String data = "";
  long lastTick;
  char[] dis;
  boolean[] dec;
  int cursorX = 0;
  int breakX;
  boolean busy;

  // SLEEP
  boolean busyZ;
  int zzz, zzzC, zzzD = 1;
  long nextZ;
  long awakeStart;

  Ticker() {

    outline = loadShape("shp/ticker.svg");
    outline.disableStyle();
    outline_mask = loadShape("shp/ticker_mask.svg");
    outline_mask.disableStyle();


    dis = new char[CHARS];
    dec = new boolean[CHARS];
    segments = new PShape[15];
    for (int i=0; i<15; i++) {
      segments[i] = loadShape("dig/"+segmentNames[i]+".svg");
      segments[i].disableStyle();
    }
    alphaFont = loadStrings("csv/alphaFont.csv");
    //println(alphaFont);
    clearDisplay();
  }

  void update() {
    switch(mode) {
    case LOOK:
      clearDisplay();
      // int eyesX = 0;
      // boolean eyesB = millis() % 1200 < 300;
      // face = (int)data.charAt(0)- 65;
      // faceClosed = (int)data.charAt(1) - 65;
      // dis[eyesX] = !eyesB ?  char(leftEyes[face]) : char(leftEyes[faceClosed]);
      // dis[eyesX + 1] = !eyesB ?  char(rightEyes[face]) : char(rightEyes[faceClosed]) ;
      // dec[eyesX] = true;
      break;
    case SLEEP:
      clearDisplay();
      switch (zzz) {
      case 0:
        break;
      case 1:
        dis[0] = 'z';
        break;
      case 2:
        dis[0] = 'z';
        dis[1] = 'z';
        break;
      case 3 :
        dis[0] = 'z';
        dis[1] = 'z';
        dis[2] = 'z';
        break;
      }
      if (millis() > nextZ) {
        zzz += zzzD;
        if (zzz == 3) zzzD = -1;
        if (zzz == 0) zzzD = 1;
        nextZ = millis() + 60;
        if (zzz == 0) {
          zzzC ++;
          if (zzzC % 2 == 0) {
            nextZ += 3000;
          }
        }
      }
      break;

    case SCROLL:
      if (millis() > lastTick + tick) {
        lastTick = millis();
        if (cursorX < breakX ) {    /// scroll right
          cursorX ++;
          for (int i = 0; i < CHARS-1; i++) {
            dis[i] = dis[i + 1];
            dec[i] = dec[i + 1];
          }
          if (data.length() > 0) {
            dis[CHARS - 1] = data.charAt(0);
            dec[CHARS - 1] = false;
            data = data.substring(1, data.length());
            if (data.length() > 0) {
              if (data.charAt(0) == '.' && dis [CHARS-2] != '.') {
                dec[CHARS - 1] = true;
                data = data.substring(1, data.length());
                breakX --;
              }
            }
          } else {
            dis[CHARS - 1] = ' ';
            dec[CHARS-1 ] = false;
          }
        } else if (cursorX > breakX ) {   /// scroll left
          cursorX --;
          for (int i = CHARS-1; i > 0; i--) {
            dis[i] = dis[i - 1];
            dec[i] = dec[i - 1];
          }

          if (data.length() > 0) {
            dis[0] = data.charAt(data.length()-1);
            dec[0] = false;
            data = data.substring(0, data.length()-1);
            // if (data.length() > 0) {
            //   if (data.charAt(0) == '.' && dis [CHARS-2] != '.') {
            //     dec[CHARS - 1] = true;
            //     data = data.substring(1, data.length());
            //     breakX --;
            //   }
            // }
          } else {
            dis[0] = ' ';
            dec[0] = false;
          }
        } else {
          busy = false;
        }
      }
      break;

    case TICKER:      
      if (millis() - lastTick > tick) {
        lastTick = millis();
        if (data.length() > 0) {
          if (breakX == 0) {
            clearDisplay();
            breakX = data.length();
            if (breakX > CHARS) breakX = findLastChar(data.substring(0, CHARS), ' ');
            if (breakX == 0) breakX = data.length();
            if (breakX > CHARS) breakX = CHARS;
            if (data.charAt(0) == ' ' && data.length() > 1) data = data.substring(1, data.length());
          }
          dis[cursorX] = data.charAt(0);
          data = data.substring(1, data.length());
          if (data.length() > 0) {
            if (data.charAt(0) == '.' && dis[cursorX] != '.') {
              dec[cursorX] = true;
              data = data.substring(1, data.length());
              breakX --;
              if (data.length() == 0) {
                lastTick = millis() + tock*100;
              }
            }
          } else {
            lastTick = millis() + tock*100;
          }
          cursorX ++;
          if (cursorX == breakX) {
            breakX = 0;
            if (data.length()>0) {
              lastTick = millis() + tock*100;
            }
            if (dis[cursorX - 1] == ' ') cursorX --;
          }
        } else {
          busy = false;
        }
      }
      if (cursorX < CHARS && cursorX >= 0) dis[cursorX] = millis() % 500 < 250 ? CHARS : '_';
      break;
    }
  }

  void display() {
    update();

    strokeWeight(2.5);
    stroke(50);
    fill(255);
    shape(outline, 0, 0);
    fill(backgroundColor);
    shape(outline_mask, 0, 0);

    fill(redColor);
    noStroke();
    float currentX = -546;
    for (int i=0; i< CHARS; i++) {
      String tmp = ""+dis[i];
      if (tmp.length() > 1) {
        current = dis[i];
      } else {
        int current = tmp.charCodeAt(0);
      }
      pushMatrix();
      translate(currentX, 36);
      scale(.16);

      //print(""+(dis[i]));
      drawChar(current);
      if (dec[i]) drawChar('.');
      currentX += 35;
      popMatrix();
    }
    //println();
  }

  void printString(String thisString, int thisMode, int thisTick, int thisTock, int thisTuck) {
    data = thisString;
    mode = thisMode;
    tick = thisTick;
    tock = thisTock;
    tuck = thisTuck;
    busy = false;
    int txDelay = int(thisString.length()/BLE_PACKET_LENGHT*TX_SPEED*1.2);
    lastTick = millis() + txDelay;

    switch (mode) {
    case DWEET_TX:
      String[] items = splitTokens(thisString, "|");
      // if (dweet) {
      // sendDweet(items[0], thisString.substring(thisString.indexOf("|"), thisString.length()));
      // }
      break;

    case BLANK:
      clearDisplay();
      break;

    case INSTANT:
      clearDisplay();
      while (data.length() > 0 && cursorX < CHARS) {
        dis[cursorX] = (char) data.charAt(0);
        data = data.substring(1, data.length());
        if (data.length() > 0) {
          if (data.charAt(0) == '.' && dis[cursorX] == '.') {
            dec[cursorX] = true;
            data = data.substring(1, data.length());
          }
        }
        cursorX ++;
      }
      break;

    case STREAM:
      if (data.length() == CHARS) {
        // dis = data;
        for (int i=0; i<CHARS; i++) {
          dis[i] = data.charAt(i);
        }
      }
      break;

    case CENTERED:
      clearDisplay();
      cursorX = int((CHARS - data.length())/2);// +  countChar(data, '.')) / 2;
      while (data.length() > 0 && cursorX < CHARS) {
        dis[cursorX] = data.charAt(0);
        data = data.substring(1, data.length());
        if (data.length() > 0) {
          if (data.charAt(0) == '.' && dis[cursorX] != '.') {
            dec[cursorX] = true;
            data = data.substring(1, data.length());
          }
        }
        cursorX ++;
      }
      break;

    case TICKER:
      breakX = 0;
      busy = true;
      break;

    case SCROLL_ALL_RIGHT:
      cursorX = 0;
      breakX = CHARS + data.length();
      mode = SCROLL;
      busy = true;
      break;

    case SCROLL_CENTER_RIGHT:
      cursorX = 0;
      breakX = ((CHARS - data.length()) / 2) + data.length();
      mode = SCROLL;
      busy = true;

      break;

    case SCROLL_PUSH_RIGHT:
      cursorX = 0;
      int lastX = CHARS+1;
      for (int i=CHARS-1; i>=0; i--) {
        if (dis[i] != ' ') break;
        lastX --;
      }
      breakX = ((CHARS - data.length()) / 2) + data.length();
      if (breakX < lastX) {
        for (int i=0; i < (lastX - breakX) && data.length()< CHARS; i++) {
          data = " "+data;
          data = data +" ";
        }
        if (CHARS > data.length()) {
          breakX = ((CHARS - data.length()) / 2) + data.length();
        } else {
          breakX = data.length();
        }
      } 
      mode = SCROLL;
      busy = true;
      break;

    case SCROLL_ALL_LEFT:
      cursorX = 0;
      breakX = -CHARS - data.length();
      mode = SCROLL;
      busy = true;
      break;

    case SCROLL_CENTER_LEFT:
      cursorX = 0;
      breakX = -((CHARS - data.length()) / 2) - data.length();
      mode = SCROLL;
      busy = true;
      break;

    case SCROLL_PUSH_LEFT:
      cursorX = 0;
      int firstX = 0;
      for (int i=0; i<CHARS; i++) {
        if (dis[i] != ' ') break;
        firstX ++;
      }
      firstX = -(CHARS - firstX);
      breakX = -((CHARS - data.length()) / 2) - data.length();
      if (breakX > firstX) {
        for (int i=0; i < (breakX - firstX) && data.length()< CHARS; i++) {
          data = " "+data;
          data = data +" ";
        }
        if (CHARS > data.length()) {
          breakX = -((CHARS - data.length()) / 2) - data.length();
        } else {
          breakX = data.length();
        }
      } 
      mode = SCROLL;
      busy = true;
      break;

    case AIRPORT:
      for (int i = data.length(); i < CHARS; i++) {
        data += " ";
      }
      break;
    }
  }

  void drawChar(char thisChar) {
    String thisWord = "000000000000000";
    int thisCharByte = (int)thisChar;//'$';
    if (thisCharByte < alphaFont.length-1) {
      thisWord = alphaFont[(int)thisChar];
      thisWord = thisWord.substring(3, 18);
      for (int i=0; i<15; i++) {
        if (thisWord.charAt(i) == "1") {
          shape(segments[i], 0, 0);
        }
      }
    }
  }

  void clearDisplay() {
    for (int i=0; i < CHARS; i++) {
      dis[i] = ' ';
      dec[i] = false;
    }
    cursorX = 0;
  }
}

String invalid  = "_âáäÁÂÄéêëÉÊËíîïÍÎÏóôöÓÔÖúûüÚÛÜñÑ"+char(8217);
String subs     = " aaaAAAeeeEEEiiiIIIoooOOOuuuUUUnN'";
String valid = " !@#$%^&*()-+=[]}{;':<>,.?/01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"+DEGREE+DOUBLE_QUOTE+SINGLE_QUOTE;

String cleanUp(String str, boolean capitalize) {
  String tmp = cleanUp(str);
  if (capitalize) tmp = tmp.toUpperCase();
  return tmp;
}

String cleanUp(String str) {
  String res = "";
  for (int i=0; i<str.length(); i++) {
    char ch = str.charAt(i);
    if (invalid.indexOf(ch) != -1) {
      if (invalid.indexOf(ch) < subs.length()) {
        ch = subs.charAt(invalid.indexOf(ch));
      }
    }
    if (valid.indexOf(ch) != -1) {
      res +=  ch;
    } else {
      res += '-';
      // println(char(ch)+" code: "+(int)ch+" not valid");
    }
  }
  return res;
}

int countChar(String str, char c){
  if (str.length() == 0 || str == null) return 0;
  int count = 0;
  for (int i=0; i<str.length(); i++) {
    if(str.charAt(i) == c) count ++;
  }
  return count;
}

int findLastChar(String str, char c) {
  if (str.length() == 0 || str == null) return 0;
  int count = str.length() - 1;
  while (count > 0) {
    if (str.charAt(count) == c) break;
    count --;
  }
  return count;
}

String removeQuotes(String str) {
  if (str.length() > 0) {
    if (str.charAt(0) == DOUBLE_QUOTE) {
      str = str.substring(1, str.length());
    }
  }
  if (str.length() > 0) {

    if (str.charAt(str.length()-1) == DOUBLE_QUOTE) {
      str = str.substring(0, str.length()-2);
    }
  }
  return str;
}

String removeSpaces(String str) {
  if (str.length() > 0) {
    if (str.charAt(0) == ' ') {
      str = str.substring(1, str.length());
    }
  }
  if (str.length() > 0) {
    if (str.charAt(str.length()-1) == ' ') {
      str = str.substring(0, str.length()-1);
    }
  }
  return str;
}



String removeBrackets(String str) {
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

String encode(String name) {
  String encoded = null;
  try { 
    encoded = java.net.URLEncoder.encode(name, "UTF-8"); 
  } catch (Exception e) {

  }
  return encoded;
}

String getCoordinate(double coordinate, boolean isLat) {
  char hemisphere = coordinate < 0 ? (isLat ? 'S' : 'W') : (isLat ? 'N' : 'E');
  float coord = (float)coordinate; 
  coord = abs(coord);
  int degrees = int(coord);         
  float minutesFromRemainder = (coord - degrees) * 60;      
  int minutes = int(minutesFromRemainder);      
  float secondsFromRemainder = ( minutesFromRemainder - minutes ) * 60;  
  int seconds = int( secondsFromRemainder);
  return (degrees+""+DEGREE + nf(minutes, 2, 0) + SINGLE_QUOTE + nf(seconds, 2, 0) +DOUBLE_QUOTE +""+hemisphere);
}

float getCelcius(float temp) {
  temp -= 32;
  temp /= 1.8;
  return temp;
}


String getStringTime(boolean am_pm) {
  String result = "";

  if (am_pm) {
    String hour_ = nf(hour()%12, 2, 0);
    result += hour_.charAt(0);
    result +=  hour_.charAt(1);
    result +=  ". ";
    String minute_ = nf(minute(), 2, 0);
    result += minute_.charAt(0);
    result += minute_.charAt(1);
    result += ". ";
    String second_ = nf(second(), 2, 0 );
    result += second_.charAt(0);
    result += second_.charAt(1);
    if (hour() >= 12) {
      result += " PM";
    } else {
      result += " AM";
    }
  }   else {
    String hour_ = nf(hour(), 2, 0);
    result += hour_.charAt(0);
    result +=  hour_.charAt(1);
    result +=  ". ";
    String minute_ = nf(minute(), 2, 0);
    result += minute_.charAt(0);
    result += minute_.charAt(1);
    result += ". ";
    String second_ = nf(second(), 2, 0 );
    result += second_.charAt(0);
    result += second_.charAt(1);
  }
  return result;
}


float attract(float val, float target, float ratio, float snap) {
  float result =  val + ((target-val)*ratio);
  if (abs(result-target) < snap) result = target;
  return result;
} 
