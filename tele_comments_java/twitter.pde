
class Twitter {
  String CONSUMER_KEY = "Ray2xXVP9I1PuxgOP1Cu6IdXO";
  String CONSUMER_SECRET = "EnZmqdtHIoH4zhDrp4VE0Ze3LzrWUrdFSZUg2CHSRu3iNzVk2i";
  String TOKEN_SECRET;// = "dxKlTw62t3w9Dc3H3pt5n5qOYqVpslIMfyVeCQV7LnbmI";
  String TOKEN;// = "dxKlTw62t3w9Dc3H3pt5n5qOYqVpslIMfyVeCQV7LnbmI";
  String CALLBACK_ID;
  String name;
  String screenName;
  String userID;
  String placeID = "2459115";
  String errorMessage;
  String profileImageUrl;
  String description;
  String location;
  String status;
  String lastUpdated;
  String mediaUrl;

  PImage img;
  boolean loggedin, authenticating, profiled;
  ArrayList<String> trends, pages, followers, friends;

  Twitter () {
    //login(); 
    trends = new ArrayList<String>();   
    pages = new ArrayList<String>();
    followers = new ArrayList<String>();
    friends = new ArrayList<String>();
  }  

  void login() {
    if (!loggedin) {
      if (authenticating) {
        println("logginin");
        authenticating = false;
        runFinalizeOAuthChoreo();
        loggedin = true;
        println("logged in");
        String[] twitterBuffer = new String[5];
        twitterBuffer[0] = TOKEN;
        twitterBuffer[1] = TOKEN_SECRET;
        twitterBuffer[2] = CONSUMER_KEY;
        twitterBuffer[3] = CONSUMER_SECRET;
        twitterBuffer[4] = userID;
        saveLocal("twitter.txt", twitterBuffer);
      } else {
        try {
          String[] twitterBuffer = loadLocal("twitter.txt");
          if (twitterBuffer.length == 5) {
            TOKEN = twitterBuffer[0];
            TOKEN_SECRET = twitterBuffer[1];
            CONSUMER_KEY = twitterBuffer[2];
            CONSUMER_SECRET = twitterBuffer[3];
            userID =  twitterBuffer[4];
            loggedin = true;
          } else {
            println("error reading twitter credentials");
          }
        } 
        catch (Exception E) {
          println("authenticating twitter");
          runInitializeOAuthChoreo();
          authenticating = true;
        }
      }
    }

    if (loggedin) {
      JSONObject show = runShowChoreo(userID);
      // println(show.toString());
      screenName= show.getString("screen_name");
      description = show.getString("description");
      name = show.getString("name");
      if (!show.isNull("profile_location")) location = show.getJSONObject("profile_location").getString("name");

      profileImageUrl = show.getString("profile_image_url_https");
      String ext = profileImageUrl.substring(profileImageUrl.length()-4, profileImageUrl.length());
      if (profileImageUrl.contains("_normal")) profileImageUrl = profileImageUrl.substring(0, profileImageUrl.length()-11)+ext;  
      img = loadLocalImage(userID+".png");
      if (img == null) {
        img = loadImage(profileImageUrl);
        saveLocal(userID+".png", img);
      }   
      status = show.getJSONObject("status").getString("text");
      lastUpdated = show.getString("created_at");
      if (!show.getJSONObject("status").isNull("extended_entities")) {
        mediaUrl = show.getJSONObject("status").getJSONObject("extended_entities").getJSONArray("media").getJSONObject(0).getString("media_url");
        if (mediaUrl != null) {
          img = loadImage (mediaUrl);   ////////////  this is only if there is media in the latest status!!!
        }
      }
    }
  }
  
  ArrayList<String> getPages() {
    if (!loggedin) {
      login();
      return null;
    }
    pages = new ArrayList<String>();
    pages.add("@"+screenName);
    if (description != null) pages.add(description);
    if (location != null) pages.add(location);
    pages.add(lastUpdated);
    pages.add(status);
    getFollowers();
    pages.add(createString(followers.size()+" FOLLOWERS", SCROLL_PUSH_RIGHT, 0, 1, 20));
    // pages.add(createString("", SCROLL_PUSH_RIGHT, 0, 1, 20));

    for (String follower : followers) {
      pages.add(createString("@"+follower, CENTERED, 1, 1, 8));
    }
    getFriends();
    pages.add(createString(friends.size()+" FRIENDS", SCROLL_PUSH_RIGHT, 0, 1, 20));
    // pages.add(createString("", SCROLL_PUSH_RIGHT, 10, 1, 20));

    for (String friend : friends) {
      pages.add(createString("@"+friend, CENTERED, 1, 1, 8));
    }
    getTrendingTopics();
    pages.add(createString("TRENDING IN NYC", SCROLL_PUSH_RIGHT, 0, 1, 20));
    // pages.add(createString("", SCROLL_PUSH_RIGHT, 10, 1, 20));

    for (String trend : trends) {
      pages.add(createString(trend, CENTERED, 1, 1, 8));
    }
    return pages;
  }

  void getFollowers() {
    followers = new ArrayList<String>();
    JSONObject followersObject = runListFollowersChoreo(userID);
    JSONArray followersArray = followersObject.getJSONArray("users");
    for (int i = 0; i<followersArray.size(); i++) {
      JSONObject thisFollower = followersArray.getJSONObject(i);
      followers.add(thisFollower.getString("screen_name"));
    }
  }

  void getFriends() {
    friends = new ArrayList<String>();
    JSONObject friendsObject = runListFriendsChoreo(userID);
    JSONArray friendsArray = friendsObject.getJSONArray("users");
    for (int i = 0; i<friendsArray.size(); i++) {
      JSONObject thisFriend = friendsArray.getJSONObject(i);
      friends.add(thisFriend.getString("screen_name"));
    }
  }

