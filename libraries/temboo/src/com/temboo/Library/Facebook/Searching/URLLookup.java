package com.temboo.Library.Facebook.Searching;

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
URLLookup

Performs a lookup for a Facebook page by URL.
*/
public class URLLookup extends Choreography {

	/**
	Create a new instance of the URLLookup Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public URLLookup(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Facebook/Searching/URLLookup"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token retrieved from the final OAuth step.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) A comma separated list of fields to return (i.e. id,name).
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the IDs input for this Choreo. 

	@param String - (required, string) One or more Open Graph Object URLs. Multiple URLs should be separated by commas.
	*/
	public void setIDs(String value) {
		this.inputs.setInput("IDs", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public URLLookupResultSet run() {
		JSONObject result = super.runWithResults();
		return new URLLookupResultSet(result);
	}
	
}
