package com.temboo.Library.GitHub.GistsAPI.Gists;

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
ListGistsForAuthenticatedUser

Returns a list of gists for the authenticated user or if called anonymously, return all public gists.
*/
public class ListGistsForAuthenticatedUser extends Choreography {

	/**
	Create a new instance of the ListGistsForAuthenticatedUser Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListGistsForAuthenticatedUser(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GitHub/GistsAPI/Gists/ListGistsForAuthenticatedUser"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (conditional, string) The Access Token retrieved during the OAuth process. If not provided, all public gists are returned.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) Indicates the page index that you want to retrieve. This is used to page through many results. Defaults to 1.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) Indicates the page index that you want to retrieve. This is used to page through many results. Defaults to 1.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the PerPage input for this Choreo. 

	@param Integer - (optional, integer) The number of results to return per page.
	*/
	public void setPerPage(Integer value) {
		this.inputs.setInput("PerPage", value);
	}

	/** 
	Set the value of the PerPage input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to return per page.
	*/
	public void setPerPage(String value) {
		this.inputs.setInput("PerPage", value);	
	}
	/** 
	Set the value of the Since input for this Choreo. 

	@param String - (optional, date) A timestamp in ISO 8601 format ( YYYY-MM-DDTHH:MM:SSZ). Only gists updated at or after this time will be returned.
	*/
	public void setSince(String value) {
		this.inputs.setInput("Since", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListGistsForAuthenticatedUserResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListGistsForAuthenticatedUserResultSet(result);
	}
	
}
