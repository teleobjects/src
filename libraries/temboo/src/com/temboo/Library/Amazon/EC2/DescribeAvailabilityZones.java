package com.temboo.Library.Amazon.EC2;

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
DescribeAvailabilityZones

Queries the Amazon EC2 API to return Availability Zones that are available for your EC2 account.
*/
public class DescribeAvailabilityZones extends Choreography {

	/**
	Create a new instance of the DescribeAvailabilityZones Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DescribeAvailabilityZones(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/EC2/DescribeAvailabilityZones"));
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
	Set the value of the FilterName input for this Choreo. 

	@param String - (optional, string) The name of a supported filter to narrow results with.
	*/
	public void setFilterName(String value) {
		this.inputs.setInput("FilterName", value);
	}


	/** 
	Set the value of the FilterValue input for this Choreo. 

	@param String - (optional, string) A value for the specified filter.
	*/
	public void setFilterValue(String value) {
		this.inputs.setInput("FilterValue", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (optional, string) The AWS region that corresponds to the EC2 endpoint you wish to access. The default region is "us-east-1". See description below for valid values.
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	/** 
	Set the value of the ZoneName input for this Choreo. 

	@param String - (optional, string) One or more Availability Zones.  This can be a comma-separated list of up to 10 instance Zones.
	*/
	public void setZoneName(String value) {
		this.inputs.setInput("ZoneName", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DescribeAvailabilityZonesResultSet run() {
		JSONObject result = super.runWithResults();
		return new DescribeAvailabilityZonesResultSet(result);
	}
	
}
