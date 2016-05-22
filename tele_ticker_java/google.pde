////////////////////////
// GOOGLE
////////////////////////

//String CLIENT_ID = "113132524761-9vc5rqbcbqjq79msolp7iaki9vbehqsl.apps.googleusercontent.com";
//String CLIENT_SECRET = "wB14XMGd7Ju_CZZh9Q3ukrwY";
//String REFRESH_TOKEN = "1/hSZSH0vYOnV1kegywSyJUcxaTgGPv8pWcq1K_KtVouAMEudVrK5jSpoR30zcRFq6";

String CLIENT_ID = "113132524761-c5gg9a8m6tq7nus1iad89enfk3t2lfjv.apps.googleusercontent.com";
String CLIENT_SECRET = "iLxRPab7WJpdXJeLN8MjeqY_";
String REFRESH_TOKEN;
String ACCESS_TOKEN;
String CALLBACK_ID;

class Google {
  boolean loggedin;
  boolean logging;
  boolean authenticating;

  String[] credentials;

  Google() {
    // login();
  }

  void login() {
    if (authenticating) {
      runFinalizeOAuthChoreo();
      authenticating = false;
    } else if (forcelogin) {
      runInitializeOAuthChoreo();
    } else {
      authenticate();
    }
  }

  void authenticate() {
    try {
      credentials = loadLocal("credentials.txt");
      if (credentials != null) {
        REFRESH_TOKEN = credentials[0];
        ACCESS_TOKEN = credentials[1];
        println(REFRESH_TOKEN);
        println(ACCESS_TOKEN);
      }
    } 
    catch (Exception e) {
      println("error");
    }
    if (REFRESH_TOKEN == null) {
      runInitializeOAuthChoreo();
    } else {
      profile.update();
      loggedin = true;
      logging = false;
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
    credentials = new String[2];
    credentials[0] = REFRESH_TOKEN;
    credentials[1] = ACCESS_TOKEN;
    saveLocal("credentials.txt", credentials);
  }
}

/////////////////////////////////////
// PROFILE
/////////////////////////////////////

class Profile {
  String nickname, email, url, familyName, givenName, objectType, id, kind, language;
  int minAge;
  PImage img = null;

  Profile () {
  }

  void update() {
    JSONObject choreo;
    try {
      String[] choreoBuffer = loadLocal("profile.json");
      choreo = JSONObject.parse(concatenate(choreoBuffer));
    } 
    catch (Exception e) {
      choreo = runGetChoreo();
      String[] choreoBuffer = { choreo.toString()};
      saveLocal("profile.json", choreoBuffer);
    }
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
      img = loadLocalImage(id+".png");
    } 
    catch (Exception e) {
    }
    if (img == null) {
      img = loadImage(url);
      saveLocal(id+".png", img);
    }
  }

