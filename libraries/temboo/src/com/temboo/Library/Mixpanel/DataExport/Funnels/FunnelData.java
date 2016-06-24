package com.temboo.Library.Mixpanel.DataExport.Funnels;

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
FunnelData

Gets data for a specified funnel.
*/
public class FunnelData extends Choreography {

	/**
	Create a new instance of the FunnelData Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FunnelData(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Mixpanel/DataExport/Funnels/FunnelData"));
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

	@param String - (optional, date) The first date in yyyy-mm-dd format from which a user can begin the first step in the funnel. This date is inclusive.
	*/
	public void setFromDate(String value) {
		this.inputs.setInput("FromDate", value);
	}


	/** 
	Set the value of the FunnelID input for this Choreo. 

	@param String - (required, string) The ID of the funnel to get data for.
	*/
	public void setFunnelID(String value) {
		this.inputs.setInput("FunnelID", value);
	}


	/** 
	Set the value of the Interval input for this Choreo. 

	@param Integer - (optional, integer) The number of days you want your results bucketed into.The default value is 1.
	*/
	public void setInterval(Integer value) {
		this.inputs.setInput("Interval", value);
	}

	/** 
	Set the value of the Interval input for this Choreo as a String. 

	@param String - (optional, integer) The number of days you want your results bucketed into.The default value is 1.
	*/
	public void setInterval(String value) {
		this.inputs.setInput("Interval", value);	
	}
	/** 
	Set the value of the Length input for this Choreo. 

	@param Integer - (optional, integer) The number of days each user has to complete the funnel, starting from the time they triggered the first step in the funnel. May not be greater than 60 days. Defaults to 14.
	*/
	public void setLength(Integer value) {
		this.inputs.setInput("Length", value);
	}

	/** 
	Set the value of the Length input for this Choreo as a String. 

	@param String - (optional, integer) The number of days each user has to complete the funnel, starting from the time they triggered the first step in the funnel. May not be greater than 60 days. Defaults to 14.
	*/
	public void setLength(String value) {
		this.inputs.setInput("Length", value);	
	}
	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Return the top limit property values. This parameter is ignored if the On input is not specified.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Return the top limit property values. This parameter is ignored if the On input is not specified.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the On input for this Choreo. 

	@param String - (optional, string) The property expression to segment the event on (e.g., properties["Referred By"] == "Friend"). See Choreo description for examples.
	*/
	public void setOn(String value) {
		this.inputs.setInput("On", value);
	}


	/** 
	Set the value of the ToDate input for this Choreo. 

	@param String - (optional, date) The last date in yyyy-mm-dd format from which a user can begin the first step in the funnel. This date is inclusive. The date range may not be more than 60 days.
	*/
	public void setToDate(String value) {
		this.inputs.setInput("ToDate", value);
	}


	/** 
	Set the value of the Unit input for this Choreo. 

	@param String - (optional, string) This is an alternate way of specifying interval and can set to be 'day' or 'week'.
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
	public FunnelDataResultSet run() {
		JSONObject result = super.runWithResults();
		return new FunnelDataResultSet(result);
	}
	
}
