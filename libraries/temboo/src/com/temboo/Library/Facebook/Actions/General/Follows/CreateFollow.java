package com.temboo.Library.Facebook.Actions.General.Follows;

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
CreateFollow

Creates an action that represents someone following a Facebook user.
*/
public class CreateFollow extends Choreography {

	/**
	Create a new instance of the CreateFollow Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateFollow(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Facebook/Actions/General/Follows/CreateFollow"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token retrieved from the final step of the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the CreatedTime input for this Choreo. 

	@param String - (optional, date) The time that the action was created (e.g. 2013-06-24T18:53:35+0000).
	*/
	public void setCreatedTime(String value) {
		this.inputs.setInput("CreatedTime", value);
	}


	/** 
	Set the value of the EndTime input for this Choreo. 

	@param String - (optional, date) The time that the user ended the action (e.g. 2013-06-24T18:53:35+0000).
	*/
	public void setEndTime(String value) {
		this.inputs.setInput("EndTime", value);
	}


	/** 
	Set the value of the ExpiresIn input for this Choreo. 

	@param Integer - (optional, integer) The amount of time (in milliseconds) from the publish_time that the action will expire.
	*/
	public void setExpiresIn(Integer value) {
		this.inputs.setInput("ExpiresIn", value);
	}

	/** 
	Set the value of the ExpiresIn input for this Choreo as a String. 

	@param String - (optional, integer) The amount of time (in milliseconds) from the publish_time that the action will expire.
	*/
	public void setExpiresIn(String value) {
		this.inputs.setInput("ExpiresIn", value);	
	}
	/** 
	Set the value of the ExplicitlyShared input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates that the user is explicitly sharing this action. Requires the explicitly_shared capability to be enabled.
	*/
	public void setExplicitlyShared(Boolean value) {
		this.inputs.setInput("ExplicitlyShared", value);
	}

	/** 
	Set the value of the ExplicitlyShared input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates that the user is explicitly sharing this action. Requires the explicitly_shared capability to be enabled.
	*/
	public void setExplicitlyShared(String value) {
		this.inputs.setInput("ExplicitlyShared", value);	
	}
	/** 
	Set the value of the ExplicityShared input for this Choreo. 

	@param Boolean - (optional, boolean) Deprecated (retained for backward compatibility only).
	*/
	public void setExplicityShared(Boolean value) {
		this.inputs.setInput("ExplicityShared", value);
	}

	/** 
	Set the value of the ExplicityShared input for this Choreo as a String. 

	@param String - (optional, boolean) Deprecated (retained for backward compatibility only).
	*/
	public void setExplicityShared(String value) {
		this.inputs.setInput("ExplicityShared", value);	
	}
	/** 
	Set the value of the Message input for this Choreo. 

	@param String - (optional, string) A message attached to this action. Setting this parameter requires enabling of message capabilities.
	*/
	public void setMessage(String value) {
		this.inputs.setInput("Message", value);
	}


	/** 
	Set the value of the NoFeedStory input for this Choreo. 

	@param Boolean - (optional, boolean) Whether or not this action should be posted to the users feed.
	*/
	public void setNoFeedStory(Boolean value) {
		this.inputs.setInput("NoFeedStory", value);
	}

	/** 
	Set the value of the NoFeedStory input for this Choreo as a String. 

	@param String - (optional, boolean) Whether or not this action should be posted to the users feed.
	*/
	public void setNoFeedStory(String value) {
		this.inputs.setInput("NoFeedStory", value);	
	}
	/** 
	Set the value of the Place input for this Choreo. 

	@param String - (optional, string) The Facebook Page ID of the location associated with this action.
	*/
	public void setPlace(String value) {
		this.inputs.setInput("Place", value);
	}


	/** 
	Set the value of the Profile input for this Choreo. 

	@param String - (required, string) The URL or ID for an Open Graph object representing the profile to follow.
	*/
	public void setProfile(String value) {
		this.inputs.setInput("Profile", value);
	}


	/** 
	Set the value of the ProfileID input for this Choreo. 

	@param String - (optional, string) The id of the user's profile. Defaults to "me" indicating the authenticated user.
	*/
	public void setProfileID(String value) {
		this.inputs.setInput("ProfileID", value);
	}


	/** 
	Set the value of the Reference input for this Choreo. 

	@param String - (optional, string) A string identifier up to 50 characters used for tracking and insights.
	*/
	public void setReference(String value) {
		this.inputs.setInput("Reference", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the StartTime input for this Choreo. 

	@param String - (optional, date) The time that the user started the action (e.g. 2013-06-24T18:53:35+0000).
	*/
	public void setStartTime(String value) {
		this.inputs.setInput("StartTime", value);
	}


	/** 
	Set the value of the Tags input for this Choreo. 

	@param String - (optional, string) A comma separated list of other profile IDs that also performed this action.
	*/
	public void setTags(String value) {
		this.inputs.setInput("Tags", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateFollowResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateFollowResultSet(result);
	}
	
}
