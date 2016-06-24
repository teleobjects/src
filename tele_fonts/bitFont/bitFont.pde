// int displayType = ALPHA_DISPLAY;
String[] fontFile;
String fileName = "";
String dest = "Font20x28_";

final int NORMAL = 0;
final int FLIPV = 1;
final int FLIPH = 2;
final int FLIP = 3;
final int ROTATE90 = 4;
final int ROTATE180 = 5;
final int COLUMN = 6;
final int PADDED = 7;

///////////////////////////////////
boolean mono = true;
int w = 20;
int h = 28;
int bytesPerColumn = 4;
String startString="// font data";
int f = 48;
///////////////////////////////////
int offsetx = 1;
int offsety = 1;
int px = 10;
///////////////////////////////////
int bitMode = NORMAL;
int byteMode = NORMAL;
///////////////////////////////////
int last = -1;
byte map[][];
boolean bitmap[][][];

void setup() {
  size(2000, 1200);
}

void draw() {
  background(255);
  fill(255,0,0);
  text(fileName, 5, height-5);
  //text(last, 5, 15);
  displayFont();
}

void keyPressed() {
  switch(key) {
    case 'l':
    selectInput("Select a file to process:", "fileSelected");
    break;
    case 'w':
    writeFont();
    break;
  }
}

void displayFont() {
  stroke(200);
  int cx = 0;
  int cy = h;
  if (last != -1) {
    for (int i=f; i<last; i++) {
      fill(255,0,0);
      textAlign(LEFT, TOP);
      text(i, cx, cy);
      stroke(255,0,0,50);
      noFill();
      rect(cx,cy,w*px, h*px);
      for (int j=0; j<w; j++) {
        for (byte k=0; k<h; k++) {
          if (bitmap[i-f][j][k]) {
            fill(50);
            stroke(255);
            rect(cx, cy, px, px);
          }
          cy += px;
        }
        cx += px;
        cy -= px*h;
      }
      cx += offsetx*px;
      if (cx > width-(w*px)) {
        cx = 0;
        cy += px*(h+offsety);
      }
    }
  }
}

void writeFont() {
  String output = "";
  output += "#include <inttypes.h>";
  output += "\n";
  output += "#ifdef __AVR__";
  output += "\n";
  output += "#include <avr/pgmspace.h>";
  output += "\n";
  output += "#else";
  output += "\n";
  output += "#define PROGMEM";
  output += "\n";
  output += "#endif";
  output += "\n";
  output += "#ifndef "+dest.toUpperCase()+"_H";
  output += "\n";
  output += "#define "+dest.toUpperCase()+"_H";
  output += "\n";
  output += "#define "+dest.toUpperCase()+"_WIDTH "+w;
  output += "\n";
  output += "#define "+dest.toUpperCase()+"_HEIGHT "+h;
  output += "\n";
  output += "static const uint8_t "+dest+"[] PROGMEM = {";
  output += "\n";
  output += "0x0, 0x0, // size of zero indicates fixed witdh";
  output += "\n";
  output += "0x"+hex((byte)w)+", // width";
  output += "\n";
  output += "0x"+hex((byte)h)+", // height";
  output += "\n";
  output += "0x"+hex((byte)f)+", // first char";
  output += "\n";
  output += "0x"+hex((byte)(last-f))+", // char count";
  output += "\n";
  output += "// font data";
  output += "\n";
  for (int c=0; c<last-f; c++) {
    for (int currentByte = 0; currentByte<bytesPerColumn; currentByte++) {
      for (int column=0; column<w; column++) {
        String str = "";
        int row = ((currentByte+1) * 8) - 1;    
        int offset = 0;         
        if (row >= h) {
          offset =  row - h+1;
          row -= offset;
        }
        for (int k=0; k<8; k++) {
          if (row < h && row >= 0 && k < 8-offset+2) {
            str += bitmap[c][column][row] ? "1" : "0";
            // println("byte "+currentByte+"  bit "+k+"  row "+row + " "+(bitmap[c][column][row] ? "1" : "0"));
          } else {
            str += "0";
            // println("byte "+currentByte+"  bit "+k+"  row "+row + " x");
          }
          row --;
        }
        output += ("0x"+hex((byte)unbinary(str))+", ");
        // println("_____________________");
      }      
    }
    output += " // "+char(c+f);
    output += "\n";
  }
  output += "};";
  output += "\n";
  output += "#endif";
  String[] fileout = {output};
  // println(output);
  saveStrings("data/"+dest+".h", fileout);
}

