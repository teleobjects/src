package com.temboo.Library.DuckDuckGo;

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
Query

Access DuckDuckGo web search functionality.  
*/
public class Query extends Choreography {

	/**
	Create a new instance of the Query Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Query(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/DuckDuckGo/Query"));
	}

	/** 
	Set the value of the Format input for this Choreo. 

	@param String - (optional, string) Enter: xml, or json.  Default is set to xml.
	*/
	public void setFormat(String value) {
		this.inputs.setInput("Format", value);
	}


	/** 
	Set the value of the NoHTML input for this Choreo. 

	@param Integer - (optional, integer) Enter 1 to remove HTML from text. Set only if Format=json.
	*/
	public void setNoHTML(Integer value) {
		this.inputs.setInput("NoHTML", value);
	}

	/** 
	Set the value of the NoHTML input for this Choreo as a String. 

	@param String - (optional, integer) Enter 1 to remove HTML from text. Set only if Format=json.
	*/
	public void setNoHTML(String value) {
		this.inputs.setInput("NoHTML", value);	
	}
	/** 
	Set the value of the NoRedirect input for this Choreo. 

	@param Integer - (optional, integer) Enter 1 to skip HTTP redirects.  This is useful for !bang commands. Set only if Format=json.
	*/
	public void setNoRedirect(Integer value) {
		this.inputs.setInput("NoRedirect", value);
	}

	/** 
	Set the value of the NoRedirect input for this Choreo as a String. 

	@param String - (optional, integer) Enter 1 to skip HTTP redirects.  This is useful for !bang commands. Set only if Format=json.
	*/
	public void setNoRedirect(String value) {
		this.inputs.setInput("NoRedirect", value);	
	}
	/** 
	Set the value of the PrettyPrint input for this Choreo. 

	@param Integer - (optional, integer) Enter 1 to pretty-print the JSON output.
	*/
	public void setPrettyPrint(Integer value) {
		this.inputs.setInput("PrettyPrint", value);
	}

	/** 
	Set the value of the PrettyPrint input for this Choreo as a String. 

	@param String - (optional, integer) Enter 1 to pretty-print the JSON output.
	*/
	public void setPrettyPrint(String value) {
		this.inputs.setInput("PrettyPrint", value);	
	}
	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (required, string) Enter a search query.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the SkipDisambiguation input for this Choreo. 

	@param Integer - (optional, integer) Enter 1 to skip disambiguation. Set only if Format=json.
	*/
	public void setSkipDisambiguation(Integer value) {
		this.inputs.setInput("SkipDisambiguation", value);
	}

	/** 
	Set the value of the SkipDisambiguation input for this Choreo as a String. 

	@param String - (optional, integer) Enter 1 to skip disambiguation. Set only if Format=json.
	*/
	public void setSkipDisambiguation(String value) {
		this.inputs.setInput("SkipDisambiguation", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public QueryResultSet run() {
		JSONObject result = super.runWithResults();
		return new QueryResultSet(result);
	}
	
}
