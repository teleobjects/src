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
GetContents

Returns the contents of a file or directory in a repository.
*/
public class GetContents extends Choreography {

	/**
	Create a new instance of the GetContents Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetContents(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GitHub/ReposAPI/Contents/GetContents"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process. Required when accessing a protected resource.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Path input for this Choreo. 

	@param String - (optional, string) The content path.
	*/
	public void setPath(String value) {
		this.inputs.setInput("Path", value);
	}


	/** 
	Set the value of the Ref input for this Choreo. 

	@param String - (optional, string) The name of the commit/branch/tag. Defaults to the repository’s default branch (usually master).
	*/
	public void setRef(String value) {
		this.inputs.setInput("Ref", value);
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
	public GetContentsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetContentsResultSet(result);
	}
	
}
