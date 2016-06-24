package com.temboo.Library.Tumblr.User;

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
RetrieveUserDashboard

Retrieves the dashboard of the user that corresponds to the OAuth credentials provided.
*/
public class RetrieveUserDashboard extends Choreography {

	/**
	Create a new instance of the RetrieveUserDashboard Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrieveUserDashboard(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Tumblr/User/RetrieveUserDashboard"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Tumblr (AKA the OAuth Consumer Key).
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) The Access Token Secret retrieved during the OAuth process.
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of results to return: 1 - 20. Defaults to 20.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to return: 1 - 20. Defaults to 20.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the NotesInfo input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates whether to return notes information. Specify 1(true) or 0 (false). Defaults to 0.
	*/
	public void setNotesInfo(Boolean value) {
		this.inputs.setInput("NotesInfo", value);
	}

	/** 
	Set the value of the NotesInfo input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates whether to return notes information. Specify 1(true) or 0 (false). Defaults to 0.
	*/
	public void setNotesInfo(String value) {
		this.inputs.setInput("NotesInfo", value);	
	}
	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) The result to start at. Defaults to 0.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) The result to start at. Defaults to 0.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the ReblogInfo input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates whether to return reblog information. Specify 1(true) or 0 (false). Defaults to 0.
	*/
	public void setReblogInfo(Boolean value) {
		this.inputs.setInput("ReblogInfo", value);
	}

	/** 
	Set the value of the ReblogInfo input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates whether to return reblog information. Specify 1(true) or 0 (false). Defaults to 0.
	*/
	public void setReblogInfo(String value) {
		this.inputs.setInput("ReblogInfo", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SecretKey input for this Choreo. 

	@param String - (required, string) The Secret Key provided by Tumblr (AKA the OAuth Consumer Secret).
	*/
	public void setSecretKey(String value) {
		this.inputs.setInput("SecretKey", value);
	}


	/** 
	Set the value of the SinceId input for this Choreo. 

	@param Integer - (optional, integer) Return posts that have appeared after this ID. Used to page through results.
	*/
	public void setSinceId(Integer value) {
		this.inputs.setInput("SinceId", value);
	}

	/** 
	Set the value of the SinceId input for this Choreo as a String. 

	@param String - (optional, integer) Return posts that have appeared after this ID. Used to page through results.
	*/
	public void setSinceId(String value) {
		this.inputs.setInput("SinceId", value);	
	}
	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (optional, string) The type of post to return. Specify one of the following:  text, photo, quote, link, chat, audio, video, answer.
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrieveUserDashboardResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrieveUserDashboardResultSet(result);
	}
	
}
