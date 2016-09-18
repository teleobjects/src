void deleteFile(String thisFileName) {
  String fileName = "";
  if (androidMode) {
    //fileName = sketchPath("data\\tmp\\"+thisFileName);
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

// String getSdFilePath(String relativeFilename) {
//   File externalDir = Environment.getExternalStorageDirectory();
//   if (externalDir == null ) {
//     return null;
//   }
//   String sketchName= this.getClass().getSimpleName();
//   File sketchSdDir = new File(externalDir, sketchName);
//   File finalDir =  new File(sketchSdDir, relativeFilename);
//   return finalDir.getAbsolutePath();
// }

String[] loadLocal(String thisFile) {
  String[] result = {};
  if (androidMode) {
    // String dataFile = getSdFilePath("strings.txt");
    // if ( dataFile == null ) {
    //   if (verbose) println("no SD CARD found");
    //   return null;
    // } else {
    //   loadStrings(dataFile);
    //   if (verbose) println("loaded "+dataFile);
    // }
  } else {
    result = loadStrings("data/tmp/"+thisFile);
    if (verbose) println("loaded "+thisFile);
  }
  return result;
}

void saveLocal(String thisFile, String[] thisContent) {
  if (androidMode) {
    //     String dataFile = getSdFilePath("strings.txt");
    //   if ( dataFile == null ) {
    //     if (verbose) println("no SD CARD found");
    // } else {
    //     saveStrings(dataFile, thisContent);
    //     if (verbose) println("saved "+dataFile);
    //   }
  } else {
    saveStrings("data/tmp/"+thisFile, thisContent);
    if (verbose) println("saved "+thisFile);
  }
}

void saveLocal(String thisFile, PImage img) {
  if (img != null) {
    PImage tmp = createImage(img.width, img.height, RGB);
    tmp = img.get();
    if (androidMode) {
      tmp.save(savePath(sketchPath("data\\tmp\\"+thisFile)));
    } else {
      tmp.save(savePath(sketchPath("data/tmp/"+thisFile)));
    }
  }
  if (verbose) println("saved "+thisFile);
}

PImage loadLocalImage(String thisFile) {
  return loadLocalImage(thisFile, "tmp");
}

PImage loadLocalImage(String thisFile, String thisFolder) {
  if (debug) { 
    Packet newPacket = new Packet(false, "", getPilot("online").x);
    newPacket.init();
  }
  String filePath = "";
  filePath = (androidMode ? "data\\"+thisFolder+"\\" : "data/"+thisFolder+"/")+thisFile;
  PImage img = loadImage(filePath);
  if (verbose) println("loaded "+thisFile);
  return img;
}

String[] loadUrl(String thisUrl) {
  network.loading = true;
  if (debug) { 
    Packet newPacket = new Packet(true, "", getPilot("online").x);
    newPacket.init();
  }
  if (verbose) println("loading url "+thisUrl);  
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
  if (androidMode) {
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
  if (thisTime == 0) return "never";
  float dif = int((time.currentTimeStamp - thisTime) / 1000);
  float secondsPerMinute = 60;  
  float secondsPerHour = secondsPerMinute * 60;
  float secondsPerDay = secondsPerHour * 24;
  float days = dif / secondsPerDay;
  float hours = (days - (int)days) * secondsPerDay / secondsPerHour;
  float minutes = (hours - (int)hours) * secondsPerHour / secondsPerMinute;
  float seconds = (minutes - (int)minutes) * secondsPerMinute;
  return ((int)days > 0 ? (int)days+"d " : "") + ((int)hours > 0 ? (int)hours+"h " : "") + ((int)minutes > 0 ? (int)minutes+"m " : "") +(int)seconds+"s ago";
}