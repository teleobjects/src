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
DeletePlace

Delete a new Place from Google Places.
*/
public class DeletePlace extends Choreography {

	/**
	Create a new instance of the DeletePlace Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DeletePlace(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Places/DeletePlace"));
	}

	/** 
	Set the value of the Key input for this Choreo. 

	@param String - (required, string) The API Key provided by Google.
	*/
	public void setKey(String value) {
		this.inputs.setInput("Key", value);
	}


	/** 
	Set the value of the PlaceID input for this Choreo. 

	@param String - (conditional, string) A textual identifier that uniquely identifies a place.
	*/
	public void setPlaceID(String value) {
		this.inputs.setInput("PlaceID", value);
	}


	/** 
	Set the value of the PlaceReference input for this Choreo. 

	@param String - (optional, string) A textual identifier that uniquely identifies a place. Note, this parameter is deprecated as of June 24, 2014. Use PlaceID instead.
	*/
	public void setPlaceReference(String value) {
		this.inputs.setInput("PlaceReference", value);
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
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DeletePlaceResultSet run() {
		JSONObject result = super.runWithResults();
		return new DeletePlaceResultSet(result);
	}
	
}
