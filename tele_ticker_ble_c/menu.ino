

void showMenu() {

  if (millis() > lastScroll + 600 - (abs(roll) * 10)) {
    if (abs(roll) > 12) {
      click(DOUBLE_CLICK);
      scrollMenu(roll > 0);
      tx();
    }
  }

  if (millis() > lastPitch + 300 && pitch > 60) {
    //    click(DOUBLE_CLICK);

    selectMenu(true);
    tx();
    lastPitch = millis();
    //    if (pitch < 0 && pitch > -170) {
    //      selectMenu(false);
    //      lastPitch = millis();
    //    }
  } else {
    clearDisplay();
    cursorX = (CHARS - menuItems[currentItem].length()) / 2;
    for (int i = 0; i < menuItems[currentItem].length(); i++) {
      dis[cursorX + i] = menuItems[currentItem][i] ;
    }
    updateDisplay();
  }
}

void scrollShow(boolean left) {
  int nextItem = currentShowItem + (left ? -1 : 1);
  if (nextItem < 0) nextItem = 15;//showItems.length();
  nextItem = nextItem % 16;
  int currentOffsetX = (CHARS - showItems[currentShowItem].length()) / 2;
  int nextOffsetX = (CHARS - showItems[currentShowItem].length()) / 2;
  int offsetX = CHARS - nextOffsetX;

  for (int xx = 0; xx < offsetX; xx++) {
    clearDisplay();
    cursorX = (CHARS - showItems[currentShowItem].length()) / 2;
    for (int i = 0; i < showItems[currentShowItem].length(); i++) {
      dis[currentOffsetX + i + (left ? xx : -xx)] = showItems[currentShowItem][i] ;
    }
    for (int i = 0; i < showItems[nextItem].length(); i++) {
      dis[i + (left ? xx : -xx) + (left ? -showItems[nextItem].length() : CHARS)] =  showItems[nextItem][i] ;
    }
    updateDisplay();
  }
  currentShowItem = nextItem;
  lastScroll = millis();
}

void scrollMenu(boolean left) {
  int nextItem = currentItem + (left ? -1 : 1);
  if (nextItem < 0) nextItem = MENUITEMS-1;
  nextItem = nextItem % MENUITEMS;
  int currentOffsetX = (CHARS - menuItems[currentItem].length()) / 2;
  int nextOffsetX = (CHARS - menuItems[nextItem].length()) / 2;
  int offsetX = CHARS - nextOffsetX;

  for (int xx = 0; xx < offsetX; xx++) {
    clearDisplay();
    cursorX = (CHARS - menuItems[currentItem].length()) / 2;
    for (int i = 0; i < menuItems[currentItem].length(); i++) {
      dis[currentOffsetX + i + (left ? xx : -xx)] = menuItems[currentItem][i] ;
    }
    for (int i = 0; i < menuItems[nextItem].length(); i++) {
      dis[i + (left ? xx : -xx) + (left ? -menuItems[nextItem].length() : CHARS)] =  menuItems[nextItem][i] ;
    }
    updateDisplay();
  }
  currentItem = nextItem;
  lastScroll = millis();
  //  tx();
  //  responses = 0;
  //  busy = false;
}

void selectMenu(boolean in) {
  int offsetX = (CHARS - menuItems[currentItem].length()) / 2;
  if (in) {
    for (int t = 0; t < 2; t++) {
      click(STRONG_CLICK);

      for (int xx = 0; xx < offsetX; xx++) {
        clearDisplay();
        for (int i = 0; i < menuItems[currentItem].length(); i++) {
          dis[offsetX + i] = menuItems[currentItem][i] ;
        }
        dis[xx - 1] = '-';
        dis[xx] = '>';
        boolean even = menuItems[currentItem].length() % 2 == 0;
        dis[CHARS - xx - (even ? 0 : 1)] = '-';
        dis[CHARS - xx - (even ? 1 : 2)] = '<';
        updateDisplay();
        delay(10);
      }
      delay(50);
    }
    delay(100);

    //    clearDisplay();
    //    updateDisplay();
    //    mode = BLANK;
    data = '@'+menuCommands[currentItem];
    parse();
    //    responses = 0;
    //    busy = false;
    //    responses = 0;
  }
}



