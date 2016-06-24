float x, y, z;
boolean dragged;
float offsetX, offsetY;

void initCamera() {
}

void updateCamera() {
  if (dragged) {
    x += (mouseX-offsetX)/ z;
    offsetX = mouseX;
    y += (mouseY-offsetY)/ z;
    offsetY = mouseY;
  }
  scale(z);
  translate(x, y);
}

void keyPressed() {
  switch (key) {
  case 't':
    textured = !textured;
    break;
  case TAB:
    debug = !debug;
    break;
  case 'a':
    auto = !auto;
    break;
  case 'm':
    muted = !muted;
    break;
  case '0':
    goToScene(0);
    break;
  case '1':
    goToScene(1);
    break;
  case '2':
    goToScene(2);
    break;
  case '3':
    goToScene(3);
    break;
  case '4':
    goToScene(4);
    break;
  case '5':
    goToScene(5);
    break;
  case '6':
    goToScene(6);
    break;
  case '7':
    goToScene(7);
    break;
  case '8':
    goToScene(8);
    break;
  case '9':
    goToScene(9);
    break;
    //case ' ':
    //  int scope = 300; 
    //  targetX = -scope+random(scope*2);
    //  targetY = -scope+random(scope*2);
    //  targetZoom = 1+random(4);
    //break;
  }
}

void iso() {
  ortho(-width/2, width/2, -height/2, height/2, -2000, 2000);
  rotateX(radians(54.7));
  rotateZ(radians(45));
}

void mouseWheel(MouseEvent event) {
  float delta = event.getAmount();
  float targetZ = delta/1000.0;
  z -= targetZ;
}

void pressCamera() {
  offsetX = mouseX;
  offsetY = mouseY;
  dragged = true;
}

void releaseCamera() {
  dragged = false;
}

void keyReleased() {
  keyCode = 0;
}

void mousePressed() {
  pressCamera();
}

void mouseReleased() {
  releaseCamera();
}