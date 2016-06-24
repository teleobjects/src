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
GetBalance

Retrieves the available balance for a PayPal account.
*/
public class GetBalance extends Choreography {

	/**
	Create a new instance of the GetBalance Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetBalance(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PayPal/Merchant/GetBalance"));
	}

	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The API Password provided by PayPal.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Signature input for this Choreo. 

	@param String - (required, string) The API Signature provided by PayPal.
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
	public GetBalanceResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetBalanceResultSet(result);
	}
	
}
