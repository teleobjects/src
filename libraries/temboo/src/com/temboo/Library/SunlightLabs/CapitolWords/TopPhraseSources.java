package com.temboo.Library.SunlightLabs.CapitolWords;

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
TopPhraseSources

Returns the top sources of a given phrase, which can be sorted either by legislator, state, party, bioguide ID, volume, or chambers.
*/
public class TopPhraseSources extends Choreography {

	/**
	Create a new instance of the TopPhraseSources Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public TopPhraseSources(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/SunlightLabs/CapitolWords/TopPhraseSources"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Sunlight Labs.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Chamber input for this Choreo. 

	@param String - (optional, string) Limit results to a particular chamber. Valid values: house, senate, extensions.
	*/
	public void setChamber(String value) {
		this.inputs.setInput("Chamber", value);
	}


	/** 
	Set the value of the Date input for this Choreo. 

	@param String - (optional, string) Show results for only the given date. Format: YYYY-MM-DD
	*/
	public void setDate(String value) {
		this.inputs.setInput("Date", value);
	}


	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (optional, string) Limit results to those on or before the given date. Format: YYYY-MM-DD.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the Entity input for this Choreo. 

	@param String - (required, string) The type of entity for which to return top results. Acceptable inputs: legislator, state, party, bioguide_id, volume, chamber. So 'legislator' returns the top legislators who say the given phrase.
	*/
	public void setEntity(String value) {
		this.inputs.setInput("Entity", value);
	}


	/** 
	Set the value of the MinCount input for this Choreo. 

	@param Integer - (optional, integer) Only returns results where mentions are at or above the supplied threshold.
	*/
	public void setMinCount(Integer value) {
		this.inputs.setInput("MinCount", value);
	}

	/** 
	Set the value of the MinCount input for this Choreo as a String. 

	@param String - (optional, integer) Only returns results where mentions are at or above the supplied threshold.
	*/
	public void setMinCount(String value) {
		this.inputs.setInput("MinCount", value);	
	}
	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page number to return.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page number to return.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the Party input for this Choreo. 

	@param String - (optional, string) Limit results to members of congress from a given party. Valid values: R, D, I.
	*/
	public void setParty(String value) {
		this.inputs.setInput("Party", value);
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
	Set the value of the Phrase input for this Choreo. 

	@param String - (required, string) The phrase to search for.
	*/
	public void setPhrase(String value) {
		this.inputs.setInput("Phrase", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) Output formats inlcude json and xml. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Sort input for this Choreo. 

	@param String - (optional, string) The metric on which to sort top results. Acceptable inputs: tfidf or count. Defaults to tfidf.
	*/
	public void setSort(String value) {
		this.inputs.setInput("Sort", value);
	}


	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (optional, string) Limit results to those on or after the given date. Format: YYYY-MM-DD
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (optional, string) Limit results to members from a particular state. Format: 2-letter state abbreviation (e.g. MD, RI, NY)
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public TopPhraseSourcesResultSet run() {
		JSONObject result = super.runWithResults();
		return new TopPhraseSourcesResultSet(result);
	}
	
}
