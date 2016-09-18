#include <Arduino.h>
#include <Adafruit_LEDBackpack.h>
#include <Adafruit_GFX.h>
#include <Adafruit_BLE.h>
#include <Adafruit_BluefruitLE_UART.h>

#include <Fonts/TomThumb.h>
#include <Fonts/FreeSans9pt7b.h>
#include <Fonts/FreeSans12pt7b.h>
#include <Fonts/FreeSansBold9pt7b.h>
#include <Fonts/FreeSansBold12pt7b.h>
#include <Fonts/FreeSansBold18pt7b.h>

// MODES

#define BLANK 1
#define CENTERED 2
#define INSTANT 3
#define TICKER 4
//#define SCROLL 5
#define SCROLL_ALL_RIGHT 6
#define SCROLL_CENTER_RIGHT 7
#define SCROLL_PUSH_RIGHT 8
#define SCROLL_ALL_LEFT 9
#define SCROLL_CENTER_LEFT 10
#define SCROLL_PUSH_LEFT 11
#define SLEEP 12
#define AIRPORT 13
#define COMPASS 16
#define BATTERY 17 // A
#define AXIS 18 // B
#define ALPHABET 19  // C
#define EXTRA // D
#define STREAM 21  // E
#define BALL 22 // F
#define RAIN 23  // G
#define SNOW 24 // H
#define RANDOM 25 // I
#define CLOCK 26 // J
#define COUNTER 27 // K
#define SPECTRUM 28 // L
#define NOISE 29 // M
#define WAIT 50
#define BRIGHTNESS 51
#define FONT 52
#define PING 54
#define LOOK 55

#define SCROLL_DOWN 56
#define SCROLL_UP 57

// PINS

#define BAT_PIN A7
#define CHARGE_PIN A0

// BLUEFRUIT

#define VERBOSE_MODE                false
#define FACTORYRESET_ENABLE         1
#define MINIMUM_FIRMWARE_VERSION    "0.6.6"
#define MODE_LED_BEHAVIOUR          "BLEUART"
#define POWER_LEVEL                  4
#define BLUEFRUIT_UART_MODE_PIN      12
#define BLUEFRUIT_HWSERIAL_NAME      Serial1

Adafruit_BluefruitLE_UART ble(BLUEFRUIT_HWSERIAL_NAME, BLUEFRUIT_UART_MODE_PIN);

// DISPLAY

Adafruit_8x8matrix matrix[] = {
  Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix(),
  Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix(),
  Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix(),
  Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix()
};

// BATTERY

int minBat = 320;
int maxBat = 425;
boolean charging, lastCharging;
int voltage;
char voltageBuffer[4];
int batIndex;
int batLong = 10;
int refreshBat;
int chargingX;
long chargingNext;
int chargingSpeed = 150;
long lastBattery;

// COMM

#define BUF_SIZE  256
#define PACKETOUT 11
#define PACKETIN 6
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
int timeOut = 1000;
int mode, lastMode;

// DISPLAY

#define NUM 16
#define WIDTH 64

int cursorX, cursorY, cursorL;

int breakX, lastX, firstX;
long lastTick;
int brightness = 1;
int brightnessIndex;
byte tack = 1, teck = 1, tick = 1, tock = 1, tuck = 1;
String dis[2] = {"", ""};
boolean deleteCursor;
int tcL, tcX, tcY;

// TIMER

int timer[6] = {0, 0, 0, 0, 0, 0};
int lastTimer[6] = {0, 0, 0, 0, 0, 0};
int timerY[6] = {0, 0, 0, 0, 0, 0};
int timerX[6];
int nextTime;
boolean postMeridiam;
boolean clock24 = false;

// FONTS

byte fontSize = 1;
byte font = 0;

String data, tmp;

void setup() {
  pinMode(CHARGE_PIN, INPUT_PULLUP);
  randomSeed(analogRead(BAT_PIN));
  //    data.reserve(BUF_SIZE);
  initDisplay();
  initComm();
  if (DEBUG) {
    Serial.begin(115200);
  }
  //  data = "400A5AQuinnipiac University survey found that 42 percent of voters supported Mrs. Clinton while 40 percent backed Mr. Trump. It has a margin of error of plus or minus two percentage points.";
  //  data =  "J01100235952";
  //  data = "400A10Nike issued a loosely hanging, short dress for Wimbledon. But it was not exactly performance gear, several players said, and wardrobe changes have ensued.";
  data = "420z00teleobjects are ready";
  //  data = "K00100";
  //  data = "M01000";
  parse();
}

void loop() {
  //  updateComm();
  battery();
  //    if (voltage < 340 && !charging) {
  //      mode = BATTERY;
  //    }
  rx();

  if (!busy) { // !buffering
    if (!buffering) {
      if (responses < 1) {
        tx();
      }
    }
  }
  play();
}
