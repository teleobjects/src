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
Shout

Creates a message in a user's shoutbox 
*/
public class Shout extends Choreography {

	/**
	Create a new instance of the Shout Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Shout(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LastFm/User/Shout"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) Your Last.fm API Key.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APISecret input for this Choreo. 

	@param String - (required, string) Your Last.fm API Secret.
	*/
	public void setAPISecret(String value) {
		this.inputs.setInput("APISecret", value);
	}


	/** 
	Set the value of the Message input for this Choreo. 

	@param String - (required, string) The message to post to the shoutbox.
	*/
	public void setMessage(String value) {
		this.inputs.setInput("Message", value);
	}


	/** 
	Set the value of the SessionKey input for this Choreo. 

	@param String - (required, string) The session key retrieved in the last step of the authorization process.
	*/
	public void setSessionKey(String value) {
		this.inputs.setInput("SessionKey", value);
	}


	/** 
	Set the value of the User input for this Choreo. 

	@param String - (required, string) The name of the user to shout on.
	*/
	public void setUser(String value) {
		this.inputs.setInput("User", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ShoutResultSet run() {
		JSONObject result = super.runWithResults();
		return new ShoutResultSet(result);
	}
	
}
