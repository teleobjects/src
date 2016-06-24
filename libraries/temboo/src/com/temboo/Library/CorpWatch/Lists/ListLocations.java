package com.temboo.Library.CorpWatch.Lists;

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
ListLocations

Returns a list of locations of companies matching the given query.
*/
public class ListLocations extends Choreography {

	/**
	Create a new instance of the ListLocations Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListLocations(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/CorpWatch/Lists/ListLocations"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (optional, string) The APIKey from CorpWatch if you have one.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Address input for this Choreo. 

	@param String - (optional, string) Enter an address fragment to search for. This can be either a street address, city, or state/subregion.
	*/
	public void setAddress(String value) {
		this.inputs.setInput("Address", value);
	}


	/** 
	Set the value of the CountryCode input for this Choreo. 

	@param String - (optional, string) Enter an ISO-3166 formatted country code. 
	*/
	public void setCountryCode(String value) {
		this.inputs.setInput("CountryCode", value);
	}


	/** 
	Set the value of the Index input for this Choreo. 

	@param Integer - (optional, integer) Set the index number of the first result to be returned. The index of the first result is 0.
	*/
	public void setIndex(Integer value) {
		this.inputs.setInput("Index", value);
	}

	/** 
	Set the value of the Index input for this Choreo as a String. 

	@param String - (optional, integer) Set the index number of the first result to be returned. The index of the first result is 0.
	*/
	public void setIndex(String value) {
		this.inputs.setInput("Index", value);	
	}
	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of results to be returned. Defaults to 100. Maximum is 5000.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to be returned. Defaults to 100. Maximum is 5000.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the MaxYear input for this Choreo. 

	@param Integer - (optional, integer) Indicate desired year of the most recent appearance in SEC filing data (e.g. indicating 2007 will search for companies that ceased filing in 2007).
	*/
	public void setMaxYear(Integer value) {
		this.inputs.setInput("MaxYear", value);
	}

	/** 
	Set the value of the MaxYear input for this Choreo as a String. 

	@param String - (optional, integer) Indicate desired year of the most recent appearance in SEC filing data (e.g. indicating 2007 will search for companies that ceased filing in 2007).
	*/
	public void setMaxYear(String value) {
		this.inputs.setInput("MaxYear", value);	
	}
	/** 
	Set the value of the MinYear input for this Choreo. 

	@param Integer - (optional, integer) Indicate desired year of the earliest appearance in SEC filing data (e.g. indicating 2004 will search for companies that started filing in 2004).
	*/
	public void setMinYear(Integer value) {
		this.inputs.setInput("MinYear", value);
	}

	/** 
	Set the value of the MinYear input for this Choreo as a String. 

	@param String - (optional, integer) Indicate desired year of the earliest appearance in SEC filing data (e.g. indicating 2004 will search for companies that started filing in 2004).
	*/
	public void setMinYear(String value) {
		this.inputs.setInput("MinYear", value);	
	}
	/** 
	Set the value of the PostalCode input for this Choreo. 

	@param Integer - (optional, integer) Enter a postal code to be searched.
	*/
	public void setPostalCode(Integer value) {
		this.inputs.setInput("PostalCode", value);
	}

	/** 
	Set the value of the PostalCode input for this Choreo as a String. 

	@param String - (optional, integer) Enter a postal code to be searched.
	*/
	public void setPostalCode(String value) {
		this.inputs.setInput("PostalCode", value);	
	}
	/** 
	Set the value of the ResponseType input for this Choreo. 

	@param String - (optional, string) Specify json or xml for the type of response to be returned. Defaults to xml.
	*/
	public void setResponseType(String value) {
		this.inputs.setInput("ResponseType", value);
	}


	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (optional, string) Indicates the origin of the location information found. Acceptable values: relation_loc, business, mailing, state_of_incorp. See documentation for more info.
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
	}


	/** 
	Set the value of the Year input for this Choreo. 

	@param Integer - (optional, integer) If a year is specified, only records for that year will be returned and the data in the company objects returned will be set appropriately for the request year. Defaults to most recent.
	*/
	public void setYear(Integer value) {
		this.inputs.setInput("Year", value);
	}

	/** 
	Set the value of the Year input for this Choreo as a String. 

	@param String - (optional, integer) If a year is specified, only records for that year will be returned and the data in the company objects returned will be set appropriately for the request year. Defaults to most recent.
	*/
	public void setYear(String value) {
		this.inputs.setInput("Year", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListLocationsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListLocationsResultSet(result);
	}
	
}
