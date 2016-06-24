package com.temboo.Library.LastFm.Tasteometer;

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
CompareArtists

Retrieves a Tasteometer score from two artist inputs.
*/
public class CompareArtists extends Choreography {

	/**
	Create a new instance of the CompareArtists Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CompareArtists(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LastFm/Tasteometer/CompareArtists"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (string) Your Last.fm API Key.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Artist1 input for this Choreo. 

	@param String - (string) The first artist to compare.
	*/
	public void setArtist1(String value) {
		this.inputs.setInput("Artist1", value);
	}


	/** 
	Set the value of the Artist2 input for this Choreo. 

	@param String - (string) The second artist to compare.
	*/
	public void setArtist2(String value) {
		this.inputs.setInput("Artist2", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) How many shared artists to display. Defaults to 5.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) How many shared artists to display. Defaults to 5.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CompareArtistsResultSet run() {
		JSONObject result = super.runWithResults();
		return new CompareArtistsResultSet(result);
	}
	
}
