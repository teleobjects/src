package com.temboo.Library.Utilities.XML;

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
RunXPathQuery

Executes an XPath query against a specified XML file and returns the result in CSV or JSON format.
*/
public class RunXPathQuery extends Choreography {

	/**
	Create a new instance of the RunXPathQuery Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RunXPathQuery(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/XML/RunXPathQuery"));
	}

	/** 
	Set the value of the Mode input for this Choreo. 

	@param String - (conditional, string) Valid values are "select" (the default) or "recursive". Recursive mode will iterate using the provided XPath. Select mode will return the first match if there are multiple rows in the XML provided.
	*/
	public void setMode(String value) {
		this.inputs.setInput("Mode", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json or csv.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the XML input for this Choreo. 

	@param String - (required, xml) The XML that contains the elements or attributes you want to retrieve.
	*/
	public void setXML(String value) {
		this.inputs.setInput("XML", value);
	}


	/** 
	Set the value of the XPath input for this Choreo. 

	@param String - (required, string) The XPath query to run.
	*/
	public void setXPath(String value) {
		this.inputs.setInput("XPath", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RunXPathQueryResultSet run() {
		JSONObject result = super.runWithResults();
		return new RunXPathQueryResultSet(result);
	}
	
}
