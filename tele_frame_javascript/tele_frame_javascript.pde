int  tick, tock, tuck;
float rot, targetRot;
PShape outline, outline_mask, app, mask;

//boolean newDweet = false;

Ticker ticker;
float s = 1;

void setup() {
  setSize();
  app = loadShape("shp/app.svg");
  app.disableStyle();
  outline = loadShape("shp/ticker.svg");
  outline.disableStyle();
  outline_mask = loadShape("shp/ticker_mask.svg");
  outline_mask.disableStyle();
  mask = loadShape("shp/mask.svg");
  mask.disableStyle();
  alpha = new Alpha();
  alpha.printString("WHAT'S UP?", TICKER, 5, 1, 1);
  listenDweet("teleobject");
}

void draw() {
  background(backgroundColor);
  //fill(redColor);
  //text(thing, 100, 100);
  //text(content, 100, 130);
  //text(created, 100, 160);
  translate(width/2, height/2);
  scale(s);
  strokeWeight(2.5);
  stroke(50);
  fill(255);
  shape(outline, 0, 0);
  fill(backgroundColor);
  shape(outline_mask, 0, 0);
  ticker.display();
}

void newDweet() {
  String[] items = splitTokens(content, "|");
  ticker.printString(items[0],parseInt(items[1]), parseInt(items[2]), parseInt(items[3]), parseInt(items[4]));
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
  println("getting dweet");
  if (mouseX <  width/2) {
    getDweet("teleobject");
    //println(result);
    //println(content);
  } else {
    
    //sendDweet("teleobject", millis());
  }
}

//interface JavaScript
//{
//  void getDweet();
//  void sendDweet();
//}

//JavaScript javascript = null;

//void setJavaScript(JavaScript js) { 
//  javascript = js;
//}