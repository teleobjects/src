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
GetBase64EncodedObject

Retrieves a specified item from an Amazon S3 bucket, returns the file content as base64-encoded data, and returns the values of key response headers as output variables if available.
*/
public class GetBase64EncodedObject extends Choreography {

	/**
	Create a new instance of the GetBase64EncodedObject Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetBase64EncodedObject(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/S3/GetBase64EncodedObject"));
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

	@param String - (required, string) The name of the bucket that contains the object to retrieve.
	*/
	public void setBucketName(String value) {
		this.inputs.setInput("BucketName", value);
	}


	/** 
	Set the value of the FileName input for this Choreo. 

	@param String - (required, string) The name of the file to retrieve.
	*/
	public void setFileName(String value) {
		this.inputs.setInput("FileName", value);
	}


	/** 
	Set the value of the IfMatch input for this Choreo. 

	@param String - (optional, string) Returns the object only if its entity tag (ETag) is the same as the one specified, otherwise returns a 412 (precondition failed) error.
	*/
	public void setIfMatch(String value) {
		this.inputs.setInput("IfMatch", value);
	}


	/** 
	Set the value of the IfModifiedSince input for this Choreo. 

	@param String - (optional, date) Returns the object only if it has been modified since the specific time, otherwise returns a 304 (not modified) error.
	*/
	public void setIfModifiedSince(String value) {
		this.inputs.setInput("IfModifiedSince", value);
	}


	/** 
	Set the value of the IfNoneMatch input for this Choreo. 

	@param String - (optional, string) Returns the object only if its entity tag (ETag) is different from the one specified, otherwise retuns a 304 (not modified) error. Will not work correctly with IfModifiedSince.
	*/
	public void setIfNoneMatch(String value) {
		this.inputs.setInput("IfNoneMatch", value);
	}


	/** 
	Set the value of the IfUnmodifiedSince input for this Choreo. 

	@param String - (optional, date) Returns the object only if it has not been modified since the specified time, otherwise returns a 412 (precondition failed) error.
	*/
	public void setIfUnmodifiedSince(String value) {
		this.inputs.setInput("IfUnmodifiedSince", value);
	}


	/** 
	Set the value of the Range input for this Choreo. 

	@param String - (optional, string) Downloads the specific range of bytes of an object. Ex: 0-9 (returns the first 10 bytes of an object), 100-1000, etc. If the range value exceeds the end of file, it will return up to the end of file.
	*/
	public void setRange(String value) {
		this.inputs.setInput("Range", value);
	}


	/** 
	Set the value of the SSECAlgorithm input for this Choreo. 

	@param String - (optional, string) Specifies the server-side encryption with customer-provided encryption keys (SSE-C) algorithm used when Amazon S3 created the target object. Valid value: AES256.
	*/
	public void setSSECAlgorithm(String value) {
		this.inputs.setInput("SSECAlgorithm", value);
	}


	/** 
	Set the value of the SSECKey input for this Choreo. 

	@param String - (optional, string) The customer-provided AES-256 256-bit (32-byte) encryption key for Amazon S3 to use to encrypt or decrypt your data.
	*/
	public void setSSECKey(String value) {
		this.inputs.setInput("SSECKey", value);
	}


	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (conditional, string) The AWS region that corresponds to the S3 endpoint you wish to access. The default region is "us-east-1".
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public GetBase64EncodedObjectResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetBase64EncodedObjectResultSet(result);
	}
	
}
