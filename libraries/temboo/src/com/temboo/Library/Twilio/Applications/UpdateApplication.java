package com.temboo.Library.Twilio.Applications;

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
UpdateApplication

Updates an existing application within your account.
*/
public class UpdateApplication extends Choreography {

	/**
	Create a new instance of the UpdateApplication Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateApplication(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twilio/Applications/UpdateApplication"));
	}

	/** 
	Set the value of the APIVersion input for this Choreo. 

	@param String - (optional, string) Requests to this application's URLs will start a new TwiML session with this API version. Either 2010-04-01 or 2008-08-01. Defaults to your account's default API version.
	*/
	public void setAPIVersion(String value) {
		this.inputs.setInput("APIVersion", value);
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

	@param String - (required, string) The id of the application to update.
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
	Set the value of the FriendlyName input for this Choreo. 

	@param String - (optional, string) A human readable description of the new application. Maximum 64 characters.
	*/
	public void setFriendlyName(String value) {
		this.inputs.setInput("FriendlyName", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SmsFallbackMethod input for this Choreo. 

	@param String - (optional, string) The HTTP method that should be used to request the SmsFallbackUrl. Must be either GET or POST. Defaults to POST.
	*/
	public void setSmsFallbackMethod(String value) {
		this.inputs.setInput("SmsFallbackMethod", value);
	}


	/** 
	Set the value of the SmsFallbackURL input for this Choreo. 

	@param String - (optional, string) A URL that Twilio will request if an error occurs requesting or executing the TwiML defined by SmsUrl.
	*/
	public void setSmsFallbackURL(String value) {
		this.inputs.setInput("SmsFallbackURL", value);
	}


	/** 
	Set the value of the SmsMethod input for this Choreo. 

	@param String - (optional, string) The HTTP method that should be used to request the SmsUrl. Must be either GET or POST. Defaults to POST.
	*/
	public void setSmsMethod(String value) {
		this.inputs.setInput("SmsMethod", value);
	}


	/** 
	Set the value of the SmsStatusCallback input for this Choreo. 

	@param String - (optional, string) Twilio will make a POST request to this URL to pass status parameters (such as sent or failed) to your application.
	*/
	public void setSmsStatusCallback(String value) {
		this.inputs.setInput("SmsStatusCallback", value);
	}


	/** 
	Set the value of the SmsURL input for this Choreo. 

	@param String - (optional, string) The URL that Twilio should request when somebody sends an SMS to a phone number assigned to this application.
	*/
	public void setSmsURL(String value) {
		this.inputs.setInput("SmsURL", value);
	}


	/** 
	Set the value of the StatusCallback input for this Choreo. 

	@param String - (optional, string) The URL that Twilio will request to pass status parameters (such as call ended) to your application.
	*/
	public void setStatusCallback(String value) {
		this.inputs.setInput("StatusCallback", value);
	}


	/** 
	Set the value of the StatusCallbackMethod input for this Choreo. 

	@param String - (optional, string) The HTTP method Twilio will use to make requests to the StatusCallback URL. Either GET or POST. Defaults to POST.
	*/
	public void setStatusCallbackMethod(String value) {
		this.inputs.setInput("StatusCallbackMethod", value);
	}


	/** 
	Set the value of the VoiceApplicationSID input for this Choreo. 

	@param String - (optional, string) The 34 character sid of the application Twilio should use to handle phone calls to this number.
	*/
	public void setVoiceApplicationSID(String value) {
		this.inputs.setInput("VoiceApplicationSID", value);
	}


	/** 
	Set the value of the VoiceCallerIDLookup input for this Choreo. 

	@param String - (optional, string) Do a lookup of a caller's name from the CNAM database and post it to your app. Either true or false. Defaults to false.
	*/
	public void setVoiceCallerIDLookup(String value) {
		this.inputs.setInput("VoiceCallerIDLookup", value);
	}


	/** 
	Set the value of the VoiceFallbackMethod input for this Choreo. 

	@param String - (optional, string) The HTTP method that should be used to request the VoiceFallbackUrl. Either GET or POST. Defaults to POST.
	*/
	public void setVoiceFallbackMethod(String value) {
		this.inputs.setInput("VoiceFallbackMethod", value);
	}


	/** 
	Set the value of the VoiceFallbackURL input for this Choreo. 

	@param String - (optional, string) A URL that Twilio will request if an error occurs requesting or executing the TwiML at Url.
	*/
	public void setVoiceFallbackURL(String value) {
		this.inputs.setInput("VoiceFallbackURL", value);
	}


	/** 
	Set the value of the VoiceMethod input for this Choreo. 

	@param String - (optional, string) The HTTP method that should be used to request the VoiceUrl. Must be either GET or POST. Defaults to POST.
	*/
	public void setVoiceMethod(String value) {
		this.inputs.setInput("VoiceMethod", value);
	}


	/** 
	Set the value of the VoiceURL input for this Choreo. 

	@param String - (optional, string) The URL that Twilio should request when somebody dials a phone number assigned to this application.
	*/
	public void setVoiceURL(String value) {
		this.inputs.setInput("VoiceURL", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateApplicationResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateApplicationResultSet(result);
	}
	
}
