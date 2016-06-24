package com.temboo.Library.Instagram;

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
SearchLocations

Searches for locations by geographic coordinates. 
*/
public class SearchLocations extends Choreography {

	/**
	Create a new instance of the SearchLocations Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchLocations(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Instagram/SearchLocations"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (conditional, string) The access token retrieved during the OAuth 2.0 process. Required unless you provide the ClientID.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Instagram after registering your application. Required unless you provide the AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the Distance input for this Choreo. 

	@param Integer - (optional, integer) The distance to search. Default is 1000m (distance=1000), max distance is 5000.
	*/
	public void setDistance(Integer value) {
		this.inputs.setInput("Distance", value);
	}

	/** 
	Set the value of the Distance input for this Choreo as a String. 

	@param String - (optional, integer) The distance to search. Default is 1000m (distance=1000), max distance is 5000.
	*/
	public void setDistance(String value) {
		this.inputs.setInput("Distance", value);	
	}
	/** 
	Set the value of the FoursquareID input for this Choreo. 

	@param String - (conditional, string) Returns a location mapped off of a foursquare v2 api location id. If used, you are not required to provide values for Latitude or Longitude.
	*/
	public void setFoursquareID(String value) {
		this.inputs.setInput("FoursquareID", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (conditional, decimal) Latitude of the center search coordinate. If used, Longitude is required.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (conditional, decimal) Latitude of the center search coordinate. If used, Longitude is required.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (conditional, decimal) Longitude of the center search coordinate. If used, Latitude is required.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (conditional, decimal) Longitude of the center search coordinate. If used, Latitude is required.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchLocationsResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchLocationsResultSet(result);
	}
	
}
