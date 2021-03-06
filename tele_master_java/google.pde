////////////////////////
// GOOGLE
////////////////////////

String CLIENT_ID;
String CLIENT_SECRET;
String REFRESH_TOKEN;
String ACCESS_TOKEN;
String CALLBACK_ID;

class Google {
  boolean loggedin;
  boolean logging;
  boolean authenticating;

  String[] keys;

  Google() {
    if (credentials.credentials != null) {
      String[] items = splitTokens(credentials.credentials[1], ",");
      CLIENT_ID = items[0];
      CLIENT_SECRET = items[1];
    }
    //login();
  }

  void login() {
    if (authenticating) {
      runFinalizeOAuthChoreo();
      authenticating = false;
      profile.update();
      loggedin = true;
      logging = false;
      manager.setChannel(GOOGLE);
    } else {
      authenticate();
    }
  }

  void logout() {
    deleteFile("google.txt");
    loggedin = false;
    logging = false;
    authenticating = false;
    REFRESH_TOKEN = null;
    ACCESS_TOKEN = null;
    profile = new Profile();
    google = new Google();
    contacts = new GoogleContacts();
    calendar = new GoogleCalendar();
  }

  void authenticate() {
    try {
      keys = loadStrings("tmp/google.txt");
      if (keys != null) {
        REFRESH_TOKEN = keys[0];
        ACCESS_TOKEN = keys[1];
      }
    } 
    catch (Exception e) {
      println("error");
    }
    if (REFRESH_TOKEN == null) {
      if (network.online) {
        runInitializeOAuthChoreo();
      }
    } else {
      profile.update();
      loggedin = true;
      logging = false;
      manager.setChannel(GOOGLE);
    }
  }

  void runInitializeOAuthChoreo() {
    com.temboo.Library.Google.OAuth.InitializeOAuth initializeOAuthChoreo = new com.temboo.Library.Google.OAuth.InitializeOAuth(session);
    initializeOAuthChoreo.setClientID(CLIENT_ID);
    String scopes = "http://www.google.com/m8/feeds/";
    scopes += " https://www.googleapis.com/auth/drive";
    scopes += " https://www.googleapis.com/auth/userinfo.email";
    scopes += " https://www.googleapis.com/auth/userinfo.profile";
    scopes += " http://www.google.com/m8/feeds/";
    scopes += " https://spreadsheets.google.com/feeds/";
    scopes += " https://www.googleapis.com/auth/calendar";
    scopes += " https://www.googleapis.com/auth/plus.login";
    scopes += " https://www.googleapis.com/auth/plus.profile.emails.read";
    scopes += " https://mail.google.com/";
    initializeOAuthChoreo.setScope(scopes);
    com.temboo.Library.Google.OAuth.InitializeOAuthResultSet initializeOAuthResults = initializeOAuthChoreo.run();
    link(initializeOAuthResults.getAuthorizationURL());
    CALLBACK_ID = initializeOAuthResults.getCallbackID();
    authenticating = true;
  }

  void runFinalizeOAuthChoreo() {
    com.temboo.Library.Google.OAuth.FinalizeOAuth finalizeOAuthChoreo = new com.temboo.Library.Google.OAuth.FinalizeOAuth(session);
    finalizeOAuthChoreo.setCallbackID(CALLBACK_ID);
    finalizeOAuthChoreo.setClientID(CLIENT_ID);
    finalizeOAuthChoreo.setClientSecret(CLIENT_SECRET);
    com.temboo.Library.Google.OAuth.FinalizeOAuthResultSet finalizeOAuthResults = finalizeOAuthChoreo.run();
    println(finalizeOAuthResults.getErrorMessage());
    println(finalizeOAuthResults.getExpires());
    println(finalizeOAuthResults.getRefreshToken());
    ACCESS_TOKEN = finalizeOAuthResults.getAccessToken();
    REFRESH_TOKEN = finalizeOAuthResults.getRefreshToken();
    keys = new String[2];
    keys[0] = REFRESH_TOKEN;
    keys[1] = ACCESS_TOKEN;
    saveLocal("google.txt", keys);
  }
}

/////////////////////////////////////
// PROFILE
/////////////////////////////////////

class Profile {
  String nickname, email, url, familyName, givenName, objectType, id, kind, language;
  int minAge;
  PImage img = null;
  boolean updated;
  long lastUpdated;

  Profile () {
  }

