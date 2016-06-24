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
CreateAnonymousPost

Creates an anonymous post.
*/
public class CreateAnonymousPost extends Choreography {

	/**
	Create a new instance of the CreateAnonymousPost Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateAnonymousPost(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Disqus/Posts/CreateAnonymousPost"));
	}

	/** 
	Set the value of the AuthorEmail input for this Choreo. 

	@param String - (required, string) The email address of the post author.
	*/
	public void setAuthorEmail(String value) {
		this.inputs.setInput("AuthorEmail", value);
	}


	/** 
	Set the value of the AuthorName input for this Choreo. 

	@param String - (required, string) The name of the post author.
	*/
	public void setAuthorName(String value) {
		this.inputs.setInput("AuthorName", value);
	}


	/** 
	Set the value of the AuthorURL input for this Choreo. 

	@param String - (optional, string) The URL of the author's Disqus profile.
	*/
	public void setAuthorURL(String value) {
		this.inputs.setInput("AuthorURL", value);
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
	public CreateAnonymousPostResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateAnonymousPostResultSet(result);
	}
	
}
