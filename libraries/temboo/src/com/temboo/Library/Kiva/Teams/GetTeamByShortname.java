package com.temboo.Library.Kiva.Teams;

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
GetTeamByShortname

Returns detailed information about one or more teams, using team shortnames.
*/
public class GetTeamByShortname extends Choreography {

	/**
	Create a new instance of the GetTeamByShortname Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetTeamByShortname(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Kiva/Teams/GetTeamByShortname"));
	}

	/** 
	Set the value of the AppID input for this Choreo. 

	@param String - (optional, string) Your unique application ID, usually in reverse DNS notation.
	*/
	public void setAppID(String value) {
		this.inputs.setInput("AppID", value);
	}


	/** 
	Set the value of the ResponseType input for this Choreo. 

	@param String - (optional, string) Output returned can be XML or JSON. Defaults to JSON.
	*/
	public void setResponseType(String value) {
		this.inputs.setInput("ResponseType", value);
	}


	/** 
	Set the value of the TeamShortname input for this Choreo. 

	@param String - (required, string) The Team shortname for which to return details.
	*/
	public void setTeamShortname(String value) {
		this.inputs.setInput("TeamShortname", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetTeamByShortnameResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetTeamByShortnameResultSet(result);
	}
	
}
