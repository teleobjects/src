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
#define RANDOM 25
#define CLOCK 26
#define WAIT 50
#define BRIGHTNESS 51

#define FONT 60
#define REST 100

#include "Adafruit_LEDBackpack.h"
#include "Adafruit_GFX.h"
#include "Fonts/FreeMono9pt7b.h";
#include "Fonts/FreeSansBold12pt7b.h";
#include "Fonts/FreeSansBold18pt7b.h";
#include "Adafruit_BLE.h"
//#include "Adafruit_BluefruitLE_SPI.h"
#include "Adafruit_BluefruitLE_UART.h"

#include "Fonts/TomThumb.h";

#define BUF_SIZE                       256
#define VERBOSE_MODE                   false
#define FACTORYRESET_ENABLE         1
#define MINIMUM_FIRMWARE_VERSION    "0.6.6"
#define MODE_LED_BEHAVIOUR          "BLEUART"
#define POWER_LEVEL 4
#define BLUEFRUIT_UART_MODE_PIN        12    // Set to -1 if unused
#define BLUEFRUIT_HWSERIAL_NAME        Serial1

Adafruit_BluefruitLE_UART ble(BLUEFRUIT_HWSERIAL_NAME, BLUEFRUIT_UART_MODE_PIN);

// PINS

static const uint8_t PROGMEM
smile_bmp[] =
{ B00111100,
  B01000010,
  B10100101,
  B10000001,
  B10100101,
  B10011001,
  B01000010,
  B00111100
},
neutral_bmp[] =
{ B00111100,
  B01000010,
  B10100101,
  B10000001,
  B10111101,
  B10000001,
  B01000010,
  B00111100
},
frown_bmp[] =
{ B00111100,
  B01000010,
  B10100101,
  B10000001,
  B10011001,
  B10100101,
  B01000010,
  B00111100
};


#define PILOT_PIN 13
#define BAT_PIN A7
#define CHARGE_PIN A0

// COMM

#define PACKETIN 6
#define PACKETOUT 11
#define DEBUG true

#define BUF_SIZE  256   // Size of the read buffer for incoming data
#define PACKETOUT 11
#define PACKETIN 6
#define NUM 16
#define WIDTH 64

int responses;
byte byteOut [PACKETOUT];
char charOut [PACKETOUT + 1];
char charIn [BUF_SIZE];
int charIndex = 0;
String data;
byte packet = 0;
byte tack = 1, teck = 1, tick = 1, tock = 1, tuck = 1;
long lastTx;
long lastRx;
int txSpeed = 300;
int timeOut = 1000;

boolean busy = false;

boolean connecting = true;
boolean connected = false;
boolean buffering = false;

int mode = CLOCK;

//// BATTERY
long lastBattery;
float measuredvbat;
int minBat = 320;
int maxBat = 419;
boolean charging, lastCharging;
int voltage;
//char voltageBuffer[4];
int batIndex;
int batLong = 10;
long lastBat;
int refreshBat;
int chargingX;
long chargingNext;
int chargingSpeed = 150;

// DISPLAY
//int alphabetX = 0;
int cX, cursorY, breakX, lastX, firstX;
String dis[2];
//int tempX;
//long airportNext;
//int airportSpeed = 100;
long lastTick;

// FONTS
byte fontSize = 1;
byte font = 0;

Adafruit_8x8matrix matrix[] = {
  Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix(),
  Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix(),
  Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix(),
  Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix(), Adafruit_8x8matrix()
};

void setup() {
  pinMode(PILOT_PIN, OUTPUT);
  pinMode(CHARGE_PIN, INPUT_PULLUP);
  data.reserve(BUF_SIZE);
  initDisplay();
  initComm();
  if (DEBUG) {
    Serial.begin(115200);
  }
//  tack = 1;
//  teck = 2;
//  tick = 3;
//  tock = 4;
  data = "400z00teleobjects";
  parse();
}

void loop() {
  rx();
  if (connecting) {
    updateComm();
  }
  battery();
  if (!busy && mode != LOOK && mode != SLEEP && mode != STREAM) {
    if (responses < 3) {
      tx();
    }
  }
  play();

}
