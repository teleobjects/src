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
Stats

Retrieves the account information for the user associated with the given authorized access token.
*/
public class Stats extends Choreography {

	/**
	Create a new instance of the Stats Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Stats(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dwolla/Transactions/Stats"));
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

	@param String - (optional, string) Ending date and time to for which to process transactions stats. Defaults to current date and time in UTC.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (optional, string) Starting date and time to for which to process transactions stats. Defaults to 0300 of the current day in UTC.
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	/** 
	Set the value of the Types input for this Choreo. 

	@param String - (optional, string) Types of status to retrieve. Must be comma delimited. Options are TransactionsCount and TransactionsTotal. Defaults to include all stats.
	*/
	public void setTypes(String value) {
		this.inputs.setInput("Types", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public StatsResultSet run() {
		JSONObject result = super.runWithResults();
		return new StatsResultSet(result);
	}
	
}
