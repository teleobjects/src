import com.temboo.core.*;
import com.temboo.Library.Google.Spreadsheets.*;
import com.temboo.Library.Google.OAuth.*;
import com.temboo.Library.Google.Contacts.*;
import com.temboo.Library.Utilities.XML.*;
import com.temboo.Library.Utilities.JSON.*;

import com.temboo.Library.Google.Calendar.*;
import com.temboo.Library.Google.Plus.People.*;

TembooSession session = new TembooSession("teleobjects", "teleobjects", "d1YKYX3a5Y6V1LAyYebWzB1RczFVkwrN");

String CLIENT_ID = "113132524761-c5gg9a8m6tq7nus1iad89enfk3t2lfjv.apps.googleusercontent.com";
String CLIENT_SECRET = "iLxRPab7WJpdXJeLN8MjeqY_";
String REFRESH_TOKEN;// = "1/3w-bk0m3khOC4Xmlkqd1ur_pLja7X801KwoGyPbE2AU";

//String CLIENT_ID = "113132524761-9vc5rqbcbqjq79msolp7iaki9vbehqsl.apps.googleusercontent.com";
//String CLIENT_SECRET = "wB14XMGd7Ju_CZZh9Q3ukrwY";
//String REFRESH_TOKEN = "1/hSZSH0vYOnV1kegywSyJUcxaTgGPv8pWcq1K_KtVouAMEudVrK5jSpoR30zcRFq6";
String[] credentials;

String ACCESS_TOKEN;
String CALLBACK_ID;

void initAccount() {
  //credentials = null;//new String[2];
  try {
    credentials = loadStrings("credentials.txt");
    if (credentials != null) {
      if (credentials.length == 2) {
        //ACCESS_TOKEN = credentials[0];
        REFRESH_TOKEN = credentials[1];
        println(REFRESH_TOKEN);
        //println(ACCESS_TOKEN);
      }
    }
  } 
  catch (Exception e) {
    println("error");
  }
  if (REFRESH_TOKEN == null) {
    runInitializeOAuthChoreo();
  } else {
    runGetChoreo();
    logged = true;
    logging = false;
    writeString("Hi "+givenName+", "+email+", "+id+", "+kind+" "+language, TICKER, 19, 10, 1);
    profileImage = loadImage(url+"sz=400");
  }
}

String nickname, email, url, familyName, givenName, objectType, id, kind, language;
int minAge;

void runGetChoreo() {
  Get getChoreo = new Get(session);
  getChoreo.setClientID(CLIENT_ID);
  getChoreo.setClientSecret(CLIENT_SECRET);
  getChoreo.setRefreshToken(REFRESH_TOKEN);
  getChoreo.setUserID("me");
  //getChoreo.addOutputFilter("knickname", "knickname", "Response");
  GetResultSet getResults = getChoreo.run();
  //println(getResults.getNewAccessToken());
  JSONObject choreo =JSONObject.parse(getResults.getResponse());
  //nickname = choreo.getString("nickname");
  email = choreo.getJSONArray("emails").getJSONObject(0).getString("value");
  url = choreo.getJSONObject("image").getString("url");
  url = url.substring(0,url.length()-6);
  familyName = choreo.getJSONObject("name").getString("familyName");
  givenName = choreo.getJSONObject("name").getString("givenName");
  objectType = choreo.getString("objectType");
  id = choreo.getString("id");
  kind = choreo.getString("kind");
  language = choreo.getString("language");
  minAge = choreo.getJSONObject("ageRange").getInt("min");
  //runAppendRowChoreo(id+","+kind+","+language+","+minAge);
  //runAppendRowChoreo(nickname+","+familyName+","+givenName);
  //runAppendRowChoreo(email+","+url);

  //println(id+","+kind+","+language+","+minAge);
  //println(nickname+","+familyName+","+givenName);
  println(email+","+url);
}

void runInitializeOAuthChoreo() {
  InitializeOAuth initializeOAuthChoreo = new InitializeOAuth(session);
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
  InitializeOAuthResultSet initializeOAuthResults = initializeOAuthChoreo.run();
  link(initializeOAuthResults.getAuthorizationURL());
  CALLBACK_ID = initializeOAuthResults.getCallbackID();
}

void runFinalizeOAuthChoreo() {
  FinalizeOAuth finalizeOAuthChoreo = new FinalizeOAuth(session);
  finalizeOAuthChoreo.setCallbackID(CALLBACK_ID);
  finalizeOAuthChoreo.setClientID(CLIENT_ID);
  finalizeOAuthChoreo.setClientSecret(CLIENT_SECRET);
  FinalizeOAuthResultSet finalizeOAuthResults = finalizeOAuthChoreo.run();
  //println(finalizeOAuthResults.getAccessToken());
  println(finalizeOAuthResults.getErrorMessage());
  println(finalizeOAuthResults.getExpires());
  println(finalizeOAuthResults.getRefreshToken());
  ACCESS_TOKEN = finalizeOAuthResults.getAccessToken();
  REFRESH_TOKEN = finalizeOAuthResults.getRefreshToken();
  credentials = new String[2];
  //credentials[0] = ACCESS_TOKEN;
  credentials[1] = REFRESH_TOKEN;
  saveStrings("credentials.txt", credentials );
  println("saved credentials");
}

