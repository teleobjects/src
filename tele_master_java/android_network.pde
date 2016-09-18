class Network {
  String hostName; // our host name;
  String hostIP; // our internal ip
  String externalIP; // our external ip
  String ssid; // ssid of connected wifi network 
  String bssid;  // hex id 
  String mac; // mac address
  int rssi;  // signal strength
  int linkSpeed;  //
  int frequency; ///
  String type; // type of active network connection
  String state; // state of current connection
  String reason; // not used
  String extra; // name of wifi network or cellular provider
  boolean roaming; // true if we are roaming
  boolean available; // not used 
  boolean cellular; // true if our connection is through cellular
  boolean wifi; // true if wifi is enabled;
  boolean networked; // true if there is an active connection
  boolean router; // true if we are connected to router
  boolean ip; // true if we have been granted an internal ip;
  boolean connected; // true if we are connected to a network (wifi or cellular)
  boolean online; // true if we are online and can access the www
  boolean loading; // true if loading in another thread;

  int pingTime;
  long pingStart;
  boolean updated;
  long lastUpdated;

  Network () {
    update();
  }

  void update() {
    updated = true;
    lastUpdated = time.currentTimeStamp;

    switch (wifiManager.getWifiState()) {
      case 1: 
      wifi = false;
      break;
      case 3: 
      wifi = true;
      break;
      case 4: 
      wifi = false; 
      break;
      default: 
      wifi = false;
    }
    if (wifi) {
      try { 
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (verbose) println(wifiInfo);
        ssid = removeQuotes(wifiInfo.getSSID());
        bssid = removeQuotes(wifiInfo.getBSSID());
        mac = removeQuotes(wifiInfo.getMacAddress());
        rssi = wifiInfo.getRssi();
        frequency = wifiInfo.getFrequency();
        linkSpeed = wifiInfo.getLinkSpeed();
        router = ssid != null;
        if (router) {
          int ipAddress = wifiInfo.getIpAddress();
          hostIP = String.format("%d.%d.%d.%d", (ipAddress & 0xff), (ipAddress >> 8 & 0xff), (ipAddress >> 16 & 0xff), (ipAddress >> 24 & 0xff));
          ip = !hostIP.equals("0.0.0.0");
        }
      }
      catch (Exception e) {
        if (verbose) println(e);
      }
    } else {
      ssid = null;
      hostIP = null;
      router = false;
    }

    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

    if (networkInfo != null) {
      networked = true;
      String[] networkInfoItems = splitTokens(networkInfo+"", ",");
      type = networkInfoItems[0].substring(7, networkInfoItems[0].length()-2);
      state = networkInfoItems[1].substring(8, networkInfoItems[1].length());
      reason = networkInfoItems[2].substring(9, networkInfoItems[2].length());
      extra = removeQuotes(networkInfoItems[3].substring(8, networkInfoItems[3].length()));
      roaming = networkInfoItems[4].substring(10, networkInfoItems[4].length()).equals("true");
      //failover = networkInfoItems[5].substring(11, networkInfoItems[5].length()).equals("true");
      //available = networkInfoItems[6].substring(14, networkInfoItems[6].length()).equals("true");
      connected = networkInfo.isConnected();
      cellular = networkInfo.getType() == ConnectivityManager.TYPE_MOBILE;
      online = isOnline();
    } else {
      networked = false;  
      type = null;
      state = null;
      reason = null;
      extra = null;
      roaming = false;
      connected = false;
      cellular = false;
      online = false;
    }

    if (online) {
      thread("getExternalIp");
    }
  }

  boolean isOnline() {
    Runtime runtime = Runtime.getRuntime();
    try {
      Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
      pingStart = millis();
      int exitValue = ipProcess.waitFor();
      pingTime = int(millis() - pingStart);
      return (exitValue == 0);
    } 
    catch (IOException e) { 
      e.printStackTrace();
    } 
    catch (InterruptedException e) { 
      e.printStackTrace();
    }
    return false;
  }
}

void getExternalIp() {
  String ipFinderUrl = "http://checkip.amazonaws.com"; // "https://api.ipify.org"; // 
  String[] ip = loadStrings(ipFinderUrl);
  if (ip != null) {
    network.externalIP = ip[0];    
  }
}

//////void ping() {
//////  network.pinging = true;
//////  network.pingStart = millis();
//////  if (debug) { 
//////    Packet newPacket = new Packet(true, "", getPilot("online").x);
//////    newPacket.init();
//////  }
//////  if (debug) println("ping http://www.google.com");  
//////  try { 
//////    String[] contentThread = loadStrings("http://www.google.com");
////    if (contentThread != null) {
////      network.pingTime = int(millis() - network.pingStart);
////      if (debug) {
////        if (verbose) println("ping google in "+network.pingTime+"ms");
////        Packet newPacket = new Packet(false, "", getPilot("online").x);
////        newPacket.init();
////        //network.online = true;
////      }
////    } else {
////      if (verbose) println("unable to reach google");
////      network.online = false;
////    }
////  } 
////  catch (Exception e) {
////    if (debug) println(e);
////    //network.online = false;
////    if (verbose) println("unable to reach google");
////  }
////  network.pinging = false;
////}