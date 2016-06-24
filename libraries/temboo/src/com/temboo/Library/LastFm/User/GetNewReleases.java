package com.temboo.Library.LastFm.User;

/*
Copyright 2014 Temboo, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

import processing.data.JSONArray;
import processing.data.JSONObject;
import java.math.BigDecimal;
import com.temboo.core.Choreography;
import com.temboo.core.Choreography.ResultSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooPath;
import com.temboo.core.TembooSession;

/** 
GetNewReleases

Retrieves a list of forthcoming releases based on a user's musical taste. 
*/
public class GetNewReleases extends Choreography {

	/**
	Create a new instance of the GetNewReleases Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetNewReleases(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LastFm/User/GetNewReleases"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (string) Your Last.fm API Key.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the User input for this Choreo. 

	@param String - (string) The Last.fm username.
	*/
	public void setUser(String value) {
		this.inputs.setInput("User", value);
	}


	/** 
	Set the value of the UserRecommendations input for this Choreo. 

	@param Boolean - (optional, boolean) If 1, the feed contains new releases based on Last.fm's artist recommendations for this user. Otherwise, it is based on their library.
	*/
	public void setUserRecommendations(Boolean value) {
		this.inputs.setInput("UserRecommendations", value);
	}

	/** 
	Set the value of the UserRecommendations input for this Choreo as a String. 

	@param String - (optional, boolean) If 1, the feed contains new releases based on Last.fm's artist recommendations for this user. Otherwise, it is based on their library.
	*/
	public void setUserRecommendations(String value) {
		this.inputs.setInput("UserRecommendations", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetNewReleasesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetNewReleasesResultSet(result);
	}
	
}