void runAppendRowChoreo(String content) {
  AppendRow appendRowChoreo = new AppendRow(session);
  appendRowChoreo.setRowData(content);
  appendRowChoreo.setSpreadsheetTitle("tele_log");
  //if (ACCESS_TOKEN == null) {
  appendRowChoreo.setRefreshToken(REFRESH_TOKEN);
  appendRowChoreo.setClientSecret(CLIENT_SECRET);
  //} else {
  //  appendRowChoreo.setAccessToken(ACCESS_TOKEN);
  //}
  appendRowChoreo.setClientID(CLIENT_ID);
  AppendRowResultSet appendRowResults = appendRowChoreo.run();
  //if (ACCESS_TOKEN == null) {
  //ACCESS_TOKEN = appendRowResults.getNewAccessToken();
  //}
  println(appendRowResults.getResponse());
}

void runRetrieveRowChoreo() {
  RetrieveRow retrieveRowChoreo = new RetrieveRow(session);
  //if (ACCESS_TOKEN == null) {
  retrieveRowChoreo.setClientID(CLIENT_ID);
  retrieveRowChoreo.setRefreshToken(REFRESH_TOKEN);
  retrieveRowChoreo.setClientSecret(CLIENT_SECRET);
  //} else {
  //  retrieveRowChoreo.setAccessToken(ACCESS_TOKEN);
  //}
  retrieveRowChoreo.setSpreadsheetName("tele_log");
  retrieveRowChoreo.setWorksheetName("tele_log");
  RetrieveRowResultSet retrieveRowResults = retrieveRowChoreo.run();
  println(retrieveRowResults.getRowData());
  //if (ACCESS_TOKEN == "") {
  //ACCESS_TOKEN = retrieveRowResults.getNewAccessToken();
  //}
}

void runGetAllContactsChoreo() {
  GetAllContacts getAllContactsChoreo = new GetAllContacts(session);
  //if (ACCESS_TOKEN == null) {
  getAllContactsChoreo.setRefreshToken(REFRESH_TOKEN);
  getAllContactsChoreo.setClientSecret(CLIENT_SECRET);
  //} else {
  //  getAllContactsChoreo.setAccessToken(ACCESS_TOKEN);
  //}
  getAllContactsChoreo.setClientID(CLIENT_ID);
  GetAllContactsResultSet getAllContactsResults = getAllContactsChoreo.run();
  //println(getAllContactsResults.getResponse());
  GetValuesFromXML getValuesFromXMLChoreo = new GetValuesFromXML(session);
  getValuesFromXMLChoreo.setNode("gd:fullName");
  getValuesFromXMLChoreo.setXML(getAllContactsResults.getResponse());
  getValuesFromXMLChoreo.setResponseFormat("csv");
  GetValuesFromXMLResultSet getValuesFromXMLResults = getValuesFromXMLChoreo.run();
  //runAppendRowChoreo(getValuesFromXMLResults.getResult());
}

void runGetAllEventsChoreo() {
  GetAllEvents getAllEventsChoreo = new GetAllEvents(session);
  println("reading events");
  getAllEventsChoreo.setRefreshToken(REFRESH_TOKEN);
  getAllEventsChoreo.setClientSecret(CLIENT_SECRET);
  getAllEventsChoreo.setClientID(CLIENT_ID);
  getAllEventsChoreo.setCalendarID("primary");
  //getAllEventsChoreo.addOutputFilter("summary", "", "Response");
  GetAllEventsResultSet getAllEventsResults = getAllEventsChoreo.run();
  GetValuesFromJSON getValuesFromJSONChoreo = new GetValuesFromJSON(session);
  println(getAllEventsResults.getResponse());
  getValuesFromJSONChoreo.setJSON(getAllEventsResults.getResponse());
  getValuesFromJSONChoreo.setProperty("summary");
  GetValuesFromJSONResultSet getValuesFromJSONResults = getValuesFromJSONChoreo.run();
  println(getValuesFromJSONResults.getResponse());
  //println(getAllEventsResults.getNewAccessToken());
}

void runCreateCalendarChoreo() {
  CreateCalendar createCalendarChoreo = new CreateCalendar(session);
  createCalendarChoreo.setRefreshToken(REFRESH_TOKEN);
  createCalendarChoreo.setClientSecret(CLIENT_SECRET);
  createCalendarChoreo.setClientID(CLIENT_ID);
  createCalendarChoreo.setTitle("tele_calendar");
  CreateCalendarResultSet createCalendarResults = createCalendarChoreo.run();
  //println(createCalendarResults.getNewAccessToken());
  //println(createCalendarResults.getResponse());
}


void completeAuthorization() {
  //println("hello");
  if (REFRESH_TOKEN == null) {
    runFinalizeOAuthChoreo();
  }

  //runGetAllContactsChoreo();
  //runRetrieveRowChoreo();
  runGetChoreo();
}