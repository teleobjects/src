package com.temboo.Library.Zillow;

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
GetZestimate

Retrieve estimate information for a specified property.
*/
public class GetZestimate extends Choreography {

	/**
	Create a new instance of the GetZestimate Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetZestimate(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Zillow/GetZestimate"));
	}

	/** 
	Set the value of the RentEstimate input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 (true) to enable. Defaults to 0 (false).
	*/
	public void setRentEstimate(Boolean value) {
		this.inputs.setInput("RentEstimate", value);
	}

	/** 
	Set the value of the RentEstimate input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 (true) to enable. Defaults to 0 (false).
	*/
	public void setRentEstimate(String value) {
		this.inputs.setInput("RentEstimate", value);	
	}
	/** 
	Set the value of the ZPID input for this Choreo. 

	@param Integer - (required, integer) Enter a Zillow Property ID for the property being queried.
	*/
	public void setZPID(Integer value) {
		this.inputs.setInput("ZPID", value);
	}

	/** 
	Set the value of the ZPID input for this Choreo as a String. 

	@param String - (required, integer) Enter a Zillow Property ID for the property being queried.
	*/
	public void setZPID(String value) {
		this.inputs.setInput("ZPID", value);	
	}
	/** 
	Set the value of the ZWSID input for this Choreo. 

	@param String - (required, string) Enter a Zillow Web Service Identifier (ZWS ID).
	*/
	public void setZWSID(String value) {
		this.inputs.setInput("ZWSID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetZestimateResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetZestimateResultSet(result);
	}
	
}
