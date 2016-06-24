package com.temboo.Library.Google.Gmailv2.Labels;

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
UpdateLabel

Updates a specific label.
*/
public class UpdateLabel extends Choreography {

	/**
	Create a new instance of the UpdateLabel Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateLabel(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Gmailv2/Labels/UpdateLabel"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid Access Token retrieved during the OAuth2 process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new Access Token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Used to specify fields to include in a partial response. This can be used to reduce the amount of data returned. See Choreo notes for syntax rules.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the LabelID input for this Choreo. 

	@param String - (required, string) The ID of the label to update.
	*/
	public void setLabelID(String value) {
		this.inputs.setInput("LabelID", value);
	}


	/** 
	Set the value of the LabelListVisibility input for this Choreo. 

	@param String - (required, string) The visibility of the label in the label list in the Gmail web interface. Valid values are: "labelHide", "labelShow", and "labelShowIfUnread.
	*/
	public void setLabelListVisibility(String value) {
		this.inputs.setInput("LabelListVisibility", value);
	}


	/** 
	Set the value of the MessageListVisibility input for this Choreo. 

	@param String - (required, string) The visibility of messages with this label in the message list in the Gmail web interface. Valid values are: "hide" and "show".
	*/
	public void setMessageListVisibility(String value) {
		this.inputs.setInput("MessageListVisibility", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) The display name of the label.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth Refresh Token used to generate a new Access Token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The ID of the acting user. Defaults to "me" indicating the user associated with the Access Token or Refresh Token provided.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateLabelResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateLabelResultSet(result);
	}
	
}
