package com.temboo.Library.Zoho.CRM;

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
GetSearchRecords

Lets you to search your Zoho CRM account for records based on Zoho's search expressions.
*/
public class GetSearchRecords extends Choreography {

	/**
	Create a new instance of the GetSearchRecords Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetSearchRecords(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Zoho/CRM/GetSearchRecords"));
	}

	/** 
	Set the value of the AuthenticationToken input for this Choreo. 

	@param String - (required, string) A valid authentication token. Permanent authentication tokens can be generated by the GenerateAuthToken Choreo.
	*/
	public void setAuthenticationToken(String value) {
		this.inputs.setInput("AuthenticationToken", value);
	}


	/** 
	Set the value of the FromIndex input for this Choreo. 

	@param Integer - (optional, integer) The beginning index of the result set to return. Defaults to 1.
	*/
	public void setFromIndex(Integer value) {
		this.inputs.setInput("FromIndex", value);
	}

	/** 
	Set the value of the FromIndex input for this Choreo as a String. 

	@param String - (optional, integer) The beginning index of the result set to return. Defaults to 1.
	*/
	public void setFromIndex(String value) {
		this.inputs.setInput("FromIndex", value);	
	}
	/** 
	Set the value of the Module input for this Choreo. 

	@param String - (optional, string) The Zoho module you want to access. Defaults to 'Leads'.
	*/
	public void setModule(String value) {
		this.inputs.setInput("Module", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid formats are: json and xml (the default).
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SearchColumn input for this Choreo. 

	@param String - (required, string) Specify the name of the column you want to search (i.e. Email)
	*/
	public void setSearchColumn(String value) {
		this.inputs.setInput("SearchColumn", value);
	}


	/** 
	Set the value of the SearchExpression input for this Choreo. 

	@param String - (required, string) Specify an expression to use in your search (i.e. =, <>, contains, starts with, ends with, doesn't contain, <, >, <=, =>)
	*/
	public void setSearchExpression(String value) {
		this.inputs.setInput("SearchExpression", value);
	}


	/** 
	Set the value of the SearchString input for this Choreo. 

	@param String - (required, string) Specify a search string to use in the search (i.e. *gmail.com*)
	*/
	public void setSearchString(String value) {
		this.inputs.setInput("SearchString", value);
	}


	/** 
	Set the value of the SelectColumns input for this Choreo. 

	@param String - (optional, string) The columns to return separated by commas (i.e. First Name,Last Name,Email). When left empty, only IDs are returned.
	*/
	public void setSelectColumns(String value) {
		this.inputs.setInput("SelectColumns", value);
	}


	/** 
	Set the value of the ToIndex input for this Choreo. 

	@param Integer - (optional, integer) The ending index of the result set to return. Defaults to 20. Max is 200.
	*/
	public void setToIndex(Integer value) {
		this.inputs.setInput("ToIndex", value);
	}

	/** 
	Set the value of the ToIndex input for this Choreo as a String. 

	@param String - (optional, integer) The ending index of the result set to return. Defaults to 20. Max is 200.
	*/
	public void setToIndex(String value) {
		this.inputs.setInput("ToIndex", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetSearchRecordsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetSearchRecordsResultSet(result);
	}
	
}
