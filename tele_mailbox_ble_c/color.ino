//int angle_to_channel(float a) {
//  if (a < -PI)
//    a += 2 * PI;
//  if (a < -2 * PI / 3  || a > 2 * PI / 3)
//    return 0;
//  float f_channel = cos(a * 3 / 4); // remap 120-degree 0-1.0 to 90 ??
//  return ceil(f_channel * 63);
//}
//
//void loopColor() {
//  OLED_Colour c;
//  c.red = angle_to_channel(angle) >> 1;
//  c.green = angle_to_channel(angle - 2 * PI / 3);
//  c.blue = angle_to_channel(angle - 4 * PI / 3) >> 1;
//  oled.fillScreen(c);
//  angle += 0.02;
//  if (angle > PI) {
//    angle -= 2 * PI;
//  }
//}
