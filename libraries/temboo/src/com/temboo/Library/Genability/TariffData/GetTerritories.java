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
GetTerritories

Returns a list of Territory objects based a specified search criteria.
*/
public class GetTerritories extends Choreography {

	/**
	Create a new instance of the GetTerritories Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetTerritories(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Genability/TariffData/GetTerritories"));
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
	Set the value of the ContainsItemType input for this Choreo. 

	@param String - (optional, string) Filters the result set to include a particular type of territory. Valid values are: CITY, ZIPCODE, STATE, COUNTY.
	*/
	public void setContainsItemType(String value) {
		this.inputs.setInput("ContainsItemType", value);
	}


	/** 
	Set the value of the ContainsItemValue input for this Choreo. 

	@param String - (optional, string) Used in combination with the ContainsItemType value. Filters the Types by this value.
	*/
	public void setContainsItemValue(String value) {
		this.inputs.setInput("ContainsItemValue", value);
	}


	/** 
	Set the value of the EndsWith input for this Choreo. 

	@param String - (optional, string) When true, the search will only return results that end with the specified search string. Otherwise, any match of the search string will be returned as a result.
	*/
	public void setEndsWith(String value) {
		this.inputs.setInput("EndsWith", value);
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

	@param Integer - (optional, integer) Filters the result set to only include territories within this LSE ID.
	*/
	public void setLSEID(Integer value) {
		this.inputs.setInput("LSEID", value);
	}

	/** 
	Set the value of the LSEID input for this Choreo as a String. 

	@param String - (optional, integer) Filters the result set to only include territories within this LSE ID.
	*/
	public void setLSEID(String value) {
		this.inputs.setInput("LSEID", value);	
	}
	/** 
	Set the value of the MasterTariffID input for this Choreo. 

	@param Integer - (optional, integer) For tariffs with prices varying by geographic location, this will return the list of those territories covered by this tariff.
	*/
	public void setMasterTariffID(Integer value) {
		this.inputs.setInput("MasterTariffID", value);
	}

	/** 
	Set the value of the MasterTariffID input for this Choreo as a String. 

	@param String - (optional, integer) For tariffs with prices varying by geographic location, this will return the list of those territories covered by this tariff.
	*/
	public void setMasterTariffID(String value) {
		this.inputs.setInput("MasterTariffID", value);	
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
	Set the value of the PopulateItems input for this Choreo. 

	@param Boolean - (optional, boolean) If set to "true", returns a list of territory items for each territory in the result set.
	*/
	public void setPopulateItems(Boolean value) {
		this.inputs.setInput("PopulateItems", value);
	}

	/** 
	Set the value of the PopulateItems input for this Choreo as a String. 

	@param String - (optional, boolean) If set to "true", returns a list of territory items for each territory in the result set.
	*/
	public void setPopulateItems(String value) {
		this.inputs.setInput("PopulateItems", value);	
	}
	/** 
	Set the value of the PopulateLSES input for this Choreo. 

	@param String - (optional, string) If set to "true", the response includes a list of TerritoryLses which are all the LSEs providing service in this territory.
	*/
	public void setPopulateLSES(String value) {
		this.inputs.setInput("PopulateLSES", value);
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
	Set the value of the UsageTypes input for this Choreo. 

	@param String - (optional, string) Filters the result set to only include territories of the specified usageType. valid values are: SERVICE, TARIFF.
	*/
	public void setUsageTypes(String value) {
		this.inputs.setInput("UsageTypes", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetTerritoriesResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetTerritoriesResultSet(result);
	}
	
}
