package com.temboo.Library.CloudMine.ObjectStorage;

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
ObjectUpdate

Allows you to update, merge, or create key/value pairs.

*/
public class ObjectUpdate extends Choreography {

	/**
	Create a new instance of the ObjectUpdate Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ObjectUpdate(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/CloudMine/ObjectStorage/ObjectUpdate"));
	}

	/** 
	Set the value of the Data input for this Choreo. 

	@param String - (required, json) A valid JSON object containing key/value pairs.
	*/
	public void setData(String value) {
		this.inputs.setInput("Data", value);
	}


	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by CloudMine after registering your app.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the ApplicationIdentifier input for this Choreo. 

	@param String - (required, string) The application identifier provided by CloudMine after registering your app.
	*/
	public void setApplicationIdentifier(String value) {
		this.inputs.setInput("ApplicationIdentifier", value);
	}


	/** 
	Set the value of the SessionToken input for this Choreo. 

	@param String - (conditional, string) The session token for an existing user (returned by the AccountLogin Choreo). This is only required if your app is performing this operation on behalf of another user.
	*/
	public void setSessionToken(String value) {
		this.inputs.setInput("SessionToken", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ObjectUpdateResultSet run() {
		JSONObject result = super.runWithResults();
		return new ObjectUpdateResultSet(result);
	}
	
}
