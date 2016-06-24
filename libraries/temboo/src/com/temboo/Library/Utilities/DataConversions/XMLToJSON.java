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
XMLToJSON

Converts data from XML format to JSON format.
*/
public class XMLToJSON extends Choreography {

	/**
	Create a new instance of the XMLToJSON Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public XMLToJSON(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/DataConversions/XMLToJSON"));
	}

	/** 
	Set the value of the XML input for this Choreo. 

	@param String - (required, xml) The XML file that you want to convert to JSON format.
	*/
	public void setXML(String value) {
		this.inputs.setInput("XML", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public XMLToJSONResultSet run() {
		JSONObject result = super.runWithResults();
		return new XMLToJSONResultSet(result);
	}
	
}
