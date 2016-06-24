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
RestoreDBInstanceFromDBSnapshot

Creates a new DB Instance from a DB snapshot.
*/
public class RestoreDBInstanceFromDBSnapshot extends Choreography {

	/**
	Create a new instance of the RestoreDBInstanceFromDBSnapshot Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RestoreDBInstanceFromDBSnapshot(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/RDS/RestoreDBInstanceFromDBSnapshot"));
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
	Set the value of the AutoMinorVersionUpgrade input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates that minor version upgrades will be applied automatically to the DB Instance during the maintenance window. Defaults to 0 (false).
	*/
	public void setAutoMinorVersionUpgrade(Boolean value) {
		this.inputs.setInput("AutoMinorVersionUpgrade", value);
	}

	/** 
	Set the value of the AutoMinorVersionUpgrade input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates that minor version upgrades will be applied automatically to the DB Instance during the maintenance window. Defaults to 0 (false).
	*/
	public void setAutoMinorVersionUpgrade(String value) {
		this.inputs.setInput("AutoMinorVersionUpgrade", value);	
	}
	/** 
	Set the value of the AvailabilityZone input for this Choreo. 

	@param String - (optional, string) The EC2 Availability Zone that the database instance will be created in. A random one is chose if not provided. Can not be specified if the MultiAZ parameter is set to 1 (true).
	*/
	public void setAvailabilityZone(String value) {
		this.inputs.setInput("AvailabilityZone", value);
	}


	/** 
	Set the value of the DBInstanceClass input for this Choreo. 

	@param String - (optional, string) The compute and memory capacity of the Amazon RDS DB instance. Valid Values: db.m1.small | db.m1.large | db.m1.xlarge | db.m2.2xlarge | db.m2.4xlarge.
	*/
	public void setDBInstanceClass(String value) {
		this.inputs.setInput("DBInstanceClass", value);
	}


	/** 
	Set the value of the DBInstanceIdentifier input for this Choreo. 

	@param String - (required, string) The identifier for the new DB instance that will be created from the specified Snapshot.
	*/
	public void setDBInstanceIdentifier(String value) {
		this.inputs.setInput("DBInstanceIdentifier", value);
	}


	/** 
	Set the value of the DBName input for this Choreo. 

	@param String - (optional, string) The database name for the restored DB Instance. Note that this parameter doesn't apply to the MySQL engine.
	*/
	public void setDBName(String value) {
		this.inputs.setInput("DBName", value);
	}


	/** 
	Set the value of the DBSnapshotIdentifier input for this Choreo. 

	@param String - (required, string) The name of the DB Snapshot to use.
	*/
	public void setDBSnapshotIdentifier(String value) {
		this.inputs.setInput("DBSnapshotIdentifier", value);
	}


	/** 
	Set the value of the Engine input for this Choreo. 

	@param String - (optional, string) The database engine to use for the new instance. Valid Values: MySQL | oracle-se1 | oracle-se | oracle-ee.
	*/
	public void setEngine(String value) {
		this.inputs.setInput("Engine", value);
	}


	/** 
	Set the value of the LicenseModel input for this Choreo. 

	@param String - (optional, string) License model information for the restored DB Instance. Valid values: license-included | bring-your-own-license | general-public-license.
	*/
	public void setLicenseModel(String value) {
		this.inputs.setInput("LicenseModel", value);
	}


	/** 
	Set the value of the MultiAZ input for this Choreo. 

	@param Boolean - (optional, boolean) Specifies if the DB Instance is a Multi-AZ deployment. Do not specify the AvailabilityZone parameter if the MultiAZ parameter is set to 1 (true).
	*/
	public void setMultiAZ(Boolean value) {
		this.inputs.setInput("MultiAZ", value);
	}

	/** 
	Set the value of the MultiAZ input for this Choreo as a String. 

	@param String - (optional, boolean) Specifies if the DB Instance is a Multi-AZ deployment. Do not specify the AvailabilityZone parameter if the MultiAZ parameter is set to 1 (true).
	*/
	public void setMultiAZ(String value) {
		this.inputs.setInput("MultiAZ", value);	
	}
	/** 
	Set the value of the Port input for this Choreo. 

	@param Integer - (optional, integer) The port number on which the database accepts connections.
	*/
	public void setPort(Integer value) {
		this.inputs.setInput("Port", value);
	}

	/** 
	Set the value of the Port input for this Choreo as a String. 

	@param String - (optional, integer) The port number on which the database accepts connections.
	*/
	public void setPort(String value) {
		this.inputs.setInput("Port", value);	
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
	public RestoreDBInstanceFromDBSnapshotResultSet run() {
		JSONObject result = super.runWithResults();
		return new RestoreDBInstanceFromDBSnapshotResultSet(result);
	}
	
}
