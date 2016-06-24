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
DeleteMultipleDatapoints

Deletes multiple datapoints from a single datastream given a start date, end date, and/or duration.
*/
public class DeleteMultipleDatapoints extends Choreography {

	/**
	Create a new instance of the DeleteMultipleDatapoints Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DeleteMultipleDatapoints(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/ReadWriteData/DeleteMultipleDatapoints"));
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

	@param String - (required, string) The ID of the datastream you would like to delete datapoints from.
	*/
	public void setDatastreamID(String value) {
		this.inputs.setInput("DatastreamID", value);
	}


	/** 
	Set the value of the Duration input for this Choreo. 

	@param String - (conditional, string) Specifies the duration of the deletion. Can be used with StartDate or EndDate. Ex: 5seconds, 10minutes, 6hours. See documentation for full description / examples.
	*/
	public void setDuration(String value) {
		this.inputs.setInput("Duration", value);
	}


	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (conditional, date) Defines the end point of the deletion as a timestamp. Can be used with Duration. Ex: 2013-05-10T12:00:00Z.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the FeedID input for this Choreo. 

	@param String - (required, string) The ID of the feed you would like to delete datapoints from.
	*/
	public void setFeedID(String value) {
		this.inputs.setInput("FeedID", value);
	}


	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (conditional, date) Defines the starting point of the deletion as a timestamp. Can be used with Duration. Ex: 2013-05-10T00:00:00Z.
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DeleteMultipleDatapointsResultSet run() {
		JSONObject result = super.runWithResults();
		return new DeleteMultipleDatapointsResultSet(result);
	}
	
}
