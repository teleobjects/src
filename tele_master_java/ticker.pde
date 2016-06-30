class Ticker extends Teleobject {
  Ticker(PApplet _parent) {
    parent = _parent;
  }

  void init() {
    comm = new Comm(parent);
    comm.portNumber = "14111";
    comm.targetDeviceAddress = "FB:57:53:9C:DF:10";
    display = new TickerDisplay();
    comm.init();
  }

  void printPages() {
    switch (channel) {
      case SEARCH:
      int face = (int)random(16);
      pages.add(new Page("", LOOK, 65+face, 66+face, 0, 0, 0));
      break;

      case HELLO: 
      String hello = "What's up"+ (google.loggedin ? " "+profile.givenName : "") +"?";
      pages.add(new Page(hello, TICKER, 0, 0, 25, 10, 10));
      // pages.add(new Page("Entre los muchos filosofos con quienes tropece en las casas de huespedes que he recorrido, ninguno mas enamorado de la filosofia que mi amigo Amoros. Puede decirse que no vivia mas que para esta dama de sus pensamientos. El duro catre de la patrona, sus garbanzos no mucho mas blandos, sus insolencias, sus albondiguillas, eran para el sabrosas penitencias que ofrecia en holocausto a su adorada Metafisica.", TICKER, 0, 0, 20, 10, 0));
      break;

      case BYE:
      pages.add(new Page("", SLEEP, 0, 0, 0, 0, 0));
      break;

      case LOCATION:    
      if (!geolocation.updated) {
        pages.add(new Page("we're rather lost...", TICKER, 0, 0, 40, 0, 1));
        } else {
          pages.add(new Page(getCoordinate(geolocation.latitude, true)+" "+getCoordinate(geolocation.longitude, false), TICKER, 0, 0, 10, 0, 20));
          pages.add(new Page((geolocation.houseNumber+" "+geolocation.street).toUpperCase(), TICKER, 0, 0, 10, 0, 20));
          pages.add(new Page((geolocation.neighbourhood+" "+geolocation.postCode).toUpperCase(), TICKER, 0, 0, 20, 0, 20));
          pages.add(new Page((geolocation.city+", "+geolocation.state).toUpperCase(), TICKER, 0, 0, 20, 0, 30));
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
            pages.add(new Page(("hmmmm, can't find the instructions...").toLowerCase(), TICKER, 0, 0, 40, 0, 1));
          }
          break;

          case WEATHER:
          if (!weather.updated) {
            pages.add(new Page(("can't connect to the cloud...").toLowerCase(), TICKER, 0, 0, 40, 0, 1));
            } else {
              pages.add(new Page((weather.condition+" in "+geolocation.neighbourhood).toUpperCase(), TICKER, 0, 0, 5, 10, 20));
              pages.add(new Page("IT'S "+nf(metric ? getCelcius(weather.temp) : weather.temp, 0, 1) + (metric ? "°c" : "°f"), CENTERED, 1, 1, 10, 0, 10));
              pages.add(new Page(int(weather.humidity)+"% HUMID", CENTERED, 0, 0, 0, 0, 10));
              pages.add(new Page("PRESSURE "+int(weather.pressure)+"mPa", CENTERED, 0, 0, 0, 0, 10));
              pages.add(new Page("WIND "+int(weather.windSpeed) +"m/h "+(int)weather.windDeg+"° "+getHeading(weather.windDeg), CENTERED, 0, 0, 0, 0, 10));
              pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 20));
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
                  pages.add(new Page("current state " + network.state, TICKER, 0, 0, 10, 10, 20));
                  pages.add(new Page(network.roaming ? "roaming" : "not roaming", TICKER, 0, 0, 10, 0, 20));
                  } else { 
                    pages.add(new Page("sighs... no network available...", TICKER, 0, 0, 40, 0, 0));
                  }
                  break;


                  case BLUETOOTH:
                  if (comm != null) {
                    if (comm.connected) {
                      if (!android) {
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
                      pages.add(new Page("", BATTERY, 0, 0, 0, 0, 1));
                      break;

                      case DIM:
                      manager.play = true;
                      pages.add(new Page("", BRIGHTNESS, comm.brightness+3, 0, 0, 0, 1));
                      pages.add(new Page("", PING, 0, 0, 0, 0, 1));

                      break;

                      case ORIENTATION:
                      pages.add(new Page("", AXIS, 0, 0, 0, 0, 2));
                      break;

                      case TIME:
                      pages.add(new Page(getStringTime(true, ". "), CENTERED, 0, 0, 0, 0, 10));
                      break;

                      case EQ: 
                      manager.play = true;
                      comm.busy = false;
                      String str = "";
                      for (int i =0; i<32; i++) {
                        str += ticker.display.getEqChar(eq.eqData[i]);
                      }
                      pages.add(new Page(str, STREAM, 0, 0, 0, 0, 1));
                      break;

                      case GOOGLE:
                      if (google.loggedin) {
                        pages.add(new Page("What's up "+profile.givenName+"?", TICKER, 0, 0, 25, 10, 40));
                        pages.add(new Page(profile.id, SCROLL_PUSH_RIGHT, 0, 0, 5, 0, 20));
                        pages.add(new Page(profile.email.toUpperCase(), SCROLL_PUSH_RIGHT, 0, 0, 5, 0, 20));
                        pages.add(new Page("we are over "+profile.minAge, SCROLL_PUSH_RIGHT, 0, 0, 5, 0, 20));
                        pages.add(new Page("and speak English...", SCROLL_PUSH_RIGHT, 0, 0, 5, 0, 20));
                        } else {
                          pages.add(new Page("we gotta login to Google!", TICKER, 0, 0, 40, 0, 1));
                        }
                        break;

                        case CONTACTS:
                        if (contacts.updated) {
                          pages.add(new Page(("we've got "+contacts.contactList.size()+" friends!").toLowerCase(), SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 40));
                          pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 0));
                          for (Contact contact : contacts.contactList) {
                            pages.add(new Page(contact.title.toUpperCase(), SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 15));
                          }
                          } else {
                            pages.add(new Page("we gotta login to Google!", TICKER, 0, 0, 40, 0, 1));
                          }
                          break;

                          case NEWS:
                          if (news.updated) {
                            pages.add(new Page(("latest from NY Times"), SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 30));
                            pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 1));
                            for (Article article : news.articles) {
                              pages.add(new Page("", INSTANT, 0, 0, 0, 0, 5));
                              for (int i=0; i < article.keywords.size(); i++) {
                                String keyword = article.keywords.get(i);
                                pages.add(new Page(keyword.toUpperCase(), CENTERED, 0, 0, 0, 0, 10));
                              }
                              pages.add(new Page("", INSTANT, 0, 0, 0, 0, 5));
                              pages.add(new Page(article.title.toUpperCase(), SCROLL_ALL_RIGHT, 0, 0, 90, 0, 10));
                              pages.add(new Page(article.content.toUpperCase(), TICKER, 0, 0, 20, 10, 30));
                            }
                            } else {
                              pages.add(new Page(("where is the news paper?").toLowerCase(), TICKER, 0, 0, 30, 0, 1));
                            }
                            break;

                            case MAIL:
                            if (mail.updated) {
                              pages.add(new Page(("latest "+mail.mailList.size()+" emails!").toLowerCase(), SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 50));
                              pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 1));

                              for (Email email : mail.mailList) {
                                pages.add(new Page(email.date.toUpperCase(), SCROLL_CENTER_RIGHT, 0, 0, 20, 0, 20));
                                pages.add(new Page(email.sender.toUpperCase(), TICKER, 0, 0, 20, 20, 30));
                                pages.add(new Page(email.subject.toUpperCase(), TICKER, 0, 0, 20, 20, 30));
                                pages.add(new Page(email.snippet.toUpperCase()+"...", TICKER, 0, 0, 20, 20, 30));
                                pages.add(new Page("", BLANK, 0, 0, 10, 0, 0));
                              }
      } else { //
        pages.add(new Page("we gotta login to Google!", TICKER, 0, 0, 30, 0, 0));
      }
      break;

      case CALENDAR:
      if (calendar.updated) {
        pages.add(new Page("", TICKER, 0, 0, 0, 0, 1));
        pages.add(new Page(("do you rememember when...?").toLowerCase(), SCROLL_CENTER_RIGHT, 0, 0, 0, 0, 50));
        pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 1));
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
          pages.add(new Page("", TICKER, 0, 0, 0, 0, 1));
          pages.add(new Page("what's going on in twitter?", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 50));
          pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 20));
          pages.add(new Page("@"+twitter.screenName, TICKER, 0, 0, 30, 10, 20));
          if (twitter.description != null)  pages.add(new Page(twitter.description, TICKER, 0, 0, 30, 10, 20));
          if (twitter.location != null)  pages.add(new Page("@"+twitter.location, TICKER, 0, 0, 30, 10, 20));

          pages.add(new Page("trending in NYC", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 30));
          pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 1));
          for (String trend : twitter.trends) {
            pages.add(new Page(trend, CENTERED, 0, 0, 0, 0, 10));
          }

          pages.add(new Page(twitter.followers.size()+" FOLLOWERS", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 30));
          pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 1));
          for (String follower : twitter.followers) {
            pages.add(new Page("@"+follower, CENTERED, 0, 0, 0, 0, 10));
          }

          pages.add(new Page(twitter.friends.size()+" FRIENDS", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 30));
          pages.add(new Page("", SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 1));

          for (String friend : twitter.friends) {
            pages.add(new Page("@"+friend, CENTERED, 0, 0, 0, 0, 10));
          }
          } else {
            if (twitter.authenticating) {
              pages.add(new Page("just a sec, logging in to twitter!", TICKER, 0, 0, 60, 0, 1));
              } else {
                pages.add(new Page("oh no, twitter is down!", TICKER, 0, 0, 60, 0, 1));
              }
            }
            break;

            case NAVIGATION:
            manager.play = false;
            for (String place : places.placeList) {
              pages.add(new Page(place.toUpperCase(), SCROLL_PUSH_RIGHT, 0, 0, 0, 0, 1));
            }
            break;

            case RESULTS:
            manager.play = true;
            if (places.results.size() > 0) {
              pages.add(new Page("FOUND "+places.results.size()+" "+places.types+"s", TICKER, 0, 0, 30, 0, 20));
              for (String result : places.results) {
                pages.add(new Page(result.toUpperCase()+" is open", TICKER, 0, 0, 30, 10, 20));
              }
              } else {
                pages.add(new Page("no "+places.types+"around here!", TICKER, 0, 0, 60, 0, 1));
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
    // if (comm.connected) {
    //   if (manager.channel == NAVIGATION || manager.channel == RESULTS || manager.channel == ORIENTATION || manager.channel == CONTACTS) {
    //     if (!comm.busy && millis() > comm.lastTx + 500) {
    //       comm.writeString("", 200, 0,0,0,0,0);
    //     }
    //   }
    //   float tilt = comm.ay - 7;
    //   if (abs(tilt) < 10) tiltEngaged = false;
    //   if (millis() > lastTilt + 500 && abs(tilt) > 10 && !tiltEngaged) {
    //     lastTilt = millis();  
    //     manager.play = false;
    //     tiltEngaged = true;
    //     if (tilt > 0) {
    //       manager.setChannel(LEFT);    
    //     } 
    //     else {
    //       manager.setChannel(RIGHT);     
    //     }
    //   }
    //   float pitch = comm.ax;
    //   if (millis() > lastPitch + 500 ) {
    //     lastPitch = millis();
    //     if (pitch < -100 && pitch > -120) {
    //       manager.setChannel(UP);    
    //     } 
    //     else if (pitch > 100 && pitch < 120)  {
    //       manager.setChannel(DOWN);    
    //     }
    //   }
    // }
  }
}