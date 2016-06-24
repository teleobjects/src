package com.temboo.Library.GitHub.GistsAPI.Gists;

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
CreateGist

Creates a gist.
*/
public class CreateGist extends Choreography {

	/**
	Create a new instance of the CreateGist Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateGist(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GitHub/GistsAPI/Gists/CreateGist"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) The description for this gist.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the FileContents input for this Choreo. 

	@param String - (required, string) The file contents of the gist.
	*/
	public void setFileContents(String value) {
		this.inputs.setInput("FileContents", value);
	}


	/** 
	Set the value of the FileName input for this Choreo. 

	@param String - (required, string) The file name of the gist (i.e. myProject.py).
	*/
	public void setFileName(String value) {
		this.inputs.setInput("FileName", value);
	}


	/** 
	Set the value of the Public input for this Choreo. 

	@param Boolean - (required, boolean) Indicates whether or not the gist is public or private.
	*/
	public void setPublic(Boolean value) {
		this.inputs.setInput("Public", value);
	}

	/** 
	Set the value of the Public input for this Choreo as a String. 

	@param String - (required, boolean) Indicates whether or not the gist is public or private.
	*/
	public void setPublic(String value) {
		this.inputs.setInput("Public", value);	
	}
	/** 
	Set the value of the User input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setUser(String value) {
		this.inputs.setInput("User", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateGistResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateGistResultSet(result);
	}
	
}
