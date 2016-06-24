package com.temboo.Library.Labs.GetPlaces;

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
ByFoursquare

Retrieves information from multiple APIs about places near a set of coordinates retrieved from Foursquare.
*/
public class ByFoursquare extends Choreography {

	/**
	Create a new instance of the ByFoursquare Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ByFoursquare(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Labs/GetPlaces/ByFoursquare"));
	}

	/** 
	Set the value of the APICredentials input for this Choreo. 

	@param String - (required, json) A JSON dictionary of credentials for the APIs you wish to access. See Choreo documentation for formatting examples.
	*/
	public void setAPICredentials(String value) {
		this.inputs.setInput("APICredentials", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Limits the number of Foursquare venues returned.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Limits the number of Foursquare venues returned.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (optional, string) This keyword input can be used to narrow search results for Google Places and Foursquare.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Shout input for this Choreo. 

	@param String - (optional, string) A message about your check-in. The maximum length of this field is 140 characters.
	*/
	public void setShout(String value) {
		this.inputs.setInput("Shout", value);
	}


	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (optional, string) Filters results by type of place, such as: bar, dentist, etc. This is used to filter results for Google Places and Yelp.
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
	}


	/** 
	Set the value of the VenueID input for this Choreo. 

	@param String - (optional, string) The venue where the user is checking in. Required if creating a Foursquare checkin.
	*/
	public void setVenueID(String value) {
		this.inputs.setInput("VenueID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ByFoursquareResultSet run() {
		JSONObject result = super.runWithResults();
		return new ByFoursquareResultSet(result);
	}
	
}
