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
GetDate

Formats a specified timestamp, or generates the current date in a desired format.
*/
public class GetDate extends Choreography {

	/**
	Create a new instance of the GetDate Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetDate(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Dates/GetDate"));
	}

	/** 
	Set the value of the AddDays input for this Choreo. 

	@param Integer - (optional, integer) Adds the specified number of days to the specified date serial number. A negative number will subtract.
	*/
	public void setAddDays(Integer value) {
		this.inputs.setInput("AddDays", value);
	}

	/** 
	Set the value of the AddDays input for this Choreo as a String. 

	@param String - (optional, integer) Adds the specified number of days to the specified date serial number. A negative number will subtract.
	*/
	public void setAddDays(String value) {
		this.inputs.setInput("AddDays", value);	
	}
	/** 
	Set the value of the AddHours input for this Choreo. 

	@param Integer - (optional, integer) Adds the specified number of hours to the specified date serial number. A negative number will subtract.
	*/
	public void setAddHours(Integer value) {
		this.inputs.setInput("AddHours", value);
	}

	/** 
	Set the value of the AddHours input for this Choreo as a String. 

	@param String - (optional, integer) Adds the specified number of hours to the specified date serial number. A negative number will subtract.
	*/
	public void setAddHours(String value) {
		this.inputs.setInput("AddHours", value);	
	}
	/** 
	Set the value of the AddMinutes input for this Choreo. 

	@param Integer - (optional, integer) Adds the specified number of minutes to the specified date serial number. A negative number will subtract.
	*/
	public void setAddMinutes(Integer value) {
		this.inputs.setInput("AddMinutes", value);
	}

	/** 
	Set the value of the AddMinutes input for this Choreo as a String. 

	@param String - (optional, integer) Adds the specified number of minutes to the specified date serial number. A negative number will subtract.
	*/
	public void setAddMinutes(String value) {
		this.inputs.setInput("AddMinutes", value);	
	}
	/** 
	Set the value of the AddMonths input for this Choreo. 

	@param Integer - (optional, integer) Adds the specified number of months to the specified date serial number. A negative number will subtract.
	*/
	public void setAddMonths(Integer value) {
		this.inputs.setInput("AddMonths", value);
	}

	/** 
	Set the value of the AddMonths input for this Choreo as a String. 

	@param String - (optional, integer) Adds the specified number of months to the specified date serial number. A negative number will subtract.
	*/
	public void setAddMonths(String value) {
		this.inputs.setInput("AddMonths", value);	
	}
	/** 
	Set the value of the AddSeconds input for this Choreo. 

	@param Integer - (optional, integer) Adds the specified number of seconds to the specified date serial number. A negative number will subtract.
	*/
	public void setAddSeconds(Integer value) {
		this.inputs.setInput("AddSeconds", value);
	}

	/** 
	Set the value of the AddSeconds input for this Choreo as a String. 

	@param String - (optional, integer) Adds the specified number of seconds to the specified date serial number. A negative number will subtract.
	*/
	public void setAddSeconds(String value) {
		this.inputs.setInput("AddSeconds", value);	
	}
	/** 
	Set the value of the AddYears input for this Choreo. 

	@param Integer - (optional, integer) Adds the specified number of years to the specified date serial number. A negative number will subtract.
	*/
	public void setAddYears(Integer value) {
		this.inputs.setInput("AddYears", value);
	}

	/** 
	Set the value of the AddYears input for this Choreo as a String. 

	@param String - (optional, integer) Adds the specified number of years to the specified date serial number. A negative number will subtract.
	*/
	public void setAddYears(String value) {
		this.inputs.setInput("AddYears", value);	
	}
	/** 
	Set the value of the Format input for this Choreo. 

	@param String - (conditional, string) The format that the timestamp should be in. Java SimpleDateFormat conventions are supported. Defaults to "yyyy-MM-dd HH:mm:ss".
	*/
	public void setFormat(String value) {
		this.inputs.setInput("Format", value);
	}


	/** 
	Set the value of the LocaleCountry input for this Choreo. 

	@param String - (optional, string) An ISO country code to specify locale.
	*/
	public void setLocaleCountry(String value) {
		this.inputs.setInput("LocaleCountry", value);
	}


