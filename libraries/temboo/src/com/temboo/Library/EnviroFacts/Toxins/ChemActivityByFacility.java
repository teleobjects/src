package com.temboo.Library.EnviroFacts.Toxins;

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
ChemActivityByFacility

Retrieves a list of the type of manufacturing activity of toxic chemicals at any EPA-regulated facility.
*/
public class ChemActivityByFacility extends Choreography {

	/**
	Create a new instance of the ChemActivityByFacility Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ChemActivityByFacility(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/EnviroFacts/Toxins/ChemActivityByFacility"));
	}

	/** 
	Set the value of the FacilityID input for this Choreo. 

	@param String - (required, string) FacilityID for which a toxin release report is to be generated. Found by first running the FacilitiesSearch Choreo.
	*/
	public void setFacilityID(String value) {
		this.inputs.setInput("FacilityID", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) Specify the desired response format. Valid formats are: xml (the default) and csv.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the RowEnd input for this Choreo. 

	@param Integer - (optional, integer) Number 1 or greater indicates the ending row number of the results displayed. Default is 4999 when RowStart is 0. Up to 5000 entries are returned in the output.
	*/
	public void setRowEnd(Integer value) {
		this.inputs.setInput("RowEnd", value);
	}

	/** 
	Set the value of the RowEnd input for this Choreo as a String. 

	@param String - (optional, integer) Number 1 or greater indicates the ending row number of the results displayed. Default is 4999 when RowStart is 0. Up to 5000 entries are returned in the output.
	*/
	public void setRowEnd(String value) {
		this.inputs.setInput("RowEnd", value);	
	}
	/** 
	Set the value of the RowStart input for this Choreo. 

	@param Integer - (optional, integer) Indicates the starting row number of the results displayed. Default is 0.
	*/
	public void setRowStart(Integer value) {
		this.inputs.setInput("RowStart", value);
	}

	/** 
	Set the value of the RowStart input for this Choreo as a String. 

	@param String - (optional, integer) Indicates the starting row number of the results displayed. Default is 0.
	*/
	public void setRowStart(String value) {
		this.inputs.setInput("RowStart", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ChemActivityByFacilityResultSet run() {
		JSONObject result = super.runWithResults();
		return new ChemActivityByFacilityResultSet(result);
	}
	
}
