package com.temboo.Library.Wordnik.WordLists;

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
CreateWordList

Creates a new word list for the specified user.
*/
public class CreateWordList extends Choreography {

	/**
	Create a new instance of the CreateWordList Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateWordList(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Wordnik/WordLists/CreateWordList"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key obtained from Wordnik.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the ListDescription input for this Choreo. 

	@param String - (required, string) A description of the list to create.
	*/
	public void setListDescription(String value) {
		this.inputs.setInput("ListDescription", value);
	}


	/** 
	Set the value of the ListName input for this Choreo. 

	@param String - (required, string) Name of list to create.
	*/
	public void setListName(String value) {
		this.inputs.setInput("ListName", value);
	}


	/** 
	Set the value of the ListStatus input for this Choreo. 

	@param String - (optional, string) Determines whether the list to cretae is public or private. Acceptable values: PUBLIC or PRIVATE.
	*/
	public void setListStatus(String value) {
		this.inputs.setInput("ListStatus", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, string) The Password of the Wordnik account.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) The Username of the Wordnik account.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateWordListResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateWordListResultSet(result);
	}
	
}
