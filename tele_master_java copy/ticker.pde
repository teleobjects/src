class Ticker extends Teleobject {

  Ticker(PApplet _parent) {
    parent = _parent;
  }

  // void setMode(int thisMode) {
  // println(thisMode);
  // }

  void init() {
    comm = new Comm(parent, this);
    comm.portNumber = "1411";
    comm.targetDeviceAddress = "FB:57:53:9C:DF:10";
    display = new TickerDisplay();
    comm.init();
  }

  void printPages() {
    switch (channel) {
      case STATUS:
      int sp = 5;
      //String hi = "Hi"+ (google.loggedin ? " "+profile.givenName : "");
      pages.add(new Page("SYSTEM", TICKER, 0, 0, 60, 0, 10));
      // pages.add(new Page(".", COUNTER, 1, 0, 30, 0, 9));
      // pages.add(new Page("", BLANK, 0, 0, 30, 0, 10));
      pages.add(new Page( nf(hour(), 2, 0) + nf(minute(), 2, 0) + nf(second(), 2, 0), CLOCK, 1, 1, 0, 0, sp));
      pages.add(new Page(time.month +" / "+time.day +" / "+ time.year, CENTERED, 1, 1, 0, 0, sp));
      pages.add(new Page("", BATTERY, 0, 0, 0, 0, sp));
      pages.add(new Page("", BRIGHTNESS, 0, 0, 0, 0, sp));
      pages.add(new Page("", SENSORS, 0, 0, 0, 0, sp));
      pages.add(new Page("", AXIS, 0, 0, 0, 0, sp));
      pages.add(new Page("", COMPASS, 0, 0, 0, 0, sp));
      pages.add(new Page(getCoordinate(geolocation.latitude, true)+"    "+getCoordinate(geolocation.longitude, false), CENTERED, 0, 0, 0, 0, sp));

      if (comm.connected) {
        if (!androidMode) {
          pages.add(new Page("we're tethered to "+comm.portName, TICKER, 0, 0, 25, sp, sp));
        } else {
          pages.add(new Page("bluetooth "+comm.deviceAddress, TICKER, 0, 0, 25, sp, sp));
          pages.add(new Page(""+comm.deviceRssi+" dB signal strength", TICKER, 0, 0, 25, sp, sp));
        }
      }

      if (network.wifi) {
        if(androidMode) {
          pages.add(new Page("wifi network " + network.extra, TICKER, 0, 0, 25, sp, sp));
          pages.add(new Page("mac address " + network.mac.toUpperCase(), TICKER, 0, 0, 25, sp, sp));
          pages.add(new Page("our state is " + network.state, TICKER, 0, 0, 25, sp, sp));
          pages.add(new Page("signal strength " + network.rssi + "dB", TICKER, 0, 0, 25, sp, sp));
          pages.add(new Page("link speed " + network.linkSpeed + "Mbsp", TICKER, 0, 0, 25, sp, sp));
          pages.add(new Page("frequency " + network.frequency+" Mhz", TICKER, 0, 0, 25, sp, sp));
        }
        if (network.hostName != null) { 
          pages.add(new Page("our host is "+network.hostName, TICKER, 0, 0, 25, sp, sp));
        }
        pages.add(new Page("our local ip is " + network.hostIP, TICKER, 0, 0, 25, sp, sp));
      } else { 
        pages.add(new Page("our wifi is disabled, damn!", TICKER, 0, 0, 25, 0, sp));
      }

      if (network.cellular) {
        pages.add(new Page("we're connected to cellular network" + network.extra, TICKER, 0, 0, 25, sp, sp));
        pages.add(new Page("with a " + network.type + " link", TICKER, 0, 0, 25, sp, sp));
        pages.add(new Page("our local ip is " + network.hostIP, TICKER, 0, 0, 25, sp, sp));
      }

      if (network.online) {
        pages.add(new Page("our external ip is "+network.externalIP + ", and we reach the cloud in " + network.pingTime + "ms", TICKER, 0, 0, 25, sp, sp));
      } else {
        pages.add(new Page("we're offline. that sucks...", TICKER, 0, 0, 25, 0, sp));
      }

      pages.add(new Page("it's "+time.dayStr, TICKER, 0, 0, 25, 0, sp));
      pages.add(new Page(time.monthStr+" " + time.day+"th, "+time.year, TICKER, 0, 0, 25, 0, sp));
      pages.add(new Page("we are at "+(int)geolocation.latitude+" degrees North and "+abs((int)geolocation.longitude)+" degrees West", TICKER, 0, 0, 25, sp, sp));
      pages.add(new Page("that seems to be at "+(geolocation.formattedAddress), TICKER, 0, 0, 25, sp, sp));

      if (!weather.updated) {
        pages.add(new Page(("no idea about the weather...").toLowerCase(), TICKER, 0, 0, 25, sp, sp));
      } else {
        pages.add(new Page("right now, "+(weather.condition+" around "+weather.station), TICKER, 0, 0, 25, sp, sp));
        pages.add(new Page("looks like it's "+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + " degrees " +(metric ? "celsius" : "farenheit") + " out there", TICKER, 0, 0, 25, sp, sp));
        pages.add(new Page("with a "+int(weather.humidity)+" per cent of humidity", TICKER, 0, 0, 25, sp, sp));
        pages.add(new Page("nice pressure of "+int(weather.pressure)+" milibars", TICKER, 0, 0, 25, sp, sp));
        pages.add(new Page("and a soft breeze of "+int(weather.windSpeed) +" miles per hour from the "+getHeading(weather.windDeg), TICKER, 0, 0, 25, sp, sp));
        // pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));
      }

      break;

      case ENVIRONMENT:
      pages.add(new Page("2", SENSORS, 0, 0, 0, 0, 0));
      break;

      case SEARCH:
      int face = (int)random(16);
      pages.add(new Page("", LOOK, 65+face, 66+face, 0, 0, 0));
      break;

      case HELLO: 
      String hello = "What's up"+ (google.loggedin ? " "+profile.givenName : "") +"?";
      pages.add(new Page(hello, TICKER, 0, 0, 25, 10, 10));
      break;

      case BYE:
      pages.add(new Page("", SLEEP, 0, 0, 0, 0, 0));
      break;

      // case NAVIGATION:
      // pages.add(new Page("", COMPASS, 0, 0, 0, 0, 0));
      // break;

      case LOCATION:    
      if (!geolocation.updated) {
        pages.add(new Page("we're rather lost...", TICKER, 0, 0, 40, 0, 1));
      } else {
        pages.add(new Page(getCoordinate(geolocation.latitude, true)+" "+getCoordinate(geolocation.longitude, false), TICKER, 0, 0, 20, 0, 20));
        pages.add(new Page((geolocation.formattedAddress).toUpperCase(), TICKER, 0, 0, 20, 20, 20));
        // String roadInfo = "";
        // if (geolocation.houseNumber != null) roadInfo += geolocation.houseNumber+" ";
        // roadInfo += geolocation.street.toUpperCase();
        // pages.add(new Page(roadInfo, TICKER, 0, 0, 10, 0, 20));
        // if (geolocation.neighbourhood != null) {
        //   pages.add(new Page(geolocation.neighbourhood.toUpperCase(), TICKER, 0, 0, 20, 0, 20));
        // }
        // pages.add(new Page(geolocation.city.toUpperCase() + ", " + geolocation.postCode, TICKER, 0, 0, 20, 0, 20));
        // pages.add(new Page((geolocation.county+ ", " + geolocation.state).toUpperCase(), TICKER, 0, 0, 20, 0, 30));
      }
      break;

      case DRIVE:
      if (drive.updated) {
        for (int i=0; i<drive.driveContent.length; i++) {
          String thisLine = drive.driveContent[i];
          String items[] = splitTokens(thisLine, TAB+"");
          if (items.length > 5) {
            String content = "";
            if (items.length>6) content = items[6];
            pages.add(new Page(content, parseInt(items[0]), parseInt(items[1]), parseInt(items[2]), parseInt(items[3]), parseInt(items[4]), parseInt(items[5])));
          }
        }
      } else {
        pages.add(new Page(("hmmmm, can't find the file...").toLowerCase(), TICKER, 0, 0, 40, 0, 1));
      }
      break;

      case WEATHER:
      if (!weather.updated) {
        pages.add(new Page(("can't connect to the cloud...").toLowerCase(), TICKER, 0, 0, 40, 0, 1));
      } else {
        pages.add(new Page((weather.condition+" in "+weather.station).toUpperCase(), SCROLL, 0, 0, 40, 0, 20));
        pages.add(new Page("IT'S "+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + (metric ? "°c" : "°f"), CENTERED, 1, 1, 10, 0, 10));
        pages.add(new Page(int(weather.humidity)+"% HUMID", CENTERED, 0, 0, 0, 0, 10));
        pages.add(new Page("PRESSURE "+int(weather.pressure)+"mPa", CENTERED, 0, 0, 0, 0, 10));
        pages.add(new Page("WIND "+int(weather.windSpeed) +"m/h "+(int)weather.windDeg+"° "+getHeading(weather.windDeg), CENTERED, 0, 0, 0, 0, 10));
        pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));
      }
      break;

      case ONLINE:
      if (network.online) {
        pages.add(new Page("ip "+network.externalIP + " ping " + network.pingTime + "ms", TICKER, 0, 0, 10, 0, 0));
      } else {
        pages.add(new Page("we're offline. that sucks...", TICKER, 0, 0, 40, 0, 0));
      }
      break;

      case WIFI:
      if (network.wifi) {
        pages.add(new Page(network.hostName+"@" + network.hostIP, TICKER, 0, 0, 10, 0, 0));
      } else { 
        pages.add(new Page("wifi is disabled, damn!", TICKER, 0, 0, 40, 0, 0));
      }
      break;

      case MOBILE:
      if (network.networked) {
        pages.add(new Page("connected to " + network.extra, TICKER, 0, 0, 10, 10, 20));
        pages.add(new Page("through " + network.type, TICKER, 0, 0, 10, 10, 20));
        pages.add(new Page("state " + removeSpaces(network.state), TICKER, 0, 0, 10, 10, 20));
        pages.add(new Page(network.roaming ? "roaming" : "not roaming", TICKER, 0, 0, 10, 0, 20));
      } else { 
        pages.add(new Page("sighs... no network available...", TICKER, 0, 0, 40, 0, 0));
      }
      break;

      case BLUETOOTH:
      if (comm != null) {
        if (comm.connected) {
          if (!androidMode) {
            pages.add(new Page(comm.portName, TICKER, 0, 0, 10, 0, 0));
          } else {
            pages.add(new Page(comm.deviceAddress+" "+comm.deviceRssi+"dB", TICKER, 0, 0, 10, 0, 0));
          }
        } else {
          pages.add(new Page("not connected...", TICKER, 0, 0, 40, 0, 0));
        }
      }
      break;

      case ENERGY:
      pages.add(new Page("", BATTERY, 0, 0, 0, 0, 0));
      break;

      case DIM:
      manager.play = true;
      pages.add(new Page("", BRIGHTNESS, comm.brightness, 0, 0, 0, 0));
      // pages.add(new Page("", PING, 0, 0, 0, 0, 0));
      break;

      case ORIENTATION:
      pages.add(new Page("", AXIS, 0, 0, 0, 0, 0));
      break;

      case NAVIGATION:
      pages.add(new Page("", COMPASS, 0, 0, 0, 0, 0));
      break;

      case TIME:
      String hour_ = nf(hour(), 2, 0);
      String minute_ = nf(minute(), 2, 0);
      String second_ = nf(second(), 2, 0);
      pages.add(new Page(hour_ + minute_ + second_, CLOCK, 1, 1, 0, 0, 0));  
      break;

      case KARAOKE:
      manager.play = true;
      //comm.busy = false;
      String nextLine = karaoke.update().toUpperCase();
      if (!nextLine.equals("")) {
        if (nextLine.length() > 32) {
          int breakX = findLastChar(nextLine.substring(0, int(nextLine.length()/1.6)), ' ');
          int next = karaoke.nextTime;

          int delay = int(breakX/1.6);
          if (delay < 6) delay = 6;
          if (delay > next/2) delay = next/2;

          // if (delay > next - 2) delay = next - 2;
          pages.add(new Page(nextLine.substring(0, breakX), CENTERED, 0, 0, 0, 0, delay));
          delay = int((nextLine.length()-breakX)/1.6);
          if (delay < 6) delay = 6;
          if (delay > next/2) delay = next/2;

          pages.add(new Page(nextLine.substring(breakX+1, nextLine.length()), CENTERED, 0, 0, 0, 0, delay));
        } else {
          int delay = int(nextLine.length()/1.6);
          int next = karaoke.nextTime;
          if (delay < 6) delay = 6;
          if (delay > next-2) delay = next-2;
          pages.add(new Page(nextLine, CENTERED, 0, 0, 0, 0, delay));
        }
      } else {
        String str = "";
        for (int i =0; i<32; i++) {
          // if (eq.eqDataNibble[i] == 0) eq.eqDataNibble[i] = 1;
          // println(eq.eqDataNibble[i]);
          str = str + char((eq.eqData[i]/2) + 48);
        }
        pages.add(new Page(str, SPECTRUM, 0, 0, 0, 0, 2));
      }
      break;

      case EQ: 
      manager.play = true;

      String str = "";
      for (int i =0; i<32; i++) {
        // if (eq.eqDataNibble[i] == 0) eq.eqDataNibble[i] = 1;
        // println(eq.eqDataNibble[i]);
        str = str + char((eq.eqData[i]/2) + 48);
      }
      // println("eq "+str);
      pages.add(new Page(str, SPECTRUM, 0, 0, 0, 0, 1));
      //pages.add(new Page("HELO", STREAM, 0, 0, 0, 0, 5));

      break;

      case GOOGLE:
      if (google.loggedin) {
        pages.add(new Page("What's up "+profile.givenName+"?", TICKER, 0, 0, 25, 10, 20));
        pages.add(new Page(profile.email, SCROLL, 0, 1, 5, 1, 20));
        pages.add(new Page("id "+profile.id, SCROLL, 0, 1, 5, 1, 20));
        pages.add(new Page("we are over "+profile.minAge, SCROLL, 0, 1, 5, 1, 20));
        pages.add(new Page("and speak English...", SCROLL, 0, 1, 5, 1, 20));
      } else {
        pages.add(new Page("we gotta login to Google!", TICKER, 0, 0, 40, 0, 1));
      }
      break;

      case CONTACTS:
      if (contacts.updated) {
        pages.add(new Page(("we've got "+contacts.contactList.size()+" friends!").toLowerCase(), SCROLL, 0, 1, 0, 0, 40));
        pages.add(new Page("", SCROLL, 0, 0, 1, 1, 0));
        for (Contact contact : contacts.contactList) {
          pages.add(new Page(contact.title.toUpperCase(), SCROLL, 0, 1, 0, 1, 0));
        }
      } else {
        pages.add(new Page("we gotta login to Google!", TICKER, 0, 0, 40, 0, 0));
      }
      break;

      case NEWS:
      if (news.updated) {
        pages.add(new Page(("latest from NY TIMES"), SCROLL, 0, 1, 0, 0, 20));
        pages.add(new Page("", SCROLL, 0, 2, 0, 1, 0));
        for (Article article : news.articles) {
          for (int i=0; i < article.keywords.size(); i++) {
            String keyword = article.keywords.get(i);
            pages.add(new Page(keyword.toUpperCase(), CENTERED, 0, 0, 0, 0, 7));
            pages.add(new Page("", BLANK, 0, 0, 0, 0, 3));
          }
          pages.add(new Page(article.title.toUpperCase(), SCROLL, 0, 0, 40, 0, 1));
          pages.add(new Page(article.content.toUpperCase(), TICKER, 0, 0, 20, 10, 30));
        }
      } else {
        pages.add(new Page(("where is the newspaper?").toLowerCase(), TICKER, 0, 0, 30, 0, 0));
      }
      break;

      case MAIL:
      if (mail.updated) {
        pages.add(new Page(("latest "+mail.mailList.size()+" emails!").toLowerCase(), SCROLL, 0, 1, 0, 0, 20));
        pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));

        for (Email email : mail.mailList) {
          pages.add(new Page(email.date.toUpperCase(), SCROLL, 0, 1, 20, 0, 20));
          pages.add(new Page(email.sender.toUpperCase(), TICKER, 0, 0, 20, 10, 20));
          pages.add(new Page(email.subject.toUpperCase(), TICKER, 0, 0, 20, 10, 20));
          pages.add(new Page(email.snippet.toUpperCase()+"...", TICKER, 0, 0, 20, 10, 20));
          pages.add(new Page("", BLANK, 0, 0, 10, 0, 0));
        }
      } else {
        pages.add(new Page("we gotta login to Google!", TICKER, 0, 0, 30, 0, 0));
      }
      break;

      case CALENDAR:
      if (calendar.updated) {
        pages.add(new Page(("do you rememember when...?").toLowerCase(), SCROLL, 0, 1, 0, 0, 50));
        pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));
        for (int i=0; i<50; i++) { 
          Event event = calendar.eventList.get((int)random(calendar.eventList.size()));
          pages.add(new Page(event.date.toUpperCase(), CENTERED, 0, 0, 0, 0, 20));
          pages.add(new Page(event.summary.toUpperCase(), TICKER, 0, 0, 50, 10, 30));
        }
      } else {
        pages.add(new Page("can't seem to find our calendar", TICKER, 0, 0, 30, 0, 30));
      }
      break;

      case TWITTER:
      if (twitter.updated) {
        pages.add(new Page("what's going on in TWITTER?", SCROLL, 0, 1, 0, 0, 20));
        pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));
        pages.add(new Page("@"+twitter.screenName, TICKER, 0, 0, 30, 10, 20));
        if (twitter.location != null)  pages.add(new Page(twitter.location, TICKER, 0, 0, 30, 10, 20));
        if (twitter.description != null)  pages.add(new Page(twitter.description, TICKER, 0, 0, 30, 10, 20));
        pages.add(new Page("trending in NYC", SCROLL, 0, 1, 0, 0, 20));
        pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));
        for (String trend : twitter.trends) {
          pages.add(new Page(trend, CENTERED, 0, 0, 0, 0, 10));
        }
        pages.add(new Page(twitter.followers.size()+" FOLLOWERS", SCROLL, 0, 1, 0, 1, 20));
        pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));
        for (String follower : twitter.followers) {
          pages.add(new Page("@"+follower, CENTERED, 0, 0, 0, 0, 10));
        }
        pages.add(new Page(twitter.friends.size()+" FRIENDS", SCROLL, 0, 1, 0, 1, 20));
        pages.add(new Page("", SCROLL, 0, 0, 0, 1, 0));
        for (String friend : twitter.friends) {
          pages.add(new Page("@"+friend, CENTERED, 0, 0, 0, 0, 10));
        }
      } else {
        if (twitter.authenticating) {
          pages.add(new Page("just a sec, logging in to TWITTER!", TICKER, 0, 0, 50, 0, 1));
        } else {
          pages.add(new Page("oh", SCROLL, 1, 3, 25, 0, 5));
          pages.add(new Page("no", SCROLL, 1, 3, 25, 0, 15));
          pages.add(new Page("twitter", SCROLL, 1, 3, 25, 0, 5));
          pages.add(new Page("is", SCROLL, 1, 3, 25, 0, 5));
          pages.add(new Page("down", SCROLL, 1, 3, 25, 0, 20));
        }
      }
      break;

      // case NAVIGATION:
      // manager.play = false;
      // for (String place : places.placeList) {
      //   pages.add(new Page(place.toUpperCase(), SCROLL, 0, 0, 0, 1, 0));
      // }
      // break;

      case RESULTS:
      manager.play = true;
      if (places.results.size() > 0) {
        pages.add(new Page("FOUND "+places.results.size()+" "+places.types+"s", TICKER, 0, 0, 30, 0, 20));
        for (String result : places.results) {
          pages.add(new Page(result.toUpperCase()+" is open", TICKER, 0, 0, 30, 10, 20));
        }
      } else {
        pages.add(new Page("no "+places.types+" around here!", TICKER, 0, 0, 60, 0, 1));
      }
      break;
    }

    // if (channel != ENERGY && channel != HELLO && channel != BYE) {
    //   int payload = 0;
    //   for (Page page : pages) {
    //     payload += page.content.length();
    //   }
    //   reel.pages.add(new Page("", INSTANT, 0, 23, int(payload/5), 0, 5));
    // }
  }

  void checkSensors() {
  }
}