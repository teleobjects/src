package com.temboo.Library.Dropbox.FilesAndMetadata;

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
Delta

Allows you keep up with changes to files and folders in a user's Dropbox.
*/
public class Delta extends Choreography {

	/**
	Create a new instance of the Delta Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Delta(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Dropbox/FilesAndMetadata/Delta"));
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
	Set the value of the AppKey input for this Choreo. 

	@param String - (required, string) The App Key provided by Dropbox (AKA the OAuth Consumer Key).
	*/
	public void setAppKey(String value) {
		this.inputs.setInput("AppKey", value);
	}


	/** 
	Set the value of the AppSecret input for this Choreo. 

	@param String - (required, string) The App Secret provided by Dropbox (AKA the OAuth Consumer Secret).
	*/
	public void setAppSecret(String value) {
		this.inputs.setInput("AppSecret", value);
	}


	/** 
	Set the value of the Cursor input for this Choreo. 

	@param String - (optional, string) A string that is used to keep track of your current state. On the next call pass in this value to return delta entries that have been recorded since the cursor was returned.
	*/
	public void setCursor(String value) {
		this.inputs.setInput("Cursor", value);
	}


	/** 
	Set the value of the IncludeMediaInfo input for this Choreo. 

	@param Boolean - (optional, boolean) If set to true, each file will include a photo_info dictionary for photos and a video_info dictionary for videos with additional media info.
	*/
	public void setIncludeMediaInfo(Boolean value) {
		this.inputs.setInput("IncludeMediaInfo", value);
	}

	/** 
	Set the value of the IncludeMediaInfo input for this Choreo as a String. 

	@param String - (optional, boolean) If set to true, each file will include a photo_info dictionary for photos and a video_info dictionary for videos with additional media info.
	*/
	public void setIncludeMediaInfo(String value) {
		this.inputs.setInput("IncludeMediaInfo", value);	
	}
	/** 
	Set the value of the Locale input for this Choreo. 

	@param String - (optional, string) The metadata returned will have its size field translated based on the given locale.
	*/
	public void setLocale(String value) {
		this.inputs.setInput("Locale", value);
	}


	/** 
	Set the value of the PathPrefix input for this Choreo. 

	@param String - (optional, string) Filters the response to only include entries at or under the specified path.
	*/
	public void setPathPrefix(String value) {
		this.inputs.setInput("PathPrefix", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DeltaResultSet run() {
		JSONObject result = super.runWithResults();
		return new DeltaResultSet(result);
	}
	
}
