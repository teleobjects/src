package com.temboo.Library.Google.Contacts;

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
	A ResultSet with methods tailored to the values returned by the DeleteContact Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class DeleteContactResultSet extends ResultSet {
		
	public DeleteContactResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "AccessToken" output from this Choreo execution

	@return String - (optional, string) The access token retrieved in the last step of the OAuth process. Access tokens that are expired will be refreshed and returned in the Choreo output.
	*/
	public String getAccessToken() {
		return this.getResultString("AccessToken");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - The response from Google. No content is returned for a successful delete request.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}