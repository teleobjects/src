char DEC_POINT = 47;
char DEGREE = 135;//char(29);
char SINGLE_QUOTE = char(5);
char DOUBLE_QUOTE = char(34);
char DECIMAL_POINT = 14;
char BAR_TOP = char(0);
char BAR_MIDDLE = '-';
char BAR_BOTTOM = char(3);
char EQ_LOW = '_';
char EQ_MID = '=';
char EQ_HIGH = char(135);
char EQ_OFF = ' ';

int currentFont = 0;

color foreground, background, top, bottom;
boolean gradient;

final int SYSTEM5x7 = 0;
final int COM8x8 = 1;
final int FONT10x14 = 2;
final int FONT20x28 = 3;
final int ARIAL14 = 4;
final int ARIALB14 = 5;
final int ARIALB16 = 6;

int[] widths =  {5, 8, 10, 20, 7, 7, 8};
int[] heights = {7, 8, 14, 28, 14, 14, 16};

final int BLANK = 0;
final int FOREGROUND = 1;
final int BACKGROUND = 2;
final int STRING = 3;
final int SYMBOL = 4;
final int BITMAP = 5;
final int DIGIT = 6;
final int CHARTABLE = 7;
final int FONT = 8;
final int DIRECTORY = 9;
final int SERVO = 10;
final int GRID = 11;
final int COPY_PIXELS = 12;
final int COPY_BYTES = 13;
final int COPY_GRADIENT = 14;
final int GRADIENT = 15;

final int LOADING = 15;

final int BATTERY = 17;
final int AXIS = 18;
final int DRIVE = 20;
final int EXTRA2 = 21;
final int BALL = 22;
final int RAIN = 23;
final int SNOW = 24;

final int WIDTH = 128;
final int HEIGHT= 128;

class Oled {
  final int FILL = 0;
  // color c;
  int w = 128;
  int h = 128;
  float f = 9;
  boolean gradient;

  PGraphics display;

  byte r, g, b;

  Oled () {
    foreground = whiteColor;
    background = redColor;
    top = 0;
    bottom = 0;
    display = createGraphics(128, 128, JAVA2D);
    display.noSmooth();
    display.beginDraw();
    display.background(background);
    display.endDraw();
  }

  void display() {
    // println("display");
    // oled.display.beginDraw();
    // oled.display.smooth();
    // //oled.display.background(255);
    // oled.display.endDraw();
    // r = (byte)red(c);
    // g = (byte)green(c);
    // b = (byte)blue(c);


    //r = (byte)map(red(c),0,255,0,31);
    //g = (byte)map(green(c),0,255,0,15);
    //b = (byte)map(blue(c),0,255,0,31);
    // fill(c);
    // noStroke();
    //rect(0, 0, w, h);
    // textAlign(CENTER, CENTER);
    // fill(255);
    // textSize(16);

    image(display, 0, 0);
    switch(channel) {
      //case CONTACTS:
      //  image(contactImg, 0, 0); 
      //  fill(255);
      //  noStroke();
      //  scale(1.14);
      //  shape(frame, 0, 0);

      //  break;
      //default:
      //  text("teleobjects", 0, 0);
      //}
    }
  }

  void printImage(String thisImageName, int thisX, int thisY) {
    PImage img;
    // img = loadImage(thisImageName);
    // if (img == null) {
      img = loadImage("data/png/"+thisImageName+".png");
    // }
    display.beginDraw();
    display.imageMode(CORNER);
    if (img!=null) display.image(img, thisX, thisY-img.height);
    display.fill(background);
    display.translate(64, 64);
    display.scale(1.14);
    display.shape(frame, 0, 0);
    display.endDraw();
  }

  void printString(String thisString, boolean mono, boolean center, int thisFont, int thisX, int thisY) {
    display.beginDraw();
    display.rectMode(CENTER);
    display.fill(background);
    display.noStroke();
    display.textFont(fonts[thisFont], fontSizes[thisFont]);
    if (center) {
      // display.rect(64, 128-thisY-heights[thisFont]/2, 128, heights[thisFont]);
      display.textAlign(CENTER, BOTTOM);
      display.fill(foreground);
      display.text(thisString, 64, thisY);
    } else {
      // display.rect(thisX, 128-thisY-heights[thisFont]/2, 128, heights[thisFont]);
      display.textAlign(LEFT, BOTTOM);
      display.fill(foreground);
      display.text(thisString, thisX, thisY);
    }
    display.endDraw();
  }
}

void printBlank() {
  if (oled.gradient) {
    oled.display.beginDraw();
    for (int i = 0; i < HEIGHT; i++) {
      float inter = map(i, 0, HEIGHT, 0, 1);
      color c = lerpColor(top, bottom, inter);
      oled.display.stroke(c);
      oled.display.line(0, i, HEIGHT, i);
    }
  } else {
    oled.display.endDraw();
    oled.display.beginDraw();
    oled.display.background(background);
    oled.display.endDraw();
  }
  writeString(str(BLANK));
}

void printGrid() {
  writeString(str(GRID));
}

void printMask() {
  // writeString("B");
  // oled.display.beginDraw();
  // oled.display.background(background);
  // oled.display.endDraw();
}

void printBackground(int c) {
  writeString(str(BACKGROUND)+char((byte)(red(c)/8)+48)+char((byte)(green(c)/4)+48)+char((byte)(blue(c)/8)+48));
  background = color(red(c), green(c), blue(c)); 
  oled.gradient = false;
}

void printForeground(int c) {
  writeString(str(FOREGROUND)+char((byte)(red(c)/8+48))+char((byte)(green(c)/4)+48)+char((byte)(blue(c)/8)+48));
  foreground = c;
  // oled.display.beginDraw();
  // oled.display.fill(foreground);  
  // oled.display.endDraw(); 
}

