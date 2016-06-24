package com.temboo.Library.Google.DistanceMatrix;

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
	A ResultSet with methods tailored to the values returned by the DrivingDistanceMatrix Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class DrivingDistanceMatrixResultSet extends ResultSet {
		
	public DrivingDistanceMatrixResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "Distance" output from this Choreo execution

	@return String - (integer) The distance of this route, expressed in meters.
	*/
	public String getDistance() {
		return this.getResultString("Distance");
	}
	/** 
	Retrieve the value for the "Duration" output from this Choreo execution

	@return String - (integer) The duration of this route, expressed in seconds.
	*/
	public String getDuration() {
		return this.getResultString("Duration");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - (json) The response from Google.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}