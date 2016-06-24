package com.temboo.Library.PayPal.Payments;

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
VerifyAllPayments

Verifies that a payment has been successfully completed.
*/
public class VerifyAllPayments extends Choreography {

	/**
	Create a new instance of the VerifyAllPayments Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public VerifyAllPayments(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PayPal/Payments/VerifyAllPayments"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved from PayPal. Required unless providing the ClientID and ClientSecret which can be used to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (conditional, string) Your PayPal AppID (or the default AppID for the PayPal sandbox: APP-80W284485P519543T). This is used to authenticate PayPal's Adaptive Payments API.
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by PayPal. This is used to authenticate PayPal's REST API.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by PayPal. This is used to authenticate PayPal's REST API.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (conditional, string) The API Password provided by PayPal. This is used to authenticate PayPal's Adaptive Payments API.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the ProofOfPayment input for this Choreo. 

	@param String - (required, json) The proof of payment received from the client SDK. This can be a proof of payment received from the Adaptive Payment API or the REST API.
	*/
	public void setProofOfPayment(String value) {
		this.inputs.setInput("ProofOfPayment", value);
	}


	/** 
	Set the value of the Signature input for this Choreo. 

	@param String - (conditional, string) The API Signature provided by PayPal. This is used to authenticate PayPal's Adaptive Payments API.
	*/
	public void setSignature(String value) {
		this.inputs.setInput("Signature", value);
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
	Set the value of the Username input for this Choreo. 

	@param String - (conditional, string) The API Username provided by PayPal. This is used to authenticate PayPal's Adaptive Payments API.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public VerifyAllPaymentsResultSet run() {
		JSONObject result = super.runWithResults();
		return new VerifyAllPaymentsResultSet(result);
	}
	
}
