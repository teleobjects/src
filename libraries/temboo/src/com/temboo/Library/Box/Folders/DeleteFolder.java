package com.temboo.Library.Box.Folders;

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
DeleteFolder

Deletes a specified folder.
*/
public class DeleteFolder extends Choreography {

	/**
	Create a new instance of the DeleteFolder Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DeleteFolder(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Box/Folders/DeleteFolder"));
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
	Set the value of the FolderID input for this Choreo. 

	@param String - (required, string) The id of the folder that you want to delete.
	*/
	public void setFolderID(String value) {
		this.inputs.setInput("FolderID", value);
	}


	/** 
	Set the value of the Recursive input for this Choreo. 

	@param Boolean - (optional, boolean) Whether or not to delete this folder if it has items within in. Defaults to true.
	*/
	public void setRecursive(Boolean value) {
		this.inputs.setInput("Recursive", value);
	}

	/** 
	Set the value of the Recursive input for this Choreo as a String. 

	@param String - (optional, boolean) Whether or not to delete this folder if it has items within in. Defaults to true.
	*/
	public void setRecursive(String value) {
		this.inputs.setInput("Recursive", value);	
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
	public DeleteFolderResultSet run() {
		JSONObject result = super.runWithResults();
		return new DeleteFolderResultSet(result);
	}
	
}
