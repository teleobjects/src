package com.temboo.Library.Google.Plus.Domains.Media;

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
Insert

Adds a new media item to an album. 
*/
public class Insert extends Choreography {

	/**
	Create a new instance of the Insert Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Insert(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Plus/Domains/Media/Insert"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved during the OAuth2 process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the Collection input for this Choreo. 

	@param String - (optional, string) Currently the acceptable values are "cloud".  (Upload the media to share on Google+).
	*/
	public void setCollection(String value) {
		this.inputs.setInput("Collection", value);
	}


	/** 
	Set the value of the ContentType input for this Choreo. 

	@param String - (conditional, string) The Content-Type of the file that is being uploaded (i.e. image/jpg). Required when specifying the FileContent input.
	*/
	public void setContentType(String value) {
		this.inputs.setInput("ContentType", value);
	}


	/** 
	Set the value of the DisplayName input for this Choreo. 

	@param String - (optional, string) The display name for the media. If this parameter is not provided, Google assigns a GUID to the media resource.
	*/
	public void setDisplayName(String value) {
		this.inputs.setInput("DisplayName", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Selector specifying a subset of fields to include in the response.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the FileContent input for this Choreo. 

	@param String - (conditional, string) The Base64 encoded contents of the file to upload.
	*/
	public void setFileContent(String value) {
		this.inputs.setInput("FileContent", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth refresh token used to generate a new access token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The ID of the user to create the activity on behalf of.  The value "me" is set as the default to indicate the authenticated user.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - A path to a vault file to upload. This can be used as an alternative to the FileContent input.
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public InsertResultSet run() {
		JSONObject result = super.runWithResults();
		return new InsertResultSet(result);
	}
	
}
