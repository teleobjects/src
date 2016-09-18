 // class Network {
 // 	String hostName; 
 // 	String hostIP; 
 // 	String externalIP;

 // 	String ipFinderUrl = "https://api.ipify.org";

 // 	String type;
 // 	String state;
 // 	String reason;
 // 	String extra;
 // 	String ssid;
 // 	boolean roaming;
 // 	boolean available;
 // 	boolean networked;
 // 	boolean router;
 // 	boolean wifi;
 // 	boolean online;
 // 	boolean pinging;

 // 	boolean ip;
 // 	boolean cellular;

 // 	boolean loading;
 // 	String connectionTime;

 // 	int pingTime;
 // 	long pingStart;
 // 	String mac = "";
 // 	int rssi = 0;
 // 	int linkSpeed = 0;
 // 	int frequency = 0;

 // 	Network () {
 // 		update();
 // 	}

 // 	void update() {
 // 		try { 
 // 			InetAddress addr = InetAddress.getLocalHost(); 
 // 			//byte[] ipAddr = addr.getAddress(); 
 // 			String raw_addr = addr.toString(); 
 // 			String[] list = split(raw_addr, '/'); 
 // 			hostIP = list[1]; 
 // 			hostName = addr.getHostName();
 // 			if (hostIP.indexOf(":") != -1 || hostIP.contains("127.0.0.1")) {
 // 				ip = false;
 // 				wifi = false;
 // 				router = false;
 // 				networked = false;
 // 			} 
 // 			else {
 // 				ip = true;
 // 				wifi = true;
 // 				router = true;
 // 				networked = true;
 // 				type = "WIFI";
 // 			}
 // 		} 
 // 		catch (UnknownHostException e) {
 // 			if (verbose) println(e);
 // 		}

 // 		if (!pinging) {
 // 			thread("ping");
 // 		}
 // 	}

 // 	void getExternalIP() {
 // 		String[] ip = loadStrings(ipFinderUrl);
 // 		if (ip != null) {
 // 			pingTime = int(millis() - pingStart);
 // 			externalIP = ip[0];
 // 		}
 // 	}
 // }

 // void ping() {
 // 	network.pinging = true;
 // 	network.pingStart = millis();
 // 	if (verbose) println("ping http://www.google.com");  
 // 	try { 
 // 		String[] contentThread = loadStrings("http://www.google.com");
 // 		if (contentThread != null) {
 // 			network.pingTime = int(millis() - network.pingStart);
 // 			if (debug) {
 // 				if (verbose) println("ping google in "+network.pingTime+"ms");
 // 				network.online = true;
 // 			}
 // 		} 
 // 		else {
 // 			if (verbose) println("unable to reach google");
 // 			network.online = false;
 // 		}
 // 	} 
 // 	catch (Exception e) {
 // 		if (verbose) println(e);
 // 		network.online = false;
 // 		if (verbose) println("unable to reach google");
 // 	}
 // 	network.pinging = false;
 // 	if (network.online) thread("getExternalIp");
 // }

 // void getExternalIp() {
 // 	String ipFinderUrl = "http://checkip.amazonaws.com"; // "https://api.ipify.org"; // 
 // 	String[] ip = loadStrings(ipFinderUrl);
 // 	if (ip != null) {
 // 		network.externalIP = ip[0];
 // 	}
 // }