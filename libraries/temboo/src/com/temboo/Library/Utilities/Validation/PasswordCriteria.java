package com.temboo.Library.Utilities.Validation;

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
PasswordCriteria

Verifies that a given password matches a standard pattern for passwords.
*/
public class PasswordCriteria extends Choreography {

	/**
	Create a new instance of the PasswordCriteria Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PasswordCriteria(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Validation/PasswordCriteria"));
	}

	/** 
	Set the value of the MaxLength input for this Choreo. 

	@param Integer - (optional, integer) The max length you want to allow for the password. Defaults to 14.
	*/
	public void setMaxLength(Integer value) {
		this.inputs.setInput("MaxLength", value);
	}

	/** 
	Set the value of the MaxLength input for this Choreo as a String. 

	@param String - (optional, integer) The max length you want to allow for the password. Defaults to 14.
	*/
	public void setMaxLength(String value) {
		this.inputs.setInput("MaxLength", value);	
	}
	/** 
	Set the value of the MinLength input for this Choreo. 

	@param Integer - (optional, integer) The minimum length you want to allow for the password. Defaults to 6.
	*/
	public void setMinLength(Integer value) {
		this.inputs.setInput("MinLength", value);
	}

	/** 
	Set the value of the MinLength input for this Choreo as a String. 

	@param String - (optional, integer) The minimum length you want to allow for the password. Defaults to 6.
	*/
	public void setMinLength(String value) {
		this.inputs.setInput("MinLength", value);	
	}
	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, string) The password to validate.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PasswordCriteriaResultSet run() {
		JSONObject result = super.runWithResults();
		return new PasswordCriteriaResultSet(result);
	}
	
}
