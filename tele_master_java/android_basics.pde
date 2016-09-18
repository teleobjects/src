
import android.os.Bundle;
import android.os.BatteryManager;
import android.os.Vibrator;
import android.os.Environment;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;

import android.app.ActivityManager;

import android.view.*;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.view.KeyEvent;
import android.view.MotionEvent;

import android.graphics.Rect;

import android.media.MediaPlayer;
import android.app.Activity;


import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiInfo;

import android.bluetooth.BluetoothAdapter;

import ketai.sensors.*; 
import ketai.ui.*;

KetaiGesture gesture;
KetaiLocation location;
KetaiAudioInput mic;
Vibrator vibe; 

ActivityManager activityManager; 
WindowManager windowManager;
InputMethodManager inputMethodManager;
WifiManager wifiManager;
ConnectivityManager connectivityManager;
BroadcastReceiver receiver;

MediaPlayer mediaPlayer;
Context context; 
Activity act;
AssetFileDescriptor afd;

// MEMORY
float maxMemory = 0;  
int freeMemory = 0;

// KEYBOARD

public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  vibe = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
  wifiManager = (WifiManager) getActivity().getSystemService(Context.WIFI_SERVICE);
  connectivityManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
  activityManager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
  //inputMethodManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
  getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

  IntentFilter filter = new IntentFilter();
  filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
  filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");

  receiver = new BroadcastReceiver() {
    @Override
      public void onReceive(Context context, Intent intent) {
      if (verbose) println("network state changed");
      if (network != null) {
        network.update();
      }
    }
  };
  getActivity().registerReceiver(receiver, filter);

  //getActivity().getWindow().getDecorView().findViewById(android.R.id.content).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
  //  public void onGlobalLayout() {
  //    Rect r = new Rect();
  //    getActivity().getWindow().getDecorView().findViewById(android.R.id.content).getWindowVisibleDisplayFrame(r);
  //    int screenHeight = getActivity().getWindow().getDecorView().findViewById(android.R.id.content).getRootView().getHeight();
  //    int keypadHeight = screenHeight - r.bottom;
  //    if (keyboard !=  null) {
  //      if (keypadHeight > screenHeight * 0.15) {
  //        keyboard.keyboard = true;
  //      } else {
  //        keyboard.keyboard = false;
  //        //View decorView = getActivity().getWindow().getDecorView();
  //        //int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
  //        //decorView.setSystemUiVisibility(uiOptions);
  //      }
  //    }
  //  }
  //}
  //);
}

void onDestroy() {
  super.onDestroy();
  if (receiver != null) {
    getActivity().unregisterReceiver(receiver);
    receiver = null;
  }
  if (mediaPlayer !=null) {
    mediaPlayer.release();
    mediaPlayer = null;
  }
  if (verbose) println("on destroy teleobjects");
}

void onPause() {
  super.onPause();
  if (bluetooth != null) {
    bluetooth.pause();
  }
  if (mediaPlayer !=null) {
    mediaPlayer.release();
    mediaPlayer = null;
  }
  if (verbose) println("on pause teleobjects");
}

void onResume() {
  super.onResume();
  if (bluetooth != null) {
    bluetooth.resume();
  }
  if (verbose) println("on resume teleobjects");
}

class Sensors {
  long vibeDuration = 5;
  long[] vibeList = { 0, 20, 20, 20, 20 };    

  PApplet parent;

  Sensors(PApplet _parent) {
    parent = _parent;
  }

  void update() {
    if (location == null) {
      try {
        location = new KetaiLocation(parent);
        location.setUpdateRate(5000, 5);
      } 
      catch (Exception e) {
        if (verbose) println("error initializing location");
      }
    }
  }

  void updateMemory() {
  }

  void updateBattery() {
  }

  void vibrate() {
    vibe.vibrate(vibeDuration);
  }
}

void onLocationEvent(double _latitude, double _longitude, double _altitude) {
  try {
    if (geolocation != null) {
      geolocation.located = true;
      geolocation.updated = false;
      geolocation.longitude = _longitude;
      geolocation.latitude = _latitude;
      geolocation.altitude = _altitude;
      if (location != null && location.getProvider() != null) geolocation.provider = location.getProvider();
    }
    Packet newPacket = new Packet(false, "", getPilot("location").x);
    newPacket.init();
  }
  catch (Exception e) {
    println("Exception "+e);
  }
}

class Gestures {
  PApplet parent;
  boolean tapped;
  boolean doubleTapped;
  boolean flicking;
  boolean dragging;
  long lastTap;
  int debounce = 200;
  float startX, startY;

  Gestures(PApplet parent_) {
    parent = parent_;
    gesture = new KetaiGesture(parent);
  }

  void update() {
    if (dragging) {
      stroke(255, 0, 0);
      line(startX, startY, mouseX, mouseY);
    }
  }
}

void onDoubleTap(float x, float y)
{
  //things.add(new Thing("DOUBLE", x, y));
}

void onTap(float x, float y)
{
  //things.add(new Thing("SINGLE", x, y));
}

void onLongPress(float x, float y)
{
  //things.add(new Thing("LONG", x, y));
}

void onFlick( float x, float y, float px, float py, float v)
{
  //things.add(new Thing("FLICK:"+v, x, y, px, py));
}

void onPinch(float x, float y, float d)
{
  //Size = constrain(Size+d, 10, 2000);
}

void onRotate(float x, float y, float ang)
{
  //Angle += ang;
}

