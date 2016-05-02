final int PLAY = -20;
final int UP = -10;
final int DOWN = -11;
final int LEFT = -12;
final int RIGHT = -13;
final int USB = -1;
final int BLUETOOTH = -2;
final int LOCATION = 100;
final int CONTACTS = 101;
final int PLACES = 102;
final int WEATHER = 103;
final int ONLINE = 104;
final int WIFI = 105;
final int TIME = 106;
final int EQ = 107;
final int MAIL = 110;
final int THING = 111;
final int DRIVE = 112;
final int TWITTER = 113;
final int NEWS = 114;

final int SETTINGS = 200;
final int REFRESH = 201;

final int RESULTS = 120;


String createString(String thisString, int thisMode, int thisTick, int thisTock, int thisTuck) {
  return thisMode+""+TAB+""+thisTick+""+TAB+""+thisTock+""+TAB+""+thisTuck+""+TAB+""+thisString;
}

void setChannel(int thisCommand) {
  if ((thisCommand >= BATTERY && thisCommand <= SNOW) || thisCommand == SLEEP) {
    channel = thisCommand;
    writeString("", thisCommand, 1, 1, 1);
  }

  boolean flag = false;

  switch(thisCommand) {
  case RESULTS:
    play = true;
    channel = thisCommand;
    pages = results;
    flag = true;
    break;

  case PLACES:
    play = false;
    pages = places;
    initPage = true;
    channel = thisCommand;
    lastPageIndex = - 1;
    break; 

  case UP:
    if (channel == PLACES) {
      searchPlaces();
      setChannel(RESULTS);
      flag = true;
    }
    break;

  case RIGHT:
    busy = false;
    alpha.busy = false;
    lastPage = 0;
    pageIndex ++;
    direction = true;
    if (pageIndex == pages.size()) pageIndex = 0;
    break;

  case LEFT:
    busy = false;
    alpha.busy = false;
    lastPage = 0;
    pageIndex --;
    direction = false;
    if (pageIndex == -1) pageIndex = pages.size()-1;
    break;

  case SETTINGS:
    debug = !debug;
    break;

  case REFRESH:
    refresh = !refresh;
    break;

  case USB:
    if (!android) {
      if (!connected) {
        usb = true;
        beginComm();
      } else {
        // terminateComm();
      }
    }
    break;

  case BLUETOOTH:
    if (android  && !connected) {
      beginComm();
    }
    if (!android) {
      if (!connected) {
        //
        beginComm();
      } else {
        // terminateComm();
      }
    }
    break;

  case TWITTER:
    // updateTwitter();
    // pages = tweets;
    // channel = thisCommand;
    // flag = true;
    break;

  case NEWS:
    updateNews();
    pages = news;
    channel = thisCommand;
    flag = true;
    break;

  case THING:
    dweet = !dweet;
    break;

  case PLAY:
    play = !play;
    break;

  case MAIL:
    updateMail();
    pages = mails;
    channel = thisCommand;
    flag = true;
    break;

  case CONTACTS:
    play = false;
    pages = contacts;
    channel = thisCommand;
    flag = true;

    break;
  case LOCATION:
    updateLocation();
    pages = locations;
    channel = thisCommand;
    flag = true;
    break;

  case WEATHER:
    updateWeather();
    pages = weathers;
    channel = thisCommand;
    flag = true;
    break;

  case ONLINE:
    updateOnline();
    pages = onlines;
    channel = thisCommand;
    flag = true;
    break;

  case WIFI:
    updateWifi();
    pages = wifis;
    channel = thisCommand;
    flag = true;
    break;

  case DRIVE:
    updateDrive();
    pages = drives;
    channel = thisCommand;
    flag = true;

    break;

  case TIME:
    channel = thisCommand;
    flag = true;
    break;

  case EQ:
    channel = thisCommand;
    break;
  }

  if (flag) {
    initPage = true;
    pageIndex = 0;
    lastPageIndex = - 1;
    lastPage = 0;
  }

  refresh = true;
  busy = false;
}

