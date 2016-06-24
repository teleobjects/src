package com.temboo.Library.ConstantContact;

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
ListAllContacts

Retrieves a list of all contacts from Constant Contact.
*/
public class ListAllContacts extends Choreography {

	/**
	Create a new instance of the ListAllContacts Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListAllContacts(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/ConstantContact/ListAllContacts"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Constant Contact.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the NextResults input for this Choreo. 

	@param String - (optional, string) The URI returned in the "NextPage" output of this Choreo. This value is used to retrieve the next 50 results.
	*/
	public void setNextResults(String value) {
		this.inputs.setInput("NextResults", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) Your Constant Contact password.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the UserName input for this Choreo. 

	@param String - (required, string) Your Constant Contact username.
	*/
	public void setUserName(String value) {
		this.inputs.setInput("UserName", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListAllContactsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListAllContactsResultSet(result);
	}
	
}
