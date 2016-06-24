package com.temboo.Library.Twitter.Trends;

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
Place

Retrieves the top 10 trending topics for a specific WOEID.
*/
public class Place extends Choreography {

	/**
	Create a new instance of the Place Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Place(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twitter/Trends/Place"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) The Access Token Secret provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) The API Key (or Consumer Key) provided by Twitter.
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) The API Secret (or Consumer Secret) provided by Twitter.
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the Exclude input for this Choreo. 

	@param Boolean - (optional, boolean) If set to "hashtags", all hashtags from the trends list will be removed.
	*/
	public void setExclude(Boolean value) {
		this.inputs.setInput("Exclude", value);
	}

	/** 
	Set the value of the Exclude input for this Choreo as a String. 

	@param String - (optional, boolean) If set to "hashtags", all hashtags from the trends list will be removed.
	*/
	public void setExclude(String value) {
		this.inputs.setInput("Exclude", value);	
	}
	/** 
	Set the value of the ID input for this Choreo. 

	@param String - (required, string) The (WOEID) Yahoo! Where On Earth ID of the location to return trending information for. Global information is available by setting this parameter to 1.
	*/
	public void setID(String value) {
		this.inputs.setInput("ID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PlaceResultSet run() {
		JSONObject result = super.runWithResults();
		return new PlaceResultSet(result);
	}
	
}
