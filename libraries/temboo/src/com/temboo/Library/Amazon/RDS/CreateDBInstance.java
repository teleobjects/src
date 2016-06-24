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
CreateDBInstance

Creates a new database instance.
*/
public class CreateDBInstance extends Choreography {

	/**
	Create a new instance of the CreateDBInstance Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateDBInstance(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/RDS/CreateDBInstance"));
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

	@param Integer - (required, integer) Storage amount (in gigabytes) to be configured for the DB. Use 5 to 1024 for MySQL , 10 to 1024 for Oracle, or 200 to 1024 for SQLServer.
	*/
	public void setAllocatedStorage(Integer value) {
		this.inputs.setInput("AllocatedStorage", value);
	}

	/** 
	Set the value of the AllocatedStorage input for this Choreo as a String. 

	@param String - (required, integer) Storage amount (in gigabytes) to be configured for the DB. Use 5 to 1024 for MySQL , 10 to 1024 for Oracle, or 200 to 1024 for SQLServer.
	*/
	public void setAllocatedStorage(String value) {
		this.inputs.setInput("AllocatedStorage", value);	
	}
	/** 
	Set the value of the AutoMinorVersionUpgrade input for this Choreo. 

	@param Boolean - (optional, boolean) Indicates that minor engine upgrades will be applied to the DB Instance automatically during the maintenance window.
	*/
	public void setAutoMinorVersionUpgrade(Boolean value) {
		this.inputs.setInput("AutoMinorVersionUpgrade", value);
	}

	/** 
	Set the value of the AutoMinorVersionUpgrade input for this Choreo as a String. 

	@param String - (optional, boolean) Indicates that minor engine upgrades will be applied to the DB Instance automatically during the maintenance window.
	*/
	public void setAutoMinorVersionUpgrade(String value) {
		this.inputs.setInput("AutoMinorVersionUpgrade", value);	
	}
	/** 
	Set the value of the AvailabilityZone input for this Choreo. 

	@param String - (optional, string) The EC2 Availability Zone that the database instance will be created in (e.g. us-east-1a, us-east-1b, us-east-1c).
	*/
	public void setAvailabilityZone(String value) {
		this.inputs.setInput("AvailabilityZone", value);
	}


	/** 
	Set the value of the BackupRetentionPeriod input for this Choreo. 

	@param Integer - (optional, integer) The number of days for which automated backups are retained. When set to a positive number, backups are enabled. Set to 0 to disable automated backups.
	*/
	public void setBackupRetentionPeriod(Integer value) {
		this.inputs.setInput("BackupRetentionPeriod", value);
	}

	/** 
	Set the value of the BackupRetentionPeriod input for this Choreo as a String. 

	@param String - (optional, integer) The number of days for which automated backups are retained. When set to a positive number, backups are enabled. Set to 0 to disable automated backups.
	*/
	public void setBackupRetentionPeriod(String value) {
		this.inputs.setInput("BackupRetentionPeriod", value);	
	}
	/** 
	Set the value of the CharacterSetName input for this Choreo. 

	@param String - (optional, string) Indicates that the DB Instance should be associated with the specified CharacterSet.
	*/
	public void setCharacterSetName(String value) {
		this.inputs.setInput("CharacterSetName", value);
	}


	/** 
	Set the value of the DBInstanceClass input for this Choreo. 

	@param String - (required, string) Capacity for the DB instance.  (db.t1.micro, db.m1.small, db.m1.large, db.m1.xlarge, db.m2.xlarge, db.m2.2xlarge, or db.m2.4xlarge).
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
	Set the value of the DBName input for this Choreo. 

	@param String - (conditional, string) For MySQL, this is the name of the db that is created on the instance. For Oracle, it refers to the SID. Must be null for SQLServer.
	*/
	public void setDBName(String value) {
		this.inputs.setInput("DBName", value);
	}


	/** 
	Set the value of the DBParameterGroupName input for this Choreo. 

	@param String - (optional, string) The name of the DB Parameter Group to associate with this DB instance. If this argument is omitted, the default DBParameterGroup for the specified engine will be used.
	*/
	public void setDBParameterGroupName(String value) {
		this.inputs.setInput("DBParameterGroupName", value);
	}


	/** 
	Set the value of the DBSecurityGroups input for this Choreo. 

	@param String - (optional, string) A comma separated list of up to 10 DB Security Groups to associate with this DB Instance.
	*/
	public void setDBSecurityGroups(String value) {
		this.inputs.setInput("DBSecurityGroups", value);
	}


	/** 
	Set the value of the DBSubnetGroupName input for this Choreo. 

	@param String - (optional, string) A DB Subnet Group to associate with this DB Instance. When not specified, it indicates that this is a non-VPC DB instance.
	*/
	public void setDBSubnetGroupName(String value) {
		this.inputs.setInput("DBSubnetGroupName", value);
	}


	/** 
	Set the value of the Engine input for this Choreo. 

	@param String - (required, string) The name of the database engine to use for the instance. Options are: MySQL, oracle-se1, oracle-se, oracle-ee, sqlserver-ee, sqlserver-se, sqlserver-ex, sqlserver-web.
	*/
	public void setEngine(String value) {
		this.inputs.setInput("Engine", value);
	}


