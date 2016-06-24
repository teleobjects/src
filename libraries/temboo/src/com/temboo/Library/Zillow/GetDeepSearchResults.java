package com.temboo.Library.Zillow;

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
GetDeepSearchResults

Retrieve comprehensive property information for a specified address. 
*/
public class GetDeepSearchResults extends Choreography {

	/**
	Create a new instance of the GetDeepSearchResults Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetDeepSearchResults(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Zillow/GetDeepSearchResults"));
	}

	/** 
	Set the value of the Address input for this Choreo. 

	@param String - (required, string) Enter the address of the property to search.
	*/
	public void setAddress(String value) {
		this.inputs.setInput("Address", value);
	}


	/** 
	Set the value of the City input for this Choreo. 

	@param String - (required, string) Enter a city name.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the RentEstimate input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 (true) to enable. Defaults to 0 (false).
	*/
	public void setRentEstimate(Boolean value) {
		this.inputs.setInput("RentEstimate", value);
	}

	/** 
	Set the value of the RentEstimate input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 (true) to enable. Defaults to 0 (false).
	*/
	public void setRentEstimate(String value) {
		this.inputs.setInput("RentEstimate", value);	
	}
	/** 
	Set the value of the State input for this Choreo. 

	@param String - (required, string) Enter a State abbreviation. If State is set, an entry for City must also be entered.
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	/** 
	Set the value of the ZWSID input for this Choreo. 

	@param String - (required, string) Enter a Zillow Web Service Identifier (ZWS ID).
	*/
	public void setZWSID(String value) {
		this.inputs.setInput("ZWSID", value);
	}


	/** 
	Set the value of the Zipcode input for this Choreo. 

	@param Integer - (required, integer) Enter a zipcode. Can be combined with or without the  City and State input variables.
	*/
	public void setZipcode(Integer value) {
		this.inputs.setInput("Zipcode", value);
	}

	/** 
	Set the value of the Zipcode input for this Choreo as a String. 

	@param String - (required, integer) Enter a zipcode. Can be combined with or without the  City and State input variables.
	*/
	public void setZipcode(String value) {
		this.inputs.setInput("Zipcode", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetDeepSearchResultsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetDeepSearchResultsResultSet(result);
	}
	
}
