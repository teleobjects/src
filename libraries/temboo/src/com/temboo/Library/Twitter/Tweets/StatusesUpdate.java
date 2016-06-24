package com.temboo.Library.Twitter.Tweets;

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
StatusesUpdate

Allows you to update your Twitter status (aka Tweet).
*/
public class StatusesUpdate extends Choreography {

	/**
	Create a new instance of the StatusesUpdate Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public StatusesUpdate(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twitter/Tweets/StatusesUpdate"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) The Access Token Secret provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) The API Key (or Consumer Key) provided by Twitter.
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) The API Secret (or Consumer Secret) provided by Twitter.
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the DisplayCoordinates input for this Choreo. 

	@param Boolean - (optional, boolean) Whether or not to put a pin on the exact coordinates a tweet has been sent from.
	*/
	public void setDisplayCoordinates(Boolean value) {
		this.inputs.setInput("DisplayCoordinates", value);
	}

	/** 
	Set the value of the DisplayCoordinates input for this Choreo as a String. 

	@param String - (optional, boolean) Whether or not to put a pin on the exact coordinates a tweet has been sent from.
	*/
	public void setDisplayCoordinates(String value) {
		this.inputs.setInput("DisplayCoordinates", value);	
	}
	/** 
	Set the value of the InReplyTo input for this Choreo. 

	@param String - (optional, string) The ID of an existing status that the update is in reply to.
	*/
	public void setInReplyTo(String value) {
		this.inputs.setInput("InReplyTo", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) The latitude of the location this tweet refers to e.g., 40.71863.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (optional, decimal) The latitude of the location this tweet refers to e.g., 40.71863.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) The longitude of the location this tweet refers to e.g., -74.005584.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (optional, decimal) The longitude of the location this tweet refers to e.g., -74.005584.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the PlaceID input for this Choreo. 

	@param String - (optional, string) The ID associated with a place in the world. These IDs can be retrieved from the PlacesAndGeo.ReverseGeocode Choreo.
	*/
	public void setPlaceID(String value) {
		this.inputs.setInput("PlaceID", value);
	}


	/** 
	Set the value of the PossiblySensitive input for this Choreo. 

	@param Boolean - (optional, boolean) Set to true for content which may not be suitable for every audience.
	*/
	public void setPossiblySensitive(Boolean value) {
		this.inputs.setInput("PossiblySensitive", value);
	}

	/** 
	Set the value of the PossiblySensitive input for this Choreo as a String. 

	@param String - (optional, boolean) Set to true for content which may not be suitable for every audience.
	*/
	public void setPossiblySensitive(String value) {
		this.inputs.setInput("PossiblySensitive", value);	
	}
	/** 
	Set the value of the StatusUpdate input for this Choreo. 

	@param String - (required, string) The text for your status update. 140-character limit.
	*/
	public void setStatusUpdate(String value) {
		this.inputs.setInput("StatusUpdate", value);
	}


	/** 
	Set the value of the TrimUser input for this Choreo. 

	@param Boolean - (optional, boolean) When set to either true, each tweet returned in a timeline will include a user object including only the status authors numerical ID.
	*/
	public void setTrimUser(Boolean value) {
		this.inputs.setInput("TrimUser", value);
	}

	/** 
	Set the value of the TrimUser input for this Choreo as a String. 

	@param String - (optional, boolean) When set to either true, each tweet returned in a timeline will include a user object including only the status authors numerical ID.
	*/
	public void setTrimUser(String value) {
		this.inputs.setInput("TrimUser", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public StatusesUpdateResultSet run() {
		JSONObject result = super.runWithResults();
		return new StatusesUpdateResultSet(result);
	}
	
}
