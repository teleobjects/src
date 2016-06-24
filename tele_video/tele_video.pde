PFont helvetica, sevenFont, orator;

PShape balloon, balloon_, frame, frame_, map, map_, map_mask;
PShape suitcase, suitcase_, mailbox, mailbox_, mailbox_flag;
PShape reel, reel_, reel_tape, alarm, alarm_, alarm__, hammer, hammer_;

PImage texture;
PImage shadow;

boolean debug, muted = false, textured = true;

color darkGreyColor = 80;
color backgroundColor = 220;
color redColor = color(190, 30, 45);
float heavyStroke = 1.2;

long globalStart;


void setup() {
  //size(1280, 720, P3D); 
  size(1920, 1080, P3D);
  //size(2048, 1152, P3D);
  frameRate(60);
  noCursor();
  Ani.init(this);
  imageMode(CENTER);
  rectMode(CENTER);
  textMode(MODEL);
  smooth(16);
  hint(DISABLE_DEPTH_TEST);
  sevenFont = createFont ("Digital-7Mono", 128);
  helvetica = createFont("HelveticaNeue-Light", 64);
  orator = createFont("OratorStd", 128);
  texture = width == 1280 ? loadImage("img/paper_1280x720.jpg") : loadImage("img/paper_1920x1080.jpg");
  shadow = loadImage("shadows/shadow_circle_light.png");
  initHome();
  initGlobe();
  initKeyhole();
  initSuitcase();
  initMailbox();
  initReel();
  initBalloon();
  initFrame();
  initMap();
  initAlarm();
  initComposer();
  initEnd();
  goToScene(0);
  //textured = true;
  if (muted) {
    soundtrack.pause();
  } else {
    initSound();
    soundtrack.play();
  }
}

void draw() {
  background(backgroundColor);
  pushMatrix();
  translate(width/2, height/2);  // center
  pushMatrix();
  scale(width/1600.0);  // normalize
  drawBackground();
  drawContent();
  drawForeground();
  popMatrix();
  if (textured) {
    scale(width*1.0/texture.width*1.0);
    blendMode(MULTIPLY);
    image(texture, 0, 0);  // background
    blendMode(BLEND);
    //tint(255, 50);
    //image(texture, 0, 0);  // overlay
    //noTint();
  }
  popMatrix();

  if (debug) {
    textFont(helvetica, 18);
    fill(redColor);
    textAlign(LEFT);  
    text(x, 10, 30);
    text(y, 10, 60);
    text(z, 10, 90);
    long ellapsed = millis()-globalStart;
    //int sec = (int)ellapsed;
    int min = (int)ellapsed/60000;
    int sec = ((int)ellapsed-min*60*1000)/1000;
    text(frameRate > 59 ? 60 : (int)frameRate, 10, 120);  
    text(auto ? "auto" : "stop", 10, 150);
    text(muted ? "muted" : "sound", 10, 180);
    text(nf(min, 2, 0)+":"+nf(sec, 2, 0), 10, 210);
    text(activeScene +"scene", 10, 240);
    text(keyframe +"keyframe", 10, 270);
    strokeWeight(1);
    stroke(redColor, 100);
    for (int i=1; i<3; i++) {
      line(i*width/3.0, 0, i*width/3.0, height);
    }
    for (int i=1; i<3; i++) {
      line(0, i*height/3.0, width, i*height/3.0);
    }
    stroke(255, 0, 0, 20);
    line(0, height/2, width, height/2);
    line(width/2, 0, width/2, height);
    //for (int i=1; i<3; i++) {
    //  line(i*width/3.0, 0, i*width/3.0, height);
    //}
    //for (int i=1; i<3; i++) {
    //  line(0, i*height/3.0, width, i*height/3.0);
    //}
  }
}