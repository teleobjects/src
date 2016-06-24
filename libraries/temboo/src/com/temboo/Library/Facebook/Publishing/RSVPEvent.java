package com.temboo.Library.Facebook.Publishing;

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
RSVPEvent

RSVP to an event as "attending", "maybe", or "declined".
*/
public class RSVPEvent extends Choreography {

	/**
	Create a new instance of the RSVPEvent Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RSVPEvent(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Facebook/Publishing/RSVPEvent"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token retrieved from the final step of the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the EventID input for this Choreo. 

	@param String - (required, string) The id for the event  to rsvp for.
	*/
	public void setEventID(String value) {
		this.inputs.setInput("EventID", value);
	}


	/** 
	Set the value of the RSVP input for this Choreo. 

	@param String - (required, string) The RSVP for the event. Valid values are: attending, maybe, or declined.
	*/
	public void setRSVP(String value) {
		this.inputs.setInput("RSVP", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RSVPEventResultSet run() {
		JSONObject result = super.runWithResults();
		return new RSVPEventResultSet(result);
	}
	
}
