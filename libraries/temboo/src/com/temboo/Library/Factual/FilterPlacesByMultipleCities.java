package com.temboo.Library.Factual;

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
FilterPlacesByMultipleCities

Restrict a query to a specified city.
*/
public class FilterPlacesByMultipleCities extends Choreography {

	/**
	Create a new instance of the FilterPlacesByMultipleCities Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FilterPlacesByMultipleCities(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Factual/FilterPlacesByMultipleCities"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (optional, string) The API Key provided by Factual (AKA the OAuth Consumer Key).
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APISecret input for this Choreo. 

	@param String - (optional, string) The API Secret provided by Factual (AKA the OAuth Consumer Secret).
	*/
	public void setAPISecret(String value) {
		this.inputs.setInput("APISecret", value);
	}


	/** 
	Set the value of the Cities input for this Choreo. 

	@param String - (required, json) A A JSON-encoded array of cities to filter results by.
	*/
	public void setCities(String value) {
		this.inputs.setInput("Cities", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (optional, string) A search string (i.e. Starbucks).
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FilterPlacesByMultipleCitiesResultSet run() {
		JSONObject result = super.runWithResults();
		return new FilterPlacesByMultipleCitiesResultSet(result);
	}
	
}
