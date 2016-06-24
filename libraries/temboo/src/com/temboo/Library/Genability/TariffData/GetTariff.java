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
GetTariff

Returns an individual Tariff object with a given id.
*/
public class GetTariff extends Choreography {

	/**
	Create a new instance of the GetTariff Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetTariff(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Genability/TariffData/GetTariff"));
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
	Set the value of the MasterTariffID input for this Choreo. 

	@param Integer - (required, integer) The master tariff id. This can be retrieved in the output of the GetTariffs Choreo.
	*/
	public void setMasterTariffID(Integer value) {
		this.inputs.setInput("MasterTariffID", value);
	}

	/** 
	Set the value of the MasterTariffID input for this Choreo as a String. 

	@param String - (required, integer) The master tariff id. This can be retrieved in the output of the GetTariffs Choreo.
	*/
	public void setMasterTariffID(String value) {
		this.inputs.setInput("MasterTariffID", value);	
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
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetTariffResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetTariffResultSet(result);
	}
	
}
