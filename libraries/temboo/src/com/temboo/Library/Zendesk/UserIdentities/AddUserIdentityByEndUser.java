package com.temboo.Library.Zendesk.UserIdentities;

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
AddUserIdentityByEndUser

 Allows an end-user  to add new identities for a given user ID.
*/
public class AddUserIdentityByEndUser extends Choreography {

	/**
	Create a new instance of the AddUserIdentityByEndUser Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddUserIdentityByEndUser(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Zendesk/UserIdentities/AddUserIdentityByEndUser"));
	}

	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (required, string) The email address you use to login to your Zendesk account.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the ID input for this Choreo. 

	@param String - (conditional, string) The ID of the user.
	*/
	public void setID(String value) {
		this.inputs.setInput("ID", value);
	}


	/** 
	Set the value of the Identity input for this Choreo. 

	@param String - (required, string) The unique idenity (e.g.  test@test.com, test@gmail.com, screen_name)
	*/
	public void setIdentity(String value) {
		this.inputs.setInput("Identity", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) Your Zendesk password.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Server input for this Choreo. 

	@param String - (required, string) Your Zendesk domain and subdomain (e.g., temboocare.zendesk.com).
	*/
	public void setServer(String value) {
		this.inputs.setInput("Server", value);
	}


	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (conditional, string) Type of identity to add (e.g. email, facebook, twitter, google)
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddUserIdentityByEndUserResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddUserIdentityByEndUserResultSet(result);
	}
	
}
