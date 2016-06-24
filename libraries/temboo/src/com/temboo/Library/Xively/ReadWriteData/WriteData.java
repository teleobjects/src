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
WriteData

Allows you to update your feed, including updating/creating new datastreams and datapoints. 
*/
public class WriteData extends Choreography {

	/**
	Create a new instance of the WriteData Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public WriteData(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/ReadWriteData/WriteData"));
	}

	/** 
	Set the value of the FeedData input for this Choreo. 

	@param String - (optional, any) Custom data body for the new feed in JSON or XML format (set by FeedType).  See Xively documentation (link below) for the minimum required fields. If FeedData is used, Value and Timestamp are ignored.
	*/
	public void setFeedData(String value) {
		this.inputs.setInput("FeedData", value);
	}


	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Xively.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the DatastreamID input for this Choreo. 

	@param String - (optional, string) ID for single datastream you would like to update. Required if specifying a single datapoint update using Value.
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
	Set the value of the FeedType input for this Choreo. 

	@param String - (optional, string) The type of feed that is being provided for custom FeedData. Valid values are "json" (the default), "xml" and "csv". Ignored if specifying single datapoint Value.
	*/
	public void setFeedType(String value) {
		this.inputs.setInput("FeedType", value);
	}


	/** 
	Set the value of the Timestamp input for this Choreo. 

	@param String - (optional, date) Can be used with a single Value and DatastreamID. If specified, sets timestamp for Value. If Value is set with blank Timestamp, Value's timestamp will be current time. Ex: 2013-05-10T00:00:00.123456Z.
	*/
	public void setTimestamp(String value) {
		this.inputs.setInput("Timestamp", value);
	}


	/** 
	Set the value of the Value input for this Choreo. 

	@param String - (optional, string) Specifies the value for a single datapoint in a specified datastream.
	*/
	public void setValue(String value) {
		this.inputs.setInput("Value", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public WriteDataResultSet run() {
		JSONObject result = super.runWithResults();
		return new WriteDataResultSet(result);
	}
	
}
