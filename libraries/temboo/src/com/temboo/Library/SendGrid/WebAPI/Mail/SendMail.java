package com.temboo.Library.SendGrid.WebAPI.Mail;

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
SendMail

Allows you to send emails.
*/
public class SendMail extends Choreography {

	/**
	Create a new instance of the SendMail Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SendMail(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/SendGrid/WebAPI/Mail/SendMail"));
	}

	/** 
	Set the value of the FileContents input for this Choreo. 

	@param String - (optional, string) The Base64-encoded contents of the file you want to attach.
	*/
	public void setFileContents(String value) {
		this.inputs.setInput("FileContents", value);
	}


	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key obtained from SendGrid.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APIUser input for this Choreo. 

	@param String - (required, string) The username registered with SendGrid.
	*/
	public void setAPIUser(String value) {
		this.inputs.setInput("APIUser", value);
	}


	/** 
	Set the value of the BCC input for this Choreo. 

	@param String - (optional, string) Enter a BCC recipient.  Multiple recipients can also be passed in as an array of email addresses.
	*/
	public void setBCC(String value) {
		this.inputs.setInput("BCC", value);
	}


	/** 
	Set the value of the Date input for this Choreo. 

	@param String - (optional, string) The timestamp of the Block records. Enter 1 to return a date in a MySQL timestamp format - YYYY-MM-DD HH:MM:SS
	*/
	public void setDate(String value) {
		this.inputs.setInput("Date", value);
	}


	/** 
	Set the value of the FileName input for this Choreo. 

	@param String - (optional, string) The name of the file you are attaching to your email.
	*/
	public void setFileName(String value) {
		this.inputs.setInput("FileName", value);
	}


	/** 
	Set the value of the From input for this Choreo. 

	@param String - (required, string) The originating email address.  Must be from your domain.
	*/
	public void setFrom(String value) {
		this.inputs.setInput("From", value);
	}


	/** 
	Set the value of the FromName input for this Choreo. 

	@param String - (optional, string) The name to be appended to the from email.  For example, your company name, or your name.
	*/
	public void setFromName(String value) {
		this.inputs.setInput("FromName", value);
	}


	/** 
	Set the value of the HTML input for this Choreo. 

	@param String - (conditional, string) The HTML to be used in the body of your email message. Required unless specifying a plain text body in the Text input.
	*/
	public void setHTML(String value) {
		this.inputs.setInput("HTML", value);
	}


	/** 
	Set the value of the Headers input for this Choreo. 

	@param String - (optional, json) The collection of key/value pairs in JSON format. Each key represents a header name and the value the header value. For example: {"X-Accept-Language": "en", "X-Mailer": "MyApp"}
	*/
	public void setHeaders(String value) {
		this.inputs.setInput("Headers", value);
	}


	/** 
	Set the value of the ReplyTo input for this Choreo. 

	@param String - (optional, string) The email address to append to the reply-to field of your email.
	*/
	public void setReplyTo(String value) {
		this.inputs.setInput("ReplyTo", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format of the response from SendGrid, in either json, or xml.  Default is set to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Subject input for this Choreo. 

	@param String - (required, string) The subject of the email message.
	*/
	public void setSubject(String value) {
		this.inputs.setInput("Subject", value);
	}


	/** 
	Set the value of the Text input for this Choreo. 

	@param String - (conditional, string) The text of the email message. Required unless providing the message body using the HTML input.
	*/
	public void setText(String value) {
		this.inputs.setInput("Text", value);
	}


	/** 
	Set the value of the To input for this Choreo. 

	@param String - (required, string) The valid recipient email address.  Multiple addresses can be entered as elements of an array.
	*/
	public void setTo(String value) {
		this.inputs.setInput("To", value);
	}


	/** 
	Set the value of the ToName input for this Choreo. 

	@param String - (optional, string) The name of the email recipient.
	*/
	public void setToName(String value) {
		this.inputs.setInput("ToName", value);
	}


	/** 
	Set the value of the XSMTPAPI input for this Choreo. 

	@param String - (optional, json) Must be valid JSON format.  See here for additional info: http://docs.sendgrid.com/documentation/api/smtp-api/
	*/
	public void setXSMTPAPI(String value) {
		this.inputs.setInput("XSMTPAPI", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - A path to a vault file to use for the attachment. Can be used as an alternative to the FileContents input.
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SendMailResultSet run() {
		JSONObject result = super.runWithResults();
		return new SendMailResultSet(result);
	}
	
}
