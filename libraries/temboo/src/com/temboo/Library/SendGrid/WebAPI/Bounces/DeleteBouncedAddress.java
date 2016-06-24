package com.temboo.Library.SendGrid.WebAPI.Bounces;

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
DeleteBouncedAddress

Delete an address from the bounced email list.
*/
public class DeleteBouncedAddress extends Choreography {

	/**
	Create a new instance of the DeleteBouncedAddress Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DeleteBouncedAddress(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/SendGrid/WebAPI/Bounces/DeleteBouncedAddress"));
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
	Set the value of the EmailAddress input for this Choreo. 

	@param String - (optional, string) The valid email address to be deleted from your block list.
	*/
	public void setEmailAddress(String value) {
		this.inputs.setInput("EmailAddress", value);
	}


	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (optional, string) The end of the date range for which blocks are to be retireved. The specified date must be in YYYY-MM-DD format.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
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
	Set the value of the Type input for this Choreo. 

	@param String - (optional, string) The type of bounce to search for. Choices include: hard, or soft.
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
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
	public DeleteBouncedAddressResultSet run() {
		JSONObject result = super.runWithResults();
		return new DeleteBouncedAddressResultSet(result);
	}
	
}
