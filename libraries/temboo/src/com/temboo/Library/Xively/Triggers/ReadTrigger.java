package com.temboo.Library.Xively.Triggers;

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
ReadTrigger

Returns a specific trigger for the authenticated account.
*/
public class ReadTrigger extends Choreography {

	/**
	Create a new instance of the ReadTrigger Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ReadTrigger(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/Triggers/ReadTrigger"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Xively.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "json" (the default) and "xml".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the TriggerID input for this Choreo. 

	@param Integer - (required, integer) ID for the trigger that you wish to retrieve information about.
	*/
	public void setTriggerID(Integer value) {
		this.inputs.setInput("TriggerID", value);
	}

	/** 
	Set the value of the TriggerID input for this Choreo as a String. 

	@param String - (required, integer) ID for the trigger that you wish to retrieve information about.
	*/
	public void setTriggerID(String value) {
		this.inputs.setInput("TriggerID", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ReadTriggerResultSet run() {
		JSONObject result = super.runWithResults();
		return new ReadTriggerResultSet(result);
	}
	
}
