package com.temboo.Library.Utilities.Authentication.OAuth2;

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
RefreshToken

Refreshes an expired access token.
*/
public class RefreshToken extends Choreography {

	/**
	Create a new instance of the RefreshToken Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RefreshToken(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Authentication/OAuth2/RefreshToken"));
	}

	/** 
	Set the value of the AccessTokenEndpoint input for this Choreo. 

	@param String - (required, string) The URL for the authorization server that issues access tokens (e.g. https://accounts.google.com/o/oauth2/token).
	*/
	public void setAccessTokenEndpoint(String value) {
		this.inputs.setInput("AccessTokenEndpoint", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (required, string) The Client ID provided by the service.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (required, string) The Client Secret provided by the service.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (required, string) The refresh token retrieved in the OAuth process to be used when your access token expires.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RefreshTokenResultSet run() {
		JSONObject result = super.runWithResults();
		return new RefreshTokenResultSet(result);
	}
	
}
