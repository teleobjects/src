package com.temboo.Library.GitHub.ReposAPI.Repos;

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
CreateRepo

Creates a new repository for the authenticated user.
*/
public class CreateRepo extends Choreography {

	/**
	Create a new instance of the CreateRepo Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateRepo(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GitHub/ReposAPI/Repos/CreateRepo"));
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

	@param String - (optional, string) A text description for the repo.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the HasDownloads input for this Choreo. 

	@param Boolean - (optional, boolean) Se to "true" to enable downloads for this repository. Defaults to "true".
	*/
	public void setHasDownloads(Boolean value) {
		this.inputs.setInput("HasDownloads", value);
	}

	/** 
	Set the value of the HasDownloads input for this Choreo as a String. 

	@param String - (optional, boolean) Se to "true" to enable downloads for this repository. Defaults to "true".
	*/
	public void setHasDownloads(String value) {
		this.inputs.setInput("HasDownloads", value);	
	}
	/** 
	Set the value of the HasIssues input for this Choreo. 

	@param Boolean - (optional, boolean) Set to "true" to enable issues for this repository. Defaults to "true."
	*/
	public void setHasIssues(Boolean value) {
		this.inputs.setInput("HasIssues", value);
	}

	/** 
	Set the value of the HasIssues input for this Choreo as a String. 

	@param String - (optional, boolean) Set to "true" to enable issues for this repository. Defaults to "true."
	*/
	public void setHasIssues(String value) {
		this.inputs.setInput("HasIssues", value);	
	}
	/** 
	Set the value of the HasWiki input for this Choreo. 

	@param Boolean - (optional, boolean) Set to "true" to enable the wiki for this repository. Defaults to "true".
	*/
	public void setHasWiki(Boolean value) {
		this.inputs.setInput("HasWiki", value);
	}

	/** 
	Set the value of the HasWiki input for this Choreo as a String. 

	@param String - (optional, boolean) Set to "true" to enable the wiki for this repository. Defaults to "true".
	*/
	public void setHasWiki(String value) {
		this.inputs.setInput("HasWiki", value);	
	}
	/** 
	Set the value of the Homepage input for this Choreo. 

	@param String - (optional, string) A homepage link.
	*/
	public void setHomepage(String value) {
		this.inputs.setInput("Homepage", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) The name of the repo being created.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the Private input for this Choreo. 

	@param Boolean - (optional, boolean) A flag indicating the the repo is private or public. Set to "true" to create a private repository. Defaults to "false".
	*/
	public void setPrivate(Boolean value) {
		this.inputs.setInput("Private", value);
	}

	/** 
	Set the value of the Private input for this Choreo as a String. 

	@param String - (optional, boolean) A flag indicating the the repo is private or public. Set to "true" to create a private repository. Defaults to "false".
	*/
	public void setPrivate(String value) {
		this.inputs.setInput("Private", value);	
	}
	/** 
	Set the value of the TeamID input for this Choreo. 

	@param Integer - (optional, integer) The id of the team that will be granted access to this repository. Only valid when creating a repo in an organization.
	*/
	public void setTeamID(Integer value) {
		this.inputs.setInput("TeamID", value);
	}

	/** 
	Set the value of the TeamID input for this Choreo as a String. 

	@param String - (optional, integer) The id of the team that will be granted access to this repository. Only valid when creating a repo in an organization.
	*/
	public void setTeamID(String value) {
		this.inputs.setInput("TeamID", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateRepoResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateRepoResultSet(result);
	}
	
}
