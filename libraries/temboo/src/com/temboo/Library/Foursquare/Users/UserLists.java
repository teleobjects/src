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
import com.temboo.core.Choreography;
import com.temboo.core.Choreography.ResultSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooPath;
import com.temboo.core.TembooSession;

/** 
UserLists

Retrieves user lists.
*/
public class UserLists extends Choreography {

	/**
	Create a new instance of the UserLists Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UserLists(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Users/UserLists"));
	}

	/** 
	Set the value of the Group input for this Choreo. 

	@param String - (optional, string) Used to narrow down the lists to returns. Valid values are: created, edited, followed, friends, and suggested. See documentation for definitions of these parameter values.
	*/
	public void setGroup(String value) {
		this.inputs.setInput("Group", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (conditional, decimal) Latitude of user's location. Required in order to return the suggested group.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (conditional, decimal) Latitude of user's location. Required in order to return the suggested group.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (conditional, decimal) Longitude of user's location. Required in order to return the suggested group.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (conditional, decimal) Longitude of user's location. Required in order to return the suggested group.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the OauthToken input for this Choreo. 

	@param String - (required, string) The Foursquare API OAuth token string.
	*/
	public void setOauthToken(String value) {
		this.inputs.setInput("OauthToken", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) Identity of the user to get lists for. Defaults to "self" to get lists of the acting user.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UserListsResultSet run() {
		JSONObject result = super.runWithResults();
		return new UserListsResultSet(result);
	}
	
}
