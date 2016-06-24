package com.temboo.Library.Utilities.Encoding;

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
Base64Encode

Returns the specified text or file as a Base64 encoded string.
*/
public class Base64Encode extends Choreography {

	/**
	Create a new instance of the Base64Encode Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Base64Encode(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Encoding/Base64Encode"));
	}

	/** 
	Set the value of the Text input for this Choreo. 

	@param String - (conditional, string) The text that should be Base64 encoded. Required unless providing a value for the URL input.
	*/
	public void setText(String value) {
		this.inputs.setInput("Text", value);
	}


	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (conditional, string) A URL to a hosted file that should be Base64 encoded. Required unless providing a value for the Text input.
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public Base64EncodeResultSet run() {
		JSONObject result = super.runWithResults();
		return new Base64EncodeResultSet(result);
	}
	
}
