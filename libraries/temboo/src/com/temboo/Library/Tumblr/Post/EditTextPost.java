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
EditTextPost

Updates a specified text post on a Tumblr blog.
*/
public class EditTextPost extends Choreography {

	/**
	Create a new instance of the EditTextPost Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public EditTextPost(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Tumblr/Post/EditTextPost"));
	}

	/** 
	Set the value of the Body input for this Choreo. 

	@param String - (required, string) The full post body, HTML allowed.
	*/
	public void setBody(String value) {
		this.inputs.setInput("Body", value);
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
	Set the value of the Title input for this Choreo. 

	@param String - (optional, string) The optional title of the post. HTML entities must be escaped.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
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
	public EditTextPostResultSet run() {
		JSONObject result = super.runWithResults();
		return new EditTextPostResultSet(result);
	}
	
}
