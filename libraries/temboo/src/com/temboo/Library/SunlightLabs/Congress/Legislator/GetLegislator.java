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
GetLegislator

Returns information for a particular member with a given identifier.
*/
public class GetLegislator extends Choreography {

	/**
	Create a new instance of the GetLegislator Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetLegislator(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/SunlightLabs/Congress/Legislator/GetLegislator"));
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

	@param String - (conditional, string) The bioguide_id of the legislator to return.
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
	Set the value of the FECID input for this Choreo. 

	@param String - (optional, string) The fec_id associated with the legislator to return.
	*/
	public void setFECID(String value) {
		this.inputs.setInput("FECID", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) A comma-separated list of fields to include in the response.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the GovTrackID input for this Choreo. 

	@param String - (optional, string) The govetrack_id associated with a legistlator to return.
	*/
	public void setGovTrackID(String value) {
		this.inputs.setInput("GovTrackID", value);
	}


	/** 
	Set the value of the ICPSRID input for this Choreo. 

	@param String - (optional, string) Identifier for this member as it is maintained by the Inter-university Consortium for Political and Social Research.
	*/
	public void setICPSRID(String value) {
		this.inputs.setInput("ICPSRID", value);
	}


	/** 
	Set the value of the LISID input for this Choreo. 

	@param String - (optional, string) Identifier for this member as it appears on some of Congress' data systems (namely Senate votes).
	*/
	public void setLISID(String value) {
		this.inputs.setInput("LISID", value);
	}


	/** 
	Set the value of the OCDID input for this Choreo. 

	@param String - (optional, string) Identifier for this member across all countries and levels of government, as defined by the Open Civic Data project.
	*/
	public void setOCDID(String value) {
		this.inputs.setInput("OCDID", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the ThomasID input for this Choreo. 

	@param String - (optional, string) Identifier for this member as it appears on THOMAS.gov and Congress.gov.
	*/
	public void setThomasID(String value) {
		this.inputs.setInput("ThomasID", value);
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
	public GetLegislatorResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetLegislatorResultSet(result);
	}
	
}
