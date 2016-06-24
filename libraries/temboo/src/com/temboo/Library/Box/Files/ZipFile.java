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
ZipFile

Creates a zipped version of the specified Box file and returns a link to the new compressed file.
*/
public class ZipFile extends Choreography {

	/**
	Create a new instance of the ZipFile Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ZipFile(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Box/Files/ZipFile"));
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

	@param String - (required, string) The id of the file to zip.
	*/
	public void setFileID(String value) {
		this.inputs.setInput("FileID", value);
	}


	/** 
	Set the value of the SharedLink input for this Choreo. 

	@param String - (conditional, json) A JSON object  representing the item?s shared link and associated permissions. See documentation for formatting examples.
	*/
	public void setSharedLink(String value) {
		this.inputs.setInput("SharedLink", value);
	}


	/** 
	Set the value of the ZipFileLocation input for this Choreo. 

	@param String - (conditional, string) The id of the folder to put the new zip file in. When not specified, the zip file will be put in the root folder.
	*/
	public void setZipFileLocation(String value) {
		this.inputs.setInput("ZipFileLocation", value);
	}


	/** 
	Set the value of the ZipFileName input for this Choreo. 

	@param String - (required, string) The name of the zip file that will be created.
	*/
	public void setZipFileName(String value) {
		this.inputs.setInput("ZipFileName", value);
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
	public ZipFileResultSet run() {
		JSONObject result = super.runWithResults();
		return new ZipFileResultSet(result);
	}
	
}
