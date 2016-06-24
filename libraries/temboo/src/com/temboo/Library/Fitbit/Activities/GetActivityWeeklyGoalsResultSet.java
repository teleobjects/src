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
import com.temboo.core.Choreography.ResultSet;

	
/**
	A ResultSet with methods tailored to the values returned by the GetActivityWeeklyGoals Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class GetActivityWeeklyGoalsResultSet extends ResultSet {
		
	public GetActivityWeeklyGoalsResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "Distance" output from this Choreo execution

	@return String - (decimal) The distance specified as the weekly goal.
	*/
	public String getDistance() {
		return this.getResultString("Distance");
	}
	/** 
	Retrieve the value for the "Floors" output from this Choreo execution

	@return String - (integer) The number of floors specified as a weekly goal.
	*/
	public String getFloors() {
		return this.getResultString("Floors");
	}
	/** 
	Retrieve the value for the "Steps" output from this Choreo execution

	@return String - (integer) The number of steps specified for a weekly goal.
	*/
	public String getSteps() {
		return this.getResultString("Steps");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - The response from Fitbit.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}