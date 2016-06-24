package com.temboo.Library.Mixpanel.Events;

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
Track

Records an event in Mixpanel.
*/
public class Track extends Choreography {

	/**
	Create a new instance of the Track Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Track(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Mixpanel/Events/Track"));
	}

	/** 
	Set the value of the DistinctID input for this Choreo. 

	@param String - (optional, string) Used to uniquely identify a user associated with your event. When provided, you can track a given user through funnels and distinguish unique users for retention analyses.
	*/
	public void setDistinctID(String value) {
		this.inputs.setInput("DistinctID", value);
	}


	/** 
	Set the value of the EventName input for this Choreo. 

	@param String - (required, string) A name for the event (e.g., Signed Up, Uploaded Photo, etc).
	*/
	public void setEventName(String value) {
		this.inputs.setInput("EventName", value);
	}


	/** 
	Set the value of the EventProperties input for this Choreo. 

	@param String - (optional, json) Additional properties associated with the event formatted as name/value pairs in a JSON object. These properties can be used for segmentation and funnels.
	*/
	public void setEventProperties(String value) {
		this.inputs.setInput("EventProperties", value);
	}


	/** 
	Set the value of the IP input for this Choreo. 

	@param String - (optional, string) An IP address string associated with the event (e.g., 127.0.0.1). When set to 0 (the default) Mixpanel will ignore IP information.
	*/
	public void setIP(String value) {
		this.inputs.setInput("IP", value);
	}


	/** 
	Set the value of the Time input for this Choreo. 

	@param String - (optional, date) A unix timestamp representing the time the event occurred. If not provided, Mixpanel will use the time the event arrives at the server.
	*/
	public void setTime(String value) {
		this.inputs.setInput("Time", value);
	}


	/** 
	Set the value of the Token input for this Choreo. 

	@param String - (required, string) The token provided by Mixpanel. You can find your Mixpanel token in the project settings dialog in the Mixpanel app.
	*/
	public void setToken(String value) {
		this.inputs.setInput("Token", value);
	}


	/** 
	Set the value of the Verbose input for this Choreo. 

	@param Boolean - (optional, boolean) When set to 1, the response will contain more information describing the success or failure of the tracking call.
	*/
	public void setVerbose(Boolean value) {
		this.inputs.setInput("Verbose", value);
	}

	/** 
	Set the value of the Verbose input for this Choreo as a String. 

	@param String - (optional, boolean) When set to 1, the response will contain more information describing the success or failure of the tracking call.
	*/
	public void setVerbose(String value) {
		this.inputs.setInput("Verbose", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public TrackResultSet run() {
		JSONObject result = super.runWithResults();
		return new TrackResultSet(result);
	}
	
}
