package com.temboo.Library.Zendesk.Macros;

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
ApplyMacroToAllTickets

Applies a given macro to all applicable tickets.
*/
public class ApplyMacroToAllTickets extends Choreography {

	/**
	Create a new instance of the ApplyMacroToAllTickets Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ApplyMacroToAllTickets(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Zendesk/Macros/ApplyMacroToAllTickets"));
	}

	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (required, string) The email address you use to login to your Zendesk account.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
	}


	/** 
	Set the value of the MacroID input for this Choreo. 

	@param Integer - (required, integer) The ID of the macro to apply.
	*/
	public void setMacroID(Integer value) {
		this.inputs.setInput("MacroID", value);
	}

	/** 
	Set the value of the MacroID input for this Choreo as a String. 

	@param String - (required, integer) The ID of the macro to apply.
	*/
	public void setMacroID(String value) {
		this.inputs.setInput("MacroID", value);	
	}
	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) Your Zendesk password.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Server input for this Choreo. 

	@param String - (required, string) Your Zendesk domain and subdomain (e.g., temboocare.zendesk.com).
	*/
	public void setServer(String value) {
		this.inputs.setInput("Server", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ApplyMacroToAllTicketsResultSet run() {
		JSONObject result = super.runWithResults();
		return new ApplyMacroToAllTicketsResultSet(result);
	}
	
}
