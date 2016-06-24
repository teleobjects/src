/*--------------------------------------------------------------------------
File   : ardledmxio.h

Author : Hoang Nguyen Hoan          Aug. 15, 2013

Desc   : This is platform specific I/O control interface for 
         IDM-LMX3208 series LED matrix display

Copyright (c) 2011, I-SYST inc., all rights reserved

Permission to use, copy, modify, and distribute this software for any purpose
with or without fee is hereby granted, provided that the above copyright
notice and this permission notice appear in all copies, and none of the
names : I-SYST or its contributors may be used to endorse or
promote products derived from this software without specific prior written
permission.

For info or contributing contact : hnhoan at i-syst dot com

THIS SOFTWARE IS PROVIDED BY THE REGENTS AND CONTRIBUTORS ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

----------------------------------------------------------------------------
Modified by          Date           Description
Hoan				Sep. 14, 2014	Add support for IBB-LMXBLUE with 16 displays
----------------------------------------------------------------------------*/

#ifndef __LEDMXIO_H__
#define __LEDMXIO_H__

#include "Arduino.h"
#include "ledmx.h"

// LMXSHILELD pin mapping
#define LMXSHIELD_RD                    8
#define LMXSHIELD_WR                    7
#define LMXSHIELD_DATA                  6
#define LMXSHIELD_EN                    5
#define LMXSHIELD_AD3                   9	// Avail on IBB-LMXBLUE for 16 displays
#define LMXSHIELD_AD2                   4
#define LMXSHIELD_AD1                   3
#define LMXSHIELD_AD0                   2
#define LMXSHIELD_CSTYPE                LEDMX_CSTYPE_BIN


#define LEDMX_MAX_ADDRPIN		4

typedef struct _LedMxIOCfg {
  int WrPin;				// WR pin map GPIO pin #
  int RdPin;				// RD pin map GPIO pin #
  int DataPin;				// DATA pin map GPIO pin #
  int EnPin;				// Decoder enable pin map GPIO pin #
  int CsPins[LEDMX_MAX_ADDRPIN];	// CS pins map GPIO pin #s
  int NbCsPins;				// Total number of CS pins used
  LEDMX_CSTYPE CsType;
} LEDMXIOCFG;

#endif /* __LEDMXIO_H__ */
