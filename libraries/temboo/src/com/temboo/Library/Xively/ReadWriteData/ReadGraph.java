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
ReadGraph

Returns a customizable graph (Base64-encoded PNG image file) of datapoints from a specific datastream.
*/
public class ReadGraph extends Choreography {

	/**
	Create a new instance of the ReadGraph Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ReadGraph(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Xively/ReadWriteData/ReadGraph"));
	}

	/** 
	Set the value of the APIKey input for this Choreo. 

	@param String - (required, string) The API Key provided by Xively.
	*/
	public void setAPIKey(String value) {
		this.inputs.setInput("APIKey", value);
	}


	/** 
	Set the value of the Color input for this Choreo. 

	@param String - (optional, string) The PNG color in hex. Ex: FFCC33.
	*/
	public void setColor(String value) {
		this.inputs.setInput("Color", value);
	}


	/** 
	Set the value of the DatastreamID input for this Choreo. 

	@param String - (required, string) The ID for the datastream you wish to read.
	*/
	public void setDatastreamID(String value) {
		this.inputs.setInput("DatastreamID", value);
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

	@param String - (optional, date) Used for a historical query. Defines the end point of the data returned as a timestamp. Ex: 2013-05-10T12:00:00Z. Default value is set to current timestamp.
	*/
	public void setEndDate(String value) {
		this.inputs.setInput("EndDate", value);
	}


	/** 
	Set the value of the FeedID input for this Choreo. 

	@param Integer - (required, integer) The ID of the feed you wish to read.
	*/
	public void setFeedID(Integer value) {
		this.inputs.setInput("FeedID", value);
	}

	/** 
	Set the value of the FeedID input for this Choreo as a String. 

	@param String - (required, integer) The ID of the feed you wish to read.
	*/
	public void setFeedID(String value) {
		this.inputs.setInput("FeedID", value);	
	}
	/** 
	Set the value of the FindPrevious input for this Choreo. 

	@param Boolean - (optional, boolean) Used for a historical query. Will also return the previous value to the date range being requested. Useful to allow a graph to start a graph with some datapoint. Valid values: "true", blank (default).
	*/
	public void setFindPrevious(Boolean value) {
		this.inputs.setInput("FindPrevious", value);
	}

	/** 
	Set the value of the FindPrevious input for this Choreo as a String. 

	@param String - (optional, boolean) Used for a historical query. Will also return the previous value to the date range being requested. Useful to allow a graph to start a graph with some datapoint. Valid values: "true", blank (default).
	*/
	public void setFindPrevious(String value) {
		this.inputs.setInput("FindPrevious", value);	
	}
	/** 
	Set the value of the Height input for this Choreo. 

	@param Integer - (optional, integer) The PNG height in pixels. Max height: 500. Ex: 400.
	*/
	public void setHeight(Integer value) {
		this.inputs.setInput("Height", value);
	}

	/** 
	Set the value of the Height input for this Choreo as a String. 

	@param String - (optional, integer) The PNG height in pixels. Max height: 500. Ex: 400.
	*/
	public void setHeight(String value) {
		this.inputs.setInput("Height", value);	
	}
	/** 
	Set the value of the Interval input for this Choreo. 

	@param Integer - (optional, integer) Used for a historical query. Determines what interval of data is requested and is defined in seconds between the datapoints. See documentation for full list of possible values. Ex: 0, 30, 60, etc.
	*/
	public void setInterval(Integer value) {
		this.inputs.setInput("Interval", value);
	}

	/** 
	Set the value of the Interval input for this Choreo as a String. 

	@param String - (optional, integer) Used for a historical query. Determines what interval of data is requested and is defined in seconds between the datapoints. See documentation for full list of possible values. Ex: 0, 30, 60, etc.
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
	Set the value of the Legend input for this Choreo. 

	@param String - (optional, string) Label given datapoints on a legend included on the graph.
	*/
	public void setLegend(String value) {
		this.inputs.setInput("Legend", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) Used for a historical query. LImits the number of results to the number specified here. Defaults to 100, has a maximum of 1000.
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) Used for a historical query. LImits the number of results to the number specified here. Defaults to 100, has a maximum of 1000.
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
	}
	/** 
	Set the value of the LineSize input for this Choreo. 

	@param Integer - (optional, integer) Size of the lines/strokes in pixels. Ex: 4.
	*/
	public void setLineSize(Integer value) {
		this.inputs.setInput("LineSize", value);
	}

