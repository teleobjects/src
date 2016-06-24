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
ChunkedUpload

Uploads larger files to Dropbox in multiple chunks, and offers a way to resume if an upload gets interrupted.
*/
public class ChunkedUpload extends Choreography {

	/**
	Create a new instance of the ChunkedUpload Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ChunkedUpload(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/FilesAndMetadata/ChunkedUpload"));
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
	Set the value of the Chunk input for this Choreo. 

	@param String - (conditional, string) A Base64 encoded chunk of data from the file being uploaded. If resuming and upload, the chunk should begin at the number of bytes into the file that equals the NextOffset.
	*/
	public void setChunk(String value) {
		this.inputs.setInput("Chunk", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param String - (conditional, string) The byte offset of this chunk, relative to the beginning of the full file. This is not required when uploading the first chunk of a file.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);
	}


	/** 
	Set the value of the UploadID input for this Choreo. 

	@param String - (conditional, string) The ID of the upload session returned after uploading the initial file chunk. This is not required when uploading the first chunk of a file. This value is returned in the UploadSessionID output.
	*/
	public void setUploadID(String value) {
		this.inputs.setInput("UploadID", value);
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
	public ChunkedUploadResultSet run() {
		JSONObject result = super.runWithResults();
		return new ChunkedUploadResultSet(result);
	}
	
}
