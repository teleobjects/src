package com.temboo.Library.Utilities.HTTP;

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
Put

Generates a HTTP PUT request.
*/
public class Put extends Choreography {

	/**
	Create a new instance of the Put Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Put(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/HTTP/Put"));
	}

	/** 
	Set the value of the RequestBody input for this Choreo. 

	@param String - (optional, multiline) The request body for the PUT request.
	*/
	public void setRequestBody(String value) {
		this.inputs.setInput("RequestBody", value);
	}


	/** 
	Set the value of the Debug input for this Choreo. 

	@param Boolean - (optional, boolean) When set to "true", the HTTP debug log will be returned.
	*/
	public void setDebug(Boolean value) {
		this.inputs.setInput("Debug", value);
	}

	/** 
	Set the value of the Debug input for this Choreo as a String. 

	@param String - (optional, boolean) When set to "true", the HTTP debug log will be returned.
	*/
	public void setDebug(String value) {
		this.inputs.setInput("Debug", value);	
	}
	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (optional, password) A valid password. This is used if the request required basic authentication.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the RequestHeaders input for this Choreo. 

	@param String - (optional, json) A JSON object containing up to 10 key/value pairs that will be mapped to the HTTP request headers.
	*/
	public void setRequestHeaders(String value) {
		this.inputs.setInput("RequestHeaders", value);
	}


	/** 
	Set the value of the RequestParameters input for this Choreo. 

	@param String - (optional, json) A JSON object containing up to 10 key/value pairs that will be mapped to the url string as HTTP parameters.
	*/
	public void setRequestParameters(String value) {
		this.inputs.setInput("RequestParameters", value);
	}


	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (required, string) The base URL for the request (including http:// or https://).
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (optional, string) A valid username. This is used if the request required basic authentication.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PutResultSet run() {
		JSONObject result = super.runWithResults();
		return new PutResultSet(result);
	}
	
}
