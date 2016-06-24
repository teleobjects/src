package com.temboo.Library.Google.Gmailv2.Drafts;

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
UpdateDraft

Updates the content of an existing draft.
*/
public class UpdateDraft extends Choreography {

	/**
	Create a new instance of the UpdateDraft Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateDraft(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/Gmailv2/Drafts/UpdateDraft"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid Access Token retrieved during the OAuth2 process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new Access Token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AttachmentContentType input for this Choreo. 

	@param String - (optional, string) The Content-Type of the attachment. This is required when providing AttachmentFileContent (e.g., image/jpeg, text/plain, etc).
	*/
	public void setAttachmentContentType(String value) {
		this.inputs.setInput("AttachmentContentType", value);
	}


	/** 
	Set the value of the AttachmentFileContent input for this Choreo. 

	@param String - (optional, string) The Base64 encoded file content for the attachment. You must specify the AttachmentFileContentType when including an attachment.
	*/
	public void setAttachmentFileContent(String value) {
		this.inputs.setInput("AttachmentFileContent", value);
	}


	/** 
	Set the value of the AttachmentFileName input for this Choreo. 

	@param String - (optional, string) The file name of the attachment.
	*/
	public void setAttachmentFileName(String value) {
		this.inputs.setInput("AttachmentFileName", value);
	}


	/** 
	Set the value of the BCC input for this Choreo. 

	@param String - (optional, string) The address and name (optional) that should be bcc'd e.g., Dan <dan@temboo.com>.
	*/
	public void setBCC(String value) {
		this.inputs.setInput("BCC", value);
	}


	/** 
	Set the value of the CC input for this Choreo. 

	@param String - (optional, string) The address and name (optional) that should be cc'd e.g., Dan <dan@temboo.com>.
	*/
	public void setCC(String value) {
		this.inputs.setInput("CC", value);
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
	Set the value of the DraftID input for this Choreo. 

	@param String - (required, string) The ID of the draft to update.
	*/
	public void setDraftID(String value) {
		this.inputs.setInput("DraftID", value);
	}


	/** 
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Used to specify fields to include in a partial response. This can be used to reduce the amount of data returned. See Choreo notes for syntax rules.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the From input for this Choreo. 

	@param String - (conditional, string) The address and name (optional) that the email is being sent from e.g., Dan <dan@temboo.com>.
	*/
	public void setFrom(String value) {
		this.inputs.setInput("From", value);
	}


	/** 
	Set the value of the MessageBody input for this Choreo. 

	@param String - (conditional, string) The text for the message body of the email.
	*/
	public void setMessageBody(String value) {
		this.inputs.setInput("MessageBody", value);
	}


	/** 
	Set the value of the MessageBodyContentType input for this Choreo. 

	@param String - (optional, string) The Content-Type of the message body. Defaults to "text/plain; charset=UTF-8".
	*/
	public void setMessageBodyContentType(String value) {
		this.inputs.setInput("MessageBodyContentType", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth Refresh Token used to generate a new Access Token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the ReplyTo input for this Choreo. 

	@param String - (optional, string) An email address to set as the Reply-To address.
	*/
	public void setReplyTo(String value) {
		this.inputs.setInput("ReplyTo", value);
	}


	/** 
	Set the value of the Subject input for this Choreo. 

	@param String - (conditional, string) The email subject.
	*/
	public void setSubject(String value) {
		this.inputs.setInput("Subject", value);
	}


	/** 
	Set the value of the ThreadID input for this Choreo. 

	@param String - (optional, string) The ID of the thread the message belongs to.
	*/
	public void setThreadID(String value) {
		this.inputs.setInput("ThreadID", value);
	}


	/** 
	Set the value of the To input for this Choreo. 

	@param String - (conditional, string) The address and name (optional) that the email is being sent to e.g., Dan <dan@temboo.com>.
	*/
	public void setTo(String value) {
		this.inputs.setInput("To", value);
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
	public UpdateDraftResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateDraftResultSet(result);
	}
	
}
