package com.temboo.Library.Amazon.DynamoDB;

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
PutItem

Creates a new item, or replaces an old item with a new item.
*/
public class PutItem extends Choreography {

	/**
	Create a new instance of the PutItem Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public PutItem(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/DynamoDB/PutItem"));
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
	Set the value of the ConditionExpression input for this Choreo. 

	@param String - (optional, string) A condition that must be satisfied in order for a conditional PutItem operation to succeed.
	*/
	public void setConditionExpression(String value) {
		this.inputs.setInput("ConditionExpression", value);
	}


	/** 
	Set the value of the ExpressionAttributeNames input for this Choreo. 

	@param String - (optional, json) One or more substitution tokens for attribute names in an expression.
	*/
	public void setExpressionAttributeNames(String value) {
		this.inputs.setInput("ExpressionAttributeNames", value);
	}


	/** 
	Set the value of the ExpressionAttributeValues input for this Choreo. 

	@param String - (optional, json) One or more values that can be substituted in an expression.
	*/
	public void setExpressionAttributeValues(String value) {
		this.inputs.setInput("ExpressionAttributeValues", value);
	}


	/** 
	Set the value of the Item input for this Choreo. 

	@param String - (required, json) A map of attribute name/value pairs, one for each attribute. Only the primary key attributes are required.
	*/
	public void setItem(String value) {
		this.inputs.setInput("Item", value);
	}


	/** 
	Set the value of the ReturnConsumedCapacity input for this Choreo. 

	@param String - (optional, string) Determines the level of detail about provisioned throughput consumption that is returned in the response. Valid values are: INDEXES, TOTAL, NONE.
	*/
	public void setReturnConsumedCapacity(String value) {
		this.inputs.setInput("ReturnConsumedCapacity", value);
	}


	/** 
	Set the value of the ReturnItemCollectionMetrics input for this Choreo. 

	@param String - (optional, string) Determines whether item collection metrics are returned. Valid values are: SIZE and NONE.
	*/
	public void setReturnItemCollectionMetrics(String value) {
		this.inputs.setInput("ReturnItemCollectionMetrics", value);
	}


	/** 
	Set the value of the ReturnValues input for this Choreo. 

	@param String - (optional, string) Use ReturnValues if you want to get the item attributes as they appeared before they were updated with the PutItem request. Valid values are NONE and ALL_OLD.
	*/
	public void setReturnValues(String value) {
		this.inputs.setInput("ReturnValues", value);
	}


	/** 
	Set the value of the TableName input for this Choreo. 

	@param String - (required, string) The name of the table to contain the item.
	*/
	public void setTableName(String value) {
		this.inputs.setInput("TableName", value);
	}


	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (optional, string) The AWS region that corresponds to the S3 endpoint you wish to access. The default region is "us-east-1".
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public PutItemResultSet run() {
		JSONObject result = super.runWithResults();
		return new PutItemResultSet(result);
	}
	
}
