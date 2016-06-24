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
RevokeDBSecurityGroupIngress

Revokes access from a DBSecurityGroup for previously authorized IP ranges or EC2 Security Groups.
*/
public class RevokeDBSecurityGroupIngress extends Choreography {

	/**
	Create a new instance of the RevokeDBSecurityGroupIngress Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RevokeDBSecurityGroupIngress(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/RDS/RevokeDBSecurityGroupIngress"));
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

	@param String - (conditional, string) IP range that should be revoked. Required unless EC2SecurityGroupName and EC2SecurityGroupOwnerId are used.
	*/
	public void setCIDRIP(String value) {
		this.inputs.setInput("CIDRIP", value);
	}


	/** 
	Set the value of the DBSecurityGroupName input for this Choreo. 

	@param String - (required, string) A unique name for the security group you want to revoke ingress from.
	*/
	public void setDBSecurityGroupName(String value) {
		this.inputs.setInput("DBSecurityGroupName", value);
	}


	/** 
	Set the value of the EC2SecurityGroupName input for this Choreo. 

	@param String - (conditional, string) The EC2 security group to revoke. This and EC2SecurityGroupOwnerId are required if CIDRIP is not used.
	*/
	public void setEC2SecurityGroupName(String value) {
		this.inputs.setInput("EC2SecurityGroupName", value);
	}


	/** 
	Set the value of the EC2SecurityGroupOwnerId input for this Choreo. 

	@param String - (conditional, string) The account number for the security group owner to revoke. This and EC2SecurityGroupName are required if CIDRIP is not used.
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
	public RevokeDBSecurityGroupIngressResultSet run() {
		JSONObject result = super.runWithResults();
		return new RevokeDBSecurityGroupIngressResultSet(result);
	}
	
}
