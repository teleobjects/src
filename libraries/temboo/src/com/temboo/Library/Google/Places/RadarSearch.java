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
RadarSearch

Search up to 200 places at once.   RadarSearch helps identify specific areas of interest within a geographic area.
*/
public class RadarSearch extends Choreography {

	/**
	Create a new instance of the RadarSearch Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RadarSearch(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Places/RadarSearch"));
	}

	/** 
	Set the value of the Key input for this Choreo. 

	@param String - (required, string) The API Key provided by Google.
	*/
	public void setKey(String value) {
		this.inputs.setInput("Key", value);
	}


	/** 
	Set the value of the Keyword input for this Choreo. 

	@param String - (conditional, string) Enter a keyword (term, address, type, customer review, etc.) to be matched against all results retrieved for this Place.  At least one of Keyword, Name or Types must be specified.
	*/
	public void setKeyword(String value) {
		this.inputs.setInput("Keyword", value);
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

	@param String - (required, string) Specify a latitude point around which Places results will be retrieved (e.g., 38.898717).
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);
	}


	/** 
	Set the value of the Longitude input for this Choreo. 

	@param String - (required, string) Specify a longitude point around which Places results will be retrieved (e.g., -77.035974).
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
	Set the value of the Name input for this Choreo. 

	@param String - (conditional, string) Enter a name to be matched when results are retrieved for this specified Place.  At least one of Keyword, Name or Types must be specified.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
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
	Set the value of the Radius input for this Choreo. 

	@param Integer - (required, integer) Specify the radius in meters for which Places results will be returned. Maximum radius is limited to 50,000 meters.
	*/
	public void setRadius(Integer value) {
		this.inputs.setInput("Radius", value);
	}

	/** 
	Set the value of the Radius input for this Choreo as a String. 

	@param String - (required, integer) Specify the radius in meters for which Places results will be returned. Maximum radius is limited to 50,000 meters.
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

	@param String - (conditional, string) Filter results by types, such as: bar, dentist.  Multiple types must be separated by the pipe ("|") symbol: bar|dentist|airport.   At least one of Keyword, Name or Types must be specified.
	*/
	public void setTypes(String value) {
		this.inputs.setInput("Types", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RadarSearchResultSet run() {
		JSONObject result = super.runWithResults();
		return new RadarSearchResultSet(result);
	}
	
}
