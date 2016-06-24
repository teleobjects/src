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
PaymentDetails

Retrieves information about a specific payment.
*/
public class PaymentDetails extends Choreography {

	/**
	Create a new instance of the PaymentDetails Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PaymentDetails(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PayPal/AdaptivePayments/PaymentDetails"));
	}

	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (required, string) Your PayPal AppID (or the default AppID for the PayPal sandbox).
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The API Password provided by PayPal.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the PayKey input for this Choreo. 

	@param String - (conditional, string) The pay key that identifies the payment for which you want to retrieve details. This is the pay key returned in the response of the Pay method.
	*/
	public void setPayKey(String value) {
		this.inputs.setInput("PayKey", value);
	}


	/** 
	Set the value of the Signature input for this Choreo. 

	@param String - (required, string) The API Signature provided by PayPal.
	*/
	public void setSignature(String value) {
		this.inputs.setInput("Signature", value);
	}


	/** 
	Set the value of the TrackingID input for this Choreo. 

	@param String - (optional, string) The tracking ID that was specified for this payment in the PayRequest message.
	*/
	public void setTrackingID(String value) {
		this.inputs.setInput("TrackingID", value);
	}


	/** 
	Set the value of the TransactionID input for this Choreo. 

	@param String - (optional, string) The PayPal transaction ID associated with the payment. The Instant Payment Notification message associated with the payment contains the transaction ID.
	*/
	public void setTransactionID(String value) {
		this.inputs.setInput("TransactionID", value);
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
	public PaymentDetailsResultSet run() {
		JSONObject result = super.runWithResults();
		return new PaymentDetailsResultSet(result);
	}
	
}
