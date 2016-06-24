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
Query

Queries a table using the primary key or a secondary index.
*/
public class Query extends Choreography {

	/**
	Create a new instance of the Query Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public Query(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/DynamoDB/Query"));
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
	Set the value of the ExclusiveStartKey input for this Choreo. 

	@param String - (optional, json) The primary key of the first item that this operation will evaluate. Use the value that was returned for LastEvaluatedKey in the previous operation.
	*/
	public void setExclusiveStartKey(String value) {
		this.inputs.setInput("ExclusiveStartKey", value);
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

	@param String - (conditional, json) One or more values that can be substituted in an expression.
	*/
	public void setExpressionAttributeValues(String value) {
		this.inputs.setInput("ExpressionAttributeValues", value);
	}


	/** 
	Set the value of the FilterExpression input for this Choreo. 

	@param String - (optional, string) A string that contains conditions that DynamoDB applies after the Query operation, but before the data is returned to you.
	*/
	public void setFilterExpression(String value) {
		this.inputs.setInput("FilterExpression", value);
	}


	/** 
	Set the value of the IndexName input for this Choreo. 

	@param String - (optional, string) The name of an index to query. This index can be any local secondary index or global secondary index on the table.
	*/
	public void setIndexName(String value) {
		this.inputs.setInput("IndexName", value);
	}


	/** 
	Set the value of the KeyConditionExpression input for this Choreo. 

	@param String - (conditional, string) The condition that specifies the key value(s) for items to be retrieved by the Query action.
	*/
	public void setKeyConditionExpression(String value) {
		this.inputs.setInput("KeyConditionExpression", value);
	}


	/** 
	Set the value of the Limit input for this Choreo. 

	@param Integer - (optional, integer) The maximum number of items to evaluate (not necessarily the number of matching items).
	*/
	public void setLimit(Integer value) {
		this.inputs.setInput("Limit", value);
	}

	/** 
	Set the value of the Limit input for this Choreo as a String. 

	@param String - (optional, integer) The maximum number of items to evaluate (not necessarily the number of matching items).
	*/
	public void setLimit(String value) {
		this.inputs.setInput("Limit", value);	
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
	Set the value of the ScanIndexForward input for this Choreo. 

	@param Boolean - (optional, boolean) Specifies the order for index traversal: If true (default), the traversal is performed in ascending order; if false, the traversal is performed in descending order.
	*/
	public void setScanIndexForward(Boolean value) {
		this.inputs.setInput("ScanIndexForward", value);
	}

	/** 
	Set the value of the ScanIndexForward input for this Choreo as a String. 

	@param String - (optional, boolean) Specifies the order for index traversal: If true (default), the traversal is performed in ascending order; if false, the traversal is performed in descending order.
	*/
	public void setScanIndexForward(String value) {
		this.inputs.setInput("ScanIndexForward", value);	
	}
	/** 
	Set the value of the Select input for this Choreo. 

	@param String - (optional, string) The attributes to be returned in the result. Valid values are: ALL_ATTRIBUTES, ALL_PROJECTED_ATTRIBUTES, SPECIFIC_ATTRIBUTES, and COUNT.
	*/
	public void setSelect(String value) {
		this.inputs.setInput("Select", value);
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
	public QueryResultSet run() {
		JSONObject result = super.runWithResults();
		return new QueryResultSet(result);
	}
	
}
