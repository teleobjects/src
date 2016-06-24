package com.temboo.Library.Utilities.Validation;

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
GermanPostalCodes

Verifies that a given zip code matches the format expected for German addresses.
*/
public class GermanPostalCodes extends Choreography {

	/**
	Create a new instance of the GermanPostalCodes Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GermanPostalCodes(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Validation/GermanPostalCodes"));
	}

	/** 
	Set the value of the ZipCode input for this Choreo. 

	@param String - (required, string) The zip code to validate.
	*/
	public void setZipCode(String value) {
		this.inputs.setInput("ZipCode", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GermanPostalCodesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GermanPostalCodesResultSet(result);
	}
	
}
