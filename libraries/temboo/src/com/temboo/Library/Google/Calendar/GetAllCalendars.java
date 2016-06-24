package com.temboo.Library.Google.Calendar;

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
GetAllCalendars

Retrieve data for all calendars.
*/
public class GetAllCalendars extends Choreography {

	/**
	Create a new instance of the GetAllCalendars Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetAllCalendars(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Calendar/GetAllCalendars"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved during the OAuth process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the Count input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of calendars to return. The default is 15.
	*/
	public void setCount(Integer value) {
		this.inputs.setInput("Count", value);
	}

	/** 
	Set the value of the Count input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of calendars to return. The default is 15.
	*/
	public void setCount(String value) {
		this.inputs.setInput("Count", value);	
	}
	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) The calendar fields to return. Accepted values are "etag", "items", "kind", and "nextPageToken". All calendar items are returned by default.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the Hidden input for this Choreo. 

	@param Boolean - (optional, boolean) Enter "1" to return hidden calendars in the results, or "0" (the default) to not return them.
	*/
	public void setHidden(Boolean value) {
		this.inputs.setInput("Hidden", value);
	}

	/** 
	Set the value of the Hidden input for this Choreo as a String. 

	@param String - (optional, boolean) Enter "1" to return hidden calendars in the results, or "0" (the default) to not return them.
	*/
	public void setHidden(String value) {
		this.inputs.setInput("Hidden", value);	
	}
	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth Refresh Token used to generate a new access token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetAllCalendarsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetAllCalendarsResultSet(result);
	}
	
}
