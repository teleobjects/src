package com.temboo.Library.Flickr.Photos;

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
ListGeoTaggedPhotos

Returns a list of your geo-tagged photos.
*/
public class ListGeoTaggedPhotos extends Choreography {

	/**
	Create a new instance of the ListGeoTaggedPhotos Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListGeoTaggedPhotos(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Flickr/Photos/ListGeoTaggedPhotos"));
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

	@param String - (optional, string) A comma-delimited list of extra information to retrieve for each returned record. See Choreo documentation for accepted values.
	*/
	public void setExtras(String value) {
		this.inputs.setInput("Extras", value);
	}


	/** 
	Set the value of the MaxTakenDate input for this Choreo. 

	@param String - (optional, date) Photos with an taken date less than or equal to this value will be returned. The date should be in the form of a mysql datetime.
	*/
	public void setMaxTakenDate(String value) {
		this.inputs.setInput("MaxTakenDate", value);
	}


	/** 
	Set the value of the MaxUploadDate input for this Choreo. 

	@param String - (optional, date) Photos with an upload date less than or equal to this value will be returned. The date should be in the form of a unix timestamp.
	*/
	public void setMaxUploadDate(String value) {
		this.inputs.setInput("MaxUploadDate", value);
	}


	/** 
	Set the value of the Media input for this Choreo. 

	@param String - (optional, string) Filter results by media type. Possible values are all (default), photos or videos.
	*/
	public void setMedia(String value) {
		this.inputs.setInput("Media", value);
	}


	/** 
	Set the value of the MinTakenDate input for this Choreo. 

	@param String - (optional, date) Photos with an taken date greater than or equal to this value will be returned. The date should be in the form of a mysql datetime.
	*/
	public void setMinTakenDate(String value) {
		this.inputs.setInput("MinTakenDate", value);
	}


	/** 
	Set the value of the MinUploadDate input for this Choreo. 

	@param String - (optional, date) Photos with an upload date greater than or equal to this value will be returned. The date should be in the form of a unix timestamp.
	*/
	public void setMinUploadDate(String value) {
		this.inputs.setInput("MinUploadDate", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page of results to return. Used for paging through many results. Defaults to 1.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page of results to return. Used for paging through many results. Defaults to 1.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the PerPage input for this Choreo. 

	@param Integer - (optional, integer) Number of photos to return per page. If this argument is omitted, it defaults to 100. The maximum allowed value is 500.
	*/
	public void setPerPage(Integer value) {
		this.inputs.setInput("PerPage", value);
	}

	/** 
	Set the value of the PerPage input for this Choreo as a String. 

	@param String - (optional, integer) Number of photos to return per page. If this argument is omitted, it defaults to 100. The maximum allowed value is 500.
	*/
	public void setPerPage(String value) {
		this.inputs.setInput("PerPage", value);	
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
	Set the value of the Sort input for this Choreo. 

	@param String - (optional, string) The sort order. Accepted values are: date-posted-asc, date-posted-desc, date-taken-asc, date-taken-desc, interestingness-desc, and interestingness-asc.
	*/
	public void setSort(String value) {
		this.inputs.setInput("Sort", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListGeoTaggedPhotosResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListGeoTaggedPhotosResultSet(result);
	}
	
}
