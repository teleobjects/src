package com.temboo.Library.SunlightLabs.Congress.Legislator;

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
Search

Returns current committees, subcommittees, and their membership.
*/
public class Search extends Choreography {

	/**
	Create a new instance of the Search Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Search(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/SunlightLabs/Congress/Legislator/Search"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Sunlight Labs.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AllLegislators input for this Choreo. 

	@param Boolean - (optional, boolean) A boolean flag indicating to search for all legislators even when they are no longer in office.
	*/
	public void setAllLegislators(Boolean value) {
		this.inputs.setInput("AllLegislators", value);
	}

	/** 
	Set the value of the AllLegislators input for this Choreo as a String. 

	@param String - (optional, boolean) A boolean flag indicating to search for all legislators even when they are no longer in office.
	*/
	public void setAllLegislators(String value) {
		this.inputs.setInput("AllLegislators", value);	
	}
	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) A comma-separated list of fields to include in the response.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the Filters input for this Choreo. 

	@param String - (optional, string) A JSON object containing key/value pairs to be used as filters.
	*/
	public void setFilters(String value) {
		this.inputs.setInput("Filters", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (optional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the Order input for this Choreo. 

	@param String - (optional, string) Used to order the results by field name (e.g. field__asc).
	*/
	public void setOrder(String value) {
		this.inputs.setInput("Order", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page offset.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page offset.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the PerPage input for this Choreo. 

	@param Integer - (optional, integer) The number of results to return per page.
	*/
	public void setPerPage(Integer value) {
		this.inputs.setInput("PerPage", value);
	}

	/** 
	Set the value of the PerPage input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to return per page.
	*/
	public void setPerPage(String value) {
		this.inputs.setInput("PerPage", value);	
	}
	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (conditional, string) A search term.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchResultSet(result);
	}
	
}
