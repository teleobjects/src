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
DeleteAccessConfig

Deletes an access configuation from an instance's network interface.
*/
public class DeleteAccessConfig extends Choreography {

	/**
	Create a new instance of the DeleteAccessConfig Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public DeleteAccessConfig(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/ComputeEngine/Instances/DeleteAccessConfig"));
	}

	/** 
	Set the value of the AccessConfig input for this Choreo. 

	@param String - (required, string) The name of the access configuration to delete.
	*/
	public void setAccessConfig(String value) {
		this.inputs.setInput("AccessConfig", value);
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
	Set the value of the Fields input for this Choreo. 

	@param String - (optional, string) Comma-seperated list of fields you want to include in the response.
	*/
	public void setFields(String value) {
		this.inputs.setInput("Fields", value);
	}


	/** 
	Set the value of the Instance input for this Choreo. 

	@param String - (required, string) The name of the instance that this access configuration applies to.
	*/
	public void setInstance(String value) {
		this.inputs.setInput("Instance", value);
	}


	/** 
	Set the value of the NetworkInterface input for this Choreo. 

	@param String - (required, string) The name of the network interface associated with the access config that is being deleted.
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
	public DeleteAccessConfigResultSet run() {
		JSONObject result = super.runWithResults();
		return new DeleteAccessConfigResultSet(result);
	}
	
}
