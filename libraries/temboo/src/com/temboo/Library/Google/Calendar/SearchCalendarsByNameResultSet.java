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
import com.temboo.core.Choreography.ResultSet;

	
/**
	A ResultSet with methods tailored to the values returned by the SearchCalendarsByName Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class SearchCalendarsByNameResultSet extends ResultSet {
		
	public SearchCalendarsByNameResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "CalendarDescription" output from this Choreo execution

	@return String - (string) The calendar description parsed from the Google response.
	*/
	public String getCalendarDescription() {
		return this.getResultString("CalendarDescription");
	}
	/** 
	Retrieve the value for the "CalendarId" output from this Choreo execution

	@return String - (string) The calendar id parsed from the Google response.
	*/
	public String getCalendarId() {
		return this.getResultString("CalendarId");
	}
	/** 
	Retrieve the value for the "CalendarSummary" output from this Choreo execution

	@return String - (string) The summary or calendar name parsed from the Google response.
	*/
	public String getCalendarSummary() {
		return this.getResultString("CalendarSummary");
	}
	/** 
	Retrieve the value for the "CalendarTimezone" output from this Choreo execution

	@return String - (string) The calendar timezone parsed from the Google response.
	*/
	public String getCalendarTimezone() {
		return this.getResultString("CalendarTimezone");
	}
	/** 
	Retrieve the value for the "NewAccessToken" output from this Choreo execution

	@return String - (string) Contains a new AccessToken when the RefreshToken is provided.
	*/
	public String getNewAccessToken() {
		return this.getResultString("NewAccessToken");
	}
}