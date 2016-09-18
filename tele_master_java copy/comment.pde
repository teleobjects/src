class Comment extends Teleobject {
  int clockMode;

  Comment(PApplet _parent) {
    parent = _parent;
  }

  void init() {
    comm = new Comm(parent, this);
    comm.portNumber = "14121";
    comm.targetDeviceAddress = "E4:CB:FF:38:3A:00";
    display = new CommentDisplay();
    comm.init();
  }

  void printPages() {
    switch (channel) {
      case BYE:
      pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
      break;

      case HELLO: 
      // pages.add(new Page("", TICKER, 0, 0, 0, 0, 1));
      // pages.add(new Page("", FONT, 1, 1, 0, 0, 1));
      if (!google.loggedin) {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page("What's up?", TICKER, 0, 0, 40, 0, 0));
      } 
      else {
        // pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));

        pages.add(new Page("What's up "+profile.givenName+"?", TICKER, 0, 0, 40, 0, 0));
        // pages.add(new Page(, TICKER, 1, 0, 40, 0, 0));
      }
      break;

      case DIM:
      manager.play = true;
      pages.add(new Page("", BRIGHTNESS, comm.brightness+3, 0, 0, 0, 1));
      pages.add(new Page("", PING, 0, 0, 0, 0, 1));
      break;

      case LOCATION:
      if (!geolocation.updated) {
        pages.add(new Page("We're lost...", TICKER, 0, 0, 50, 0, 1));
      } 
      else {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page(getCoordinate(geolocation.latitude, true), CENTERED, 0, 0, 0, 0, 0));
        pages.add(new Page(getCoordinate(geolocation.longitude, false), CENTERED, 1, 0, 0, 0, 20));
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));


        pages.add(new Page(geolocation.houseNumber+" "+geolocation.street, SCROLL_ALL_RIGHT, 0, 0, 10, 0, 1));
        pages.add(new Page(geolocation.neighbourhood+" "+geolocation.postCode, SCROLL_ALL_RIGHT, 0, 0, 10, 0, 1));
        pages.add(new Page(geolocation.city+", "+geolocation.county+", "+geolocation.state, SCROLL_ALL_RIGHT, 1, 0, 10, 0, 1));
      }
      break;

      case WEATHER:
      if (!weather.updated) {
        pages.add(new Page("can't connect to the cloud...", TICKER, 0, 0, 50, 0, 0));
      } 
      else {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page(("weather"), SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 30));
        pages.add(new Page((weather.condition+" in "+geolocation.neighbourhood), SCROLL_ALL_RIGHT, 1, 0, 5, 0, 1));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("It's "+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + (metric ? "°c" : "°f"), CENTERED, 0, 0, 0, 0, 10));
        pages.add(new Page("and it's gonna get hotter...", SCROLL_ALL_RIGHT, 1, 0, 10, 0, 10));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("humidity", CENTERED, 0, 0, 0, 0, 5));
        pages.add(new Page(int(weather.humidity)+"%", CENTERED, 1, 0, 0, 0, 10));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("pressure", CENTERED, 0, 0, 0, 0, 5));
        pages.add(new Page(int(weather.pressure)+"mPa", CENTERED, 1, 0, 0, 0, 10));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("wind", CENTERED, 0, 0, 0, 0, 5));
        pages.add(new Page(int(weather.windSpeed) +"m/h "+(int)weather.windDeg+"° "+getHeading(weather.windDeg), CENTERED, 1, 0, 0, 0, 10));
      }
      break;

      case ONLINE:
      if (network.online) {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page("ip "+network.externalIP, CENTERED, 0, 0, 0, 0, 0));
        pages.add(new Page("ping "+network.pingTime+"ms", CENTERED, 1, 0, 0, 0, 0));
      } 
      else {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page("no network...", TICKER, 0, 0, 0, 0, 5));
        pages.add(new Page("...no fun", TICKER, 1, 0, 0, 0, 5));
      }
      break;

      case WIFI:
      if (network.wifi) {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page(network.hostName, CENTERED, 0, 0, 0, 0, 0));
        pages.add(new Page(network.hostIP, CENTERED, 1, 0, 0, 0, 0));
      } 
      else {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page("no wifi...", TICKER, 0, 0, 20, 0, 5));
        pages.add(new Page("...no network", TICKER, 1, 0, 20, 0, 5));
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page("no cloud...", TICKER, 0, 0, 0, 0, 5));
        pages.add(new Page("...no fun", TICKER, 1, 0, 0, 0, 5));
      }
      break;

      case BLUETOOTH:
      if (comm != null) {
        if (comm.connected) {
          if (!androidMode) {
            pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
            pages.add(new Page(comm.portName.substring(0, 5), TICKER, 0, 0, 50, 0, 10));
            pages.add(new Page(comm.portName.substring(5, comm.portName.length()), TICKER, 1, 0, 50, 0, 0));
          } 
          else {
            pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
            pages.add(new Page(comm.deviceAddress, CENTERED, 0, 0, 0, 0, 0));
            pages.add(new Page(comm.deviceRssi+"dB", CENTERED, 1, 0, 0, 0, 0));
          }
        } 
        else {
          pages.add(new Page("not connected...", TICKER, 0, 0, 10, 0, 0));
        }
      } 
      break;

      case ENERGY:
      pages.add(new Page("", BATTERY, 0, 0, 0, 0, 1));
      break;

      case TIME:
      if (clockMode++ == 3) clockMode = 0;
      String hour_ = nf(hour(), 2, 0);
      String minute_ = nf(minute(), 2, 0);
      String second_ = nf(second(), 2, 0);
      pages.add(new Page(hour_ + minute_ + second_, CLOCK, clockMode, 1, 0, 0, 0));
      break;

      case GOOGLE:
      if (google.loggedin) {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        // pages.add(new Page("", FONT, 1, 1, 0, 0, 1));

        pages.add(new Page("What's up", TICKER, 0, 0, 50, 0, 10));
        pages.add(new Page(profile.givenName+"?", TICKER, 1, 0, 50, 0, 10));
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 1));
        pages.add(new Page("our google id", SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 10));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 1, 0, 0, 5));

        pages.add(new Page(profile.id, SCROLL_ALL_RIGHT, 1, 0, 10, 0, 5));

        pages.add(new Page("our email", SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 10));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 1, 0, 0, 5));

        pages.add(new Page(profile.email, SCROLL_ALL_RIGHT, 1, 0, 10, 0, 0));

        pages.add(new Page("we are over "+profile.minAge+","+"speak english!", CENTERED, 2, 0, 0, 0, 20));
        // pages.add(new Page(, CENTERED, 1, 0, 0, 0, 30));
        // pages.add(new Page("", BLANK, 2, 0, 0, 0, 1));
        pages.add(new Page("let's rock!", CENTERED, 2, 0, 0, 0, 0));
      } 
      else {
        pages.add(new Page("let's login to google!"+profile.givenName, CENTERED, 0, 0, 10, 0, 0));
      }
      break;

      case CONTACTS:
      // pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
      pages.add(new Page(contacts.contactList.size()+" friends!", SCROLL_CENTER_RIGHT, 0, 1, 0, 0, 10));
      pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 1, 0, 0, 5));

      for (Contact contact : contacts.contactList) {
        pages.add(new Page(contact.title.toUpperCase(), CENTERED, 1, 0, 0, 0, 0));
      }
      break;

      case NEWS:
      if (news.updated) {
        pages.add(new Page("", BLANK, 2, 0, 0, 0, 0));
        pages.add(new Page("NY TIMES", SCROLL_CENTER_RIGHT, 0, 1, 0, 0, 10));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 1, 0, 0, 5));

        for (Article article : news.articles) {
          for (int i=0; i < article.keywords.size(); i++) {
            String keyword = article.keywords.get(i);
            pages.add(new Page(keyword.toUpperCase(), CENTERED, 2, 0, 0, 0, 5));
            pages.add(new Page("", BLANK, 2, 0, 0, 0, 1));
          }
          pages.add(new Page("", BLANK, 2, 0, 0, 0, 5));
          pages.add(new Page(article.section.toUpperCase()+":", SCROLL_DOWN, 0, 0, 0, 0, 20));
          pages.add(new Page(article.title, SCROLL_ALL_RIGHT, 1, 0, 10, 0, 5));
          pages.add(new Page(article.content, TICKER, 1, 0, 4, 2, 20));
          pages.add(new Page("", BLANK, 2, 0, 0, 0, 10));
        }
      } 
      else {
        pages.add(new Page("can't find...", TICKER, 0, 0, 60, 0, 30));
        pages.add(new Page(("...the newspaper"), TICKER, 1, 0, 60, 0, 30));
      }
      break;

      case CALENDAR:
      pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
      if (calendar.updated) {
        pages.add(new Page(("remember...?"), SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 50));
        for (int i=0; i<50; i++) {           // for (Event event : calendar.eventList) {         
          Event event = calendar.eventList.get((int)random(calendar.eventList.size()));
          pages.add(new Page(event.date, CENTERED, 0, 0, 0, 0, 0));
          pages.add(new Page(event.summary, SCROLL_ALL_RIGHT, 1, 0, 5, 0, 0));
        }
      } 
      else {
        pages.add(new Page("can't find...", TICKER, 0, 0, 60, 0, 30));
        pages.add(new Page(("...the calendar"), TICKER, 1, 0, 60, 0, 30));
      }
      break;

      case EQ: 
      manager.play = true;
      comm.busy = false;
      String str = "";
      for (int i =0; i<32; i++) {
        str += char(48+eq.eqData[int(i)]);
      }
      pages.add(new Page(str, SPECTRUM, 2, 0, 0, 0, 1));
      break;
    }
  }
}