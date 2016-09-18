// import java.awt.image.BufferedImage;
// import java.io.ByteArrayInputStream;
// import java.io.ByteArrayOutputStream;
// import java.io.File;
// import java.io.IOException;
// import java.io.InputStream;
// import javax.imageio.ImageIO;
// import ddf.minim.*;

// import ddf.minim.*;
// import ddf.minim.effects.*;

// Minim minim;
// AudioPlayer song;


// class Player{
// 	PApplet parent;

// 	Player(PApplet _parent) {
// 		parent = _parent;
// 		minim = new Minim(parent);
// 		song = minim.loadFile("mp3/"+karaoke.file+".mp3");
// 	}

// 	void play() {
// 		song.play();
// 	}
// }

// /////////////////
// // PLACE HOLDERS
// /////////////////

// // void downloadByteArrayAsImage(String url, String fileName) {
// // 	println("downloading file array");
// // 	byte[] imageInByte = loadBytes(url);
// // 	InputStream in = new ByteArrayInputStream(imageInByte);  
// // 	try {
// // 		BufferedImage bImageFromConvert = ImageIO.read(in);
// // 		ImageIO.write(bImageFromConvert, "png", new File(
// // 			sketchPath("data/tmp/"+fileName+".png")));
// // 		println("downloaded byte array "+fileName);
// // 	} 
// // 	catch(Exception e) {
// // 		println("error");
// // 	}
// // }

// /////////////////
// // GESTURES
// /////////////////

// class Gestures {
// 	PApplet parent;
// 	boolean tapped;
// 	boolean doubleTapped;
// 	boolean flicking;
// 	boolean dragging;
// 	long lastTap;
// 	int debounce = 200;
// 	float startX, startY;

// 	Gestures(PApplet parent_) {
// 		parent = parent_;
// 	}

// 	void update() {
// 		if (dragging) {
// 			stroke(255, 0, 0);
// 			line(startX, startY, mouseX, mouseY);
// 		}
// 	}
// }

// void mousePressed() {
// // println(mouseX+" "+mouseY+" "+keyboard.keyboard);
// if (millis() - gestures.lastTap > gestures.debounce) {
// 	gestures.lastTap = millis();
// 	gestures.tapped = true;
// 	gestures.dragging = true;
// 	gestures.startX = mouseX;
// 	gestures.startY = mouseY;
// }
// }

// void mouseReleased() {
// 	gestures.tapped = false;
// 	gestures.dragging = false;
// }

// void mouseDragged()
// {
// }

// /////////////////
// // KEYBOARD
// /////////////////

// class Keyboard {
// 	PApplet parent;
// 	boolean keyboard;

// 	Keyboard(PApplet _parent) {
// 		parent = _parent;
// 	}

// 	void show() {
// 	}

// 	void hide() {
// 	}

// 	void update() {
// 	}
// }

// void keyPressed() {
// 	if (key == 10) key = 31;
// 	if (activeObject != null) {
// 		activeObject.pages.add(new Page(key+"", TYPE, 0, 0, 0, 0, 1));
// 	}
// }

// class Bluetooth {
// 	boolean available;
// 	PApplet parent;

// 	Bluetooth(PApplet _parent) {
// 		parent = _parent;
// 	}

// 	void update() {
// 	}

// 	void reconnect() {
// 	}
// }

// class Sensors {
// 	PApplet parent;

// 	Sensors(PApplet _parent) {
// 		parent = _parent;
// 		init();
// 	}

// 	void init() {
// 		if (network.externalIP == null) {
//    // geolocation.latitude = 28.659363; 
//    // geolocation.longitude = -17.913001;
//    geolocation.latitude = 40.735;
//    geolocation.longitude = -73.955;
//    //geolocation.latitude = 28.46944; 
//    //geolocation.longitude = - 16.24806;
//    geolocation.provider = "fixed";
//    geolocation.located = true;
// } else {
// 	String url = "http://www.geoplugin.net/json.gp?ip="+network.externalIP;
// 	String[] geopluginContent = loadUrl(url);
// 	if (geopluginContent != null) {
// 		saveStrings("tmp/geolocation.json", geopluginContent);
// 		String jsonFragment = "";
// 		for (int i=0; i<geopluginContent.length; i++) {
// 			jsonFragment += geopluginContent[i];
// 		}
// 		processing.data.JSONObject geolocatedData = processing.data.JSONObject.parse(jsonFragment);
// 		geolocation.latitude = geolocatedData.getFloat("geoplugin_latitude");
// 		geolocation.longitude = geolocatedData.getFloat("geoplugin_longitude");
// 		geolocation.provider = "geoplugin";
// 		geolocation.located = true;
// 	}
// }
// }

// void update() {
// }
// }

// /////////////////
// // MIC
// /////////////////

// class Eq {
// 	Minim minim;
// 	AudioInput in;

// 	char[] eqDataNibble;

// 	char[] eqData;
// 	float[] eqVal;
// 	int res = 32;

// 	float maxL = .05;
// 	float minL = 0;

// 	float rightL;
// 	float leftL;
// 	float eqFilter = .25;

// 	Eq (PApplet parent) {
// 		minim = new Minim(parent);
// 		in = minim.getLineIn(minim.STEREO, res);
// 		eqData = new char[res];
// 		eqVal = new float[res];
// 		eqDataNibble =new char[res/4];
// 	}

// 	void update() {
// 		rightL = in.right.level();
// 		leftL = in.left.level();
// 		for (int i = 0; i < in.bufferSize(); i++) {
// 			float targetLevel = abs(in.left.get(i));
// 			if (targetLevel < maxL / 2) targetLevel += targetLevel/2; 
// 			eqVal[i] += (targetLevel-eqVal[i])*eqFilter;
// 			eqData[i] = char(byte(map(eqVal[i], minL, maxL, 0, 7)));
// 			if (eqData[i] > 7) eqData[i] = 7;
// 			if (eqData[i] < 0) eqData[i] = 0;
// 		}


//  // for (int i=0; i<res/4; i++) {
//  //   int a = int((eqData[(i*4)])/2 << 6);
//  //   int b = int((eqData[(i*4)+1])/2 << 4);
//  //   int c = int((eqData[(i*4)+2])/2 << 2);
//  //   int d = int((eqData[(i*4)+3])/2);
//  //   eqDataNibble[i] = char(255-(a | b | c | d));
//  //   //if (eqDataNibble[i] == '\n') eqDataNibble[i]++;
//  //   //if (eqDataNibble[i] == 0) eqDataNibble[i]++;
//  // }
// }

// void display() {

// }
// }

// // //    if ( in.isMonitoring() )
// // //    {
// // //      in.disableMonitoring();
// // //    }
// // //    else
// // //    {
// // //      in.enableMonitoring();
// // //    }