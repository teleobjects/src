package com.temboo.Library.Google.ComputeEngine.Disks;

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
InsertDisk

Creates a Persistent Disk resource in the specified project.
*/
public class InsertDisk extends Choreography {

	/**
	Create a new instance of the InsertDisk Choreo. A TembooSession object, containing a valid
	set of Temboo credentials, must be supplied.
	*/
	public InsertDisk(TembooSession session) {
		super(session, TembooPath.pathFromStringNoException("/Library/Google/ComputeEngine/Disks/InsertDisk"));
	}

	/** 
	Set the value of the DiskResource input for this Choreo. 

	@param String - (optional, json) A JSON string containing the disk resource properties you wish to set. This can be used as an alternative to individual inputs that represent disk properties.
	*/
	public void setDiskResource(String value) {
		this.inputs.setInput("DiskResource", value);
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
	Set the value of the Name input for this Choreo. 

	@param String - (required, string) The name of the persistent disk resource being created.
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
	Set the value of the SizeGB input for this Choreo. 

	@param String - (conditional, string) Size of the persistent disk, specified in GB. This is optional when using a SourceSnapshot or SourceImage, otherwise it is required.
	*/
	public void setSizeGB(String value) {
		this.inputs.setInput("SizeGB", value);
	}


	/** 
	Set the value of the SourceImage input for this Choreo. 

	@param String - (conditional, string) The URL for the source image to apply to the disk. This is required if SizeGB or SourceSnapshot is not provided.
	*/
	public void setSourceImage(String value) {
		this.inputs.setInput("SourceImage", value);
	}


	/** 
	Set the value of the SourceSnapshot input for this Choreo. 

	@param String - (conditional, string) The source snapshot used to create this disk. This is required if SizeGB and SourceImage are not specified.
	*/
	public void setSourceSnapshot(String value) {
		this.inputs.setInput("SourceSnapshot", value);
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
	public InsertDiskResultSet run() {
		JSONObject result = super.runWithResults();
		return new InsertDiskResultSet(result);
	}
	
}
