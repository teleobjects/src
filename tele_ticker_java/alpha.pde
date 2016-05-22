final int CHARS = 32;

char DEC_POINT = 47;
char DEGREE = 29;
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
final int COMPASS = 16;
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

class Alpha {
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

  Alpha() {
    dis = new char[CHARS];
    dec = new boolean[CHARS];
    segments = new PShape[15];
    for (int i=0; i<15; i++) {
      segments[i] = loadShape("dig/"+segmentNames[i]+".svg");
      segments[i].disableStyle();
    }
    alphaFont = loadStrings("csv/alphaFont.csv");
    clearDisplay();
  }

  void update() {
    switch(mode) {
      case LOOK:
      clearDisplay();
      int eyesX = 0;
      boolean eyesB = millis() % 1200 < 300;
      face = (int)data.charAt(0)- 65;
      faceClosed = (int)data.charAt(1) - 65;
      dis[eyesX] = !eyesB ?  char(leftEyes[face]) : char(leftEyes[faceClosed]);
      dis[eyesX + 1] = !eyesB ?  char(rightEyes[face]) : char(rightEyes[faceClosed]) ;
      dec[eyesX] = true;
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
      if (millis() > lastTick + tick*1) {
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
      if (millis() - lastTick > tick*1.35) {
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
          if (cursorX < CHARS) { ///// to fix bug ????
            dis[cursorX] = data.charAt(0);
          }
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
    fill(redColor);
    noStroke();
    float currentX = -546;
    for (int i=0; i < CHARS; i++) {
      pushMatrix();
      translate(currentX, 36);
      scale(.16);
      drawChar(dis[i]);
      if (dec[i]) drawChar('.');
      currentX += 35;
      popMatrix();
    }
  }

  void printString(String thisString, int thisMode, int thisTick, int thisTock, int thisTuck) {
    data = thisString;
    mode = thisMode;
    tick = thisTick;
    tock = thisTock;
    tuck = thisTuck;
    busy = false;

    lastTick = millis() + txDelay;

    switch (mode) {
      case DWEET_TX:
      String[] items = splitTokens(thisString, "|");
      //if (dweet) {
      messaging.sendDweet(items[0], thisString.substring(thisString.indexOf("|"), thisString.length()));
      //}
      break;

      case BLANK:
      clearDisplay();
      break;

      case INSTANT:
      clearDisplay();
      while (data.length() > 0 && cursorX < CHARS) {
        dis[cursorX] = data.charAt(0);
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
      cursorX = (CHARS - data.length() +  countChar(data, '.')) / 2;
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
    if (thisChar < alphaFont.length) {
      thisWord = alphaFont[thisChar].substring(3, 18);
    } 
    for (int i=0; i<15; i++) {
      if (thisWord.charAt(i) == '1') {
        shape(segments[i], 0, 0);
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

String invalid  = "`´_âáäÁÂÄéêëÉÊËíîïÍÎÏóôöÓÔÖúûüÚÛÜñÑ";//+char(8217);
String subs     = "'' 'aaAAAeeeEEEiiiIIIoooOOOuuuUUUnN";
String valid = " !@#$%^&*()-+=[]}{;':<>,.?/01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"+DEGREE+DOUBLE_QUOTE+SINGLE_QUOTE;

String cleanUp(String str, boolean capitalize) {
  String tmp = cleanUp(str);
  if (capitalize) tmp = tmp.toUpperCase();
  return tmp;
}

String cleanUp(String str) {
  // boolean flag = false;
  String res = "";
  for (int i=0; i<str.length(); i++) {
    char ch = str.charAt(i);
    if (ch == '&' && str.charAt(i+1) == '#') {
      ch = 39;
      i = i+6;
      // flag = true;

    }
    if (ch > 127) {
      ch = 39;

    }
    if (invalid.indexOf(ch) != -1) {
      ch = subs.charAt(invalid.indexOf(ch));
    }
    if (valid.indexOf(ch) != -1) {
      res +=  ch;
    } else {
      res += '-';
    }
  }
  // if (flag) println(res);
  return res;
}