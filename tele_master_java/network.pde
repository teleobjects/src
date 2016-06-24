import java.net.InetAddress; 
import java.net.UnknownHostException; 

class Network {
  String hostName; 
  String hostIP; 
  String externalIP;

  // String pingUrl = "http://www.google.com";
  String ipFinderUrl = "https://api.ipify.org";

  // STATES
  String wifiState;   
  String onlineState;
  boolean wifi, online, loading;
  int pingTime;
  long pingStart;

  Network () {
    init();
  }

  void init() {
    updateWifi();
    if (wifi) {
      updateOnline();
    } 
    else {
      onlineState ="offline";
      online = false;
    }
  }

  void updateOnline() {
    pingStart = millis();  
    try { 
      String[] ip = loadStrings(ipFinderUrl);
      if (ip != null) {
        pingTime = int(millis() - pingStart);
        externalIP = ip[0];
        onlineState ="online";
        online = true;
      } 
      else {
        onlineState ="offline";
        online = false;
      }
    } 
    catch (Exception e) {
      println(e);
      online = false;
      onlineState ="offline";
    }
  }

  void updateWifi() {
    try { 
      InetAddress addr = InetAddress.getLocalHost(); 
      println(addr);
      byte[] ipAddr = addr.getAddress(); 
      String raw_addr = addr.toString(); 
      String[] list = split(raw_addr, '/'); 
      hostIP = list[1]; 
      hostName = addr.getHostName();
      if (hostIP.indexOf(":") != -1 || hostIP.equals("127.0.0.1")) {
        wifiState = "wifi disabled";
        wifi = false;
      } 
      else {  
        wifiState = "wifi enabled";
        wifi = true;
      }
    } 
    catch (UnknownHostException e) {
      println(e);
    }
  }
}

void deleteFile(String thisFile) {
  String fileName;
  if (android) {
    fileName = sketchPath("data\\tmp\\"+thisFile);
  } 
  else {
    fileName = dataPath("tmp/"+thisFile);
  }
  File f = new File(fileName);
  if (f.exists()) {
    f.delete();
    println("deleted "+thisFile);
  } 
  else {
    println("could not delete "+thisFile);
  }
}

String[] loadLocal(String thisFile) {
  String[] result = loadStrings((android ? "data\\tmp\\" : "data/tmp/") +thisFile);
  if (debug) println("loaded "+thisFile);
  return result;
}

void saveLocal(String thisFile, String[] thisContent) {
  saveStrings((android ? "data\\tmp\\" : "data/tmp/") +thisFile, thisContent);
  if (debug) println("saved "+thisFile);
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
    if (debug) println("saved "+thisFile);
  }

  PImage loadLocalImage(String thisFile) {
    if (debug) { 
      Packet newPacket = new Packet(false, "", getPilot("online").x);
    }
    PImage img = loadImage((android ? "data\\tmp\\" : "data/tmp/")+thisFile);
    if (debug) println("loaded "+thisFile);
    return img;
  }

  String[] loadUrl(String thisUrl) {
    network.loading = true;
    if (debug) { 
      Packet newPacket = new Packet(true, "", getPilot("online").x);
    }
    if (debug) println("loading "+thisUrl);  
    network.pingStart = millis();
    if (network.online) {
      try { 
        String[] content = loadStrings(thisUrl);
        if (content != null) {
          network.pingTime = int(millis() - network.pingStart);
          if (debug) println("loaded url "+network.pingTime+"ms");
          if (debug) {
            Packet newPacket = new Packet(false, "", getPilot("online").x);
          }
          network.loading = false;
          return content;
        }
      } 
      catch (Exception e) {
        if (debug) println(e);
      }
    }
    if (debug) println("error, offline");
    network.loading = false;
    return null;
  }

  String urlThread;
  String[] contentThread;


  void loadUrlThread(String thisUrl) {
    urlThread = thisUrl;
    contentThread = null;
    thread("startLoadUrlThread");
    network.pingStart = millis();
  }

  void updateThread() {
  // if (contentThread != null) {  
  //   println(contentThread);
  // }
}


void startLoadUrlThread() {
  network.loading = true;
  if (debug) { 
    Packet newPacket = new Packet(true, "", getPilot("online").x);
  }
  if (debug) println("loading in thread "+urlThread);  
  if (network.online) {
    try { 
      String[] contentThread = loadStrings(urlThread);
      if (contentThread != null) {
        network.pingTime = int(millis() - network.pingStart);
        if (debug) println("loaded url in thread in "+network.pingTime+"ms");
        if (debug) {
          Packet newPacket = new Packet(false, "", getPilot("online").x);
        }
      }
    } 
    catch (Exception e) {
      if (debug) println(e);
    }
    } else {
      if (debug) println("error, offline");
    }
    network.loading = false;
  }


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