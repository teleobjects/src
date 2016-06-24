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
DescribeImages

Queries the Amazon EC2 API to return information about Amazon Machine Image(s) that are available to you.
*/
public class DescribeImages extends Choreography {

	/**
	Create a new instance of the DescribeImages Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DescribeImages(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/EC2/DescribeImages"));
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
	Set the value of the ExecutableBy input for this Choreo. 

	@param String - (optional, string) The user ID that has explicit launch permissions. The user ID can be an AWS account ID, "self", or "all" to return AMIs with public launch permissions.
	*/
	public void setExecutableBy(String value) {
		this.inputs.setInput("ExecutableBy", value);
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
	Set the value of the ImageId input for this Choreo. 

	@param String - (conditional, string) The ID of the AMI that you want to return. Returns all AMIs when this parameter is not specified.
	*/
	public void setImageId(String value) {
		this.inputs.setInput("ImageId", value);
	}


	/** 
	Set the value of the Owner input for this Choreo. 

	@param String - (conditional, string) The IDs "amazon", "aws-marketplace", and "self" can be used to include AMIs owned by Amazon, AWS Marketplace, or AMIs owned by you, respectively.
	*/
	public void setOwner(String value) {
		this.inputs.setInput("Owner", value);
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
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DescribeImagesResultSet run() {
		JSONObject result = super.runWithResults();
		return new DescribeImagesResultSet(result);
	}
	
}