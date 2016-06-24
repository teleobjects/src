package com.temboo.Library.Utilities.Email;

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
SendEmail

Sends an email using a specified email server.
*/
public class SendEmail extends Choreography {

	/**
	Create a new instance of the SendEmail Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SendEmail(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Utilities/Email/SendEmail"));
	}

	/** 
	Set the value of the Attachment input for this Choreo. 

	@param String - (optional, string) The Base64 encoded contents of the file to attach to the email.  Use this instead of AttachmentURL.
	*/
	public void setAttachment(String value) {
		this.inputs.setInput("Attachment", value);
	}


	/** 
	Set the value of the AttachmentName input for this Choreo. 

	@param String - (optional, string) The name of the file to attach to the email.
	*/
	public void setAttachmentName(String value) {
		this.inputs.setInput("AttachmentName", value);
	}


	/** 
	Set the value of the AttachmentURL input for this Choreo. 

	@param String - (optional, string) URL of a hosted file that you wish to add as an attachment.  Use this instead of a normal Attachment.
	*/
	public void setAttachmentURL(String value) {
		this.inputs.setInput("AttachmentURL", value);
	}


	/** 
	Set the value of the BCC input for this Choreo. 

	@param String - (optional, string) An email address to BCC on the email you're sending. Can be a comma separated list of email addresses.
	*/
	public void setBCC(String value) {
		this.inputs.setInput("BCC", value);
	}


	/** 
	Set the value of the CC input for this Choreo. 

	@param String - (optional, string) An email address to CC on the email you're sending. Can be a comma separated list of email addresses.
	*/
	public void setCC(String value) {
		this.inputs.setInput("CC", value);
	}


	/** 
	Set the value of the FromAddress input for this Choreo. 

	@param String - (conditional, string) The name and email address that the message is being sent from.
	*/
	public void setFromAddress(String value) {
		this.inputs.setInput("FromAddress", value);
	}


	/** 
	Set the value of the MessageBody input for this Choreo. 

	@param String - (required, string) The message body for the email.
	*/
	public void setMessageBody(String value) {
		this.inputs.setInput("MessageBody", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) The password for your email account.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Port input for this Choreo. 

	@param Integer - (required, integer) Specify the port number (e.g., 25, 465, 587).
	*/
	public void setPort(Integer value) {
		this.inputs.setInput("Port", value);
	}

	/** 
	Set the value of the Port input for this Choreo as a String. 

	@param String - (required, integer) Specify the port number (e.g., 25, 465, 587).
	*/
	public void setPort(String value) {
		this.inputs.setInput("Port", value);	
	}
	/** 
	Set the value of the Server input for this Choreo. 

	@param String - (required, string) The name or IP address of the email server.
	*/
	public void setServer(String value) {
		this.inputs.setInput("Server", value);
	}


	/** 
	Set the value of the Subject input for this Choreo. 

	@param String - (required, string) The subject line of the email.
	*/
	public void setSubject(String value) {
		this.inputs.setInput("Subject", value);
	}


	/** 
	Set the value of the ToAddress input for this Choreo. 

	@param String - (required, string) The email address that you want to send an email to. Can be a comma separated list of email addresses.
	*/
	public void setToAddress(String value) {
		this.inputs.setInput("ToAddress", value);
	}


	/** 
	Set the value of the UseSSL input for this Choreo. 

	@param Boolean - (optional, boolean) Set to 1 to connect over SSL. Set to 0 for no SSL or to enable TLS. Defaults to 1.
	*/
	public void setUseSSL(Boolean value) {
		this.inputs.setInput("UseSSL", value);
	}

	/** 
	Set the value of the UseSSL input for this Choreo as a String. 

	@param String - (optional, boolean) Set to 1 to connect over SSL. Set to 0 for no SSL or to enable TLS. Defaults to 1.
	*/
	public void setUseSSL(String value) {
		this.inputs.setInput("UseSSL", value);	
	}
	/** 
	Set the value of the Username input for this Choreo. 

	@param String - (required, string) Your username for your email account.
	*/
	public void setUsername(String value) {
		this.inputs.setInput("Username", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SendEmailResultSet run() {
		JSONObject result = super.runWithResults();
		return new SendEmailResultSet(result);
	}
	
}
