package com.temboo.Library.RunKeeper.FitnessActivities;

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
	A ResultSet with methods tailored to the values returned by the RetrieveLatestActivity Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class RetrieveLatestActivityResultSet extends ResultSet {
		
	public RetrieveLatestActivityResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "BeginTime" output from this Choreo execution

	@return String - (date) The start time of the latest activity.
	*/
	public String getBeginTime() {
		return this.getResultString("BeginTime");
	}
	/** 
	Retrieve the value for the "Climb" output from this Choreo execution

	@return String - (decimal) The total elevation climbed over the course of the activity, in meters.
	*/
	public String getClimb() {
		return this.getResultString("Climb");
	}
	/** 
	Retrieve the value for the "Duration" output from this Choreo execution

	@return String - (integer) The duration of the activity, in seconds.
	*/
	public String getDuration() {
		return this.getResultString("Duration");
	}
	/** 
	Retrieve the value for the "Equipment" output from this Choreo execution

	@return String - (string) The equipment used to complete this activity.
	*/
	public String getEquipment() {
		return this.getResultString("Equipment");
	}
	/** 
	Retrieve the value for the "Notes" output from this Choreo execution

	@return String - (string) Any notes that the user has associated with the activity.
	*/
	public String getNotes() {
		return this.getResultString("Notes");
	}
	/** 
	Retrieve the value for the "TotalCalories" output from this Choreo execution

	@return String - (integer) The total calories burned (omitted if not available).
	*/
	public String getTotalCalories() {
		return this.getResultString("TotalCalories");
	}
	/** 
	Retrieve the value for the "TotalDistance" output from this Choreo execution

	@return String - (decimal) The total distance traveled, in meters.
	*/
	public String getTotalDistance() {
		return this.getResultString("TotalDistance");
	}
	/** 
	Retrieve the value for the "Type" output from this Choreo execution

	@return String - (string) The type of activity.
	*/
	public String getType() {
		return this.getResultString("Type");
	}
	/** 
	Retrieve the value for the "URI" output from this Choreo execution

	@return String - (string) The URI of the activity.
	*/
	public String getURI() {
		return this.getResultString("URI");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - (json) The response from RunKeeper.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}