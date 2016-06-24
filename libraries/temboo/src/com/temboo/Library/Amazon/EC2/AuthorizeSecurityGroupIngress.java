package com.temboo.Library.Amazon.EC2;

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
AuthorizeSecurityGroupIngress

Adds an ingress rule to a security group using the Amazon EC2 API.
*/
public class AuthorizeSecurityGroupIngress extends Choreography {

	/**
	Create a new instance of the AuthorizeSecurityGroupIngress Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AuthorizeSecurityGroupIngress(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/EC2/AuthorizeSecurityGroupIngress"));
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
	Set the value of the GroupId input for this Choreo. 

	@param String - (conditional, string) The ID of the security group to modify. Can be used instead of GroupName.
	*/
	public void setGroupId(String value) {
		this.inputs.setInput("GroupId", value);
	}


	/** 
	Set the value of the GroupName input for this Choreo. 

	@param String - (conditional, string) The name of the security group to modify. Can be used instead of GroupId.
	*/
	public void setGroupName(String value) {
		this.inputs.setInput("GroupName", value);
	}


	/** 
	Set the value of the IpPermissionsCidrIp input for this Choreo. 

	@param String - (optional, string) The CIDR range. Cannot be used when specifying a source security group.
	*/
	public void setIpPermissionsCidrIp(String value) {
		this.inputs.setInput("IpPermissionsCidrIp", value);
	}


	/** 
	Set the value of the IpPermissionsFromPort input for this Choreo. 

	@param Integer - (optional, integer) The start of port range for the TCP and UDP protocols, or an ICMP type number. For the ICMP type number, you can use -1 to specify all ICMP types.
	*/
	public void setIpPermissionsFromPort(Integer value) {
		this.inputs.setInput("IpPermissionsFromPort", value);
	}

	/** 
	Set the value of the IpPermissionsFromPort input for this Choreo as a String. 

	@param String - (optional, integer) The start of port range for the TCP and UDP protocols, or an ICMP type number. For the ICMP type number, you can use -1 to specify all ICMP types.
	*/
	public void setIpPermissionsFromPort(String value) {
		this.inputs.setInput("IpPermissionsFromPort", value);	
	}
	/** 
	Set the value of the IpPermissionsGroupId input for this Choreo. 

	@param String - (optional, string) The ID of the source security group. Cannot be used when specifying a CIDR IP address.
	*/
	public void setIpPermissionsGroupId(String value) {
		this.inputs.setInput("IpPermissionsGroupId", value);
	}


	/** 
	Set the value of the IpPermissionsGroupName input for this Choreo. 

	@param String - (optional, string) The name of the source security group. Cannot be used when specifying a CIDR IP address.
	*/
	public void setIpPermissionsGroupName(String value) {
		this.inputs.setInput("IpPermissionsGroupName", value);
	}


	/** 
	Set the value of the IpPermissionsIpProtocol input for this Choreo. 

	@param String - (required, string) The IP protocol name or number. Valid values for EC2-Classic: tcp, udp, icmp (or 6, 17, 1). Valid values for EC2-VPC: tcp, udp, icmp, any valid protocol number (0-254), or -1 (to specify all).
	*/
	public void setIpPermissionsIpProtocol(String value) {
		this.inputs.setInput("IpPermissionsIpProtocol", value);
	}


	/** 
	Set the value of the IpPermissionsToPort input for this Choreo. 

	@param Integer - (optional, integer) The end of port range for the TCP and UDP protocols, or an ICMP code number. For the ICMP code number, you can use -1 to specify all ICMP codes for the given ICMP type.
	*/
	public void setIpPermissionsToPort(Integer value) {
		this.inputs.setInput("IpPermissionsToPort", value);
	}

	/** 
	Set the value of the IpPermissionsToPort input for this Choreo as a String. 

	@param String - (optional, integer) The end of port range for the TCP and UDP protocols, or an ICMP code number. For the ICMP code number, you can use -1 to specify all ICMP codes for the given ICMP type.
	*/
	public void setIpPermissionsToPort(String value) {
		this.inputs.setInput("IpPermissionsToPort", value);	
	}
	/** 
	Set the value of the IpPermissionsUserId input for this Choreo. 

	@param String - (optional, string) The AWS account ID that owns the source security group. Cannot be used when specifying a CIDR IP address.
	*/
	public void setIpPermissionsUserId(String value) {
		this.inputs.setInput("IpPermissionsUserId", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (optional, string) The AWS region that corresponds to the EC2 endpoint you wish to access. The default region is "us-east-1". See description below for valid values.
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public AuthorizeSecurityGroupIngressResultSet run() {
		JSONObject result = super.runWithResults();
		return new AuthorizeSecurityGroupIngressResultSet(result);
	}
	
}
