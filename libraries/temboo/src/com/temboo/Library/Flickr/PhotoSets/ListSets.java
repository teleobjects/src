package com.temboo.Library.Flickr.PhotoSets;

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
ListSets

Returns the photosets belonging to the specified user.
*/
public class ListSets extends Choreography {

	/**
	Create a new instance of the ListSets Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListSets(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Flickr/PhotoSets/ListSets"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Flickr (AKA the OAuth Consumer Key).
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APISecret input for this Choreo. 

	@param String - (conditional, string) The API Secret provided by Flickr (AKA the OAuth Consumer Secret). Required when accessing a protected resource or when UserID is not provided.
	*/
	public void setAPISecret(String value) {
		this.inputs.setInput("APISecret", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process. Required when accessing a protected resource or when UserID is not provided.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (conditional, string) The Access Token Secret retrieved during the OAuth process. Required when accessing a protected resource or when UserID is not provided.
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page of results to get. Currently, if this is not provided, all sets are returned, but this behaviour may change in future.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page of results to get. Currently, if this is not provided, all sets are returned, but this behaviour may change in future.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the PerPage input for this Choreo. 

	@param Integer - (optional, integer) The number of sets to get per page. If paging is enabled, the maximum number of sets per page is 500.
	*/
	public void setPerPage(Integer value) {
		this.inputs.setInput("PerPage", value);
	}

	/** 
	Set the value of the PerPage input for this Choreo as a String. 

	@param String - (optional, integer) The number of sets to get per page. If paging is enabled, the maximum number of sets per page is 500.
	*/
	public void setPerPage(String value) {
		this.inputs.setInput("PerPage", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: xml and json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (conditional, string) The NSID of the user to get a photoset list for. When OAuth parameters are passed, the authenticated user is assumed.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListSetsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListSetsResultSet(result);
	}
	
}
