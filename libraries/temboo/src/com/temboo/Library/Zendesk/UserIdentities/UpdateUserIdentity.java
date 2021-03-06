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
UpdateUserIdentity

Updates the User Identity.    This API method only allows you to set an identity as verified.
*/
public class UpdateUserIdentity extends Choreography {

	/**
	Create a new instance of the UpdateUserIdentity Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateUserIdentity(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Zendesk/UserIdentities/UpdateUserIdentity"));
	}

	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (required, string) The email address you use to login to your Zendesk account.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the IdentityID input for this Choreo. 

	@param String - (conditional, string) The ID of the Identity to be updated.
	*/
	public void setIdentityID(String value) {
		this.inputs.setInput("IdentityID", value);
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
	Set the value of the UserID input for this Choreo. 

	@param String - (conditional, string) The ID of the user.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	/** 
	Set the value of the Verified input for this Choreo. 

	@param String - (required, string) Specifies whether the identity has been verified (true or false).
	*/
	public void setVerified(String value) {
		this.inputs.setInput("Verified", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateUserIdentityResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateUserIdentityResultSet(result);
	}
	
}
