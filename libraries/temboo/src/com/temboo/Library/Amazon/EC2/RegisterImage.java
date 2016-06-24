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
RegisterImage

Registers a new AMI with Amazon EC2 using the Amazon EC2 API.
*/
public class RegisterImage extends Choreography {

	/**
	Create a new instance of the RegisterImage Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public RegisterImage(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/EC2/RegisterImage"));
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
	Set the value of the Architecture input for this Choreo. 

	@param String - (optional, string) The architecture of the image. Valid values are: i386 or x86_64. Defaults to i386.
	*/
	public void setArchitecture(String value) {
		this.inputs.setInput("Architecture", value);
	}


	/** 
	Set the value of the DeleteOnTermination input for this Choreo. 

	@param Boolean - (optional, boolean) Whether the Amazon EBS volume is deleted on instance termination. Defaults to true.
	*/
	public void setDeleteOnTermination(Boolean value) {
		this.inputs.setInput("DeleteOnTermination", value);
	}

	/** 
	Set the value of the DeleteOnTermination input for this Choreo as a String. 

	@param String - (optional, boolean) Whether the Amazon EBS volume is deleted on instance termination. Defaults to true.
	*/
	public void setDeleteOnTermination(String value) {
		this.inputs.setInput("DeleteOnTermination", value);	
	}
	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) The description of the AMI.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the DeviceName input for this Choreo. 

	@param String - (conditional, string) If registering an Amazon EBS-backed AMI from a snapshot, specify this input with the root device name (e.g., /dev/sda1, or xvda), and SnapshotId.
	*/
	public void setDeviceName(String value) {
		this.inputs.setInput("DeviceName", value);
	}


	/** 
	Set the value of the ImageLocation input for this Choreo. 

	@param String - (conditional, string) Full path to your AMI manifest in Amazon S3 storage. Required if registering an Amazon-S3 backed AMI.
	*/
	public void setImageLocation(String value) {
		this.inputs.setInput("ImageLocation", value);
	}


	/** 
	Set the value of the Iops input for this Choreo. 

	@param Integer - (conditional, integer) The number of I/O operations per second (IOPS) that the volume supports. A valid range is: 100 to 2000.
	*/
	public void setIops(Integer value) {
		this.inputs.setInput("Iops", value);
	}

	/** 
	Set the value of the Iops input for this Choreo as a String. 

	@param String - (conditional, integer) The number of I/O operations per second (IOPS) that the volume supports. A valid range is: 100 to 2000.
	*/
	public void setIops(String value) {
		this.inputs.setInput("Iops", value);	
	}
	/** 
	Set the value of the KernelId input for this Choreo. 

	@param String - (optional, string) The ID of the kernel to select.
	*/
	public void setKernelId(String value) {
		this.inputs.setInput("KernelId", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) A name for your AMI.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the NoDevice input for this Choreo. 

	@param Boolean - (optional, boolean) Specifies that no device should be mapped. Defaults to 1 (true).
	*/
	public void setNoDevice(Boolean value) {
		this.inputs.setInput("NoDevice", value);
	}

	/** 
	Set the value of the NoDevice input for this Choreo as a String. 

	@param String - (optional, boolean) Specifies that no device should be mapped. Defaults to 1 (true).
	*/
	public void setNoDevice(String value) {
		this.inputs.setInput("NoDevice", value);	
	}
	/** 
	Set the value of the RamdiskId input for this Choreo. 

	@param String - (optional, string) The ID of the RAM disk to select.
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
	Set the value of the RootDeviceName input for this Choreo. 

	@param String - (conditional, string) The root device name (e.g., /dev/sda1, or xvda). Required if registering an Amazon EBS-backed AMI.
	*/
	public void setRootDeviceName(String value) {
		this.inputs.setInput("RootDeviceName", value);
	}


	/** 
	Set the value of the SnapshotId input for this Choreo. 

	@param String - (conditional, string) If registering an Amazon EBS-backed AMI from a snapshot, you must at least specify this input with the snapshot ID, and DeviceName with the root device name.
	*/
	public void setSnapshotId(String value) {
		this.inputs.setInput("SnapshotId", value);
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

	@param String - (optional, string) The virtual device name.
	*/
	public void setVirtualName(String value) {
		this.inputs.setInput("VirtualName", value);
	}


	/** 
	Set the value of the VolumeSize input for this Choreo. 

	@param Integer - (conditional, integer) The size of the volume, in GiBs. Required if you are not creating a volume from a snapshot.
	*/
	public void setVolumeSize(Integer value) {
		this.inputs.setInput("VolumeSize", value);
	}

	/** 
	Set the value of the VolumeSize input for this Choreo as a String. 

	@param String - (conditional, integer) The size of the volume, in GiBs. Required if you are not creating a volume from a snapshot.
	*/
	public void setVolumeSize(String value) {
		this.inputs.setInput("VolumeSize", value);	
	}
	/** 
	Set the value of the VolumeType input for this Choreo. 

	@param String - (optional, string) The volume type. Valid values are: standard and io.
	*/
	public void setVolumeType(String value) {
		this.inputs.setInput("VolumeType", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public RegisterImageResultSet run() {
		JSONObject result = super.runWithResults();
		return new RegisterImageResultSet(result);
	}
	
}
