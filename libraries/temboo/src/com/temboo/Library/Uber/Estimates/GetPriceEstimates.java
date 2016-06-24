package com.temboo.Library.Uber.Estimates;

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
GetPriceEstimates

Returns an estimated price range for each product offered at a given location.
*/
public class GetPriceEstimates extends Choreography {

	/**
	Create a new instance of the GetPriceEstimates Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetPriceEstimates(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Uber/Estimates/GetPriceEstimates"));
	}

	/** 
	Set the value of the EndLatitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The latitude coordinate for the destination e.g., 40.650729.
	*/
	public void setEndLatitude(BigDecimal value) {
		this.inputs.setInput("EndLatitude", value);
	}

	/** 
	Set the value of the EndLatitude input for this Choreo as a String. 

	@param String - (required, decimal) The latitude coordinate for the destination e.g., 40.650729.
	*/
	public void setEndLatitude(String value) {
		this.inputs.setInput("EndLatitude", value);	
	}
	/** 
	Set the value of the EndLongitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The longitude coordinate for the destination e.g., -74.009536.
	*/
	public void setEndLongitude(BigDecimal value) {
		this.inputs.setInput("EndLongitude", value);
	}

	/** 
	Set the value of the EndLongitude input for this Choreo as a String. 

	@param String - (required, decimal) The longitude coordinate for the destination e.g., -74.009536.
	*/
	public void setEndLongitude(String value) {
		this.inputs.setInput("EndLongitude", value);	
	}
	/** 
	Set the value of the ServerToken input for this Choreo. 

	@param String - (required, string) The Sever Token provided by Uber.
	*/
	public void setServerToken(String value) {
		this.inputs.setInput("ServerToken", value);
	}


	/** 
	Set the value of the StartLatitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The latitude coordinate for the starting location e.g., 40.71863.
	*/
	public void setStartLatitude(BigDecimal value) {
		this.inputs.setInput("StartLatitude", value);
	}

	/** 
	Set the value of the StartLatitude input for this Choreo as a String. 

	@param String - (required, decimal) The latitude coordinate for the starting location e.g., 40.71863.
	*/
	public void setStartLatitude(String value) {
		this.inputs.setInput("StartLatitude", value);	
	}
	/** 
	Set the value of the StartLongitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The longitude coordinate for the starting location e.g., -74.005584.
	*/
	public void setStartLongitude(BigDecimal value) {
		this.inputs.setInput("StartLongitude", value);
	}

	/** 
	Set the value of the StartLongitude input for this Choreo as a String. 

	@param String - (required, decimal) The longitude coordinate for the starting location e.g., -74.005584.
	*/
	public void setStartLongitude(String value) {
		this.inputs.setInput("StartLongitude", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetPriceEstimatesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetPriceEstimatesResultSet(result);
	}
	
}
