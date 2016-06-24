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
XMLToTSV

Converts an XML file to TSV format (TAB-separated values).
*/
public class XMLToTSV extends Choreography {

	/**
	Create a new instance of the XMLToTSV Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public XMLToTSV(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/DataConversions/XMLToTSV"));
	}

	/** 
	Set the value of the XML input for this Choreo. 

	@param String - (required, xml) The XML file to convert to TSV data.
	*/
	public void setXML(String value) {
		this.inputs.setInput("XML", value);
	}


	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (optional, string) If your XML is not in "/rowset/row/column_name" format, specify a path to the rows. See documentation for examples.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public XMLToTSVResultSet run() {
		JSONObject result = super.runWithResults();
		return new XMLToTSVResultSet(result);
	}
	
}
