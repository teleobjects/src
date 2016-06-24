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
Set

Sets the properties of a profile.
*/
public class Set extends Choreography {

	/**
	Create a new instance of the Set Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Set(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Mixpanel/Profiles/Set"));
	}

	/** 
	Set the value of the City input for this Choreo. 

	@param String - (optional, string) The city associated with the user's location.
	*/
	public void setCity(String value) {
		this.inputs.setInput("City", value);
	}


	/** 
	Set the value of the Created input for this Choreo. 

	@param String - (optional, date) The time when the user created their account. This should be expressed as YYYY-MM-DDThh:mm:ss.
	*/
	public void setCreated(String value) {
		this.inputs.setInput("Created", value);
	}


	/** 
	Set the value of the DistinctID input for this Choreo. 

	@param String - (required, string) Used to uniquely identify the profile you want to update.
	*/
	public void setDistinctID(String value) {
		this.inputs.setInput("DistinctID", value);
	}


	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (optional, string) The user's email address. Mixpanel can use this property when sending email notifications to your users.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the FirstName input for this Choreo. 

	@param String - (optional, string) The first name of the user represented the profile.
	*/
	public void setFirstName(String value) {
		this.inputs.setInput("FirstName", value);
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
	Set the value of the LastName input for this Choreo. 

	@param String - (optional, string) The last name of the user representing the profile.
	*/
	public void setLastName(String value) {
		this.inputs.setInput("LastName", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (optional, string) The full name of the user. This can be used as an alternative to FirstName and LastName.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the Phone input for this Choreo. 

	@param String - (optional, string) The user's phone number (e.g., 4805551212). Mixpanel can use this property when sending SMS messages to your users.
	*/
	public void setPhone(String value) {
		this.inputs.setInput("Phone", value);
	}


	/** 
	Set the value of the ProfileProperties input for this Choreo. 

	@param String - (optional, json) A JSON object containing names and values of custom profile properties. Note that properties that exist already will be overwritten.
	*/
	public void setProfileProperties(String value) {
		this.inputs.setInput("ProfileProperties", value);
	}


	/** 
	Set the value of the Region input for this Choreo. 

	@param String - (optional, string) The region associated with a user's location.
	*/
	public void setRegion(String value) {
		this.inputs.setInput("Region", value);
	}


	/** 
	Set the value of the Time input for this Choreo. 

	@param String - (optional, date) A unix timestamp representing the time of the profile update. If not provided, Mixpanel will use the time the update arrives at the server.
	*/
	public void setTime(String value) {
		this.inputs.setInput("Time", value);
	}


	/** 
	Set the value of the Timezone input for this Choreo. 

	@param String - (optional, string) The timezone associated with a user's location.
	*/
	public void setTimezone(String value) {
		this.inputs.setInput("Timezone", value);
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
	public SetResultSet run() {
		JSONObject result = super.runWithResults();
		return new SetResultSet(result);
	}
	
}
