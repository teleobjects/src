ShapeObject logo, home, cloud, world, mobile, box, box_;
PShape rays;
OverlayObject overlay;
MultipleObject mobileMultiple;
BoxObject[] boxes;
ShapeObject[] clouds, apps, actions;
int actionNum = 8;
int cloudNum = 6;
int appNum = 8;
String[] appNames = {"skypeapp", "mailapp", "markerapp", "mapapp", "wifiapp", "whatsapp", "cameraapp", "mailapp"};
String[] actionNames = {"talk", "like", "location", "touch", "camera", "moon", "drop", "heart"};
long homeStart;
boolean homeStatus;
float currentApp;
float heartZ;
int keyframe;
boolean titleFlag, homeFlag, cloudFlag;

void initHome() {
  overlay = new OverlayObject();
  z = .0001;
  logo = new ShapeObject();
  logo.shp = loadShape("svg/logo.svg");
  logo.c = 70;
  logo.init();
  mobileMultiple = new MultipleObject();
  mobileMultiple.shp = loadShape("svg/mobile.svg");
  mobileMultiple.c = backgroundColor;
  mobileMultiple.init();
  cloud = new ShapeObject();
  cloud.shp = loadShape("svg/cloud.svg");
  cloud.c = backgroundColor;
  cloud.init();
  clouds = new ShapeObject[cloudNum];
  PVector[] cloudData = new PVector[cloudNum];
  cloudData[0] = new PVector(400, -100, 7);
  cloudData[1] = new PVector(-200, 300, 5);
  cloudData[2] = new PVector(-500, -300, 9);
  cloudData[3] = new PVector(100, 300, 12);
  cloudData[4] = new PVector(0, 200, 16);
  cloudData[5] = new PVector(0, 0, 50);
  for (int i=0; i<cloudNum; i++) {
    clouds[i] = new ShapeObject();
    clouds[i].shp = cloud.shp;
    clouds[i].c = backgroundColor;
    clouds[i].x = cloudData[i].x;
    clouds[i].y = cloudData[i].y;
    clouds[i].z = cloudData[i].z;
    clouds[i].init();
  }
  apps = new ShapeObject[appNum];
  boxes = new BoxObject[appNum];
  for (int i=0; i<appNum; i++) {
    apps[i] = new ShapeObject();
    apps[i].shp = loadShape("svg/"+appNames[i]+".svg");
    apps[i].shp_ = loadShape("svg/maskapp.svg");
    apps[i].c = redColor;
    apps[i].z = .6;
    apps[i].init();
    boxes[i] = new BoxObject();
    boxes[i].shp = loadShape("svg/box.svg");
    boxes[i].shp_ = loadShape("svg/box_.svg");
    boxes[i].c = 0;
  }
  rays = loadShape("svg/rays.svg");
  rays.disableStyle();
  mobile = new ShapeObject();
  mobile.shp = loadShape("svg/mobile.svg");
  mobile.shp_ = loadShape("svg/mobile_.svg");
  mobile.c = darkGreyColor;
  mobile.init();
  actions = new ShapeObject[actionNum];
  for (int i=0; i<actionNum; i++) {
    actions[i] = new ShapeObject();
    actions[i].shp = loadShape("svg/"+actionNames[i]+".svg");
    actions[i].c = redColor;
    actions[i].z = 4;
    actions[i].init();
  }

  home = new ShapeObject();
  home.shp = loadShape("svg/home.svg");
  home.c = backgroundColor;
  home.init();
}

void homeOn() {
  globalStart = millis();

  //if (!muted) soundtrack.rewind();
  keyframe = 0;// 8;// 7;
  homeStart = millis(); //- 20000;
  //auto = false;
  homeStatus = true;
  keyframe = 0;
  overlay.a = 0;
  overlay.c = redColor;
  logo.z = 1.3;
  logo.a = 0;
  home.a = 0;
  home.z = .3;
  home_mask.c = backgroundColor;
  home_mask.a = 1;
  cloud.a = 1;
  cloud.z = 1;
  cloud.y = -1000;
  for (int i=0; i<cloudNum; i++) {
    clouds[i].a = 0;
  }
  for (int i=0; i<appNum; i++) {
    boxes[i].shp = loadShape("svg/box.svg");
    boxes[i].shp_ = loadShape("svg/box_.svg");
    boxes[i].z = 1.75;
    boxes[i].a = 0;
    boxes[i].init();
    apps[i].a = 0;
  }
  mobileMultiple.z = 1.3;
  mobileMultiple.a = 0;
  mobileMultiple.c = backgroundColor;
  mobileMultiple.s = .750 ;
  startY= -400;
  layerY = 0;
  heartZ = 1;
  globeOn();
}

