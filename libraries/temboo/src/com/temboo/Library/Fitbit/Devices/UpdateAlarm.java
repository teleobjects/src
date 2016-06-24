package com.temboo.Library.Fitbit.Devices;

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
UpdateAlarm

Updates an existing alarm entry for a given device.
*/
public class UpdateAlarm extends Choreography {

	/**
	Create a new instance of the UpdateAlarm Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateAlarm(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Fitbit/Devices/UpdateAlarm"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the AlarmID input for this Choreo. 

	@param String - (required, string) The ID of the alarm to update.
	*/
	public void setAlarmID(String value) {
		this.inputs.setInput("AlarmID", value);
	}


	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) Deprecated (retained for backward compatibility only).
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the DeviceID input for this Choreo. 

	@param String - (required, string) The id of the device you would like to manage the alarm on.
	*/
	public void setDeviceID(String value) {
		this.inputs.setInput("DeviceID", value);
	}


	/** 
	Set the value of the Enabled input for this Choreo. 

	@param Boolean - (required, boolean) Indicates whether or not the alarm is enabled. Valid values are: true and false.
	*/
	public void setEnabled(Boolean value) {
		this.inputs.setInput("Enabled", value);
	}

	/** 
	Set the value of the Enabled input for this Choreo as a String. 

	@param String - (required, boolean) Indicates whether or not the alarm is enabled. Valid values are: true and false.
	*/
	public void setEnabled(String value) {
		this.inputs.setInput("Enabled", value);	
	}
	/** 
	Set the value of the Label input for this Choreo. 

	@param String - (optional, string) A label for the alarm.
	*/
	public void setLabel(String value) {
		this.inputs.setInput("Label", value);
	}


	/** 
	Set the value of the Recurring input for this Choreo. 

	@param Boolean - (required, boolean) Specifies if this is a one-time or recurring alarm. Valid values are: true or false. When adding a recurring alarm, the WeekDays input is required.
	*/
	public void setRecurring(Boolean value) {
		this.inputs.setInput("Recurring", value);
	}

	/** 
	Set the value of the Recurring input for this Choreo as a String. 

	@param String - (required, boolean) Specifies if this is a one-time or recurring alarm. Valid values are: true or false. When adding a recurring alarm, the WeekDays input is required.
	*/
	public void setRecurring(String value) {
		this.inputs.setInput("Recurring", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that you want the response to be in: xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SnoozeCount input for this Choreo. 

	@param Integer - (required, integer) The maximum snooze count.
	*/
	public void setSnoozeCount(Integer value) {
		this.inputs.setInput("SnoozeCount", value);
	}

	/** 
	Set the value of the SnoozeCount input for this Choreo as a String. 

	@param String - (required, integer) The maximum snooze count.
	*/
	public void setSnoozeCount(String value) {
		this.inputs.setInput("SnoozeCount", value);	
	}
	/** 
	Set the value of the SnoozeLength input for this Choreo. 

	@param Integer - (required, integer) The number of minutes in between alarms when using the snooze option.
	*/
	public void setSnoozeLength(Integer value) {
		this.inputs.setInput("SnoozeLength", value);
	}

	/** 
	Set the value of the SnoozeLength input for this Choreo as a String. 

	@param String - (required, integer) The number of minutes in between alarms when using the snooze option.
	*/
	public void setSnoozeLength(String value) {
		this.inputs.setInput("SnoozeLength", value);	
	}
	/** 
	Set the value of the Time input for this Choreo. 

	@param String - (required, string) The time of the alarm in the format XX:XX+XX:XX (the hour, minute, and time offset from UTC). This will be converted to the timezone of the user's profile.
	*/
	public void setTime(String value) {
		this.inputs.setInput("Time", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The user's encoded id. Defaults to "-" (dash) which will return data for the user associated with the token credentials provided.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	/** 
	Set the value of the Vibe input for this Choreo. 

	@param String - (optional, string) The vibe pattern. Currently this only has one accepted value: DEFAULT.
	*/
	public void setVibe(String value) {
		this.inputs.setInput("Vibe", value);
	}


	/** 
	Set the value of the WeekDays input for this Choreo. 

	@param String - (required, string) Specifies the days of the week that the alarm is active. Required when specifying a "recurring" alarm. Multiple days can be specified in a comma-separated list (e.g., MONDAY,TUESDAY,WEDNESDAY).
	*/
	public void setWeekDays(String value) {
		this.inputs.setInput("WeekDays", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateAlarmResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateAlarmResultSet(result);
	}
	
}
