package com.temboo.Library.Yahoo.PlaceFinder;

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
FindByCoordinates

Retrieves complete location information from a specified pair of latitude and longitude coordinates.
*/
public class FindByCoordinates extends Choreography {

	/**
	Create a new instance of the FindByCoordinates Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FindByCoordinates(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Yahoo/PlaceFinder/FindByCoordinates"));
	}

	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (optional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the GeocodeFlags input for this Choreo. 

	@param String - (optional, string) Affects how geocoding is performed for the request. Valid value are: A, C, L, Q, or R. See documentation for more details on this parameter.
	*/
	public void setGeocodeFlags(String value) {
		this.inputs.setInput("GeocodeFlags", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The latitude coordinate of the location you want to find (e.g., 38.898717).
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (required, decimal) The latitude coordinate of the location you want to find (e.g., 38.898717).
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The longitude coordinate of the location you want to find (e.g., -77.035974).
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (required, decimal) The longitude coordinate of the location you want to find (e.g., -77.035974).
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the ResponseFlags input for this Choreo. 

	@param String - (optional, string) Determines which data elements are returned in the response. Valid values are: B, C, D, E, G, I, J, Q, R, T, U, W, X. See documentation for details on this parameter.
	*/
	public void setResponseFlags(String value) {
		this.inputs.setInput("ResponseFlags", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: xml (the default) and json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FindByCoordinatesResultSet run() {
		JSONObject result = super.runWithResults();
		return new FindByCoordinatesResultSet(result);
	}
	
}
