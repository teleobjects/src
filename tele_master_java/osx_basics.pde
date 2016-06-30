import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import ddf.minim.*;

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

class Keyboard {
	PApplet parent;

	Keyboard(PApplet _parent) {
		parent = _parent;
	}
}

class Bluetooth{
	boolean available;
	PApplet parent;

	Bluetooth(PApplet _parent) {
		parent = _parent;
	}

	void update() {

	}

	void scanDevices() {
	} 
}

class Sensors {
	PApplet parent;

	Sensors(PApplet _parent) {
		parent = _parent;
		init();	
	}

	void init() {
		if (network.externalIP == null) {
			geolocation.latitude = 28.659363; 
			geolocation.longitude = -17.913001;
			geolocation.provider = "fixed";
			geolocation.located = true;
		} 
		else  {
			String url = "http://www.geoplugin.net/json.gp?ip="+network.externalIP;
			String[] geopluginContent = loadUrl(url);
			if (geopluginContent != null) {
				saveStrings("tmp/geolocation.json", geopluginContent);
				String jsonFragment = "";
				for (int i=0; i<geopluginContent.length; i++) {
					jsonFragment += geopluginContent[i];
				}
				processing.data.JSONObject geolocatedData = processing.data.JSONObject.parse(jsonFragment);
				geolocation.latitude = geolocatedData.getFloat("geoplugin_latitude");
				geolocation.longitude = geolocatedData.getFloat("geoplugin_longitude");
				geolocation.provider = "geoplugin";
				geolocation.located = true;
			}			
		}
	}

	void update() {


	}
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
			float targetLevel = abs(in.left.get(i));
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