package com.temboo.Library.Dwolla.Transactions;

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
Request

Use this method to request funds from a source user, originating from the user associated with the authorized access token.
*/
public class Request extends Choreography {

	/**
	Create a new instance of the Request Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Request(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dwolla/Transactions/Request"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) A valid OAuth token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Amount input for this Choreo. 

	@param BigDecimal - (required, decimal) Amount of funds to request from the source user.
	*/
	public void setAmount(BigDecimal value) {
		this.inputs.setInput("Amount", value);
	}

	/** 
	Set the value of the Amount input for this Choreo as a String. 

	@param String - (required, decimal) Amount of funds to request from the source user.
	*/
	public void setAmount(String value) {
		this.inputs.setInput("Amount", value);	
	}
	/** 
	Set the value of the FacillitatorAmount input for this Choreo. 

	@param BigDecimal - (optional, decimal) Amount of the facilitator fee to override. Only applicable if the facilitator fee feature is enabled. If set to 0, facilitator fee is disabled for transaction. Cannot exceed 25% of the 'amount'.
	*/
	public void setFacillitatorAmount(BigDecimal value) {
		this.inputs.setInput("FacillitatorAmount", value);
	}

	/** 
	Set the value of the FacillitatorAmount input for this Choreo as a String. 

	@param String - (optional, decimal) Amount of the facilitator fee to override. Only applicable if the facilitator fee feature is enabled. If set to 0, facilitator fee is disabled for transaction. Cannot exceed 25% of the 'amount'.
	*/
	public void setFacillitatorAmount(String value) {
		this.inputs.setInput("FacillitatorAmount", value);	
	}
	/** 
	Set the value of the Notes input for this Choreo. 

	@param String - (optional, multiline) Note to attach to the transaction. Limited to 250 characters.
	*/
	public void setNotes(String value) {
		this.inputs.setInput("Notes", value);
	}


	/** 
	Set the value of the Pin input for this Choreo. 

	@param Integer - (required, integer) User's PIN associated with their account.
	*/
	public void setPin(Integer value) {
		this.inputs.setInput("Pin", value);
	}

	/** 
	Set the value of the Pin input for this Choreo as a String. 

	@param String - (required, integer) User's PIN associated with their account.
	*/
	public void setPin(String value) {
		this.inputs.setInput("Pin", value);	
	}
	/** 
	Set the value of the SourceID input for this Choreo. 

	@param String - (required, string) Identification of the user to request funds from. Must be the Dwolla identifier, Facebook identifier, Twitter screename, phone number, or email address.
	*/
	public void setSourceID(String value) {
		this.inputs.setInput("SourceID", value);
	}


	/** 
	Set the value of the SourceType input for this Choreo. 

	@param String - (optional, string) Type of destination user. Defaults to Dwolla. Can be Dwolla, Facebook, Twitter, Email, or Phone.
	*/
	public void setSourceType(String value) {
		this.inputs.setInput("SourceType", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RequestResultSet run() {
		JSONObject result = super.runWithResults();
		return new RequestResultSet(result);
	}
	
}
