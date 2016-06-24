package com.temboo.Library.Facebook.Publishing;

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
UploadPhoto

Uploads a photo to a given album.
*/
public class UploadPhoto extends Choreography {

	/**
	Create a new instance of the UploadPhoto Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UploadPhoto(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Facebook/Publishing/UploadPhoto"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token retrieved from the final step of the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AlbumID input for this Choreo. 

	@param String - (optional, string) The id of the album to upload the photo to.
	*/
	public void setAlbumID(String value) {
		this.inputs.setInput("AlbumID", value);
	}


	/** 
	Set the value of the Message input for this Choreo. 

	@param String - (optional, string) A message to attach to the photo.
	*/
	public void setMessage(String value) {
		this.inputs.setInput("Message", value);
	}


	/** 
	Set the value of the Photo input for this Choreo. 

	@param String - (conditional, string) The Base64 encoded image to upload. This is required unless using the URL input to publish the photo.
	*/
	public void setPhoto(String value) {
		this.inputs.setInput("Photo", value);
	}


	/** 
	Set the value of the Place input for this Choreo. 

	@param String - (optional, string) The ID of a location where the photo was taken.
	*/
	public void setPlace(String value) {
		this.inputs.setInput("Place", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Source input for this Choreo. 

	@param String - (optional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setSource(String value) {
		this.inputs.setInput("Source", value);
	}


	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (conditional, string) A URL to a hosted photo that should be uploaded. This is required unless providing a Base64 encoded image for the Photo input.
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - A path to image in the vault. This can be used as an alternative to the Photo input.
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UploadPhotoResultSet run() {
		JSONObject result = super.runWithResults();
		return new UploadPhotoResultSet(result);
	}
	
}