void homeOff() {
  homeStatus = false;
}

void drawHome() {
  if (activeScene == 0 && !homeStatus) {
    homeOn();
  }
  if (activeScene != 0 && homeStatus) {
    homeOff();
  }
  if (homeStatus) {
    long  homeEllapsed = millis() - homeStart;
    switch(keyframe) {
    case 0:
      if (homeEllapsed > 0) {  // title fades out
        keyframe ++;
      }
      break;
    case 1:
      if (homeEllapsed > 0) { // globe enters
        Ani.to(this, 3, "globeA", 1, Ani.QUAD_IN_OUT);    
        Ani.to(this, 3, "globeZ", 1, Ani.QUAD_IN_OUT);    
        keyframe ++;
      }
      break;
    case 2:
      drawGlobe();   
      if (homeEllapsed > 4000) { // globe zooms in
        Ani.to(this, 3, "globeZ", 15, Ani.QUAD_IN_OUT);  
        keyframe ++;
      }
      break;
    case 3:
      drawGlobe();  
      overlay.draw();
      if (homeEllapsed > 5000 && overlay.a == 0) { // multiple zooms appears
        overlay.aniA(1, 1, Ani.SINE_IN);
      }
      if (homeEllapsed > 4500 && layerY == 0) {  // layers scroll
        Ani.to(this, 8.5, "layerY", 950, Ani.QUAD_IN_OUT);
      }
      if (homeEllapsed > 6000) {  
        mobileMultiple.aniA(1, 1, Ani.SINE_OUT);

        keyframe++;
      }
      break;
    case 4:
      overlay.draw(); 
      mobileMultiple.draw();
      if (homeEllapsed > 6500) {  // multiple zooms in
        mobileMultiple.aniS(5, 28, Ani.QUAD_IN_OUT);
        keyframe ++;
      }
      break;
    case 5:  
      overlay.draw();
      pushMatrix();
      scale(mobileMultiple.s/5);
      cloud.y = layerY - 950;
      cloud.draw();
      drawLayers();
      popMatrix();    
      mobileMultiple.draw();
      for (int i =0; i<cloudNum; i++) { // clouds overlap
        if (homeEllapsed-12000 > 100*i) {
          if (clouds[i].a ==0) clouds[i].aniA(.2, 1, Ani.SINE_IN_OUT);
          clouds[i].draw();
        }
      }
      if (homeEllapsed > 13000) {  // overlay fades in
        overlay.c = backgroundColor;
        overlay.a = 1;
        overlay.aniA(1, 0, Ani.SINE_IN_OUT);
        mobile.aniZ(1, 2, Ani.SINE_IN_OUT);
        mobile.aniA(1, 1, Ani.SINE_IN_OUT);
        keyframe++;
      }
      break;
    case 6:
      drawDataMatrix();
      overlay.draw();
      mobile.draw();
      float appAngle = millis()/10000.0;
      float appOffset = 2*PI/appNum;
      for (int i =0; i<appNum; i++) { // apps fade in
        if (homeEllapsed-12000 > 200*i) {
          if (apps[i].a ==0) apps[i].aniA(1, 1, Ani.SINE_IN_OUT);
          apps[i].x = cos(appAngle+appOffset*i)*200*1.7;
          apps[i].y = sin(appAngle+appOffset*i)*200*1.7;
          apps[i].draw();
        }
      }
      for (int i =0; i<appNum; i++) {
        if (homeEllapsed-15000 > 200*i) { // apps fade out

          if (boxes[i].a ==0) boxes[i].aniA(.5, 1, Ani.SINE_IN_OUT);
          boxes[i].x = apps[i].x;
          boxes[i].y = apps[i].y;
          boxes[i].draw();

          if (apps[i].a == 1) apps[i].aniA(.5, 0.001, Ani.SINE_IN_OUT);
          apps[i].x = cos(appAngle+appOffset*i)*200*1.7;
          apps[i].y = sin(appAngle+appOffset*i)*200*1.7;
          apps[i].draw();
        }
      }
      if (homeEllapsed > 15000 && mobile.a == 1) { // mobile fades out
        mobile.aniA(1, 0, Ani.SINE_IN_OUT);
      }

      if (homeEllapsed > 17000) {
        keyframe++;
      }
      break;
    case 7:
      drawDataMatrix();
      pushMatrix();
      scale(heartZ);
      appAngle = millis()/10000.0;
      appOffset = 2*PI/appNum;
      for (int i =0; i<appNum; i++) {
        int currentApp = (int)(homeEllapsed-17000)/300;
        if (currentApp >= 0 && currentApp < appNum ) {
          actions[currentApp].draw();
          actions[currentApp].a = 1;
        }
        apps[i].x = cos(appAngle+appOffset*i)*200*1.7;
        apps[i].y = sin(appAngle+appOffset*i)*200*1.7;
      }
      for (int i =0; i<appNum; i++) {
        if (homeEllapsed-17000 > 300*i) {  // boxes fade out 
          if (boxes[i].a == 1) {
            boxes[i].aniA(.3, 0, Ani.SINE_OUT);
            boxes[i].shp = rays;
            boxes[i].shp_ = rays;
            boxes[i].z = 1.2;
          }
        }
        boxes[i].x = apps[i].x;
        boxes[i].y = apps[i].y;
        boxes[i].draw();
      }
      popMatrix();
      if (homeEllapsed > 19200 && heartZ == 1) Ani.to(this, 7, "heartZ", 100, Ani.SINE_IN_OUT);
      if (homeEllapsed > 19200) {
        keyframe ++;
      }
      break;
    case 8:
      drawDataMatrix();
      pushMatrix();
      scale(heartZ);
      actions[appNum-1].draw();
      home.draw();
      popMatrix();
      z = heartZ / 120;
      home_mask.z = home.z * heartZ ;
      if (homeEllapsed > 20000 && home.a == 0) home.aniA(1, 1, Ani.SINE_IN_OUT);
      if (homeEllapsed > 21000) {    
        keyframe ++;
        home_mask.aniA(3, 0, Ani.SINE_IN_OUT);
      }
      break;
    case 9:
      pushMatrix();
      z = heartZ / 120;
      scale(heartZ);
      actions[appNum-1].draw();
      home.draw();
      home_mask.z = home.z * heartZ;
      if (homeEllapsed > 24000 && logo.a == 0) {    
        logo.aniA(2, 1, Ani.SINE_OUT);
      }
      if (homeEllapsed > 26000 && logo.a == 1) {    
        logo.aniA(.5, 0.0001, Ani.SINE_OUT);
      }
      popMatrix();
      logo.draw();
      if (homeEllapsed > 27000 && auto) {    
        goToScene(1);
      }
      break;
    }
  }
}

