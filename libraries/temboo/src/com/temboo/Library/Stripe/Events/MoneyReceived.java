package com.temboo.Library.Stripe.Events;

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
MoneyReceived

Retrieves a list of successful charge events.
*/
public class MoneyReceived extends Choreography {

	/**
	Create a new instance of the MoneyReceived Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public MoneyReceived(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Stripe/Events/MoneyReceived"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Stripe
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Count input for this Choreo. 

	@param Integer - (optional, integer) A limit on the number of events to be returned. Count can range between 1 and 100 items. Defaults to 10.
	*/
	public void setCount(Integer value) {
		this.inputs.setInput("Count", value);
	}

	/** 
	Set the value of the Count input for this Choreo as a String. 

	@param String - (optional, integer) A limit on the number of events to be returned. Count can range between 1 and 100 items. Defaults to 10.
	*/
	public void setCount(String value) {
		this.inputs.setInput("Count", value);	
	}
	/** 
	Set the value of the Created input for this Choreo. 

	@param String - (optional, date) Filters the result based on the event created date (a UTC timestamp).
	*/
	public void setCreated(String value) {
		this.inputs.setInput("Created", value);
	}


	/** 
	Set the value of the GreaterThan input for this Choreo. 

	@param String - (optional, date) Returns events that have been created after this UTC timestamp.
	*/
	public void setGreaterThan(String value) {
		this.inputs.setInput("GreaterThan", value);
	}


	/** 
	Set the value of the GreaterThanEqualTo input for this Choreo. 

	@param String - (optional, date) Returns events that have been created after or equal to this UTC timestamp.
	*/
	public void setGreaterThanEqualTo(String value) {
		this.inputs.setInput("GreaterThanEqualTo", value);
	}


	/** 
	Set the value of the LessThan input for this Choreo. 

	@param String - (optional, date) Return events that were created before this UTC timestamp.
	*/
	public void setLessThan(String value) {
		this.inputs.setInput("LessThan", value);
	}


	/** 
	Set the value of the LessThanEqualTo input for this Choreo. 

	@param String - (optional, date) Return events that were created before or equal to this UTC timestamp.
	*/
	public void setLessThanEqualTo(String value) {
		this.inputs.setInput("LessThanEqualTo", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) An offset into your events array. The API will return the requested number of events starting at that offset.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) An offset into your events array. The API will return the requested number of events starting at that offset.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the ResponseMode input for this Choreo. 

	@param String - (optional, string) Used to simplify the response. Valid values are: simple and verbose. When set to simple, an array of charge amounts is returned. Verbose mode returns an array of charge objects. Defaults to "simple".
	*/
	public void setResponseMode(String value) {
		this.inputs.setInput("ResponseMode", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public MoneyReceivedResultSet run() {
		JSONObject result = super.runWithResults();
		return new MoneyReceivedResultSet(result);
	}
	
}
