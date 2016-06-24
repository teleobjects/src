package com.temboo.Library.Instagram;

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
SearchMedia

Allows you to search for media in a given area.
*/
public class SearchMedia extends Choreography {

	/**
	Create a new instance of the SearchMedia Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SearchMedia(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Instagram/SearchMedia"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (conditional, string) The access token retrieved during the OAuth 2.0 process. Required unless you provide the ClientID.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Instagram after registering your application. Required unless you provide the AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the Distance input for this Choreo. 

	@param Integer - (optional, integer) The distance in meters. Defaults to 1000. Max is 5000.
	*/
	public void setDistance(Integer value) {
		this.inputs.setInput("Distance", value);
	}

	/** 
	Set the value of the Distance input for this Choreo as a String. 

	@param String - (optional, integer) The distance in meters. Defaults to 1000. Max is 5000.
	*/
	public void setDistance(String value) {
		this.inputs.setInput("Distance", value);	
	}
	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (required, decimal) Latitude of the center search coordinate.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (required, decimal) Latitude of the center search coordinate.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (required, decimal) Longitude of the center search coordinate.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (required, decimal) Longitude of the center search coordinate.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the MaxTimestamp input for this Choreo. 

	@param String - (optional, date) A unix timestamp. All media returned will be taken earlier than this timestamp.
	*/
	public void setMaxTimestamp(String value) {
		this.inputs.setInput("MaxTimestamp", value);
	}


	/** 
	Set the value of the MinTimestamp input for this Choreo. 

	@param String - (optional, date) A unix timestamp. All media returned will be taken later than this timestamp.
	*/
	public void setMinTimestamp(String value) {
		this.inputs.setInput("MinTimestamp", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public SearchMediaResultSet run() {
		JSONObject result = super.runWithResults();
		return new SearchMediaResultSet(result);
	}
	
}
