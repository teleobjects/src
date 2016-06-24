package com.temboo.Library.Twilio.Conferences;

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
DeleteParticipant

Removes an individual partipant from a conference.
*/
public class DeleteParticipant extends Choreography {

	/**
	Create a new instance of the DeleteParticipant Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DeleteParticipant(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Twilio/Conferences/DeleteParticipant"));
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
	Set the value of the CallSID input for this Choreo. 

	@param String - (required, string) The call id associated with the participant to delete.
	*/
	public void setCallSID(String value) {
		this.inputs.setInput("CallSID", value);
	}


	/** 
	Set the value of the ConferenceSID input for this Choreo. 

	@param String - (required, string) The id of the conference that the participant is in.
	*/
	public void setConferenceSID(String value) {
		this.inputs.setInput("ConferenceSID", value);
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

	@param String - (optional, string) The SID of the subaccount associated with the conference. If not specified, the main AccountSID used to authenticate is used in the request.
	*/
	public void setSubAccountSID(String value) {
		this.inputs.setInput("SubAccountSID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DeleteParticipantResultSet run() {
		JSONObject result = super.runWithResults();
		return new DeleteParticipantResultSet(result);
	}
	
}
