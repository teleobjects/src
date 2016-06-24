package com.temboo.Library.PagerDuty.LogEntries;

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
ListLogEntriesByIncident

Lists all incident log entries associated with a specific incident.
*/
public class ListLogEntriesByIncident extends Choreography {

	/**
	Create a new instance of the ListLogEntriesByIncident Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListLogEntriesByIncident(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PagerDuty/LogEntries/ListLogEntriesByIncident"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by PagerDuty.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the IncidentID input for this Choreo. 

	@param String - (required, string) The ID of the incident associated with the log entries to retrieve.
	*/
	public void setIncidentID(String value) {
		this.inputs.setInput("IncidentID", value);
	}


	/** 
	Set the value of the Include input for this Choreo. 

	@param String - (optional, string) A list of additional details to include in the response. Valid values are: channel, incident, and service.
	*/
	public void setInclude(String value) {
		this.inputs.setInput("Include", value);
	}


	/** 
	Set the value of the IsOverview input for this Choreo. 

	@param Boolean - (optional, boolean) If set to true, only log entries of type trigger, acknowledge, or resolve are returned. Defaults to false.
	*/
	public void setIsOverview(Boolean value) {
		this.inputs.setInput("IsOverview", value);
	}

	/** 
	Set the value of the IsOverview input for this Choreo as a String. 

	@param String - (optional, boolean) If set to true, only log entries of type trigger, acknowledge, or resolve are returned. Defaults to false.
	*/
	public void setIsOverview(String value) {
		this.inputs.setInput("IsOverview", value);	
	}
	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of log events returned. Default (and max limit) is 100.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of log events returned. Default (and max limit) is 100.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) The offset of the first log event record returned. Default is 0.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) The offset of the first log event record returned. Default is 0.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the Since input for this Choreo. 

	@param String - (optional, date) The start of the date range to search (e.g., 2013-03-06T15:28-05). Note that including the time is optional.
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

	@param String - (optional, date) The end of the date range to search (e.g., 2013-03-06T15:28-05). Note that including the time is optional.
	*/
	public void setUntil(String value) {
		this.inputs.setInput("Until", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListLogEntriesByIncidentResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListLogEntriesByIncidentResultSet(result);
	}
	
}
