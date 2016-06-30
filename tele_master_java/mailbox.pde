class Mailbox extends Teleobject {
  Mailbox(PApplet _parent) {
    parent = _parent;
  }

  void init() {
    comm = new Comm(parent);
    display = new MailboxDisplay();
    comm.portNumber = "1431";
    comm.targetDeviceAddress = "D2:26:16:99:DF:A5";
    comm.init();
  }

  void printPages() {
    switch(channel) {
    case HELLO: 
      pages.add(new Page("", REFRESH, 0, 0, 0, 0, 1));

      String hello = "What's up"+ (google.loggedin ? " "+profile.givenName : "") +"?";
      pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
      pages.add(new Page("", FONT, 5, 0, 0, 0, 1));
      pages.add(new Page(hello, STRING, 0, 1, 1, 64+6, 1));
      pages.add(new Page("", SERVO, 2, 5, 15, 0, 0));

      break;

    case BYE:
      pages.add(new Page("", SERVO, 0, 0, 0, 0, 1));
      pages.add(new Page("", BACKGROUND, 0, 0, 0, 0, 1));
      pages.add(new Page("", BACKGROUND, 0, 0, 0, 0, 1));

      pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
      pages.add(new Page("", FONT, 5, 0, 0, 0, 1));
      pages.add(new Page("zzz", STRING, 0, 1, 1, 64+6, 1 ));
      break;

    case CONTACTS:
      break;


    default:
      String thisCommandName = "";
      if (channel > 100 && getPilotByCommand(channel) != null) {
        thisCommandName = getPilotByCommand(channel).name;
      } else {
        thisCommandName = "????";
      }
      pages.add(new Page("", SERVO, 2, 5, 15, 0, 0));
      pages.add(new Page("", FONT, 5, 0, 0, 0, 0));
      pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
      pages.add(new Page(thisCommandName, STRING, 0, 1, 1, 64+6, 0));
      break;
    }
  }
}