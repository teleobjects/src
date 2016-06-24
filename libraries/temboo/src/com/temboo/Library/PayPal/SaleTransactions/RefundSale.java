package com.temboo.Library.PayPal.SaleTransactions;

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
RefundSale

Allows your application to refund a completed payment.
*/
public class RefundSale extends Choreography {

	/**
	Create a new instance of the RefundSale Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RefundSale(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PayPal/SaleTransactions/RefundSale"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved from PayPal. Required unless providing the ClientID and ClientSecret which can be used to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by PayPal. Required unless a valid Access Token is provided.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by PayPal. Required unless a valid Access Token is provided.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the Currency input for this Choreo. 

	@param String - (required, string) The currency associated with the sale (i.e. USD).
	*/
	public void setCurrency(String value) {
		this.inputs.setInput("Currency", value);
	}


	/** 
	Set the value of the SaleID input for this Choreo. 

	@param String - (required, string) The id of the sale to retrieve.
	*/
	public void setSaleID(String value) {
		this.inputs.setInput("SaleID", value);
	}


	/** 
	Set the value of the Scope input for this Choreo. 

	@param String - (optional, string) A space delimited list of resource URL endpoints that the token should have access for. This is only used when providing the ClientID and Client Secret in order to generate a new access token.
	*/
	public void setScope(String value) {
		this.inputs.setInput("Scope", value);
	}


	/** 
	Set the value of the Total input for this Choreo. 

	@param BigDecimal - (required, decimal) The total amount to refund.
	*/
	public void setTotal(BigDecimal value) {
		this.inputs.setInput("Total", value);
	}

	/** 
	Set the value of the Total input for this Choreo as a String. 

	@param String - (required, decimal) The total amount to refund.
	*/
	public void setTotal(String value) {
		this.inputs.setInput("Total", value);	
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
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RefundSaleResultSet run() {
		JSONObject result = super.runWithResults();
		return new RefundSaleResultSet(result);
	}
	
}
