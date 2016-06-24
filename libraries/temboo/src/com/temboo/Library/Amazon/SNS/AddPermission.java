package com.temboo.Library.Amazon.SNS;

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
AddPermission

Creates a statement for a topic's access control policy which allows an AWS account to have access to the specified Amazon SNS actions.
*/
public class AddPermission extends Choreography {

	/**
	Create a new instance of the AddPermission Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddPermission(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/SNS/AddPermission"));
	}

	/** 
	Set the value of the AWSAccessKeyId input for this Choreo. 

	@param String - (required, string) The Access Key ID provided by Amazon Web Services.
	*/
	public void setAWSAccessKeyId(String value) {
		this.inputs.setInput("AWSAccessKeyId", value);
	}


	/** 
	Set the value of the AWSAccountId input for this Choreo. 

	@param Integer - (required, integer) The AWS account number of the user that will be granted access to a specified action. Enter account number omitting any dashes.
	*/
	public void setAWSAccountId(Integer value) {
		this.inputs.setInput("AWSAccountId", value);
	}

	/** 
	Set the value of the AWSAccountId input for this Choreo as a String. 

	@param String - (required, integer) The AWS account number of the user that will be granted access to a specified action. Enter account number omitting any dashes.
	*/
	public void setAWSAccountId(String value) {
		this.inputs.setInput("AWSAccountId", value);	
	}
	/** 
	Set the value of the AWSSecretKeyId input for this Choreo. 

	@param String - (required, string) The Secret Key ID provided by Amazon Web Services.
	*/
	public void setAWSSecretKeyId(String value) {
		this.inputs.setInput("AWSSecretKeyId", value);
	}


	/** 
	Set the value of the ActionName input for this Choreo. 

	@param String - (required, string) The action you want to allow for a specified user (i.e. DeleteTopic, Publish, GetTopicAttributes, etc).
	*/
	public void setActionName(String value) {
		this.inputs.setInput("ActionName", value);
	}


	/** 
	Set the value of the Label input for this Choreo. 

	@param String - (required, string) The unique identifier for the new policy statement.
	*/
	public void setLabel(String value) {
		this.inputs.setInput("Label", value);
	}


	/** 
	Set the value of the TopicArn input for this Choreo. 

	@param String - (required, string) The ARN of the topic whos access control policy you want to adjust.
	*/
	public void setTopicArn(String value) {
		this.inputs.setInput("TopicArn", value);
	}


	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (optional, string) The AWS region that corresponds to the SNS endpoint you wish to access. The default region is "us-east-1". See description below for valid values.
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AddPermissionResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddPermissionResultSet(result);
	}
	
}
