package com.temboo.Library.Dropbox.FileOperations;

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

Creates a zipped version of the specified Dropbox file and returns a shareable link to the new compressed file.
*/
public class ZipFile extends Choreography {

	/**
	Create a new instance of the ZipFile Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ZipFile(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/FileOperations/ZipFile"));
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
	Set the value of the FileName input for this Choreo. 

	@param String - (required, string) The name of the Dropbox file you want to zip.
	*/
	public void setFileName(String value) {
		this.inputs.setInput("FileName", value);
	}


	/** 
	Set the value of the Folder input for this Choreo. 

	@param String - (conditional, string) The name of the folder that contains the file you want to zip. A path to a sub-folder is also valid (i.e. RootFolder/SubFolder). Not required if the file is at the root level.
	*/
	public void setFolder(String value) {
		this.inputs.setInput("Folder", value);
	}


	/** 
	Set the value of the Root input for this Choreo. 

	@param String - (optional, string) Defaults to "auto" which automatically determines the root folder using your app's permission level. Other options are "sandbox" (App Folder) and "dropbox" (Full Dropbox).
	*/
	public void setRoot(String value) {
		this.inputs.setInput("Root", value);
	}


	/** 
	Set the value of the ZipFileLocation input for this Choreo. 

	@param String - (optional, string) The name of the folder to put the new zip file in.A path to a sub-folder is also valid (i.e. RootFolder/SubFolder).  When not specified, the zip file will be put in the root folder.
	*/
	public void setZipFileLocation(String value) {
		this.inputs.setInput("ZipFileLocation", value);
	}


	/** 
	Set the value of the ZipFileName input for this Choreo. 

	@param String - (optional, string) The name of the zip file that will be created. If not specified, the original file name will be used with a .zip extension.
	*/
	public void setZipFileName(String value) {
		this.inputs.setInput("ZipFileName", value);
	}


	
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
