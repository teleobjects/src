package com.temboo.Library.DataGov;

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
GetDemographicsByCoordinates

Retrieve demographic information for specified geographical coordinates.
*/
public class GetDemographicsByCoordinates extends Choreography {

	/**
	Create a new instance of the GetDemographicsByCoordinates Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetDemographicsByCoordinates(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/DataGov/GetDemographicsByCoordinates"));
	}

	/** 
	Set the value of the DataVersion input for this Choreo. 

	@param String - (optional, string) Specify the data version to search. Valid values are 2011 or 2012 (the default).
	*/
	public void setDataVersion(String value) {
		this.inputs.setInput("DataVersion", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (required, decimal) Specify a latitude to search for, such as "41.486857".
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (required, decimal) Specify a latitude to search for, such as "41.486857".
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (required, decimal) Specify a longitude to search for, such as "-71.294392".
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (required, decimal) Specify a longitude to search for, such as "-71.294392".
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: xml (the default) and json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetDemographicsByCoordinatesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetDemographicsByCoordinatesResultSet(result);
	}
	
}
