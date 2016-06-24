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
Upload

Uploads a photo to Flickr.
*/
public class Upload extends Choreography {

	/**
	Create a new instance of the Upload Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Upload(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Flickr/Photos/Upload"));
	}

	/** 
	Set the value of the ImageFileContents input for this Choreo. 

	@param String - (conditional, string) The base-64 encoded file contents to upload. Required unless using the URL input.
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
	Set the value of the ContentType input for this Choreo. 

	@param Integer - (optional, integer) The type of content you are uploading. Set to 1 for Photo, 2 for Screenshot, or 3 for Other. Defaults to 1.
	*/
	public void setContentType(Integer value) {
		this.inputs.setInput("ContentType", value);
	}

	/** 
	Set the value of the ContentType input for this Choreo as a String. 

	@param String - (optional, integer) The type of content you are uploading. Set to 1 for Photo, 2 for Screenshot, or 3 for Other. Defaults to 1.
	*/
	public void setContentType(String value) {
		this.inputs.setInput("ContentType", value);	
	}
	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) A description for the photo.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the Hidden input for this Choreo. 

	@param Integer - (optional, integer) Set to 1 to allow photos to appear in global search results, 2 to be hidden from public searches. Defaults to 2.
	*/
	public void setHidden(Integer value) {
		this.inputs.setInput("Hidden", value);
	}

	/** 
	Set the value of the Hidden input for this Choreo as a String. 

	@param String - (optional, integer) Set to 1 to allow photos to appear in global search results, 2 to be hidden from public searches. Defaults to 2.
	*/
	public void setHidden(String value) {
		this.inputs.setInput("Hidden", value);	
	}
	/** 
	Set the value of the IsFamily input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 0 for no, 1 for yes. Specifies who can view the photo. Defaults to 0.
	*/
	public void setIsFamily(Boolean value) {
		this.inputs.setInput("IsFamily", value);
	}

	/** 
	Set the value of the IsFamily input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 0 for no, 1 for yes. Specifies who can view the photo. Defaults to 0.
	*/
	public void setIsFamily(String value) {
		this.inputs.setInput("IsFamily", value);	
	}
	/** 
	Set the value of the IsFriend input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 0 for no, 1 for yes. Specifies who can view the photo. Defaults to 0.
	*/
	public void setIsFriend(Boolean value) {
		this.inputs.setInput("IsFriend", value);
	}

	/** 
	Set the value of the IsFriend input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 0 for no, 1 for yes. Specifies who can view the photo. Defaults to 0.
	*/
	public void setIsFriend(String value) {
		this.inputs.setInput("IsFriend", value);	
	}
	/** 
	Set the value of the IsPublic input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 0 for no, 1 for yes. Specifies who can view the photo. Defaults to 0.
	*/
	public void setIsPublic(Boolean value) {
		this.inputs.setInput("IsPublic", value);
	}

	/** 
	Set the value of the IsPublic input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 0 for no, 1 for yes. Specifies who can view the photo. Defaults to 0.
	*/
	public void setIsPublic(String value) {
		this.inputs.setInput("IsPublic", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: xml and json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SafetyLevel input for this Choreo. 

	@param Integer - (optional, integer) Set value to 1 for Safe, 2 for Moderate, or 3 for Restricted. Defaults to 1.
	*/
	public void setSafetyLevel(Integer value) {
		this.inputs.setInput("SafetyLevel", value);
	}

	/** 
	Set the value of the SafetyLevel input for this Choreo as a String. 

	@param String - (optional, integer) Set value to 1 for Safe, 2 for Moderate, or 3 for Restricted. Defaults to 1.
	*/
	public void setSafetyLevel(String value) {
		this.inputs.setInput("SafetyLevel", value);	
	}
	/** 
	Set the value of the Tags input for this Choreo. 

	@param String - (optional, string) A list of tags to apply to the photo. Separate multiple tags with spaces.
	*/
	public void setTags(String value) {
		this.inputs.setInput("Tags", value);
	}


	/** 
	Set the value of the Title input for this Choreo. 

	@param String - (optional, string) The title of the photo you're uploading.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
	}


	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (conditional, string) A url for a photo to upload to Flickr. Required unless specifying the ImageFileContents.
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
	public UploadResultSet run() {
		JSONObject result = super.runWithResults();
		return new UploadResultSet(result);
	}
	
}
