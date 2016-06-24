package com.temboo.Library.Withings.Measure;

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
GetBodyMetrics

Retrieves body metrics for the specified user.
*/
public class GetBodyMetrics extends Choreography {

	/**
	Create a new instance of the GetBodyMetrics Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetBodyMetrics(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Withings/Measure/GetBodyMetrics"));
	}

	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (required, string) The Access Token retrieved during the OAuth process.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the AccessTokenSecret input for this Choreo. 

	@param String - (required, string) The Access Token Secret retrieved during the OAuth process.
	*/
	public void setAccessTokenSecret(String value) {
		this.inputs.setInput("AccessTokenSecret", value);
	}


	/** 
	Set the value of the Category input for this Choreo. 

	@param Integer - (optional, integer) Set to 2 to retrieve objectives or to 1 to retrieve actual measurements.
	*/
	public void setCategory(Integer value) {
		this.inputs.setInput("Category", value);
	}

	/** 
	Set the value of the Category input for this Choreo as a String. 

	@param String - (optional, integer) Set to 2 to retrieve objectives or to 1 to retrieve actual measurements.
	*/
	public void setCategory(String value) {
		this.inputs.setInput("Category", value);	
	}
	/** 
	Set the value of the ConsumerKey input for this Choreo. 

	@param String - (required, string) The Consumer Key provided by Withings.
	*/
	public void setConsumerKey(String value) {
		this.inputs.setInput("ConsumerKey", value);
	}


	/** 
	Set the value of the ConsumerSecret input for this Choreo. 

	@param String - (required, string) The Consumer Secret provided by Withings.
	*/
	public void setConsumerSecret(String value) {
		this.inputs.setInput("ConsumerSecret", value);
	}


	/** 
	Set the value of the DeviceType input for this Choreo. 

	@param Integer - (optional, integer) Retrieves data for a particular device type. Specifying 1 will retrieve all body scale related measures and 0 will retrieve all user personal data entered at user creation time.
	*/
	public void setDeviceType(Integer value) {
		this.inputs.setInput("DeviceType", value);
	}

	/** 
	Set the value of the DeviceType input for this Choreo as a String. 

	@param String - (optional, integer) Retrieves data for a particular device type. Specifying 1 will retrieve all body scale related measures and 0 will retrieve all user personal data entered at user creation time.
	*/
	public void setDeviceType(String value) {
		this.inputs.setInput("DeviceType", value);	
	}
	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (optional, date) Retrieves results dated before the specified EPOCH formatted date.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the LastUpdated input for this Choreo. 

	@param String - (optional, date) Retrieves results added or modified since the specified EPOCH formatted date.
	*/
	public void setLastUpdated(String value) {
		this.inputs.setInput("LastUpdated", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Limits the number of measure groups returned in the result.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Limits the number of measure groups returned in the result.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the MeasurementType input for this Choreo. 

	@param Integer - (optional, integer) Filters by the measurement type. Set to 1 to filter by weight or 4 to filter by height.
	*/
	public void setMeasurementType(Integer value) {
		this.inputs.setInput("MeasurementType", value);
	}

	/** 
	Set the value of the MeasurementType input for this Choreo as a String. 

	@param String - (optional, integer) Filters by the measurement type. Set to 1 to filter by weight or 4 to filter by height.
	*/
	public void setMeasurementType(String value) {
		this.inputs.setInput("MeasurementType", value);	
	}
	/** 
	Set the value of the Offset input for this Choreo. 

	@param Integer - (optional, integer) Used in combination with the Limit parameter to page through results.
	*/
	public void setOffset(Integer value) {
		this.inputs.setInput("Offset", value);
	}

	/** 
	Set the value of the Offset input for this Choreo as a String. 

	@param String - (optional, integer) Used in combination with the Limit parameter to page through results.
	*/
	public void setOffset(String value) {
		this.inputs.setInput("Offset", value);	
	}
	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (optional, date) Retrieves results dated after the specified EPOCH formatted date.
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	/** 
	Set the value of the UserID input for this Choreo. 

	@param String - (required, string) The ID of the user to retrieve body metrics for.
	*/
	public void setUserID(String value) {
		this.inputs.setInput("UserID", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetBodyMetricsResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetBodyMetricsResultSet(result);
	}
	
}
