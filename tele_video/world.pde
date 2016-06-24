Globe globe;

int globeR = 170;
float globeA;
float globeZ;
int satNum = 9;

ShapeObject[] satellites;
float satAngle = 0;
float satOffset = 2*PI/satNum;

//long globeStart = 0;
long globeNext = 0;
int globeCounter = 0;

String[] satelliteShapes = {"nerd", "woman", "glasses", "necktie", "curly", "ponytail", "beard", "moustache", "freaky"};

void initGlobe() {
  globe = new Globe(globeR, 32, "img/world_red3.png");
  satellites = new ShapeObject[satNum];
  for (int i=0; i < satNum; i++) {
    satellites[i] = new ShapeObject();
    //satellites[i].a = 0;
    satellites[i].c = darkGreyColor;
    //satellites[i].z = 0;
    satellites[i].shp = loadShape("svg/profiles/"+satelliteShapes[i]+".svg");
    satellites[i].init();
  }
}

float rotation;
float rotationSpeed = .005;
boolean back, sat;

void globeOn() {
  for (int i=0; i < satNum; i++) {
    satellites[i].a = 0;
    satellites[i].z = 0;
  }
  rotation = 2.4;
  globeCounter = 0;
  globeNext = millis() + 500;
  globeZ = 0;
  globeA = 0;
  satAngle = -PI/2;
  back = false;
  sat = true;
}

void drawGlobe() {

  pushMatrix();
  scale(globeZ);
  pushMatrix();
  rotation += rotationSpeed;
  rotateY(rotation);
  rotateZ(radians(-15));
  noStroke();
  hint(ENABLE_DEPTH_TEST);
  globe.render(); 
  hint(DISABLE_DEPTH_TEST);
  popMatrix();

  if (sat) {
    satAngle += rotationSpeed;

    if (!back && millis() > globeNext) {
      globeNext = millis() + 200;
      satellites[globeCounter].aniZ(2, .5, Ani.SINE_IN_OUT);
      satellites[globeCounter].aniA(2, 1, Ani.SINE_IN_OUT);
      globeCounter ++;
      if (globeCounter == satNum) {
        globeCounter = 0;
        globeNext = millis() + 1000;
        back = true;
      }
    }


    if (back && millis() > globeNext && globeCounter < satNum) {
      globeNext = millis() + 100;
      satellites[globeCounter].aniZ(.4, 0, Ani.SINE_IN_OUT);
      satellites[globeCounter].aniA(.4, 0, Ani.SINE_IN_OUT);
      globeCounter ++;
    }

    for (int i=0; i < satNum; i++) {
      pushMatrix(); 
      //if (satellites[i].a > 0.2 ) {
      satellites[i].x = cos(satAngle+satOffset*i)*globeR*1.7;
      satellites[i].y = sin(satAngle+satOffset*i)*globeR*1.7;

      float offset = 15*satellites[i].z;
      
      tint(255, satellites[i].a*255*.8);
      image(shadow, satellites[i].x+offset, satellites[i].y+offset, 220*satellites[i].z, 220*satellites[i].z);
      noTint();
      fill(255, satellites[i].a*255);

      ellipse(satellites[i].x, satellites[i].y, 200*satellites[i].z, 200*satellites[i].z);
      satellites[i].draw();
      //}
      popMatrix();
    }
  }
  noStroke();
  fill(backgroundColor, (1-globeA) * 255);
  ellipse(0, 0, globeR*2, globeR*2);
  popMatrix();
}

class Globe {
  PImage 
    txtMap;
  int 
    globeRadius; 
  float 
    rWRatio, 
    rHRatio, 
    ROTATION_FACTOR=.01*DEG_TO_RAD;
  PVector   
    rotation, 
    rotSpeed;

  // Textured sphere implementation 
  float[][] 
    texturedSphereX, 
    texturedSphereY, 
    texturedSphereZ, 
    texturedSphereU, 
    texturedSphereV; 
  int   
    texturedSphereDetail;


  Globe(int _radius, int _sphereDetail, String _mapFilename) {
    globeRadius = _radius;
    txtMap = loadImage(_mapFilename);
    rWRatio= txtMap.width/globeRadius;
    rHRatio= txtMap.height/globeRadius;
    setTexturedSphereDetail(_sphereDetail); 
    rotation= new PVector(0, HALF_PI);
    rotSpeed= new PVector(0, 0);
  }

  void setTexturedSphereDetail(int detail) {   //Set the detail level for textured spheres, constructing the underlying vertex and uv map data  
    if (detail == texturedSphereDetail) return; 
    texturedSphereDetail = detail; 
    float step = PI / detail; 
    float ustep = .5 / detail; 
    float vstep = 1. / detail; 
    int d1= detail+1;
    int d2= detail*2 +1;

    texturedSphereX = new float[d1][d2]; 
    texturedSphereY = new float[d1][d2]; 
    texturedSphereZ = new float[d1][d2]; 
    texturedSphereU = new float[d1][d2]; 
    texturedSphereV = new float[d1][d2]; 

    for (int i = 0; i <= detail; i++) { 
      float theta = step * i; 
      float y = cos(theta); 
      float sin_theta = sin(theta); 
      float v = 1.0f - vstep * i; 

      for (int j = 0; j <= 2 * detail; j++) { 
        float phi = step * j; 
        float x = sin_theta * cos(phi); 
        float z = sin_theta * sin(phi); 
        float u = 1.0f - ustep * j; 

        texturedSphereX[i][j] = x * globeRadius; 
        texturedSphereY[i][j] = y * globeRadius; 
        texturedSphereZ[i][j] = z * globeRadius; 
        texturedSphereU[i][j] = u * txtMap.width; 
        texturedSphereV[i][j] = v * txtMap.height;
      }
    }
  }

  void render() {  // draw the sphere
    int nexti, t2= 2*texturedSphereDetail;
    for (int i = 0; i < texturedSphereDetail; i=nexti) { 
      nexti = i + 1;   
      beginShape(QUAD_STRIP); 
      texture(txtMap); 
      for (int j=0; j<=t2; j++) {         
        float u  = texturedSphereU[i][j]; 
        float x1 = texturedSphereX[i][j]; 
        float y1 = texturedSphereY[i][j]; 
        float z1 = texturedSphereZ[i][j]; 
        float v1 = texturedSphereV[i][j]; 
        float x2 = texturedSphereX[nexti][j]; 
        float y2 = texturedSphereY[nexti][j]; 
        float z2 = texturedSphereZ[nexti][j]; 
        float v2 = texturedSphereV[nexti][j]; 
        vertex(x1, y1, z1, u, v1); 
        vertex(x2, y2, z2, u, v2);
      }   
      endShape();
    }
  }

  //  void addRotation(int mX, int mY, int pmX, int pmY) {
  //    rotSpeed.x += (pmY-mY)* ROTATION_FACTOR;
  //    rotSpeed.y -= (pmX-mX)* ROTATION_FACTOR;
  //  }
  //
  //  void update() {
  //    // w.addRotation(0, 0, -int(rotationSpeed*10000), 0);
  //    // theta1 = sin(angle*orbitSpeed) * scalar;
  //    // rotSpeed.x += rotationSpeed*360;
  //    rotation.add(rotSpeed);
  //    rotSpeed.mult(.95);
  //  }
}