void fileSelected(File selection) {
  if (selection != null) {
    fileName = selection.getAbsolutePath();
    load();
  }
}

ArrayList byteArray;

void load() {
  byteArray = new ArrayList();
  boolean flag = false;
  fontFile = loadStrings(fileName);
  println(fileName+" loaded");
  for (int i=0; i <fontFile.length; i++) {
    String l = fontFile[i];
    if (flag && l.indexOf("0x") != -1) {
      String bytes[] = splitTokens(l, ", ");
      for (int j=0; j < bytes.length; j++) {
        String tmp = clean(bytes[j]);
        if (tmp != null) {
          byteArray.add((int)unhex(tmp));
        }  
      }
    } else {
      if (l.indexOf(startString) != -1 ) {
        flag = true;
      }
    }
  }
  println(byteArray.size()+" bytes loaded");
  parse();
}

void parse() {  
  int currentChar = 0;
  int charNum = byteArray.size() / (bytesPerColumn * w);
  int byteIndex = 0;
  bitmap = new boolean[charNum][w][h];
  for (int i=0;i<charNum; i++) {
    switch(byteMode) {
      case PADDED:
      for (int currentByte = 0; currentByte < bytesPerColumn; currentByte++) {
        for (int column = 0; column < w; column++) {
          int row = ((bytesPerColumn-currentByte) * 8);
          int temp = (int)byteArray.get(byteIndex);
          byteIndex ++;
          // println("0x"+hex(temp)+" "+binary(temp, 8) +" " + i +" "+ column + " " + currentByte);
          int offset = 0;
          if (row >= h) {
            offset = (row-h);
            row -= offset;
          }
          for (int bit = 0; bit < 8; bit++) {
            int row_ = h-row;
            // println("byte"+currentByte+" bit"+bit+" row"+(row_));
            if(row_ < h && row_ >= 0) {
              bitmap [i][column][row_] = (temp & (1<<bit)) != 0;              
            }
            row--;
          }
        }
      }
      break;

      case NORMAL:
      for (int currentByte = 0; currentByte < bytesPerColumn; currentByte++) {
        for (int column = 0; column < w; column++) {
          int row = ((bytesPerColumn-currentByte) * 8)-((8*bytesPerColumn)-h)-1;
          int temp = (int)byteArray.get(byteIndex);
          byteIndex ++;
          // println("0x"+hex(temp)+" "+binary(temp, 8) +" " + i +" "+ column + " " + currentByte);
          for (int bit = 0; bit < 8; bit++) {
            if(row < h && row >= 0) {
              bitmap [i][column][h-row-1] = (temp & (1<<bit)) != 0;
            }
            row--;
          }
        }
      }
      break;

      case COLUMN:
      for (int column = 0; column < w; column++) {
        for (int currentByte = 0; currentByte < bytesPerColumn; currentByte++) {
          int temp = (int)byteArray.get(byteIndex);
          byteIndex ++;
          int row = (bytesPerColumn-currentByte-1)*8-((8*bytesPerColumn)-h);
          // println("0x"+hex(temp)+" "+binary(temp, 8) +" " + i +" "+ column + " " + currentByte);
          for (int bit = 0; bit < 8; bit++) {
            if(row < h && row >= 0) {
              bitmap [i][column][h-row-1] = (temp & (1<<bit)) != 0; //
            }
            row++;
          }
        }
      }
      break;
    }
  }
  println(charNum + " characters parsed");
  last = charNum+f;
}

String clean(String str) {
  if (str.indexOf("0x") == -1) return null;
  String output = "";
  for (int i=0; i<str.length(); i++) {
    char c = str.charAt(i);
    if (c != ' ' && c != '\t' && c != '}' && c!= ',') {
      output += c;
    }
  }
  // println(output);

  if (output.length() == 4) {
    return output.substring(2, output.length());
  } else {
    return null;
  }
}