package com.temboo.Library.Kiva.Loans;

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
SearchLoans

Returns a keyword search for loan listings by multiple criteria.
*/
public class SearchLoans extends Choreography {

	/**
	Create a new instance of the SearchLoans Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchLoans(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Kiva/Loans/SearchLoans"));
	}

	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (optional, string) Your unique application ID, usually in reverse DNS notation.
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the CountryCode input for this Choreo. 

	@param String - (optional, string) A list of two-character ISO codes of countries by which to filter results.
	*/
	public void setCountryCode(String value) {
		this.inputs.setInput("CountryCode", value);
	}


	/** 
	Set the value of the Gender input for this Choreo. 

	@param String - (optional, string) If supplied, results are filtered to loans with entrepreneurs of the specified gender. In the case of group loans, this matches against the predominate gender in the group: male or female.
	*/
	public void setGender(String value) {
		this.inputs.setInput("Gender", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page position of results to return. Defaults to 1.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page position of results to return. Defaults to 1.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the Partner input for this Choreo. 

	@param String - (optional, string) A list of partner IDs for which to filter results.
	*/
	public void setPartner(String value) {
		this.inputs.setInput("Partner", value);
	}


	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (optional, string) A query string against which results should be returned.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the Region input for this Choreo. 

	@param String - (optional, string) List of two-letter codes corresponding to regions in which Kiva operates. If supplied, results are filtered to loans only from the specified regions: na, ca, sa, af, as, me, ee.
	*/
	public void setRegion(String value) {
		this.inputs.setInput("Region", value);
	}


	/** 
	Set the value of the ResponseType input for this Choreo. 

	@param String - (optional, string) Output returned can be XML or JSON. Defaults to JSON.
	*/
	public void setResponseType(String value) {
		this.inputs.setInput("ResponseType", value);
	}


	/** 
	Set the value of the Sector input for this Choreo. 

	@param String - (optional, string) A list of business sectors for which to filter results.
	*/
	public void setSector(String value) {
		this.inputs.setInput("Sector", value);
	}


	/** 
	Set the value of the SortBy input for this Choreo. 

	@param String - (optional, string) The order by which to sort results. Acceptable values: popularity, loan_amount, oldest, expiration, newest, amount_remaining, repayment_term. Defaults to newest.
	*/
	public void setSortBy(String value) {
		this.inputs.setInput("SortBy", value);
	}


	/** 
	Set the value of the Status input for this Choreo. 

	@param String - (optional, string) The status of loans to return: fundraising, funded, in_repayment, paid, ended_with_loss.
	*/
	public void setStatus(String value) {
		this.inputs.setInput("Status", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchLoansResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchLoansResultSet(result);
	}
	
}
