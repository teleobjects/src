package com.temboo.Library.NOAA;

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
ListCityCoordinatesUnsummarized

Retrieve unsummarized latitude and longitude data for a specified list of cities.
*/
public class ListCityCoordinatesUnsummarized extends Choreography {

	/**
	Create a new instance of the ListCityCoordinatesUnsummarized Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListCityCoordinatesUnsummarized(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NOAA/ListCityCoordinatesUnsummarized"));
	}

	/** 
	Set the value of the CitiesLevel input for this Choreo. 

	@param Integer - (integer) Enter a city grouping number to retrieve its latitude and longitude coordinates. For example: enter 1, to obtain information for primary U.S. cities.
	*/
	public void setCitiesLevel(Integer value) {
		this.inputs.setInput("CitiesLevel", value);
	}

	/** 
	Set the value of the CitiesLevel input for this Choreo as a String. 

	@param String - (integer) Enter a city grouping number to retrieve its latitude and longitude coordinates. For example: enter 1, to obtain information for primary U.S. cities.
	*/
	public void setCitiesLevel(String value) {
		this.inputs.setInput("CitiesLevel", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListCityCoordinatesUnsummarizedResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListCityCoordinatesUnsummarizedResultSet(result);
	}
	
}
