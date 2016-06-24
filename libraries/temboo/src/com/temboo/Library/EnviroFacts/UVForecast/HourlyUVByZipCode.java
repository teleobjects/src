package com.temboo.Library.EnviroFacts.UVForecast;

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
HourlyUVByZipCode

Retrieves EPA hourly Ultraviolet (UV) Index readings in a given zip code.
*/
public class HourlyUVByZipCode extends Choreography {

	/**
	Create a new instance of the HourlyUVByZipCode Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public HourlyUVByZipCode(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/EnviroFacts/UVForecast/HourlyUVByZipCode"));
	}

	/** 
	Set the value of the ResponseType input for this Choreo. 

	@param String - (optional, string) Results can be retrieved in either JSON or XML. Defaults to XML.
	*/
	public void setResponseType(String value) {
		this.inputs.setInput("ResponseType", value);
	}


	/** 
	Set the value of the Zip input for this Choreo. 

	@param Integer - (required, integer) A valid United States Postal Service (USPS) ZIP Code or Postal Code.
	*/
	public void setZip(Integer value) {
		this.inputs.setInput("Zip", value);
	}

	/** 
	Set the value of the Zip input for this Choreo as a String. 

	@param String - (required, integer) A valid United States Postal Service (USPS) ZIP Code or Postal Code.
	*/
	public void setZip(String value) {
		this.inputs.setInput("Zip", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public HourlyUVByZipCodeResultSet run() {
		JSONObject result = super.runWithResults();
		return new HourlyUVByZipCodeResultSet(result);
	}
	
}
