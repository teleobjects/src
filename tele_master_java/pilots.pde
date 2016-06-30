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
    thisPilot.y = android ? 700 : height - 100;
    pilots.add(thisPilot);
  }

  pilotTable = loadTable("csv/pilotsControl.csv", "header, csv");
  for (int i=0; i<pilotTable.getRowCount(); i++ ) {
    TableRow row = pilotTable.getRow(i);
    Pilot thisPilot = new Pilot(row.getString("name"), row.getString("shape"), row.getInt("command"));
    thisPilot.x = 80+(130*i);
    thisPilot.y = android ? 820 : height;
    pilots.add(thisPilot);
  }
}

void displayPilots() {
  String bluetoothInfo = "";

  for (Teleobject teleobject : teleobjects) {
    if (teleobject.comm != null) {
      if (android) {
        bluetoothInfo += (teleobject.comm.found ? teleobject.comm.portName : teleobject.name + " not found") + "\n";
        bluetoothInfo += (teleobject.comm.paired ? "P" : "p" );
        bluetoothInfo += (teleobject.comm.discovering ? "D" : "d");
        bluetoothInfo += (teleobject.comm.discovered ? "S" : "s");
        bluetoothInfo += (teleobject.comm.connected ? "C" : "c");
        bluetoothInfo += (teleobject.comm.acknowledged ? "A" : "a");
        bluetoothInfo += (teleobject.comm.busy ? "B" : "b") + "\n";
        //bluetoothInfo += teleobject.comm.timeOuts + " timeouts";
      } else {
        bluetoothInfo += teleobject.comm.portName+"\n";
        // bluetoothInfo += (teleobject.comm.acknowledged ? "acknowledged" : "not acknowledged") + "\n";
      }
    }
  }

  String energyInfo = "";
  for (Teleobject teleobject : teleobjects) {
    if (teleobject.comm != null) {
      energyInfo += teleobject.comm.battery+"v "+(teleobject.comm.charging ? "c" : "b")+"\n";
    }
  }

  String currentChannelName = "null";

  Pilot currentPilot = getPilotByCommand(manager.channel);
  if (currentPilot != null) currentChannelName = currentPilot.name.toUpperCase();
  setPilot("play", manager.play);

  // TOP

  setPilot("settings", debug);
  setPilot("settings", width + "x" + height + "px\n" + (retina ? "retina" : "non-retina") + "\n" + (int)frameRate +" fps\n" + currentChannelName);

  setPilot("bluetooth", bluetooth.available);
  setPilot("bluetooth", bluetoothInfo);

  setPilot("wifi", network.wifi); 
  setPilot("wifi", (network.wifi ? "wifi enabled" : "wifi disabled") + "\n" + network.hostIP + "\n" + network.hostName+"\n" + (network.router ? "connected to WLAN" : "no WLAN" ));

  setPilot("mobile", network.type + "\n" + network.state + "\n" + network.reason + "\n" + network.extra + "\n" + (network.roaming ? " roaming" : "not roaming") 
    + "\n");
  setPilot("mobile", network.networked); 

  setPilot("online", network.online);
  setPilot("online", (network.online ? "online" : "offline") + "\n" + (network.online ? network.externalIP+"\n"+network.pingTime+"ms" : ""));

  setPilot("energy", manager.channel == ENERGY);
  setPilot("energy", energyInfo);

  setPilot("orientation", manager.channel == ORIENTATION);
  setPilot("orientation", "R "+(ticker.comm.ax>=0?"+":"")+int(ticker.comm.ax)+"\n"+"P "+(ticker.comm.ay>=0?"+":"")+int(ticker.comm.ay)+"\n"+"H "+(ticker.comm.az>=0?"+":"")+int(ticker.comm.az));

  setPilot("time", manager.channel == TIME);
  setPilot("time", getStringTime(true, ":")+"\n"+getStringDate("/"));

  setPilot("sync", sync);

  setPilot("search", manager.channel == SEARCH);


  int brightnessIndex = (int)map(ticker.comm.brightness, 1, 13, 2, 10);

  setPilot("dim", manager.channel==DIM);
  setPilot("dim", brightnessIndex+"0%");

  setPilot("eq", manager.channel==EQ);
  setPilot("eq", "R "+nf((int)(eq.rightL*1000), 3, 0)+"\nL "+nf((int)(eq.leftL*1000), 3, 0));

  setPilot("navigation", manager.channel==NAVIGATION);

  setPilot("location", manager.channel==LOCATION);
  setPilot("location", getCoordinate(geolocation.latitude, true)+"\n"+getCoordinate(geolocation.longitude, false)+"\n"+geolocation.provider+", "+(time.currentTimeStamp-geolocation.lastUpdated)/1000+"s\n"+geolocation.houseNumber+" "+geolocation.street+"\n"+geolocation.neighbourhood);
  setPilot("sleep", manager.channel==SLEEP);
  setPilot("sleep", (int)frameRate+" fps\n"+width+"x"+height+"px");

  // BOTTOM

  setPilot("google", google.loggedin);
  if (profile != null) {
    setPilot("google", profile.givenName+" "+ profile.familyName+"\n"+profile.email+"\n"+profile.id+"\n"+profile.kind+"\n"+profile.minAge+"\n"+profile.language);
    if (profile.img != null && google.loggedin) {
      setPilot("google", profile.img);
    } else {
      getPilot("google").img = null;
    }
  }

  setPilot("mail", manager.channel==MAIL);

  setPilot("contacts", manager.channel==CONTACTS);
  setPilot("contacts", contacts.contactList.size()+" contacts");

  setPilot("calendar", manager.channel==CALENDAR);
  setPilot("calendar", calendar.eventList.size()+" events");

  setPilot("youtube", manager.channel==YOUTUBE);

  setPilot("drive", manager.channel==DRIVE);

  setPilot("twitter", manager.channel==TWITTER);
  setPilot("twitter", twitter.name+"\n@"+twitter.screenName+"\n"+twitter.userID+"\n"+twitter.followers.size()+" followers\n"+twitter.friends.size()+" friends\n"+twitter.trends.size()+" trending topics");
  if (twitter.img != null) setPilot("twitter", twitter.img);

  setPilot("facebook", manager.channel==FACEBOOK);

  setPilot("instagram", manager.channel==INSTAGRAM);

  setPilot("foursquare", manager.channel==FOURSQUARE);

  setPilot("news", manager.channel==NEWS);
  setPilot("news", getEasyTimeStamp(news.lastUpdated));

  setPilot("weather", manager.channel==WEATHER);
  setPilot("weather", weather.conditionMain+", "+(time.currentTimeStamp-weather.lastUpdated)/1000+"s"+"\n"+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + (metric ? "°C" : char(29)+"°F")+"\n"+int(weather.humidity)+"% humidity"+"\n"+
    weather.pressure+"mPa \n"+weather.clouds+"% clouds\n"+weather.windSpeed+"m/h \n"+getHeading(weather.windDeg)+" "+(int)weather.windDeg+"°");

  // CENTER

  setPilot("play", manager.play);
  setPilot("loop", manager.loop);


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

  Pilot(String thisName, String thisShape, int thisCommand) {
    name = thisName;
    if (thisShape.equals("bluetooth") && !android) thisShape = "usb";
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
        strokeWeight(2);
        shape(icon, 0, 0);
      }
      noFill();
      strokeWeight(2);
      stroke(state ? redColor : whiteColor);
      shape(app, 0, 0);
    }
    if (label!=null && (debug || ((name.equals("bluetooth") || name.equals("settings")) && activeObject == null))) { 
      fill(50);
      textAlign(CENTER);
      int fontSize = android ? 20 : 16;
      int lineHieght = android ? 26 : 24;
      textFont(font, fontSize);
      int offsetY =  y < height/2 ? 84 : (-84 - (countChar(label, '\n')*lineHieght));
      text(label, 0, offsetY);
    }
    popMatrix();
  }

  void check() {
    sx = screenX (x, y);
    sy = screenY (x, y);
    if (gui.clicked && dist(sx, sy, mouseX, mouseY) < 50) {
      manager.setChannel(command);
      gui.clicked = false;
    }
  }
}

// void setPilotRotation(String thisPilot, boolean thisRotation) {
//   for (Pilot pilot : pilots) {
//     if (pilot.name.equals(thisPilot)) {
//       pilot.rotating = thisRotation;
//       break;
//     }
//   }
// }

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