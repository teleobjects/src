package com.temboo.Library.PayPal.Merchant;

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
AddressVerify

Confirms whether a postal address and postal code match those of the specified PayPal account holder.
*/
public class AddressVerify extends Choreography {

	/**
	Create a new instance of the AddressVerify Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddressVerify(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PayPal/Merchant/AddressVerify"));
	}

	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (required, string) The email address of a PayPal member to verify.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The API Password provided by PayPal.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the PostalCode input for this Choreo. 

	@param String - (required, string) The postal code to verify.
	*/
	public void setPostalCode(String value) {
		this.inputs.setInput("PostalCode", value);
	}


	/** 
	Set the value of the Signature input for this Choreo. 

	@param String - (required, string) The API Signature provided by PayPal.
	*/
	public void setSignature(String value) {
		this.inputs.setInput("Signature", value);
	}


	/** 
	Set the value of the Street input for this Choreo. 

	@param String - (required, string) The first line of the billing or shipping address to verify.
	*/
	public void setStreet(String value) {
		this.inputs.setInput("Street", value);
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

	@param String - (required, string) The API Username provided by PayPal.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddressVerifyResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddressVerifyResultSet(result);
	}
	
}
