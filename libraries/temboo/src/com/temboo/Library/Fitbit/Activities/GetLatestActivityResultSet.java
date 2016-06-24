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
	A ResultSet with methods tailored to the values returned by the GetLatestActivity Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class GetLatestActivityResultSet extends ResultSet {
		
	public GetLatestActivityResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "ActivityID" output from this Choreo execution

	@return String - (string) The ID of the activity.
	*/
	public String getActivityID() {
		return this.getResultString("ActivityID");
	}
	/** 
	Retrieve the value for the "Calories" output from this Choreo execution

	@return String - (integer) Calories burned during this activity.
	*/
	public String getCalories() {
		return this.getResultString("Calories");
	}
	/** 
	Retrieve the value for the "Description" output from this Choreo execution

	@return String - (string) The description of the activity.
	*/
	public String getDescription() {
		return this.getResultString("Description");
	}
	/** 
	Retrieve the value for the "Distance" output from this Choreo execution

	@return String - (decimal) The distance traveled during the activity.
	*/
	public String getDistance() {
		return this.getResultString("Distance");
	}
	/** 
	Retrieve the value for the "Duration" output from this Choreo execution

	@return String - (integer) The duration of the activity (in milliseconds).
	*/
	public String getDuration() {
		return this.getResultString("Duration");
	}
	/** 
	Retrieve the value for the "Name" output from this Choreo execution

	@return String - (string) The name of the activity.
	*/
	public String getName() {
		return this.getResultString("Name");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - The response from Fitbit.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}