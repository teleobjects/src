#include <Arduino.h>
#include <Wire.h>
#include <SPI.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_LSM9DS0.h>
#include "Adafruit_BLE.h"
#include "Adafruit_BluefruitLE_SPI.h"
#include <stdlib.h>
#include <stdio.h>
#include "Adafruit_LEDBackpack.h"
#include "Adafruit_GFX.h"

// MODES

#define BLANK 1
#define CENTERED 2
#define INSTANT 3
#define TICKER 4
#define SCROLL 5
#define SCROLL_ALL_RIGHT 6
#define SCROLL_CENTER_RIGHT 7
#define SCROLL_PUSH_RIGHT 8
#define SCROLL_ALL_LEFT 9
#define SCROLL_CENTER_LEFT 10
#define SCROLL_PUSH_LEFT 11
#define SLEEP 12
#define AIRPORT 13
#define BLINK 14
#define LOADING 15
#define COMPASS 16
#define BATTERY 17 // A
#define AXIS 18 // B
#define ALPHABET 19  // C
#define EXTRA // D
#define STREAM 21  // E
#define BALL 22 // F
#define RAIN 23  // G
#define SNOW 24 // H
#define RANDOM 25
#define CLOCK 26
#define COUNTER 27
#define WAIT 50
#define BRIGHTNESS 51
#define FONT 52
#define COUNTER 53
#define PING 54
#define LOOK 55

// PINS

#define PILOT_PIN 13
#define BAT_PIN A7
#define CHARGE_PIN A0

// DISPLAY

Adafruit_AlphaNum4 alpha0 = Adafruit_AlphaNum4();
Adafruit_AlphaNum4 alpha1 = Adafruit_AlphaNum4();
Adafruit_AlphaNum4 alpha2 = Adafruit_AlphaNum4();
Adafruit_AlphaNum4 alpha3 = Adafruit_AlphaNum4();
Adafruit_AlphaNum4 alpha4 = Adafruit_AlphaNum4();
Adafruit_AlphaNum4 alpha5 = Adafruit_AlphaNum4();
Adafruit_AlphaNum4 alpha6 = Adafruit_AlphaNum4();
Adafruit_AlphaNum4 alpha7 = Adafruit_AlphaNum4();

// BLUEFRUIT

#define BUF_SIZE                       256
#define VERBOSE_MODE                   false
#define BLUEFRUIT_SPI_CS               8
#define BLUEFRUIT_SPI_IRQ              7
#define BLUEFRUIT_SPI_RST              4
#define FACTORYRESET_ENABLE            1
#define MINIMUM_FIRMWARE_VERSION       "0.6.6"
#define MODE_LED_BEHAVIOUR             "BLEUART"
#define POWER_LEVEL                     4

Adafruit_BluefruitLE_SPI ble(BLUEFRUIT_SPI_CS, BLUEFRUIT_SPI_IRQ, BLUEFRUIT_SPI_RST);

// ACCELEROMETER

Adafruit_LSM9DS0     lsm(1000);  // Use I2C, ID #1000

float roll, pitch, heading;
char rollBuffer[4];
char pitchBuffer[4];
char headingBuffer[4];

int momentum;
long momentumNext;
int inertia;
boolean shock;
boolean upsideDown = false;
long upsideDownStart;

//// BATTERY

int minBat = 320;
int maxBat = 425;
boolean charging, lastCharging;
int voltage;
char voltageBuffer[4];
int batIndex;
int batLong = 10;
long lastBat;
int refreshBat;
int chargingX;
long chargingNext;
int chargingSpeed = 150;
long lastBattery;

// DISPLAY

#define CHARS 32
boolean dec[CHARS];

int cursorX, breakX, lastX, firstX;
long lastTick;
int brightness = 1;
int brightnessIndex;

//byte packet = 0;
byte tack = 1, teck = 1, tick = 1, tock = 1, tuck = 1;
long lastTx;
long lastRx;
int txSpeed = 100;
int timeOut = 1000;

boolean busy;
boolean connecting = true;
boolean connected = false;
boolean buffering = false;

// SLEEP
boolean busyZ;
int zzz, zzzC, zzzD = 1;
long nextZ;
long awakeStart;

// LOOK
boolean eyesW = false;;
int eyesX = 0;
boolean eyesB;
boolean eyesD = true;
int eyesSpeed = 100;
long eyesLast;

// BALL
int ballX;
int ballY;

// SNOW
//int snowIntensity = 5;
//int snowWind = 10;
//int snowFall = 10;

// SPIN
byte loadingOut[] = {0, 1, 2, 3, 4, 5};
byte loadingIn[] = {6, 8, 9, 10, 7, 13, 12, 11};

// COMPASS
String compass = "E | | | | | | NE | | | | | | N | | | | | | NW | | | | | | W | | | | | | SW | | | | | | S | | | | | | SE | | | | | | ";

// COMM

#define PACKETIN 6
#define PACKETOUT 11
#define DEBUG true

int responses;
byte byteOut [PACKETOUT];
char charOut [PACKETOUT + 1];
char charIn [BUF_SIZE];
int charIndex = 0;
int mode;
String data, dis;


void setup() {
  pinMode(PILOT_PIN, OUTPUT);
  pinMode(CHARGE_PIN, INPUT_PULLUP);
  //  data.reserve(BUF_SIZE);
  initDisplay();
  clearDisplay();
  updateDisplay();
  if (DEBUG) {
    Serial.begin(115200);
  }
  initComm();
  initAccelerometer();
  setBrightness(brightness);
  data = "400z00teleobjects";
  //  parse();
  //  tock = 20;
  //  tack = 2;
  //  teck = 0;
  //  tick = 100;

  mode = ALPHABET;
}

void loop() {
  digitalWrite(PILOT_PIN, buffering ? HIGH : LOW);
  //  digitalWrite(PILOT,  millis() % 200 < 100 ? HIGH : LOW);
  if (connecting) {
    updateComm();
  }
  accelerometer();
  battery();
  if (voltage < 340 && !charging) {
    mode = BATTERY;
  }
  rx();
  if (!buffering) {
    if (!busy) { // && mode != LOOK && mode != SLEEP && mode != STREAM && mode != WAIT) {
      if (responses < 1) {

        tx();
      }
    }
  }
  play();

  //    if (upsideDown && millis() - upsideDownStart > 2000) {
  //      mode = SLEEP;
  //    if ( millis() - awakeStart > 5000) {
  //      if (z > 6 && !busyZ) {
  //        busyZ = true;
  //        mode ++;
  //        if (mode > 8 ) mode = 0;
  //      }
  //      if (z < -6 && !busyZ) {
  //        mode --;
  //        busyZ = true;
  //        if (mode < 0) mode = 8;
  //      }
  //    }
}

