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
GetWeeklyAlbumChart

Retrieves an album chart for a user profile, for a given date range.
*/
public class GetWeeklyAlbumChart extends Choreography {

	/**
	Create a new instance of the GetWeeklyAlbumChart Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetWeeklyAlbumChart(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/LastFm/User/GetWeeklyAlbumChart"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (string) Your Last.fm API Key.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the EndTimestamp input for this Choreo. 

	@param String - (optional, date) End timestamp at which the chart should end on, in UNIX timestamp format. This must be in the UTC time zone.
	*/
	public void setEndTimestamp(String value) {
		this.inputs.setInput("EndTimestamp", value);
	}


	/** 
	Set the value of the StartTimestamp input for this Choreo. 

	@param String - (optional, date) Beginning timestamp at which the chart should start from, in UNIX timestamp format. This must be in the UTC time zone.
	*/
	public void setStartTimestamp(String value) {
		this.inputs.setInput("StartTimestamp", value);
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
	public GetWeeklyAlbumChartResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetWeeklyAlbumChartResultSet(result);
	}
	
}