void mousePressed() {
  println(mouseX+" "+mouseY+" "+keyboard.keyboard);
  if (millis() - gestures.lastTap > gestures.debounce) {
    if (keyboard.keyboard) {
      keyboard.hide();
    } else {
      gestures.lastTap = millis();
      gestures.tapped = true;
      gestures.dragging = true;
      gestures.startX = mouseX;
      gestures.startY = mouseY;
    }
  }
}

void mouseReleased() {
  gestures.tapped = false;
  gestures.dragging = false;
}

void mouseDragged()
{
}

public boolean surfaceTouchEvent(MotionEvent event) {
  super.surfaceTouchEvent(event);
  return gesture.surfaceTouchEvent(event);
}

class Keyboard {
  PApplet parent;
  boolean keyboard, lastKeyboard;

  Keyboard(PApplet _parent) {
    parent = _parent;
  }

  void update() {
    //if (!keyboard) {
    //  getActivity().runOnUiThread(new Runnable() {
    //    public void run() {
    //      View decorView = getActivity().getWindow().getDecorView();
    //      int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
    //      decorView.setSystemUiVisibility(uiOptions);
    //    }
    //  }
    //  );
    //}
  }

  void show() {
    if (!keyboard) {
      KetaiKeyboard.toggle(parent);
    }
  }

  void hide() {
    if (keyboard) {
      KetaiKeyboard.toggle(parent);
    }
  }
}

void keyPressed() {
  if (keyboard.keyboard) {
    if (key == CODED && keyCode == KeyEvent.KEYCODE_DEL) key = 8;
    if (key == 10) key = 31;
    if (activeObject != null) {
      activeObject.pages.add(new Page(key+"", TYPE, 0, 0, 0, 0, 1));
    }
  }
}

///////////////
// MIC
///////////////

class Eq {

  short[] micData;

  char[] eqData;
  char[] eqDataNibble;
  float[] eqVal;
  int res= 32;

  float rightL;
  float leftL;
  float eqFilter = 1;// .75;

  float maxL = sqrt(32768);
  float minL = 0;

  Eq( PApplet parent) {
    //println("starting eq");
    mic = new KetaiAudioInput(parent);
    eqVal = new float[res];
    eqData = new char[res];
    //startMic();
  }

  void update() {
    if (!mic.isActive()) {
      mic.start();
    }

    //if (manager.channel == EQ) {
    //  startMic();
    //} else {
    //  stopMic();
    //}

    float max = 0;

    if (micData != null) {
      rightL = 0;//abs(micData[0]);
      leftL = 0;//abs(micData[micData.length-1]);
      for (int i = 0; i < res; i++) {
        //print(micData[int(micData.length/res*i)]);
        //print("   ");
        float targetLevel = sqrt(abs(micData[int(micData.length/res*i)]));
        if (targetLevel > max) max = targetLevel;
        //if (targetLevel < maxL / 2) targetLevel += targetLevel/2; //////// look for better way to adjust sensitivity
        eqVal[i] += (targetLevel-eqVal[i])*eqFilter;

        eqData[i] = char((byte)map(eqVal[i], minL, maxL, 0, 7));
        if (eqData[i] > 7) eqData[i] = 7;
        if (eqData[i] < 0) eqData[i] = 0;
        //print(char(eqData[i]+48));
      }
      rightL = (max)/1000;
      leftL = rightL;

      //println();
      //for (int i=0; i<res/4; i++) {
      //  int a = int((eqData[(i*4)])/2 << 6);
      //  int b = int((eqData[(i*4)+1])/2 << 4);
      //  int c = int((eqData[(i*4)+2])/2 << 2);
      //  int d = int((eqData[(i*4)+3])/2);
      //  eqDataNibble[i] =  char(int(random(255)));//char(255-(a | b | c | d));
      //  if (eqDataNibble[i] < 32) eqDataNibble[i] = 32;
      //  //if (eqDataNibble[i] == '\n') eqDataNibble[i]++;
      //  //if (eqDataNibble[i] == 0) eqDataNibble[i]++;
      //}
    }
  }


  void display() {
    if (mic.isActive()) {
      stroke(greenColor);
      strokeWeight(2);
      pushMatrix();
      scale(displayWidth*1.0/micData.length*1.0, 1);
      translate(0, 250);
      for (int i = 0; i < micData.length; i++)
      {
        if (i != micData.length-1)
          line(i, map(micData[i], -32768, 32767, height, 0), i+1, map(micData[i+1], -32768, 32767, height, 0));
      }
      popMatrix();
    }
  }

  void startMic() {
    if (!mic.isActive()) {
      if (verbose) println("mic started");
      mic.start();
    }
  }

  void stopMic() {
    if (mic.isActive()) {
      if (verbose) println("mic stopped");
      mic.stop();
    }
  }
}

void onAudioEvent(short[] _micData)
{
  eq.micData= _micData;
}


void downloadByteArrayAsImage(String url, String fileName) {
}

//// PLAYER

class Player {
  PApplet parent;

  Player(PApplet _parent) {
    parent =_parent; 
    act = parent.getActivity();
    context = act.getApplicationContext();
    //try {
    //mediaPlayer = new MediaPlayer();
    //afd = context.getAssets().openFd("daft punk - get lucky.mp3");
    //if (verbose) println("Successfully loaded audio file");
    //mediaPlayer.setDataSource(afd.getFileDescriptor());
    //mediaPlayer.prepare();
    //} 
    //catch(IOException e) {
    //  if (verbose) println("Audio file did not load");
    //}
    //mediaPlayer.start();
  }

  void play() {
    mediaPlayer.start();
  }

  void stop() {
    mediaPlayer.stop();
  }
}