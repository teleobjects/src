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
WeatherForPointsOnLineSummarized

Retrieve weather information for all points on a line defined by a set of latitude and longitude coordinates.
*/
public class WeatherForPointsOnLineSummarized extends Choreography {

	/**
	Create a new instance of the WeatherForPointsOnLineSummarized Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public WeatherForPointsOnLineSummarized(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NOAA/WeatherForPointsOnLineSummarized"));
	}

	/** 
	Set the value of the Endpoint1Latitude input for this Choreo. 

	@param BigDecimal - (required, decimal) Enter the latitude of the first endpoint of the line for which weather data is requested. North latitude is positive.
	*/
	public void setEndpoint1Latitude(BigDecimal value) {
		this.inputs.setInput("Endpoint1Latitude", value);
	}

	/** 
	Set the value of the Endpoint1Latitude input for this Choreo as a String. 

	@param String - (required, decimal) Enter the latitude of the first endpoint of the line for which weather data is requested. North latitude is positive.
	*/
	public void setEndpoint1Latitude(String value) {
		this.inputs.setInput("Endpoint1Latitude", value);	
	}
	/** 
	Set the value of the Endpoint1Longitude input for this Choreo. 

	@param BigDecimal - (required, decimal) Enter the longitude of the first endpoint of the line for which weather data is requested. West longitude is negative.
	*/
	public void setEndpoint1Longitude(BigDecimal value) {
		this.inputs.setInput("Endpoint1Longitude", value);
	}

	/** 
	Set the value of the Endpoint1Longitude input for this Choreo as a String. 

	@param String - (required, decimal) Enter the longitude of the first endpoint of the line for which weather data is requested. West longitude is negative.
	*/
	public void setEndpoint1Longitude(String value) {
		this.inputs.setInput("Endpoint1Longitude", value);	
	}
	/** 
	Set the value of the Endpoint2Latitude input for this Choreo. 

	@param BigDecimal - (required, decimal) Enter the latitude of the second endpoint of the line for which weather data is requested. North latitude is positive.
	*/
	public void setEndpoint2Latitude(BigDecimal value) {
		this.inputs.setInput("Endpoint2Latitude", value);
	}

	/** 
	Set the value of the Endpoint2Latitude input for this Choreo as a String. 

	@param String - (required, decimal) Enter the latitude of the second endpoint of the line for which weather data is requested. North latitude is positive.
	*/
	public void setEndpoint2Latitude(String value) {
		this.inputs.setInput("Endpoint2Latitude", value);	
	}
	/** 
	Set the value of the Endpoint2Longitude input for this Choreo. 

	@param BigDecimal - (required, decimal) Enter the longitude of the second endpoint of the line for which weather data is requested. West longitude is negative.
	*/
	public void setEndpoint2Longitude(BigDecimal value) {
		this.inputs.setInput("Endpoint2Longitude", value);
	}

	/** 
	Set the value of the Endpoint2Longitude input for this Choreo as a String. 

	@param String - (required, decimal) Enter the longitude of the second endpoint of the line for which weather data is requested. West longitude is negative.
	*/
	public void setEndpoint2Longitude(String value) {
		this.inputs.setInput("Endpoint2Longitude", value);	
	}
	/** 
	Set the value of the Format input for this Choreo. 

	@param String - (required, string) Specify a timespan for which NDFD data will be summarized. Enter: 24 hourly, for a 24 hour summary, or: 12 hourly, for a 12 hour weather summary.
	*/
	public void setFormat(String value) {
		this.inputs.setInput("Format", value);
	}


	/** 
	Set the value of the NumberOfDays input for this Choreo. 

	@param Integer - (optional, integer) The number of days to retrieve data from.  If left blank, defaults to 7 days.
	*/
	public void setNumberOfDays(Integer value) {
		this.inputs.setInput("NumberOfDays", value);
	}

	/** 
	Set the value of the NumberOfDays input for this Choreo as a String. 

	@param String - (optional, integer) The number of days to retrieve data from.  If left blank, defaults to 7 days.
	*/
	public void setNumberOfDays(String value) {
		this.inputs.setInput("NumberOfDays", value);	
	}
	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (optional, date) The start date for retrieval of NDFD information in UTC format (2004-04-27) . If blank, the earliest date in the database is returned. Currently the NDFD may be only logging 1 day of data.
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
	public WeatherForPointsOnLineSummarizedResultSet run() {
		JSONObject result = super.runWithResults();
		return new WeatherForPointsOnLineSummarizedResultSet(result);
	}
	
}
