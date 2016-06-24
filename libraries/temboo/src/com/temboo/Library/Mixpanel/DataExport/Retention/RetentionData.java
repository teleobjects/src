package com.temboo.Library.Mixpanel.DataExport.Retention;

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
RetentionData

Gets cohort analysis.
*/
public class RetentionData extends Choreography {

	/**
	Create a new instance of the RetentionData Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetentionData(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Mixpanel/DataExport/Retention/RetentionData"));
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
	Set the value of the BornEvent input for this Choreo. 

	@param String - (conditional, string) The first event a user must do to be counted in a birth retention cohort. Required when retention_type is 'birth'.
	*/
	public void setBornEvent(String value) {
		this.inputs.setInput("BornEvent", value);
	}


	/** 
	Set the value of the BornWhere input for this Choreo. 

	@param String - (optional, string) An expression to filter born_events by. See Choreo description for examples.
	*/
	public void setBornWhere(String value) {
		this.inputs.setInput("BornWhere", value);
	}


	/** 
	Set the value of the EventName input for this Choreo. 

	@param String - (optional, string) The event to generate returning counts for.
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

	@param String - (required, date) The date in yyyy-mm-dd format from which to begin generating cohorts from. This date is inclusive.
	*/
	public void setFromDate(String value) {
		this.inputs.setInput("FromDate", value);
	}


	/** 
	Set the value of the Interval input for this Choreo. 

	@param Integer - (optional, integer) The number of days you want your results bucketed into.The default value is 1 or specified by unit.
	*/
	public void setInterval(Integer value) {
		this.inputs.setInput("Interval", value);
	}

	/** 
	Set the value of the Interval input for this Choreo as a String. 

	@param String - (optional, integer) The number of days you want your results bucketed into.The default value is 1 or specified by unit.
	*/
	public void setInterval(String value) {
		this.inputs.setInput("Interval", value);	
	}
	/** 
	Set the value of the IntervalCount input for this Choreo. 

	@param Integer - (optional, integer) The number of intervals you want. Defaults to 1.
	*/
	public void setIntervalCount(Integer value) {
		this.inputs.setInput("IntervalCount", value);
	}

	/** 
	Set the value of the IntervalCount input for this Choreo as a String. 

	@param String - (optional, integer) The number of intervals you want. Defaults to 1.
	*/
	public void setIntervalCount(String value) {
		this.inputs.setInput("IntervalCount", value);	
	}
	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Return the top limit segmentation values. This parameter is ignored if the On input is not specified.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Return the top limit segmentation values. This parameter is ignored if the On input is not specified.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the On input for this Choreo. 

	@param String - (optional, string) The property expression to segment the second event on. See Choreo description for examples.
	*/
	public void setOn(String value) {
		this.inputs.setInput("On", value);
	}


	/** 
	Set the value of the RetentionType input for this Choreo. 

	@param String - (conditional, string) The type of retention. Valid values are: birth (the default) or compounded.
	*/
	public void setRetentionType(String value) {
		this.inputs.setInput("RetentionType", value);
	}


	/** 
	Set the value of the ToDate input for this Choreo. 

	@param String - (required, date) The date in yyyy-mm-dd format from which to stop generating cohorts from. This date is inclusive.
	*/
	public void setToDate(String value) {
		this.inputs.setInput("ToDate", value);
	}


	/** 
	Set the value of the Unit input for this Choreo. 

	@param String - (optional, string) This is an alternate way of specifying interval. Valid values are: day, week, or month.
	*/
	public void setUnit(String value) {
		this.inputs.setInput("Unit", value);
	}


	/** 
	Set the value of the Where input for this Choreo. 

	@param String - (optional, string) An expression to filter events by  (e.g., properties["Signed Up"]). See Choreo description for examples.
	*/
	public void setWhere(String value) {
		this.inputs.setInput("Where", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetentionDataResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetentionDataResultSet(result);
	}
	
}
