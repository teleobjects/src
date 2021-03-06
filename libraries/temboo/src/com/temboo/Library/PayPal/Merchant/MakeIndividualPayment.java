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
MakeIndividualPayment

Retrieves the available balance for a PayPal account.
*/
public class MakeIndividualPayment extends Choreography {

	/**
	Create a new instance of the MakeIndividualPayment Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public MakeIndividualPayment(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PayPal/Merchant/MakeIndividualPayment"));
	}

	/** 
	Set the value of the CurrencyCode input for this Choreo. 

	@param String - (optional, string) The currency code associated with the PaymentAmount. Defaults to "USD".
	*/
	public void setCurrencyCode(String value) {
		this.inputs.setInput("CurrencyCode", value);
	}


	/** 
	Set the value of the EmailAddress input for this Choreo. 

	@param String - (required, string) The email address used to identify the recipient of the payment.
	*/
	public void setEmailAddress(String value) {
		this.inputs.setInput("EmailAddress", value);
	}


	/** 
	Set the value of the EmailSubject input for this Choreo. 

	@param String - (optional, string) The subject line of the email that PayPal sends when the transaction is completed. Character length and limitations: 255 single-byte alphanumeric characters.
	*/
	public void setEmailSubject(String value) {
		this.inputs.setInput("EmailSubject", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The API Password provided by PayPal.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the PaymentAmount input for this Choreo. 

	@param BigDecimal - (required, decimal) The amount to be paid.
	*/
	public void setPaymentAmount(BigDecimal value) {
		this.inputs.setInput("PaymentAmount", value);
	}

	/** 
	Set the value of the PaymentAmount input for this Choreo as a String. 

	@param String - (required, decimal) The amount to be paid.
	*/
	public void setPaymentAmount(String value) {
		this.inputs.setInput("PaymentAmount", value);	
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
	public MakeIndividualPaymentResultSet run() {
		JSONObject result = super.runWithResults();
		return new MakeIndividualPaymentResultSet(result);
	}
	
}
