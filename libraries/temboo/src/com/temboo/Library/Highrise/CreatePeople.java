package com.temboo.Library.Highrise;

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
CreatePeople

Creates a new contact record in your Highrise CRM.
*/
public class CreatePeople extends Choreography {

	/**
	Create a new instance of the CreatePeople Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreatePeople(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Highrise/CreatePeople"));
	}

	/** 
	Set the value of the AccountName input for this Choreo. 

	@param String - (required, string) A valid Highrise account name. This is the first part of the account's URL.
	*/
	public void setAccountName(String value) {
		this.inputs.setInput("AccountName", value);
	}


	/** 
	Set the value of the Background input for this Choreo. 

	@param String - (optional, string) Corresponds to the background field in Highrise
	*/
	public void setBackground(String value) {
		this.inputs.setInput("Background", value);
	}


	/** 
	Set the value of the CompanyName input for this Choreo. 

	@param String - (optional, string) Corresponds to the company name field in Highrise.
	*/
	public void setCompanyName(String value) {
		this.inputs.setInput("CompanyName", value);
	}


	/** 
	Set the value of the EmailAddress input for this Choreo. 

	@param String - (optional, string) Corresponds to the email address field in Highrise.
	*/
	public void setEmailAddress(String value) {
		this.inputs.setInput("EmailAddress", value);
	}


	/** 
	Set the value of the FirstName input for this Choreo. 

	@param String - (required, string) Corresponds to the first name field in Highrise.
	*/
	public void setFirstName(String value) {
		this.inputs.setInput("FirstName", value);
	}


	/** 
	Set the value of the HomePhone input for this Choreo. 

	@param String - (optional, string) Corresponds to the home phone field in Highrise.
	*/
	public void setHomePhone(String value) {
		this.inputs.setInput("HomePhone", value);
	}


	/** 
	Set the value of the LastName input for this Choreo. 

	@param String - (optional, string) Corresponds to the last name field in Highrise.
	*/
	public void setLastName(String value) {
		this.inputs.setInput("LastName", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The Highrise account password. Use the value 'X' when specifying an API Key for the Username input.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Title input for this Choreo. 

	@param String - (optional, string) Corresponds to the title field in Highrise.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) A Highrise account username or API Key.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	/** 
	Set the value of the WorkPhone input for this Choreo. 

	@param String - (optional, string) Corresponds to the work phone field in Highrise.
	*/
	public void setWorkPhone(String value) {
		this.inputs.setInput("WorkPhone", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreatePeopleResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreatePeopleResultSet(result);
	}
	
}
