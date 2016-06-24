package com.temboo.Library.Google.ComputeEngine.Networks;

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
InsertNetwork

Creates a new Network resource in the specified project.
*/
public class InsertNetwork extends Choreography {

	/**
	Create a new instance of the InsertNetwork Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public InsertNetwork(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/ComputeEngine/Networks/InsertNetwork"));
	}

	/** 
	Set the value of the NetworkResource input for this Choreo. 

	@param String - (optional, json) A JSON string containing the network resource properties you wish to set. This can be used as an alternative to individual inputs that represent network resource properties.
	*/
	public void setNetworkResource(String value) {
		this.inputs.setInput("NetworkResource", value);
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

	@param String - (optional, string) A description of the network.
	*/
	public void setDescription(String value) {
		this.inputs.setInput("Description", value);
	}


	/** 
	Set the value of the GatewayIP input for this Choreo. 

	@param String - (optional, string) An optional address used for default routing to other networks. Must be within the range specified by IPRange.
	*/
	public void setGatewayIP(String value) {
		this.inputs.setInput("GatewayIP", value);
	}


	/** 
	Set the value of the IPRange input for this Choreo. 

	@param String - (conditional, string) The range of internal addresses that are allowed on the network.
	*/
	public void setIPRange(String value) {
		this.inputs.setInput("IPRange", value);
	}


	/** 
	Set the value of the Name input for this Choreo. 

	@param String - (conditional, string) The name of the network.
	*/
	public void setName(String value) {
		this.inputs.setInput("Name", value);
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
	 * Execute the Choreo, wait for the Choreo to complete 
	 * and return a ResultSet containing the execution results.
	 */
	@Override
	public InsertNetworkResultSet run() {
		JSONObject result = super.runWithResults();
		return new InsertNetworkResultSet(result);
	}
	
}
