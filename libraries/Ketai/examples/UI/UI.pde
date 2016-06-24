import ketai.ui.*;
//import android.content.Intent;
//import android.os.Bundle;

ArrayList<String> colorlist = new ArrayList<String>();
color backgroundcolor = color(0, 0, 0);

void setup()
{
  //orientation(LANDSCAPE);
  textSize(28);
  textAlign(CENTER);
  //register for key events(keyPressed currently Broken)
  //registerMethod("keyEvent", this);
}

void draw()
{
  background(backgroundcolor);
  text("click screen to change background color", width/2, height/2);
}


void mousePressed()
{
  KetaiKeyboard.toggle(this);

  //if (mouseX < width/3)
}

//use event framework temporarily
public void keyPressed() {

  if (key == CODED) {
    if (keyCode ==  android.view.KeyEvent.KEYCODE_BACK) {
      // do something here for the back button behavior
      // you'll need to set keyCode to 0 if you want to prevent quitting (see above)
      keyCode = 0;
      key = 0;
    } else if (keyCode == MENU) {
    }
  }


  println("key");
  if (key == ' ')
    //KetaiAlertDialog.popup(this, "SPACE pressed", "You pressed the <SPACE> key!");
  {
    println(key);
  }
  keyCode = 0;
  key = 0;
}