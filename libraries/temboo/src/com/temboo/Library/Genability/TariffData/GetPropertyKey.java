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
GetPropertyKey

Returns an individual Property Key using a given key name.
*/
public class GetPropertyKey extends Choreography {

	/**
	Create a new instance of the GetPropertyKey Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetPropertyKey(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Genability/TariffData/GetPropertyKey"));
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
	Set the value of the KeyName input for this Choreo. 

	@param String - (required, string) The key name for the property key you want to return.
	*/
	public void setKeyName(String value) {
		this.inputs.setInput("KeyName", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetPropertyKeyResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetPropertyKeyResultSet(result);
	}
	
}
