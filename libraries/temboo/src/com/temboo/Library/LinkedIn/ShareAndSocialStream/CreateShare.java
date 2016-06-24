package com.temboo.Library.LinkedIn.ShareAndSocialStream;

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
CreateShare

Allows you to share content on behalf of a LinkedIn member.
*/
public class CreateShare extends Choreography {

	/**
	Create a new instance of the CreateShare Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateShare(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LinkedIn/ShareAndSocialStream/CreateShare"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by LinkedIn (AKA the Client ID).
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process (AKA the OAuth User Token).
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) The Access Token Secret retrieved during the OAuth process (AKA the OAuth User Secret).
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the Comment input for this Choreo. 

	@param String - (conditional, string) The text of the member's comment. Required unless providing Title and URL for a shared post.
	*/
	public void setComment(String value) {
		this.inputs.setInput("Comment", value);
	}


	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) A description of the shared content.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the ImageURL input for this Choreo. 

	@param String - (optional, string) The URL for the image of the shared content.
	*/
	public void setImageURL(String value) {
		this.inputs.setInput("ImageURL", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: xml (the default) and json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SecretKey input for this Choreo. 

	@param String - (required, string) The Secret Key provided by LinkedIn (AKA the Client Secret).
	*/
	public void setSecretKey(String value) {
		this.inputs.setInput("SecretKey", value);
	}


	/** 
	Set the value of the Title input for this Choreo. 

	@param String - (conditional, string) The title of the shared content. Required unless providing a Comment.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
	}


	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (conditional, string) The URL for the shared content. Required unless providing a Comment.
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	/** 
	Set the value of the Visibility input for this Choreo. 

	@param String - (optional, string) Determines if the post will be visible to everyone, or only those who are connected to you. Valid values are: "anyone" or "connections-only" (the default).
	*/
	public void setVisibility(String value) {
		this.inputs.setInput("Visibility", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateShareResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateShareResultSet(result);
	}
	
}
