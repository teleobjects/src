ArrayList<String> mails;
int mailIndex;

void initMail() {
}

void updateMail() {
  mails = new ArrayList();
  String[] mailBuffer = loadUrl("http://teleobjects.com/api/proxy.php?mail=true");
  //println(mailBuffer);
  for (int i=0; i<mailBuffer.length; i++) {
    int currentMail = mailBuffer.length - i - 1;
    if (mailBuffer[currentMail].indexOf("=?") == - 1) {
      String[] items = splitTokens (mailBuffer[currentMail], "\t");
      if (items.length>0) {
        String name =  items[0];
        if (name.indexOf("<") != -1) {
          name = name.substring(0, name.indexOf("<"));
        }
        name = removeQuotes(name);
        mails.add(createString(" ", INSTANT, 1, 1, 1));
        mails.add(createString(cleanUp(name, true), SCROLL_PUSH_RIGHT, 10, 1, 10));
        mails.add(createString(" ", INSTANT, 1, 1, 1));
        if (items.length>1) {
          String date = items[1].substring(0, 11);
          mails.add(createString(cleanUp(date, true), CENTERED, 1, 1, 10));
          mails.add(createString(" ", INSTANT, 1, 1, 1));
        }

        if (items.length > 2) {
          String subject =  cleanUp(items[2].toUpperCase());
          mails.add(createString(subject, SCROLL_ALL_RIGHT, 100, 1, 10));
        }
      }
    }
  }
  if (mails.size() == 0) {
    mails.add("No unread emails");
  }
}