package com.temboo.Library.Mixpanel.DataExport.Properties;

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
PropertyData

Gets unique, total, or average data for of a single event and property over the last N days, weeks, or months.
*/
public class PropertyData extends Choreography {

	/**
	Create a new instance of the PropertyData Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PropertyData(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Mixpanel/DataExport/Properties/PropertyData"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided my Mixpanel. You can find your Mixpanel API Key in the project settings dialog in the Mixpanel app.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APISecret input for this Choreo. 

	@param String - (required, string) The API Secret provided by Mixpanel. You can find your Mixpanel API Secret in the project settings dialog in the Mixpanel app.
	*/
	public void setAPISecret(String value) {
		this.inputs.setInput("APISecret", value);
	}


	/** 
	Set the value of the EventName input for this Choreo. 

	@param String - (required, string) The name of the event that you wish to get data for.
	*/
	public void setEventName(String value) {
		this.inputs.setInput("EventName", value);
	}


	/** 
	Set the value of the Expire input for this Choreo. 

	@param Integer - (optional, integer) The amount of minutes past NOW() before the request will expire. Defaults to 1.
	*/
	public void setExpire(Integer value) {
		this.inputs.setInput("Expire", value);
	}

	/** 
	Set the value of the Expire input for this Choreo as a String. 

	@param String - (optional, integer) The amount of minutes past NOW() before the request will expire. Defaults to 1.
	*/
	public void setExpire(String value) {
		this.inputs.setInput("Expire", value);	
	}
	/** 
	Set the value of the Interval input for this Choreo. 

	@param Integer - (required, integer) The time interval to return. This relates to the value provided for Unit.
	*/
	public void setInterval(Integer value) {
		this.inputs.setInput("Interval", value);
	}

	/** 
	Set the value of the Interval input for this Choreo as a String. 

	@param String - (required, integer) The time interval to return. This relates to the value provided for Unit.
	*/
	public void setInterval(String value) {
		this.inputs.setInput("Interval", value);	
	}
	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of values to return. Defaults to 255.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of values to return. Defaults to 255.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the PropertyName input for this Choreo. 

	@param String - (required, string) The name of the property you would like to get data for.
	*/
	public void setPropertyName(String value) {
		this.inputs.setInput("PropertyName", value);
	}


	/** 
	Set the value of the PropertyValues input for this Choreo. 

	@param String - (optional, json) A JSON array containing property values that you wish to retrieve.
	*/
	public void setPropertyValues(String value) {
		this.inputs.setInput("PropertyValues", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and csv.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (required, string) The analysis type you would like to get data for. Valid values are: general, unique, or average
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
	}


	/** 
	Set the value of the Unit input for this Choreo. 

	@param String - (required, string) The granularity of the data to return. Valid values are: minute, hour, day, week, or month.
	*/
	public void setUnit(String value) {
		this.inputs.setInput("Unit", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PropertyDataResultSet run() {
		JSONObject result = super.runWithResults();
		return new PropertyDataResultSet(result);
	}
	
}
