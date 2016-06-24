package com.temboo.Library.CloudMine.FileStorage;

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

Retrieves a file from the CloudMine server with a given key.
*/
public class GetFile extends Choreography {

	/**
	Create a new instance of the GetFile Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetFile(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/CloudMine/FileStorage/GetFile"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by CloudMine after registering your app.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the ApplicationIdentifier input for this Choreo. 

	@param String - (required, string) The application identifier provided by CloudMine after registering your app.
	*/
	public void setApplicationIdentifier(String value) {
		this.inputs.setInput("ApplicationIdentifier", value);
	}


	/** 
	Set the value of the EncodeFileContent input for this Choreo. 

	@param Boolean - (optional, boolean) Returns the file content as Base64 encoded data when set to "true". This should be set to "true" when returning binary files. Defaults to "false".
	*/
	public void setEncodeFileContent(Boolean value) {
		this.inputs.setInput("EncodeFileContent", value);
	}

	/** 
	Set the value of the EncodeFileContent input for this Choreo as a String. 

	@param String - (optional, boolean) Returns the file content as Base64 encoded data when set to "true". This should be set to "true" when returning binary files. Defaults to "false".
	*/
	public void setEncodeFileContent(String value) {
		this.inputs.setInput("EncodeFileContent", value);	
	}
	/** 
	Set the value of the Key input for this Choreo. 

	@param String - (required, string) The key whose value you want.
	*/
	public void setKey(String value) {
		this.inputs.setInput("Key", value);
	}


	/** 
	Set the value of the SessionToken input for this Choreo. 

	@param String - (conditional, string) The session token for an existing user (returned by the AccountLogin Choreo). This is only required if your app is performing this operation on behalf of another user.
	*/
	public void setSessionToken(String value) {
		this.inputs.setInput("SessionToken", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - A path to the vault file to upload. This can be used as an alternative to the FileContents input.
	*/

	
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
