package com.temboo.Library.GitHub.IssuesAPI.Issues;

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
ListIssuesForRepo

List all issues for a specified repository.
*/
public class ListIssuesForRepo extends Choreography {

	/**
	Create a new instance of the ListIssuesForRepo Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListIssuesForRepo(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/GitHub/IssuesAPI/Issues/ListIssuesForRepo"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Assignee input for this Choreo. 

	@param String - (required, string) Can be set to a username, "none" for issues with no assinged user, or * for issues with any assigned user.
	*/
	public void setAssignee(String value) {
		this.inputs.setInput("Assignee", value);
	}


	/** 
	Set the value of the Creator input for this Choreo. 

	@param String - (optional, string) The user that created the issue.
	*/
	public void setCreator(String value) {
		this.inputs.setInput("Creator", value);
	}


	/** 
	Set the value of the Direction input for this Choreo. 

	@param String - (optional, string) The direction of the sort order. Valid values are: asc or desc (the default).
	*/
	public void setDirection(String value) {
		this.inputs.setInput("Direction", value);
	}


	/** 
	Set the value of the Labels input for this Choreo. 

	@param String - (optional, string) A comma separated list of label names (i.e. bug, ui, etc).
	*/
	public void setLabels(String value) {
		this.inputs.setInput("Labels", value);
	}


	/** 
	Set the value of the Mentioned input for this Choreo. 

	@param String - (optional, string) A Github username that is mentioned.
	*/
	public void setMentioned(String value) {
		this.inputs.setInput("Mentioned", value);
	}


	/** 
	Set the value of the Milestone input for this Choreo. 

	@param String - (required, string) Can be set to a milestone number, "none" for issues with no milestone, or * for issues with any milestone.
	*/
	public void setMilestone(String value) {
		this.inputs.setInput("Milestone", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) Indicates the page index that you want to retrieve. This is used to page through many results. Defaults to 1.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) Indicates the page index that you want to retrieve. This is used to page through many results. Defaults to 1.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the PerPage input for this Choreo. 

	@param Integer - (optional, integer) The number of results to return per page.
	*/
	public void setPerPage(Integer value) {
		this.inputs.setInput("PerPage", value);
	}

	/** 
	Set the value of the PerPage input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to return per page.
	*/
	public void setPerPage(String value) {
		this.inputs.setInput("PerPage", value);	
	}
	/** 
	Set the value of the Repo input for this Choreo. 

	@param String - (required, string) The name of the repo.
	*/
	public void setRepo(String value) {
		this.inputs.setInput("Repo", value);
	}


	/** 
	Set the value of the Since input for this Choreo. 

	@param String - (optional, date) A timestamp in ISO 8601 format (YYYY-MM-DDTHH:MM:SSZ). Returns issues since this date.
	*/
	public void setSince(String value) {
		this.inputs.setInput("Since", value);
	}


	/** 
	Set the value of the Sort input for this Choreo. 

	@param String - (optional, string) Indicates how the issues will be sorted in the response. Valid sort options are: created (the default), updated, comments.
	*/
	public void setSort(String value) {
		this.inputs.setInput("Sort", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (optional, string) Returns issues with a particular state: open (the default) or closed.
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
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
	public ListIssuesForRepoResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListIssuesForRepoResultSet(result);
	}
	
}
