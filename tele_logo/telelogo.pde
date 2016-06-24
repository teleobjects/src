PFont font;


String str = "teleobjects";
int charNum = str.length();
float w;

void setup() {

  size(800, 800 );
  println(PFont.list());
  font = createFont("HelveticaNeue", 32);
  frameRate(5);
}

void draw() {
  background(255);
  fill(0);
  textFont(font, 64);
  textAlign(CENTER, CENTER);
  translate(width/2, height/2);
  w = 0;
  for (int i=0; i<charNum; i++) {
    char c = str.charAt(i);
    w += textWidth(c);
  }

  translate(-w/2.0, 0);

  for (int i=0; i<charNum; i++) {
    char c = str.charAt(i);
    float cw = textWidth(c);
    pushMatrix();
    translate(cw/2.0,0);
    
    if (random(100)<5) rotate(radians(-45+random(90)));
    text( c, 0, 0);
    popMatrix();
    translate(cw, 0);
  }


  //text("teleobjects", 0, 0);
}