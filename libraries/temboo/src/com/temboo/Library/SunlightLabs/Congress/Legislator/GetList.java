package com.temboo.Library.SunlightLabs.Congress.Legislator;

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
GetList

Returns a list of legislators that meet a specified search criteria.
*/
public class GetList extends Choreography {

	/**
	Create a new instance of the GetList Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetList(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/SunlightLabs/Congress/Legislator/GetList"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Sunlight Labs.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the AllLegislators input for this Choreo. 

	@param Boolean - (optional, boolean) A boolean flag indicating to search for all legislators even when they are no longer in office.
	*/
	public void setAllLegislators(Boolean value) {
		this.inputs.setInput("AllLegislators", value);
	}

	/** 
	Set the value of the AllLegislators input for this Choreo as a String. 

	@param String - (optional, boolean) A boolean flag indicating to search for all legislators even when they are no longer in office.
	*/
	public void setAllLegislators(String value) {
		this.inputs.setInput("AllLegislators", value);	
	}
	/** 
	Set the value of the BioguideID input for this Choreo. 

	@param String - (optional, string) The bioguide_id of the legislator to return.
	*/
	public void setBioguideID(String value) {
		this.inputs.setInput("BioguideID", value);
	}


	/** 
	Set the value of the CRPID input for this Choreo. 

	@param String - (optional, string) The crp_id associated with a legislator to return.
	*/
	public void setCRPID(String value) {
		this.inputs.setInput("CRPID", value);
	}


	/** 
	Set the value of the District input for this Choreo. 

	@param Integer - (optional, integer) Narrows the search result by district number.
	*/
	public void setDistrict(Integer value) {
		this.inputs.setInput("District", value);
	}

	/** 
	Set the value of the District input for this Choreo as a String. 

	@param String - (optional, integer) Narrows the search result by district number.
	*/
	public void setDistrict(String value) {
		this.inputs.setInput("District", value);	
	}
	/** 
	Set the value of the FECID input for this Choreo. 

	@param String - (optional, string) The fec_id associated with the legislator to return.
	*/
	public void setFECID(String value) {
		this.inputs.setInput("FECID", value);
	}


	/** 
	Set the value of the FacebookID input for this Choreo. 

	@param String - (optional, string) The facebook id of a legislator to return.
	*/
	public void setFacebookID(String value) {
		this.inputs.setInput("FacebookID", value);
	}


	/** 
	Set the value of the Filters input for this Choreo. 

	@param String - (optional, json) A JSON object containing key/value pairs to be used as filters.
	*/
	public void setFilters(String value) {
		this.inputs.setInput("Filters", value);
	}


	/** 
	Set the value of the FirstName input for this Choreo. 

	@param String - (optional, string) The first name of a legislator to return.
	*/
	public void setFirstName(String value) {
		this.inputs.setInput("FirstName", value);
	}


	/** 
	Set the value of the Gender input for this Choreo. 

	@param String - (optional, string) Narrows the search result by gender.
	*/
	public void setGender(String value) {
		this.inputs.setInput("Gender", value);
	}


	/** 
	Set the value of the GovTrackID input for this Choreo. 

	@param String - (optional, string) The govetrack_id associated with a legistlator to return.
	*/
	public void setGovTrackID(String value) {
		this.inputs.setInput("GovTrackID", value);
	}


	/** 
	Set the value of the InOffice input for this Choreo. 

	@param Boolean - (optional, boolean) Whether or not the individual is in office currently. Valid values are true or false.
	*/
	public void setInOffice(Boolean value) {
		this.inputs.setInput("InOffice", value);
	}

	/** 
	Set the value of the InOffice input for this Choreo as a String. 

	@param String - (optional, boolean) Whether or not the individual is in office currently. Valid values are true or false.
	*/
	public void setInOffice(String value) {
		this.inputs.setInput("InOffice", value);	
	}
	/** 
	Set the value of the LastName input for this Choreo. 

	@param String - (optional, string) The last name of the legislator to return.
	*/
	public void setLastName(String value) {
		this.inputs.setInput("LastName", value);
	}


	/** 
	Set the value of the Order input for this Choreo. 

	@param String - (optional, string) Used to order the results by field name (e.g. field__asc).
	*/
	public void setOrder(String value) {
		this.inputs.setInput("Order", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page offset.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page offset.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the Party input for this Choreo. 

	@param String - (optional, string) Narrows the search result by party (i.e. "D" or "R").
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
	Set the value of the Query input for this Choreo. 

	@param String - (optional, string) A search term.
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
	Set the value of the State input for this Choreo. 

	@param String - (optional, string) A state abbreviation to narrow the search results.
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	/** 
	Set the value of the Title input for this Choreo. 

	@param String - (optional, string) The title associated with the individual to return.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
	}


	/** 
	Set the value of the TwitterID input for this Choreo. 

	@param String - (optional, string) The twitter id of the legislator to return (note, this can be a twitter screen name).
	*/
	public void setTwitterID(String value) {
		this.inputs.setInput("TwitterID", value);
	}


	/** 
	Set the value of the VoteSmartID input for this Choreo. 

	@param Integer - (optional, integer) The votesmart_id of a legislator to return.
	*/
	public void setVoteSmartID(Integer value) {
		this.inputs.setInput("VoteSmartID", value);
	}

	/** 
	Set the value of the VoteSmartID input for this Choreo as a String. 

	@param String - (optional, integer) The votesmart_id of a legislator to return.
	*/
	public void setVoteSmartID(String value) {
		this.inputs.setInput("VoteSmartID", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetListResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetListResultSet(result);
	}
	
}
