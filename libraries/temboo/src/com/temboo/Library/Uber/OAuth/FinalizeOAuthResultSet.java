package com.temboo.Library.Uber.OAuth;

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
	A ResultSet with methods tailored to the values returned by the FinalizeOAuth Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class FinalizeOAuthResultSet extends ResultSet {
		
	public FinalizeOAuthResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "AccessToken" output from this Choreo execution

	@return String - (string) The Access Token for the user that has granted access to your application.
	*/
	public String getAccessToken() {
		return this.getResultString("AccessToken");
	}
	/** 
	Retrieve the value for the "ErrorMessage" output from this Choreo execution

	@return String - (string) Contains an error message if an error occurs during the OAuth redirect process and if SuppressErrors is set to true.
	*/
	public String getErrorMessage() {
		return this.getResultString("ErrorMessage");
	}
	/** 
	Retrieve the value for the "Expires" output from this Choreo execution

	@return String - (integer) The remaining lifetime of the short-lived Access Token.
	*/
	public String getExpires() {
		return this.getResultString("Expires");
	}
	/** 
	Retrieve the value for the "RefreshToken" output from this Choreo execution

	@return String - (string) A token that may be used to obtain a new Access Token when the short-lived Access Token expires.
	*/
	public String getRefreshToken() {
		return this.getResultString("RefreshToken");
	}
}