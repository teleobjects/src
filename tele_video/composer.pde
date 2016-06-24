import de.looksgood.ani.*;
import de.looksgood.ani.easing.*;

int activeScene;

PShape[] numbers;

Scene[] scenes;

boolean auto = true;

void initComposer() {
  numbers = new PShape[10];
  for (int i=0; i<10; i++) {
    numbers[i] = loadShape("svg/"+i+".svg");
    numbers[i].disableStyle();
  }
  scenes = new Scene[10];
  for (int i=0; i<10; i++) {
    scenes[i] = new Scene();
    scenes[i].num = i;
    scenes[i].init();
  }
}

void drawBackground() {

  for (int i=1; i<9; i++) {
    scenes[i].update();
    scenes[i].drawBackground();
  }

  drawHome();

  if (activeScene == 9) {
    drawEnd();
  } else {
    endOff();
  }
}

void drawContent() {
  pushMatrix();
  updateCamera();  
  if ((activeScene == 0 && keyframe == 9) || (activeScene > 0 && activeScene < 9) || (activeScene == 9 && millis() - endStart < 8000)) {
    drawFrame(300, 0);
    drawBalloon(300, -250);
    drawMap(-100, -250);
    drawSuitcase(-500, -220);
    drawAlarm(-450, 0);
    drawMailbox(-520, 280);
    drawReel(-200, 150);

    drawKeyhole(100, 305);
  }
  noStroke();
  popMatrix();
  if ((activeScene == 9 && millis() - endStart < 9000) || (activeScene == 0 && keyframe == 9)) {
    home_mask.draw();
    logo.draw();
  }
}

void drawForeground() {
  for (int i=1; i<9; i++) {
    scenes[i].drawForeground();
  }
}

void goToScene(int thisScene) {
  scenes[activeScene].off();
  activeScene = thisScene;
  scenes[activeScene].on();
  /**
   * Ani.LINEAR
   * Ani.QUAD_IN
   * Ani.QUAD_OUT
   * Ani.QUAD_IN_OUT
   * Ani.CUBIC_IN
   * Ani.CUBIC_IN_OUT
   * Ani.CUBIC_OUT
   * Ani.QUART_IN
   * Ani.QUART_OUT
   * Ani.QUART_IN_OUT
   * Ani.QUINT_IN
   * Ani.QUINT_OUT
   * Ani.QUINT_IN_OUT
   * Ani.SINE_IN
   * Ani.SINE_OUT
   * Ani.SINE_IN_OUT
   * Ani.CIRC_IN
   * Ani.CIRC_OUT
   * Ani.CIRC_IN_OUT
   * Ani.EXPO_IN
   * Ani.EXPO_OUT
   * Ani.EXPO_IN_OUT
   * Ani.BACK_IN
   * Ani.BACK_OUT
   * Ani.BACK_IN_OUT
   * Ani.BOUNCE_IN
   * Ani.BOUNCE_OUT
   * Ani.BOUNCE_IN_OUT
   * Ani.ELASTIC_IN
   * Ani.ELASTIC_OUT
   * Ani.ELASTIC_IN_OUT
   */
}

void goTo(float xx, float yy, float zz) {
  float tt = 3;
  if (activeScene != 9) {
    Ani.to(this, tt, "x", xx, Ani.SINE_IN_OUT);
    Ani.to(this, tt, "y", yy, Ani.SINE_IN_OUT);
    Ani.to(this, tt, "z", zz, Ani.SINE_IN_OUT);
  }
}

class Scene {
  int num;
  boolean status;

  long start, ellapsed;
  PVector target = new PVector(0, 0, 1);
  PVector targetZoom = new PVector(0, 0, 0);

  boolean zoom;

  ShapeObject index, app;
  TextObject[] infos;
  IconObject[] props;

  void init() {
    if (num > 0 && num < 9) {
      index = new ShapeObject();
      index.shp = numbers[num];
      index.c = redColor;
      index.init();
    }

    String data[] = loadStrings("data/"+num+".txt");

    String[] dataItems = split(data[0], ",");
    String appName = dataItems[0];

    if (!appName.equals("null")) {
      app = new ShapeObject();
      app.shp = loadShape("svg/"+appName+".svg");
      app.init();
      app.c = 200;
    }

    if (dataItems.length > 3) {
      target = new PVector(parseFloat(dataItems[1]), parseFloat(dataItems[2]), parseFloat(dataItems[3]));
    }
    if (dataItems.length > 6) {
      targetZoom = new PVector(parseFloat(dataItems[4]), parseFloat(dataItems[5]), parseFloat(dataItems[6]));
    } else {
      targetZoom = target;
    }
    if (data.length > 1) {
      String[] icons = split(data[1], ",");
      String[] labels = split(data[2], ",");
      props = new IconObject[icons.length];
      for (int i=0; i<props.length; i ++) {
        props[i] = new IconObject();
        props[i].shp = loadShape("svg/"+icons[i]+".svg");
        props[i].content =labels[i];
        props[i].c = redColor;
        props[i].init();
      }
    }
    if (data.length > 3) {
      infos = new TextObject[data.length-3];
      for (int i=0; i<infos.length; i++ ) {
        infos[i] = new TextObject();
        infos[i].c = 50;
        infos[i].content = data[i+3];
      }
    }
  }

