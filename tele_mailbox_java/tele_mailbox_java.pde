
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
final int ALPHABET = 108;
final int SDCARD = 109;
final int MAIL = 110;
final int THING = 111;
final int TWITTER = 113;
final int NEWS = 114;
final int SETTINGS = 200;
final int REFRESH = 201;

final int RESULTS = 120;

boolean dweet, usb, bluetooth, wifi, paired, connecting, connected, ready, online, located, found, forecasted, placed, loggedin, loading, metric = true;

boolean play;
boolean refresh;

int servoDown = 20;
int servoUp = 177;
int servoWave = 175;

int channel = -1;

ArrayList<String> pages;
int pageIndex;
int lastPageIndex;
int pageSpeed = 200;
long lastPage;
boolean initPage;

boolean debug = false;

boolean android = false;

// boolean gradient = false;

void setup() {
  size(1600, 900);
  rectMode(CENTER);
  imageMode(CENTER);
  initTime();
  initComm();
  initColors();
  initGui();
  initPilots();
  // initWifi();
  // initOnline();
  // initThing();
  initLocation();
  initContacts();
  //initPlaces();
  begin();
}

int currentSymbol = 0;
int currentColor = 0;

void setChannel(int thisCOM8x8mand) {
  println(thisCOM8x8mand);
  channel = thisCOM8x8mand;
  switch(channel) {
    case PLAY:
    // printBlank();
    // printForeground(whiteColor);
    currentSymbol ++;
    if (currentSymbol == pilots.size()) currentSymbol = 0;
    // printForeground(foreground);
    printBlank();
    printSymbol(pilots.get(currentSymbol).icon, 40, 40, 48, 48, 1, true);
    break;

    case UP:
    foreground = fWheel.c;
    background = bWheel.c;
    printForeground(foreground);
    printBackground(background);

    break;

    case DOWN:
    int g = (int)random(gradients.length);
    top = tops[g];
    bottom = bottoms[g];
    printGradient(color(red(top), green(top), blue(top)), color(red(bottom), green(bottom), blue(bottom)));
    break;

    case LEFT:
    if (currentColor ++ == colors.length-1) currentColor = 0;
    printBackground(colors[currentColor]);
    printBlank();
    break;


    case THING:
    // updateThing();
    // if (dweeted) {
    //   dweeted = false;
    //   if (latestDweet.content_ != null) {
    //     String[] items = splitTokens(latestDweet.content_, ",");
    //     if (items[0].equals("CONTACT")) {
    //     }
    //   }
    // }
    break;
    case MAIL:
    pageSpeed = 500;
    updateMail();
    pages = mails;
    break;
    case TIME:
    printTime();
    break;
    case SDCARD:
    writeString("0");
    printBlank();
    printDirectory("/");
    break;
    case CONTACTS:
    updateContacts();
    //pages = contacts;
    printContact();
    break;
    case WEATHER:
    updateWeather();
    //pages = weathers;
    printWeather();
    break;
    case LOCATION:
    updateLocation();
    //pages = locations;
    printLocation();
    break;
    case ONLINE:
    updateOnline();
    //pages = onlines;
    printOnline();
    break;
    case WIFI:
    updateWifi();
    //pages = wifis;
    printWifi();
    break;
    case DRIVE:

    break;
    case ALPHABET:
    // println("pixels");
    // printBytes(64,64,48,48);
    // initPage = false;
    // // printServo(servoDown);
    // printForeground(color(255,255,255));
    // printBackground(redColor);
    printBlank();

    printAlphabet(true, currentFont, 0, 0);
    currentFont ++;
    currentFont = currentFont % widths.length;
    break;
    case USB:
    if (connected) {
      terminate();
    } else {
      begin();
    }
  }
  initPage = true;
  pageIndex = 0;
  lastPageIndex = - 1;
  lastPage = millis() - pageSpeed;

}

