package com.temboo.Library.Facebook.Reading;

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
LikesPage

Determines whether or not someone likes a Facebook Page.
*/
public class LikesPage extends Choreography {

	/**
	Create a new instance of the LikesPage Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public LikesPage(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Facebook/Reading/LikesPage"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token retrieved from the final OAuth step.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the PageID input for this Choreo. 

	@param String - (required, string) The ID of the page to check against the acting user's likes.
	*/
	public void setPageID(String value) {
		this.inputs.setInput("PageID", value);
	}


	/** 
	Set the value of the ProfileID input for this Choreo. 

	@param String - (optional, string) The ID of the user whose likes you want to check the PageID against. Defaults to "me" indicating the authenticated user.
	*/
	public void setProfileID(String value) {
		this.inputs.setInput("ProfileID", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public LikesPageResultSet run() {
		JSONObject result = super.runWithResults();
		return new LikesPageResultSet(result);
	}
	
}
