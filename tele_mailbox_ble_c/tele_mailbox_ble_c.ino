#include <SPI.h>
#include <SD.h>
#include <FTOLED.h>
#include <Servo.h>

// PINS

#define DC_PIN 6
#define RESET_PIN 9
#define CS_PIN 10
#define SD_CS_PIN 11
#define SERVO_PIN 5
#define PILOT_PIN 13
#define BAT_PIN A7
#define CHARGE_PIN A0

// BLUEFRUIT

#include "Adafruit_BLE.h"
#include "Adafruit_BluefruitLE_SPI.h"
#include "Adafruit_BluefruitLE_UART.h"

#define BUF_SIZE                       256
#define VERBOSE_MODE                   false
#define BLUEFRUIT_SPI_CS               8
#define BLUEFRUIT_SPI_IRQ              7
#define BLUEFRUIT_SPI_RST              4
#define FACTORYRESET_ENABLE            1
#define MINIMUM_FIRMWARE_VERSION      "0.6.6"
#define MODE_LED_BEHAVIOUR            "BLEUART"
#define POWER_LEVEL 4

Adafruit_BluefruitLE_SPI ble(BLUEFRUIT_SPI_CS, BLUEFRUIT_SPI_IRQ, BLUEFRUIT_SPI_RST);

// SD CARD

#define MSG_NOSD F("SD card missing")
#define MSG_SKIP F("File not found")

// BATTERY

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

// DISPLAY

boolean gradient = false;
const byte WIDTH = 128;
const byte HEIGHT = 128;
OLED oled(CS_PIN, DC_PIN, RESET_PIN);
OLED_TextBox text(oled);
OLED_Colour background, foreground;
int font = 0;

// FONTS

#include <fonts/System5x7.h>
#include <fonts/Com8x8.h>
#include <fonts/Font10x14_.h>
#include <fonts/Font20x28_.h>
#include <fonts/Arial_14.h>
#include <fonts/Arial_Bold_14.h>
#include <fonts/Arial_Black_16.h>

const uint8_t *fonts[] = {System5x7, Com8x8, Font10x14_, Font20x28_, Arial_14, Arial_Bold_14, Arial_Black_16};
const uint8_t widths[] = {6, 8, 12, 22, 9, 9, 16};
const uint8_t heights[] = {8, 8, 16, 30, 14, 14, 16};
const uint8_t firsts[] = {32, 0, 32, 48, 32, 32, 32};

// SERVO

Servo servo;

byte servoMin = 15;
byte servoMax = 180;


// COMM

int responses;

String data, str;
byte screen[2048];
#define PACKETIN 6
#define PACKETOUT 11

byte byteOut [PACKETOUT];
char charOut [PACKETOUT + 1];
char charIn [BUF_SIZE];
int charIndex = 0;
//String data, dis;
byte packet = 0;
byte tack = 1, teck = 1, tick = 1, tock = 1, tuck = 1;
long lastTx;
long lastRx;
int txSpeed = 300;
int timeOut = 500;
boolean busy;
boolean connecting = true;
boolean connected = false;
boolean buffering = false;

// MODES



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
#define FONT 52


#define FOREGROUND 61
#define BACKGROUND 62
#define STRING 63
#define SYMBOL 64
#define BITMAP 65
#define DIGIT 66
#define CHARTABLE 67
#define DIRECTORY 69
#define SERVO 70
#define GRID 71
#define GRADIENT 72
#define COPY_PIXELS 73
#define COPY_BYTES 74
#define COPY_GRADIENT 75
#define REFRESH 76

//#define BRIGHTNESS 51
//#define FONT 52


#define DEBUG true

int mode;

void setup()
{
  pinMode(PILOT_PIN, OUTPUT);
  pinMode(CHARGE_PIN, INPUT_PULLUP);
  data.reserve(2048 + 5 + 1);
  if (DEBUG) {
    Serial.begin(115200);
  }
  servo.attach(SERVO_PIN);
  printServo(servoMin);
  //  oled.begin();
  foreground = WHITE;
  background = RED;
  gradient = false;
  oled.selectFont(System5x7);
  //  screen.reserve(1024);// = new byte[256];
  //  while (!SD.begin(SD_CS_PIN)) {
  //    Serial.println(MSG_NOSD);
  //    text.println(MSG_NOSD);
  //    delay(500);
  //  }
  oled.begin();
  text.setForegroundColour(foreground);
  text.setBackgroundColour(background);
  oled.fillScreen(background);
  //  printDirectory("");
  //  while (true) {
  //    long ping = millis();
  //    oled.fillScreen(BLACK);
  //    printBitmap("ICON/MAILBOX.BMP", 0, 0);
  //    oled.fillScreen(BLACK);
  //    Serial.println(millis()-ping);
  //    delay(1000);
  //  }
  //  printGrid();
  initComm();
  printFont(5);
  printString("teleobjects", false, true, 1, 64 + 6);
}

void loop() {
  rx();
  if (!buffering) {
    if (connecting) {
      updateComm();
    }
    battery();
    //    accelerometer();
    //    if (!busy) {
    if (responses < 3) {
      tx();
    }
    //    }
    //    play();
  }
}

