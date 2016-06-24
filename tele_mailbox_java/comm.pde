// PROTOCOL
int packetLength = 14;
int headerLength = 4;
int missedPackets = 0;
int packetIn = 1, packetOut = 1;
long lastTx, lastRx;
int txSpeed = 100;

//int displayMode, tick, tock;

// SENSOR


float sens = 1;
float ax, ay, az;
float fx, fy, fz;
boolean shock, busy;
int mm;
float battery;
int txR;
int rxR;