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
GetBucketList

Retrieves a list of the items that are in a specified Amazon S3 storage bucket.
*/
public class GetBucketList extends Choreography {

	/**
	Create a new instance of the GetBucketList Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetBucketList(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/S3/GetBucketList"));
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

	@param String - (required, string) The name of the bucket that contains the list of objects that you want to retrieve.
	*/
	public void setBucketName(String value) {
		this.inputs.setInput("BucketName", value);
	}


	/** 
	Set the value of the Delimiter input for this Choreo. 

	@param String - (optional, string) A delimiter is a character you use to group keys. All keys that contain the delimiter are grouped under a single result element, Common Prefixes. For more information see Amazon documentation.
	*/
	public void setDelimiter(String value) {
		this.inputs.setInput("Delimiter", value);
	}


	/** 
	Set the value of the Marker input for this Choreo. 

	@param String - (optional, string) Specifies the key to start with when listing objects in a bucket. Amazon S3 lists objects in alphabetical order.
	*/
	public void setMarker(String value) {
		this.inputs.setInput("Marker", value);
	}


	/** 
	Set the value of the MaxKeys input for this Choreo. 

	@param String - (optional, string) Lowers the max number of keys returned in the response from 1000 to specified value.The response will contain the key IsTruncated (true) if there are additional keys that exceed the # of MaxKeys.
	*/
	public void setMaxKeys(String value) {
		this.inputs.setInput("MaxKeys", value);
	}


	/** 
	Set the value of the Prefix input for this Choreo. 

	@param String - (optional, string) Limits the response to keys that begin with the specified prefix - useful for separating a bucket into different groupings of keys. Ex: specify 'test' to get a list of objects starting with 'test'.
	*/
	public void setPrefix(String value) {
		this.inputs.setInput("Prefix", value);
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
	public GetBucketListResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetBucketListResultSet(result);
	}
	
}
