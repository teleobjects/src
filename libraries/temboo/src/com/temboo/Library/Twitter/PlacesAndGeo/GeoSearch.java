package com.temboo.Library.Twitter.PlacesAndGeo;

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
GeoSearch

Searches for places that can be attached to a status update using a latitude and a longitude pair, an IP address, or a name.
*/
public class GeoSearch extends Choreography {

	/**
	Create a new instance of the GeoSearch Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GeoSearch(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twitter/PlacesAndGeo/GeoSearch"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) The Access Token Secret provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the Accuracy input for this Choreo. 

	@param String - (optional, string) A hint on the "region" in which to search. If a number, then this is a radius in meters. You can also specify feet by using the ft suffix (i.e. 5ft).
	*/
	public void setAccuracy(String value) {
		this.inputs.setInput("Accuracy", value);
	}


	/** 
	Set the value of the Callback input for this Choreo. 

	@param String - (optional, string) If supplied, the response will use the JSONP format with a callback of the given name.
	*/
	public void setCallback(String value) {
		this.inputs.setInput("Callback", value);
	}


	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) The API Key (or Consumer Key) provided by Twitter.
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) The API Secret (or Consumer Secret) provided by Twitter.
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the ContainedWithin input for this Choreo. 

	@param String - (optional, string) This is the place_id which you would like to restrict the search results to. This id can be retrieved with the GetPlaceInformation Choreo.
	*/
	public void setContainedWithin(String value) {
		this.inputs.setInput("ContainedWithin", value);
	}


	/** 
	Set the value of the Granularity input for this Choreo. 

	@param String - (optional, string) This is the minimal granularity of place types to return and must be one of: poi, neighborhood, city, admin or country. Defaults to neighborhood.
	*/
	public void setGranularity(String value) {
		this.inputs.setInput("Granularity", value);
	}


	/** 
	Set the value of the IP input for this Choreo. 

	@param String - (conditional, string) An IP address. Used when attempting to fix geolocation based off of the user's IP address. You must provide Latitude and Longitude, IP, or Query.
	*/
	public void setIP(String value) {
		this.inputs.setInput("IP", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (conditional, decimal) The latitude to search around. You must provide Latitude and Longitude, IP, or Query.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (conditional, decimal) The latitude to search around. You must provide Latitude and Longitude, IP, or Query.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (conditional, decimal) The longitude to search around. You must provide Latitude and Longitude, IP, or Query.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (conditional, decimal) The longitude to search around. You must provide Latitude and Longitude, IP, or Query.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the MaxResults input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of results to return.
	*/
	public void setMaxResults(Integer value) {
		this.inputs.setInput("MaxResults", value);
	}

	/** 
	Set the value of the MaxResults input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of results to return.
	*/
	public void setMaxResults(String value) {
		this.inputs.setInput("MaxResults", value);	
	}
	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (conditional, string) Free-form text to match against while executing a geo-based query. You must provide Latitude and Longitude, IP, or Query.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GeoSearchResultSet run() {
		JSONObject result = super.runWithResults();
		return new GeoSearchResultSet(result);
	}
	
}
