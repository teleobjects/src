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
TransactionSearch

Retrieves transaction history for transactions that meet a specified criteria.
*/
public class TransactionSearch extends Choreography {

	/**
	Create a new instance of the TransactionSearch Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public TransactionSearch(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PayPal/Merchant/TransactionSearch"));
	}

	/** 
	Set the value of the Account input for this Choreo. 

	@param String - (optional, string) Search by credit card number.
	*/
	public void setAccount(String value) {
		this.inputs.setInput("Account", value);
	}


	/** 
	Set the value of the AuctionItemNumber input for this Choreo. 

	@param String - (optional, string) Search by auction item number of the purchased item.
	*/
	public void setAuctionItemNumber(String value) {
		this.inputs.setInput("AuctionItemNumber", value);
	}


	/** 
	Set the value of the CurrencyCode input for this Choreo. 

	@param String - (optional, string) Search by currency code (i.e. USD).
	*/
	public void setCurrencyCode(String value) {
		this.inputs.setInput("CurrencyCode", value);
	}


	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (optional, string) Search by email.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (optional, date) The latest transaction date to return. Must be an epoch timestamp in milliseconds or formatted in UTC like: 2011-05-19T00:00:00Z.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the InvoiceNumber input for this Choreo. 

	@param String - (optional, string) Search by invoice number.
	*/
	public void setInvoiceNumber(String value) {
		this.inputs.setInput("InvoiceNumber", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The API Password provided by PayPal.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the ReceiptId input for this Choreo. 

	@param String - (optional, string) Search by the PayPal receipt ID.
	*/
	public void setReceiptId(String value) {
		this.inputs.setInput("ReceiptId", value);
	}


	/** 
	Set the value of the Receiver input for this Choreo. 

	@param String - (optional, string) Search by the email address of the receiver.
	*/
	public void setReceiver(String value) {
		this.inputs.setInput("Receiver", value);
	}


	/** 
	Set the value of the Signature input for this Choreo. 

	@param String - (required, string) The API Signature provided by PayPal.
	*/
	public void setSignature(String value) {
		this.inputs.setInput("Signature", value);
	}


	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (required, date) The earliest transaction date to return. Must be an epoch timestamp in milliseconds or formatted in UTC like: 2011-05-19T00:00:00Z.
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	/** 
	Set the value of the TransactionAmount input for this Choreo. 

	@param BigDecimal - (optional, decimal) Search by transaction amount.
	*/
	public void setTransactionAmount(BigDecimal value) {
		this.inputs.setInput("TransactionAmount", value);
	}

	/** 
	Set the value of the TransactionAmount input for this Choreo as a String. 

	@param String - (optional, decimal) Search by transaction amount.
	*/
	public void setTransactionAmount(String value) {
		this.inputs.setInput("TransactionAmount", value);	
	}
	/** 
	Set the value of the TransactionClass input for this Choreo. 

	@param String - (optional, string) Search by classification of transaction (i.e. All, Sent, Recieved, etc).
	*/
	public void setTransactionClass(String value) {
		this.inputs.setInput("TransactionClass", value);
	}


	/** 
	Set the value of the TransactionId input for this Choreo. 

	@param String - (optional, string) Search by the transaction ID
	*/
	public void setTransactionId(String value) {
		this.inputs.setInput("TransactionId", value);
	}


	/** 
	Set the value of the TransactionStatus input for this Choreo. 

	@param String - (optional, string) Search by transaction status (i.e. Pending, Processing, Success, Denied, Reversed).
	*/
	public void setTransactionStatus(String value) {
		this.inputs.setInput("TransactionStatus", value);
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
	public TransactionSearchResultSet run() {
		JSONObject result = super.runWithResults();
		return new TransactionSearchResultSet(result);
	}
	
}
