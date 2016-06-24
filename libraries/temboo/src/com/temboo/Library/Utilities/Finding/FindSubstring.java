package com.temboo.Library.Utilities.Finding;

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
FindSubstring

Finds all occurrences of a specified substring and returns the substring positions as a JSON array.
*/
public class FindSubstring extends Choreography {

	/**
	Create a new instance of the FindSubstring Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FindSubstring(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Finding/FindSubstring"));
	}

	/** 
	Set the value of the CaseSensitive input for this Choreo. 

	@param Boolean - (optional, boolean) When set to true, the search will be case-sensitive. Defaults to false indicating a case-insensitive search.
	*/
	public void setCaseSensitive(Boolean value) {
		this.inputs.setInput("CaseSensitive", value);
	}

	/** 
	Set the value of the CaseSensitive input for this Choreo as a String. 

	@param String - (optional, boolean) When set to true, the search will be case-sensitive. Defaults to false indicating a case-insensitive search.
	*/
	public void setCaseSensitive(String value) {
		this.inputs.setInput("CaseSensitive", value);	
	}
	/** 
	Set the value of the StartNumber input for this Choreo. 

	@param String - (optional, string) The character position at which to begin the search. Defaults to 1.
	*/
	public void setStartNumber(String value) {
		this.inputs.setInput("StartNumber", value);
	}


	/** 
	Set the value of the Substring input for this Choreo. 

	@param String - (required, string) The sub-string to search within the specified text (searching from left to right).
	*/
	public void setSubstring(String value) {
		this.inputs.setInput("Substring", value);
	}


	/** 
	Set the value of the Text input for this Choreo. 

	@param String - (required, string) The text to search for a sub-string.
	*/
	public void setText(String value) {
		this.inputs.setInput("Text", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FindSubstringResultSet run() {
		JSONObject result = super.runWithResults();
		return new FindSubstringResultSet(result);
	}
	
}
