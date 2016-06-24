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
PutBucketCORS

Sets the CORS (Cross-Origin Resource Sharing) configuration for a specified bucket.
*/
public class PutBucketCORS extends Choreography {

	/**
	Create a new instance of the PutBucketCORS Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PutBucketCORS(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/S3/PutBucketCORS"));
	}

	/** 
	Set the value of the CORSConfiguration input for this Choreo. 

	@param String - (optional, xml) The CORS Configuration XML containing one or more CORS Rules for advanced configuration. If provided the Choreo will ignore all other inputs except your AWS Key/Secret and BucketName.
	*/
	public void setCORSConfiguration(String value) {
		this.inputs.setInput("CORSConfiguration", value);
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
	Set the value of the AllowedHeader input for this Choreo. 

	@param String - (optional, string) Specifies which headers are allowed in a pre-flight OPTIONS request via the Access-Control-Request-Headers header.
	*/
	public void setAllowedHeader(String value) {
		this.inputs.setInput("AllowedHeader", value);
	}


	/** 
	Set the value of the AllowedMethod input for this Choreo. 

	@param String - (conditional, string) The HTTP verb that you want to allow the origin to execute. Valid values are: GET, PUT, HEAD, POST, DELETE.
	*/
	public void setAllowedMethod(String value) {
		this.inputs.setInput("AllowedMethod", value);
	}


	/** 
	Set the value of the AllowedOrigin input for this Choreo. 

	@param String - (conditional, string) An origin that you want to allow cross-domain requests from. This can contain at most one * wild character (i.e. http://*.example.com).
	*/
	public void setAllowedOrigin(String value) {
		this.inputs.setInput("AllowedOrigin", value);
	}


	/** 
	Set the value of the BucketName input for this Choreo. 

	@param String - (required, string) The name of the bucket to set a CORS configuration for.
	*/
	public void setBucketName(String value) {
		this.inputs.setInput("BucketName", value);
	}


	/** 
	Set the value of the ExposeHeader input for this Choreo. 

	@param String - (optional, string) A header in the response that you want customers to be able to access from their applications.
	*/
	public void setExposeHeader(String value) {
		this.inputs.setInput("ExposeHeader", value);
	}


	/** 
	Set the value of the ID input for this Choreo. 

	@param String - (optional, string) A unique identifier for the rule. The ID value can be up to 255 characters long.
	*/
	public void setID(String value) {
		this.inputs.setInput("ID", value);
	}


	/** 
	Set the value of the MaxAgeSeconds input for this Choreo. 

	@param Integer - (optional, integer) The time in seconds that your browser is to cache the preflight response for the specified resource.
	*/
	public void setMaxAgeSeconds(Integer value) {
		this.inputs.setInput("MaxAgeSeconds", value);
	}

	/** 
	Set the value of the MaxAgeSeconds input for this Choreo as a String. 

	@param String - (optional, integer) The time in seconds that your browser is to cache the preflight response for the specified resource.
	*/
	public void setMaxAgeSeconds(String value) {
		this.inputs.setInput("MaxAgeSeconds", value);	
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
	public PutBucketCORSResultSet run() {
		JSONObject result = super.runWithResults();
		return new PutBucketCORSResultSet(result);
	}
	
}
