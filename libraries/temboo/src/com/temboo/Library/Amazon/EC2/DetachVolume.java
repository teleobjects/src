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
DetachVolume

Detaches an Amazon EBS volume from an instance using the Amazon EC2 API.
*/
public class DetachVolume extends Choreography {

	/**
	Create a new instance of the DetachVolume Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DetachVolume(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/EC2/DetachVolume"));
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
	Set the value of the Device input for this Choreo. 

	@param String - (optional, string) The device name.
	*/
	public void setDevice(String value) {
		this.inputs.setInput("Device", value);
	}


	/** 
	Set the value of the Force input for this Choreo. 

	@param Boolean - (required, boolean) Forces detachment if the previous detachment attempt did not occur cleanly. Use this option only as a last resort to detach a volume from a failed instance. Defaults to false.
	*/
	public void setForce(Boolean value) {
		this.inputs.setInput("Force", value);
	}

	/** 
	Set the value of the Force input for this Choreo as a String. 

	@param String - (required, boolean) Forces detachment if the previous detachment attempt did not occur cleanly. Use this option only as a last resort to detach a volume from a failed instance. Defaults to false.
	*/
	public void setForce(String value) {
		this.inputs.setInput("Force", value);	
	}
	/** 
	Set the value of the InstanceId input for this Choreo. 

	@param String - (optional, string) The ID of the instance.
	*/
	public void setInstanceId(String value) {
		this.inputs.setInput("InstanceId", value);
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
	Set the value of the VolumeId input for this Choreo. 

	@param String - (required, string) The ID of the volume.
	*/
	public void setVolumeId(String value) {
		this.inputs.setInput("VolumeId", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public DetachVolumeResultSet run() {
		JSONObject result = super.runWithResults();
		return new DetachVolumeResultSet(result);
	}
	
}
