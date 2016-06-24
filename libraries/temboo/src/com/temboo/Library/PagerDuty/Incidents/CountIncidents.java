package com.temboo.Library.PagerDuty.Incidents;

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
CountIncidents

Returns a count of incidents that match a specified criteria.
*/
public class CountIncidents extends Choreography {

	/**
	Create a new instance of the CountIncidents Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CountIncidents(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PagerDuty/Incidents/CountIncidents"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by PagerDuty.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AssignedToUser input for this Choreo. 

	@param String - (optional, string) Returns the count of incidents assigned to the specified user.
	*/
	public void setAssignedToUser(String value) {
		this.inputs.setInput("AssignedToUser", value);
	}


	/** 
	Set the value of the DateRange input for this Choreo. 

	@param String - (optional, string) When set to "all", this allows you to retrieve the count of all incidents since the account was created.
	*/
	public void setDateRange(String value) {
		this.inputs.setInput("DateRange", value);
	}


	/** 
	Set the value of the IncidentKey input for this Choreo. 

	@param String - (optional, string) Returns the count of incidents with the specified key.
	*/
	public void setIncidentKey(String value) {
		this.inputs.setInput("IncidentKey", value);
	}


	/** 
	Set the value of the Service input for this Choreo. 

	@param String - (optional, string) Returns the count of incidents associated with the specified service.
	*/
	public void setService(String value) {
		this.inputs.setInput("Service", value);
	}


	/** 
	Set the value of the Since input for this Choreo. 

	@param String - (optional, date) The start of the date range to search (e.g., 2013-03-06T15:28-05). Note that including the time is optional.
	*/
	public void setSince(String value) {
		this.inputs.setInput("Since", value);
	}


	/** 
	Set the value of the Status input for this Choreo. 

	@param String - (optional, string) Returns the count of incidents with this specified status. Valid values are: triggered, acknowledged, and resolved.
	*/
	public void setStatus(String value) {
		this.inputs.setInput("Status", value);
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
	public CountIncidentsResultSet run() {
		JSONObject result = super.runWithResults();
		return new CountIncidentsResultSet(result);
	}
	
}
