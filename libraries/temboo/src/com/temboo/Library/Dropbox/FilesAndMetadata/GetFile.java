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
GetFile

Gets the content and metadata for a specified file.
*/
public class GetFile extends Choreography {

	/**
	Create a new instance of the GetFile Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetFile(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/FilesAndMetadata/GetFile"));
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
	Set the value of the EncodeFileContent input for this Choreo. 

	@param Boolean - (optional, boolean) File content is returned as Base64 encoded data by default. Text files can be returned as Base64 decoded by setting this input to "false". Note that binary files should always be Base64 encoded.
	*/
	public void setEncodeFileContent(Boolean value) {
		this.inputs.setInput("EncodeFileContent", value);
	}

	/** 
	Set the value of the EncodeFileContent input for this Choreo as a String. 

	@param String - (optional, boolean) File content is returned as Base64 encoded data by default. Text files can be returned as Base64 decoded by setting this input to "false". Note that binary files should always be Base64 encoded.
	*/
	public void setEncodeFileContent(String value) {
		this.inputs.setInput("EncodeFileContent", value);	
	}
	/** 
	Set the value of the IncludeMetadata input for this Choreo. 

	@param Boolean - (optional, boolean) If set to true, metadata about the file is returned. Defaults to false, indicating that only the file content is returned.
	*/
	public void setIncludeMetadata(Boolean value) {
		this.inputs.setInput("IncludeMetadata", value);
	}

	/** 
	Set the value of the IncludeMetadata input for this Choreo as a String. 

	@param String - (optional, boolean) If set to true, metadata about the file is returned. Defaults to false, indicating that only the file content is returned.
	*/
	public void setIncludeMetadata(String value) {
		this.inputs.setInput("IncludeMetadata", value);	
	}
	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (required, string) The path to file you want to retrieve (i.e. RootFolder/SubFolder/MyFile.txt). Only the file name is necessary when the file is at the root level.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	/** 
	Set the value of the Root input for this Choreo. 

	@param String - (optional, string) Defaults to "auto" which automatically determines the root folder using your app's permission level. Other options are "sandbox" (App Folder) and "dropbox" (Full Dropbox).
	*/
	public void setRoot(String value) {
		this.inputs.setInput("Root", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetFileResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetFileResultSet(result);
	}
	
}
