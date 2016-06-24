package com.temboo.Library.Google.Geocoding;

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
GeocodeByAddress

Converts a human-readable address into geographic coordinates.
*/
public class GeocodeByAddress extends Choreography {

	/**
	Create a new instance of the GeocodeByAddress Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GeocodeByAddress(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Geocoding/GeocodeByAddress"));
	}

	/** 
	Set the value of the Address input for this Choreo. 

	@param String - (required, string) The address that you want to geocode.
	*/
	public void setAddress(String value) {
		this.inputs.setInput("Address", value);
	}


	/** 
	Set the value of the Bounds input for this Choreo. 

	@param String - (optional, string) The bounding box of the viewport within which to bias geocode results more prominently.
	*/
	public void setBounds(String value) {
		this.inputs.setInput("Bounds", value);
	}


	/** 
	Set the value of the Language input for this Choreo. 

	@param String - (optional, string) The language in which to return results. Defaults to 'en' (English).
	*/
	public void setLanguage(String value) {
		this.inputs.setInput("Language", value);
	}


	/** 
	Set the value of the Region input for this Choreo. 

	@param String - (optional, string) The region code, specified as a ccTLD ("top-level domain") two-character value. Defaults to 'us' (United States).
	*/
	public void setRegion(String value) {
		this.inputs.setInput("Region", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Sensor input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates whether or not the geocoding request is from a device with a location sensor. Value must be either 1 or 0. Defaults to 0 (false).
	*/
	public void setSensor(Boolean value) {
		this.inputs.setInput("Sensor", value);
	}

	/** 
	Set the value of the Sensor input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates whether or not the geocoding request is from a device with a location sensor. Value must be either 1 or 0. Defaults to 0 (false).
	*/
	public void setSensor(String value) {
		this.inputs.setInput("Sensor", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GeocodeByAddressResultSet run() {
		JSONObject result = super.runWithResults();
		return new GeocodeByAddressResultSet(result);
	}
	
}
