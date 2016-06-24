package com.temboo.Library.FedEx.Locations;

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
SearchLocationsByAddress

Searches for FedEx locations near a given address.
*/
public class SearchLocationsByAddress extends Choreography {

	/**
	Create a new instance of the SearchLocationsByAddress Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchLocationsByAddress(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/FedEx/Locations/SearchLocationsByAddress"));
	}

	/** 
	Set the value of the AccountNumber input for this Choreo. 

	@param String - (required, string) Your FedEx Account Number or Test Account Number.
	*/
	public void setAccountNumber(String value) {
		this.inputs.setInput("AccountNumber", value);
	}


	/** 
	Set the value of the AuthenticationKey input for this Choreo. 

	@param String - (required, string) The Production Authentication Key or Development Test Key provided by FedEx Web Services.
	*/
	public void setAuthenticationKey(String value) {
		this.inputs.setInput("AuthenticationKey", value);
	}


	/** 
	Set the value of the City input for this Choreo. 

	@param String - (required, string) The city associated with the location being searched.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the CountryCode input for this Choreo. 

	@param String - (required, string) The country code associated with the location being searched (e.g., US).
	*/
	public void setCountryCode(String value) {
		this.inputs.setInput("CountryCode", value);
	}


	/** 
	Set the value of the Endpoint input for this Choreo. 

	@param String - (conditional, string) Set to "test" to direct requests to the FedEx test environment. Defaults to "production" indicating that requests are sent to the production URL.
	*/
	public void setEndpoint(String value) {
		this.inputs.setInput("Endpoint", value);
	}


	/** 
	Set the value of the MeterNumber input for this Choreo. 

	@param String - (required, string) The Production or Test Meter Number provided by FedEx Web Services.
	*/
	public void setMeterNumber(String value) {
		this.inputs.setInput("MeterNumber", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The Production or Test Password provided by FedEx Web Services.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the PostalCode input for this Choreo. 

	@param String - (required, string) The postal code associated with the location being searched.
	*/
	public void setPostalCode(String value) {
		this.inputs.setInput("PostalCode", value);
	}


	/** 
	Set the value of the RadiusDistance input for this Choreo. 

	@param BigDecimal - (optional, decimal) Specifies value of the radius around the address to search for FedEx locations. Note that RadiusUnits applies to this value. Defaults to 10 miles.
	*/
	public void setRadiusDistance(BigDecimal value) {
		this.inputs.setInput("RadiusDistance", value);
	}

	/** 
	Set the value of the RadiusDistance input for this Choreo as a String. 

	@param String - (optional, decimal) Specifies value of the radius around the address to search for FedEx locations. Note that RadiusUnits applies to this value. Defaults to 10 miles.
	*/
	public void setRadiusDistance(String value) {
		this.inputs.setInput("RadiusDistance", value);	
	}
	/** 
	Set the value of the RadiusUnits input for this Choreo. 

	@param String - (optional, string) Specifies the unit of measure for the RadiusDistance value. Valid values are mi (the default) and km.
	*/
	public void setRadiusUnits(String value) {
		this.inputs.setInput("RadiusUnits", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SortBy input for this Choreo. 

	@param String - (optional, string) Specifies the criterion to be used to sort the location details. Valid values are: distance (the default), latest_express_dropoff_time, latest_ground_dropoff_time, location_type.
	*/
	public void setSortBy(String value) {
		this.inputs.setInput("SortBy", value);
	}


	/** 
	Set the value of the SortOrder input for this Choreo. 

	@param String - (optional, string) Specifies sort order of the location details. Valid values are: lowest_to_highest (the default) and highest_to_lowest.
	*/
	public void setSortOrder(String value) {
		this.inputs.setInput("SortOrder", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (required, string) Identifying abbreviation for US state, Canada province (e.g., NY).
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	/** 
	Set the value of the Street input for this Choreo. 

	@param String - (required, string) The street number and street name (e.g., 350 5th Ave).
	*/
	public void setStreet(String value) {
		this.inputs.setInput("Street", value);
	}


	/** 
	Set the value of the SupportedServices input for this Choreo. 

	@param String - (optional, string) Specifies the types of services supported by a FedEx location for redirect to hold. Valid values are: fedex_express, fedex_ground, fedex_ground_home_delivery.
	*/
	public void setSupportedServices(String value) {
		this.inputs.setInput("SupportedServices", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchLocationsByAddressResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchLocationsByAddressResultSet(result);
	}
	
}
