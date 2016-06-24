package com.temboo.Library.Twilio.Queues;

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
CreateQueue

Creates a new queue within a Twilio account.
*/
public class CreateQueue extends Choreography {

	/**
	Create a new instance of the CreateQueue Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateQueue(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twilio/Queues/CreateQueue"));
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

	@param String - (required, string) A unique identifier for this queue.
	*/
	public void setFriendlyName(String value) {
		this.inputs.setInput("FriendlyName", value);
	}


	/** 
	Set the value of the MaxSize input for this Choreo. 

	@param Integer - (optional, integer) The maximum size of this queue. The default is 100. The maximum is 1000.
	*/
	public void setMaxSize(Integer value) {
		this.inputs.setInput("MaxSize", value);
	}

	/** 
	Set the value of the MaxSize input for this Choreo as a String. 

	@param String - (optional, integer) The maximum size of this queue. The default is 100. The maximum is 1000.
	*/
	public void setMaxSize(String value) {
		this.inputs.setInput("MaxSize", value);	
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

	@param String - (optional, string) The SID of the subaccount that the queue should be associated with. If not specified, the main AccountSID used to authenticate is used in the request.
	*/
	public void setSubAccountSID(String value) {
		this.inputs.setInput("SubAccountSID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateQueueResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateQueueResultSet(result);
	}
	
}
