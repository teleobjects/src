package com.temboo.Library.Twilio.SMSMessages;

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
SendSMS

Sends an SMS to a specified phone number using the Twilio API.
*/
public class SendSMS extends Choreography {

	/**
	Create a new instance of the SendSMS Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SendSMS(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twilio/SMSMessages/SendSMS"));
	}

	/** 
	Set the value of the AccountSID input for this Choreo. 

	@param String - (required, string) The AccountSID provided when you signed up for a Twilio account.
	*/
	public void setAccountSID(String value) {
		this.inputs.setInput("AccountSID", value);
	}


	/** 
	Set the value of the AuthToken input for this Choreo. 

	@param String - (required, string) The authorization token provided when you signed up for a Twilio account.
	*/
	public void setAuthToken(String value) {
		this.inputs.setInput("AuthToken", value);
	}


	/** 
	Set the value of the Body input for this Choreo. 

	@param String - (conditional, string) The text of the message.
	*/
	public void setBody(String value) {
		this.inputs.setInput("Body", value);
	}


	/** 
	Set the value of the From input for this Choreo. 

	@param String - (required, string) The purchased Twilio phone number, Twilio Sandbox number, or short code enabled for the type of message you wish to send (SMS or MMS). Format with a '+' and country code e.g., +16175551212.
	*/
	public void setFrom(String value) {
		this.inputs.setInput("From", value);
	}


	/** 
	Set the value of the MediaURL input for this Choreo. 

	@param String - (optional, string) One or more URLs for media you wish to send with the message. Supported formats include: png, gif, and jpeg. Multiple URLs (up-to 10) should be separated by commas.
	*/
	public void setMediaURL(String value) {
		this.inputs.setInput("MediaURL", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SubAccountSID input for this Choreo. 

	@param String - (optional, string) The SID of the subaccount to send the message from. If not specified, the main AccountSID used to authenticate is used in request.
	*/
	public void setSubAccountSID(String value) {
		this.inputs.setInput("SubAccountSID", value);
	}


	/** 
	Set the value of the To input for this Choreo. 

	@param String - (required, string) The destination phone number. Format with a '+' and country code e.g., +16175551212.
	*/
	public void setTo(String value) {
		this.inputs.setInput("To", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SendSMSResultSet run() {
		JSONObject result = super.runWithResults();
		return new SendSMSResultSet(result);
	}
	
}
