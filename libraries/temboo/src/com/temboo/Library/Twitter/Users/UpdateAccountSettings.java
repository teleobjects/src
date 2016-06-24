package com.temboo.Library.Twitter.Users;

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
UpdateAccountSettings

Updates the authenticating user's settings such as trend location and sleep time settings.
*/
public class UpdateAccountSettings extends Choreography {

	/**
	Create a new instance of the UpdateAccountSettings Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateAccountSettings(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twitter/Users/UpdateAccountSettings"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) The Access Token Secret provided by Twitter or retrieved during the OAuth process.
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) The API Key (or Consumer Key) provided by Twitter.
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) The API Secret (or Consumer Secret) provided by Twitter.
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the EndSleepTime input for this Choreo. 

	@param String - (optional, string) The hour that sleep time should end if it is enabled. The value should be provided in ISO8601 format (e.g., 00-23).
	*/
	public void setEndSleepTime(String value) {
		this.inputs.setInput("EndSleepTime", value);
	}


	/** 
	Set the value of the Language input for this Choreo. 

	@param String - (optional, string) The language which Twitter should render in for this user. The language must be specified by the appropriate two letter ISO 639-1 representation.
	*/
	public void setLanguage(String value) {
		this.inputs.setInput("Language", value);
	}


	/** 
	Set the value of the SleepTimeEnabled input for this Choreo. 

	@param Boolean - (optional, boolean) When set to true, enables sleep time for the user. Sleep time is when push or SMS notifications should not be sent to the user.
	*/
	public void setSleepTimeEnabled(Boolean value) {
		this.inputs.setInput("SleepTimeEnabled", value);
	}

	/** 
	Set the value of the SleepTimeEnabled input for this Choreo as a String. 

	@param String - (optional, boolean) When set to true, enables sleep time for the user. Sleep time is when push or SMS notifications should not be sent to the user.
	*/
	public void setSleepTimeEnabled(String value) {
		this.inputs.setInput("SleepTimeEnabled", value);	
	}
	/** 
	Set the value of the StartSleepTime input for this Choreo. 

	@param String - (optional, string) The hour that sleep time should begin if it is enabled. The value should be provided in ISO8601 format (e.g., 00-23).
	*/
	public void setStartSleepTime(String value) {
		this.inputs.setInput("StartSleepTime", value);
	}


	/** 
	Set the value of the Timezone input for this Choreo. 

	@param String - (optional, string) The timezone dates and times that should be displayed for the user (e.g., Europe/Copenhagen, Pacific/Tongatapu)
	*/
	public void setTimezone(String value) {
		this.inputs.setInput("Timezone", value);
	}


	/** 
	Set the value of the TrendLocationWOEID input for this Choreo. 

	@param String - (optional, string) The Yahoo! Where On Earth ID to use as the user's default trend location.
	*/
	public void setTrendLocationWOEID(String value) {
		this.inputs.setInput("TrendLocationWOEID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateAccountSettingsResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateAccountSettingsResultSet(result);
	}
	
}