	/** 
	Set the value of the EngineVersion input for this Choreo. 

	@param String - (optional, string) The version number of the database engine to use.
	*/
	public void setEngineVersion(String value) {
		this.inputs.setInput("EngineVersion", value);
	}


	/** 
	Set the value of the Iops input for this Choreo. 

	@param String - (optional, string) The amount of provisioned input/output operations per second to be initially allocated for the DB Instance.
	*/
	public void setIops(String value) {
		this.inputs.setInput("Iops", value);
	}


	/** 
	Set the value of the LicenseModel input for this Choreo. 

	@param String - (optional, string) License model information for this DB Instance. Valid values are: license-included, bring-your-own-license, general-public-license.
	*/
	public void setLicenseModel(String value) {
		this.inputs.setInput("LicenseModel", value);
	}


	/** 
	Set the value of the MasterUserPassword input for this Choreo. 

	@param String - (required, password) The master password for the DB instance.
	*/
	public void setMasterUserPassword(String value) {
		this.inputs.setInput("MasterUserPassword", value);
	}


	/** 
	Set the value of the MasterUsername input for this Choreo. 

	@param String - (required, string) The master username for the DB instance.
	*/
	public void setMasterUsername(String value) {
		this.inputs.setInput("MasterUsername", value);
	}


	/** 
	Set the value of the MultiAZ input for this Choreo. 

	@param Boolean - (optional, boolean) Specifies if the DB Instance is a Multi-AZ deployment. You cannot set the AvailabilityZone parameter if the MultiAZ parameter is set to true.
	*/
	public void setMultiAZ(Boolean value) {
		this.inputs.setInput("MultiAZ", value);
	}

	/** 
	Set the value of the MultiAZ input for this Choreo as a String. 

	@param String - (optional, boolean) Specifies if the DB Instance is a Multi-AZ deployment. You cannot set the AvailabilityZone parameter if the MultiAZ parameter is set to true.
	*/
	public void setMultiAZ(String value) {
		this.inputs.setInput("MultiAZ", value);	
	}
	/** 
	Set the value of the OptionGroupName input for this Choreo. 

	@param String - (optional, string) Indicates that the DB Instance should be associated with the specified option group.
	*/
	public void setOptionGroupName(String value) {
		this.inputs.setInput("OptionGroupName", value);
	}


	/** 
	Set the value of the Port input for this Choreo. 

	@param Integer - (optional, integer) The port number on which the database accepts connections. Valid range for MySQL is 1150-65535. Valid range for Oracle is 1150-65535. Valid range for SQLServer is 1150-65535 except for 1434 and 3389.
	*/
	public void setPort(Integer value) {
		this.inputs.setInput("Port", value);
	}

	/** 
	Set the value of the Port input for this Choreo as a String. 

	@param String - (optional, integer) The port number on which the database accepts connections. Valid range for MySQL is 1150-65535. Valid range for Oracle is 1150-65535. Valid range for SQLServer is 1150-65535 except for 1434 and 3389.
	*/
	public void setPort(String value) {
		this.inputs.setInput("Port", value);	
	}
	/** 
	Set the value of the PreferredBackupWindow input for this Choreo. 

	@param String - (optional, string) The daily time range during which automated backups are created if automated backups are enabled, using the BackupRetentionPeriod parameter. Must be in the format hh24:mi-hh24:mi (in UTC).
	*/
	public void setPreferredBackupWindow(String value) {
		this.inputs.setInput("PreferredBackupWindow", value);
	}


	/** 
	Set the value of the PreferredMaintenanceWindow input for this Choreo. 

	@param String - (optional, string) The weekly time range (in UTC) during which system maintenance can occur. Format: ddd:hh24:mi-ddd:hh24:mi.
	*/
	public void setPreferredMaintenanceWindow(String value) {
		this.inputs.setInput("PreferredMaintenanceWindow", value);
	}


	/** 
	Set the value of the PubliclyAccessible input for this Choreo. 

	@param Boolean - (optional, boolean) Specifies the accessibility options for the DB Instance. The default behavior varies depending on whether a VPC has been requested or not.
	*/
	public void setPubliclyAccessible(Boolean value) {
		this.inputs.setInput("PubliclyAccessible", value);
	}

	/** 
	Set the value of the PubliclyAccessible input for this Choreo as a String. 

	@param String - (optional, boolean) Specifies the accessibility options for the DB Instance. The default behavior varies depending on whether a VPC has been requested or not.
	*/
	public void setPubliclyAccessible(String value) {
		this.inputs.setInput("PubliclyAccessible", value);	
	}
	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (optional, string) The AWS region that corresponds to the RDS endpoint you wish to access. The default region is "us-east-1". See description below for valid values.
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	/** 
	Set the value of the VpcSecurityGroupIds input for this Choreo. 

	@param String - (optional, string) A comma separated list of up to 10 EC2 VPC Security Groups to associate with this DB Instance.
	*/
	public void setVpcSecurityGroupIds(String value) {
		this.inputs.setInput("VpcSecurityGroupIds", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateDBInstanceResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateDBInstanceResultSet(result);
	}
	
}
