package com.temboo.Library.LittleSis.Entity;

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
GetEntityByOutsideID

Retrieves the record for an Entity in LittleSis using the ID of a number of third-party organizations such as the SEC or GovTrack.
*/
public class GetEntityByOutsideID extends Choreography {

	/**
	Create a new instance of the GetEntityByOutsideID Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetEntityByOutsideID(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LittleSis/Entity/GetEntityByOutsideID"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key obtained from LittleSis.org.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the ID input for this Choreo. 

	@param Integer - (required, integer) The ID of the record to be returned.
	*/
	public void setID(Integer value) {
		this.inputs.setInput("ID", value);
	}

	/** 
	Set the value of the ID input for this Choreo as a String. 

	@param String - (required, integer) The ID of the record to be returned.
	*/
	public void setID(String value) {
		this.inputs.setInput("ID", value);	
	}
	/** 
	Set the value of the IDType input for this Choreo. 

	@param String - (required, string) You can search for a record by the IDs of other third-party services. Acceptable inputs: ticker, sec_cik, fec_id, bioguide_id, govtrack_id, crp_id, watchdog_id. See documentation for more information.
	*/
	public void setIDType(String value) {
		this.inputs.setInput("IDType", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) Format of the response returned by LittleSis.org. Acceptable inputs: xml or json. Defaults to xml
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetEntityByOutsideIDResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetEntityByOutsideIDResultSet(result);
	}
	
}
