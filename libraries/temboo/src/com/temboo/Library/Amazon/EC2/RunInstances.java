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
RunInstances

Calls the Amazon EC2 API to launch the specified number of instances of an AMI for which you have permissions.
*/
public class RunInstances extends Choreography {

	/**
	Create a new instance of the RunInstances Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RunInstances(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/EC2/RunInstances"));
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
	Set the value of the DeleteOnTermination input for this Choreo. 

	@param Boolean - (optional, boolean) Sets whether the volume is deleted on instance termination. Defaults to "true". This is a Block Device Mapping parameter.
	*/
	public void setDeleteOnTermination(Boolean value) {
		this.inputs.setInput("DeleteOnTermination", value);
	}

	/** 
	Set the value of the DeleteOnTermination input for this Choreo as a String. 

	@param String - (optional, boolean) Sets whether the volume is deleted on instance termination. Defaults to "true". This is a Block Device Mapping parameter.
	*/
	public void setDeleteOnTermination(String value) {
		this.inputs.setInput("DeleteOnTermination", value);	
	}
	/** 
	Set the value of the DeviceName input for this Choreo. 

	@param String - (optional, string) The device name exposed to the instance (i.e. /dev/sdh or xvdh). This is a Block Device Mapping parameter.
	*/
	public void setDeviceName(String value) {
		this.inputs.setInput("DeviceName", value);
	}


	/** 
	Set the value of the ImageId input for this Choreo. 

	@param String - (required, string) The ID of the AMI.
	*/
	public void setImageId(String value) {
		this.inputs.setInput("ImageId", value);
	}


	/** 
	Set the value of the InstanceType input for this Choreo. 

	@param String - (optional, string) The instance type (i.e. t1.micro, m1.small, m1.medium, m1.large, m1.xlarge). Default is m1.small.
	*/
	public void setInstanceType(String value) {
		this.inputs.setInput("InstanceType", value);
	}


	/** 
	Set the value of the Iops input for this Choreo. 

	@param Integer - (optional, integer) The number of I/O operations per second (IOPS) that the volume supports. Valid range is 100 to 2000. This is a Block Device Mapping parameter.
	*/
	public void setIops(Integer value) {
		this.inputs.setInput("Iops", value);
	}

	/** 
	Set the value of the Iops input for this Choreo as a String. 

	@param String - (optional, integer) The number of I/O operations per second (IOPS) that the volume supports. Valid range is 100 to 2000. This is a Block Device Mapping parameter.
	*/
	public void setIops(String value) {
		this.inputs.setInput("Iops", value);	
	}
	/** 
	Set the value of the KernelId input for this Choreo. 

	@param String - (optional, string) The ID of the kernel with which to launch the instance.
	*/
	public void setKernelId(String value) {
		this.inputs.setInput("KernelId", value);
	}


	/** 
	Set the value of the KeyName input for this Choreo. 

	@param String - (optional, string) The name of the key pair to use.
	*/
	public void setKeyName(String value) {
		this.inputs.setInput("KeyName", value);
	}


	/** 
	Set the value of the MaxCount input for this Choreo. 

	@param Integer - (required, integer) The maximum number of instances to launch. If the value is more than Amazon EC2 can launch, the largest possible number above MinCount will be launched instead.
	*/
	public void setMaxCount(Integer value) {
		this.inputs.setInput("MaxCount", value);
	}

	/** 
	Set the value of the MaxCount input for this Choreo as a String. 

	@param String - (required, integer) The maximum number of instances to launch. If the value is more than Amazon EC2 can launch, the largest possible number above MinCount will be launched instead.
	*/
	public void setMaxCount(String value) {
		this.inputs.setInput("MaxCount", value);	
	}
	/** 
	Set the value of the MinCount input for this Choreo. 

	@param Integer - (required, integer) The minimum number of instances to launch. If the value is more than Amazon EC2 can launch, no instances are launched at all.
	*/
	public void setMinCount(Integer value) {
		this.inputs.setInput("MinCount", value);
	}

	/** 
	Set the value of the MinCount input for this Choreo as a String. 

	@param String - (required, integer) The minimum number of instances to launch. If the value is more than Amazon EC2 can launch, no instances are launched at all.
	*/
	public void setMinCount(String value) {
		this.inputs.setInput("MinCount", value);	
	}
	/** 
	Set the value of the MonitoringEnabled input for this Choreo. 

	@param Boolean - (optional, boolean) Enables monitoring for the instance. Defaults to false.
	*/
	public void setMonitoringEnabled(Boolean value) {
		this.inputs.setInput("MonitoringEnabled", value);
	}

