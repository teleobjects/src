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
PutBucketTagging

Adds a set of billing tags to an existing bucket.
*/
public class PutBucketTagging extends Choreography {

	/**
	Create a new instance of the PutBucketTagging Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PutBucketTagging(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/S3/PutBucketTagging"));
	}

	/** 
	Set the value of the Tags input for this Choreo. 

	@param String - (optional, xml) An XML file describing the key/values for the tag set. Note - if you use this input, the Key and Value input variables will be ignored.
	*/
	public void setTags(String value) {
		this.inputs.setInput("Tags", value);
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

	@param String - (required, string) The name of the bucket to add tags to.
	*/
	public void setBucketName(String value) {
		this.inputs.setInput("BucketName", value);
	}


	/** 
	Set the value of the Key input for this Choreo. 

	@param String - (conditional, string) The tag name.
	*/
	public void setKey(String value) {
		this.inputs.setInput("Key", value);
	}


	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (required, string) The AWS region that corresponds to the S3 endpoint you wish to access. The default region is "us-east-1".
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	/** 
	Set the value of the Value input for this Choreo. 

	@param String - (conditional, string) The tag value.
	*/
	public void setValue(String value) {
		this.inputs.setInput("Value", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PutBucketTaggingResultSet run() {
		JSONObject result = super.runWithResults();
		return new PutBucketTaggingResultSet(result);
	}
	
}
