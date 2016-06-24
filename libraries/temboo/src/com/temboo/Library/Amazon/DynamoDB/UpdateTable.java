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
UpdateTable

Modifies the provisioned throughput settings, global secondary indexes, or DynamoDB Streams settings for a given table.
*/
public class UpdateTable extends Choreography {

	/**
	Create a new instance of the UpdateTable Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public UpdateTable(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/DynamoDB/UpdateTable"));
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
	Set the value of the AttributeDefinitions input for this Choreo. 

	@param String - (optional, json) An array of attributes that describe the key schema for the table and indexes.
	*/
	public void setAttributeDefinitions(String value) {
		this.inputs.setInput("AttributeDefinitions", value);
	}


	/** 
	Set the value of the GlobalSecondaryIndexUpdates input for this Choreo. 

	@param String - (conditional, json) One or more global secondary indexes (the maximum is five) to be created on the table.
	*/
	public void setGlobalSecondaryIndexUpdates(String value) {
		this.inputs.setInput("GlobalSecondaryIndexUpdates", value);
	}


	/** 
	Set the value of the ProvisionedThroughput input for this Choreo. 

	@param String - (conditional, json) Represents the provisioned throughput settings for a specified table or index.
	*/
	public void setProvisionedThroughput(String value) {
		this.inputs.setInput("ProvisionedThroughput", value);
	}


	/** 
	Set the value of the StreamSpecification input for this Choreo. 

	@param String - (conditional, json) The settings for DynamoDB Streams on the table.
	*/
	public void setStreamSpecification(String value) {
		this.inputs.setInput("StreamSpecification", value);
	}


	/** 
	Set the value of the TableName input for this Choreo. 

	@param String - (required, string) The name of the table to create.
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
	public UpdateTableResultSet run() {
		JSONObject result = super.runWithResults();
		return new UpdateTableResultSet(result);
	}
	
}
