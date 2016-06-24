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
ZipBucket

Creates a zip file containing all objects within the specified bucket and returns a download link for the new compressed file.
*/
public class ZipBucket extends Choreography {

	/**
	Create a new instance of the ZipBucket Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ZipBucket(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/S3/ZipBucket"));
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

	@param String - (required, string) The name of the bucket that contains the list of objects that you want to zip.
	*/
	public void setBucketName(String value) {
		this.inputs.setInput("BucketName", value);
	}


	/** 
	Set the value of the CannedACL input for this Choreo. 

	@param String - (conditional, string) This sets the permissions for the newly created zip file. Valid values are: private, public-read, public-read-write, authenticated-read, bucket-owner-read, or bucket-owner-full-control.
	*/
	public void setCannedACL(String value) {
		this.inputs.setInput("CannedACL", value);
	}


	/** 
	Set the value of the Delimiter input for this Choreo. 

	@param String - (optional, string) A delimiter is a character you use to group keys. All keys that contain the delimiter are grouped under a single result element, Common Prefixes. For more information see Amazon documentation.
	*/
	public void setDelimiter(String value) {
		this.inputs.setInput("Delimiter", value);
	}


	/** 
	Set the value of the Prefix input for this Choreo. 

	@param String - (optional, string) Limits the response to keys that begin with the specified prefix - useful for separating a bucket into different groupings of keys. Ex: specify 'test' to get a list of objects starting with 'test'.
	*/
	public void setPrefix(String value) {
		this.inputs.setInput("Prefix", value);
	}


	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (required, string) The AWS region that corresponds to the S3 endpoint you wish to access. The default region is "us-east-1".
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	/** 
	Set the value of the ZipFileLocation input for this Choreo. 

	@param String - (optional, string) The name of the bucket to put the new zip file in. When not specified, the zip file will be put in the bucket that contains the files being zipped.
	*/
	public void setZipFileLocation(String value) {
		this.inputs.setInput("ZipFileLocation", value);
	}


	/** 
	Set the value of the ZipFileName input for this Choreo. 

	@param String - (optional, string) The name of the zip file that will be created. If not specified, the original bucket name will be used with .zip extension.
	*/
	public void setZipFileName(String value) {
		this.inputs.setInput("ZipFileName", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ZipBucketResultSet run() {
		JSONObject result = super.runWithResults();
		return new ZipBucketResultSet(result);
	}
	
}
