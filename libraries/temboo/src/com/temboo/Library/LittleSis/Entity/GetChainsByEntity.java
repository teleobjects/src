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
GetChainsByEntity

Retrieves a chain of connections between two Entities (person or organization) in LittleSis.
*/
public class GetChainsByEntity extends Choreography {

	/**
	Create a new instance of the GetChainsByEntity Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetChainsByEntity(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LittleSis/Entity/GetChainsByEntity"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key obtained from LittleSis.org.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the CategoryID input for this Choreo. 

	@param Integer - (optional, integer) Limit the relationships to specific categories by specifying the category number.
	*/
	public void setCategoryID(Integer value) {
		this.inputs.setInput("CategoryID", value);
	}

	/** 
	Set the value of the CategoryID input for this Choreo as a String. 

	@param String - (optional, integer) Limit the relationships to specific categories by specifying the category number.
	*/
	public void setCategoryID(String value) {
		this.inputs.setInput("CategoryID", value);	
	}
	/** 
	Set the value of the EntityIDs input for this Choreo. 

	@param Integer - (required, integer) The EntityIDs of the two entities for which a relationship chain is to be returned, separated by a semicolon (e.g. 14629;2 ).
	*/
	public void setEntityIDs(Integer value) {
		this.inputs.setInput("EntityIDs", value);
	}

	/** 
	Set the value of the EntityIDs input for this Choreo as a String. 

	@param String - (required, integer) The EntityIDs of the two entities for which a relationship chain is to be returned, separated by a semicolon (e.g. 14629;2 ).
	*/
	public void setEntityIDs(String value) {
		this.inputs.setInput("EntityIDs", value);	
	}
	/** 
	Set the value of the Page input for this Choreo. 

	@param String - (optional, string) Specifies which of the found chain to expand in detail. Default is 1.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);
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
	public GetChainsByEntityResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetChainsByEntityResultSet(result);
	}
	
}
