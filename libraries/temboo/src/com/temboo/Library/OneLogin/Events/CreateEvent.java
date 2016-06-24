package com.temboo.Library.OneLogin.Events;

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
CreateEvent

Creates a new event.
*/
public class CreateEvent extends Choreography {

	/**
	Create a new instance of the CreateEvent Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateEvent(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/OneLogin/Events/CreateEvent"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by OneLogin.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the EventTypeID input for this Choreo. 

	@param Integer - (required, integer) The id for the type of event you want to create. Note that depending on the event type id specified, you may need to provide the ObjectName and ObjectID that is being affected.
	*/
	public void setEventTypeID(Integer value) {
		this.inputs.setInput("EventTypeID", value);
	}

	/** 
	Set the value of the EventTypeID input for this Choreo as a String. 

	@param String - (required, integer) The id for the type of event you want to create. Note that depending on the event type id specified, you may need to provide the ObjectName and ObjectID that is being affected.
	*/
	public void setEventTypeID(String value) {
		this.inputs.setInput("EventTypeID", value);	
	}
	/** 
	Set the value of the ObjectID input for this Choreo. 

	@param Integer - (conditional, integer) The object id that is being affected. Required for certain event types. When specified, ObjectName must also be provided.
	*/
	public void setObjectID(Integer value) {
		this.inputs.setInput("ObjectID", value);
	}

	/** 
	Set the value of the ObjectID input for this Choreo as a String. 

	@param String - (conditional, integer) The object id that is being affected. Required for certain event types. When specified, ObjectName must also be provided.
	*/
	public void setObjectID(String value) {
		this.inputs.setInput("ObjectID", value);	
	}
	/** 
	Set the value of the ObjectName input for this Choreo. 

	@param String - (conditional, string) The object name that is being affected (i.e. user-id). Required for certain event types. When specified, ObjectID must also be provided.
	*/
	public void setObjectName(String value) {
		this.inputs.setInput("ObjectName", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateEventResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateEventResultSet(result);
	}
	
}
