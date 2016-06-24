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
SearchByKeyword

Searches movie reviews by keyword and various filter parameters.
*/
public class SearchByKeyword extends Choreography {

	/**
	Create a new instance of the SearchByKeyword Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchByKeyword(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NYTimes/MovieReviews/SearchByKeyword"));
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
	Set the value of the DVD input for this Choreo. 

	@param String - (optional, string) Set this parameter to Y to limit the results to movies that have been released on DVD. To get only those movies that have not been released on DVD, specify N.
	*/
	public void setDVD(String value) {
		this.inputs.setInput("DVD", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of results to return.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to return.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) A numeric value indicating the starting point of the result set. This can be used in combination with the Limit input to page through results.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) A numeric value indicating the starting point of the result set. This can be used in combination with the Limit input to page through results.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the OpeningDate input for this Choreo. 

	@param String - (optional, date) Limits by date or range of dates. The opening-date is the date the movie's opening date in the New York region. Format YYYY-MM-DD. Separate ranges with semicolons.
	*/
	public void setOpeningDate(String value) {
		this.inputs.setInput("OpeningDate", value);
	}


	/** 
	Set the value of the Order input for this Choreo. 

	@param String - (optional, string) Sets the sort order of the results. Accepted values are: by-title, by-publication-date, by-opening-date, by-dvd-release-date.
	*/
	public void setOrder(String value) {
		this.inputs.setInput("Order", value);
	}


	/** 
	Set the value of the PublicationDate input for this Choreo. 

	@param String - (optional, date) Limits by date or range of dates. The publication-date is the date the review was first publish.ed in The Times. Format YYYY-MM-DD. Separate ranges with semicolons.
	*/
	public void setPublicationDate(String value) {
		this.inputs.setInput("PublicationDate", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (conditional, string) A string of search keywords. Matches movie titles and indexed terms.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Reviewer input for this Choreo. 

	@param String - (optional, string) Limits results to reviews by a specific critic. Reviewer names should be hyphenated or concatenated with dots (i.e manohla.dargis).
	*/
	public void setReviewer(String value) {
		this.inputs.setInput("Reviewer", value);
	}


	/** 
	Set the value of the ThousandBest input for this Choreo. 

	@param String - (optional, string) Set this parameter to Y to limit the results to movies on the Times list of The Best 1,000 Movies Ever Made. To get only those movies that are not on the list, specify N.
	*/
	public void setThousandBest(String value) {
		this.inputs.setInput("ThousandBest", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchByKeywordResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchByKeywordResultSet(result);
	}
	
}
