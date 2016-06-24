package com.temboo.Library.Mixpanel.DataExport.Segmentation;

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
Sum

Sums an expression for events per unit time.
*/
public class Sum extends Choreography {

	/**
	Create a new instance of the Sum Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Sum(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Mixpanel/DataExport/Segmentation/Sum"));
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

	@param String - (required, string) The event that you wish to segment on.
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
	Set the value of the FromDate input for this Choreo. 

	@param String - (required, date) The date in yyyy-mm-dd format from which to begin querying for the event from. This date is inclusive.
	*/
	public void setFromDate(String value) {
		this.inputs.setInput("FromDate", value);
	}


	/** 
	Set the value of the On input for this Choreo. 

	@param String - (required, string) The expression to sum per unit time. Must be a numeric expression (e.g., number(properties["time"]). See Choreo description for examples.
	*/
	public void setOn(String value) {
		this.inputs.setInput("On", value);
	}


	/** 
	Set the value of the ToDate input for this Choreo. 

	@param String - (required, date) The date in yyyy-mm-dd format from which to stop querying for the event from. This date is inclusive. The date range may not be more than 30 days.
	*/
	public void setToDate(String value) {
		this.inputs.setInput("ToDate", value);
	}


	/** 
	Set the value of the Unit input for this Choreo. 

	@param String - (optional, string) Determines the buckets into which the property values that you segment on are placed. Valid values are: hour or day.
	*/
	public void setUnit(String value) {
		this.inputs.setInput("Unit", value);
	}


	/** 
	Set the value of the Where input for this Choreo. 

	@param String - (optional, string) An expression to filter events by  (e.g., number(properties["time"]) >= 2000). See Choreo description for examples.
	*/
	public void setWhere(String value) {
		this.inputs.setInput("Where", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SumResultSet run() {
		JSONObject result = super.runWithResults();
		return new SumResultSet(result);
	}
	
}
