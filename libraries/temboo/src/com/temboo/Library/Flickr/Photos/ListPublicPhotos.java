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
ListPublicPhotos

Obtain a list of public photos for a given user.
*/
public class ListPublicPhotos extends Choreography {

	/**
	Create a new instance of the ListPublicPhotos Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListPublicPhotos(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Flickr/Photos/ListPublicPhotos"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Flickr (AKA the OAuth Consumer Key).
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Extras input for this Choreo. 

	@param String - (optional, string) A comma-separated list returning additional photo information such as: license, description, date_upload, date_taken.  Additional options are listed on this method's API doc page.
	*/
	public void setExtras(String value) {
		this.inputs.setInput("Extras", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) Specify the page of photos that is to be returned.  If unspecified, the first page is returned.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) Specify the page of photos that is to be returned.  If unspecified, the first page is returned.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the PerPage input for this Choreo. 

	@param Integer - (optional, integer) Specify how many photos to display per page. Default is set to: 100. The mamimum allowed value is: 500.
	*/
	public void setPerPage(Integer value) {
		this.inputs.setInput("PerPage", value);
	}

	/** 
	Set the value of the PerPage input for this Choreo as a String. 

	@param String - (optional, integer) Specify how many photos to display per page. Default is set to: 100. The mamimum allowed value is: 500.
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
	Set the value of the SafeSearch input for this Choreo. 

	@param Integer - (optional, integer) Specify a safe search setting by entering: 1 (for safe), 2 (moderate), 3 (restricted).  Default is set to: 1 (safe).
	*/
	public void setSafeSearch(Integer value) {
		this.inputs.setInput("SafeSearch", value);
	}

	/** 
	Set the value of the SafeSearch input for this Choreo as a String. 

	@param String - (optional, integer) Specify a safe search setting by entering: 1 (for safe), 2 (moderate), 3 (restricted).  Default is set to: 1 (safe).
	*/
	public void setSafeSearch(String value) {
		this.inputs.setInput("SafeSearch", value);	
	}
	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (required, string) Enter the NSID of the user whose public photos are being retrieved.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListPublicPhotosResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListPublicPhotosResultSet(result);
	}
	
}
