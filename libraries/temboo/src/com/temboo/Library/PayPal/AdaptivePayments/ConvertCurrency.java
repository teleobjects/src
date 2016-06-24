package com.temboo.Library.PayPal.AdaptivePayments;

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
ConvertCurrency

Converts a payment amount from one currency to another.
*/
public class ConvertCurrency extends Choreography {

	/**
	Create a new instance of the ConvertCurrency Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ConvertCurrency(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PayPal/AdaptivePayments/ConvertCurrency"));
	}

	/** 
	Set the value of the Amount input for this Choreo. 

	@param BigDecimal - (required, decimal) The amount that should be converted to a new currency.
	*/
	public void setAmount(BigDecimal value) {
		this.inputs.setInput("Amount", value);
	}

	/** 
	Set the value of the Amount input for this Choreo as a String. 

	@param String - (required, decimal) The amount that should be converted to a new currency.
	*/
	public void setAmount(String value) {
		this.inputs.setInput("Amount", value);	
	}
	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (required, string) Your PayPal AppID (or the default AppID for the PayPal sandbox).
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the ConvertToCurrency input for this Choreo. 

	@param String - (required, string) The currency code that you want to convert to (i.e. GBP).
	*/
	public void setConvertToCurrency(String value) {
		this.inputs.setInput("ConvertToCurrency", value);
	}


	/** 
	Set the value of the CurrencyCode input for this Choreo. 

	@param String - (required, string) The currency code that you want to convert. (i.e. USD).
	*/
	public void setCurrencyCode(String value) {
		this.inputs.setInput("CurrencyCode", value);
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
	public ConvertCurrencyResultSet run() {
		JSONObject result = super.runWithResults();
		return new ConvertCurrencyResultSet(result);
	}
	
}
