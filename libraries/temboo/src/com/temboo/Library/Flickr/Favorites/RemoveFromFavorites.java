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
RemoveFromFavorites

Removes a photo from a user's favorites list.
*/
public class RemoveFromFavorites extends Choreography {

	/**
	Create a new instance of the RemoveFromFavorites Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RemoveFromFavorites(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Flickr/Favorites/RemoveFromFavorites"));
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
	Set the value of the PhotoID input for this Choreo. 

	@param Integer - (required, integer) The id of the photo to remove from the user's favorites.
	*/
	public void setPhotoID(Integer value) {
		this.inputs.setInput("PhotoID", value);
	}

	/** 
	Set the value of the PhotoID input for this Choreo as a String. 

	@param String - (required, integer) The id of the photo to remove from the user's favorites.
	*/
	public void setPhotoID(String value) {
		this.inputs.setInput("PhotoID", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: xml and json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RemoveFromFavoritesResultSet run() {
		JSONObject result = super.runWithResults();
		return new RemoveFromFavoritesResultSet(result);
	}
	
}
