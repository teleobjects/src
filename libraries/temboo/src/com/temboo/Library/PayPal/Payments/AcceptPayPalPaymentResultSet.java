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
	A ResultSet with methods tailored to the values returned by the AcceptPayPalPayment Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class AcceptPayPalPaymentResultSet extends ResultSet {
		
	public AcceptPayPalPaymentResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "ApprovalURL" output from this Choreo execution

	@return String - (string) The approval url that the application should redirect the user to in order to approve the payment.
	*/
	public String getApprovalURL() {
		return this.getResultString("ApprovalURL");
	}
	/** 
	Retrieve the value for the "NewAccessToken" output from this Choreo execution

	@return String - (string) The new access token retrieved from PayPal when providing the Client ID and Client Secret.
	*/
	public String getNewAccessToken() {
		return this.getResultString("NewAccessToken");
	}
	/** 
	Retrieve the value for the "PaymentID" output from this Choreo execution

	@return String - (string) The id of the payment that was created. This is used to execute the payment after the buyer has approved.
	*/
	public String getPaymentID() {
		return this.getResultString("PaymentID");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - (json) The response from PayPal.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}