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
ObjectDelete

Deletes one or more specified keys.
*/
public class ObjectDelete extends Choreography {

	/**
	Create a new instance of the ObjectDelete Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ObjectDelete(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/CloudMine/ObjectStorage/ObjectDelete"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by CloudMine after registering your app.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the All input for this Choreo. 

	@param Boolean - (conditional, boolean) Indicates that all keys should be deleted if the Keys input is left empty. Set to "true" to delete all keys.
	*/
	public void setAll(Boolean value) {
		this.inputs.setInput("All", value);
	}

	/** 
	Set the value of the All input for this Choreo as a String. 

	@param String - (conditional, boolean) Indicates that all keys should be deleted if the Keys input is left empty. Set to "true" to delete all keys.
	*/
	public void setAll(String value) {
		this.inputs.setInput("All", value);	
	}
	/** 
	Set the value of the ApplicationIdentifier input for this Choreo. 

	@param String - (required, string) The application identifier provided by CloudMine after registering your app.
	*/
	public void setApplicationIdentifier(String value) {
		this.inputs.setInput("ApplicationIdentifier", value);
	}


	/** 
	Set the value of the Keys input for this Choreo. 

	@param String - (conditional, string) A comma separated list of keys to delete. Required unless specifying "true" for the All parameter.
	*/
	public void setKeys(String value) {
		this.inputs.setInput("Keys", value);
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
	public ObjectDeleteResultSet run() {
		JSONObject result = super.runWithResults();
		return new ObjectDeleteResultSet(result);
	}
	
}
