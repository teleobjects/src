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
ListIncidents

Allows you to list or search PagerDuty incidents.
*/
public class ListIncidents extends Choreography {

	/**
	Create a new instance of the ListIncidents Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListIncidents(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PagerDuty/Incidents/ListIncidents"));
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

	@param String - (optional, string) Returns only incidents assigned to the specified user.
	*/
	public void setAssignedToUser(String value) {
		this.inputs.setInput("AssignedToUser", value);
	}


	/** 
	Set the value of the DateRange input for this Choreo. 

	@param String - (optional, string) When set to "all", this allows you to retrieve all incidents since the account was created.
	*/
	public void setDateRange(String value) {
		this.inputs.setInput("DateRange", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Allows you to select specific incident properties to be returned in the response.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the IncidentKey input for this Choreo. 

	@param String - (optional, string) Returns only incidents with the specified key.
	*/
	public void setIncidentKey(String value) {
		this.inputs.setInput("IncidentKey", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of incidents returned. Default (and max limit) is 100.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of incidents returned. Default (and max limit) is 100.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) The offset of the first incident record returned. Default is 0.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) The offset of the first incident record returned. Default is 0.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the Service input for this Choreo. 

	@param String - (optional, string) Returns only incidents associated with the specified service.
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
	Set the value of the SortBy input for this Choreo. 

	@param String - (optional, string) Used to specify both the field you wish to sort the results on (incident_number, created_on, or resolved_on), as well as the direction (asc/desc) of the results (e.g., created_on:desc).
	*/
	public void setSortBy(String value) {
		this.inputs.setInput("SortBy", value);
	}


	/** 
	Set the value of the Status input for this Choreo. 

	@param String - (optional, string) Returns only the incidents with this specified status. Valid values are: triggered, acknowledged, and resolved.
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
	public ListIncidentsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListIncidentsResultSet(result);
	}
	
}
