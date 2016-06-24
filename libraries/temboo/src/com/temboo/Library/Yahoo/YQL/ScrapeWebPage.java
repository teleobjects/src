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
ScrapeWebPage

Scrapes HTML from a web page and converts it to JSON or XML so that it can be reused by an application.
*/
public class ScrapeWebPage extends Choreography {

	/**
	Create a new instance of the ScrapeWebPage Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ScrapeWebPage(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Yahoo/YQL/ScrapeWebPage"));
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
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (required, string) The URL of the web page to scrape.
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	/** 
	Set the value of the XPATH input for this Choreo. 

	@param String - (optional, string) An XPATH statement that can be used to extract specific information from the HTML.
	*/
	public void setXPATH(String value) {
		this.inputs.setInput("XPATH", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ScrapeWebPageResultSet run() {
		JSONObject result = super.runWithResults();
		return new ScrapeWebPageResultSet(result);
	}
	
}