  void getTrendingTopics() {
    println("getting trending");
    trends = new ArrayList<String>();   
    JSONObject trendsObject = runPlaceChoreo(placeID);
    JSONArray trendsArray = trendsObject.getJSONArray("trends");
    for (int i = 0; i<trendsArray.size(); i++) {
      JSONObject thisTrend = trendsArray.getJSONObject(i);
      trends.add(removeQuotes(thisTrend.getString("name")));
    }
  }



  void runInitializeOAuthChoreo() {
    println("initializing, launching link");
    com.temboo.Library.Twitter.OAuth.InitializeOAuth initializeOAuthChoreo = new com.temboo.Library.Twitter.OAuth.InitializeOAuth(session);
    initializeOAuthChoreo.setConsumerKey(CONSUMER_KEY);
    initializeOAuthChoreo.setConsumerSecret(CONSUMER_SECRET);
    initializeOAuthChoreo.setForwardingURL("http://www.teleobjects.com");
    com.temboo.Library.Twitter.OAuth.InitializeOAuthResultSet initializeOAuthResults = initializeOAuthChoreo.run();
    TOKEN_SECRET = initializeOAuthResults.getOAuthTokenSecret();
    CALLBACK_ID = initializeOAuthResults.getCallbackID();
    link(initializeOAuthResults.getAuthorizationURL());
  }

  void runFinalizeOAuthChoreo() {
    println("finalizing");
    com.temboo.Library.Twitter.OAuth.FinalizeOAuth finalizeOAuthChoreo = new com.temboo.Library.Twitter.OAuth.FinalizeOAuth(session);
    finalizeOAuthChoreo.setConsumerKey(CONSUMER_KEY);
    finalizeOAuthChoreo.setConsumerSecret(CONSUMER_SECRET);
    finalizeOAuthChoreo.setOAuthTokenSecret (TOKEN_SECRET);
    finalizeOAuthChoreo.setCallbackID(CALLBACK_ID);
    com.temboo.Library.Twitter.OAuth.FinalizeOAuthResultSet finalizeOAuthResults = finalizeOAuthChoreo.run();
    TOKEN = finalizeOAuthResults.getAccessToken();
    TOKEN_SECRET = finalizeOAuthResults.getAccessTokenSecret();
    errorMessage = finalizeOAuthResults.getErrorMessage();
    userID = finalizeOAuthResults.getUserID();
    println(userID+" "+errorMessage);
  }

  JSONObject runListFollowersChoreo(String userID) {
    ListFollowers listFollowersChoreo = new ListFollowers(session);
    listFollowersChoreo.setAccessToken(TOKEN);
    listFollowersChoreo.setAccessTokenSecret(TOKEN_SECRET);
    listFollowersChoreo.setConsumerKey(CONSUMER_KEY);
    listFollowersChoreo.setConsumerSecret(CONSUMER_SECRET);
    listFollowersChoreo.setUserID(userID);
    ListFollowersResultSet listFollowersResults = listFollowersChoreo.run();
    // println(listFollowersResults.getLimit());
    // println(listFollowersResults.getRemaining());
    // println(listFollowersResults.getReset());
    return JSONObject.parse(listFollowersResults.getResponse());
  }

  JSONObject runListFriendsChoreo(String userID) {
    ListFriends listFriendsChoreo = new ListFriends(session);
    listFriendsChoreo.setAccessToken(TOKEN);
    listFriendsChoreo.setAccessTokenSecret(TOKEN_SECRET);
    listFriendsChoreo.setConsumerKey(CONSUMER_KEY);
    listFriendsChoreo.setConsumerSecret(CONSUMER_SECRET);
    listFriendsChoreo.setUserID(userID);
    ListFriendsResultSet listFriendsResults = listFriendsChoreo.run();
    // println(listFriendsResults.getLimit());
    // println(listFriendsResults.getRemaining());
    // println(listFriendsResults.getReset());
    return JSONObject.parse(listFriendsResults.getResponse());
  }

  JSONObject runPlaceChoreo(String placeId) {
    Place placeChoreo = new Place(session);
    placeChoreo.setAccessToken(TOKEN);
    placeChoreo.setAccessTokenSecret(TOKEN_SECRET);
    placeChoreo.setConsumerKey(CONSUMER_KEY);
    placeChoreo.setConsumerSecret(CONSUMER_SECRET);
    placeChoreo.setID(placeID);
    PlaceResultSet placeResults = placeChoreo.run();
    String result = placeResults.getResponse();
    return JSONObject.parse(result.substring(1, result.length()-1));
  }

  JSONObject runShowChoreo(String thisUserID) {
    JSONObject result;
    try {
      String[] showBuffer = loadLocal(thisUserID+".txt");
      result = JSONObject.parse(concatenate(showBuffer));
    } 
    catch (Exception E) {
      Show showChoreo = new Show(session);
      showChoreo.setAccessToken(TOKEN);
      showChoreo.setAccessTokenSecret(TOKEN_SECRET);
      showChoreo.setConsumerKey(CONSUMER_KEY);
      showChoreo.setConsumerSecret(CONSUMER_SECRET);
      showChoreo.setUserId(thisUserID);
      ShowResultSet showResults = showChoreo.run();
      String showBuffer = showResults.getResponse();
      String[] tmp = new String[1];
      tmp[0] = showBuffer;
      saveLocal(thisUserID+".txt", tmp);    
      result = JSONObject.parse(showBuffer);
      // println(showResults.getLimit());
      // println(showResults.getRemaining());
      // println(showResults.getReset());
    }
    return result;
  }
}