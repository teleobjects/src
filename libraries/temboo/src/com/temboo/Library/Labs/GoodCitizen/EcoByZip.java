package com.temboo.Library.Labs.GoodCitizen;

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
EcoByZip

Returns a host of eco-conscious environmental information for a specified location based on zip code.
*/
public class EcoByZip extends Choreography {

	/**
	Create a new instance of the EcoByZip Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public EcoByZip(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Labs/GoodCitizen/EcoByZip"));
	}

	/** 
	Set the value of the APICredentials input for this Choreo. 

	@param String - (optional, string) A JSON dictionary containing credentials for Genability. See Choreo documentation for formatting examples.
	*/
	public void setAPICredentials(String value) {
		this.inputs.setInput("APICredentials", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of facility records to search for in the Envirofacts database.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of facility records to search for in the Envirofacts database.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Zip input for this Choreo. 

	@param Integer - (required, integer) The zip code for the user's current location.
	*/
	public void setZip(Integer value) {
		this.inputs.setInput("Zip", value);
	}

	/** 
	Set the value of the Zip input for this Choreo as a String. 

	@param String - (required, integer) The zip code for the user's current location.
	*/
	public void setZip(String value) {
		this.inputs.setInput("Zip", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public EcoByZipResultSet run() {
		JSONObject result = super.runWithResults();
		return new EcoByZipResultSet(result);
	}
	
}
