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
CreateTrigger

Creates a new trigger.
*/
public class CreateTrigger extends Choreography {

	/**
	Create a new instance of the CreateTrigger Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateTrigger(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/Triggers/CreateTrigger"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Xively.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the DatastreamID input for this Choreo. 

	@param String - (required, string) The ID of the datastream you would like to create a trigger for.
	*/
	public void setDatastreamID(String value) {
		this.inputs.setInput("DatastreamID", value);
	}


	/** 
	Set the value of the FeedID input for this Choreo. 

	@param Integer - (required, integer) The ID of the feed you would like to create a trigger for.
	*/
	public void setFeedID(Integer value) {
		this.inputs.setInput("FeedID", value);
	}

	/** 
	Set the value of the FeedID input for this Choreo as a String. 

	@param String - (required, integer) The ID of the feed you would like to create a trigger for.
	*/
	public void setFeedID(String value) {
		this.inputs.setInput("FeedID", value);	
	}
	/** 
	Set the value of the ThresholdValue input for this Choreo. 

	@param String - (required, string) Threshold that will cause the trigger to activate. Not required if TriggerType = "change", "frozen" or "live". Required for all others.
	*/
	public void setThresholdValue(String value) {
		this.inputs.setInput("ThresholdValue", value);
	}


	/** 
	Set the value of the TriggerType input for this Choreo. 

	@param String - (required, string) Type of trigger. Possible values: "gt", "gte", "lt", "lte", "eq", "change" (any change), "frozen" (no updates for 15 minutes), or "live" (updated again after being frozen).
	*/
	public void setTriggerType(String value) {
		this.inputs.setInput("TriggerType", value);
	}


	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (required, string) The URL that the Xively trigger will post to when activated. Ex: http://requestb.in
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateTriggerResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateTriggerResultSet(result);
	}
	
}
