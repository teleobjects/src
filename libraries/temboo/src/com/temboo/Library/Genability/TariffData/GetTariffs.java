package com.temboo.Library.Genability.TariffData;

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
GetTariffs

Returns a list of Tariff objects based a specified search criteria.
*/
public class GetTariffs extends Choreography {

	/**
	Create a new instance of the GetTariffs Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetTariffs(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Genability/TariffData/GetTariffs"));
	}

	/** 
	Set the value of the AccountID input for this Choreo. 

	@param String - (optional, string) The unique ID of the Account to find tariffs for. Values passed in will override those from the Account.
	*/
	public void setAccountID(String value) {
		this.inputs.setInput("AccountID", value);
	}


	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (conditional, string) The App ID provided by Genability.
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the AppKey input for this Choreo. 

	@param String - (required, string) The App Key provided by Genability.
	*/
	public void setAppKey(String value) {
		this.inputs.setInput("AppKey", value);
	}


	/** 
	Set the value of the CustomerClasses input for this Choreo. 

	@param String - (optional, string) Returns only these customer classes. Valid values are: RESIDENTIAL, GENERAL.
	*/
	public void setCustomerClasses(String value) {
		this.inputs.setInput("CustomerClasses", value);
	}


	/** 
	Set the value of the EffectiveOn input for this Choreo. 

	@param String - (optional, date) Returns only tariffs that are effective on this date.
	*/
	public void setEffectiveOn(String value) {
		this.inputs.setInput("EffectiveOn", value);
	}


	/** 
	Set the value of the EndsWith input for this Choreo. 

	@param String - (optional, string) When true, the search will only return results that end with the specified search string. Otherwise, any match of the search string will be returned as a result.
	*/
	public void setEndsWith(String value) {
		this.inputs.setInput("EndsWith", value);
	}


	/** 
	Set the value of the FromDateTime input for this Choreo. 

	@param String - (optional, date) Returns only tariffs that are effective on or after this date.
	*/
	public void setFromDateTime(String value) {
		this.inputs.setInput("FromDateTime", value);
	}


	/** 
	Set the value of the IsRegex input for this Choreo. 

	@param Boolean - (optional, boolean) When true, the provided search string will be regarded as a regular expression and the search will return results matching the regular expression.
	*/
	public void setIsRegex(Boolean value) {
		this.inputs.setInput("IsRegex", value);
	}

	/** 
	Set the value of the IsRegex input for this Choreo as a String. 

	@param String - (optional, boolean) When true, the provided search string will be regarded as a regular expression and the search will return results matching the regular expression.
	*/
	public void setIsRegex(String value) {
		this.inputs.setInput("IsRegex", value);	
	}
	/** 
	Set the value of the LSEID input for this Choreo. 

	@param Integer - (optional, integer) Filter tariffs for a specific LSE.
	*/
	public void setLSEID(Integer value) {
		this.inputs.setInput("LSEID", value);
	}

	/** 
	Set the value of the LSEID input for this Choreo as a String. 

	@param String - (optional, integer) Filter tariffs for a specific LSE.
	*/
	public void setLSEID(String value) {
		this.inputs.setInput("LSEID", value);	
	}
	/** 
	Set the value of the PageCount input for this Choreo. 

	@param Integer - (optional, integer) The number of results to return. Defaults to 25.
	*/
	public void setPageCount(Integer value) {
		this.inputs.setInput("PageCount", value);
	}

	/** 
	Set the value of the PageCount input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to return. Defaults to 25.
	*/
	public void setPageCount(String value) {
		this.inputs.setInput("PageCount", value);	
	}
	/** 
	Set the value of the PageStart input for this Choreo. 

	@param Integer - (optional, integer) The page number to begin the result set from. Defaults to 1.
	*/
	public void setPageStart(Integer value) {
		this.inputs.setInput("PageStart", value);
	}

