PImage[] mapImage;
float[] mapImageZ = {.25, .5, 1};
PShape marker;
PGraphics mapCanvas;
boolean mapStatus;
boolean mapZoom;
float mapX, mapY, mapZ;
float mapNext;
float mapA;
float scope = 50;
long mapStart;
float mapTx, mapTy;
float mapScaleY;

float[] markerX = {70, 46, -85, -125, -35, 25, 60, -70, -80, -60};
float[] markerY = {0, -18, 70, 30, 20, 50, 60, 30, -30, -50, -150};

boolean mapKill;
boolean mapSound;

void initMap() {
  marker= loadShape("svg/location_.svg");
  marker.disableStyle();
  map = loadShape("svg/map.svg");
  map.disableStyle();
  map_ = loadShape("svg/map_.svg");
  map_.disableStyle();
  map_mask = loadShape("svg/map_mask.svg");
  map_mask.disableStyle();
  mapImage = new PImage[3];
  mapImage[2] = loadImage("maps/nyc_16x9_2.png");
  mapImage[1] = loadImage("maps/nyc_16x9_1.png");
  mapImage[0] = loadImage("maps/nyc_16x9_0.png");
  mapCanvas =  createGraphics(1600, 900);
  mapCanvas.beginDraw();
  mapCanvas.shapeMode(CORNER);
  mapCanvas.imageMode(CENTER);
  mapCanvas.endDraw();
  mapTx = 0;
  mapTy = 10000;
  //mapScaleY = 1;
}

void mapOn() {
  mapKill = false;

  mapScaleY = 1;
  mapA = 0;
  mapStatus = true;
  mapStart = millis();
  mapZoom = false;
  mapSound = false;
}

void mapOff() {
  //Ani.to(this, .5, "mapA", 0.01, Ani.SINE_IN_OUT);
  mapKill = false;
  mapStatus = false;
}

void drawMap(float thisX, float thisY) {
  if (activeScene == 3 && !mapStatus) {
    mapOn();
  }
  if (activeScene != 3 && mapStatus && !mapKill) {
    mapKill = true;
  }
  long mapEllapsed = millis() - mapStart;
  mapTx += .0025;
  mapTy += .0025;
  if (mapStatus) {
    if (mapEllapsed > 2000 && mapA == 0) {
      if (!muted) {
        ready.rewind();
        ready.play();
      }
      Ani.to(this, 3, "mapA", 1, Ani.SINE_IN_OUT);
    }
    if (mapEllapsed < 6500) {
      mapZ = 1.7 + sin(mapEllapsed/1000.0)/4;
      mapX = map(noise(mapTx), 100, 1, -scope, scope);
      mapY = map(noise(mapTy), 100, 1, -scope, scope);
    }
    if (mapEllapsed > 6500 && mapZoom == false) {
      mapZoom = true;
      Ani.to(this, 3.5, "mapX", -46, Ani.SINE_IN_OUT);
      Ani.to(this, 3.5, "mapY", 18, Ani.SINE_IN_OUT);
      Ani.to(this, 3.5, "mapZ", 20, Ani.SINE_IN_OUT);
      if (!muted) {
        zoomin.rewind();
        zoomin.play();
      }
    }
    if (mapEllapsed > 11500 && mapScaleY == 1) {
      Ani.to(this, .3, "mapScaleY", 0, Ani.SINE_OUT);
      if (!muted) {
        offff.rewind();
        offff.play();
      }
    }
    if (mapKill && mapEllapsed > 12000) {
      mapOff();
    }
  }
  pushMatrix();
  translate(thisX, thisY);
  noStroke();
  fill(255);
  shape(map_, -map.width/2, -map.height/2);
  pushMatrix();
  iso();
  rotateX(radians(-90));
  scale(.115);
  translate(-45, 80);
  if (mapStatus || mapKill) {
    if (mapA > 0) {
      mapCanvas.beginDraw();
      mapCanvas.translate(mapCanvas.width/2, mapCanvas.height/2);
      mapCanvas.scale(mapZ);
      mapCanvas.translate(mapX, mapY);
      mapCanvas.background(255);
      mapCanvas.tint(255, 200);
      if (mapZ < 3) {
        mapCanvas.image(mapImage[2], 0, 0);
      } 
      if (mapZ >= 3 && mapZ <= 9) {
        mapCanvas.pushMatrix();
        mapCanvas.scale(mapImageZ[1]);
        mapCanvas.image(mapImage[1], 0, 0);
        mapCanvas.popMatrix();
      }
      if (mapZ > 9) {
        mapCanvas.pushMatrix();
        mapCanvas.scale(mapImageZ[0]);
        mapCanvas.image(mapImage[0], 0, 0);
        mapCanvas.popMatrix();
      }
      mapCanvas.noStroke();
      mapCanvas.scale(1.0/mapZ);
      for (int i=0; i<markerX.length; i++) {
        mapCanvas.pushMatrix();
        mapCanvas.ellipseMode(CENTER);
        mapCanvas.translate(markerX[i]*mapZ, markerY[i]*mapZ);
        mapCanvas.scale(1);
        mapCanvas.fill(redColor);
        mapCanvas.shape(marker, -100, -100);
        mapCanvas.fill(255);
        mapCanvas.popMatrix();
      }
      if (mapEllapsed > 9000) {
        if (!mapSound && !muted) {
          mapSound = true;
          pattern.rewind();
          pattern.play();
        }

        float angle = PI/2+millis()/5000.0;
        float offset = 2*PI/satNum;
        float radius = 100;

        for (int i=0; i < satNum; i++) {

          if (mapEllapsed > 9000+(i*200)) {
            mapCanvas.pushMatrix(); 
            float x = markerX[1]*mapZ+cos(angle+offset*i)*radius*1.7;
            float y = markerY[1]*mapZ+sin(angle+satOffset*i)*radius*1.7;
            mapCanvas.translate(x, y);
            mapCanvas.fill(255);
            mapCanvas.ellipse(0, 0, 90, 90);
            mapCanvas.fill(redColor);
            mapCanvas.scale(.6);
            mapCanvas.shape(satellites[i].shp, 0, 0);
            //satellites[i].draw();
            mapCanvas.popMatrix();
          }
        }
      }
      mapCanvas.endDraw();
    }
    pushMatrix();
    scale(1, mapScaleY);
    image(mapCanvas, 0, 0);
    popMatrix();
  }    
  if (mapA < 1) {
    fill(255, 255*(1-mapA));
    rect(0, 0, mapCanvas.width, mapCanvas.height);
  }
  fill(redColor, 30);
  rect(0, 0, mapCanvas.width, mapCanvas.height);
  popMatrix();
  noStroke();
  fill(255);
  shape(map_mask, -map.width/2, -map.height/2);
  noFill();
  stroke(0);
  strokeWeight(1);
  shape(map, -map.width/2, -map.height/2);
  strokeWeight( z*heavyStroke);
  shape(map_, -map.width/2, -map.height/2);
  popMatrix();
}