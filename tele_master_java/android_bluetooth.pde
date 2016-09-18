import blepdroid.*;
import blepdroid.BlepdroidDevice;

UUID BLUEFRUIT_UART_SERVICE = UUID.fromString( "6E400001-B5A3-F393-E0A9-E50E24DCCA9E");
UUID BLUEFRUIT_UART_TX = UUID.fromString("6E400002-B5A3-F393-E0A9-E50E24DCCA9E");
UUID BLUEFRUIT_UART_RX = UUID.fromString("6E400003-B5A3-F393-E0A9-E50E24DCCA9E");

class Bluetooth {
  PApplet parent;
  BluetoothAdapter mBluetoothAdapter;

  Bluetooth(PApplet _parent) {
    parent = _parent;
    mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
  }

  boolean available;
  boolean initialized;
  boolean pairing;
  boolean discovering;

  void update() {
    available = mBluetoothAdapter.isEnabled();
    if (!available) {
      BluetoothAdapter.getDefaultAdapter().enable();
    } else {
      if (!initialized) {
        try {
          Blepdroid.initialize(parent);
          initialized = true;
          if (verbose) println("initalizing bluetooth");
        }
        catch (Exception e) {
          if (verbose) println("error initializing bluetooth");
        }
      } else {
        connect();
      }
    }
  }

  void disconnect() {
    if (verbose) println("disconnecting");
    for (Teleobject teleobject : teleobjects) {      
      teleobject.comm.device = null;
      teleobject.comm.found = false;
      teleobject.comm.paired = false;
      teleobject.comm.discovered = false;
      teleobject.comm.connected = false;
      teleobject.comm.acknowledged = false;
      teleobject.comm.busy = false;
      teleobject.comm.deviceName = "";
      teleobject.comm.deviceAddress = "";
      teleobject.comm.deviceRssi = 0;
    }
    //available = false;
    pairing = false;
    discovering = false;
  }    

  void pause() {
    disconnect();
  }

  void resume() {
  }

  void reconnect() {
    if (verbose) println("reconnecting");
    disconnect();
    Blepdroid.getInstance().onPause();
    Blepdroid.getInstance().onResume();
    //scan();
  }

  void connect() {
    for (Teleobject teleobject : teleobjects) {   
      if (teleobject.comm != null && !teleobject.comm.connected) {
        if (teleobject.comm.found) {
          if (teleobject.comm.paired) {
            if (teleobject.comm.discovered) {
              //Blepdroid.getInstance().connectToService(BLUEFRUIT_UART_SERVICE); //not required, throws error ???
              Blepdroid.getInstance().setCharacteristicToListen(teleobject.comm.device, BLUEFRUIT_UART_RX);
              teleobject.comm.connected = true;
              teleobject.comm.connecting = true;
              teleobject.comm.connectionTime = millis();
              discovering = false;
              if (verbose) println("setting characteristic");
            } else {
              if (!discovering) {
                Blepdroid.getInstance().discoverServices(teleobject.comm.device);
                discovering = true;
                if (verbose) println("discovering services");
              }
            }
          } else {
            if (!pairing) {
              Blepdroid.getInstance().connectDevice(teleobject.comm.device);
              pairing = true;
              if (verbose) println("connecting device");
            }
          }
        } else { 
          // not found, maybe scan again after 10 seconds... might drain battery ??? check ???
        }
      }
    }

    // rssi changes not implemented in current version of blepdroid
    //if (teleobject.comm != null && teleobject.comm.connected) {
    //  if (millis() > teleobject.comm.lastRssi + 5000) {
    //    teleobject.comm.lastRssi = millis();
    //    if (verbose) println("requesting rssi");
    //    Blepdroid.getInstance().readRSSI(teleobject.comm.device);
    //  }
    //}
  }

  //void scan() {
  //  Blepdroid.getInstance().scanDevices();
  //}
}

void onCharacteristicChanged(BlepdroidDevice device_, String characteristic, byte[] data)
{
  for (Teleobject teleobject : teleobjects) {
    if (teleobject.comm != null && teleobject.comm.device != null && device_ == teleobject.comm.device) {
      teleobject.comm.rx(data);
    }
  }
}

void onDeviceDiscovered(BlepdroidDevice device_)
{
  for (Teleobject teleobject : teleobjects) {
    if (teleobject.comm != null && device_.address.contains(teleobject.comm.targetDeviceAddress)) {
      if (!teleobject.comm.found) {
        //println("/////////////////////////////////////////////////////// target device found "+teleobject.name);
        teleobject.comm.deviceName = device_.name;
        teleobject.comm.deviceAddress = device_.address;
        teleobject.comm.deviceRssi = device_.rssi;
        teleobject.comm.portName = teleobject.comm.deviceAddress;
        teleobject.comm.device = device_;
        teleobject.comm.found = true;
      }
    }
  }
}

void onBluetoothConnection(BlepdroidDevice device_, int state)
{
  for (Teleobject teleobject : teleobjects) {
    if (teleobject.comm != null && teleobject.comm.device !=  null && device_ == teleobject.comm.device) {
      //if (verbose) println("/////////////////////////////////////////////////////// paring successfull to "+  teleobject.name + " "+state);
      teleobject.comm.paired = true;
      bluetooth.pairing = false;
    }
  }
}

void onServicesDiscovered(BlepdroidDevice device_, int status)
{
  for (Teleobject teleobject : teleobjects) {
    if (teleobject.comm != null && teleobject.comm.device !=  null && device_ == teleobject.comm.device) {
      //if (verbose) println("/////////////////////////////////////////////////////// discovered services successfull to "+  teleobject.name + " "+status);
      teleobject.comm.discovered = true;
      bluetooth.discovering = false;
    }
  }
}

void onBluetoothRSSI(BlepdroidDevice device_, int rssi)
{
  println("onBluetoothRSSI " + device_.address + " " + Integer.toString(rssi));
}

void onDescriptorWrite(BlepdroidDevice device, String characteristic, String data)
{
  //println("onDescriptorWrite " + characteristic + " " + data);
}

void onDescriptorRead(BlepdroidDevice device_, String characteristic, String data)
{
  //println(" onDescriptorRead " + characteristic + " " + data);
}

void onCharacteristicRead(BlepdroidDevice device_, String characteristic, byte[] data)
{
  //println("onCharacteristicRead " + characteristic + " " + data);
}

void onCharacteristicWrite(BlepdroidDevice device_, String characteristic, byte[] data)
{
  //println("onCharacteristicWrite " + characteristic + " " + data);
}