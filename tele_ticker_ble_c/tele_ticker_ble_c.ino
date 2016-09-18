
#include <Arduino.h>
#include <Wire.h>
#include <SPI.h>
#include <Adafruit_BLE.h>
#include <Adafruit_BluefruitLE_SPI.h>
#include <Adafruit_LEDBackpack.h>
#include <Adafruit_GFX.h>
#include <Adafruit_Sensor.h>
#include <Adafruit_LSM9DS0.h>
#include <Adafruit_Simple_AHRS.h>
#include <Adafruit_DRV2605.h>
#include <Adafruit_SHT31.h>
#include <Adafruit_MPL3115A2.h>


#include <stdlib.h>
#include <stdio.h>

// MODES

#define BLANK 1
#define CENTERED 2
#define INSTANT 3
#define TICKER 4
#define SCROLL 5
//#define SCROLL_ALL_RIGHT 6
//#define SCROLL_CENTER_RIGHT 7
//#define SCROLL_PUSH_RIGHT 8
//#define SCROLL_ALL_LEFT 9
//#define SCROLL_CENTER_LEFT 10
//#define SCROLL_PUSH_LEFT 11
#define SLEEP 12
#define AIRPORT 13
#define BLINK 14
#define LOADING 15
#define BATTERY 17 // A
#define AXIS 18 // B
#define ALPHABET 19  // C
#define EXTRA 20 // D
#define STREAM 21  // E
#define BALL 22 // F
#define RAIN 23  // G
#define SNOW 24 // H
#define RANDOM 25 // I
#define CLOCK 26 // J
#define COUNTER 27 // K
#define SPECTRUM 28 // L
#define BRIGHTNESS 29 // M
#define LOOK 30 // N
#define COMPASS 31// O
#define TYPE 32 // P
#define SENSORS 33 // Q
#define SHOW 34 // R

#define WAIT 50
//#define FONT 52
#define PING 54
#define MENU 55

// MOTOR

#define STRONG_CLICK 1
#define SHARP_CLICK 4
#define SOFT_BUMP 7
#define DOUBLE_CLICK 10
#define TRIPLE_CLICK 12
#define SOFT_BUZZ 14
#define STRONG_BUZZ 14
#define ALERT 16
#define MEDIUM_CLICK 21
#define SHORT_DOUBLE_CLICK_STRONG 27
#define SHORT_DOUBLE_CLICK_MEDIUM 31
#define SHORT_DOUBLE_SHARP_TICK 34
#define BUZZ 88
#define PULSING_STRONG 52
#define PULSING_MEDIUM 54
#define PULSING_SHARP 56
#define TRANSITION_CLICK 58
#define TRANSITION_HUM 64
#define TRANSITION_RAMP_DOWN 70
#define TRANSITION_RAMP_DOWN 70

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

Adafruit_LSM9DS0 lsm(1000);
Adafruit_Simple_AHRS ahrs(&lsm.getAccel(), &lsm.getMag());

// MOTOR

Adafruit_DRV2605 mot;

// SENSORS

Adafruit_SHT31 sht = Adafruit_SHT31();
Adafruit_MPL3115A2 baro = Adafruit_MPL3115A2();

float temperature, temperature2, altitude, pressure, humidity;
long lastSensors;

// BATTERY

int minBat = 320;
int lowBat = 340;
int maxBat = 425;
boolean charging, lastCharging;
int voltage;
int lastVoltage;
char voltageBuffer[4];
int batIndex;
int batLong = 10;
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
int brightness = 15;
int lastBrightness = 1;
int brightnessIndex;
byte tack = 1, teck = 1, tick = 1, tock = 1, tuck = 1;

// COMM

#define BUF_SIZE 256
#define PACKETIN 7
#define PACKETOUT 15
#define DEBUG true

boolean busy = false;
boolean connecting = true;
boolean connected = false;
boolean buffering = false;

int responses;
byte byteOut [PACKETOUT];
char charOut [PACKETOUT + 1];
long lastTx;
long lastRx;
int txSpeed = 100;
int timeOut = 100;
int mode;
String data, dis;

// TIMER

int timer[6] = {0, 0, 0, 0, 0, 0};
//int lastTimer[6] = {0, 0, 0, 0, 0, 0};
int nextTime;
boolean postMeridiam;
boolean clock24 = false;

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

float ballX;
float ballY;

// SPIN

byte loadingOut[] = {0, 1, 2, 3, 4, 5};
byte loadingIn[] = {6, 8, 9, 10, 7, 13, 12, 11};

// COMPASS

String compass = "| | | | | | E | | | | | | NE | | | | | | N | | | | | | NW | | | | | | W | | | | | | SW | | | | | | S | | | | | | SE ";
char bars[3] = {'_', '-', 0};
char spectrum[4] = {' ', '_', '=', 135};

// MENU

#define MENUITEMS 11
String menuItems[MENUITEMS] = {"BATTERY", "BRIGHTNESS", "AXIS", "ALPHABET", "CLOCK", "COMPASS", "BALL", "SENSORS", "RAIN", "SNOW", "SHOW"};
String menuCommands[MENUITEMS] = {"A00000", "M00000", "B00000", "C00000", "J00000", "O00000", "F00000", "Q00000", "G00AA0", "HAAAA0", "R00000"};

String showItems[16] = {"teleobjects", "1 APP + 1 OBJECT", "EVERYDAY PRODUCT", "LOW TECH", "LOW COST", "LOW RES", "PERSONAL", "MASH UP", "SENSOR DATA", "PERSONAL CONTENT", "ONLINE SERVICES", "IKEA MEETS IOT", "COMPANION VS ASSISTANT", "ARTIFICIAL EMPATHY", "USELESS TOOL", "USEFUL TOY"};
int currentShowItem = 0;

int currentItem = 0;

float roll, pitch, heading;
float roll_, pitch_, heading_;

float currentHeading;

boolean rollOn, pitchOn;
long lastRoll;
long lastPitch;
long lastScroll;

float inertiaRoll, targetInertiaRoll;
float inertiaPitch, targetInertiaPitch;
float inertia, targetInertia;
//long momentumNext;
//int inertia;
//boolean shock;

boolean upsideDown;
long upsideDownStart;
long lastAccelerometer;

void setup() {
  if (DEBUG) {
    Serial.begin(115200);
  }
  pinMode(PILOT_PIN, OUTPUT);
  pinMode(CHARGE_PIN, INPUT_PULLUP);
  initDisplay();
  clearDisplay();
  updateDisplay();
  initComm();
  initAccelerometer();
  initSensors();
  updateSensors();
  initMotor();
  setBrightness(brightness);
  data = "@400z00teleobjects";
  //  data = menuCommands[8];
  parse();
  //  mode = RANDOM;
  click(STRONG_BUZZ);
}

void loop() {
  //  digitalWrite(PILOT_PIN, LOW);// buffering ? HIGH : LOW);
  updateComm();
  rx();
  if (mode == SPECTRUM) return;
  updateTimer();
  accelerometer();
  checkGestures();
  battery();
  //  if (voltage < lowBat && !charging) {
  //    mode = BATTERY;
  //  } else {

  //    if (!buffering && !busy && responses <= 3) {
  //      if (responses > 1) {
  //        tx();
  //      }
  //      responses ++;
  //    }
  //  }
  play();
}


