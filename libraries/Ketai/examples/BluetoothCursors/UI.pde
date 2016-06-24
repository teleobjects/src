/*  UI-related functions */


void mousePressed()
{
  //keyboard button -- toggle virtual keyboard
  if (mouseY <= 50 && mouseX > 0 && mouseX < width/3)
    KetaiKeyboard.toggle(this);
  else if (mouseY <= 50 && mouseX > width/3 && mouseX < 2*(width/3)) //config button
  {
    isConfiguring=true;
  } else if (mouseY <= 50 && mouseX >  2*(width/3) && mouseX < width) // draw button
  {
    if (isConfiguring)
    {
      //if we're entering draw mode then clear canvas
      background(78, 93, 75);
      isConfiguring=false;

      //if (isConfiguring) return;
    }
  }

  if (isConfiguring)
    return;

  byte[] data = {(byte)'s', (byte)'w', (byte)'i', (byte)'t', (byte)'c', (byte)'h', (byte)10};

  //byte[] data = new byte[7];
  //data[0] = '2';
  //data[1] = ' ';

  //data[2] = 'a';
  //data[3] = 'b';
  //data[4] = 'O';
  //data[5] = 'K';
  //data[6] = 10;
  bt.broadcast(data);
  //bt.writeToDeviceName(deviceName, data);
  //println(bt.isConnected());
 
  println("sending "+deviceName+"  "+millis());
}

void mouseDragged()
{
  if (isConfiguring)
    return;

  //send data to everyone
  //  we could send to a specific device through
  //   the writeToDevice(String _devName, byte[] data)
  //  method.


  //send(data);
  //delay(200);
  ellipse(mouseX, mouseY, 20, 20);
}


public void keyPressed() {
  if (key =='c')
  {
    //If we have not discovered any devices, try prior paired devices
    if (bt.getDiscoveredDeviceNames().size() > 0)
      klist = new KetaiList(this, bt.getDiscoveredDeviceNames());
    else if (bt.getPairedDeviceNames().size() > 0)
      klist = new KetaiList(this, bt.getPairedDeviceNames());
  } else if (key == 'd')
  {
    bt.discoverDevices();
  } else if (key == 'x')
    bt.stop();
  else if (key == 'b')
  {
    bt.makeDiscoverable();
  } else if (key == 's')
  {
    bt.start();
  }
}


void drawUI()
{
  //Draw top shelf UI buttons

  pushStyle();
  fill(0);
  stroke(255);
  rect(0, 0, width/3, 50);

  if (isConfiguring)
  {
    noStroke();
    fill(78, 93, 75);
  } else
    fill(0);

  rect(width/3, 0, width/3, 50);

  if (!isConfiguring)
  {  
    noStroke();
    fill(78, 93, 75);
  } else
  {
    fill(0);
    stroke(255);
  }
  rect((width/3)*2, 0, width/3, 50);

  fill(255);
  text("Keyboard", 5, 30); 
  text("Bluetooth", width/3+5, 30); 
  text("Interact", width/3*2+5, 30); 

  popStyle();
}
String deviceName;

void onKetaiListSelection(KetaiList klist)
{
  String selection = klist.getSelection();
  bt.connectToDeviceByName(selection);
   deviceName = selection;
  //dispose of list for now
  klist = null;
}