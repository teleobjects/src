package com.temboo.Library.Twilio.ShortCodes;

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
UpdateShortCode

Attempts to update an existing short code resource.
*/
public class UpdateShortCode extends Choreography {

	/**
	Create a new instance of the UpdateShortCode Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateShortCode(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twilio/ShortCodes/UpdateShortCode"));
	}

	/** 
	Set the value of the APIVersion input for this Choreo. 

	@param String - (optional, string) SMSs to this short code will start a new TwiML session with this API version. Either 2010-04-01 or 2008-08-01.
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
	Set the value of the AuthToken input for this Choreo. 

	@param String - (required, string) The authorization token provided when you signed up for a Twilio account.
	*/
	public void setAuthToken(String value) {
		this.inputs.setInput("AuthToken", value);
	}


	/** 
	Set the value of the FriendlyName input for this Choreo. 

	@param String - (optional, string) A human readable description of the short code, with maximum length 64 characters.
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
	Set the value of the ShortCodeSID input for this Choreo. 

	@param String - (required, string) The id of the short code to update.
	*/
	public void setShortCodeSID(String value) {
		this.inputs.setInput("ShortCodeSID", value);
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

	@param String - (optional, string) A URL that Twilio will request if an error occurs requesting or executing the TwiML at the SmsUrl.
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

	@param String - (optional, string) The URL that Twilio should request when somebody sends an SMS to the short code.
	*/
	public void setSmsURL(String value) {
		this.inputs.setInput("SmsURL", value);
	}


	/** 
	Set the value of the SubAccountSID input for this Choreo. 

	@param String - (optional, string) The SID of the subaccount associated with short code. If not specified, the main AccountSID used to authenticate is used in the request.
	*/
	public void setSubAccountSID(String value) {
		this.inputs.setInput("SubAccountSID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateShortCodeResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateShortCodeResultSet(result);
	}
	
}
