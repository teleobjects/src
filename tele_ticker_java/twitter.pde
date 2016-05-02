//import twitter4j.conf.*;
//import twitter4j.api.*;
//import twitter4j.*;

//import java.util.List;
//// import java.util.Iterator;

//ConfigurationBuilder   cb;
//Query query;
//Twitter twitter;

ArrayList<String> tweets;

//// ArrayList<UserCustom> twittersList;

//String screenName;

//int    trendId = 2459115; // NYC


void initTwitter() {
  //	cb = new ConfigurationBuilder();
  //	cb.setOAuthConsumerKey("Ray2xXVP9I1PuxgOP1Cu6IdXO");
  //	cb.setOAuthConsumerSecret("EnZmqdtHIoH4zhDrp4VE0Ze3LzrWUrdFSZUg2CHSRu3iNzVk2i");
  //	cb.setOAuthAccessToken("4421325317-j8acACcvuXYnxsFYtjJGe2AOdY6vQxtQvLVpGXz");
  //	cb.setOAuthAccessTokenSecret("dxKlTw62t3w9Dc3H3pt5n5qOYqVpslIMfyVeCQV7LnbmI");
  //	twitter = new TwitterFactory(cb.build()).getInstance();
}
void updateTwitter() {
  //	tweets = new ArrayList();
  //	getTrending();
  //	getTweets();
  //	queryTwitter(("#IoT"));
}

//void getTweets() {
//	try 
//	{
//		// println("10 Twitter timeline");
//		User user = twitter.verifyCredentials();
//		String screenName = "@"+user.getScreenName();
//		// println(screenName);
//		tweets.add(screenName+" LATEST TWEETS");
//		tweets.add(user.getDescription());
//		tweets.add(user.getLocation());
//		Paging paging = new Paging(1, 10);
//		List<Status> statuses = twitter.getHomeTimeline(paging);

//		for (Status status : statuses) {
//			String usr = "@"+status.getUser().getName();
//			String msg =  status.getText();
//			println(usr, msg);
//			tweets.add(cleanUp(usr+" "+msg, true));
//		}
//	}
//	catch(TwitterException te) {
//		tweets.add("Can't connect to Twitter " + te);
//	}
//	if (tweets.size() == 0 ) tweets.add("Can't connect to Twitter");
//}

//void queryTwitter(String str) {
//	ArrayList<String> twitt = new ArrayList<String>();
//	query = new Query(str);
//	query.setCount(10);
//	try {
//		QueryResult result = twitter.search(query);
//		List<Status> results = result.getTweets();
//		// println("New Tweet : ");
//		tweets.add(cleanUp("LATEST ABOUT "+str, false));

//		for (Status tw : results) {
//			String msg = tw.getText();
//			String usr = tw.getUser().getScreenName();
//			String twStr = "@"+usr+": "+msg;
//			// println(twStr);
//			// tweets.add(cleanUp("@"+usr)+cleanUp(msg, true));
//			tweets.add(cleanUp(msg, true));

//		}
//	}
//	catch (TwitterException te) {
//		tweets.add("Can't connect to Twitter "+te);
//	}
//	// return twitt;
//}


//void getTrending() {
//	ArrayList<String> twitt = new ArrayList<String>();
//	try {
//		Trends trends = twitter.getPlaceTrends(trendId);
//		tweets.add(createString("POPULAR IN NEW YORK CITY", SCROLL_PUSH_RIGHT, 10, 1, 20)) ;
//		tweets.add(createString(" ", SCROLL_PUSH_RIGHT, 10, 1, 1)) ;

//		// tweets.add(createString(" ", INSTANT, 1, 1, 1));

//		for (int i = 0; i < trends.getTrends().length && i < 5; i++) {
//			// println(trends.getTrends()[i].getName());
//			tweets.add(createString(cleanUp(trends.getTrends()[i].getName(), true), CENTERED, 1, 1, 10));
//			tweets.add(createString(" ", INSTANT, 1, 1, 1));

//		}
//	}
//	catch (TwitterException te) {
//		tweets.add("Can't connect to Twitter "+te);
//	}
//}