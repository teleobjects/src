ArrayList<Pilot> pilots; 

void initPilots() {
  pilots = new ArrayList();
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
    thisPilot.y = (height-70)/(width/cW);
    pilots.add(thisPilot);
  }
}

void displayPilots() {
  setPilot("play", play);
  setPilot("refresh", refresh);
  setPilot("settings", debug);
  setPilot("contacts", channel==CONTACTS);
  setPilot("twitter", channel==TWITTER);
  setPilot("mail", channel==MAIL);
  setPilot("news", channel==NEWS);
  setPilot("drive", channel==DRIVE);
  setPilot("things", dweet);
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
  setPilot("sleep", (int)frameRate+" fps\n"+width+"x"+height+"px\n"+channel+"\n"+(currentTimeStamp-startTimeStamp)/1000+"s");
  setPilot("weather", conditionMain+"\n"+nf(metric ? getCelcius(temp) : temp, 0, 1) + (metric ? "°C" : char(29)+"°F")+"\n"+int(humidity)+"% humidity"+"\n"+
    pressure+"mPa \n"+clouds+"% clouds\n"+windSpeed+"m/h \n"+getHeading(windDeg)+" "+(int)windDeg+"°\n"+(currentTimeStamp-weatherUpdated)/1000+"s");
  setPilot("online", onlineState + "\n" + (online ? externalIP+"\n"+pingTime+"ms" : ""));
  setPilot("wifi", wifiState+"\n"+hostIP+"\n"+hostName);
  if (connected) {
    setPilot(usb ? "usb" : "bluetooth", "TX "+nf(millis()-lastTx, 4, 0)+"ms\nRX "+nf(millis()-lastRx, 4, 0)+"ms\n"+busy+"\n");
  }
  setPilot("battery", nf(battery, 1, 2)+"v");
  setPilot("time", getStringTime(true)+"\n");
  setPilot("location", getCoordinate(latitude, true)+"\n"+getCoordinate(longitude, false)+"\n"+provider+"\n"+houseNumber+" "+street+"\n"+neighbourhood);
  setPilot("usb", usb && connected);
  setPilot("bluetooth", connected);
  setPilotRotation("bluetooth", connecting);
  setPilot("axis", "X "+(ax>=0?"+":"")+nf(ax, 1, 1)+"\n"+"Y "+(ay>=0?"+":"")+nf(ay, 1, 1)+"\n"+"Z "+(az>=0?"+":"")+nf(az, 1, 1));
  setPilot("eq", "R "+nf((int)(rightL*1000), 3, 0)+"\nL "+nf((int)(leftL*1000), 3, 0));

  if (channel == CONTACTS && profileImage != null) {
    pushMatrix();
    translate(getPilot("contacts").x, getPilot("contacts").y-100);
    pushMatrix();
    scale(.822);
    scale(96.0/profileImage.height*1.0);

    image(profileImage, 0, 0);
    popMatrix();
    fill(backgroundColor);
    noStroke();
    scale(.7);
    shape(mask, 0, 0);
    popMatrix();
  }


  if (channel == NEWS && articleImage != null) {
    pushMatrix();
    translate(getPilot("news").x, getPilot("news").y-100);
    pushMatrix();
    scale(articleImage.width/mask.width*.765);

    image(articleImage, 0, 0);
    popMatrix();
    fill(backgroundColor);
    noStroke();
    scale(.7);
    shape(mask, 0, 0);
    popMatrix();
  }

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
  float r = 0;

  boolean rotating;

  Pilot(String thisName, String thisShape, int thisCommand) {
    name = thisName;
    icon = loadShape("svg/"+thisShape+".svg");
    icon.disableStyle();
    command = thisCommand;
  }

  void display() {
    pushMatrix();

    noFill();
    noStroke();
    translate(x, y);
    fill(backgroundColor);
    scale(s);
    rectMode(CENTER);
    rect(0, 0, 120, 120);
    stroke(state ? redColor : 255);
    strokeWeight(3);
    shape(app, 0, 0);
    //if (rotating) rotate(millis()/1000.0);
    shape(icon, 0, 0);
    if (label!=null && debug && (channel == command || !android)) {     
      fill(50);
      textAlign(CENTER);
      textFont(font, android ? 20 : 20);
      text(label, 0, 84);
    }
    popMatrix();
  }

  void check() {
    sx = screenX (x, y);
    sy = screenY (x, y);
    if (clicked && dist(sx, sy, mouseX, mouseY) < 50) {
      setChannel(command);
      clicked = false;
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

//Pilot getPilotByCommand(String thisCommand) {
//  for (Pilot pilot : pilots) {
//    if (pilot.command.equals(thisCommand)) {
//      return pilot;
//    }
//  }
//  return null;
//}

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