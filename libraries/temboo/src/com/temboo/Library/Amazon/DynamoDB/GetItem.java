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
GetItem

Returns a set of attributes for the item with the given primary key.
*/
public class GetItem extends Choreography {

	/**
	Create a new instance of the GetItem Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public GetItem(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/DynamoDB/GetItem"));
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
	Set the value of the ConsistentRead input for this Choreo. 

	@param Boolean - (optional, boolean) Determines the read consistency model: If set to true, then the operation uses strongly consistent reads; otherwise, the operation uses eventually consistent reads.
	*/
	public void setConsistentRead(Boolean value) {
		this.inputs.setInput("ConsistentRead", value);
	}

	/** 
	Set the value of the ConsistentRead input for this Choreo as a String. 

	@param String - (optional, boolean) Determines the read consistency model: If set to true, then the operation uses strongly consistent reads; otherwise, the operation uses eventually consistent reads.
	*/
	public void setConsistentRead(String value) {
		this.inputs.setInput("ConsistentRead", value);	
	}
	/** 
	Set the value of the ExpressionAttributeNames input for this Choreo. 

	@param String - (optional, json) One or more substitution tokens for attribute names in an expression.
	*/
	public void setExpressionAttributeNames(String value) {
		this.inputs.setInput("ExpressionAttributeNames", value);
	}


	/** 
	Set the value of the Key input for this Choreo. 

	@param String - (required, json) A map of attribute names to AttributeValue objects, representing the primary key of the item to retrieve.
	*/
	public void setKey(String value) {
		this.inputs.setInput("Key", value);
	}


	/** 
	Set the value of the ProjectionExpression input for this Choreo. 

	@param String - (optional, string) A string that identifies one or more attributes to retrieve from the table.
	*/
	public void setProjectionExpression(String value) {
		this.inputs.setInput("ProjectionExpression", value);
	}


	/** 
	Set the value of the ReturnConsumedCapacity input for this Choreo. 

	@param String - (optional, string) Determines the level of detail about provisioned throughput consumption that is returned in the response. Valid values are: INDEXES, TOTAL, NONE.
	*/
	public void setReturnConsumedCapacity(String value) {
		this.inputs.setInput("ReturnConsumedCapacity", value);
	}


	/** 
	Set the value of the TableName input for this Choreo. 

	@param String - (required, string) The name of the table containing the requested items.
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
	public GetItemResultSet run() {
		JSONObject result = super.runWithResults();
		return new GetItemResultSet(result);
	}
	
}