  ArrayList<String> getPages() {
    ArrayList<String> pages = new ArrayList<String>();
    pages.add(createString("Hi "+givenName, TICKER, 20, 1, 20));
    pages.add(createString(id+" "+objectType, TICKER, 20, 1, 20));
    pages.add(createString(email, TICKER, 20, 1, 20));
    pages.add(createString("+"+minAge+" "+"speaks "+language, TICKER, 20, 1, 20));
    return pages;
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

class GoogleDrive {
  ArrayList<String> drives;

  GoogleDrive () {
  }

  void update() {
    drives = new ArrayList<String>();
    String logId = "1nDJ7lBSpylE5ORHF6xTntc4N9iqq8m3j_LW7Ok5K8RQ";
    String driveUrl = "https://docs.google.com/spreadsheets/d/"+logId+"/export?format=tsv&id="+logId;
    String[] driveContent = loadUrl(driveUrl);
    if (driveContent != null) {
      for (int i=0; i<driveContent.length; i++) {
        drives.add(removeQuotes(driveContent[i]));
      }
    }
  }

  ArrayList<String> getPages() {
    update();
    return drives;
  }

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
    XML contactsXML = null;
    try {
      contactsXML = loadXML((android ? "data\\tmp\\" : "data/tmp/") + "contacts.xml");
    } catch (Exception e) {
      println("error loading contacts.xml");
    }

    if (contactsXML == null && online) {
      println("getting contacts");
      String contactsBuffer = runGetAllContactsChoreo();
      contactsXML = parseXML (contactsBuffer);
      saveXML(contactsXML, (android ?  "data\\tmp\\" : "data/tmp/") + "contacts.xml");  
    }

    if (contactsXML != null) {
      XML[] entries = contactsXML.getChildren("entry");
      for (int i = 0; i < entries.length; i++) {
        Contact contact = new Contact();
        contact.title = entries[i].getChild("title").getContent();
        XML names = entries[i].getChild("gd:name");
        // if (names.getChild("gd:fullName").getContent() !=null && names.getChild("gd:fullName").getContent()!=null) contact.fullName = names.getChild("gd:fullName").getContent();
        // if (names.getChild("gd:givenName").getContent() !=null  && names.getChild("gd:givenName").getContent()!=null) contact.givenName = names.getChild("gd:givenName").getContent();
        // if (names.getChild("gd:familyName") !=null && names.getChild("gd:familyName").getContent()!=null) contact.familyName = names.getChild("gd:familyName").getContent();
        if (entries[i].getChild("gd:email") !=null ) contact.email = entries[i].getChild("gd:email").getString("address").toLowerCase();
        if (entries[i].getChild("gd:phoneNumber") !=null ) contact.phoneNumber = entries[i].getChild("gd:phoneNumber").getContent();
        if (entries[i].getChild("link") != null) {
          if (entries[i].getChild("link").hasAttribute("gd:etag")) {
            contact.url = entries[i].getChild("link").getString("href");
            if (contact.url != null) {
              String url = contact.url+"?access_token="+ACCESS_TOKEN;
              println(url);
              // try {
              //   contact.img = loadLocalImage(contact.email+".png");
              // } catch (Exception e)   {                
              //   downloadByteArrayAsImage(url, contact.email);
              //   contact.img = loadLocalImage(contact.email+".png");
              // }
              contactList.add(contact);
            }
          }
        }
      }
      updated = true;
    }
    println(contactList.size() + " contacts");
  }

  ArrayList<String> getPages() {
    if (!updated) update();
    ArrayList<String> pages = new ArrayList<String>();
    for (Contact thisContact : contactList) {
      if (thisContact.title != null && thisContact.title != "") {
        pages.add(createString(cleanUp(thisContact.url, true), IMAGE, 1, 1, 5));
        pages.add(cleanUp(thisContact.title, true));
       
      }
    }
    return pages;
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
}

/////////////////////////////////////
// CALENDAR
/////////////////////////////////////


class GoogleCalendar {
  ArrayList<Event> eventsList;
  boolean updated;

  GoogleCalendar () {
    eventsList = new ArrayList<Event>();
  }

  void update() {
    eventsList = new ArrayList<Event>();
    JSONObject eventsObject = runGetAllEventsChoreo();
    JSONArray itemsArray = eventsObject.getJSONArray("items");
    for (int i = 0; i<itemsArray.size(); i++) {
      JSONObject thisItem = itemsArray.getJSONObject(itemsArray.size()-i-1);
      Event event = new Event();
      event.summary = thisItem.getString("summary");
      eventsList.add(event);
    }  
    updated = true;
    println(eventsList.size()+" events");
  }

  ArrayList<String> getPages() {
    if (!updated) update();
    ArrayList<String> pages = new ArrayList<String>();
    for (Event thisEvent : eventsList) {
      if (thisEvent.summary != null && thisEvent.summary != "") {
        pages.add(cleanUp(thisEvent.summary, true));
      }
    }
    return pages;
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
  String date;

  Event() {
  }

  void debug() {
  }
}