	/** 
	Set the value of the LocaleLanguage input for this Choreo. 

	@param String - (optional, string) An ISO language code to specify locale.
	*/
	public void setLocaleLanguage(String value) {
		this.inputs.setInput("LocaleLanguage", value);
	}


	/** 
	Set the value of the LocaleVariant input for this Choreo. 

	@param String - (optional, string) A local variant code such as "NY" to add additional context for a locale.
	*/
	public void setLocaleVariant(String value) {
		this.inputs.setInput("LocaleVariant", value);
	}


	/** 
	Set the value of the SetDay input for this Choreo. 

	@param Integer - (optional, integer) Sets the day of month (1-31) of the specified date serial number.
	*/
	public void setSetDay(Integer value) {
		this.inputs.setInput("SetDay", value);
	}

	/** 
	Set the value of the SetDay input for this Choreo as a String. 

	@param String - (optional, integer) Sets the day of month (1-31) of the specified date serial number.
	*/
	public void setSetDay(String value) {
		this.inputs.setInput("SetDay", value);	
	}
	/** 
	Set the value of the SetHour input for this Choreo. 

	@param Integer - (optional, integer) Sets the hours (0-23) of the specified date serial number.
	*/
	public void setSetHour(Integer value) {
		this.inputs.setInput("SetHour", value);
	}

	/** 
	Set the value of the SetHour input for this Choreo as a String. 

	@param String - (optional, integer) Sets the hours (0-23) of the specified date serial number.
	*/
	public void setSetHour(String value) {
		this.inputs.setInput("SetHour", value);	
	}
	/** 
	Set the value of the SetMinute input for this Choreo. 

	@param Integer - (optional, integer) Sets the minutes (0-59) of the specified date serial number.
	*/
	public void setSetMinute(Integer value) {
		this.inputs.setInput("SetMinute", value);
	}

	/** 
	Set the value of the SetMinute input for this Choreo as a String. 

	@param String - (optional, integer) Sets the minutes (0-59) of the specified date serial number.
	*/
	public void setSetMinute(String value) {
		this.inputs.setInput("SetMinute", value);	
	}
	/** 
	Set the value of the SetMonth input for this Choreo. 

	@param Integer - (optional, integer) Sets the month (1-12) of the specified date serial number.
	*/
	public void setSetMonth(Integer value) {
		this.inputs.setInput("SetMonth", value);
	}

	/** 
	Set the value of the SetMonth input for this Choreo as a String. 

	@param String - (optional, integer) Sets the month (1-12) of the specified date serial number.
	*/
	public void setSetMonth(String value) {
		this.inputs.setInput("SetMonth", value);	
	}
	/** 
	Set the value of the SetSecond input for this Choreo. 

	@param Integer - (optional, integer) Sets the seconds (0-59) of the specified date serial number.
	*/
	public void setSetSecond(Integer value) {
		this.inputs.setInput("SetSecond", value);
	}

	/** 
	Set the value of the SetSecond input for this Choreo as a String. 

	@param String - (optional, integer) Sets the seconds (0-59) of the specified date serial number.
	*/
	public void setSetSecond(String value) {
		this.inputs.setInput("SetSecond", value);	
	}
	/** 
	Set the value of the SetYear input for this Choreo. 

	@param Integer - (optional, integer) Sets the year (such as 1989) of the specified date serial number.
	*/
	public void setSetYear(Integer value) {
		this.inputs.setInput("SetYear", value);
	}

	/** 
	Set the value of the SetYear input for this Choreo as a String. 

	@param String - (optional, integer) Sets the year (such as 1989) of the specified date serial number.
	*/
	public void setSetYear(String value) {
		this.inputs.setInput("SetYear", value);	
	}
	/** 
	Set the value of the TimeZone input for this Choreo. 

	@param String - (optional, string) The timezone to use for the date formatting function. Defaults to UTC.
	*/
	public void setTimeZone(String value) {
		this.inputs.setInput("TimeZone", value);
	}


	/** 
	Set the value of the Timestamp input for this Choreo. 

	@param String - (conditional, date) A number representing the desired formatted date and time, expressed as the number of milliseconds since January 1, 1970 (epoch time). If not provided, this defaults to NOW().
	*/
	public void setTimestamp(String value) {
		this.inputs.setInput("Timestamp", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetDateResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetDateResultSet(result);
	}
	
}
