
ArrayList<String> contacts;

ArrayList<String> profileImages;

int currentContact = 0;
// String[] contactData;

// String contactName, contactLastName, contactInitials, contactImage;

void initContacts() {
  contacts = new ArrayList();
  profileImages = new ArrayList();

  String[] contactData = loadStrings("csv/contact_list.csv");
  for (int i=0; i<contactData.length; i++) {
    String[] items =  splitTokens(contactData[i], ",");
    String fullName = removeQuotes(cleanUp(items[0]));
    String lastName = removeQuotes(cleanUp(items[1]));
    String initials = cleanUp(items[2]);
    String contactImage = items[3];
    if (!lastName.equals("_") && !lastName.equals(" ") && !lastName.equals("")) {
      fullName += " "+lastName;
    }
    contacts.add(fullName);
    profileImages.add(contactImage);
  }
}