	/** 
	Set the value of the LineSize input for this Choreo as a String. 

	@param String - (optional, integer) Size of the lines/strokes in pixels. Ex: 4.
	*/
	public void setLineSize(String value) {
		this.inputs.setInput("LineSize", value);	
	}
	/** 
	Set the value of the ShowAxisLabels input for this Choreo. 

	@param Boolean - (optional, boolean) Show access labels. Input "true" to turn on, leave blank to keep off (default).
	*/
	public void setShowAxisLabels(Boolean value) {
		this.inputs.setInput("ShowAxisLabels", value);
	}

	/** 
	Set the value of the ShowAxisLabels input for this Choreo as a String. 

	@param String - (optional, boolean) Show access labels. Input "true" to turn on, leave blank to keep off (default).
	*/
	public void setShowAxisLabels(String value) {
		this.inputs.setInput("ShowAxisLabels", value);	
	}
	/** 
	Set the value of the ShowDetailedGrid input for this Choreo. 

	@param String - (optional, string) Show detailed grid. Input "true" to turn on, leave blank to keep off (default).
	*/
	public void setShowDetailedGrid(String value) {
		this.inputs.setInput("ShowDetailedGrid", value);
	}


	/** 
	Set the value of the StartDate input for this Choreo. 

	@param String - (optional, date) Used for a historical query. Defines the starting the point of the query as a timestamp. Ex: 2013-05-10T00:00:00Z.
	*/
	public void setStartDate(String value) {
		this.inputs.setInput("StartDate", value);
	}


	/** 
	Set the value of the Timezone input for this Choreo. 

	@param String - (optional, string) Timezone of the graph. For a list of valid values please see description and API documenation. Ex: Eastern Time (US & Canada), Pacific Time (US & Canada), UTC, Tokyo.
	*/
	public void setTimezone(String value) {
		this.inputs.setInput("Timezone", value);
	}


	/** 
	Set the value of the Title input for this Choreo. 

	@param String - (optional, string) Title of the graph.
	*/
	public void setTitle(String value) {
		this.inputs.setInput("Title", value);
	}


	/** 
	Set the value of the Width input for this Choreo. 

	@param Integer - (optional, integer) The PNG width in pixels. Max width: 600. Ex: 600.
	*/
	public void setWidth(Integer value) {
		this.inputs.setInput("Width", value);
	}

	/** 
	Set the value of the Width input for this Choreo as a String. 

	@param String - (optional, integer) The PNG width in pixels. Max width: 600. Ex: 600.
	*/
	public void setWidth(String value) {
		this.inputs.setInput("Width", value);	
	}
	/** 
	Set the value of the YAxisMax input for this Choreo. 

	@param String - (optional, string) Y-axis maximum value if the YAxisScale is set to "manual".
	*/
	public void setYAxisMax(String value) {
		this.inputs.setInput("YAxisMax", value);
	}


	/** 
	Set the value of the YAxisMin input for this Choreo. 

	@param String - (optional, string) Y-axis minimum value if the YAxisScale is set to "manual".
	*/
	public void setYAxisMin(String value) {
		this.inputs.setInput("YAxisMin", value);
	}


	/** 
	Set the value of the YAxisScale input for this Choreo. 

	@param String - (optional, string) Method used to determine the y-axis scale. Valid values: "auto" (default), "datastream", or "manual".
	*/
	public void setYAxisScale(String value) {
		this.inputs.setInput("YAxisScale", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ReadGraphResultSet run() {
		JSONObject result = super.runWithResults();
		return new ReadGraphResultSet(result);
	}
	
}
