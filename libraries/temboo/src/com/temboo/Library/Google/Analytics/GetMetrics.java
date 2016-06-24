package com.temboo.Library.Google.Analytics;

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
GetMetrics

Retrieves metrics such as visits, page views, bounces within a specified time frame.
*/
public class GetMetrics extends Choreography {

	/**
	Create a new instance of the GetMetrics Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetMetrics(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Analytics/GetMetrics"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid Access Token retrieved during the OAuth process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new Access Token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the Dimensions input for this Choreo. 

	@param String - (optional, string) Defines the primary data keys for your Analytics report. Use dimensions to segment your web property metrics (e.g.  ga:browser or ga:city).
	*/
	public void setDimensions(String value) {
		this.inputs.setInput("Dimensions", value);
	}


	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (required, date) The end date for the range of data you want to retrieve. Epoch timestamp in milliseconds or formatted as yyyy-MM-dd.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the Filters input for this Choreo. 

	@param String - (optional, string) Restricts the data returned by a dimension or metric you want to filter by using an expression (i.e. ga:timeOnPage==10).
	*/
	public void setFilters(String value) {
		this.inputs.setInput("Filters", value);
	}


	/** 
	Set the value of the MaxResults input for this Choreo. 

	@param Integer - (optional, integer) The max results to be returned in the feed. Defaults to 50.
	*/
	public void setMaxResults(Integer value) {
		this.inputs.setInput("MaxResults", value);
	}

	/** 
	Set the value of the MaxResults input for this Choreo as a String. 

	@param String - (optional, integer) The max results to be returned in the feed. Defaults to 50.
	*/
	public void setMaxResults(String value) {
		this.inputs.setInput("MaxResults", value);	
	}
	/** 
	Set the value of the Metrics input for this Choreo. 

	@param String - (optional, string) This is a comma separated list of metrics you want to retrieve. Defaults to: ga:visits,ga:bounces,ga:pageviews.
	*/
	public void setMetrics(String value) {
		this.inputs.setInput("Metrics", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) Deprecated (retained for backward compatibility only).
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the ProfileId input for this Choreo. 

	@param Integer - (required, integer) The Google Analytics Profile ID to access. This is also known as the View ID. It can be found in the Admin > View Settings section of a particular profile.
	*/
	public void setProfileId(Integer value) {
		this.inputs.setInput("ProfileId", value);
	}

	/** 
	Set the value of the ProfileId input for this Choreo as a String. 

	@param String - (required, integer) The Google Analytics Profile ID to access. This is also known as the View ID. It can be found in the Admin > View Settings section of a particular profile.
	*/
	public void setProfileId(String value) {
		this.inputs.setInput("ProfileId", value);	
	}
	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth Refresh Token used to generate a new Access Token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: XML (the default) and JSON.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Segment input for this Choreo. 

	@param String - (optional, string) Used to segment your data by dimensions and/or metrics. You can use expressions for segments just as you would for the Filters parameter.
	*/
	public void setSegment(String value) {
		this.inputs.setInput("Segment", value);
	}


	/** 
	Set the value of the Sort input for this Choreo. 

	@param String - (optional, string) Indicates the sorting order and direction for the returned data. Values can be separated by commas (i.e. ga:browser,ga:pageviews).
	*/
	public void setSort(String value) {
		this.inputs.setInput("Sort", value);
	}


	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (required, date) The start date for the range of data to retrieve. Use epoch timestamp in milliseconds or formatted as yyyy-MM-dd.
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	/** 
	Set the value of the StartIndex input for this Choreo. 

	@param Integer - (optional, integer) The starting entry for the feed. Defaults to 1.
	*/
	public void setStartIndex(Integer value) {
		this.inputs.setInput("StartIndex", value);
	}

	/** 
	Set the value of the StartIndex input for this Choreo as a String. 

	@param String - (optional, integer) The starting entry for the feed. Defaults to 1.
	*/
	public void setStartIndex(String value) {
		this.inputs.setInput("StartIndex", value);	
	}
	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetMetricsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetMetricsResultSet(result);
	}
	
}
