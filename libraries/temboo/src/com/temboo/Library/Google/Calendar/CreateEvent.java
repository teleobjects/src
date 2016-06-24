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
CreateEvent

Create a new event in a specified calendar.
*/
public class CreateEvent extends Choreography {

	/**
	Create a new instance of the CreateEvent Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateEvent(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Calendar/CreateEvent"));
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

	@param String - (required, string) The unique ID for the calendar in which to add the event.  Note that calendar IDs can be retrieved by running GetAllCalendars or SearchCalendarsByName.
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
	Set the value of the EndDate input for this Choreo. 

	@param String - (required, string) The end date of the event, in the format "2012-04-10".
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the EndTime input for this Choreo. 

	@param String - (required, string) The end time for the event, in the format "10:30:00".
	*/
	public void setEndTime(String value) {
		this.inputs.setInput("EndTime", value);
	}


	/** 
	Set the value of the EventDescription input for this Choreo. 

	@param String - (optional, string) A short description of the event.
	*/
	public void setEventDescription(String value) {
		this.inputs.setInput("EventDescription", value);
	}


	/** 
	Set the value of the EventLocation input for this Choreo. 

	@param String - (optional, string) The location for the new event.
	*/
	public void setEventLocation(String value) {
		this.inputs.setInput("EventLocation", value);
	}


	/** 
	Set the value of the EventTitle input for this Choreo. 

	@param String - (required, string) The title for the new event.
	*/
	public void setEventTitle(String value) {
		this.inputs.setInput("EventTitle", value);
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
	Set the value of the StartDate input for this Choreo. 

	@param String - (required, string) The start date of the event, in the format "2012-11-03".
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	/** 
	Set the value of the StartTime input for this Choreo. 

	@param String - (required, string) The start time for the event, in the format "10:00:00".
	*/
	public void setStartTime(String value) {
		this.inputs.setInput("StartTime", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateEventResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateEventResultSet(result);
	}
	
}
