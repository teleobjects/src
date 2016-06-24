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
GetDemographicsByTypeAndID

Retrieve demographic data for a specified geography type and geography ID.
*/
public class GetDemographicsByTypeAndID extends Choreography {

	/**
	Create a new instance of the GetDemographicsByTypeAndID Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetDemographicsByTypeAndID(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/DataGov/GetDemographicsByTypeAndID"));
	}

	/** 
	Set the value of the DataVersion input for this Choreo. 

	@param String - (optional, string) Specify the census data version to search. Valid values are: jun2011, dec2011, jun2012, and dec2012.
	*/
	public void setDataVersion(String value) {
		this.inputs.setInput("DataVersion", value);
	}


	/** 
	Set the value of the GeographyIDs input for this Choreo. 

	@param Integer - (conditional, integer) The geography IDs to search for. Separate multiple IDs by commas; a maximum of 10 IDs are allowed.
	*/
	public void setGeographyIDs(Integer value) {
		this.inputs.setInput("GeographyIDs", value);
	}

	/** 
	Set the value of the GeographyIDs input for this Choreo as a String. 

	@param String - (conditional, integer) The geography IDs to search for. Separate multiple IDs by commas; a maximum of 10 IDs are allowed.
	*/
	public void setGeographyIDs(String value) {
		this.inputs.setInput("GeographyIDs", value);	
	}
	/** 
	Set the value of the GeographyType input for this Choreo. 

	@param String - (required, string) Specify one of the following geography type values: "state", "county", "tract", "block", "congdistrict", "statehouse", "statesenate", "censusplace", or "msa" (metropolitan statistical area).
	*/
	public void setGeographyType(String value) {
		this.inputs.setInput("GeographyType", value);
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
	public GetDemographicsByTypeAndIDResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetDemographicsByTypeAndIDResultSet(result);
	}
	
}
