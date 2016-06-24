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
Replace

 Replaces a photo that has already been uploaded to Flickr.
*/
public class Replace extends Choreography {

	/**
	Create a new instance of the Replace Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Replace(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Flickr/Photos/Replace"));
	}

	/** 
	Set the value of the ImageFileContents input for this Choreo. 

	@param String - (conditional, string) The base-64 encoded file contents to replace. Required unless using the URL input.
	*/
	public void setImageFileContents(String value) {
		this.inputs.setInput("ImageFileContents", value);
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
	Set the value of the Async input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 to replace photos in async mode. This can be used if you don't want to wait around for an upload to complete.
	*/
	public void setAsync(Boolean value) {
		this.inputs.setInput("Async", value);
	}

	/** 
	Set the value of the Async input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 to replace photos in async mode. This can be used if you don't want to wait around for an upload to complete.
	*/
	public void setAsync(String value) {
		this.inputs.setInput("Async", value);	
	}
	/** 
	Set the value of the PhotoID input for this Choreo. 

	@param String - (required, string) The ID of the photo to replace.
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
	Set the value of the URL input for this Choreo. 

	@param String - (conditional, string) A url for a photo to use as the replacement. Required unless specifying the ImageFileContents.
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - (optional, vault file) A vault file path can be specified as an alternative to using ImageFileContents input. Required if ImageFileContents is not specified.
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ReplaceResultSet run() {
		JSONObject result = super.runWithResults();
		return new ReplaceResultSet(result);
	}
	
}
