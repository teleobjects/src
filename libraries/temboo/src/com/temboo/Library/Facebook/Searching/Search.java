package com.temboo.Library.Facebook.Searching;

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
Search

Search public objects across the social graph.
*/
public class Search extends Choreography {

	/**
	Create a new instance of the Search Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Search(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Facebook/Searching/Search"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (conditional, string) The access token retrieved from the final OAuth step.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Center input for this Choreo. 

	@param String - (conditional, string) The coordinates for a place (such as 37.76,122.427). Used only when specifying an object type of "place".
	*/
	public void setCenter(String value) {
		this.inputs.setInput("Center", value);
	}


	/** 
	Set the value of the Distance input for this Choreo. 

	@param Integer - (optional, integer) The distance search parameter used only when specifying an object type of "place". Defaults to 1000.
	*/
	public void setDistance(Integer value) {
		this.inputs.setInput("Distance", value);
	}

	/** 
	Set the value of the Distance input for this Choreo as a String. 

	@param String - (optional, integer) The distance search parameter used only when specifying an object type of "place". Defaults to 1000.
	*/
	public void setDistance(String value) {
		this.inputs.setInput("Distance", value);	
	}
	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) A comma separated list of fields to return (i.e. id,name).
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Used to page through results. Limits the number of records returned in the response.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Used to page through results. Limits the number of records returned in the response.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the ObjectType input for this Choreo. 

	@param String - (required, string) The type of object to search for such as: user, page, event, group, or place.
	*/
	public void setObjectType(String value) {
		this.inputs.setInput("ObjectType", value);
	}


	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) Used to page through results. Returns results starting from the specified number.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) Used to page through results. Returns results starting from the specified number.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the Query input for this Choreo. 

	@param String - (conditional, string) The Facebook query term to send in the request.
	*/
	public void setQuery(String value) {
		this.inputs.setInput("Query", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Since input for this Choreo. 

	@param String - (optional, date) Used for time-based pagination. Values can be a unix timestamp or any date accepted by strtotime.
	*/
	public void setSince(String value) {
		this.inputs.setInput("Since", value);
	}


	/** 
	Set the value of the Until input for this Choreo. 

	@param String - (optional, date) Used for time-based pagination. Values can be a unix timestamp or any date accepted by strtotime.
	*/
	public void setUntil(String value) {
		this.inputs.setInput("Until", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchResultSet(result);
	}
	
}