  void on() {
    start = millis();
    status = true;
    zoom = false;

    goTo(target.x, target.y, target.z);

    if (index != null) {
      index.a = 1;
      index.z = 200;
      index.aniZ(1, 14, Ani.SINE_OUT);
    }
    if (app != null ) {
      app.z = 5;
      app.a = 0;
      app.aniA(2, .7, Ani.SINE_OUT);
      app.aniZ(16, 15, Ani.SINE_OUT);
    }

    if (infos != null) {
      float lineHeight = 120;
      for (int i=0; i<infos.length; i++ ) {
        infos[i].x = activeScene % 2 == 0 ? 2000 : -2000;
        infos[i].y = -lineHeight*1.5 +  ( i * lineHeight);
        infos[i].z = 1;
      }
      for (int i=0; i<props.length; i ++) {
        int column = i%2;
        int row = i == 0 ? 0 : int(i/2);
        props[i].z = 0;
        props[i].y = (row*220) - 220;
        props[i].x = (column*220) + (activeScene % 2 != 0 ? (-width/4) - 110 : (width/4) - 110);
      }
    }
  }

  void off() {
    status = false;
    if (index != null) {
      index.aniA(0.001, 0, Ani.LINEAR);
      index.aniZ(0.001, 100, Ani.LINEAR);
    }
    if (app != null ) {
      app.aniA(1, 0, Ani.SINE_OUT);
    }
    if (infos != null) {
      for (int i=0; i<infos.length; i ++) {
        infos[i].aniA(0.001, 0, Ani.LINEAR);
        infos[i].aniX(0.001, -2000, Ani.LINEAR);
      }
    } 
    if (props != null) {
      for (int i=0; i<props.length; i ++) {
        props[i].aniZ(0.001, 0, Ani.LINEAR);
        props[i].aniA(0.001, 0, Ani.LINEAR);
      }
    }
  }

  void update() {
    if (status) {
      ellapsed = millis() - start;

      if (ellapsed > 12000 && auto && activeScene < 9) {
        goToScene(activeScene + 1);
      }

      if ((ellapsed > 800 && ellapsed < 850) ||  (ellapsed > 900 && ellapsed < 950 )) index.a = 0;
      if ((ellapsed > 850 && ellapsed < 900) ||  (ellapsed > 950 && ellapsed < 1000)) index.a = 1;
      if (ellapsed > 1000) index.aniA(.5, 0, Ani.SINE_OUT);

      if (ellapsed > 7000 && !zoom && auto) {
        goTo(targetZoom.x, targetZoom.y, targetZoom.z);
        zoom = true;
      }

      if (ellapsed > 11000) {
        app.aniA(1, 0, Ani.SINE_OUT);
      }

      if (infos != null) {
        for (int i=0; i<infos.length; i++ ) {
          if (ellapsed > 2000+(800*i)) {
            infos[i].aniA (.1, 1, Ani.LINEAR);
            infos[i].aniX (.1, activeScene % 2 == 0 ? 0 : -650, Ani.LINEAR);
          }

          if (ellapsed > 4500+(800*i)) {
            infos[i].aniA (.1, 0, Ani.SINE_OUT);
          }
        }
      }

      if (props != null) {
        for (int i=0; i<props.length; i ++) {
          if (ellapsed > 6000+(i*400)) {
            props[i].aniZ(1, 1, Ani.ELASTIC_OUT);
            props[i].aniA(.1, 1, Ani.SINE_OUT);
          }
          if (ellapsed > 9000+(i*100)) {
            props[i].aniZ(.2, 0, Ani.SINE_OUT);
            props[i].aniA(.2, 0, Ani.SINE_OUT);
          }
        }
      }
    }
  }

  void drawBackground() {
    if (app != null) {
      pushMatrix();
      iso();
      rotateZ(activeScene % 2 == 0 ? radians(-90) : 0);
      app.draw();
      popMatrix();
    }
  }

  void drawForeground() {
    if (infos != null) {
      for (int i=0; i<infos.length; i ++) {
        infos[i].draw();
      }
    }    
    if (props != null) {
      for (int i=0; i<props.length; i ++) {
        props[i].draw();
      }
    }
    if (index != null) {
      index.draw();
    }
  }
}