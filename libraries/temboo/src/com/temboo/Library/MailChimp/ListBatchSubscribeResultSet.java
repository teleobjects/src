package com.temboo.Library.MailChimp;

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
	A ResultSet with methods tailored to the values returned by the ListBatchSubscribe Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class ListBatchSubscribeResultSet extends ResultSet {
		
	public ListBatchSubscribeResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "ErrorList" output from this Choreo execution

	@return String - (json) A list of emails that were not successfully subscribed.
	*/
	public String getErrorList() {
		return this.getResultString("ErrorList");
	}
	/** 
	Retrieve the value for the "SuccessList" output from this Choreo execution

	@return String - (json) A list of email successfully subscribed.
	*/
	public String getSuccessList() {
		return this.getResultString("SuccessList");
	}
}