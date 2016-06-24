package com.temboo.Library.Fitbit.Activities;

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
UpdateActivityWeeklyGoals

Create or updates a user's weekly activity goals.
*/
public class UpdateActivityWeeklyGoals extends Choreography {

	/**
	Create a new instance of the UpdateActivityWeeklyGoals Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateActivityWeeklyGoals(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Fitbit/Activities/UpdateActivityWeeklyGoals"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the Distance input for this Choreo. 

	@param BigDecimal - (conditional, decimal) The desired distance for a weekly activity goal.
	*/
	public void setDistance(BigDecimal value) {
		this.inputs.setInput("Distance", value);
	}

	/** 
	Set the value of the Distance input for this Choreo as a String. 

	@param String - (conditional, decimal) The desired distance for a weekly activity goal.
	*/
	public void setDistance(String value) {
		this.inputs.setInput("Distance", value);	
	}
	/** 
	Set the value of the Floors input for this Choreo. 

	@param Integer - (conditional, integer) The number of floors walked for a weekly activity goal.
	*/
	public void setFloors(Integer value) {
		this.inputs.setInput("Floors", value);
	}

	/** 
	Set the value of the Floors input for this Choreo as a String. 

	@param String - (conditional, integer) The number of floors walked for a weekly activity goal.
	*/
	public void setFloors(String value) {
		this.inputs.setInput("Floors", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that you want the response to be in: xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Steps input for this Choreo. 

	@param Integer - (conditional, integer) The number of steps to take for a weekly activity goal.
	*/
	public void setSteps(Integer value) {
		this.inputs.setInput("Steps", value);
	}

	/** 
	Set the value of the Steps input for this Choreo as a String. 

	@param String - (conditional, integer) The number of steps to take for a weekly activity goal.
	*/
	public void setSteps(String value) {
		this.inputs.setInput("Steps", value);	
	}
	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The user's encoded id. Defaults to "-" (dash) which will return data for the user associated with the token credentials provided.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateActivityWeeklyGoalsResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateActivityWeeklyGoalsResultSet(result);
	}
	
}
