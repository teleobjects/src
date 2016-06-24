package com.temboo.Library.RunKeeper.CommentThreads;

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
PostComment

Posts a comment about a user's activity.
*/
public class PostComment extends Choreography {

	/**
	Create a new instance of the PostComment Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PostComment(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/RunKeeper/CommentThreads/PostComment"));
	}

	/** 
	Set the value of the Comment input for this Choreo. 

	@param String - (required, string) The comment text.
	*/
	public void setComment(String value) {
		this.inputs.setInput("Comment", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved after the final step in the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the URI input for this Choreo. 

	@param String - (required, string) The URI of the activity thread to post a comment to (e.g., /fitnessActivities/327844402).
	*/
	public void setURI(String value) {
		this.inputs.setInput("URI", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PostCommentResultSet run() {
		JSONObject result = super.runWithResults();
		return new PostCommentResultSet(result);
	}
	
}
