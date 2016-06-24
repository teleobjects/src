package com.temboo.Library.Google.Spreadsheets;

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
	A ResultSet with methods tailored to the values returned by the SearchColumn Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class SearchColumnResultSet extends ResultSet {
		
	public SearchColumnResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "MatchFound" output from this Choreo execution

	@return String - (boolean) Whether or not a matched result was found.
	*/
	public String getMatchFound() {
		return this.getResultString("MatchFound");
	}
	/** 
	Retrieve the value for the "Count" output from this Choreo execution

	@return String - (integer) The count of matched results. This is only returned when ReturnMatches is set to true.
	*/
	public String getCount() {
		return this.getResultString("Count");
	}
	/** 
	Retrieve the value for the "NewAccessToken" output from this Choreo execution

	@return String - (string) Contains a new AccessToken when the RefreshToken is provided.
	*/
	public String getNewAccessToken() {
		return this.getResultString("NewAccessToken");
	}
	/** 
	Retrieve the value for the "Results" output from this Choreo execution

	@return String - (json) Contains an array of the matched cell values. This is only returned when ReturnMatches is set to true.
	*/
	public String getResults() {
		return this.getResultString("Results");
	}
}