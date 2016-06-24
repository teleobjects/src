package com.temboo.Library.Utilities.Dates;

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
import com.temboo.core.Choreography;
import com.temboo.core.Choreography.ResultSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooPath;
import com.temboo.core.TembooSession;

/** 
GetDateDifference

Returns the difference between two specified dates, expressed as the number of milliseconds since January 1, 1970 (epoch time).
*/
public class GetDateDifference extends Choreography {

	/**
	Create a new instance of the GetDateDifference Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetDateDifference(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Dates/GetDateDifference"));
	}

	/** 
	Set the value of the EarlierDate input for this Choreo. 

	@param String - (required, date) The earlier date to use for the date comparision (e.g., March 2, 2014).
	*/
	public void setEarlierDate(String value) {
		this.inputs.setInput("EarlierDate", value);
	}


	/** 
	Set the value of the LaterDate input for this Choreo. 

	@param String - (required, date) The later date to use for the date comparision (e.g., March 3, 2014).
	*/
	public void setLaterDate(String value) {
		this.inputs.setInput("LaterDate", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetDateDifferenceResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetDateDifferenceResultSet(result);
	}
	
}
