void deleteFile(String thisFileName) {
  String fileName;
  if (android) {
    fileName = sketchPath("data\\tmp\\"+thisFileName);
  } else {
    fileName = sketchPath("data/tmp/"+thisFileName);
  }
  File f = new File(fileName);
  if (f.exists()) {
    f.delete();
    println("deleted "+thisFileName);
  } else {
    println("could not delete "+thisFileName);
  }
}

// String[] loadLocal(String thisFile) {
//   String[] result = loadStrings((android ? "data\\tmp\\" : "data/tmp/") +thisFile);
//   if (debug) println("loaded "+thisFile);
//   return result;
// }

void saveLocal(String thisFile, String[] thisContent) {
  saveStrings((android ? "data\\tmp\\" : "data/tmp/") +thisFile, thisContent);
  if (verbose) println("saved "+thisFile);
}

void saveLocal(String thisFile, PImage img) {
  if (img != null) {
    PImage tmp = createImage(img.width, img.height, RGB);
    tmp = img.get();
    if (android) {
      tmp.save(savePath(sketchPath("data\\tmp\\"+thisFile)));
    } else {
      tmp.save(savePath(sketchPath("data/tmp/"+thisFile)));
    }
  }
  if (verbose) println("saved "+thisFile);
}

PImage loadLocalImage(String thisFile) {
  if (debug) { 
    Packet newPacket = new Packet(false, "", getPilot("online").x);
    newPacket.init();
  }
  PImage img = loadImage((android ? "data\\tmp\\" : "data/tmp/")+thisFile);
  if (verbose) println("loaded "+thisFile);
  return img;
}

String[] loadUrl(String thisUrl) {
  network.loading = true;
  if (debug) { 
    Packet newPacket = new Packet(true, "", getPilot("online").x);
    newPacket.init();
  }
  if (verbose) println("loading "+thisUrl);  
  network.pingStart = millis();
  if (network.online) {
    try { 
      String[] content = loadStrings(thisUrl);
      if (content != null) {
        network.pingTime = int(millis() - network.pingStart);
        if (verbose) println("loaded url "+network.pingTime+"ms");
        if (debug) {
          Packet newPacket = new Packet(false, "", getPilot("online").x);
          newPacket.init();
        }
        //network.updated = false;
        return content;
      }
    } 
    catch (Exception e) {
      if (verbose) println(e);
    }
  }
  if (verbose) println("error, offline");
  //network.updated = false;
  network.loading = false;
  return null;
}

long getFileTimeStamp(String thisFolder, String thisFileName) {
  String fileName;
  if (android) {
    fileName = dataPath("tmp\\"+thisFileName);
  } else {
    fileName = sketchPath("data/tmp/"+thisFileName);
  }
  File file = new File(fileName);
  if (file.exists()) {  
    long lastUpdated = file.lastModified();
    if (verbose) println("getting time stamp "+fileName);
    return lastUpdated;
  } else {
    if (verbose) println("could not get time stamp "+fileName);
    return 0;
  }
}

String getEasyTimeStamp(long thisTime) {
  float dif = int((time.currentTimeStamp - thisTime) / 1000);
  float secondsPerMinute = 60;  
  float secondsPerHour = secondsPerMinute * 60;
  float secondsPerDay = secondsPerHour * 24;
  float days = dif / secondsPerDay;
  float hours = (days - (int)days) * secondsPerDay / secondsPerHour;
  float minutes = (hours - (int)hours) * secondsPerHour / secondsPerMinute;
  float seconds = (minutes - (int)minutes) * secondsPerMinute;
  return (int)days+"d "+(int)hours+"h "+(int)minutes+"m "+(int)seconds+"s ago";
}