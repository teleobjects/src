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
import com.temboo.core.Choreography;
import com.temboo.core.Choreography.ResultSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooPath;
import com.temboo.core.TembooSession;

/** 
ListPayments

Retrieves a list of payments.
*/
public class ListPayments extends Choreography {

	/**
	Create a new instance of the ListPayments Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListPayments(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PayPal/Payments/ListPayments"));
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
	Set the value of the Count input for this Choreo. 

	@param Integer - (optional, integer) Number of items to return. Default is 10 with a maximum value of 20.
	*/
	public void setCount(Integer value) {
		this.inputs.setInput("Count", value);
	}

	/** 
	Set the value of the Count input for this Choreo as a String. 

	@param String - (optional, integer) Number of items to return. Default is 10 with a maximum value of 20.
	*/
	public void setCount(String value) {
		this.inputs.setInput("Count", value);	
	}
	/** 
	Set the value of the Scope input for this Choreo. 

	@param String - (optional, string) A space delimited list of resource URL endpoints that the token should have access for. This is only used when providing the ClientID and Client Secret in order to generate a new access token.
	*/
	public void setScope(String value) {
		this.inputs.setInput("Scope", value);
	}


	/** 
	Set the value of the SortBy input for this Choreo. 

	@param String - (optional, string) The field to sort results by. Valid values are: create_time and update_time.
	*/
	public void setSortBy(String value) {
		this.inputs.setInput("SortBy", value);
	}


	/** 
	Set the value of the SortOrder input for this Choreo. 

	@param String - (optional, string) The sort order of the results. Valid values are asc and desc (the default).
	*/
	public void setSortOrder(String value) {
		this.inputs.setInput("SortOrder", value);
	}


	/** 
	Set the value of the StartID input for this Choreo. 

	@param String - (optional, string) The resource ID that indicates the starting resource to return. When results are paged, you can use the next_id response value as the StartID to continue with the next set of results.
	*/
	public void setStartID(String value) {
		this.inputs.setInput("StartID", value);
	}


	/** 
	Set the value of the StartIndex input for this Choreo. 

	@param Integer - (optional, integer) The start index of the resources to be returned. Used to jump to a specific position in the results.
	*/
	public void setStartIndex(Integer value) {
		this.inputs.setInput("StartIndex", value);
	}

	/** 
	Set the value of the StartIndex input for this Choreo as a String. 

	@param String - (optional, integer) The start index of the resources to be returned. Used to jump to a specific position in the results.
	*/
	public void setStartIndex(String value) {
		this.inputs.setInput("StartIndex", value);	
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
	public ListPaymentsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListPaymentsResultSet(result);
	}
	
}
