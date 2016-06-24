package com.temboo.Library.LittleSis.Reference;

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
GetReferences

Retrieves references for the data included in any record obtained from LittleSis.
*/
public class GetReferences extends Choreography {

	/**
	Create a new instance of the GetReferences Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetReferences(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LittleSis/Reference/GetReferences"));
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

	@param BigDecimal - (required, decimal) The ID of the record for which you want references. This can be either an entity or a relationship ID.
	*/
	public void setID(BigDecimal value) {
		this.inputs.setInput("ID", value);
	}

	/** 
	Set the value of the ID input for this Choreo as a String. 

	@param String - (required, decimal) The ID of the record for which you want references. This can be either an entity or a relationship ID.
	*/
	public void setID(String value) {
		this.inputs.setInput("ID", value);	
	}
	/** 
	Set the value of the RecordType input for this Choreo. 

	@param String - (required, string) Specify type of record for which you want to obtain references: entity (for a person or an institution record) or relationship (for a relationship record).
	*/
	public void setRecordType(String value) {
		this.inputs.setInput("RecordType", value);
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
	public GetReferencesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetReferencesResultSet(result);
	}
	
}
