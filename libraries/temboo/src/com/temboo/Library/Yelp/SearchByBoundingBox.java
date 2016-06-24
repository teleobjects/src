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
SearchByBoundingBox

Retrieve businesses in a geographic bounding box.
*/
public class SearchByBoundingBox extends Choreography {

	/**
	Create a new instance of the SearchByBoundingBox Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchByBoundingBox(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Yelp/SearchByBoundingBox"));
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
	Set the value of the NortheastLatitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The northeastern latitude of the bounding box to search, such as "37.788022".
	*/
	public void setNortheastLatitude(BigDecimal value) {
		this.inputs.setInput("NortheastLatitude", value);
	}

	/** 
	Set the value of the NortheastLatitude input for this Choreo as a String. 

	@param String - (required, decimal) The northeastern latitude of the bounding box to search, such as "37.788022".
	*/
	public void setNortheastLatitude(String value) {
		this.inputs.setInput("NortheastLatitude", value);	
	}
	/** 
	Set the value of the NortheastLongitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The northeastern longitude of the bounding box to search, such as "-122.399797".
	*/
	public void setNortheastLongitude(BigDecimal value) {
		this.inputs.setInput("NortheastLongitude", value);
	}

	/** 
	Set the value of the NortheastLongitude input for this Choreo as a String. 

	@param String - (required, decimal) The northeastern longitude of the bounding box to search, such as "-122.399797".
	*/
	public void setNortheastLongitude(String value) {
		this.inputs.setInput("NortheastLongitude", value);	
	}
	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) Offsets the list of returned business results by this amount.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) Offsets the list of returned business results by this amount.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
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
	Set the value of the SouthwestLatitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The southwestern latitude of the bounding box to search, such as "37.900000".
	*/
	public void setSouthwestLatitude(BigDecimal value) {
		this.inputs.setInput("SouthwestLatitude", value);
	}

	/** 
	Set the value of the SouthwestLatitude input for this Choreo as a String. 

	@param String - (required, decimal) The southwestern latitude of the bounding box to search, such as "37.900000".
	*/
	public void setSouthwestLatitude(String value) {
		this.inputs.setInput("SouthwestLatitude", value);	
	}
	/** 
	Set the value of the SouthwestLongitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The southwestern longitude of the bounding box to search, such as "-122.500000".
	*/
	public void setSouthwestLongitude(BigDecimal value) {
		this.inputs.setInput("SouthwestLongitude", value);
	}

	/** 
	Set the value of the SouthwestLongitude input for this Choreo as a String. 

	@param String - (required, decimal) The southwestern longitude of the bounding box to search, such as "-122.500000".
	*/
	public void setSouthwestLongitude(String value) {
		this.inputs.setInput("SouthwestLongitude", value);	
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
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchByBoundingBoxResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchByBoundingBoxResultSet(result);
	}
	
}
