package com.temboo.Library.Google.Calendar;

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
UpdateCalendar

Updates the metadata for a calendar.
*/
public class UpdateCalendar extends Choreography {

	/**
	Create a new instance of the UpdateCalendar Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateCalendar(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Calendar/UpdateCalendar"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved during the OAuth process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the CalendarID input for this Choreo. 

	@param String - (required, string) The unique ID for the calendar to update. Note that calendar IDs can be retrieved by running GetAllCalendars or SearchCalendarsByName.
	*/
	public void setCalendarID(String value) {
		this.inputs.setInput("CalendarID", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the NewDescription input for this Choreo. 

	@param String - (optional, string) The new description for the calendar to update.
	*/
	public void setNewDescription(String value) {
		this.inputs.setInput("NewDescription", value);
	}


	/** 
	Set the value of the NewLocation input for this Choreo. 

	@param String - (optional, string) The new location for the calendar to update.
	*/
	public void setNewLocation(String value) {
		this.inputs.setInput("NewLocation", value);
	}


	/** 
	Set the value of the NewSummary input for this Choreo. 

	@param String - (required, string) The new summary for the calendar to update.
	*/
	public void setNewSummary(String value) {
		this.inputs.setInput("NewSummary", value);
	}


	/** 
	Set the value of the NewTimezone input for this Choreo. 

	@param String - (optional, string) The new timezone for the calendar to update.
	*/
	public void setNewTimezone(String value) {
		this.inputs.setInput("NewTimezone", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth Refresh Token used to generate a new access token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateCalendarResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateCalendarResultSet(result);
	}
	
}
