package com.temboo.Library.FedEx.TrackingAndVisibility;

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
TrackByReference

Retrieves shipment information for a specified reference number.
*/
public class TrackByReference extends Choreography {

	/**
	Create a new instance of the TrackByReference Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public TrackByReference(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/FedEx/TrackingAndVisibility/TrackByReference"));
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

	@param String - (optional, string) The destination city.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the CountryCode input for this Choreo. 

	@param String - (conditional, string) The country code associated with the shipment destination (e.g., US). Required unless specifying the ShipmentAccountNumber.
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
	Set the value of the OperatingCompany input for this Choreo. 

	@param String - (required, string) Identification for a fedex operating company (e.g.,  fedex_express, fedex_freight, fedex_ground). See Choreo notes for allowed values.
	*/
	public void setOperatingCompany(String value) {
		this.inputs.setInput("OperatingCompany", value);
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

	@param String - (conditional, string) The postal code associated with the shipment destination. Required unless specifying the ShipmentAccountNumber.
	*/
	public void setPostalCode(String value) {
		this.inputs.setInput("PostalCode", value);
	}


	/** 
	Set the value of the Reference input for this Choreo. 

	@param String - (required, string) A reference number for tracking the shipment.
	*/
	public void setReference(String value) {
		this.inputs.setInput("Reference", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the ShipDateRangeBegin input for this Choreo. 

	@param String - (optional, date) Specifies the beginning of a date range used to narrow the search to a period in time. Dates should be formatted as YYYY-MM-DD.
	*/
	public void setShipDateRangeBegin(String value) {
		this.inputs.setInput("ShipDateRangeBegin", value);
	}


	/** 
	Set the value of the ShipDateRangeEnd input for this Choreo. 

	@param String - (optional, date) Specifies the beginning of a date range used to narrow the search to a period in time. Dates should be formatted as YYYY-MM-DD.
	*/
	public void setShipDateRangeEnd(String value) {
		this.inputs.setInput("ShipDateRangeEnd", value);
	}


	/** 
	Set the value of the ShipmentAccountNumber input for this Choreo. 

	@param String - (conditional, string) The shipment account number. Required unless specifying the PostalCode and CountryCode.
	*/
	public void setShipmentAccountNumber(String value) {
		this.inputs.setInput("ShipmentAccountNumber", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (optional, string) Identifying abbreviation for US state, Canada province of the shipment destination (e.g., NY).
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	/** 
	Set the value of the Street input for this Choreo. 

	@param String - (optional, string) The street number and street name for the shipment destination (e.g., 350 5th Ave).
	*/
	public void setStreet(String value) {
		this.inputs.setInput("Street", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public TrackByReferenceResultSet run() {
		JSONObject result = super.runWithResults();
		return new TrackByReferenceResultSet(result);
	}
	
}