  void update() {
    JSONObject choreo = null;
    try {
      String[] choreoBuffer = loadLocal("profile.json");
      choreo = JSONObject.parse(concatenate(choreoBuffer));
    } 
    catch (Exception e) {
      if (network.online) {
        choreo = runGetChoreo();
        String[] choreoBuffer = { choreo.toString()};
        saveLocal("profile.json", choreoBuffer);
      }
    }
    if (choreo != null) {
      email = choreo.getJSONArray("emails").getJSONObject(0).getString("value");
      url = choreo.getJSONObject("image").getString("url");
      url = profile.url.substring(0, url.length()-6);
      familyName = choreo.getJSONObject("name").getString("familyName");
      givenName = choreo.getJSONObject("name").getString("givenName");
      objectType = choreo.getString("objectType");
      id = choreo.getString("id");
      kind = choreo.getString("kind");
      language = choreo.getString("language");
      minAge = choreo.getJSONObject("ageRange").getInt("min");
      try {
        //img = loadLocalImage(id+".png");
      } 
      catch (Exception e) {
      }
      if (img == null) {
        //img = loadImage(url);
        //saveLocal(id+".png", img);
      }
      updated = true;
    }
  }

  JSONObject runGetChoreo() {
    Get getChoreo = new Get(session);
    getChoreo.setClientID(CLIENT_ID);
    getChoreo.setClientSecret(CLIENT_SECRET);
    getChoreo.setRefreshToken(REFRESH_TOKEN);
    getChoreo.setUserID("me");
    //getChoreo.addOutputFilter("nickname", "nickname", "Response");
    GetResultSet getResults = getChoreo.run();
    //println(getResults.getNewAccessToken());
    JSONObject response = JSONObject.parse(getResults.getResponse());
    return response;
  }
}

/////////////////////////////////////
// DRIVE
/////////////////////////////////////

class GoogleMail {
  ArrayList<Email> mailList = new ArrayList<Email>();
  boolean updated;
  int maxEmails = 5;

  void update() {
    if (google.loggedin && network.online) {
      mailList = new ArrayList<Email>();
      JSONObject emailList = runListMessagesChoreo();
      JSONArray itemsArray = emailList.getJSONArray("messages");
      for (int i = 0; i<itemsArray.size(); i++) {
        String id = itemsArray.getJSONObject(i).getString("id");
        JSONObject emailObject = runGetMessageChoreo(id);
        Email email = new Email();
        email.id = id;
        email.snippet = emailObject.getString("snippet");
        JSONArray headers = emailObject.getJSONObject("payload").getJSONArray("headers");
        for (int j = 0; j<headers.size(); j++) {
          JSONObject header = headers.getJSONObject(j);
          if (header.getString("name").equals("Subject")) email.subject = header.getString("value");
          if (header.getString("name").equals("From")) email.sender = header.getString("value");
          if (header.getString("name").equals("Date")) email.date = header.getString("value").substring(0, 25);
        }
        println(email.subject +" "+email.sender);
        email.fix();
        mailList.add( email);
      }
      updated = true;
    }
  }

  JSONObject runListMessagesChoreo() {
    ListMessages listMessagesChoreo = new ListMessages(session);
    listMessagesChoreo.setRefreshToken(REFRESH_TOKEN);
    listMessagesChoreo.setClientSecret(CLIENT_SECRET);
    listMessagesChoreo.setClientID(CLIENT_ID);
    listMessagesChoreo.setMaxResults(maxEmails);
    listMessagesChoreo.setQuery("is:unread");
    ListMessagesResultSet listMessagesResults = listMessagesChoreo.run();

    ACCESS_TOKEN = listMessagesResults.getNewAccessToken();
    // String result = listMessagesResults.getResponse();
    JSONObject response = JSONObject.parse(listMessagesResults.getResponse());
    return response;
  }

  JSONObject runGetMessageChoreo(String id) {
    GetMessage getMessageChoreo = new GetMessage(session);
    getMessageChoreo.setRefreshToken(REFRESH_TOKEN);
    getMessageChoreo.setClientSecret(CLIENT_SECRET);
    getMessageChoreo.setClientID(CLIENT_ID);
    getMessageChoreo.setMessageID(id);
    GetMessageResultSet getMessageResults = getMessageChoreo.run();
    ACCESS_TOKEN =  getMessageResults.getNewAccessToken();
    JSONObject response = JSONObject.parse(getMessageResults.getResponse());
    return response;
  }
}

