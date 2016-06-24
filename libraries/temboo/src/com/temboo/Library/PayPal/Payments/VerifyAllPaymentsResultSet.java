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
import com.temboo.core.Choreography.ResultSet;

	
/**
	A ResultSet with methods tailored to the values returned by the VerifyAllPayments Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class VerifyAllPaymentsResultSet extends ResultSet {
		
	public VerifyAllPaymentsResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "FailureDescription" output from this Choreo execution

	@return String - (json) When the payment details indicate that the payment status is not complete, this will contain a JSON dictionary of payment status descriptions.
	*/
	public String getFailureDescription() {
		return this.getResultString("FailureDescription");
	}
	/** 
	Retrieve the value for the "VerificationStatus" output from this Choreo execution

	@return String - (string) The status of the payment verification. This will set to either "verified" or "unverified" depending on the status of the payment details.
	*/
	public String getVerificationStatus() {
		return this.getResultString("VerificationStatus");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - (json) The response from PayPal. This includes the full response from retrieving payment details from either the AdaptivePayments API or the Rest API.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}