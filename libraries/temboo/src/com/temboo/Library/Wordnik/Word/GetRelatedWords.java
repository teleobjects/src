package com.temboo.Library.Wordnik.Word;

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
GetRelatedWords

Retrieves the related words of a given word.
*/
public class GetRelatedWords extends Choreography {

	/**
	Create a new instance of the GetRelatedWords Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetRelatedWords(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Wordnik/Word/GetRelatedWords"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key from Wordnik.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Cannonical input for this Choreo. 

	@param String - (optional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setCannonical(String value) {
		this.inputs.setInput("Cannonical", value);
	}


	/** 
	Set the value of the LimitPerType input for this Choreo. 

	@param Integer - (optional, integer) Limits the amount of results returned for each relationship type included in the output. Defaults to 10.
	*/
	public void setLimitPerType(Integer value) {
		this.inputs.setInput("LimitPerType", value);
	}

	/** 
	Set the value of the LimitPerType input for this Choreo as a String. 

	@param String - (optional, integer) Limits the amount of results returned for each relationship type included in the output. Defaults to 10.
	*/
	public void setLimitPerType(String value) {
		this.inputs.setInput("LimitPerType", value);	
	}
	/** 
	Set the value of the RelationshipType input for this Choreo. 

	@param String - (optional, string) Limits the total results per type of relationship. Acceptable values inlcude adjective, noun, etc. See docs for complete list.
	*/
	public void setRelationshipType(String value) {
		this.inputs.setInput("RelationshipType", value);
	}


	/** 
	Set the value of the ResponseType input for this Choreo. 

	@param String - (optional, string) Response can be either JSON or XML. Defaults to JSON.
	*/
	public void setResponseType(String value) {
		this.inputs.setInput("ResponseType", value);
	}


	/** 
	Set the value of the UseCanonical input for this Choreo. 

	@param Boolean - (optional, boolean) If true will try to return the correct word root ('cats' -> 'cat'). If false returns exactly what was requested. Defaults to false.
	*/
	public void setUseCanonical(Boolean value) {
		this.inputs.setInput("UseCanonical", value);
	}

	/** 
	Set the value of the UseCanonical input for this Choreo as a String. 

	@param String - (optional, boolean) If true will try to return the correct word root ('cats' -> 'cat'). If false returns exactly what was requested. Defaults to false.
	*/
	public void setUseCanonical(String value) {
		this.inputs.setInput("UseCanonical", value);	
	}
	/** 
	Set the value of the Word input for this Choreo. 

	@param String - (required, string) The word you want to look up on Wordnik.
	*/
	public void setWord(String value) {
		this.inputs.setInput("Word", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetRelatedWordsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetRelatedWordsResultSet(result);
	}
	
}
