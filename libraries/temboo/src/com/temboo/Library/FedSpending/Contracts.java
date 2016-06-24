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
Contracts

Allows access to the information in the Federal Procurement Data System (FPDS) database, which reports all federal contracts awarded. 
*/
public class Contracts extends Choreography {

	/**
	Create a new instance of the Contracts Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Contracts(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/FedSpending/Contracts"));
	}

	/** 
	Set the value of the City input for this Choreo. 

	@param String - (conditional, string) The city within a contractor's address.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the CompanyName input for this Choreo. 

	@param String - (conditional, string) The name of a a contractor or contractor parent company.
	*/
	public void setCompanyName(String value) {
		this.inputs.setInput("CompanyName", value);
	}


	/** 
	Set the value of the Completion input for this Choreo. 

	@param String - (conditional, string) The competition status of a contract. Valid values: c=Full competition, o=Full competition, one bid, p=Competition, exclusion of sources, n=Not complete, a=Not available, f=Follow-up, u=Unknown.
	*/
	public void setCompletion(String value) {
		this.inputs.setInput("Completion", value);
	}


	/** 
	Set the value of the Detail input for this Choreo. 

	@param String - (optional, string) Controls the level of detail of the output. Acceptable values: -1 (summary), 0 (low), 1 (medium), 2 (high), and 3 (extensive). Defaults to -1. See docs for more information.
	*/
	public void setDetail(String value) {
		this.inputs.setInput("Detail", value);
	}


	/** 
	Set the value of the FirstYearRange input for this Choreo. 

	@param Integer - (conditional, integer) Specifies the first year in a range of years; if used, must be used with LastYearRange and without FiscalYear.
	*/
	public void setFirstYearRange(Integer value) {
		this.inputs.setInput("FirstYearRange", value);
	}

	/** 
	Set the value of the FirstYearRange input for this Choreo as a String. 

	@param String - (conditional, integer) Specifies the first year in a range of years; if used, must be used with LastYearRange and without FiscalYear.
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
	Set the value of the MajAgency input for this Choreo. 

	@param String - (conditional, string) The 2-character code for a major governmental agency issuing contracts.
	*/
	public void setMajAgency(String value) {
		this.inputs.setInput("MajAgency", value);
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
	Set the value of the ModAgency input for this Choreo. 

	@param String - (conditional, string) The 4-digit code for a specific governmental agency issuing contracts.
	*/
	public void setModAgency(String value) {
		this.inputs.setInput("ModAgency", value);
	}


	/** 
	Set the value of the PIID input for this Choreo. 

	@param Integer - (conditional, integer) A Federal ID number for the contract.
	*/
	public void setPIID(Integer value) {
		this.inputs.setInput("PIID", value);
	}

	/** 
	Set the value of the PIID input for this Choreo as a String. 

	@param String - (conditional, integer) A Federal ID number for the contract.
	*/
	public void setPIID(String value) {
		this.inputs.setInput("PIID", value);	
	}
	/** 
	Set the value of the PSC input for this Choreo. 

	@param String - (conditional, string) The 4-character code for a product or service.
	*/
	public void setPSC(String value) {
		this.inputs.setInput("PSC", value);
	}


	/** 
	Set the value of the PSCCategory input for this Choreo. 

	@param String - (conditional, string) The 2-character code for a major product or service category.
	*/
	public void setPSCCategory(String value) {
		this.inputs.setInput("PSCCategory", value);
	}


	/** 
	Set the value of the PopCountryCode input for this Choreo. 

	@param String - (conditional, string) The two-letter country code for the place of performance country.
	*/
	public void setPopCountryCode(String value) {
		this.inputs.setInput("PopCountryCode", value);
	}


	/** 
	Set the value of the PopDistrict input for this Choreo. 

	@param String - (conditional, string) The Congressional District of the place of performance.
	*/
	public void setPopDistrict(String value) {
		this.inputs.setInput("PopDistrict", value);
	}


	/** 
	Set the value of the PopZipCode input for this Choreo. 

	@param Integer - (conditional, integer) The ZIP code of the place of performance.
	*/
	public void setPopZipCode(Integer value) {
		this.inputs.setInput("PopZipCode", value);
	}

	/** 
	Set the value of the PopZipCode input for this Choreo as a String. 

	@param String - (conditional, integer) The ZIP code of the place of performance.
	*/
	public void setPopZipCode(String value) {
		this.inputs.setInput("PopZipCode", value);	
	}
	/** 
	Set the value of the SortBy input for this Choreo. 

	@param String - (optional, string) Determines how records are sorted. Valid values: r (contractor/recipient name), f (dollars of awards),g (major contracting agency),p (Product or Service Category),d (date of award). Defaults to f.
	*/
	public void setSortBy(String value) {
		this.inputs.setInput("SortBy", value);
	}


	/** 
	Set the value of the State input for this Choreo. 

	@param String - (conditional, string) The state abbreviation within a contractor's address.
	*/
	public void setState(String value) {
		this.inputs.setInput("State", value);
	}


	/** 
	Set the value of the StateCode input for this Choreo. 

	@param String - (conditional, string) The state abbreviation of the state of the place of performance.
	*/
	public void setStateCode(String value) {
		this.inputs.setInput("StateCode", value);
	}


	/** 
	Set the value of the TextSearch input for this Choreo. 

	@param String - (conditional, string) Free text search within the text that describes what the contract is for.
	*/
	public void setTextSearch(String value) {
		this.inputs.setInput("TextSearch", value);
	}


	/** 
	Set the value of the VendorCountryCode input for this Choreo. 

	@param String - (conditional, string) The two-letter country code for the country in a contractor's address.
	*/
	public void setVendorCountryCode(String value) {
		this.inputs.setInput("VendorCountryCode", value);
	}


	/** 
	Set the value of the VendorDistrict input for this Choreo. 

	@param String - (conditional, string) The 4-character Congressional District within which a contractor is located.
	*/
	public void setVendorDistrict(String value) {
		this.inputs.setInput("VendorDistrict", value);
	}


	/** 
	Set the value of the ZipCode input for this Choreo. 

	@param Integer - (conditional, integer) The ZIP code within a contractor's address.
	*/
	public void setZipCode(Integer value) {
		this.inputs.setInput("ZipCode", value);
	}

	/** 
	Set the value of the ZipCode input for this Choreo as a String. 

	@param String - (conditional, integer) The ZIP code within a contractor's address.
	*/
	public void setZipCode(String value) {
		this.inputs.setInput("ZipCode", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ContractsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ContractsResultSet(result);
	}
	
}
