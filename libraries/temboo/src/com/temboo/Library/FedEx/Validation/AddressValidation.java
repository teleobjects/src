package com.temboo.Library.FedEx.Validation;

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
AddressValidation

Validates a given address.
*/
public class AddressValidation extends Choreography {

	/**
	Create a new instance of the AddressValidation Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddressValidation(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/FedEx/Validation/AddressValidation"));
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

	@param String - (conditional, string) The name of the city or town.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the ClientReferenceID input for this Choreo. 

	@param String - (optional, string) A reference id provided by the client.
	*/
	public void setClientReferenceID(String value) {
		this.inputs.setInput("ClientReferenceID", value);
	}


	/** 
	Set the value of the CompanyName input for this Choreo. 

	@param String - (optional, string) Identifies the company associated with the location.
	*/
	public void setCompanyName(String value) {
		this.inputs.setInput("CompanyName", value);
	}


	/** 
	Set the value of the CountryCode input for this Choreo. 

	@param String - (conditional, string) The country code associated with the address being validated (e.g., US).
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
	Set the value of the PhoneNumber input for this Choreo. 

	@param String - (optional, string) Identifies the phone number associated with the contact being validated.
	*/
	public void setPhoneNumber(String value) {
		this.inputs.setInput("PhoneNumber", value);
	}


	/** 
	Set the value of the PostalCode input for this Choreo. 

	@param String - (conditional, string) The postal code associated with the address being validated.
	*/
	public void setPostalCode(String value) {
		this.inputs.setInput("PostalCode", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (conditional, string) Identifying abbreviation for US state, Canada province (e.g., NY).
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	/** 
	Set the value of the Street input for this Choreo. 

	@param String - (conditional, string) The street number and street name (e.g., 350 5th Ave).
	*/
	public void setStreet(String value) {
		this.inputs.setInput("Street", value);
	}


	/** 
	Set the value of the UrbanizationCode input for this Choreo. 

	@param String - (optional, string) Relevant only to addresses in Puerto Rico.
	*/
	public void setUrbanizationCode(String value) {
		this.inputs.setInput("UrbanizationCode", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddressValidationResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddressValidationResultSet(result);
	}
	
}
