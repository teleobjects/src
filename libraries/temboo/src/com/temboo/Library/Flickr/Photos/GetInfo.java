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
GetInfo

Retrieves information about a specified photo.
*/
public class GetInfo extends Choreography {

	/**
	Create a new instance of the GetInfo Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetInfo(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Flickr/Photos/GetInfo"));
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
	Set the value of the PhotoID input for this Choreo. 

	@param Integer - (required, integer) The ID of the photo.
	*/
	public void setPhotoID(Integer value) {
		this.inputs.setInput("PhotoID", value);
	}

	/** 
	Set the value of the PhotoID input for this Choreo as a String. 

	@param String - (required, integer) The ID of the photo.
	*/
	public void setPhotoID(String value) {
		this.inputs.setInput("PhotoID", value);	
	}
	/** 
	Set the value of the PhotoSecret input for this Choreo. 

	@param String - (optional, string) The secret for the photo. If the correct secret is passed then permissions checking is skipped, and authenticating with OAuth tokens is not required.
	*/
	public void setPhotoSecret(String value) {
		this.inputs.setInput("PhotoSecret", value);
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
	public GetInfoResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetInfoResultSet(result);
	}
	
}
