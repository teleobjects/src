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
Assistance

Allows access to the information in the Federal Assisatance Award Data System (FAADS) database, which reports all financial assistance made by federal agencies.
*/
public class Assistance extends Choreography {

	/**
	Create a new instance of the Assistance Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Assistance(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/FedSpending/Assistance"));
	}

	/** 
	Set the value of the AgencyCode input for this Choreo. 

	@param String - (conditional, string) The 4-character code for a specific governmental agency providing assistance.
	*/
	public void setAgencyCode(String value) {
		this.inputs.setInput("AgencyCode", value);
	}


	/** 
	Set the value of the AssistanceType input for this Choreo. 

	@param String - (conditional, string) The type of assistance provided. Valid values are: d = Direct Payments (specified and unrestricted), g = Grants and Cooperative Agreements, i = Insurance, l = Loans (direct and guaranteed), o = Other.
	*/
	public void setAssistanceType(String value) {
		this.inputs.setInput("AssistanceType", value);
	}


	/** 
	Set the value of the CFDAProgram input for this Choreo. 

	@param String - (conditional, string) An ID for the governmental program.
	*/
	public void setCFDAProgram(String value) {
		this.inputs.setInput("CFDAProgram", value);
	}


	/** 
	Set the value of the Detail input for this Choreo. 

	@param String - (optional, string) Controls the level of detail of the output. Acceptable values: -1 (summary), 0 (low), 1 (medium), 2 (high), and 3 (extensive). Defaults to -1. See docs for more information.
	*/
	public void setDetail(String value) {
		this.inputs.setInput("Detail", value);
	}


	/** 
	Set the value of the FederalID input for this Choreo. 

	@param String - (conditional, string) A Federal ID for the award.
	*/
	public void setFederalID(String value) {
		this.inputs.setInput("FederalID", value);
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

	@param Integer - (conditional, integer) Specifies a single year from 2000-2006; defaults to all years.
	*/
	public void setFiscalYear(Integer value) {
		this.inputs.setInput("FiscalYear", value);
	}

	/** 
	Set the value of the FiscalYear input for this Choreo as a String. 

	@param String - (conditional, integer) Specifies a single year from 2000-2006; defaults to all years.
	*/
	public void setFiscalYear(String value) {
		this.inputs.setInput("FiscalYear", value);	
	}
	/** 
	Set the value of the LastYearRange input for this Choreo. 

	@param Integer - (conditional, integer) Specifies the last year in a range of years from 2000-2006; if used, must be used with FirstYearRange and without FiscalYear.
	*/
	public void setLastYearRange(Integer value) {
		this.inputs.setInput("LastYearRange", value);
	}

	/** 
	Set the value of the LastYearRange input for this Choreo as a String. 

	@param String - (conditional, integer) Specifies the last year in a range of years from 2000-2006; if used, must be used with FirstYearRange and without FiscalYear.
	*/
	public void setLastYearRange(String value) {
		this.inputs.setInput("LastYearRange", value);	
	}
	/** 
	Set the value of the MajAgency input for this Choreo. 

	@param String - (conditional, string) The 2-character code for a major governmental agency providing assistance.
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
	Set the value of the PrincipalPlaceCC input for this Choreo. 

	@param String - (conditional, string) The city or county of the place of performance.
	*/
	public void setPrincipalPlaceCC(String value) {
		this.inputs.setInput("PrincipalPlaceCC", value);
	}


	/** 
	Set the value of the PrincipalPlaceStateCode input for this Choreo. 

	@param String - (conditional, string) The FIPS state code for the state of the place of performance.
	*/
	public void setPrincipalPlaceStateCode(String value) {
		this.inputs.setInput("PrincipalPlaceStateCode", value);
	}


	/** 
	Set the value of the RecipientCityName input for this Choreo. 

	@param String - (conditional, string) The city in the address of a recipient.
	*/
	public void setRecipientCityName(String value) {
		this.inputs.setInput("RecipientCityName", value);
	}


	/** 
	Set the value of the RecipientCountyName input for this Choreo. 

	@param String - (conditional, string) The county in which a recipient is located.
	*/
	public void setRecipientCountyName(String value) {
		this.inputs.setInput("RecipientCountyName", value);
	}


	/** 
	Set the value of the RecipientDistrict input for this Choreo. 

	@param String - (conditional, string) The Congressional District in which the recipient is located, formatted with four characters.
	*/
	public void setRecipientDistrict(String value) {
		this.inputs.setInput("RecipientDistrict", value);
	}


	/** 
	Set the value of the RecipientName input for this Choreo. 

	@param String - (conditional, string) The name of a recipient of assistance.
	*/
	public void setRecipientName(String value) {
		this.inputs.setInput("RecipientName", value);
	}


	/** 
	Set the value of the RecipientStateCode input for this Choreo. 

	@param String - (conditional, string) The FIPS state code for the state in the address of a recipient.
	*/
	public void setRecipientStateCode(String value) {
		this.inputs.setInput("RecipientStateCode", value);
	}


	/** 
	Set the value of the RecipientType input for this Choreo. 

	@param String - (conditional, string) The type of recipient. Valid values are: f = For Profits, g = Government,h = Higher Education, i = Individuals,n = Nonprofits, o = Other.
	*/
	public void setRecipientType(String value) {
		this.inputs.setInput("RecipientType", value);
	}


	/** 
	Set the value of the RecipientZip input for this Choreo. 

	@param Integer - (conditional, integer) The ZIP code in the address of a recipient.
	*/
	public void setRecipientZip(Integer value) {
		this.inputs.setInput("RecipientZip", value);
	}

	/** 
	Set the value of the RecipientZip input for this Choreo as a String. 

	@param String - (conditional, integer) The ZIP code in the address of a recipient.
	*/
	public void setRecipientZip(String value) {
		this.inputs.setInput("RecipientZip", value);	
	}
	/** 
	Set the value of the SortBy input for this Choreo. 

	@param String - (optional, string) Determines how records are sorted. Valid values: r (contractor/recipient name), f (dollars of awards),g (major contracting agency), p (CFDA Program), d (date of award). Defaults to f.
	*/
	public void setSortBy(String value) {
		this.inputs.setInput("SortBy", value);
	}


	/** 
	Set the value of the TextSearch input for this Choreo. 

	@param String - (conditional, string) A free text search on a description of the project.
	*/
	public void setTextSearch(String value) {
		this.inputs.setInput("TextSearch", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AssistanceResultSet run() {
		JSONObject result = super.runWithResults();
		return new AssistanceResultSet(result);
	}
	
}
