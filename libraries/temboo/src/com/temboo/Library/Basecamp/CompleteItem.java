package com.temboo.Library.Basecamp;

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
CompleteItem

Marks a single, specified item in a To-do list as complete.
*/
public class CompleteItem extends Choreography {

	/**
	Create a new instance of the CompleteItem Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CompleteItem(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Basecamp/CompleteItem"));
	}

	/** 
	Set the value of the AccountName input for this Choreo. 

	@param String - (required, string) A valid Basecamp account name. This is the first part of the account's URL.
	*/
	public void setAccountName(String value) {
		this.inputs.setInput("AccountName", value);
	}


	/** 
	Set the value of the ItemID input for this Choreo. 

	@param Integer - (required, integer) The ID of the item to mark as complete.
	*/
	public void setItemID(Integer value) {
		this.inputs.setInput("ItemID", value);
	}

	/** 
	Set the value of the ItemID input for this Choreo as a String. 

	@param String - (required, integer) The ID of the item to mark as complete.
	*/
	public void setItemID(String value) {
		this.inputs.setInput("ItemID", value);	
	}
	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The Basecamp account password. Use the value 'X' when specifying an API Key for the Username input.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) A Basecamp account username or API Key.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CompleteItemResultSet run() {
		JSONObject result = super.runWithResults();
		return new CompleteItemResultSet(result);
	}
	
}
