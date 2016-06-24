package com.temboo.Library.Dwolla.Users;

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
Basic

Retrieves the Dwolla account information for the user associated with the specified consumer credentials and Dwolla account identifier.
*/
public class Basic extends Choreography {

	/**
	Create a new instance of the Basic Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Basic(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dwolla/Users/Basic"));
	}

	/** 
	Set the value of the AccountIdentifier input for this Choreo. 

	@param String - (required, string) Dwolla account identifier or email address of the Dwolla account.
	*/
	public void setAccountIdentifier(String value) {
		this.inputs.setInput("AccountIdentifier", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (required, string) The Client ID provided by Dwolla (AKA the Consumer Key).
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (required, string) The Client Secret provided by Dwolla (AKA the Consumer Secret).
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public BasicResultSet run() {
		JSONObject result = super.runWithResults();
		return new BasicResultSet(result);
	}
	
}
