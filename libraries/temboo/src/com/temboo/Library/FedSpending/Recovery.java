package com.temboo.Library.FedSpending;

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
Recovery

Allows access to the information in the Recovery Act Recipient Reports database.
*/
public class Recovery extends Choreography {

	/**
	Create a new instance of the Recovery Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Recovery(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/FedSpending/Recovery"));
	}

	/** 
	Set the value of the Activity input for this Choreo. 

	@param String - (conditional, string) Whether or not to search by activity. (Will provide a select list if "y"). y = yes, n = no. Defaults to n if not set.
	*/
	public void setActivity(String value) {
		this.inputs.setInput("Activity", value);
	}


	/** 
	Set the value of the AwardAmount input for this Choreo. 

	@param String - (conditional, string) Grants: total Federal dollars. Loans: face value of loan obligated by the Federal Agency. Contracts: total amount obligated by Federal Agency. Vendors: payment amount. Recipients:  amount of award.
	*/
	public void setAwardAmount(String value) {
		this.inputs.setInput("AwardAmount", value);
	}


	/** 
	Set the value of the AwardNumber input for this Choreo. 

	@param Integer - (conditional, integer) Identifying number assigned by the awarding Federal Agency. e.g. federal grant number, federal contract number or federal loan number. For grants and loans, this is assigned by the prime recipient.
	*/
	public void setAwardNumber(Integer value) {
		this.inputs.setInput("AwardNumber", value);
	}

	/** 
	Set the value of the AwardNumber input for this Choreo as a String. 

	@param String - (conditional, integer) Identifying number assigned by the awarding Federal Agency. e.g. federal grant number, federal contract number or federal loan number. For grants and loans, this is assigned by the prime recipient.
	*/
	public void setAwardNumber(String value) {
		this.inputs.setInput("AwardNumber", value);	
	}
	/** 
	Set the value of the AwardType input for this Choreo. 

	@param String - (conditional, string) Acceptable values: G = Grants only,L = Loans only, C = Contracts only.
	*/
	public void setAwardType(String value) {
		this.inputs.setInput("AwardType", value);
	}


	/** 
	Set the value of the AwardingAgency input for this Choreo. 

	@param String - (conditional, string) The 4-digit code for a specific governmental awarding agency that awarded and is administering the award on behalf of the funding agency.
	*/
	public void setAwardingAgency(String value) {
		this.inputs.setInput("AwardingAgency", value);
	}


	/** 
	Set the value of the CFDA input for this Choreo. 

	@param String - (conditional, string) The Catalog of Federal Domestic Number is the number associated with the published description of a Federal Assistance program in the CFDA.
	*/
	public void setCFDA(String value) {
		this.inputs.setInput("CFDA", value);
	}


	/** 
	Set the value of the Detail input for this Choreo. 

	@param String - (optional, string) Controls the level of detail of the output. Acceptable values: -1 (summary), 0 (low), 1 (medium), 2 (high), and 3 (extensive). Defaults to -1. See docs for more information.
	*/
	public void setDetail(String value) {
		this.inputs.setInput("Detail", value);
	}


	/** 
	Set the value of the EntityDun input for this Choreo. 

	@param String - (conditional, string) The prime recipient for the award's Dun & Bradstreet number (no vendor information).
	*/
	public void setEntityDun(String value) {
		this.inputs.setInput("EntityDun", value);
	}


	/** 
	Set the value of the FirstYearRange input for this Choreo. 

	@param Integer - (conditional, integer) Specifies the first year in a range of years from 2000-2006; if used, must be used with LastYearRange and without FiscalYear.
	*/
	public void setFirstYearRange(Integer value) {
		this.inputs.setInput("FirstYearRange", value);
	}

	/** 
	Set the value of the FirstYearRange input for this Choreo as a String. 

	@param String - (conditional, integer) Specifies the first year in a range of years from 2000-2006; if used, must be used with LastYearRange and without FiscalYear.
	*/
	public void setFirstYearRange(String value) {
		this.inputs.setInput("FirstYearRange", value);	
	}
	/** 
	Set the value of the FiscalYear input for this Choreo. 

	@param Integer - (conditional, integer) Specifies a single year; defaults to all years.
	*/
	public void setFiscalYear(Integer value) {
		this.inputs.setInput("FiscalYear", value);
	}

