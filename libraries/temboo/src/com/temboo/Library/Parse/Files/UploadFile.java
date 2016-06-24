package com.temboo.Library.Parse.Files;

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

Uploads a file to Parse.
*/
public class UploadFile extends Choreography {

	/**
	Create a new instance of the UploadFile Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UploadFile(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Parse/Files/UploadFile"));
	}

	/** 
	Set the value of the FileContents input for this Choreo. 

	@param String - (conditional, string) The Base64-encoded contents of the file you want to upload.
	*/
	public void setFileContents(String value) {
		this.inputs.setInput("FileContents", value);
	}


	/** 
	Set the value of the ApplicationID input for this Choreo. 

	@param String - (required, string) The Application ID provided by Parse.
	*/
	public void setApplicationID(String value) {
		this.inputs.setInput("ApplicationID", value);
	}


	/** 
	Set the value of the ContentType input for this Choreo. 

	@param String - (required, string) The content type of the file that is being uploaded (i.e. text/plain, image/jpeg, etc).
	*/
	public void setContentType(String value) {
		this.inputs.setInput("ContentType", value);
	}


	/** 
	Set the value of the FileName input for this Choreo. 

	@param String - (required, string) The name of the file you are uploading to Parse.
	*/
	public void setFileName(String value) {
		this.inputs.setInput("FileName", value);
	}


	/** 
	Set the value of the RESTAPIKey input for this Choreo. 

	@param String - (required, string) The REST API Key provided by Parse.
	*/
	public void setRESTAPIKey(String value) {
		this.inputs.setInput("RESTAPIKey", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - A path to a vault file to upload. Can be used as an alternative to the FileContents input.
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
