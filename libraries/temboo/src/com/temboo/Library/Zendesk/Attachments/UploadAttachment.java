package com.temboo.Library.Zendesk.Attachments;

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
UploadAttachment

Uploads a file to be used as an attachment to a ticket.
*/
public class UploadAttachment extends Choreography {

	/**
	Create a new instance of the UploadAttachment Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UploadAttachment(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Zendesk/Attachments/UploadAttachment"));
	}

	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (required, string) The email address you use to login to your Zendesk account.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the ExistingToken input for this Choreo. 

	@param String - (optional, string) Allows you to pass in an existing token when uploading multiple attachments to associate with a ticket.
	*/
	public void setExistingToken(String value) {
		this.inputs.setInput("ExistingToken", value);
	}


	/** 
	Set the value of the FileContents input for this Choreo. 

	@param String - (required, string) The Base64 encoded file contents of the attachment you want to upload.
	*/
	public void setFileContents(String value) {
		this.inputs.setInput("FileContents", value);
	}


	/** 
	Set the value of the FileName input for this Choreo. 

	@param String - (required, string) The file name of the attachment.
	*/
	public void setFileName(String value) {
		this.inputs.setInput("FileName", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) Your Zendesk password.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Server input for this Choreo. 

	@param String - (required, string) Your Zendesk domain and subdomain (e.g., temboocare.zendesk.com).
	*/
	public void setServer(String value) {
		this.inputs.setInput("Server", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - The path to a vault file to upload. Can be used as an alternative to the FileContents input.
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UploadAttachmentResultSet run() {
		JSONObject result = super.runWithResults();
		return new UploadAttachmentResultSet(result);
	}
	
}
