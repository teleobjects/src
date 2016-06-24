package com.temboo.Library.Foursquare.Checkins;

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
Like

Allows the authenticated user to like or unlike a check-in.
*/
public class Like extends Choreography {

	/**
	Create a new instance of the Like Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Like(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Checkins/Like"));
	}

	/** 
	Set the value of the CheckinID input for this Choreo. 

	@param String - (required, string) The ID of the check-in to like or unlike.
	*/
	public void setCheckinID(String value) {
		this.inputs.setInput("CheckinID", value);
	}


	/** 
	Set the value of the OauthToken input for this Choreo. 

	@param String - (required, string) The Foursquare API OAuth token string.
	*/
	public void setOauthToken(String value) {
		this.inputs.setInput("OauthToken", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Set input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 (the default) to like this check-in. Set to 0 to undo a previous like.
	*/
	public void setSet(Boolean value) {
		this.inputs.setInput("Set", value);
	}

	/** 
	Set the value of the Set input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 (the default) to like this check-in. Set to 0 to undo a previous like.
	*/
	public void setSet(String value) {
		this.inputs.setInput("Set", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public LikeResultSet run() {
		JSONObject result = super.runWithResults();
		return new LikeResultSet(result);
	}
	
}
