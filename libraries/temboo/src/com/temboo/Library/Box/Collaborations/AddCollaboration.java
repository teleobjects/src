package com.temboo.Library.Box.Collaborations;

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
AddCollaboration

Adds a collaboration for a single user to a specific folder.
*/
public class AddCollaboration extends Choreography {

	/**
	Create a new instance of the AddCollaboration Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddCollaboration(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Box/Collaborations/AddCollaboration"));
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
	Set the value of the FolderID input for this Choreo. 

	@param String - (required, string) The id of the folder that you want to create a collaboration for.
	*/
	public void setFolderID(String value) {
		this.inputs.setInput("FolderID", value);
	}


	/** 
	Set the value of the Login input for this Choreo. 

	@param String - (conditional, string) The email address of someone who this collaboration applies to. Required unless providing the UserID. Note, this does not need to be a Box user.
	*/
	public void setLogin(String value) {
		this.inputs.setInput("Login", value);
	}


	/** 
	Set the value of the Role input for this Choreo. 

	@param String - (optional, string) The access level of the collaboration. Valid values are "viewer" or "editor". Defaults to "viewer".
	*/
	public void setRole(String value) {
		this.inputs.setInput("Role", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (conditional, string) The id of a Box user who this collaboration applies to. Required unless providing the EmailAddress.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - (optional, vault file) The path to a vault file that you want to upload. Required unless using the FileContents input.
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddCollaborationResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddCollaborationResultSet(result);
	}
	
}
