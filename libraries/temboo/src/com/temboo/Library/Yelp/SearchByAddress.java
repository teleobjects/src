package com.temboo.Library.Yelp;

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
SearchByAddress

Retrieve businesses within a specific range of a specified address.
*/
public class SearchByAddress extends Choreography {

	/**
	Create a new instance of the SearchByAddress Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchByAddress(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Yelp/SearchByAddress"));
	}

	/** 
	Set the value of the Address input for this Choreo. 

	@param String - (required, string) The street address of the business to search for.
	*/
	public void setAddress(String value) {
		this.inputs.setInput("Address", value);
	}


	/** 
	Set the value of the BusinessType input for this Choreo. 

	@param String - (optional, string) A term to narrow the search, such as "wine" or "restaurants". Leave blank to search for all business types.
	*/
	public void setBusinessType(String value) {
		this.inputs.setInput("BusinessType", value);
	}


	/** 
	Set the value of the Category input for this Choreo. 

	@param String - (optional, string) The category to filter search results with. This can be a list of comma delimited categories. For example, "bars,french". See Choreo description for a list of categories.
	*/
	public void setCategory(String value) {
		this.inputs.setInput("Category", value);
	}


	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) The Consumer Key provided by Yelp.
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) The Consumer Secret provided by Yelp.
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the Count input for this Choreo. 

	@param Integer - (optional, integer) The number of business results to return. The maxiumum is 20.
	*/
	public void setCount(Integer value) {
		this.inputs.setInput("Count", value);
	}

	/** 
	Set the value of the Count input for this Choreo as a String. 

	@param String - (optional, integer) The number of business results to return. The maxiumum is 20.
	*/
	public void setCount(String value) {
		this.inputs.setInput("Count", value);	
	}
	/** 
	Set the value of the CountryCode input for this Choreo. 

	@param String - (optional, string) The ISO 3166-1 2-digit country code to use when parsing the location field. United States = US, Canada = CA, United Kingdom = GB.
	*/
	public void setCountryCode(String value) {
		this.inputs.setInput("CountryCode", value);
	}


	/** 
	Set the value of the Deals input for this Choreo. 

	@param Boolean - (optional, boolean) Set to "true" to exclusively search for businesses with deals.
	*/
	public void setDeals(Boolean value) {
		this.inputs.setInput("Deals", value);
	}

	/** 
	Set the value of the Deals input for this Choreo as a String. 

	@param String - (optional, boolean) Set to "true" to exclusively search for businesses with deals.
	*/
	public void setDeals(String value) {
		this.inputs.setInput("Deals", value);	
	}
	/** 
	Set the value of the LanguageCode input for this Choreo. 

	@param String - (optional, string) The ISO 639 language code. Default to "en". Reviews and snippets written in the specified language will be returned.
	*/
	public void setLanguageCode(String value) {
		this.inputs.setInput("LanguageCode", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param String - (optional, string) Offsets the list of returned business results by this amount.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);
	}


	/** 
	Set the value of the Range input for this Choreo. 

	@param Integer - (optional, integer) Narrow or expand a search by specifying a range in either feet, meters, miles, or kilometers, depending on the value of the Units input. Maximum is 25 miles (40000 meters).
	*/
	public void setRange(Integer value) {
		this.inputs.setInput("Range", value);
	}

	/** 
	Set the value of the Range input for this Choreo as a String. 

	@param String - (optional, integer) Narrow or expand a search by specifying a range in either feet, meters, miles, or kilometers, depending on the value of the Units input. Maximum is 25 miles (40000 meters).
	*/
	public void setRange(String value) {
		this.inputs.setInput("Range", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format of the response from Yelp, either XML or JSON (the default).
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Sort input for this Choreo. 

	@param Integer - (optional, integer) The sort mode: 0 = Best matched, 1 = Distance (default), 2 = Highest Rated.
	*/
	public void setSort(Integer value) {
		this.inputs.setInput("Sort", value);
	}

	/** 
	Set the value of the Sort input for this Choreo as a String. 

	@param String - (optional, integer) The sort mode: 0 = Best matched, 1 = Distance (default), 2 = Highest Rated.
	*/
	public void setSort(String value) {
		this.inputs.setInput("Sort", value);	
	}
	/** 
	Set the value of the Token input for this Choreo. 

	@param String - (required, string) The Token provided by Yelp.
	*/
	public void setToken(String value) {
		this.inputs.setInput("Token", value);
	}


	/** 
	Set the value of the TokenSecret input for this Choreo. 

	@param String - (required, string) The Token Secret provided by Yelp.
	*/
	public void setTokenSecret(String value) {
		this.inputs.setInput("TokenSecret", value);
	}


	/** 
	Set the value of the Units input for this Choreo. 

	@param String - (optional, string) Specify "feet" (the default), "meters", "miles", or "kilometers". Units apply to the Range input value.
	*/
	public void setUnits(String value) {
		this.inputs.setInput("Units", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchByAddressResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchByAddressResultSet(result);
	}
	
}
