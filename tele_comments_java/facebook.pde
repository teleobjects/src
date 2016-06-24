import com.temboo.Library.Facebook.OAuth.*;
import com.temboo.Library.Facebook.Reading.*;

class Facebook {

	String APP_ID = "494885047387549";
	String APP_SECRET = "4c49b9d1dfd0766a5d806ddd8f766f60";
	String SCOPE = "public_profile,user_friends";
	String CALLBACK_ID;//= "teleobjects";
	String TOKEN;

	boolean loggedin, authenticating, profiled;
	String expires;
	String errorMessage;

	String name;
	String id;

	PImage img;

	Facebook() {

	}

	void login() {
		if (!loggedin) {
			if (authenticating) {
				println("logginin");
				authenticating = false;
				runFinalizeOAuthChoreo();
				loggedin = true;
				println("logged in");
				String[] facebookBuffer = new String[3];
				facebookBuffer[0] = APP_ID;
				facebookBuffer[1] = APP_SECRET;
				facebookBuffer[2] = TOKEN;
				saveLocal("facebook.txt", facebookBuffer);
			} else {
				try {
					String[] facebookBuffer = loadLocal("facebook.txt");
					if (facebookBuffer.length == 3) {
						APP_ID = facebookBuffer[0];
						APP_SECRET = facebookBuffer[1];
						TOKEN = facebookBuffer[2];
						loggedin = true;
					} else {
						println("error reading facebook credentials");
					}
				} 
				catch (Exception E) {
					println("authenticating facebook");
					runInitializeOAuthChoreo();
					authenticating = true;
				}
			}
		}
		if (loggedin) {
			getInfo();
		}
	}

	void getInfo() {
		if (loggedin) {
			JSONObject profileInfo;
			try {
				String[] profileInfoBuffer = loadLocal("profileFacebook.json");
				profileInfo = JSONObject.parse(concatenate(profileInfoBuffer));
			} 
			catch (Exception e) {
				profileInfo = runUserchoreo();
				String[] profileInfoBuffer = { profileInfo.toString()};
				saveLocal("profileFacebook.json", profileInfoBuffer);
			}
			name = profileInfo.getString("name");
			id = profileInfo.getString("id");


			img = loadLocalImage(id+".png");
			if (img == null) {
				JSONObject profileImage = runPictureChoreo("me");
				println(profileImage);
				String profileImageUrl = profileImage.getJSONObject("data").getString("url");
				img = loadImage(profileImageUrl);
				saveLocal(id+".png", img);
			}   

		}
	}

	JSONObject runPictureChoreo(String profileId) {
		Picture pictureChoreo = new Picture(session);
		pictureChoreo.setAccessToken(TOKEN);
		pictureChoreo.setRedirect("false");
		pictureChoreo.setType("large");
		PictureResultSet pictureResults = pictureChoreo.run();
		return JSONObject.parse(pictureResults.getResponse());
	}

	JSONObject runUserchoreo() {
		User userChoreo = new User(session);
		userChoreo.setAccessToken(TOKEN);
		UserResultSet userResults = userChoreo.run();
		return JSONObject.parse(userResults.getResponse());
	}

	void runInitializeOAuthChoreo() {
		println("initializing, launching link");		
		com.temboo.Library.Facebook.OAuth.InitializeOAuth initializeOAuthChoreo = new com.temboo.Library.Facebook.OAuth.InitializeOAuth(session);

		initializeOAuthChoreo.setAppID(APP_ID);
		initializeOAuthChoreo.setScope(SCOPE);
		// initializeOAuthChoreo.setCustomCallbackID(CALLBACK_ID);
		com.temboo.Library.Facebook.OAuth.InitializeOAuthResultSet initializeOAuthResults = initializeOAuthChoreo.run();	
		CALLBACK_ID = initializeOAuthResults.getCallbackID();
		link(initializeOAuthResults.getAuthorizationURL());
	} 


	void runFinalizeOAuthChoreo() {
		println("finalizing");
		com.temboo.Library.Facebook.OAuth.FinalizeOAuth finalizeOAuthChoreo = new com.temboo.Library.Facebook.OAuth.FinalizeOAuth(session);
		finalizeOAuthChoreo.setAppID(APP_ID);
		finalizeOAuthChoreo.setAppSecret(APP_SECRET);
		finalizeOAuthChoreo.setCallbackID(CALLBACK_ID);
		finalizeOAuthChoreo.setLongLivedToken(true);
		com.temboo.Library.Facebook.OAuth.FinalizeOAuthResultSet finalizeOAuthResults = finalizeOAuthChoreo.run();
		// TOKEN_SECRET = finalizeOAuthResults.getAccessTokenSecret();
		errorMessage = finalizeOAuthResults.getErrorMessage();
		expires = finalizeOAuthResults.getExpires();
		println(expires+" "+errorMessage);
		try {
			TOKEN = finalizeOAuthResults.getAccessToken();
		} catch (Exception e) {
			println("error getting authorization TOKEN");
		}

	}
}


