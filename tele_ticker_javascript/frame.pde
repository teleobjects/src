


class Frame {
  PShape frame, app;
  PImage img;

  //PGraphics canvas;


  Frame() {
    //canvas = createGraphics(240, 240);

    //canvas.beginDraw();
    //canvas.background(redColor);
    //canvas.endDraw();

    app = loadShape("shp/app.svg");
    app.disableStyle();

    mask = loadShape("shp/mask.svg");
    mask.disableStyle();
  }

  void display() {

    strokeWeight(2.5);
    stroke(50);
    fill(255);
    pushMatrix();
    scale(2.5);
    strokeWeight(2.5/2.5);

    shape(app, 0, 0);
    popMatrix();

    pushMatrix();
    //image(canvas, 0, 0);

    if (img != null) {
      imageMode(CENTER);

      scale(240.0/img.width*.46);

      image(img, 0, 0);
    }
    popMatrix();

    fill(255);
    noStroke();
    shape(mask, 0, 0);

    stroke(0);
    strokeWeight(2.5);
    noFill();
    shape(app, 0, 0);
  }

  void printString(String thisString, int thisMode, int thisTick, int thisTock, int thisTuck) {
    if (thisMode == IMAGE) {
      println("loading "+thisString);
      img = loadImage(thisString);
      //canvas.beginDraw();
      //canvas.scale(img.width/240.0);
      ////canvas.scale(2);
      //canvas.background(255);
      //canvas.fill(redColor);
      //canvas.text(thisString, 10, 120);
      //canvas.imageMode(CORNER);

      //canvas.image(img,0,0);
      //canvas.endDraw();
    }
  }
}
