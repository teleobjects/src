package com.temboo.Library.eBay.Trading;

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
FetchToken

Completes the authentication process by retrieving an eBay user token after they have visited the authorization URL returned by the GetSessionID Choreo and clicked "I agree".
*/
public class FetchToken extends Choreography {

	/**
	Create a new instance of the FetchToken Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FetchToken(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/eBay/Trading/FetchToken"));
	}

	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (required, string) The unique identifier for the application.
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the CertID input for this Choreo. 

	@param String - (required, string) The certificate that authenticates the application when making API calls.
	*/
	public void setCertID(String value) {
		this.inputs.setInput("CertID", value);
	}


	/** 
	Set the value of the DevID input for this Choreo. 

	@param String - (required, string) The unique identifier for the developer's account.
	*/
	public void setDevID(String value) {
		this.inputs.setInput("DevID", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SandboxMode input for this Choreo. 

	@param Boolean - (conditional, boolean) Indicates that the request should be made to the sandbox endpoint instead of the production endpoint. Set to 1 to enable sandbox mode.
	*/
	public void setSandboxMode(Boolean value) {
		this.inputs.setInput("SandboxMode", value);
	}

	/** 
	Set the value of the SandboxMode input for this Choreo as a String. 

	@param String - (conditional, boolean) Indicates that the request should be made to the sandbox endpoint instead of the production endpoint. Set to 1 to enable sandbox mode.
	*/
	public void setSandboxMode(String value) {
		this.inputs.setInput("SandboxMode", value);	
	}
	/** 
	Set the value of the SessionID input for this Choreo. 

	@param String - (required, string) The SessionID returned from PayPal. This gets passed to the FetchToken Choreo after the user authorizes the request.
	*/
	public void setSessionID(String value) {
		this.inputs.setInput("SessionID", value);
	}


	/** 
	Set the value of the SiteID input for this Choreo. 

	@param String - (optional, string) The eBay site ID that you want to access. Defaults to 0 indicating the US site.
	*/
	public void setSiteID(String value) {
		this.inputs.setInput("SiteID", value);
	}


	/** 
	Set the value of the Timeout input for this Choreo. 

	@param Integer - (optional, integer) The amount of time (in seconds) to poll eBay to see if your app's user has allowed or denied the request for access. Defaults to 20. Max is 60.
	*/
	public void setTimeout(Integer value) {
		this.inputs.setInput("Timeout", value);
	}

	/** 
	Set the value of the Timeout input for this Choreo as a String. 

	@param String - (optional, integer) The amount of time (in seconds) to poll eBay to see if your app's user has allowed or denied the request for access. Defaults to 20. Max is 60.
	*/
	public void setTimeout(String value) {
		this.inputs.setInput("Timeout", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FetchTokenResultSet run() {
		JSONObject result = super.runWithResults();
		return new FetchTokenResultSet(result);
	}
	
}
