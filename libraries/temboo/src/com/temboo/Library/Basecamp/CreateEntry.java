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
CreateEntry

Creates a new calendar entry in a specified project.
*/
public class CreateEntry extends Choreography {

	/**
	Create a new instance of the CreateEntry Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateEntry(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Basecamp/CreateEntry"));
	}

	/** 
	Set the value of the AccountName input for this Choreo. 

	@param String - (required, string) A valid Basecamp account name. This is the first part of the account's URL.
	*/
	public void setAccountName(String value) {
		this.inputs.setInput("AccountName", value);
	}


	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (required, date) The date the entry ends, in YYYY-MM-DD format. This is the same as StartDate for one-day entries.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The Basecamp account password. Use the value 'X' when specifying an API Key for the Username input.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the ProjectID input for this Choreo. 

	@param Integer - (required, integer) The ID for the project in which to create the new entry.
	*/
	public void setProjectID(Integer value) {
		this.inputs.setInput("ProjectID", value);
	}

	/** 
	Set the value of the ProjectID input for this Choreo as a String. 

	@param String - (required, integer) The ID for the project in which to create the new entry.
	*/
	public void setProjectID(String value) {
		this.inputs.setInput("ProjectID", value);	
	}
	/** 
	Set the value of the ResponsibleParty input for this Choreo. 

	@param String - (optional, any) The user ID or company ID (preceded by a “c”, as in "c1234") to assign the entry to. Applies only to "Milestone" entry types.
	*/
	public void setResponsibleParty(String value) {
		this.inputs.setInput("ResponsibleParty", value);
	}


	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (required, date) The date the entry starts, in YYYY-MM-DD format.
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	/** 
	Set the value of the Title input for this Choreo. 

	@param String - (required, string) The title for the calendar entry to create.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
	}


	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (required, string) The type of calendar entry to create, either "Milestone" or "CalendarEvent" (the default).
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
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
	public CreateEntryResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateEntryResultSet(result);
	}
	
}
