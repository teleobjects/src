import processing.serial.*;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

Serial port;

void initComm() {
  beginComm();
  updateWifi();
  if (!forceoffline) {
    updateOnline();
  } else {
    online = false;
    onlineState = "offline";
  }
}

void beginComm() {
  usb = true;
  for (int i=0; i<Serial.list().length; i++) {
    if (Serial.list()[i].indexOf(usb ? "1441" : "teleobject") != -1) {
      portName = Serial.list()[i];   
      println("connecting to "+portName);
      try {
        port = new Serial(this, portName, 115200);
        connecting = true;
        connected = true;
        println("connected to "+portName);
        break;
      } 
      catch (Exception e) {
        println("could not connect to "+portName);
      }
    }
  }
}

void updateComm() {
  if (connected) {
    rx();
  }
}

void terminateComm() {
  port = null;
  connected = false;
}

void tx(byte[] data) {
  if (connected) {
    txR = int(millis() - lastTx);
    lastTx = millis();
    port.write(data);
    if (debug) {
     Packet newPacket = new Packet(false, "", getPilot(usb ? "usb" : "bluetooth").x);
   }
 }
}

void rx() {
  if (connected) {
    if (port.available() > 13  ) {
      byte[] data = port.readBytesUntil(254);
      rxR = int(millis() - lastRx);
      lastRx = millis();
      if (data != null) {
        parseBytes(data);
        if (debug) {
          Packet newPacket = new Packet(true, "", getPilot(usb ? "usb" : "bluetooth").x);
        }
      }
    }
  }
}

/////////////////
// PLACE HOLDERS
/////////////////

void downloadByteArrayAsImage(String url, String fileName) {
  byte[] imageInByte = loadBytes(url);
  InputStream in = new ByteArrayInputStream(imageInByte);  
  try {
    BufferedImage bImageFromConvert = ImageIO.read(in);
    ImageIO.write(bImageFromConvert, "png", new File(
      sketchPath("data/tmp/"+fileName+".png")));
    println("downloaded byte array "+fileName);
  } 
  catch(Exception e) {
    println("error");
  }
}

int location = -1;// = null;

void tx(String str) {
}

void connectBluetooth() {
}

void updateBluetooth() {
}


/////////////////
// MIC
/////////////////

import ddf.minim.*;

class Eq {
 Minim minim;
 AudioInput in;

 char[] eqData;
 float[]eqVal;
 int res= 32;

 float maxL = .03;
 float midL = .01;
 float minL = midL/2;

 float rightL;
 float leftL;
 float eqFilter = .2;

 Eq (PApplet parent) {
   minim = new Minim(parent);
   in = minim.getLineIn(minim.STEREO, res);
   eqData = new char[res];
   eqVal = new float[res];
 }

 boolean softEq = false;

 void update()
 {
   rightL = in.right.level();
   leftL = in.left.level();
   if (channel == EQ ) {
     // pushMatrix();
     // stroke(redColor);
     // strokeWeight(2);
     // translate(0, height);
     // pushMatrix();
     // scale(width/res, 1);
     float offset = 100;
     // popMatrix();
     float eqWidth = width*1.0/(res-1);
     for (int i = 0; i < in.bufferSize(); i++) {
       float targetLevel =  abs(in.left.get(i));
       eqVal[i] = eqVal[i]+(targetLevel-eqVal[i])*eqFilter;
       if ( eqVal[i] > maxL) {
         eqData[i] =EQ_HIGH;
       } else if ( eqVal[i] > midL &&  eqVal[i] < maxL) {
         eqData[i] =EQ_MID;
       } else if ( eqVal[i] >  minL &&  eqVal[i] < midL) {
         eqData[i] =EQ_LOW;
       } else {
         eqData[i] =EQ_OFF;
       }
       // line(0, -offset + in.left.get(i)*offset, eqWidth, -offset + in.left.get(i)*offset);
       // translate(eqWidth, 0);
     }
     // popMatrix();
   }
 }
}
//    if ( in.isMonitoring() )
//    {
//      in.disableMonitoring();
//    }
//    else
//    {
//      in.enableMonitoring();
//    }