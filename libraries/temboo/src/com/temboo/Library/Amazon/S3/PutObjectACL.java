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
PutObjectACL

Sets the access control list (ACL) permissions for an existing object.
*/
public class PutObjectACL extends Choreography {

	/**
	Create a new instance of the PutObjectACL Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PutObjectACL(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/S3/PutObjectACL"));
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
	Set the value of the AccessControlList input for this Choreo. 

	@param String - (optional, xml) Custom Access Control List xml for advanced configuration. See description for an example, plus Amazon documentation.
	*/
	public void setAccessControlList(String value) {
		this.inputs.setInput("AccessControlList", value);
	}


	/** 
	Set the value of the BucketName input for this Choreo. 

	@param String - (required, string) The name of the bucket that contains the object that you want to create or update a policy for.
	*/
	public void setBucketName(String value) {
		this.inputs.setInput("BucketName", value);
	}


	/** 
	Set the value of the CannedACL input for this Choreo. 

	@param String - (conditional, string) Most common ACL usage, required unless creating a custom policy. Values: private, public-read, public-read-write, authenticated-read, bucket-owner-read, or bucket-owner-full-control.
	*/
	public void setCannedACL(String value) {
		this.inputs.setInput("CannedACL", value);
	}


	/** 
	Set the value of the FileName input for this Choreo. 

	@param String - (required, string) The name of the file or object that you want to put access controls on in S3. Ex.: file.txt or folder/file.txt.
	*/
	public void setFileName(String value) {
		this.inputs.setInput("FileName", value);
	}


	/** 
	Set the value of the OwnerEmailAddress input for this Choreo. 

	@param String - (optional, string) The email address of the owner who is granting permission. Required if creating your own custom ACL policy.
	*/
	public void setOwnerEmailAddress(String value) {
		this.inputs.setInput("OwnerEmailAddress", value);
	}


	/** 
	Set the value of the OwnerId input for this Choreo. 

	@param String - (optional, string) The canonical user id of the owner who is granting permission. Required if creating your own custom ACL policy.
	*/
	public void setOwnerId(String value) {
		this.inputs.setInput("OwnerId", value);
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
	public PutObjectACLResultSet run() {
		JSONObject result = super.runWithResults();
		return new PutObjectACLResultSet(result);
	}
	
}
