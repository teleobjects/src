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
GetLastMessageThatContains

Retrieves the latest received message that contains the specified search string.
*/
public class GetLastMessageThatContains extends Choreography {

	/**
	Create a new instance of the GetLastMessageThatContains Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetLastMessageThatContains(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twilio/SMSMessages/GetLastMessageThatContains"));
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
	Set the value of the Filter input for this Choreo. 

	@param String - (required, string) A search string to apply to the message body field.
	*/
	public void setFilter(String value) {
		this.inputs.setInput("Filter", value);
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

	@param Integer - (optional, integer) The number of results per page to search through. Defaults to 50.
	*/
	public void setPageSize(Integer value) {
		this.inputs.setInput("PageSize", value);
	}

	/** 
	Set the value of the PageSize input for this Choreo as a String. 

	@param String - (optional, integer) The number of results per page to search through. Defaults to 50.
	*/
	public void setPageSize(String value) {
		this.inputs.setInput("PageSize", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are: json (the default) and xml. This parameter is only valid when setting ResponseMode to "verbose".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the ResponseMode input for this Choreo. 

	@param String - (optional, string) Used to simplify the response. Valid values are: simple and verbose. When set to simple, only the message string is returned. Verbose mode returns the full object. Defaults to "simple".
	*/
	public void setResponseMode(String value) {
		this.inputs.setInput("ResponseMode", value);
	}


	/** 
	Set the value of the ReturnLegacyFormat input for this Choreo. 

	@param Boolean - (optional, boolean) If set to true, XML responses will be formatted using the deprecated /SMS/Messages resource schema. This should only be used if you have existing code that relies on the older schema.
	*/
	public void setReturnLegacyFormat(Boolean value) {
		this.inputs.setInput("ReturnLegacyFormat", value);
	}

	/** 
	Set the value of the ReturnLegacyFormat input for this Choreo as a String. 

	@param String - (optional, boolean) If set to true, XML responses will be formatted using the deprecated /SMS/Messages resource schema. This should only be used if you have existing code that relies on the older schema.
	*/
	public void setReturnLegacyFormat(String value) {
		this.inputs.setInput("ReturnLegacyFormat", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetLastMessageThatContainsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetLastMessageThatContainsResultSet(result);
	}
	
}
