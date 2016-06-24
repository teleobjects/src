package com.temboo.Library.Google.Geocoding;

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
	A ResultSet with methods tailored to the values returned by the GeocodeByAddress Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class GeocodeByAddressResultSet extends ResultSet {
		
	public GeocodeByAddressResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "Latitude" output from this Choreo execution

	@return String - (decimal) The latitude coordinate associated with the address provided.
	*/
	public String getLatitude() {
		return this.getResultString("Latitude");
	}
	/** 
	Retrieve the value for the "Longitude" output from this Choreo execution

	@return String - (decimal) The longitude coordinate associated with the address provided.
	*/
	public String getLongitude() {
		return this.getResultString("Longitude");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - The response from Google.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}