package com.temboo.Library.Parse.Users;

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
Query

Retrieves multiple users at once and allows you to specify query constraints.
*/
public class Query extends Choreography {

	/**
	Create a new instance of the Query Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Query(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Parse/Users/Query"));
	}

	/** 
	Set the value of the ApplicationID input for this Choreo. 

	@param String - (required, string) The Application ID provided by Parse.
	*/
	public void setApplicationID(String value) {
		this.inputs.setInput("ApplicationID", value);
	}


	/** 
	Set the value of the Count input for this Choreo. 

	@param Boolean - (optional, boolean) A flag indicating to include a count of users in the response. Set to 1 to include a count. Defaults to 0.
	*/
	public void setCount(Boolean value) {
		this.inputs.setInput("Count", value);
	}

	/** 
	Set the value of the Count input for this Choreo as a String. 

	@param String - (optional, boolean) A flag indicating to include a count of users in the response. Set to 1 to include a count. Defaults to 0.
	*/
	public void setCount(String value) {
		this.inputs.setInput("Count", value);	
	}
	/** 
	Set the value of the Include input for this Choreo. 

	@param String - (optional, string) Specify a field to return multiple types of related objects in this query.  For example, enter: post.author, to retrieve posts and their authors related to this class.
	*/
	public void setInclude(String value) {
		this.inputs.setInput("Include", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The number of users to return.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The number of users to return.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the RESTAPIKey input for this Choreo. 

	@param String - (required, string) The REST API Key provided by Parse.
	*/
	public void setRESTAPIKey(String value) {
		this.inputs.setInput("RESTAPIKey", value);
	}


	/** 
	Set the value of the Where input for this Choreo. 

	@param String - (optional, json) A valid query constraint formatted as a JSON-encoded string. See documentation for syntax rules.
	*/
	public void setWhere(String value) {
		this.inputs.setInput("Where", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public QueryResultSet run() {
		JSONObject result = super.runWithResults();
		return new QueryResultSet(result);
	}
	
}
