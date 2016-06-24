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
CommitChunkedUpload

Completes an upload initiated by the ChunkedUpload Choreo.
*/
public class CommitChunkedUpload extends Choreography {

	/**
	Create a new instance of the CommitChunkedUpload Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CommitChunkedUpload(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/FilesAndMetadata/CommitChunkedUpload"));
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
	Set the value of the Locale input for this Choreo. 

	@param String - (optional, string) The metadata returned on successful upload will have its size field translated based on the given locale.
	*/
	public void setLocale(String value) {
		this.inputs.setInput("Locale", value);
	}


	/** 
	Set the value of the Overwrite input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates what happens when a file already exists at the specified path. If true (the default), the existing file will be overwritten. If false, the new file will be automatically renamed.
	*/
	public void setOverwrite(Boolean value) {
		this.inputs.setInput("Overwrite", value);
	}

	/** 
	Set the value of the Overwrite input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates what happens when a file already exists at the specified path. If true (the default), the existing file will be overwritten. If false, the new file will be automatically renamed.
	*/
	public void setOverwrite(String value) {
		this.inputs.setInput("Overwrite", value);	
	}
	/** 
	Set the value of the ParentRevision input for this Choreo. 

	@param String - (optional, string) The revision of the file you're editing. If this value matches the latest version of the file on the user's Dropbox, that file will be replaced, otherwise a new file will be created.
	*/
	public void setParentRevision(String value) {
		this.inputs.setInput("ParentRevision", value);
	}


	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (required, string) The path to the file you want to write to (i.e. /RootFolder/SubFolder/MyFile.txt).
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
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
	Set the value of the UploadID input for this Choreo. 

	@param String - (required, string) Used to identify the chunked upload session you'd like to commit. This is returned from the ChunkedUpload Choreo.
	*/
	public void setUploadID(String value) {
		this.inputs.setInput("UploadID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CommitChunkedUploadResultSet run() {
		JSONObject result = super.runWithResults();
		return new CommitChunkedUploadResultSet(result);
	}
	
}
