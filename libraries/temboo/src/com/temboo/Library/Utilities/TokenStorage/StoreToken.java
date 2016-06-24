package com.temboo.Library.Utilities.TokenStorage;

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
StoreToken

Stores a token.
*/
public class StoreToken extends Choreography {

	/**
	Create a new instance of the StoreToken Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public StoreToken(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/TokenStorage/StoreToken"));
	}

	/** 
	Set the value of the Expires input for this Choreo. 

	@param Integer - (optional, integer) The lifetime of the token (in seconds). Defaults to 0 indicating no expiration.
	*/
	public void setExpires(Integer value) {
		this.inputs.setInput("Expires", value);
	}

	/** 
	Set the value of the Expires input for this Choreo as a String. 

	@param String - (optional, integer) The lifetime of the token (in seconds). Defaults to 0 indicating no expiration.
	*/
	public void setExpires(String value) {
		this.inputs.setInput("Expires", value);	
	}
	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) The token name. When a token does not exist, it will be inserted. When a token does exist, an update is performed.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the Value input for this Choreo. 

	@param String - (required, string) The token value to store. The maximum number of characters for a token is 4096.
	*/
	public void setValue(String value) {
		this.inputs.setInput("Value", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public StoreTokenResultSet run() {
		JSONObject result = super.runWithResults();
		return new StoreTokenResultSet(result);
	}
	
}
