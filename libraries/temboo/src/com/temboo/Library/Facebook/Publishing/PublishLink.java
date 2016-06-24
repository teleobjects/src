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
PublishLink

Publishes a link on a given profile.
*/
public class PublishLink extends Choreography {

	/**
	Create a new instance of the PublishLink Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PublishLink(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Facebook/Publishing/PublishLink"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The access token retrieved from the final step of the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the Caption input for this Choreo. 

	@param String - (optional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setCaption(String value) {
		this.inputs.setInput("Caption", value);
	}


	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the Link input for this Choreo. 

	@param String - (required, string) The link to publish.
	*/
	public void setLink(String value) {
		this.inputs.setInput("Link", value);
	}


	/** 
	Set the value of the Message input for this Choreo. 

	@param String - (optional, string) A message about the link.
	*/
	public void setMessage(String value) {
		this.inputs.setInput("Message", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (optional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the Picture input for this Choreo. 

	@param String - (optional, string) Deprecated (retained for backward compatibility only).
	*/
	public void setPicture(String value) {
		this.inputs.setInput("Picture", value);
	}


	/** 
	Set the value of the ProfileID input for this Choreo. 

	@param String - (optional, string) The id of the profile that the link will be published to. Defaults to "me" indicating the authenticated user.
	*/
	public void setProfileID(String value) {
		this.inputs.setInput("ProfileID", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PublishLinkResultSet run() {
		JSONObject result = super.runWithResults();
		return new PublishLinkResultSet(result);
	}
	
}
