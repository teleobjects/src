package com.temboo.Library.Genability.PricingAndCalc;

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
GetPrice

Retrieves the consumption price of a specified Tariff over a given date range.
*/
public class GetPrice extends Choreography {

	/**
	Create a new instance of the GetPrice Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetPrice(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Genability/PricingAndCalc/GetPrice"));
	}

	/** 
	Set the value of the AccountID input for this Choreo. 

	@param String - (optional, string) A Genability ID for an account. More info on Accounts is available here: http://developer.genability.com/documentation/api-reference/account-api/account
	*/
	public void setAccountID(String value) {
		this.inputs.setInput("AccountID", value);
	}


	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (required, string) The App ID provided by Genability.
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
	Set the value of the ConsumptionAmount input for this Choreo. 

	@param BigDecimal - (optional, decimal) Specify a monthly consumption in kWh. By default the highest banded level of consumption is used.
	*/
	public void setConsumptionAmount(BigDecimal value) {
		this.inputs.setInput("ConsumptionAmount", value);
	}

	/** 
	Set the value of the ConsumptionAmount input for this Choreo as a String. 

	@param String - (optional, decimal) Specify a monthly consumption in kWh. By default the highest banded level of consumption is used.
	*/
	public void setConsumptionAmount(String value) {
		this.inputs.setInput("ConsumptionAmount", value);	
	}
	/** 
	Set the value of the DemandAmount input for this Choreo. 

	@param BigDecimal - (optional, decimal) Specify a monthly demand in kWh. By default the highest banded level of demand is used.
	*/
	public void setDemandAmount(BigDecimal value) {
		this.inputs.setInput("DemandAmount", value);
	}

	/** 
	Set the value of the DemandAmount input for this Choreo as a String. 

	@param String - (optional, decimal) Specify a monthly demand in kWh. By default the highest banded level of demand is used.
	*/
	public void setDemandAmount(String value) {
		this.inputs.setInput("DemandAmount", value);	
	}
	/** 
	Set the value of the FromDateTime input for this Choreo. 

	@param String - (required, string) The date and time of the requested start of the price query. Must be in ISO 8601 format.  Example: 2012-06-12T00:00:00.0-0700
	*/
	public void setFromDateTime(String value) {
		this.inputs.setInput("FromDateTime", value);
	}


	/** 
	Set the value of the MasterTariffID input for this Choreo. 

	@param String - (optional, string) A Genability tariff ID. Not required, if AccountID is specified.
	*/
	public void setMasterTariffID(String value) {
		this.inputs.setInput("MasterTariffID", value);
	}


	/** 
	Set the value of the PageCount input for this Choreo. 

	@param Integer - (optional, integer) The number of results to be returned. Defailt is set to: 25.
	*/
	public void setPageCount(Integer value) {
		this.inputs.setInput("PageCount", value);
	}

	/** 
	Set the value of the PageCount input for this Choreo as a String. 

	@param String - (optional, integer) The number of results to be returned. Defailt is set to: 25.
	*/
	public void setPageCount(String value) {
		this.inputs.setInput("PageCount", value);	
	}
	/** 
	Set the value of the PageStart input for this Choreo. 

	@param Integer - (optional, integer) The page number to start to display results from. If unspecified, the first page of results will be returned.
	*/
	public void setPageStart(Integer value) {
		this.inputs.setInput("PageStart", value);
	}

	/** 
	Set the value of the PageStart input for this Choreo as a String. 

	@param String - (optional, integer) The page number to start to display results from. If unspecified, the first page of results will be returned.
	*/
	public void setPageStart(String value) {
		this.inputs.setInput("PageStart", value);	
	}
	/** 
	Set the value of the ProfileID input for this Choreo. 

	@param String - (optional, string) The Genability ID of a profile. This ID can be passed instead of consumptionAmount or demandAmount.
	*/
	public void setProfileID(String value) {
		this.inputs.setInput("ProfileID", value);
	}


	/** 
	Set the value of the ProviderAccountID input for this Choreo. 

	@param String - (optional, string) A unique ID for an Account. Same as AccountId, however your unique ID can be used instead of the Genability Account ID.
	*/
	public void setProviderAccountID(String value) {
		this.inputs.setInput("ProviderAccountID", value);
	}


	/** 
	Set the value of the TerritoryID input for this Choreo. 

	@param String - (optional, string) Return rate changes for the specified Territory.
	*/
	public void setTerritoryID(String value) {
		this.inputs.setInput("TerritoryID", value);
	}


	/** 
	Set the value of the ToDateTime input for this Choreo. 

	@param String - (optional, string) The date and time of the requested start of the price query. Must be in ISO 8601 format.  Example: 2012-06-12T00:00:00.0-0700
	*/
	public void setToDateTime(String value) {
		this.inputs.setInput("ToDateTime", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetPriceResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetPriceResultSet(result);
	}
	
}
