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
SearchFilesAndFolders

Allows you to search Dropbox for files or folders by a keyword search.
*/
public class SearchFilesAndFolders extends Choreography {

	/**
	Create a new instance of the SearchFilesAndFolders Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchFilesAndFolders(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/FilesAndMetadata/SearchFilesAndFolders"));
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
	Set the value of the FileLimit input for this Choreo. 

	@param Integer - (optional, integer) Dropbox will not return a list that exceeds this specified limit. Defaults to 10,000.
	*/
	public void setFileLimit(Integer value) {
		this.inputs.setInput("FileLimit", value);
	}

	/** 
	Set the value of the FileLimit input for this Choreo as a String. 

	@param String - (optional, integer) Dropbox will not return a list that exceeds this specified limit. Defaults to 10,000.
	*/
	public void setFileLimit(String value) {
		this.inputs.setInput("FileLimit", value);	
	}
	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (optional, string) The path to the folder you want to search from (i.e. /RootFolder/SubFolder). Leave blank to search ALL.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (required, string) The search string. Must be at least three characters long.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
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
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchFilesAndFoldersResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchFilesAndFoldersResultSet(result);
	}
	
}
