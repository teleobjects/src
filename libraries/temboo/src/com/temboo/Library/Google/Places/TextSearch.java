package com.temboo.Library.Google.Places;

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
TextSearch

Search for places based on a text query and optional location.
*/
public class TextSearch extends Choreography {

	/**
	Create a new instance of the TextSearch Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public TextSearch(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Places/TextSearch"));
	}

	/** 
	Set the value of the Key input for this Choreo. 

	@param String - (required, string) The API Key provided by Google.
	*/
	public void setKey(String value) {
		this.inputs.setInput("Key", value);
	}


	/** 
	Set the value of the Language input for this Choreo. 

	@param String - (optional, string) The language code, indicating in which language the results should be returned, if possible. See Choreo notes for a list of supported languages and their codes.
	*/
	public void setLanguage(String value) {
		this.inputs.setInput("Language", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param String - (optional, string) Specify a latitude point around which Places results will be retrieved (e.g., 38.898717). When specifying a latitude, both longitude and radius must also be supplied.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);
	}


	/** 
	Set the value of the Longitude input for this Choreo. 

	@param String - (optional, string) Specify a longitude point around which Places results will be retrieved (e.g., -77.035974). When specifying a longitude, both latitude and radius must also be supplied.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);
	}


	/** 
	Set the value of the MaxPrice input for this Choreo. 

	@param Integer - (optional, integer) Restricts results to only those places within the specified range. Valid values range between 0 (most affordable) to 4 (most expensive), inclusive. The exact amount will vary from region to region.
	*/
	public void setMaxPrice(Integer value) {
		this.inputs.setInput("MaxPrice", value);
	}

	/** 
	Set the value of the MaxPrice input for this Choreo as a String. 

	@param String - (optional, integer) Restricts results to only those places within the specified range. Valid values range between 0 (most affordable) to 4 (most expensive), inclusive. The exact amount will vary from region to region.
	*/
	public void setMaxPrice(String value) {
		this.inputs.setInput("MaxPrice", value);	
	}
	/** 
	Set the value of the MinPrice input for this Choreo. 

	@param Integer - (optional, integer) Restricts results to only those places within the specified range. Valid values range between 0 (most affordable) to 4 (most expensive), inclusive. The exact amount will vary from region to region.
	*/
	public void setMinPrice(Integer value) {
		this.inputs.setInput("MinPrice", value);
	}

	/** 
	Set the value of the MinPrice input for this Choreo as a String. 

	@param String - (optional, integer) Restricts results to only those places within the specified range. Valid values range between 0 (most affordable) to 4 (most expensive), inclusive. The exact amount will vary from region to region.
	*/
	public void setMinPrice(String value) {
		this.inputs.setInput("MinPrice", value);	
	}
	/** 
	Set the value of the OpenNow input for this Choreo. 

	@param Boolean - (optional, boolean) Returns only those Places that are open for business at the time the query is sent. Places that do not specify opening hours in the Google Places database will not be returned.
	*/
	public void setOpenNow(Boolean value) {
		this.inputs.setInput("OpenNow", value);
	}

	/** 
	Set the value of the OpenNow input for this Choreo as a String. 

	@param String - (optional, boolean) Returns only those Places that are open for business at the time the query is sent. Places that do not specify opening hours in the Google Places database will not be returned.
	*/
	public void setOpenNow(String value) {
		this.inputs.setInput("OpenNow", value);	
	}
	/** 
	Set the value of the PageToken input for this Choreo. 

	@param String - (optional, string) The "NextPageToken" returned in the choreo output from a previous run. Used to page through large result sets. When the PageToken is specified, all other inputs are ignored.
	*/
	public void setPageToken(String value) {
		this.inputs.setInput("PageToken", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (required, string) The text string on which to search, for example: "restaurant". The Place service will return candidate matches based on this string and order the results based on their perceived relevance.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the Radius input for this Choreo. 

	@param Integer - (optional, integer) Specify the radius in meters for which Places results will be returned. Maximum radius is limited to 50,000 meters. When specifying a radius, both latitude and longitude must also be supplied.
	*/
	public void setRadius(Integer value) {
		this.inputs.setInput("Radius", value);
	}

	/** 
	Set the value of the Radius input for this Choreo as a String. 

	@param String - (optional, integer) Specify the radius in meters for which Places results will be returned. Maximum radius is limited to 50,000 meters. When specifying a radius, both latitude and longitude must also be supplied.
	*/
	public void setRadius(String value) {
		this.inputs.setInput("Radius", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Sensor input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates whether or not the directions request is from a device with a location sensor. Value must be either 1 or 0. Defaults to 0 (false).
	*/
	public void setSensor(Boolean value) {
		this.inputs.setInput("Sensor", value);
	}

	/** 
	Set the value of the Sensor input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates whether or not the directions request is from a device with a location sensor. Value must be either 1 or 0. Defaults to 0 (false).
	*/
	public void setSensor(String value) {
		this.inputs.setInput("Sensor", value);	
	}
	/** 
	Set the value of the Types input for this Choreo. 

	@param String - (optional, string) Filter results by types, such as: bar, dentist.  Multiple types must be separated by the pipe ("|") symbol: bar|dentist|airport.
	*/
	public void setTypes(String value) {
		this.inputs.setInput("Types", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public TextSearchResultSet run() {
		JSONObject result = super.runWithResults();
		return new TextSearchResultSet(result);
	}
	
}
