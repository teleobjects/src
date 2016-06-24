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
PutObject

Uploads a file to your Amazon S3 storage bucket.
*/
public class PutObject extends Choreography {

	/**
	Create a new instance of the PutObject Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PutObject(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/S3/PutObject"));
	}

	/** 
	Set the value of the FileContents input for this Choreo. 

	@param String - (required, string) The Base64-encoded file contents that you want to upload to an AmazonS3 bucket. This is required unless providing a URL to a hosted file to upload, using the UploadSourceURL input.
	*/
	public void setFileContents(String value) {
		this.inputs.setInput("FileContents", value);
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

	@param String - (required, string) The name of the bucket that will be the file destination.
	*/
	public void setBucketName(String value) {
		this.inputs.setInput("BucketName", value);
	}


	/** 
	Set the value of the CannedACL input for this Choreo. 

	@param String - (optional, string) By default all objects are private (only owner has full access control). Valid values: private, public-read, public-read-write, authenticated-read, bucket-owner-read, bucket-owner-full-control.
	*/
	public void setCannedACL(String value) {
		this.inputs.setInput("CannedACL", value);
	}


	/** 
	Set the value of the ContentType input for this Choreo. 

	@param String - (optional, string) Sets the content-type (text/html, image/jpeg, etc.). Default is application/octet-stream.
	*/
	public void setContentType(String value) {
		this.inputs.setInput("ContentType", value);
	}


	/** 
	Set the value of the FileName input for this Choreo. 

	@param String - (required, string) The name of the file to put in S3 Storage. Ex.: file.txt or folder/file.txt
	*/
	public void setFileName(String value) {
		this.inputs.setInput("FileName", value);
	}


	/** 
	Set the value of the SSECAlgorithm input for this Choreo. 

	@param String - (optional, string) Specifies the server-side encryption with customer-provided encryption keys (SSE-C) algorithm to use when Amazon S3 creates the target object. Valid value: AES256.
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
	Set the value of the ServerSideEncryption input for this Choreo. 

	@param String - (optional, string) Specifies the server-side encryption algorithm to use when Amazon S3 creates the target object. Valid value: AES256.
	*/
	public void setServerSideEncryption(String value) {
		this.inputs.setInput("ServerSideEncryption", value);
	}


	/** 
	Set the value of the StorageClass input for this Choreo. 

	@param String - (optional, string) Enables RRS customers to store their noncritical, reproducible data at lower levels of redundancy than Amazon S3's standard storage. Valid Values: STANDARD (default), REDUCED_REDUNDANCY.
	*/
	public void setStorageClass(String value) {
		this.inputs.setInput("StorageClass", value);
	}


	/** 
	Set the value of the UploadSourcePassword input for this Choreo. 

	@param String - (optional, string) The password to use when Basic Authentiation is required to access a file located at the URL specified in the UploadSourceURL input.
	*/
	public void setUploadSourcePassword(String value) {
		this.inputs.setInput("UploadSourcePassword", value);
	}


	/** 
	Set the value of the UploadSourceURL input for this Choreo. 

	@param String - (optional, string) A URL to a hosted file that should be uploaded. This is required unless providing a Base64 encoded file for the FileContents input.
	*/
	public void setUploadSourceURL(String value) {
		this.inputs.setInput("UploadSourceURL", value);
	}


	/** 
	Set the value of the UploadSourceUsername input for this Choreo. 

	@param String - (optional, string) The username to use when Basic Authentiation is required to access a file located at the URL specified in the UploadSourceURL input.
	*/
	public void setUploadSourceUsername(String value) {
		this.inputs.setInput("UploadSourceUsername", value);
	}


	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (conditional, string) The AWS region that corresponds to the S3 endpoint you wish to access. The default region is "us-east-1".
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	/** 
	Set the value of the WebsiteRedirectLocation input for this Choreo. 

	@param String - (optional, string) If the bucket is configured as a website, redirects requests for this object to another object in the same bucket or to an external URL. Ex: /anotherPage.html, http://www.page.com. Max length: 2 K.
	*/
	public void setWebsiteRedirectLocation(String value) {
		this.inputs.setInput("WebsiteRedirectLocation", value);
	}


	/** 
	Set the value of the VaultFile input for this Choreo. 

	@param TembooPath - (optional, vault file) The path to a vault file that you want to upload to an Amazon S3 bucket. Required unless using the FileContents input variable.
	*/

	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PutObjectResultSet run() {
		JSONObject result = super.runWithResults();
		return new PutObjectResultSet(result);
	}
	
}
