package com.temboo.Library.Amazon.RDS;

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
DescribeEvents

Returns events related to DB Instances, DB Security Groups, DB Snapshots and DB Parameter Groups for the past 14 days.
*/
public class DescribeEvents extends Choreography {

	/**
	Create a new instance of the DescribeEvents Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DescribeEvents(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/RDS/DescribeEvents"));
	}

	/** 
	Set the value of the AWSAccessKeyId input for this Choreo. 

	@param String - (required, string) The Access Key ID provided by Amazon Web Services.
	*/
	public void setAWSAccessKeyId(String value) {
		this.inputs.setInput("AWSAccessKeyId", value);
	}


	/** 
	Set the value of the AWSSecretKeyId input for this Choreo. 

	@param String - (required, string) The Secret Key ID provided by Amazon Web Services.
	*/
	public void setAWSSecretKeyId(String value) {
		this.inputs.setInput("AWSSecretKeyId", value);
	}


	/** 
	Set the value of the Duration input for this Choreo. 

	@param Integer - (optional, integer) The number of minutes to retrieve events for. Defaults to 60.
	*/
	public void setDuration(Integer value) {
		this.inputs.setInput("Duration", value);
	}

	/** 
	Set the value of the Duration input for this Choreo as a String. 

	@param String - (optional, integer) The number of minutes to retrieve events for. Defaults to 60.
	*/
	public void setDuration(String value) {
		this.inputs.setInput("Duration", value);	
	}
	/** 
	Set the value of the EndTime input for this Choreo. 

	@param String - (optional, date) The end of the time interval for which to retrieve events, specified in ISO 8601 format (i.e. 2009-07-08T18:00Z).
	*/
	public void setEndTime(String value) {
		this.inputs.setInput("EndTime", value);
	}


	/** 
	Set the value of the Marker input for this Choreo. 

	@param Integer - (optional, integer) If this parameter is specified, the response includes only records beyond the marker, up to the value specified by MaxRecords.
	*/
	public void setMarker(Integer value) {
		this.inputs.setInput("Marker", value);
	}

	/** 
	Set the value of the Marker input for this Choreo as a String. 

	@param String - (optional, integer) If this parameter is specified, the response includes only records beyond the marker, up to the value specified by MaxRecords.
	*/
	public void setMarker(String value) {
		this.inputs.setInput("Marker", value);	
	}
	/** 
	Set the value of the MaxRecords input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of records to include in the response. If more records exist, a marker is included in the response so that the remaining results may be retrieved. Defaults to max (100). Min is 20.
	*/
	public void setMaxRecords(Integer value) {
		this.inputs.setInput("MaxRecords", value);
	}

	/** 
	Set the value of the MaxRecords input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of records to include in the response. If more records exist, a marker is included in the response so that the remaining results may be retrieved. Defaults to max (100). Min is 20.
	*/
	public void setMaxRecords(String value) {
		this.inputs.setInput("MaxRecords", value);	
	}
	/** 
	Set the value of the SourceIdentifier input for this Choreo. 

	@param String - (optional, string) The identifier of the event source for which events will be returned. If not specified, then all sources are included in the response.
	*/
	public void setSourceIdentifier(String value) {
		this.inputs.setInput("SourceIdentifier", value);
	}


	/** 
	Set the value of the SourceType input for this Choreo. 

	@param String - (optional, string) The event source to retrieve events for. If no value is specified, all events are returned. Valid values are: db-instance | db-parameter-group | db-security-group | db-snapshot.
	*/
	public void setSourceType(String value) {
		this.inputs.setInput("SourceType", value);
	}


	/** 
	Set the value of the StartTime input for this Choreo. 

	@param String - (optional, date) The beginning of the time interval to retrieve events for, specified in ISO 8601 format (i.e. 2009-07-08T18:00Z)
	*/
	public void setStartTime(String value) {
		this.inputs.setInput("StartTime", value);
	}


	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (optional, string) The AWS region that corresponds to the RDS endpoint you wish to access. The default region is "us-east-1". See description below for valid values.
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DescribeEventsResultSet run() {
		JSONObject result = super.runWithResults();
		return new DescribeEventsResultSet(result);
	}
	
}
