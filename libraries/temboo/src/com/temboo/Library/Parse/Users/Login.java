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
Login

Allows your application to authenticate a given user; returns user information, user-provided fields, and a session token.
*/
public class Login extends Choreography {

	/**
	Create a new instance of the Login Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Login(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Parse/Users/Login"));
	}

	/** 
	Set the value of the ApplicationID input for this Choreo. 

	@param String - (required, string) The Application ID provided by Parse.
	*/
	public void setApplicationID(String value) {
		this.inputs.setInput("ApplicationID", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, string) The password for the user that is logging in.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the RESTAPIKey input for this Choreo. 

	@param String - (required, string) The REST API Key provided by Parse.
	*/
	public void setRESTAPIKey(String value) {
		this.inputs.setInput("RESTAPIKey", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) The username for the user that is authenticating.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public LoginResultSet run() {
		JSONObject result = super.runWithResults();
		return new LoginResultSet(result);
	}
	
}
