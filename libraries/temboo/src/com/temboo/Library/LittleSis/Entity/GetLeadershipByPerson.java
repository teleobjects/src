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
GetLeadershipByPerson

Retrieves a list of organizations of which a given person is an executive or board member.
*/
public class GetLeadershipByPerson extends Choreography {

	/**
	Create a new instance of the GetLeadershipByPerson Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetLeadershipByPerson(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LittleSis/Entity/GetLeadershipByPerson"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key obtained from LittleSis.org.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Current input for this Choreo. 

	@param Integer - (optional, integer) Set to 1 to limit the relationships returned to only past relationships. Set to 0 to limit relationships returned to only current relationships. Defaults to all.
	*/
	public void setCurrent(Integer value) {
		this.inputs.setInput("Current", value);
	}

	/** 
	Set the value of the Current input for this Choreo as a String. 

	@param String - (optional, integer) Set to 1 to limit the relationships returned to only past relationships. Set to 0 to limit relationships returned to only current relationships. Defaults to all.
	*/
	public void setCurrent(String value) {
		this.inputs.setInput("Current", value);	
	}
	/** 
	Set the value of the EntityID input for this Choreo. 

	@param Integer - (required, integer) The ID of the person.
	*/
	public void setEntityID(Integer value) {
		this.inputs.setInput("EntityID", value);
	}

	/** 
	Set the value of the EntityID input for this Choreo as a String. 

	@param String - (required, integer) The ID of the person.
	*/
	public void setEntityID(String value) {
		this.inputs.setInput("EntityID", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) Format of the response returned by LittleSis.org. Acceptable inputs: xml or json. Defaults to xml
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (optional, string) Limits results to organizations of the specified type, e.g. "PublicCompany."
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetLeadershipByPersonResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetLeadershipByPersonResultSet(result);
	}
	
}
