package com.temboo.Library.LastFm.Album;

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
AddTags

Tags an album using a list of user supplied tags. 
*/
public class AddTags extends Choreography {

	/**
	Create a new instance of the AddTags Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddTags(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LastFm/Album/AddTags"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (string) Your Last.fm API Key.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APISecret input for this Choreo. 

	@param String - (string) Your Last.fm API Secret.
	*/
	public void setAPISecret(String value) {
		this.inputs.setInput("APISecret", value);
	}


	/** 
	Set the value of the Album input for this Choreo. 

	@param String - (string) The album name.
	*/
	public void setAlbum(String value) {
		this.inputs.setInput("Album", value);
	}


	/** 
	Set the value of the Artist input for this Choreo. 

	@param String - (string) The artist name.
	*/
	public void setArtist(String value) {
		this.inputs.setInput("Artist", value);
	}


	/** 
	Set the value of the SessionKey input for this Choreo. 

	@param String - (string) The session key retrieved in the last step of the authorization process.
	*/
	public void setSessionKey(String value) {
		this.inputs.setInput("SessionKey", value);
	}


	/** 
	Set the value of the Tags input for this Choreo. 

	@param String - (string) A comma delimited list of user supplied tags to apply to this album. Accepts a maximum of 10 tags.
	*/
	public void setTags(String value) {
		this.inputs.setInput("Tags", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddTagsResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddTagsResultSet(result);
	}
	
}
