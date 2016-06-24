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
PresidentialDonorInformation

Retrieve details about individual donors, or a summary of donors from a particular location to a presidential election campaign.
*/
public class PresidentialDonorInformation extends Choreography {

	/**
	Create a new instance of the PresidentialDonorInformation Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PresidentialDonorInformation(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/NYTimes/CampaignFinance/PresidentialCampaigns/PresidentialDonorInformation"));
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
	Set the value of the FirstName input for this Choreo. 

	@param String - (optional, string) Enter the first name of a donor.  This parameter can be used together with LastName and/or Zip
	*/
	public void setFirstName(String value) {
		this.inputs.setInput("FirstName", value);
	}


	/** 
	Set the value of the LastName input for this Choreo. 

	@param String - (optional, string) Enter the last name of an individual donor to be retrieved.
	*/
	public void setLastName(String value) {
		this.inputs.setInput("LastName", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) Specify the starting point of the retrieved results, in multiples of 20.  By default, the first 20 results are returned.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) Specify the starting point of the retrieved results, in multiples of 20.  By default, the first 20 results are returned.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) Enter json or xml.  Default is json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Zip input for this Choreo. 

	@param Integer - (optional, integer) Enter a zipcode for which donor information wil be retrieved.
	*/
	public void setZip(Integer value) {
		this.inputs.setInput("Zip", value);
	}

	/** 
	Set the value of the Zip input for this Choreo as a String. 

	@param String - (optional, integer) Enter a zipcode for which donor information wil be retrieved.
	*/
	public void setZip(String value) {
		this.inputs.setInput("Zip", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PresidentialDonorInformationResultSet run() {
		JSONObject result = super.runWithResults();
		return new PresidentialDonorInformationResultSet(result);
	}
	
}
