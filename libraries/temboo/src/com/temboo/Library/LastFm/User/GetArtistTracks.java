package com.temboo.Library.LastFm.User;

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
GetArtistTracks

Retrieves a list of tracks by a given artist scrobbled by this user, including scrobble time.
*/
public class GetArtistTracks extends Choreography {

	/**
	Create a new instance of the GetArtistTracks Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetArtistTracks(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LastFm/User/GetArtistTracks"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) Your Last.fm API Key.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Artist input for this Choreo. 

	@param String - (required, string) The artist name you are interested in.
	*/
	public void setArtist(String value) {
		this.inputs.setInput("Artist", value);
	}


	/** 
	Set the value of the EndTimestamp input for this Choreo. 

	@param String - (optional, date) A unix timestamp to end at.
	*/
	public void setEndTimestamp(String value) {
		this.inputs.setInput("EndTimestamp", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page number to fetch. Defaults to 1.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page number to fetch. Defaults to 1.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the StartTimestamp input for this Choreo. 

	@param String - (optional, date) A unix timestamp to start at.
	*/
	public void setStartTimestamp(String value) {
		this.inputs.setInput("StartTimestamp", value);
	}


	/** 
	Set the value of the User input for this Choreo. 

	@param String - (required, string) The last.fm username to fetch the recent tracks of.
	*/
	public void setUser(String value) {
		this.inputs.setInput("User", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetArtistTracksResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetArtistTracksResultSet(result);
	}
	
}
