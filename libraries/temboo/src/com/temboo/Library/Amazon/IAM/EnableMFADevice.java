package com.temboo.Library.Amazon.IAM;

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
EnableMFADevice

Enables the specified MFA device and associates it with the specified user name. When enabled, the MFA device is required for every subsequent login by the user name associated with the device.
*/
public class EnableMFADevice extends Choreography {

	/**
	Create a new instance of the EnableMFADevice Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public EnableMFADevice(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Amazon/IAM/EnableMFADevice"));
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
	Set the value of the AuthenticationCode1 input for this Choreo. 

	@param String - (required, string) An authentication code emitted by the device.
	*/
	public void setAuthenticationCode1(String value) {
		this.inputs.setInput("AuthenticationCode1", value);
	}


	/** 
	Set the value of the AuthenticationCode2 input for this Choreo. 

	@param String - (required, string) A subsequent authentication code emitted by the device.
	*/
	public void setAuthenticationCode2(String value) {
		this.inputs.setInput("AuthenticationCode2", value);
	}


	/** 
	Set the value of the ResponseFormat input for this Choreo. 

	@param String - (optional, string) The format that the response should be in. Valid values are "xml" (the default) and "json".
	*/
	public void setResponseFormat(String value) {
		this.inputs.setInput("ResponseFormat", value);
	}


	/** 
	Set the value of the SerialNumber input for this Choreo. 

	@param String - (required, string) The serial number that uniquely identifies the MFA device. For virtual MFA devices, the serial number is the same as the ARN.
	*/
	public void setSerialNumber(String value) {
		this.inputs.setInput("SerialNumber", value);
	}


	/** 
	Set the value of the UserName input for this Choreo. 

	@param String - (required, string) Name of the user for whom you want to enable the MFA device.
	*/
	public void setUserName(String value) {
		this.inputs.setInput("UserName", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public EnableMFADeviceResultSet run() {
		JSONObject result = super.runWithResults();
		return new EnableMFADeviceResultSet(result);
	}
	
}
