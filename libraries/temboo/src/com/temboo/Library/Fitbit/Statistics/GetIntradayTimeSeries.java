package com.temboo.Library.Fitbit.Statistics;

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
GetIntradayTimeSeries

Returns the intraday time series for a given resource based on a date range you specify.
*/
public class GetIntradayTimeSeries extends Choreography {

	/**
	Create a new instance of the GetIntradayTimeSeries Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetIntradayTimeSeries(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Fitbit/Statistics/GetIntradayTimeSeries"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the DetailLevel input for this Choreo. 

	@param String - (conditional, string) Number of data points to include. for heart rate data, this must be either 1sec or 1min. For other activities, it can be 1min or 15min.
	*/
	public void setDetailLevel(String value) {
		this.inputs.setInput("DetailLevel", value);
	}


	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (required, date) The end date of the date range for the data you want to retrieve (in the format yyyy-MM-dd). You can also specify the value '1d'.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the EndTime input for this Choreo. 

	@param String - (optional, date) The end of the period, in the format HH:mm.
	*/
	public void setEndTime(String value) {
		this.inputs.setInput("EndTime", value);
	}


	/** 
	Set the value of the ResourcePath input for this Choreo. 

	@param String - (required, string) The resource path that you want to access (for example: activities/heart). See Choreo documentation for a full list of resource paths.
	*/
	public void setResourcePath(String value) {
		this.inputs.setInput("ResourcePath", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that you want the response to be in: xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (required, date) The start date of the date range for the data you want to retrieve (in the format yyyy-MM-dd). You can also specify the value 'today'.
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	/** 
	Set the value of the StartTime input for this Choreo. 

	@param String - (optional, date) The start of the period, in the format HH:mm.
	*/
	public void setStartTime(String value) {
		this.inputs.setInput("StartTime", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The user's encoded id. Defaults to "-" (dash) which will return data for the user associated with the token credentials provided.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetIntradayTimeSeriesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetIntradayTimeSeriesResultSet(result);
	}
	
}
