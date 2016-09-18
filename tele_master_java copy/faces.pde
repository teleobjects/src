final int BOTTOM_EYE_LEFT = 27;
final int BOTTOM_EYE_RIGHT = 27;
final int BOTTOM_EYE_CLOSED_LEFT = 28;
final int BOTTOM_EYE_CLOSED_RIGHT = 28;

final int TOP_EYE_LEFT = 29;
final int TOP_EYE_RIGHT = 29;
final int TOP_EYE_CLOSED_LEFT = 30;
final int TOP_EYE_CLOSED_RIGHT = 30;

final int NEUTRAL_LEFT = 145;
final int NEUTRAL_RIGHT = 146;
final int WIDE_EYED_LEFT = 147;
final int WIDE_EYED_RIGHT = 148;
final int WIDE_EYED_SURPRISED_LEFT = 149;
final int WIDE_EYED_SURPRISED_RIGHT = 150;
final int SURPRISED_LEFT = 151;
final int SURPRISED_RIGHT = 152;
final int SCARED_LEFT = 153;
final int SCARED_RIGHT = 154;
final int ANGRY_LEFT = 155;
final int ANGRY_RIGHT = 156;
final int PERPLEXED_LEFT = 157;
final int PERPLEXED_RIGHT = 158;
final int HAPPY_LEFT = 159;
final int HAPPY_RIGHT = 160;
final int CRYING_LEFT = 161;
final int CRYING_RIGHT = 162;
final int EYES_CLOSED_LEFT = 163;
final int EYES_CLOSED_RIGHT = 164 ;
final int CROSS_DEAD_LEFT = 165 ;
final int CROSS_DEAD_RIGHT = 166;
final int X_DEAD_LEFT = 167;
final int X_DEAD_RIGHT = 168;

final int UNDERSCORE_LEFT = '_';
final int UNDERSCORE_RIGHT = '_';

final int DASH_LEFT = '-';
final int DASH_RIGHT = '-';

final int SWEAT_BEAD = 169;

final int bottom = 0;
final int bottom_closed = 1;
final int top = 2;
final int top_closed = 3;;
final int neutral = 4;
final int wide = 5;
final int surprised= 6;
final int scared = 7;
final int angry = 8;
final int perplexed = 9;
final int happy = 10;
final int crying = 11;
final int closed = 12;
final int cross = 13;
final int dead = 14;
final int underscore = 15;
final int dash = 16;

boolean noseFace = true;
int face = neutral;
int faceClosed = closed;

int leftEyes[] = {BOTTOM_EYE_LEFT, BOTTOM_EYE_CLOSED_LEFT, TOP_EYE_LEFT, TOP_EYE_CLOSED_LEFT, NEUTRAL_LEFT, 
WIDE_EYED_LEFT, WIDE_EYED_SURPRISED_LEFT, SURPRISED_LEFT, SCARED_LEFT, ANGRY_LEFT, PERPLEXED_LEFT, HAPPY_LEFT, 
CRYING_LEFT, EYES_CLOSED_LEFT, CROSS_DEAD_LEFT, X_DEAD_LEFT, UNDERSCORE_LEFT, DASH_LEFT};

int rightEyes[] = {BOTTOM_EYE_RIGHT, BOTTOM_EYE_CLOSED_RIGHT, TOP_EYE_RIGHT, TOP_EYE_CLOSED_RIGHT, NEUTRAL_RIGHT, 
WIDE_EYED_RIGHT, WIDE_EYED_SURPRISED_RIGHT, SURPRISED_RIGHT, SCARED_RIGHT, ANGRY_RIGHT, PERPLEXED_RIGHT, HAPPY_RIGHT, 
CRYING_RIGHT, EYES_CLOSED_RIGHT, CROSS_DEAD_RIGHT, X_DEAD_RIGHT, UNDERSCORE_RIGHT, DASH_RIGHT};