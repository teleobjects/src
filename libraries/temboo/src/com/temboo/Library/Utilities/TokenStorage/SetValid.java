package com.temboo.Library.Utilities.TokenStorage;

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
SetValid

Sets a specified token as valid or invalid.
*/
public class SetValid extends Choreography {

	/**
	Create a new instance of the SetValid Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SetValid(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/TokenStorage/SetValid"));
	}

	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) The name of the token to modify.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the Valid input for this Choreo. 

	@param Boolean - (conditional, boolean) Can be set to true or false depending on whether the token is valid or not.
	*/
	public void setValid(Boolean value) {
		this.inputs.setInput("Valid", value);
	}

	/** 
	Set the value of the Valid input for this Choreo as a String. 

	@param String - (conditional, boolean) Can be set to true or false depending on whether the token is valid or not.
	*/
	public void setValid(String value) {
		this.inputs.setInput("Valid", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SetValidResultSet run() {
		JSONObject result = super.runWithResults();
		return new SetValidResultSet(result);
	}
	
}
