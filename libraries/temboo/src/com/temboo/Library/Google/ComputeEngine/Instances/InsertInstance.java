package com.temboo.Library.Google.ComputeEngine.Instances;

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
InsertInstance

Creates an Instance resource in the specified project.
*/
public class InsertInstance extends Choreography {

	/**
	Create a new instance of the InsertInstance Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public InsertInstance(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/ComputeEngine/Instances/InsertInstance"));
	}

	/** 
	Set the value of the InstanceResource input for this Choreo. 

	@param String - (optional, json) A JSON string containing the instance resource properties to set. This an be used as an alternative to individual inputs representing instance properties.
	*/
	public void setInstanceResource(String value) {
		this.inputs.setInput("InstanceResource", value);
	}


	/** 
	Set the value of the AccessToken input for this Choreo. 

	@param String - (optional, string) A valid access token retrieved during the OAuth process. This is required unless you provide the ClientID, ClientSecret, and RefreshToken to generate a new access token.
	*/
	public void setAccessToken(String value) {
		this.inputs.setInput("AccessToken", value);
	}


	/** 
	Set the value of the ClientID input for this Choreo. 

	@param String - (conditional, string) The Client ID provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientID(String value) {
		this.inputs.setInput("ClientID", value);
	}


	/** 
	Set the value of the ClientSecret input for this Choreo. 

	@param String - (conditional, string) The Client Secret provided by Google. Required unless providing a valid AccessToken.
	*/
	public void setClientSecret(String value) {
		this.inputs.setInput("ClientSecret", value);
	}


	/** 
	Set the value of the Description input for this Choreo. 

	@param String - (optional, string) The description of the instance.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the Disks input for this Choreo. 

	@param String - (conditional, json) An array of persistent disks. This array contains the following properties: source, type, and boot.
	*/
	public void setDisks(String value) {
		this.inputs.setInput("Disks", value);
	}


	/** 
	Set the value of the MachineType input for this Choreo. 

	@param String - (conditional, string) The fully-qualified URL of the machine type resource to use for this instance.
	*/
	public void setMachineType(String value) {
		this.inputs.setInput("MachineType", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (conditional, string) The name of the instance being created.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the NetworkInterfaces input for this Choreo. 

	@param String - (conditional, json) An array of network configurations for this instance. This array contains the following properties: network, accessConfigs[], accessConfigs[].name, and accessConfigs[].type.
	*/
	public void setNetworkInterfaces(String value) {
		this.inputs.setInput("NetworkInterfaces", value);
	}


	/** 
	Set the value of the Project input for this Choreo. 

	@param String - (required, string) The ID of a Google Compute project.
	*/
	public void setProject(String value) {
		this.inputs.setInput("Project", value);
	}


	/** 
	Set the value of the RefreshToken input for this Choreo. 

	@param String - (conditional, string) An OAuth refresh token used to generate a new access token when the original token is expired. Required unless providing a valid AccessToken.
	*/
	public void setRefreshToken(String value) {
		this.inputs.setInput("RefreshToken", value);
	}


	/** 
	Set the value of the Zone input for this Choreo. 

	@param String - (required, string) The name of the zone associated with this request.
	*/
	public void setZone(String value) {
		this.inputs.setInput("Zone", value);
	}


	
	/**
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public InsertInstanceResultSet run() {
		JSONObject result = super.runWithResults();
		return new InsertInstanceResultSet(result);
	}
	
}
