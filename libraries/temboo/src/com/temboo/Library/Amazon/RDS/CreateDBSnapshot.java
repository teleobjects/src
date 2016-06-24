package com.temboo.Library.Amazon.RDS;

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
CreateDBSnapshot

Creates a snapshot of an existing database instance.
*/
public class CreateDBSnapshot extends Choreography {

	/**
	Create a new instance of the CreateDBSnapshot Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateDBSnapshot(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/RDS/CreateDBSnapshot"));
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
	Set the value of the DBInstanceIdentifier input for this Choreo. 

	@param String - (required, string) The DB Instance identifier. Should be in all lowercase.
	*/
	public void setDBInstanceIdentifier(String value) {
		this.inputs.setInput("DBInstanceIdentifier", value);
	}


	/** 
	Set the value of the DBSnapshotIdentifier input for this Choreo. 

	@param String - (required, string) The unique identifier for the db snapshot you're creating.
	*/
	public void setDBSnapshotIdentifier(String value) {
		this.inputs.setInput("DBSnapshotIdentifier", value);
	}


	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (optional, string) The AWS region that corresponds to the RDS endpoint you wish to access. The default region is "us-east-1". See description below for valid values.
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateDBSnapshotResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateDBSnapshotResultSet(result);
	}
	
}
