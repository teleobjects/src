package com.temboo.Library.LinkedIn.Companies;

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
GetCompanyUpdate

Returns a specific update event from the LinkedIn company page.
*/
public class GetCompanyUpdate extends Choreography {

	/**
	Create a new instance of the GetCompanyUpdate Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetCompanyUpdate(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LinkedIn/Companies/GetCompanyUpdate"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by LinkedIn (AKA the Client ID).
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process (AKA the OAuth User Token).
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) The Access Token Secret retrieved during the OAuth process (AKA the OAuth User Secret).
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the CompanyID input for this Choreo. 

	@param Integer - (required, integer) A LinkedIn assigned ID associated with the company.
	*/
	public void setCompanyID(Integer value) {
		this.inputs.setInput("CompanyID", value);
	}

	/** 
	Set the value of the CompanyID input for this Choreo as a String. 

	@param String - (required, integer) A LinkedIn assigned ID associated with the company.
	*/
	public void setCompanyID(String value) {
		this.inputs.setInput("CompanyID", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: xml (the default) and json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SecretKey input for this Choreo. 

	@param String - (required, string) The Secret Key provided by LinkedIn (AKA the Client Secret).
	*/
	public void setSecretKey(String value) {
		this.inputs.setInput("SecretKey", value);
	}


	/** 
	Set the value of the UpdateKey input for this Choreo. 

	@param String - (required, string) The key of the update to return.
	*/
	public void setUpdateKey(String value) {
		this.inputs.setInput("UpdateKey", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetCompanyUpdateResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetCompanyUpdateResultSet(result);
	}
	
}
