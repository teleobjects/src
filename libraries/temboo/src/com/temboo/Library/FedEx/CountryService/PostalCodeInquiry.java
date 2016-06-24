package com.temboo.Library.FedEx.CountryService;

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
PostalCodeInquiry

Retrieves location information from FedEx Web Services for a specified postal code.
*/
public class PostalCodeInquiry extends Choreography {

	/**
	Create a new instance of the PostalCodeInquiry Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PostalCodeInquiry(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/FedEx/CountryService/PostalCodeInquiry"));
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
	Set the value of the CountryCode input for this Choreo. 

	@param String - (required, string) The country code to use in the inquiry request (e.g., US).
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

	@param String - (required, string) The postal code to use in the inquiry request.
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
	Set the value of the ShipDate input for this Choreo. 

	@param String - (optional, string) The ship date to use for the inquiry. Dates should be formatted as YYYY-MM-DD. Defautls to today's date.
	*/
	public void setShipDate(String value) {
		this.inputs.setInput("ShipDate", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PostalCodeInquiryResultSet run() {
		JSONObject result = super.runWithResults();
		return new PostalCodeInquiryResultSet(result);
	}
	
}
