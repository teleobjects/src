package com.temboo.Library.Dropbox.FilesAndMetadata;

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

Uploads a file to your Dropbox account.
*/
public class UploadFile extends Choreography {

	/**
	Create a new instance of the UploadFile Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UploadFile(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/FilesAndMetadata/UploadFile"));
	}

	/** 
	Set the value of the FileContents input for this Choreo. 

	@param String - (conditional, string) The Base64-encoded contents of the file you want to upload. Required UNLESS uploading a file from a URL using the FileContentsFromURL input variable.
	*/
	public void setFileContents(String value) {
		this.inputs.setInput("FileContents", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) The Access Token Secret retrieved during the OAuth process.
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the AppKey input for this Choreo. 

	@param String - (required, string) The App Key provided by Dropbox (AKA the OAuth Consumer Key).
	*/
	public void setAppKey(String value) {
		this.inputs.setInput("AppKey", value);
	}


	/** 
	Set the value of the AppSecret input for this Choreo. 

	@param String - (required, string) The App Secret provided by Dropbox (AKA the OAuth Consumer Secret).
	*/
	public void setAppSecret(String value) {
		this.inputs.setInput("AppSecret", value);
	}


	/** 
	Set the value of the FileContentsFromURL input for this Choreo. 

	@param String - (conditional, string) URL for file you want to upload. Alternative to uploading Base64Encoded data. If specifiying URL, leave FileContents blank. Valid URLs: http(s) requests only.
	*/
	public void setFileContentsFromURL(String value) {
		this.inputs.setInput("FileContentsFromURL", value);
	}


	/** 
	Set the value of the FileName input for this Choreo. 

	@param String - (required, string) The name of the file you are uploading to Dropbox.
	*/
	public void setFileName(String value) {
		this.inputs.setInput("FileName", value);
	}


	/** 
	Set the value of the Folder input for this Choreo. 

	@param String - (optional, string) The name of the folder that that you want to upload a file to. A path to a sub-folder is also valid (i.e. /RootFolder/SubFolder).
	*/
	public void setFolder(String value) {
		this.inputs.setInput("Folder", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Root input for this Choreo. 

	@param String - (optional, string) Defaults to "auto" which automatically determines the root folder using your app's permission level. Other options are "sandbox" (App Folder) and "dropbox" (Full Dropbox).
	*/
	public void setRoot(String value) {
		this.inputs.setInput("Root", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - (optional, vault file) The path to a vault file you want to upload. Required unless using the FileContents input.
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
