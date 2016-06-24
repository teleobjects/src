package com.temboo.Library.USPS.AddressInformationAPI;

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
CityStateLookup

Lookup city and state using incomplete address information.
*/
public class CityStateLookup extends Choreography {

	/**
	Create a new instance of the CityStateLookup Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CityStateLookup(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/USPS/AddressInformationAPI/CityStateLookup"));
	}

	/** 
	Set the value of the Endpoint input for this Choreo. 

	@param String - (optional, string) If you are accessing the production server, set to 'production'. Defaults to 'testing' which indicates that you are using the sandbox.
	*/
	public void setEndpoint(String value) {
		this.inputs.setInput("Endpoint", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The password assigned by USPS
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the UserId input for this Choreo. 

	@param String - (required, string) Alphanumeric ID assigned by USPS
	*/
	public void setUserId(String value) {
		this.inputs.setInput("UserId", value);
	}


	/** 
	Set the value of the Zip input for this Choreo. 

	@param Integer - (required, integer) Maximum characters allowed: 5
	*/
	public void setZip(Integer value) {
		this.inputs.setInput("Zip", value);
	}

	/** 
	Set the value of the Zip input for this Choreo as a String. 

	@param String - (required, integer) Maximum characters allowed: 5
	*/
	public void setZip(String value) {
		this.inputs.setInput("Zip", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CityStateLookupResultSet run() {
		JSONObject result = super.runWithResults();
		return new CityStateLookupResultSet(result);
	}
	
}
