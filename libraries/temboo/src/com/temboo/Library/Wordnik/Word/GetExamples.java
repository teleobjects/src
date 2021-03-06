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
GetExamples

Retrieves the examples of a given word.
*/
public class GetExamples extends Choreography {

	/**
	Create a new instance of the GetExamples Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetExamples(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Wordnik/Word/GetExamples"));
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
	Set the value of the Duplicates input for this Choreo. 

	@param String - (optional, string) Shows duplicate examples from different sources when set to true. Defaults to false.
	*/
	public void setDuplicates(String value) {
		this.inputs.setInput("Duplicates", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Maximum number of results to return.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Maximum number of results to return.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
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

	@param Integer - (optional, integer) Results to skip. Defaults to 0.
	*/
	public void setSkip(Integer value) {
		this.inputs.setInput("Skip", value);
	}

	/** 
	Set the value of the Skip input for this Choreo as a String. 

	@param String - (optional, integer) Results to skip. Defaults to 0.
	*/
	public void setSkip(String value) {
		this.inputs.setInput("Skip", value);	
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
	public GetExamplesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetExamplesResultSet(result);
	}
	
}
