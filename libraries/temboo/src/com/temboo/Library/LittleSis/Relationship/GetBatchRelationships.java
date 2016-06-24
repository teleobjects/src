package com.temboo.Library.LittleSis.Relationship;

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
GetBatchRelationships

Retrieves information about a batch of relationships in LittleSis according to the relationship IDs provided.
*/
public class GetBatchRelationships extends Choreography {

	/**
	Create a new instance of the GetBatchRelationships Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetBatchRelationships(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LittleSis/Relationship/GetBatchRelationships"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key obtained from LittleSis.org.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Details input for this Choreo. 

	@param Integer - (optional, integer) Indicate 1 to include details for each relationship record returned. Otherwise, only a basic record will be returned.
	*/
	public void setDetails(Integer value) {
		this.inputs.setInput("Details", value);
	}

	/** 
	Set the value of the Details input for this Choreo as a String. 

	@param String - (optional, integer) Indicate 1 to include details for each relationship record returned. Otherwise, only a basic record will be returned.
	*/
	public void setDetails(String value) {
		this.inputs.setInput("Details", value);	
	}
	/** 
	Set the value of the RelationshipIDs input for this Choreo. 

	@param String - (required, string) The IDs of the relationship records to be returned as a comma delimited string.
	*/
	public void setRelationshipIDs(String value) {
		this.inputs.setInput("RelationshipIDs", value);
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
	public GetBatchRelationshipsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetBatchRelationshipsResultSet(result);
	}
	
}
