package com.temboo.Library.Stripe.Coupons;

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
RetrieveCoupon

Retrieves a coupon with specified coupon id.
*/
public class RetrieveCoupon extends Choreography {

	/**
	Create a new instance of the RetrieveCoupon Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrieveCoupon(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Stripe/Coupons/RetrieveCoupon"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Stripe
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the CouponID input for this Choreo. 

	@param String - (required, string) The unique identifier of the coupon you want to retrieve
	*/
	public void setCouponID(String value) {
		this.inputs.setInput("CouponID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrieveCouponResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrieveCouponResultSet(result);
	}
	
}
