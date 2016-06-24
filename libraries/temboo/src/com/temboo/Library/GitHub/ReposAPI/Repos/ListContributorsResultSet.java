package com.temboo.Library.GitHub.ReposAPI.Repos;

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
	A ResultSet with methods tailored to the values returned by the ListContributors Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class ListContributorsResultSet extends ResultSet {
		
	public ListContributorsResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "FirstPage" output from this Choreo execution

	@return String - (integer) The index for the first page of results.
	*/
	public String getFirstPage() {
		return this.getResultString("FirstPage");
	}
	/** 
	Retrieve the value for the "LastPage" output from this Choreo execution

	@return String - (integer) The index for the last page of results.
	*/
	public String getLastPage() {
		return this.getResultString("LastPage");
	}
	/** 
	Retrieve the value for the "Limit" output from this Choreo execution

	@return String - (integer) The available rate limit for your account. This is returned in the GitHub response header.
	*/
	public String getLimit() {
		return this.getResultString("Limit");
	}
	/** 
	Retrieve the value for the "NextPage" output from this Choreo execution

	@return String - (integer) The index for the next page of results.
	*/
	public String getNextPage() {
		return this.getResultString("NextPage");
	}
	/** 
	Retrieve the value for the "PreviousPage" output from this Choreo execution

	@return String - (integer) The index for the previous page of results.
	*/
	public String getPreviousPage() {
		return this.getResultString("PreviousPage");
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