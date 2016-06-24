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
GetContactById

Retrieves a specific contact with a given id.
*/
public class GetContactById extends Choreography {

	/**
	Create a new instance of the GetContactById Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetContactById(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Contacts/GetContactById"));
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

	@param String - (required, string) The client ID provided by Google when you register your application.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (required, string) The client secret provided by Google when you registered your application.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the ContactId input for this Choreo. 

	@param String - (required, string) The id associated with the contact to return. This can either be the individual id of the contact, or the full 'edit' link returned in the entry nodes of the GetAllContacts output.
	*/
	public void setContactId(String value) {
		this.inputs.setInput("ContactId", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (required, string) The refresh token retrieved in the last step of the OAuth process. This is used when an access token is expired or not provided.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the UserEmail input for this Choreo. 

	@param String - (required, string) The email address of the user whose contacts you want to retrieve. Defaults to "default," or the user whose OAuth access token is passed.
	*/
	public void setUserEmail(String value) {
		this.inputs.setInput("UserEmail", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetContactByIdResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetContactByIdResultSet(result);
	}
	
}
