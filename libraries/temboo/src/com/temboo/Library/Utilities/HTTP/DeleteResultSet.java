package com.temboo.Library.Utilities.HTTP;

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
import com.temboo.core.Choreography.ResultSet;

	
/**
	A ResultSet with methods tailored to the values returned by the Delete Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class DeleteResultSet extends ResultSet {
		
	public DeleteResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "HTTPLog" output from this Choreo execution

	@return String - (string) A debug log for the http request that was sent. This is only returned when Debug is set to "true".
	*/
	public String getHTTPLog() {
		return this.getResultString("HTTPLog");
	}
	/** 
	Retrieve the value for the "ResponseStatusCode" output from this Choreo execution

	@return String - (integer) The response status code.
	*/
	public String getResponseStatusCode() {
		return this.getResultString("ResponseStatusCode");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - The response from the server.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}