package com.temboo.Library.Amazon.S3;

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
	A ResultSet with methods tailored to the values returned by the GetBucketLocation Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class GetBucketLocationResultSet extends ResultSet {
		
	public GetBucketLocationResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "LocationConstraint" output from this Choreo execution

	@return String - (string) The Region returned by the choreo. Valid values: blank (Default US Classic Region AKA us-east-1), EU (AKA eu-west-1), us-west-1, us-west-2, ap-southeast-1, ap-southeast-2, ap-northeast-1, sa-east-1.
	*/
	public String getLocationConstraint() {
		return this.getResultString("LocationConstraint");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - The response from Amazon.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}