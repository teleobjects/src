package com.temboo.Library.Foursquare.Specials;

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
SearchSpecials

Returns a list of specials near the current location.
*/
public class SearchSpecials extends Choreography {

	/**
	Create a new instance of the SearchSpecials Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchSpecials(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Specials/SearchSpecials"));
	}

	/** 
	Set the value of the AccuracyOfCoordinates input for this Choreo. 

	@param Integer - (optional, integer) Accuracy of latitude and longitude, in meters.
	*/
	public void setAccuracyOfCoordinates(Integer value) {
		this.inputs.setInput("AccuracyOfCoordinates", value);
	}

	/** 
	Set the value of the AccuracyOfCoordinates input for this Choreo as a String. 

	@param String - (optional, integer) Accuracy of latitude and longitude, in meters.
	*/
	public void setAccuracyOfCoordinates(String value) {
		this.inputs.setInput("AccuracyOfCoordinates", value);	
	}
	/** 
	Set the value of the Altitude input for this Choreo. 

	@param Integer - (optional, integer) Altitude of the user's location, in meters.
	*/
	public void setAltitude(Integer value) {
		this.inputs.setInput("Altitude", value);
	}

	/** 
	Set the value of the Altitude input for this Choreo as a String. 

	@param String - (optional, integer) Altitude of the user's location, in meters.
	*/
	public void setAltitude(String value) {
		this.inputs.setInput("Altitude", value);	
	}
	/** 
	Set the value of the AltitudeAccuracy input for this Choreo. 

	@param Integer - (optional, integer) Accuracy of the user's altitude, in meters.
	*/
	public void setAltitudeAccuracy(Integer value) {
		this.inputs.setInput("AltitudeAccuracy", value);
	}

	/** 
	Set the value of the AltitudeAccuracy input for this Choreo as a String. 

	@param String - (optional, integer) Accuracy of the user's altitude, in meters.
	*/
	public void setAltitudeAccuracy(String value) {
		this.inputs.setInput("AltitudeAccuracy", value);	
	}
	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) Your Foursquare client ID, obtained after registering at Foursquare. Required unless using the OauthToken input.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) Your Foursquare client secret, obtained after registering at Foursquare. Required unless using the OauthToken input.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (conditional, decimal) The latitude point of the user's location.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (conditional, decimal) The latitude point of the user's location.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Number of results to retun, up to 50.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Number of results to retun, up to 50.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (conditional, decimal) The longitude point of the user's location.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (conditional, decimal) The longitude point of the user's location.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the OauthToken input for this Choreo. 

	@param String - (conditional, string) The Foursquare API Oauth token string. Required unless specifying the ClientID and ClientSecret.
	*/
	public void setOauthToken(String value) {
		this.inputs.setInput("OauthToken", value);
	}


	/** 
	Set the value of the Radius input for this Choreo. 

	@param Integer - (optional, integer) Limit results to venues within this many meters of the specified location. Defaults to a city-wide area.
	*/
	public void setRadius(Integer value) {
		this.inputs.setInput("Radius", value);
	}

	/** 
	Set the value of the Radius input for this Choreo as a String. 

	@param String - (optional, integer) Limit results to venues within this many meters of the specified location. Defaults to a city-wide area.
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
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchSpecialsResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchSpecialsResultSet(result);
	}
	
}
