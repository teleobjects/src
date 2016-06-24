package com.temboo.Library.Twilio.Calls;

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
MakeCall

Initiates a call from the specified Twilio account.
*/
public class MakeCall extends Choreography {

	/**
	Create a new instance of the MakeCall Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public MakeCall(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twilio/Calls/MakeCall"));
	}

	/** 
	Set the value of the AccountSID input for this Choreo. 

	@param String - (required, string) The AccountSID provided when you signed up for a Twilio account.
	*/
	public void setAccountSID(String value) {
		this.inputs.setInput("AccountSID", value);
	}


	/** 
	Set the value of the ApplicationSID input for this Choreo. 

	@param String - (conditional, string) The 34 character sid of the application Twilio should use to handle this phone call. Required unless providing the URL parameter.
	*/
	public void setApplicationSID(String value) {
		this.inputs.setInput("ApplicationSID", value);
	}


	/** 
	Set the value of the AuthToken input for this Choreo. 

	@param String - (required, string) The authorization token provided when you signed up for a Twilio account.
	*/
	public void setAuthToken(String value) {
		this.inputs.setInput("AuthToken", value);
	}


	/** 
	Set the value of the FallbackMethod input for this Choreo. 

	@param String - (optional, string) The HTTP method that Twilio should use to request the FallbackUrl. Valid values are: GET and POST.
	*/
	public void setFallbackMethod(String value) {
		this.inputs.setInput("FallbackMethod", value);
	}


	/** 
	Set the value of the FallbackURL input for this Choreo. 

	@param String - (optional, string) A URL that Twilio will request if an error occurs making a request to the URL provided. This is ignored when ApplicationSID is provided.
	*/
	public void setFallbackURL(String value) {
		this.inputs.setInput("FallbackURL", value);
	}


	/** 
	Set the value of the From input for this Choreo. 

	@param String - (required, string) The Twilio phone number or client identifier to use as the caller id.
	*/
	public void setFrom(String value) {
		this.inputs.setInput("From", value);
	}


	/** 
	Set the value of the IfMachine input for this Choreo. 

	@param String - (optional, string) Indicates if Twilio should to try and determine if a machine (like voicemail) or a human has answered the call. Possible values are "Continue" and "Hangup".
	*/
	public void setIfMachine(String value) {
		this.inputs.setInput("IfMachine", value);
	}


	/** 
	Set the value of the Method input for this Choreo. 

	@param String - (optional, string) This the HTTP method Twilio will use when making its request to the URL (when the URL input is provided). Defaults to POST. This is ignored when ApplicationSID is provided.
	*/
	public void setMethod(String value) {
		this.inputs.setInput("Method", value);
	}


	/** 
	Set the value of the Record input for this Choreo. 

	@param Boolean - (optional, boolean) Set this parameter to 'true' to record the entirety of a phone call.
	*/
	public void setRecord(Boolean value) {
		this.inputs.setInput("Record", value);
	}

	/** 
	Set the value of the Record input for this Choreo as a String. 

	@param String - (optional, boolean) Set this parameter to 'true' to record the entirety of a phone call.
	*/
	public void setRecord(String value) {
		this.inputs.setInput("Record", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SendDigits input for this Choreo. 

	@param String - (optional, string) A string of keys to dial after connecting to the number. Valid digits in the string include: any digit (0-9), '#', '*' and 'w' (to insert a half second pause).
	*/
	public void setSendDigits(String value) {
		this.inputs.setInput("SendDigits", value);
	}


	/** 
	Set the value of the StatusCallback input for this Choreo. 

	@param String - (optional, string) A URL that Twilio will request when the call ends to notify your app. This is ignored when ApplicationSID is provided.
	*/
	public void setStatusCallback(String value) {
		this.inputs.setInput("StatusCallback", value);
	}


	/** 
	Set the value of the StatusCallbackMethod input for this Choreo. 

	@param String - (optional, string) The HTTP method Twilio should use when requesting the StatusCallback URL. Defaults to POST. If an ApplicationSid parameter is present, this parameter is ignored.
	*/
	public void setStatusCallbackMethod(String value) {
		this.inputs.setInput("StatusCallbackMethod", value);
	}


	/** 
	Set the value of the SubAccountSID input for this Choreo. 

	@param String - (optional, string) The SID of the subaccount associated with this call. If not specified, the main AccountSID used to authenticate is used in request.
	*/
	public void setSubAccountSID(String value) {
		this.inputs.setInput("SubAccountSID", value);
	}


	/** 
	Set the value of the Timeout input for this Choreo. 

	@param Integer - (optional, integer) The integer number of seconds that Twilio should allow the phone to ring before assuming there is no answer. Default is 60 seconds, the maximum is 999 seconds.
	*/
	public void setTimeout(Integer value) {
		this.inputs.setInput("Timeout", value);
	}

	/** 
	Set the value of the Timeout input for this Choreo as a String. 

	@param String - (optional, integer) The integer number of seconds that Twilio should allow the phone to ring before assuming there is no answer. Default is 60 seconds, the maximum is 999 seconds.
	*/
	public void setTimeout(String value) {
		this.inputs.setInput("Timeout", value);	
	}
	/** 
	Set the value of the To input for this Choreo. 

	@param String - (required, string) The phone number or client identifier to call.
	*/
	public void setTo(String value) {
		this.inputs.setInput("To", value);
	}


	/** 
	Set the value of the URL input for this Choreo. 

	@param String - (conditional, string) The fully qualified URL that should be consulted when the call connects. Required unless providing the ApplicationSID parameter.
	*/
	public void setURL(String value) {
		this.inputs.setInput("URL", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public MakeCallResultSet run() {
		JSONObject result = super.runWithResults();
		return new MakeCallResultSet(result);
	}
	
}
