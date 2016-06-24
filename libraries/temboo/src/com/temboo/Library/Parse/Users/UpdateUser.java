package com.temboo.Library.Parse.Users;

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

Updates information for an existing user.
*/
public class UpdateUser extends Choreography {

	/**
	Create a new instance of the UpdateUser Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateUser(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Parse/Users/UpdateUser"));
	}

	/** 
	Set the value of the UserInformation input for this Choreo. 

	@param String - (required, json) A JSON string containing the user information to update.
	*/
	public void setUserInformation(String value) {
		this.inputs.setInput("UserInformation", value);
	}


	/** 
	Set the value of the ApplicationID input for this Choreo. 

	@param String - (required, string) The Application ID provided by Parse.
	*/
	public void setApplicationID(String value) {
		this.inputs.setInput("ApplicationID", value);
	}


	/** 
	Set the value of the ObjectID input for this Choreo. 

	@param String - (required, string) The ID of the user to update.
	*/
	public void setObjectID(String value) {
		this.inputs.setInput("ObjectID", value);
	}


	/** 
	Set the value of the RESTAPIKey input for this Choreo. 

	@param String - (required, string) The REST API Key provided by Parse.
	*/
	public void setRESTAPIKey(String value) {
		this.inputs.setInput("RESTAPIKey", value);
	}


	/** 
	Set the value of the SessionToken input for this Choreo. 

	@param String - (required, string) A valid Session Token. Note that Session Tokens can be retrieved by the Login and SignUp Choreos.
	*/
	public void setSessionToken(String value) {
		this.inputs.setInput("SessionToken", value);
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
