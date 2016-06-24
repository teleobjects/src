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
AuthorizeDBSecurityGroupIngress

Allows restricted access to your database instance by adding EC2 Security Groups to the DBSecurityGroup or by specifying an allowed IP range.
*/
public class AuthorizeDBSecurityGroupIngress extends Choreography {

	/**
	Create a new instance of the AuthorizeDBSecurityGroupIngress Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AuthorizeDBSecurityGroupIngress(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/RDS/AuthorizeDBSecurityGroupIngress"));
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
	Set the value of the CIDRIP input for this Choreo. 

	@param String - (conditional, string) IP range that should have access. Required unless EC2SecurityGroupName and EC2SecurityGroupOwnerId are used.
	*/
	public void setCIDRIP(String value) {
		this.inputs.setInput("CIDRIP", value);
	}


	/** 
	Set the value of the DBSecurityGroupName input for this Choreo. 

	@param String - (required, string) A unique name for the security group you want to authorize.
	*/
	public void setDBSecurityGroupName(String value) {
		this.inputs.setInput("DBSecurityGroupName", value);
	}


	/** 
	Set the value of the EC2SecurityGroupId input for this Choreo. 

	@param String - (conditional, string) The ID of the EC2 security group to authorize. For VPC DB security groups, this is required. Otherwise, EC2SecurityGroupOwnerId and either EC2SecurityGroupName or EC2SecurityGroupId must be provided.
	*/
	public void setEC2SecurityGroupId(String value) {
		this.inputs.setInput("EC2SecurityGroupId", value);
	}


	/** 
	Set the value of the EC2SecurityGroupName input for this Choreo. 

	@param String - (conditional, string) The EC2 security group to authorize. This and EC2SecurityGroupOwnerId are required if CIDRIP is not used.
	*/
	public void setEC2SecurityGroupName(String value) {
		this.inputs.setInput("EC2SecurityGroupName", value);
	}


	/** 
	Set the value of the EC2SecurityGroupOwnerId input for this Choreo. 

	@param String - (conditional, string) The AWS account number for the security group owner. This and EC2SecurityGroupName are required if CIDRIP is not used.
	*/
	public void setEC2SecurityGroupOwnerId(String value) {
		this.inputs.setInput("EC2SecurityGroupOwnerId", value);
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
	public AuthorizeDBSecurityGroupIngressResultSet run() {
		JSONObject result = super.runWithResults();
		return new AuthorizeDBSecurityGroupIngressResultSet(result);
	}
	
}
