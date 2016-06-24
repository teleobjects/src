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
Share

Allows you to share an album with one or more Last.fm users or other friends.
*/
public class Share extends Choreography {

	/**
	Create a new instance of the Share Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Share(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LastFm/Album/Share"));
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
	Set the value of the Message input for this Choreo. 

	@param String - (optional, string) An optional message to send with the recommendation. If not supplied a default message will be used.
	*/
	public void setMessage(String value) {
		this.inputs.setInput("Message", value);
	}


	/** 
	Set the value of the Public input for this Choreo. 

	@param Boolean - (optional, boolean) Optionally show in the sharing users activity feed. Defaults to 0 (false).
	*/
	public void setPublic(Boolean value) {
		this.inputs.setInput("Public", value);
	}

	/** 
	Set the value of the Public input for this Choreo as a String. 

	@param String - (optional, boolean) Optionally show in the sharing users activity feed. Defaults to 0 (false).
	*/
	public void setPublic(String value) {
		this.inputs.setInput("Public", value);	
	}
	/** 
	Set the value of the Recipient input for this Choreo. 

	@param String - (string) A comma delimited list of email addresses or Last.fm usernames. Maximum is 10.
	*/
	public void setRecipient(String value) {
		this.inputs.setInput("Recipient", value);
	}


	/** 
	Set the value of the SessionKey input for this Choreo. 

	@param String - (string) The session key retrieved in the last step of the authorization process.
	*/
	public void setSessionKey(String value) {
		this.inputs.setInput("SessionKey", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ShareResultSet run() {
		JSONObject result = super.runWithResults();
		return new ShareResultSet(result);
	}
	
}
