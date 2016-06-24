package com.temboo.Library.NYTimes.TimesNewswire;

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
GetRecentNewsItems

Retrieves recent news items.
*/
public class GetRecentNewsItems extends Choreography {

	/**
	Create a new instance of the GetRecentNewsItems Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetRecentNewsItems(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NYTimes/TimesNewswire/GetRecentNewsItems"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by NY Times.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of results to return. Defaults to 20.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to return. Defaults to 20.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) A numeric value indicating the starting point of the result set. This can be used in combination with the Limit input to page through results.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) A numeric value indicating the starting point of the result set. This can be used in combination with the Limit input to page through results.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Section input for this Choreo. 

	@param String - (optional, string) Limits the set of items by one or more sections. Separate sections by semicolons. Defaults to "all" to get all sections. See Choreo documentation for more options for this input.
	*/
	public void setSection(String value) {
		this.inputs.setInput("Section", value);
	}


	/** 
	Set the value of the Source input for this Choreo. 

	@param String - (optional, string) Limits the set of items by originating source. Set to "nyt" for New York Times items only and "iht" for International Herald Tribune items. Set to "all" for both (the default).
	*/
	public void setSource(String value) {
		this.inputs.setInput("Source", value);
	}


	/** 
	Set the value of the TimePeriod input for this Choreo. 

	@param Integer - (optional, integer) Limits the set of items by time published. Valid range is number of hours, 1–720 (in hours). Defaults to 24.
	*/
	public void setTimePeriod(Integer value) {
		this.inputs.setInput("TimePeriod", value);
	}

	/** 
	Set the value of the TimePeriod input for this Choreo as a String. 

	@param String - (optional, integer) Limits the set of items by time published. Valid range is number of hours, 1–720 (in hours). Defaults to 24.
	*/
	public void setTimePeriod(String value) {
		this.inputs.setInput("TimePeriod", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetRecentNewsItemsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetRecentNewsItemsResultSet(result);
	}
	
}
