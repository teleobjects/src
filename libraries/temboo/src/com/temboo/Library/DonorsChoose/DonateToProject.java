package com.temboo.Library.DonorsChoose;

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
DonateToProject

Makes a donation to a specified DonorsChoose.org project.
*/
public class DonateToProject extends Choreography {

	/**
	Create a new instance of the DonateToProject Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DonateToProject(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/DonorsChoose/DonateToProject"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The APIKey provided by DonorsChoose.org.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APIPassword input for this Choreo. 

	@param String - (required, string) Your DonorsChoose.org API password. This is only required when performing transactions.
	*/
	public void setAPIPassword(String value) {
		this.inputs.setInput("APIPassword", value);
	}


	/** 
	Set the value of the Address1 input for this Choreo. 

	@param String - (optional, string) Line one of the donor's address.
	*/
	public void setAddress1(String value) {
		this.inputs.setInput("Address1", value);
	}


	/** 
	Set the value of the Address2 input for this Choreo. 

	@param String - (optional, string) Line two of the donor's address.
	*/
	public void setAddress2(String value) {
		this.inputs.setInput("Address2", value);
	}


	/** 
	Set the value of the Amount input for this Choreo. 

	@param Integer - (required, integer) The donation amount. Must be a whole number.
	*/
	public void setAmount(Integer value) {
		this.inputs.setInput("Amount", value);
	}

	/** 
	Set the value of the Amount input for this Choreo as a String. 

	@param String - (required, integer) The donation amount. Must be a whole number.
	*/
	public void setAmount(String value) {
		this.inputs.setInput("Amount", value);	
	}
	/** 
	Set the value of the Callback input for this Choreo. 

	@param String - (optional, string) To wrap the response in a callback function, include the name in this input.
	*/
	public void setCallback(String value) {
		this.inputs.setInput("Callback", value);
	}


	/** 
	Set the value of the City input for this Choreo. 

	@param String - (optional, string) The donor's city.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (required, string) The email address of the person who is making the donation.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the FirstName input for this Choreo. 

	@param String - (optional, string) The first name of the donor.
	*/
	public void setFirstName(String value) {
		this.inputs.setInput("FirstName", value);
	}


	/** 
	Set the value of the LastName input for this Choreo. 

	@param String - (optional, string) The last name of the donor.
	*/
	public void setLastName(String value) {
		this.inputs.setInput("LastName", value);
	}


	/** 
	Set the value of the ProposalId input for this Choreo. 

	@param Integer - (required, integer) The ID of the project that will receive the donation.
	*/
	public void setProposalId(Integer value) {
		this.inputs.setInput("ProposalId", value);
	}

	/** 
	Set the value of the ProposalId input for this Choreo as a String. 

	@param String - (required, integer) The ID of the project that will receive the donation.
	*/
	public void setProposalId(String value) {
		this.inputs.setInput("ProposalId", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Salutation input for this Choreo. 

	@param String - (optional, string) Hwo the donor wants to be acknowledged on donorschoose.org.
	*/
	public void setSalutation(String value) {
		this.inputs.setInput("Salutation", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (optional, string) The donor's state.
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	/** 
	Set the value of the Zip input for this Choreo. 

	@param String - (optional, string) The donor's five-digit zip code.
	*/
	public void setZip(String value) {
		this.inputs.setInput("Zip", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DonateToProjectResultSet run() {
		JSONObject result = super.runWithResults();
		return new DonateToProjectResultSet(result);
	}
	
}
