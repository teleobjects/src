package com.temboo.Library.Fitbit.Body;

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
GetBodyFat

Get a list of all user's body fat log entries for a given day.
*/
public class GetBodyFat extends Choreography {

	/**
	Create a new instance of the GetBodyFat Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetBodyFat(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Fitbit/Body/GetBodyFat"));
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

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the Date input for this Choreo. 

	@param String - (required, string) The date that corresponds with the log entry you want to retrieve (in the format yyyy-MM-dd). Time periods and ranges are allowed by passing a range like 2013-03-16/2013-03-18 or 2013-03-18/1w.
	*/
	public void setDate(String value) {
		this.inputs.setInput("Date", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that you want the response to be in: xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The user's encoded id. Defaults to "-" (dash) which will return data for the user associated with the token credentials provided.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetBodyFatResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetBodyFatResultSet(result);
	}
	
}
