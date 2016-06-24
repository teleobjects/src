package com.temboo.Library.Amazon.SQS;

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
ChangeMessageVisibility

Updates the visibility timeout parameter of a message.
*/
public class ChangeMessageVisibility extends Choreography {

	/**
	Create a new instance of the ChangeMessageVisibility Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ChangeMessageVisibility(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/SQS/ChangeMessageVisibility"));
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

	@param Integer - (required, integer) The AWS account id associated with the queue. Enter account number omitting any dashes.
	*/
	public void setAWSAccountId(Integer value) {
		this.inputs.setInput("AWSAccountId", value);
	}

	/** 
	Set the value of the AWSAccountId input for this Choreo as a String. 

	@param String - (required, integer) The AWS account id associated with the queue. Enter account number omitting any dashes.
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
	Set the value of the QueueName input for this Choreo. 

	@param String - (required, string) The name of the queue that contains the message.
	*/
	public void setQueueName(String value) {
		this.inputs.setInput("QueueName", value);
	}


	/** 
	Set the value of the ReceiptHandle input for this Choreo. 

	@param String - (required, string) The receipt handle associated with the message you want to modify. This is returned in the RecieveMessage request.
	*/
	public void setReceiptHandle(String value) {
		this.inputs.setInput("ReceiptHandle", value);
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

	@param String - (optional, string) The AWS region that corresponds to the SQS endpoint you wish to access. The default region is "us-east-1". See description below for valid values.
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	/** 
	Set the value of the VisibilityTimeout input for this Choreo. 

	@param Integer - (required, integer) The new value for the visibility timeout of the message (in seconds).
	*/
	public void setVisibilityTimeout(Integer value) {
		this.inputs.setInput("VisibilityTimeout", value);
	}

	/** 
	Set the value of the VisibilityTimeout input for this Choreo as a String. 

	@param String - (required, integer) The new value for the visibility timeout of the message (in seconds).
	*/
	public void setVisibilityTimeout(String value) {
		this.inputs.setInput("VisibilityTimeout", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ChangeMessageVisibilityResultSet run() {
		JSONObject result = super.runWithResults();
		return new ChangeMessageVisibilityResultSet(result);
	}
	
}
