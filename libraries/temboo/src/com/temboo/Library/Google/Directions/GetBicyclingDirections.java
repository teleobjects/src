package com.temboo.Library.Google.Directions;

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
GetBicyclingDirections

 Generate biking directions between two locations, denoted by address or latitude/longitude coordinates.
*/
public class GetBicyclingDirections extends Choreography {

	/**
	Create a new instance of the GetBicyclingDirections Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetBicyclingDirections(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Directions/GetBicyclingDirections"));
	}

	/** 
	Set the value of the Alternatives input for this Choreo. 

	@param String - (optional, string) If set to true, additional routes will be returned.
	*/
	public void setAlternatives(String value) {
		this.inputs.setInput("Alternatives", value);
	}


	/** 
	Set the value of the Destination input for this Choreo. 

	@param String - (required, string) Enter the address or latitude/longitude coordinates from which directions will be generated (i.e."104 Franklin St, New York, NY" or "40.7160,-74.0037").
	*/
	public void setDestination(String value) {
		this.inputs.setInput("Destination", value);
	}


	/** 
	Set the value of the Origin input for this Choreo. 

	@param String - (required, string) Enter the address or latitude/longitude coordinates from which directions will be computed (i.e."104 Franklin St, New York, NY" or "40.7160,-74.0037").
	*/
	public void setOrigin(String value) {
		this.inputs.setInput("Origin", value);
	}


	/** 
	Set the value of the Region input for this Choreo. 

	@param String - (optional, string) Enter the region code for the directions, specified as a ccTLD two-character value.
	*/
	public void setRegion(String value) {
		this.inputs.setInput("Region", value);
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
	Set the value of the Units input for this Choreo. 

	@param String - (optional, string) Specify the units to be used when displaying results.  Options include, metric, or imperial.
	*/
	public void setUnits(String value) {
		this.inputs.setInput("Units", value);
	}


	/** 
	Set the value of the Waypoints input for this Choreo. 

	@param String - (optional, string) Specify route waypoints, either by address, or latitude/longitude coordinates.
	*/
	public void setWaypoints(String value) {
		this.inputs.setInput("Waypoints", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetBicyclingDirectionsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetBicyclingDirectionsResultSet(result);
	}
	
}
