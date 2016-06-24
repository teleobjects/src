package com.temboo.Library.Foursquare.Checkins;

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
RecentCheckins

Returns a list of recent friends' check-ins.
*/
public class RecentCheckins extends Choreography {

	/**
	Create a new instance of the RecentCheckins Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RecentCheckins(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Foursquare/Checkins/RecentCheckins"));
	}

	/** 
	Set the value of the AfterTimeStamp input for this Choreo. 

	@param Integer - (optional, integer) Seconds after which to look for check-ins, e.g. for looking for new check-ins since the last fetch.
	*/
	public void setAfterTimeStamp(Integer value) {
		this.inputs.setInput("AfterTimeStamp", value);
	}

	/** 
	Set the value of the AfterTimeStamp input for this Choreo as a String. 

	@param String - (optional, integer) Seconds after which to look for check-ins, e.g. for looking for new check-ins since the last fetch.
	*/
	public void setAfterTimeStamp(String value) {
		this.inputs.setInput("AfterTimeStamp", value);	
	}
	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) The latitude point of the user's location.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (optional, decimal) The latitude point of the user's location.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Number of results to return, up to 100.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Number of results to return, up to 100.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) The longitude point of the user's location.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (optional, decimal) The longitude point of the user's location.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the OauthToken input for this Choreo. 

	@param String - (required, string) The FourSquare API Oauth token string.
	*/
	public void setOauthToken(String value) {
		this.inputs.setInput("OauthToken", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that response should be in. Can be set to xml or json. Defaults to json.
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RecentCheckinsResultSet run() {
		JSONObject result = super.runWithResults();
		return new RecentCheckinsResultSet(result);
	}
	
}
