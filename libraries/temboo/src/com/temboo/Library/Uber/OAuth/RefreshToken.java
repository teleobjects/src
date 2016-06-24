package com.temboo.Library.Uber.OAuth;

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

Retrieves a fresh Access Token by exchanging the Refresh Token that is associated with the expired Access Token.
*/
public class RefreshToken extends Choreography {

	/**
	Create a new instance of the RefreshToken Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RefreshToken(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Uber/OAuth/RefreshToken"));
	}

	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (required, string) The Client ID provided by Uber after registering your application.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (required, string) The Client Secret provided by Uber after registering your application.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (required, string) An OAuth Refresh Token used to generate a new access token when the original token is expired.
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
