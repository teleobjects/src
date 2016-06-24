long endStart;
ShapeObject home_mask;
OverlayObject red_mask;

boolean endStatus;
int endFrame;

TextObject title;


void initEnd() {
  title = new TextObject();
  title.content = "www.teleobjects.com";
  title.centered = true;
  title.fontSize = 48;

  home_mask = new ShapeObject();
  home_mask.shp = home.shp;
  home_mask.init();
}

void endOff() {
  endStatus = false;
}

void endOn() {
  z = scenes[8].targetZoom.z;
  x = scenes[8].targetZoom.x;
  y = scenes[8].targetZoom.y;
  //title.content = "teleobjects";
  title.z = 1;
  title.c = 50;

  logo.a = 0;
  endStart = millis();
  endStatus = true;
  endFrame = 0;
  cloud.c = redColor;
  cloud.a = 1;
  cloud.z = 10;
  cloud.y = 0;
  mobile.c = 255;
  mobile.a = 1;
  mobile.z = 2;
  mobile.c = 255;
  mobile.c_ = redColor;
  rotation = 1.3;
  sat = false;
  globeA = 0;
  globeZ = 12;
  home.c = backgroundColor;
  home.a = 1;
  home_mask.c = backgroundColor;
  home_mask.a = 0;
  Ani.to(this, 13, "z", .00005, Ani.QUINT_OUT);
  Ani.to(this, 13, "x", 0, Ani.QUINT_IN_OUT);
  Ani.to(this, 13, "y", 0, Ani.QUINT_IN_OUT);
}

void drawEnd() {
  if (activeScene == 9 && !endStatus) {
    endOn();
  }
  if (activeScene != 9 && endStatus) {
    endOff();
  }
  long endEllapsed = millis() - endStart;
  pushMatrix();
  if (globeA > 0 ) {
    drawGlobe();
  }
  scale(z*105);
  cloud.draw();
  mobile.draw();
  home.draw();   
  popMatrix();
  logo.draw();
  title.draw();
  home_mask.z = home.z*z*105;

  if (endEllapsed > 3500 && home_mask.a == 0) home_mask.aniA(3, 1, Ani.SINE_IN_OUT);
  if (endEllapsed > 6000 && logo.a == 0) logo.aniA (.5, 1, Ani.SINE_IN_OUT);
  if (endEllapsed > 7250 && logo.a == 1 ) logo.aniA (.5, .01, Ani.SINE_IN_OUT);
  if (endEllapsed > 8500 && home.a == 1) home.aniA(1, 0, Ani.SINE_IN_OUT);
  if (endEllapsed > 10000 && mobile.a == 1) mobile.aniA(.5, 0.0001, Ani.SINE_IN_OUT);
  if (endEllapsed > 11000 && cloud.a == 1) cloud.aniA(.5, 0, Ani.SINE_IN_OUT);
  if (endEllapsed > 10000 && globeZ == 12) Ani.to(this, 3, "globeZ", 1, Ani.SINE_IN_OUT);
  if (endEllapsed > 10000 && globeA == 0) Ani.to(this, .5, "globeA", 1, Ani.SINE_IN_OUT);
  if (endEllapsed > 13000 && globeA == 1) Ani.to(this, 1, "globeA", .001, Ani.SINE_IN_OUT);
  if (endEllapsed > 13000 && title.a == 0) title.aniA (1, 1, Ani.SINE_IN_OUT);
  if (endEllapsed > 15000 && title.a == 1) title.aniA (.5, .01, Ani.SINE_IN_OUT);
}