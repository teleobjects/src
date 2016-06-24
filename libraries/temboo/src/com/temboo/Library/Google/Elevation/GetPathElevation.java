package com.temboo.Library.Google.Elevation;

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
GetPathElevation

Obtain elevation information for a path specified by a set of  geo-coordinates.
*/
public class GetPathElevation extends Choreography {

	/**
	Create a new instance of the GetPathElevation Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetPathElevation(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Elevation/GetPathElevation"));
	}

	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (required, string) Specify the path for which elevation data will be obtained.  Input formats: an array of two or more lat/longitude coordinate pairs; A set of encoded coordinates using the Encoded Polyline Algorithm.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Samples input for this Choreo. 

	@param Integer - (required, integer) Enter the number of sample points.  See API docs for additional information.
	*/
	public void setSamples(Integer value) {
		this.inputs.setInput("Samples", value);
	}

	/** 
	Set the value of the Samples input for this Choreo as a String. 

	@param String - (required, integer) Enter the number of sample points.  See API docs for additional information.
	*/
	public void setSamples(String value) {
		this.inputs.setInput("Samples", value);	
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
	public GetPathElevationResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetPathElevationResultSet(result);
	}
	
}
