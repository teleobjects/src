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
ReadFeed

Returns filterable data on a specific feed viewable by the authenticated account.
*/
public class ReadFeed extends Choreography {

	/**
	Create a new instance of the ReadFeed Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ReadFeed(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/ReadWriteData/ReadFeed"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Xively.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Datastreams input for this Choreo. 

	@param String - (optional, string) Filter by datastream. Valid values - comma separated datastream IDs (Ex: energy,power).
	*/
	public void setDatastreams(String value) {
		this.inputs.setInput("Datastreams", value);
	}


	/** 
	Set the value of the Duration input for this Choreo. 

	@param String - (optional, string) Used for a historical query. If used with EndDate will request data prior to EndDate, if used with StartDate will request data after StartDate. By itself will give most recent data. Ex: 6hours, 2days.
	*/
	public void setDuration(String value) {
		this.inputs.setInput("Duration", value);
	}


	/** 
	Set the value of the EndDate input for this Choreo. 

	@param String - (optional, date) Used for a historical query. Defines the end point of the data returned as a timestamp. Ex: 2013-05-10T12:00:00Z.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the FeedID input for this Choreo. 

	@param Integer - (required, integer) The ID of the feed you wish to view.
	*/
	public void setFeedID(Integer value) {
		this.inputs.setInput("FeedID", value);
	}

	/** 
	Set the value of the FeedID input for this Choreo as a String. 

	@param String - (required, integer) The ID of the feed you wish to view.
	*/
	public void setFeedID(String value) {
		this.inputs.setInput("FeedID", value);	
	}
	/** 
	Set the value of the FeedType input for this Choreo. 

	@param String - (optional, string) The type of feed that is being returned. Valid values are "json" (the default), "csv" and "xml". No metadata is returned for the csv feed.
	*/
	public void setFeedType(String value) {
		this.inputs.setInput("FeedType", value);
	}


	/** 
	Set the value of the FindPrevious input for this Choreo. 

	@param Boolean - (optional, boolean) Used for a historical query. Will also return the previous value to the date range being requested. Useful when graphing, to start a graph with a datapoint. Valid values: "true", blank (default).
	*/
	public void setFindPrevious(Boolean value) {
		this.inputs.setInput("FindPrevious", value);
	}

	/** 
	Set the value of the FindPrevious input for this Choreo as a String. 

	@param String - (optional, boolean) Used for a historical query. Will also return the previous value to the date range being requested. Useful when graphing, to start a graph with a datapoint. Valid values: "true", blank (default).
	*/
	public void setFindPrevious(String value) {
		this.inputs.setInput("FindPrevious", value);	
	}
	/** 
	Set the value of the Interval input for this Choreo. 

	@param Integer - (optional, integer) Used for a historical query. Determines what interval of data is requested and is defined in seconds between the datapoints. See documentation for full list of possible values. Ex.: 0, 30, 60, etc.
	*/
	public void setInterval(Integer value) {
		this.inputs.setInput("Interval", value);
	}

	/** 
	Set the value of the Interval input for this Choreo as a String. 

	@param String - (optional, integer) Used for a historical query. Determines what interval of data is requested and is defined in seconds between the datapoints. See documentation for full list of possible values. Ex.: 0, 30, 60, etc.
	*/
	public void setInterval(String value) {
		this.inputs.setInput("Interval", value);	
	}
	/** 
	Set the value of the IntervalType input for this Choreo. 

	@param String - (optional, string) Used for a historical query. If set to "discrete" the data will be returned in fixed time interval format according to Interval value. If not set, the raw datapoints will be returned.
	*/
	public void setIntervalType(String value) {
		this.inputs.setInput("IntervalType", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Used for a historical query. Limits the number of results to the number specified here. Defaults to 100, has a maximum of 1000.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Used for a historical query. Limits the number of results to the number specified here. Defaults to 100, has a maximum of 1000.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the ShowUser input for this Choreo. 

	@param String - (optional, string) Include user login for each feed. For JSON/XML response only. Valid values: "true", "false" (default).
	*/
	public void setShowUser(String value) {
		this.inputs.setInput("ShowUser", value);
	}


	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (optional, date) Used for a historical query. Defines the starting point of the query as a timestamp. Ex: 2013-05-10T00:00:00Z.
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ReadFeedResultSet run() {
		JSONObject result = super.runWithResults();
		return new ReadFeedResultSet(result);
	}
	
}
