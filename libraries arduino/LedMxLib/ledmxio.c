/*--------------------------------------------------------------------------
File   : ledmxio.c

Author : Hoang Nguyen Hoan          Aug. 15, 2013

Desc   : This is platform specific I/O control interface for LED Matrix Control

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
Modified by          Date              Description

----------------------------------------------------------------------------*/
#include "ardledmxio.h"
//#include "delay.h"

typedef struct {
//  int  EnPin;
  int  WrPin;
  int  RdPin;
  int  DataPin;
  int  EnPin;
  int  CsPins[LEDMX_MAX_ADDRPIN];
  int  NbCsPins;				// Total number of CS pins used
  LEDMX_CSTYPE CsType;
} IODEV;

IODEV g_IODev;

void LedMxIOInit(LEDMXDEV *pLedMxDev, LEDMXCFG *pCfg)
{
    int i;
    IODEV *pdev = &g_IODev;
    LEDMXIOCFG *pcfg = (LEDMXIOCFG *)pCfg->pIOCfg;

    pLedMxDev->pIODev = (void *)&g_IODev;

    pdev->WrPin = pcfg->WrPin;
    pinMode(pdev->WrPin, OUTPUT);
    digitalWrite(pdev->WrPin, HIGH);
 
    pdev->RdPin = pcfg->RdPin;
    pinMode(pdev->RdPin, OUTPUT);
    digitalWrite(pdev->RdPin, HIGH);

    pdev->DataPin = pcfg->DataPin;
    pinMode(pdev->DataPin, OUTPUT);
    digitalWrite(pdev->DataPin, HIGH);
    
    pdev->EnPin = pcfg->EnPin;
    pinMode(pdev->EnPin, OUTPUT);
    digitalWrite(pdev->EnPin, HIGH);

    pdev->CsType = pcfg->CsType;
    
    for (i = 0; i < LEDMX_MAX_ADDRPIN; i++)
    {
        pdev->CsPins[i] = pcfg->CsPins[i];
        if (pdev->CsPins[i] >= 0)
        {
            pinMode(pdev->CsPins[i], OUTPUT);            
            digitalWrite(pdev->CsPins[i], LOW);
        }
    }

/*
  for (int i = 0; i < LEDMX_MAX_ADDRPIN; i++)
	{
		if (pcfg->CsPorts[i] >= 0)
		{
			IOPinConfig(pcfg->CsPorts[i], pcfg->CsPins[i], 0, IOPIN_RES_PULLUP, IOPIN_MODE_NORMAL);
			pdev->pCsPorts[i] = &LPC_GPIO0[pcfg->CsPorts[i]];
			pdev->CsPins[i] = 1 << pcfg->CsPins[i];
			((LPC_GPIO_TypeDef *)(pdev->pCsPorts[i]))->FIODIR |= pdev->CsPins[i];

			if (pdev->CsType == LEDMX_CSTYPE_BIN)
				((LPC_GPIO_TypeDef *)(pdev->pCsPorts[i]))->FIOCLR = pdev->CsPins[i];
			else
				((LPC_GPIO_TypeDef *)(pdev->pCsPorts[i]))->FIOSET = pdev->CsPins[i];
		}
	}
*/
	pdev->NbCsPins = pcfg->NbCsPins;
}

void LedMxStartTx(LEDMXDEV *pLedMxDev, int PanelAddr)
{
  	int i;
  	IODEV *pdev = (IODEV *)pLedMxDev->pIODev;

  	// Make sure all R/W stopped & CS disabled
  	digitalWrite(pdev->RdPin, HIGH);
  	digitalWrite(pdev->WrPin, HIGH);
  
  	if (pdev->CsType == LEDMX_CSTYPE_BIN)
  	{
      	digitalWrite(pdev->EnPin, HIGH);
      	for (i = 0; i < pdev->NbCsPins; i++)
      	{
          	if (pdev->CsPins[i] >= 0)
          	{
              	if (PanelAddr & 1)
                  	digitalWrite(pdev->CsPins[i], HIGH);
              	else
                  	digitalWrite(pdev->CsPins[i], LOW);                  
          	}
          	PanelAddr >>= 1;
      	}
      	digitalWrite(pdev->EnPin, LOW);      
  	}
  	else
  	{
      	digitalWrite(pdev->CsPins[PanelAddr], LOW);
      
  	}
  	
  //delay(2);
}

void LedMxTxData(LEDMXDEV *pLedMxDev, uint32_t Data, int NbBits)
{
  	uint32_t mask = 1 << (NbBits - 1);
  	IODEV *pdev = (IODEV *)pLedMxDev->pIODev;

  	while (mask)
  	{
    	digitalWrite(pdev->WrPin, LOW);
    	if (Data & mask)
			digitalWrite(pdev->DataPin, 1);
    	else
			digitalWrite(pdev->DataPin, 0);

    	digitalWrite(pdev->WrPin, HIGH);
    	mask >>= 1;
  	}
}

void LedMxStopTx(LEDMXDEV *pLedMxDev, int PanelAddr)
{
  	int i;
  	IODEV *pdev = (IODEV *)pLedMxDev->pIODev;

  	digitalWrite(pdev->WrPin, HIGH);

  	if (pdev->CsType == LEDMX_CSTYPE_BIN)
  	{
    	digitalWrite(pdev->EnPin, HIGH);
  	}
  	else
      	digitalWrite(pdev->CsPins[PanelAddr], HIGH);
}



