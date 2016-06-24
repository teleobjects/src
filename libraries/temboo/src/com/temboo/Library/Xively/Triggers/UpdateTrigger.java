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
UpdateTrigger

Updates an existing trigger.
*/
public class UpdateTrigger extends Choreography {

	/**
	Create a new instance of the UpdateTrigger Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateTrigger(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/Triggers/UpdateTrigger"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Xively.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the ThresholdValue input for this Choreo. 

	@param String - (optional, string) Threshold that will cause the trigger to activate. Include input only if changing Threshold Value.
	*/
	public void setThresholdValue(String value) {
		this.inputs.setInput("ThresholdValue", value);
	}


	/** 
	Set the value of the TriggerID input for this Choreo. 

	@param Integer - (required, integer) TriggerID for the trigger that you wish to update.
	*/
	public void setTriggerID(Integer value) {
		this.inputs.setInput("TriggerID", value);
	}

	/** 
	Set the value of the TriggerID input for this Choreo as a String. 

	@param String - (required, integer) TriggerID for the trigger that you wish to update.
	*/
	public void setTriggerID(String value) {
		this.inputs.setInput("TriggerID", value);	
	}
	/** 
	Set the value of the TriggerType input for this Choreo. 

	@param String - (optional, string) Type of trigger. Include input only if changing TriggerType. Valid values: gt, gte, lt, lte, eq, change (any change), frozen (no updates for 15 minutes), or live (updated again after being frozen).
	*/
	public void setTriggerType(String value) {
		this.inputs.setInput("TriggerType", value);
	}


	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (optional, string) The URL that the Xively trigger will post to when activated. Include input only if changing the URL. Ex: http://requestb.in
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateTriggerResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateTriggerResultSet(result);
	}
	
}
