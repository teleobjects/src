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

String[] loadUrl(String thisUrl) {
  loading = true;
  // writeString("", LOADING, 1, 1, 1);
  println(thisUrl);
  if (!wifi) updateWifi();
  long pingStart = millis();
  if (wifi) {
    String[] content = loadStrings(thisUrl);
    if (content != null) {
      pingTime = int(millis() - pingStart);
      online = true;
      println("ok "+pingTime+"ms");
      return content;
    }
  }
  println("error");
  return null;
}

void initOnline() {
  updateOnline();
}

void updateOnline() {
  onlines = new ArrayList();
  long pingStart = millis();
  println(ipFinderUrl);
  try { 
    String[] ip = loadUrl(ipFinderUrl);
    if (ip != null) {
      online = true;
      pingTime = int(millis() - pingStart);
      externalIP = ip[0];
      onlines.add(cleanUp("IP "+ip[0]+" PING "+pingTime+"ms"));
    } else {
      onlines.add("CAN'T CONNECT TO WWW");
      online = false;
    }
  } 
  catch (Exception e) {
    println(e);
    online = false;
    onlines.add("EXCEPTION THROWN");
  }
}

void initWifi() {
  updateWifi();
}

void updateWifi() {
  wifis = new ArrayList();
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
      wifi = false;
      online = false;
    } else {
      hostName = addr.getHostName();
      wifis.add(cleanUp(hostName+"@"+hostIP, true));
      wifi = true;
    }
  } 
  catch (UnknownHostException e) {
    println(e);
  }
}