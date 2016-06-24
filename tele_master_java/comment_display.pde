class CommentDisplay extends Display {
  PShape outline;
  float m = 58;
  float w = m*8;
  float h = m; 
  float offsetV = 50;
  boolean busy = true;

  CommentDisplay() {
    outline = loadShape("shp/comment.svg");
    outline.disableStyle();
  }

  void display() {
    strokeWeight(thick);
    stroke(0);
    fill(255);
    shape(outline, 0, 0);
    translate(-230, - 45);
    translate(0, -offsetV);
    displayRow();
    translate(0, offsetV*2);
    displayRow();
  }

  void displayRow() {
    rectMode(CORNER);
    ellipseMode(CORNER);
    fill(50);
    // rect(0,0,w,h,5);
    stroke(redColor, 10);	
    stroke(255, 50);
    strokeWeight(.5);
    // noStroke();
    fill(redColor);
    for (int c = 0; c<8; c++) {
      for (int x = 0; x<8; x++) {
        for (int y=0; y<8; y++) {		
          ellipse(c*m + (x*m/8.0), y*m/8.0, m/8.0, m/8.0);
        }
      }
    }
  }

  String invalid  = "`´_âáäÁÂÄéêëÉÊËíîïÍÎÏóôöÓÔÖúûüÚÛÜñÑ";
  String subs     = "'' 'aaAAAeeeEEEiiiIIIoooOOOuuuUUUnN";
  String valid = " !@#$%^&*()-+=[]}{;':<>,.?/01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz°'"+char(34);

  String cleanUp(String str) {
    // println(str);
    String res = "";
    for (int i=0; i<str.length(); i++) {
     char ch = str.charAt(i);
     if (ch == '&'){
      if (str.charAt(i+1) == '#') {
        ch = 39;
        i = i+6;
      } else {
       if (str.length() > i+5) {
        if (str.charAt(i+5) == ';') {
          ch = 39;
          i = i+5;
        }
      }
    }
  }
  if (ch > 127) {
   ch = 39;
 }
 if (invalid.indexOf(ch) != -1) {
   ch = subs.charAt(invalid.indexOf(ch));
 }
 if (valid.indexOf(ch) != -1) {
   res +=  ch;
 } else {
   res += '-';
 }
}
return res;
}
}