class Email {
  String sender, date, subject, id, snippet;

  void fix() {
    if (sender.indexOf("<") != -1 &&  sender.indexOf("<") > 0) {

      sender = sender.substring(0, sender.indexOf("<")-1);
    }
    sender = removeQuotes(sender);
  }
}


/////////////////////////////////////
// DRIVE
/////////////////////////////////////

class GoogleDrive {
  boolean updated;
  String[] driveContent;
  ArrayList<String> commands;

  GoogleDrive () {
  }

  void update() {
    if (network.online && false) {
      String logId = "1nDJ7lBSpylE5ORHF6xTntc4N9iqq8m3j_LW7Ok5K8RQ";
      String driveUrl = "https://docs.google.com/spreadsheets/d/"+logId+"/export?format=tsv&id="+logId;
      driveContent = loadUrl(driveUrl);
    } else {
      driveContent = loadStrings("tsv/drive.tsv");
    }
    if (driveContent != null) {
      updated = true;
    }
  }

  // ArrayList<String> getPages() {
  //   update();
  //   return drives;
  // }

  // void runAppendRowChoreo(String content) {
  //   AppendRow appendRowChoreo = new AppendRow(session);
  //   appendRowChoreo.setClientID(CLIENT_ID);
  //   appendRowChoreo.setRefreshToken(REFRESH_TOKEN);
  //   appendRowChoreo.setClientSecret(CLIENT_SECRET);
  //   appendRowChoreo.setSpreadsheetTitle("tele_log");
  //   retrieveRowChoreo.setWorksheetName("tele_log");
  //   appendRowChoreo.setRowData(content);
  //   AppendRowResultSet appendRowResults = appendRowChoreo.run();
  //   //if (ACCESS_TOKEN == null) {
  //   //ACCESS_TOKEN = appendRowResults.getNewAccessToken();
  //   //}
  //   println(appendRowResults.getResponse());
  // }

  // void runRetrieveRowChoreo() {
  //   RetrieveRow retrieveRowChoreo = new RetrieveRow(session);
  //   retrieveRowChoreo.setClientID(CLIENT_ID);
  //   retrieveRowChoreo.setRefreshToken(REFRESH_TOKEN);
  //   retrieveRowChoreo.setClientSecret(CLIENT_SECRET);
  //   retrieveRowChoreo.setSpreadsheetName("tele_log");
  //   retrieveRowChoreo.setWorksheetName("tele_log");
  //   RetrieveRowResultSet retrieveRowResults = retrieveRowChoreo.run();
  //   println(retrieveRowResults.getRowData());
  //   //if (ACCESS_TOKEN == "") {
  //   //ACCESS_TOKEN = retrieveRowResults.getNewAccessToken();
  //   //}
  // }
}

/////////////////////////////////////
// CONTACTS
/////////////////////////////////////

class GoogleContacts {
  String contactsData;
  ArrayList<Contact> contactList;
  int maxContacts = 5000;
  boolean updated;

  GoogleContacts () {
    contactList = new ArrayList<Contact>();
  }

  void update() {
    if (google.loggedin) {

      XML contactsXML = null;
      try {
        contactsXML = loadXML((androidMode ? "data\\tmp\\" : "data/tmp/") + "contacts.xml");
      } 
      catch (Exception e) {
        println("error loading contacts.xml");
      }

      if (contactsXML == null) {
        println("getting contacts");
        String contactsBuffer = runGetAllContactsChoreo();
        contactsXML = parseXML (contactsBuffer);
        saveXML(contactsXML, (androidMode ?  "data\\tmp\\" : "data/tmp/") + "contacts.xml");
      }

      if (contactsXML != null) {
        XML[] entries = contactsXML.getChildren("entry");
        for (int i = 1; i < entries.length; i++) {
          Contact contact = new Contact();
          contact.title = entries[i].getChild("title").getContent();
          // XML names = entries[i].getChild("gd:name");
          // if (names.getChild("gd:fullName").getContent() !=null && names.getChild("gd:fullName").getContent()!=null) contact.fullName = names.getChild("gd:fullName").getContent();
          // if (names.getChild("gd:givenName").getContent() !=null  && names.getChild("gd:givenName").getContent()!=null) contact.givenName = names.getChild("gd:givenName").getContent();
          // if (names.getChild("gd:familyName") !=null && names.getChild("gd:familyName").getContent()!=null) contact.familyName = names.getChild("gd:familyName").getContent();
          if (entries[i].getChild("gd:email") !=null ) contact.email = entries[i].getChild("gd:email").getString("address").toLowerCase();
          if (entries[i].getChild("gd:phoneNumber") !=null ) contact.phoneNumber = entries[i].getChild("gd:phoneNumber").getContent();
          if (entries[i].getChild("link") != null) {
            if (entries[i].getChild("link").hasAttribute("gd:etag")) {
              contact.url = entries[i].getChild("link").getString("href");
              if (contact.url != null) {
                try {
                  //contact.img = loadLocalImage(contact.email+".png");
                  // println(contact.url);
                } 
                catch (Exception e) {                
                  //String url = contact.url+"?access_token="+ACCESS_TOKEN;
                  //downloadByteArrayAsImage(url, contact.email);
                }
                if (contact.title.length() >0) contactList.add(contact);
              }
            }
          }
        }
        updated = true;
      }
    }
  }

