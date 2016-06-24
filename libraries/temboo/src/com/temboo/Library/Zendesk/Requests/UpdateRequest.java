package com.temboo.Library.Zendesk.Requests;

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
UpdateRequest

Updates an existing request.
*/
public class UpdateRequest extends Choreography {

	/**
	Create a new instance of the UpdateRequest Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateRequest(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Zendesk/Requests/UpdateRequest"));
	}

	/** 
	Set the value of the RequestData input for this Choreo. 

	@param String - (optional, json) A JSON-formatted string containing the request properties you wish to set. This can be used as an alternative to setting individual inputs representing request properties.
	*/
	public void setRequestData(String value) {
		this.inputs.setInput("RequestData", value);
	}


	/** 
	Set the value of the Comment input for this Choreo. 

	@param String - (conditional, string) A comment associated with the request.
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
	Set the value of the ID input for this Choreo. 

	@param String - (conditional, string) The ID of the request to update.
	*/
	public void setID(String value) {
		this.inputs.setInput("ID", value);
	}


	/** 
	Set the value of the Password input for this Choreo. 

	@param String - (required, password) Your Zendesk password.
	*/
	public void setPassword(String value) {
		this.inputs.setInput("Password", value);
	}


	/** 
	Set the value of the Priority input for this Choreo. 

	@param String - (conditional, string) Priority (e.g. low, normal, high, urgent). Defaults to normal.
	*/
	public void setPriority(String value) {
		this.inputs.setInput("Priority", value);
	}


	/** 
	Set the value of the Server input for this Choreo. 

	@param String - (required, string) Your Zendesk domain and subdomain (e.g., temboocare.zendesk.com).
	*/
	public void setServer(String value) {
		this.inputs.setInput("Server", value);
	}


	/** 
	Set the value of the Subject input for this Choreo. 

	@param String - (conditional, string) The subject of the request.
	*/
	public void setSubject(String value) {
		this.inputs.setInput("Subject", value);
	}


	/** 
	Set the value of the Type input for this Choreo. 

	@param String - (conditional, string) Type of request (e.g.question, incident, problem, task). Defaults to incident.
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public UpdateRequestResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateRequestResultSet(result);
	}
	
}