	/** 
	Set the value of the FiscalYear input for this Choreo as a String. 

	@param String - (conditional, integer) Specifies a single year; defaults to all years.
	*/
	public void setFiscalYear(String value) {
		this.inputs.setInput("FiscalYear", value);	
	}
	/** 
	Set the value of the FundingAgency input for this Choreo. 

	@param String - (conditional, string) The 4-digit code for a specific governmental agency that is responsible for funding/distributing the ARRA funds to recipients.
	*/
	public void setFundingAgency(String value) {
		this.inputs.setInput("FundingAgency", value);
	}


	/** 
	Set the value of the FundingTAS input for this Choreo. 

	@param String - (conditional, string) The Agency Treasury Account Symbol (TAS) that identifies the funding Program Source. The Program Source is based out of the OMB TAS list.
	*/
	public void setFundingTAS(String value) {
		this.inputs.setInput("FundingTAS", value);
	}


	/** 
	Set the value of the GovtContractOffice input for this Choreo. 

	@param String - (conditional, string) The agency supplied code of the government contracting office that executed the transaction. (For prime recipients only.)
	*/
	public void setGovtContractOffice(String value) {
		this.inputs.setInput("GovtContractOffice", value);
	}


	/** 
	Set the value of the LastYearRange input for this Choreo. 

	@param Integer - (conditional, integer) Specifies the last year in a range of years; if used, must be used with FirstYearRange and without FiscalYear.
	*/
	public void setLastYearRange(Integer value) {
		this.inputs.setInput("LastYearRange", value);
	}

	/** 
	Set the value of the LastYearRange input for this Choreo as a String. 

	@param String - (conditional, integer) Specifies the last year in a range of years; if used, must be used with FirstYearRange and without FiscalYear.
	*/
	public void setLastYearRange(String value) {
		this.inputs.setInput("LastYearRange", value);	
	}
	/** 
	Set the value of the MaxRecords input for this Choreo. 

	@param Integer - (optional, integer) Allows you to set the maximum number of records retrieved. Defaults to 100.
	*/
	public void setMaxRecords(Integer value) {
		this.inputs.setInput("MaxRecords", value);
	}

	/** 
	Set the value of the MaxRecords input for this Choreo as a String. 

	@param String - (optional, integer) Allows you to set the maximum number of records retrieved. Defaults to 100.
	*/
	public void setMaxRecords(String value) {
		this.inputs.setInput("MaxRecords", value);	
	}
	/** 
	Set the value of the NumberOfJobs input for this Choreo. 

	@param Integer - (conditional, integer) The number of Full-Time Equivalent (FTE) jobs created and retained.
	*/
	public void setNumberOfJobs(Integer value) {
		this.inputs.setInput("NumberOfJobs", value);
	}

	/** 
	Set the value of the NumberOfJobs input for this Choreo as a String. 

	@param String - (conditional, integer) The number of Full-Time Equivalent (FTE) jobs created and retained.
	*/
	public void setNumberOfJobs(String value) {
		this.inputs.setInput("NumberOfJobs", value);	
	}
	/** 
	Set the value of the OfficerComp input for this Choreo. 

	@param Integer - (conditional, integer) Total compensation of first highly compensated officer.
	*/
	public void setOfficerComp(Integer value) {
		this.inputs.setInput("OfficerComp", value);
	}

	/** 
	Set the value of the OfficerComp input for this Choreo as a String. 

	@param String - (conditional, integer) Total compensation of first highly compensated officer.
	*/
	public void setOfficerComp(String value) {
		this.inputs.setInput("OfficerComp", value);	
	}
	/** 
	Set the value of the OrderNumber input for this Choreo. 

	@param String - (conditional, string) This is an identifying number assigned to the contract.
	*/
	public void setOrderNumber(String value) {
		this.inputs.setInput("OrderNumber", value);
	}


