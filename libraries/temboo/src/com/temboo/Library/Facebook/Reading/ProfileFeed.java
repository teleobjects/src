package com.temboo.Library.Facebook.Reading;

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
ProfileFeed

Retrieves the feed from a specified user's Wall.
*/
public class ProfileFeed extends Choreography {

	/**
	Create a new instance of the ProfileFeed Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ProfileFeed(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Facebook/Reading/ProfileFeed"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token retrieved from the final step of the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Edge input for this Choreo. 

	@param String - (optional, string) Filters results by a given "edge". Valid values are: links, posts, statuses, or tagged.
	*/
	public void setEdge(String value) {
		this.inputs.setInput("Edge", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) A comma separated list of fields to return (i.e. id,name).
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the Filter input for this Choreo. 

	@param String - (optional, string) Retrieve only posts that match a particular stream filter. See Choreo notes for valid filters that can be used here.
	*/
	public void setFilter(String value) {
		this.inputs.setInput("Filter", value);
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
	Set the value of the ProfileID input for this Choreo. 

	@param String - (optional, string) The id of the profile to retrieve a feed for. Defaults to "me" indicating the authenticated user.
	*/
	public void setProfileID(String value) {
		this.inputs.setInput("ProfileID", value);
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
	Set the value of the With input for this Choreo. 

	@param String - (optional, string) Can be set to "location" to retrieve only posts associated with a location attached.
	*/
	public void setWith(String value) {
		this.inputs.setInput("With", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ProfileFeedResultSet run() {
		JSONObject result = super.runWithResults();
		return new ProfileFeedResultSet(result);
	}
	
}
