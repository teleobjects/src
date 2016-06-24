package com.temboo.Library.Twilio.AvailablePhoneNumbers;

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
LocalList

Returns a list of local available phone numbers that match the specified filters.
*/
public class LocalList extends Choreography {

	/**
	Create a new instance of the LocalList Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public LocalList(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twilio/AvailablePhoneNumbers/LocalList"));
	}

	/** 
	Set the value of the AccountSID input for this Choreo. 

	@param String - (required, string) The AccountSID provided when you signed up for a Twilio account.
	*/
	public void setAccountSID(String value) {
		this.inputs.setInput("AccountSID", value);
	}


	/** 
	Set the value of the AreaCode input for this Choreo. 

	@param Integer - (optional, integer) Find phone numbers in the specified area code. (US and Canada only).
	*/
	public void setAreaCode(Integer value) {
		this.inputs.setInput("AreaCode", value);
	}

	/** 
	Set the value of the AreaCode input for this Choreo as a String. 

	@param String - (optional, integer) Find phone numbers in the specified area code. (US and Canada only).
	*/
	public void setAreaCode(String value) {
		this.inputs.setInput("AreaCode", value);	
	}
	/** 
	Set the value of the AuthToken input for this Choreo. 

	@param String - (required, string) The authorization token provided when you signed up for a Twilio account.
	*/
	public void setAuthToken(String value) {
		this.inputs.setInput("AuthToken", value);
	}


	/** 
	Set the value of the Contains input for this Choreo. 

	@param String - (optional, string) A pattern to match phone numbers on. Valid characters are '*' and [0-9a-zA-Z]. The '*' character will match any single digit.
	*/
	public void setContains(String value) {
		this.inputs.setInput("Contains", value);
	}


	/** 
	Set the value of the Distance input for this Choreo. 

	@param Integer - (optional, integer) Specifies the search radius for Latitude, Longitude, and NearNumber quires in miles. If not specified this defaults to 25 miles.
	*/
	public void setDistance(Integer value) {
		this.inputs.setInput("Distance", value);
	}

	/** 
	Set the value of the Distance input for this Choreo as a String. 

	@param String - (optional, integer) Specifies the search radius for Latitude, Longitude, and NearNumber quires in miles. If not specified this defaults to 25 miles.
	*/
	public void setDistance(String value) {
		this.inputs.setInput("Distance", value);	
	}
	/** 
	Set the value of the InLata input for this Choreo. 

	@param String - (optional, string) Limit results to a specific Local access and transport area (LATA). Given a phone number, search within the same LATA as that number.
	*/
	public void setInLata(String value) {
		this.inputs.setInput("InLata", value);
	}


	/** 
	Set the value of the InPostalCode input for this Choreo. 

	@param Integer - (optional, integer) Limit results to a particular postal code. Given a phone number, search within the same postal code as that number. (US and Canada only).
	*/
	public void setInPostalCode(Integer value) {
		this.inputs.setInput("InPostalCode", value);
	}

	/** 
	Set the value of the InPostalCode input for this Choreo as a String. 

	@param String - (optional, integer) Limit results to a particular postal code. Given a phone number, search within the same postal code as that number. (US and Canada only).
	*/
	public void setInPostalCode(String value) {
		this.inputs.setInput("InPostalCode", value);	
	}
	/** 
	Set the value of the InRateCenter input for this Choreo. 

	@param String - (optional, string) Limit results to a specific rate center, or given a phone number search within the same rate center as that number. Requires InLata to be set as well.
	*/
	public void setInRateCenter(String value) {
		this.inputs.setInput("InRateCenter", value);
	}


	/** 
	Set the value of the InRegion input for this Choreo. 

	@param String - (optional, string) Limit results to a particular region (i.e. State/Province). Given a phone number, search within the same Region as that number. (US and Canada only).
	*/
	public void setInRegion(String value) {
		this.inputs.setInput("InRegion", value);
	}


	/** 
	Set the value of the IsoCountryCode input for this Choreo. 

	@param String - (optional, string) The country code to search within. Defaults to US.
	*/
	public void setIsoCountryCode(String value) {
		this.inputs.setInput("IsoCountryCode", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) Finds numbers close to this Latitude coordinate. Longitude is also required when searching by coordinates.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (optional, decimal) Finds numbers close to this Latitude coordinate. Longitude is also required when searching by coordinates.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param String - (optional, string) Finds numbers close this Longitude. Latitude is also required when searching by coordinates.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);
	}


	/** 
	Set the value of the NearNumber input for this Choreo. 

	@param String - (optional, string) Searches numbers near  this phone number.
	*/
	public void setNearNumber(String value) {
		this.inputs.setInput("NearNumber", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page of results to retrieve. Defaults to 0.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page of results to retrieve. Defaults to 0.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the PageSize input for this Choreo. 

	@param Integer - (optional, integer) The number of results per page.
	*/
	public void setPageSize(Integer value) {
		this.inputs.setInput("PageSize", value);
	}

	/** 
	Set the value of the PageSize input for this Choreo as a String. 

	@param String - (optional, integer) The number of results per page.
	*/
	public void setPageSize(String value) {
		this.inputs.setInput("PageSize", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public LocalListResultSet run() {
		JSONObject result = super.runWithResults();
		return new LocalListResultSet(result);
	}
	
}
