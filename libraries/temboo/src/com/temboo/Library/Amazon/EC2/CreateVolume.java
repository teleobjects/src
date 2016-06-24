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
CreateVolume

Calls the Amazon EC2 API to create a new EBS volume that your EC2 instance can attach to.
*/
public class CreateVolume extends Choreography {

	/**
	Create a new instance of the CreateVolume Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public CreateVolume(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/EC2/CreateVolume"));
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
	Set the value of the AvailabilityZone input for this Choreo. 

	@param String - (required, string) The Availability Zone to use when creating thew new volume (i.e us-east-1a).
	*/
	public void setAvailabilityZone(String value) {
		this.inputs.setInput("AvailabilityZone", value);
	}


	/** 
	Set the value of the Iops input for this Choreo. 

	@param Integer - (optional, integer) The number of I/O operations per second (IOPS) that the volume supports. Valid range is 100 to 2000. Required when the volume type is io1.
	*/
	public void setIops(Integer value) {
		this.inputs.setInput("Iops", value);
	}

	/** 
	Set the value of the Iops input for this Choreo as a String. 

	@param String - (optional, integer) The number of I/O operations per second (IOPS) that the volume supports. Valid range is 100 to 2000. Required when the volume type is io1.
	*/
	public void setIops(String value) {
		this.inputs.setInput("Iops", value);	
	}
	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the Size input for this Choreo. 

	@param Integer - (conditional, integer) The size for the volume (in gigabytes) that you are creating. Valid Values are 1-1024. Required if you're not creating a volume from a snapshot. If the volume type is io1, the min size is 10 GiB.
	*/
	public void setSize(Integer value) {
		this.inputs.setInput("Size", value);
	}

	/** 
	Set the value of the Size input for this Choreo as a String. 

	@param String - (conditional, integer) The size for the volume (in gigabytes) that you are creating. Valid Values are 1-1024. Required if you're not creating a volume from a snapshot. If the volume type is io1, the min size is 10 GiB.
	*/
	public void setSize(String value) {
		this.inputs.setInput("Size", value);	
	}
	/** 
	Set the value of the SnapshotId input for this Choreo. 

	@param String - (conditional, string) The snapshot from which to create the new volume. Required if you are creating a volume from a snapshot.
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
	Set the value of the VolumeType input for this Choreo. 

	@param String - (optional, string) The volume type.Valid values are: "standard" (the default) and "io1".
	*/
	public void setVolumeType(String value) {
		this.inputs.setInput("VolumeType", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public CreateVolumeResultSet run() {
		JSONObject result = super.runWithResults();
		return new CreateVolumeResultSet(result);
	}
	
}