int printString(String str, boolean mono, boolean center, int thisFont, int thisX, int thisY) {
  boolean alpha = true;
  int charWidth = 0;
  charWidth = int(WIDTH/widths[thisFont])-4;
  // if (mono) {
  //   charWidth = int(WIDTH/widths[thisFont])-4;
  // } else {
  //   charWidth = int(WIDTH/widths[thisFont])-4;
  // }
  if (str != null) {
    while (str.length() > 0) {
      int nextLineW = str.length () > charWidth ? charWidth : str.length();  
      nextLineW = str.length();
      writeString(str(STRING)+char((mono ? 1 : 0)+48)+char((center ? 1 : 0)+48)+char(thisFont+48)+char(thisX+48)+char(thisY+48)+str.substring(0, nextLineW));
      oled.printString( str.substring(0, nextLineW),  mono,  center,  thisFont,  thisX,  thisY);
      str = str.substring(nextLineW, str.length());
      thisY = thisY - heights[thisFont];
    }
  }
  return thisY + heights[thisFont];
}

void printGradient(color c1, color c2) {
  top = c1;
  bottom = c2;
  oled.display.beginDraw();
  for (int i = 0; i < HEIGHT; i++) {
    float inter = map(i, 0, HEIGHT, 0, 1);
    color c = lerpColor(top, bottom, inter);
    oled.display.stroke(c);
    oled.display.line(0, i, HEIGHT, i);
  }
  oled.display.endDraw();
  String str = "";
  for (int row = 0 ; row < WIDTH; row = row + 2) {
    color c = oled.display.get(1,row);
    str += char((byte)(red(c)/8)+48);
    str += char((byte)(green(c)/4)+48);
    str += char((byte)(blue(c)/8)+48);
  }
  writeString("" + char(COPY_GRADIENT+48) + str);
  // writeString("" + char(GRADIENT+48));
  oled.gradient = true;

}

void printSymbol(int img, int thisX, int thisY) {
  writeString(""+SYMBOL+char(thisX+48)+char(thisY+48)+char(img+48));
}

void printImage(String img, int thisX, int thisY) {
  oled.printImage(img, thisX, thisY);
  if (img.length() > 11) {
    img = "/FACE/"+img.substring(0, 6).toUpperCase()+"~1.BMP";
  }
  writeString(""+BITMAP+char(thisX+48)+char(thisY+48)+img);
}

void printAlphabet(boolean mono, int f, int x, int y) {    
  writeString(""+CHARTABLE+char((mono ? 1 : 0 )+48)+char(f+48)+char(x+48)+char(y+48));
}

void printServo(int a) {
  writeString(""+char(SERVO+48)+char(a+48));
}

PGraphics tile2;
void printSymbol(PShape shp, int x, int y, int w, int h, float s, boolean alpha) {
 tile2 = createGraphics(w*2, h*2);
 tile2.noSmooth();
 tile2.beginDraw();
 tile2.background(255);
 tile2.fill(0);
 tile2.noStroke();
 tile2.translate(w, h);
  // tile.scale(shp.width/w);
  tile2.scale(.58*2);
  tile2.shape(shp, 0, 0);
  tile2.endDraw();


  tile = createGraphics(w, h);
  tile.noSmooth();
  tile.beginDraw();
  tile.background(255);
  // tile.fill(0);
  // tile.noStroke();
  // tile.translate(w/2, h /2);
  // // tile.scale(shp.width/w);
  // tile.scale(.55);
  // tile.shape(shp, 0, 0);

  tile.imageMode(CENTER);
  tile.translate(w/2,h/2);
  tile.scale(s/2);
  tile.image(tile2, 0,0);
  tile.endDraw();
  printBytes(x, y, w, h, alpha);
}

void printCharacter(char c, int x, int y, int w, int h, int f, int s, boolean alpha) {
  tile = createGraphics(w,h, JAVA2D);
  tile.noSmooth();
  tile.beginDraw();
  tile.background(255);
  tile.fill(0);
  tile.noStroke();
  tile.textAlign(CENTER, CENTER);
  tile.textFont(fontBold);
  tile.textSize(s);
  tile.text(char(c), (w/2)-1, (h/2)-2);
  tile.endDraw();
  printBytes(x, y, w, h, alpha);
}

PGraphics tile;

// void printCharacter(char c, int w, int y, int f, int s) 

void printBytes(int x, int y, int w, int h, boolean alpha) {
  String str = "";
  for (int row = 0 ; row < w; row ++) {
    for (int byte_ = 0; byte_ < int(w/8); byte_ ++) {
      String thisByte = "";
      for (int bit = 7 ; bit >= 0; bit --) {
        int column = (byte_*8)+bit;
        thisByte += tile.get(column, row) == color(0) ? "1" : "0";
      }
      int newVal = unbinary(thisByte);
      str += char(newVal);
    }
  }
  writeString("" + char(COPY_BYTES+48) + char(x+48) + char(y+48) + char(w+48) + char(h+48) + (alpha ? '1' : '0') + "\n" + str);
}

void printPixels(int x, int y, int w, int h) {
  String str = "";
  for (int row = 0 ; row < w; row ++) {
    for (int column = 0 ; column < h; column ++) {
      str += random(10)<5 ? "0" : "1";
    }
  }
  writeString(""+ char(COPY_PIXELS+48)+ char(x+48) +char(y+48)+char(w+48)+char(h+48)+str);
  println(str.length());
}

void printFont(int f) {
  writeString(""+FONT+char(f+48));
  oled.display.beginDraw();
  oled.display.textFont(fonts[f]);
  oled.display.endDraw();
}

void printDirectory(String thisString) {    
  writeString(""+DIRECTORY+thisString);
}
