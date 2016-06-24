package com.temboo.Library.Parse.PushNotifications;

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
UploadInstallationData

Creates an installation object on Parse.
*/
public class UploadInstallationData extends Choreography {

	/**
	Create a new instance of the UploadInstallationData Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UploadInstallationData(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Parse/PushNotifications/UploadInstallationData"));
	}

	/** 
	Set the value of the Installation input for this Choreo. 

	@param String - (required, json) A JSON string containing the installation data. See documentation for syntax examples.
	*/
	public void setInstallation(String value) {
		this.inputs.setInput("Installation", value);
	}


	/** 
	Set the value of the ApplicationID input for this Choreo. 

	@param String - (required, string) The Application ID provided by Parse.
	*/
	public void setApplicationID(String value) {
		this.inputs.setInput("ApplicationID", value);
	}


	/** 
	Set the value of the RESTAPIKey input for this Choreo. 

	@param String - (required, string) The REST API Key provided by Parse.
	*/
	public void setRESTAPIKey(String value) {
		this.inputs.setInput("RESTAPIKey", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UploadInstallationDataResultSet run() {
		JSONObject result = super.runWithResults();
		return new UploadInstallationDataResultSet(result);
	}
	
}
