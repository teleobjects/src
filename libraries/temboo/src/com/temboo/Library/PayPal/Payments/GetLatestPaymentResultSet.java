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
	A ResultSet with methods tailored to the values returned by the GetLatestPayment Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class GetLatestPaymentResultSet extends ResultSet {
		
	public GetLatestPaymentResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "Amount" output from this Choreo execution

	@return String - (decimal) The amount of the latest payment.
	*/
	public String getAmount() {
		return this.getResultString("Amount");
	}
	/** 
	Retrieve the value for the "CreateTime" output from this Choreo execution

	@return String - (date) The date that the payment was created.
	*/
	public String getCreateTime() {
		return this.getResultString("CreateTime");
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

	@return String - (string) The payment ID.
	*/
	public String getPaymentID() {
		return this.getResultString("PaymentID");
	}
	/** 
	Retrieve the value for the "State" output from this Choreo execution

	@return String - (string) The payment state.
	*/
	public String getState() {
		return this.getResultString("State");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - (json) The response from PayPal.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}