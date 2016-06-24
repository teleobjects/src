package com.temboo.Library.Stripe.Subscriptions;

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
UpdateSubscription

Subscribes a customer to a specified plan.
*/
public class UpdateSubscription extends Choreography {

	/**
	Create a new instance of the UpdateSubscription Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateSubscription(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Stripe/Subscriptions/UpdateSubscription"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Stripe
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Coupon input for this Choreo. 

	@param String - (optional, string) If you provide a coupon code, it can be specified here
	*/
	public void setCoupon(String value) {
		this.inputs.setInput("Coupon", value);
	}


	/** 
	Set the value of the CustomerID input for this Choreo. 

	@param String - (required, string) The unique identifier of the customer you want to subscribe to a plan
	*/
	public void setCustomerID(String value) {
		this.inputs.setInput("CustomerID", value);
	}


	/** 
	Set the value of the Metadata input for this Choreo. 

	@param String - (optional, json) A JSON object used to attach key-value data to this Stripe object.
	*/
	public void setMetadata(String value) {
		this.inputs.setInput("Metadata", value);
	}


	/** 
	Set the value of the Plan input for this Choreo. 

	@param String - (required, string) The unique identifier of the plan to subscribe the customer to
	*/
	public void setPlan(String value) {
		this.inputs.setInput("Plan", value);
	}


	/** 
	Set the value of the Prorate input for this Choreo. 

	@param Boolean - (optional, boolean) When set to 1, Stripe will prorate switching plans during a billing cycle. When set to 0, this feature is disabled. Defaults to 1.
	*/
	public void setProrate(Boolean value) {
		this.inputs.setInput("Prorate", value);
	}

	/** 
	Set the value of the Prorate input for this Choreo as a String. 

	@param String - (optional, boolean) When set to 1, Stripe will prorate switching plans during a billing cycle. When set to 0, this feature is disabled. Defaults to 1.
	*/
	public void setProrate(String value) {
		this.inputs.setInput("Prorate", value);	
	}
	/** 
	Set the value of the Token input for this Choreo. 

	@param String - (optional, string) The token associated with a set of credit card details.
	*/
	public void setToken(String value) {
		this.inputs.setInput("Token", value);
	}


	/** 
	Set the value of the TrialEnd input for this Choreo. 

	@param String - (optional, date) A timestamp representing the end of the trial period in UTC. The customer will not be charged during the trial period.
	*/
	public void setTrialEnd(String value) {
		this.inputs.setInput("TrialEnd", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateSubscriptionResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateSubscriptionResultSet(result);
	}
	
}
