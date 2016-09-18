void checkGestures() {
  if (pitch < -80 && pitch > -100) {
    if (!upsideDown) {
      upsideDown = true;
      upsideDownStart = millis();
    }
  } else {
    upsideDown = false;
  }
  if (upsideDown && millis() - upsideDownStart > 1000) {
    mode = SLEEP;
    tx();
    //    busy = false;
    //    responses = 0;
  }

  if (mode == SLEEP) {
    if (inertia > 200) {
      tack = 65;
      teck = 66;
      mode = LOOK;
      lastPitch = millis();
      lastRoll = millis();
      //      busy = false;
      //      responses = 0;
      tx();
    }
  }

  //

  if (mode != MENU && mode != SLEEP) {
    if (pitch < -45) {
      if (!pitchOn) {
        pitchOn = true;
        lastPitch = millis();
      }
    } else {
      pitchOn = false;
    }
    if (pitchOn && millis() > lastPitch + 200) {
      click(STRONG_CLICK);
      blinkDisplay(200, 200);
      click(STRONG_CLICK);

      blinkDisplay(200, 200);
      //      blinkDisplay(200, 200);
      mode = MENU;
      lastPitch = millis();
      lastRoll = millis();
      lastScroll = millis();
      //      busy = false;
      //      responses = 0;
      tx();
    }
  }
  //
  //    if (upsideDown && millis() - upsideDownStart > 2000) {
  //      mode = SLEEP;
  //      if ( millis() - awakeStart > 5000) {
  //        if (z > 6 && !busyZ) {
  //          busyZ = true;
  //          mode ++;
  //          if (mode > 8 ) mode = 0;
  //        }
  //        if (z < -6 && !busyZ) {
  //          mode --;
  //          busyZ = true;
  //          if (mode < 0) mode = 8;
  //        }
  //      }
  //    }
}
