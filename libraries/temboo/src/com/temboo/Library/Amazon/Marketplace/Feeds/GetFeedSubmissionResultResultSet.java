package com.temboo.Library.Amazon.Marketplace.Feeds;

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
	A ResultSet with methods tailored to the values returned by the GetFeedSubmissionResult Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class GetFeedSubmissionResultResultSet extends ResultSet {
		
	public GetFeedSubmissionResultResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "ContentMD5Header" output from this Choreo execution

	@return String - (string) The Content MD5 header returned from Amazon. This can used to check against an MD5 hash that you generate before submitting the feed to verify that the feed was submitted correctly.
	*/
	public String getContentMD5Header() {
		return this.getResultString("ContentMD5Header");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - Stores the response from Amazon.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}