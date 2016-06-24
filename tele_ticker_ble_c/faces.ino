#define BOTTOM_EYE_LEFT 27
#define BOTTOM_EYE_RIGHT 27
#define BOTTOM_EYE_CLOSED_LEFT 28
#define BOTTOM_EYE_CLOSED_RIGHT 28

#define TOP_EYE_LEFT 29
#define TOP_EYE_RIGHT 29
#define TOP_EYE_CLOSED_LEFT 30
#define TOP_EYE_CLOSED_RIGHT 30

#define NEUTRAL_LEFT 145
#define NEUTRAL_RIGHT 146
#define WIDE_EYED_LEFT 147
#define WIDE_EYED_RIGHT 148
#define WIDE_EYED_SURPRISED_LEFT 149
#define WIDE_EYED_SURPRISED_RIGHT 150
#define SURPRISED_LEFT 151
#define SURPRISED_RIGHT 152
#define SCARED_LEFT 153
#define SCARED_RIGHT 154
#define ANGRY_LEFT 155
#define ANGRY_RIGHT 156
#define PERPLEXED_LEFT 157
#define PERPLEXED_RIGHT 158
#define HAPPY_LEFT 159
#define HAPPY_RIGHT 160
#define CRYING_LEFT 161
#define CRYING_RIGHT 162
#define EYES_CLOSED_LEFT 163
#define EYES_CLOSED_RIGHT 164 
#define CROSS_DEAD_LEFT 165 
#define CROSS_DEAD_RIGHT 166
#define X_DEAD_LEFT 167
#define X_DEAD_RIGHT 168

#define UNDERSCORE_LEFT '_'
#define UNDERSCORE_RIGHT '_'

#define DASH_LEFT '-'
#define DASH_RIGHT '-'

#define SWEAT_BEAD 169

#define bottom 0
#define bottom_closed 1
#define top 2
#define top_closed 3
#define neutral 4
#define wide 5
#define surprised 6
#define scared 7
#define angry 8
#define perplexed 9
#define happy 10
#define crying 11
#define closed 12
#define cross 13
#define dead 14
#define underscore 15
#define dash 16

boolean noseFace = true;
int face = neutral;
int faceClosed = closed;

byte leftEyes[] = {BOTTOM_EYE_LEFT, BOTTOM_EYE_CLOSED_LEFT, TOP_EYE_LEFT, TOP_EYE_CLOSED_LEFT, NEUTRAL_LEFT, 
WIDE_EYED_LEFT, WIDE_EYED_SURPRISED_LEFT, SURPRISED_LEFT, SCARED_LEFT, ANGRY_LEFT, PERPLEXED_LEFT, HAPPY_LEFT, 
CRYING_LEFT, EYES_CLOSED_LEFT, CROSS_DEAD_LEFT, X_DEAD_LEFT, UNDERSCORE_LEFT, DASH_LEFT};

byte rightEyes[] = {BOTTOM_EYE_RIGHT, BOTTOM_EYE_CLOSED_RIGHT, TOP_EYE_RIGHT, TOP_EYE_CLOSED_RIGHT, NEUTRAL_RIGHT, 
WIDE_EYED_RIGHT, WIDE_EYED_SURPRISED_RIGHT, SURPRISED_RIGHT, SCARED_RIGHT, ANGRY_RIGHT, PERPLEXED_RIGHT, HAPPY_RIGHT, 
CRYING_RIGHT, EYES_CLOSED_RIGHT, CROSS_DEAD_RIGHT, X_DEAD_RIGHT, UNDERSCORE_RIGHT, DASH_RIGHT};




