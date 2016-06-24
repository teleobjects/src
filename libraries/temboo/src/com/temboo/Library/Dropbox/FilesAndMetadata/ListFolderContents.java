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
ListFolderContents

Retrieves metadata (including folder contents) for a folder or file in Dropbox.
*/
public class ListFolderContents extends Choreography {

	/**
	Create a new instance of the ListFolderContents Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListFolderContents(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/FilesAndMetadata/ListFolderContents"));
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
	Set the value of the Folder input for this Choreo. 

	@param String - (optional, string) The path to a folder for which to retrieve metadata (i.e. /RootFolder/SubFolder). Note that a path to file can also be passed.
	*/
	public void setFolder(String value) {
		this.inputs.setInput("Folder", value);
	}


	/** 
	Set the value of the Hash input for this Choreo. 

	@param String - (optional, string) The value of a hash field from a previous request to get metadata on a folder. When provided, a 304 (not Modified) status code is returned instead of a folder listing if no changes have been made.
	*/
	public void setHash(String value) {
		this.inputs.setInput("Hash", value);
	}


	/** 
	Set the value of the IncludeDeleted input for this Choreo. 

	@param Boolean - (optional, boolean) Only applicable when List is set. If this parameter is set to true, contents will include the metadata of deleted children.
	*/
	public void setIncludeDeleted(Boolean value) {
		this.inputs.setInput("IncludeDeleted", value);
	}

	/** 
	Set the value of the IncludeDeleted input for this Choreo as a String. 

	@param String - (optional, boolean) Only applicable when List is set. If this parameter is set to true, contents will include the metadata of deleted children.
	*/
	public void setIncludeDeleted(String value) {
		this.inputs.setInput("IncludeDeleted", value);	
	}
	/** 
	Set the value of the List input for this Choreo. 

	@param Boolean - (optional, boolean) If true (the default), the folder's metadata will include a contents field with a list of metadata entries for the contents of the folder.
	*/
	public void setList(Boolean value) {
		this.inputs.setInput("List", value);
	}

	/** 
	Set the value of the List input for this Choreo as a String. 

	@param String - (optional, boolean) If true (the default), the folder's metadata will include a contents field with a list of metadata entries for the contents of the folder.
	*/
	public void setList(String value) {
		this.inputs.setInput("List", value);	
	}
	/** 
	Set the value of the Locale input for this Choreo. 

	@param String - (optional, string) If your app supports any language other than English, insert the appropriate IETF language tag, and the metadata returned will have its size field translated based on the given locale (e.g., pt-BR).
	*/
	public void setLocale(String value) {
		this.inputs.setInput("Locale", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Revision input for this Choreo. 

	@param String - (optional, string) When including a particular revision number, only the metadata for that revision will be returned.
	*/
	public void setRevision(String value) {
		this.inputs.setInput("Revision", value);
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
	public ListFolderContentsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListFolderContentsResultSet(result);
	}
	
}
