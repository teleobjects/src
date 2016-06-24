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
SetMetadata

Sets the metadata for the specified instance.
*/
public class SetMetadata extends Choreography {

	/**
	Create a new instance of the SetMetadata Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public SetMetadata(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/ComputeEngine/Instances/SetMetadata"));
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
	Set the value of the Fingerprint input for this Choreo. 

	@param String - (required, string) The current fingerprint of this resource. You must provide the current version of the fingerprint to successfully update any metadata.
	*/
	public void setFingerprint(String value) {
		this.inputs.setInput("Fingerprint", value);
	}


	/** 
	Set the value of the Instance input for this Choreo. 

	@param String - (required, string) The name of the instance that you're setting metadata for.
	*/
	public void setInstance(String value) {
		this.inputs.setInput("Instance", value);
	}


	/** 
	Set the value of the Items input for this Choreo. 

	@param String - (required, json) An array of key/value pairs. The total size of the keys and values should not exceed 512 KB.
	*/
	public void setItems(String value) {
		this.inputs.setInput("Items", value);
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
	public SetMetadataResultSet run() {
		JSONObject result = super.runWithResults();
		return new SetMetadataResultSet(result);
	}
	
}
