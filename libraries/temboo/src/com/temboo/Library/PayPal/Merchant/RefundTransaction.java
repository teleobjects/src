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
RefundTransaction

Issue a refund to a PayPal buyer by specifying a transaction ID.
*/
public class RefundTransaction extends Choreography {

	/**
	Create a new instance of the RefundTransaction Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RefundTransaction(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PayPal/Merchant/RefundTransaction"));
	}

	/** 
	Set the value of the Amount input for this Choreo. 

	@param BigDecimal - (optional, decimal) Refund amount. Amount is required if RefundType is set to Partial. If RefundType is set to Full, leave input blank.
	*/
	public void setAmount(BigDecimal value) {
		this.inputs.setInput("Amount", value);
	}

	/** 
	Set the value of the Amount input for this Choreo as a String. 

	@param String - (optional, decimal) Refund amount. Amount is required if RefundType is set to Partial. If RefundType is set to Full, leave input blank.
	*/
	public void setAmount(String value) {
		this.inputs.setInput("Amount", value);	
	}
	/** 
	Set the value of the CurrencyCode input for this Choreo. 

	@param String - (optional, string) A three-character currency code (i.e. USD). Required for partial refunds. Leave this field blank for full refunds. Defaults to USD.
	*/
	public void setCurrencyCode(String value) {
		this.inputs.setInput("CurrencyCode", value);
	}


	/** 
	Set the value of the InvoiceID input for this Choreo. 

	@param String - (optional, string) Your own invoice or tracking number. Character length limitation is 127 alphanumeric characters.
	*/
	public void setInvoiceID(String value) {
		this.inputs.setInput("InvoiceID", value);
	}


	/** 
	Set the value of the Note input for this Choreo. 

	@param String - (optional, string) Custom note about the refund. Character length limitation is 255 alphanumeric characters.
	*/
	public void setNote(String value) {
		this.inputs.setInput("Note", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The API Password provided by PayPal.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the RefundType input for this Choreo. 

	@param String - (required, string) The refund type must be set to Full or Partial.  This flag effects what values some other input variables should have. Defaults to Full.
	*/
	public void setRefundType(String value) {
		this.inputs.setInput("RefundType", value);
	}


	/** 
	Set the value of the Signature input for this Choreo. 

	@param String - (required, string) The API Signature provided by PayPal.
	*/
	public void setSignature(String value) {
		this.inputs.setInput("Signature", value);
	}


	/** 
	Set the value of the TransactionID input for this Choreo. 

	@param String - (required, string) The ID for the transaction you want to retrieve data for.
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
	public RefundTransactionResultSet run() {
		JSONObject result = super.runWithResults();
		return new RefundTransactionResultSet(result);
	}
	
}
