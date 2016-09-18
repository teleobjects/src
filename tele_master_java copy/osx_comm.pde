 import processing.serial.*;

 class Comm {
 	PApplet parent;
 	Serial port;
 	String portNumber;
 	boolean connecting, connected, found, paired, discovering, discovered, acknowledged, busy;
 	boolean parsed;
 	String portName = "";
 	String targetDeviceAddress = "";
 	long lastTx, lastRx;
 	int txR;
 	int rxR;
 	long connectionTime;
 	Teleobject teleobject;

	// PLACEHOLDERS
	String deviceAddress, deviceRssi;

	// PROTOCOL IN
	int packetLength = 15;

	// PROTOCOL OUT
	int headerLength = 7;

	// SENSOR
	float sens = .5;
	float ax, ay, az;
	boolean shock;
	int mm;
	float battery = 0;
	boolean charging = false;

	int minBat = 320;
	int maxBat = 425;

	int brightness = 1;
	int temperature = 0;
	int pressure = 0;
	int humidity = 0;
	// MEMORY
	float maxMemory = 0;  
	int freeMemory = 0;

	float tiltAngle = 3;

	// final int BLE_PACKET_LENGHT=18;
	// final int TX_SPEED = 200;
	int timeOuts = 0;
	int txDelay;

	Comm(PApplet _parent, Teleobject _teleobject) {
		parent = _parent;
		teleobject = _teleobject;
	}

	void init() {
		for (int i=0; i<Serial.list().length; i++) {
			if (Serial.list()[i].indexOf(portNumber) != -1) {
				portName = Serial.list()[i];   
				try {
					port = new Serial(parent, portName, 115200);
					connecting = true;
					connected = true;
					discovered = true;
					acknowledged = true;
					connectionTime = millis();
					println("connected to "+portName);
					break;
				} 
				catch (Exception e) {
					println("could not connect to "+portName);
				}
			}
		}
	}

	void update() {
		if (connected) {
			rx();
		}
	}

	void terminate() {
		port = null;
		connected = false;
	}

	void tx(byte[] data) {  
		txR = int(millis() - lastTx);
		lastTx = millis();
		port.write(data);
		if (debug) {
			Packet newPacket = new Packet(false, "", getPilot("bluetooth").x);
		}
	}

	void tx(String str) {
	}

	void rx() {  
		if (port.available() == packetLength) {
			byte[] data = port.readBytesUntil(254);
			rxR = int(millis() - lastRx);
			lastRx = millis();
			if (data != null && data[0] == '>' && data.length >= packetLength) {
				acknowledged = true;
				parseBytes(data);			
			}
			// port.clear();
		}
	}

	void writeString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
		if (connected) {
			byte[] data = new byte[thisString.length()+headerLength+1];
			data[0] = '>';
			data[1] = (byte)(thisMode+48);
			data[2] = (byte)(tack+48);
			data[3] = (byte)(teck+48);
			data[4] = (byte)(tick+48);
			data[5] = (byte)(tock+48);
			data[6] = (byte)(tuck+48);
			for (int i=0; i < thisString.length(); i++) {  
				data[i+headerLength] = (byte)thisString.charAt(i);
			}
			data [data.length-1] = (byte)'\n';
			tx(data);
			busy = true;
		}
	}

	void parseBytes(byte[] data) {	
		if (debug) {
			Packet newPacket = new Packet(true, "", getPilot("bluetooth").x);
			newPacket.init();
		}
		mm = data[1];
		ax = int(data[3])*(data[2] == 1 ? -1 : 1);
		ay = int(data[5])*(data[4] == 1 ? -1 : 1);
		az = int(data[7])*(data[6] == 1 ? -1 : 1);
		battery = (data[8]+320.0)/100.0;
		charging = (data[9] == 1);
		brightness = data[10];
		pressure = data[11]+1000;
		temperature = data[12]-50;
		humidity = data[13];
		busy = false;
		parsed = true;	
	}
}