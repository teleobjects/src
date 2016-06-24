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
Listing

Retrieves a list of transactions for the user associated with the authorized access token.
*/
public class Listing extends Choreography {

	/**
	Create a new instance of the Listing Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Listing(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dwolla/Transactions/Listing"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) A valid OAuth token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (optional, string) Latest date and time for which to retrieve transactions.  (In ISO 8601 format.  e.g. 2012-07-22)  Defaults to current date and time in UTC.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Number of transactions to retrieve. Defaults to 10. Can be between 1 and 200 transactions.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Number of transactions to retrieve. Defaults to 10. Can be between 1 and 200 transactions.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the SinceDate input for this Choreo. 

	@param String - (optional, string) Earliest date and time (in ISO 8601 format) for which to retrieve transactions. (e.g. 2012-07-20) Defaults to 7 days prior to current date and time in UTC.
	*/
	public void setSinceDate(String value) {
		this.inputs.setInput("SinceDate", value);
	}


	/** 
	Set the value of the Skip input for this Choreo. 

	@param Integer - (optional, integer) Number of transactions to skip. Defaults to 0.
	*/
	public void setSkip(Integer value) {
		this.inputs.setInput("Skip", value);
	}

	/** 
	Set the value of the Skip input for this Choreo as a String. 

	@param String - (optional, integer) Number of transactions to skip. Defaults to 0.
	*/
	public void setSkip(String value) {
		this.inputs.setInput("Skip", value);	
	}
	/** 
	Set the value of the Types input for this Choreo. 

	@param String - (optional, string) Transaction types to retrieve. Must be delimited by a '|'. Options are money_sent, money_received, deposit, withdrawal, and fee. Defaults to include all transaction types.
	*/
	public void setTypes(String value) {
		this.inputs.setInput("Types", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListingResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListingResultSet(result);
	}
	
}
