package com.temboo.Library.Google.Contacts;

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
GetAllGroups

Retrieve data for all groups in an account.
*/
public class GetAllGroups extends Choreography {

	/**
	Create a new instance of the GetAllGroups Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetAllGroups(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Contacts/GetAllGroups"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) The access token retrieved in the last step of the OAuth process. Access tokens that are expired will be refreshed and returned in the Choreo output.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (required, string) The OAuth client ID provided by Google when you register your application.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (required, string) The OAuth client secret provided by Google when you registered your application.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the MaxResults input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of entries to return.
	*/
	public void setMaxResults(Integer value) {
		this.inputs.setInput("MaxResults", value);
	}

	/** 
	Set the value of the MaxResults input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of entries to return.
	*/
	public void setMaxResults(String value) {
		this.inputs.setInput("MaxResults", value);	
	}
	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (required, string) The refresh token retrieved in the last step of the OAuth process. This is used when an access token is expired or not provided.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the StartIndex input for this Choreo. 

	@param Integer - (optional, integer) The index of the first result to be retrieved (for paging).
	*/
	public void setStartIndex(Integer value) {
		this.inputs.setInput("StartIndex", value);
	}

	/** 
	Set the value of the StartIndex input for this Choreo as a String. 

	@param String - (optional, integer) The index of the first result to be retrieved (for paging).
	*/
	public void setStartIndex(String value) {
		this.inputs.setInput("StartIndex", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetAllGroupsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetAllGroupsResultSet(result);
	}
	
}
