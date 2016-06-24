package com.temboo.Library.NYTimes.CampaignFinance.IndividualContributors;

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
ContributionsToPresidentialCandidates

Retrieve contributions made by individuals to a specific presidential candidate. 
*/
public class ContributionsToPresidentialCandidates extends Choreography {

	/**
	Create a new instance of the ContributionsToPresidentialCandidates Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ContributionsToPresidentialCandidates(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NYTimes/CampaignFinance/IndividualContributors/ContributionsToPresidentialCandidates"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by NY Times.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the CampaignCycle input for this Choreo. 

	@param Integer - (required, integer) Enter the campaign cycle year in YYYY format.  This must be an even year.
	*/
	public void setCampaignCycle(Integer value) {
		this.inputs.setInput("CampaignCycle", value);
	}

	/** 
	Set the value of the CampaignCycle input for this Choreo as a String. 

	@param String - (required, integer) Enter the campaign cycle year in YYYY format.  This must be an even year.
	*/
	public void setCampaignCycle(String value) {
		this.inputs.setInput("CampaignCycle", value);	
	}
	/** 
	Set the value of the CandidateFECID input for this Choreo. 

	@param String - (conditional, string) Enter a candidate's nine-digit FEC ID. IDs can be obtained by first running the CandidateSearch Choreo. Required unless providing the LastName input.
	*/
	public void setCandidateFECID(String value) {
		this.inputs.setInput("CandidateFECID", value);
	}


	/** 
	Set the value of the LastName input for this Choreo. 

	@param String - (conditional, string) Enter the name of a presidential candidate for whom contributions will be obtained. Required unless providing the CandidateFECID input.
	*/
	public void setLastName(String value) {
		this.inputs.setInput("LastName", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) Enter json or xml.  Default is json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ContributionsToPresidentialCandidatesResultSet run() {
		JSONObject result = super.runWithResults();
		return new ContributionsToPresidentialCandidatesResultSet(result);
	}
	
}
