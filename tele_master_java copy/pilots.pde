ArrayList<Pilot> pilots; 

void initPilots() {
  pilots = new ArrayList<Pilot>();

  int offsetX = width / 16; 

  Table pilotTable = loadTable("csv/pilotsTop.csv", "header, csv");
  for (int i=0; i<pilotTable.getRowCount(); i++ ) {
    TableRow row = pilotTable.getRow(i);
    Pilot thisPilot = new Pilot(row.getString("name"), row.getString("shape"), row.getInt("command"));
    thisPilot.x = offsetX/2+(offsetX*i);
    thisPilot.s = width/2400.0;
    thisPilot.y = offsetX-(50*thisPilot.s);
    pilots.add(thisPilot);
  }

  pilotTable = loadTable("csv/pilotsBottom.csv", "header, csv");
  for (int i=0; i<pilotTable.getRowCount(); i++ ) {
    TableRow row = pilotTable.getRow(i);
    Pilot thisPilot = new Pilot(row.getString("name"), row.getString("shape"), row.getInt("command"));
    thisPilot.x = offsetX/2+(offsetX*i);
    thisPilot.s = width/2400.0;
    thisPilot.y = height-offsetX+(50*thisPilot.s);
    // thisPilot.y = 1000;
    pilots.add(thisPilot);
  }

  //pilotTable = loadTable("csv/pilotsControl.csv", "header, csv");
  //for (int i=0; i<pilotTable.getRowCount(); i++ ) {
  //  TableRow row = pilotTable.getRow(i);
  //  Pilot thisPilot = new Pilot(row.getString("name"), row.getString("shape"), row.getInt("command"));
  //  thisPilot.x = offsetX/2+(offsetX*i);
  //  thisPilot.s = width/2400.0;
  //  thisPilot.y = height-(offsetX);
  //  // thisPilot.y = 1130;
  //  pilots.add(thisPilot);
  //}
}

