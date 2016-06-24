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
CalculateTariffInputMetaData

Retrieve inputs required to run a calculation for the specified tariff, within a specified period of time.
*/
public class CalculateTariffInputMetaData extends Choreography {

	/**
	Create a new instance of the CalculateTariffInputMetaData Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CalculateTariffInputMetaData(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Genability/PricingAndCalc/CalculateTariffInputMetaData"));
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
	Set the value of the BillingPeriod input for this Choreo. 

	@param String - (optional, string) Specify whether results retireved should be based on a billing period, or not.  Default is set to: false.
	*/
	public void setBillingPeriod(String value) {
		this.inputs.setInput("BillingPeriod", value);
	}


	/** 
	Set the value of the CityLimits input for this Choreo. 

	@param String - (optional, string) Specify whether electricity pricing information should be restricted to city limits, or not.  Example input value: Inside.
	*/
	public void setCityLimits(String value) {
		this.inputs.setInput("CityLimits", value);
	}


	/** 
	Set the value of the ConnectionType input for this Choreo. 

	@param String - (optional, string) The connection type.  For example: Primary.
	*/
	public void setConnectionType(String value) {
		this.inputs.setInput("ConnectionType", value);
	}


	/** 
	Set the value of the FromDateTime input for this Choreo. 

	@param String - (required, string) The date and time of the requested start of the price query. Must be in ISO 8601 format.  Example: 2012-06-12T00:00:00.0-0700
	*/
	public void setFromDateTime(String value) {
		this.inputs.setInput("FromDateTime", value);
	}


	/** 
	Set the value of the GroupBy input for this Choreo. 

	@param String - (optional, string) Specify how calculation details are displayed.  For example retrieved details can be grouped by month, or year. Options include: Daily, Weekly, Month, Year.
	*/
	public void setGroupBy(String value) {
		this.inputs.setInput("GroupBy", value);
	}


	/** 
	Set the value of the KeyName input for this Choreo. 

	@param String - (optional, string) An applicability value.  If an error is returned, indicating the need for an extra applicability parameter, use this variable to set the parameter name.  For example: territoryID.
	*/
	public void setKeyName(String value) {
		this.inputs.setInput("KeyName", value);
	}


	/** 
	Set the value of the KeyValue input for this Choreo. 

	@param String - (conditional, string) The value for the specified KeyName variable. For example if KeyName is set to territoryID, you could provide 3385 for the KeyValue input.
	*/
	public void setKeyValue(String value) {
		this.inputs.setInput("KeyValue", value);
	}


	/** 
	Set the value of the MasterTariffID input for this Choreo. 

	@param String - (required, string) A Genability tariff ID.
	*/
	public void setMasterTariffID(String value) {
		this.inputs.setInput("MasterTariffID", value);
	}


	/** 
	Set the value of the ToDateTime input for this Choreo. 

	@param String - (required, string) The date and time of the requested start of the price query. Must be in ISO 8601 format.  Example: 2012-06-12T00:00:00.0-0700
	*/
	public void setToDateTime(String value) {
		this.inputs.setInput("ToDateTime", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CalculateTariffInputMetaDataResultSet run() {
		JSONObject result = super.runWithResults();
		return new CalculateTariffInputMetaDataResultSet(result);
	}
	
}
