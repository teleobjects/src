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
GetCensusIDByTypeAndName

Retrieve the U.S. census ID for a specified geography type and name.
*/
public class GetCensusIDByTypeAndName extends Choreography {

	/**
	Create a new instance of the GetCensusIDByTypeAndName Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetCensusIDByTypeAndName(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/DataGov/GetCensusIDByTypeAndName"));
	}

	/** 
	Set the value of the GeographyName input for this Choreo. 

	@param String - (required, string) Specify the geography name for the correspnding type, with at least three leading characters. For example, for the geography type "state" you could enter "ore" for Oregon.
	*/
	public void setGeographyName(String value) {
		this.inputs.setInput("GeographyName", value);
	}


	/** 
	Set the value of the GeographyType input for this Choreo. 

	@param String - (required, string) Specify one of the following geography type values: "state", "county", "tract", "block", "congdistrict", "statehouse", "statesenate", "censusplace", or "msa" (metropolitan statistical area).
	*/
	public void setGeographyType(String value) {
		this.inputs.setInput("GeographyType", value);
	}


	/** 
	Set the value of the MaxResults input for this Choreo. 

	@param Integer - (required, integer) Specify the maximum number of results to return. Defaults to 50.
	*/
	public void setMaxResults(Integer value) {
		this.inputs.setInput("MaxResults", value);
	}

	/** 
	Set the value of the MaxResults input for this Choreo as a String. 

	@param String - (required, integer) Specify the maximum number of results to return. Defaults to 50.
	*/
	public void setMaxResults(String value) {
		this.inputs.setInput("MaxResults", value);	
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
	public GetCensusIDByTypeAndNameResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetCensusIDByTypeAndNameResultSet(result);
	}
	
}
