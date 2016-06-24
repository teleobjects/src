package com.temboo.Library.Foursquare.Users;

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
	A ResultSet with methods tailored to the values returned by the LatestCheckinForUser Choreo.
	The ResultSet object is used to retrieve the results of a Choreo execution.
*/
public  class LatestCheckinForUserResultSet extends ResultSet {
		
	public LatestCheckinForUserResultSet(JSONObject doc) {
		super(doc);
	}

	/** 
	Retrieve the value for the "City" output from this Choreo execution

	@return String - (string) The city that the venue is located in.
	*/
	public String getCity() {
		return this.getResultString("City");
	}
	/** 
	Retrieve the value for the "CreatedAt" output from this Choreo execution

	@return String - (date) The date associated with the user's latest check-in.
	*/
	public String getCreatedAt() {
		return this.getResultString("CreatedAt");
	}
	/** 
	Retrieve the value for the "FormattedAddress" output from this Choreo execution

	@return String - (string) The formatted address of the venue associated with the user's latest check-in.
	*/
	public String getFormattedAddress() {
		return this.getResultString("FormattedAddress");
	}
	/** 
	Retrieve the value for the "PostalCode" output from this Choreo execution

	@return String - (integer) The postal code of the venue.
	*/
	public String getPostalCode() {
		return this.getResultString("PostalCode");
	}
	/** 
	Retrieve the value for the "State" output from this Choreo execution

	@return String - (string) The state that the venue is located in.
	*/
	public String getState() {
		return this.getResultString("State");
	}
	/** 
	Retrieve the value for the "VenueID" output from this Choreo execution

	@return String - (string) The ID of the venue associated with the user's latest check-in.
	*/
	public String getVenueID() {
		return this.getResultString("VenueID");
	}
	/** 
	Retrieve the value for the "VenueName" output from this Choreo execution

	@return String - (string) The name of the venue that the user last checked into.
	*/
	public String getVenueName() {
		return this.getResultString("VenueName");
	}
	/** 
	Retrieve the value for the "Response" output from this Choreo execution

	@return String - The response from Foursquare. Corresponds to the ResponseFormat input. Defaults to JSON.
	*/
	public String getResponse() {
		return this.getResultString("Response");
	}
}