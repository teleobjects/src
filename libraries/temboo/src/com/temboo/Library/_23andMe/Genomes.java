package com.temboo.Library._23andMe;

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
Genomes

Retrieves the entire profile's genome as a string of base pairs.
*/
public class Genomes extends Choreography {

	/**
	Create a new instance of the Genomes Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Genomes(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/23andMe/Genomes"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved after completing the OAuth2 process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ProfileID input for this Choreo. 

	@param String - (required, string) The unique identifier for a profile to retrieve information for. This ID can be retrieved by running the User Choreo.
	*/
	public void setProfileID(String value) {
		this.inputs.setInput("ProfileID", value);
	}


	/** 
	Set the value of the TestMode input for this Choreo. 

	@param Boolean - (optional, boolean) A boolean flag indicating that the request should be made to the "demo" 23andMe endpoint for testing. Set to 1 for test mode. Defaults to 0.
	*/
	public void setTestMode(Boolean value) {
		this.inputs.setInput("TestMode", value);
	}

	/** 
	Set the value of the TestMode input for this Choreo as a String. 

	@param String - (optional, boolean) A boolean flag indicating that the request should be made to the "demo" 23andMe endpoint for testing. Set to 1 for test mode. Defaults to 0.
	*/
	public void setTestMode(String value) {
		this.inputs.setInput("TestMode", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GenomesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GenomesResultSet(result);
	}
	
}
