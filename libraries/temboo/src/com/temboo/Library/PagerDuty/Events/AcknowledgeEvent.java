package com.temboo.Library.PagerDuty.Events;

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
AcknowledgeEvent

Updates the state of an incident to "acknowleged", and allows you to log data to an incident log.
*/
public class AcknowledgeEvent extends Choreography {

	/**
	Create a new instance of the AcknowledgeEvent Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AcknowledgeEvent(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/PagerDuty/Events/AcknowledgeEvent"));
	}

	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) A short description that will appear in the incident's log associated with this event.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the Details input for this Choreo. 

	@param String - (optional, json) A JSON object containing any data you'd like included in the incident log.
	*/
	public void setDetails(String value) {
		this.inputs.setInput("Details", value);
	}


	/** 
	Set the value of the IncidentKey input for this Choreo. 

	@param String - (required, string) Identifies the incident to acknowledge.
	*/
	public void setIncidentKey(String value) {
		this.inputs.setInput("IncidentKey", value);
	}


	/** 
	Set the value of the ServiceKey input for this Choreo. 

	@param String - (required, string) The service key of one of your "Generic API" services. This is listed on a Generic API's service detail page.
	*/
	public void setServiceKey(String value) {
		this.inputs.setInput("ServiceKey", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AcknowledgeEventResultSet run() {
		JSONObject result = super.runWithResults();
		return new AcknowledgeEventResultSet(result);
	}
	
}
