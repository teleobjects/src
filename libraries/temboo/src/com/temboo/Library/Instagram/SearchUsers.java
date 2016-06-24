package com.temboo.Library.Instagram;

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
SearchUsers

Allows you to search for users by name.
*/
public class SearchUsers extends Choreography {

	/**
	Create a new instance of the SearchUsers Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchUsers(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Instagram/SearchUsers"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (conditional, string) The access token retrieved during the OAuth 2.0 process. Required unless you provide the ClientID.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Instagram after registering your application. Required unless you provide an AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the Count input for this Choreo. 

	@param Integer - (optional, integer) The number of results to return.
	*/
	public void setCount(Integer value) {
		this.inputs.setInput("Count", value);
	}

	/** 
	Set the value of the Count input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to return.
	*/
	public void setCount(String value) {
		this.inputs.setInput("Count", value);	
	}
	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (required, string) The query string to use for the user search.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchUsersResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchUsersResultSet(result);
	}
	
}
