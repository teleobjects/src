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
AddAccessConfig

Adds an access config to an instance's network interface.
*/
public class AddAccessConfig extends Choreography {

	/**
	Create a new instance of the AddAccessConfig Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public AddAccessConfig(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/ComputeEngine/Instances/AddAccessConfig"));
	}

	/** 
	Set the value of the AccessConfiguration input for this Choreo. 

	@param String - (optional, json) A JSON string containing the access configuration properties you wish to set. This can be used as an alternative to individual inputs that represent access configuration properties.
	*/
	public void setAccessConfiguration(String value) {
		this.inputs.setInput("AccessConfiguration", value);
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
	Set the value of the Instance input for this Choreo. 

	@param String - (required, string) Name of the instance for which to add an access configuration.
	*/
	public void setInstance(String value) {
		this.inputs.setInput("Instance", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (optional, string) The name of this access configuration. Defaults to "External NAT" if not specified.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
	}


	/** 
	Set the value of the NatIP input for this Choreo. 

	@param String - (optional, string) An external IP address associated with this instance. Specify an unused static IP address available to the project. An external IP will be drawn from a shared ephemeral pool when not specified.
	*/
	public void setNatIP(String value) {
		this.inputs.setInput("NatIP", value);
	}


	/** 
	Set the value of the NetworkInterface input for this Choreo. 

	@param String - (required, string) The name of the network interface to add the access config (e.g. nic0, nic1, etc).
	*/
	public void setNetworkInterface(String value) {
		this.inputs.setInput("NetworkInterface", value);
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
	Set the value of the Type input for this Choreo. 

	@param String - (required, string) Type of configuration. Must be set to ONE_TO_ONE_NAT.
	*/
	public void setType(String value) {
		this.inputs.setInput("Type", value);
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
	public AddAccessConfigResultSet run() {
		JSONObject result = super.runWithResults();
		return new AddAccessConfigResultSet(result);
	}
	
}
