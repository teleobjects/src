package com.temboo.Library.Utilities.Numbers;

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
	A ResultSet with methods tailored to the values returned by the GenerateRandom Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class GenerateRandomResultSet extends ResultSet {
		
	public GenerateRandomResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "SignedDecimal" output from this Choreo execution

	@return String - (decimal) Signed Decimal in the range of  -0.5 to +0.5.
	*/
	public String getSignedDecimal() {
		return this.getResultString("SignedDecimal");
	}
	/** 
	Retrieve the value for the "SignedInteger" output from this Choreo execution

	@return String - (integer) SIgned Integer in the range of -2147483648 through 2147483647.
	*/
	public String getSignedInteger() {
		return this.getResultString("SignedInteger");
	}
	/** 
	Retrieve the value for the "UnsignedDecimal" output from this Choreo execution

	@return String - (decimal) Unsigned Decimal in the range of 0.0 to 1.0.
	*/
	public String getUnsignedDecimal() {
		return this.getResultString("UnsignedDecimal");
	}
	/** 
	Retrieve the value for the "UnsignedInteger" output from this Choreo execution

	@return String - (integer) Unsigned integer in the range of 0 through 4294967295.
	*/
	public String getUnsignedInteger() {
		return this.getResultString("UnsignedInteger");
	}
}