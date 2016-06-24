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
FilterRestaurantsByCuisineAndCoordinates

Find restaurants by cuisine and near specified latitude, longitude coordinates.
*/
public class FilterRestaurantsByCuisineAndCoordinates extends Choreography {

	/**
	Create a new instance of the FilterRestaurantsByCuisineAndCoordinates Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FilterRestaurantsByCuisineAndCoordinates(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Factual/FilterRestaurantsByCuisineAndCoordinates"));
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
	Set the value of the Cuisine input for this Choreo. 

	@param String - (required, string) Enter a desired cuisine to narrow the search results. See Choreo doc for a list of available cuisine parameters.
	*/
	public void setCuisine(String value) {
		this.inputs.setInput("Cuisine", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (required, decimal) Enter latitude coordinates of the location defining the center of the search radius.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (required, decimal) Enter latitude coordinates of the location defining the center of the search radius.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (required, decimal) Enter longitude coordinates of the location defining the center of the search radius.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (required, decimal) Enter longitude coordinates of the location defining the center of the search radius.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the Radius input for this Choreo. 

	@param Integer - (required, integer) Provide the radius (in meters, and centered on the latitude-longitude coordinates specified) for which search results will be returned.
	*/
	public void setRadius(Integer value) {
		this.inputs.setInput("Radius", value);
	}

	/** 
	Set the value of the Radius input for this Choreo as a String. 

	@param String - (required, integer) Provide the radius (in meters, and centered on the latitude-longitude coordinates specified) for which search results will be returned.
	*/
	public void setRadius(String value) {
		this.inputs.setInput("Radius", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FilterRestaurantsByCuisineAndCoordinatesResultSet run() {
		JSONObject result = super.runWithResults();
		return new FilterRestaurantsByCuisineAndCoordinatesResultSet(result);
	}
	
}
