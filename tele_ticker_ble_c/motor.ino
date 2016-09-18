


void initMotor() {
  mot.begin();
  mot.selectLibrary(1);
  mot.setMode(DRV2605_MODE_INTTRIG);
}

void click(int thisMode) {
//  mot.setWaveform(0, 84); 
  mot.setWaveform(0, thisMode);
  mot.setWaveform(1, 0);   
  mot.go();
}
