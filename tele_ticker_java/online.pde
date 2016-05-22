ArrayList<String> onlines;
ArrayList<String> wifis;

import java.net.InetAddress; 
import java.net.UnknownHostException; 

String hostName; 
String hostIP; 
String externalIP;

String pingUrl = "http://www.google.com";
String ipFinderUrl = "https://api.ipify.org";
int pingTime;

//String fileName = "weather.json";
//File file = new File(fileName);
//if (file!= null) {
//  weatherUpdated = file.lastModified();
//  //if ((currentTimeStamp - weatherUpdated)/1000 < weatherRefresh || !online) {
//  weatherContent = loadStrings(fileName);
//  //weatherUpdated = currentTimeStamp;
//  println("loading local file "+fileName);
//  //}
//}

String[] loadLocal(String thisFile) {
  String[] result = loadStrings((android ? "data\\tmp\\" : "data/tmp/") +thisFile);
  println("loaded "+thisFile);
  return result;
}

void saveLocal(String thisFile, String[] thisContent) {
  saveStrings((android ? "data\\tmp\\" : "data/tmp/") +thisFile, thisContent);
  println("saved "+thisFile);
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
  println("saved "+thisFile);
}


PImage loadLocalImage(String thisFile) {
  if (debug) { 
    Packet newPacket = new Packet(false, "", getPilot("online").x);
  }
  PImage img = loadImage((android ? "data\\tmp\\" : "data/tmp/")+thisFile);
  println("loaded "+thisFile);
  return img;
}

String[] loadUrl(String thisUrl) {
  loading = true;
  //writeString("", LOADING, 1, 1, 1);
  if (debug) { 
    Packet newPacket = new Packet(false, "", getPilot("online").x);
  }
  println("loading "+thisUrl);  
  long pingStart = millis();
  if (wifi && online) {
    try { 
      String[] content = loadStrings(thisUrl);
      if (content != null) {
        pingTime = int(millis() - pingStart);
        //online = true;
        println("loaded url "+pingTime+"ms");
        if (debug) {
          Packet newPacket = new Packet(true, "", getPilot("online").x);
        }
        return content;
      }
    } 
    catch (Exception e) {
      println(e);
      onlines.add("error, exception");
    }
  }
  println("error, offline");
  return null;
}

void updateOnline() {
  onlines = new ArrayList<String>();
  long pingStart = millis();
  // println(ipFinderUrl);
  // onlineState ="online";
  // online = true;
  
  try { 
    String[] ip = loadStrings(ipFinderUrl);
    if (ip != null) {
      pingTime = int(millis() - pingStart);
      externalIP = ip[0];
      onlines.add(cleanUp("IP "+ip[0]+" PING "+pingTime+"ms"));
      onlineState ="online";
      online = true;
    } else {
      onlines.add("CAN'T CONNECT TO WWW");
      onlineState ="offline";
      online = false;
    }
  } 
  catch (Exception e) {
    println(e);
    online = false;
    onlines.add("EXCEPTION THROWN");
    onlineState ="offline";
  }
}

void initWifi() {
  updateWifi();
}

void updateWifi() {
  wifis = new ArrayList<String>();
  try { 
    InetAddress addr = InetAddress.getLocalHost(); 
    byte[] ipAddr = addr.getAddress(); 
    String raw_addr = addr.toString(); 
    String[] list = split(raw_addr, '/'); 
    hostIP = list[1]; 
    if (hostIP.indexOf(":") != -1) {
      hostName = addr.getHostName();
      hostIP = "OFFLINE";
      wifis.add(cleanUp(hostName+" IS OFFLINE", true));
      wifiState = "wifi disabled";
      wifi = false;
    } else {
      hostName = addr.getHostName();
      wifis.add(cleanUp(hostName+"@"+hostIP, true));
      wifiState = "wifi enabled";
      wifi = true;
    }
  } 
  catch (UnknownHostException e) {
    println(e);
  }
}