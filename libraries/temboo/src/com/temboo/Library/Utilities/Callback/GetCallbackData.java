package com.temboo.Library.Utilities.Callback;

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
GetCallbackData

Retrieves data captured from a request to your callback URL.
*/
public class GetCallbackData extends Choreography {

	/**
	Create a new instance of the GetCallbackData Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetCallbackData(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Callback/GetCallbackData"));
	}

	/** 
	Set the value of the CallbackID input for this Choreo. 

	@param String - (required, string) The ID that can used to retrieve request data that the callback URL has captured.
	*/
	public void setCallbackID(String value) {
		this.inputs.setInput("CallbackID", value);
	}


	/** 
	Set the value of the FilterName input for this Choreo. 

	@param String - (optional, string) Allows you to filter callback data by a query parameter key-value pair. FilterValue is required when using this input.
	*/
	public void setFilterName(String value) {
		this.inputs.setInput("FilterName", value);
	}


	/** 
	Set the value of the FilterValue input for this Choreo. 

	@param String - (optional, string) Allows you to filter callback data by a query parameter key-value pair. FilterName is required when using this input.
	*/
	public void setFilterValue(String value) {
		this.inputs.setInput("FilterValue", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetCallbackDataResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetCallbackDataResultSet(result);
	}
	
}
