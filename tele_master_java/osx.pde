import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import processing.serial.*;
import ddf.minim.*;

class Comm {
	PApplet parent;
	Serial port;
	String portNumber;

	boolean usb, bluetooth, connecting, connected, busy;
	String portName = "";
	String targetDeviceAddress = "";
	long lastTx, lastRx;
	int txR;
	int rxR;
	long connectionTime;

	// PLACEHOLDERS
	String deviceAddress, deviceRssi;

	// PROTOCOL IN
	int packetLength = 11;

	// PROTOCOL OUT
	int headerLength = 6;

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

	// MEMORY
	float maxMemory = 0;  
	int freeMemory = 0;

	float tiltAngle = 3;

	// final int BLE_PACKET_LENGHT=18;
	// final int TX_SPEED = 200;

	int txDelay;

	Comm(PApplet _parent) {
		parent = _parent;
	}

	void init() {
		usb = true;
		for (int i=0; i<Serial.list().length; i++) {
			if (Serial.list()[i].indexOf(portNumber) != -1) {
				portName = Serial.list()[i];   
				try {
					port = new Serial(parent, portName, 115200);
					connecting = true;
					connected = true;
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
		if (connected) {
			txR = int(millis() - lastTx);
			lastTx = millis();
			port.write(data);
			if (debug) {
				Packet newPacket = new Packet(false, "", getPilot("bluetooth").x);
			}
		}
	}

	void tx(String str) {
	}

	void rx() {  
		if (port.available() > 13  ) {
			byte[] data = port.readBytesUntil(254);
			rxR = int(millis() - lastRx);
			lastRx = millis();
			if (data != null) {
				parseBytes(data);
				if (debug) {
					Packet newPacket = new Packet(true, "", getPilot("bluetooth").x);
				}
			}
		}
	}

	void writeString(String thisString, int thisMode, int tack, int teck, int tick, int tock, int tuck) {
		// txDelay = 0;

		byte[] data = new byte[thisString.length()+headerLength+1];
		data[0] = (byte)(thisMode+48);
		data[1] = (byte)(tack+48);
		data[2] = (byte)(teck+48);
		data[3] = (byte)(tick+48);
		data[4] = (byte)(tock+48);
		data[5] = (byte)(tuck+48);
		for (int i=0; i < thisString.length(); i++) {  
			data[i+headerLength] = (byte)thisString.charAt(i);
		}
		data [data.length-1] = (byte)'\n';
		tx(data);
		busy = true;
		if (debug) {
			println(thisMode+"|"+tack+"|"+teck+"|"+tick+"|"+tock+"|"+tuck+"|"+thisString);
		}
	}

	void parseBytes(byte[] data) {
		if (data.length == packetLength) {
			mm = data[0];
			ax = data[2]*(data[1] == 1 ? -1 : 1);
			ay = data[4]*(data[3] == 1 ? -1 : 1);
			az = data[6]*(data[5] == 1 ? -1 : 1);
			battery = (data[7]+320.0)/100.0;
			charging = (data[8] == 1);
			brightness = data[9];
			busy = false;
		}
	}
}

/////////////////
// PLACE HOLDERS
/////////////////

// void downloadByteArrayAsImage(String url, String fileName) {
// 	println("downloading file array");
// 	byte[] imageInByte = loadBytes(url);
// 	InputStream in = new ByteArrayInputStream(imageInByte);  
// 	try {
// 		BufferedImage bImageFromConvert = ImageIO.read(in);
// 		ImageIO.write(bImageFromConvert, "png", new File(
// 			sketchPath("data/tmp/"+fileName+".png")));
// 		println("downloaded byte array "+fileName);
// 	} 
// 	catch(Exception e) {
// 		println("error");
// 	}
// }

void updateSensors() {
}

void scanDevices() {
}    

/////////////////
// MIC
/////////////////

class Eq {
	Minim minim;
	AudioInput in;

	char[] eqData;
	float[] eqVal;
	int res = 32;
	String eqStr;

	float maxL = .03;
	float midL = .02;
	float minL = .01;

	float rightL;
	float leftL;
	float eqFilter = .1;

	String str;

	Eq (PApplet parent) {
		minim = new Minim(parent);
		in = minim.getLineIn(minim.STEREO, res);
		eqData = new char[res];
		eqVal = new float[res];
	}

	void update()
	{
		rightL = in.right.level();
		leftL = in.left.level();
		eqStr = "";
		for (int i = 0; i < in.bufferSize(); i++) {
			float targetLevel =  abs(in.left.get(i));
			eqVal[i] += (targetLevel-eqVal[i])*eqFilter;
			if ( eqVal[i] > maxL) {
				eqData[i] = 3;
			} 
			else if ( eqVal[i] > midL &&  eqVal[i] < maxL) {
				eqData[i] = 2;
			} 
			else if ( eqVal[i] >  minL &&  eqVal[i] < midL) {
				eqData[i] = 1;
			} 
			else {
				eqData[i] = 0;
			}
      // line(0, -offset + in.left.get(i)*offset, eqWidth, -offset + in.left.get(i)*offset);
      // translate(eqWidth, 0);
      eqStr += eqData[i];
    }
  }
}
// //    if ( in.isMonitoring() )
// //    {
// //      in.disableMonitoring();
// //    }
// //    else
// //    {
// //      in.enableMonitoring();
// //    }