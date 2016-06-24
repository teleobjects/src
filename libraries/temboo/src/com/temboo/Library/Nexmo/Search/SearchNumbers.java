package com.temboo.Library.Nexmo.Search;

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
SearchNumbers

Get available inbound numbers for a given country.
*/
public class SearchNumbers extends Choreography {

	/**
	Create a new instance of the SearchNumbers Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchNumbers(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Nexmo/Search/SearchNumbers"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) Your API Key provided to you by Nexmo.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APISecret input for this Choreo. 

	@param String - (required, string) Your API Secret provided to you by Nexmo.
	*/
	public void setAPISecret(String value) {
		this.inputs.setInput("APISecret", value);
	}


	/** 
	Set the value of the Country input for this Choreo. 

	@param String - (required, string) 2-digit country code. (e.g. CA)
	*/
	public void setCountry(String value) {
		this.inputs.setInput("Country", value);
	}


	/** 
	Set the value of the Index input for this Choreo. 

	@param Integer - (optional, integer) Page index
	*/
	public void setIndex(Integer value) {
		this.inputs.setInput("Index", value);
	}

	/** 
	Set the value of the Index input for this Choreo as a String. 

	@param String - (optional, integer) Page index
	*/
	public void setIndex(String value) {
		this.inputs.setInput("Index", value);	
	}
	/** 
	Set the value of the Pattern input for this Choreo. 

	@param String - (optional, string) Pattern to match.
	*/
	public void setPattern(String value) {
		this.inputs.setInput("Pattern", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "json" (the default) and "xml".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Size input for this Choreo. 

	@param Integer - (optional, integer) Page size.
	*/
	public void setSize(Integer value) {
		this.inputs.setInput("Size", value);
	}

	/** 
	Set the value of the Size input for this Choreo as a String. 

	@param String - (optional, integer) Page size.
	*/
	public void setSize(String value) {
		this.inputs.setInput("Size", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchNumbersResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchNumbersResultSet(result);
	}
	
}
