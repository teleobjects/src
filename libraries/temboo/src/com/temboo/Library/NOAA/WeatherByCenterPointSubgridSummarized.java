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
WeatherByCenterPointSubgridSummarized

Retrieve weather information for a rectangle defined by a center point and distances in the latitudinal and longitudinal directions.
*/
public class WeatherByCenterPointSubgridSummarized extends Choreography {

	/**
	Create a new instance of the WeatherByCenterPointSubgridSummarized Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public WeatherByCenterPointSubgridSummarized(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NOAA/WeatherByCenterPointSubgridSummarized"));
	}

	/** 
	Set the value of the CenterPointLatitude input for this Choreo. 

	@param BigDecimal - (required, decimal) Enter the latitude specifying the rectangle or the grid center that defines the area being queried. North latitude is positive.
	*/
	public void setCenterPointLatitude(BigDecimal value) {
		this.inputs.setInput("CenterPointLatitude", value);
	}

	/** 
	Set the value of the CenterPointLatitude input for this Choreo as a String. 

	@param String - (required, decimal) Enter the latitude specifying the rectangle or the grid center that defines the area being queried. North latitude is positive.
	*/
	public void setCenterPointLatitude(String value) {
		this.inputs.setInput("CenterPointLatitude", value);	
	}
	/** 
	Set the value of the CenterPointLongitude input for this Choreo. 

	@param BigDecimal - (required, decimal) Enter the longitute specifying the rectangle or the grid center that defines the area being queried. West longitude is negative.
	*/
	public void setCenterPointLongitude(BigDecimal value) {
		this.inputs.setInput("CenterPointLongitude", value);
	}

	/** 
	Set the value of the CenterPointLongitude input for this Choreo as a String. 

	@param String - (required, decimal) Enter the longitute specifying the rectangle or the grid center that defines the area being queried. West longitude is negative.
	*/
	public void setCenterPointLongitude(String value) {
		this.inputs.setInput("CenterPointLongitude", value);	
	}
	/** 
	Set the value of the Format input for this Choreo. 

	@param String - (required, string) Specify a timespan for which NDFD data will be summarized. Enter: 24 hourly, for a 24 hour summary, or: 12 hourly, for a 12 hour weather summary.
	*/
	public void setFormat(String value) {
		this.inputs.setInput("Format", value);
	}


	/** 
	Set the value of the LatitudeDistance input for this Choreo. 

	@param BigDecimal - (required, decimal) Specify the distance from the center point in the latitudinal direction to the rectangle's East/West oriented sides.
	*/
	public void setLatitudeDistance(BigDecimal value) {
		this.inputs.setInput("LatitudeDistance", value);
	}

	/** 
	Set the value of the LatitudeDistance input for this Choreo as a String. 

	@param String - (required, decimal) Specify the distance from the center point in the latitudinal direction to the rectangle's East/West oriented sides.
	*/
	public void setLatitudeDistance(String value) {
		this.inputs.setInput("LatitudeDistance", value);	
	}
	/** 
	Set the value of the LongitudeDistance input for this Choreo. 

	@param BigDecimal - (required, decimal) Specify the distance from the center point in the longitudinal direction to the rectangle's North/South oriented side.
	*/
	public void setLongitudeDistance(BigDecimal value) {
		this.inputs.setInput("LongitudeDistance", value);
	}

	/** 
	Set the value of the LongitudeDistance input for this Choreo as a String. 

	@param String - (required, decimal) Specify the distance from the center point in the longitudinal direction to the rectangle's North/South oriented side.
	*/
	public void setLongitudeDistance(String value) {
		this.inputs.setInput("LongitudeDistance", value);	
	}
	/** 
	Set the value of the NumberOfDays input for this Choreo. 

	@param Integer - (optional, integer) Specify the number of days to retieve data for. If null, data from the earliest date in the dabase is returned.
	*/
	public void setNumberOfDays(Integer value) {
		this.inputs.setInput("NumberOfDays", value);
	}

	/** 
	Set the value of the NumberOfDays input for this Choreo as a String. 

	@param String - (optional, integer) Specify the number of days to retieve data for. If null, data from the earliest date in the dabase is returned.
	*/
	public void setNumberOfDays(String value) {
		this.inputs.setInput("NumberOfDays", value);	
	}
	/** 
	Set the value of the SquareResolution input for this Choreo. 

	@param BigDecimal - (optional, decimal) Enter desired data resolution in kilometers.  Default is 5km.
	*/
	public void setSquareResolution(BigDecimal value) {
		this.inputs.setInput("SquareResolution", value);
	}

	/** 
	Set the value of the SquareResolution input for this Choreo as a String. 

	@param String - (optional, decimal) Enter desired data resolution in kilometers.  Default is 5km.
	*/
	public void setSquareResolution(String value) {
		this.inputs.setInput("SquareResolution", value);	
	}
	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (required, date) Enter the start time for retrieval of NDWD data in following format: 2004-04-27 If null, the earliest date in the database is returned.
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
	public WeatherByCenterPointSubgridSummarizedResultSet run() {
		JSONObject result = super.runWithResults();
		return new WeatherByCenterPointSubgridSummarizedResultSet(result);
	}
	
}
