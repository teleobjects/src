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
ReverseDictionary

Retrieves a reverse dictionary search for a given word.
*/
public class ReverseDictionary extends Choreography {

	/**
	Create a new instance of the ReverseDictionary Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ReverseDictionary(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Wordnik/Words/ReverseDictionary"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key from Wordnik.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the ExcludePartOfSpeech input for this Choreo. 

	@param String - (optional, string) Excludes the specified comma-delimited parts of speech from the results returned. Acceptable values include: adjective, noun, etc. See docs for full list.
	*/
	public void setExcludePartOfSpeech(String value) {
		this.inputs.setInput("ExcludePartOfSpeech", value);
	}


	/** 
	Set the value of the ExcludeSource input for this Choreo. 

	@param String - (optional, string) Exclude these comma-delimited source dictionaries: ahd, century, wiktionary,webster, wordnet.
	*/
	public void setExcludeSource(String value) {
		this.inputs.setInput("ExcludeSource", value);
	}


	/** 
	Set the value of the ExpandTerms input for this Choreo. 

	@param String - (optional, any) Expand terms by either: synonym or hypernym.
	*/
	public void setExpandTerms(String value) {
		this.inputs.setInput("ExpandTerms", value);
	}


	/** 
	Set the value of the IncludePartOfSpeech input for this Choreo. 

	@param String - (optional, string) Only includes the specified comma-delimited parts of speech. Acceptable values include: adjective, noun, etc. See docs for full list.
	*/
	public void setIncludePartOfSpeech(String value) {
		this.inputs.setInput("IncludePartOfSpeech", value);
	}


	/** 
	Set the value of the IncludeSource input for this Choreo. 

	@param String - (optional, string) Only include these comma-delimited source dictionaries: ahd, century, wiktionary,webster, wordnet.
	*/
	public void setIncludeSource(String value) {
		this.inputs.setInput("IncludeSource", value);
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
	Set the value of the SortBy input for this Choreo. 

	@param String - (optional, string) Results can be sorted by: alpha, count, or length.
	*/
	public void setSortBy(String value) {
		this.inputs.setInput("SortBy", value);
	}


	/** 
	Set the value of the SortOrder input for this Choreo. 

	@param String - (optional, string) Indicate the order to sort, either asc (ascending) or desc (descending).
	*/
	public void setSortOrder(String value) {
		this.inputs.setInput("SortOrder", value);
	}


	/** 
	Set the value of the WordSense input for this Choreo. 

	@param String - (optional, string) Restricts words and finds the closest sense to the one indicated.
	*/
	public void setWordSense(String value) {
		this.inputs.setInput("WordSense", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ReverseDictionaryResultSet run() {
		JSONObject result = super.runWithResults();
		return new ReverseDictionaryResultSet(result);
	}
	
}
