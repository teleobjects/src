package com.temboo.Library.CloudMine.UserAccountManagement;

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
CreateAccount

Creates a user account with a given username and password.
*/
public class CreateAccount extends Choreography {

	/**
	Create a new instance of the CreateAccount Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateAccount(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/CloudMine/UserAccountManagement/CreateAccount"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by CloudMine after registering your app.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the ApplicationIdentifier input for this Choreo. 

	@param String - (required, string) The application identifier provided by CloudMine after registering your app.
	*/
	public void setApplicationIdentifier(String value) {
		this.inputs.setInput("ApplicationIdentifier", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) The latitude coordinate of the user's location. If provide, Longitude is also required.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (optional, decimal) The latitude coordinate of the user's location. If provide, Longitude is also required.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) The longitude coordinate of the user's location. If provide, Latitude is also required.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (optional, decimal) The longitude coordinate of the user's location. If provide, Latitude is also required.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (optional, string) A name to associated with the user profile information.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, string) The password for the account that is being created.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) The username for the account that is being created.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateAccountResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateAccountResultSet(result);
	}
	
}
