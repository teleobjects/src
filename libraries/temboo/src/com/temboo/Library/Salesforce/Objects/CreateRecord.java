package com.temboo.Library.Salesforce.Objects;

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
CreateRecord

Creates a new Salesforce Object such as an individual Account, Contact, or Lead record.
*/
public class CreateRecord extends Choreography {

	/**
	Create a new instance of the CreateRecord Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateRecord(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Salesforce/Objects/CreateRecord"));
	}

	/** 
	Set the value of the SObject input for this Choreo. 

	@param String - (required, json) A JSON string containing the SObject properties you wish to set.
	*/
	public void setSObject(String value) {
		this.inputs.setInput("SObject", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved during the OAuth process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Salesforce. Required unless providing a valid AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by Salesforce. Required unless providing a valid AccessToken.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the InstanceName input for this Choreo. 

	@param String - (required, string) The server url prefix that indicates which instance your Salesforce account is on (e.g. na1, na2, na3, etc).
	*/
	public void setInstanceName(String value) {
		this.inputs.setInput("InstanceName", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth Refresh Token used to generate a new access token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SObjectName input for this Choreo. 

	@param String - (required, string) The name of the Salesforce object type being created (e.g. Account, Contact, Lead, etc).
	*/
	public void setSObjectName(String value) {
		this.inputs.setInput("SObjectName", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateRecordResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateRecordResultSet(result);
	}
	
}
