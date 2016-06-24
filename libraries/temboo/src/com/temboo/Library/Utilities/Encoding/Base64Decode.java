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
Base64Decode

Returns the specified Base64 encoded string as decoded text.
*/
public class Base64Decode extends Choreography {

	/**
	Create a new instance of the Base64Decode Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Base64Decode(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Encoding/Base64Decode"));
	}

	/** 
	Set the value of the Base64EncodedText input for this Choreo. 

	@param String - (required, string) The Base64 encoded text to decode. Note that Base64 encoded binary data is not allowed.
	*/
	public void setBase64EncodedText(String value) {
		this.inputs.setInput("Base64EncodedText", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public Base64DecodeResultSet run() {
		JSONObject result = super.runWithResults();
		return new Base64DecodeResultSet(result);
	}
	
}
