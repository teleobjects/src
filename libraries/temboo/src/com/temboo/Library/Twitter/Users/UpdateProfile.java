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
UpdateProfile

Updates values that users are able to set under "Account" tab of their settings page.
*/
public class UpdateProfile extends Choreography {

	/**
	Create a new instance of the UpdateProfile Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateProfile(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twitter/Users/UpdateProfile"));
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
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) A description of the user owning the account. Maximum of 160 characters.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the IncludeUserEntities input for this Choreo. 

	@param Boolean - (optional, boolean) The user "entities" node containing extra metadata will not be included when set to false.
	*/
	public void setIncludeUserEntities(Boolean value) {
		this.inputs.setInput("IncludeUserEntities", value);
	}

	/** 
	Set the value of the IncludeUserEntities input for this Choreo as a String. 

	@param String - (optional, boolean) The user "entities" node containing extra metadata will not be included when set to false.
	*/
	public void setIncludeUserEntities(String value) {
		this.inputs.setInput("IncludeUserEntities", value);	
	}
	/** 
	Set the value of the Location input for this Choreo. 

	@param String - (optional, string) The city or country describing where the user of the account is located.
	*/
	public void setLocation(String value) {
		this.inputs.setInput("Location", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (optional, string) The full name associated with the profile. Maximum of 20 characters.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the SkipStatus input for this Choreo. 

	@param Boolean - (optional, boolean) When set to true, statuses will not be included in the returned user objects.
	*/
	public void setSkipStatus(Boolean value) {
		this.inputs.setInput("SkipStatus", value);
	}

	/** 
	Set the value of the SkipStatus input for this Choreo as a String. 

	@param String - (optional, boolean) When set to true, statuses will not be included in the returned user objects.
	*/
	public void setSkipStatus(String value) {
		this.inputs.setInput("SkipStatus", value);	
	}
	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (optional, string) URL associated with the profile.
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateProfileResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateProfileResultSet(result);
	}
	
}