	/** 
	Set the value of the PopCity input for this Choreo. 

	@param String - (conditional, string) The city in which work was performed.
	*/
	public void setPopCity(String value) {
		this.inputs.setInput("PopCity", value);
	}


	/** 
	Set the value of the PopCountry input for this Choreo. 

	@param String - (conditional, string) The two-letter country code for the country in which work was performed.
	*/
	public void setPopCountry(String value) {
		this.inputs.setInput("PopCountry", value);
	}


	/** 
	Set the value of the PopDistrict input for this Choreo. 

	@param String - (conditional, string) The Congressional District in which work was performed.
	*/
	public void setPopDistrict(String value) {
		this.inputs.setInput("PopDistrict", value);
	}


	/** 
	Set the value of the PopState input for this Choreo. 

	@param String - (conditional, string) The two-letter code for the state in which in which work was performed (the "place of performance").
	*/
	public void setPopState(String value) {
		this.inputs.setInput("PopState", value);
	}


	/** 
	Set the value of the PopZip input for this Choreo. 

	@param Integer - (conditional, integer) The ZIP code in which work was performed.
	*/
	public void setPopZip(Integer value) {
		this.inputs.setInput("PopZip", value);
	}

	/** 
	Set the value of the PopZip input for this Choreo as a String. 

	@param String - (conditional, integer) The ZIP code in which work was performed.
	*/
	public void setPopZip(String value) {
		this.inputs.setInput("PopZip", value);	
	}
	/** 
	Set the value of the ProjectDescription input for this Choreo. 

	@param String - (conditional, string) A description of the project under which the award is funded.
	*/
	public void setProjectDescription(String value) {
		this.inputs.setInput("ProjectDescription", value);
	}


	/** 
	Set the value of the RecipientDistrict input for this Choreo. 

	@param String - (conditional, string) A 4-character numeric designation for the Congressional District within which a recipient or vendor is located. (For prime recipients and sub-recipients only.)
	*/
	public void setRecipientDistrict(String value) {
		this.inputs.setInput("RecipientDistrict", value);
	}


	/** 
	Set the value of the RecipientName input for this Choreo. 

	@param String - (conditional, string) The name of the recipient (prime recipient, sub-recipient, or vendor); value given is used as a text search.
	*/
	public void setRecipientName(String value) {
		this.inputs.setInput("RecipientName", value);
	}


	/** 
	Set the value of the RecipientStateCode input for this Choreo. 

	@param String - (conditional, string) The postal state abbreviation for the state in the recipient's address (can be for prime recipient, sub-recipient, or vendor).
	*/
	public void setRecipientStateCode(String value) {
		this.inputs.setInput("RecipientStateCode", value);
	}


	/** 
	Set the value of the RecipientType input for this Choreo. 

	@param String - (conditional, string) Recipient or vendor type: p = Prime recipients only, s = Sub-recipients only, v = Vendors only.
	*/
	public void setRecipientType(String value) {
		this.inputs.setInput("RecipientType", value);
	}


	/** 
	Set the value of the RecipientZip input for this Choreo. 

	@param Integer - (conditional, integer) The ZIP code of the recipient (prime recipient, sub-recipient, or vendor).
	*/
	public void setRecipientZip(Integer value) {
		this.inputs.setInput("RecipientZip", value);
	}

	/** 
	Set the value of the RecipientZip input for this Choreo as a String. 

	@param String - (conditional, integer) The ZIP code of the recipient (prime recipient, sub-recipient, or vendor).
	*/
	public void setRecipientZip(String value) {
		this.inputs.setInput("RecipientZip", value);	
	}
	/** 
	Set the value of the Sort input for this Choreo. 

	@param String - (optional, string) Determines the order in which records are sorted. The default value sorts by Recipient/Vendor Name. See doc for all other values.
	*/
	public void setSort(String value) {
		this.inputs.setInput("Sort", value);
	}


	/** 
	Set the value of the TextSearch input for this Choreo. 

	@param String - (conditional, string) Full text search.
	*/
	public void setTextSearch(String value) {
		this.inputs.setInput("TextSearch", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RecoveryResultSet run() {
		JSONObject result = super.runWithResults();
		return new RecoveryResultSet(result);
	}
	
}
