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
AddMultipleContacts

Creates multiple contacts in your Constant Contact list via the Activities bulk API.  The Choreo can use Excel or CSV files for the bulk upload.
*/
public class AddMultipleContacts extends Choreography {

	/**
	Create a new instance of the AddMultipleContacts Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddMultipleContacts(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/ConstantContact/AddMultipleContacts"));
	}

	/** 
	Set the value of the FileContents input for this Choreo. 

	@param String - (conditional, multiline) The file contents of the list you want to upload. Should be in CSV format.
	*/
	public void setFileContents(String value) {
		this.inputs.setInput("FileContents", value);
	}


	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Constant Contact.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the ListId input for this Choreo. 

	@param Integer - (required, integer) The numberic id for the list that you want to add contacts to.
	*/
	public void setListId(Integer value) {
		this.inputs.setInput("ListId", value);
	}

	/** 
	Set the value of the ListId input for this Choreo as a String. 

	@param String - (required, integer) The numberic id for the list that you want to add contacts to.
	*/
	public void setListId(String value) {
		this.inputs.setInput("ListId", value);	
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
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - (optional, vault file) A path to the vault CSV file you want to upload. Required unless using the FileContents input.
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddMultipleContactsResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddMultipleContactsResultSet(result);
	}
	
}
