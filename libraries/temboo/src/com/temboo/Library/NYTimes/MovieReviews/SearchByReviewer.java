package com.temboo.Library.NYTimes.MovieReviews;

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
SearchByReviewer

Retrieves reviews by a specific Times reviewer.
*/
public class SearchByReviewer extends Choreography {

	/**
	Create a new instance of the SearchByReviewer Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchByReviewer(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NYTimes/MovieReviews/SearchByReviewer"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (optional, string) The API Key provided by NY Times.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the CriticsPick input for this Choreo. 

	@param String - (optional, string) Set this parameter to Y to limt the results to NYT Critics' Picks. To get only those movies that have not been highlighted by Times critics, specify N.
	*/
	public void setCriticsPick(String value) {
		this.inputs.setInput("CriticsPick", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) A numeric value indicating the starting point of the result set. Used to page through results.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) A numeric value indicating the starting point of the result set. Used to page through results.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the Order input for this Choreo. 

	@param String - (optional, string) Sets the sort order of the results. Accepted values are: by-title, by-publication-date, by-opening-date, by-dvd-release-date.
	*/
	public void setOrder(String value) {
		this.inputs.setInput("Order", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the ReviewerName input for this Choreo. 

	@param String - (required, string) The name of the Times reviewer. Reviewer names should be separated by hyphens or dots (i.e. manohla-dargis or manohla.dargis).
	*/
	public void setReviewerName(String value) {
		this.inputs.setInput("ReviewerName", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchByReviewerResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchByReviewerResultSet(result);
	}
	
}
