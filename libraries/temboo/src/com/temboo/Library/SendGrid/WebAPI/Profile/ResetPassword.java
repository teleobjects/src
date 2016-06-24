package com.temboo.Library.SendGrid.WebAPI.Profile;

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
ResetPassword

Reset a SendGrid account password.
*/
public class ResetPassword extends Choreography {

	/**
	Create a new instance of the ResetPassword Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ResetPassword(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/SendGrid/WebAPI/Profile/ResetPassword"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key obtained from SendGrid.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APIUser input for this Choreo. 

	@param String - (required, string) The username registered with SendGrid.
	*/
	public void setAPIUser(String value) {
		this.inputs.setInput("APIUser", value);
	}


	/** 
	Set the value of the ConfirmPassword input for this Choreo. 

	@param String - (required, string) The new account password.  Must match the string entered in the Password variable.  Minumum password length is 6 characters.
	*/
	public void setConfirmPassword(String value) {
		this.inputs.setInput("ConfirmPassword", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, string) The new account password of 6 characters or more.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format of the response from SendGrid, in either json, or xml.  Default is set to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - 
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ResetPasswordResultSet run() {
		JSONObject result = super.runWithResults();
		return new ResetPasswordResultSet(result);
	}
	
}
