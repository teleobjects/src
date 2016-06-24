package com.temboo.Library.Bitly.LinkMetrics;

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
GetCountryMetricsForLink

Returns metrics about the countries referring click traffic to a single Bitly link.
*/
public class GetCountryMetricsForLink extends Choreography {

	/**
	Create a new instance of the GetCountryMetricsForLink Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetCountryMetricsForLink(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Bitly/LinkMetrics/GetCountryMetricsForLink"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The OAuth access token provided by Bitly.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The result limit. Defaults to 100. Range is 1 to 1000.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The result limit. Defaults to 100. Range is 1 to 1000.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Link input for this Choreo. 

	@param String - (required, string) A Bitly link.
	*/
	public void setLink(String value) {
		this.inputs.setInput("Link", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that you want the response to be in. Accepted values are "json" or "xml". Defaults to "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Rollup input for this Choreo. 

	@param Boolean - (optional, boolean) Accepted values are true or false. When set to true, this returns data for multiple units rolled up to a single result instead of a separate value for each period of time.
	*/
	public void setRollup(Boolean value) {
		this.inputs.setInput("Rollup", value);
	}

	/** 
	Set the value of the Rollup input for this Choreo as a String. 

	@param String - (optional, boolean) Accepted values are true or false. When set to true, this returns data for multiple units rolled up to a single result instead of a separate value for each period of time.
	*/
	public void setRollup(String value) {
		this.inputs.setInput("Rollup", value);	
	}
	/** 
	Set the value of the Timestamp input for this Choreo. 

	@param String - (optional, date) An epoch timestamp, indicating the most recent time for which to pull metrics.
	*/
	public void setTimestamp(String value) {
		this.inputs.setInput("Timestamp", value);
	}


	/** 
	Set the value of the Timezone input for this Choreo. 

	@param String - (optional, string) An integer hour offset from UTC (-12..12), or a timezone string. Defaults to "America/New_York".
	*/
	public void setTimezone(String value) {
		this.inputs.setInput("Timezone", value);
	}


	/** 
	Set the value of the UnitName input for this Choreo. 

	@param String - (optional, string) The unit of time that corresponds to query you want to run. Accepted values are: minute, hour, day, week, month, and day. Defaults to "day".
	*/
	public void setUnitName(String value) {
		this.inputs.setInput("UnitName", value);
	}


	/** 
	Set the value of the UnitValue input for this Choreo. 

	@param Integer - (optional, integer) An integer representing the amount of time to query for. Corresponds to the UnitName input. Defaults to -1 indicating to return all units of time.
	*/
	public void setUnitValue(Integer value) {
		this.inputs.setInput("UnitValue", value);
	}

	/** 
	Set the value of the UnitValue input for this Choreo as a String. 

	@param String - (optional, integer) An integer representing the amount of time to query for. Corresponds to the UnitName input. Defaults to -1 indicating to return all units of time.
	*/
	public void setUnitValue(String value) {
		this.inputs.setInput("UnitValue", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetCountryMetricsForLinkResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetCountryMetricsForLinkResultSet(result);
	}
	
}
