package com.temboo.Library.ConstantContact;

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
CreateContact

Creates a contact in your Constant Contact account.
*/
public class CreateContact extends Choreography {

	/**
	Create a new instance of the CreateContact Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateContact(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/ConstantContact/CreateContact"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Constant Contact.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Addr1 input for this Choreo. 

	@param String - (optional, string) The first line of the contact's address.
	*/
	public void setAddr1(String value) {
		this.inputs.setInput("Addr1", value);
	}


	/** 
	Set the value of the Addr2 input for this Choreo. 

	@param String - (optional, string) The second line of the contact's address.
	*/
	public void setAddr2(String value) {
		this.inputs.setInput("Addr2", value);
	}


	/** 
	Set the value of the Addr3 input for this Choreo. 

	@param String - (optional, string) The third line of the contact's address.
	*/
	public void setAddr3(String value) {
		this.inputs.setInput("Addr3", value);
	}


	/** 
	Set the value of the City input for this Choreo. 

	@param String - (optional, string) The city portion of the contact's address.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the CompanyName input for this Choreo. 

	@param String - (optional, string) The company name for the contact.
	*/
	public void setCompanyName(String value) {
		this.inputs.setInput("CompanyName", value);
	}


	/** 
	Set the value of the CountryCode input for this Choreo. 

	@param String - (optional, string) The country code associated with the contact's address.
	*/
	public void setCountryCode(String value) {
		this.inputs.setInput("CountryCode", value);
	}


	/** 
	Set the value of the CountryName input for this Choreo. 

	@param String - (optional, string) Corresponds to the Country Name field in Constant Contact
	*/
	public void setCountryName(String value) {
		this.inputs.setInput("CountryName", value);
	}


	/** 
	Set the value of the EmailAddress input for this Choreo. 

	@param String - (required, string) The email address for the contact.
	*/
	public void setEmailAddress(String value) {
		this.inputs.setInput("EmailAddress", value);
	}


	/** 
	Set the value of the EmailType input for this Choreo. 

	@param String - (optional, string) The email type that the contact should receive.
	*/
	public void setEmailType(String value) {
		this.inputs.setInput("EmailType", value);
	}


	/** 
	Set the value of the FirstName input for this Choreo. 

	@param String - (optional, string) The first name of the contact.
	*/
	public void setFirstName(String value) {
		this.inputs.setInput("FirstName", value);
	}


	/** 
	Set the value of the HomePhone input for this Choreo. 

	@param String - (optional, string) The contact's home phone.
	*/
	public void setHomePhone(String value) {
		this.inputs.setInput("HomePhone", value);
	}


	/** 
	Set the value of the JobTitle input for this Choreo. 

	@param String - (optional, string) The contact's job title.
	*/
	public void setJobTitle(String value) {
		this.inputs.setInput("JobTitle", value);
	}


	/** 
	Set the value of the LastName input for this Choreo. 

	@param String - (optional, string) The last name of the contact.
	*/
	public void setLastName(String value) {
		this.inputs.setInput("LastName", value);
	}


	/** 
	Set the value of the ListId input for this Choreo. 

	@param Integer - (required, integer) The ID for the list that you want to add the contact to.
	*/
	public void setListId(Integer value) {
		this.inputs.setInput("ListId", value);
	}

	/** 
	Set the value of the ListId input for this Choreo as a String. 

	@param String - (required, integer) The ID for the list that you want to add the contact to.
	*/
	public void setListId(String value) {
		this.inputs.setInput("ListId", value);	
	}
	/** 
	Set the value of the MiddleName input for this Choreo. 

	@param String - (optional, string) The middle name of the contact.
	*/
	public void setMiddleName(String value) {
		this.inputs.setInput("MiddleName", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (optional, string) The full name of the contact.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the Note input for this Choreo. 

	@param String - (optional, string) A note associated with the contact.
	*/
	public void setNote(String value) {
		this.inputs.setInput("Note", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) Your Constant Contact password.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the PostalCode input for this Choreo. 

	@param String - (optional, string) The postal code for the contact's address.
	*/
	public void setPostalCode(String value) {
		this.inputs.setInput("PostalCode", value);
	}


	/** 
	Set the value of the StateCode input for this Choreo. 

	@param String - (optional, string) The state code for the contact's address.
	*/
	public void setStateCode(String value) {
		this.inputs.setInput("StateCode", value);
	}


	/** 
	Set the value of the StateName input for this Choreo. 

	@param String - (optional, string) Corresponds to the State Name field in Constant Contact
	*/
	public void setStateName(String value) {
		this.inputs.setInput("StateName", value);
	}


	/** 
	Set the value of the Status input for this Choreo. 

	@param String - (optional, string) The status of the contact (i.e. Active).
	*/
	public void setStatus(String value) {
		this.inputs.setInput("Status", value);
	}


	/** 
	Set the value of the SubPostalCode input for this Choreo. 

	@param String - (optional, string) The sub postal code for the contact.
	*/
	public void setSubPostalCode(String value) {
		this.inputs.setInput("SubPostalCode", value);
	}


	/** 
	Set the value of the UserName input for this Choreo. 

	@param String - (required, string) Your Constant Contact username.
	*/
	public void setUserName(String value) {
		this.inputs.setInput("UserName", value);
	}


	/** 
	Set the value of the WorkPhone input for this Choreo. 

	@param String - (optional, string) The contact's work phone.
	*/
	public void setWorkPhone(String value) {
		this.inputs.setInput("WorkPhone", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateContactResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateContactResultSet(result);
	}
	
}
