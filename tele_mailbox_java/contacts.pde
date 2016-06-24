
ArrayList<String> contacts;
int currentContact = 0;


String contactName, contactLastName, contactInitials, contactImage;
//PImage contactImg;

void initContacts() {
  contacts = new ArrayList();
  String[] buffer = loadStrings("csv/contact_list.csv");
  for (int i=0; i<buffer.length; i++) {
    contacts.add(buffer[i]);
  }
}

void updateContacts() {
  currentContact = (int)random(contacts.size());
  //currentContact ++;
  //if (currentContact == contacts.size()) currentContact = 0;

  String[] items =  splitTokens(contacts.get(currentContact), ",");
  contactName = cleanUp(items[0]);
  contactLastName =  cleanUp(items[1]);
  contactInitials =  cleanUp(items[2]);
  contactImage = items[3];
  //contactImg = loadImage("data/img/"+contactImage+".png");


  //println("data/img/"+contactImage+".png");
}