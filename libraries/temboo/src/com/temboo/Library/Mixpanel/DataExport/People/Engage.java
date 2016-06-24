package com.temboo.Library.Mixpanel.DataExport.People;

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
Engage

Queries Mixpanel for data about people.
*/
public class Engage extends Choreography {

	/**
	Create a new instance of the Engage Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Engage(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Mixpanel/DataExport/People/Engage"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided my Mixpanel. You can find your Mixpanel API Key in the project settings dialog in the Mixpanel app.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the APISecret input for this Choreo. 

	@param String - (required, string) The API Secret provided by Mixpanel. You can find your Mixpanel API Secret in the project settings dialog in the Mixpanel app.
	*/
	public void setAPISecret(String value) {
		this.inputs.setInput("APISecret", value);
	}


	/** 
	Set the value of the Expire input for this Choreo. 

	@param Integer - (optional, integer) The amount of minutes past NOW() before the request will expire. Defaults to 1.
	*/
	public void setExpire(Integer value) {
		this.inputs.setInput("Expire", value);
	}

	/** 
	Set the value of the Expire input for this Choreo as a String. 

	@param String - (optional, integer) The amount of minutes past NOW() before the request will expire. Defaults to 1.
	*/
	public void setExpire(String value) {
		this.inputs.setInput("Expire", value);	
	}
	/** 
	Set the value of the Page input for this Choreo. 

	@param Integer - (optional, integer) Which page of the results to retrieve. Pages start at zero. If the "page" parameter is provided, the session_id parameter must also be provided.
	*/
	public void setPage(Integer value) {
		this.inputs.setInput("Page", value);
	}

	/** 
	Set the value of the Page input for this Choreo as a String. 

	@param String - (optional, integer) Which page of the results to retrieve. Pages start at zero. If the "page" parameter is provided, the session_id parameter must also be provided.
	*/
	public void setPage(String value) {
		this.inputs.setInput("Page", value);	
	}
	/** 
	Set the value of the SessionID input for this Choreo. 

	@param String - (optional, string) A string id provided in the results of a previous query. Using a session_id speeds up api response, and allows paging through results.
	*/
	public void setSessionID(String value) {
		this.inputs.setInput("SessionID", value);
	}


	/** 
	Set the value of the Where input for this Choreo. 

	@param String - (optional, string) An expression to filter people by (e.g., properties["time"]). See Choreo description for examples.
	*/
	public void setWhere(String value) {
		this.inputs.setInput("Where", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public EngageResultSet run() {
		JSONObject result = super.runWithResults();
		return new EngageResultSet(result);
	}
	
}
