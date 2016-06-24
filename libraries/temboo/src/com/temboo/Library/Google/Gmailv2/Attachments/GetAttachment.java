package com.temboo.Library.Google.Gmailv2.Attachments;

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
GetAttachment

Gets the specified message attachment.
*/
public class GetAttachment extends Choreography {

	/**
	Create a new instance of the GetAttachment Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetAttachment(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Gmailv2/Attachments/GetAttachment"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved during the OAuth2 process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AttachmentID input for this Choreo. 

	@param String - (required, string) The ID of the attachment to retrieve.
	*/
	public void setAttachmentID(String value) {
		this.inputs.setInput("AttachmentID", value);
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

	@param String - (optional, string) Selector specifying a subset of fields to include in the response.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the Format input for this Choreo. 

	@param Boolean - (optional, boolean) Specifies the format of the message returned. Valid values are: full (the default), minimal, and raw. See Choreo notes for more details about these formats.
	*/
	public void setFormat(Boolean value) {
		this.inputs.setInput("Format", value);
	}

	/** 
	Set the value of the Format input for this Choreo as a String. 

	@param String - (optional, boolean) Specifies the format of the message returned. Valid values are: full (the default), minimal, and raw. See Choreo notes for more details about these formats.
	*/
	public void setFormat(String value) {
		this.inputs.setInput("Format", value);	
	}
	/** 
	Set the value of the MessageID input for this Choreo. 

	@param String - (required, string) The ID of the message to retrieve.
	*/
	public void setMessageID(String value) {
		this.inputs.setInput("MessageID", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth refresh token used to generate a new access token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (optional, string) The id of the acting user. Defaults to "me" indicating the user associated with the access token or refresh token provided.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetAttachmentResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetAttachmentResultSet(result);
	}
	
}
