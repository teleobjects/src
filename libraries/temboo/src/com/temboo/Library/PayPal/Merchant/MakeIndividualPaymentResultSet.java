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
import com.temboo.core.Choreography.ResultSet;

	
/**
	A ResultSet with methods tailored to the values returned by the MakeIndividualPayment Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class MakeIndividualPaymentResultSet extends ResultSet {
		
	public MakeIndividualPaymentResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "Acknowledged" output from this Choreo execution

	@return String - (string) Indicates the status of the request. Should contain "Sucess" or "Failure".
	*/
	public String getAcknowledged() {
		return this.getResultString("Acknowledged");
	}
	/** 
	Retrieve the value for the "CorrelationId" output from this Choreo execution

	@return String - (string) A unique id returned by PayPal for this payment.
	*/
	public String getCorrelationId() {
		return this.getResultString("CorrelationId");
	}
	/** 
	Retrieve the value for the "ErrorMessage" output from this Choreo execution

	@return String - (string) This will contain any error message returned by PayPal during this operation.
	*/
	public String getErrorMessage() {
		return this.getResultString("ErrorMessage");
	}
	/** 
	Retrieve the value for the "Timestamp" output from this Choreo execution

	@return String - (date) The timestamp associated with the payment request.
	*/
	public String getTimestamp() {
		return this.getResultString("Timestamp");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - (string) The full response from PayPal formatted in name/value pairs.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}