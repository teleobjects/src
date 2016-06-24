
// class Twitter {
//   String CLIENT_ID = "3879bde847ca43818456eef7dff703ad";
//   String CLIENT_SECRET = "EnZmqdtHIoH4zhDrp4VE0Ze3LzrWUrdFSZUg2CHSRu3iNzVk2i";
//   String TOKEN_SECRET;// = "dxKlTw62t3w9Dc3H3pt5n5qOYqVpslIMfyVeCQV7LnbmI";
//   String TOKEN;// = "dxKlTw62t3w9Dc3H3pt5n5qOYqVpslIMfyVeCQV7LnbmI";
//   String CALLBACK_ID;
//   String name;
//   String screenName;
//   String userID;
//   String placeID = "2459115";
//   String errorMessage;
//   String profileImageUrl;
//   String description;
//   String location;
//   String status;
//   String lastUpdated;
//   String mediaUrl;

//   // PImage img;
//   boolean loggedin, authenticating, profiled;
//   ArrayList<String> trends, pages, followers, friends;

//   Twitter () {
//     //login(); 
//     trends = new ArrayList<String>();   
//     pages = new ArrayList<String>();
//     followers = new ArrayList<String>();
//     friends = new ArrayList<String>();
//   }  

//   void login() {
//     if (!loggedin) {
//       if (authenticating) {
//         println("logginin");
//         authenticating = false;
//         runFinalizeOAuthChoreo();
//         loggedin = true;
//         println("logged in");
//         String[] twitterBuffer = new String[5];
//         twitterBuffer[0] = TOKEN;
//         twitterBuffer[1] = TOKEN_SECRET;
//         twitterBuffer[2] = CONSUMER_KEY;
//         twitterBuffer[3] = CONSUMER_SECRET;
//         twitterBuffer[4] = userID;
//         saveLocal("twitter.txt", twitterBuffer);
//       } else {
//         try {
//           String[] twitterBuffer = loadLocal("twitter.txt");
//           if (twitterBuffer.length == 5) {
//             TOKEN = twitterBuffer[0];
//             TOKEN_SECRET = twitterBuffer[1];
//             CONSUMER_KEY = twitterBuffer[2];
//             CONSUMER_SECRET = twitterBuffer[3];
//             userID =  twitterBuffer[4];
//             loggedin = true;
//           } else {
//             println("error reading twitter credentials");
//           }
//         } 
//         catch (Exception E) {
//           println("authenticating twitter");
//           runInitializeOAuthChoreo();
//           authenticating = true;
//         }
//       }
//     }

//     if (loggedin) {
//       JSONObject show = runShowChoreo(userID);
//       // println(show.toString());
//       screenName= show.getString("screen_name");
//       description = show.getString("description");
//       name = show.getString("name");
//       if (!show.isNull("profile_location")) location = show.getJSONObject("profile_location").getString("name");

//       profileImageUrl = show.getString("profile_image_url_https");
//       String ext = profileImageUrl.substring(profileImageUrl.length()-4, profileImageUrl.length());
//       if (profileImageUrl.contains("_normal")) profileImageUrl = profileImageUrl.substring(0, profileImageUrl.length()-11)+ext;  
//       img = loadLocalImage(userID+".png");
//       if (img == null) {
//         img = loadImage(profileImageUrl);
//         saveLocal(userID+".png", img);
//       }   
//       status = show.getJSONObject("status").getString("text");
//       lastUpdated = show.getString("created_at");
//       if (!show.getJSONObject("status").isNull("extended_entities")) {
//         mediaUrl = show.getJSONObject("status").getJSONObject("extended_entities").getJSONArray("media").getJSONObject(0).getString("media_url");
//         if (mediaUrl != null) {
//           img = loadImage (mediaUrl);   ////////////  this is only if there is media in the latest status!!!
//         }
//       }
//     }
//   }
//   