float startY, layerY;
float layerOffset = 150;
float layerSize = 200;
int modules = 10;
float moduleOffset = layerSize/modules;
int layerNum = 4;
float layersAlpha = 1;
char[][][] matrix = new char[layerNum][modules][modules];
long lastMatrix;

void drawLayers () {
  pushMatrix();
  translate(0, startY+layerY);
  iso();
  strokeWeight(1.5);
  textFont(orator, 16);
  textAlign(CENTER, CENTER);
  for (int k=0; k<layerNum; k++) {
    noFill();
    fill(redColor);
    stroke(255, layersAlpha*255);
    rect(0, 0, layerSize, layerSize, 20);
    pushMatrix();
    translate(-layerSize/2, -layerSize/2);
    if (millis() > lastMatrix) {
      lastMatrix = millis() + 100;
      for (int l=0; l<layerNum; l++) {
        for (int i=0; i<modules; i++) {
          for (int j=0; j<modules; j++) {
            if (random(10)<5) {
              matrix[l][i][j] = char('A'+(int)random(24));
            }
          }
        }
      }
    }
    for (int rows = 1; rows < modules; rows ++ ) {
      for (int columns = 1; columns < modules; columns ++ ) {
        pushMatrix();
        translate (columns * moduleOffset, rows * moduleOffset);
        fill(255, layersAlpha*255);
        text(matrix[k][rows][columns], 0, 0);
        popMatrix();
      }
    }
    popMatrix();
    translate(0, 0, layerOffset);
  }
  popMatrix();
  hint(ENABLE_DEPTH_TEST);
  fill(redColor);
  noStroke();
  rect(0, -1250, 1000, 2000);
  hint(DISABLE_DEPTH_TEST);
}

int rrr = 9;
int ccc = 16;
float fff;

char[][] dataMatrix = new char[rrr][ccc];
long lastDataMatrix;

void drawDataMatrix() {
  fff = 1600 / ccc;
  if (millis() > lastMatrix) {
    lastMatrix = millis() + 100;
    for (int i=0; i<rrr; i++) {
      for (int j=0; j<ccc; j++) {
        if (random(10)<5) {
          dataMatrix[i][j] = char('A'+(int)random(24));
        }
      }
    }
  }

  textAlign(CENTER, TOP);
  textFont(orator, 128);
  fill(50, 25);
  pushMatrix();
  translate(-1600/2, -900/2);
  for (int rr = 0; rr < rrr; rr ++ ) {
    for (int cc = 0; cc < ccc; cc ++ ) {
      pushMatrix();
      translate (48 + cc * fff, 8+rr * fff);
      text(dataMatrix[rr][cc], 0, 0);
      popMatrix();
    }
  }
  popMatrix();
}