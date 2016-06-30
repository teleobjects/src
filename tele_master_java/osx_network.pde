class Network {
	String hostName; 
	String hostIP; 
	String externalIP;

	String ipFinderUrl = "https://api.ipify.org";

	String type;
	String state;
	String reason;
	String extra;
	boolean roaming;
	boolean available;
	boolean networked, router, wifi, online, pinging, loading;

	String connectionTime;

	int pingTime;
	long pingStart;

	Network () {
		update();
	}

	void update() {
		try { 
			InetAddress addr = InetAddress.getLocalHost(); 
			byte[] ipAddr = addr.getAddress(); 
			String raw_addr = addr.toString(); 
			String[] list = split(raw_addr, '/'); 
			hostIP = list[1]; 
			hostName = addr.getHostName();
			if (hostIP.indexOf(":") != -1 || hostIP.contains("127.0.0.1")) {
				wifi = false;
				router = false;
				networked = false;
			} 
			else {
				wifi = true;
				router = true;
				networked = true;
			}
		} 
		catch (UnknownHostException e) {
			if (verbose) println(e);
		}
		if (!online && !pinging) {
			thread("ping");
		}
	}

	void getExternalIP() {
		String[] ip = loadStrings(ipFinderUrl);
		if (ip != null) {
			pingTime = int(millis() - pingStart);
			externalIP = ip[0];
		}
	}
}

void ping() {
	network.pinging = true;
	network.pingStart = millis();
	if (debug) { 
		Packet newPacket = new Packet(true, "", getPilot("online").x);
		newPacket.init();
	}
	if (verbose) println("ping http://www.google.com");  
	try { 
		String[] contentThread = loadStrings("http://www.google.com");
		if (contentThread != null) {
			network.pingTime = int(millis() - network.pingStart);
			if (debug) {
				if (verbose) println("ping google in "+network.pingTime+"ms");
				Packet newPacket = new Packet(false, "", getPilot("online").x);
				newPacket.init();
				network.online = true;
			}
			} else {
				if (verbose) println("unable to reach google");
				network.online = false;
			}
		} 
		catch (Exception e) {
			if (verbose) println(e);
			network.online = false;
			if (verbose) println("unable to reach google");
		}
		network.pinging = false;
	}