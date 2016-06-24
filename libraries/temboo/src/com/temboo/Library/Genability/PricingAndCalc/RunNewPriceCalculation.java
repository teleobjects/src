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
RunNewPriceCalculation

Calculate electricity costs based on a POSTed calculation criteria. 
*/
public class RunNewPriceCalculation extends Choreography {

	/**
	Create a new instance of the RunNewPriceCalculation Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RunNewPriceCalculation(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Genability/PricingAndCalc/RunNewPriceCalculation"));
	}

	/** 
	Set the value of the POSTData input for this Choreo. 

	@param String - (required, json) The POST payload in JSON format.
	*/
	public void setPOSTData(String value) {
		this.inputs.setInput("POSTData", value);
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
	Set the value of the MasterTariffID input for this Choreo. 

	@param String - (required, string) A Genability tariff ID.
	*/
	public void setMasterTariffID(String value) {
		this.inputs.setInput("MasterTariffID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RunNewPriceCalculationResultSet run() {
		JSONObject result = super.runWithResults();
		return new RunNewPriceCalculationResultSet(result);
	}
	
}
