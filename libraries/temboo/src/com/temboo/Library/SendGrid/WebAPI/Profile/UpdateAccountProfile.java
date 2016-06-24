package com.temboo.Library.SendGrid.WebAPI.Profile;

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
UpdateAccountProfile

Update a SendGrid account profile.
*/
public class UpdateAccountProfile extends Choreography {

	/**
	Create a new instance of the UpdateAccountProfile Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateAccountProfile(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/SendGrid/WebAPI/Profile/UpdateAccountProfile"));
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
	Set the value of the Address input for this Choreo. 

	@param String - (optional, string) The company address.
	*/
	public void setAddress(String value) {
		this.inputs.setInput("Address", value);
	}


	/** 
	Set the value of the City input for this Choreo. 

	@param String - (optional, string) The city where this address is located in.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the FirstName input for this Choreo. 

	@param String - (optional, string) The first name of the profile being updated.
	*/
	public void setFirstName(String value) {
		this.inputs.setInput("FirstName", value);
	}


	/** 
	Set the value of the LastName input for this Choreo. 

	@param String - (optional, string) The last name of the profile being updated.
	*/
	public void setLastName(String value) {
		this.inputs.setInput("LastName", value);
	}


	/** 
	Set the value of the Phone input for this Choreo. 

	@param String - (optional, string) The phone number, where you can be reached.
	*/
	public void setPhone(String value) {
		this.inputs.setInput("Phone", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format of the response from SendGrid, in either json, or xml.  Default is set to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (optional, string) The state where this company is located in.
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	/** 
	Set the value of the Website input for this Choreo. 

	@param String - (optional, string) The company's website.
	*/
	public void setWebsite(String value) {
		this.inputs.setInput("Website", value);
	}


	/** 
	Set the value of the Zip input for this Choreo. 

	@param String - (optional, string) The zipcode where this company is located.
	*/
	public void setZip(String value) {
		this.inputs.setInput("Zip", value);
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
	public UpdateAccountProfileResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateAccountProfileResultSet(result);
	}
	
}
