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

	@return String - (date) The start time of the activity.
	*/
	public String getBeginTime() {
		return this.getResultString("BeginTime");
	}
	/** 
	Retrieve the value for the "Notes" output from this Choreo execution

	@return String - (string) Notes for the latest activity entry.
	*/
	public String getNotes() {
		return this.getResultString("Notes");
	}
	/** 
	Retrieve the value for the "PrimaryMuscleGroup" output from this Choreo execution

	@return String - (string) The primary muscle group used in the activity.
	*/
	public String getPrimaryMuscleGroup() {
		return this.getResultString("PrimaryMuscleGroup");
	}
	/** 
	Retrieve the value for the "PrimaryType" output from this Choreo execution

	@return String - (string) The primary exercise type for the activity.
	*/
	public String getPrimaryType() {
		return this.getResultString("PrimaryType");
	}
	/** 
	Retrieve the value for the "URI" output from this Choreo execution

	@return String - (string) The activity URI.
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