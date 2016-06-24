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
TollFreeList

Returns a list of toll-free available phone numbers that match the specified filters.
*/
public class TollFreeList extends Choreography {

	/**
	Create a new instance of the TollFreeList Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public TollFreeList(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twilio/AvailablePhoneNumbers/TollFreeList"));
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
	Set the value of the IsoCountryCode input for this Choreo. 

	@param String - (optional, string) The country code to search within. Defaults to US.
	*/
	public void setIsoCountryCode(String value) {
		this.inputs.setInput("IsoCountryCode", value);
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
	public TollFreeListResultSet run() {
		JSONObject result = super.runWithResults();
		return new TollFreeListResultSet(result);
	}
	
}
