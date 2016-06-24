package com.temboo.Library.Instagram;

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
GetLocationInformation

Retrieves information about a location.
*/
public class GetLocationInformation extends Choreography {

	/**
	Create a new instance of the GetLocationInformation Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetLocationInformation(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Instagram/GetLocationInformation"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (conditional, string) The access token retrieved during the OAuth 2.0 process. Required unless you provide the ClientID.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Instagram after registering your application. Required unless you provide an AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the LocationID input for this Choreo. 

	@param Integer - (required, integer) The ID for the location that you want to retrieve information for.
	*/
	public void setLocationID(Integer value) {
		this.inputs.setInput("LocationID", value);
	}

	/** 
	Set the value of the LocationID input for this Choreo as a String. 

	@param String - (required, integer) The ID for the location that you want to retrieve information for.
	*/
	public void setLocationID(String value) {
		this.inputs.setInput("LocationID", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetLocationInformationResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetLocationInformationResultSet(result);
	}
	
}
