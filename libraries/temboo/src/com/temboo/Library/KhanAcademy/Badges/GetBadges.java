package com.temboo.Library.KhanAcademy.Badges;

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
GetBadges

Retrieves a list of all badges, and if a user is logged in, retrieves additional information about the badges that user has earned.
*/
public class GetBadges extends Choreography {

	/**
	Create a new instance of the GetBadges Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetBadges(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/KhanAcademy/Badges/GetBadges"));
	}

	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (optional, string) The Consumer Key provided by Khan Academy.
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (optional, string) The OAuth Consumer Secret provided by Khan Academy.
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (optional, string) The email address (coach or student ID) of user. If not provided, defaults to currently logged in user in the case when authentication credentials are provided.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the OAuthToken input for this Choreo. 

	@param String - (optional, string) The OAuth Token retrieved during the OAuth process.
	*/
	public void setOAuthToken(String value) {
		this.inputs.setInput("OAuthToken", value);
	}


	/** 
	Set the value of the OAuthTokenSecret input for this Choreo. 

	@param String - (optional, string) The OAuth Token Secret retrieved during the OAuth process.
	*/
	public void setOAuthTokenSecret(String value) {
		this.inputs.setInput("OAuthTokenSecret", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetBadgesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetBadgesResultSet(result);
	}
	
}
