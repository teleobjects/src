package com.temboo.Library.PagerDuty.Reports;

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
AlertsPerTime

Returns high-level statistics about the number of alerts sent for a specified time period.
*/
public class AlertsPerTime extends Choreography {

	/**
	Create a new instance of the AlertsPerTime Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AlertsPerTime(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PagerDuty/Reports/AlertsPerTime"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by PagerDuty.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Rollup input for this Choreo. 

	@param String - (optional, string) Used to rollup totals by time period. Valid values are: daily, weekly, or monthly.
	*/
	public void setRollup(String value) {
		this.inputs.setInput("Rollup", value);
	}


	/** 
	Set the value of the Since input for this Choreo. 

	@param String - (required, date) The start of the date range to search (e.g., 2013-03-06T15:28-05). Note that including the time is optional.
	*/
	public void setSince(String value) {
		this.inputs.setInput("Since", value);
	}


	/** 
	Set the value of the SubDomain input for this Choreo. 

	@param String - (required, string) The subdomain of your PagerDuty site address.
	*/
	public void setSubDomain(String value) {
		this.inputs.setInput("SubDomain", value);
	}


	/** 
	Set the value of the Until input for this Choreo. 

	@param String - (required, date) The end of the date range to search (e.g., 2013-03-06T15:28-05). Note that including the time is optional.
	*/
	public void setUntil(String value) {
		this.inputs.setInput("Until", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AlertsPerTimeResultSet run() {
		JSONObject result = super.runWithResults();
		return new AlertsPerTimeResultSet(result);
	}
	
}
