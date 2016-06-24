package com.temboo.Library.LastFm.Artist;

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
GetPodcast

Retrieves a podcast of free mp3s based on a specified artist.
*/
public class GetPodcast extends Choreography {

	/**
	Create a new instance of the GetPodcast Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetPodcast(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LastFm/Artist/GetPodcast"));
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

	@param String - (conditional, string) The artist name. Required unless providing MbID.
	*/
	public void setArtist(String value) {
		this.inputs.setInput("Artist", value);
	}


	/** 
	Set the value of the AutoCorrect input for this Choreo. 

	@param Boolean - (optional, boolean) Transform misspelled artist names into correct artist names. The corrected artist name will be returned in the response. Defaults to 0.
	*/
	public void setAutoCorrect(Boolean value) {
		this.inputs.setInput("AutoCorrect", value);
	}

	/** 
	Set the value of the AutoCorrect input for this Choreo as a String. 

	@param String - (optional, boolean) Transform misspelled artist names into correct artist names. The corrected artist name will be returned in the response. Defaults to 0.
	*/
	public void setAutoCorrect(String value) {
		this.inputs.setInput("AutoCorrect", value);	
	}
	/** 
	Set the value of the MbID input for this Choreo. 

	@param String - (optional, string) The musicbrainz id for the artist. Required unless providing Artist.
	*/
	public void setMbID(String value) {
		this.inputs.setInput("MbID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetPodcastResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetPodcastResultSet(result);
	}
	
}
