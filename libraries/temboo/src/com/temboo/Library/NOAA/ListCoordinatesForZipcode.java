package com.temboo.Library.NOAA;

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
ListCoordinatesForZipcode

Retrieve latitude and longitude data for a specified zipcode (in 50 U.S. States and Puerto Rico).
*/
public class ListCoordinatesForZipcode extends Choreography {

	/**
	Create a new instance of the ListCoordinatesForZipcode Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListCoordinatesForZipcode(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NOAA/ListCoordinatesForZipcode"));
	}

	/** 
	Set the value of the ListZipCodeList input for this Choreo. 

	@param Integer - (integer) Enter the zipcode for which latitude and longitude coordinates will be retrieved.
	*/
	public void setListZipCodeList(Integer value) {
		this.inputs.setInput("ListZipCodeList", value);
	}

	/** 
	Set the value of the ListZipCodeList input for this Choreo as a String. 

	@param String - (integer) Enter the zipcode for which latitude and longitude coordinates will be retrieved.
	*/
	public void setListZipCodeList(String value) {
		this.inputs.setInput("ListZipCodeList", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListCoordinatesForZipcodeResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListCoordinatesForZipcodeResultSet(result);
	}
	
}
