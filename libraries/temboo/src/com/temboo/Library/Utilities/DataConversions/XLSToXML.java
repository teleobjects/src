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
XLSToXML

Converts Excel (.xls) formatted data to XML.
*/
public class XLSToXML extends Choreography {

	/**
	Create a new instance of the XLSToXML Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public XLSToXML(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/DataConversions/XLSToXML"));
	}

	/** 
	Set the value of the XLS input for this Choreo. 

	@param String - (conditional, string) The base64-encoded contents of the Excel file that you want to convert to XML. Compatible with Excel 97-2003.
	*/
	public void setXLS(String value) {
		this.inputs.setInput("XLS", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - (optional, vault file) A path to an Excel file that has been uploaded to the vault. You can use this input alias as an alternative to the ExcelFile input variable.
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public XLSToXMLResultSet run() {
		JSONObject result = super.runWithResults();
		return new XLSToXMLResultSet(result);
	}
	
}
