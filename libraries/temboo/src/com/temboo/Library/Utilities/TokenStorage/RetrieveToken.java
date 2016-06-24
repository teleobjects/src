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
RetrieveToken

Retrieves a specified token.
*/
public class RetrieveToken extends Choreography {

	/**
	Create a new instance of the RetrieveToken Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrieveToken(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/TokenStorage/RetrieveToken"));
	}

	/** 
	Set the value of the LockToken input for this Choreo. 

	@param Boolean - (optional, boolean) If set to true, the Choreo will attempt to lock the token after retrieving it. If the token is already locked, the Choreo will attempt to get the lock for up-to 1 minute.
	*/
	public void setLockToken(Boolean value) {
		this.inputs.setInput("LockToken", value);
	}

	/** 
	Set the value of the LockToken input for this Choreo as a String. 

	@param String - (optional, boolean) If set to true, the Choreo will attempt to lock the token after retrieving it. If the token is already locked, the Choreo will attempt to get the lock for up-to 1 minute.
	*/
	public void setLockToken(String value) {
		this.inputs.setInput("LockToken", value);	
	}
	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) The name of the token to retrieve.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrieveTokenResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrieveTokenResultSet(result);
	}
	
}
