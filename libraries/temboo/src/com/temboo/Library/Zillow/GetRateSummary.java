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
GetRateSummary

Retrieve current interest rates for a specified loan type.
*/
public class GetRateSummary extends Choreography {

	/**
	Create a new instance of the GetRateSummary Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetRateSummary(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Zillow/GetRateSummary"));
	}

	/** 
	Set the value of the OutputFormat input for this Choreo. 

	@param String - (optional, string) Enter the desired query output format.  Enter: xml, or json.  Default output is set to: xml.
	*/
	public void setOutputFormat(String value) {
		this.inputs.setInput("OutputFormat", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (optional, string) Enter a U.S. state abbreviation for which to retrieve mortgage rates.  If null, the national average rate is returned.
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
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
	public GetRateSummaryResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetRateSummaryResultSet(result);
	}
	
}
