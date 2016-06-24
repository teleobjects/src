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
FullTextSearch

Returns a list of Congressional Record documents in which the given phrase appears.
*/
public class FullTextSearch extends Choreography {

	/**
	Create a new instance of the FullTextSearch Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public FullTextSearch(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/SunlightLabs/CapitolWords/FullTextSearch"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Sunlight Labs.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the BioguideID input for this Choreo. 

	@param String - (optional, string) Limit results to the member of Congress with the given Bioguide ID. The Bioguide ID of any current or past congressonal member can be found at bioguide.congress.gov.
	*/
	public void setBioguideID(String value) {
		this.inputs.setInput("BioguideID", value);
	}


	/** 
	Set the value of the CRPages input for this Choreo. 

	@param String - (optional, string) The pages in the Congressional Record to search.
	*/
	public void setCRPages(String value) {
		this.inputs.setInput("CRPages", value);
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
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page of results to show. 100 shown at a time.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page of results to show. 100 shown at a time.
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
	Set the value of the Phrase input for this Choreo. 

	@param String - (required, string) A phrase to search the body of each Congressional Record document for. Either Phrase or Title inputs are required.
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
	Set the value of the Title input for this Choreo. 

	@param Integer - (optional, integer) A phrase to search the title of each Congressional Record document for. Either Phrase or Title are required.
	*/
	public void setTitle(Integer value) {
		this.inputs.setInput("Title", value);
	}

	/** 
	Set the value of the Title input for this Choreo as a String. 

	@param String - (optional, integer) A phrase to search the title of each Congressional Record document for. Either Phrase or Title are required.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public FullTextSearchResultSet run() {
		JSONObject result = super.runWithResults();
		return new FullTextSearchResultSet(result);
	}
	
}
