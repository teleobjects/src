package com.temboo.Library.NYTimes.MostPopular;

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
GetMostShared

Retrieves information for the blog posts and articles that are most frequently shared.
*/
public class GetMostShared extends Choreography {

	/**
	Create a new instance of the GetMostShared Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetMostShared(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NYTimes/MostPopular/GetMostShared"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by NY Times.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param String - (optional, string) The first 20 results are shown by default. To page through the results, set Offset to the appropriate value.
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

	@param String - (required, string) Limits the results by one or more sections (i.e. arts).  To get all sections, specify all-sections.
	*/
	public void setSection(String value) {
		this.inputs.setInput("Section", value);
	}


	/** 
	Set the value of the ShareTypes input for this Choreo. 

	@param String - (required, string) Limits the results by the method used to share the items.  Separate multiple share types by semicolons (i.e. facebook; twitter).
	*/
	public void setShareTypes(String value) {
		this.inputs.setInput("ShareTypes", value);
	}


	/** 
	Set the value of the TimePeriod input for this Choreo. 

	@param Integer - (required, integer) Allowed integer values: 1, 7, or 30, which corresponds to a day (1) , a week (7), or a month (30) of content.
	*/
	public void setTimePeriod(Integer value) {
		this.inputs.setInput("TimePeriod", value);
	}

	/** 
	Set the value of the TimePeriod input for this Choreo as a String. 

	@param String - (required, integer) Allowed integer values: 1, 7, or 30, which corresponds to a day (1) , a week (7), or a month (30) of content.
	*/
	public void setTimePeriod(String value) {
		this.inputs.setInput("TimePeriod", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetMostSharedResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetMostSharedResultSet(result);
	}
	
}
