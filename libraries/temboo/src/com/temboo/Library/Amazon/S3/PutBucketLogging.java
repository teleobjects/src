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
PutBucketLogging

Sets the logging parameters for a bucket and specifies permissions for who can view and modify the logging parameters. Can also be used to disable logging.
*/
public class PutBucketLogging extends Choreography {

	/**
	Create a new instance of the PutBucketLogging Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PutBucketLogging(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/S3/PutBucketLogging"));
	}

	/** 
	Set the value of the BucketLoggingStatus input for this Choreo. 

	@param String - (optional, any) An XML file that allows custom config, this can be used as an alternative to the other bucket logging inputs. If provided, the Choreo will ignore all inputs except your AWS Key/Secret and BucketName.
	*/
	public void setBucketLoggingStatus(String value) {
		this.inputs.setInput("BucketLoggingStatus", value);
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

	@param String - (required, string) The name of the bucket that you are setting the logging for.
	*/
	public void setBucketName(String value) {
		this.inputs.setInput("BucketName", value);
	}


	/** 
	Set the value of the EmailAddress input for this Choreo. 

	@param String - (conditional, string) The email address of the person being granted logging permissions.
	*/
	public void setEmailAddress(String value) {
		this.inputs.setInput("EmailAddress", value);
	}


	/** 
	Set the value of the Permission input for this Choreo. 

	@param String - (conditional, string) The logging permissions given to the Grantee for the bucket. Valid values are: FULL_CONTROL, READ, or WRITE.
	*/
	public void setPermission(String value) {
		this.inputs.setInput("Permission", value);
	}


	/** 
	Set the value of the TargetBucket input for this Choreo. 

	@param String - (conditional, string) The name of the target bucket. To disable logging, just leave this blank.
	*/
	public void setTargetBucket(String value) {
		this.inputs.setInput("TargetBucket", value);
	}


	/** 
	Set the value of the TargetPrefix input for this Choreo. 

	@param String - (conditional, string) Lets you specify a prefix for the keys that the log files will be stored under. Defaults to "/logs"
	*/
	public void setTargetPrefix(String value) {
		this.inputs.setInput("TargetPrefix", value);
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
	public PutBucketLoggingResultSet run() {
		JSONObject result = super.runWithResults();
		return new PutBucketLoggingResultSet(result);
	}
	
}
