long mailboxLast, mailboxStart;
int counter;
boolean mailboxStatus, flagUp;
float mailboxAngle = 0, mailboxTargetAngle = 90;

void initMailbox() {
  mailbox = loadShape("svg/mailbox.svg");
  mailbox.disableStyle();
  mailbox_ = loadShape("svg/mailbox_.svg");
  mailbox_.disableStyle();
  mailbox_flag = loadShape("svg/mailbox_flag2.svg");
  mailbox_flag.disableStyle();
}

void mailboxOn() {
  mailboxStatus = true;
  mailboxStart = millis();
  counter = 0;
}

void mailboxOff() {
  mailboxStatus = false;
}

void drawMailbox(float thisX, float thisY) {
  long mailboxEllapsed = millis()- mailboxStart;
  if (activeScene == 6 && !mailboxStatus) {
    mailboxOn();
  }
  if (activeScene != 6 && mailboxStatus) {
    mailboxOff();
  }

  pushMatrix();
  translate(thisX, thisY);
  scale(.8);
  pushMatrix();
  noStroke();
  fill(255);
  shape(mailbox_, -mailbox.width/2, -mailbox.height/2);
  noFill();
  stroke(0);
  strokeWeight(1);
  shape(mailbox, -mailbox.width/2, -mailbox.height/2);
  strokeWeight( z*heavyStroke);
  shape(mailbox_, -mailbox.width/2, -mailbox.height/2);
  popMatrix();
  pushMatrix();
  iso();
  rotateX(radians(-90));
  pushMatrix();
  stroke(redColor);
  fill(255);
  scale(.18);
  translate(80, 0, -30);
  translate(0, 0, 55);
  strokeWeight( z*heavyStroke);


  if (mailboxStatus) {
    if (mailboxEllapsed > 5000 && mailboxEllapsed < 9000 && mailboxStatus && millis()-mailboxLast > 1000 && counter < 4) {
      mailboxLast = millis();
      mailboxAngle = 45;
      counter ++;
      if (!muted) {
        boing.rewind();
        boing.play();
      }
    }
    if (mailboxEllapsed > 10000 && mailboxStatus && millis()-mailboxLast > 100 && counter > 0) {
      mailboxLast = millis();
      mailboxAngle = 45;
      if (counter == 4 && !muted) {
        bitbit.rewind();
        bitbit.play();
      }
      counter --;
    }
  }
  if (counter > 0) mailboxTargetAngle = 0;
  if (counter == 0) mailboxTargetAngle = 90;
  mailboxAngle += (mailboxTargetAngle-mailboxAngle)*.5;
  rotateZ(-radians(mailboxAngle));
  shape(mailbox_flag, 0, 0 );
  shape(mailbox_flag, -5, 0 );
  popMatrix();
  rotateY(radians(90));
  noStroke();
  textFont(sevenFont, 15);
  textAlign(LEFT, BOTTOM);
  String counterDisplay = nf(counter, 3, 0)+"";
  for (int i=0; i<3; i++) {
    fill(redColor, 30);
    text("8", 27+(i*9), 58.5);
    if (mailboxEllapsed > 3000) {
      fill(redColor);
      text(counterDisplay.charAt(i), 27+(i*9), 58.5);
    }
  }
  popMatrix();
  popMatrix();
}