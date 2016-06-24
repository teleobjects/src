package com.temboo.Library.Yahoo.Weather;

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
GetWeatherByAddress

Retrieves the Yahoo Weather RSS Feed for any specified location by address.
*/
public class GetWeatherByAddress extends Choreography {

	/**
	Create a new instance of the GetWeatherByAddress Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetWeatherByAddress(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Yahoo/Weather/GetWeatherByAddress"));
	}

	/** 
	Set the value of the Address input for this Choreo. 

	@param String - (required, string) The address to be searched.
	*/
	public void setAddress(String value) {
		this.inputs.setInput("Address", value);
	}


	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (optional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the Day input for this Choreo. 

	@param Integer - (optional, integer) An index in the range 1 to 5 that corresponds to the forecast day you want to retrieve. Today corresponds to 1, tomorrow corresponds to 2, and so on. Defaults to 1.
	*/
	public void setDay(Integer value) {
		this.inputs.setInput("Day", value);
	}

	/** 
	Set the value of the Day input for this Choreo as a String. 

	@param String - (optional, integer) An index in the range 1 to 5 that corresponds to the forecast day you want to retrieve. Today corresponds to 1, tomorrow corresponds to 2, and so on. Defaults to 1.
	*/
	public void setDay(String value) {
		this.inputs.setInput("Day", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: xml (the default) and json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Units input for this Choreo. 

	@param String - (optional, string) The unit of temperature in the response. Acceptable inputs: f for Fahrenheit or c for Celsius. Defaults to f. When c is specified, all units measurements returned are changed to metric.
	*/
	public void setUnits(String value) {
		this.inputs.setInput("Units", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetWeatherByAddressResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetWeatherByAddressResultSet(result);
	}
	
}
