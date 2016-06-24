package com.temboo.Library.Foursquare.Checkins;

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
GetNearbyFriends

Returns a list of recent friends' check-ins that are nearby the specified location.
*/
public class GetNearbyFriends extends Choreography {

	/**
	Create a new instance of the GetNearbyFriends Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetNearbyFriends(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Checkins/GetNearbyFriends"));
	}

	/** 
	Set the value of the Distance input for this Choreo. 

	@param Integer - (optional, integer) The distance (in meters) between the supplied coordinates and the checkin location. This returns friends' checkins where the distance is less than or equal to this value. Default is 500.
	*/
	public void setDistance(Integer value) {
		this.inputs.setInput("Distance", value);
	}

	/** 
	Set the value of the Distance input for this Choreo as a String. 

	@param String - (optional, integer) The distance (in meters) between the supplied coordinates and the checkin location. This returns friends' checkins where the distance is less than or equal to this value. Default is 500.
	*/
	public void setDistance(String value) {
		this.inputs.setInput("Distance", value);	
	}
	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The latitude point of the user's location.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (required, decimal) The latitude point of the user's location.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Number of results to return, up to 100.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Number of results to return, up to 100.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (required, decimal) The longitude point of the user's location.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (required, decimal) The longitude point of the user's location.
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
	Set the value of the ResponseMode input for this Choreo. 

	@param String - (optional, string) Used to simplify the response. Valid values are: simple and verbose. When set to simple, an array of user objects are returned. Verbose mode returns an array of checkin objects. Defaults to "simple".
	*/
	public void setResponseMode(String value) {
		this.inputs.setInput("ResponseMode", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetNearbyFriendsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetNearbyFriendsResultSet(result);
	}
	
}
