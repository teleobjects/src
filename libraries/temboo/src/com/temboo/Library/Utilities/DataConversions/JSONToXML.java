package com.temboo.Library.Utilities.DataConversions;

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
JSONToXML

Converts data from JSON format to XML format.
*/
public class JSONToXML extends Choreography {

	/**
	Create a new instance of the JSONToXML Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public JSONToXML(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/DataConversions/JSONToXML"));
	}

	/** 
	Set the value of the JSON input for this Choreo. 

	@param String - (required, json) The JSON data that you want to convert to XML.
	*/
	public void setJSON(String value) {
		this.inputs.setInput("JSON", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public JSONToXMLResultSet run() {
		JSONObject result = super.runWithResults();
		return new JSONToXMLResultSet(result);
	}
	
}
