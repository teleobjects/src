package com.temboo.Library.Disqus.Posts;

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
CreateAuthenticatedPost

Create a new post for the authenticated user.
*/
public class CreateAuthenticatedPost extends Choreography {

	/**
	Create a new instance of the CreateAuthenticatedPost Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateAuthenticatedPost(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Disqus/Posts/CreateAuthenticatedPost"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) A valid OAuth 2.0 access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Date input for this Choreo. 

	@param String - (optional, string) The date of the post, either in Unix timestamp format, or ISO datetime standard. You must be a moderator to do this.
	*/
	public void setDate(String value) {
		this.inputs.setInput("Date", value);
	}


	/** 
	Set the value of the IPAddress input for this Choreo. 

	@param String - (optional, string) The author's IP address. You must be a moderator to do this.
	*/
	public void setIPAddress(String value) {
		this.inputs.setInput("IPAddress", value);
	}


	/** 
	Set the value of the ParentPost input for this Choreo. 

	@param String - (conditional, string) The ID of a parent post to which the new post will be responding to. Either ParentPost, or Thread must be set, or both.
	*/
	public void setParentPost(String value) {
		this.inputs.setInput("ParentPost", value);
	}


	/** 
	Set the value of the PostContent input for this Choreo. 

	@param String - (required, string) The text of this post.
	*/
	public void setPostContent(String value) {
		this.inputs.setInput("PostContent", value);
	}


	/** 
	Set the value of the PostState input for this Choreo. 

	@param String - (optional, string) Specify the state of the post (comment). Available options include: unapproved, approved, spam, killed. You must be a moderator to do this. If set, pre-approval validation will be skipped.
	*/
	public void setPostState(String value) {
		this.inputs.setInput("PostState", value);
	}


	/** 
	Set the value of the PublicKey input for this Choreo. 

	@param String - (required, string) The Public Key provided by Disqus (AKA the API Key).
	*/
	public void setPublicKey(String value) {
		this.inputs.setInput("PublicKey", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and jsonp.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Thread input for this Choreo. 

	@param String - (conditional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setThread(String value) {
		this.inputs.setInput("Thread", value);
	}


	/** 
	Set the value of the ThreadID input for this Choreo. 

	@param String - (conditional, string) The thread ID to attach the new post to. Either ParentPost, or Thread must be set, or both.
	*/
	public void setThreadID(String value) {
		this.inputs.setInput("ThreadID", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - 
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateAuthenticatedPostResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateAuthenticatedPostResultSet(result);
	}
	
}
