

#include <inttypes.h>
#include <avr/pgmspace.h>



#include <inttypes.h>

#ifndef FIXEDNUMS7X15__H
#define FIXEDNUMS7X15__H
#define FIXEDNUMS7X15__WIDTH 7
#define FIXEDNUMS7X15__HEIGHT 15

 static uint8_t fixednums7x15_[] PROGMEM = {
    0x0, 0x0,	// size of zero indicates fixed width font
    7,		// width
    15,		// height
    '+',	// first char (48)
    16,		// char count
    // font data

// font data
0x00, 0x80, 0x80, 0xE0, 0xE0, 0x80, 0x80, 0x00, 0x00, 0x00, 0x03, 0x03, 0x00, 0x00,  // 
0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x58, 0x38, 0x00, 0x00,  // 
0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x80, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,  // 
0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x30, 0x30, 0x00, 0x00,  // 
0x00, 0x00, 0x00, 0xC0, 0xF0, 0x3C, 0x0F, 0x00, 0x3C, 0x0F, 0x03, 0x00, 0x00, 0x00,  // 
0xFC, 0xFE, 0x03, 0xE1, 0x1B, 0xFE, 0xFC, 0x0F, 0x1F, 0x36, 0x21, 0x30, 0x1F, 0x0F,  // 
0x04, 0x04, 0x06, 0xFF, 0xFF, 0x00, 0x00, 0x20, 0x20, 0x20, 0x3F, 0x3F, 0x20, 0x20,  // 
0x0C, 0x0E, 0x03, 0x01, 0x81, 0xFE, 0x7C, 0x38, 0x3C, 0x26, 0x23, 0x21, 0x20, 0x20,  // 
0x0C, 0x0E, 0x43, 0x41, 0x43, 0xFE, 0xBC, 0x0C, 0x1C, 0x30, 0x20, 0x30, 0x1F, 0x0F,  // 
0x00, 0xE0, 0xFC, 0x1F, 0x83, 0x80, 0x00, 0x0F, 0x0F, 0x08, 0x08, 0x3F, 0x3F, 0x08,  // 
0x3F, 0x3F, 0x21, 0x21, 0x61, 0xE1, 0x81, 0x0C, 0x1C, 0x30, 0x20, 0x30, 0x3F, 0x0F,  // 

0xE0, 0xF8, 0x5C, 0x46, 0xC3, 0xC1, 0x01, 0x0F, 0x1F, 0x30, 0x20, 0x30, 0x3F, 0x0F,  // 
0x01, 0x01, 0x01, 0x81, 0xF1, 0x7F, 0x0F, 0x00, 0x00, 0x3C, 0x3F, 0x03, 0x00, 0x00,  // 
0x1C, 0xBE, 0xE3, 0x41, 0xE3, 0xBE, 0x1C, 0x0F, 0x1F, 0x30, 0x20, 0x30, 0x1F, 0x0F,  // 
0x3C, 0x7E, 0xC3, 0x81, 0x81, 0xFE, 0xFC, 0x20, 0x30, 0x38, 0x0C, 0x07, 0x03, 0x00,  // 
0x00, 0x00, 0x00, 0x60, 0x60, 0x00, 0x00, 0x00, 0x00, 0x00, 0x30, 0x30, 0x00, 0x00,  // 
};
#endif
