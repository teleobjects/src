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
ListMessages

Retrieves a list of SMS messages from your Twilio account.
*/
public class ListMessages extends Choreography {

	/**
	Create a new instance of the ListMessages Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ListMessages(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twilio/SMSMessages/ListMessages"));
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
	Set the value of the DateSent input for this Choreo. 

	@param String - (optional, date) A date in YYYY-MM-DD format. If you use this input, the Choreo will retrieve only messages sent on this date.
	*/
	public void setDateSent(String value) {
		this.inputs.setInput("DateSent", value);
	}


	/** 
	Set the value of the From input for this Choreo. 

	@param String - (optional, string) If used, the Choreo will only retrieve messages sent from this phone number.
	*/
	public void setFrom(String value) {
		this.inputs.setInput("From", value);
	}


	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) The page of results to retrieve. Defaults to 0.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) The page of results to retrieve. Defaults to 0.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the PageSize input for this Choreo. 

	@param Integer - (optional, integer) The number of results per page.
	*/
	public void setPageSize(Integer value) {
		this.inputs.setInput("PageSize", value);
	}

	/** 
	Set the value of the PageSize input for this Choreo as a String. 

	@param String - (optional, integer) The number of results per page.
	*/
	public void setPageSize(String value) {
		this.inputs.setInput("PageSize", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the ReturnLegacyFormat input for this Choreo. 

	@param Boolean - (optional, boolean) If set to true, the response will be formatted using the deprecated /SMS/Messages resource schema. This should only be used if you have existing code that relies on the older schema.
	*/
	public void setReturnLegacyFormat(Boolean value) {
		this.inputs.setInput("ReturnLegacyFormat", value);
	}

	/** 
	Set the value of the ReturnLegacyFormat input for this Choreo as a String. 

	@param String - (optional, boolean) If set to true, the response will be formatted using the deprecated /SMS/Messages resource schema. This should only be used if you have existing code that relies on the older schema.
	*/
	public void setReturnLegacyFormat(String value) {
		this.inputs.setInput("ReturnLegacyFormat", value);	
	}
	/** 
	Set the value of the SubAccountSID input for this Choreo. 

	@param String - (optional, string) The SID of the subaccount to retrieve the message from. If not specified, the main AccountSID used to authenticate is used in request.
	*/
	public void setSubAccountSID(String value) {
		this.inputs.setInput("SubAccountSID", value);
	}


	/** 
	Set the value of the To input for this Choreo. 

	@param String - (optional, string) If used, the Choreo will only retrieve messages sent to this phone number.
	*/
	public void setTo(String value) {
		this.inputs.setInput("To", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ListMessagesResultSet run() {
		JSONObject result = super.runWithResults();
		return new ListMessagesResultSet(result);
	}
	
}
