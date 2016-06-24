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
CreateQueue

Creates a new queue with a specified queue name.
*/
public class CreateQueue extends Choreography {

	/**
	Create a new instance of the CreateQueue Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateQueue(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/SQS/CreateQueue"));
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
	Set the value of the DefaultVisibilityTimeout input for this Choreo. 

	@param Integer - (optional, integer) The visibility timeout for the queue. An integer from 0 to 43200 (12 hours). The default for this attribute is 30.
	*/
	public void setDefaultVisibilityTimeout(Integer value) {
		this.inputs.setInput("DefaultVisibilityTimeout", value);
	}

	/** 
	Set the value of the DefaultVisibilityTimeout input for this Choreo as a String. 

	@param String - (optional, integer) The visibility timeout for the queue. An integer from 0 to 43200 (12 hours). The default for this attribute is 30.
	*/
	public void setDefaultVisibilityTimeout(String value) {
		this.inputs.setInput("DefaultVisibilityTimeout", value);	
	}
	/** 
	Set the value of the MaximumMessageSize input for this Choreo. 

	@param Integer - (optional, integer) The limit of how many bytes a message can contain before Amazon SQS rejects it. An integer from 1024 bytes (1 KiB) up to 262144 bytes (256 KiB)
	*/
	public void setMaximumMessageSize(Integer value) {
		this.inputs.setInput("MaximumMessageSize", value);
	}

	/** 
	Set the value of the MaximumMessageSize input for this Choreo as a String. 

	@param String - (optional, integer) The limit of how many bytes a message can contain before Amazon SQS rejects it. An integer from 1024 bytes (1 KiB) up to 262144 bytes (256 KiB)
	*/
	public void setMaximumMessageSize(String value) {
		this.inputs.setInput("MaximumMessageSize", value);	
	}
	/** 
	Set the value of the MessageRetentionPeriod input for this Choreo. 

	@param Integer - (optional, integer) The number of seconds Amazon SQS retains a message. Integer representing seconds, from 60 (1 minute) to 1209600 (14 days). The default for this attribute is 345600 (4 days).
	*/
	public void setMessageRetentionPeriod(Integer value) {
		this.inputs.setInput("MessageRetentionPeriod", value);
	}

	/** 
	Set the value of the MessageRetentionPeriod input for this Choreo as a String. 

	@param String - (optional, integer) The number of seconds Amazon SQS retains a message. Integer representing seconds, from 60 (1 minute) to 1209600 (14 days). The default for this attribute is 345600 (4 days).
	*/
	public void setMessageRetentionPeriod(String value) {
		this.inputs.setInput("MessageRetentionPeriod", value);	
	}
	/** 
	Set the value of the Policy input for this Choreo. 

	@param String - (optional, json) The queue's policy.
	*/
	public void setPolicy(String value) {
		this.inputs.setInput("Policy", value);
	}


	/** 
	Set the value of the QueueName input for this Choreo. 

	@param String - (required, string) The name of the queue you want to create.
	*/
	public void setQueueName(String value) {
		this.inputs.setInput("QueueName", value);
	}


	/** 
	Set the value of the ReceiveMessageWaitTimeSeconds input for this Choreo. 

	@param Integer - (optional, integer) The time for which a ReceiveMessage call will wait for a message to arrive. An integer from 0 to 20 (seconds). The default for this attribute is 0.
	*/
	public void setReceiveMessageWaitTimeSeconds(Integer value) {
		this.inputs.setInput("ReceiveMessageWaitTimeSeconds", value);
	}

	/** 
	Set the value of the ReceiveMessageWaitTimeSeconds input for this Choreo as a String. 

	@param String - (optional, integer) The time for which a ReceiveMessage call will wait for a message to arrive. An integer from 0 to 20 (seconds). The default for this attribute is 0.
	*/
	public void setReceiveMessageWaitTimeSeconds(String value) {
		this.inputs.setInput("ReceiveMessageWaitTimeSeconds", value);	
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
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateQueueResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateQueueResultSet(result);
	}
	
}
