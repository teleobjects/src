package com.temboo.Library.Xively.ReadWriteData;

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
WriteLocationData

Allows you to easily update the location data of your feed.
*/
public class WriteLocationData extends Choreography {

	/**
	Create a new instance of the WriteLocationData Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public WriteLocationData(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/ReadWriteData/WriteLocationData"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Xively.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Disposition input for this Choreo. 

	@param String - (optional, string) Can be set to "mobile" to enable creating waypoints (lat, lon and elevation with timestamp), or "fixed" (default) for a single location. Leave empty to keep existing settings.
	*/
	public void setDisposition(String value) {
		this.inputs.setInput("Disposition", value);
	}


	/** 
	Set the value of the Domain input for this Choreo. 

	@param String - (optional, string) The domain of the location, i.e. physical or virtual. Leave empty to keep existing Domain. Type "BLANK" to clear existing Domain. Ex: "physical".
	*/
	public void setDomain(String value) {
		this.inputs.setInput("Domain", value);
	}


	/** 
	Set the value of the Elevation input for this Choreo. 

	@param BigDecimal - (optional, decimal) Elevation in meters. Leave empty to keep previously existing Elevation. Type "BLANK" to clear existing Elevation. Ex: 20.5.
	*/
	public void setElevation(BigDecimal value) {
		this.inputs.setInput("Elevation", value);
	}

	/** 
	Set the value of the Elevation input for this Choreo as a String. 

	@param String - (optional, decimal) Elevation in meters. Leave empty to keep previously existing Elevation. Type "BLANK" to clear existing Elevation. Ex: 20.5.
	*/
	public void setElevation(String value) {
		this.inputs.setInput("Elevation", value);	
	}
	/** 
	Set the value of the FeedID input for this Choreo. 

	@param Integer - (required, integer) The ID for the feed that you would like to update.
	*/
	public void setFeedID(Integer value) {
		this.inputs.setInput("FeedID", value);
	}

	/** 
	Set the value of the FeedID input for this Choreo as a String. 

	@param String - (required, integer) The ID for the feed that you would like to update.
	*/
	public void setFeedID(String value) {
		this.inputs.setInput("FeedID", value);	
	}
	/** 
	Set the value of the Latitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) Latitude coordinates. Leave empty to keep previously existing Latitude. Type "BLANK" to clear existing Latitude. Ex: 40.728194.
	*/
	public void setLatitude(BigDecimal value) {
		this.inputs.setInput("Latitude", value);
	}

	/** 
	Set the value of the Latitude input for this Choreo as a String. 

	@param String - (optional, decimal) Latitude coordinates. Leave empty to keep previously existing Latitude. Type "BLANK" to clear existing Latitude. Ex: 40.728194.
	*/
	public void setLatitude(String value) {
		this.inputs.setInput("Latitude", value);	
	}
	/** 
	Set the value of the Longitude input for this Choreo. 

	@param BigDecimal - (optional, decimal) Longitude coordinates. Leave empty to keep previously existing Location. Type "BLANK" to clear existing settings. Ex: -73.957316.
	*/
	public void setLongitude(BigDecimal value) {
		this.inputs.setInput("Longitude", value);
	}

	/** 
	Set the value of the Longitude input for this Choreo as a String. 

	@param String - (optional, decimal) Longitude coordinates. Leave empty to keep previously existing Location. Type "BLANK" to clear existing settings. Ex: -73.957316.
	*/
	public void setLongitude(String value) {
		this.inputs.setInput("Longitude", value);	
	}
	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (optional, string) Name of Location. Leave empty to keep existing Location. Type "BLANK" to clear existing settings. Ex.: "My Fitbit Tracker".
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public WriteLocationDataResultSet run() {
		JSONObject result = super.runWithResults();
		return new WriteLocationDataResultSet(result);
	}
	
}
