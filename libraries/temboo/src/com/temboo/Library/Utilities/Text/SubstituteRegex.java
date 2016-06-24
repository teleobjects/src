package com.temboo.Library.Utilities.Text;

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
SubstituteRegex

Finds all instances of the specified regular expression pattern within the given string and passes the specified new sub-string to the result variable. 
*/
public class SubstituteRegex extends Choreography {

	/**
	Create a new instance of the SubstituteRegex Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SubstituteRegex(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Text/SubstituteRegex"));
	}

	/** 
	Set the value of the New input for this Choreo. 

	@param String - (required, string) New sub-string to replace with.
	*/
	public void setNew(String value) {
		this.inputs.setInput("New", value);
	}


	/** 
	Set the value of the Pattern input for this Choreo. 

	@param String - (required, string) Regex pattern to use.
	*/
	public void setPattern(String value) {
		this.inputs.setInput("Pattern", value);
	}


	/** 
	Set the value of the Text input for this Choreo. 

	@param String - (required, string) Text to peform substitution.
	*/
	public void setText(String value) {
		this.inputs.setInput("Text", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SubstituteRegexResultSet run() {
		JSONObject result = super.runWithResults();
		return new SubstituteRegexResultSet(result);
	}
	
}
