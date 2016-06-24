package com.temboo.Library.GitHub.ReposAPI.Contents;

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
CreateFile

Creates a new file in a repository.
*/
public class CreateFile extends Choreography {

	/**
	Create a new instance of the CreateFile Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateFile(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GitHub/ReposAPI/Contents/CreateFile"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Branch input for this Choreo. 

	@param String - (optional, string) The branch name. Default: the repository’s default branch (usually master)
	*/
	public void setBranch(String value) {
		this.inputs.setInput("Branch", value);
	}


	/** 
	Set the value of the Content input for this Choreo. 

	@param String - (required, string) The new file content, Base64 encoded.
	*/
	public void setContent(String value) {
		this.inputs.setInput("Content", value);
	}


	/** 
	Set the value of the Contributer input for this Choreo. 

	@param String - (optional, string) The type of contributer: committer (the default) or author.
	*/
	public void setContributer(String value) {
		this.inputs.setInput("Contributer", value);
	}


	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (optional, string) The email of the author (or committer) of the commit.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the Message input for this Choreo. 

	@param String - (required, string) The commit message.
	*/
	public void setMessage(String value) {
		this.inputs.setInput("Message", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (optional, string) The name of the author (or committer) of the commit.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (required, string) The content path.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	/** 
	Set the value of the Repo input for this Choreo. 

	@param String - (required, string) The name of the repository.
	*/
	public void setRepo(String value) {
		this.inputs.setInput("Repo", value);
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
	public CreateFileResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateFileResultSet(result);
	}
	
}
