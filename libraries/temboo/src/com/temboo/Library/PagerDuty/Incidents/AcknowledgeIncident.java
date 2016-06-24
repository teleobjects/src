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
AcknowledgeIncident

Acknowledges an incident.
*/
public class AcknowledgeIncident extends Choreography {

	/**
	Create a new instance of the AcknowledgeIncident Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AcknowledgeIncident(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PagerDuty/Incidents/AcknowledgeIncident"));
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

	@param String - (required, string) The ID of the incident to acknowledge.
	*/
	public void setIncidentID(String value) {
		this.inputs.setInput("IncidentID", value);
	}


	/** 
	Set the value of the RequesterID input for this Choreo. 

	@param String - (required, string) The ID of the user making the request. This will be added to the incident log entry.
	*/
	public void setRequesterID(String value) {
		this.inputs.setInput("RequesterID", value);
	}


	/** 
	Set the value of the SubDomain input for this Choreo. 

	@param String - (required, string) The subdomain of your PagerDuty site address.
	*/
	public void setSubDomain(String value) {
		this.inputs.setInput("SubDomain", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AcknowledgeIncidentResultSet run() {
		JSONObject result = super.runWithResults();
		return new AcknowledgeIncidentResultSet(result);
	}
	
}
