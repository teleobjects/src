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
PostDetails

Obtain information about a post.
*/
public class PostDetails extends Choreography {

	/**
	Create a new instance of the PostDetails Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PostDetails(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Disqus/Posts/PostDetails"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid OAuth 2.0 access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the PostID input for this Choreo. 

	@param Integer - (required, integer) The post ID for which information will be returned.
	*/
	public void setPostID(Integer value) {
		this.inputs.setInput("PostID", value);
	}

	/** 
	Set the value of the PostID input for this Choreo as a String. 

	@param String - (required, integer) The post ID for which information will be returned.
	*/
	public void setPostID(String value) {
		this.inputs.setInput("PostID", value);	
	}
	/** 
	Set the value of the PublicKey input for this Choreo. 

	@param String - (required, string) The Public Key provided by Disqus (AKA the API Key).
	*/
	public void setPublicKey(String value) {
		this.inputs.setInput("PublicKey", value);
	}


	/** 
	Set the value of the Related input for this Choreo. 

	@param String - (optional, string) Specify a related thread or forum that are to be included in the response.  Valid entries include: thread, or forum.
	*/
	public void setRelated(String value) {
		this.inputs.setInput("Related", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and jsonp.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
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
	public PostDetailsResultSet run() {
		JSONObject result = super.runWithResults();
		return new PostDetailsResultSet(result);
	}
	
}
