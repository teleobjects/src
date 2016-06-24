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
CreateCheckin

Allows you to create a check-in with Foursquare.
*/
public class CreateCheckin extends Choreography {

	/**
	Create a new instance of the CreateCheckin Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateCheckin(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Checkins/CreateCheckin"));
	}

	/** 
	Set the value of the AccuracyOfCoordinates input for this Choreo. 

	@param Integer - (optional, integer) Accuracy of the user's latitude and longitude, in meters.
	*/
	public void setAccuracyOfCoordinates(Integer value) {
		this.inputs.setInput("AccuracyOfCoordinates", value);
	}

	/** 
	Set the value of the AccuracyOfCoordinates input for this Choreo as a String. 

	@param String - (optional, integer) Accuracy of the user's latitude and longitude, in meters.
	*/
	public void setAccuracyOfCoordinates(String value) {
		this.inputs.setInput("AccuracyOfCoordinates", value);	
	}
	/** 
	Set the value of the Altitude input for this Choreo. 

	@param Integer - (optional, integer) Altitude of the user's location, in meters.
	*/
	public void setAltitude(Integer value) {
		this.inputs.setInput("Altitude", value);
	}

	/** 
	Set the value of the Altitude input for this Choreo as a String. 

	@param String - (optional, integer) Altitude of the user's location, in meters.
	*/
	public void setAltitude(String value) {
		this.inputs.setInput("Altitude", value);	
	}
	/** 
	Set the value of the AltitudeAccuracy input for this Choreo. 

	@param Integer - (optional, integer) Vertical accuracy of the user's location, in meters.
	*/
	public void setAltitudeAccuracy(Integer value) {
		this.inputs.setInput("AltitudeAccuracy", value);
	}

	/** 
	Set the value of the AltitudeAccuracy input for this Choreo as a String. 

	@param String - (optional, integer) Vertical accuracy of the user's location, in meters.
	*/
	public void setAltitudeAccuracy(String value) {
		this.inputs.setInput("AltitudeAccuracy", value);	
	}
	/** 
	Set the value of the Broadcast input for this Choreo. 

	@param String - (optional, string) Who to broadcast this check-in to. Can be a comma-delimited list: private, public, facebook, twitter, or followers. Defaults to 'public'.
	*/
	public void setBroadcast(String value) {
		this.inputs.setInput("Broadcast", value);
	}


	/** 
	Set the value of the EventID input for this Choreo. 

	@param String - (optional, string) The event the user is checking in to. A venueId for a venue with this eventId must also be specified in the request.
	*/
	public void setEventID(String value) {
		this.inputs.setInput("EventID", value);
	}


	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) The latitude point of the user's location.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (optional, decimal) The latitude point of the user's location.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) The longitude point of the user's location.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (optional, decimal) The longitude point of the user's location.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the OauthToken input for this Choreo. 

	@param String - (required, string) The FourSquare API Oauth token string.
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
	Set the value of the Shout input for this Choreo. 

	@param String - (optional, string) A message about your check-in. The maximum length of this field is 140 characters.
	*/
	public void setShout(String value) {
		this.inputs.setInput("Shout", value);
	}


	/** 
	Set the value of the Venue input for this Choreo. 

	@param String - (optional, string) If you are not shouting, but you don't have a venue ID or prefer a 'venueless' checkin, pass the venue name as a string using this parameter.
	*/
	public void setVenue(String value) {
		this.inputs.setInput("Venue", value);
	}


	/** 
	Set the value of the VenueID input for this Choreo. 

	@param String - (required, string) The venue where the user is checking in. No venueid is needed if shouting or just providing a venue name.
	*/
	public void setVenueID(String value) {
		this.inputs.setInput("VenueID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateCheckinResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateCheckinResultSet(result);
	}
	
}
