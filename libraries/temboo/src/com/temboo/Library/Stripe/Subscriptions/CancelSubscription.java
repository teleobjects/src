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
CancelSubscription

Cancels an existing subscription.
*/
public class CancelSubscription extends Choreography {

	/**
	Create a new instance of the CancelSubscription Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CancelSubscription(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Stripe/Subscriptions/CancelSubscription"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Stripe
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AtPeriodEnd input for this Choreo. 

	@param Boolean - (optional, boolean) Delays the cancellation of the subscription until the end of the current period when set to 1. Defaults to 0.
	*/
	public void setAtPeriodEnd(Boolean value) {
		this.inputs.setInput("AtPeriodEnd", value);
	}

	/** 
	Set the value of the AtPeriodEnd input for this Choreo as a String. 

	@param String - (optional, boolean) Delays the cancellation of the subscription until the end of the current period when set to 1. Defaults to 0.
	*/
	public void setAtPeriodEnd(String value) {
		this.inputs.setInput("AtPeriodEnd", value);	
	}
	/** 
	Set the value of the CustomerID input for this Choreo. 

	@param String - (required, string) The id of the customer whose subscription you want to cancel
	*/
	public void setCustomerID(String value) {
		this.inputs.setInput("CustomerID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CancelSubscriptionResultSet run() {
		JSONObject result = super.runWithResults();
		return new CancelSubscriptionResultSet(result);
	}
	
}
