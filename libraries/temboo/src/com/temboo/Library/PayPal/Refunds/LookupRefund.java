package com.temboo.Library.PayPal.Refunds;

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
LookupRefund

Retrieves details about a specific refund.
*/
public class LookupRefund extends Choreography {

	/**
	Create a new instance of the LookupRefund Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public LookupRefund(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PayPal/Refunds/LookupRefund"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved from PayPal. Required unless providing the ClientID and ClientSecret which can be used to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by PayPal. Required unless a valid Access Token is provided.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by PayPal. Required unless a valid Access Token is provided.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the RefundID input for this Choreo. 

	@param String - (required, string) The id of the refund to retrieve.
	*/
	public void setRefundID(String value) {
		this.inputs.setInput("RefundID", value);
	}


	/** 
	Set the value of the Scope input for this Choreo. 

	@param String - (optional, string) A space delimited list of resource URL endpoints that the token should have access for. This is only used when providing the ClientID and Client Secret in order to generate a new access token.
	*/
	public void setScope(String value) {
		this.inputs.setInput("Scope", value);
	}


	/** 
	Set the value of the UseSandbox input for this Choreo. 

	@param Boolean - (conditional, boolean) Set to 1 to indicate that you're testing against the PayPal sandbox instead of production. Set to 0 (the default) when moving to production.
	*/
	public void setUseSandbox(Boolean value) {
		this.inputs.setInput("UseSandbox", value);
	}

	/** 
	Set the value of the UseSandbox input for this Choreo as a String. 

	@param String - (conditional, boolean) Set to 1 to indicate that you're testing against the PayPal sandbox instead of production. Set to 0 (the default) when moving to production.
	*/
	public void setUseSandbox(String value) {
		this.inputs.setInput("UseSandbox", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public LookupRefundResultSet run() {
		JSONObject result = super.runWithResults();
		return new LookupRefundResultSet(result);
	}
	
}
