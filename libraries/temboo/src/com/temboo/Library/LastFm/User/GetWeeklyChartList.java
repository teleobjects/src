package com.temboo.Library.LastFm.User;

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
GetWeeklyChartList

Retrieves a list of available charts for this user, expressed as date ranges which can be sent to the chart services.
*/
public class GetWeeklyChartList extends Choreography {

	/**
	Create a new instance of the GetWeeklyChartList Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetWeeklyChartList(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LastFm/User/GetWeeklyChartList"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (string) Your Last.fm API Key.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the User input for this Choreo. 

	@param String - (string) The last.fm username to fetch the charts of.
	*/
	public void setUser(String value) {
		this.inputs.setInput("User", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetWeeklyChartListResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetWeeklyChartListResultSet(result);
	}
	
}
