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
Checksum

Returns a checksum of the specified text calculated using the specified algorithm. 
*/
public class Checksum extends Choreography {

	/**
	Create a new instance of the Checksum Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Checksum(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Hashing/Checksum"));
	}

	/** 
	Set the value of the Algorithm input for this Choreo. 

	@param String - (required, string) Algorithm used to calculate the checksum. Valid values are: FIX44,  MD5+BASE64, or MD5+HEX (the default). MD5+BASE64 and MD5+HEX return the result in Base64 and hexadecimal encoding, respectively.
	*/
	public void setAlgorithm(String value) {
		this.inputs.setInput("Algorithm", value);
	}


	/** 
	Set the value of the Base64DecodeValue input for this Choreo. 

	@param Boolean - (optional, boolean) Setting this parameter to 1 indicates that the Text is Base64 encoded, and that the choreo should decode the value before calculating the checksum. Defaults to 0.
	*/
	public void setBase64DecodeValue(Boolean value) {
		this.inputs.setInput("Base64DecodeValue", value);
	}

	/** 
	Set the value of the Base64DecodeValue input for this Choreo as a String. 

	@param String - (optional, boolean) Setting this parameter to 1 indicates that the Text is Base64 encoded, and that the choreo should decode the value before calculating the checksum. Defaults to 0.
	*/
	public void setBase64DecodeValue(String value) {
		this.inputs.setInput("Base64DecodeValue", value);	
	}
	/** 
	Set the value of the Text input for this Choreo. 

	@param String - (required, string) The text to return a checksum for.
	*/
	public void setText(String value) {
		this.inputs.setInput("Text", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ChecksumResultSet run() {
		JSONObject result = super.runWithResults();
		return new ChecksumResultSet(result);
	}
	
}
