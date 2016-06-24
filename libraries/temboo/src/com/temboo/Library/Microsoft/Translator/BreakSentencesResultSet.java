package com.temboo.Library.Microsoft.Translator;

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
	A ResultSet with methods tailored to the values returned by the BreakSentences Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class BreakSentencesResultSet extends ResultSet {
		
	public BreakSentencesResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "ExpiresIn" output from this Choreo execution

	@return String - (integer) Contains the number of seconds for which the access token is valid when ClientID and ClientSecret are provided.
	*/
	public String getExpiresIn() {
		return this.getResultString("ExpiresIn");
	}
	/** 
	Retrieve the value for the "NewAccessToken" output from this Choreo execution

	@return String - (string) Contains a new AccessToken when the ClientID and ClientSecret are provided.
	*/
	public String getNewAccessToken() {
		return this.getResultString("NewAccessToken");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - The response from Microsoft.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}