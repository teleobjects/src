package com.temboo.Library.Facebook.Actions.Music.Listens;

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
UpdateListen

Updates and existing listen action.
*/
public class UpdateListen extends Choreography {

	/**
	Create a new instance of the UpdateListen Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateListen(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Facebook/Actions/Music/Listens/UpdateListen"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token retrieved from the final step of the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ActionID input for this Choreo. 

	@param String - (required, string) The id of the action to update.
	*/
	public void setActionID(String value) {
		this.inputs.setInput("ActionID", value);
	}


	/** 
	Set the value of the Album input for this Choreo. 

	@param String - (optional, string) The URL or ID for an Open Graph object representing  representing an album.
	*/
	public void setAlbum(String value) {
		this.inputs.setInput("Album", value);
	}


	/** 
	Set the value of the EndTime input for this Choreo. 

	@param String - (optional, date) The time that the user ended the action (e.g. 2013-06-24T18:53:35+0000).
	*/
	public void setEndTime(String value) {
		this.inputs.setInput("EndTime", value);
	}


	/** 
	Set the value of the ExpiresIn input for this Choreo. 

	@param Integer - (optional, integer) The amount of time (in milliseconds) from the publish_time that the action will expire.
	*/
	public void setExpiresIn(Integer value) {
		this.inputs.setInput("ExpiresIn", value);
	}

	/** 
	Set the value of the ExpiresIn input for this Choreo as a String. 

	@param String - (optional, integer) The amount of time (in milliseconds) from the publish_time that the action will expire.
	*/
	public void setExpiresIn(String value) {
		this.inputs.setInput("ExpiresIn", value);	
	}
	/** 
	Set the value of the Message input for this Choreo. 

	@param String - (optional, string) A message attached to this fitness action. Setting this parameter requires enabling of message capabilities.
	*/
	public void setMessage(String value) {
		this.inputs.setInput("Message", value);
	}


	/** 
	Set the value of the Musician input for this Choreo. 

	@param String - (optional, string) The URL or ID for an Open Graph object representing representing a musician.
	*/
	public void setMusician(String value) {
		this.inputs.setInput("Musician", value);
	}


	/** 
	Set the value of the Paused input for this Choreo. 

	@param Boolean - (optional, boolean) Whether the audio is paused or not
	*/
	public void setPaused(Boolean value) {
		this.inputs.setInput("Paused", value);
	}

	/** 
	Set the value of the Paused input for this Choreo as a String. 

	@param String - (optional, boolean) Whether the audio is paused or not
	*/
	public void setPaused(String value) {
		this.inputs.setInput("Paused", value);	
	}
	/** 
	Set the value of the Place input for this Choreo. 

	@param String - (optional, string) The URL or ID for an Open Graph object representing the location associated with this action.
	*/
	public void setPlace(String value) {
		this.inputs.setInput("Place", value);
	}


	/** 
	Set the value of the Playlist input for this Choreo. 

	@param String - (optional, string) The URL or ID for an Open Graph object representing representing a playlist.
	*/
	public void setPlaylist(String value) {
		this.inputs.setInput("Playlist", value);
	}


	/** 
	Set the value of the RadioStation input for this Choreo. 

	@param String - (optional, string) The URL or ID for an Open Graph object representing  representing a radio station.
	*/
	public void setRadioStation(String value) {
		this.inputs.setInput("RadioStation", value);
	}


	/** 
	Set the value of the Song input for this Choreo. 

	@param String - (optional, string) The URL or ID for an Open Graph object representing  representing a song.
	*/
	public void setSong(String value) {
		this.inputs.setInput("Song", value);
	}


	/** 
	Set the value of the Tags input for this Choreo. 

	@param String - (optional, string) A comma separated list of other profile IDs that also performed this action.
	*/
	public void setTags(String value) {
		this.inputs.setInput("Tags", value);
	}


	/** 
	Set the value of the ViaUser input for this Choreo. 

	@param Integer - (optional, integer) The ID of anyone whom the user discovered this audio from
	*/
	public void setViaUser(Integer value) {
		this.inputs.setInput("ViaUser", value);
	}

	/** 
	Set the value of the ViaUser input for this Choreo as a String. 

	@param String - (optional, integer) The ID of anyone whom the user discovered this audio from
	*/
	public void setViaUser(String value) {
		this.inputs.setInput("ViaUser", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateListenResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateListenResultSet(result);
	}
	
}
