void updateDots() {
  for (int i = 0; i < PIXEL_NUM; i++) {
    uint8_t red = pixelColors[i][0];
    uint8_t green = pixelColors[i][1];
    uint8_t blue = pixelColors[i][2];
    uint32_t color =  strip.Color(red, green, blue);
    strip.setPixelColor(i,  color);
  }
  strip.show();
}

void dotStrip() {
  //  for (int i = 0; i < PIXEL_NUM; i = i + 4) {
  //    pixelColors[i][0] = 0;
  //  }
  for (int i = 0; i < PIXEL_NUM; i = i + 4) {
    pixelColors[(i + pixelX - 1) % PIXEL_NUM][0] = 0;
    pixelColors[i + pixelX][0] = brightness;
    pixelColors[(i + pixelX + 1) % PIXEL_NUM][0] = 0;
  }
  strip.show();
  if (millis() - lastPixelTime > (250 - (teck*10))) {
    lastPixelTime = millis();
    pixelX += dir ? 1 : -1;
    if (pixelX < 0 ) {
      pixelX = 4;
    }
    if (pixelX > 4) {
      pixelX = 0;
    }
  }
}

void clearDots() {
  for (int i = 0; i < PIXEL_NUM; i++) {
    uint8_t red = pixelColors[i][0] = 0;
    uint8_t green = pixelColors[i][1] = 0;
    uint8_t blue = pixelColors[i][2] = 0;
  }
}


