package com.temboo.Library.Bugzilla;

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
RetrieveAttachment

Retrieves a bug attachment by ID.
*/
public class RetrieveAttachment extends Choreography {

	/**
	Create a new instance of the RetrieveAttachment Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RetrieveAttachment(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Bugzilla/RetrieveAttachment"));
	}

	/** 
	Set the value of the AttachmentID input for this Choreo. 

	@param Integer - (required, integer) The ID of the attachment to retrieve.
	*/
	public void setAttachmentID(Integer value) {
		this.inputs.setInput("AttachmentID", value);
	}

	/** 
	Set the value of the AttachmentID input for this Choreo as a String. 

	@param String - (required, integer) The ID of the attachment to retrieve.
	*/
	public void setAttachmentID(String value) {
		this.inputs.setInput("AttachmentID", value);	
	}
	/** 
	Set the value of the AttachmentsWithData input for this Choreo. 

	@param Integer - (optional, integer) Enter 1 to obtain full bug attachments data.  If null, only attachments fields will be returned with no associated data.
	*/
	public void setAttachmentsWithData(Integer value) {
		this.inputs.setInput("AttachmentsWithData", value);
	}

	/** 
	Set the value of the AttachmentsWithData input for this Choreo as a String. 

	@param String - (optional, integer) Enter 1 to obtain full bug attachments data.  If null, only attachments fields will be returned with no associated data.
	*/
	public void setAttachmentsWithData(String value) {
		this.inputs.setInput("AttachmentsWithData", value);	
	}
	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (optional, password) Your Bugzilla password.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Server input for this Choreo. 

	@param String - (optional, string) The base URL for the Bugzilla server to access. Defaults to https://api-dev.bugzilla.mozilla.org/latest. To access the test server, set to https://api-dev.bugzilla.mozilla.org/test/latest.
	*/
	public void setServer(String value) {
		this.inputs.setInput("Server", value);
	}


	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (optional, string) Your Bugzilla username.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RetrieveAttachmentResultSet run() {
		JSONObject result = super.runWithResults();
		return new RetrieveAttachmentResultSet(result);
	}
	
}