void play() {

  if (channel == ONLINE || channel == WIFI || channel == LOCATION || channel == WEATHER || channel == RESULTS ||
    channel == DRIVE || channel == MAIL || channel == TWITTER || channel == NEWS ||
    channel == UP || channel == DOWN || channel == RIGHT || channel == LEFT) {

    //if (!busy && abs(ax) > tiltAngle) {
    //  play = false;
    //  if (millis() - lastPage > 500) {
    //    if (ax > 0) {
    //      direction = true;
    //      pageIndex++;
    //      lastPage = 0;
    //      if (pageIndex == pages.size()) pageIndex = 0;
    //    } else {
    //      direction = false;
    //      pageIndex--;
    //      lastPage = 0;
    //      if (pageIndex == -1) pageIndex = pages.size()-1;
    //    }
    //  }
    //}
    if (!busy) {
      if (pageIndex != lastPageIndex) {
        if (millis() - lastPage > tuck*100) {
          lastPage = millis();
          busy = true;
          lastPageIndex = pageIndex;
          String stringText = ""; 
          String thisPage = pages.get(pageIndex);
          if (thisPage.indexOf(TAB+"") != -1) {
            String[] items = splitTokens(thisPage, ""+TAB);
            displayMode = parseInt(items[0]);
            tick = parseInt(items[1]);
            tock = parseInt(items[2]);
            tuck = parseInt(items[3]);
            if (items.length > 4) {
              stringText = items[4];
            }
          } else {
            stringText = thisPage;
            displayMode = TICKER;
            tick = 20;
            tock = 10;
            tuck = 10;
          }
          writeString(stringText, displayMode, tick, tock, tuck);
          if (play) {
            //println("play");
            pageIndex ++;
            if (pageIndex == pages.size()) {
              pageIndex = 0;
            }
          }
        }
      }
    } else { 
      //lastPage = millis();
    }
  }

  if (channel == TIME) {
    if (millis() - lastPage > 1000) {
      lastPage= millis();
      writeString(cleanUp(getStringTime(true)), CENTERED, 1, 1, 1);
    }
  }

  //if (dweet && !busy) {
  //  if (millis() - lastDweet > 1000) { /////////
  //    lastDweet = millis();
  //    getDweet();
  //  }
  //  if (dweeted) {
  //    dweeted = false;
  //    if (latestDweet.content_ != null) {
  //      String[] items = splitTokens(latestDweet.content_, "|");
  //      println("got dweet "+items[1]);
  //      if (items[1].indexOf("CONTACTS") != -1) { /////////// fix dweet from frame (now frameCONTACT
  //        writeString(items[2], SCROLL_PUSH_RIGHT, 10, 1, 20);
  //        lastPage = millis();
  //        //busy = true;
  //      }
  //    }
  //  }
  //}

  if (channel == RESULTS) {
    if (az < -5 && !busy) {
      setChannel(PLACES);
    }
  }

  if (channel == PLACES || channel == CONTACTS && !busy) {
    if (millis() - lastPage > 1000) {
      if (play && channel == CONTACTS) {
        direction = true;
        pageIndex++;
        if (pageIndex == pages.size()) pageIndex = 0;
      }
      //if (abs(ax) > tiltAngle ) {
      //  //lastPage = millis();
      //  if (ax > 0) {
      //    direction = true;
      //    pageIndex++;
      //    if (pageIndex == pages.size()) pageIndex = 0;
      //  } else {
      //    direction = false;
      //    pageIndex--;
      //    if (pageIndex == -1) pageIndex = pages.size()-1;
      //  }
      //}
      if (az > 5) {
        //if (channel == PLACES) {
        //  searchPlaces();
        //  setChannel(RESULTS);
        //}
      } else if (pageIndex != lastPageIndex) {
        if (!busy) {
          lastPage = millis();
          busy = true;
          if (channel == CONTACTS) {  
            if (dweet) {        
              //sendDweet("CONTACTS", pages.get(pageIndex)+"|"+profileImages.get(pageIndex));
            }
          }

          writeString(cleanUp(pages.get(pageIndex), true), direction ? 
            SCROLL_PUSH_RIGHT : SCROLL_PUSH_LEFT, 10, 1, 10);
          lastPageIndex = pageIndex;
        }
      }
    }
  }

  //if (channel == EQ) {
  //  if (!android) {
  //    updateMic();
  //    tuck = 1;
  //    if (millis() - lastPage > tuck*100) {
  //      lastPage = millis();
  //      String str = "";
  //      for (int i=0; i<CHARS; i++) {
  //        str += eq[i];
  //      }
  //      writeString(str, STREAM, 1, 1, 1);
  //    }
  //  }
  //}
}