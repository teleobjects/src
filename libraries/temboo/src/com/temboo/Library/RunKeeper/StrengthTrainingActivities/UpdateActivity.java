package com.temboo.Library.RunKeeper.StrengthTrainingActivities;

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
UpdateActivity

Updates a past strength training activity.
*/
public class UpdateActivity extends Choreography {

	/**
	Create a new instance of the UpdateActivity Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateActivity(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/RunKeeper/StrengthTrainingActivities/UpdateActivity"));
	}

	/** 
	Set the value of the Activity input for this Choreo. 

	@param String - (required, json) A JSON string containing the key/value pairs for the activity to update. See documentation for formatting examples.
	*/
	public void setActivity(String value) {
		this.inputs.setInput("Activity", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved after the final step in the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ActivityID input for this Choreo. 

	@param Integer - (required, integer) This can be the individual id of the activity, or you can pass the full uri for the activity as returned from RetrieveActivities response (i.e. /strengthTrainingActivities/125927913).
	*/
	public void setActivityID(Integer value) {
		this.inputs.setInput("ActivityID", value);
	}

	/** 
	Set the value of the ActivityID input for this Choreo as a String. 

	@param String - (required, integer) This can be the individual id of the activity, or you can pass the full uri for the activity as returned from RetrieveActivities response (i.e. /strengthTrainingActivities/125927913).
	*/
	public void setActivityID(String value) {
		this.inputs.setInput("ActivityID", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateActivityResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateActivityResultSet(result);
	}
	
}
