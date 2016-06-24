package com.temboo.Library.Stripe.Customers;

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
CreateCustomerWithToken

Creates a new customer record using a Stripe generated token that represents the customer's credit card information.
*/
public class CreateCustomerWithToken extends Choreography {

	/**
	Create a new instance of the CreateCustomerWithToken Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateCustomerWithToken(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Stripe/Customers/CreateCustomerWithToken"));
	}

	/** 
	Set the value of the Metadata input for this Choreo. 

	@param String - (optional, json) A JSON object used to attach key-value data to this Stripe object.
	*/
	public void setMetadata(String value) {
		this.inputs.setInput("Metadata", value);
	}


	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Stripe
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AccountBalance input for this Choreo. 

	@param Integer - (optional, integer) The amount in cents for the starting account balance. A negative amount represents a credit that will be used before charging the customer's card; a positive amount will be added to the next invoice.
	*/
	public void setAccountBalance(Integer value) {
		this.inputs.setInput("AccountBalance", value);
	}

	/** 
	Set the value of the AccountBalance input for this Choreo as a String. 

	@param String - (optional, integer) The amount in cents for the starting account balance. A negative amount represents a credit that will be used before charging the customer's card; a positive amount will be added to the next invoice.
	*/
	public void setAccountBalance(String value) {
		this.inputs.setInput("AccountBalance", value);	
	}
	/** 
	Set the value of the Coupon input for this Choreo. 

	@param String - (optional, string) If you provide a coupon code, it can be specified here
	*/
	public void setCoupon(String value) {
		this.inputs.setInput("Coupon", value);
	}


	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) An arbitrary string of text that will be associated with the customer object
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (optional, string) The customer's email address
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the Plan input for this Choreo. 

	@param String - (optional, string) The unique identifier of the plan to subscribe the customer to
	*/
	public void setPlan(String value) {
		this.inputs.setInput("Plan", value);
	}


	/** 
	Set the value of the Quantity input for this Choreo. 

	@param Integer - (optional, integer) The quantity you'd like to apply to the subscription you're creating. This parameter applies to the plan amount associated with the customer.
	*/
	public void setQuantity(Integer value) {
		this.inputs.setInput("Quantity", value);
	}

	/** 
	Set the value of the Quantity input for this Choreo as a String. 

	@param String - (optional, integer) The quantity you'd like to apply to the subscription you're creating. This parameter applies to the plan amount associated with the customer.
	*/
	public void setQuantity(String value) {
		this.inputs.setInput("Quantity", value);	
	}
	/** 
	Set the value of the Token input for this Choreo. 

	@param String - (conditional, string) The token associated with a set of credit card details
	*/
	public void setToken(String value) {
		this.inputs.setInput("Token", value);
	}


	/** 
	Set the value of the TrialEnd input for this Choreo. 

	@param String - (optional, date) Epoch timestamp in seconds for the end of the trial period. The customer won't be charged during the trial period. Timestamp should be in UTC.
	*/
	public void setTrialEnd(String value) {
		this.inputs.setInput("TrialEnd", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateCustomerWithTokenResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateCustomerWithTokenResultSet(result);
	}
	
}
