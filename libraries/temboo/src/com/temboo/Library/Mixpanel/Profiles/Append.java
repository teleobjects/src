package com.temboo.Library.Mixpanel.Profiles;

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
Append

Appends a value to a list property on a profile.
*/
public class Append extends Choreography {

	/**
	Create a new instance of the Append Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Append(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Mixpanel/Profiles/Append"));
	}

	/** 
	Set the value of the DistinctID input for this Choreo. 

	@param String - (required, string) Used to uniquely identify the profile you want to update.
	*/
	public void setDistinctID(String value) {
		this.inputs.setInput("DistinctID", value);
	}


	/** 
	Set the value of the IP input for this Choreo. 

	@param String - (optional, string) An IP address string associated with the profile (e.g., 127.0.0.1). When set to 0 (the default) Mixpanel will ignore IP information.
	*/
	public void setIP(String value) {
		this.inputs.setInput("IP", value);
	}


	/** 
	Set the value of the IgnoreTime input for this Choreo. 

	@param Boolean - (optional, boolean) When set to true, Mixpanel will not automatically update the "Last Seen" property of the profile. Otherwise, Mixpanel will add a "Last Seen" property associated with any set, append, or add requests.
	*/
	public void setIgnoreTime(Boolean value) {
		this.inputs.setInput("IgnoreTime", value);
	}

	/** 
	Set the value of the IgnoreTime input for this Choreo as a String. 

	@param String - (optional, boolean) When set to true, Mixpanel will not automatically update the "Last Seen" property of the profile. Otherwise, Mixpanel will add a "Last Seen" property associated with any set, append, or add requests.
	*/
	public void setIgnoreTime(String value) {
		this.inputs.setInput("IgnoreTime", value);	
	}
	/** 
	Set the value of the ProfileProperties input for this Choreo. 

	@param String - (conditional, json) A JSON object containing a name/value pair representing a list name and value. The current value will be appended to any existing lists. If the list doesn't exist, it will be created.
	*/
	public void setProfileProperties(String value) {
		this.inputs.setInput("ProfileProperties", value);
	}


	/** 
	Set the value of the Time input for this Choreo. 

	@param String - (optional, date) A unix timestamp representing the time of the profile update. If not provided, Mixpanel will use the time the update arrives at the server.
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
	public AppendResultSet run() {
		JSONObject result = super.runWithResults();
		return new AppendResultSet(result);
	}
	
}
