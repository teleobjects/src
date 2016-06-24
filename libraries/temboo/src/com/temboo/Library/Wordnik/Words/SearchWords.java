package com.temboo.Library.Wordnik.Words;

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
SearchWords

Searches words.
*/
public class SearchWords extends Choreography {

	/**
	Create a new instance of the SearchWords Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchWords(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Wordnik/Words/SearchWords"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key from Wordnik.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the CaseSensitive input for this Choreo. 

	@param String - (optional, string) Makes the query case-insensitive when false. Defaults to true, so queries are case-sensitive.
	*/
	public void setCaseSensitive(String value) {
		this.inputs.setInput("CaseSensitive", value);
	}


	/** 
	Set the value of the ExcludePartOfSpeech input for this Choreo. 

	@param String - (optional, string) Excludes the specified comma-delimited parts of speech from the results returned. Acceptable values include: adjective, noun, etc. See docs for full list.
	*/
	public void setExcludePartOfSpeech(String value) {
		this.inputs.setInput("ExcludePartOfSpeech", value);
	}


	/** 
	Set the value of the IncludePartOfSpeech input for this Choreo. 

	@param String - (optional, string) Only includes the specified comma-delimited parts of speech. Acceptable values include: adjective, noun, etc. See docs for full list.
	*/
	public void setIncludePartOfSpeech(String value) {
		this.inputs.setInput("IncludePartOfSpeech", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Maximum number of results to return. Defaults to 10.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Maximum number of results to return. Defaults to 10.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the MaxCorpus input for this Choreo. 

	@param Integer - (optional, integer) Results include a corpus frequency count for each word returned. When this input is specified, results are limited to words with a corpus frequency count below the given number.
	*/
	public void setMaxCorpus(Integer value) {
		this.inputs.setInput("MaxCorpus", value);
	}

	/** 
	Set the value of the MaxCorpus input for this Choreo as a String. 

	@param String - (optional, integer) Results include a corpus frequency count for each word returned. When this input is specified, results are limited to words with a corpus frequency count below the given number.
	*/
	public void setMaxCorpus(String value) {
		this.inputs.setInput("MaxCorpus", value);	
	}
	/** 
	Set the value of the MaxEntries input for this Choreo. 

	@param Integer - (optional, integer) Limits the results to words that have fewer than the given numner of dictionary entries.
	*/
	public void setMaxEntries(Integer value) {
		this.inputs.setInput("MaxEntries", value);
	}

	/** 
	Set the value of the MaxEntries input for this Choreo as a String. 

	@param String - (optional, integer) Limits the results to words that have fewer than the given numner of dictionary entries.
	*/
	public void setMaxEntries(String value) {
		this.inputs.setInput("MaxEntries", value);	
	}
	/** 
	Set the value of the MaxLength input for this Choreo. 

	@param Integer - (optional, integer) Maximum word length.
	*/
	public void setMaxLength(Integer value) {
		this.inputs.setInput("MaxLength", value);
	}

	/** 
	Set the value of the MaxLength input for this Choreo as a String. 

	@param String - (optional, integer) Maximum word length.
	*/
	public void setMaxLength(String value) {
		this.inputs.setInput("MaxLength", value);	
	}
	/** 
	Set the value of the MinCorpus input for this Choreo. 

	@param Integer - (optional, integer) Results include a corpus frequency count for each word returned. When this input is specified, results are limited to words with a corpus frequency count above the given number.
	*/
	public void setMinCorpus(Integer value) {
		this.inputs.setInput("MinCorpus", value);
	}

	/** 
	Set the value of the MinCorpus input for this Choreo as a String. 

	@param String - (optional, integer) Results include a corpus frequency count for each word returned. When this input is specified, results are limited to words with a corpus frequency count above the given number.
	*/
	public void setMinCorpus(String value) {
		this.inputs.setInput("MinCorpus", value);	
	}
	/** 
	Set the value of the MinEntries input for this Choreo. 

	@param Integer - (optional, integer) Limits the results to words that have more than the given numner of dictionary entries.
	*/
	public void setMinEntries(Integer value) {
		this.inputs.setInput("MinEntries", value);
	}

	/** 
	Set the value of the MinEntries input for this Choreo as a String. 

	@param String - (optional, integer) Limits the results to words that have more than the given numner of dictionary entries.
	*/
	public void setMinEntries(String value) {
		this.inputs.setInput("MinEntries", value);	
	}
	/** 
	Set the value of the MinLength input for this Choreo. 

	@param Integer - (optional, integer) ?Minimum word length.
	*/
	public void setMinLength(Integer value) {
		this.inputs.setInput("MinLength", value);
	}

	/** 
	Set the value of the MinLength input for this Choreo as a String. 

	@param String - (optional, integer) ?Minimum word length.
	*/
	public void setMinLength(String value) {
		this.inputs.setInput("MinLength", value);	
	}
	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (required, string) Word or fragment to query for in Wordnik.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the ResponseType input for this Choreo. 

	@param String - (optional, string) Response can be either JSON or XML. Defaults to JSON.
	*/
	public void setResponseType(String value) {
		this.inputs.setInput("ResponseType", value);
	}


	/** 
	Set the value of the Skip input for this Choreo. 

	@param Integer - (optional, integer) Number of results to skip.
	*/
	public void setSkip(Integer value) {
		this.inputs.setInput("Skip", value);
	}

	/** 
	Set the value of the Skip input for this Choreo as a String. 

	@param String - (optional, integer) Number of results to skip.
	*/
	public void setSkip(String value) {
		this.inputs.setInput("Skip", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchWordsResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchWordsResultSet(result);
	}
	
}
