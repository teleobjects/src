import ddf.minim.*;
import ddf.minim.effects.*;

Minim minim;
AudioPlayer whistle, notification, skypeCall, soundtrack, bitbit, offline, dial, pattern, ready, event, boing, bubble, twobubbles, offff, zoomin, click;

AudioPlayer skype1, hangup;

void initSound()
{
  minim = new Minim(this);
  whistle = minim.loadFile("sounds/Whatsapp Notification Sound (Whistle).mp3");
  notification =  minim.loadFile("sounds/WhatsApp Sound Original Message.mp3");  
  skypeCall =  minim.loadFile("sounds/skypeCallMuted.mp3");
  skype1 =  minim.loadFile("sounds/skype1.mp3");
  soundtrack = minim.loadFile("sounds/07 fold air.mp3");
  hangup = minim.loadFile("sounds/hangup.mp3");
  offline = minim.loadFile("sounds/offline.mp3");
  bitbit = minim.loadFile("sounds/bitBit.mp3");
  dial = minim.loadFile("sounds/dialTone.mp3");
  pattern = minim.loadFile("sounds/pattern.mp3");
  ready = minim.loadFile("sounds/ready.mp3");
  event = minim.loadFile("sounds/event.mp3");
  boing = minim.loadFile("sounds/boing.mp3");
  bubble = minim.loadFile("sounds/bubble.mp3");
  twobubbles = minim.loadFile("sounds/twoBubbles.mp3");
  offff = minim.loadFile("sounds/offff.mp3");
  zoomin = minim.loadFile("sounds/zoomin.mp3");
  click = minim.loadFile("sounds/click.mp3");
}

//void updateSound()
//{
//  stroke(redColor);
//  for (int i = 0; i < whistle.bufferSize() - 1; i++)
//  {
//    line(i, 50  + whistle.left.get(i)*50, i+1, 50  + whistle.left.get(i+1)*50);
//    line(i, 150 + whistle.right.get(i)*50, i+1, 150 + whistle.right.get(i+1)*50);
//  }
//}