	/** 
	Set the value of the MonitoringEnabled input for this Choreo as a String. 

	@param String - (optional, boolean) Enables monitoring for the instance. Defaults to false.
	*/
	public void setMonitoringEnabled(String value) {
		this.inputs.setInput("MonitoringEnabled", value);	
	}
	/** 
	Set the value of the NoDevice input for this Choreo. 

	@param Boolean - (optional, boolean) Suppresses a device mapping. This is a Block Device Mapping parameter.
	*/
	public void setNoDevice(Boolean value) {
		this.inputs.setInput("NoDevice", value);
	}

	/** 
	Set the value of the NoDevice input for this Choreo as a String. 

	@param String - (optional, boolean) Suppresses a device mapping. This is a Block Device Mapping parameter.
	*/
	public void setNoDevice(String value) {
		this.inputs.setInput("NoDevice", value);	
	}
	/** 
	Set the value of the PlacementAvailabilityZone input for this Choreo. 

	@param String - (optional, string) The Availability Zone to launch the instance into.
	*/
	public void setPlacementAvailabilityZone(String value) {
		this.inputs.setInput("PlacementAvailabilityZone", value);
	}


	/** 
	Set the value of the PlacementGroupName input for this Choreo. 

	@param String - (optional, string) The name of an existing placement group you want to launch the instance into (for cluster instances).
	*/
	public void setPlacementGroupName(String value) {
		this.inputs.setInput("PlacementGroupName", value);
	}


	/** 
	Set the value of the PlacementTenancy input for this Choreo. 

	@param String - (optional, string) The tenancy of the instance. When set to "dedicated", the instance will run on single-tenant hardware and can only be launched into a VPC.
	*/
	public void setPlacementTenancy(String value) {
		this.inputs.setInput("PlacementTenancy", value);
	}


	/** 
	Set the value of the RamdiskId input for this Choreo. 

	@param String - (optional, string) The ID of the RAM disk.
	*/
	public void setRamdiskId(String value) {
		this.inputs.setInput("RamdiskId", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SecurityGroup input for this Choreo. 

	@param String - (optional, string) One or more security group names. This can be a comma-separated list of up to 10 security group names.
	*/
	public void setSecurityGroup(String value) {
		this.inputs.setInput("SecurityGroup", value);
	}


	/** 
	Set the value of the SecurityGroupId input for this Choreo. 

	@param String - (optional, string) One or more security group IDs. This can be a comma-separated list of up to 10 security group ids.
	*/
	public void setSecurityGroupId(String value) {
		this.inputs.setInput("SecurityGroupId", value);
	}


	/** 
	Set the value of the ShutdownBehavior input for this Choreo. 

	@param String - (optional, string) Whether the instance stops or terminates on instance-initiated shutdown. Valid values are: stop and terminate.
	*/
	public void setShutdownBehavior(String value) {
		this.inputs.setInput("ShutdownBehavior", value);
	}


	/** 
	Set the value of the SnapshotId input for this Choreo. 

	@param String - (optional, string) The ID of the snapshot. This is a Block Device Mapping parameter.
	*/
	public void setSnapshotId(String value) {
		this.inputs.setInput("SnapshotId", value);
	}


	/** 
	Set the value of the SubnetId input for this Choreo. 

	@param String - (optional, string) The ID of the subnet to launch the instance into (i.e. subnet-dea63cb7).
	*/
	public void setSubnetId(String value) {
		this.inputs.setInput("SubnetId", value);
	}


	/** 
	Set the value of the UserData input for this Choreo. 

	@param String - (optional, string) The Base64-encoded MIME user data to be made available to the instance(s).
	*/
	public void setUserData(String value) {
		this.inputs.setInput("UserData", value);
	}


	/** 
	Set the value of the UserRegion input for this Choreo. 

	@param String - (optional, string) The AWS region that corresponds to the EC2 endpoint you wish to access. The default region is "us-east-1". See description below for valid values.
	*/
	public void setUserRegion(String value) {
		this.inputs.setInput("UserRegion", value);
	}


	/** 
	Set the value of the VirtualName input for this Choreo. 

	@param String - (optional, string) The name of the virtual device. This is a Block Device Mapping parameter.
	*/
	public void setVirtualName(String value) {
		this.inputs.setInput("VirtualName", value);
	}


	/** 
	Set the value of the VolumeSize input for this Choreo. 

	@param String - (optional, string) The size of the volume, in GiBs. Required unless you're creating the volume from a snapshot which indicates that the size will be the size of the snapshot. This is a Block Device Mapping parameter.
	*/
	public void setVolumeSize(String value) {
		this.inputs.setInput("VolumeSize", value);
	}


	/** 
	Set the value of the VolumeType input for this Choreo. 

	@param String - (optional, string) The volume type. Valid values are: standard (the default) and io1. This is a Block Device Mapping parameter.
	*/
	public void setVolumeType(String value) {
		this.inputs.setInput("VolumeType", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RunInstancesResultSet run() {
		JSONObject result = super.runWithResults();
		return new RunInstancesResultSet(result);
	}
	
}
