package com.temboo.Library.NYTimes.EventListings;

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
SearchListings

Searches events by location, filters, or full text search.
*/
public class SearchListings extends Choreography {

	/**
	Create a new instance of the SearchListings Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchListings(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NYTimes/EventListings/SearchListings"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by NY Times.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the DateRange input for this Choreo. 

	@param String - (optional, date) Start date to end date in the following format: YYYY-MM-DD:YYYY-MM-DD.
	*/
	public void setDateRange(String value) {
		this.inputs.setInput("DateRange", value);
	}


	/** 
	Set the value of the Filters input for this Choreo. 

	@param String - (optional, string) Filters search results using facet names and values. See Choreo documentation for examples.
	*/
	public void setFilters(String value) {
		this.inputs.setInput("Filters", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) The latitude coordinate of the location to use in the event search. If specified, Longitude must also be provided.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (optional, decimal) The latitude coordinate of the location to use in the event search. If specified, Longitude must also be provided.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of results to return.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to return.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) The longitude coordinate of the location to use in the event search. If specified, Latitude must also be provided.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (optional, decimal) The longitude coordinate of the location to use in the event search. If specified, Latitude must also be provided.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
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
	Set the value of the Query input for this Choreo. 

	@param String - (optional, string) Search keywords to perform a text search on the following fields: web_description, event_name and venue_name.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the Radius input for this Choreo. 

	@param Integer - (optional, integer) The radius of the spacial search (in meters). Defaults to 1000.
	*/
	public void setRadius(Integer value) {
		this.inputs.setInput("Radius", value);
	}

	/** 
	Set the value of the Radius input for this Choreo as a String. 

	@param String - (optional, integer) The radius of the spacial search (in meters). Defaults to 1000.
	*/
	public void setRadius(String value) {
		this.inputs.setInput("Radius", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Sort input for this Choreo. 

	@param String - (optional, string) Allows you to sort results. Appending "+asc" or "+desc" to a facet will sort results on that value in ascending or descending order (i.e. dist+asc).
	*/
	public void setSort(String value) {
		this.inputs.setInput("Sort", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchListingsResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchListingsResultSet(result);
	}
	
}
