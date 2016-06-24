package com.temboo.Library.SendGrid.NewsletterAPI.Lists;

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
CreateRecipientList

Create a new recipient list.
*/
public class CreateRecipientList extends Choreography {

	/**
	Create a new instance of the CreateRecipientList Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateRecipientList(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/SendGrid/NewsletterAPI/Lists/CreateRecipientList"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key obtained from SendGrid.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APIUser input for this Choreo. 

	@param String - (required, string) The username registered with SendGrid. 
	*/
	public void setAPIUser(String value) {
		this.inputs.setInput("APIUser", value);
	}


	/** 
	Set the value of the ColumnName input for this Choreo. 

	@param String - (optional, string) An additional column name.
	*/
	public void setColumnName(String value) {
		this.inputs.setInput("ColumnName", value);
	}


	/** 
	Set the value of the List input for this Choreo. 

	@param String - (required, string) The name of the recipient list that is being created.
	*/
	public void setList(String value) {
		this.inputs.setInput("List", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (optional, string) The column name to be associated with email addresses.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format of the response from SendGrid. Specify json, or xml.  Default is set to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - 
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateRecipientListResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateRecipientListResultSet(result);
	}
	
}
