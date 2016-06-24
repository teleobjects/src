package com.temboo.Library.Utilities.Authentication.OAuth1;

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
InitializeOAuth

Generates an authorization URL that an application can use to complete the first step in the OAuth 1.0 process.
*/
public class InitializeOAuth extends Choreography {

	/**
	Create a new instance of the InitializeOAuth Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public InitializeOAuth(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Authentication/OAuth1/InitializeOAuth"));
	}

	/** 
	Set the value of the AuthorizationEndpoint input for this Choreo. 

	@param String - (required, string) The endpoint that the user should be redirected to in order to authenticate and grant access (e.g. https://www.dropbox.com/1/oauth/authorize).
	*/
	public void setAuthorizationEndpoint(String value) {
		this.inputs.setInput("AuthorizationEndpoint", value);
	}


	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) The Consumer Key provided by the service.
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) The Consumer Secret provided by the service.
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the ForwardingURL input for this Choreo. 

	@param String - (optional, string) The URL that Temboo will redirect your users to after they grant access to your application. This should include the "https://" or "http://" prefix and be a fully qualified URL.
	*/
	public void setForwardingURL(String value) {
		this.inputs.setInput("ForwardingURL", value);
	}


	/** 
	Set the value of the RequestTokenEndpoint input for this Choreo. 

	@param String - (required, string) The Authorization Server URL where the initial token request occurs (e.g. https://api.dropbox.com/1/oauth/request_token).
	*/
	public void setRequestTokenEndpoint(String value) {
		this.inputs.setInput("RequestTokenEndpoint", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public InitializeOAuthResultSet run() {
		JSONObject result = super.runWithResults();
		return new InitializeOAuthResultSet(result);
	}
	
}
