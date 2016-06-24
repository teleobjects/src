package com.temboo.Library.GitHub.GitDataAPI.Commits;

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
	A ResultSet with methods tailored to the values returned by the GetCommit Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class GetCommitResultSet extends ResultSet {
		
	public GetCommitResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "Limit" output from this Choreo execution

	@return String - (integer) The available rate limit for your account. This is returned in the GitHub response header.
	*/
	public String getLimit() {
		return this.getResultString("Limit");
	}
	/** 
	Retrieve the value for the "Remaining" output from this Choreo execution

	@return String - (integer) The remaining number of API requests available to you. This is returned in the GitHub response header.
	*/
	public String getRemaining() {
		return this.getResultString("Remaining");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - (json) The response from GitHub.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}