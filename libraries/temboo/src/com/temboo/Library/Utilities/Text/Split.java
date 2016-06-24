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
Split

Splits a string into sub-strings delimited by the specified delmiter pattern.
*/
public class Split extends Choreography {

	/**
	Create a new instance of the Split Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Split(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Text/Split"));
	}

	/** 
	Set the value of the Delimiter input for this Choreo. 

	@param String - (required, string) The delimiter to search for when splitting the string into sub-strings. See Choreo notes for restrictions with delimiters.
	*/
	public void setDelimiter(String value) {
		this.inputs.setInput("Delimiter", value);
	}


	/** 
	Set the value of the Text input for this Choreo. 

	@param String - (required, multiline) The text that should be split into sub-strings.
	*/
	public void setText(String value) {
		this.inputs.setInput("Text", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SplitResultSet run() {
		JSONObject result = super.runWithResults();
		return new SplitResultSet(result);
	}
	
}
