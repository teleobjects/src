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
SearchEvents

Allows you to search for events using a variety of search parameters.
*/
public class SearchEvents extends Choreography {

	/**
	Create a new instance of the SearchEvents Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchEvents(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Calendar/SearchEvents"));
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

	@param String - (required, string) The unique ID for the calendar with the events to search. Note that calendar IDs can be retrieved by running GetAllCalendars or SearchCalendarsByName.
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
	Set the value of the LastModified input for this Choreo. 

	@param String - (optional, date) An event's last modification time (as a RFC 3339 timestamp) to filter by.
	*/
	public void setLastModified(String value) {
		this.inputs.setInput("LastModified", value);
	}


	/** 
	Set the value of the MaxAttendees input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of attendees to include in the response. If there are more than the specified number of attendees, only the participant is returned.
	*/
	public void setMaxAttendees(Integer value) {
		this.inputs.setInput("MaxAttendees", value);
	}

	/** 
	Set the value of the MaxAttendees input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of attendees to include in the response. If there are more than the specified number of attendees, only the participant is returned.
	*/
	public void setMaxAttendees(String value) {
		this.inputs.setInput("MaxAttendees", value);	
	}
	/** 
	Set the value of the MaxResults input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of events to return on one result page.
	*/
	public void setMaxResults(Integer value) {
		this.inputs.setInput("MaxResults", value);
	}

	/** 
	Set the value of the MaxResults input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of events to return on one result page.
	*/
	public void setMaxResults(String value) {
		this.inputs.setInput("MaxResults", value);	
	}
	/** 
	Set the value of the MaxTime input for this Choreo. 

	@param String - (optional, date) The max start time to filter by (formatted like 2012-05-22T00:47:43.000Z).
	*/
	public void setMaxTime(String value) {
		this.inputs.setInput("MaxTime", value);
	}


	/** 
	Set the value of the MinTime input for this Choreo. 

	@param String - (optional, date) The minimum start time to filter by (formatted like 2012-05-22T00:47:43.000Z).
	*/
	public void setMinTime(String value) {
		this.inputs.setInput("MinTime", value);
	}


	/** 
	Set the value of the OrderBy input for this Choreo. 

	@param String - (optional, string) The order of the events returned in the result. Accepted values are: "startTime" (ordered by start date/time. Must set SingleEvents to 1 to use this) or "updated" (ordered by modification date/time).
	*/
	public void setOrderBy(String value) {
		this.inputs.setInput("OrderBy", value);
	}


	/** 
	Set the value of the PageToken input for this Choreo. 

	@param Integer - (optional, integer) Indicates which result page to return. Used for paging through results.
	*/
	public void setPageToken(Integer value) {
		this.inputs.setInput("PageToken", value);
	}

	/** 
	Set the value of the PageToken input for this Choreo as a String. 

	@param String - (optional, integer) Indicates which result page to return. Used for paging through results.
	*/
	public void setPageToken(String value) {
		this.inputs.setInput("PageToken", value);	
	}
	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (optional, string) A keyword search to find events.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
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
	Set the value of the ShowDeleted input for this Choreo. 

	@param Boolean - (optional, boolean) Whether to include deleted events. Set to 1 (true) to include deleted events. Defaults to 0 (false).
	*/
	public void setShowDeleted(Boolean value) {
		this.inputs.setInput("ShowDeleted", value);
	}

	/** 
	Set the value of the ShowDeleted input for this Choreo as a String. 

	@param String - (optional, boolean) Whether to include deleted events. Set to 1 (true) to include deleted events. Defaults to 0 (false).
	*/
	public void setShowDeleted(String value) {
		this.inputs.setInput("ShowDeleted", value);	
	}
	/** 
	Set the value of the ShowHiddenInvitations input for this Choreo. 

	@param Boolean - (optional, boolean) Whether to include hidden invitations in the result. Set to 1 (true) to enable. The default is 0 (false).
	*/
	public void setShowHiddenInvitations(Boolean value) {
		this.inputs.setInput("ShowHiddenInvitations", value);
	}

	/** 
	Set the value of the ShowHiddenInvitations input for this Choreo as a String. 

	@param String - (optional, boolean) Whether to include hidden invitations in the result. Set to 1 (true) to enable. The default is 0 (false).
	*/
	public void setShowHiddenInvitations(String value) {
		this.inputs.setInput("ShowHiddenInvitations", value);	
	}
	/** 
	Set the value of the SingleEvent input for this Choreo. 

	@param Boolean - (optional, boolean) Whether to expand recurring events into instances and only return single one-off events and instances of recurring events. Defaults to 0 (false).
	*/
	public void setSingleEvent(Boolean value) {
		this.inputs.setInput("SingleEvent", value);
	}

	/** 
	Set the value of the SingleEvent input for this Choreo as a String. 

	@param String - (optional, boolean) Whether to expand recurring events into instances and only return single one-off events and instances of recurring events. Defaults to 0 (false).
	*/
	public void setSingleEvent(String value) {
		this.inputs.setInput("SingleEvent", value);	
	}
	/** 
	Set the value of the Timezone input for this Choreo. 

	@param String - (optional, string) The time zone used in the response (i.e. America/Los_Angeles). The default is the time zone of the calendar.
	*/
	public void setTimezone(String value) {
		this.inputs.setInput("Timezone", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchEventsResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchEventsResultSet(result);
	}
	
}
