package com.temboo.Library.Zendesk.Tickets;

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
CreateTicket

Creates a new ticket.
*/
public class CreateTicket extends Choreography {

	/**
	Create a new instance of the CreateTicket Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateTicket(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Zendesk/Tickets/CreateTicket"));
	}

	/** 
	Set the value of the Comment input for this Choreo. 

	@param String - (conditional, string) The comment for the ticket that is being created.
	*/
	public void setComment(String value) {
		this.inputs.setInput("Comment", value);
	}


	/** 
	Set the value of the Email input for this Choreo. 

	@param String - (required, string) The email address you use to login to your Zendesk account.
	*/
	public void setEmail(String value) {
		this.inputs.setInput("Email", value);
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

	@param String - (required, string) Your Zendesk domain and subdomain (i.e. temboocare.zendesk.com).
	*/
	public void setServer(String value) {
		this.inputs.setInput("Server", value);
	}


	/** 
	Set the value of the Subject input for this Choreo. 

	@param String - (conditional, string) The subject for the ticket that is being created.
	*/
	public void setSubject(String value) {
		this.inputs.setInput("Subject", value);
	}


	/** 
	Set the value of the TicketData input for this Choreo. 

	@param String - (optional, json) A JSON-formatted string containing the ticket properties you wish to set. This can be used as an alternative to setting individual inputs representing ticket properties.
	*/
	public void setTicketData(String value) {
		this.inputs.setInput("TicketData", value);
	}


	/** 
	Set the value of the Token input for this Choreo. 

	@param String - (optional, string) The token associated with an upload to attach to this ticket. Note that tokens can be retrieved by running the UploadFile Choreo.
	*/
	public void setToken(String value) {
		this.inputs.setInput("Token", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateTicketResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateTicketResultSet(result);
	}
	
}
