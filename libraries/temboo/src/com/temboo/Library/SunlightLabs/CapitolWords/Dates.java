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
Dates

Returns the popularity of a given phrase in the Congressional Record over time.
*/
public class Dates extends Choreography {

	/**
	Create a new instance of the Dates Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Dates(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/SunlightLabs/CapitolWords/Dates"));
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

	@param String - (optional, string) Limit results to the member of Congress with the given Bioguide ID. The Bioguide ID of any current or past congressional member can be found at bioguide.congress.gov.
	*/
	public void setBioguideID(String value) {
		this.inputs.setInput("BioguideID", value);
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
	Set the value of the Granularity input for this Choreo. 

	@param String - (optional, string) The length of time covered by each result. Valid values: year, month, day. Defaults to day.
	*/
	public void setGranularity(String value) {
		this.inputs.setInput("Granularity", value);
	}


	/** 
	Set the value of the MinCount input for this Choreo. 

	@param Boolean - (optional, boolean) Only returns results where mentions are at or above the supplied threshold.
	*/
	public void setMinCount(Boolean value) {
		this.inputs.setInput("MinCount", value);
	}

	/** 
	Set the value of the MinCount input for this Choreo as a String. 

	@param String - (optional, boolean) Only returns results where mentions are at or above the supplied threshold.
	*/
	public void setMinCount(String value) {
		this.inputs.setInput("MinCount", value);	
	}
	/** 
	Set the value of the Party input for this Choreo. 

	@param String - (optional, string) Limit results to members of congress from a given party. Valid values: R, D, I.
	*/
	public void setParty(String value) {
		this.inputs.setInput("Party", value);
	}


	/** 
	Set the value of the Percentages input for this Choreo. 

	@param String - (optional, string) Include the percentage of mentions versus total words in the result objects. Valid values: true, false. Defaults to false.
	*/
	public void setPercentages(String value) {
		this.inputs.setInput("Percentages", value);
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
	public DatesResultSet run() {
		JSONObject result = super.runWithResults();
		return new DatesResultSet(result);
	}
	
}
