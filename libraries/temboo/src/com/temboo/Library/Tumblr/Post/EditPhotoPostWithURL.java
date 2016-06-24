package com.temboo.Library.Tumblr.Post;

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
EditPhotoPostWithURL

Updates a specified audio post on a Tumblr blog using a specified source image URL.
*/
public class EditPhotoPostWithURL extends Choreography {

	/**
	Create a new instance of the EditPhotoPostWithURL Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public EditPhotoPostWithURL(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Tumblr/Post/EditPhotoPostWithURL"));
	}

	/** 
	Set the value of the Source input for this Choreo. 

	@param String - (required, string) The photo source URL.
	*/
	public void setSource(String value) {
		this.inputs.setInput("Source", value);
	}


	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Tumblr (AKA the OAuth Consumer Key).
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
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
	Set the value of the BaseHostname input for this Choreo. 

	@param String - (required, string) The standard or custom blog hostname (i.e. temboo.tumblr.com).
	*/
	public void setBaseHostname(String value) {
		this.inputs.setInput("BaseHostname", value);
	}


	/** 
	Set the value of the Caption input for this Choreo. 

	@param String - (optional, string) The user-supplied caption. HTML is allowed.
	*/
	public void setCaption(String value) {
		this.inputs.setInput("Caption", value);
	}


	/** 
	Set the value of the Date input for this Choreo. 

	@param String - (optional, date) The GMT date and time of the post. Can be an epoch timestamp in milliseconds or formatted like: Dec 8th, 2011 4:03pm. Defaults to NOW().
	*/
	public void setDate(String value) {
		this.inputs.setInput("Date", value);
	}


	/** 
	Set the value of the ID input for this Choreo. 

	@param Integer - (required, integer) The ID of the post you want to edit.
	*/
	public void setID(Integer value) {
		this.inputs.setInput("ID", value);
	}

	/** 
	Set the value of the ID input for this Choreo as a String. 

	@param String - (required, integer) The ID of the post you want to edit.
	*/
	public void setID(String value) {
		this.inputs.setInput("ID", value);	
	}
	/** 
	Set the value of the Link input for this Choreo. 

	@param String - (optional, string) The "click-through URL" for the photo.
	*/
	public void setLink(String value) {
		this.inputs.setInput("Link", value);
	}


	/** 
	Set the value of the Markdown input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates whether the post uses markdown syntax. Defaults to false. Set to 1 to indicate true.
	*/
	public void setMarkdown(Boolean value) {
		this.inputs.setInput("Markdown", value);
	}

	/** 
	Set the value of the Markdown input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates whether the post uses markdown syntax. Defaults to false. Set to 1 to indicate true.
	*/
	public void setMarkdown(String value) {
		this.inputs.setInput("Markdown", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SecretKey input for this Choreo. 

	@param String - (required, string) The Secret Key provided by Tumblr (AKA the OAuth Consumer Secret).
	*/
	public void setSecretKey(String value) {
		this.inputs.setInput("SecretKey", value);
	}


	/** 
	Set the value of the Slug input for this Choreo. 

	@param String - (optional, string) Adds a short text summary to the end of the post URL.
	*/
	public void setSlug(String value) {
		this.inputs.setInput("Slug", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (optional, string) The state of the post. Specify one of the following:  published, draft, queue. Defaults to published.
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	/** 
	Set the value of the Tags input for this Choreo. 

	@param String - (optional, string) Comma-separated tags for this post.
	*/
	public void setTags(String value) {
		this.inputs.setInput("Tags", value);
	}


	/** 
	Set the value of the Tweet input for this Choreo. 

	@param String - (optional, string) Manages the autotweet (if enabled) for this post. Set to "off" for no tweet. Enter text to override the default tweet.
	*/
	public void setTweet(String value) {
		this.inputs.setInput("Tweet", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public EditPhotoPostWithURLResultSet run() {
		JSONObject result = super.runWithResults();
		return new EditPhotoPostWithURLResultSet(result);
	}
	
}
