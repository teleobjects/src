package com.temboo.Library.Foursquare.Photos;

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
AddPhoto

Allows a user to add a new photo to a check-in, tip, or a venue.
*/
public class AddPhoto extends Choreography {

	/**
	Create a new instance of the AddPhoto Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddPhoto(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Photos/AddPhoto"));
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

	@param String - (optional, string) Whether to broadcast this photo. Set to "twitter" if you want to send to twitter, "facebook "if you want to send to facebook, or "twitter,facebook" if you want to send to both.
	*/
	public void setBroadcast(String value) {
		this.inputs.setInput("Broadcast", value);
	}


	/** 
	Set the value of the CheckinID input for this Choreo. 

	@param String - (conditional, any) The ID of the checkin to attach a photo to. One of the id fields (CheckinID, TipID, or VenueID) must be specified.
	*/
	public void setCheckinID(String value) {
		this.inputs.setInput("CheckinID", value);
	}


	/** 
	Set the value of the ImageFile input for this Choreo. 

	@param String - (conditional, string) The base64 encoded image contents. Required unless using the VaultFile alias (an advanced option used when running Choreos in the Temboo Designer).
	*/
	public void setImageFile(String value) {
		this.inputs.setInput("ImageFile", value);
	}


	/** 
	Set the value of the LLAccuracy input for this Choreo. 

	@param Integer - (optional, integer) Accuracy of the user's latitude and longitude, in meters.
	*/
	public void setLLAccuracy(Integer value) {
		this.inputs.setInput("LLAccuracy", value);
	}

	/** 
	Set the value of the LLAccuracy input for this Choreo as a String. 

	@param String - (optional, integer) Accuracy of the user's latitude and longitude, in meters.
	*/
	public void setLLAccuracy(String value) {
		this.inputs.setInput("LLAccuracy", value);	
	}
	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) Laitude of the user's location.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (optional, decimal) Laitude of the user's location.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) Longitude of the user's location.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (optional, decimal) Longitude of the user's location.
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
	Set the value of the TipID input for this Choreo. 

	@param String - (conditional, string) The ID of the tip to attach a photo to. One of the id fields (CheckinID, TipID, or VenueID) must be specified.
	*/
	public void setTipID(String value) {
		this.inputs.setInput("TipID", value);
	}


	/** 
	Set the value of the VenueID input for this Choreo. 

	@param String - (conditional, string) The ID of the venue to attach a photo to. One of the id fields (CheckinID, TipID, or VenueID) must be specified.
	*/
	public void setVenueID(String value) {
		this.inputs.setInput("VenueID", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - A path to an image in the vault. Required unless specifying the ImageFile input variable.
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddPhotoResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddPhotoResultSet(result);
	}
	
}
