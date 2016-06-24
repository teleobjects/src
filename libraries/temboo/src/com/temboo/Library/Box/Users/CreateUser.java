package com.temboo.Library.Box.Users;

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
CreateUser

Creates a new user in an enterprise.
*/
public class CreateUser extends Choreography {

	/**
	Create a new instance of the CreateUser Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateUser(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Box/Users/CreateUser"));
	}

	/** 
	Set the value of the UserObject input for this Choreo. 

	@param String - (required, json) A JSON object representing the new user. See documentation for formatting examples.
	*/
	public void setUserObject(String value) {
		this.inputs.setInput("UserObject", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token retrieved during the OAuth2 process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AsUser input for this Choreo. 

	@param String - (optional, string) The ID of the user. Only used for enterprise administrators to make API calls for their managed users.
	*/
	public void setAsUser(String value) {
		this.inputs.setInput("AsUser", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) A comma-separated list of fields to include in the response.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateUserResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateUserResultSet(result);
	}
	
}
