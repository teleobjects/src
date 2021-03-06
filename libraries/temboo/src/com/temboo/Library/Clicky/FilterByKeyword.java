package com.temboo.Library.Clicky;

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
FilterByKeyword

Retrieves analytics, filtering down to only the results you specify in a keyword filter.
*/
public class FilterByKeyword extends Choreography {

	/**
	Create a new instance of the FilterByKeyword Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FilterByKeyword(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Clicky/FilterByKeyword"));
	}

	/** 
	Set the value of the Filter input for this Choreo. 

	@param String - (required, string) You can use this parameter to filter down to only the results you want.
	*/
	public void setFilter(String value) {
		this.inputs.setInput("Filter", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of results that will be returned. Defaults to 10.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of results that will be returned. Defaults to 10.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Output input for this Choreo. 

	@param String - (optional, string) What format you want the returned data to be in. Accepted values: xml, php, json, csv. Defaults to 'xml'.
	*/
	public void setOutput(String value) {
		this.inputs.setInput("Output", value);
	}


	/** 
	Set the value of the SiteID input for this Choreo. 

	@param Integer - (required, integer) Your request must include the site's ID that you want to access data from. Available from your site preferences page.
	*/
	public void setSiteID(Integer value) {
		this.inputs.setInput("SiteID", value);
	}

	/** 
	Set the value of the SiteID input for this Choreo as a String. 

	@param String - (required, integer) Your request must include the site's ID that you want to access data from. Available from your site preferences page.
	*/
	public void setSiteID(String value) {
		this.inputs.setInput("SiteID", value);	
	}
	/** 
	Set the value of the SiteKey input for this Choreo. 

	@param String - (required, string) The unique key assigned to you when you first register with Clicky. Available from your site preferences page.
	*/
	public void setSiteKey(String value) {
		this.inputs.setInput("SiteKey", value);
	}


	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (required, string) The type of data you want to retrieve. Can be a comma-separated list of types (i.e. visitors,countries,searches).
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FilterByKeywordResultSet run() {
		JSONObject result = super.runWithResults();
		return new FilterByKeywordResultSet(result);
	}
	
}
