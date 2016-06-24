import hypermedia.net.*;

UDP udpManager;  
String ip       = "192.168.0.7";	
int udpPort        = 2390;


void beginUdp() {
	udpManager = new UDP( this, 6000 );
	// udpManager.log( true ); 		
	udpManager.listen( true );
}

void receive( byte[] data, String ip, int port ) {	// <-- extended handler
	// data = subset(data, 0, data.length);
	String message = new String( data );
	// println( "receive: \""+message+"\" from "+ip+" on port "+port +" of length "+message.length());
	parseBytes(data);
	if (debug) {
		Packet newPacket = new Packet(true, "", getPilot("wifi").x);
	}
}

void transmit(String str) {
	if (udp) {
		udpManager.send( str, ip, udpPort );
		if (debug) {
			Packet newPacket = new Packet(false, "", getPilot("wifi").x);
		}
	}
}