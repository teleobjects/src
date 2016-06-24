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
ModifyDBInstance

Modify settings for a DB Instance. You can change one or more database configuration parameters by specifying values for the Choreo inputs.
*/
public class ModifyDBInstance extends Choreography {

	/**
	Create a new instance of the ModifyDBInstance Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public ModifyDBInstance(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/RDS/ModifyDBInstance"));
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
	Set the value of the AllocatedStorage input for this Choreo. 

	@param Integer - (required, integer) Storage amount (in gigabytes) to be configured for the DB. Use 5 to 1024 for MySQL or 10 to 1024 for Oracle. Value supplied must be at least 10% greater than the current value
	*/
	public void setAllocatedStorage(Integer value) {
		this.inputs.setInput("AllocatedStorage", value);
	}

	/** 
	Set the value of the AllocatedStorage input for this Choreo as a String. 

	@param String - (required, integer) Storage amount (in gigabytes) to be configured for the DB. Use 5 to 1024 for MySQL or 10 to 1024 for Oracle. Value supplied must be at least 10% greater than the current value
	*/
	public void setAllocatedStorage(String value) {
		this.inputs.setInput("AllocatedStorage", value);	
	}
	/** 
	Set the value of the AllowMajorVersionUpgrade input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates that major version upgrades are allowed. Defaults to 0 (false).
	*/
	public void setAllowMajorVersionUpgrade(Boolean value) {
		this.inputs.setInput("AllowMajorVersionUpgrade", value);
	}

	/** 
	Set the value of the AllowMajorVersionUpgrade input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates that major version upgrades are allowed. Defaults to 0 (false).
	*/
	public void setAllowMajorVersionUpgrade(String value) {
		this.inputs.setInput("AllowMajorVersionUpgrade", value);	
	}
	/** 
	Set the value of the ApplyImmediately input for this Choreo. 

	@param Boolean - (optional, boolean) Specifies whether or not the modifications applied as soon as possible, regardless of the PreferredMaintenanceWindow setting for the DB Instance. Defaults to 0 (false).
	*/
	public void setApplyImmediately(Boolean value) {
		this.inputs.setInput("ApplyImmediately", value);
	}

	/** 
	Set the value of the ApplyImmediately input for this Choreo as a String. 

	@param String - (optional, boolean) Specifies whether or not the modifications applied as soon as possible, regardless of the PreferredMaintenanceWindow setting for the DB Instance. Defaults to 0 (false).
	*/
	public void setApplyImmediately(String value) {
		this.inputs.setInput("ApplyImmediately", value);	
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
	Set the value of the BackupRetentionPeriod input for this Choreo. 

	@param Integer - (optional, integer) Number of days to retain automated backups. Setting to a positive number enables backups. Setting to 0 disables automated backups. Must be a value from 0 to 8. Defaults to 0 (disabled).
	*/
	public void setBackupRetentionPeriod(Integer value) {
		this.inputs.setInput("BackupRetentionPeriod", value);
	}

	/** 
	Set the value of the BackupRetentionPeriod input for this Choreo as a String. 

	@param String - (optional, integer) Number of days to retain automated backups. Setting to a positive number enables backups. Setting to 0 disables automated backups. Must be a value from 0 to 8. Defaults to 0 (disabled).
	*/
	public void setBackupRetentionPeriod(String value) {
		this.inputs.setInput("BackupRetentionPeriod", value);	
	}
	/** 
	Set the value of the DBInstanceClass input for this Choreo. 

	@param String - (required, string) Capacity for the DB instance.  (db.m1.small, db.m1.large, db.m1.xlarge, db.m2.xlarge, db.m2.2xlarge, or db.m2.4xlarge).
	*/
	public void setDBInstanceClass(String value) {
		this.inputs.setInput("DBInstanceClass", value);
	}


	/** 
	Set the value of the DBInstanceIdentifier input for this Choreo. 

	@param String - (required, string) The DB Instance identifier. Should be in all lowercase.
	*/
	public void setDBInstanceIdentifier(String value) {
		this.inputs.setInput("DBInstanceIdentifier", value);
	}


	/** 
	Set the value of the DBParameterGroupName input for this Choreo. 

	@param String - (optional, string) The name of the DB Parameter Group to apply to this DB Instance.
	*/
	public void setDBParameterGroupName(String value) {
		this.inputs.setInput("DBParameterGroupName", value);
	}


	/** 
	Set the value of the DBSecurityGroup input for this Choreo. 

	@param String - (optional, string) A DB Security Groups to authorize on this DB Instance.
	*/
	public void setDBSecurityGroup(String value) {
		this.inputs.setInput("DBSecurityGroup", value);
	}


	/** 
	Set the value of the EngineVersion input for this Choreo. 

	@param String - (optional, string) The version number of the database engine to upgrade to.
	*/
	public void setEngineVersion(String value) {
		this.inputs.setInput("EngineVersion", value);
	}


	/** 
	Set the value of the MasterUserPassword input for this Choreo. 

	@param String - (required, string) The new password for the DB Instance master user.
	*/
	public void setMasterUserPassword(String value) {
		this.inputs.setInput("MasterUserPassword", value);
	}


	/** 
	Set the value of the MultiAZ input for this Choreo. 

	@param Boolean - (optional, boolean) Specifies if the DB Instance is a Multi-AZ deployment.
	*/
	public void setMultiAZ(Boolean value) {
		this.inputs.setInput("MultiAZ", value);
	}

	/** 
	Set the value of the MultiAZ input for this Choreo as a String. 

	@param String - (optional, boolean) Specifies if the DB Instance is a Multi-AZ deployment.
	*/
	public void setMultiAZ(String value) {
		this.inputs.setInput("MultiAZ", value);	
	}
	/** 
	Set the value of the PreferredBackupWindow input for this Choreo. 

	@param String - (optional, string) The daily time range during which automated backups are created. Format: hh24:mi-hh24:mi (in UTC). Must be at least 30 minutes. Can not conflict with PreferredMaintenanceWindow setting.
	*/
	public void setPreferredBackupWindow(String value) {
		this.inputs.setInput("PreferredBackupWindow", value);
	}


	/** 
	Set the value of the PreferredMaintenanceWindow input for this Choreo. 

	@param String - (optional, string) The weekly time range (in UTC) during which system maintenance can occur, which may result in an outage. Format: ddd:hh24:mi-ddd:hh24:mi. Valid Days: Mon | Tue | Wed | Thu | Fri | Sat | Sun.
	*/
	public void setPreferredMaintenanceWindow(String value) {
		this.inputs.setInput("PreferredMaintenanceWindow", value);
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
	public ModifyDBInstanceResultSet run() {
		JSONObject result = super.runWithResults();
		return new ModifyDBInstanceResultSet(result);
	}
	
}
