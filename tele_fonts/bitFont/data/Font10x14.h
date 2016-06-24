#include <inttypes.h>
#ifdef __AVR__
#include <avr/pgmspace.h>
#else
#define PROGMEM
#endif
#ifndef FONT10X14_H
#define FONT10X14_H
#define FONT10X14_WIDTH 10
#define FONT10X14_HEIGHT 14
static const uint8_t Font10x14[] PROGMEM = {
0x0, 0x0, // size of zero indicates fixed witdh
0x0A, // width
0x0E, // height
0x20, // first char
0x40, // char count
// font data
0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,  //  
0x00, 0x00, 0x00, 0x00, 0xFF, 0xFF, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x33, 0x33, 0x00, 0x00, 0x00, 0x00,  // !
0x00, 0x00, 0x0F, 0x0F, 0x00, 0x00, 0x0F, 0x0F, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,  // "
0x30, 0x30, 0xFF, 0xFF, 0x30, 0x30, 0xFF, 0xFF, 0x30, 0x30, 0x03, 0x03, 0x3F, 0x3F, 0x03, 0x03, 0x3F, 0x3F, 0x03, 0x03,  // #
0x30, 0x78, 0xFC, 0xCC, 0xFF, 0xFF, 0xCC, 0xCC, 0x9C, 0x18, 0x06, 0x0E, 0x0C, 0x0C, 0x3F, 0x3F, 0x0C, 0x0F, 0x07, 0x03,  // $
0x06, 0x0F, 0x0F, 0x06, 0xC0, 0xF0, 0x3C, 0x0F, 0x03, 0x00, 0x00, 0x30, 0x3C, 0x0F, 0x03, 0x00, 0x18, 0x3C, 0x3C, 0x18,  // %
0x3C, 0xFE, 0xC3, 0xE3, 0xF3, 0x3B, 0x1E, 0x0C, 0x00, 0x00, 0x0F, 0x1F, 0x38, 0x31, 0x33, 0x37, 0x1E, 0x0C, 0x3F, 0x33,  // &
0x00, 0x00, 0x00, 0x22, 0x37, 0x1F, 0x0E, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,  // '
0x00, 0x00, 0xF0, 0xFC, 0x1E, 0x06, 0x03, 0x03, 0x00, 0x00, 0x00, 0x00, 0x03, 0x0F, 0x1E, 0x18, 0x30, 0x30, 0x00, 0x00,  // (
0x00, 0x00, 0x03, 0x03, 0x06, 0x1E, 0xFC, 0xF0, 0x00, 0x00, 0x00, 0x00, 0x30, 0x30, 0x18, 0x1E, 0x0F, 0x03, 0x00, 0x00,  // )
0x30, 0x70, 0xE0, 0xC0, 0xFC, 0xFC, 0xC0, 0xE0, 0x70, 0x30, 0x06, 0x07, 0x03, 0x01, 0x1F, 0x1F, 0x01, 0x03, 0x07, 0x06,  // *
0xC0, 0xC0, 0xC0, 0xC0, 0xFC, 0xFC, 0xC0, 0xC0, 0xC0, 0xC0, 0x00, 0x00, 0x00, 0x00, 0x0F, 0x0F, 0x00, 0x00, 0x00, 0x00,  // +
0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x22, 0x37, 0x1F, 0x0E, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,  // ,
0xC0, 0xC0, 0xC0, 0xC0, 0xC0, 0xC0, 0xC0, 0xC0, 0xC0, 0xC0, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,  // -
0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x18, 0x3C, 0x3C, 0x18, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,  // .
0x00, 0x00, 0x00, 0x00, 0xC0, 0xF0, 0x3C, 0x0F, 0x03, 0x00, 0x00, 0x30, 0x3C, 0x0F, 0x03, 0x00, 0x00, 0x00, 0x00, 0x00,  // /
0xFC, 0xFE, 0x07, 0x83, 0xC3, 0xE3, 0x73, 0x3F, 0xFE, 0xFC, 0x0F, 0x1F, 0x3F, 0x33, 0x31, 0x30, 0x30, 0x38, 0x1F, 0x0F,  // 0
0x00, 0x00, 0x0C, 0x0E, 0xFF, 0xFF, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x30, 0x30, 0x3F, 0x3F, 0x30, 0x30, 0x00, 0x00,  // 1
0x0C, 0x0E, 0x07, 0x03, 0x03, 0x83, 0xC3, 0xE7, 0x7E, 0x3C, 0x30, 0x38, 0x3C, 0x3E, 0x37, 0x33, 0x31, 0x30, 0x30, 0x30,  // 2
0x0C, 0x0E, 0x07, 0x03, 0x03, 0xC3, 0xC3, 0xC7, 0xFE, 0x3C, 0x0C, 0x1C, 0x38, 0x30, 0x30, 0x30, 0x30, 0x38, 0x1F, 0x0F,  // 3
0xC0, 0xE0, 0x70, 0x38, 0x1C, 0x0E, 0xFF, 0xFF, 0x00, 0x00, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x3F, 0x3F, 0x03, 0x03,  // 4
0x3F, 0x3F, 0x33, 0x33, 0x33, 0x33, 0x33, 0x73, 0xE3, 0xC3, 0x0C, 0x1C, 0x38, 0x30, 0x30, 0x30, 0x30, 0x38, 0x1F, 0x0F,  // 5
0xFC, 0xFE, 0xC7, 0xC3, 0xC3, 0xC3, 0xC3, 0xC7, 0x8E, 0x0C, 0x0F, 0x1F, 0x38, 0x30, 0x30, 0x30, 0x30, 0x39, 0x1F, 0x0F,  // 6
0x03, 0x03, 0x03, 0x03, 0xC3, 0xE3, 0x73, 0x3B, 0x1F, 0x0F, 0x00, 0x00, 0x00, 0x00, 0x3F, 0x3F, 0x00, 0x00, 0x00, 0x00,  // 7
0x3C, 0xFE, 0xE7, 0xC3, 0xC3, 0xC3, 0xC3, 0xE7, 0xFE, 0x3C, 0x0F, 0x1F, 0x39, 0x30, 0x30, 0x30, 0x30, 0x39, 0x1F, 0x0F,  // 8
0x3C, 0x7E, 0xE7, 0xC3, 0xC3, 0xC3, 0xC3, 0xE7, 0xFE, 0xFC, 0x00, 0x00, 0x30, 0x30, 0x38, 0x1C, 0x0E, 0x07, 0x03, 0x01,  // 9
0x00, 0x00, 0x00, 0x18, 0x3C, 0x3C, 0x18, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x06, 0x0F, 0x0F, 0x06, 0x00, 0x00, 0x00,  // :
0x00, 0x00, 0x00, 0x18, 0x3C, 0x3C, 0x18, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x22, 0x37, 0x1F, 0x0E, 0x00, 0x00, 0x00,  // ;
0x00, 0xC0, 0xE0, 0xF0, 0x38, 0x1C, 0x0E, 0x07, 0x03, 0x00, 0x00, 0x00, 0x01, 0x03, 0x07, 0x0E, 0x1C, 0x38, 0x30, 0x00,  // <
0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03,  // =
0x00, 0x03, 0x07, 0x0E, 0x1C, 0x38, 0xF0, 0xE0, 0xC0, 0x00, 0x00, 0x30, 0x38, 0x1C, 0x0E, 0x07, 0x03, 0x01, 0x00, 0x00,  // >
0x0C, 0x0E, 0x07, 0x03, 0x83, 0xC3, 0xC3, 0x67, 0x7E, 0x3C, 0x00, 0x00, 0x00, 0x00, 0x37, 0x37, 0x00, 0x00, 0x00, 0x00,  // ?
0x0C, 0x8E, 0xC7, 0xC3, 0xC3, 0xC3, 0x03, 0x07, 0xFE, 0xFC, 0x0F, 0x1F, 0x39, 0x30, 0x3F, 0x3F, 0x30, 0x38, 0x1F, 0x0F,  // @
0xFC, 0xFE, 0x07, 0x03, 0x03, 0x03, 0x03, 0x07, 0xFE, 0xFC, 0x3F, 0x3F, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x3F, 0x3F,  // A
0xFF, 0xFF, 0xC3, 0xC3, 0xC3, 0xC3, 0xC3, 0xE7, 0xFE, 0x3C, 0x3F, 0x3F, 0x30, 0x30, 0x30, 0x30, 0x30, 0x39, 0x1F, 0x0F,  // B
0xFC, 0xFE, 0x07, 0x03, 0x03, 0x03, 0x03, 0x07, 0x0E, 0x0C, 0x0F, 0x1F, 0x38, 0x30, 0x30, 0x30, 0x30, 0x38, 0x1C, 0x0C,  // C
0xFF, 0xFF, 0x03, 0x03, 0x03, 0x03, 0x03, 0x07, 0xFE, 0xFC, 0x3F, 0x3F, 0x30, 0x30, 0x30, 0x30, 0x30, 0x38, 0x1F, 0x0F,  // D
0xFF, 0xFF, 0xC3, 0xC3, 0xC3, 0xC3, 0xC3, 0xC3, 0x03, 0x03, 0x3F, 0x3F, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30,  // E
0xFF, 0xFF, 0xC3, 0xC3, 0xC3, 0xC3, 0xC3, 0xC3, 0x03, 0x03, 0x3F, 0x3F, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,  // F
0xFC, 0xFE, 0x07, 0x03, 0x03, 0xC3, 0xC3, 0xC7, 0xCE, 0xCC, 0x0F, 0x1F, 0x38, 0x30, 0x30, 0x30, 0x30, 0x38, 0x1F, 0x0F,  // G
0xFF, 0xFF, 0xC0, 0xC0, 0xC0, 0xC0, 0xC0, 0xC0, 0xFF, 0xFF, 0x3F, 0x3F, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x3F, 0x3F,  // H
0x00, 0x00, 0x03, 0x03, 0xFF, 0xFF, 0x03, 0x03, 0x00, 0x00, 0x00, 0x00, 0x30, 0x30, 0x3F, 0x3F, 0x30, 0x30, 0x00, 0x00,  // I
0x00, 0x00, 0x03, 0x03, 0x03, 0x03, 0xFF, 0xFF, 0x03, 0x03, 0x0C, 0x1C, 0x38, 0x30, 0x30, 0x38, 0x1F, 0x0F, 0x00, 0x00,  // J
0xFF, 0xFF, 0xE0, 0xE0, 0xF0, 0x38, 0x1C, 0x0E, 0x07, 0x03, 0x3F, 0x3F, 0x01, 0x01, 0x03, 0x07, 0x0E, 0x1C, 0x38, 0x30,  // K
0xFF, 0xFF, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x3F, 0x3F, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30,  // L
0xFF, 0xFF, 0x0E, 0x1C, 0xF8, 0xF8, 0x1C, 0x0E, 0xFF, 0xFF, 0x3F, 0x3F, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x3F, 0x3F,  // M
0xFF, 0xFF, 0x38, 0x70, 0xE0, 0xC0, 0x80, 0x00, 0xFF, 0xFF, 0x3F, 0x3F, 0x00, 0x00, 0x00, 0x01, 0x03, 0x07, 0x3F, 0x3F,  // N
0xFC, 0xFE, 0x07, 0x03, 0x03, 0x03, 0x03, 0x07, 0xFE, 0xFC, 0x0F, 0x1F, 0x38, 0x30, 0x30, 0x30, 0x30, 0x38, 0x1F, 0x0F,  // O
0xFF, 0xFF, 0xC3, 0xC3, 0xC3, 0xC3, 0xC3, 0xE7, 0x7E, 0x3C, 0x3F, 0x3F, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,  // P
0xFC, 0xFE, 0x07, 0x03, 0x03, 0x03, 0x03, 0x07, 0xFE, 0xFC, 0x0F, 0x1F, 0x38, 0x30, 0x33, 0x37, 0x3E, 0x1C, 0x3F, 0x37,  // Q
0xFF, 0xFF, 0xC3, 0xC3, 0xC3, 0xC3, 0xC3, 0xE7, 0x7E, 0x3C, 0x3F, 0x3F, 0x00, 0x01, 0x01, 0x03, 0x03, 0x0E, 0x3C, 0x38,  // R
0x3C, 0x7E, 0xE7, 0xC3, 0xC3, 0xC3, 0xC3, 0xC3, 0x87, 0x06, 0x18, 0x38, 0x30, 0x30, 0x30, 0x30, 0x30, 0x39, 0x1F, 0x0F,  // S
0x03, 0x03, 0x03, 0x03, 0xFF, 0xFF, 0x03, 0x03, 0x03, 0x03, 0x00, 0x00, 0x00, 0x00, 0x3F, 0x3F, 0x00, 0x00, 0x00, 0x00,  // T
0xFF, 0xFF, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xFF, 0xFF, 0x0F, 0x1F, 0x38, 0x30, 0x30, 0x30, 0x30, 0x38, 0x1F, 0x0F,  // U
0xFF, 0xFF, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xFF, 0xFF, 0x03, 0x07, 0x0E, 0x1C, 0x38, 0x38, 0x1C, 0x0E, 0x07, 0x03,  // V
0xFF, 0xFF, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xFF, 0xFF, 0x0F, 0x1F, 0x38, 0x3C, 0x1F, 0x1F, 0x3C, 0x38, 0x1F, 0x0F,  // W
0x0F, 0x1F, 0x38, 0xF0, 0xE0, 0xE0, 0xF0, 0x38, 0x1F, 0x0F, 0x3C, 0x3E, 0x07, 0x03, 0x01, 0x01, 0x03, 0x07, 0x3E, 0x3C,  // X
0x3F, 0x7F, 0xE0, 0xC0, 0x80, 0x80, 0xC0, 0xE0, 0x7F, 0x3F, 0x00, 0x00, 0x00, 0x01, 0x3F, 0x3F, 0x01, 0x00, 0x00, 0x00,  // Y
0x03, 0x03, 0x03, 0x83, 0xC3, 0xE3, 0x73, 0x3B, 0x1F, 0x0F, 0x3C, 0x3E, 0x37, 0x33, 0x31, 0x30, 0x30, 0x30, 0x30, 0x30,  // Z
0x00, 0x00, 0xFF, 0xFF, 0x03, 0x03, 0x03, 0x00, 0x00, 0x00, 0x00, 0x00, 0x3F, 0x3F, 0x30, 0x30, 0x30, 0x00, 0x00, 0x00,  // [
0x0C, 0x0C, 0x30, 0x30, 0xC0, 0xC0, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x03, 0x03, 0x0C, 0x0C,  // \
0x00, 0x00, 0x03, 0x03, 0x03, 0xFF, 0xFF, 0x00, 0x00, 0x00, 0x00, 0x00, 0x30, 0x30, 0x30, 0x3F, 0x3F, 0x00, 0x00, 0x00,  // ]
0x30, 0x38, 0x1C, 0x0E, 0x07, 0x07, 0x0E, 0x1C, 0x38, 0x30, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,  // ^
0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30,  // _
0x00, 0x00, 0x03, 0x07, 0x0E, 0x1C, 0x18, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,  // `
0x00, 0x60, 0x70, 0x30, 0x30, 0x30, 0x30, 0x70, 0xE0, 0xC0, 0x0C, 0x1E, 0x3F, 0x33, 0x33, 0x33, 0x33, 0x33, 0x3F, 0x1F,  // a
0xFF, 0xFF, 0xC0, 0xC0, 0xC0, 0xC0, 0xC0, 0xC0, 0x80, 0x00, 0x3F, 0x3F, 0x30, 0x30, 0x30, 0x30, 0x30, 0x39, 0x1F, 0x0F,  // b
0xC0, 0xE0, 0x70, 0x30, 0x30, 0x30, 0x30, 0x70, 0xE0, 0xC0, 0x0F, 0x1F, 0x38, 0x30, 0x30, 0x30, 0x30, 0x38, 0x1C, 0x0C,  // c
0x00, 0x80, 0xC0, 0xC0, 0xC0, 0xC0, 0xC0, 0xC0, 0xFF, 0xFF, 0x0F, 0x1F, 0x39, 0x30, 0x30, 0x30, 0x30, 0x30, 0x3F, 0x3F,  // d
0xC0, 0xE0, 0x70, 0x30, 0x30, 0x30, 0x30, 0x70, 0xE0, 0xC0, 0x0F, 0x1F, 0x3B, 0x33, 0x33, 0x33, 0x33, 0x3B, 0x1B, 0x09,  // e
0x00, 0xC0, 0xFC, 0xFE, 0xC7, 0xC7, 0x0E, 0x0C, 0x00, 0x00, 0x00, 0x00, 0x3F, 0x3F, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,  // f
0xC0, 0xE0, 0xF0, 0x30, 0x30, 0x30, 0x30, 0x30, 0xF0, 0xE0, 0x18, 0x39, 0x33, 0x33, 0x33, 0x33, 0x33, 0x3B, 0x1F, 0x0F,  // g
0xFF, 0xFF, 0xC0, 0xC0, 0xC0, 0xC0, 0xC0, 0x80, 0x00, 0x00, 0x3F, 0x3F, 0x00, 0x00, 0x00, 0x00, 0x01, 0x3F, 0x3F, 0x00,  // h
0x00, 0x00, 0x00, 0x00, 0xD8, 0xD8, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x3F, 0x3F, 0x00, 0x00, 0x00, 0x00,  // i
0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xF3, 0xF3, 0x00, 0x00, 0x0C, 0x1C, 0x38, 0x30, 0x30, 0x38, 0x1F, 0x0F, 0x00,  // j
0x00, 0xFF, 0xFF, 0x00, 0x80, 0xC0, 0xE0, 0x70, 0x30, 0x00, 0x00, 0x3F, 0x3F, 0x07, 0x07, 0x0F, 0x1C, 0x38, 0x30, 0x00,  // k
0x00, 0x00, 0x03, 0x03, 0xFF, 0xFF, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x30, 0x30, 0x3F, 0x3F, 0x30, 0x30, 0x00, 0x00,  // l
0xF0, 0xF0, 0x70, 0xE0, 0xC0, 0xC0, 0xE0, 0x70, 0xF0, 0xF0, 0x3F, 0x3F, 0x00, 0x00, 0x03, 0x03, 0x00, 0x00, 0x3F, 0x3F,  // m
0xF0, 0xF0, 0xC0, 0xE0, 0x70, 0x30, 0x30, 0x70, 0xE0, 0xC0, 0x3F, 0x3F, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x3F, 0x3F,  // n
0xC0, 0xE0, 0x70, 0x30, 0x30, 0x30, 0x30, 0x70, 0xE0, 0xC0, 0x0F, 0x1F, 0x38, 0x30, 0x30, 0x30, 0x30, 0x38, 0x1F, 0x0F,  // o
0xF0, 0xF0, 0x30, 0x30, 0x30, 0x30, 0x30, 0xF0, 0xE0, 0xC0, 0x3F, 0x3F, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x01, 0x00,  // p
0xC0, 0xE0, 0xF0, 0x30, 0x30, 0x30, 0x30, 0x30, 0xF0, 0xF0, 0x00, 0x01, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x3F, 0x3F,  // q
0xF0, 0xF0, 0xC0, 0xE0, 0x70, 0x30, 0x30, 0x70, 0xE0, 0xC0, 0x3F, 0x3F, 0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,  // r
0xC0, 0xE0, 0xF0, 0x30, 0x30, 0x30, 0x30, 0x30, 0x70, 0x60, 0x18, 0x39, 0x33, 0x33, 0x33, 0x33, 0x33, 0x3F, 0x1E, 0x0C,  // s
0x00, 0x30, 0x30, 0xFF, 0xFF, 0x30, 0x30, 0x30, 0x30, 0x00, 0x00, 0x00, 0x00, 0x0F, 0x1F, 0x38, 0x38, 0x1C, 0x0C, 0x00,  // t
0xF0, 0xF0, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xF0, 0xF0, 0x0F, 0x1F, 0x38, 0x30, 0x30, 0x30, 0x30, 0x38, 0x1F, 0x0F,  // u
0xF0, 0xF0, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xF0, 0xF0, 0x03, 0x07, 0x0E, 0x1C, 0x38, 0x38, 0x1C, 0x0E, 0x07, 0x03,  // v
0xF0, 0xF0, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0xF0, 0xF0, 0x0F, 0x1F, 0x38, 0x38, 0x1F, 0x1F, 0x38, 0x38, 0x1F, 0x0F,  // w
0x30, 0x70, 0xE0, 0xC0, 0x80, 0x80, 0xC0, 0xE0, 0x70, 0x30, 0x30, 0x38, 0x1C, 0x0F, 0x07, 0x07, 0x0F, 0x1C, 0x38, 0x30,  // x
0x30, 0x70, 0xE0, 0xC0, 0x80, 0x80, 0xC0, 0xE0, 0x70, 0x30, 0x00, 0x00, 0x30, 0x39, 0x1F, 0x0F, 0x01, 0x00, 0x00, 0x00,  // y
0x30, 0x30, 0x30, 0x30, 0x30, 0xB0, 0xF0, 0xF0, 0x70, 0x30, 0x30, 0x38, 0x3C, 0x3E, 0x37, 0x33, 0x31, 0x30, 0x30, 0x30,  // z
0x00, 0xC0, 0xE0, 0xFC, 0x3E, 0x07, 0x03, 0x03, 0x03, 0x00, 0x00, 0x00, 0x01, 0x0F, 0x1F, 0x38, 0x30, 0x30, 0x30, 0x00,  // {
0xC0, 0xC0, 0xFC, 0xFE, 0xC7, 0xC3, 0x03, 0x07, 0x0E, 0x0C, 0x30, 0x30, 0x3F, 0x3F, 0x30, 0x30, 0x30, 0x30, 0x30, 0x30,  // |
0x00, 0x03, 0x03, 0x03, 0x07, 0x3E, 0xFC, 0xE0, 0xC0, 0x00, 0x00, 0x30, 0x30, 0x30, 0x38, 0x1F, 0x0F, 0x01, 0x00, 0x00,  // }
0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x03, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,  // ~
0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,  // 
};
#endif
