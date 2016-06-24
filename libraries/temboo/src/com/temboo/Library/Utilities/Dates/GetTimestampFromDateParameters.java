package com.temboo.Library.Utilities.Dates;

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
GetTimestampFromDateParameters

Returns the specified date parameters, expressed as the number of seconds or milliseconds since January 1, 1970 (epoch time).
*/
public class GetTimestampFromDateParameters extends Choreography {

	/**
	Create a new instance of the GetTimestampFromDateParameters Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetTimestampFromDateParameters(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Dates/GetTimestampFromDateParameters"));
	}

	/** 
	Set the value of the Day input for this Choreo. 

	@param Integer - (conditional, integer) Sets the day (1-31) of the timestamp.
	*/
	public void setDay(Integer value) {
		this.inputs.setInput("Day", value);
	}

	/** 
	Set the value of the Day input for this Choreo as a String. 

	@param String - (conditional, integer) Sets the day (1-31) of the timestamp.
	*/
	public void setDay(String value) {
		this.inputs.setInput("Day", value);	
	}
	/** 
	Set the value of the Granularity input for this Choreo. 

	@param String - (optional, string) Set to "seconds" to return the number of seconds since the epoch. Defaults to "milliseconds".
	*/
	public void setGranularity(String value) {
		this.inputs.setInput("Granularity", value);
	}


	/** 
	Set the value of the Hour input for this Choreo. 

	@param Integer - (optional, integer) Sets the hours (0-23) of the timestamp.
	*/
	public void setHour(Integer value) {
		this.inputs.setInput("Hour", value);
	}

	/** 
	Set the value of the Hour input for this Choreo as a String. 

	@param String - (optional, integer) Sets the hours (0-23) of the timestamp.
	*/
	public void setHour(String value) {
		this.inputs.setInput("Hour", value);	
	}
	/** 
	Set the value of the Milliseconds input for this Choreo. 

	@param Integer - (optional, integer) Sets the milliseconds (0-999) of the timestamp.
	*/
	public void setMilliseconds(Integer value) {
		this.inputs.setInput("Milliseconds", value);
	}

	/** 
	Set the value of the Milliseconds input for this Choreo as a String. 

	@param String - (optional, integer) Sets the milliseconds (0-999) of the timestamp.
	*/
	public void setMilliseconds(String value) {
		this.inputs.setInput("Milliseconds", value);	
	}
	/** 
	Set the value of the Minute input for this Choreo. 

	@param Integer - (optional, integer) Sets the minutes (0-59) of the timestamp.
	*/
	public void setMinute(Integer value) {
		this.inputs.setInput("Minute", value);
	}

	/** 
	Set the value of the Minute input for this Choreo as a String. 

	@param String - (optional, integer) Sets the minutes (0-59) of the timestamp.
	*/
	public void setMinute(String value) {
		this.inputs.setInput("Minute", value);	
	}
	/** 
	Set the value of the Month input for this Choreo. 

	@param Integer - (conditional, integer) Sets the month (1-12) of the timestamp.
	*/
	public void setMonth(Integer value) {
		this.inputs.setInput("Month", value);
	}

	/** 
	Set the value of the Month input for this Choreo as a String. 

	@param String - (conditional, integer) Sets the month (1-12) of the timestamp.
	*/
	public void setMonth(String value) {
		this.inputs.setInput("Month", value);	
	}
	/** 
	Set the value of the Second input for this Choreo. 

	@param Integer - (optional, integer) Sets the seconds (0-59) of the timestamp.
	*/
	public void setSecond(Integer value) {
		this.inputs.setInput("Second", value);
	}

	/** 
	Set the value of the Second input for this Choreo as a String. 

	@param String - (optional, integer) Sets the seconds (0-59) of the timestamp.
	*/
	public void setSecond(String value) {
		this.inputs.setInput("Second", value);	
	}
	/** 
	Set the value of the Year input for this Choreo. 

	@param Integer - (conditional, integer) Sets the year of the timestamp.
	*/
	public void setYear(Integer value) {
		this.inputs.setInput("Year", value);
	}

	/** 
	Set the value of the Year input for this Choreo as a String. 

	@param String - (conditional, integer) Sets the year of the timestamp.
	*/
	public void setYear(String value) {
		this.inputs.setInput("Year", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetTimestampFromDateParametersResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetTimestampFromDateParametersResultSet(result);
	}
	
}
