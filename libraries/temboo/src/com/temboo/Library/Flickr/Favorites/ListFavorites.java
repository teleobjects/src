package com.temboo.Library.Flickr.Favorites;

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
ListFavorites

Returns a list of the user's favorite photos.
*/
public class ListFavorites extends Choreography {

	/**
	Create a new instance of the ListFavorites Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListFavorites(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Flickr/Favorites/ListFavorites"));
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

	@param String - (required, string) The API Secret provided by Flickr (AKA the OAuth Consumer Secret).
	*/
	public void setAPISecret(String value) {
		this.inputs.setInput("APISecret", value);
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
	Set the value of the Extras input for this Choreo. 

	@param String - (optional, string) A comma-delimited list of extra information to fetch for each returned record. See Choreo documentation for accepted values.
	*/
	public void setExtras(String value) {
		this.inputs.setInput("Extras", value);
	}


	/** 
	Set the value of the MaxFaveDate input for this Choreo. 

	@param String - (optional, date) Maximum date that a photo was favorited on. The date should be in the form of a unix timestamp.
	*/
	public void setMaxFaveDate(String value) {
		this.inputs.setInput("MaxFaveDate", value);
	}


	/** 
	Set the value of the MinFaveDate input for this Choreo. 

	@param String - (optional, date) Minimum date that a photo was favorited on. The date should be in the form of a unix timestamp.
	*/
	public void setMinFaveDate(String value) {
		this.inputs.setInput("MinFaveDate", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page of results to return. Used for paging through many results.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page of results to return. Used for paging through many results.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the PerPage input for this Choreo. 

	@param Integer - (optional, integer) The number of photos to return per page. Defaults to 100.
	*/
	public void setPerPage(Integer value) {
		this.inputs.setInput("PerPage", value);
	}

	/** 
	Set the value of the PerPage input for this Choreo as a String. 

	@param String - (optional, integer) The number of photos to return per page. Defaults to 100.
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

	@param String - (required, string) The NSID of the user to fetch the favorites list for. If this argument is omitted, the favorites list for the calling user is returned.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListFavoritesResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListFavoritesResultSet(result);
	}
	
}
