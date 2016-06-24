package com.temboo.Library.SendGrid.WebAPI.InvalidEmails;

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
RetrieveInvalidEmails

Retrieve a list of invalid emails with addresses, response codes, and dates.
*/
public class RetrieveInvalidEmails extends Choreography {

	/**
	Create a new instance of the RetrieveInvalidEmails Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrieveInvalidEmails(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/SendGrid/WebAPI/InvalidEmails/RetrieveInvalidEmails"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key obtained from SendGrid.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APIUser input for this Choreo. 

	@param String - (required, string) The username registered with SendGrid.
	*/
	public void setAPIUser(String value) {
		this.inputs.setInput("APIUser", value);
	}


	/** 
	Set the value of the Date input for this Choreo. 

	@param String - (optional, string) The timestamp of the Block records. Enter 1 to return a date in a MySQL timestamp format - YYYY-MM-DD HH:MM:SS
	*/
	public void setDate(String value) {
		this.inputs.setInput("Date", value);
	}


	/** 
	Set the value of the Days input for this Choreo. 

	@param Integer - (optional, integer) The number of days (greater than 0) for which block data will be retrieved.
	*/
	public void setDays(Integer value) {
		this.inputs.setInput("Days", value);
	}

	/** 
	Set the value of the Days input for this Choreo as a String. 

	@param String - (optional, integer) The number of days (greater than 0) for which block data will be retrieved.
	*/
	public void setDays(String value) {
		this.inputs.setInput("Days", value);	
	}
	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (optional, string) The email to search for.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (optional, string) The end of the date range for which blocks are to be retireved. The specified date must be in YYYY-MM-DD format.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number to limit the number of results returned.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number to limit the number of results returned.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) The beginning point in the list to retrieve bounces from.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) The beginning point in the list to retrieve bounces from.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format of the response from SendGrid, in either json, or xml.  Default is set to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (optional, string) The start of the date range for which blocks are to be retireved. The specified date must be in YYYY-MM-DD format, and must be earlier than the EndDate variable value.
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - 
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrieveInvalidEmailsResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrieveInvalidEmailsResultSet(result);
	}
	
}
