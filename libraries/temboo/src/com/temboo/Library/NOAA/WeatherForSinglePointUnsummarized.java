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
WeatherForSinglePointUnsummarized

Retrieve unsummarized weather information for a single point defined by latitude and longitude coordinates.
*/
public class WeatherForSinglePointUnsummarized extends Choreography {

	/**
	Create a new instance of the WeatherForSinglePointUnsummarized Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public WeatherForSinglePointUnsummarized(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NOAA/WeatherForSinglePointUnsummarized"));
	}

	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (optional, date) Enter the end time for retrieval of NDWD information in UTC format. If null, the last available time in the database is returned. Format: 2004-04-27T12:00.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (required, decimal) Enter the latitude coordinate of the point for which weather data is requested. North latitude is positive.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (required, decimal) Enter the latitude coordinate of the point for which weather data is requested. North latitude is positive.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (required, decimal) Enter the longitude coordinate of the point for which weather data is requested. West longitude is negative.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (required, decimal) Enter the longitude coordinate of the point for which weather data is requested. West longitude is negative.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the Product input for this Choreo. 

	@param String - (required, string) Enter one of two parameters: time-series (to return all data between the Begin and End time parameters); glance for a subset of 5 often used parameters
	*/
	public void setProduct(String value) {
		this.inputs.setInput("Product", value);
	}


	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (optional, date) Enter the start time for retrieval of NDWD information in UTC format. If null, the earliest time in the database is returned. Format: 2004-04-27T12:00.
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	/** 
	Set the value of the Unit input for this Choreo. 

	@param String - (optional, string) Enter the unit format the data will be displayed in. Default is: e, for Standard English (U.S. Standard).  Or: m, for Metric (SI Units).
	*/
	public void setUnit(String value) {
		this.inputs.setInput("Unit", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public WeatherForSinglePointUnsummarizedResultSet run() {
		JSONObject result = super.runWithResults();
		return new WeatherForSinglePointUnsummarizedResultSet(result);
	}
	
}
