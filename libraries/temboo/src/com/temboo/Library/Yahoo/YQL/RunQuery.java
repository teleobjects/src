package com.temboo.Library.Yahoo.YQL;

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
RunQuery

Executes a specified YQL (Yahoo Query Language) statement.
*/
public class RunQuery extends Choreography {

	/**
	Create a new instance of the RunQuery Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RunQuery(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Yahoo/YQL/RunQuery"));
	}

	/** 
	Set the value of the Diagnostics input for this Choreo. 

	@param Boolean - (optional, boolean) When set to "true" (the default), additional debug information about the request is returned.
	*/
	public void setDiagnostics(Boolean value) {
		this.inputs.setInput("Diagnostics", value);
	}

	/** 
	Set the value of the Diagnostics input for this Choreo as a String. 

	@param String - (optional, boolean) When set to "true" (the default), additional debug information about the request is returned.
	*/
	public void setDiagnostics(String value) {
		this.inputs.setInput("Diagnostics", value);	
	}
	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (required, string) A YQL (Yahoo! Query Language) statement to execute.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RunQueryResultSet run() {
		JSONObject result = super.runWithResults();
		return new RunQueryResultSet(result);
	}
	
}
