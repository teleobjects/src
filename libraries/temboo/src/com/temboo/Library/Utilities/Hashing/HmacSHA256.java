package com.temboo.Library.Utilities.Hashing;

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
HmacSHA256

Generates a SHA256-encrypted HMAC signature for the specified message text using the specified secret key.
*/
public class HmacSHA256 extends Choreography {

	/**
	Create a new instance of the HmacSHA256 Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public HmacSHA256(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Hashing/HmacSHA256"));
	}

	/** 
	Set the value of the Key input for this Choreo. 

	@param String - (required, string) The secret key used to generate the SHA256-encrypted HMAC signature.
	*/
	public void setKey(String value) {
		this.inputs.setInput("Key", value);
	}


	/** 
	Set the value of the Text input for this Choreo. 

	@param String - (required, string) The text that should be SHA256-encrypted.
	*/
	public void setText(String value) {
		this.inputs.setInput("Text", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public HmacSHA256ResultSet run() {
		JSONObject result = super.runWithResults();
		return new HmacSHA256ResultSet(result);
	}
	
}
