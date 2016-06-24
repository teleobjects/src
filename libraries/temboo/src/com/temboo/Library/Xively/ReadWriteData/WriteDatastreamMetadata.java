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
WriteDatastreamMetadata

Allows you to easily update the metadata of your datastream.
*/
public class WriteDatastreamMetadata extends Choreography {

	/**
	Create a new instance of the WriteDatastreamMetadata Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public WriteDatastreamMetadata(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/ReadWriteData/WriteDatastreamMetadata"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Xively.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the CurrentValue input for this Choreo. 

	@param String - (optional, string) The current value of the datastream. Leave empty to keep existing  CurrentValue. Type "BLANK" to clear existing value.
	*/
	public void setCurrentValue(String value) {
		this.inputs.setInput("CurrentValue", value);
	}


	/** 
	Set the value of the CustomDatastreamData input for this Choreo. 

	@param String - (optional, json) Custom datastream formatted as a JSON array. See documentation for how to construct your own datastream feed. If custom DatastreamData is used, all other optional inputs are ignored.
	*/
	public void setCustomDatastreamData(String value) {
		this.inputs.setInput("CustomDatastreamData", value);
	}


	/** 
	Set the value of the DatastreamID input for this Choreo. 

	@param String - (required, string) The ID of the Datastream you would like to add metadata to. Required unless you are using CustomDatastreamData.
	*/
	public void setDatastreamID(String value) {
		this.inputs.setInput("DatastreamID", value);
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
	Set the value of the MaxValue input for this Choreo. 

	@param String - (optional, string) The maximum value since the last reset. Leave empty to keep existing MaxValue. Type "BLANK" to clear existing value.
	*/
	public void setMaxValue(String value) {
		this.inputs.setInput("MaxValue", value);
	}


	/** 
	Set the value of the MinValue input for this Choreo. 

	@param String - (optional, string) The minimum value since the last reset. Leave empty to keep existing MinValue. Type "BLANK" to clear existing value.
	*/
	public void setMinValue(String value) {
		this.inputs.setInput("MinValue", value);
	}


	/** 
	Set the value of the Tags input for this Choreo. 

	@param String - (optional, string) Comma-separated list of searchable tags (the characters ', ", and commas are not allowed). Tags input overwrites previous tags, enter "BLANK" to clear all tags. Ex: "power,energy".
	*/
	public void setTags(String value) {
		this.inputs.setInput("Tags", value);
	}


	/** 
	Set the value of the UnitSymbol input for this Choreo. 

	@param String - (optional, string) The symbol of the Unit. Leave empty to keep existing UnitSymbol. Type "BLANK" to clear existing value. Ex: "C".
	*/
	public void setUnitSymbol(String value) {
		this.inputs.setInput("UnitSymbol", value);
	}


	/** 
	Set the value of the UnitType input for this Choreo. 

	@param String - (optional, string) The type of Unit. Leave empty to keep existing UnitType. Type "BLANK" to clear existing value. Ex: "basicSI".
	*/
	public void setUnitType(String value) {
		this.inputs.setInput("UnitType", value);
	}


	/** 
	Set the value of the Units input for this Choreo. 

	@param String - (optional, string) The units of the datastream. Leave empty to keep existing Units. Type "BLANK" to clear existing Units. Ex: "Celsius".
	*/
	public void setUnits(String value) {
		this.inputs.setInput("Units", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public WriteDatastreamMetadataResultSet run() {
		JSONObject result = super.runWithResults();
		return new WriteDatastreamMetadataResultSet(result);
	}
	
}
