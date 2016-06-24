package com.temboo.Library.Google.Drive.Changes;

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
List

Lists the changes for a user.
*/
public class List extends Choreography {

	/**
	Create a new instance of the List Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public List(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Drive/Changes/List"));
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
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Selector specifying a subset of fields to include in the response.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the IncludeDeleted input for this Choreo. 

	@param Boolean - (optional, boolean) Whether to include deleted items. (Default: true).
	*/
	public void setIncludeDeleted(Boolean value) {
		this.inputs.setInput("IncludeDeleted", value);
	}

	/** 
	Set the value of the IncludeDeleted input for this Choreo as a String. 

	@param String - (optional, boolean) Whether to include deleted items. (Default: true).
	*/
	public void setIncludeDeleted(String value) {
		this.inputs.setInput("IncludeDeleted", value);	
	}
	/** 
	Set the value of the IncludeSubscribed input for this Choreo. 

	@param Boolean - (optional, boolean) Whether to include shared files and public files the user opened. If false, the list includes owned files plus any shared or public files the user explictly added to a folder in Drive. (Default: true)
	*/
	public void setIncludeSubscribed(Boolean value) {
		this.inputs.setInput("IncludeSubscribed", value);
	}

	/** 
	Set the value of the IncludeSubscribed input for this Choreo as a String. 

	@param String - (optional, boolean) Whether to include shared files and public files the user opened. If false, the list includes owned files plus any shared or public files the user explictly added to a folder in Drive. (Default: true)
	*/
	public void setIncludeSubscribed(String value) {
		this.inputs.setInput("IncludeSubscribed", value);	
	}
	/** 
	Set the value of the MaxResults input for this Choreo. 

	@param Boolean - (optional, boolean) Maximum number of changes to return.
	*/
	public void setMaxResults(Boolean value) {
		this.inputs.setInput("MaxResults", value);
	}

	/** 
	Set the value of the MaxResults input for this Choreo as a String. 

	@param String - (optional, boolean) Maximum number of changes to return.
	*/
	public void setMaxResults(String value) {
		this.inputs.setInput("MaxResults", value);	
	}
	/** 
	Set the value of the PageToken input for this Choreo. 

	@param String - (optional, string) Page token for changes.
	*/
	public void setPageToken(String value) {
		this.inputs.setInput("PageToken", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth refresh token used to generate a new access token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the StartChangeID input for this Choreo. 

	@param String - (optional, multiline) Change ID to start listing changes from.
	*/
	public void setStartChangeID(String value) {
		this.inputs.setInput("StartChangeID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListResultSet(result);
	}
	
}
