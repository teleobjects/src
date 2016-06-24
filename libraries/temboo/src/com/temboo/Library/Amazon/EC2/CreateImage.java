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
CreateImage

Creates an Amazon Machine Image from an Amazon EBS-backed instance using the Amazon EC2 API. The image can be used later to launch other identical servers.
*/
public class CreateImage extends Choreography {

	/**
	Create a new instance of the CreateImage Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateImage(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/EC2/CreateImage"));
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

	@param Boolean - (optional, boolean) Whether the volume is deleted on instance termination. Defaults to "true".
	*/
	public void setDeleteOnTermination(Boolean value) {
		this.inputs.setInput("DeleteOnTermination", value);
	}

	/** 
	Set the value of the DeleteOnTermination input for this Choreo as a String. 

	@param String - (optional, boolean) Whether the volume is deleted on instance termination. Defaults to "true".
	*/
	public void setDeleteOnTermination(String value) {
		this.inputs.setInput("DeleteOnTermination", value);	
	}
	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) A description for the image you want to create.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the DeviceName input for this Choreo. 

	@param String - (conditional, string) The device name exposed to the instance (i.e. /dev/sdh or xvdh). When registering an AMI from a snapshot, DiviceName is required as well as SnapshotId.
	*/
	public void setDeviceName(String value) {
		this.inputs.setInput("DeviceName", value);
	}


	/** 
	Set the value of the InstanceId input for this Choreo. 

	@param String - (required, string) The ID of the instance to create the image on.
	*/
	public void setInstanceId(String value) {
		this.inputs.setInput("InstanceId", value);
	}


	/** 
	Set the value of the Iops input for this Choreo. 

	@param Integer - (conditional, integer) The number of I/O operations per second (IOPS) that the volume supports. Valid range is 100 to 2000.
	*/
	public void setIops(Integer value) {
		this.inputs.setInput("Iops", value);
	}

	/** 
	Set the value of the Iops input for this Choreo as a String. 

	@param String - (conditional, integer) The number of I/O operations per second (IOPS) that the volume supports. Valid range is 100 to 2000.
	*/
	public void setIops(String value) {
		this.inputs.setInput("Iops", value);	
	}
	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) The name for the image you are creating.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the NoDevice input for this Choreo. 

	@param Boolean - (optional, boolean) Suppresses a device mapping. Defaults to "true".
	*/
	public void setNoDevice(Boolean value) {
		this.inputs.setInput("NoDevice", value);
	}

	/** 
	Set the value of the NoDevice input for this Choreo as a String. 

	@param String - (optional, boolean) Suppresses a device mapping. Defaults to "true".
	*/
	public void setNoDevice(String value) {
		this.inputs.setInput("NoDevice", value);	
	}
	/** 
	Set the value of the NoReboot input for this Choreo. 

	@param Boolean - (optional, boolean) Defaults to "false". Amazon EC2 will attempt to shut down the instance before and after creating the image. Set to "true" for NoReboot.
	*/
	public void setNoReboot(Boolean value) {
		this.inputs.setInput("NoReboot", value);
	}

	/** 
	Set the value of the NoReboot input for this Choreo as a String. 

	@param String - (optional, boolean) Defaults to "false". Amazon EC2 will attempt to shut down the instance before and after creating the image. Set to "true" for NoReboot.
	*/
	public void setNoReboot(String value) {
		this.inputs.setInput("NoReboot", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SnapshotId input for this Choreo. 

	@param String - (conditional, string) The ID of the snapshot. Required when registering from a snapshot. You must also specify DeviceName with the root device name.
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

	@param String - (optional, string) The name of the virtual device.
	*/
	public void setVirtualName(String value) {
		this.inputs.setInput("VirtualName", value);
	}


	/** 
	Set the value of the VolumeSize input for this Choreo. 

	@param String - (conditional, string) The size of the volume, in GiBs. Required unless you're creating the volume from a snapshot which indicates that the size will be the size of the snapshot.
	*/
	public void setVolumeSize(String value) {
		this.inputs.setInput("VolumeSize", value);
	}


	/** 
	Set the value of the VolumeType input for this Choreo. 

	@param String - (optional, string) The volume type. Valid values are: standard (the default) and io1.
	*/
	public void setVolumeType(String value) {
		this.inputs.setInput("VolumeType", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateImageResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateImageResultSet(result);
	}
	
}
