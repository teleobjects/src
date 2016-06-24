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
Post

Adds an entry to a user's profile feed.
*/
public class Post extends Choreography {

	/**
	Create a new instance of the Post Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Post(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Facebook/Publishing/Post"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token retrieved from the final step of the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Caption input for this Choreo. 

	@param String - (optional, string) Caption of the post (only used if link is specified).
	*/
	public void setCaption(String value) {
		this.inputs.setInput("Caption", value);
	}


	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) Description of the post (only used if link is specified).
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the Link input for this Choreo. 

	@param String - (conditional, string) Link to Post. Supply either a message or a link
	*/
	public void setLink(String value) {
		this.inputs.setInput("Link", value);
	}


	/** 
	Set the value of the Message input for this Choreo. 

	@param String - (required, string) The message to Post. Supply either a message or a link.
	*/
	public void setMessage(String value) {
		this.inputs.setInput("Message", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (optional, string) Name of the post (only used if link is specified).
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the Picture input for this Choreo. 

	@param String - (optional, string) Post thumbnail image (only used if link is specified).
	*/
	public void setPicture(String value) {
		this.inputs.setInput("Picture", value);
	}


	/** 
	Set the value of the PlaceID input for this Choreo. 

	@param String - (optional, string) Facebook Page ID of the location associated with this post.
	*/
	public void setPlaceID(String value) {
		this.inputs.setInput("PlaceID", value);
	}


	/** 
	Set the value of the ProfileID input for this Choreo. 

	@param String - (optional, string) The id of the profile that is being updated. Defaults to "me" indicating the authenticated user.
	*/
	public void setProfileID(String value) {
		this.inputs.setInput("ProfileID", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Tags input for this Choreo. 

	@param String - (optional, string) Comma-separated list of Facebook IDs of people tagged in this Post. NOTE: You cannot specify this field without also specifying a place.
	*/
	public void setTags(String value) {
		this.inputs.setInput("Tags", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PostResultSet run() {
		JSONObject result = super.runWithResults();
		return new PostResultSet(result);
	}
	
}
