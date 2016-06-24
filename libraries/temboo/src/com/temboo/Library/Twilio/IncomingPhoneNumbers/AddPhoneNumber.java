package com.temboo.Library.Twilio.IncomingPhoneNumbers;

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
AddPhoneNumber

Purchases a new phone number for your Twilio account.
*/
public class AddPhoneNumber extends Choreography {

	/**
	Create a new instance of the AddPhoneNumber Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddPhoneNumber(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twilio/IncomingPhoneNumbers/AddPhoneNumber"));
	}

	/** 
	Set the value of the APIVersion input for this Choreo. 

	@param String - (optional, string) Calls to this phone number will start a new TwiML session with this API version. Either 2010-04-01 or 2008-08-01.
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
	Set the value of the AreaCode input for this Choreo. 

	@param Integer - (conditional, integer) The desired area code for your new incoming phone number. Required unless specifying the complete PhoneNumber.
	*/
	public void setAreaCode(Integer value) {
		this.inputs.setInput("AreaCode", value);
	}

	/** 
	Set the value of the AreaCode input for this Choreo as a String. 

	@param String - (conditional, integer) The desired area code for your new incoming phone number. Required unless specifying the complete PhoneNumber.
	*/
	public void setAreaCode(String value) {
		this.inputs.setInput("AreaCode", value);	
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

	@param String - (optional, string) A human readable description of the new incoming phone number resource, with maximum length 64 characters.
	*/
	public void setFriendlyName(String value) {
		this.inputs.setInput("FriendlyName", value);
	}


	/** 
	Set the value of the PhoneNumber input for this Choreo. 

	@param String - (conditional, string) The phone number you want to purchase. Required unless provided the AreaCode.
	*/
	public void setPhoneNumber(String value) {
		this.inputs.setInput("PhoneNumber", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SmsApplicationSID input for this Choreo. 

	@param String - (optional, string) The 34 character sid of the application Twilio should use to handle SMSs sent to this number.
	*/
	public void setSmsApplicationSID(String value) {
		this.inputs.setInput("SmsApplicationSID", value);
	}


	/** 
	Set the value of the SmsFallbackMethod input for this Choreo. 

	@param String - (optional, string) The HTTP method that should be used to request the SmsFallbackUrl. Either GET or POST.
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

	@param String - (optional, string) The HTTP method that should be used to request the SmsUrl. Either GET or POST.
	*/
	public void setSmsMethod(String value) {
		this.inputs.setInput("SmsMethod", value);
	}


	/** 
	Set the value of the SmsURL input for this Choreo. 

	@param String - (optional, string) The URL that Twilio should request when somebody sends an SMS to the new phone number.
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

	@param String - (optional, string) The HTTP method Twilio will use to make requests to the StatusCallback URL. Either GET or POST.
	*/
	public void setStatusCallbackMethod(String value) {
		this.inputs.setInput("StatusCallbackMethod", value);
	}


	/** 
	Set the value of the SubAccountSID input for this Choreo. 

	@param String - (optional, string) The SID of the subaccount associated with the phone number. If not specified, the main AccountSID used to authenticate is used in the request.
	*/
	public void setSubAccountSID(String value) {
		this.inputs.setInput("SubAccountSID", value);
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

	@param String - (optional, string) Do a lookup of a caller's name from the CNAM database and post it to your app. Either true or false.
	*/
	public void setVoiceCallerIDLookup(String value) {
		this.inputs.setInput("VoiceCallerIDLookup", value);
	}


	/** 
	Set the value of the VoiceFallbackMethod input for this Choreo. 

	@param String - (optional, string) The HTTP method that should be used to request the VoiceFallbackURL. Either GET or POST.
	*/
	public void setVoiceFallbackMethod(String value) {
		this.inputs.setInput("VoiceFallbackMethod", value);
	}


	/** 
	Set the value of the VoiceFallbackURL input for this Choreo. 

	@param String - (optional, string) A URL that Twilio will request if an error occurs requesting or executing the TwiML defined by VoiceURL.
	*/
	public void setVoiceFallbackURL(String value) {
		this.inputs.setInput("VoiceFallbackURL", value);
	}


	/** 
	Set the value of the VoiceMethod input for this Choreo. 

	@param String - (optional, string) The HTTP method that should be used to request the VoiceURL. Either GET or POST.
	*/
	public void setVoiceMethod(String value) {
		this.inputs.setInput("VoiceMethod", value);
	}


	/** 
	Set the value of the VoiceURL input for this Choreo. 

	@param String - (optional, string) The URL that Twilio should request when somebody dials the phone number.
	*/
	public void setVoiceURL(String value) {
		this.inputs.setInput("VoiceURL", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddPhoneNumberResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddPhoneNumberResultSet(result);
	}
	
}
