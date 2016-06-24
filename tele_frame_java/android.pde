import ketai.sensors.*;
import ketai.camera.*;

KetaiSensor sensor;
KetaiCamera cam;
//import android.content.Context;

long lastCam;
int camDelay = 100;

int w = 360;
int h = 360;

//PImage camImage;


void initSensors() {
  sensor = new KetaiSensor(this);
  sensor.start();
  cam = new KetaiCamera(this, w, h, 24);
  cam.setCameraID(1);
}

void displayCam() {
  //filter(grayscale);
  pushMatrix();
  //tint(255,0,0);
  rotate(PI/2);
  scale(1.1);
  cam.filter(GRAY);

  image(cam, 0, 0);
  popMatrix();
}

void updateCam() {
  if (display.mode == CAM) {
    if (millis() - lastCam > camDelay) {
      lastCam = millis();
      if (cam != null) {
        if (!cam.isStarted()) {
          cam.start();
        }
      }
      //pushMatrix();
      //image(cam, 850, 0, w, h);
      //cam.loadPixels();
      //camImage.loadPixels(); 
      //for (int x = 0; x < cam.width; x++) {
      // for (int y = 0; y < cam.height; y++ ) {
      //   int loc = x + y*cam.width;
      //   int destloc = camImage.pixels.length-1-(y + x*camImage.width);
      //   camImage.pixels[destloc]  = cam.pixels[loc];
      // }
      //}
      //camImage.updatePixels();
      //scale(height*1.0/destimg.height*1.0);
      //image(cam, 0, 0, h, w);
    }
  } else {
    if (cam.isStarted()) {
      cam.stop();
    }
  }
}

void onCameraPreviewEvent()
{
  if (display.mode == CAM) {
    cam.read();
  }
}

void onAccelerometerEvent(float x, float y, float z)
{
  //println(x +" "+y+" "+z);
  accelerometerX = x;
  accelerometerY = y;
  accelerometerZ = z;
}