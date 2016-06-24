package com.temboo.Library.OneLogin.Accounts;

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
CreateAccount

Creates a new account.
*/
public class CreateAccount extends Choreography {

	/**
	Create a new instance of the CreateAccount Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateAccount(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/OneLogin/Accounts/CreateAccount"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by OneLogin.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AccountName input for this Choreo. 

	@param String - (required, string) The account name.
	*/
	public void setAccountName(String value) {
		this.inputs.setInput("AccountName", value);
	}


	/** 
	Set the value of the Address input for this Choreo. 

	@param String - (optional, string) The street address for the new account.
	*/
	public void setAddress(String value) {
		this.inputs.setInput("Address", value);
	}


	/** 
	Set the value of the City input for this Choreo. 

	@param String - (optional, string) The city associated with the address.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the Country input for this Choreo. 

	@param String - (optional, string) The country associated with the address of the new account.
	*/
	public void setCountry(String value) {
		this.inputs.setInput("Country", value);
	}


	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (required, string) The email address for the new account.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the FirstName input for this Choreo. 

	@param String - (required, string) The first name on the new account.
	*/
	public void setFirstName(String value) {
		this.inputs.setInput("FirstName", value);
	}


	/** 
	Set the value of the LastName input for this Choreo. 

	@param String - (required, string) The last name on the new account.
	*/
	public void setLastName(String value) {
		this.inputs.setInput("LastName", value);
	}


	/** 
	Set the value of the Phone input for this Choreo. 

	@param String - (optional, string) The phone number for the new account.
	*/
	public void setPhone(String value) {
		this.inputs.setInput("Phone", value);
	}


	/** 
	Set the value of the Plan input for this Choreo. 

	@param String - (required, string) Indicates which plan the new account has (i.e. enterprise).
	*/
	public void setPlan(String value) {
		this.inputs.setInput("Plan", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (optional, string) The state associated with the address of the new account.
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	/** 
	Set the value of the Zip input for this Choreo. 

	@param String - (optional, string) The postal code associated with the address of the new account.
	*/
	public void setZip(String value) {
		this.inputs.setInput("Zip", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateAccountResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateAccountResultSet(result);
	}
	
}
