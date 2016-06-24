Ticker ticker;
Frame frame;
//PImage test;

void setup() {
  setSize();
  ticker = new Ticker();
  ticker.printString("WHAT'S UP?", TICKER, 5, 1, 1);

  frame = new Frame();
  listenDweet("teleobject");
}

void draw() {
  background(backgroundColor);
  //size(12000,600);
  //fill(redColor);
  //text(thing, 100, 100);
  //text(content, 100, 130);
  //text(created, 100, 160);

  //if (test != null) {
  //  pushMatrix();
  //  scale(.5);
  //  image(test, 50, 50);
  //  popMatrix();
  //}
  translate(width/2, height/2);
  //scale(s);

  ticker.display();

  translate(300, -300);
  //frame.display();
}

void newDweet() {
  String[] items = splitTokens(content, "|");


  ticker.printString(items[0], parseInt(items[1]), parseInt(items[2]), parseInt(items[3]), parseInt(items[4]));
  //frame.printString(items[0], parseInt(items[1]), parseInt(items[2]), parseInt(items[3]), parseInt(items[4]));

  //println(items[0]);
}

void setSize()
{
  //println("setSize");
  size(window.innerWidth, window.innerHeight);
  if (width < 1200) {
    s = width/1400.0;
  }
  //size(document.body.clientWidth - 20, document.body.clientHeight - 20);
}

void mousePressed() {
  String thing = "teleobject";
  String url = "https://thingspace.io/get/latest/dweet/for/"+thing;
  //test = loadImage("https://static01.nyt.com/images/2016/05/12/us/politics/00trumpwomen-top-copy/00trumpwomen-top-square320.jpg");

  if (mouseX <  width/2) {
    //getDweet("teleobject");
    //println(result);
    //println(content);
  } else {

    //sendDweet("teleobject", millis());
  }
}