void draw() {
  displayGui();
  if (connected) {
    rx();
    tx();
  }
  if (connecting) {
    if (portName != null) {
      connected = true;
      connecting = false;
      printServo(servoDown);
      printForeground(foreground);
      printBackground(background);
      printBlank();
      busy = false;
      setChannel(TIME);
    }
  }

  // if (millis() - lastPage>pageSpeed) {
  //   getDweet();
  //   if (dweeted) {
  //     dweeted = false;
  //     if (latestDweet.content_ != null) {
  //       String[] items = splitTokens(latestDweet.content_, "|");
  //       println("got dweet "+items);
  //       if (items[0].indexOf("CONTACTS") != -1) { /////////// fix dweet from frame (now frameCONTACT
  //         printServo(servoWave);
  //         printBlank();
  //         printServo(servoUp);
  //         printForeground(redColor);
  //         // println(items[2]);
  //         printImage(items[2], 16, 16);
  //         writeString("E");
  //         printString(cleanUp(items[1]), false, true, ARIALB14, 0, 2);
  //         lastPage = millis();
  //         //busy = true;
  //       }
  //     }
  //   }
  // }


  if (channel == TIME) {
    if (millis() - lastPage > pageSpeed) {
      lastPage = millis();
      printString(getStringTime(false), true, true, ARIALB14, 0, 26);
      pageSpeed = 500;

    }
  }

  if (channel == MAIL) {
    if (millis() - lastPage > pageSpeed) {
      lastPage = millis();
      lastPageIndex = pageIndex;
      pageSpeed = 3000;
      String stringText = ""; 
      String thisPage = pages.get(pageIndex);
      String[] items = splitTokens(thisPage, ""+TAB);
      String name = cleanUp(removeQuotes(items[0].substring(0, items[0].indexOf("<")-1)));
      if (name.indexOf("(") != -1) {
        name = name.substring(0, items[0].indexOf("(")-2);
      }
      if (name != null) {
        // sendDweet("CONTACTS", removeSpaces(name).toUpperCase()+"|null");  //////////
      }
      printServo(servoWave);
      printBlank();
      printServo(servoUp);
      printForeground(redColor);
      int y = 100;
      y = printString(name, false, true, ARIALB14, 0, y);
      printForeground(color(50, 50, 50));
      y -= 14;
      String subject = cleanUp(items[2]);
      if (subject.length() > 50) subject = subject.substring(0,50);
      printString(subject, true, true, COM8x8, 0, y);
      printString(items[1].substring(0, 16), false, true, SYSTEM5x7, 0, 5);
      printString(items[1].substring(18, items[1].length()), false, true, SYSTEM5x7, 0, 15);
      pageIndex++;
      if (pageIndex == pages.size()) {
        updateMail();
        pageIndex = 0;
        pageSpeed = 10000;
      }
    }
  }
}

void printContact() {
  printServo(servoWave );
  printBlank();
  printServo(servoUp);
  printForeground(redColor);
  printImage(contactImage, 16, 112);
  // writeString("E");
  printString(cleanUp(contactName), false, true, FONT10x14, 0, 127);
  // sendDweet("CONTACTS", contactName +"|"+contactImage);  //////////
}

void printLocation() {
  printBlank();
  printString(getCoordinate(longitude, false), true, true, COM8x8, 0, 96);
  printString(getCoordinate(latitude, true), true, true, COM8x8, 0, 108);
  printString(houseNumber +" "+ street, false, true, SYSTEM5x7, 0, 40);
  printString(neighbourhood, false, true, ARIALB14, 0, 28);
  printSymbol(getPilot("weather").icon , 40, 40, 48, 48, .75, true);

}

void printWeather() {
  printBlank();
  printString(neighbourhood, false, true, ARIALB14, 0, 28);
  printString(condition+"", false, true, ARIAL14, 0, 40);
  printString(int(humidity)+"% "+ int(pressure)+" mPa", false, true, SYSTEM5x7, 0, 98);
  printString(int(windSpeed)+" m/h "+getHeading(windDeg)+" "+(int)windDeg, false, true, SYSTEM5x7, 128, 108);
  int tmp = int(metric ? getCelcius(temp) : temp);
  // String decimals = ""+(getCelcius(temp) - int(getCelcius(temp)));
  if (tmp >= 10) {
    printCharacter((""+tmp).charAt(0) , 18, 40, 48, 48, 1, 60, true);
    printCharacter((""+tmp).charAt(1) , 54, 40, 48, 48, 1, 60, true);
    printString(metric ? "C" : "F", false, false, ARIALB14, 90, 56);
  } else {
    printString(metric ? "C" : "F", false, false, ARIALB14, 80, 56);
    printCharacter((""+tmp).charAt(0) , 40, 40, 48, 48, 1, 60, true);
  }
}

void printTime() {
  printBlank();
  printString(monthStr+"", false, true, ARIALB14, 0, 102);
  printString(dayStr+"", false, true, ARIAL14, 0, 40);
  printString(year+"", false, true, ARIAL14, 0, 118);
  if (day > 9) {
    // printCharacter((""+day).charAt(0) , 26, 40, 48, 48, 1, 58, true);
    // printCharacter((""+day).charAt(1) , 58, 40, 48, 48, 1, 58, true);
    printCharacter((""+day).charAt(0) , 28, 40, 48, 48, 1, 50, true);
    printCharacter((""+day).charAt(1) , 56, 40, 48, 48, 1, 50, true);
  } else {
    printCharacter((""+day).charAt(0) , 40, 40, 48, 48, 1, 50, true);
  }
}

void printOnline() {
  printBlank();
  printString(externalIP, false, true, ARIALB14, 0, 82);
  printString("ping "+pingTime+"ms",false, true, SYSTEM5x7, 0, 90);
  printSymbol(getPilot("online").icon , 40, 20, 48, 48, .9, true);

}

void printWifi() {
  printBlank();
  printString(hostIP, false, true, ARIALB14, 0, 82);
  printString(hostName, false, true, SYSTEM5x7, 0, 90);
  printSymbol(getPilot("wifi").icon , 40, 20, 48, 48, .9, true);
}