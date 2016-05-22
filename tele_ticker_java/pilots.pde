ArrayList<Pilot> pilots; 

void initPilots() {
  pilots = new ArrayList<Pilot>();
  Table pilotTable = loadTable("csv/pilotsTop.csv", "header, csv");
  for (int i=0; i<pilotTable.getRowCount(); i++ ) {
    TableRow row = pilotTable.getRow(i);
    Pilot thisPilot = new Pilot(row.getString("name"), row.getString("shape"), row.getInt("command"));
    thisPilot.x = 80+(130*i);
    thisPilot.y = 70;
    pilots.add(thisPilot);
  }

  pilotTable = loadTable("csv/pilotsBottom.csv", "header, csv");
  for (int i=0; i<pilotTable.getRowCount(); i++ ) {
    TableRow row = pilotTable.getRow(i);
    Pilot thisPilot = new Pilot(row.getString("name"), row.getString("shape"), row.getInt("command"));
    thisPilot.x = 80+(130*i);
    thisPilot.y = (height-70)/(width/gui.cW);
    pilots.add(thisPilot);
  }

  pilotTable = loadTable("csv/pilotsControl.csv", "header, csv");
  for (int i=0; i<pilotTable.getRowCount(); i++ ) {
    TableRow row = pilotTable.getRow(i);
    Pilot thisPilot = new Pilot(row.getString("name"), row.getString("shape"), row.getInt("command"));
    thisPilot.x = -8 + (width/2) - (130*5/2) + (130*i);
    thisPilot.y = (height-200)/(width/gui.cW);
    pilots.add(thisPilot);
  }
}

void displayPilots() {
  String currentChannelName = "null";

  Pilot currentPilot = getPilotByCommand(channel);
  if (currentPilot != null) currentChannelName = currentPilot.name.toUpperCase();
  setPilot("play", play);
  // setPilot("refresh", refresh);
  setPilot("profile", google.loggedin);
  setPilot("settings", debug);
  setPilot("compass", channel==COMPASS);
  setPilot("contacts", channel==CONTACTS);
  setPilot("twitter", channel==TWITTER);
  setPilot("mail", channel==MAIL);
  setPilot("news", channel==NEWS);
  setPilot("drive", channel==DRIVE);
  //setPilot("things", dweet);
  setPilot("eq", channel==EQ);
  setPilot("time", channel==TIME);
  setPilot("axis", channel==AXIS);
  setPilot("sleep", channel==SLEEP);
  setPilot("places", channel==PLACES);
  setPilot("location", channel==LOCATION);
  setPilot("battery", channel==BATTERY);
  setPilot("weather", channel==WEATHER);
  setPilot("online", online);
  setPilot("wifi", wifi); 
  setPilot("twitter", twitter.name+"\n@"+twitter.screenName+"\n"+twitter.userID+"\n"+twitter.followers.size()+" followers\n"+twitter.friends.size()+" friends\n"+twitter.trends.size()+" trending topics");
  if (twitter.img != null) setPilot("twitter", twitter.img);
  setPilot("calendar", calendar.eventsList.size()+" events");

  setPilot("contacts", contacts.contactList.size()+" contacts");
  if (profile != null) {
    setPilot("profile", profile.givenName+" "+ profile.familyName+"\n"+profile.email+"\n"+profile.id+"\n"+profile.kind+"\n"+profile.minAge+"\n"+profile.language);
  }
  if (profile.img != null) setPilot("profile", profile.img);
  setPilot("sleep", (busy ? "busy" : "free")+"\n"+(int)frameRate+" fps\n"+width+"x"+height+"px\n"+currentChannelName+"\n"+(time.currentTimeStamp-time.startTimeStamp)/1000+"s");
  setPilot("weather", weather.conditionMain+"\n"+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + (metric ? "°C" : char(29)+"°F")+"\n"+int(weather.humidity)+"% humidity"+"\n"+
    weather.pressure+"mPa \n"+weather.clouds+"% clouds\n"+weather.windSpeed+"m/h \n"+getHeading(weather.windDeg)+" "+(int)weather.windDeg+"°\n"+(time.currentTimeStamp-weather.lastUpdated)/1000+"s");
  setPilot("online", onlineState + "\n" + (online ? externalIP+"\n"+pingTime+"ms" : ""));
  setPilot("wifi", wifiState+"\n"+hostIP+"\n"+hostName);
  if (connected) {
    setPilot(usb ? "usb" : "bluetooth", portName+"\nTX "+nf(millis()-lastTx, 4, 0)+"ms\nRX "+nf(millis()-lastRx, 4, 0)+"ms\n"+busy+"\n");
  }
  setPilot("battery", nf(battery, 1, 2)+"v");
  setPilot("time", getStringTime(true)+"\n");
  setPilot("location", getCoordinate(geolocation.latitude, true)+"\n"+getCoordinate(geolocation.longitude, false)+"\n"+geolocation.provider+"\n"+geolocation.houseNumber+" "+geolocation.street+"\n"+geolocation.neighbourhood+"\n"+(time.currentTimeStamp-geolocation.lastUpdated)/1000+"s");
  setPilot("usb", usb && connected);
  setPilot("bluetooth", bluetooth &  connected);
  setPilotRotation("bluetooth", connecting);
  setPilot("axis", "X "+(ax>=0?"+":"")+int(ax)+"\n"+"Y "+(ay>=0?"+":"")+int(ay)+"\n"+"Z "+(az>=0?"+":"")+int(az));
  setPilot("eq", "R "+nf((int)(eq.rightL*1000), 3, 0)+"\nL "+nf((int)(eq.leftL*1000), 3, 0));

  // if (channel == CONTACTS && profile.img != null) {
  //   pushMatrix();
  //   translate(getPilot("contacts").x, getPilot("contacts").y-100);
  //   pushMatrix();
  //   scale(.822);
  //   scale(96.0/ profile.img.height*1.0);
  //   image( profile.img, 0, 0);
  //   popMatrix();
  //   fill(backgroundColor);
  //   noStroke();
  //   scale(.7);
  //   shape(mask, 0, 0);
  //   popMatrix();
  // }
  // if (channel == NEWS && articleImage != null) {
  //   pushMatrix();
  //   translate(getPilot("news").x, getPilot("news").y-100);
  //   pushMatrix();
  //   scale(articleImage.width/mask.width*.765);
  //   image(articleImage, 0, 0);
  //   popMatrix();
  //   fill(backgroundColor);
  //   noStroke();
  //   scale(.7);
  //   shape(mask, 0, 0);
  //   popMatrix();
  // }
  //  if (logged && profileImage != null) {
  //    pushMatrix();
  //    translate(getPilot("account").x, getPilot("account").y);
  //    pushMatrix();
  //    scale(profileImage.width/mask.width*.48);
  //    image(profileImage, 0, 0);
  //    popMatrix();
  //    fill(255, 0, 0, 50);
  //    noStroke();
  //    scale(.7);
  //    shape(mask, 0, 0);
  //    //scale(.7);
  //    //shape(mask, 0, 0);
  //    popMatrix();
  //  }

  for (Pilot thisPilot : pilots) {
    thisPilot.display();
  }
}

