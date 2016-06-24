package com.temboo.Library.OneLogin.Users;

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
UpdateUser

Updates an existing user.
*/
public class UpdateUser extends Choreography {

	/**
	Create a new instance of the UpdateUser Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateUser(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/OneLogin/Users/UpdateUser"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by OneLogin.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Address input for this Choreo. 

	@param String - (conditional, string) The street address for the new account.
	*/
	public void setAddress(String value) {
		this.inputs.setInput("Address", value);
	}


	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (conditional, string) The email address for the new user.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the FirstName input for this Choreo. 

	@param String - (conditional, string) The first name of the new user.
	*/
	public void setFirstName(String value) {
		this.inputs.setInput("FirstName", value);
	}


	/** 
	Set the value of the GroupID input for this Choreo. 

	@param String - (optional, string) The group id associated with the new user.
	*/
	public void setGroupID(String value) {
		this.inputs.setInput("GroupID", value);
	}


	/** 
	Set the value of the ID input for this Choreo. 

	@param Integer - (required, integer) The id of the user you want to update.
	*/
	public void setID(Integer value) {
		this.inputs.setInput("ID", value);
	}

	/** 
	Set the value of the ID input for this Choreo as a String. 

	@param String - (required, integer) The id of the user you want to update.
	*/
	public void setID(String value) {
		this.inputs.setInput("ID", value);	
	}
	/** 
	Set the value of the LastName input for this Choreo. 

	@param String - (conditional, string) The last name of the new user.
	*/
	public void setLastName(String value) {
		this.inputs.setInput("LastName", value);
	}


	/** 
	Set the value of the OpenIDName input for this Choreo. 

	@param String - (conditional, string) The open id name.
	*/
	public void setOpenIDName(String value) {
		this.inputs.setInput("OpenIDName", value);
	}


	/** 
	Set the value of the Phone input for this Choreo. 

	@param String - (conditional, string) The phone number of the new user.
	*/
	public void setPhone(String value) {
		this.inputs.setInput("Phone", value);
	}


	/** 
	Set the value of the Role input for this Choreo. 

	@param String - (optional, string) Updates a user's role.
	*/
	public void setRole(String value) {
		this.inputs.setInput("Role", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateUserResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateUserResultSet(result);
	}
	
}
