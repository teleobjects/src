package com.temboo.Library.FilesAnywhere;

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
AccountLogin

Retrieves an authentication token from FilesAnywhere.
*/
public class AccountLogin extends Choreography {

	/**
	Create a new instance of the AccountLogin Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AccountLogin(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/FilesAnywhere/AccountLogin"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by FilesAnywhere.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AllowedIPList input for this Choreo. 

	@param String - (optional, string) List of allowed IP addresses.  Multiple IP addresses can be separated by commas.
	*/
	public void setAllowedIPList(String value) {
		this.inputs.setInput("AllowedIPList", value);
	}


	/** 
	Set the value of the ClientEncryptParam input for this Choreo. 

	@param String - (optional, string) Used to return an encrypted password to use for subsequent logins.
	*/
	public void setClientEncryptParam(String value) {
		this.inputs.setInput("ClientEncryptParam", value);
	}


	/** 
	Set the value of the OrgID input for this Choreo. 

	@param Integer - (conditional, integer) Defaults to 0 for a FilesAnywhere Web account.  Use 50 for a FilesAnywhere WebAdvanced account.
	*/
	public void setOrgID(Integer value) {
		this.inputs.setInput("OrgID", value);
	}

	/** 
	Set the value of the OrgID input for this Choreo as a String. 

	@param String - (conditional, integer) Defaults to 0 for a FilesAnywhere Web account.  Use 50 for a FilesAnywhere WebAdvanced account.
	*/
	public void setOrgID(String value) {
		this.inputs.setInput("OrgID", value);	
	}
	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) Your FilesAnywhere password.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) Your FilesAnywhere username.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AccountLoginResultSet run() {
		JSONObject result = super.runWithResults();
		return new AccountLoginResultSet(result);
	}
	
}