	/** 
	Set the value of the PageStart input for this Choreo as a String. 

	@param String - (optional, integer) The page number to begin the result set from. Defaults to 1.
	*/
	public void setPageStart(String value) {
		this.inputs.setInput("PageStart", value);	
	}
	/** 
	Set the value of the PopulateProperties input for this Choreo. 

	@param Boolean - (optional, boolean) Set to "true" to populate the properties for the returned Tariffs.
	*/
	public void setPopulateProperties(Boolean value) {
		this.inputs.setInput("PopulateProperties", value);
	}

	/** 
	Set the value of the PopulateProperties input for this Choreo as a String. 

	@param String - (optional, boolean) Set to "true" to populate the properties for the returned Tariffs.
	*/
	public void setPopulateProperties(String value) {
		this.inputs.setInput("PopulateProperties", value);	
	}
	/** 
	Set the value of the PopulateRates input for this Choreo. 

	@param Boolean - (optional, boolean) Set to "true" to populate the rate details for the returned Tariffs.
	*/
	public void setPopulateRates(Boolean value) {
		this.inputs.setInput("PopulateRates", value);
	}

	/** 
	Set the value of the PopulateRates input for this Choreo as a String. 

	@param String - (optional, boolean) Set to "true" to populate the rate details for the returned Tariffs.
	*/
	public void setPopulateRates(String value) {
		this.inputs.setInput("PopulateRates", value);	
	}
	/** 
	Set the value of the Search input for this Choreo. 

	@param String - (optional, string) The string of text to search on. This can also be a regular expression, in which case you should set the 'isRegex' flag to true.
	*/
	public void setSearch(String value) {
		this.inputs.setInput("Search", value);
	}


	/** 
	Set the value of the SearchOn input for this Choreo. 

	@param String - (optional, string) Comma separated list of fields to query on. When searchOn is specified, the text provided in the search string field will be searched within these fields.
	*/
	public void setSearchOn(String value) {
		this.inputs.setInput("SearchOn", value);
	}


	/** 
	Set the value of the SortOn input for this Choreo. 

	@param String - (optional, string) Comma separated list of fields to sort on.
	*/
	public void setSortOn(String value) {
		this.inputs.setInput("SortOn", value);
	}


	/** 
	Set the value of the SortOrder input for this Choreo. 

	@param String - (optional, string) Comma separated list of ordering. Possible values are 'ASC' and 'DESC'. Default is 'ASC'. This list corresponds to the field list used in the SortOn input.
	*/
	public void setSortOrder(String value) {
		this.inputs.setInput("SortOrder", value);
	}


	/** 
	Set the value of the StartsWith input for this Choreo. 

	@param Boolean - (optional, boolean) When true, the search will only return results that begin with the specified search string. Otherwise, any match of the search string will be returned as a result.
	*/
	public void setStartsWith(Boolean value) {
		this.inputs.setInput("StartsWith", value);
	}

	/** 
	Set the value of the StartsWith input for this Choreo as a String. 

	@param String - (optional, boolean) When true, the search will only return results that begin with the specified search string. Otherwise, any match of the search string will be returned as a result.
	*/
	public void setStartsWith(String value) {
		this.inputs.setInput("StartsWith", value);	
	}
	/** 
	Set the value of the TariffTypes input for this Choreo. 

	@param String - (optional, string) Returns only these tariff types. Valid values are: DEFAULT, ALTERNATIVE, OPTIONAL_EXTRA, RIDER.
	*/
	public void setTariffTypes(String value) {
		this.inputs.setInput("TariffTypes", value);
	}


	/** 
	Set the value of the ToDateTime input for this Choreo. 

	@param String - (optional, date) Returns only tariffs that are effective on or before this date.
	*/
	public void setToDateTime(String value) {
		this.inputs.setInput("ToDateTime", value);
	}


	/** 
	Set the value of the ZipCode input for this Choreo. 

	@param String - (optional, string) Return tariffs for a given zip or post code.
	*/
	public void setZipCode(String value) {
		this.inputs.setInput("ZipCode", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetTariffsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetTariffsResultSet(result);
	}
	
}
