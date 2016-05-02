//import ddf.minim.*;

//Minim minim;
//AudioInput in;

//char[]eq;
//float[]eqVal;
//int res= 32;

//float maxL = .03;
//float midL = .01;
//float minL = midL/2;

//float rightL;
//float leftL;
//float eqFilter = .2;

//void initMic()
//{
// minim = new Minim(this);
// in = minim.getLineIn(minim.STEREO, res);
// eq = new char[res];
// eqVal = new float[res];
//}

//boolean softEq = false;

//void updateMic()
//{
// rightL = in.right.level();
// leftL = in.left.level();
// if (channel == EQ ) {
// // pushMatrix();
// // stroke(redColor);
// // strokeWeight(2);
// // translate(0, height);
// // pushMatrix();
// // scale(width/res, 1);
// float offset = 100;
// // popMatrix();
// float eqWidth = width*1.0/(res-1);
// for (int i = 0; i < in.bufferSize(); i++) {
//   float targetLevel =  abs(in.left.get(i));
//   eqVal[i] = eqVal[i]+(targetLevel-eqVal[i])*eqFilter;
//   if ( eqVal[i] > maxL) {
//     eq[i] =EQ_HIGH;
//   } else if ( eqVal[i] > midL &&  eqVal[i] < maxL) {
//     eq[i] =EQ_MID;
//   } else if ( eqVal[i] >  minL &&  eqVal[i] < midL) {
//     eq[i] =EQ_LOW;
//   } else {
//     eq[i] =EQ_OFF;
//   }
//   // line(0, -offset + in.left.get(i)*offset, eqWidth, -offset + in.left.get(i)*offset);
//   // translate(eqWidth, 0);
// }
// // popMatrix();
//}
//}

////    if ( in.isMonitoring() )
////    {
////      in.disableMonitoring();
////    }
////    else
////    {
////      in.enableMonitoring();
////    }