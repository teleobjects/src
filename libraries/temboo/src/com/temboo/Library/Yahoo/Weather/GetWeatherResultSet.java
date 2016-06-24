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
import com.temboo.core.Choreography.ResultSet;

	
/**
	A ResultSet with methods tailored to the values returned by the GetWeather Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class GetWeatherResultSet extends ResultSet {
		
	public GetWeatherResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "ConditionCode" output from this Choreo execution

	@return String - (integer) A code representing the current condition.
	*/
	public String getConditionCode() {
		return this.getResultString("ConditionCode");
	}
	/** 
	Retrieve the value for the "ConditionText" output from this Choreo execution

	@return String - (string) The textual description for the current condition.
	*/
	public String getConditionText() {
		return this.getResultString("ConditionText");
	}
	/** 
	Retrieve the value for the "ForecastCode" output from this Choreo execution

	@return String - (integer) A code representing the forecast condition.
	*/
	public String getForecastCode() {
		return this.getResultString("ForecastCode");
	}
	/** 
	Retrieve the value for the "ForecastText" output from this Choreo execution

	@return String - (string) The textual description for the specified day's forecast condition.
	*/
	public String getForecastText() {
		return this.getResultString("ForecastText");
	}
	/** 
	Retrieve the value for the "High" output from this Choreo execution

	@return String - (integer) The high temperature forecast for the specified day.
	*/
	public String getHigh() {
		return this.getResultString("High");
	}
	/** 
	Retrieve the value for the "Humidity" output from this Choreo execution

	@return String - (decimal) The current measurement for atmospheric humidity.
	*/
	public String getHumidity() {
		return this.getResultString("Humidity");
	}
	/** 
	Retrieve the value for the "Low" output from this Choreo execution

	@return String - (integer) The low temperature forecast for the specified day.
	*/
	public String getLow() {
		return this.getResultString("Low");
	}
	/** 
	Retrieve the value for the "Pressure" output from this Choreo execution

	@return String - (decimal) The current measurement for atmospheric pressure.
	*/
	public String getPressure() {
		return this.getResultString("Pressure");
	}
	/** 
	Retrieve the value for the "Temperature" output from this Choreo execution

	@return String - (integer) The current temperature.
	*/
	public String getTemperature() {
		return this.getResultString("Temperature");
	}
	/** 
	Retrieve the value for the "Visibility" output from this Choreo execution

	@return String - (decimal) The current measurement for visibility.
	*/
	public String getVisibility() {
		return this.getResultString("Visibility");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - The response from Yahoo Weather.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}