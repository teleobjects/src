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
SetTopicAttributes

Allows a topic owner to update the attribute of a topic to a new value.
*/
public class SetTopicAttributes extends Choreography {

	/**
	Create a new instance of the SetTopicAttributes Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SetTopicAttributes(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/SNS/SetTopicAttributes"));
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
	Set the value of the AttributeName input for this Choreo. 

	@param String - (required, string) The name of the attribute you want to modify. Valid values are: Policy and DisplayName.
	*/
	public void setAttributeName(String value) {
		this.inputs.setInput("AttributeName", value);
	}


	/** 
	Set the value of the AttributeValue input for this Choreo. 

	@param String - (required, string) The new value for the attribute that you want to update.
	*/
	public void setAttributeValue(String value) {
		this.inputs.setInput("AttributeValue", value);
	}


	/** 
	Set the value of the TopicArn input for this Choreo. 

	@param String - (required, string) The ARN of the topic that has an attribute that you want to set.
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
	public SetTopicAttributesResultSet run() {
		JSONObject result = super.runWithResults();
		return new SetTopicAttributesResultSet(result);
	}
	
}
