package com.temboo.Library.RunKeeper.OAuth;

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

Generates an authorization URL that an application can use to complete the first step in the OAuth process.
*/
public class InitializeOAuth extends Choreography {

	/**
	Create a new instance of the InitializeOAuth Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public InitializeOAuth(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/RunKeeper/OAuth/InitializeOAuth"));
	}

	/** 
	Set the value of the AccountName input for this Choreo. 

	@param String - (optional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setAccountName(String value) {
		this.inputs.setInput("AccountName", value);
	}


	/** 
	Set the value of the AppKeyName input for this Choreo. 

	@param String - (optional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setAppKeyName(String value) {
		this.inputs.setInput("AppKeyName", value);
	}


	/** 
	Set the value of the AppKeyValue input for this Choreo. 

	@param String - (optional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setAppKeyValue(String value) {
		this.inputs.setInput("AppKeyValue", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (required, string) The Client ID provided by RunKeeper after registering your application.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the CustomCallbackID input for this Choreo. 

	@param String - (optional, string) A unique identifier that you can pass to eliminate the need to wait for a Temboo generated CallbackID. Callback identifiers may only contain numbers, letters, periods, and hyphens.
	*/
	public void setCustomCallbackID(String value) {
		this.inputs.setInput("CustomCallbackID", value);
	}


	/** 
	Set the value of the ForwardingURL input for this Choreo. 

	@param String - (optional, string) The URL that Temboo will redirect your users to after they grant access to your application. This should include the "https://" or "http://" prefix and be a fully qualified URL.
	*/
	public void setForwardingURL(String value) {
		this.inputs.setInput("ForwardingURL", value);
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
