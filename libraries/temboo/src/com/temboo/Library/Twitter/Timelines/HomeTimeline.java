package com.temboo.Library.Twitter.Timelines;

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
HomeTimeline

Retrieves a collection of the most recent Tweets and retweets posted by the authenticating user and the users they follow.
*/
public class HomeTimeline extends Choreography {

	/**
	Create a new instance of the HomeTimeline Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public HomeTimeline(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twitter/Timelines/HomeTimeline"));
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
	Set the value of the ContributorDetails input for this Choreo. 

	@param Boolean - (optional, boolean) Set to true to include the screen_name of the contributor. By default only the user_id of the contributor is included.
	*/
	public void setContributorDetails(Boolean value) {
		this.inputs.setInput("ContributorDetails", value);
	}

	/** 
	Set the value of the ContributorDetails input for this Choreo as a String. 

	@param String - (optional, boolean) Set to true to include the screen_name of the contributor. By default only the user_id of the contributor is included.
	*/
	public void setContributorDetails(String value) {
		this.inputs.setInput("ContributorDetails", value);	
	}
	/** 
	Set the value of the Count input for this Choreo. 

	@param Integer - (optional, integer) Specifies the number of records to retrieve. Must be less than or equal to 200. Defaults to 20.
	*/
	public void setCount(Integer value) {
		this.inputs.setInput("Count", value);
	}

	/** 
	Set the value of the Count input for this Choreo as a String. 

	@param String - (optional, integer) Specifies the number of records to retrieve. Must be less than or equal to 200. Defaults to 20.
	*/
	public void setCount(String value) {
		this.inputs.setInput("Count", value);	
	}
	/** 
	Set the value of the ExcludeReplies input for this Choreo. 

	@param Boolean - (optional, boolean) Set to true to prevent replies from appearing in the returned timeline.
	*/
	public void setExcludeReplies(Boolean value) {
		this.inputs.setInput("ExcludeReplies", value);
	}

	/** 
	Set the value of the ExcludeReplies input for this Choreo as a String. 

	@param String - (optional, boolean) Set to true to prevent replies from appearing in the returned timeline.
	*/
	public void setExcludeReplies(String value) {
		this.inputs.setInput("ExcludeReplies", value);	
	}
	/** 
	Set the value of the IncludeEntities input for this Choreo. 

	@param Boolean - (optional, boolean) The "entities" node containing extra metadata will not be included when set to false.
	*/
	public void setIncludeEntities(Boolean value) {
		this.inputs.setInput("IncludeEntities", value);
	}

	/** 
	Set the value of the IncludeEntities input for this Choreo as a String. 

	@param String - (optional, boolean) The "entities" node containing extra metadata will not be included when set to false.
	*/
	public void setIncludeEntities(String value) {
		this.inputs.setInput("IncludeEntities", value);	
	}
	/** 
	Set the value of the MaxId input for this Choreo. 

	@param String - (optional, string) Returns results with an ID less than (older than) or equal to the specified ID.
	*/
	public void setMaxId(String value) {
		this.inputs.setInput("MaxId", value);
	}


	/** 
	Set the value of the SinceId input for this Choreo. 

	@param String - (optional, string) Returns results with an ID greater than (more recent than) the specified ID.
	*/
	public void setSinceId(String value) {
		this.inputs.setInput("SinceId", value);
	}


	/** 
	Set the value of the TrimUser input for this Choreo. 

	@param Boolean - (optional, boolean) When set to true, each tweet returned in a timeline will include a user object including only the status authors numerical ID. Defaults to false.
	*/
	public void setTrimUser(Boolean value) {
		this.inputs.setInput("TrimUser", value);
	}

	/** 
	Set the value of the TrimUser input for this Choreo as a String. 

	@param String - (optional, boolean) When set to true, each tweet returned in a timeline will include a user object including only the status authors numerical ID. Defaults to false.
	*/
	public void setTrimUser(String value) {
		this.inputs.setInput("TrimUser", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public HomeTimelineResultSet run() {
		JSONObject result = super.runWithResults();
		return new HomeTimelineResultSet(result);
	}
	
}
