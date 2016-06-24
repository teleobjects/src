package com.temboo.Library.Amazon.S3;

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
PutBucketLifecycle

Sets lifecycle configuration for your bucket. This is used to remove objects from a bucket automatically after a certain time or at a certain date.
*/
public class PutBucketLifecycle extends Choreography {

	/**
	Create a new instance of the PutBucketLifecycle Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PutBucketLifecycle(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/S3/PutBucketLifecycle"));
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
	Set the value of the BucketName input for this Choreo. 

	@param String - (required, string) The name of the bucket to create or update a policy for.
	*/
	public void setBucketName(String value) {
		this.inputs.setInput("BucketName", value);
	}


	/** 
	Set the value of the CustomLifecycleConfiguration input for this Choreo. 

	@param String - (optional, xml) Write a custom LifecycleConfiguration xml request for advanced customization. Note - this will overwrite all other inputs other than the AWS AccessKeyId, SecretKeyId, and BucketName.
	*/
	public void setCustomLifecycleConfiguration(String value) {
		this.inputs.setInput("CustomLifecycleConfiguration", value);
	}


	/** 
	Set the value of the DateOfExpiration input for this Choreo. 

	@param String - (optional, date) Date when the rule takes effect. You can specify either DateOfExpiration OR NumberOfDays. The date value must be in ISO 8601 format, time is always midnight UTC. Ex: 2013-04-24T00:00:00.000Z.
	*/
	public void setDateOfExpiration(String value) {
		this.inputs.setInput("DateOfExpiration", value);
	}


	/** 
	Set the value of the LifecycleId input for this Choreo. 

	@param String - (optional, string) A unique ID for this lifecycle (i.e. delete-logs-in-30-days-rule).
	*/
	public void setLifecycleId(String value) {
		this.inputs.setInput("LifecycleId", value);
	}


	/** 
	Set the value of the NumberOfDays input for this Choreo. 

	@param Integer - (conditional, integer) The number of days to wait until the lifecycle expiration kicks in. Required unless you specify DateOfExpiration or a CustomLifecycleConfiguration instead.
	*/
	public void setNumberOfDays(Integer value) {
		this.inputs.setInput("NumberOfDays", value);
	}

	/** 
	Set the value of the NumberOfDays input for this Choreo as a String. 

	@param String - (conditional, integer) The number of days to wait until the lifecycle expiration kicks in. Required unless you specify DateOfExpiration or a CustomLifecycleConfiguration instead.
	*/
	public void setNumberOfDays(String value) {
		this.inputs.setInput("NumberOfDays", value);	
	}
	/** 
	Set the value of the Prefix input for this Choreo. 

	@param String - (optional, string) Indicating that objects with this prefix will expire and be removed after the number of days specified. If not specified this lifecycle will apply to all objects in the bucket.
	*/
	public void setPrefix(String value) {
		this.inputs.setInput("Prefix", value);
	}


	/** 
	Set the value of the Status input for this Choreo. 

	@param String - (optional, string) The lifecycle status. Accepted values are: "Enabled" or "Disabled". Defaults to "Enabled".
	*/
	public void setStatus(String value) {
		this.inputs.setInput("Status", value);
	}


	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (required, string) The AWS region that corresponds to the S3 endpoint you wish to access. The default region is "us-east-1".
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PutBucketLifecycleResultSet run() {
		JSONObject result = super.runWithResults();
		return new PutBucketLifecycleResultSet(result);
	}
	
}
