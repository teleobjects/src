class TickerDisplay extends Display {
  int CHARS = 32;

  float rot, targetRot;
  PShape outline, outline_mask;
  PShape segments[];
  String segmentNames[] = {"DP", "N", "M", "L", "K", "J", "H", "G2", "G1", "F", "E", "D", "C", "B", "A"};
  String alphaFont[];

  String data;
  long lastTick;
  char[] dis;
  boolean[] dec;
  int cursorX, firstX, lastX, breakX;
  int displayMode, tack, teck, tick, tock, tuck;

  char EQ_OFF = ' ';
  char EQ_LOW = '_';
  char EQ_MID = '=';
  char EQ_HIGH = char(135);

  char[] spectrum = {EQ_OFF, EQ_LOW, EQ_MID, EQ_HIGH};

  byte loadingOut[] = {0, 1, 2, 3, 4, 5};
  byte loadingIn[] = {6, 8, 9, 10, 7, 13, 12, 11};

  String compass = "| | | | | | E | | | | | | NE | | | | | | N | | | | | | NW | | | | | | W | | | | | | SW | | | | | | S | | | | | | SE ";
  float heading, currentHeading;

  // SLEEP
  boolean busyZ;
  int zzz, zzzC, zzzD = 1;
  long nextZ;
  long awakeStart;

  // BATTERY
  int batIndex;
  int batLong = 10;
  int chargingX;
  long chargingNext;
  int chargingSpeed = 150;
  long lastBattery;

  color displayColor = greenColor;
  int displayBrightness = 255;

  PImage ticker_front;

  TickerDisplay() {
    ticker_front = loadImage("ticker_front_red_2400.png");
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
    clearDisplay();
  }

  void display() {
    update();
    if (ticker.channel == ORIENTATION) {
      targetRot = radians(ticker.comm.ax);
      rot += (targetRot-rot)*.1;
      rotate(rot);
    }

    if (real) {
      pushMatrix();
      scale(outline.width*.413/2400);
      image(ticker_front, -10, 3);
      popMatrix();
    } else {
      strokeWeight(thickStroke);
      stroke(0);
      fill(255);
      shape(outline, 0, 0);
      fill(backgroundColor);
      shape(outline_mask, 0, 0);
    }

    float currentX = -546;
    if (ticker.comm != null) displayBrightness = int(map(ticker.comm.brightness, 1, 15, 100, 255));
    fill(displayColor, displayBrightness);
    noStroke();
    hint(ENABLE_DEPTH_TEST);

    for (int i=0; i < CHARS; i++) {
      pushMatrix();
      translate(currentX, 36);
      scale(.16);
      drawChar(dis[i]);
      if (dec[i]) drawChar('.');
      currentX += 35;
      popMatrix();
    }
    hint(DISABLE_DEPTH_TEST);
  }

  void update() {
    switch(mode) {
      case COMPASS:
      heading = ticker.comm.az;

      if (abs(heading - currentHeading) > 180) {
        if (heading > currentHeading) {
          currentHeading += 360;
        } else if (heading < currentHeading) {
          currentHeading -= 360;
        }
      }
      currentHeading += (heading - currentHeading) * .025;
      int offset = int(map(currentHeading + 180, 0, 360, 0, compass.length()));
      for (int i = 0; i < CHARS; i++) {
        int pos = (i + offset);
        if (pos < 0) pos += compass.length();
        dis[i] = compass.charAt(pos % compass.length());
        dec[i] = false;
      }
      break;

      case TYPE:
      if (cursorX < CHARS && cursorX >= 0) dis[cursorX] = millis() % 500 < 250 ? ' ' : '_';
      break;

      case AIRPORT:
      if (millis() > lastTick + tick) {
        lastTick = millis();
        busy = false;
        for (int i = 0; i < CHARS; i++) {
          if (dis[i] != data.charAt(i)) {
            busy = true;
            dis[i] = char(dis[i] + 1);
            if (dis[i] == 35) dis[i] = char(48);
            if (dis[i] > 64 + 26) dis[i] = char(48);
            if (dis[i] < 48) dis[i] = char(48);
            if (dis[i] > 58 && dis[i] < 65) dis[i] = 65;
            if (dis[i] == 48 && (data.charAt(i) < 48 || data.charAt(i) > 65 + 26)) dis[i] = data.charAt(i);
          }
        }
      }
      break;

      case ALPHABET:
      tick = 100;
      if (millis() > lastTick + tick) {
        lastTick = millis();
        cursorX++;
        if (cursorX == 255- CHARS) busy = false;
        for (int i=0; i<CHARS; i++) {
          dis[i] = char((cursorX + i) % 255);
        }
      }
      break;

      case LOADING:
      if (millis() > lastTick + tick) {
        lastTick = millis();
        switch (tack) {
          case 0:
          dis[0] = (char)loadingOut[lastX%6];
          lastX ++;
          if (lastX >= 6) lastX = 0;
          break;
          case 1:
          dis[0] = (char)loadingIn[lastX%8];
          lastX ++;
          if (lastX >= 8) lastX = 0;
          break;

          case 2:
          for (int i = 0; i < CHARS; i++) {
            dis[i] = (char)loadingIn[lastX];
          }
          lastX ++;
          if (lastX >= 8) lastX = 0;
          break;
        }
        cursorX = 1;
        for (int i = 0; i < data.length(); i++) {
          dis[cursorX] = data.charAt(i);
          cursorX ++;
        }
        if (teck > 0) {
          cursorX --;
          int index = millis() % 1000 / 200;
          for (int i = 0; i < 3; i++) {
            dec[cursorX + i] = index > i;
          }
        }
      }

      break;

      case AXIS:
      clearDisplay();
      int offsetX = 5;

      dis[0 + offsetX] = 'P';
      dis[1 + offsetX] = ticker.comm.ay >= 0 ? '+' : '-';

      dis[2 + offsetX] = char((abs(int(ticker.comm.ay)) / 100) + 48);
      dis[3 + offsetX] = char((abs(int(ticker.comm.ay)) / 10 % 10) + 48);
      dis[4 + offsetX] = char((abs(int(ticker.comm.ay)) % 10) + 48);

      dis[8 + offsetX] = 'R';
      dis[9 + offsetX] = ticker.comm.ax >= 0 ? '+' : '-';
      dis[10 + offsetX] = char((abs(int(ticker.comm.ax)) / 100) + 48);
      dis[11 + offsetX] = char((abs(int(ticker.comm.ax)) / 10 % 10) + 48);
      dis[12 + offsetX] = char((abs(int(ticker.comm.ax)) % 10) + 48);

      dis[16 + offsetX] = 'H';
      dis[17 + offsetX] = ticker.comm.az >= 0 ? '+' : '-';
      dis[18 + offsetX] = char((abs(int(ticker.comm.az)) / 100) + 48);
      dis[19 + offsetX] = char((abs(int(ticker.comm.az)) / 10 % 10) + 48);
      dis[20 + offsetX] = char((abs(int(ticker.comm.az)) % 10) + 48);
      break;

      case BRIGHTNESS:
      clearDisplay();
      int brightnessIndex = (int)map(ticker.comm.brightness, 1, 15, 1, 10);
      dis[cursorX++] = char(brightnessIndex + 48);
      dis[cursorX++] = '0';
      if (brightnessIndex == 10) dis[cursorX++] = '0';
      dis[cursorX++] = '%';
      cursorX++;
      data = "brightness";
      for (int i = 0; i < data.length(); i++) {
        dis[cursorX++] = data.charAt(i);
      }
      for (int i = 0; i < ticker.comm.brightness; i++) {
        dis[CHARS - 15 + i] = '|';
      }
      break;

      case BATTERY:
      clearDisplay();
      int batIndex = int(map(min(ticker.comm.battery*100, ticker.comm.maxBat), ticker.comm.minBat, ticker.comm.maxBat, 0, 10));
      dis[batLong] = 6;
      cursorX = batLong + 1;
      if (batIndex == 10) {
        dis[cursorX++] = '1';
        dis[cursorX++] = '0';
        dis[cursorX++] = '0';
      } else {
        dis[cursorX++] = ' ';
        dis[cursorX++] = char(batIndex + 48);
        dis[cursorX++] = '0';
      } 
      dis[cursorX++] = '%';
      dis[cursorX++] = ' ';
      dis[cursorX++] = nf(ticker.comm.battery*100, 3, 0).charAt(0);
      dec[cursorX-1] = true;
      dis[cursorX++] = nf(ticker.comm.battery*100, 3, 0).charAt(1);
      dis[cursorX++] = nf(ticker.comm.battery*100, 3, 0).charAt(2);
      dis[cursorX++] = 131; 

      if (ticker.comm.charging) {
        if (millis() > chargingNext) {    
          chargingX ++;
          chargingNext = millis() + chargingSpeed;
          if (chargingX == batIndex) chargingNext = millis() + chargingSpeed * 4;
          if (chargingX >= batIndex + 1) {
            chargingNext = millis() + chargingSpeed * 4;
            chargingX = -1;
          }
        }
        dis[0] = chargingX > 0 ? 130 : '[';
        for (int i = 1; i < batLong - 1; i++) {
          dis[i] =  i < chargingX ? char(130) : char(128);
        }
        dis[batLong - 1] = chargingX >= 10 ? 130 : ']';
      } else {
        dis[0] = batIndex == 0 ? '[' : 130;
        for (int i = 1; i < batLong - 1; i++) {
          dis[i] =  i < batIndex ?  char(130) : char(128);
        }
        dis[batLong - 1] = batIndex == 10 ? 130 : ']';
      }

      cursorX++;
      if (ticker.comm.battery < 3.40 && !ticker.comm.charging && millis() % 1000 < 500) {
        data = "LOW BATTERY";
        for (int i = 0; i < data.length(); i++) {
          dis[cursorX++] = data.charAt(i);
        }
      }
      break;

      case CLOCK:
      clearDisplay();
      cursorX = 10;
      String t = getStringTime(true, " ");
      if (t.charAt(0) > '0') {
        dis[cursorX] = t.charAt(0);
      }
      for (int i = 1; i<11; i++) {
        dis[cursorX + i] = t.charAt(i);
      }
      dec [cursorX + 1] = millis() % 1000 < 500;
      dec [cursorX + 4] = millis() % 1000 < 500;
      break;

      case RANDOM:
      if (millis() > lastTick + tick) {
        lastTick = millis();
        clearDisplay();
        for (int i = 0; i < CHARS; i++) {
          switch (tack) {
            case 0:
            dis[i] = (char)int(48 + random(10));
            break;
            case 1:
            dis[i] = (char)int(65 + random(28));
            break;
            case 2:
            dis[i] = (char)int(0 + random(128));
            break;
            case 3:
            dis[i] = (char)int(random(15));
            break;
            case 4:
            dec[i] = random(10) < 5;
            break;
          }
        }
      }
      break;

      case LOOK:
      clearDisplay();
      int eyesX = 0;
      boolean eyesB = millis() % 1200 < 300;
      face = tack-65;
      faceClosed = teck-65;
      if (face < 0) face = 0;
      if (faceClosed < 0) faceClosed = 0;
      dis[eyesX] = !eyesB ?  char(leftEyes[face]) : char(leftEyes[faceClosed]);
      dis[eyesX + 1] = !eyesB ?  char(rightEyes[face]) : char(rightEyes[faceClosed]) ;
      dec[eyesX] = true;
      break;

      case SLEEP:
      clearDisplay();

      for (int i = 1; i <= zzz; i++) {
        dis[i-1] = 'z';
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
      if (millis() > lastTick + tick * 2) {
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
              if (data.charAt(0) == '.' && dis[CHARS-2] != '.') {
                dec[CHARS - 1] = true;
                data = data.substring(1, data.length());
                breakX --;
              }
            }
          } else {
            dis[CHARS - 1] = ' ';
            dec[CHARS - 1] = false;
          }
        } else if (cursorX > breakX ) { 
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
      if (millis() - lastTick > tick *.9) {
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
      if (cursorX < CHARS && cursorX >= 0) dis[cursorX] = millis() % 500 < 250 ? ' ' : '_';
      break;

      case RAIN:
      if (millis() - lastTick > tick * 10 ) {
        lastTick = millis();
        for (int i = 0; i < CHARS; i++) {
          if (dis[i] == ' ') {
            if (random(100) < tock) dis[i] = 10;
          } else if (dis[i] == 10) {
            dis[i] = 11;
            if (random(100) < 70) dis[i] = '/';
          } else if (dis[i] == 11) {
            dis[i] = ' ';
          } else if (dis[i] == '/') {
            dis[i] = 11;
            if (random(100) < 30) dis[i] = '/';
          }
        }
      }
      break;

      case SNOW:
      // tack fall
      // teck wind
      // tick speed
      // tock intensity

      if (millis() - lastTick > tick * 10 ) {
        lastTick = millis();
        for (int i = 0; i < CHARS; i++) {
          if (random(100) < 70 && dis[i] > 7 && dis[i] < 14) {
            dis[i] = (char)32;
          }
          switch (dis[i]) {
            case (char)141:
            dis[i] = (char)137;
            break;
            case (char)142:
            dis[i] = (char)138;
            break;
            case (char)143:
            dis[i] = (char)139;
            break;
            case (char)144:
            dis[i] = (char)140;
            break;
            case (char)8:
            dis[i] = (char)137;
            break;
            case (char)10:
            dis[i] = (char)138;
            break;
            case (char)11:
            dis[i] = (char)139;
            break;
            case (char)13:
            dis[i] = (char)140;
            break;
          }
          if (dis[i] == (char)32 && random(100) < tock) {
            dis[i] = random(100) < 50 ? (char)137 : (char)138;
          }
          if (random(100) < 1) {
            dis[i] = ' ';
          }
        }
        for (int i = 0; i < CHARS; i++) {
          int wind = (int)(-2 + random(teck*2)); 
          if (random(100) < abs(wind)) {
            if (teck > 0) {
              if (dis[i] == (char)137) {
                dis[i] = 138;
              } else if (dis[i] == (char)138) {
                if (i < CHARS-1) {
                  if (dis[i + 1] == (char)32 || i == 31) {
                    dis[i + 1] = (char)137;
                    dis[i] = (char)32;
                    i++;
                  }
                }
              } else if (dis[i] == (char)139) {
                dis[i] = (char)140;
              } else if (dis[i] == (char)140) {
                if (i < CHARS - 1) {
                  if (dis[i + 1] == (char)32 || i == CHARS - 1) {
                    dis[i] = (char)32;
                    dis[i + 1] = (char)139;
                    i++;
                  }
                }
              }
            } else {
              if (dis[i] == (char)138) {
                dis[i] = 137;
              } else if (dis[i] == (char)137) {
                if (dis[i - 1] == (char)32 || i == 0) {
                  dis[i - 1] = (char)138;
                  dis[i] = (char)32;
                  i++;
                }
              } else if (dis[i] == (char)140) {
                dis[i] = 139;
              } else if (dis[i] == (char)139) {
                if (dis[i - 1] == (char)32 || i == 0) {
                  dis[i] = (char)32;
                  dis[i - 1] = (char)140;
                  i++;
                }
              }
            }
          } else {
            if (random(100) < tack) {
              if (dis[i] == (char)137) {
                dis[i] = 139;
              } else if (dis[i] == (char)138) {
                dis[i] = 140;
              } else if (dis[i] == (char)139) {
                dis[i] = (char)32;
              } else if (dis[i] == (char)140) {
                dis[i] = (char)32;
              }
            }
          }
        }
        if (random(100) < 50) {
          for (int i = 0; i < CHARS; i++) {
            if (random(100) < 80) {
              switch (dis[i]) {
                case (char)137:
                dis[i] = (char)141;
                break;
                case (char)138:
                dis[i] = (char)142;
                break;
                case (char)139:
                dis[i] = (char)143;
                break;
                case (char)140:
                dis[i] = (char)144;
                break;
              }
            } else {
              switch (dis[i]) {
                case (char)137:
                dis[i] = (char)8;
                break;
                case (char)138:
                dis[i] = (char)10;
                break;
                case (char)139:
                dis[i] = (char)11;
                break;
                case (char)140:
                dis[i] = (char)13;
                break;
              }
            }
          }
        }
        break;
      }
    }
  }

  ////

  void printString(String thisString, int thisMode, int thisTack, int thisTeck, int thisTick, int thisTock, int thisTuck) {
    data = thisString;
    if (thisMode != PING) {
      mode = thisMode;
      tack = thisTack;
      teck = thisTeck;
      tick = thisTick;
      tock = thisTock;
      tuck = thisTuck;
    } else {
      return;
    }

    busy = false;
    lastTick = millis() + ticker.comm.txDelay;

    switch (mode) {
      case TYPE:
      if (data.charAt(0) == 8) {
        if (cursorX > 0) {
          dis[cursorX] = ' ';
          dis[cursorX -1] = ' ';
          cursorX --;
        }
      } else if (data.charAt(0) == 31) {
        clearDisplay();
      } else if (data.charAt(0) >= 32 && data.charAt(0) < 128) {
        dis[cursorX] = data.charAt(0);
        cursorX ++;
        if (cursorX == CHARS) {
          lastTick = millis() + tock;
          for (int i=0; i < CHARS - 1; i ++) {
            dis[i] = dis[i+1];
          }
          cursorX --;
        }
      }
      break;

      //case COMPASS:
      //  clearDisplay();
      //  break;

      //case LOADING:
      //  clearDisplay();
      //  break;

      // case ALPHABET:
      // clearDisplay();

      //case BRIGHTNESS:
      //  clearDisplay();
      //  break;

      // case BATTERY:
      // clearDisplay();
      // break;

      // case AXIS:
      // clearDisplay();
      // break;

      case SNOW:
      clearDisplay();
      break;

      case RAIN:
      clearDisplay();
      break;

      case BLANK:
      clearDisplay();
      break;

      //case SLEEP:
      //  clearDisplay();
      //  break;

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

      case SENSORS:
      clearDisplay();

      int offsetX = 5;
      dis[1 + offsetX] = ticker.comm.temperature >= 0 ? ' ' : '-';
      dis[2 + offsetX] = char(int(abs(ticker.comm.temperature) / 10) + 48);
      dis[3 + offsetX] = char((int(abs(ticker.comm.temperature)) % 10) + 48);
      dis[4 + offsetX] = '°';
      dis[5 + offsetX] = 'C';

      dis[7 + offsetX] = ticker.comm.humidity == 100 ? '1' : ' ';
      dis[8 + offsetX] = char(int(ticker.comm.humidity / 10) + 48);
      dis[9 + offsetX] = char((int(ticker.comm.humidity) % 10) + 48);
      dis[10 + offsetX] = '%';
      dis[11 + offsetX] = 'h';

      dis[14 + offsetX] = ticker.comm.pressure > 1000 ? '1' : ' ';
      dis[15 + offsetX] =  char(((ticker.comm.pressure % 1000) / 100) + 48);
      dis[16 + offsetX] =  char(((ticker.comm.pressure % 100) / 10) + 48);
      dis[17 + offsetX] =  char((ticker.comm.pressure % 10) + 48);
      dis[18 + offsetX] = 'm';
      dis[19 + offsetX] = 'b';
      break;

      case SPECTRUM:
      clearDisplay();
      // if (data.length() == 32) {
        for (int i = 0; i < data.length(); i++) {
          dis[i] = spectrum[data.charAt(i) - 48];
        }
      // }

      // for (int i = 0; i < CHARS / 4; i++) {
      //   byte b[] = new byte[4];
      //   int c = 255-data.charAt(i);
      //   b[0] = byte(c & unbinary("00000011"));
      //   b[1] = byte((c & unbinary("00001100")) >> 2);
      //   b[2] = byte((c & unbinary("00110000")) >> 4);
      //   b[3] = byte((c & unbinary("11000000")) >> 6);
      //   for (int j = 0; j < 4; j++) {
      //     dis[(i * 4) + j] = spectrum[b[j]];
      //     dec[(i * 4) + j] = false;
      //   }
      // }
      // }
      break;

      case STREAM:
      if (data.length() == CHARS) {
        for (int i=0; i<CHARS; i++) {
          dis[i] = data.charAt(i);
          dec[i] = false;
        }
      }
      break;

      case CENTERED:
      clearDisplay();
      cursorX = (CHARS - data.length() +  countChar(data, '.')) / 2;
      while (data.length() > 0 && cursorX < CHARS) {
        if (cursorX > 0) {
          dis[cursorX] = data.charAt(0);
          data = data.substring(1, data.length());
          if (data.length() > 0) {
            if (data.charAt(0) == '.' && dis[cursorX] != '.') {
              dec[cursorX] = true;
              data = data.substring(1, data.length());
            }
          }
        }
        cursorX ++;
      }
      break;

      case TICKER:
      busy = true;
      breakX = 0;
      break;

      case SCROLL:
      busy = true;
      cursorX = 0;
      mode = SCROLL;

      if (tock == 0) {
        clearDisplay();
      }

      if (tack == 0) {
        switch (teck) {
          case 0:
          breakX = CHARS + data.length();
          break;
          case 1:
          breakX = ((CHARS - data.length()) / 2) + data.length();
          if (tock == 1) {
            lastX = CHARS + 1;
            for (int i = CHARS - 1; i >= 0; i--) {
              if (dis[i] != ' ') break;
              lastX --;
            }
            breakX = ((CHARS - data.length()) / 2) + data.length();
            if (breakX < lastX) {
              for (int i = 0; i < (lastX - breakX) && data.length() < CHARS; i++) {
                data = " " + data;
                data = data + " ";
              }
              if (CHARS > data.length()) {
                breakX = ((CHARS - data.length()) / 2) + data.length();
              } else {
                breakX = data.length();
              }
            }
          }
          break;
          case 2:
          breakX = CHARS;
          break;
          case 3:
          breakX = data.length();
          break;
        }
      } else {
        switch (teck) {
          case 0:
          breakX = -(CHARS + data.length());
          break;
          case 1:
          breakX = -((CHARS - data.length()) / 2) - data.length();
          if (tock == 1) {
            firstX = 0;
            for (int i = 0; i < CHARS; i++) {
              if (dis[i] != ' ') break;
              firstX ++;
            }
            firstX = -(CHARS - firstX);
            if (breakX > firstX) {
              for (int i = 0; i < (breakX - firstX) && data.length() < CHARS; i++) {
                data = " " + data;
                data = data + " ";
              }
              if (CHARS > data.length()) {
                breakX = -((CHARS - data.length()) / 2) - data.length();
              } else {
                breakX = data.length();
              }
            }
          }
          break;
          case 2:
          breakX = -CHARS;
          break;
          case 3:
          breakX = - data.length();
          break;
        }
      }
      break;

      case AIRPORT:
      for (int i = data.length(); i < CHARS; i++) {
        data += " ";
      }
      busy = true;      
      break;
    }
  }

  void drawChar(char thisChar) {
    if (int(thisChar) < alphaFont.length && int(thisChar) >= 0) {
      String thisWord = alphaFont[thisChar].substring(3, 18);
      for (int i=0; i<15; i++) {
        if (thisWord.charAt(i) == '1') {
          shape(segments[i], 0, 0);
        }
      }
    }
  }

  void clearDisplay() {
    for (int i = 0; i < CHARS; i++) {
      dis[i] = ' ';
    }
    dec = new boolean[CHARS];
    cursorX = 0;
  }

  String invalid  = "`´âáäÁÂÄéêëÉÊËíîïÍÎÏóôöÓÔÖúûüÚÛÜñÑ";
  String subs     = "'''aaAAAeeeEEEiiiIIIoooOOOuuuUUUnN   ";
  String valid = " !@#$%^&*()-+=[|]}{;':<>,.?/~`°'_01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"+char(34)+char(135);

  String cleanUp(String str) {
    String res = "";
    for (int i=0; i<str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '&') {
        if (str.charAt(i+1) == '#') {
          ch = 39;
          i = i+6;
        } else {
          if (str.length() > i+5) {
            if (str.charAt(i+5) == ';') {
              ch = 39;
              i = i+5;
            }
          }
        }
      }
      if (invalid.indexOf(ch) != -1) {
        ch = subs.charAt(invalid.indexOf(ch));
      }
      if (valid.indexOf(ch) != -1) {
        res +=  ch;
      } else {
        res += char(39);
      }
    }
    return res;
  }
}