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
ReceiveMessage

Returns one or more messages from the specified queue.
*/
public class ReceiveMessage extends Choreography {

	/**
	Create a new instance of the ReceiveMessage Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ReceiveMessage(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/SQS/ReceiveMessage"));
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

	@param Integer - (required, integer) The id for the AWS account associated with the queue you're retrieving a message from (remove all dashes in the account number).
	*/
	public void setAWSAccountId(Integer value) {
		this.inputs.setInput("AWSAccountId", value);
	}

	/** 
	Set the value of the AWSAccountId input for this Choreo as a String. 

	@param String - (required, integer) The id for the AWS account associated with the queue you're retrieving a message from (remove all dashes in the account number).
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
	Set the value of the AttributeName input for this Choreo. 

	@param String - (optional, string) The attribute you wish to return. Values are: All (default), SenderId, SentTimestamp, ApproximateReceiveCount, or ApproximateFirstReceiveTimestamp.
	*/
	public void setAttributeName(String value) {
		this.inputs.setInput("AttributeName", value);
	}


	/** 
	Set the value of the MaxNumberOfMessages input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of messages to return. Defaults to 1.
	*/
	public void setMaxNumberOfMessages(Integer value) {
		this.inputs.setInput("MaxNumberOfMessages", value);
	}

	/** 
	Set the value of the MaxNumberOfMessages input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of messages to return. Defaults to 1.
	*/
	public void setMaxNumberOfMessages(String value) {
		this.inputs.setInput("MaxNumberOfMessages", value);	
	}
	/** 
	Set the value of the MessageAttributeName input for this Choreo. 

	@param String - (optional, string) The name of a message attribute to return. You can return all of the attributes by specifying "All".
	*/
	public void setMessageAttributeName(String value) {
		this.inputs.setInput("MessageAttributeName", value);
	}


	/** 
	Set the value of the QueueName input for this Choreo. 

	@param String - (required, string) The name of the queue you want to retrieve a message from.
	*/
	public void setQueueName(String value) {
		this.inputs.setInput("QueueName", value);
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

	@param Integer - (optional, integer) The duration (in seconds) that the received messages are hidden from future retrieve requests after a ReceiveMessage request (max is 43200).
	*/
	public void setVisibilityTimeout(Integer value) {
		this.inputs.setInput("VisibilityTimeout", value);
	}

	/** 
	Set the value of the VisibilityTimeout input for this Choreo as a String. 

	@param String - (optional, integer) The duration (in seconds) that the received messages are hidden from future retrieve requests after a ReceiveMessage request (max is 43200).
	*/
	public void setVisibilityTimeout(String value) {
		this.inputs.setInput("VisibilityTimeout", value);	
	}
	/** 
	Set the value of the WaitTimeSeconds input for this Choreo. 

	@param Integer - (optional, integer) The duration (in seconds) for which the call will wait for a message to arrive in the queue before returning. If a message is available, the call will return sooner than WaitTimeSeconds.
	*/
	public void setWaitTimeSeconds(Integer value) {
		this.inputs.setInput("WaitTimeSeconds", value);
	}

	/** 
	Set the value of the WaitTimeSeconds input for this Choreo as a String. 

	@param String - (optional, integer) The duration (in seconds) for which the call will wait for a message to arrive in the queue before returning. If a message is available, the call will return sooner than WaitTimeSeconds.
	*/
	public void setWaitTimeSeconds(String value) {
		this.inputs.setInput("WaitTimeSeconds", value);	
	}
	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public ReceiveMessageResultSet run() {
		JSONObject result = super.runWithResults();
		return new ReceiveMessageResultSet(result);
	}
	
}
