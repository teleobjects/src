package com.temboo.Library.Box.Files;

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
UploadFile

Uploads a new file to a user's account. This can also be used when updating the contents of an existing file.
*/
public class UploadFile extends Choreography {

	/**
	Create a new instance of the UploadFile Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UploadFile(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Box/Files/UploadFile"));
	}

	/** 
	Set the value of the FileContents input for this Choreo. 

	@param String - (conditional, string) The Base64 encoded contents of the file you want to upload.
	*/
	public void setFileContents(String value) {
		this.inputs.setInput("FileContents", value);
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
	Set the value of the FileID input for this Choreo. 

	@param String - (optional, string) When providing the id of an existing file, the content of the file will be updated.
	*/
	public void setFileID(String value) {
		this.inputs.setInput("FileID", value);
	}


	/** 
	Set the value of the FileName input for this Choreo. 

	@param String - (conditional, string) The name of the new file to upload. Note that when providing the FileID in order to perform an update to a file, it is not necessary to provide the FileName.
	*/
	public void setFileName(String value) {
		this.inputs.setInput("FileName", value);
	}


	/** 
	Set the value of the FolderID input for this Choreo. 

	@param String - (optional, string) The ID of the target folder to upload the file to. Defaults to 0 indicating the root folder.
	*/
	public void setFolderID(String value) {
		this.inputs.setInput("FolderID", value);
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
	public UploadFileResultSet run() {
		JSONObject result = super.runWithResults();
		return new UploadFileResultSet(result);
	}
	
}