void checkPilots() {
  for (Pilot thisPilot : pilots) {
    thisPilot.check();
  }
}

class Pilot {
  String label;
  String name;
  int command;
  boolean state;
  PShape icon;
  float x, y, s = .7;
  float sx, sy;
  float val;
  PImage img;

  //float r = 0;

  boolean rotating;

  Pilot(String thisName, String thisShape, int thisCommand) {
    name = thisName;
    icon = loadShape("svg/"+thisShape+".svg");
    icon.disableStyle();
    command = thisCommand;
  }

  void display() {
    pushMatrix();
    translate(x, y);
    scale(s);
    if (gui.refresh) {
      rectMode(CENTER);
      noStroke();
      fill( backgroundColor);
      rect(0, 0, 120, 120);
      if (img != null) {
        pushMatrix();
        scale(112.0/img.width*1.0);
        imageMode(CENTER);
        image(img, 0, 0);
        popMatrix();
        noStroke();
        fill(backgroundColor);
        shape(mask, 0, 0);
      } else {
        noFill();
        stroke(state ? redColor : 255);
        strokeWeight(3);
        shape(icon, 0, 0);
      }
      noFill();
      strokeWeight(3);
      stroke(state ? redColor : whiteColor);
      shape(app, 0, 0);
    }
    if (label!=null && debug) { 
      fill(50);
      textAlign(CENTER);
      int fontSize = android ? 20 : 16;
      int lineHieght = android ? 26 : 24;
      textFont(font, fontSize);
      int offsetY =  y < height/2 ? 84 : (-90 - (countChar(label, '\n')*lineHieght));
      text(label, 0, offsetY);
    }
    popMatrix();
  }

  void check() {
    sx = screenX (x, y);
    sy = screenY (x, y);
    if (gui.clicked && dist(sx, sy, mouseX, mouseY) < 50) {
      setChannel(command);
      gui.clicked = false;
    }
  }
}

void setPilotRotation(String thisPilot, boolean thisRotation) {
  for (Pilot pilot : pilots) {
    if (pilot.name.equals(thisPilot)) {
      pilot.rotating = thisRotation;
      break;
    }
  }
}

Pilot getPilot(String thisPilot) {
  for (Pilot pilot : pilots) {
    if (pilot.name.equals(thisPilot)) {
      return pilot;
    }
  }
  return null;
}

Pilot getPilotByCommand(int thisCommand) {
  for (Pilot pilot : pilots) {
    if (pilot.command == thisCommand) {
      return pilot;
    }
  }
  return null;
}

void setPilot(String thisPilot, boolean thisState) {
  for (Pilot pilot : pilots) {
    if (pilot.name.equals(thisPilot)) {
      pilot.state = thisState;
      break;
    }
  }
}

void setPilot(String thisPilot, String thisLabel) {
  for (Pilot pilot : pilots) {
    if (pilot.name.equals(thisPilot)) {
      pilot.label = thisLabel;
      break;
    }
  }
}

void setPilot(String thisPilot, PImage img) {
  for (Pilot pilot : pilots) {
    if (pilot.name.equals(thisPilot)) {
      pilot.img = img;
      break;
    }
  }
}