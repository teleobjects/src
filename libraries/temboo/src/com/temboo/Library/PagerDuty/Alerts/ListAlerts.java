package com.temboo.Library.PagerDuty.Alerts;

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
ListAlerts

List alerts for a given time range and allows you to filter by type.
*/
public class ListAlerts extends Choreography {

	/**
	Create a new instance of the ListAlerts Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListAlerts(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PagerDuty/Alerts/ListAlerts"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by PagerDuty.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Filter input for this Choreo. 

	@param String - (optional, string) Returns only alerts of this type. Valid types are: SMS, Email, Phone, or Push.
	*/
	public void setFilter(String value) {
		this.inputs.setInput("Filter", value);
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
	Set the value of the TimeZone input for this Choreo. 

	@param String - (optional, string) The time zone in which dates in the result will be rendered. Defaults to account time zone.
	*/
	public void setTimeZone(String value) {
		this.inputs.setInput("TimeZone", value);
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
	public ListAlertsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListAlertsResultSet(result);
	}
	
}