  String runGetAllContactsChoreo() {
    GetAllContacts getAllContactsChoreo = new GetAllContacts(session);
    getAllContactsChoreo.setRefreshToken(REFRESH_TOKEN);
    getAllContactsChoreo.setClientSecret(CLIENT_SECRET);
    getAllContactsChoreo.setClientID(CLIENT_ID);
    getAllContactsChoreo.setMaxResults(maxContacts);
    GetAllContactsResultSet getAllContactsResults = getAllContactsChoreo.run();
    ACCESS_TOKEN = getAllContactsResults.getAccessToken();
    return getAllContactsResults.getResponse();
  }
}

class Contact {
  String title;
  String fullName;
  String givenName;
  String familyName;
  String email;
  String phoneNumber;
  String url;
  PImage img;

  // void fix() {
  //   if (title.length() == 0) {
  //     title = fullName;
  //   }
  //   if (title.length() == 0) {
  //     title = givenName+" "+familyName;
  //   }
  //   if (title.length() == 0) {
  //     title = email;
  //   }
  // }
}

/////////////////////////////////////
// CALENDAR
/////////////////////////////////////


class GoogleCalendar {
  ArrayList<Event> eventList;
  boolean updated;

  GoogleCalendar () {
    eventList = new ArrayList<Event>();
  }

  void update() {
    if (google.loggedin && network.online) {

      eventList = new ArrayList<Event>();
      JSONObject eventsObject = runGetAllEventsChoreo();
      JSONArray itemsArray = eventsObject.getJSONArray("items");
      for (int i = 0; i<itemsArray.size(); i++) {
        JSONObject thisItem = itemsArray.getJSONObject(itemsArray.size()-i-1);
        println(thisItem.toString());
        Event event = new Event();
        event.summary = thisItem.getString("summary");
        event.dateRaw = thisItem.getString("created");
        event.fix();
        eventList.add(event);
      }  
      updated = true;
      println(eventList.size()+" events");
    }
  }

  JSONObject runGetAllEventsChoreo() {
    // println(loadStrings("https://www.googleapis.com/calendar/v3/calendars/primary/events&access_token="+ACCESS_TOKEN));
    GetAllEvents getAllEventsChoreo = new GetAllEvents(session);
    getAllEventsChoreo.setRefreshToken(REFRESH_TOKEN);
    getAllEventsChoreo.setClientSecret(CLIENT_SECRET);
    getAllEventsChoreo.setClientID(CLIENT_ID);
    getAllEventsChoreo.setCalendarID("primary");
    // getAllEventsChoreo.setMaxResults(2500);
    // getAllEventsChoreo.setSingleEvents("true");
    getAllEventsChoreo.setResponseFormat("json");
    GetAllEventsResultSet getAllEventsResults = getAllEventsChoreo.run();
    // println(getAllEventsResults.getNewAccessToken());
    return JSONObject.parse(getAllEventsResults.getResponse());
  }
}

class Event {
  String summary;
  String dateRaw, date;
  int day, month, year;
  Event() {
  }

  void fix() {
    //print(dateRaw);
    year = parseInt(dateRaw.substring(0, 4));
    month = parseInt(dateRaw.substring(5, 7));
    day = parseInt(dateRaw.substring(8, 10));
    date =time.monthNames[month-1] +" "+ day+", "+year;
  }

  void debug() {
  }
}