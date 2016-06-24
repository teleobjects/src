package com.temboo.Library.GitHub.ReposAPI.Comments;

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
CreateCommitComment

Creates a comment on a specified commit.
*/
public class CreateCommitComment extends Choreography {

	/**
	Create a new instance of the CreateCommitComment Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateCommitComment(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GitHub/ReposAPI/Comments/CreateCommitComment"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Body input for this Choreo. 

	@param String - (required, string) The comment text.
	*/
	public void setBody(String value) {
		this.inputs.setInput("Body", value);
	}


	/** 
	Set the value of the Line input for this Choreo. 

	@param Integer - (required, integer) The line number in the file to comment on.
	*/
	public void setLine(Integer value) {
		this.inputs.setInput("Line", value);
	}

	/** 
	Set the value of the Line input for this Choreo as a String. 

	@param String - (required, integer) The line number in the file to comment on.
	*/
	public void setLine(String value) {
		this.inputs.setInput("Line", value);	
	}
	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (required, string) The relative path of the file to comment on.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	/** 
	Set the value of the Position input for this Choreo. 

	@param Integer - (required, integer) The line index in the diff to comment on.
	*/
	public void setPosition(Integer value) {
		this.inputs.setInput("Position", value);
	}

	/** 
	Set the value of the Position input for this Choreo as a String. 

	@param String - (required, integer) The line index in the diff to comment on.
	*/
	public void setPosition(String value) {
		this.inputs.setInput("Position", value);	
	}
	/** 
	Set the value of the Repo input for this Choreo. 

	@param String - (required, string) The name of the repo that the comment is associated with.
	*/
	public void setRepo(String value) {
		this.inputs.setInput("Repo", value);
	}


	/** 
	Set the value of the SHA input for this Choreo. 

	@param String - (required, string) The SHA or id of the commit.
	*/
	public void setSHA(String value) {
		this.inputs.setInput("SHA", value);
	}


	/** 
	Set the value of the User input for this Choreo. 

	@param String - (required, string) The GitHub account owner.
	*/
	public void setUser(String value) {
		this.inputs.setInput("User", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateCommitCommentResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateCommitCommentResultSet(result);
	}
	
}
