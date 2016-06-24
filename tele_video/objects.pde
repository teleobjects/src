class Object {
  int c;
  float a, x, y, z;

  void aniX (float tt, float xx, Easing ee) {
    Ani.to(this, tt, "x", xx, ee);
  }

  void aniY (float tt, float yy, Easing ee) {
    Ani.to(this, tt, "y", yy, ee);
  }

  void aniZ (float tt, float zz, Easing ee) {
    Ani.to(this, tt, "z", zz, ee);
  }

  void aniA (float tt, float aa, Easing ee) {
    Ani.to(this, tt, "a", aa, ee);
  }
}

class TextObject extends Object {
  String content = "";
  int fontSize = 48;
  boolean centered;

  void draw() {
    pushMatrix();
    translate(x, y);
    scale(z);
    fill(c, a*255);
    noStroke();
    textAlign(centered ? CENTER : LEFT, CENTER);
    textFont(helvetica, fontSize);  
    text(content, 0, -fontSize/8);
    popMatrix();
  }
}

class OverlayObject extends Object {
  void draw() {
    fill(c, a*255);
    rect(0, 0, 1600, 900);
  }
}

class MultipleObject extends ShapeObject {
  int rows = 10, columns = 16; 
  float s;

  void aniS (float tt, float ss, Easing ee) {
    Ani.to(this, tt, "s", ss, ee);
  }

  void draw () {
    pushMatrix();
    scale(s);
    translate(x-(200*columns/2), y-(200*rows/2));
    for (int i = 0; i < rows; i++) {
      pushMatrix();
      for (int j = 0; j <columns; j++ ) {
        pushMatrix();
        scale(z);
        fill(c, a*255);
        noStroke();
        shape(shp, 0, 0);
        popMatrix();
        translate(200, 0);
      }
      popMatrix();
      translate(0, 200);
    }  
    popMatrix();
  }
}

class IconObject extends ShapeObject {
  String content  = "";

  void draw() {
    pushMatrix();
    translate(x, y);
    scale(z);
    pushMatrix();
    translate(8, 8);
    scale(180.0/shadow.width*1.15);
    tint(255, a*255);
    image(shadow, 0, 0);
    noTint();
    popMatrix();
    noStroke();
    fill(c, a*255);
    ellipse(0, 0, 180, 180);
    fill(255, a*255);
    shape(shp, 0, -15);
    textFont(orator, 22);
    textAlign(CENTER, CENTER);
    text(content.toUpperCase(), 0, 47);
    popMatrix();
  }
}

class BoxObject extends ShapeObject {
  PShape shp;

  void init() {
    shp_.disableStyle();
    shp.disableStyle();
    findBoundsOutline(shp);
    dimension = new PVector(vMax.x-vMin.x, vMax.y - vMin.y);
    location = new PVector(0, 0);
  }

  void draw() {
    pushMatrix();
    translate(x, y);
    scale(z);
    translate(-500, -500);
    fill(255, 255*a);
    noStroke();
    shape(shp_, 0, 0);
    noFill();
    stroke(0, a*255);
    strokeWeight(1);
    shape(shp, 0, 0);
    strokeWeight(heavyStroke);
    shape(shp_, 0, 0);
    popMatrix();
  }
}

class ShapeObject extends Object {
  int c_ = 255;
  PShape shp, shp_;
  PVector vMin = new PVector(1000, 1000);
  PVector vMax = new PVector(0, 0);
  PVector dimension, location;

  void init() {
    shp.disableStyle();
    if (shp_ != null) {
      shp_.disableStyle();
    }
    findBoundsOutline(shp);
    dimension = new PVector(vMax.x-vMin.x, vMax.y - vMin.y);
    location = new PVector(0, 0);
  }

  void findBoundsOutline(PShape outline) {
    for (int j=0; j<outline.getChildCount(); j++) {
      PShape contour = outline.getChild(j);
      PShape path ;
      if (contour.getVertexCount() == 0) {
        for (int k=0; k<contour.getChildCount(); k++) {
          path = contour.getChild(k);
          findBoundsPath(path);
        }
      } else {
        path = contour;
        findBoundsPath(path);
      }
    }
  }

  void findBoundsPath(PShape path) {
    for (int i=0; i<path.getVertexCount(); i++) {
      PVector v = new PVector(0, 0);
      v = path.getVertex(i);
      if (v.x != 0 && v.y != 0) {
        if (v.x > vMax.x) vMax.x = v.x;
        if (v.y > vMax.y) vMax.y = v.y;
        if (v.x < vMin.x) vMin.x = v.x;
        if (v.y < vMin.y) vMin.y = v.y;
      }
    }
  }

  void draw() {
    pushMatrix();
    translate(x, y);
    scale(z);
    noStroke();
    if (shp_ != null) {
      fill(c_, a * 255);
      shape(shp_, 0, 0);
    }
    fill(c, a*255);
    shape(shp, 0, 0);
    popMatrix();
  }
}