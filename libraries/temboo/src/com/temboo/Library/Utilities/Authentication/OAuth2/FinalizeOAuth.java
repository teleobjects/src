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
FinalizeOAuth

Completes the OAuth process by retrieving an access token for a user, after they have visited the authorization URL returned by the InitializeOAuth Choreo and clicked "allow."
*/
public class FinalizeOAuth extends Choreography {

	/**
	Create a new instance of the FinalizeOAuth Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FinalizeOAuth(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Authentication/OAuth2/FinalizeOAuth"));
	}

	/** 
	Set the value of the AccessTokenEndpoint input for this Choreo. 

	@param String - (required, string) The URL for the authorization server that issues access tokens (e.g. https://accounts.google.com/o/oauth2/token).
	*/
	public void setAccessTokenEndpoint(String value) {
		this.inputs.setInput("AccessTokenEndpoint", value);
	}


	/** 
	Set the value of the CallbackID input for this Choreo. 

	@param String - (required, string) The callback token returned by the InitializeOAuth Choreo. Used to retrieve the authorization code after the user authorizes.
	*/
	public void setCallbackID(String value) {
		this.inputs.setInput("CallbackID", value);
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
	Set the value of the SuppressErrors input for this Choreo. 

	@param Boolean - (optional, boolean) When set to true, errors received during the OAuth redirect process will be suppressed and returned in the ErrorMessage output.
	*/
	public void setSuppressErrors(Boolean value) {
		this.inputs.setInput("SuppressErrors", value);
	}

	/** 
	Set the value of the SuppressErrors input for this Choreo as a String. 

	@param String - (optional, boolean) When set to true, errors received during the OAuth redirect process will be suppressed and returned in the ErrorMessage output.
	*/
	public void setSuppressErrors(String value) {
		this.inputs.setInput("SuppressErrors", value);	
	}
	/** 
	Set the value of the Timeout input for this Choreo. 

	@param Integer - (optional, integer) The amount of time (in seconds) to poll your Temboo callback URL to see if your app's user has allowed or denied the request for access. Defaults to 20. Max is 60.
	*/
	public void setTimeout(Integer value) {
		this.inputs.setInput("Timeout", value);
	}

	/** 
	Set the value of the Timeout input for this Choreo as a String. 

	@param String - (optional, integer) The amount of time (in seconds) to poll your Temboo callback URL to see if your app's user has allowed or denied the request for access. Defaults to 20. Max is 60.
	*/
	public void setTimeout(String value) {
		this.inputs.setInput("Timeout", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FinalizeOAuthResultSet run() {
		JSONObject result = super.runWithResults();
		return new FinalizeOAuthResultSet(result);
	}
	
}
