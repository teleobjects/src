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
WeatherByZipcode

Retrieve DWML-encoded NDFD data for a specified zipcode (in 50 U.S. States and Puerto Rico).
*/
public class WeatherByZipcode extends Choreography {

	/**
	Create a new instance of the WeatherByZipcode Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public WeatherByZipcode(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NOAA/WeatherByZipcode"));
	}

	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (optional, date) Enter today's date, or some future date in UTC format. Format: 2004-04-27T12:00. Defaults to NOW if not provided.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the NDFDParameterName input for this Choreo. 

	@param String - (optional, string) Enter an additional weather parameter in the following format: phail=phail. Use only if Product is set to: glance.
	*/
	public void setNDFDParameterName(String value) {
		this.inputs.setInput("NDFDParameterName", value);
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

	@param String - (optional, date) Enter the start time for retrieval of NDWD information in UTC format. If null, the earliest date in the database is returned.  Format: 2004-04-27T12:00.
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
	Set the value of the ZipCodeList input for this Choreo. 

	@param Integer - (required, integer) Enter the zipcode for which NDFD weather information will be retrieved.
	*/
	public void setZipCodeList(Integer value) {
		this.inputs.setInput("ZipCodeList", value);
	}

	/** 
	Set the value of the ZipCodeList input for this Choreo as a String. 

	@param String - (required, integer) Enter the zipcode for which NDFD weather information will be retrieved.
	*/
	public void setZipCodeList(String value) {
		this.inputs.setInput("ZipCodeList", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public WeatherByZipcodeResultSet run() {
		JSONObject result = super.runWithResults();
		return new WeatherByZipcodeResultSet(result);
	}
	
}
