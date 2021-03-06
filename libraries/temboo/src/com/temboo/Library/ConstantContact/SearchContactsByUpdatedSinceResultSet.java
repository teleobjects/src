package com.temboo.Library.ConstantContact;

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
	A ResultSet with methods tailored to the values returned by the SearchContactsByUpdatedSince Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class SearchContactsByUpdatedSinceResultSet extends ResultSet {
		
	public SearchContactsByUpdatedSinceResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "NextPage" output from this Choreo execution

	@return String - (string) A URI used to retrieve the next page of results. If this value is not returned, there are no more results to retrieve. This value can be passed to the "NextResults" input of this Choreo.
	*/
	public String getNextPage() {
		return this.getResultString("NextPage");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - (xml) The response from Constant Contact.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}