void displayPilots() {
  String bluetoothInfo = "";

  for (Teleobject teleobject : teleobjects) {
    if (teleobject.comm != null) {
      if (androidMode) {
        bluetoothInfo += (teleobject.comm.found ? teleobject.comm.portName : teleobject.name + " not found") + "\n";
        bluetoothInfo += (teleobject.comm.paired ? "P" : "p" );
        bluetoothInfo += (teleobject.comm.discovered ? "D" : "d");
        bluetoothInfo += (teleobject.comm.connected ? "C" : "c");        
        bluetoothInfo += (teleobject.comm.acknowledged ? "A" : "a");
        bluetoothInfo += (teleobject.comm.busy ? "B" : "b") + "\n" ;
      } else {
        if (teleobject.comm.connected) {
          bluetoothInfo +=  teleobject.comm.portName +" " +(teleobject.display.busy ? "B" : "b") + "\n";
        }
      }
    }
  }

  String energyInfo = "";
  for (Teleobject teleobject : teleobjects) {
    if (teleobject.comm != null && teleobject.comm.connected) {
      energyInfo += teleobject.comm.battery+"v "+(teleobject.comm.charging ? "c" : "b")+"\n";
    }
  }

  String dimInfo = "";
  for (Teleobject teleobject : teleobjects) {
    if (teleobject.comm != null && teleobject.comm.connected) {
      int index = (int)map(teleobject.comm.brightness, 1, 15, 1, 10);
      dimInfo += index+"0 %\n";
    }
  }

  String environmentInfo = ticker.comm.temperature+"°C\n"+ ticker.comm.humidity+"%\n"+ticker.comm.pressure+"mba";
  setPilot("environment", manager.channel == ENVIRONMENT);
  setPilot("environment", environmentInfo);

  String currentChannelName = "null";

  Pilot currentPilot = getPilotByCommand(manager.channel);
  if (currentPilot != null) currentChannelName = currentPilot.name.toUpperCase();
  setPilot("play", manager.play);

  // TOP

  setPilot("settings", debug);
  setPilot("settings", width + "x" + height + "px\n" + (retina ? "retina" : "non-retina") + "\n" + (int)frameRate +" fps\n" + currentChannelName);

  setPilot("bluetooth", bluetooth.available);
  setPilot("bluetooth", bluetoothInfo);

  String networkInfo = (network.wifi ? "wifi enabled" : "wifi disabled") + "\n";
  if (network.wifi) {
    if (network.router) {
      networkInfo += (androidMode ? network.ssid : network.hostName)+ "\n";
      networkInfo += network.ip ? network.hostIP : "no IP";
    } else {
      networkInfo += "";
    }
  }
  setPilot("wifi", network.wifi && network.ip);
  setPilot("wifi", networkInfo);

  setPilot("mobile", network.cellular ? network.state + "\n" + network.extra : "" ); // + "\n" + network.reason
  setPilot("mobile", network.cellular);

  setPilot("online", network.online);

  String onlineInfo = (network.online ? "online" : "offline") + "\n";
  if (network.online) {
    onlineInfo += network.type + "\n" + network.externalIP + "\n" + network.pingTime + "ms";
  }
  setPilot("online", onlineInfo);

  setPilot("energy", manager.channel == ENERGY);
  setPilot("energy", energyInfo);

  setPilot("orientation", manager.channel == ORIENTATION);
  setPilot("orientation", "P "+(ticker.comm.ay>=0?"+":"")+int(ticker.comm.ay)+"\n"+"R "+(ticker.comm.ax>=0?"+":"")+int(ticker.comm.ax)+"\n"+"H "+(ticker.comm.az>=0?"+":"")+int(ticker.comm.az));

  setPilot("time", manager.channel == TIME);
  setPilot("time", getStringTime(true, ":")+"\n"+getStringDate("/"));

  setPilot("sync", sync);

  setPilot("search", manager.channel == SEARCH);



  setPilot("dim", manager.channel==DIM);
  setPilot("dim", dimInfo);

  setPilot("eq", manager.channel==EQ);
  setPilot("eq", "R "+nf((int)(eq.rightL*1000), 3, 0)+"\nL "+nf((int)(eq.leftL*1000), 3, 0));

  setPilot("navigation", manager.channel==NAVIGATION);

  setPilot("location", manager.channel==LOCATION);
  setPilot("location", getCoordinate(geolocation.latitude, true)+"\n"+getCoordinate(geolocation.longitude, false)+"\n"+geolocation.provider+", "+(time.currentTimeStamp-geolocation.lastUpdated)/1000+"s\n"+geolocation.houseNumber+" "+geolocation.street+"\n"+geolocation.neighbourhood);
  setPilot("sleep", manager.channel==SLEEP);
  setPilot("sleep", (int)frameRate+" fps\n"+width+"x"+height+"px");

  // BOTTOM

  setPilot("google", google.loggedin);
  if (profile != null && google.loggedin) {
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

  String twitterInfo = "";
  if (twitter.updated) twitterInfo += twitter.name+"\n@"+twitter.screenName+"\n"+twitter.userID+"\n"+twitter.followers.size()+" followers\n"+twitter.friends.size()+" friends\n"+twitter.trends.size()+" trending topics";
  setPilot("twitter", twitterInfo);
  if (twitter.img != null) setPilot("twitter", twitter.img);

  setPilot("facebook", manager.channel==FACEBOOK);

  setPilot("instagram", manager.channel==INSTAGRAM);

  setPilot("foursquare", manager.channel==FOURSQUARE);

  setPilot("news", manager.channel==NEWS);
  setPilot("news", getEasyTimeStamp(news.lastUpdated));

  setPilot("weather", manager.channel==WEATHER);

  String weatherInfo = "";

  if (weather.updated) weatherInfo = weather.conditionMain+", "+(time.currentTimeStamp-weather.lastUpdated)/1000+"s"+"\n"+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + (metric ? "°C" : char(29)+"°F")+"\n"+int(weather.humidity)+"% humidity"+"\n"+
    weather.pressure+"mPa \n"+weather.clouds+"% clouds\n"+weather.windSpeed+"m/h "+getHeading(weather.windDeg)+"\n"+ getEasyTimeStamp(weather.lastUpdated);
  setPilot("weather", weatherInfo);

  // CENTER

  setPilot("play", manager.play);
  setPilot("loop", manager.loop);

  for (Pilot thisPilot : pilots) {
    thisPilot.check();
    thisPilot.display();
  }
}


class Pilot {
  String label;
  String name;
  int command;
  boolean state;
  PShape icon;
  float x, y, s;
  //float sx, sy;
  float val;
  PImage img;

  Pilot(String thisName, String thisShape, int thisCommand) {
    name = thisName;
    if (thisShape.equals("bluetooth") && !androidMode) thisShape = "usb";
    icon = loadShape("svg/"+thisShape+".svg");
    icon.disableStyle();
    command = thisCommand;
  }

  void display() {
    pushMatrix();
    translate(x, y);
    scale(s);

    //noStroke();
    //fill(80);
    //shape(app, 0, 0);


    // if (gui.refresh) {
    // rectMode(CENTER);
    // noStroke();
    // fill(backgroundColor);
    // rect(0, 0, 120, 120);
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
      stroke(state ? redColor : 150);
      strokeWeight(2);
      shape(icon, 0, 0);
    }
    noFill();
    strokeWeight(2);
    stroke(state ? redColor : 150);
    shape(app, 0, 0);
    // }       
    if (label!=null && debug) { 
      fill(real ? 50 : 200);
      textAlign(CENTER);
      int lineHeight = androidMode ? 24 : 24;
      int offsetY =  y < height/2 ? 84 : (-84 - (countChar(label, '\n')*lineHeight));
      text(label, 0, offsetY);
    }
    popMatrix();
  }

  void check() {
    if (gestures.tapped && dist(x, y, mouseX, mouseY) < 60*s) {
      manager.setChannel(command);
      gestures.tapped = false;
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