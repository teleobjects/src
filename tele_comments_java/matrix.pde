final int CHARS = 32;

char DEC_POINT = 47;
char DEGREE = 176;
char SINGLE_QUOTE = 39;
char DOUBLE_QUOTE = 34;
char DECIMAL_POINT = 46;
char BAR_TOP = 0;
char BAR_MIDDLE = '-';
char BAR_BOTTOM = 3;
char EQ_LOW = '_';
char EQ_MID = '=';
char EQ_HIGH = 135;
char EQ_OFF = ' ';

final int BLANK = 0;
final int LOOK = 1;
final int CENTERED = 2;
final int INSTANT= 3;
final int TICKER = 4;
final int SCROLL = 5;
final int SCROLL_ALL_RIGHT = 6;
final int SCROLL_CENTER_RIGHT = 7;
final int SCROLL_PUSH_RIGHT = 8;
final int SCROLL_ALL_LEFT = 9;
final int SCROLL_CENTER_LEFT = 10;
final int SCROLL_PUSH_LEFT = 11;
final int SLEEP = 12;
final int AIRPORT = 13;
final int BLINK = 14;
final int LOADING = 15;
final int COMPASS = 16;
final int BATTERY = 17;
final int AXIS = 18;
final int ALPHABET = 19;
final int EXTRA = 20;
final int STREAM = 21;
final int BALL = 22;
final int RAIN = 23;
final int SNOW = 24;
final int FONT = 60;


final int DWEET_TX = 100;
final int IMAGE = 101;

class Matrix {
	float m = 58;
	float w = m*8;
	float h = m; 
	float offsetV = 50;
	boolean busy;

	Matrix() {
		
	}

	void display() {
		translate(0, - 20);
		pushMatrix();
		translate(0, -offsetV);
		displayRow();
		translate(0, offsetV*2);
		displayRow();
		popMatrix();
	}

	void displayRow() {
		pushMatrix();
		translate(-w/2,-h/2);
		rectMode(CORNER);
		ellipseMode(CORNER);
		fill(50);
		rect(0,0,w,h,5);
		stroke(50);	
		strokeWeight(1.5);
		fill(redColor);
		for (int c = 0;c<8;c++) {
			for (int x = 0;x<8;x++) {
				for (int y=0;y<8;y++) {		
					ellipse(c*m + (x*m/8.0), y*m/8.0, m/8.0,m/8.0);
				}
			}
		}
		popMatrix();
	}
}


String invalid  = "`´_âáäÁÂÄéêëÉÊËíîïÍÎÏóôöÓÔÖúûüÚÛÜñÑ";//+char(8217);
String subs     = "'' 'aaAAAeeeEEEiiiIIIoooOOOuuuUUUnN";
String valid = " !@#$%^&*()-+=[]}{;':<>,.?/01234567890ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"+DEGREE+DOUBLE_QUOTE+SINGLE_QUOTE;

String cleanUp(String str, boolean capitalize) {
	String tmp = cleanUp(str);
	if (capitalize) tmp = tmp.toUpperCase();
	return tmp;
}

String cleanUp(String str) {
  // boolean flag = false;
  String res = "";
  for (int i=0; i<str.length(); i++) {
  	char ch = str.charAt(i);
  // 	if (ch == '&' && str.charAt(i+1) == '#') {
  // 		ch = 39;
  // 		i = i+6;
  //     // flag = true;

  // }
  if (ch > 127) {
  // println((int)ch, char(ch));// ch = 39;

}
  // if (invalid.indexOf(ch) != -1) {
  // 	ch = subs.charAt(invalid.indexOf(ch));
  // }
  if (valid.indexOf(ch) != -1) {
  	res +=  ch;
  } else {
  	res += '-';
  }
}
  // if (flag) println(res);
  return res;
}
