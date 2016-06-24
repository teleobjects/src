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
ListPhotos

Retrieves the list of photos in a set.
*/
public class ListPhotos extends Choreography {

	/**
	Create a new instance of the ListPhotos Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListPhotos(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Flickr/PhotoSets/ListPhotos"));
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

	@param String - (optional, string) The API Secret provided by Flickr (AKA the OAuth Consumer Secret).  Required when accessing a protected resource.
	*/
	public void setAPISecret(String value) {
		this.inputs.setInput("APISecret", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) The Access Token retrieved during the OAuth process. Required when accessing a protected resource.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (optional, string) The Access Token Secret retrieved during the OAuth process. Required when accessing a protected resource.
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the Extras input for this Choreo. 

	@param String - (optional, string) A comma-delimited list of extra information to fetch for each returned record.
	*/
	public void setExtras(String value) {
		this.inputs.setInput("Extras", value);
	}


	/** 
	Set the value of the Media input for this Choreo. 

	@param String - (optional, string) Filter results by media type. Possible values are all (default), photos or videos
	*/
	public void setMedia(String value) {
		this.inputs.setInput("Media", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page of results to return. If this argument is omitted, it defaults to 1.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page of results to return. If this argument is omitted, it defaults to 1.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the PerPage input for this Choreo. 

	@param Integer - (optional, integer) The number of photos to return per page. Defaults to 500. The maximum allowed value is 500.
	*/
	public void setPerPage(Integer value) {
		this.inputs.setInput("PerPage", value);
	}

	/** 
	Set the value of the PerPage input for this Choreo as a String. 

	@param String - (optional, integer) The number of photos to return per page. Defaults to 500. The maximum allowed value is 500.
	*/
	public void setPerPage(String value) {
		this.inputs.setInput("PerPage", value);	
	}
	/** 
	Set the value of the PhotoSetID input for this Choreo. 

	@param Integer - (required, integer) The ID of the photo set.
	*/
	public void setPhotoSetID(Integer value) {
		this.inputs.setInput("PhotoSetID", value);
	}

	/** 
	Set the value of the PhotoSetID input for this Choreo as a String. 

	@param String - (required, integer) The ID of the photo set.
	*/
	public void setPhotoSetID(String value) {
		this.inputs.setInput("PhotoSetID", value);	
	}
	/** 
	Set the value of the PrivacyFilter input for this Choreo. 

	@param Integer - (optional, integer) Valid values are: 1 (public photos), 2 (private photos visible to friends), 3 (private photos visible to family), 4 (private photos visible to friends and family), 5 (completely private photos).
	*/
	public void setPrivacyFilter(Integer value) {
		this.inputs.setInput("PrivacyFilter", value);
	}

	/** 
	Set the value of the PrivacyFilter input for this Choreo as a String. 

	@param String - (optional, integer) Valid values are: 1 (public photos), 2 (private photos visible to friends), 3 (private photos visible to family), 4 (private photos visible to friends and family), 5 (completely private photos).
	*/
	public void setPrivacyFilter(String value) {
		this.inputs.setInput("PrivacyFilter", value);	
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
	public ListPhotosResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListPhotosResultSet(result);
	}
	
}
