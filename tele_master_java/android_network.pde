// class Network {
//   NetworkInfo networkInfo;
//   List<ScanResult> networks;

//   String hostName; 
//   String hostIP; 
//   String externalIP;
//   String ipFinderUrl = "https://api.ipify.org";

//   String type;
//   String state;
//   String reason;
//   String extra;
//   boolean roaming;
//   boolean available;
//   boolean networked, router, wifi, online, pinging, loading;

//   int pingTime;
//   long pingStart;

//   boolean updated;
//   long lastUpdated;

//   Network () {
//     update();
//   }

//   void update() {
//     //if (!updated) {
//     //  updated = true;
//     lastUpdated = time.currentTimeStamp;
//     switch (wifiManager.getWifiState()) {
//     case 1: 
//       wifi = false;
//       break;
//     case 3: 
//       wifi = true;
//       break;
//     case 4: 
//       wifi = false; 
//       break;
//     default: 
//       wifi = false;
//     }
//     if (wifi) {
//       try { 
//         InetAddress addr = InetAddress.getLocalHost(); 
//         //byte[] ipAddr = addr.getAddress(); 
//         String raw_addr = addr.toString(); 
//         String[] list = split(raw_addr, '/'); 
//         hostIP = list[1]; 
//         hostName = addr.getHostName();
//         if (hostIP.indexOf(":") != -1 || hostIP.contains("127.0.0.1")) {
//           router = false;
//         } else {  
//           router = true;
//         }
//       } 
//       catch (UnknownHostException e) {
//         println(e);
//       }
//     }
//     networkInfo = connectivityManager.getActiveNetworkInfo();
//     if (networkInfo != null) {
//       networked = false;
//       String[] networkInfoItems = splitTokens(networkInfo+"", ",");
//       type = networkInfoItems[0].substring(7, networkInfoItems[0].length());
//       state = networkInfoItems[1].substring(7, networkInfoItems[1].length());
//       reason = networkInfoItems[2].substring(9, networkInfoItems[2].length());
//       extra = removeQuotes(networkInfoItems[3].substring(8, networkInfoItems[3].length()));
//       roaming = networkInfoItems[4].substring(10, networkInfoItems[4].length()).equals("true");
//       //failover = networkInfoItems[5].substring(11, networkInfoItems[5].length()).equals("true");
//       available = networkInfoItems[6].substring(14, networkInfoItems[6].length()).equals("true");
//       //connected = networkInfoItems[7].substring(networkInfoItems[7].length()-6, networkInfoItems[7].length()-1);
//     } else {
//       networked = false;  
//       type = "no network";
//       state = "no state";
//       reason = "no reason";
//       extra = "no provider";
//       roaming = false;
//       available = false;
//       online = false;
//     }
//     if (networkInfo != null) {
//       if (!online && !pinging) {
//         thread("ping");
//       }
//     } else {
//       online = false;
//     }
//   }
//   //}

//   void getExternalIP() {
//     String[] ip = loadStrings(ipFinderUrl);
//     if (ip != null) {
//       pingTime = int(millis() - pingStart);
//       externalIP = ip[0];
//     }
//   }
// }

// void ping() {
//   network.pinging = true;
//   network.pingStart = millis();
//   if (debug) { 
//     Packet newPacket = new Packet(true, "", getPilot("online").x);
//     newPacket.init();
//   }
//   if (debug) println("ping http://www.google.com");  
//   try { 
//     String[] contentThread = loadStrings("http://www.google.com");
//     if (contentThread != null) {
//       network.pingTime = int(millis() - network.pingStart);
//       if (debug) {
//         if (verbose) println("ping google in "+network.pingTime+"ms");
//         Packet newPacket = new Packet(false, "", getPilot("online").x);
//         newPacket.init();
//         network.online = true;
//       }
//     } else {
//       if (verbose) println("unable to reach google");
//       network.online = false;
//     }
//   } 
//   catch (Exception e) {
//     if (debug) println(e);
//     network.online = false;
//     if (verbose) println("unable to reach google");
//   }
//   network.pinging = false;
// }