#include <AccelStepper.h>
#include <Wire.h>
#include <SPI.h>
#include <Adafruit_MotorShield.h>
#include "utility/Adafruit_MS_PWMServoDriver.h"
#include <Adafruit_NeoPixel.h>
#include "Adafruit_BLE.h"
#include "Adafruit_BluefruitLE_SPI.h"
#include "Adafruit_BluefruitLE_UART.h"

// PINS

#define PILOT_PIN 13
#define BAT_PIN A7
#define CHARGE_PIN A0
#define PIXEL_PIN  6

// DOTS
#define PIXEL_NUM 16

Adafruit_NeoPixel strip = Adafruit_NeoPixel(PIXEL_NUM, PIXEL_PIN, NEO_GRB + NEO_KHZ800);

uint8_t pixelColors[PIXEL_NUM][3];
byte brightness = 10;

// MOTORS
Adafruit_MotorShield AFMStop(0x60);
Adafruit_StepperMotor *myMotorR = AFMStop.getStepper(256, 1);
Adafruit_StepperMotor *myMotorL = AFMStop.getStepper(256, 2);

// you can change these to DOUBLE or INTERLEAVE or MICROSTEP!
void forwardstepR() {
  myMotorR->onestep(FORWARD, SINGLE);
}
void backwardstepR() {
  myMotorR->onestep(BACKWARD, SINGLE);
}
void forwardstepL() {
  myMotorL->onestep(FORWARD, SINGLE);
}
void backwardstepL() {
  myMotorL->onestep(BACKWARD, SINGLE);
}

AccelStepper stepperR(forwardstepR, backwardstepR);
AccelStepper stepperL(forwardstepL, backwardstepL);

// BLUEFRUIT

#define BUF_SIZE                       256
#define VERBOSE_MODE                   false
#define BLUEFRUIT_SPI_CS               8
#define BLUEFRUIT_SPI_IRQ              7
#define BLUEFRUIT_SPI_RST              4
#define FACTORYRESET_ENABLE         1
#define MINIMUM_FIRMWARE_VERSION    "0.6.6"
#define MODE_LED_BEHAVIOUR          "BLEUART"
#define POWER_LEVEL 4

Adafruit_BluefruitLE_SPI ble(BLUEFRUIT_SPI_CS, BLUEFRUIT_SPI_IRQ, BLUEFRUIT_SPI_RST);

//// BATTERY

int minBat = 320;
int maxBat = 419;
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

// COMM

#define PACKET 4
#define PACKETOUT 11
#define DEBUG true

int responses;
byte byteOut [PACKETOUT];
char charOut [PACKETOUT + 1];
char charIn [BUF_SIZE];
int charIndex = 0;
String data, dis;
byte packet = 0;
byte tack = 1, teck = 1, tick = 1, tock = 1, tuck = 1;
long lastTx;
long lastRx;
int txSpeed = 300;
int timeOut = 1000;

boolean busy;
boolean connecting = true;
boolean connected = false;
boolean buffering = false;

#define BLANK 0
#define LOOK 1
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
#define CLOCK 26
#define WAIT 50
#define BRIGHTNESS 51

#define RANDOM 1
#define STOP 2

int mode = BATTERY;

// PIXELS
int pixelX;
boolean dir;
int pixelSpeed = 5;

long lastPixelTime;

// MOTORS
int rMax, rAcc, rPos;
int lMax, lAcc, lPos;
long lastR, ampR, lastL, ampL;
long lastMotorTime;

void setup()
{
  pinMode(PILOT_PIN, OUTPUT);
  pinMode(CHARGE_PIN, INPUT_PULLUP);
  if (DEBUG) {
    Serial.begin(115200);
  }
  initComm();
  initMotors();
  strip.begin();
}

void loop()
{
  digitalWrite(PILOT_PIN, buffering ? HIGH : LOW);
  //  digitalWrite(PILOT_PIN,  millis() % 200 < 100 ? HIGH : LOW);
  rx();
  if (!buffering) {
    if (connecting) {
      updateComm();
    }
    battery();
    if (!busy) {
      if (responses < 3) {
        tx();
      }
    }
  }
  play();
  updateDots();
}

