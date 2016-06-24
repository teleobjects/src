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
SearchPeople

Lets you search your Highrise CRM by specifying an email search criteria.
*/
public class SearchPeople extends Choreography {

	/**
	Create a new instance of the SearchPeople Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchPeople(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Highrise/SearchPeople"));
	}

	/** 
	Set the value of the AccountName input for this Choreo. 

	@param String - (required, string) A valid Highrise account name. This is the first part of the account's URL.
	*/
	public void setAccountName(String value) {
		this.inputs.setInput("AccountName", value);
	}


	/** 
	Set the value of the City input for this Choreo. 

	@param String - (optional, string) Allows you to search by the city field in Highrise.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the Country input for this Choreo. 

	@param String - (optional, string) Allows you to search by the country field in Highrise.
	*/
	public void setCountry(String value) {
		this.inputs.setInput("Country", value);
	}


	/** 
	Set the value of the EmailAddress input for this Choreo. 

	@param String - (optional, string) Allows you to search by the email address field in Highrise.
	*/
	public void setEmailAddress(String value) {
		this.inputs.setInput("EmailAddress", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The Highrise account password. Use the value 'X' when specifying an API Key for the Username input.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Phone input for this Choreo. 

	@param String - (optional, string) Allows you to search by the phone field in Highrise.
	*/
	public void setPhone(String value) {
		this.inputs.setInput("Phone", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (optional, string) Allows you to search by the state field in Highrise.
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) A Highrise account username or API Key.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	/** 
	Set the value of the Zip input for this Choreo. 

	@param String - (optional, string) Allows you to search by the ZIP field in Highrise.
	*/
	public void setZip(String value) {
		this.inputs.setInput("Zip", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchPeopleResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchPeopleResultSet(result);
	}
	
}
