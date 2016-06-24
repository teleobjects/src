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
GetLoadServingEntity

Returns a Load Serving Entity with a given ID.
*/
public class GetLoadServingEntity extends Choreography {

	/**
	Create a new instance of the GetLoadServingEntity Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetLoadServingEntity(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Genability/TariffData/GetLoadServingEntity"));
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
	Set the value of the LSEID input for this Choreo. 

	@param Integer - (required, integer) The id of a particular Load Serving Entity to return.
	*/
	public void setLSEID(Integer value) {
		this.inputs.setInput("LSEID", value);
	}

	/** 
	Set the value of the LSEID input for this Choreo as a String. 

	@param String - (required, integer) The id of a particular Load Serving Entity to return.
	*/
	public void setLSEID(String value) {
		this.inputs.setInput("LSEID", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetLoadServingEntityResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetLoadServingEntityResultSet(result);
	}
	
}
