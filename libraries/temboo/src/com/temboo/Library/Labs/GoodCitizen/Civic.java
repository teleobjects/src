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
Civic

Retrieves a host of information about the district and representatives of a specified location.
*/
public class Civic extends Choreography {

	/**
	Create a new instance of the Civic Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Civic(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Labs/GoodCitizen/Civic"));
	}

	/** 
	Set the value of the APICredentials input for this Choreo. 

	@param String - (conditional, json) A JSON dictionary containing credentials for Sunlight Labs and LittleSis. If this input is set, a Sunset Labs key must be present. See Choreo notes for formatting examples.
	*/
	public void setAPICredentials(String value) {
		this.inputs.setInput("APICredentials", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The latitude coordinate of your location.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (required, decimal) The latitude coordinate of your location.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Set the number of records to return for the bills, votes, and relationships of each legislator. Defaults to 5.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Set the number of records to return for the bills, votes, and relationships of each legislator. Defaults to 5.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The longitude coordinate of your locaion.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (required, decimal) The longitude coordinate of your locaion.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CivicResultSet run() {
		JSONObject result = super.runWithResults();
		return new CivicResultSet(result);
	}
	
}
