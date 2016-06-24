package com.temboo.Library.NYTimes.CampaignFinance.PresidentialCampaigns;

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
PresidentialStateZipTotals

Retrieve the total amount of donations aggregated by a specified location (by state and/or zipcode).
*/
public class PresidentialStateZipTotals extends Choreography {

	/**
	Create a new instance of the PresidentialStateZipTotals Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PresidentialStateZipTotals(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NYTimes/CampaignFinance/PresidentialCampaigns/PresidentialStateZipTotals"));
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
	Set the value of the Location input for this Choreo. 

	@param String - (required, string) Enter the location for which data will be retrieved. If ResourceType = states, use a two-letter state abbreviation (example: NY).  For zips, enter a five-digit zip code.
	*/
	public void setLocation(String value) {
		this.inputs.setInput("Location", value);
	}


	/** 
	Set the value of the ResourceType input for this Choreo. 

	@param String - (required, string) Specify the type of resource to use when retrieving donor data. Valid formats include: zips, or states.
	*/
	public void setResourceType(String value) {
		this.inputs.setInput("ResourceType", value);
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
	public PresidentialStateZipTotalsResultSet run() {
		JSONObject result = super.runWithResults();
		return new PresidentialStateZipTotalsResultSet(result);
	}
	
}
