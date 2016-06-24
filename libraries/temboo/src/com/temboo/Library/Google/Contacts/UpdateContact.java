package com.temboo.Library.Google.Contacts;

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
UpdateContact

Update an existing contact's information.
*/
public class UpdateContact extends Choreography {

	/**
	Create a new instance of the UpdateContact Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateContact(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Contacts/UpdateContact"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) The access token retrieved in the last step of the OAuth process. Access tokens that are expired will be refreshed and returned in the Choreo output.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The OAuth client ID provided by Google when you register your application.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The OAuth client secret provided by Google when you registered your application.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the ID input for this Choreo. 

	@param String - (conditional, string) The id of the contact to update. Required unless providing a value for the Query input.
	*/
	public void setID(String value) {
		this.inputs.setInput("ID", value);
	}


	/** 
	Set the value of the NewEmail input for this Choreo. 

	@param String - (conditional, string) The contact's new email address.
	*/
	public void setNewEmail(String value) {
		this.inputs.setInput("NewEmail", value);
	}


	/** 
	Set the value of the NewFirstName input for this Choreo. 

	@param String - (conditional, string) The contact's new first name.
	*/
	public void setNewFirstName(String value) {
		this.inputs.setInput("NewFirstName", value);
	}


	/** 
	Set the value of the NewLastName input for this Choreo. 

	@param String - (conditional, string) The contact's new last name.
	*/
	public void setNewLastName(String value) {
		this.inputs.setInput("NewLastName", value);
	}


	/** 
	Set the value of the NewPhone input for this Choreo. 

	@param String - (optional, string) The contact's new telephone number.
	*/
	public void setNewPhone(String value) {
		this.inputs.setInput("NewPhone", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (conditional, string) A search term to retrieve the contact to update, such as an email address, last name, or address. Required unless providing a value for the ID input.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) The refresh token retrieved in the last step of the OAuth process. This is used when an access token is expired or not provided.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateContactResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateContactResultSet(result);
	}
	
}
