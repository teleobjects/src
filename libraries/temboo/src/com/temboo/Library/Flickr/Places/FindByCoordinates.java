package com.temboo.Library.Flickr.Places;

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
FindByCoordinates

Returns a place ID for a given latitude, longitude and accuracy.
*/
public class FindByCoordinates extends Choreography {

	/**
	Create a new instance of the FindByCoordinates Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FindByCoordinates(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Flickr/Places/FindByCoordinates"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Flickr (AKA the OAuth Consumer Key).
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Accuracy input for this Choreo. 

	@param Integer - (optional, integer) Recorded accuracy level of the location information. Valid range is 1-16. The default is 16.
	*/
	public void setAccuracy(Integer value) {
		this.inputs.setInput("Accuracy", value);
	}

	/** 
	Set the value of the Accuracy input for this Choreo as a String. 

	@param String - (optional, integer) Recorded accuracy level of the location information. Valid range is 1-16. The default is 16.
	*/
	public void setAccuracy(String value) {
		this.inputs.setInput("Accuracy", value);	
	}
	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The latitude whose valid range is -90 to 90. Anything more than 4 decimal places will be truncated.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (required, decimal) The latitude whose valid range is -90 to 90. Anything more than 4 decimal places will be truncated.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The longitude whose valid range is -180 to 180. Anything more than 4 decimal places will be truncated.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (required, decimal) The longitude whose valid range is -180 to 180. Anything more than 4 decimal places will be truncated.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) 
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FindByCoordinatesResultSet run() {
		JSONObject result = super.runWithResults();
		return new FindByCoordinatesResultSet(result);
	}
	
}
