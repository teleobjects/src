class Comment extends Teleobject {
  Comment(PApplet _parent) {
    parent = _parent;
  }

  void init() {
    comm = new Comm(parent);
    display = new CommentDisplay();
    comm.portNumber = "1421";
    comm.targetDeviceAddress = "E4:CB:FF:38:3A:00";
    comm.init();
  }

  void printPages() {
    switch (channel) {
      case BYE:
      pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
      break;

      case HELLO: 
      pages.add(new Page("", TICKER, 0, 0, 0, 0, 1));
      pages.add(new Page("", FONT, 1, 1, 0, 0, 1));
      if (!google.loggedin) {
        pages.add(new Page("What's up?", TICKER, 0, 0, 80, 0, 1));
        } else {
          pages.add(new Page("What's up", TICKER, 0, 0, 80, 0, 1));
          pages.add(new Page(profile.givenName+"?", TICKER, 1, 0, 80, 0, 1));
        }
        break;

        case LOCATION:
        if (!geolocation.updated) {
          pages.add(new Page("We're lost...", TICKER, 0, 0, 50, 0, 1));
          } else {
            pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
            pages.add(new Page(getCoordinate(geolocation.latitude, true), CENTERED, 0, 0, 0, 0, 1));
            pages.add(new Page(getCoordinate(geolocation.longitude, false), CENTERED, 1, 0, 0, 0, 20));
            pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
            pages.add(new Page(geolocation.houseNumber+" "+geolocation.street, SCROLL_ALL_RIGHT, 0, 0, 10, 0, 5));
            pages.add(new Page(geolocation.neighbourhood+" "+geolocation.postCode, TICKER, 0, 0, 20, 0, 5));
            pages.add(new Page(geolocation.city+", "+geolocation.state, TICKER, 1, 0, 20, 0, 20));
          }
          break;

          case WEATHER:
          if (!weather.updated) {
            pages.add(new Page("can't connect to the cloud...", TICKER, 0, 0, 50, 0, 0));
            } else {
              pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
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
            pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
            pages.add(new Page("ip "+network.externalIP, CENTERED, 0, 0, 0, 0, 1));
            pages.add(new Page("ping "+network.pingTime+"ms", CENTERED, 1, 0, 0, 0, 1));
            break;

            case WIFI:
            pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
            pages.add(new Page(network.hostName, CENTERED, 0, 0, 0, 0, 1));
            pages.add(new Page(network.hostIP, CENTERED, 1, 0, 0, 0, 1));
            break;

            case BLUETOOTH:
            if (comm != null) {
              if (comm.connected) {
                if (!android) {
                  pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
                  pages.add(new Page(comm.portName.substring(0, 5), TICKER, 0, 0, 20, 0, 1));
                  pages.add(new Page(comm.portName.substring(5, comm.portName.length()), TICKER, 1, 0, 20, 0, 1));
                  } else {
                    pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
                    pages.add(new Page(comm.deviceAddress, CENTERED, 0, 0, 0, 0, 1));
                    pages.add(new Page(comm.deviceRssi+"dB", CENTERED, 1, 0, 0, 0, 1));
                  }
                  } else {
                    pages.add(new Page("not connected...", TICKER, 0, 0, 10, 0, 1));
                  }
                } 
                break;

                case ENERGY:
                pages.add(new Page("", BATTERY, 0, 0, 0, 0, 1));
                break;

                case TIME:
      //pages.add(new Page(getStringTime(true, "."), CENTERED, 0, 0, 0, 0, 10));
      //if (newPage) pages.add(new Page(time.monthStr+" "+time.day+"th, "+time.year, CENTERED, 1, 0, 0, 0, 0));//time.dayStr+", "+
      String hour_ = nf(hour(), 2, 0);
      String minute_ = nf(minute(), 2, 0);
      pages.add(new Page(getStringTime(true, "."), CLOCK, hour_.charAt(0), hour_.charAt(1), minute_.charAt(0), minute_.charAt(1), 10));
      break;

      case GOOGLE:
      if (google.loggedin) {
        //pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("", FONT, 1, 1, 0, 0, 1));

        pages.add(new Page("What's up", TICKER, 0, 0, 50, 0, 10));
        pages.add(new Page(profile.givenName+"?", TICKER, 1, 0, 40, 0, 30));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("our google id", CENTERED, 0, 0, 0, 0, 1));
        pages.add(new Page(profile.id, SCROLL_ALL_RIGHT, 1, 0, 10, 0, 5));
        pages.add(new Page("our email", CENTERED, 0, 0, 0, 0, 1));
        pages.add(new Page(profile.email, SCROLL_ALL_RIGHT, 1, 0, 10, 0, 5));
        pages.add(new Page("we are over "+profile.minAge+",", CENTERED, 0, 0, 0, 0, 1));
        pages.add(new Page("speak english!", CENTERED, 1, 0, 0, 0, 30));
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 1));
        pages.add(new Page("let's!", CENTERED, 0, 0, 0, 0, 10));
        pages.add(new Page("rock!", CENTERED, 1, 0, 0, 0, 30));
        } else {
          pages.add(new Page("let's login to google!"+profile.givenName, CENTERED, 0, 0, 10, 0, 0));
        }
        break;

        case CONTACTS:
      // pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
      pages.add(new Page(contacts.contactList.size()+" friends!", CENTERED, 0, 0, 0, 0, 40));
      for (Contact contact : contacts.contactList) {
        pages.add(new Page(contact.title.toUpperCase(), CENTERED, 1, 0, 0, 0, 15));
      }
      break;

      case NEWS:
      if (news.updated) {
        pages.add(new Page("", BLANK, 0, 0, 0, 0, 0));
        pages.add(new Page(("NY TIMES"), SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 30));
        for (Article article : news.articles) {
          for (int i=0; i < article.keywords.size(); i++) {
            String keyword = article.keywords.get(i);
            pages.add(new Page(keyword.toUpperCase(), CENTERED, 0, 0, 0, 0, 5));
          }
          pages.add(new Page(article.title, SCROLL_ALL_RIGHT, 1, 0, 5, 0, 0));
          pages.add(new Page(article.content, SCROLL_ALL_RIGHT, 1, 0, 5, 0, 0));
        }
        } else {
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
        } else {
          pages.add(new Page("can't find...", TICKER, 0, 0, 60, 0, 30));
          pages.add(new Page(("...the calendar"), TICKER, 1, 0, 60, 0, 30));
        }
        break;
      }
    }
  }