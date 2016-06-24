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
import com.temboo.core.Choreography.ResultSet;

	
/**
	A ResultSet with methods tailored to the values returned by the PaymentDetails Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class PaymentDetailsResultSet extends ResultSet {
		
	public PaymentDetailsResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "AccountID" output from this Choreo execution

	@return String - (string) The account id of the payment reciever.
	*/
	public String getAccountID() {
		return this.getResultString("AccountID");
	}
	/** 
	Retrieve the value for the "Amount" output from this Choreo execution

	@return String - (decimal) The payment amount.
	*/
	public String getAmount() {
		return this.getResultString("Amount");
	}
	/** 
	Retrieve the value for the "CurrencyCode" output from this Choreo execution

	@return String - (string) The currency code for the payment.
	*/
	public String getCurrencyCode() {
		return this.getResultString("CurrencyCode");
	}
	/** 
	Retrieve the value for the "Email" output from this Choreo execution

	@return String - (string) The receiver email address.
	*/
	public String getEmail() {
		return this.getResultString("Email");
	}
	/** 
	Retrieve the value for the "Status" output from this Choreo execution

	@return String - (string) The status of the payment.
	*/
	public String getStatus() {
		return this.getResultString("Status");
	}
	/** 
	Retrieve the value for the "TransactionStatus" output from this Choreo execution

	@return String - (string) The transaction status of the payment.
	*/
	public String getTransactionStatus() {
		return this.getResultString("TransactionStatus");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - (json) The response from PayPal.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}