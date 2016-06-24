package com.temboo.Library.CorpWatch.Company;

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
GetCompanyByEIN

Returns a company record for a given IRS Employer Identification Number (tax ID).
*/
public class GetCompanyByEIN extends Choreography {

	/**
	Create a new instance of the GetCompanyByEIN Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetCompanyByEIN(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/CorpWatch/Company/GetCompanyByEIN"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (optional, string) The APIKey from CorpWatch if you have one.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the EIN input for this Choreo. 

	@param String - (required, string) The IRS Employer Identification Number (tax ID) of a company.
	*/
	public void setEIN(String value) {
		this.inputs.setInput("EIN", value);
	}


	/** 
	Set the value of the Index input for this Choreo. 

	@param Integer - (optional, integer) Set the index number of the first result to be returned. The index of the first result is 0.
	*/
	public void setIndex(Integer value) {
		this.inputs.setInput("Index", value);
	}

	/** 
	Set the value of the Index input for this Choreo as a String. 

	@param String - (optional, integer) Set the index number of the first result to be returned. The index of the first result is 0.
	*/
	public void setIndex(String value) {
		this.inputs.setInput("Index", value);	
	}
	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of results to be returned. Defaults to 100. Maximum is 5000.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to be returned. Defaults to 100. Maximum is 5000.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the ResponseType input for this Choreo. 

	@param String - (optional, string) Specify json or xml for the type of response to be returned. Defaults to xml.
	*/
	public void setResponseType(String value) {
		this.inputs.setInput("ResponseType", value);
	}


	/** 
	Set the value of the Year input for this Choreo. 

	@param Integer - (optional, integer) If a year is specified, only records for that year will be returned and the data in the company objects returned will be set appropriately for the request year. Defaults to most recent.
	*/
	public void setYear(Integer value) {
		this.inputs.setInput("Year", value);
	}

	/** 
	Set the value of the Year input for this Choreo as a String. 

	@param String - (optional, integer) If a year is specified, only records for that year will be returned and the data in the company objects returned will be set appropriately for the request year. Defaults to most recent.
	*/
	public void setYear(String value) {
		this.inputs.setInput("Year", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetCompanyByEINResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetCompanyByEINResultSet(result);
	}
	
}
