package com.temboo.Library.GitHub.GitDataAPI.Tags;

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
CreateTag

Creates a tag object.
*/
public class CreateTag extends Choreography {

	/**
	Create a new instance of the CreateTag Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateTag(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GitHub/GitDataAPI/Tags/CreateTag"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Message input for this Choreo. 

	@param String - (required, string) The tag message.
	*/
	public void setMessage(String value) {
		this.inputs.setInput("Message", value);
	}


	/** 
	Set the value of the Object input for this Choreo. 

	@param String - (required, string) The SHA of the git object that is being tagged.
	*/
	public void setObject(String value) {
		this.inputs.setInput("Object", value);
	}


	/** 
	Set the value of the Repo input for this Choreo. 

	@param String - (required, string) The name of the repo associated with the tag being created.
	*/
	public void setRepo(String value) {
		this.inputs.setInput("Repo", value);
	}


	/** 
	Set the value of the Tag input for this Choreo. 

	@param String - (required, string) A string to use for the tag (i.e. v0.0.1).
	*/
	public void setTag(String value) {
		this.inputs.setInput("Tag", value);
	}


	/** 
	Set the value of the TaggerDate input for this Choreo. 

	@param String - (required, date) A timestamp of when the object is tagged. Should be formatted like: 2011-06-17T14:53:35-07:00.
	*/
	public void setTaggerDate(String value) {
		this.inputs.setInput("TaggerDate", value);
	}


	/** 
	Set the value of the TaggerEmail input for this Choreo. 

	@param String - (required, string) The email of the author of the tag.
	*/
	public void setTaggerEmail(String value) {
		this.inputs.setInput("TaggerEmail", value);
	}


	/** 
	Set the value of the TaggerName input for this Choreo. 

	@param String - (required, string) The name of the author of the tag.
	*/
	public void setTaggerName(String value) {
		this.inputs.setInput("TaggerName", value);
	}


	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (required, string) The type of object that is being tagged. Valid values are: commit, tree, or blob.
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
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
	public CreateTagResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateTagResultSet(result);
	}
	
}
