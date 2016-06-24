package com.temboo.Library.Socrata.SODA;

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
	A ResultSet with methods tailored to the values returned by the Query Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class QueryResultSet extends ResultSet {
		
	public QueryResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "Fields" output from this Choreo execution

	@return String - (json) This lists the fields returned in this response in a JSON array.
	*/
	public String getFields() {
		return this.getResultString("Fields");
	}
	/** 
	Retrieve the value for the "Types" output from this Choreo execution

	@return String - (json) This is a list of SODA2 types in a JSON array. These will match up in the same order as the fields in X-SODA2-Fields.
	*/
	public String getTypes() {
		return this.getResultString("Types");
	}
	/** 
	Retrieve the value for the "LastModified" output from this Choreo execution

	@return String - (date) Contains the date returned in the Last-Modified response header.
	*/
	public String getLastModified() {
		return this.getResultString("LastModified");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - The response form Socrata.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}