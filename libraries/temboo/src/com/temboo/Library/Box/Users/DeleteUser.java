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
DeleteUser

Deletes a specified user.
*/
public class DeleteUser extends Choreography {

	/**
	Create a new instance of the DeleteUser Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DeleteUser(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Box/Users/DeleteUser"));
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
	Set the value of the Force input for this Choreo. 

	@param Boolean - (optional, boolean) Whether or not the user should be deleted even when they still own files.
	*/
	public void setForce(Boolean value) {
		this.inputs.setInput("Force", value);
	}

	/** 
	Set the value of the Force input for this Choreo as a String. 

	@param String - (optional, boolean) Whether or not the user should be deleted even when they still own files.
	*/
	public void setForce(String value) {
		this.inputs.setInput("Force", value);	
	}
	/** 
	Set the value of the Notify input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates that the user should receive an email notification of the transfer.
	*/
	public void setNotify(Boolean value) {
		this.inputs.setInput("Notify", value);
	}

	/** 
	Set the value of the Notify input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates that the user should receive an email notification of the transfer.
	*/
	public void setNotify(String value) {
		this.inputs.setInput("Notify", value);	
	}
	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (required, string) The id of the user whose information should be updated.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DeleteUserResultSet run() {
		JSONObject result = super.runWithResults();
		return new DeleteUserResultSet(result);
	}
	
}
